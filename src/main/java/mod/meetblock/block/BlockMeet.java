package mod.meetblock.block;

import java.util.Random;

import mod.meetblock.core.Mod_MeetBlock;
import mod.meetblock.item.ItemCore;
import mod.meetblock.network.MessageHandler;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.Particles;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockMeet extends Block {

	protected final Item rawItem;
	protected final boolean isCooked;
	protected int heal = 0;
	protected float saturationLevel = 0;
	protected Block cookedBlock;

	public BlockMeet(Item itm, boolean coocked){
		this(itm, coocked, Blocks.AIR);
	}

	public BlockMeet(Item rawitem, boolean cancooked, Block cooked) {
		super(Properties.create(Mod_MeetBlock.materialMeet)
				.sound(SoundType.SLIME)
				.hardnessAndResistance(0.3F,0.0F)
				.needsRandomTick());
		rawItem = rawitem;
		isCooked = cancooked;

		cookedBlock = cooked!=null?cooked:Blocks.AIR;
		if (rawitem instanceof ItemFood){
			heal= ((ItemFood)rawItem).getHealAmount(new ItemStack(rawItem,1)) * 4;
			saturationLevel = ((ItemFood)rawItem).getSaturationModifier(new ItemStack(rawItem,1)) * 4;
		}else{
			heal = ((ItemFood)Items.ROTTEN_FLESH).getHealAmount(new ItemStack(Items.ROTTEN_FLESH,1)) * 4;
			saturationLevel = ((ItemFood)Items.ROTTEN_FLESH).getSaturationModifier(new ItemStack(Items.ROTTEN_FLESH,1)) * 4;
		}
	}

    @Override
    public boolean canEntitySpawn(IBlockState state, Entity entityIn)
    {
        return false;
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
    	if (!worldIn.isRemote){
    		setTimeBuren(worldIn,pos);
    	}
    }

    @Override
    public void onBlockAdded(IBlockState state, World worldIn, BlockPos pos, IBlockState oldState)
    //public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
    	if (!worldIn.isRemote){
    		setTimeBuren(worldIn,pos);
    	}
    }

    @Override
    public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune)
    //public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
    	return rawItem;
    }

    @Override
    public int quantityDropped(IBlockState state, Random random)
    //public int quantityDropped(Random random)
    {
        return 4;
    }


//    @Override
//    public int damageDropped(IBlockState state)
//    {
//    	if (this.getCooked(state)){
//    		return cookedMeta;
//    	}
//        return rawMeta;
//    }

    @Override
    public boolean onBlockActivated(IBlockState state, World worldIn, BlockPos pos, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        ItemStack stack = playerIn.getHeldItemMainhand();
        if (stack.getItem() == Items.FLINT_AND_STEEL){
        	if (isCooked){
        		// 調理済みなら消し炭に
        		worldIn.setBlockState(pos,Blocks.AIR.getDefaultState());
				if (worldIn.isRemote){
					DisplayParticle(worldIn,pos);
				}
        	}else{
        		// 未調理なら調理済みに
        		worldIn.setBlockState(pos, cookedBlock.getDefaultState());
				if (worldIn.isRemote){
					DisplayParticle(worldIn,pos);
				}
        	}
        	return true;
        }else if(playerIn.isSneaking()){
        	if (playerIn.canEat(false) || playerIn.isCreative()){
        		boolean cooked = this.getCooked(state);
        		onEat(worldIn,playerIn, this, cooked);
        		worldIn.setBlockState(pos,Blocks.AIR.getDefaultState());
            	return true;
        	}
        }
        return false;
    }

    @Override
    protected ItemStack getSilkTouchDrop(IBlockState state)
    {
        return new ItemStack(this, 1);
    }

    @Override
    public boolean canDropFromExplosion(Explosion explosionIn)
    {
        return false;
    }

	@Override
	public void tick(IBlockState state, World worldIn, BlockPos pos, Random random) {
		if (getBurnAround(worldIn,pos)){
			if (this.getCooked(state)){
				worldIn.setBlockState(pos,Blocks.AIR.getDefaultState());
			}else{
				worldIn.setBlockState(pos, cookedBlock.getDefaultState());
			}
			for (EntityPlayer pl : worldIn.playerEntities){
				if (pl instanceof EntityPlayerMP && pl.getDistanceSq(pos) < 100){
					MessageHandler.SendBurnSound(pos.getX(),pos.getY(),pos.getZ(),(EntityPlayerMP)pl);
				}
			}
		}
	}

    public boolean getCooked(IBlockState state){
    	return isCooked;
    }

    public IBlockState setCooked(IBlockState state, boolean cook){
    	return this.getDefaultState();
    }

    protected void setTimeBuren(World worldIn, BlockPos pos){
    	if (getBurnAround(worldIn, pos)){
    		//worldIn.scheduleBlockUpdate(pos, this, 3*20 + worldIn.rand.nextInt(200),1);
    	}
    }

    protected boolean getBurnAround(World worldIn, BlockPos pos){
    	boolean buren = false;
    	if (worldIn.getBlockState(pos.offset(EnumFacing.NORTH)).getBlock() == Blocks.FIRE){
    		buren = true;
    	}else if (worldIn.getBlockState(pos.offset(EnumFacing.SOUTH)).getBlock() == Blocks.FIRE){
    		buren = true;
    	}else if (worldIn.getBlockState(pos.offset(EnumFacing.EAST)).getBlock() == Blocks.FIRE){
    		buren = true;
    	}else if (worldIn.getBlockState(pos.offset(EnumFacing.WEST)).getBlock() == Blocks.FIRE){
    		buren = true;
    	}else if (worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.FIRE){
    		buren = true;
    	}else if (worldIn.getBlockState(pos.offset(EnumFacing.UP)).getBlock() == Blocks.FIRE){
    		buren = true;
    	}
    	return buren;
    }

    public static void DisplayParticle(World worldIn, BlockPos pos){
		double d0 = (double)pos.getX() + 0.5D;
        double d1 = (double)pos.getY() + worldIn.rand.nextDouble();
        double d2 = (double)pos.getZ() + 0.5D;
        double d3 = 0.52D;
        double d4 = worldIn.rand.nextDouble() * 0.6D - 0.3D;
	    worldIn.spawnParticle(Particles.SMOKE, d0 - 0.52D, d1, d2 + d4, 0.0D, 0.0D, 0.0D);
	    worldIn.playSound((double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1.0F + worldIn.rand.nextFloat(), worldIn.rand.nextFloat() * 0.7F + 0.3F, false);

    }

    public static void onEat(World worldIn, EntityPlayer playerIn, BlockMeet blk, boolean cooked){
    		playerIn.getFoodStats().addStats(blk.heal, blk.saturationLevel);
    		if (!cooked || blk.rawItem == ItemCore.cooked_rotten_flesh){
    			if (worldIn.rand.nextFloat() < 0.7){
        			playerIn.addPotionEffect(new PotionEffect(MobEffects.NAUSEA,20*60*4,4));
        			playerIn.addPotionEffect(new PotionEffect(MobEffects.HUNGER,20*60*4,4));
    			}
    		}
    }
}

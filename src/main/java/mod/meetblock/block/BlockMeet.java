package mod.meetblock.block;

import java.util.Random;

import org.apache.commons.lang3.BooleanUtils;

import mod.meetblock.core.Mod_MeetBlock;
import mod.meetblock.item.ItemCore;
import mod.meetblock.network.MessageBurnSound;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockMeet extends Block {

	protected static final PropertyBool COOKED = PropertyBool.create("cooked");
	protected final Item rawItem;
	protected final int rawMeta;
	protected final Item cookedItem;
	protected final int cookedMeta;
	protected int[] heal = new int[2];
	protected float[] saturationLevel = new float[2];


	public BlockMeet(Item rawitem, Item cookeditem) {
		this(rawitem,0,cookeditem,0);
	}

	public BlockMeet(Item rawitem, int meta1, Item cookeditem, int meta2){
		super(Material.GROUND);
		rawItem = rawitem;
		cookedItem = cookeditem;
		if (rawitem instanceof ItemFood){
			heal[0] = ((ItemFood)rawItem).getHealAmount(new ItemStack(rawItem,1)) * 4;
			saturationLevel[0] = ((ItemFood)rawItem).getSaturationModifier(new ItemStack(rawItem,1)) * 4;
		}else{
			heal[0] = ((ItemFood)Items.ROTTEN_FLESH).getHealAmount(new ItemStack(Items.ROTTEN_FLESH,1)) * 4;
			saturationLevel[0] = ((ItemFood)Items.ROTTEN_FLESH).getSaturationModifier(new ItemStack(Items.ROTTEN_FLESH,1)) * 4;
		}
		if (cookeditem instanceof ItemFood){
			heal[1] = ((ItemFood)cookedItem).getHealAmount(new ItemStack(cookedItem,1))* 4;
			saturationLevel[1] = ((ItemFood)cookedItem).getSaturationModifier(new ItemStack(cookedItem,1)) * 4;

		}else{
			heal[1] = ((ItemFood)Items.ROTTEN_FLESH).getHealAmount(new ItemStack(Items.ROTTEN_FLESH,1)) * 4;
			saturationLevel[1] = ((ItemFood)Items.ROTTEN_FLESH).getSaturationModifier(new ItemStack(Items.ROTTEN_FLESH,1)) * 4;
		}
		rawMeta = meta1;
		cookedMeta = meta2;
		this.setSoundType(SoundType.SLIME);
		this.setCreativeTab(Mod_MeetBlock.tabMeet);
		this.setResistance(0.0F);
		this.setHardness(0.3F);
		this.setDefaultState(this.setCooked(this.getDefaultState(), false));
	}

    @Override
    public boolean canEntitySpawn(IBlockState state, Entity entityIn)
    {
        return false;
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return setCooked(this.getDefaultState(), BooleanUtils.toBoolean(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
    	int ret = BooleanUtils.toInteger(getCooked(state));
    	return ret;
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
    	if (!worldIn.isRemote){
    		setTimeBuren(worldIn,pos);
    	}
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
    	if (!worldIn.isRemote){
    		setTimeBuren(worldIn,pos);
    	}
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
    	if (this.getCooked(state)){
    		return cookedItem;
    	}else{
    		return rawItem;
    	}
    }

    @Override
    public int quantityDropped(Random random)
    {
        return 4;
    }


    @Override
    public int damageDropped(IBlockState state)
    {
    	if (this.getCooked(state)){
    		return cookedMeta;
    	}
        return rawMeta;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack stack = playerIn.getHeldItemMainhand();
        if (stack.getItem() == Items.FLINT_AND_STEEL){
        	if (this.getCooked(state)){
        		// 調理済みなら消し炭に
        		worldIn.setBlockToAir(pos);
				if (worldIn.isRemote){
					DisplayParticle(worldIn,pos);
				}
        	}else{
        		// 未調理なら調理済みに
        		worldIn.setBlockState(pos, this.setCooked(state, true));
				if (worldIn.isRemote){
					DisplayParticle(worldIn,pos);
				}
        	}
        	return true;
        }else if(playerIn.isSneaking()){
        	if (playerIn.canEat(false) || playerIn.isCreative()){
        		boolean cooked = this.getCooked(state);
        		onEat(worldIn,playerIn, this, cooked);
        		worldIn.setBlockToAir(pos);
            	return true;
        	}
        }
        return false;
    }

    @Override
    protected ItemStack getSilkTouchDrop(IBlockState state)
    {
        return new ItemStack(this, 1, this.getMetaFromState(state));
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
    	if (itemIn != this.getCreativeTabToDisplayOn()){return;}
        items.add(new ItemStack(this,1,this.getMetaFromState(this.getDefaultState())));
        items.add(new ItemStack(this,1,this.getMetaFromState(this.setCooked(this.getDefaultState(), true))));
    }

    @Override
    public boolean canDropFromExplosion(Explosion explosionIn)
    {
        return false;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[]{COOKED});
    }

	@Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand){
		if (getBurnAround(worldIn,pos)){
			if (this.getCooked(state)){
				worldIn.setBlockToAir(pos);
			}else{
				worldIn.setBlockState(pos, this.setCooked(state, true));
			}
			for (EntityPlayer pl : worldIn.playerEntities){
				if (pl instanceof EntityPlayerMP && pl.getDistanceSq(pos) < 100){
					Mod_MeetBlock.Net_Instance.sendTo(new MessageBurnSound(pos.getX(),pos.getY(),pos.getZ()),(EntityPlayerMP)pl);
				}
			}
		}
	}

    public boolean getCooked(IBlockState state){
    	return state.getValue(COOKED);
    }

    public IBlockState setCooked(IBlockState state, boolean cook){
    	return state.withProperty(COOKED, cook);
    }

    protected void setTimeBuren(World worldIn, BlockPos pos){
    	if (getBurnAround(worldIn, pos)){
    		worldIn.scheduleBlockUpdate(pos, this, 3*20 + worldIn.rand.nextInt(200),1);
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
	    worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 - 0.52D, d1, d2 + d4, 0.0D, 0.0D, 0.0D);
	    worldIn.playSound((double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1.0F + worldIn.rand.nextFloat(), worldIn.rand.nextFloat() * 0.7F + 0.3F, false);

    }

    public static void onEat(World worldIn, EntityPlayer playerIn, BlockMeet blk, boolean cooked){
    		playerIn.getFoodStats().addStats(blk.heal[cooked?1:0], blk.saturationLevel[cooked?1:0]);
    		if (!cooked || blk.cookedItem == ItemCore.cooked_rotten_flesh){
    			if (worldIn.rand.nextFloat() < 0.7){
        			playerIn.addPotionEffect(new PotionEffect(MobEffects.NAUSEA,20*60*4,4));
        			playerIn.addPotionEffect(new PotionEffect(MobEffects.HUNGER,20*60*4,4));
    			}
    		}
    }
}

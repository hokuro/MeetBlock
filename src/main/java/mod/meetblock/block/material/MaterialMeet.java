package mod.meetblock.block.material;

import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class MaterialMeet extends Material {

	public MaterialMeet(MapColor color) {
		super(color);
	}

	@Override
    public boolean getCanBurn()
    {
        return true;
    }

	@Override
    public boolean isToolNotRequired()
    {
        return true;
    }

	@Override
    public EnumPushReaction getMobilityFlag()
    {
        return EnumPushReaction.DESTROY;
    }
}

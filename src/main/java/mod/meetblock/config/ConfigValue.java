package mod.meetblock.config;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigValue{
	private static final ModConfig config = new ModConfig();

	public static void init(FMLPreInitializationEvent event){
		config.init(new Class<?>[]{
			General.class
		}, event);
	}


	public static void setting() {
	}

	public static void save(){
		config.saveConfig();
	}

	public static class General{
		@ConfigProperty(comment="show debutlog")
		public static boolean isDebut=false;
	}
}
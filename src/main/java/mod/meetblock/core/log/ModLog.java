package mod.meetblock.core.log;


import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import mod.meetblock.core.ModCommon;
import net.minecraftforge.fml.relauncher.FMLLaunchHandler;


public class ModLog {
	// インスタンス
	private static final ModLog instance = new ModLog();
	// ログインスタンス
	private Logger _log;
	// 紺フィギュア度
	private boolean configured;

	// ログインスタンスを取得する
	public static ModLog log(){return instance;}

	// コンストラクタ
	private ModLog(){
		_log = LogManager.getLogger(ModCommon.MOD_NAME);
		ThreadContext.put("side", FMLLaunchHandler.side().name().toLowerCase(Locale.ENGLISH));
		configured = true;
	}

	// 継続不可エラーログ
	public void fatal(String message){
		_log.fatal(message);
	}

	// エラーログ
	public void error(String message){
		_log.error(message);
	}

	// 警告ログ
	public void warn(String message){
		_log.warn(message);
	}

	// infoログ
	public void info(String message){
		_log.info(message);
	}

	// デバッグログ
	public void debug(String message){
		if (ModCommon.isDebug){
			StackTraceElement throwableStackTraceElement = new Throwable().getStackTrace()[1];
			_log.info(throwableStackTraceElement.getClassName()+ "." +
			           throwableStackTraceElement.getMethodName() + "(" +
					   throwableStackTraceElement.getLineNumber() + ")" + ":" + message);
		}
	}
}

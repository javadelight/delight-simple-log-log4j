package delight.simplelog.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import delight.simplelog.FieldDefinition;
import delight.simplelog.Level;
import delight.simplelog.LogListener;

public class Log4JBridge implements LogListener {

	private final Logger logger;

	private org.apache.logging.log4j.Level getLevel(Level level) {
		return org.apache.logging.log4j.Level.getLevel(level.name());
	}

	@Override
	public void onMessage(Level level, String text) {
		logger.log(getLevel(level), text);
	}

	@Override
	public void onMessage(Level level, String text, Throwable exception) {
		logger.log(getLevel(level), text, exception);
	}

	@Override
	public void onMessage(Level level, Object context, String text) {
		LogManager.getLogger(context).log(getLevel(level), text);
	}

	@Override
	public void onMessage(Level level, Object context, String text, Throwable exception) {
		LogManager.getLogger(context).log(getLevel(level), text, exception);
	}

	@Override
	public void onMessage(Level level, Object context, String text, FieldDefinition[] fields) {
		for (FieldDefinition field : fields) {
			ThreadContext.put(field.key(), field.value());
		}

		onMessage(level, context, text);

		if (fields.length > 0) {
			ThreadContext.clearAll();
		}
	}

	@Override
	public void onMessage(Level level, Object context, String text, Throwable exception, FieldDefinition[] fields) {
		for (FieldDefinition field : fields) {
			ThreadContext.put(field.key(), field.value());
		}

		onMessage(level, context, text, exception);

		if (fields.length > 0) {
			ThreadContext.clearAll();
		}
		
	}
	
	public Log4JBridge() {
		super();
		this.logger = LogManager.getLogger();
	}

	@Override
	public void onMessage(Level level, String text, FieldDefinition[] fields) {
		for (FieldDefinition field : fields) {
			ThreadContext.put(field.key(), field.value());
		}

		onMessage(level, text);

		if (fields.length > 0) {
			ThreadContext.clearAll();
		}
		
	}

	@Override
	public void onMessage(Level level, String text, Throwable exception, FieldDefinition[] fields) {
		for (FieldDefinition field : fields) {
			ThreadContext.put(field.key(), field.value());
		}

		onMessage(level, text, exception);

		if (fields.length > 0) {
			ThreadContext.clearAll();
		}
		
	}

	

}

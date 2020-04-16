package com.ingka.aol.StackDriverLogging;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.Logging.WriteOption;
import com.google.cloud.logging.Payload.JsonPayload;
import com.google.cloud.logging.Payload.StringPayload;

public class ErrorLogging {

	String logName = null;

	public ErrorLogging(String LoggerName) {
		logName = LoggerName;
	}

	public void logInfo(

			String errorIdentifier, String errorDateTimeUTC, String clientMessageIdentifier,
			String internalMessageIdentifier, String correlationIdentifier, String errorAggregationIdentifier,
			String notificationIdentifier, String clientIdentifier, String internalClientIdentifier,
			String clientHttpCode, String clientHttpMessage, String clientMoreInformation, String clientErrorType,
			String errorCode, String errorText, String errorDetails, String stackTrace,
			String requestPayload, String componentName, String componentType, String cloudProject,
			String cloudResourceIdentifier,String serverName, String environmentType, String environmentOwner, String sourceSystem,
			String sourceSystemInstance, String targetSystem, String targetSystemInstance) {

		Map<String, Object> jsonMap = new HashMap<>();

		jsonMap.put("errorIdentifier", errorIdentifier);
		jsonMap.put("errorDateTimeUTC", errorDateTimeUTC);
		jsonMap.put("clientMessageIdentifier", clientMessageIdentifier);
		jsonMap.put("internalMessageIdentifier", internalMessageIdentifier);
		jsonMap.put("correlationIdentifier", correlationIdentifier);
		jsonMap.put("errorAggregationIdentifier", errorAggregationIdentifier);
		jsonMap.put("notificationIdentifier", notificationIdentifier);
		jsonMap.put("clientIdentifier", clientIdentifier);
		jsonMap.put("internalClientIdentifier", internalClientIdentifier);
		jsonMap.put("clientHttpCode", clientHttpCode);
		jsonMap.put("clientHttpMessage", clientHttpMessage);
		jsonMap.put("clientMoreInformation", clientMoreInformation);
		jsonMap.put("clientErrorType", clientErrorType);
		jsonMap.put("errorCode", errorCode);
		jsonMap.put("errorText", errorText);
		jsonMap.put("errorDetails", errorDetails);
		jsonMap.put("stackTrace", stackTrace);
		jsonMap.put("requestPayload", Base64.getEncoder().encodeToString(requestPayload.getBytes()));
		jsonMap.put("componentName", componentName);
		jsonMap.put("componentType", componentType);
		jsonMap.put("cloudProject", cloudProject);
		jsonMap.put("cloudResourceIdentifier", cloudResourceIdentifier);
		jsonMap.put("serverName", serverName);
		jsonMap.put("environmentType", environmentType);
		jsonMap.put("environmentOwner", environmentOwner);
		jsonMap.put("sourceSystem", sourceSystem);
		jsonMap.put("sourceSystemInstance", sourceSystemInstance);
		jsonMap.put("targetSystem", targetSystem);
		jsonMap.put("targetSystemInstance", targetSystemInstance);

		// Logging
		LoggingOptions options = LoggingOptions.getDefaultInstance();

		try (Logging logging = options.getService()) {

			List<LogEntry> entries = new ArrayList<>();
			entries.add(LogEntry.of(StringPayload.of("Exception payload logging")));

			// entries.add(LogEntry.of(JsonPayload.of(jsonMap)));
			entries.add(LogEntry.of(JsonPayload.of(jsonMap)));
			logging.write(entries, WriteOption.logName(logName),
					WriteOption.resource(MonitoredResource.newBuilder("global").build()));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// return jsonMap;
	}

}
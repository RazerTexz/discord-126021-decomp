package lombok.core.configuration;

import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: discord-126021.apk:lombok/core/configuration/ConfigurationParser.SCL.lombok */
public class ConfigurationParser {
    private static final Pattern LINE = Pattern.compile("(?:clear\\s+([^=]+))|(?:(\\S*?)\\s*([-+]?=)\\s*(.*?))");
    private static final Pattern NEWLINE_FINDER = Pattern.compile("^[\t ]*(.*?)[\t\r ]*$", 8);
    private static final Pattern IMPORT = Pattern.compile("import\\s+(.+?)");
    private ConfigurationProblemReporter reporter;

    /* JADX INFO: loaded from: discord-126021.apk:lombok/core/configuration/ConfigurationParser$Collector.SCL.lombok */
    public interface Collector {
        void addImport(ConfigurationFile configurationFile, ConfigurationFile configurationFile2, int i);

        void clear(ConfigurationKey<?> configurationKey, ConfigurationFile configurationFile, int i);

        void set(ConfigurationKey<?> configurationKey, Object obj, ConfigurationFile configurationFile, int i);

        void add(ConfigurationKey<?> configurationKey, Object obj, ConfigurationFile configurationFile, int i);

        void remove(ConfigurationKey<?> configurationKey, Object obj, ConfigurationFile configurationFile, int i);
    }

    public ConfigurationParser(ConfigurationProblemReporter reporter) {
        if (reporter == null) {
            throw new NullPointerException("reporter");
        }
        this.reporter = reporter;
    }

    public void parse(ConfigurationFile context, Collector collector) {
        String keyName;
        String operator;
        String stringValue;
        CharSequence contents = contents(context);
        if (contents == null) {
            return;
        }
        Map<String, ConfigurationKey<?>> registeredKeys = ConfigurationKey.registeredKeys();
        int lineNumber = 0;
        Matcher lineMatcher = NEWLINE_FINDER.matcher(contents);
        boolean importsAllowed = true;
        while (lineMatcher.find()) {
            CharSequence line = contents.subSequence(lineMatcher.start(1), lineMatcher.end(1));
            lineNumber++;
            if (line.length() != 0 && line.charAt(0) != '#') {
                Matcher importMatcher = IMPORT.matcher(line);
                if (importMatcher.matches()) {
                    if (!importsAllowed) {
                        this.reporter.report(context.description(), "Imports are only allowed in the top of the file", lineNumber, line);
                    } else {
                        String imported = importMatcher.group(1);
                        ConfigurationFile importFile = context.resolve(imported);
                        if (importFile == null) {
                            this.reporter.report(context.description(), "Import is not valid", lineNumber, line);
                        } else if (!importFile.exists()) {
                            this.reporter.report(context.description(), "Imported file does not exist", lineNumber, line);
                        } else {
                            collector.addImport(importFile, context, lineNumber);
                        }
                    }
                } else {
                    Matcher matcher = LINE.matcher(line);
                    if (!matcher.matches()) {
                        this.reporter.report(context.description(), "Invalid line", lineNumber, line);
                    } else {
                        importsAllowed = false;
                        if (matcher.group(1) == null) {
                            keyName = matcher.group(2);
                            operator = matcher.group(3);
                            stringValue = matcher.group(4);
                        } else {
                            keyName = matcher.group(1);
                            operator = "clear";
                            stringValue = null;
                        }
                        ConfigurationKey<?> key = registeredKeys.get(keyName);
                        if (key == null) {
                            this.reporter.report(context.description(), "Unknown key '" + keyName + "'", lineNumber, line);
                        } else {
                            ConfigurationDataType type = key.getType();
                            boolean listOperator = operator.equals("+=") || operator.equals("-=");
                            if (listOperator && !type.isList()) {
                                this.reporter.report(context.description(), "'" + keyName + "' is not a list and doesn't support " + operator + " (only = and clear)", lineNumber, line);
                            } else if (operator.equals("=") && type.isList()) {
                                this.reporter.report(context.description(), "'" + keyName + "' is a list and cannot be assigned to (use +=, -= and clear instead)", lineNumber, line);
                            } else {
                                Object value = null;
                                if (stringValue != null) {
                                    try {
                                        value = type.getParser().parse(stringValue);
                                    } catch (Exception unused) {
                                        this.reporter.report(context.description(), "Error while parsing the value for '" + keyName + "' value '" + stringValue + "' (should be " + type.getParser().exampleValue() + ")", lineNumber, line);
                                    }
                                }
                                if (operator.equals("clear")) {
                                    collector.clear(key, context, lineNumber);
                                } else if (operator.equals("=")) {
                                    collector.set(key, value, context, lineNumber);
                                } else if (operator.equals("+=")) {
                                    collector.add(key, value, context, lineNumber);
                                } else {
                                    collector.remove(key, value, context, lineNumber);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private CharSequence contents(ConfigurationFile context) {
        try {
            return context.contents();
        } catch (IOException e) {
            this.reporter.report(context.description(), "Exception while reading file: " + e.getMessage(), 0, null);
            return null;
        }
    }
}

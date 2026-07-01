package lombok.core.configuration;

import com.zwitserloot.cmdreader.CmdReader;
import com.zwitserloot.cmdreader.Description;
import com.zwitserloot.cmdreader.Excludes;
import com.zwitserloot.cmdreader.FullName;
import com.zwitserloot.cmdreader.InvalidCommandLineException;
import com.zwitserloot.cmdreader.Mandatory;
import com.zwitserloot.cmdreader.Requires;
import com.zwitserloot.cmdreader.Sequential;
import com.zwitserloot.cmdreader.Shorthand;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import lombok.ConfigurationKeys;
import lombok.core.LombokApp;
import lombok.core.configuration.ConfigurationKeysLoader;
import lombok.core.configuration.ConfigurationParser;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/ConfigurationApp.SCL.lombok */
public class ConfigurationApp extends LombokApp {
    private PrintStream out = System.out;
    private PrintStream err = System.err;
    private static final URI NO_CONFIG = URI.create("");
    private static final ConfigurationProblemReporter VOID = new ConfigurationProblemReporter() { // from class: lombok.core.configuration.ConfigurationApp.1
        @Override // lombok.core.configuration.ConfigurationProblemReporter
        public void report(String sourceDescription, String problem, int lineNumber, CharSequence line) {
        }
    };

    @Override // lombok.core.LombokApp
    public String getAppName() {
        return "config";
    }

    @Override // lombok.core.LombokApp
    public String getAppDescription() {
        return "Prints the configurations for the provided paths to standard out.";
    }

    @Override // lombok.core.LombokApp
    public List<String> getAppAliases() {
        return Arrays.asList("configuration", "config", "conf", "settings");
    }

    /* JADX INFO: loaded from: app.apk:lombok/core/configuration/ConfigurationApp$CmdArgs.SCL.lombok */
    public static class CmdArgs {

        @Mandatory(onlyIfNot = {"help", "generate"})
        @Description("Paths to java files or directories the configuration is to be printed for.")
        @Sequential
        private List<String> paths = new ArrayList();

        @Excludes({"paths"})
        @Description("Generates a list containing all the available configuration parameters. Add --verbose to print more information.")
        @Shorthand({"g"})
        boolean generate = false;

        @Description("Displays more information.")
        @Shorthand({"v"})
        boolean verbose = false;

        @Requires({"verbose"})
        @Description("Also display files that don't mention the key.")
        @Shorthand({"n"})
        @FullName("not-mentioned")
        boolean notMentioned = false;

        @Description("Limit the result to these keys.")
        @Shorthand({"k"})
        private List<String> key = new ArrayList();

        @Description("Shows this help text.")
        @Shorthand({"h", "?"})
        boolean help = false;
    }

    @Override // lombok.core.LombokApp
    public int runApp(List<String> raw) throws Exception {
        CmdReader<CmdArgs> reader = CmdReader.of(CmdArgs.class);
        try {
            CmdArgs args = reader.make((String[]) raw.toArray(new String[0]));
            if (args.help) {
                this.out.println(reader.generateCommandLineHelp("java -jar lombok.jar configuration"));
                return 0;
            }
            ConfigurationKeysLoader.LoaderLoader.loadAllConfigurationKeys();
            Collection<ConfigurationKey<?>> keys = checkKeys(args.key);
            if (keys == null) {
                return 1;
            }
            boolean verbose = args.verbose;
            if (args.generate) {
                return generate(keys, verbose, !args.key.isEmpty());
            }
            return display(keys, verbose, args.paths, !args.key.isEmpty(), args.notMentioned);
        } catch (InvalidCommandLineException e) {
            this.err.println(e.getMessage());
            this.err.println(reader.generateCommandLineHelp("java -jar lombok.jar configuration"));
            return 1;
        }
    }

    public ConfigurationApp redirectOutput(PrintStream out, PrintStream err) {
        if (out != null) {
            this.out = out;
        }
        if (err != null) {
            this.err = err;
        }
        return this;
    }

    public int generate(Collection<ConfigurationKey<?>> keys, boolean verbose, boolean explicit) {
        for (ConfigurationKey<?> key : keys) {
            if (explicit || !key.isHidden()) {
                String keyName = key.getKeyName();
                ConfigurationDataType type = key.getType();
                String description = key.getDescription();
                boolean hasDescription = (description == null || description.isEmpty()) ? false : true;
                if (!verbose) {
                    this.out.println(keyName);
                    if (hasDescription) {
                        this.out.print("  ");
                        this.out.println(description);
                    }
                    this.out.println();
                } else {
                    this.out.printf("##%n## Key : %s%n## Type: %s%n", keyName, type);
                    if (hasDescription) {
                        this.out.printf("##%n## %s%n", description);
                    }
                    this.out.printf("##%n## Examples:%n#%n", new Object[0]);
                    this.out.printf("# clear %s%n", keyName);
                    String exampleValue = type.getParser().exampleValue();
                    if (type.isList()) {
                        this.out.printf("# %s += %s%n", keyName, exampleValue);
                        this.out.printf("# %s -= %s%n", keyName, exampleValue);
                    } else {
                        this.out.printf("# %s = %s%n", keyName, exampleValue);
                    }
                    this.out.printf("#%n%n", new Object[0]);
                }
            }
        }
        if (!verbose) {
            this.out.println("Use --verbose for more information.");
            return 0;
        }
        return 0;
    }

    public int display(Collection<ConfigurationKey<?>> keys, boolean verbose, Collection<String> argsPaths, boolean explicitKeys, boolean notMentioned) throws Exception {
        TreeMap<URI, Set<String>> sharedDirectories = findSharedDirectories(argsPaths);
        if (sharedDirectories == null) {
            return 1;
        }
        Set<String> none = sharedDirectories.remove(NO_CONFIG);
        if (none != null) {
            if (none.size() == 1) {
                this.out.printf("No 'lombok.config' found for '%s'.%n", none.iterator().next());
            } else {
                this.out.println("No 'lombok.config' found for: ");
                for (String path : none) {
                    this.out.printf("- %s%n", path);
                }
            }
        }
        final List<String> problems = new ArrayList<>();
        ConfigurationProblemReporter reporter = new ConfigurationProblemReporter() { // from class: lombok.core.configuration.ConfigurationApp.2
            @Override // lombok.core.configuration.ConfigurationProblemReporter
            public void report(String sourceDescription, String problem, int lineNumber, CharSequence line) {
                problems.add(String.format("%s: %s (%s:%d)", problem, line, sourceDescription, Integer.valueOf(lineNumber)));
            }
        };
        FileSystemSourceCache cache = new FileSystemSourceCache();
        ConfigurationParser parser = new ConfigurationParser(reporter);
        boolean first = true;
        for (Map.Entry<URI, Set<String>> entry : sharedDirectories.entrySet()) {
            if (!first) {
                this.out.printf("%n%n", new Object[0]);
            }
            Set<String> paths = entry.getValue();
            if (paths.size() == 1) {
                if (argsPaths.size() != 1) {
                    this.out.printf("Configuration for '%s'.%n%n", paths.iterator().next());
                }
            } else {
                this.out.printf("Configuration for:%n", new Object[0]);
                for (String path2 : paths) {
                    this.out.printf("- %s%n", path2);
                }
                this.out.println();
            }
            URI directory = entry.getKey();
            ConfigurationResolver resolver = new BubblingConfigurationResolver(cache.forUri(directory), cache.fileToSource(parser));
            Map<ConfigurationKey<?>, ? extends Collection<String>> traces = trace(keys, directory, notMentioned);
            boolean printed = false;
            for (ConfigurationKey<?> key : keys) {
                Object value = resolver.resolve(key);
                Collection<String> modifications = traces.get(key);
                if (!modifications.isEmpty() || explicitKeys) {
                    if (printed && verbose) {
                        this.out.println();
                    }
                    printValue(key, value, verbose, modifications);
                    printed = true;
                }
            }
            if (!printed) {
                this.out.println("<default>");
            }
            first = false;
        }
        if (!problems.isEmpty()) {
            this.err.printf("Problems in the configuration files:%n", new Object[0]);
            for (String problem : problems) {
                this.err.printf("- %s%n", problem);
            }
            return 0;
        }
        return 0;
    }

    private void printValue(ConfigurationKey<?> key, Object value, boolean verbose, Collection<String> history) {
        if (verbose) {
            this.out.printf("# %s%n", key.getDescription());
        }
        if (value == null) {
            this.out.printf("clear %s%n", key.getKeyName());
        } else if (value instanceof List) {
            List<?> list = (List) value;
            if (list.isEmpty()) {
                this.out.printf("clear %s%n", key.getKeyName());
            }
            for (Object element : list) {
                this.out.printf("%s += %s%n", key.getKeyName(), element);
            }
        } else {
            this.out.printf("%s = %s%n", key.getKeyName(), value);
        }
        if (verbose) {
            for (String modification : history) {
                this.out.printf("# %s%n", modification);
            }
        }
    }

    private Map<ConfigurationKey<?>, ? extends Collection<String>> trace(Collection<ConfigurationKey<?>> keys, URI directory, boolean notMentioned) throws Exception {
        Map<ConfigurationKey<?>, List<String>> result = new HashMap<>();
        Iterator<ConfigurationKey<?>> it = keys.iterator();
        while (it.hasNext()) {
            result.put(it.next(), new ArrayList<>());
        }
        Set<ConfigurationKey<?>> used = new HashSet<>();
        boolean stopBubbling = false;
        Collection<ConfigurationFile> visited = new HashSet<>();
        ConfigurationFile configurationFileForDirectory = ConfigurationFile.forDirectory(new File(directory));
        while (true) {
            ConfigurationFile context = configurationFileForDirectory;
            if (context == null || stopBubbling) {
                break;
            }
            if (context.exists()) {
                Deque<Source> round = new ArrayDeque<>();
                round.push(new Source(context, context.description()));
                while (!round.isEmpty()) {
                    Source current = round.pop();
                    if (current != null && visited.add(current.file) && current.file.exists()) {
                        Map<ConfigurationKey<?>, List<String>> traces = trace(current.file, keys, round);
                        stopBubbling = stopBubbling(traces.get(ConfigurationKeys.STOP_BUBBLING));
                        for (ConfigurationKey<?> key : keys) {
                            List<String> modifications = traces.get(key);
                            if (modifications == null) {
                                modifications = new ArrayList();
                                if (notMentioned) {
                                    modifications.add("");
                                    modifications.add(String.valueOf(current.description) + ":");
                                    modifications.add("     <'" + key.getKeyName() + "' not mentioned>");
                                }
                            } else {
                                used.add(key);
                                modifications.add(0, String.valueOf(current.description) + ":");
                                modifications.add(0, "");
                            }
                            result.get(key).addAll(0, modifications);
                        }
                    }
                }
            }
            configurationFileForDirectory = context.parent();
        }
        for (ConfigurationKey<?> key2 : keys) {
            if (used.contains(key2)) {
                List<String> modifications2 = result.get(key2);
                modifications2.remove(0);
                if (stopBubbling) {
                    String mostRecent = modifications2.get(0);
                    modifications2.set(0, String.valueOf(mostRecent.substring(0, mostRecent.length() - 1)) + " (stopped bubbling):");
                }
            } else {
                result.put(key2, Collections.emptyList());
            }
        }
        return result;
    }

    /* JADX INFO: loaded from: app.apk:lombok/core/configuration/ConfigurationApp$Source.SCL.lombok */
    private static final class Source {
        final ConfigurationFile file;
        final String description;

        Source(ConfigurationFile file, String description) {
            this.file = file;
            this.description = description;
        }
    }

    private Map<ConfigurationKey<?>, List<String>> trace(ConfigurationFile context, final Collection<ConfigurationKey<?>> keys, final Deque<Source> round) throws IOException {
        final Map<ConfigurationKey<?>, List<String>> result = new HashMap<>();
        ConfigurationParser.Collector collector = new ConfigurationParser.Collector() { // from class: lombok.core.configuration.ConfigurationApp.3
            @Override // lombok.core.configuration.ConfigurationParser.Collector
            public void addImport(ConfigurationFile importFile, ConfigurationFile context2, int lineNumber) {
                round.push(new Source(importFile, String.valueOf(importFile.description()) + " (imported from " + context2.description() + ":" + lineNumber + ")"));
            }

            @Override // lombok.core.configuration.ConfigurationParser.Collector
            public void clear(ConfigurationKey<?> key, ConfigurationFile context2, int lineNumber) {
                trace(key, "clear " + key.getKeyName(), lineNumber);
            }

            @Override // lombok.core.configuration.ConfigurationParser.Collector
            public void set(ConfigurationKey<?> key, Object value, ConfigurationFile context2, int lineNumber) {
                trace(key, String.valueOf(key.getKeyName()) + " = " + value, lineNumber);
            }

            @Override // lombok.core.configuration.ConfigurationParser.Collector
            public void add(ConfigurationKey<?> key, Object value, ConfigurationFile context2, int lineNumber) {
                trace(key, String.valueOf(key.getKeyName()) + " += " + value, lineNumber);
            }

            @Override // lombok.core.configuration.ConfigurationParser.Collector
            public void remove(ConfigurationKey<?> key, Object value, ConfigurationFile context2, int lineNumber) {
                trace(key, String.valueOf(key.getKeyName()) + " -= " + value, lineNumber);
            }

            private void trace(ConfigurationKey<?> key, String message, int lineNumber) {
                if (keys.contains(key) || key == ConfigurationKeys.STOP_BUBBLING) {
                    List<String> traces = (List) result.get(key);
                    if (traces == null) {
                        traces = new ArrayList<>();
                        result.put(key, traces);
                    }
                    traces.add(String.format("%4d: %s", Integer.valueOf(lineNumber), message));
                }
            }
        };
        new ConfigurationParser(VOID).parse(context, collector);
        return result;
    }

    private boolean stopBubbling(List<String> stops) {
        return (stops == null || stops.isEmpty() || !stops.get(stops.size() - 1).endsWith("true")) ? false : true;
    }

    private Collection<ConfigurationKey<?>> checkKeys(List<String> keyList) {
        Map<String, ConfigurationKey<?>> registeredKeys = ConfigurationKey.registeredKeys();
        if (keyList.isEmpty()) {
            return registeredKeys.values();
        }
        Collection<ConfigurationKey<?>> keys = new ArrayList<>();
        for (String keyName : keyList) {
            ConfigurationKey<?> key = registeredKeys.get(keyName);
            if (key == null) {
                this.err.printf("Unknown key '%s'%n", keyName);
                return null;
            }
            keys.remove(key);
            keys.add(key);
        }
        return keys;
    }

    private TreeMap<URI, Set<String>> findSharedDirectories(Collection<String> paths) {
        TreeMap<URI, Set<String>> sharedDirectories = new TreeMap<>(new Comparator<URI>() { // from class: lombok.core.configuration.ConfigurationApp.4
            @Override // java.util.Comparator
            public int compare(URI o1, URI o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
        for (String path : paths) {
            File file = new File(path);
            if (!file.exists()) {
                this.err.printf("File not found: '%s'%n", path);
                return null;
            }
            URI first = findFirstLombokDirectory(file);
            Set<String> sharedBy = sharedDirectories.get(first);
            if (sharedBy == null) {
                sharedBy = new TreeSet();
                sharedDirectories.put(first, sharedBy);
            }
            sharedBy.add(path);
        }
        return sharedDirectories;
    }

    private URI findFirstLombokDirectory(File file) {
        File current = new File(file.toURI().normalize());
        if (file.isFile()) {
            current = current.getParentFile();
        }
        while (current != null) {
            if (new File(current, "lombok.config").exists()) {
                return current.toURI();
            }
            current = current.getParentFile();
        }
        return NO_CONFIG;
    }
}

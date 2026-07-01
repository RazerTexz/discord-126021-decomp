package com.zwitserloot.cmdreader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: app.apk:com/zwitserloot/cmdreader/CmdReader.SCL.lombok */
public class CmdReader<T> {
    private final Class<T> settingsDescriptor;
    private final List<ParseItem> items = Collections.unmodifiableList(init());
    private final Map<Character, ParseItem> shorthands = ParseItem.makeShortHandMap(this.items);
    private final List<ParseItem> seqList = makeSeqList(this.items);
    private static final int SCREEN_WIDTH = 72;

    private CmdReader(Class<T> settingsDescriptor) {
        this.settingsDescriptor = settingsDescriptor;
    }

    public static <T> CmdReader<T> of(Class<T> settingsDescriptor) {
        return new CmdReader<>(settingsDescriptor);
    }

    private List<ParseItem> init() {
        List<ParseItem> out = new ArrayList<>();
        for (Class<T> superclass = this.settingsDescriptor; superclass != Object.class; superclass = superclass.getSuperclass()) {
            Field[] fields = this.settingsDescriptor.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (!Modifier.isStatic(field.getModifiers())) {
                    out.add(new ParseItem(field));
                }
            }
        }
        ParseItem.multiSanityChecks(out);
        return out;
    }

    private static List<ParseItem> makeSeqList(List<ParseItem> items) {
        List<ParseItem> list = new ArrayList<>();
        for (ParseItem item : items) {
            if (item.isSeq()) {
                list.add(item);
            }
        }
        return list;
    }

    public String generateCommandLineHelp(String commandName) {
        StringBuilder out = new StringBuilder();
        int maxFullName = 0;
        int maxShorthand = 0;
        for (ParseItem item : this.items) {
            if (!item.isSeq()) {
                maxFullName = Math.max(maxFullName, item.getFullName().length() + (item.isParameterized() ? 4 : 0));
                maxShorthand = Math.max(maxShorthand, item.getShorthand().length());
            }
        }
        if (maxShorthand == 0) {
            maxShorthand++;
        }
        int maxShorthand2 = (maxShorthand * 3) - 1;
        generateShortSummary(commandName, out);
        generateSequentialArgsHelp(out);
        generateMandatoryArgsHelp(maxFullName, maxShorthand2, out);
        generateOptionalArgsHelp(maxFullName, maxShorthand2, out);
        return out.toString();
    }

    private void generateShortSummary(String commandName, StringBuilder out) {
        if (commandName != null && commandName.length() > 0) {
            out.append(commandName).append(" ");
        }
        StringBuilder sb = new StringBuilder();
        for (ParseItem item : this.items) {
            if (!item.isSeq() && !item.isMandatory()) {
                sb.append(item.getShorthand());
            }
        }
        if (sb.length() > 0) {
            out.append("[-").append((CharSequence) sb).append("] ");
            sb.setLength(0);
        }
        for (ParseItem item2 : this.items) {
            if (!item2.isSeq() && item2.isMandatory()) {
                sb.append(item2.getShorthand());
            }
        }
        if (sb.length() > 0) {
            out.append("-").append((CharSequence) sb).append(" ");
            sb.setLength(0);
        }
        for (ParseItem item3 : this.items) {
            if (!item3.isSeq() && item3.isMandatory() && item3.getShorthand().length() == 0) {
                out.append("--").append(item3.getFullName()).append("=val ");
            }
        }
        for (ParseItem item4 : this.items) {
            if (item4.isSeq()) {
                if (!item4.isMandatory()) {
                    out.append('[');
                }
                out.append(item4.getFullName());
                if (!item4.isMandatory()) {
                    out.append(']');
                }
                out.append(' ');
            }
        }
        out.append("\n");
    }

    private void generateSequentialArgsHelp(StringBuilder out) {
        List<ParseItem> items = new ArrayList<>();
        for (ParseItem item : this.items) {
            if (item.isSeq() && item.getFullDescription().length() > 0) {
                items.add(item);
            }
        }
        if (items.size() == 0) {
            return;
        }
        int maxSeqArg = 0;
        for (ParseItem item2 : items) {
            maxSeqArg = Math.max(maxSeqArg, item2.getFullName().length());
        }
        out.append("\n  Sequential arguments:\n");
        for (ParseItem item3 : items) {
            generateSequentialArgHelp(maxSeqArg, item3, out);
        }
    }

    private void generateMandatoryArgsHelp(int maxFullName, int maxShorthand, StringBuilder out) {
        List<ParseItem> items = new ArrayList<>();
        for (ParseItem item : this.items) {
            if (item.isMandatory() && !item.isSeq()) {
                items.add(item);
            }
        }
        if (items.size() == 0) {
            return;
        }
        out.append("\n  Mandatory arguments:\n");
        Iterator<ParseItem> it = items.iterator();
        while (it.hasNext()) {
            generateArgHelp(maxFullName, maxShorthand, it.next(), out);
        }
    }

    private void generateOptionalArgsHelp(int maxFullName, int maxShorthand, StringBuilder out) {
        List<ParseItem> items = new ArrayList<>();
        for (ParseItem item : this.items) {
            if (!item.isMandatory() && !item.isSeq()) {
                items.add(item);
            }
        }
        if (items.size() == 0) {
            return;
        }
        out.append("\n  Optional arguments:\n");
        Iterator<ParseItem> it = items.iterator();
        while (it.hasNext()) {
            generateArgHelp(maxFullName, maxShorthand, it.next(), out);
        }
    }

    private void generateArgHelp(int maxFullName, int maxShorthand, ParseItem item, StringBuilder out) {
        out.append("    ");
        String fn = item.getFullName() + (item.isParameterized() ? "=val" : "");
        out.append(String.format("--%-" + maxFullName + "s ", fn));
        StringBuilder sh = new StringBuilder();
        char[] arr$ = item.getShorthand().toCharArray();
        for (char c : arr$) {
            if (sh.length() > 0) {
                sh.append(" ");
            }
            sh.append("-").append(c);
        }
        out.append(String.format("%-" + maxShorthand + "s ", sh));
        int left = (64 - maxShorthand) - maxFullName;
        String description = item.getFullDescription();
        if (description.length() == 0 || description.length() < left) {
            out.append(description).append("\n");
            return;
        }
        for (String line : wordbreak(item.getFullDescription(), 64)) {
            out.append("\n        ").append(line);
        }
        out.append("\n");
    }

    private void generateSequentialArgHelp(int maxSeqArg, ParseItem item, StringBuilder out) {
        out.append("    ");
        out.append(String.format("%-" + maxSeqArg + "s   ", item.getFullName()));
        int left = 65 - maxSeqArg;
        String description = item.getFullDescription();
        if (description.length() == 0 || description.length() < left) {
            out.append(description).append("\n");
            return;
        }
        for (String line : wordbreak(item.getFullDescription(), 64)) {
            out.append("\n        ").append(line);
        }
        out.append("\n");
    }

    private static List<String> wordbreak(String text, int width) {
        StringBuilder line = new StringBuilder();
        List<String> out = new ArrayList<>();
        int lastSpace = -1;
        char[] arr$ = text.toCharArray();
        int len$ = arr$.length;
        for (int i$ = 0; i$ < len$; i$++) {
            char c = arr$[i$];
            if (c == '\t') {
                c = ' ';
            }
            if (c == '\n') {
                out.add(line.toString());
                line.setLength(0);
                lastSpace = -1;
            } else {
                if (c == ' ') {
                    lastSpace = line.length();
                    line.append(' ');
                } else {
                    line.append(c);
                }
                if (line.length() > width && lastSpace > 8) {
                    out.add(line.substring(0, lastSpace));
                    String left = line.substring(lastSpace + 1);
                    line.setLength(0);
                    line.append(left);
                    lastSpace = -1;
                }
            }
        }
        if (line.length() > 0) {
            out.add(line.toString());
        }
        return out;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0052  */
    /* JADX WARN: Code duplicated, block: B:14:0x0058  */
    /* JADX WARN: Code duplicated, block: B:16:0x005f  */
    /* JADX WARN: Code duplicated, block: B:18:0x0064  */
    /* JADX WARN: Code duplicated, block: B:19:0x0068  */
    /* JADX WARN: Code duplicated, block: B:21:0x006e  */
    /* JADX WARN: Code duplicated, block: B:29:0x009e  */
    public T make(String in) throws InvalidCommandLineException, IllegalArgumentException {
        boolean z2;
        List<String> out = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inQuote = false;
        boolean inBack = false;
        char[] arr$ = in.toCharArray();
        for (char c : arr$) {
            if (inBack) {
                inBack = false;
                if (c != '\n') {
                    sb.append(c);
                    if (c == '\\') {
                        inBack = true;
                    } else if (c == '\"') {
                        if (inQuote) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        inQuote = z2;
                    } else if (c != ' ' && !inQuote) {
                        String p = sb.toString();
                        sb.setLength(0);
                        if (!p.equals("")) {
                            out.add(p);
                        }
                    } else {
                        sb.append(c);
                    }
                }
            } else if (c == '\\') {
                inBack = true;
            } else if (c == '\"') {
                if (inQuote) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                inQuote = z2;
            } else if (c != ' ') {
                sb.append(c);
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
            out.add(sb.toString());
        }
        return make((String[]) out.toArray(new String[out.size()]));
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.zwitserloot.cmdreader.CmdReader$1State] */
    public T make(String[] in) throws InvalidCommandLineException {
        final T obj = construct();
        if (in == null) {
            in = new String[0];
        }
        int seq = 0;
        ?? r0 = new Object() { // from class: com.zwitserloot.cmdreader.CmdReader.1State
            List<ParseItem> used = new ArrayList();

            void handle(ParseItem item, String value) {
                item.set(obj, value);
                this.used.add(item);
            }

            void finish() throws InvalidCommandLineException {
                checkForGlobalMandatories();
                checkForExcludes();
                checkForRequires();
                checkForMandatoriesIf();
                checkForMandatoriesIfNot();
            }

            private void checkForGlobalMandatories() throws InvalidCommandLineException {
                for (ParseItem item : CmdReader.this.items) {
                    if (item.isMandatory() && !this.used.contains(item)) {
                        throw new InvalidCommandLineException("You did not specify mandatory parameter " + item.getFullName());
                    }
                }
            }

            private void checkForExcludes() throws InvalidCommandLineException {
                for (ParseItem item : CmdReader.this.items) {
                    if (this.used.contains(item)) {
                        for (String n : item.getExcludes()) {
                            for (ParseItem i : CmdReader.this.items) {
                                if (i.getFullName().equals(n) && this.used.contains(i)) {
                                    throw new InvalidCommandLineException("You specified parameter " + i.getFullName() + " which cannot be used together with " + item.getFullName());
                                }
                            }
                        }
                    }
                }
            }

            private void checkForRequires() throws InvalidCommandLineException {
                for (ParseItem item : CmdReader.this.items) {
                    if (this.used.contains(item)) {
                        for (String n : item.getRequires()) {
                            for (ParseItem i : CmdReader.this.items) {
                                if (i.getFullName().equals(n) && !this.used.contains(i)) {
                                    throw new InvalidCommandLineException("You specified parameter " + item.getFullName() + " which requires that you also supply " + i.getFullName());
                                }
                            }
                        }
                    }
                }
            }

            private void checkForMandatoriesIf() throws InvalidCommandLineException {
                for (ParseItem item : CmdReader.this.items) {
                    if (!this.used.contains(item) && item.getMandatoryIf().size() != 0) {
                        for (String n : item.getMandatoryIf()) {
                            for (ParseItem i : CmdReader.this.items) {
                                if (i.getFullName().equals(n) && this.used.contains(i)) {
                                    throw new InvalidCommandLineException("You did not specify parameter " + item.getFullName() + " which is mandatory if you use " + i.getFullName());
                                }
                            }
                        }
                    }
                }
            }

            private void checkForMandatoriesIfNot() throws InvalidCommandLineException {
                for (ParseItem item : CmdReader.this.items) {
                    if (!this.used.contains(item) && item.getMandatoryIfNot().size() != 0) {
                        Iterator<String> it = item.getMandatoryIfNot().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                String n = it.next();
                                for (ParseItem i : CmdReader.this.items) {
                                    if (i.getFullName().equals(n) && this.used.contains(i)) {
                                        break;
                                    }
                                }
                            } else {
                                StringBuilder alternatives = new StringBuilder();
                                if (item.getMandatoryIfNot().size() > 1) {
                                    alternatives.append("one of ");
                                }
                                for (String n2 : item.getMandatoryIfNot()) {
                                    alternatives.append(n2).append(", ");
                                }
                                alternatives.setLength(alternatives.length() - 2);
                                throw new InvalidCommandLineException("You did not specify parameter " + item.getFullName() + " which is mandatory unless you use " + ((Object) alternatives));
                            }
                        }
                    }
                }
            }
        };
        int i = 0;
        while (i < in.length) {
            if (in[i].startsWith("--")) {
                int idx = in[i].indexOf(61);
                String key = idx == -1 ? in[i].substring(2) : in[i].substring(2, idx);
                String value = idx == -1 ? "" : in[i].substring(idx + 1);
                if (value.length() == 0 && idx != -1) {
                    throw new InvalidCommandLineException("invalid command line argument - you should write something after the '=': " + in[i]);
                }
                boolean handled = false;
                for (ParseItem item : this.items) {
                    if (item.getFullName().equalsIgnoreCase(key)) {
                        if (item.isParameterized() && value.length() == 0) {
                            if (i >= in.length - 1 || in[i + 1].startsWith("-")) {
                                throw new InvalidCommandLineException(String.format("invalid command line argument - %s requires a parameter but there is none.", key));
                            }
                            i++;
                            value = in[i];
                        }
                        r0.handle(item, (item.isParameterized() || value.length() != 0) ? value : null);
                        handled = true;
                        break;
                    }
                }
                if (!handled) {
                    throw new InvalidCommandLineException("invalid command line argument - I don't know about that option: " + in[i]);
                }
            } else if (in[i].startsWith("-")) {
                char[] arr$ = in[i].substring(1).toCharArray();
                for (char c : arr$) {
                    ParseItem item2 = this.shorthands.get(Character.valueOf(c));
                    if (item2 == null) {
                        throw new InvalidCommandLineException(String.format("invalid command line argument - %s is not a known option: %s", Character.valueOf(c), in[i]));
                    }
                    if (!item2.isParameterized()) {
                        r0.handle(item2, null);
                    } else {
                        if (i >= in.length - 1 || in[i + 1].startsWith("-")) {
                            throw new InvalidCommandLineException(String.format("invalid command line argument - %s requires a parameter but there is none.", Character.valueOf(c)));
                        }
                        i++;
                        r0.handle(item2, in[i]);
                    }
                }
            } else {
                seq++;
                if (this.seqList.size() < seq) {
                    if (this.seqList.size() > 0 && this.seqList.get(this.seqList.size() - 1).isCollection()) {
                        r0.handle(this.seqList.get(this.seqList.size() - 1), in[i]);
                    } else {
                        throw new InvalidCommandLineException(String.format("invalid command line argument - you've provided too many free-standing arguments: %s", in[i]));
                    }
                } else {
                    r0.handle(this.seqList.get(seq - 1), in[i]);
                }
            }
            i++;
        }
        r0.finish();
        return obj;
    }

    private T construct() {
        try {
            Constructor<T> constructor = this.settingsDescriptor.getDeclaredConstructor(new Class[0]);
            constructor.setAccessible(true);
            return constructor.newInstance(new Object[0]);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Huh?");
        } catch (InstantiationException e2) {
            throw new IllegalArgumentException(String.format("A CmdReader class must not be an interface or abstract: %s", this.settingsDescriptor));
        } catch (NoSuchMethodException e3) {
            throw new IllegalArgumentException(String.format("A CmdReader class must have a no-args constructor: %s", this.settingsDescriptor));
        } catch (InvocationTargetException e4) {
            throw new IllegalArgumentException("Exception occurred when constructing CmdReader class " + this.settingsDescriptor, e4.getCause());
        }
    }

    public static String squash(Collection<String> collection) {
        Iterator<String> i = collection.iterator();
        StringBuilder out = new StringBuilder();
        while (i.hasNext()) {
            out.append(i.next());
            if (i.hasNext()) {
                out.append(' ');
            }
        }
        return out.toString();
    }
}

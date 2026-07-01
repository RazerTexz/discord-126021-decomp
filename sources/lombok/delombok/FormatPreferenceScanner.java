package lombok.delombok;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: app.apk:lombok/delombok/FormatPreferenceScanner.SCL.lombok */
public class FormatPreferenceScanner {
    private FormatPreferences tryEasy(FormatPreferences preferences, boolean force) {
        int count = 0;
        for (Map.Entry<String, String> e : preferences.rawMap.entrySet()) {
            if (!"scan".equalsIgnoreCase(e.getValue())) {
                count++;
            }
        }
        if (force || count >= FormatPreferences.KEYS.size()) {
            return preferences;
        }
        return null;
    }

    public FormatPreferences scan(FormatPreferences preferences, CharSequence source) {
        FormatPreferences fps = tryEasy(preferences, source == null);
        if (fps != null) {
            return fps;
        }
        try {
            return scan_(preferences, new Reader(source) { // from class: lombok.delombok.FormatPreferenceScanner.1
                int pos = 0;
                int max;
                private final /* synthetic */ CharSequence val$source;

                {
                    this.val$source = source;
                    this.max = source.length();
                }

                @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                }

                @Override // java.io.Reader
                public int read(char[] b2, int p, int len) throws IOException {
                    int read = 0;
                    if (this.pos >= this.max) {
                        return -1;
                    }
                    for (int i = p; i < p + len; i++) {
                        CharSequence charSequence = this.val$source;
                        int i2 = this.pos;
                        this.pos = i2 + 1;
                        b2[i] = charSequence.charAt(i2);
                        read++;
                        if (this.pos == this.max) {
                            return read;
                        }
                    }
                    return len;
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public FormatPreferences scan(FormatPreferences preferences, char[] source) {
        FormatPreferences fps = tryEasy(preferences, source == null);
        if (fps != null) {
            return fps;
        }
        try {
            return scan_(preferences, new CharArrayReader(source));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public FormatPreferences scan(FormatPreferences preferences, Reader in) throws IOException {
        FormatPreferences fps = tryEasy(preferences, in == null);
        return fps != null ? fps : scan_(preferences, in);
    }

    private static FormatPreferences scan_(FormatPreferences preferences, Reader in) throws IOException {
        int filledEmpties = 0;
        List<String> indents = new ArrayList<>();
        char[] buffer = new char[32700];
        int pos = 1;
        int end = 0;
        StringBuilder indentSoFar = new StringBuilder();
        boolean inIndent = true;
        boolean inComment = false;
        char lastChar = ' ';
        while (true) {
            if (pos >= end) {
                int r = in.read(buffer);
                if (r == -1) {
                    break;
                }
                pos = 0;
                end = r;
            } else {
                int i = pos;
                pos++;
                char c = buffer[i];
                if (inComment) {
                    if (lastChar == '*' && c == '/') {
                        inComment = false;
                    }
                    lastChar = c;
                } else if (lastChar == '/' && c == '*') {
                    inComment = true;
                    lastChar = ' ';
                    indentSoFar.setLength(0);
                    inIndent = false;
                } else if (inIndent) {
                    boolean w = Character.isWhitespace(c);
                    if (c == '\n') {
                        if (indentSoFar.length() > 0 && indentSoFar.charAt(indentSoFar.length() - 1) == '\r') {
                            indentSoFar.setLength(indentSoFar.length() - 1);
                        }
                        if (indentSoFar.length() > 0) {
                            filledEmpties++;
                        }
                        indents.add(indentSoFar.toString());
                        indentSoFar.setLength(0);
                        lastChar = c;
                    } else if (w) {
                        indentSoFar.append(c);
                        lastChar = c;
                    } else {
                        if (indentSoFar.length() > 0) {
                            indents.add(indentSoFar.toString());
                            indentSoFar.setLength(0);
                        }
                        lastChar = c;
                        inIndent = false;
                    }
                } else {
                    lastChar = c;
                    if (c == '\n') {
                        inIndent = true;
                        indentSoFar.setLength(0);
                    }
                }
            }
        }
        String indent = null;
        int lowestSpaceCount = Integer.MAX_VALUE;
        for (String ind : indents) {
            if (ind.indexOf(9) > -1) {
                indent = "\t";
                break;
            }
            if (ind.length() >= 2 && ind.length() <= 8 && ind.length() < lowestSpaceCount) {
                lowestSpaceCount = ind.length();
            }
        }
        if (lowestSpaceCount == Integer.MAX_VALUE) {
            indent = "\t";
        }
        if (indent == null) {
            char[] id2 = new char[lowestSpaceCount];
            Arrays.fill(id2, ' ');
            indent = new String(id2);
        }
        return new FormatPreferences(preferences.rawMap, indent, Boolean.valueOf(filledEmpties > 0));
    }
}

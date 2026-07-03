package com.discord.utilities.debug;

import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: DebugPrintable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DebugPrintBuilder {
    private static final int maxDepth = 10;
    private int indentation;
    private final StringBuilder sb;

    public DebugPrintBuilder(StringBuilder sb) {
        C12238m.checkNotNullParameter(sb, "sb");
        this.sb = sb;
    }

    public final void append(String s2) {
        C12238m.checkNotNullParameter(s2, "s");
        this.sb.append(s2);
    }

    public final void appendKeyValue(String key, Object value) {
        String string;
        C12238m.checkNotNullParameter(key, "key");
        int i = this.indentation;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                this.sb.append("  ");
                if (i2 == i) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        this.sb.append(" - ");
        this.sb.append(key);
        this.sb.append(": ");
        StringBuilder sb = this.sb;
        if (value == null || (string = value.toString()) == null) {
            string = "{null}";
        }
        sb.append(string);
        this.sb.append("\n");
    }

    public final void appendLine(String s2) {
        C12238m.checkNotNullParameter(s2, "s");
        StringBuilder sb = this.sb;
        sb.append(s2);
        C12238m.checkNotNullExpressionValue(sb, "append(value)");
        sb.append('\n');
        C12238m.checkNotNullExpressionValue(sb, "append('\\n')");
    }

    public final StringBuilder getSb() {
        return this.sb;
    }

    public final void append(int s2) {
        this.sb.append(s2);
    }

    public final void append(Object s2) {
        C12238m.checkNotNullParameter(s2, "s");
        this.sb.append(s2);
    }

    public final void appendKeyValue(String key, DebugPrintable value) {
        C12238m.checkNotNullParameter(key, "key");
        int i = this.indentation;
        if (i >= 10) {
            this.sb.append(" + Reached maxDepth 10");
            return;
        }
        int i2 = 0;
        if (i >= 0) {
            while (true) {
                this.sb.append("  ");
                if (i2 == i) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        this.sb.append(" + ");
        this.sb.append(key);
        if (value == null) {
            this.sb.append(": {null}\n");
            return;
        }
        this.sb.append(":\n");
        this.indentation++;
        value.debugPrint(this);
        this.indentation--;
    }
}

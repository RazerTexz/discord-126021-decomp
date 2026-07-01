package com.discord.utilities.debug;

import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.utilities.debug.DebugPrintBuilder, reason: use source file name */
/* JADX INFO: compiled from: DebugPrintable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DebugPrintable2 {
    private static final int maxDepth = 10;
    private int indentation;
    private final StringBuilder sb;

    public DebugPrintable2(StringBuilder sb) {
        Intrinsics3.checkNotNullParameter(sb, "sb");
        this.sb = sb;
    }

    public final void append(String s2) {
        Intrinsics3.checkNotNullParameter(s2, "s");
        this.sb.append(s2);
    }

    public final void appendKeyValue(String key, Object value) {
        String string;
        Intrinsics3.checkNotNullParameter(key, "key");
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
        Intrinsics3.checkNotNullParameter(s2, "s");
        StringBuilder sb = this.sb;
        sb.append(s2);
        Intrinsics3.checkNotNullExpressionValue(sb, "append(value)");
        sb.append('\n');
        Intrinsics3.checkNotNullExpressionValue(sb, "append('\\n')");
    }

    public final StringBuilder getSb() {
        return this.sb;
    }

    public final void append(int s2) {
        this.sb.append(s2);
    }

    public final void append(Object s2) {
        Intrinsics3.checkNotNullParameter(s2, "s");
        this.sb.append(s2);
    }

    public final void appendKeyValue(String key, DebugPrintable value) {
        Intrinsics3.checkNotNullParameter(key, "key");
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

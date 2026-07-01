package com.discord.utilities.collections;

import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import kotlin.collections.ArrayDeque;

/* JADX INFO: compiled from: FixedSizeLineBuffer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FixedSizeLineBuffer {
    private final int maxCharacterCount;
    private int outputLength;
    private final ArrayDeque<String> output = new ArrayDeque<>();
    private final Object sync = new Object();

    public FixedSizeLineBuffer(int i) {
        this.maxCharacterCount = i;
    }

    public final void addLine(String line) {
        String strRemoveFirstOrNull;
        Intrinsics3.checkNotNullParameter(line, "line");
        synchronized (this.sync) {
            this.output.add(line);
            this.outputLength = line.length() + 1 + this.outputLength;
            while (this.outputLength > this.maxCharacterCount && (strRemoveFirstOrNull = this.output.removeFirstOrNull()) != null) {
                this.outputLength -= strRemoveFirstOrNull.length() - 1;
            }
        }
    }

    public final void appendString(StringBuilder sb) {
        Intrinsics3.checkNotNullParameter(sb, "sb");
        synchronized (this.sync) {
            Iterator<String> it = this.output.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                Intrinsics3.checkNotNullExpressionValue(sb, "append(value)");
                sb.append('\n');
                Intrinsics3.checkNotNullExpressionValue(sb, "append('\\n')");
            }
        }
    }

    public final String getString() {
        String strJoinToString$default;
        synchronized (this.sync) {
            strJoinToString$default = _Collections.joinToString$default(this.output, "\n", null, null, 0, null, null, 62, null);
        }
        return strJoinToString$default;
    }
}

package d0.g0;

import b.d.b.a.outline;
import kotlin.ranges.Ranges2;

/* JADX INFO: renamed from: d0.g0.a, reason: use source file name */
/* JADX INFO: compiled from: CharJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public class CharJVM {
    public static final int checkRadix(int i) {
        if (2 <= i && 36 >= i) {
            return i;
        }
        StringBuilder sbV = outline.V("radix ", i, " was not in valid range ");
        sbV.append(new Ranges2(2, 36));
        throw new IllegalArgumentException(sbV.toString());
    }

    public static final int digitOf(char c, int i) {
        return Character.digit((int) c, i);
    }

    public static final boolean isWhitespace(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }
}

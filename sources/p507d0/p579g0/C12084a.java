package p507d0.p579g0;

import kotlin.ranges.IntRange;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: d0.g0.a */
/* JADX INFO: compiled from: CharJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12084a {
    public static final int checkRadix(int i) {
        if (2 <= i && 36 >= i) {
            return i;
        }
        StringBuilder sbM834V = C1643a.m834V("radix ", i, " was not in valid range ");
        sbM834V.append(new IntRange(2, 36));
        throw new IllegalArgumentException(sbM834V.toString());
    }

    public static final int digitOf(char c, int i) {
        return Character.digit((int) c, i);
    }

    public static final boolean isWhitespace(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }
}

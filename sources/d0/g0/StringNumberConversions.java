package d0.g0;

import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.g0.s, reason: use source file name */
/* JADX INFO: compiled from: StringNumberConversions.kt */
/* JADX INFO: loaded from: classes3.dex */
public class StringNumberConversions extends StringNumberConversionsJVM2 {
    public static final Byte toByteOrNull(String str, int i) {
        int iIntValue;
        Intrinsics3.checkNotNullParameter(str, "$this$toByteOrNull");
        Integer intOrNull = toIntOrNull(str, i);
        if (intOrNull == null || (iIntValue = intOrNull.intValue()) < -128 || iIntValue > 127) {
            return null;
        }
        return Byte.valueOf((byte) iIntValue);
    }

    public static final Integer toIntOrNull(String str) {
        Intrinsics3.checkNotNullParameter(str, "$this$toIntOrNull");
        return toIntOrNull(str, 10);
    }

    public static final Long toLongOrNull(String str) {
        Intrinsics3.checkNotNullParameter(str, "$this$toLongOrNull");
        return toLongOrNull(str, 10);
    }

    public static final Short toShortOrNull(String str, int i) {
        int iIntValue;
        Intrinsics3.checkNotNullParameter(str, "$this$toShortOrNull");
        Integer intOrNull = toIntOrNull(str, i);
        if (intOrNull == null || (iIntValue = intOrNull.intValue()) < -32768 || iIntValue > 32767) {
            return null;
        }
        return Short.valueOf((short) iIntValue);
    }

    public static final Integer toIntOrNull(String str, int i) {
        boolean z2;
        int i2;
        Intrinsics3.checkNotNullParameter(str, "$this$toIntOrNull");
        CharJVM.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char cCharAt = str.charAt(0);
        int i4 = -2147483647;
        int i5 = 1;
        if (Intrinsics3.compare(cCharAt, 48) >= 0) {
            z2 = false;
            i5 = 0;
        } else {
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                i4 = Integer.MIN_VALUE;
                z2 = true;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z2 = false;
            }
        }
        int i6 = -59652323;
        while (i5 < length) {
            int iDigitOf = CharJVM.digitOf(str.charAt(i5), i);
            if (iDigitOf < 0) {
                return null;
            }
            if ((i3 < i6 && (i6 != -59652323 || i3 < (i6 = i4 / i))) || (i2 = i3 * i) < i4 + iDigitOf) {
                return null;
            }
            i3 = i2 - iDigitOf;
            i5++;
        }
        return z2 ? Integer.valueOf(i3) : Integer.valueOf(-i3);
    }

    public static final Long toLongOrNull(String str, int i) {
        Intrinsics3.checkNotNullParameter(str, "$this$toLongOrNull");
        CharJVM.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char cCharAt = str.charAt(0);
        long j = -9223372036854775807L;
        boolean z2 = true;
        if (Intrinsics3.compare(cCharAt, 48) >= 0) {
            z2 = false;
        } else {
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                j = Long.MIN_VALUE;
                i2 = 1;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                i2 = 1;
                z2 = false;
            }
        }
        long j2 = -256204778801521550L;
        long j3 = 0;
        long j4 = -256204778801521550L;
        while (i2 < length) {
            int iDigitOf = CharJVM.digitOf(str.charAt(i2), i);
            if (iDigitOf < 0) {
                return null;
            }
            if (j3 < j4) {
                if (j4 == j2) {
                    j4 = j / ((long) i);
                    if (j3 < j4) {
                    }
                }
                return null;
            }
            long j5 = j3 * ((long) i);
            long j6 = iDigitOf;
            if (j5 < j + j6) {
                return null;
            }
            j3 = j5 - j6;
            i2++;
            j2 = -256204778801521550L;
        }
        return z2 ? Long.valueOf(j3) : Long.valueOf(-j3);
    }
}

package p007b.p225i.p226a.p288f.p313h.p325l;

import com.discord.api.permission.Permission;

/* JADX INFO: renamed from: b.i.a.f.h.l.k7 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3724k7 {

    /* JADX INFO: renamed from: a */
    public static final AbstractC3750m7 f10058a;

    static {
        f10058a = (!(C3711j7.f10038g && C3711j7.f10037f) || C3798q3.m5185a()) ? new C3737l7() : new C3763n7();
    }

    /* JADX INFO: renamed from: a */
    public static int m5021a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt >= 2048) {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char cCharAt2 = charSequence.charAt(i2);
                    if (cCharAt2 < 2048) {
                        i += (127 - cCharAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) < 65536) {
                                throw new C3776o7(i2, length2);
                            }
                            i2++;
                        }
                    }
                    i2++;
                }
                i3 += i;
                break;
            }
            i3 += (127 - cCharAt) >>> 31;
            i2++;
        }
        if (i3 >= length) {
            return i3;
        }
        long j = ((long) i3) + Permission.REQUEST_TO_SPEAK;
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: renamed from: b */
    public static boolean m5022b(byte[] bArr, int i, int i2) {
        return f10058a.mo5055a(0, bArr, i, i2) == 0;
    }

    /* JADX INFO: renamed from: c */
    public static int m5023c(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    /* JADX INFO: renamed from: d */
    public static int m5024d(byte[] bArr, int i, int i2) {
        byte b2 = bArr[i - 1];
        int i3 = i2 - i;
        int i4 = -1;
        if (i3 == 0) {
            if (b2 > -12) {
                b2 = -1;
            }
            return b2;
        }
        if (i3 != 1) {
            if (i3 == 2) {
                return m5023c(b2, bArr[i], bArr[i + 1]);
            }
            throw new AssertionError();
        }
        byte b3 = bArr[i];
        if (b2 <= -12 && b3 <= -65) {
            i4 = b2 ^ (b3 << 8);
        }
        return i4;
    }
}

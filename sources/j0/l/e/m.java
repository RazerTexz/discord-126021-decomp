package j0.l.e;

import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: UtilityFunctions.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public static int a(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = i + i2;
        int i5 = i;
        int i6 = i3;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i5 < i4) {
            int i10 = i5 + 1;
            int iCharAt = charSequence.charAt(i5);
            int i11 = 24;
            if (iCharAt < 128) {
                i11 = 8;
            } else if (iCharAt < 2048) {
                iCharAt = (((iCharAt & 63) | 128) << 8) | (iCharAt >> 6) | Opcodes.CHECKCAST;
                i11 = 16;
            } else if (iCharAt < 55296 || iCharAt > 57343 || i10 >= i4) {
                iCharAt = (((iCharAt & 63) | 128) << 16) | (iCharAt >> 12) | 224 | ((((iCharAt >> 6) & 63) | 128) << 8);
            } else {
                int iCharAt2 = ((iCharAt - 55232) << 10) + (charSequence.charAt(i10) & 1023);
                iCharAt = (((iCharAt2 & 63) | 128) << 24) | ((((iCharAt2 >> 12) & 63) | 128) << 8) | (((iCharAt2 >> 18) | 240) & 255) | ((((iCharAt2 >> 6) & 63) | 128) << 16);
                i10++;
                i11 = 32;
            }
            int i12 = (iCharAt << i7) | i9;
            i7 += i11;
            if (i7 >= 32) {
                int i13 = i12 * (-862048943);
                int i14 = (((i13 >>> 17) | (i13 << 15)) * 461845907) ^ i6;
                i7 -= 32;
                i8 += 4;
                i6 = (((i14 >>> 19) | (i14 << 13)) * 5) - 430675100;
                i9 = i7 != 0 ? iCharAt >>> (i11 - i7) : 0;
            } else {
                i9 = i12;
            }
            i5 = i10;
        }
        if (i7 > 0) {
            i8 += i7 >> 3;
            int i15 = i9 * (-862048943);
            i6 ^= ((i15 << 15) | (i15 >>> 17)) * 461845907;
        }
        int i16 = i6 ^ i8;
        int i17 = (i16 ^ (i16 >>> 16)) * (-2048144789);
        int i18 = (i17 ^ (i17 >>> 13)) * (-1028477387);
        return i18 ^ (i18 >>> 16);
    }

    public static int b(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }
}

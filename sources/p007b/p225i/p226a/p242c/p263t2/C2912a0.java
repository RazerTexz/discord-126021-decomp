package p007b.p225i.p226a.p242c.p263t2;

import androidx.annotation.Nullable;
import com.discord.restapi.RestAPIAbortCodes;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.a.c.t2.a0 */
/* JADX INFO: compiled from: MpegAudioUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2912a0 {

    /* JADX INFO: renamed from: a */
    public static final String[] f7670a = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};

    /* JADX INFO: renamed from: b */
    public static final int[] f7671b = {44100, 48000, 32000};

    /* JADX INFO: renamed from: c */
    public static final int[] f7672c = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};

    /* JADX INFO: renamed from: d */
    public static final int[] f7673d = {32000, 48000, 56000, 64000, RestAPIAbortCodes.RELATIONSHIP_INCOMING_DISABLED, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};

    /* JADX INFO: renamed from: e */
    public static final int[] f7674e = {32000, 48000, 56000, 64000, RestAPIAbortCodes.RELATIONSHIP_INCOMING_DISABLED, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};

    /* JADX INFO: renamed from: f */
    public static final int[] f7675f = {32000, 40000, 48000, 56000, 64000, RestAPIAbortCodes.RELATIONSHIP_INCOMING_DISABLED, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};

    /* JADX INFO: renamed from: g */
    public static final int[] f7676g = {8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, RestAPIAbortCodes.RELATIONSHIP_INCOMING_DISABLED, 96000, 112000, 128000, 144000, 160000};

    /* JADX INFO: renamed from: b.i.a.c.t2.a0$a */
    /* JADX INFO: compiled from: MpegAudioUtil.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public int f7677a;

        /* JADX INFO: renamed from: b */
        @Nullable
        public String f7678b;

        /* JADX INFO: renamed from: c */
        public int f7679c;

        /* JADX INFO: renamed from: d */
        public int f7680d;

        /* JADX INFO: renamed from: e */
        public int f7681e;

        /* JADX INFO: renamed from: f */
        public int f7682f;

        /* JADX INFO: renamed from: g */
        public int f7683g;

        /* JADX INFO: renamed from: a */
        public boolean m3469a(int i) {
            int i2;
            int i3;
            int i4;
            int i5;
            if (!C2912a0.m3467c(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
                return false;
            }
            this.f7677a = i2;
            this.f7678b = C2912a0.f7670a[3 - i3];
            int i6 = C2912a0.f7671b[i5];
            this.f7680d = i6;
            if (i2 == 2) {
                this.f7680d = i6 / 2;
            } else if (i2 == 0) {
                this.f7680d = i6 / 4;
            }
            int i7 = (i >>> 9) & 1;
            this.f7683g = C2912a0.m3466b(i2, i3);
            if (i3 == 3) {
                int i8 = i2 == 3 ? C2912a0.f7672c[i4 - 1] : C2912a0.f7673d[i4 - 1];
                this.f7682f = i8;
                this.f7679c = (((i8 * 12) / this.f7680d) + i7) * 4;
            } else {
                int i9 = Opcodes.D2F;
                if (i2 == 3) {
                    int i10 = i3 == 2 ? C2912a0.f7674e[i4 - 1] : C2912a0.f7675f[i4 - 1];
                    this.f7682f = i10;
                    this.f7679c = ((i10 * Opcodes.D2F) / this.f7680d) + i7;
                } else {
                    int i11 = C2912a0.f7676g[i4 - 1];
                    this.f7682f = i11;
                    if (i3 == 1) {
                        i9 = 72;
                    }
                    this.f7679c = ((i9 * i11) / this.f7680d) + i7;
                }
            }
            this.f7681e = ((i >> 6) & 3) == 3 ? 1 : 2;
            return true;
        }
    }

    /* JADX INFO: renamed from: a */
    public static int m3465a(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (!m3467c(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
            return -1;
        }
        int i7 = f7671b[i5];
        if (i2 == 2) {
            i7 /= 2;
        } else if (i2 == 0) {
            i7 /= 4;
        }
        int i8 = (i >>> 9) & 1;
        if (i3 == 3) {
            return ((((i2 == 3 ? f7672c[i4 - 1] : f7673d[i4 - 1]) * 12) / i7) + i8) * 4;
        }
        if (i2 == 3) {
            i6 = i3 == 2 ? f7674e[i4 - 1] : f7675f[i4 - 1];
        } else {
            i6 = f7676g[i4 - 1];
        }
        int i9 = Opcodes.D2F;
        if (i2 == 3) {
            return ((i6 * Opcodes.D2F) / i7) + i8;
        }
        if (i3 == 1) {
            i9 = 72;
        }
        return ((i9 * i6) / i7) + i8;
    }

    /* JADX INFO: renamed from: b */
    public static int m3466b(int i, int i2) {
        if (i2 == 1) {
            return i == 3 ? 1152 : 576;
        }
        if (i2 == 2) {
            return 1152;
        }
        if (i2 == 3) {
            return 384;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: renamed from: c */
    public static boolean m3467c(int i) {
        return (i & (-2097152)) == -2097152;
    }

    /* JADX INFO: renamed from: d */
    public static int m3468d(int i) {
        int i2;
        int i3;
        if (!m3467c(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0) {
            return -1;
        }
        int i4 = (i >>> 12) & 15;
        int i5 = (i >>> 10) & 3;
        if (i4 == 0 || i4 == 15 || i5 == 3) {
            return -1;
        }
        return m3466b(i2, i3);
    }
}

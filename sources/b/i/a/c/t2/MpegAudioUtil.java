package b.i.a.c.t2;

import androidx.annotation.Nullable;
import com.discord.restapi.RestAPIAbortCodes;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.a.c.t2.a0, reason: use source file name */
/* JADX INFO: compiled from: MpegAudioUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class MpegAudioUtil {
    public static final String[] a = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1115b = {44100, 48000, 32000};
    public static final int[] c = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};
    public static final int[] d = {32000, 48000, 56000, 64000, RestAPIAbortCodes.RELATIONSHIP_INCOMING_DISABLED, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};
    public static final int[] e = {32000, 48000, 56000, 64000, RestAPIAbortCodes.RELATIONSHIP_INCOMING_DISABLED, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};
    public static final int[] f = {32000, 40000, 48000, 56000, 64000, RestAPIAbortCodes.RELATIONSHIP_INCOMING_DISABLED, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};
    public static final int[] g = {8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, RestAPIAbortCodes.RELATIONSHIP_INCOMING_DISABLED, 96000, 112000, 128000, 144000, 160000};

    /* JADX INFO: renamed from: b.i.a.c.t2.a0$a */
    /* JADX INFO: compiled from: MpegAudioUtil.java */
    public static final class a {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public String f1116b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;

        public boolean a(int i) {
            int i2;
            int i3;
            int i4;
            int i5;
            if (!MpegAudioUtil.c(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
                return false;
            }
            this.a = i2;
            this.f1116b = MpegAudioUtil.a[3 - i3];
            int i6 = MpegAudioUtil.f1115b[i5];
            this.d = i6;
            if (i2 == 2) {
                this.d = i6 / 2;
            } else if (i2 == 0) {
                this.d = i6 / 4;
            }
            int i7 = (i >>> 9) & 1;
            this.g = MpegAudioUtil.b(i2, i3);
            if (i3 == 3) {
                int i8 = i2 == 3 ? MpegAudioUtil.c[i4 - 1] : MpegAudioUtil.d[i4 - 1];
                this.f = i8;
                this.c = (((i8 * 12) / this.d) + i7) * 4;
            } else {
                int i9 = Opcodes.D2F;
                if (i2 == 3) {
                    int i10 = i3 == 2 ? MpegAudioUtil.e[i4 - 1] : MpegAudioUtil.f[i4 - 1];
                    this.f = i10;
                    this.c = ((i10 * Opcodes.D2F) / this.d) + i7;
                } else {
                    int i11 = MpegAudioUtil.g[i4 - 1];
                    this.f = i11;
                    if (i3 == 1) {
                        i9 = 72;
                    }
                    this.c = ((i9 * i11) / this.d) + i7;
                }
            }
            this.e = ((i >> 6) & 3) == 3 ? 1 : 2;
            return true;
        }
    }

    public static int a(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (!c(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
            return -1;
        }
        int i7 = f1115b[i5];
        if (i2 == 2) {
            i7 /= 2;
        } else if (i2 == 0) {
            i7 /= 4;
        }
        int i8 = (i >>> 9) & 1;
        if (i3 == 3) {
            return ((((i2 == 3 ? c[i4 - 1] : d[i4 - 1]) * 12) / i7) + i8) * 4;
        }
        if (i2 == 3) {
            i6 = i3 == 2 ? e[i4 - 1] : f[i4 - 1];
        } else {
            i6 = g[i4 - 1];
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

    public static int b(int i, int i2) {
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

    public static boolean c(int i) {
        return (i & (-2097152)) == -2097152;
    }

    public static int d(int i) {
        int i2;
        int i3;
        if (!c(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0) {
            return -1;
        }
        int i4 = (i >>> 12) & 15;
        int i5 = (i >>> 10) & 3;
        if (i4 == 0 || i4 == 15 || i5 == 3) {
            return -1;
        }
        return b(i2, i3);
    }
}

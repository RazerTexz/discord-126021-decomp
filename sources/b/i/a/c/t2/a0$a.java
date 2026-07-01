package b.i.a.c.t2;

import androidx.annotation.Nullable;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: MpegAudioUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a0$a {
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
        if (!a0.c(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
            return false;
        }
        this.a = i2;
        this.f1116b = a0.a[3 - i3];
        int i6 = a0.f1115b[i5];
        this.d = i6;
        if (i2 == 2) {
            this.d = i6 / 2;
        } else if (i2 == 0) {
            this.d = i6 / 4;
        }
        int i7 = (i >>> 9) & 1;
        this.g = a0.b(i2, i3);
        if (i3 == 3) {
            int i8 = i2 == 3 ? a0.c[i4 - 1] : a0.d[i4 - 1];
            this.f = i8;
            this.c = (((i8 * 12) / this.d) + i7) * 4;
        } else {
            int i9 = Opcodes.D2F;
            if (i2 == 3) {
                int i10 = i3 == 2 ? a0.e[i4 - 1] : a0.f[i4 - 1];
                this.f = i10;
                this.c = ((i10 * Opcodes.D2F) / this.d) + i7;
            } else {
                int i11 = a0.g[i4 - 1];
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

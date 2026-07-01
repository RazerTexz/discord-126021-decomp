package b.i.a.c.g3;

import androidx.annotation.Nullable;
import b.i.a.c.Bundleable;
import java.util.Arrays;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: renamed from: b.i.a.c.g3.n, reason: use source file name */
/* JADX INFO: compiled from: ColorInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ColorInfo implements Bundleable {
    public static final /* synthetic */ int j = 0;
    public final int k;
    public final int l;
    public final int m;

    @Nullable
    public final byte[] n;
    public int o;

    public ColorInfo(int i, int i2, int i3, @Nullable byte[] bArr) {
        this.k = i;
        this.l = i2;
        this.m = i3;
        this.n = bArr;
    }

    @Pure
    public static int a(int i) {
        if (i == 1) {
            return 1;
        }
        if (i != 9) {
            return (i == 4 || i == 5 || i == 6 || i == 7) ? 2 : -1;
        }
        return 6;
    }

    @Pure
    public static int b(int i) {
        if (i == 1) {
            return 3;
        }
        if (i == 16) {
            return 6;
        }
        if (i != 18) {
            return (i == 6 || i == 7) ? 3 : -1;
        }
        return 7;
    }

    public static String c(int i) {
        return Integer.toString(i, 36);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ColorInfo.class != obj.getClass()) {
            return false;
        }
        ColorInfo colorInfo = (ColorInfo) obj;
        return this.k == colorInfo.k && this.l == colorInfo.l && this.m == colorInfo.m && Arrays.equals(this.n, colorInfo.n);
    }

    public int hashCode() {
        if (this.o == 0) {
            this.o = Arrays.hashCode(this.n) + ((((((527 + this.k) * 31) + this.l) * 31) + this.m) * 31);
        }
        return this.o;
    }

    public String toString() {
        int i = this.k;
        int i2 = this.l;
        int i3 = this.m;
        boolean z2 = this.n != null;
        StringBuilder sb = new StringBuilder(55);
        sb.append("ColorInfo(");
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(z2);
        sb.append(")");
        return sb.toString();
    }
}

package b.i.a.c.x2;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: TrackOutput.java */
/* JADX INFO: loaded from: classes3.dex */
public final class w$a {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f1299b;
    public final int c;
    public final int d;

    public w$a(int i, byte[] bArr, int i2, int i3) {
        this.a = i;
        this.f1299b = bArr;
        this.c = i2;
        this.d = i3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || w$a.class != obj.getClass()) {
            return false;
        }
        w$a w_a = (w$a) obj;
        return this.a == w_a.a && this.c == w_a.c && this.d == w_a.d && Arrays.equals(this.f1299b, w_a.f1299b);
    }

    public int hashCode() {
        return ((((Arrays.hashCode(this.f1299b) + (this.a * 31)) * 31) + this.c) * 31) + this.d;
    }
}

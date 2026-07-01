package b.i.a.c.a3;

import androidx.annotation.Nullable;
import b.i.a.c.w0;
import java.util.Arrays;

/* JADX INFO: compiled from: TrackGroupArray.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o0 implements w0 {
    public static final o0 j = new o0(new n0[0]);
    public final int k;
    public final n0[] l;
    public int m;

    public o0(n0... n0VarArr) {
        this.l = n0VarArr;
        this.k = n0VarArr.length;
    }

    public int a(n0 n0Var) {
        for (int i = 0; i < this.k; i++) {
            if (this.l[i] == n0Var) {
                return i;
            }
        }
        return -1;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o0.class != obj.getClass()) {
            return false;
        }
        o0 o0Var = (o0) obj;
        return this.k == o0Var.k && Arrays.equals(this.l, o0Var.l);
    }

    public int hashCode() {
        if (this.m == 0) {
            this.m = Arrays.hashCode(this.l);
        }
        return this.m;
    }
}

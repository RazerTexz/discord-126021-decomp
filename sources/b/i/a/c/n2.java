package b.i.a.c;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: ThumbRating.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n2 extends d2 {
    public final boolean k;
    public final boolean l;

    public n2() {
        this.k = false;
        this.l = false;
    }

    public static String a(int i) {
        return Integer.toString(i, 36);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof n2)) {
            return false;
        }
        n2 n2Var = (n2) obj;
        return this.l == n2Var.l && this.k == n2Var.k;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.k), Boolean.valueOf(this.l)});
    }

    public n2(boolean z2) {
        this.k = true;
        this.l = z2;
    }
}

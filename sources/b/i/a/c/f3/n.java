package b.i.a.c.f3;

import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: FlagSet.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public final SparseBooleanArray a;

    public n(SparseBooleanArray sparseBooleanArray, n$a n_a) {
        this.a = sparseBooleanArray;
    }

    public boolean a(int i) {
        return this.a.get(i);
    }

    public int b(int i) {
        b.c.a.a0.d.t(i, 0, c());
        return this.a.keyAt(i);
    }

    public int c() {
        return this.a.size();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (e0.a >= 24) {
            return this.a.equals(nVar.a);
        }
        if (c() != nVar.c()) {
            return false;
        }
        for (int i = 0; i < c(); i++) {
            if (b(i) != nVar.b(i)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (e0.a >= 24) {
            return this.a.hashCode();
        }
        int iC = c();
        for (int i = 0; i < c(); i++) {
            iC = (iC * 31) + b(i);
        }
        return iC;
    }
}

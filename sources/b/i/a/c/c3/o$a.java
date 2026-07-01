package b.i.a.c.c3;

import androidx.annotation.Nullable;
import b.i.a.c.a3.n0;
import b.i.a.c.w0;
import b.i.b.b.n$b;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: TrackSelectionOverrides.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o$a implements w0 {
    public static final /* synthetic */ int j = 0;
    public final n0 k;
    public final b.i.b.b.p<Integer> l;

    public o$a(n0 n0Var) {
        this.k = n0Var;
        b.i.a.f.e.o.f.A(4, "initialCapacity");
        Object[] objArrCopyOf = new Object[4];
        int i = 0;
        int i2 = 0;
        while (i < n0Var.k) {
            Integer numValueOf = Integer.valueOf(i);
            Objects.requireNonNull(numValueOf);
            int i3 = i2 + 1;
            if (objArrCopyOf.length < i3) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, n$b.a(objArrCopyOf.length, i3));
            }
            objArrCopyOf[i2] = numValueOf;
            i++;
            i2 = i3;
        }
        this.l = b.i.b.b.p.l(objArrCopyOf, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o$a.class != obj.getClass()) {
            return false;
        }
        o$a o_a = (o$a) obj;
        return this.k.equals(o_a.k) && this.l.equals(o_a.l);
    }

    public int hashCode() {
        return (this.l.hashCode() * 31) + this.k.hashCode();
    }

    public o$a(n0 n0Var, List<Integer> list) {
        if (!list.isEmpty() && (((Integer) Collections.min(list)).intValue() < 0 || ((Integer) Collections.max(list)).intValue() >= n0Var.k)) {
            throw new IndexOutOfBoundsException();
        }
        this.k = n0Var;
        this.l = b.i.b.b.p.n(list);
    }
}

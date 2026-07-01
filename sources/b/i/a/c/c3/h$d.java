package b.i.a.c.c3;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import b.i.a.c.a3.o0;
import b.i.a.c.f3.e0;
import b.i.a.c.w0;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: compiled from: DefaultTrackSelector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h$d extends p implements w0 {
    public static final h$d I = new h$e().d();
    public final int J;
    public final boolean K;
    public final boolean L;
    public final boolean M;
    public final boolean N;
    public final boolean O;
    public final boolean P;
    public final boolean Q;
    public final boolean R;
    public final boolean S;
    public final boolean T;
    public final SparseArray<Map<o0, h$f>> U;
    public final SparseBooleanArray V;

    public h$d(h$e h_e, h$a h_a) {
        super(h_e);
        this.K = h_e.f900y;
        this.L = h_e.f901z;
        this.M = h_e.A;
        this.N = h_e.B;
        this.O = h_e.C;
        this.P = h_e.D;
        this.Q = h_e.E;
        this.J = h_e.F;
        this.R = h_e.G;
        this.S = h_e.H;
        this.T = h_e.I;
        this.U = h_e.J;
        this.V = h_e.K;
    }

    @Override // b.i.a.c.c3.p
    public boolean equals(@Nullable Object obj) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (obj == null || h$d.class != obj.getClass()) {
            return false;
        }
        h$d h_d = (h$d) obj;
        if (super.equals(h_d) && this.K == h_d.K && this.L == h_d.L && this.M == h_d.M && this.N == h_d.N && this.O == h_d.O && this.P == h_d.P && this.Q == h_d.Q && this.J == h_d.J && this.R == h_d.R && this.S == h_d.S && this.T == h_d.T) {
            SparseBooleanArray sparseBooleanArray = this.V;
            SparseBooleanArray sparseBooleanArray2 = h_d.V;
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() == size) {
                int i = 0;
                while (true) {
                    if (i >= size) {
                        z2 = true;
                        break;
                    }
                    if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                        z2 = false;
                        break;
                    }
                    i++;
                }
            } else {
                z2 = false;
                break;
            }
            if (z2) {
                SparseArray<Map<o0, h$f>> sparseArray = this.U;
                SparseArray<Map<o0, h$f>> sparseArray2 = h_d.U;
                int size2 = sparseArray.size();
                if (sparseArray2.size() != size2) {
                    z3 = false;
                } else {
                    int i2 = 0;
                    while (true) {
                        if (i2 < size2) {
                            int iIndexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i2));
                            if (iIndexOfKey < 0) {
                                break;
                            }
                            Map<o0, h$f> mapValueAt = sparseArray.valueAt(i2);
                            Map<o0, h$f> mapValueAt2 = sparseArray2.valueAt(iIndexOfKey);
                            if (mapValueAt2.size() == mapValueAt.size()) {
                                Iterator<Map$Entry<o0, h$f>> it = mapValueAt.entrySet().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        z4 = true;
                                        break;
                                    }
                                    Map$Entry<o0, h$f> next = it.next();
                                    o0 key = next.getKey();
                                    if (!mapValueAt2.containsKey(key) || !e0.a(next.getValue(), mapValueAt2.get(key))) {
                                        z4 = false;
                                        break;
                                    }
                                }
                            } else {
                                z4 = false;
                                break;
                            }
                            if (!z4) {
                                break;
                            }
                            i2++;
                        } else {
                            z3 = true;
                        }
                    }
                    z3 = false;
                }
                if (z3) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // b.i.a.c.c3.p
    public int hashCode() {
        return ((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.K ? 1 : 0)) * 31) + (this.L ? 1 : 0)) * 31) + (this.M ? 1 : 0)) * 31) + (this.N ? 1 : 0)) * 31) + (this.O ? 1 : 0)) * 31) + (this.P ? 1 : 0)) * 31) + (this.Q ? 1 : 0)) * 31) + this.J) * 31) + (this.R ? 1 : 0)) * 31) + (this.S ? 1 : 0)) * 31) + (this.T ? 1 : 0);
    }
}

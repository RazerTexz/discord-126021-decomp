package b.i.a.e;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: FlexboxHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class c$c implements Comparable<c$c> {
    public int j;
    public int k;

    public c$c() {
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull c$c c_c) {
        c$c c_c2 = c_c;
        int i = this.k;
        int i2 = c_c2.k;
        return i != i2 ? i - i2 : this.j - c_c2.j;
    }

    @NonNull
    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Order{order=");
        sbU.append(this.k);
        sbU.append(", index=");
        return b.d.b.a.a.A(sbU, this.j, '}');
    }

    public c$c(c$a c_a) {
    }
}

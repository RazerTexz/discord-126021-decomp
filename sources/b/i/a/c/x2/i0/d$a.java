package b.i.a.c.x2.i0;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: Atom.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d$a extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1209b;
    public final List<d$b> c;
    public final List<d$a> d;

    public d$a(int i, long j) {
        super(i);
        this.f1209b = j;
        this.c = new ArrayList();
        this.d = new ArrayList();
    }

    @Nullable
    public d$a b(int i) {
        int size = this.d.size();
        for (int i2 = 0; i2 < size; i2++) {
            d$a d_a = this.d.get(i2);
            if (d_a.a == i) {
                return d_a;
            }
        }
        return null;
    }

    @Nullable
    public d$b c(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            d$b d_b = this.c.get(i2);
            if (d_b.a == i) {
                return d_b;
            }
        }
        return null;
    }

    @Override // b.i.a.c.x2.i0.d
    public String toString() {
        String strA = d.a(this.a);
        String string = Arrays.toString(this.c.toArray());
        String string2 = Arrays.toString(this.d.toArray());
        StringBuilder sbS = b.d.b.a.a.S(b.d.b.a.a.b(string2, b.d.b.a.a.b(string, b.d.b.a.a.b(strA, 22))), strA, " leaves: ", string, " containers: ");
        sbS.append(string2);
        return sbS.toString();
    }
}

package b.f.j.p;

import java.util.Objects;

/* JADX INFO: compiled from: ThumbnailBranchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class j1 implements w0<b.f.j.j.e> {
    public final k1<b.f.j.j.e>[] a;

    public j1(k1<b.f.j.j.e>... k1VarArr) {
        Objects.requireNonNull(k1VarArr);
        this.a = k1VarArr;
        int length = k1VarArr.length;
        if (length <= 0) {
            if (length < 0) {
                throw new IllegalArgumentException(b.d.b.a.a.q("negative size: ", length));
            }
            throw new IndexOutOfBoundsException(b.c.a.a0.d.k0("%s (%s) must be less than size (%s)", "index", 0, Integer.valueOf(length)));
        }
    }

    @Override // b.f.j.p.w0
    public void b(l<b.f.j.j.e> lVar, x0 x0Var) {
        if (x0Var.e().j == null) {
            lVar.b(null, 1);
        } else {
            if (c(0, lVar, x0Var)) {
                return;
            }
            lVar.b(null, 1);
        }
    }

    public final boolean c(int i, l<b.f.j.j.e> lVar, x0 x0Var) {
        b.f.j.d.e eVar = x0Var.e().j;
        while (true) {
            k1<b.f.j.j.e>[] k1VarArr = this.a;
            if (i >= k1VarArr.length) {
                i = -1;
                break;
            }
            if (k1VarArr[i].a(eVar)) {
                break;
            }
            i++;
        }
        if (i == -1) {
            return false;
        }
        this.a[i].b(new j1$a(this, lVar, x0Var, i), x0Var);
        return true;
    }
}

package b.i.a.c.s2;

import android.util.SparseArray;
import b.i.a.c.f3.p$b;
import b.i.a.c.y1;
import java.util.Objects;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class h implements p$b {
    public final /* synthetic */ g1 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y1 f1082b;

    public /* synthetic */ h(g1 g1Var, y1 y1Var) {
        this.a = g1Var;
        this.f1082b = y1Var;
    }

    @Override // b.i.a.c.f3.p$b
    public final void a(Object obj, b.i.a.c.f3.n nVar) {
        h1 h1Var = (h1) obj;
        SparseArray<h1$a> sparseArray = this.a.n;
        SparseArray sparseArray2 = new SparseArray(nVar.c());
        for (int i = 0; i < nVar.c(); i++) {
            int iB = nVar.b(i);
            h1$a h1_a = sparseArray.get(iB);
            Objects.requireNonNull(h1_a);
            sparseArray2.append(iB, h1_a);
        }
        h1Var.K();
    }
}

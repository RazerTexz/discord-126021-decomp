package b.f.j.p;

import android.util.Pair;
import java.util.Objects;

/* JADX INFO: compiled from: ThrottlingProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class i1$b$a implements Runnable {
    public final /* synthetic */ Pair j;
    public final /* synthetic */ i1$b k;

    public i1$b$a(i1$b i1_b, Pair pair) {
        this.k = i1_b;
        this.j = pair;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // java.lang.Runnable
    public void run() {
        i1 i1Var = this.k.c;
        Pair pair = this.j;
        l lVar = (l) pair.first;
        x0 x0Var = (x0) pair.second;
        Objects.requireNonNull(i1Var);
        x0Var.o().j(x0Var, "ThrottlingProducer", null);
        i1Var.a.b(new i1$b(i1Var, lVar, null), x0Var);
    }
}

package b.i.a.f.i.b;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class j9 implements Runnable {
    public final /* synthetic */ r9 j;
    public final /* synthetic */ k9 k;

    public j9(k9 k9Var, r9 r9Var) {
        this.k = k9Var;
        this.j = r9Var;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        k9 k9Var = this.k;
        k9Var.k.f().b();
        g gVar = new g(k9Var);
        gVar.o();
        k9Var.d = gVar;
        k9Var.k.h.c = k9Var.f1542b;
        q8 q8Var = new q8(k9Var);
        q8Var.o();
        k9Var.j = q8Var;
        ba baVar = new ba(k9Var);
        baVar.o();
        k9Var.g = baVar;
        g7 g7Var = new g7(k9Var);
        g7Var.o();
        k9Var.i = g7Var;
        h9 h9Var = new h9(k9Var);
        h9Var.o();
        k9Var.f = h9Var;
        k9Var.e = new b4(k9Var);
        if (k9Var.p != k9Var.q) {
            k9Var.k.g().f.c("Not all upload components initialized", Integer.valueOf(k9Var.p), Integer.valueOf(k9Var.q));
        }
        k9Var.l = true;
        k9 k9Var2 = this.k;
        k9Var2.k.f().b();
        k9Var2.K().i0();
        if (k9Var2.k.o().f.a() == 0) {
            h4 h4Var = k9Var2.k.o().f;
            Objects.requireNonNull((b.i.a.f.e.o.c) k9Var2.k.o);
            h4Var.b(System.currentTimeMillis());
        }
        k9Var2.w();
    }
}

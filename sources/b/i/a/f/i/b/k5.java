package b.i.a.f.i.b;

import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.measurement.internal.zzn;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class k5 implements Runnable {
    public final /* synthetic */ zzn j;
    public final /* synthetic */ z4 k;

    public k5(z4 z4Var, zzn zznVar) {
        this.k = z4Var;
        this.j = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        this.k.a.R();
        k9 k9Var = this.k.a;
        zzn zznVar = this.j;
        if (b.i.a.f.h.l.t8.b() && k9Var.k.h.o(p.J0)) {
            k9Var.f().b();
            k9Var.P();
            AnimatableValueParser.w(zznVar.j);
            d dVarB = d.b(zznVar.F);
            d dVarA = k9Var.a(zznVar.j);
            k9Var.g().n.c("Setting consent, package, consent", zznVar.j, dVarB);
            k9Var.s(zznVar.j, dVarB);
            if (dVarB.f(dVarA)) {
                k9Var.p(zznVar);
            }
        }
    }
}

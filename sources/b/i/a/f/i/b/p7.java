package b.i.a.f.i.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class p7 extends i {
    public final /* synthetic */ q7 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p7(q7 q7Var, t5 t5Var) {
        super(t5Var);
        this.e = q7Var;
    }

    @Override // b.i.a.f.i.b.i
    public final void a() {
        q7 q7Var = this.e;
        q7Var.b();
        if (q7Var.B()) {
            q7Var.g().n.a("Inactivity, disconnecting from the service");
            q7Var.D();
        }
    }
}

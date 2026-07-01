package b.i.a.f.i.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class g9 extends i {
    public final /* synthetic */ k9 e;
    public final /* synthetic */ h9 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g9(h9 h9Var, t5 t5Var, k9 k9Var) {
        super(t5Var);
        this.f = h9Var;
        this.e = k9Var;
    }

    @Override // b.i.a.f.i.b.i
    public final void a() {
        this.f.s();
        this.f.g().n.a("Starting upload from DelayedRunnable");
        this.e.Q();
    }
}

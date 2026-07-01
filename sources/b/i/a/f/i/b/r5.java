package b.i.a.f.i.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r5 extends s5 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1566b;

    public r5(u4 u4Var) {
        super(u4Var);
        this.a.F++;
    }

    public void m() {
    }

    public final boolean n() {
        return this.f1566b;
    }

    public final void o() {
        if (!n()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void p() {
        if (this.f1566b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (r()) {
            return;
        }
        this.a.G.incrementAndGet();
        this.f1566b = true;
    }

    public final void q() {
        if (this.f1566b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        m();
        this.a.G.incrementAndGet();
        this.f1566b = true;
    }

    public abstract boolean r();
}

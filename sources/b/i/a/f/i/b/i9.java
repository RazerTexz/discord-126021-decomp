package b.i.a.f.i.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i9 extends s5 implements t5 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k9 f1538b;
    public boolean c;

    public i9(k9 k9Var) {
        super(k9Var.k);
        this.f1538b = k9Var;
        k9Var.p++;
    }

    public q9 m() {
        return this.f1538b.N();
    }

    public final void n() {
        if (!this.c) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void o() {
        if (this.c) {
            throw new IllegalStateException("Can't initialize twice");
        }
        p();
        this.f1538b.q++;
        this.c = true;
    }

    public abstract boolean p();

    public g q() {
        return this.f1538b.K();
    }

    public p4 r() {
        return this.f1538b.H();
    }
}

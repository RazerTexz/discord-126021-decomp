package p007b.p225i.p226a.p288f.p330i.p332b;

/* JADX INFO: renamed from: b.i.a.f.i.b.r5 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4170r5 extends C4181s5 {

    /* JADX INFO: renamed from: b */
    public boolean f11176b;

    public AbstractC4170r5(C4202u4 c4202u4) {
        super(c4202u4);
        this.f11202a.f11251F++;
    }

    /* JADX INFO: renamed from: m */
    public void mo5573m() {
    }

    /* JADX INFO: renamed from: n */
    public final boolean m5856n() {
        return this.f11176b;
    }

    /* JADX INFO: renamed from: o */
    public final void m5857o() {
        if (!m5856n()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    /* JADX INFO: renamed from: p */
    public final void m5858p() {
        if (this.f11176b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (mo5574r()) {
            return;
        }
        this.f11202a.f11252G.incrementAndGet();
        this.f11176b = true;
    }

    /* JADX INFO: renamed from: q */
    public final void m5859q() {
        if (this.f11176b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        mo5573m();
        this.f11202a.f11252G.incrementAndGet();
        this.f11176b = true;
    }

    /* JADX INFO: renamed from: r */
    public abstract boolean mo5574r();
}

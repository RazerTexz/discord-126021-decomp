package p007b.p225i.p226a.p288f.p330i.p332b;

/* JADX INFO: renamed from: b.i.a.f.i.b.i9 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4074i9 extends C4181s5 implements InterfaceC4192t5 {

    /* JADX INFO: renamed from: b */
    public final C4097k9 f10827b;

    /* JADX INFO: renamed from: c */
    public boolean f10828c;

    public AbstractC4074i9(C4097k9 c4097k9) {
        super(c4097k9.f10906k);
        this.f10827b = c4097k9;
        c4097k9.f10911p++;
    }

    /* JADX INFO: renamed from: m */
    public C4163q9 m5683m() {
        return this.f10827b.m5713N();
    }

    /* JADX INFO: renamed from: n */
    public final void m5684n() {
        if (!this.f10828c) {
            throw new IllegalStateException("Not initialized");
        }
    }

    /* JADX INFO: renamed from: o */
    public final void m5685o() {
        if (this.f10828c) {
            throw new IllegalStateException("Can't initialize twice");
        }
        mo5515p();
        this.f10827b.f10912q++;
        this.f10828c = true;
    }

    /* JADX INFO: renamed from: p */
    public abstract boolean mo5515p();

    /* JADX INFO: renamed from: q */
    public C4040g m5686q() {
        return this.f10827b.m5710K();
    }

    /* JADX INFO: renamed from: r */
    public C4147p4 m5687r() {
        return this.f10827b.m5707H();
    }
}

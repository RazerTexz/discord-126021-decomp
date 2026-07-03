package p007b.p225i.p226a.p242c.p245b3;

/* JADX INFO: renamed from: b.i.a.c.b3.e */
/* JADX INFO: compiled from: SimpleSubtitleDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2581e extends AbstractC2587k {

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ AbstractC2582f f5798n;

    public C2581e(AbstractC2582f abstractC2582f) {
        this.f5798n = abstractC2582f;
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.AbstractC2958f
    /* JADX INFO: renamed from: p */
    public void mo2611p() {
        AbstractC2582f abstractC2582f = this.f5798n;
        synchronized (abstractC2582f.f7932b) {
            m2618q();
            O[] oArr = abstractC2582f.f7936f;
            int i = abstractC2582f.f7938h;
            abstractC2582f.f7938h = i + 1;
            oArr[i] = this;
            abstractC2582f.m3558g();
        }
    }
}

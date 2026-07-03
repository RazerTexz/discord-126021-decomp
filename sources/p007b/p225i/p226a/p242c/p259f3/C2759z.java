package p007b.p225i.p226a.p242c.p259f3;

import p007b.p225i.p226a.p242c.C2998x1;

/* JADX INFO: renamed from: b.i.a.c.f3.z */
/* JADX INFO: compiled from: StandaloneMediaClock.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2759z implements InterfaceC2752s {

    /* JADX INFO: renamed from: j */
    public final InterfaceC2740g f6800j;

    /* JADX INFO: renamed from: k */
    public boolean f6801k;

    /* JADX INFO: renamed from: l */
    public long f6802l;

    /* JADX INFO: renamed from: m */
    public long f6803m;

    /* JADX INFO: renamed from: n */
    public C2998x1 f6804n = C2998x1.f8026j;

    public C2759z(InterfaceC2740g interfaceC2740g) {
        this.f6800j = interfaceC2740g;
    }

    /* JADX INFO: renamed from: a */
    public void m3117a(long j) {
        this.f6802l = j;
        if (this.f6801k) {
            this.f6803m = this.f6800j.mo2952d();
        }
    }

    /* JADX INFO: renamed from: b */
    public void m3118b() {
        if (this.f6801k) {
            return;
        }
        this.f6803m = this.f6800j.mo2952d();
        this.f6801k = true;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.InterfaceC2752s
    /* JADX INFO: renamed from: c */
    public C2998x1 mo2416c() {
        return this.f6804n;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.InterfaceC2752s
    /* JADX INFO: renamed from: e */
    public long mo2417e() {
        long j = this.f6802l;
        if (!this.f6801k) {
            return j;
        }
        long jMo2952d = this.f6800j.mo2952d() - this.f6803m;
        C2998x1 c2998x1 = this.f6804n;
        return c2998x1.f8027k == 1.0f ? j + C2738e0.m2981B(jMo2952d) : j + (jMo2952d * ((long) c2998x1.f8029m));
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.InterfaceC2752s
    /* JADX INFO: renamed from: i */
    public void mo2418i(C2998x1 c2998x1) {
        if (this.f6801k) {
            m3117a(mo2417e());
        }
        this.f6804n = c2998x1;
    }
}

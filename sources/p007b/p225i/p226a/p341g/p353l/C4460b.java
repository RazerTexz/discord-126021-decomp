package p007b.p225i.p226a.p341g.p353l;

import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.g.l.b */
/* JADX INFO: compiled from: FadeModeEvaluators.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4460b {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC4459a f11894a = new a();

    /* JADX INFO: renamed from: b */
    public static final InterfaceC4459a f11895b = new b();

    /* JADX INFO: renamed from: c */
    public static final InterfaceC4459a f11896c = new c();

    /* JADX INFO: renamed from: d */
    public static final InterfaceC4459a f11897d = new d();

    /* JADX INFO: renamed from: b.i.a.g.l.b$a */
    /* JADX INFO: compiled from: FadeModeEvaluators.java */
    public static class a implements InterfaceC4459a {
        @Override // p007b.p225i.p226a.p341g.p353l.InterfaceC4459a
        /* JADX INFO: renamed from: a */
        public C4461c mo6181a(float f, float f2, float f3) {
            return new C4461c(255, C4469k.m6192g(0, 255, f2, f3, f), true);
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.l.b$b */
    /* JADX INFO: compiled from: FadeModeEvaluators.java */
    public static class b implements InterfaceC4459a {
        @Override // p007b.p225i.p226a.p341g.p353l.InterfaceC4459a
        /* JADX INFO: renamed from: a */
        public C4461c mo6181a(float f, float f2, float f3) {
            return C4461c.m6182a(C4469k.m6192g(255, 0, f2, f3, f), 255);
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.l.b$c */
    /* JADX INFO: compiled from: FadeModeEvaluators.java */
    public static class c implements InterfaceC4459a {
        @Override // p007b.p225i.p226a.p341g.p353l.InterfaceC4459a
        /* JADX INFO: renamed from: a */
        public C4461c mo6181a(float f, float f2, float f3) {
            return C4461c.m6182a(C4469k.m6192g(255, 0, f2, f3, f), C4469k.m6192g(0, 255, f2, f3, f));
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.l.b$d */
    /* JADX INFO: compiled from: FadeModeEvaluators.java */
    public static class d implements InterfaceC4459a {
        @Override // p007b.p225i.p226a.p341g.p353l.InterfaceC4459a
        /* JADX INFO: renamed from: a */
        public C4461c mo6181a(float f, float f2, float f3) {
            float fM839a = C1643a.m839a(f3, f2, 0.35f, f2);
            return C4461c.m6182a(C4469k.m6192g(255, 0, f2, fM839a, f), C4469k.m6192g(0, 255, fM839a, f3, f));
        }
    }
}

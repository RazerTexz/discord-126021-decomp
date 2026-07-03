package p007b.p225i.p226a.p341g.p353l.p354l;

import androidx.annotation.RequiresApi;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.g.l.l.b */
/* JADX INFO: compiled from: FadeModeEvaluators.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class C4471b {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC4470a f11916a = new a();

    /* JADX INFO: renamed from: b */
    public static final InterfaceC4470a f11917b = new b();

    /* JADX INFO: renamed from: c */
    public static final InterfaceC4470a f11918c = new c();

    /* JADX INFO: renamed from: d */
    public static final InterfaceC4470a f11919d = new d();

    /* JADX INFO: renamed from: b.i.a.g.l.l.b$a */
    /* JADX INFO: compiled from: FadeModeEvaluators.java */
    public static class a implements InterfaceC4470a {
        @Override // p007b.p225i.p226a.p341g.p353l.p354l.InterfaceC4470a
        /* JADX INFO: renamed from: a */
        public C4472c mo6195a(float f, float f2, float f3) {
            return new C4472c(255, C4480k.m6206g(0, 255, f2, f3, f), true);
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.l.l.b$b */
    /* JADX INFO: compiled from: FadeModeEvaluators.java */
    public static class b implements InterfaceC4470a {
        @Override // p007b.p225i.p226a.p341g.p353l.p354l.InterfaceC4470a
        /* JADX INFO: renamed from: a */
        public C4472c mo6195a(float f, float f2, float f3) {
            return C4472c.m6196a(C4480k.m6206g(255, 0, f2, f3, f), 255);
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.l.l.b$c */
    /* JADX INFO: compiled from: FadeModeEvaluators.java */
    public static class c implements InterfaceC4470a {
        @Override // p007b.p225i.p226a.p341g.p353l.p354l.InterfaceC4470a
        /* JADX INFO: renamed from: a */
        public C4472c mo6195a(float f, float f2, float f3) {
            return C4472c.m6196a(C4480k.m6206g(255, 0, f2, f3, f), C4480k.m6206g(0, 255, f2, f3, f));
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.l.l.b$d */
    /* JADX INFO: compiled from: FadeModeEvaluators.java */
    public static class d implements InterfaceC4470a {
        @Override // p007b.p225i.p226a.p341g.p353l.p354l.InterfaceC4470a
        /* JADX INFO: renamed from: a */
        public C4472c mo6195a(float f, float f2, float f3) {
            float fM839a = C1643a.m839a(f3, f2, 0.35f, f2);
            return C4472c.m6196a(C4480k.m6206g(255, 0, f2, fM839a, f), C4480k.m6206g(0, 255, fM839a, f3, f));
        }
    }
}

package p007b.p225i.p226a.p288f.p313h.p325l;

/* JADX INFO: renamed from: b.i.a.f.h.l.ra */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3818ra implements InterfaceC3779oa {

    /* JADX INFO: renamed from: a */
    public static final AbstractC3732l2<Boolean> f10297a;

    /* JADX INFO: renamed from: b */
    public static final AbstractC3732l2<Boolean> f10298b;

    static {
        C3797q2 c3797q2 = new C3797q2(C3692i2.m4961a("com.google.android.gms.measurement"));
        f10297a = c3797q2.m5184c("measurement.sdk.screen.manual_screen_view_logging", true);
        f10298b = c3797q2.m5184c("measurement.sdk.screen.disabling_automatic_reporting", true);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3779oa
    /* JADX INFO: renamed from: a */
    public final boolean mo5158a() {
        return true;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3779oa
    /* JADX INFO: renamed from: b */
    public final boolean mo5159b() {
        return f10297a.m5050d().booleanValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3779oa
    /* JADX INFO: renamed from: c */
    public final boolean mo5160c() {
        return f10298b.m5050d().booleanValue();
    }
}

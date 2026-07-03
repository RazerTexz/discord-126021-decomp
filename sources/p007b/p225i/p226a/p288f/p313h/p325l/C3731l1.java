package p007b.p225i.p226a.p288f.p313h.p325l;

/* JADX INFO: renamed from: b.i.a.f.h.l.l1 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3731l1 implements InterfaceC3583a5 {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC3583a5 f10068a = new C3731l1();

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3583a5
    /* JADX INFO: renamed from: f */
    public final boolean mo4556f(int i) {
        EnumC3705j1 enumC3705j1;
        if (i == 0) {
            enumC3705j1 = EnumC3705j1.AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_UNKNOWN;
        } else if (i == 1) {
            enumC3705j1 = EnumC3705j1.AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_RESTRICTED;
        } else if (i == 2) {
            enumC3705j1 = EnumC3705j1.AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_DENIED;
        } else if (i == 3) {
            enumC3705j1 = EnumC3705j1.AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_AUTHORIZED;
        } else if (i != 4) {
            enumC3705j1 = i != 5 ? null : EnumC3705j1.AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_NOT_CONFIGURED;
        } else {
            enumC3705j1 = EnumC3705j1.AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_NOT_DETERMINED;
        }
        return enumC3705j1 != null;
    }
}

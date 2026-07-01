package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class l1 implements a5 {
    public static final a5 a = new l1();

    @Override // b.i.a.f.h.l.a5
    public final boolean f(int i) {
        j1 j1Var;
        if (i == 0) {
            j1Var = j1.AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_UNKNOWN;
        } else if (i == 1) {
            j1Var = j1.AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_RESTRICTED;
        } else if (i == 2) {
            j1Var = j1.AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_DENIED;
        } else if (i == 3) {
            j1Var = j1.AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_AUTHORIZED;
        } else if (i != 4) {
            j1Var = i != 5 ? null : j1.AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_NOT_CONFIGURED;
        } else {
            j1Var = j1.AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_NOT_DETERMINED;
        }
        return j1Var != null;
    }
}

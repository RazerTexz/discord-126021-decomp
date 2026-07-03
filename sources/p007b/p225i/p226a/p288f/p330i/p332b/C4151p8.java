package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4195t8;

/* JADX INFO: renamed from: b.i.a.f.i.b.p8 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4151p8<T extends Context & InterfaceC4195t8> {

    /* JADX INFO: renamed from: a */
    public final T f11131a;

    public C4151p8(T t) {
        this.f11131a = t;
    }

    @MainThread
    /* JADX INFO: renamed from: a */
    public final boolean m5785a(Intent intent) {
        if (intent == null) {
            m5786b().f11141f.m5860a("onUnbind called with null intent");
            return true;
        }
        m5786b().f11149n.m5861b("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    /* JADX INFO: renamed from: b */
    public final C4157q3 m5786b() {
        return C4202u4.m5933b(this.f11131a, null, null).mo5726g();
    }

    @MainThread
    /* JADX INFO: renamed from: c */
    public final void m5787c(Intent intent) {
        if (intent == null) {
            m5786b().f11141f.m5860a("onRebind called with null intent");
        } else {
            m5786b().f11149n.m5861b("onRebind called. action", intent.getAction());
        }
    }
}

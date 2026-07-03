package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.Bundle;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzz;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p313h.p325l.C3893x7;

/* JADX INFO: renamed from: b.i.a.f.i.b.n6 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4127n6 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Bundle f10993j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C3999c6 f10994k;

    public RunnableC4127n6(C3999c6 c3999c6, Bundle bundle) {
        this.f10994k = c3999c6;
        this.f10993j = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C3999c6 c3999c6 = this.f10994k;
        Bundle bundle = this.f10993j;
        c3999c6.mo5848b();
        c3999c6.m5497t();
        Objects.requireNonNull(bundle, "null reference");
        C1460d.m583w(bundle.getString(ModelAuditLogEntry.CHANGE_KEY_NAME));
        C1460d.m583w(bundle.getString("origin"));
        Objects.requireNonNull(bundle.get("value"), "null reference");
        if (!c3999c6.f11202a.m5940d()) {
            c3999c6.mo5726g().f11149n.m5860a("Conditional property not set since app measurement is disabled");
            return;
        }
        try {
            c3999c6.m5971p().m5813y(new zzz(bundle.getString("app_id"), bundle.getString("origin"), new zzku(bundle.getString(ModelAuditLogEntry.CHANGE_KEY_NAME), bundle.getLong("triggered_timestamp"), bundle.get("value"), bundle.getString("origin")), bundle.getLong("creation_timestamp"), false, bundle.getString("trigger_event_name"), c3999c6.m5866e().m5890B(bundle.getString("app_id"), bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), bundle.getString("origin"), 0L, true, C3893x7.m5362b() && c3999c6.f11202a.f11260h.m5526o(C4142p.f11043L0)), bundle.getLong("trigger_timeout"), c3999c6.m5866e().m5890B(bundle.getString("app_id"), bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), bundle.getString("origin"), 0L, true, C3893x7.m5362b() && c3999c6.f11202a.f11260h.m5526o(C4142p.f11043L0)), bundle.getLong("time_to_live"), c3999c6.m5866e().m5890B(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), bundle.getString("origin"), 0L, true, C3893x7.m5362b() && c3999c6.f11202a.f11260h.m5526o(C4142p.f11043L0))));
        } catch (IllegalArgumentException unused) {
        }
    }
}

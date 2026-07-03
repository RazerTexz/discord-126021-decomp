package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.Bundle;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzz;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p313h.p325l.C3893x7;

/* JADX INFO: renamed from: b.i.a.f.i.b.p6 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4149p6 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Bundle f11128j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C3999c6 f11129k;

    public RunnableC4149p6(C3999c6 c3999c6, Bundle bundle) {
        this.f11129k = c3999c6;
        this.f11128j = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C3999c6 c3999c6 = this.f11129k;
        Bundle bundle = this.f11128j;
        c3999c6.mo5848b();
        c3999c6.m5497t();
        Objects.requireNonNull(bundle, "null reference");
        C1460d.m583w(bundle.getString(ModelAuditLogEntry.CHANGE_KEY_NAME));
        if (!c3999c6.f11202a.m5940d()) {
            c3999c6.mo5726g().f11149n.m5860a("Conditional property not cleared since app measurement is disabled");
        } else {
            try {
                c3999c6.m5971p().m5813y(new zzz(bundle.getString("app_id"), bundle.getString("origin"), new zzku(bundle.getString(ModelAuditLogEntry.CHANGE_KEY_NAME), 0L, null, null), bundle.getLong("creation_timestamp"), bundle.getBoolean("active"), bundle.getString("trigger_event_name"), null, bundle.getLong("trigger_timeout"), null, bundle.getLong("time_to_live"), c3999c6.m5866e().m5890B(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), bundle.getString("origin"), bundle.getLong("creation_timestamp"), true, C3893x7.m5362b() && c3999c6.f11202a.f11260h.m5526o(C4142p.f11043L0))));
            } catch (IllegalArgumentException unused) {
            }
        }
    }
}

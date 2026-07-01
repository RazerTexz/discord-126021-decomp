package b.i.a.f.i.b;

import android.os.Bundle;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzz;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class n6 implements Runnable {
    public final /* synthetic */ Bundle j;
    public final /* synthetic */ c6 k;

    public n6(c6 c6Var, Bundle bundle) {
        this.k = c6Var;
        this.j = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c6 c6Var = this.k;
        Bundle bundle = this.j;
        c6Var.b();
        c6Var.t();
        Objects.requireNonNull(bundle, "null reference");
        b.c.a.a0.d.w(bundle.getString(ModelAuditLogEntry.CHANGE_KEY_NAME));
        b.c.a.a0.d.w(bundle.getString("origin"));
        Objects.requireNonNull(bundle.get("value"), "null reference");
        if (!c6Var.a.d()) {
            c6Var.g().n.a("Conditional property not set since app measurement is disabled");
            return;
        }
        try {
            c6Var.p().y(new zzz(bundle.getString("app_id"), bundle.getString("origin"), new zzku(bundle.getString(ModelAuditLogEntry.CHANGE_KEY_NAME), bundle.getLong("triggered_timestamp"), bundle.get("value"), bundle.getString("origin")), bundle.getLong("creation_timestamp"), false, bundle.getString("trigger_event_name"), c6Var.e().B(bundle.getString("app_id"), bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), bundle.getString("origin"), 0L, true, b.i.a.f.h.l.x7.b() && c6Var.a.h.o(p.L0)), bundle.getLong("trigger_timeout"), c6Var.e().B(bundle.getString("app_id"), bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), bundle.getString("origin"), 0L, true, b.i.a.f.h.l.x7.b() && c6Var.a.h.o(p.L0)), bundle.getLong("time_to_live"), c6Var.e().B(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), bundle.getString("origin"), 0L, true, b.i.a.f.h.l.x7.b() && c6Var.a.h.o(p.L0))));
        } catch (IllegalArgumentException unused) {
        }
    }
}

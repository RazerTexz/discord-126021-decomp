package b.i.a.f.i.b;

import android.os.Bundle;
import b.c.a.a0.AnimatableValueParser;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzz;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class p6 implements Runnable {
    public final /* synthetic */ Bundle j;
    public final /* synthetic */ c6 k;

    public p6(c6 c6Var, Bundle bundle) {
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
        AnimatableValueParser.w(bundle.getString(ModelAuditLogEntry.CHANGE_KEY_NAME));
        if (!c6Var.a.d()) {
            c6Var.g().n.a("Conditional property not cleared since app measurement is disabled");
        } else {
            try {
                c6Var.p().y(new zzz(bundle.getString("app_id"), bundle.getString("origin"), new zzku(bundle.getString(ModelAuditLogEntry.CHANGE_KEY_NAME), 0L, null, null), bundle.getLong("creation_timestamp"), bundle.getBoolean("active"), bundle.getString("trigger_event_name"), null, bundle.getLong("trigger_timeout"), null, bundle.getLong("time_to_live"), c6Var.e().B(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), bundle.getString("origin"), bundle.getLong("creation_timestamp"), true, b.i.a.f.h.l.x7.b() && c6Var.a.h.o(p.L0))));
            } catch (IllegalArgumentException unused) {
            }
        }
    }
}

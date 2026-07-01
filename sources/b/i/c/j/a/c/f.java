package b.i.c.j.a.c;

import android.os.Bundle;
import b.i.a.f.i.a.a;
import b.i.c.m.CrashlyticsAnalyticsListener;
import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements a.InterfaceC0041a {
    public final /* synthetic */ d a;

    public f(d dVar) {
        this.a = dVar;
    }

    @Override // b.i.a.f.i.b.z5
    public final void a(String str, String str2, Bundle bundle, long j) {
        if (str == null || str.equals("crash") || !(!c.a.contains(str2))) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString(ModelAuditLogEntry.CHANGE_KEY_NAME, str2);
        bundle2.putLong("timestampInMillis", j);
        bundle2.putBundle("params", bundle);
        ((CrashlyticsAnalyticsListener) this.a.a).a(3, bundle2);
    }
}

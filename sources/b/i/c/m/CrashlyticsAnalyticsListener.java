package b.i.c.m;

import android.os.Bundle;
import androidx.annotation.Nullable;
import b.i.c.j.a.a;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.i.AnalyticsEventReceiver;
import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: renamed from: b.i.c.m.a, reason: use source file name */
/* JADX INFO: compiled from: CrashlyticsAnalyticsListener.java */
/* JADX INFO: loaded from: classes3.dex */
public class CrashlyticsAnalyticsListener implements a.b {
    public AnalyticsEventReceiver a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnalyticsEventReceiver f1672b;

    public void a(int i, @Nullable Bundle bundle) {
        Logger3.a.b("Received Analytics message: " + i + " " + bundle);
        String string = bundle.getString(ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (string != null) {
            Bundle bundle2 = bundle.getBundle("params");
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            AnalyticsEventReceiver analyticsEventReceiver = "clx".equals(bundle2.getString("_o")) ? this.a : this.f1672b;
            if (analyticsEventReceiver == null) {
                return;
            }
            analyticsEventReceiver.b(string, bundle2);
        }
    }
}

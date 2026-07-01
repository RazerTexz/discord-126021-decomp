package b.i.c.m;

import android.os.Bundle;
import androidx.annotation.Nullable;
import b.i.c.j.a.a$b;
import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: CrashlyticsAnalyticsListener.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements a$b {
    public b.i.c.m.d.i.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b.i.c.m.d.i.b f1672b;

    public void a(int i, @Nullable Bundle bundle) {
        b.i.c.m.d.b.a.b("Received Analytics message: " + i + " " + bundle);
        String string = bundle.getString(ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (string != null) {
            Bundle bundle2 = bundle.getBundle("params");
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            b.i.c.m.d.i.b bVar = "clx".equals(bundle2.getString("_o")) ? this.a : this.f1672b;
            if (bVar == null) {
                return;
            }
            bVar.b(string, bundle2);
        }
    }
}

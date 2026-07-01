package b.i.c.m.d.i;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.j.BreadcrumbSource;
import b.i.c.m.d.k.CrashlyticsCore;
import b.i.c.m.d.k.CrashlyticsCore3;
import b.i.c.m.d.k.n;
import b.i.c.m.d.k.x;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: b.i.c.m.d.i.d, reason: use source file name */
/* JADX INFO: compiled from: BreadcrumbAnalyticsEventReceiver.java */
/* JADX INFO: loaded from: classes3.dex */
public class BreadcrumbAnalyticsEventReceiver implements AnalyticsEventReceiver, BreadcrumbSource {

    @Nullable
    public CrashlyticsCore a;

    @NonNull
    public static String c(@NonNull String str, @NonNull Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : bundle.keySet()) {
            jSONObject2.put(str2, bundle.get(str2));
        }
        jSONObject.put(ModelAuditLogEntry.CHANGE_KEY_NAME, str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }

    @Override // b.i.c.m.d.j.BreadcrumbSource
    public void a(@Nullable CrashlyticsCore crashlyticsCore) {
        this.a = crashlyticsCore;
        Logger3.a.b("Registered Firebase Analytics event receiver for breadcrumbs");
    }

    @Override // b.i.c.m.d.i.AnalyticsEventReceiver
    public void b(@NonNull String str, @NonNull Bundle bundle) {
        CrashlyticsCore crashlyticsCore = this.a;
        if (crashlyticsCore != null) {
            try {
                String str2 = "$A$:" + c(str, bundle);
                CrashlyticsCore3 crashlyticsCore3 = crashlyticsCore.a;
                Objects.requireNonNull(crashlyticsCore3);
                long jCurrentTimeMillis = System.currentTimeMillis() - crashlyticsCore3.d;
                x xVar = crashlyticsCore3.h;
                xVar.m.b(new n(xVar, jCurrentTimeMillis, str2));
            } catch (JSONException unused) {
                Logger3.a.g("Unable to serialize Firebase Analytics event to breadcrumb.");
            }
        }
    }
}

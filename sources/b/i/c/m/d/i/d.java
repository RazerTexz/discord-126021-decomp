package b.i.c.m.d.i;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.c.m.d.k.i0;
import b.i.c.m.d.k.k0;
import b.i.c.m.d.k.n;
import b.i.c.m.d.k.x;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: BreadcrumbAnalyticsEventReceiver.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements b, b.i.c.m.d.j.a {

    @Nullable
    public i0 a;

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

    @Override // b.i.c.m.d.j.a
    public void a(@Nullable i0 i0Var) {
        this.a = i0Var;
        b.i.c.m.d.b.a.b("Registered Firebase Analytics event receiver for breadcrumbs");
    }

    @Override // b.i.c.m.d.i.b
    public void b(@NonNull String str, @NonNull Bundle bundle) {
        i0 i0Var = this.a;
        if (i0Var != null) {
            try {
                String str2 = "$A$:" + c(str, bundle);
                k0 k0Var = i0Var.a;
                Objects.requireNonNull(k0Var);
                long jCurrentTimeMillis = System.currentTimeMillis() - k0Var.d;
                x xVar = k0Var.h;
                xVar.m.b(new n(xVar, jCurrentTimeMillis, str2));
            } catch (JSONException unused) {
                b.i.c.m.d.b.a.g("Unable to serialize Firebase Analytics event to breadcrumb.");
            }
        }
    }
}

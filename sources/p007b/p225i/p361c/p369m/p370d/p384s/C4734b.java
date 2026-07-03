package p007b.p225i.p361c.p369m.p370d.p384s;

import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;
import p007b.p225i.p361c.p369m.p370d.p373k.C4621e1;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.C4741b;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.C4742c;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.C4743d;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.C4745f;

/* JADX INFO: renamed from: b.i.c.m.d.s.b */
/* JADX INFO: compiled from: DefaultSettingsJsonTransform.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4734b implements InterfaceC4738f {
    /* JADX INFO: renamed from: b */
    public static long m6681b(C4621e1 c4621e1, long j, JSONObject jSONObject) {
        if (jSONObject.has("expires_at")) {
            return jSONObject.optLong("expires_at");
        }
        Objects.requireNonNull(c4621e1);
        return (j * 1000) + System.currentTimeMillis();
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p384s.InterfaceC4738f
    /* JADX INFO: renamed from: a */
    public C4745f mo6682a(C4621e1 c4621e1, JSONObject jSONObject) throws JSONException {
        int iOptInt = jSONObject.optInt("settings_version", 0);
        int iOptInt2 = jSONObject.optInt("cache_duration", 3600);
        JSONObject jSONObject2 = jSONObject.getJSONObject("app");
        return new C4745f(m6681b(c4621e1, iOptInt2, jSONObject), new C4741b(jSONObject2.getString("status"), jSONObject2.getString("url"), jSONObject2.getString("reports_url"), jSONObject2.getString("ndk_reports_url"), jSONObject2.optBoolean("update_required", false)), new C4743d(jSONObject.getJSONObject("session").optInt("max_custom_exception_events", 8), 4), new C4742c(jSONObject.getJSONObject("features").optBoolean("collect_reports", true)), iOptInt, iOptInt2);
    }
}

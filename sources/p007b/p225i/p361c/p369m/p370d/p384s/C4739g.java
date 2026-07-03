package p007b.p225i.p361c.p369m.p370d.p384s;

import java.util.Locale;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;
import p007b.p225i.p361c.p369m.p370d.p373k.C4621e1;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.C4741b;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.C4742c;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.C4743d;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.C4745f;

/* JADX INFO: renamed from: b.i.c.m.d.s.g */
/* JADX INFO: compiled from: SettingsV3JsonTransform.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4739g implements InterfaceC4738f {
    @Override // p007b.p225i.p361c.p369m.p370d.p384s.InterfaceC4738f
    /* JADX INFO: renamed from: a */
    public C4745f mo6682a(C4621e1 c4621e1, JSONObject jSONObject) throws JSONException {
        long jCurrentTimeMillis;
        int iOptInt = jSONObject.optInt("settings_version", 0);
        int iOptInt2 = jSONObject.optInt("cache_duration", 3600);
        JSONObject jSONObject2 = jSONObject.getJSONObject("fabric");
        JSONObject jSONObject3 = jSONObject.getJSONObject("app");
        String string = jSONObject3.getString("status");
        boolean zEquals = "new".equals(string);
        String string2 = jSONObject2.getString("bundle_id");
        String string3 = jSONObject2.getString("org_id");
        String str = zEquals ? "https://update.crashlytics.com/spi/v1/platforms/android/apps" : String.format(Locale.US, "https://update.crashlytics.com/spi/v1/platforms/android/apps/%s", string2);
        Locale locale = Locale.US;
        C4741b c4741b = new C4741b(string, str, String.format(locale, "https://reports.crashlytics.com/spi/v1/platforms/android/apps/%s/reports", string2), String.format(locale, "https://reports.crashlytics.com/sdk-api/v1/platforms/android/apps/%s/minidumps", string2), string2, string3, jSONObject3.optBoolean("update_required", false), jSONObject3.optInt("report_upload_variant", 0), jSONObject3.optInt("native_report_upload_variant", 0));
        C4743d c4743d = new C4743d(8, 4);
        C4742c c4742c = new C4742c(jSONObject.getJSONObject("features").optBoolean("collect_reports", true));
        long j = iOptInt2;
        if (jSONObject.has("expires_at")) {
            jCurrentTimeMillis = jSONObject.optLong("expires_at");
        } else {
            Objects.requireNonNull(c4621e1);
            jCurrentTimeMillis = (j * 1000) + System.currentTimeMillis();
        }
        return new C4745f(jCurrentTimeMillis, c4741b, c4743d, c4742c, iOptInt, iOptInt2);
    }
}

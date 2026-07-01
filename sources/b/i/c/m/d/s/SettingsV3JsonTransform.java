package b.i.c.m.d.s;

import b.i.c.m.d.k.SystemCurrentTimeProvider;
import b.i.c.m.d.s.h.AppSettingsData;
import b.i.c.m.d.s.h.FeaturesSettingsData;
import b.i.c.m.d.s.h.SessionSettingsData;
import b.i.c.m.d.s.h.SettingsData;
import java.util.Locale;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: b.i.c.m.d.s.g, reason: use source file name */
/* JADX INFO: compiled from: SettingsV3JsonTransform.java */
/* JADX INFO: loaded from: classes3.dex */
public class SettingsV3JsonTransform implements SettingsJsonTransform {
    @Override // b.i.c.m.d.s.SettingsJsonTransform
    public SettingsData a(SystemCurrentTimeProvider systemCurrentTimeProvider, JSONObject jSONObject) throws JSONException {
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
        AppSettingsData appSettingsData = new AppSettingsData(string, str, String.format(locale, "https://reports.crashlytics.com/spi/v1/platforms/android/apps/%s/reports", string2), String.format(locale, "https://reports.crashlytics.com/sdk-api/v1/platforms/android/apps/%s/minidumps", string2), string2, string3, jSONObject3.optBoolean("update_required", false), jSONObject3.optInt("report_upload_variant", 0), jSONObject3.optInt("native_report_upload_variant", 0));
        SessionSettingsData sessionSettingsData = new SessionSettingsData(8, 4);
        FeaturesSettingsData featuresSettingsData = new FeaturesSettingsData(jSONObject.getJSONObject("features").optBoolean("collect_reports", true));
        long j = iOptInt2;
        if (jSONObject.has("expires_at")) {
            jCurrentTimeMillis = jSONObject.optLong("expires_at");
        } else {
            Objects.requireNonNull(systemCurrentTimeProvider);
            jCurrentTimeMillis = (j * 1000) + System.currentTimeMillis();
        }
        return new SettingsData(jCurrentTimeMillis, appSettingsData, sessionSettingsData, featuresSettingsData, iOptInt, iOptInt2);
    }
}

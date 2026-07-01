package b.i.c.m.d.s;

import b.i.c.m.d.k.SystemCurrentTimeProvider;
import b.i.c.m.d.s.h.SettingsData;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: b.i.c.m.d.s.e, reason: use source file name */
/* JADX INFO: compiled from: SettingsJsonParser.java */
/* JADX INFO: loaded from: classes3.dex */
public class SettingsJsonParser {
    public final SystemCurrentTimeProvider a;

    public SettingsJsonParser(SystemCurrentTimeProvider systemCurrentTimeProvider) {
        this.a = systemCurrentTimeProvider;
    }

    public SettingsData a(JSONObject jSONObject) throws JSONException {
        return (jSONObject.getInt("settings_version") != 3 ? new DefaultSettingsJsonTransform() : new SettingsV3JsonTransform()).a(this.a, jSONObject);
    }
}

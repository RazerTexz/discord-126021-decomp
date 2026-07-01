package b.i.c.m.d.s;

import b.i.c.m.d.k.e1;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SettingsJsonParser.java */
/* JADX INFO: loaded from: classes3.dex */
public class e {
    public final e1 a;

    public e(e1 e1Var) {
        this.a = e1Var;
    }

    public b.i.c.m.d.s.h.f a(JSONObject jSONObject) throws JSONException {
        return (jSONObject.getInt("settings_version") != 3 ? new b() : new g()).a(this.a, jSONObject);
    }
}

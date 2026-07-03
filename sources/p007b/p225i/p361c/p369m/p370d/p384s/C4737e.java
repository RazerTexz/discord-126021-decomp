package p007b.p225i.p361c.p369m.p370d.p384s;

import org.json.JSONException;
import org.json.JSONObject;
import p007b.p225i.p361c.p369m.p370d.p373k.C4621e1;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.C4745f;

/* JADX INFO: renamed from: b.i.c.m.d.s.e */
/* JADX INFO: compiled from: SettingsJsonParser.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4737e {

    /* JADX INFO: renamed from: a */
    public final C4621e1 f12739a;

    public C4737e(C4621e1 c4621e1) {
        this.f12739a = c4621e1;
    }

    /* JADX INFO: renamed from: a */
    public C4745f m6688a(JSONObject jSONObject) throws JSONException {
        return (jSONObject.getInt("settings_version") != 3 ? new C4734b() : new C4739g()).mo6682a(this.f12739a, jSONObject);
    }
}

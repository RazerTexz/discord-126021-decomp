package p007b.p225i.p361c.p369m.p370d.p384s;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import org.json.JSONObject;
import p007b.p225i.p361c.p369m.p370d.C4592b;
import p007b.p225i.p361c.p369m.p370d.p373k.C4628h;
import p007b.p225i.p361c.p369m.p370d.p378o.C4715h;

/* JADX INFO: renamed from: b.i.c.m.d.s.a */
/* JADX INFO: compiled from: CachedSettingsIo.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4733a {

    /* JADX INFO: renamed from: a */
    public final Context f12728a;

    public C4733a(Context context) {
        this.f12728a = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX INFO: renamed from: a */
    public JSONObject m6680a() throws Throwable {
        Exception e;
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        C4592b c4592b = C4592b.f12227a;
        c4592b.m6371b("Reading cached settings...");
        ?? r2 = 0;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                File file = new File(new C4715h(this.f12728a).m6636a(), "com.crashlytics.settings.json");
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        jSONObject = new JSONObject(C4628h.m6430x(fileInputStream));
                        fileInputStream2 = fileInputStream;
                    } catch (Exception e2) {
                        e = e2;
                        if (C4592b.f12227a.m6370a(6)) {
                            Log.e("FirebaseCrashlytics", "Failed to fetch cached settings", e);
                        }
                        C4628h.m6409c(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    }
                } else {
                    c4592b.m6371b("No cached settings found.");
                    jSONObject = null;
                }
                C4628h.m6409c(fileInputStream2, "Error while closing settings cache file.");
                return jSONObject;
            } catch (Throwable th) {
                r2 = c4592b;
                th = th;
                C4628h.m6409c(r2, "Error while closing settings cache file.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            C4628h.m6409c(r2, "Error while closing settings cache file.");
            throw th;
        }
    }
}

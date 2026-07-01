package b.i.c.m.d.s;

import android.content.Context;
import android.util.Log;
import b.i.c.m.d.o.h;
import java.io.File;
import java.io.FileInputStream;
import org.json.JSONObject;

/* JADX INFO: compiled from: CachedSettingsIo.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public final Context a;

    public a(Context context) {
        this.a = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public JSONObject a() throws Throwable {
        Exception e;
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
        bVar.b("Reading cached settings...");
        ?? r2 = 0;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                File file = new File(new h(this.a).a(), "com.crashlytics.settings.json");
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        jSONObject = new JSONObject(b.i.c.m.d.k.h.x(fileInputStream));
                        fileInputStream2 = fileInputStream;
                    } catch (Exception e2) {
                        e = e2;
                        if (b.i.c.m.d.b.a.a(6)) {
                            Log.e("FirebaseCrashlytics", "Failed to fetch cached settings", e);
                        }
                        b.i.c.m.d.k.h.c(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    }
                } else {
                    bVar.b("No cached settings found.");
                    jSONObject = null;
                }
                b.i.c.m.d.k.h.c(fileInputStream2, "Error while closing settings cache file.");
                return jSONObject;
            } catch (Throwable th) {
                r2 = bVar;
                th = th;
                b.i.c.m.d.k.h.c(r2, "Error while closing settings cache file.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            b.i.c.m.d.k.h.c(r2, "Error while closing settings cache file.");
            throw th;
        }
    }
}

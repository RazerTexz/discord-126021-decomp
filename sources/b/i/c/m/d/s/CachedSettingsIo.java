package b.i.c.m.d.s;

import android.content.Context;
import android.util.Log;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.k.CommonUtils;
import b.i.c.m.d.o.FileStoreImpl;
import java.io.File;
import java.io.FileInputStream;
import org.json.JSONObject;

/* JADX INFO: renamed from: b.i.c.m.d.s.a, reason: use source file name */
/* JADX INFO: compiled from: CachedSettingsIo.java */
/* JADX INFO: loaded from: classes3.dex */
public class CachedSettingsIo {
    public final Context a;

    public CachedSettingsIo(Context context) {
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
        Logger3 logger3 = Logger3.a;
        logger3.b("Reading cached settings...");
        ?? r2 = 0;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                File file = new File(new FileStoreImpl(this.a).a(), "com.crashlytics.settings.json");
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        jSONObject = new JSONObject(CommonUtils.x(fileInputStream));
                        fileInputStream2 = fileInputStream;
                    } catch (Exception e2) {
                        e = e2;
                        if (Logger3.a.a(6)) {
                            Log.e("FirebaseCrashlytics", "Failed to fetch cached settings", e);
                        }
                        CommonUtils.c(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    }
                } else {
                    logger3.b("No cached settings found.");
                    jSONObject = null;
                }
                CommonUtils.c(fileInputStream2, "Error while closing settings cache file.");
                return jSONObject;
            } catch (Throwable th) {
                r2 = logger3;
                th = th;
                CommonUtils.c(r2, "Error while closing settings cache file.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            CommonUtils.c(r2, "Error while closing settings cache file.");
            throw th;
        }
    }
}

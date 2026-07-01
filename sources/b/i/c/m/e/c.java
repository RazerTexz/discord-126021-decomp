package b.i.c.m.e;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.ndk.JniNativeApi;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: compiled from: FirebaseCrashlyticsNdk.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements b.i.c.m.d.a {
    public final e a;

    public c(@NonNull e eVar) {
        this.a = eVar;
    }

    @Override // b.i.c.m.d.a
    public boolean a(@NonNull String str) {
        f fVar = ((a) this.a).d;
        Objects.requireNonNull(fVar);
        f.b(new File(fVar.a, str));
        return true;
    }

    @Override // b.i.c.m.d.a
    @NonNull
    public b.i.c.m.d.d b(@NonNull String str) {
        return new h(((a) this.a).a(str));
    }

    @Override // b.i.c.m.d.a
    public void c(@NonNull String str, int i, @NonNull String str2, int i2, long j, long j2, boolean z2, int i3, @NonNull String str3, @NonNull String str4) throws Throwable {
        a aVar = (a) this.a;
        Objects.requireNonNull(aVar);
        HashMap map = new HashMap();
        map.put("arch", Integer.valueOf(i));
        map.put("build_model", str2);
        map.put("available_processors", Integer.valueOf(i2));
        map.put("total_ram", Long.valueOf(j));
        map.put("disk_space", Long.valueOf(j2));
        map.put("is_emulator", Boolean.valueOf(z2));
        map.put("state", Integer.valueOf(i3));
        map.put("build_manufacturer", str3);
        map.put("build_product", str4);
        aVar.c(str, new JSONObject(map).toString(), "device.json");
    }

    @Override // b.i.c.m.d.a
    public void d(@NonNull String str, @NonNull String str2, long j) throws Throwable {
        a aVar = (a) this.a;
        Objects.requireNonNull(aVar);
        HashMap map = new HashMap();
        map.put("session_id", str);
        map.put("generator", str2);
        map.put("started_at_seconds", Long.valueOf(j));
        aVar.c(str, new JSONObject(map).toString(), "session.json");
    }

    @Override // b.i.c.m.d.a
    public boolean e(@NonNull String str) {
        File file;
        a aVar = (a) this.a;
        f fVar = aVar.d;
        Objects.requireNonNull(fVar);
        return new File(fVar.a, str).exists() && (file = aVar.a(str).a) != null && file.exists();
    }

    @Override // b.i.c.m.d.a
    public void f(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, int i, @NonNull String str6) throws Throwable {
        a aVar = (a) this.a;
        Objects.requireNonNull(aVar);
        if (TextUtils.isEmpty(str6)) {
            str6 = "";
        }
        HashMap map = new HashMap();
        map.put("app_identifier", str2);
        map.put("version_code", str3);
        map.put("version_name", str4);
        map.put("install_uuid", str5);
        map.put("delivery_mechanism", Integer.valueOf(i));
        map.put("unity_version", str6);
        aVar.c(str, new JSONObject(map).toString(), "app.json");
    }

    @Override // b.i.c.m.d.a
    public void g(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z2) throws Throwable {
        a aVar = (a) this.a;
        Objects.requireNonNull(aVar);
        HashMap map = new HashMap();
        map.put("version", str2);
        map.put("build_version", str3);
        map.put("is_rooted", Boolean.valueOf(z2));
        aVar.c(str, new JSONObject(map).toString(), "os.json");
    }

    @Override // b.i.c.m.d.a
    public boolean h(String str) {
        a aVar = (a) this.a;
        File fileA = aVar.d.a(str);
        boolean zA = false;
        if (fileA != null) {
            try {
                zA = ((JniNativeApi) aVar.c).a(fileA.getCanonicalPath(), aVar.f1755b.getAssets());
            } catch (IOException e) {
                if (b.i.c.m.d.b.a.a(6)) {
                    Log.e("FirebaseCrashlytics", "Error initializing CrashlyticsNdk", e);
                }
            }
        }
        b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
        StringBuilder sbU = b.d.b.a.a.U("Crashlytics NDK initialization ");
        sbU.append(zA ? "successful" : "FAILED");
        bVar.f(sbU.toString());
        return zA;
    }
}

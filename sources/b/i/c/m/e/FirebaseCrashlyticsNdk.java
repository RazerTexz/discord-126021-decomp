package b.i.c.m.e;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import b.d.b.a.outline;
import b.i.c.m.d.CrashlyticsNativeComponent;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.NativeSessionFileProvider;
import com.google.firebase.crashlytics.ndk.JniNativeApi;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: renamed from: b.i.c.m.e.c, reason: use source file name */
/* JADX INFO: compiled from: FirebaseCrashlyticsNdk.java */
/* JADX INFO: loaded from: classes3.dex */
public class FirebaseCrashlyticsNdk implements CrashlyticsNativeComponent {
    public final NativeComponentController a;

    public FirebaseCrashlyticsNdk(@NonNull NativeComponentController nativeComponentController) {
        this.a = nativeComponentController;
    }

    @Override // b.i.c.m.d.CrashlyticsNativeComponent
    public boolean a(@NonNull String str) {
        NdkCrashFilesManager ndkCrashFilesManager = ((BreakpadController) this.a).d;
        Objects.requireNonNull(ndkCrashFilesManager);
        NdkCrashFilesManager.b(new File(ndkCrashFilesManager.a, str));
        return true;
    }

    @Override // b.i.c.m.d.CrashlyticsNativeComponent
    @NonNull
    public NativeSessionFileProvider b(@NonNull String str) {
        return new SessionFilesProvider(((BreakpadController) this.a).a(str));
    }

    @Override // b.i.c.m.d.CrashlyticsNativeComponent
    public void c(@NonNull String str, int i, @NonNull String str2, int i2, long j, long j2, boolean z2, int i3, @NonNull String str3, @NonNull String str4) throws Throwable {
        BreakpadController breakpadController = (BreakpadController) this.a;
        Objects.requireNonNull(breakpadController);
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
        breakpadController.c(str, new JSONObject(map).toString(), "device.json");
    }

    @Override // b.i.c.m.d.CrashlyticsNativeComponent
    public void d(@NonNull String str, @NonNull String str2, long j) throws Throwable {
        BreakpadController breakpadController = (BreakpadController) this.a;
        Objects.requireNonNull(breakpadController);
        HashMap map = new HashMap();
        map.put("session_id", str);
        map.put("generator", str2);
        map.put("started_at_seconds", Long.valueOf(j));
        breakpadController.c(str, new JSONObject(map).toString(), "session.json");
    }

    @Override // b.i.c.m.d.CrashlyticsNativeComponent
    public boolean e(@NonNull String str) {
        File file;
        BreakpadController breakpadController = (BreakpadController) this.a;
        NdkCrashFilesManager ndkCrashFilesManager = breakpadController.d;
        Objects.requireNonNull(ndkCrashFilesManager);
        return new File(ndkCrashFilesManager.a, str).exists() && (file = breakpadController.a(str).a) != null && file.exists();
    }

    @Override // b.i.c.m.d.CrashlyticsNativeComponent
    public void f(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, int i, @NonNull String str6) throws Throwable {
        BreakpadController breakpadController = (BreakpadController) this.a;
        Objects.requireNonNull(breakpadController);
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
        breakpadController.c(str, new JSONObject(map).toString(), "app.json");
    }

    @Override // b.i.c.m.d.CrashlyticsNativeComponent
    public void g(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z2) throws Throwable {
        BreakpadController breakpadController = (BreakpadController) this.a;
        Objects.requireNonNull(breakpadController);
        HashMap map = new HashMap();
        map.put("version", str2);
        map.put("build_version", str3);
        map.put("is_rooted", Boolean.valueOf(z2));
        breakpadController.c(str, new JSONObject(map).toString(), "os.json");
    }

    @Override // b.i.c.m.d.CrashlyticsNativeComponent
    public boolean h(String str) {
        BreakpadController breakpadController = (BreakpadController) this.a;
        File fileA = breakpadController.d.a(str);
        boolean zA = false;
        if (fileA != null) {
            try {
                zA = ((JniNativeApi) breakpadController.c).a(fileA.getCanonicalPath(), breakpadController.f1755b.getAssets());
            } catch (IOException e) {
                if (Logger3.a.a(6)) {
                    Log.e("FirebaseCrashlytics", "Error initializing CrashlyticsNdk", e);
                }
            }
        }
        Logger3 logger3 = Logger3.a;
        StringBuilder sbU = outline.U("Crashlytics NDK initialization ");
        sbU.append(zA ? "successful" : "FAILED");
        logger3.f(sbU.toString());
        return zA;
    }
}

package p007b.p225i.p361c.p369m.p389e;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.ndk.JniNativeApi;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import org.json.JSONObject;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p369m.p370d.C4592b;
import p007b.p225i.p361c.p369m.p370d.InterfaceC4591a;
import p007b.p225i.p361c.p369m.p370d.InterfaceC4594d;

/* JADX INFO: renamed from: b.i.c.m.e.c */
/* JADX INFO: compiled from: FirebaseCrashlyticsNdk.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4760c implements InterfaceC4591a {

    /* JADX INFO: renamed from: a */
    public final InterfaceC4762e f12789a;

    public C4760c(@NonNull InterfaceC4762e interfaceC4762e) {
        this.f12789a = interfaceC4762e;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.InterfaceC4591a
    /* JADX INFO: renamed from: a */
    public boolean mo6362a(@NonNull String str) {
        C4763f c4763f = ((C4758a) this.f12789a).f12787d;
        Objects.requireNonNull(c4763f);
        C4763f.m6701b(new File(c4763f.f12790a, str));
        return true;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.InterfaceC4591a
    @NonNull
    /* JADX INFO: renamed from: b */
    public InterfaceC4594d mo6363b(@NonNull String str) {
        return new C4765h(((C4758a) this.f12789a).m6699a(str));
    }

    @Override // p007b.p225i.p361c.p369m.p370d.InterfaceC4591a
    /* JADX INFO: renamed from: c */
    public void mo6364c(@NonNull String str, int i, @NonNull String str2, int i2, long j, long j2, boolean z2, int i3, @NonNull String str3, @NonNull String str4) throws Throwable {
        C4758a c4758a = (C4758a) this.f12789a;
        Objects.requireNonNull(c4758a);
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
        c4758a.m6700c(str, new JSONObject(map).toString(), "device.json");
    }

    @Override // p007b.p225i.p361c.p369m.p370d.InterfaceC4591a
    /* JADX INFO: renamed from: d */
    public void mo6365d(@NonNull String str, @NonNull String str2, long j) throws Throwable {
        C4758a c4758a = (C4758a) this.f12789a;
        Objects.requireNonNull(c4758a);
        HashMap map = new HashMap();
        map.put("session_id", str);
        map.put("generator", str2);
        map.put("started_at_seconds", Long.valueOf(j));
        c4758a.m6700c(str, new JSONObject(map).toString(), "session.json");
    }

    @Override // p007b.p225i.p361c.p369m.p370d.InterfaceC4591a
    /* JADX INFO: renamed from: e */
    public boolean mo6366e(@NonNull String str) {
        File file;
        C4758a c4758a = (C4758a) this.f12789a;
        C4763f c4763f = c4758a.f12787d;
        Objects.requireNonNull(c4763f);
        return new File(c4763f.f12790a, str).exists() && (file = c4758a.m6699a(str).f12791a) != null && file.exists();
    }

    @Override // p007b.p225i.p361c.p369m.p370d.InterfaceC4591a
    /* JADX INFO: renamed from: f */
    public void mo6367f(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, int i, @NonNull String str6) throws Throwable {
        C4758a c4758a = (C4758a) this.f12789a;
        Objects.requireNonNull(c4758a);
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
        c4758a.m6700c(str, new JSONObject(map).toString(), "app.json");
    }

    @Override // p007b.p225i.p361c.p369m.p370d.InterfaceC4591a
    /* JADX INFO: renamed from: g */
    public void mo6368g(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z2) throws Throwable {
        C4758a c4758a = (C4758a) this.f12789a;
        Objects.requireNonNull(c4758a);
        HashMap map = new HashMap();
        map.put("version", str2);
        map.put("build_version", str3);
        map.put("is_rooted", Boolean.valueOf(z2));
        c4758a.m6700c(str, new JSONObject(map).toString(), "os.json");
    }

    @Override // p007b.p225i.p361c.p369m.p370d.InterfaceC4591a
    /* JADX INFO: renamed from: h */
    public boolean mo6369h(String str) {
        C4758a c4758a = (C4758a) this.f12789a;
        File fileM6702a = c4758a.f12787d.m6702a(str);
        boolean zM9176a = false;
        if (fileM6702a != null) {
            try {
                zM9176a = ((JniNativeApi) c4758a.f12786c).m9176a(fileM6702a.getCanonicalPath(), c4758a.f12785b.getAssets());
            } catch (IOException e) {
                if (C4592b.f12227a.m6370a(6)) {
                    Log.e("FirebaseCrashlytics", "Error initializing CrashlyticsNdk", e);
                }
            }
        }
        C4592b c4592b = C4592b.f12227a;
        StringBuilder sbM833U = C1643a.m833U("Crashlytics NDK initialization ");
        sbM833U.append(zM9176a ? "successful" : "FAILED");
        c4592b.m6375f(sbM833U.toString());
        return zM9176a;
    }
}

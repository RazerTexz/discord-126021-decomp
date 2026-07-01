package b.i.c.m.d.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.k.CommonUtils;
import b.i.c.m.d.k.DataCollectionArbiter;
import b.i.c.m.d.k.SystemCurrentTimeProvider;
import b.i.c.m.d.n.HttpRequest;
import b.i.c.m.d.n.HttpResponse;
import b.i.c.m.d.o.FileStoreImpl;
import b.i.c.m.d.s.h.AppSettingsData;
import b.i.c.m.d.s.h.FeaturesSettingsData;
import b.i.c.m.d.s.h.SessionSettingsData;
import b.i.c.m.d.s.h.Settings2;
import b.i.c.m.d.s.h.SettingsData;
import b.i.c.m.d.s.h.SettingsRequest;
import b.i.c.m.d.s.i.DefaultSettingsSpiCall;
import b.i.c.m.d.s.i.SettingsSpiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: b.i.c.m.d.s.c, reason: use source file name */
/* JADX INFO: compiled from: SettingsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class SettingsController implements SettingsDataProvider {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SettingsRequest f1747b;
    public final SettingsJsonParser c;
    public final SystemCurrentTimeProvider d;
    public final CachedSettingsIo e;
    public final SettingsSpiCall f;
    public final DataCollectionArbiter g;
    public final AtomicReference<Settings2> h;
    public final AtomicReference<TaskCompletionSource<AppSettingsData>> i;

    /* JADX INFO: renamed from: b.i.c.m.d.s.c$a */
    /* JADX INFO: compiled from: SettingsController.java */
    public class a implements b.i.a.f.n.f<Void, Void> {
        public a() {
        }

        @Override // b.i.a.f.n.f
        @NonNull
        public Task<Void> a(@Nullable Void r11) throws Exception {
            JSONObject jSONObjectG;
            FileWriter fileWriter;
            SettingsController settingsController = SettingsController.this;
            SettingsSpiCall settingsSpiCall = settingsController.f;
            SettingsRequest settingsRequest = settingsController.f1747b;
            DefaultSettingsSpiCall defaultSettingsSpiCall = (DefaultSettingsSpiCall) settingsSpiCall;
            Objects.requireNonNull(defaultSettingsSpiCall);
            FileWriter fileWriter2 = null;
            try {
                Map<String, String> mapF = defaultSettingsSpiCall.f(settingsRequest);
                HttpRequest httpRequestC = defaultSettingsSpiCall.c(mapF);
                defaultSettingsSpiCall.d(httpRequestC, settingsRequest);
                defaultSettingsSpiCall.f.b("Requesting settings from " + defaultSettingsSpiCall.f1676b);
                defaultSettingsSpiCall.f.b("Settings query params were: " + mapF);
                HttpResponse httpResponseA = httpRequestC.a();
                defaultSettingsSpiCall.f.b("Settings request ID: " + httpResponseA.c.c("X-REQUEST-ID"));
                jSONObjectG = defaultSettingsSpiCall.g(httpResponseA);
            } catch (IOException e) {
                if (defaultSettingsSpiCall.f.a(6)) {
                    Log.e("FirebaseCrashlytics", "Settings request failed.", e);
                }
                jSONObjectG = null;
            }
            if (jSONObjectG != null) {
                SettingsData settingsDataA = SettingsController.this.c.a(jSONObjectG);
                CachedSettingsIo cachedSettingsIo = SettingsController.this.e;
                long j = settingsDataA.d;
                Objects.requireNonNull(cachedSettingsIo);
                Logger3.a.b("Writing settings to cache file...");
                try {
                    jSONObjectG.put("expires_at", j);
                    fileWriter = new FileWriter(new File(new FileStoreImpl(cachedSettingsIo.a).a(), "com.crashlytics.settings.json"));
                    try {
                        fileWriter.write(jSONObjectG.toString());
                        fileWriter.flush();
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            if (Logger3.a.a(6)) {
                                Log.e("FirebaseCrashlytics", "Failed to cache settings", e);
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileWriter2 = fileWriter;
                            fileWriter = fileWriter2;
                            CommonUtils.c(fileWriter, "Failed to close settings writer.");
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        CommonUtils.c(fileWriter, "Failed to close settings writer.");
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileWriter = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileWriter = fileWriter2;
                    CommonUtils.c(fileWriter, "Failed to close settings writer.");
                    throw th;
                }
                CommonUtils.c(fileWriter, "Failed to close settings writer.");
                SettingsController.this.e(jSONObjectG, "Loaded settings: ");
                SettingsController settingsController2 = SettingsController.this;
                String str = settingsController2.f1747b.f;
                SharedPreferences.Editor editorEdit = CommonUtils.o(settingsController2.a).edit();
                editorEdit.putString("existing_instance_identifier", str);
                editorEdit.apply();
                SettingsController.this.h.set(settingsDataA);
                SettingsController.this.i.get().b(settingsDataA.a);
                TaskCompletionSource<AppSettingsData> taskCompletionSource = new TaskCompletionSource<>();
                taskCompletionSource.b(settingsDataA.a);
                SettingsController.this.i.set(taskCompletionSource);
            }
            return b.i.a.f.e.o.f.Z(null);
        }
    }

    public SettingsController(Context context, SettingsRequest settingsRequest, SystemCurrentTimeProvider systemCurrentTimeProvider, SettingsJsonParser settingsJsonParser, CachedSettingsIo cachedSettingsIo, SettingsSpiCall settingsSpiCall, DataCollectionArbiter dataCollectionArbiter) {
        AtomicReference<Settings2> atomicReference = new AtomicReference<>();
        this.h = atomicReference;
        this.i = new AtomicReference<>(new TaskCompletionSource());
        this.a = context;
        this.f1747b = settingsRequest;
        this.d = systemCurrentTimeProvider;
        this.c = settingsJsonParser;
        this.e = cachedSettingsIo;
        this.f = settingsSpiCall;
        this.g = dataCollectionArbiter;
        JSONObject jSONObject = new JSONObject();
        atomicReference.set(new SettingsData(DefaultSettingsJsonTransform.b(systemCurrentTimeProvider, 3600L, jSONObject), null, new SessionSettingsData(jSONObject.optInt("max_custom_exception_events", 8), 4), new FeaturesSettingsData(jSONObject.optBoolean("collect_reports", true)), 0, 3600));
    }

    public Task<AppSettingsData> a() {
        return this.i.get().a;
    }

    public final SettingsData b(int i) throws Throwable {
        SettingsData settingsData = null;
        try {
            if (!b.c.a.y.b.g(2, i)) {
                JSONObject jSONObjectA = this.e.a();
                if (jSONObjectA != null) {
                    SettingsData settingsDataA = this.c.a(jSONObjectA);
                    if (settingsDataA != null) {
                        e(jSONObjectA, "Loaded cached settings: ");
                        Objects.requireNonNull(this.d);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (b.c.a.y.b.g(3, i)) {
                            try {
                                Logger3.a.b("Returning cached settings.");
                                settingsData = settingsDataA;
                            } catch (Exception e) {
                                e = e;
                                settingsData = settingsDataA;
                                if (Logger3.a.a(6)) {
                                    Log.e("FirebaseCrashlytics", "Failed to get cached settings", e);
                                }
                            }
                        } else {
                            if (settingsDataA.d < jCurrentTimeMillis) {
                                Logger3.a.b("Cached settings have expired.");
                            } else {
                                Logger3.a.b("Returning cached settings.");
                                settingsData = settingsDataA;
                            }
                        }
                    } else if (Logger3.a.a(6)) {
                        Log.e("FirebaseCrashlytics", "Failed to parse cached settings data.", null);
                    }
                } else {
                    Logger3.a.b("No cached settings data found.");
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
        return settingsData;
    }

    public Settings2 c() {
        return this.h.get();
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/Object;Ljava/util/concurrent/Executor;)Lcom/google/android/gms/tasks/Task<Ljava/lang/Void;>; */
    public Task d(int i, Executor executor) throws Throwable {
        SettingsData settingsDataB;
        if (!(!CommonUtils.o(this.a).getString("existing_instance_identifier", "").equals(this.f1747b.f)) && (settingsDataB = b(i)) != null) {
            this.h.set(settingsDataB);
            this.i.get().b(settingsDataB.a);
            return b.i.a.f.e.o.f.Z(null);
        }
        SettingsData settingsDataB2 = b(3);
        if (settingsDataB2 != null) {
            this.h.set(settingsDataB2);
            this.i.get().b(settingsDataB2.a);
        }
        return this.g.c().r(executor, new a());
    }

    public final void e(JSONObject jSONObject, String str) throws JSONException {
        Logger3 logger3 = Logger3.a;
        StringBuilder sbU = outline.U(str);
        sbU.append(jSONObject.toString());
        logger3.b(sbU.toString());
    }
}

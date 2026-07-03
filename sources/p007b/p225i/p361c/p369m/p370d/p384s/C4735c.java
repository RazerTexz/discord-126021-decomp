package p007b.p225i.p361c.p369m.p370d.p384s;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4362f;
import p007b.p225i.p361c.p369m.p370d.C4592b;
import p007b.p225i.p361c.p369m.p370d.p373k.C4621e1;
import p007b.p225i.p361c.p369m.p370d.p373k.C4628h;
import p007b.p225i.p361c.p369m.p370d.p373k.C4650q0;
import p007b.p225i.p361c.p369m.p370d.p377n.C4705a;
import p007b.p225i.p361c.p369m.p370d.p377n.C4707c;
import p007b.p225i.p361c.p369m.p370d.p378o.C4715h;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.C4741b;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.C4742c;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.C4743d;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.C4745f;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.C4746g;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.InterfaceC4744e;
import p007b.p225i.p361c.p369m.p370d.p384s.p386i.C4749c;
import p007b.p225i.p361c.p369m.p370d.p384s.p386i.InterfaceC4750d;

/* JADX INFO: renamed from: b.i.c.m.d.s.c */
/* JADX INFO: compiled from: SettingsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4735c implements InterfaceC4736d {

    /* JADX INFO: renamed from: a */
    public final Context f12729a;

    /* JADX INFO: renamed from: b */
    public final C4746g f12730b;

    /* JADX INFO: renamed from: c */
    public final C4737e f12731c;

    /* JADX INFO: renamed from: d */
    public final C4621e1 f12732d;

    /* JADX INFO: renamed from: e */
    public final C4733a f12733e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC4750d f12734f;

    /* JADX INFO: renamed from: g */
    public final C4650q0 f12735g;

    /* JADX INFO: renamed from: h */
    public final AtomicReference<InterfaceC4744e> f12736h;

    /* JADX INFO: renamed from: i */
    public final AtomicReference<TaskCompletionSource<C4741b>> f12737i;

    /* JADX INFO: renamed from: b.i.c.m.d.s.c$a */
    /* JADX INFO: compiled from: SettingsController.java */
    public class a implements InterfaceC4362f<Void, Void> {
        public a() {
        }

        @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4362f
        @NonNull
        /* JADX INFO: renamed from: a */
        public Task<Void> mo4013a(@Nullable Void r11) throws Exception {
            JSONObject jSONObjectM6695g;
            FileWriter fileWriter;
            C4735c c4735c = C4735c.this;
            InterfaceC4750d interfaceC4750d = c4735c.f12734f;
            C4746g c4746g = c4735c.f12730b;
            C4749c c4749c = (C4749c) interfaceC4750d;
            Objects.requireNonNull(c4749c);
            FileWriter fileWriter2 = null;
            try {
                Map<String, String> mapM6694f = c4749c.m6694f(c4746g);
                C4705a c4705aM6391c = c4749c.m6391c(mapM6694f);
                c4749c.m6692d(c4705aM6391c, c4746g);
                c4749c.f12773f.m6371b("Requesting settings from " + c4749c.f12253b);
                c4749c.f12773f.m6371b("Settings query params were: " + mapM6694f);
                C4707c c4707cM6621a = c4705aM6391c.m6621a();
                c4749c.f12773f.m6371b("Settings request ID: " + c4707cM6621a.f12665c.m10954c("X-REQUEST-ID"));
                jSONObjectM6695g = c4749c.m6695g(c4707cM6621a);
            } catch (IOException e) {
                if (c4749c.f12773f.m6370a(6)) {
                    Log.e("FirebaseCrashlytics", "Settings request failed.", e);
                }
                jSONObjectM6695g = null;
            }
            if (jSONObjectM6695g != null) {
                C4745f c4745fM6688a = C4735c.this.f12731c.m6688a(jSONObjectM6695g);
                C4733a c4733a = C4735c.this.f12733e;
                long j = c4745fM6688a.f12762d;
                Objects.requireNonNull(c4733a);
                C4592b.f12227a.m6371b("Writing settings to cache file...");
                try {
                    jSONObjectM6695g.put("expires_at", j);
                    fileWriter = new FileWriter(new File(new C4715h(c4733a.f12728a).m6636a(), "com.crashlytics.settings.json"));
                    try {
                        fileWriter.write(jSONObjectM6695g.toString());
                        fileWriter.flush();
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            if (C4592b.f12227a.m6370a(6)) {
                                Log.e("FirebaseCrashlytics", "Failed to cache settings", e);
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileWriter2 = fileWriter;
                            fileWriter = fileWriter2;
                            C4628h.m6409c(fileWriter, "Failed to close settings writer.");
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        C4628h.m6409c(fileWriter, "Failed to close settings writer.");
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileWriter = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileWriter = fileWriter2;
                    C4628h.m6409c(fileWriter, "Failed to close settings writer.");
                    throw th;
                }
                C4628h.m6409c(fileWriter, "Failed to close settings writer.");
                C4735c.this.m6687e(jSONObjectM6695g, "Loaded settings: ");
                C4735c c4735c2 = C4735c.this;
                String str = c4735c2.f12730b.f12768f;
                SharedPreferences.Editor editorEdit = C4628h.m6421o(c4735c2.f12729a).edit();
                editorEdit.putString("existing_instance_identifier", str);
                editorEdit.apply();
                C4735c.this.f12736h.set(c4745fM6688a);
                C4735c.this.f12737i.get().m9126b(c4745fM6688a.f12759a);
                TaskCompletionSource<C4741b> taskCompletionSource = new TaskCompletionSource<>();
                taskCompletionSource.m9126b(c4745fM6688a.f12759a);
                C4735c.this.f12737i.set(taskCompletionSource);
            }
            return C3404f.m4264Z(null);
        }
    }

    public C4735c(Context context, C4746g c4746g, C4621e1 c4621e1, C4737e c4737e, C4733a c4733a, InterfaceC4750d interfaceC4750d, C4650q0 c4650q0) {
        AtomicReference<InterfaceC4744e> atomicReference = new AtomicReference<>();
        this.f12736h = atomicReference;
        this.f12737i = new AtomicReference<>(new TaskCompletionSource());
        this.f12729a = context;
        this.f12730b = c4746g;
        this.f12732d = c4621e1;
        this.f12731c = c4737e;
        this.f12733e = c4733a;
        this.f12734f = interfaceC4750d;
        this.f12735g = c4650q0;
        JSONObject jSONObject = new JSONObject();
        atomicReference.set(new C4745f(C4734b.m6681b(c4621e1, 3600L, jSONObject), null, new C4743d(jSONObject.optInt("max_custom_exception_events", 8), 4), new C4742c(jSONObject.optBoolean("collect_reports", true)), 0, 3600));
    }

    /* JADX INFO: renamed from: a */
    public Task<C4741b> m6683a() {
        return this.f12737i.get().f20845a;
    }

    /* JADX INFO: renamed from: b */
    public final C4745f m6684b(int i) throws Throwable {
        C4745f c4745f = null;
        try {
            if (!C1563b.m757g(2, i)) {
                JSONObject jSONObjectM6680a = this.f12733e.m6680a();
                if (jSONObjectM6680a != null) {
                    C4745f c4745fM6688a = this.f12731c.m6688a(jSONObjectM6680a);
                    if (c4745fM6688a != null) {
                        m6687e(jSONObjectM6680a, "Loaded cached settings: ");
                        Objects.requireNonNull(this.f12732d);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (C1563b.m757g(3, i)) {
                            try {
                                C4592b.f12227a.m6371b("Returning cached settings.");
                                c4745f = c4745fM6688a;
                            } catch (Exception e) {
                                e = e;
                                c4745f = c4745fM6688a;
                                if (C4592b.f12227a.m6370a(6)) {
                                    Log.e("FirebaseCrashlytics", "Failed to get cached settings", e);
                                }
                            }
                        } else {
                            if (c4745fM6688a.f12762d < jCurrentTimeMillis) {
                                C4592b.f12227a.m6371b("Cached settings have expired.");
                            } else {
                                C4592b.f12227a.m6371b("Returning cached settings.");
                                c4745f = c4745fM6688a;
                            }
                        }
                    } else if (C4592b.f12227a.m6370a(6)) {
                        Log.e("FirebaseCrashlytics", "Failed to parse cached settings data.", null);
                    }
                } else {
                    C4592b.f12227a.m6371b("No cached settings data found.");
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
        return c4745f;
    }

    /* JADX INFO: renamed from: c */
    public InterfaceC4744e m6685c() {
        return this.f12736h.get();
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/Object;Ljava/util/concurrent/Executor;)Lcom/google/android/gms/tasks/Task<Ljava/lang/Void;>; */
    /* JADX INFO: renamed from: d */
    public Task m6686d(int i, Executor executor) throws Throwable {
        C4745f c4745fM6684b;
        if (!(!C4628h.m6421o(this.f12729a).getString("existing_instance_identifier", "").equals(this.f12730b.f12768f)) && (c4745fM6684b = m6684b(i)) != null) {
            this.f12736h.set(c4745fM6684b);
            this.f12737i.get().m9126b(c4745fM6684b.f12759a);
            return C3404f.m4264Z(null);
        }
        C4745f c4745fM6684b2 = m6684b(3);
        if (c4745fM6684b2 != null) {
            this.f12736h.set(c4745fM6684b2);
            this.f12737i.get().m9126b(c4745fM6684b2.f12759a);
        }
        return this.f12735g.m6451c().mo6023r(executor, new a());
    }

    /* JADX INFO: renamed from: e */
    public final void m6687e(JSONObject jSONObject, String str) throws JSONException {
        C4592b c4592b = C4592b.f12227a;
        StringBuilder sbM833U = C1643a.m833U(str);
        sbM833U.append(jSONObject.toString());
        c4592b.m6371b(sbM833U.toString());
    }
}

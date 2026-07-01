package b.i.c.m.d.s;

import android.content.Context;
import android.util.Log;
import b.i.c.m.d.k.e1;
import b.i.c.m.d.k.h;
import b.i.c.m.d.k.q0;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SettingsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements d {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.c.m.d.s.h.g f1747b;
    public final e c;
    public final e1 d;
    public final a e;
    public final b.i.c.m.d.s.i.d f;
    public final q0 g;
    public final AtomicReference<b.i.c.m.d.s.h.e> h;
    public final AtomicReference<TaskCompletionSource<b.i.c.m.d.s.h.b>> i;

    public c(Context context, b.i.c.m.d.s.h.g gVar, e1 e1Var, e eVar, a aVar, b.i.c.m.d.s.i.d dVar, q0 q0Var) {
        AtomicReference<b.i.c.m.d.s.h.e> atomicReference = new AtomicReference<>();
        this.h = atomicReference;
        this.i = new AtomicReference<>(new TaskCompletionSource());
        this.a = context;
        this.f1747b = gVar;
        this.d = e1Var;
        this.c = eVar;
        this.e = aVar;
        this.f = dVar;
        this.g = q0Var;
        JSONObject jSONObject = new JSONObject();
        atomicReference.set(new b.i.c.m.d.s.h.f(b.b(e1Var, 3600L, jSONObject), null, new b.i.c.m.d.s.h.d(jSONObject.optInt("max_custom_exception_events", 8), 4), new b.i.c.m.d.s.h.c(jSONObject.optBoolean("collect_reports", true)), 0, 3600));
    }

    public Task<b.i.c.m.d.s.h.b> a() {
        return this.i.get().a;
    }

    public final b.i.c.m.d.s.h.f b(int i) throws Throwable {
        b.i.c.m.d.s.h.f fVar = null;
        try {
            if (!b.c.a.y.b.g(2, i)) {
                JSONObject jSONObjectA = this.e.a();
                if (jSONObjectA != null) {
                    b.i.c.m.d.s.h.f fVarA = this.c.a(jSONObjectA);
                    if (fVarA != null) {
                        e(jSONObjectA, "Loaded cached settings: ");
                        Objects.requireNonNull(this.d);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (b.c.a.y.b.g(3, i)) {
                            try {
                                b.i.c.m.d.b.a.b("Returning cached settings.");
                                fVar = fVarA;
                            } catch (Exception e) {
                                e = e;
                                fVar = fVarA;
                                if (b.i.c.m.d.b.a.a(6)) {
                                    Log.e("FirebaseCrashlytics", "Failed to get cached settings", e);
                                }
                            }
                        } else {
                            if (fVarA.d < jCurrentTimeMillis) {
                                b.i.c.m.d.b.a.b("Cached settings have expired.");
                            } else {
                                b.i.c.m.d.b.a.b("Returning cached settings.");
                                fVar = fVarA;
                            }
                        }
                    } else if (b.i.c.m.d.b.a.a(6)) {
                        Log.e("FirebaseCrashlytics", "Failed to parse cached settings data.", null);
                    }
                } else {
                    b.i.c.m.d.b.a.b("No cached settings data found.");
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
        return fVar;
    }

    public b.i.c.m.d.s.h.e c() {
        return this.h.get();
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/Object;Ljava/util/concurrent/Executor;)Lcom/google/android/gms/tasks/Task<Ljava/lang/Void;>; */
    public Task d(int i, Executor executor) throws Throwable {
        b.i.c.m.d.s.h.f fVarB;
        if (!(!h.o(this.a).getString("existing_instance_identifier", "").equals(this.f1747b.f)) && (fVarB = b(i)) != null) {
            this.h.set(fVarB);
            this.i.get().b(fVarB.a);
            return b.i.a.f.e.o.f.Z(null);
        }
        b.i.c.m.d.s.h.f fVarB2 = b(3);
        if (fVarB2 != null) {
            this.h.set(fVarB2);
            this.i.get().b(fVarB2.a);
        }
        return this.g.c().r(executor, new c$a(this));
    }

    public final void e(JSONObject jSONObject, String str) throws JSONException {
        b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
        StringBuilder sbU = b.d.b.a.a.U(str);
        sbU.append(jSONObject.toString());
        bVar.b(sbU.toString());
    }
}

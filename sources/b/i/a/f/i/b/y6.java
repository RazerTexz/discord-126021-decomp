package b.i.a.f.i.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.MainThread;
import com.adjust.sdk.Constants;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(14)
@MainThread
public final class y6 implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ c6 j;

    public y6(c6 c6Var, d6 d6Var) {
        this.j = c6Var;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            try {
                this.j.g().n.a("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent == null) {
                    return;
                }
                Uri data = intent.getData();
                if (data != null && data.isHierarchical()) {
                    this.j.e();
                    this.j.f().v(new c7(this, bundle == null, data, t9.V(intent) ? "gs" : "auto", data.getQueryParameter(Constants.REFERRER)));
                    return;
                }
                return;
            } catch (Exception e) {
                this.j.g().f.b("Throwable caught in onActivityCreated", e);
                return;
            }
        } finally {
            this.j.q().y(activity, bundle);
        }
        this.j.q().y(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        h7 h7VarQ = this.j.q();
        synchronized (h7VarQ.l) {
            if (activity == h7VarQ.g) {
                h7VarQ.g = null;
            }
        }
        if (h7VarQ.a.h.z().booleanValue()) {
            h7VarQ.f.remove(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    @MainThread
    public final void onActivityPaused(Activity activity) {
        h7 h7VarQ = this.j.q();
        if (h7VarQ.a.h.o(p.v0)) {
            synchronized (h7VarQ.l) {
                h7VarQ.k = false;
                h7VarQ.h = true;
            }
        }
        Objects.requireNonNull((b.i.a.f.e.o.c) h7VarQ.a.o);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!h7VarQ.a.h.o(p.u0) || h7VarQ.a.h.z().booleanValue()) {
            i7 i7VarE = h7VarQ.E(activity);
            h7VarQ.d = h7VarQ.c;
            h7VarQ.c = null;
            h7VarQ.f().v(new o7(h7VarQ, i7VarE, jElapsedRealtime));
        } else {
            h7VarQ.c = null;
            h7VarQ.f().v(new l7(h7VarQ, jElapsedRealtime));
        }
        w8 w8VarS = this.j.s();
        Objects.requireNonNull((b.i.a.f.e.o.c) w8VarS.a.o);
        w8VarS.f().v(new y8(w8VarS, SystemClock.elapsedRealtime()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    @MainThread
    public final void onActivityResumed(Activity activity) {
        w8 w8VarS = this.j.s();
        Objects.requireNonNull((b.i.a.f.e.o.c) w8VarS.a.o);
        w8VarS.f().v(new v8(w8VarS, SystemClock.elapsedRealtime()));
        h7 h7VarQ = this.j.q();
        if (h7VarQ.a.h.o(p.v0)) {
            synchronized (h7VarQ.l) {
                h7VarQ.k = true;
                if (activity != h7VarQ.g) {
                    synchronized (h7VarQ.l) {
                        h7VarQ.g = activity;
                        h7VarQ.h = false;
                    }
                    if (h7VarQ.a.h.o(p.u0) && h7VarQ.a.h.z().booleanValue()) {
                        h7VarQ.i = null;
                        h7VarQ.f().v(new n7(h7VarQ));
                    }
                }
            }
        }
        if (h7VarQ.a.h.o(p.u0) && !h7VarQ.a.h.z().booleanValue()) {
            h7VarQ.c = h7VarQ.i;
            h7VarQ.f().v(new m7(h7VarQ));
            return;
        }
        h7VarQ.z(activity, h7VarQ.E(activity), false);
        a aVarM = h7VarQ.m();
        Objects.requireNonNull((b.i.a.f.e.o.c) aVarM.a.o);
        aVarM.f().v(new a3(aVarM, SystemClock.elapsedRealtime()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        i7 i7Var;
        h7 h7VarQ = this.j.q();
        if (!h7VarQ.a.h.z().booleanValue() || bundle == null || (i7Var = h7VarQ.f.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong(ModelAuditLogEntry.CHANGE_KEY_ID, i7Var.c);
        bundle2.putString(ModelAuditLogEntry.CHANGE_KEY_NAME, i7Var.a);
        bundle2.putString("referrer_name", i7Var.f1537b);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}

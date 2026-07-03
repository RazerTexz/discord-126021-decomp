package p007b.p225i.p226a.p288f.p330i.p332b;

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
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;

/* JADX INFO: renamed from: b.i.a.f.i.b.y6 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(14)
@MainThread
public final class C4248y6 implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C3999c6 f11379j;

    public C4248y6(C3999c6 c3999c6, RunnableC4011d6 runnableC4011d6) {
        this.f11379j = c3999c6;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            try {
                this.f11379j.mo5726g().f11149n.m5860a("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent == null) {
                    return;
                }
                Uri data = intent.getData();
                if (data != null && data.isHierarchical()) {
                    this.f11379j.m5866e();
                    this.f11379j.mo5725f().m5852v(new RunnableC4000c7(this, bundle == null, data, C4196t9.m5875V(intent) ? "gs" : "auto", data.getQueryParameter(Constants.REFERRER)));
                    return;
                }
                return;
            } catch (Exception e) {
                this.f11379j.mo5726g().f11141f.m5861b("Throwable caught in onActivityCreated", e);
                return;
            }
        } finally {
            this.f11379j.m5972q().m5657y(activity, bundle);
        }
        this.f11379j.m5972q().m5657y(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        C4060h7 c4060h7M5972q = this.f11379j.m5972q();
        synchronized (c4060h7M5972q.f10784l) {
            if (activity == c4060h7M5972q.f10779g) {
                c4060h7M5972q.f10779g = null;
            }
        }
        if (c4060h7M5972q.f11202a.f11260h.m5537z().booleanValue()) {
            c4060h7M5972q.f10778f.remove(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    @MainThread
    public final void onActivityPaused(Activity activity) {
        C4060h7 c4060h7M5972q = this.f11379j.m5972q();
        if (c4060h7M5972q.f11202a.f11260h.m5526o(C4142p.f11104v0)) {
            synchronized (c4060h7M5972q.f10784l) {
                c4060h7M5972q.f10783k = false;
                c4060h7M5972q.f10780h = true;
            }
        }
        Objects.requireNonNull((C3401c) c4060h7M5972q.f11202a.f11267o);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!c4060h7M5972q.f11202a.f11260h.m5526o(C4142p.f11102u0) || c4060h7M5972q.f11202a.f11260h.m5537z().booleanValue()) {
            C4072i7 c4072i7M5655E = c4060h7M5972q.m5655E(activity);
            c4060h7M5972q.f10776d = c4060h7M5972q.f10775c;
            c4060h7M5972q.f10775c = null;
            c4060h7M5972q.mo5725f().m5852v(new RunnableC4139o7(c4060h7M5972q, c4072i7M5655E, jElapsedRealtime));
        } else {
            c4060h7M5972q.f10775c = null;
            c4060h7M5972q.mo5725f().m5852v(new RunnableC4106l7(c4060h7M5972q, jElapsedRealtime));
        }
        C4228w8 c4228w8M5974s = this.f11379j.m5974s();
        Objects.requireNonNull((C3401c) c4228w8M5974s.f11202a.f11267o);
        c4228w8M5974s.mo5725f().m5852v(new RunnableC4250y8(c4228w8M5974s, SystemClock.elapsedRealtime()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    @MainThread
    public final void onActivityResumed(Activity activity) {
        C4228w8 c4228w8M5974s = this.f11379j.m5974s();
        Objects.requireNonNull((C3401c) c4228w8M5974s.f11202a.f11267o);
        c4228w8M5974s.mo5725f().m5852v(new RunnableC4217v8(c4228w8M5974s, SystemClock.elapsedRealtime()));
        C4060h7 c4060h7M5972q = this.f11379j.m5972q();
        if (c4060h7M5972q.f11202a.f11260h.m5526o(C4142p.f11104v0)) {
            synchronized (c4060h7M5972q.f10784l) {
                c4060h7M5972q.f10783k = true;
                if (activity != c4060h7M5972q.f10779g) {
                    synchronized (c4060h7M5972q.f10784l) {
                        c4060h7M5972q.f10779g = activity;
                        c4060h7M5972q.f10780h = false;
                    }
                    if (c4060h7M5972q.f11202a.f11260h.m5526o(C4142p.f11102u0) && c4060h7M5972q.f11202a.f11260h.m5537z().booleanValue()) {
                        c4060h7M5972q.f10781i = null;
                        c4060h7M5972q.mo5725f().m5852v(new RunnableC4128n7(c4060h7M5972q));
                    }
                }
            }
        }
        if (c4060h7M5972q.f11202a.f11260h.m5526o(C4142p.f11102u0) && !c4060h7M5972q.f11202a.f11260h.m5537z().booleanValue()) {
            c4060h7M5972q.f10775c = c4060h7M5972q.f10781i;
            c4060h7M5972q.mo5725f().m5852v(new RunnableC4117m7(c4060h7M5972q));
            return;
        }
        c4060h7M5972q.m5658z(activity, c4060h7M5972q.m5655E(activity), false);
        C3968a c3968aM5968m = c4060h7M5972q.m5968m();
        Objects.requireNonNull((C3401c) c3968aM5968m.f11202a.f11267o);
        c3968aM5968m.mo5725f().m5852v(new RunnableC3972a3(c3968aM5968m, SystemClock.elapsedRealtime()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        C4072i7 c4072i7;
        C4060h7 c4060h7M5972q = this.f11379j.m5972q();
        if (!c4060h7M5972q.f11202a.f11260h.m5537z().booleanValue() || bundle == null || (c4072i7 = c4060h7M5972q.f10778f.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong(ModelAuditLogEntry.CHANGE_KEY_ID, c4072i7.f10818c);
        bundle2.putString(ModelAuditLogEntry.CHANGE_KEY_NAME, c4072i7.f10816a);
        bundle2.putString("referrer_name", c4072i7.f10817b);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}

package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: b.i.a.f.e.h.j.c */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class ComponentCallbacks2C3281c implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* JADX INFO: renamed from: j */
    public static final ComponentCallbacks2C3281c f9349j = new ComponentCallbacks2C3281c();

    /* JADX INFO: renamed from: k */
    public final AtomicBoolean f9350k = new AtomicBoolean();

    /* JADX INFO: renamed from: l */
    public final AtomicBoolean f9351l = new AtomicBoolean();

    /* JADX INFO: renamed from: m */
    public final ArrayList<a> f9352m = new ArrayList<>();

    /* JADX INFO: renamed from: n */
    public boolean f9353n = false;

    /* JADX INFO: renamed from: b.i.a.f.e.h.j.c$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo4066a(boolean z2);
    }

    /* JADX INFO: renamed from: a */
    public static void m4064a(@RecentlyNonNull Application application) {
        ComponentCallbacks2C3281c componentCallbacks2C3281c = f9349j;
        synchronized (componentCallbacks2C3281c) {
            if (!componentCallbacks2C3281c.f9353n) {
                application.registerActivityLifecycleCallbacks(componentCallbacks2C3281c);
                application.registerComponentCallbacks(componentCallbacks2C3281c);
                componentCallbacks2C3281c.f9353n = true;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m4065b(boolean z2) {
        synchronized (f9349j) {
            Iterator<a> it = this.f9352m.iterator();
            while (it.hasNext()) {
                it.next().mo4066a(z2);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(@RecentlyNonNull Activity activity, @Nullable Bundle bundle) {
        boolean zCompareAndSet = this.f9350k.compareAndSet(true, false);
        this.f9351l.set(true);
        if (zCompareAndSet) {
            m4065b(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(@RecentlyNonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(@RecentlyNonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(@RecentlyNonNull Activity activity) {
        boolean zCompareAndSet = this.f9350k.compareAndSet(true, false);
        this.f9351l.set(true);
        if (zCompareAndSet) {
            m4065b(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(@RecentlyNonNull Activity activity, @RecentlyNonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(@RecentlyNonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(@RecentlyNonNull Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(@RecentlyNonNull Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        if (i == 20 && this.f9350k.compareAndSet(false, true)) {
            this.f9351l.set(true);
            m4065b(true);
        }
    }
}

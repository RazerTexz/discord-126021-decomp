package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.fragment.app.FragmentActivity;
import b.c.a.a0.d;
import b.i.a.f.e.h.j.d1;
import b.i.a.f.e.h.j.f1;
import b.i.a.f.e.h.j.i;
import b.i.a.f.e.h.j.j;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class LifecycleCallback {

    @RecentlyNonNull
    public final j j;

    public LifecycleCallback(@RecentlyNonNull j jVar) {
        this.j = jVar;
    }

    @RecentlyNonNull
    public static j c(@RecentlyNonNull Activity activity) {
        d1 d1Var;
        d1 d1Var2;
        j jVar;
        f1 f1Var;
        f1 f1Var2;
        d.z(activity, "Activity must not be null");
        if (activity instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) activity;
            WeakHashMap<FragmentActivity, WeakReference<f1>> weakHashMap = f1.j;
            WeakReference<f1> weakReference = weakHashMap.get(fragmentActivity);
            if (weakReference == null || (f1Var2 = weakReference.get()) == null) {
                try {
                    jVar = f1Var2;
                    f1 f1Var3 = (f1) fragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
                    if (f1Var3 == null || f1Var3.isRemoving()) {
                        f1Var = f1Var3;
                        f1 f1Var4 = new f1();
                        fragmentActivity.getSupportFragmentManager().beginTransaction().add(f1Var4, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
                        f1Var = f1Var4;
                    }
                    f1Var = f1Var3;
                    weakHashMap.put(fragmentActivity, new WeakReference<>(f1Var));
                    jVar = f1Var;
                } catch (ClassCastException e) {
                    throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
                }
            }
        } else {
            WeakHashMap<Activity, WeakReference<d1>> weakHashMap2 = d1.j;
            WeakReference<d1> weakReference2 = weakHashMap2.get(activity);
            if (weakReference2 == null || (d1Var2 = weakReference2.get()) == null) {
                try {
                    jVar = d1Var2;
                    d1 d1Var3 = (d1) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
                    if (d1Var3 == null || d1Var3.isRemoving()) {
                        d1Var = d1Var3;
                        d1 d1Var4 = new d1();
                        activity.getFragmentManager().beginTransaction().add(d1Var4, "LifecycleFragmentImpl").commitAllowingStateLoss();
                        d1Var = d1Var4;
                    }
                    d1Var = d1Var3;
                    weakHashMap2.put(activity, new WeakReference<>(d1Var));
                    jVar = d1Var;
                } catch (ClassCastException e2) {
                    throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e2);
                }
            }
        }
        jVar = d1Var2;
        jVar = f1Var2;
        return jVar;
    }

    @Keep
    private static j getChimeraLifecycleFragmentImpl(i iVar) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    @MainThread
    public void a() {
    }

    @RecentlyNonNull
    public Activity b() {
        return this.j.e();
    }

    @MainThread
    public void d(int i, int i2, @RecentlyNonNull Intent intent) {
    }

    @MainThread
    public void e(@Nullable Bundle bundle) {
    }

    @MainThread
    public void f() {
    }

    @MainThread
    public void g() {
    }

    @MainThread
    public void h(@RecentlyNonNull Bundle bundle) {
    }

    @MainThread
    public void i() {
    }

    @MainThread
    public void j() {
    }
}

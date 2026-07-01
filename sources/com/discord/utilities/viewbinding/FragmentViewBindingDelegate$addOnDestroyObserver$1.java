package com.discord.utilities.viewbinding;

import androidx.view.DefaultLifecycleObserver;
import androidx.view.LifecycleOwner;
import d0.z.d.m;
import y.c.a;

/* JADX INFO: compiled from: FragmentViewBindingDelegate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FragmentViewBindingDelegate$addOnDestroyObserver$1 implements DefaultLifecycleObserver {
    public final /* synthetic */ FragmentViewBindingDelegate this$0;

    public FragmentViewBindingDelegate$addOnDestroyObserver$1(FragmentViewBindingDelegate fragmentViewBindingDelegate) {
        this.this$0 = fragmentViewBindingDelegate;
    }

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public void onCreate(LifecycleOwner owner) {
        m.checkNotNullParameter(owner, "owner");
        this.this$0.getFragment().getViewLifecycleOwnerLiveData().observe(this.this$0.getFragment(), new FragmentViewBindingDelegate$addOnDestroyObserver$1$onCreate$1(this));
    }

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        a.b(this, lifecycleOwner);
    }

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        a.c(this, lifecycleOwner);
    }

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        a.d(this, lifecycleOwner);
    }

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        a.e(this, lifecycleOwner);
    }

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        a.f(this, lifecycleOwner);
    }
}

package com.discord.utilities.viewbinding;

import androidx.view.DefaultLifecycleObserver;
import androidx.view.LifecycleOwner;
import androidx.viewbinding.ViewBinding;
import d0.z.d.m;
import y.c.a;

/* JADX INFO: compiled from: FragmentViewBindingDelegate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FragmentViewBindingDelegate$addOnDestroyObserver$1$onCreate$1$1 implements DefaultLifecycleObserver {
    public final /* synthetic */ FragmentViewBindingDelegate$addOnDestroyObserver$1$onCreate$1 this$0;

    public FragmentViewBindingDelegate$addOnDestroyObserver$1$onCreate$1$1(FragmentViewBindingDelegate$addOnDestroyObserver$1$onCreate$1 fragmentViewBindingDelegate$addOnDestroyObserver$1$onCreate$1) {
        this.this$0 = fragmentViewBindingDelegate$addOnDestroyObserver$1$onCreate$1;
    }

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        a.a(this, lifecycleOwner);
    }

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public void onDestroy(LifecycleOwner owner) {
        m.checkNotNullParameter(owner, "owner");
        ViewBinding viewBindingAccess$getBinding$p = FragmentViewBindingDelegate.access$getBinding$p(this.this$0.this$0.this$0);
        if (viewBindingAccess$getBinding$p != null) {
            this.this$0.this$0.this$0.getOnViewBindingDestroy().invoke(viewBindingAccess$getBinding$p);
        }
        FragmentViewBindingDelegate.access$setBinding$p(this.this$0.this$0.this$0, null);
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

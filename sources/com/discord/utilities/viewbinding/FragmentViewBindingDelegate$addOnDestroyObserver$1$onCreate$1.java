package com.discord.utilities.viewbinding;

import androidx.exifinterface.media.ExifInterface;
import androidx.view.LifecycleOwner;
import androidx.view.Observer;
import d0.z.d.m;

/* JADX INFO: compiled from: FragmentViewBindingDelegate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FragmentViewBindingDelegate$addOnDestroyObserver$1$onCreate$1<T> implements Observer<LifecycleOwner> {
    public final /* synthetic */ FragmentViewBindingDelegate$addOnDestroyObserver$1 this$0;

    public FragmentViewBindingDelegate$addOnDestroyObserver$1$onCreate$1(FragmentViewBindingDelegate$addOnDestroyObserver$1 fragmentViewBindingDelegate$addOnDestroyObserver$1) {
        this.this$0 = fragmentViewBindingDelegate$addOnDestroyObserver$1;
    }

    @Override // androidx.view.Observer
    public /* bridge */ /* synthetic */ void onChanged(LifecycleOwner lifecycleOwner) {
        onChanged2(lifecycleOwner);
    }

    /* JADX INFO: renamed from: onChanged, reason: avoid collision after fix types in other method */
    public final void onChanged2(LifecycleOwner lifecycleOwner) {
        m.checkNotNullExpressionValue(lifecycleOwner, "viewLifecycleOwner");
        lifecycleOwner.getLifecycle().addObserver(new FragmentViewBindingDelegate$addOnDestroyObserver$1$onCreate$1$1(this));
    }
}

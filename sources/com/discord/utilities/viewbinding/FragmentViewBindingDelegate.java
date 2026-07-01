package com.discord.utilities.viewbinding;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.view.Lifecycle;
import androidx.view.Lifecycle$State;
import androidx.view.LifecycleOwner;
import androidx.viewbinding.ViewBinding;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: FragmentViewBindingDelegate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FragmentViewBindingDelegate<T extends ViewBinding> {
    private T binding;
    private final Fragment fragment;
    private final Function1<T, Unit> onViewBindingDestroy;
    private final Function1<View, T> viewBindingFactory;

    /* JADX WARN: Multi-variable type inference failed */
    public FragmentViewBindingDelegate(Fragment fragment, Function1<? super View, ? extends T> function1, Function1<? super T, Unit> function2) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(function1, "viewBindingFactory");
        m.checkNotNullParameter(function2, "onViewBindingDestroy");
        this.fragment = fragment;
        this.viewBindingFactory = function1;
        this.onViewBindingDestroy = function2;
        addOnDestroyObserver();
    }

    public static final /* synthetic */ ViewBinding access$getBinding$p(FragmentViewBindingDelegate fragmentViewBindingDelegate) {
        return fragmentViewBindingDelegate.binding;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void access$setBinding$p(FragmentViewBindingDelegate fragmentViewBindingDelegate, ViewBinding viewBinding) {
        fragmentViewBindingDelegate.binding = viewBinding;
    }

    private final void addOnDestroyObserver() {
        this.fragment.getLifecycle().addObserver(new FragmentViewBindingDelegate$addOnDestroyObserver$1(this));
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    public final Function1<T, Unit> getOnViewBindingDestroy() {
        return this.onViewBindingDestroy;
    }

    public /* bridge */ /* synthetic */ Object getValue(Object obj, KProperty kProperty) {
        return getValue((Fragment) obj, (KProperty<?>) kProperty);
    }

    public final Function1<View, T> getViewBindingFactory() {
        return this.viewBindingFactory;
    }

    public T getValue(Fragment thisRef, KProperty<?> property) {
        m.checkNotNullParameter(thisRef, "thisRef");
        m.checkNotNullParameter(property, "property");
        T t = this.binding;
        if (t != null) {
            return t;
        }
        LifecycleOwner viewLifecycleOwner = this.fragment.getViewLifecycleOwner();
        m.checkNotNullExpressionValue(viewLifecycleOwner, "fragment.viewLifecycleOwner");
        Lifecycle lifecycle = viewLifecycleOwner.getLifecycle();
        m.checkNotNullExpressionValue(lifecycle, "fragment.viewLifecycleOwner.lifecycle");
        if (!lifecycle.getCurrentState().isAtLeast(Lifecycle$State.INITIALIZED)) {
            throw new IllegalStateException("Should not attempt to get bindings when Fragment views are destroyed.");
        }
        Function1<View, T> function1 = this.viewBindingFactory;
        View viewRequireView = thisRef.requireView();
        m.checkNotNullExpressionValue(viewRequireView, "thisRef.requireView()");
        T tInvoke = function1.invoke(viewRequireView);
        this.binding = tInvoke;
        return tInvoke;
    }
}

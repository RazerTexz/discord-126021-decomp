package com.discord.utilities.viewbinding;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.view.DefaultLifecycleObserver;
import androidx.view.Lifecycle;
import androidx.view.LifecycleOwner;
import androidx.view.Observer;
import androidx.viewbinding.ViewBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p507d0.p592z.p594d.C12238m;
import p677y.p685c.C13195a;

/* JADX INFO: compiled from: FragmentViewBindingDelegate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FragmentViewBindingDelegate<T extends ViewBinding> {
    private T binding;
    private final Fragment fragment;
    private final Function1<T, Unit> onViewBindingDestroy;
    private final Function1<View, T> viewBindingFactory;

    /* JADX INFO: renamed from: com.discord.utilities.viewbinding.FragmentViewBindingDelegate$addOnDestroyObserver$1 */
    /* JADX INFO: compiled from: FragmentViewBindingDelegate.kt */
    public static final class C70141 implements DefaultLifecycleObserver {
        public C70141() {
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public void onCreate(LifecycleOwner owner) {
            C12238m.checkNotNullParameter(owner, "owner");
            FragmentViewBindingDelegate.this.getFragment().getViewLifecycleOwnerLiveData().observe(FragmentViewBindingDelegate.this.getFragment(), new Observer<LifecycleOwner>() { // from class: com.discord.utilities.viewbinding.FragmentViewBindingDelegate$addOnDestroyObserver$1$onCreate$1
                @Override // androidx.view.Observer
                public final void onChanged(LifecycleOwner lifecycleOwner) {
                    C12238m.checkNotNullExpressionValue(lifecycleOwner, "viewLifecycleOwner");
                    lifecycleOwner.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: com.discord.utilities.viewbinding.FragmentViewBindingDelegate$addOnDestroyObserver$1$onCreate$1.1
                        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
                        public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner2) {
                            C13195a.m11359a(this, lifecycleOwner2);
                        }

                        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
                        public void onDestroy(LifecycleOwner owner2) {
                            C12238m.checkNotNullParameter(owner2, "owner");
                            ViewBinding viewBinding = FragmentViewBindingDelegate.this.binding;
                            if (viewBinding != null) {
                                FragmentViewBindingDelegate.this.getOnViewBindingDestroy().invoke(viewBinding);
                            }
                            FragmentViewBindingDelegate.this.binding = null;
                        }

                        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
                        public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner2) {
                            C13195a.m11361c(this, lifecycleOwner2);
                        }

                        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
                        public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner2) {
                            C13195a.m11362d(this, lifecycleOwner2);
                        }

                        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
                        public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner2) {
                            C13195a.m11363e(this, lifecycleOwner2);
                        }

                        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
                        public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner2) {
                            C13195a.m11364f(this, lifecycleOwner2);
                        }
                    });
                }
            });
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
            C13195a.m11360b(this, lifecycleOwner);
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
            C13195a.m11361c(this, lifecycleOwner);
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
            C13195a.m11362d(this, lifecycleOwner);
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
            C13195a.m11363e(this, lifecycleOwner);
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
            C13195a.m11364f(this, lifecycleOwner);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FragmentViewBindingDelegate(Fragment fragment, Function1<? super View, ? extends T> function1, Function1<? super T, Unit> function2) {
        C12238m.checkNotNullParameter(fragment, "fragment");
        C12238m.checkNotNullParameter(function1, "viewBindingFactory");
        C12238m.checkNotNullParameter(function2, "onViewBindingDestroy");
        this.fragment = fragment;
        this.viewBindingFactory = function1;
        this.onViewBindingDestroy = function2;
        addOnDestroyObserver();
    }

    private final void addOnDestroyObserver() {
        this.fragment.getLifecycle().addObserver(new C70141());
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
        C12238m.checkNotNullParameter(thisRef, "thisRef");
        C12238m.checkNotNullParameter(property, "property");
        T t = this.binding;
        if (t != null) {
            return t;
        }
        LifecycleOwner viewLifecycleOwner = this.fragment.getViewLifecycleOwner();
        C12238m.checkNotNullExpressionValue(viewLifecycleOwner, "fragment.viewLifecycleOwner");
        Lifecycle lifecycle = viewLifecycleOwner.getLifecycle();
        C12238m.checkNotNullExpressionValue(lifecycle, "fragment.viewLifecycleOwner.lifecycle");
        if (!lifecycle.getCurrentState().isAtLeast(Lifecycle.State.INITIALIZED)) {
            throw new IllegalStateException("Should not attempt to get bindings when Fragment views are destroyed.");
        }
        Function1<View, T> function1 = this.viewBindingFactory;
        View viewRequireView = thisRef.requireView();
        C12238m.checkNotNullExpressionValue(viewRequireView, "thisRef.requireView()");
        T tInvoke = function1.invoke(viewRequireView);
        this.binding = tInvoke;
        return tInvoke;
    }
}

package com.discord.utilities.viewbinding;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FragmentViewBindingDelegate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FragmentViewBindingDelegateKt {
    public static final <T extends ViewBinding> FragmentViewBindingDelegate<T> viewBinding(Fragment fragment, Function1<? super View, ? extends T> function1, Function1<? super T, Unit> function2) {
        m.checkNotNullParameter(fragment, "$this$viewBinding");
        m.checkNotNullParameter(function1, "viewBindingFactory");
        m.checkNotNullParameter(function2, "onViewBindingDestroy");
        return new FragmentViewBindingDelegate<>(fragment, function1, function2);
    }

    public static /* synthetic */ FragmentViewBindingDelegate viewBinding$default(Fragment fragment, Function1 function1, Function1 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = FragmentViewBindingDelegateKt$viewBinding$1.INSTANCE;
        }
        return viewBinding(fragment, function1, function2);
    }
}

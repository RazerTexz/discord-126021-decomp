package com.discord.utilities.viewbinding;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt, reason: use source file name */
/* JADX INFO: compiled from: FragmentViewBindingDelegate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FragmentViewBindingDelegate3 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt$viewBinding$1, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentViewBindingDelegate.kt */
    public static final class AnonymousClass1<T> extends Lambda implements Function1<T, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke((ViewBinding) obj);
            return Unit.a;
        }

        /* JADX WARN: Incorrect types in method signature: (TT;)V */
        public final void invoke(ViewBinding viewBinding) {
            Intrinsics3.checkNotNullParameter(viewBinding, "it");
        }
    }

    public static final <T extends ViewBinding> FragmentViewBindingDelegate<T> viewBinding(Fragment fragment, Function1<? super View, ? extends T> function1, Function1<? super T, Unit> function2) {
        Intrinsics3.checkNotNullParameter(fragment, "$this$viewBinding");
        Intrinsics3.checkNotNullParameter(function1, "viewBindingFactory");
        Intrinsics3.checkNotNullParameter(function2, "onViewBindingDestroy");
        return new FragmentViewBindingDelegate<>(fragment, function1, function2);
    }

    public static /* synthetic */ FragmentViewBindingDelegate viewBinding$default(Fragment fragment, Function1 function1, Function1 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = AnonymousClass1.INSTANCE;
        }
        return viewBinding(fragment, function1, function2);
    }
}

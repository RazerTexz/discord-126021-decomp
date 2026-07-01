package com.discord.utilities.viewbinding;

import androidx.exifinterface.media.ExifInterface;
import androidx.viewbinding.ViewBinding;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: FragmentViewBindingDelegate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FragmentViewBindingDelegateKt$viewBinding$1<T> extends o implements Function1<T, Unit> {
    public static final FragmentViewBindingDelegateKt$viewBinding$1 INSTANCE = new FragmentViewBindingDelegateKt$viewBinding$1();

    public FragmentViewBindingDelegateKt$viewBinding$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke((ViewBinding) obj);
        return Unit.a;
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)V */
    public final void invoke(ViewBinding viewBinding) {
        m.checkNotNullParameter(viewBinding, "it");
    }
}

package com.discord.utilities.view.extensions;

import android.view.ViewPropertyAnimator;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ViewExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewExtensions$fadeOut$1 extends o implements Function1<ViewPropertyAnimator, Unit> {
    public static final ViewExtensions$fadeOut$1 INSTANCE = new ViewExtensions$fadeOut$1();

    public ViewExtensions$fadeOut$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ViewPropertyAnimator viewPropertyAnimator) {
        invoke2(viewPropertyAnimator);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ViewPropertyAnimator viewPropertyAnimator) {
        m.checkNotNullParameter(viewPropertyAnimator, "$receiver");
    }
}

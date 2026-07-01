package com.discord.widgets.changelog;

import android.view.ViewPropertyAnimator;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChangeLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeLog$hideVideoOverlay$1 extends o implements Function1<ViewPropertyAnimator, Unit> {
    public static final WidgetChangeLog$hideVideoOverlay$1 INSTANCE = new WidgetChangeLog$hideVideoOverlay$1();

    public WidgetChangeLog$hideVideoOverlay$1() {
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
        viewPropertyAnimator.scaleX(2.0f);
        viewPropertyAnimator.scaleY(2.0f);
    }
}

package com.discord.widgets.channels;

import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextInVoiceOnboarding$showVideoOverlay$1 extends o implements Function1<View, Unit> {
    public static final WidgetTextInVoiceOnboarding$showVideoOverlay$1 INSTANCE = new WidgetTextInVoiceOnboarding$showVideoOverlay$1();

    public WidgetTextInVoiceOnboarding$showVideoOverlay$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "view");
        view.setScaleX(2.0f);
        view.setScaleY(2.0f);
    }
}

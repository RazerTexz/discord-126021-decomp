package com.discord.widgets.voice.fullscreen;

import d0.z.d.FunctionReferenceImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetCallFullscreen$onViewBound$listener$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public WidgetCallFullscreen$onViewBound$listener$1(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        super(1, widgetCallFullscreenViewModel, WidgetCallFullscreenViewModel.class, "onPushToTalkPressed", "onPushToTalkPressed(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        ((WidgetCallFullscreenViewModel) this.receiver).onPushToTalkPressed(z2);
    }
}

package com.discord.widgets.voice.fullscreen;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetCallFullscreen$onViewBound$listener$1 extends C12236k implements Function1<Boolean, Unit> {
    public WidgetCallFullscreen$onViewBound$listener$1(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        super(1, widgetCallFullscreenViewModel, WidgetCallFullscreenViewModel.class, "onPushToTalkPressed", "onPushToTalkPressed(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.f27425a;
    }

    public final void invoke(boolean z2) {
        ((WidgetCallFullscreenViewModel) this.receiver).onPushToTalkPressed(z2);
    }
}

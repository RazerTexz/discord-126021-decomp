package com.discord.widgets.voice.fullscreen;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetCallFullscreen$onViewBoundOrOnResume$1 extends k implements Function1<WidgetCallFullscreenViewModel$ViewState, Unit> {
    public WidgetCallFullscreen$onViewBoundOrOnResume$1(WidgetCallFullscreen widgetCallFullscreen) {
        super(1, widgetCallFullscreen, WidgetCallFullscreen.class, "configureUI", "configureUI(Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetCallFullscreenViewModel$ViewState widgetCallFullscreenViewModel$ViewState) {
        invoke2(widgetCallFullscreenViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetCallFullscreenViewModel$ViewState widgetCallFullscreenViewModel$ViewState) {
        m.checkNotNullParameter(widgetCallFullscreenViewModel$ViewState, "p1");
        WidgetCallFullscreen.access$configureUI((WidgetCallFullscreen) this.receiver, widgetCallFullscreenViewModel$ViewState);
    }
}

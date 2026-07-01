package com.discord.widgets.voice.fullscreen;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetCallFullscreen$onViewBoundOrOnResume$2 extends k implements Function1<WidgetCallFullscreenViewModel$Event, Unit> {
    public WidgetCallFullscreen$onViewBoundOrOnResume$2(WidgetCallFullscreen widgetCallFullscreen) {
        super(1, widgetCallFullscreen, WidgetCallFullscreen.class, "handleEvent", "handleEvent(Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetCallFullscreenViewModel$Event widgetCallFullscreenViewModel$Event) {
        invoke2(widgetCallFullscreenViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetCallFullscreenViewModel$Event widgetCallFullscreenViewModel$Event) {
        m.checkNotNullParameter(widgetCallFullscreenViewModel$Event, "p1");
        ((WidgetCallFullscreen) this.receiver).handleEvent(widgetCallFullscreenViewModel$Event);
    }
}

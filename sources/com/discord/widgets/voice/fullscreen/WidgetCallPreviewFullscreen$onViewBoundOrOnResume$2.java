package com.discord.widgets.voice.fullscreen;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetCallPreviewFullscreen$onViewBoundOrOnResume$2 extends k implements Function1<WidgetCallPreviewFullscreenViewModel$Event, Unit> {
    public WidgetCallPreviewFullscreen$onViewBoundOrOnResume$2(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
        super(1, widgetCallPreviewFullscreen, WidgetCallPreviewFullscreen.class, "handleEvent", "handleEvent(Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetCallPreviewFullscreenViewModel$Event widgetCallPreviewFullscreenViewModel$Event) {
        invoke2(widgetCallPreviewFullscreenViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetCallPreviewFullscreenViewModel$Event widgetCallPreviewFullscreenViewModel$Event) {
        m.checkNotNullParameter(widgetCallPreviewFullscreenViewModel$Event, "p1");
        WidgetCallPreviewFullscreen.access$handleEvent((WidgetCallPreviewFullscreen) this.receiver, widgetCallPreviewFullscreenViewModel$Event);
    }
}

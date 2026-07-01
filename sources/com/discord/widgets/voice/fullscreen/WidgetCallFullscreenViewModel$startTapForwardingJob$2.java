package com.discord.widgets.voice.fullscreen;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreenViewModel$startTapForwardingJob$2 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ WidgetCallFullscreenViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreenViewModel$startTapForwardingJob$2(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        super(1);
        this.this$0 = widgetCallFullscreenViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l) {
        boolean isIdle = WidgetCallFullscreenViewModel.access$getVideoPlayerIdleDetectorFooter$p(this.this$0).getIsIdle();
        WidgetCallFullscreenViewModel.access$getVideoPlayerIdleDetectorFooter$p(this.this$0).onInteraction(WidgetCallFullscreenViewModel.access$getVideoPlayerIdleDetectorHeader$p(this.this$0).getIsIdle());
        WidgetCallFullscreenViewModel.access$getVideoPlayerIdleDetectorHeader$p(this.this$0).onInteraction(isIdle);
    }
}

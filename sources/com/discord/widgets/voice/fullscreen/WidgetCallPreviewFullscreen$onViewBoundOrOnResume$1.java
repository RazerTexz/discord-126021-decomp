package com.discord.widgets.voice.fullscreen;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallPreviewFullscreen$onViewBoundOrOnResume$1 extends o implements Function1<WidgetCallPreviewFullscreenViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetCallPreviewFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallPreviewFullscreen$onViewBoundOrOnResume$1(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
        super(1);
        this.this$0 = widgetCallPreviewFullscreen;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetCallPreviewFullscreenViewModel$ViewState widgetCallPreviewFullscreenViewModel$ViewState) {
        invoke2(widgetCallPreviewFullscreenViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetCallPreviewFullscreenViewModel$ViewState widgetCallPreviewFullscreenViewModel$ViewState) {
        m.checkNotNullParameter(widgetCallPreviewFullscreenViewModel$ViewState, "it");
        WidgetCallPreviewFullscreen.access$configureUI(this.this$0, widgetCallPreviewFullscreenViewModel$ViewState);
    }
}

package com.discord.widgets.voice.fullscreen;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallPreviewFullscreenViewModel$1 extends o implements Function1<WidgetCallPreviewFullscreenViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetCallPreviewFullscreenViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallPreviewFullscreenViewModel$1(WidgetCallPreviewFullscreenViewModel widgetCallPreviewFullscreenViewModel) {
        super(1);
        this.this$0 = widgetCallPreviewFullscreenViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetCallPreviewFullscreenViewModel$StoreState widgetCallPreviewFullscreenViewModel$StoreState) {
        invoke2(widgetCallPreviewFullscreenViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetCallPreviewFullscreenViewModel$StoreState widgetCallPreviewFullscreenViewModel$StoreState) {
        WidgetCallPreviewFullscreenViewModel widgetCallPreviewFullscreenViewModel = this.this$0;
        m.checkNotNullExpressionValue(widgetCallPreviewFullscreenViewModel$StoreState, "it");
        WidgetCallPreviewFullscreenViewModel.access$handleStoreState(widgetCallPreviewFullscreenViewModel, widgetCallPreviewFullscreenViewModel$StoreState);
    }
}

package com.discord.widgets.voice.fullscreen;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallPreviewFullscreen$configureUI$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetCallPreviewFullscreen$configureUI$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallPreviewFullscreen$configureUI$2$1(WidgetCallPreviewFullscreen$configureUI$2 widgetCallPreviewFullscreen$configureUI$2) {
        super(0);
        this.this$0 = widgetCallPreviewFullscreen$configureUI$2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetCallPreviewFullscreen.access$getViewModel$p(this.this$0.this$0).tryConnectToVoice(true);
    }
}

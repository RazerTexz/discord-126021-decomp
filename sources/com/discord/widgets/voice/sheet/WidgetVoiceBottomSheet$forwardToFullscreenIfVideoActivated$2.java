package com.discord.widgets.voice.sheet;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceBottomSheet$forwardToFullscreenIfVideoActivated$2 extends AbstractC12240o implements Function0<Boolean> {
    public final /* synthetic */ WidgetVoiceBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceBottomSheet$forwardToFullscreenIfVideoActivated$2(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
        super(0);
        this.this$0 = widgetVoiceBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return this.this$0.getArgumentsOrDefault().getBoolean("ARG_FORWARD_TO_FULLSCREEN_IF_VIDEO_ACTIVATED");
    }
}

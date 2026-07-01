package com.discord.widgets.voice.sheet;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceBottomSheet$configureBottomContent$7$1 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetVoiceBottomSheet$configureBottomContent$7 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceBottomSheet$configureBottomContent$7$1(WidgetVoiceBottomSheet$configureBottomContent$7 widgetVoiceBottomSheet$configureBottomContent$7) {
        super(0);
        this.this$0 = widgetVoiceBottomSheet$configureBottomContent$7;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetVoiceBottomSheet.access$getViewModel$p(this.this$0.this$0).tryConnectToVoice(false);
    }
}

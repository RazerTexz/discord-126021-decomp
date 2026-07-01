package com.discord.widgets.voice.call;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetVoiceCallIncoming.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetVoiceCallIncoming$onViewBoundOrOnResume$1 extends k implements Function1<WidgetVoiceCallIncoming$Model, Unit> {
    public WidgetVoiceCallIncoming$onViewBoundOrOnResume$1(WidgetVoiceCallIncoming widgetVoiceCallIncoming) {
        super(1, widgetVoiceCallIncoming, WidgetVoiceCallIncoming.class, "configureUI", "configureUI(Lcom/discord/widgets/voice/call/WidgetVoiceCallIncoming$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetVoiceCallIncoming$Model widgetVoiceCallIncoming$Model) {
        invoke2(widgetVoiceCallIncoming$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetVoiceCallIncoming$Model widgetVoiceCallIncoming$Model) {
        ((WidgetVoiceCallIncoming) this.receiver).configureUI(widgetVoiceCallIncoming$Model);
    }
}

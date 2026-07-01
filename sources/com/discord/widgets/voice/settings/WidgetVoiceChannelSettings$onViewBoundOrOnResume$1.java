package com.discord.widgets.voice.settings;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetVoiceChannelSettings.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceChannelSettings$onViewBoundOrOnResume$1 extends o implements Function1<WidgetVoiceChannelSettings$Model, Unit> {
    public final /* synthetic */ WidgetVoiceChannelSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceChannelSettings$onViewBoundOrOnResume$1(WidgetVoiceChannelSettings widgetVoiceChannelSettings) {
        super(1);
        this.this$0 = widgetVoiceChannelSettings;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetVoiceChannelSettings$Model widgetVoiceChannelSettings$Model) {
        invoke2(widgetVoiceChannelSettings$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetVoiceChannelSettings$Model widgetVoiceChannelSettings$Model) {
        WidgetVoiceChannelSettings.access$configureUI(this.this$0, widgetVoiceChannelSettings$Model);
    }
}

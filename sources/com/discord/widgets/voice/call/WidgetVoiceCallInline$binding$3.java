package com.discord.widgets.voice.call;

import com.discord.databinding.WidgetVoiceCallInlineBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetVoiceCallInline$binding$3 extends k implements Function1<WidgetVoiceCallInlineBinding, Unit> {
    public WidgetVoiceCallInline$binding$3(WidgetVoiceCallInline widgetVoiceCallInline) {
        super(1, widgetVoiceCallInline, WidgetVoiceCallInline.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetVoiceCallInlineBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetVoiceCallInlineBinding widgetVoiceCallInlineBinding) {
        invoke2(widgetVoiceCallInlineBinding);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetVoiceCallInlineBinding widgetVoiceCallInlineBinding) {
        m.checkNotNullParameter(widgetVoiceCallInlineBinding, "p1");
        WidgetVoiceCallInline.access$onViewBindingDestroy((WidgetVoiceCallInline) this.receiver, widgetVoiceCallInlineBinding);
    }
}

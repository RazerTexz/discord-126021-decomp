package com.discord.widgets.voice.call;

import b.d.b.a.outline;
import com.discord.app.AppActivity;
import com.discord.app.AppLog;
import com.discord.widgets.voice.call.WidgetVoiceCallIncoming;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$SystemCallIncoming$onViewCreated$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetVoiceCallIncoming.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceCallIncoming3 extends Lambda implements Function1<Long, Unit> {
    public final /* synthetic */ WidgetVoiceCallIncoming.SystemCallIncoming this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceCallIncoming3(WidgetVoiceCallIncoming.SystemCallIncoming systemCallIncoming) {
        super(1);
        this.this$0 = systemCallIncoming;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l) {
        StringBuilder sbU = outline.U("Stopping ");
        sbU.append(this.this$0.getClass().getName());
        sbU.append(" to prevent keeping screen awake");
        AppLog.i(sbU.toString());
        AppActivity appActivity = this.this$0.getAppActivity();
        if (appActivity != null) {
            appActivity.finish();
        }
    }
}

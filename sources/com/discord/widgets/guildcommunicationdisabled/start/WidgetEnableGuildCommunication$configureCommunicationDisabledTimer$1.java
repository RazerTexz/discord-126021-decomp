package com.discord.widgets.guildcommunicationdisabled.start;

import android.content.Context;
import android.widget.TextView;
import b.a.k.b;
import com.discord.utilities.duration.DurationUtilsKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEnableGuildCommunication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableGuildCommunication$configureCommunicationDisabledTimer$1 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ long $communicationDisabledTimestampMs;
    public final /* synthetic */ CharSequence $username;
    public final /* synthetic */ WidgetEnableGuildCommunication this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEnableGuildCommunication$configureCommunicationDisabledTimer$1(WidgetEnableGuildCommunication widgetEnableGuildCommunication, long j, CharSequence charSequence) {
        super(1);
        this.this$0 = widgetEnableGuildCommunication;
        this.$communicationDisabledTimestampMs = j;
        this.$username = charSequence;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l) {
        long jMax = Math.max(this.$communicationDisabledTimestampMs - WidgetEnableGuildCommunication.access$getClock$p(this.this$0).currentTimeMillis(), 0L);
        TextView textView = WidgetEnableGuildCommunication.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(textView, "binding.enableGuildCommunicationBody");
        Context contextRequireContext = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        b.n(textView, 2131888849, new Object[]{this.$username, DurationUtilsKt.humanizeCountdownDuration(contextRequireContext, jMax)}, null, 4);
    }
}

package com.discord.widgets.guildscheduledevent;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetPreviewGuildScheduledEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPreviewGuildScheduledEvent$onViewBound$3$2 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ WidgetPreviewGuildScheduledEvent$onViewBound$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPreviewGuildScheduledEvent$onViewBound$3$2(WidgetPreviewGuildScheduledEvent$onViewBound$3 widgetPreviewGuildScheduledEvent$onViewBound$3) {
        super(1);
        this.this$0 = widgetPreviewGuildScheduledEvent$onViewBound$3;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l) {
        FragmentActivity activity = this.this$0.this$0.getActivity();
        if (activity != null) {
            if (WidgetPreviewGuildScheduledEvent.access$getViewModel$p(this.this$0.this$0).isCreate()) {
                Intent intent = new Intent();
                intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", WidgetPreviewGuildScheduledEvent.access$getEventModel$p(this.this$0.this$0).getChannelId());
                intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", l);
                intent.putExtra(WidgetPreviewGuildScheduledEvent.EXTRA_EVENT_CREATED, true);
                activity.setResult(-1, intent);
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", WidgetPreviewGuildScheduledEvent.access$getEventModel$p(this.this$0.this$0).getChannelId());
                intent2.putExtra("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", l);
                activity.setResult(-1, intent2);
            }
            activity.finish();
        }
    }
}

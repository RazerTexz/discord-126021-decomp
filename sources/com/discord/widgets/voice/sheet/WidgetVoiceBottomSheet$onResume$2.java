package com.discord.widgets.voice.sheet;

import android.content.Context;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.databinding.WidgetVoiceBottomSheetBinding;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventModelKt;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent$Companion;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent$Companion$Action;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceBottomSheet$onResume$2 extends o implements Function1<GuildScheduledEvent, Unit> {
    public final /* synthetic */ WidgetVoiceBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceBottomSheet$onResume$2(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
        super(1);
        this.this$0 = widgetVoiceBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEvent guildScheduledEvent) {
        invoke2(guildScheduledEvent);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildScheduledEvent guildScheduledEvent) {
        m.checkNotNullParameter(guildScheduledEvent, "event");
        WidgetPreviewGuildScheduledEvent$Companion widgetPreviewGuildScheduledEvent$Companion = WidgetPreviewGuildScheduledEvent.Companion;
        WidgetVoiceBottomSheetBinding widgetVoiceBottomSheetBindingAccess$getBinding$p = WidgetVoiceBottomSheet.access$getBinding$p(this.this$0);
        m.checkNotNullExpressionValue(widgetVoiceBottomSheetBindingAccess$getBinding$p, "binding");
        CoordinatorLayout coordinatorLayout = widgetVoiceBottomSheetBindingAccess$getBinding$p.a;
        m.checkNotNullExpressionValue(coordinatorLayout, "binding.root");
        Context context = coordinatorLayout.getContext();
        m.checkNotNullExpressionValue(context, "binding.root.context");
        WidgetPreviewGuildScheduledEvent$Companion.launch$default(widgetPreviewGuildScheduledEvent$Companion, context, GuildScheduledEventModelKt.toModel(guildScheduledEvent), new WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData(guildScheduledEvent.getId(), WidgetPreviewGuildScheduledEvent$Companion$Action.START_EVENT), null, false, 24, null);
    }
}

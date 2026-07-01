package com.discord.widgets.voice.fullscreen;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.databinding.WidgetCallPreviewFullscreenBinding;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventModelKt;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent$Companion;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent$Companion$Action;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallPreviewFullscreen$onViewBound$7 extends o implements Function1<GuildScheduledEvent, Unit> {
    public final /* synthetic */ WidgetCallPreviewFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallPreviewFullscreen$onViewBound$7(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
        super(1);
        this.this$0 = widgetCallPreviewFullscreen;
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
        WidgetCallPreviewFullscreenBinding widgetCallPreviewFullscreenBindingAccess$getBinding$p = WidgetCallPreviewFullscreen.access$getBinding$p(this.this$0);
        m.checkNotNullExpressionValue(widgetCallPreviewFullscreenBindingAccess$getBinding$p, "binding");
        ConstraintLayout constraintLayout = widgetCallPreviewFullscreenBindingAccess$getBinding$p.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        Context context = constraintLayout.getContext();
        m.checkNotNullExpressionValue(context, "binding.root.context");
        WidgetPreviewGuildScheduledEvent$Companion.launch$default(widgetPreviewGuildScheduledEvent$Companion, context, GuildScheduledEventModelKt.toModel(guildScheduledEvent), new WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData(guildScheduledEvent.getId(), WidgetPreviewGuildScheduledEvent$Companion$Action.START_EVENT), null, false, 24, null);
    }
}

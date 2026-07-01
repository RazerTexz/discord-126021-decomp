package com.discord.widgets.voice.fullscreen;

import androidx.fragment.app.FragmentManager;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallPreviewFullscreen$onViewBound$6 extends o implements Function1<GuildScheduledEvent, Unit> {
    public final /* synthetic */ WidgetCallPreviewFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallPreviewFullscreen$onViewBound$6(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
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
        WidgetGuildScheduledEventDetailsBottomSheet$Companion widgetGuildScheduledEventDetailsBottomSheet$Companion = WidgetGuildScheduledEventDetailsBottomSheet.Companion;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetGuildScheduledEventDetailsBottomSheet$Companion.showForGuild(parentFragmentManager, guildScheduledEvent.getId());
    }
}

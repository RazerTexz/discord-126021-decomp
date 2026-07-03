package com.discord.widgets.voice.fullscreen;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventModelKt;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$configureEventPrompt$onStartEvent$1 extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ GuildScheduledEvent $startableEvent;
    public final /* synthetic */ WidgetCallFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreen$configureEventPrompt$onStartEvent$1(WidgetCallFullscreen widgetCallFullscreen, GuildScheduledEvent guildScheduledEvent) {
        super(0);
        this.this$0 = widgetCallFullscreen;
        this.$startableEvent = guildScheduledEvent;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$startableEvent == null) {
            return;
        }
        WidgetPreviewGuildScheduledEvent.INSTANCE.launch(this.this$0.requireContext(), GuildScheduledEventModelKt.toModel(this.$startableEvent), (24 & 4) != 0 ? null : new WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData(this.$startableEvent.getId(), WidgetPreviewGuildScheduledEvent.Companion.Action.START_EVENT), (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? false : false);
    }
}

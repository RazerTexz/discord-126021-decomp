package com.discord.widgets.voice.fullscreen;

import com.discord.models.guild.Guild;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$configureEventPrompt$onCreateEventClick$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Guild $guild;
    public final /* synthetic */ WidgetCallFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreen$configureEventPrompt$onCreateEventClick$1(WidgetCallFullscreen widgetCallFullscreen, Guild guild) {
        super(0);
        this.this$0 = widgetCallFullscreen;
        this.$guild = guild;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$guild != null) {
            WidgetGuildScheduledEventLocationSelect.INSTANCE.launch(this.this$0.requireContext(), this.$guild.getId(), Long.valueOf(this.this$0.getChannelId()));
        }
    }
}

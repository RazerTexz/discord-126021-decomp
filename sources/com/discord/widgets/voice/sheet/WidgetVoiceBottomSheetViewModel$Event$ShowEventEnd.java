package com.discord.widgets.voice.sheet;

import b.d.b.a.a;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetVoiceBottomSheetViewModel$Event$ShowEventEnd extends WidgetVoiceBottomSheetViewModel$Event {
    private final GuildScheduledEvent guildScheduledEvent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceBottomSheetViewModel$Event$ShowEventEnd(GuildScheduledEvent guildScheduledEvent) {
        super(null);
        m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        this.guildScheduledEvent = guildScheduledEvent;
    }

    public static /* synthetic */ WidgetVoiceBottomSheetViewModel$Event$ShowEventEnd copy$default(WidgetVoiceBottomSheetViewModel$Event$ShowEventEnd widgetVoiceBottomSheetViewModel$Event$ShowEventEnd, GuildScheduledEvent guildScheduledEvent, int i, Object obj) {
        if ((i & 1) != 0) {
            guildScheduledEvent = widgetVoiceBottomSheetViewModel$Event$ShowEventEnd.guildScheduledEvent;
        }
        return widgetVoiceBottomSheetViewModel$Event$ShowEventEnd.copy(guildScheduledEvent);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    public final WidgetVoiceBottomSheetViewModel$Event$ShowEventEnd copy(GuildScheduledEvent guildScheduledEvent) {
        m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        return new WidgetVoiceBottomSheetViewModel$Event$ShowEventEnd(guildScheduledEvent);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetVoiceBottomSheetViewModel$Event$ShowEventEnd) && m.areEqual(this.guildScheduledEvent, ((WidgetVoiceBottomSheetViewModel$Event$ShowEventEnd) other).guildScheduledEvent);
        }
        return true;
    }

    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    public int hashCode() {
        GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
        if (guildScheduledEvent != null) {
            return guildScheduledEvent.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("ShowEventEnd(guildScheduledEvent=");
        sbU.append(this.guildScheduledEvent);
        sbU.append(")");
        return sbU.toString();
    }
}

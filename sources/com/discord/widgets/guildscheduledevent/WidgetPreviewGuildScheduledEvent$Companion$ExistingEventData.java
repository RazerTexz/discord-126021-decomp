package com.discord.widgets.guildscheduledevent;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;
import java.io.Serializable;

/* JADX INFO: compiled from: WidgetPreviewGuildScheduledEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData implements Serializable {
    private final WidgetPreviewGuildScheduledEvent$Companion$Action action;
    private final long guildScheduledEventId;

    public WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData(long j, WidgetPreviewGuildScheduledEvent$Companion$Action widgetPreviewGuildScheduledEvent$Companion$Action) {
        m.checkNotNullParameter(widgetPreviewGuildScheduledEvent$Companion$Action, "action");
        this.guildScheduledEventId = j;
        this.action = widgetPreviewGuildScheduledEvent$Companion$Action;
    }

    public static /* synthetic */ WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData copy$default(WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData widgetPreviewGuildScheduledEvent$Companion$ExistingEventData, long j, WidgetPreviewGuildScheduledEvent$Companion$Action widgetPreviewGuildScheduledEvent$Companion$Action, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetPreviewGuildScheduledEvent$Companion$ExistingEventData.guildScheduledEventId;
        }
        if ((i & 2) != 0) {
            widgetPreviewGuildScheduledEvent$Companion$Action = widgetPreviewGuildScheduledEvent$Companion$ExistingEventData.action;
        }
        return widgetPreviewGuildScheduledEvent$Companion$ExistingEventData.copy(j, widgetPreviewGuildScheduledEvent$Companion$Action);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildScheduledEventId() {
        return this.guildScheduledEventId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final WidgetPreviewGuildScheduledEvent$Companion$Action getAction() {
        return this.action;
    }

    public final WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData copy(long guildScheduledEventId, WidgetPreviewGuildScheduledEvent$Companion$Action action) {
        m.checkNotNullParameter(action, "action");
        return new WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData(guildScheduledEventId, action);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData)) {
            return false;
        }
        WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData widgetPreviewGuildScheduledEvent$Companion$ExistingEventData = (WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData) other;
        return this.guildScheduledEventId == widgetPreviewGuildScheduledEvent$Companion$ExistingEventData.guildScheduledEventId && m.areEqual(this.action, widgetPreviewGuildScheduledEvent$Companion$ExistingEventData.action);
    }

    public final WidgetPreviewGuildScheduledEvent$Companion$Action getAction() {
        return this.action;
    }

    public final long getGuildScheduledEventId() {
        return this.guildScheduledEventId;
    }

    public int hashCode() {
        int iA = b.a(this.guildScheduledEventId) * 31;
        WidgetPreviewGuildScheduledEvent$Companion$Action widgetPreviewGuildScheduledEvent$Companion$Action = this.action;
        return iA + (widgetPreviewGuildScheduledEvent$Companion$Action != null ? widgetPreviewGuildScheduledEvent$Companion$Action.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ExistingEventData(guildScheduledEventId=");
        sbU.append(this.guildScheduledEventId);
        sbU.append(", action=");
        sbU.append(this.action);
        sbU.append(")");
        return sbU.toString();
    }
}

package com.discord.widgets.guildscheduledevent;

import b.d.b.a.a;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildScheduledEventSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventSettingsViewModel$ViewState$Initialized extends GuildScheduledEventSettingsViewModel$ViewState {
    private final GuildScheduledEventModel eventModel;
    private final GuildScheduledEvent existingEvent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventSettingsViewModel$ViewState$Initialized(GuildScheduledEventModel guildScheduledEventModel, GuildScheduledEvent guildScheduledEvent) {
        super(null);
        m.checkNotNullParameter(guildScheduledEventModel, "eventModel");
        this.eventModel = guildScheduledEventModel;
        this.existingEvent = guildScheduledEvent;
    }

    public static /* synthetic */ GuildScheduledEventSettingsViewModel$ViewState$Initialized copy$default(GuildScheduledEventSettingsViewModel$ViewState$Initialized guildScheduledEventSettingsViewModel$ViewState$Initialized, GuildScheduledEventModel guildScheduledEventModel, GuildScheduledEvent guildScheduledEvent, int i, Object obj) {
        if ((i & 1) != 0) {
            guildScheduledEventModel = guildScheduledEventSettingsViewModel$ViewState$Initialized.eventModel;
        }
        if ((i & 2) != 0) {
            guildScheduledEvent = guildScheduledEventSettingsViewModel$ViewState$Initialized.existingEvent;
        }
        return guildScheduledEventSettingsViewModel$ViewState$Initialized.copy(guildScheduledEventModel, guildScheduledEvent);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildScheduledEventModel getEventModel() {
        return this.eventModel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final GuildScheduledEvent getExistingEvent() {
        return this.existingEvent;
    }

    public final GuildScheduledEventSettingsViewModel$ViewState$Initialized copy(GuildScheduledEventModel eventModel, GuildScheduledEvent existingEvent) {
        m.checkNotNullParameter(eventModel, "eventModel");
        return new GuildScheduledEventSettingsViewModel$ViewState$Initialized(eventModel, existingEvent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventSettingsViewModel$ViewState$Initialized)) {
            return false;
        }
        GuildScheduledEventSettingsViewModel$ViewState$Initialized guildScheduledEventSettingsViewModel$ViewState$Initialized = (GuildScheduledEventSettingsViewModel$ViewState$Initialized) other;
        return m.areEqual(this.eventModel, guildScheduledEventSettingsViewModel$ViewState$Initialized.eventModel) && m.areEqual(this.existingEvent, guildScheduledEventSettingsViewModel$ViewState$Initialized.existingEvent);
    }

    public final GuildScheduledEventModel getEventModel() {
        return this.eventModel;
    }

    public final GuildScheduledEvent getExistingEvent() {
        return this.existingEvent;
    }

    public int hashCode() {
        GuildScheduledEventModel guildScheduledEventModel = this.eventModel;
        int iHashCode = (guildScheduledEventModel != null ? guildScheduledEventModel.hashCode() : 0) * 31;
        GuildScheduledEvent guildScheduledEvent = this.existingEvent;
        return iHashCode + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Initialized(eventModel=");
        sbU.append(this.eventModel);
        sbU.append(", existingEvent=");
        sbU.append(this.existingEvent);
        sbU.append(")");
        return sbU.toString();
    }
}

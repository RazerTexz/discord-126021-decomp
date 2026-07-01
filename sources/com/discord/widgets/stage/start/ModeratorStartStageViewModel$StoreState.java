package com.discord.widgets.stage.start;

import b.d.b.a.a;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.guild.UserGuildMember;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ModeratorStartStageViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ModeratorStartStageViewModel$StoreState {
    private final boolean canStartEvent;
    private final List<GuildScheduledEvent> channelEvents;
    private final List<UserGuildMember> voiceParticipants;

    public ModeratorStartStageViewModel$StoreState(List<GuildScheduledEvent> list, List<UserGuildMember> list2, boolean z2) {
        m.checkNotNullParameter(list, "channelEvents");
        m.checkNotNullParameter(list2, "voiceParticipants");
        this.channelEvents = list;
        this.voiceParticipants = list2;
        this.canStartEvent = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModeratorStartStageViewModel$StoreState copy$default(ModeratorStartStageViewModel$StoreState moderatorStartStageViewModel$StoreState, List list, List list2, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = moderatorStartStageViewModel$StoreState.channelEvents;
        }
        if ((i & 2) != 0) {
            list2 = moderatorStartStageViewModel$StoreState.voiceParticipants;
        }
        if ((i & 4) != 0) {
            z2 = moderatorStartStageViewModel$StoreState.canStartEvent;
        }
        return moderatorStartStageViewModel$StoreState.copy(list, list2, z2);
    }

    public final List<GuildScheduledEvent> component1() {
        return this.channelEvents;
    }

    public final List<UserGuildMember> component2() {
        return this.voiceParticipants;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getCanStartEvent() {
        return this.canStartEvent;
    }

    public final ModeratorStartStageViewModel$StoreState copy(List<GuildScheduledEvent> channelEvents, List<UserGuildMember> voiceParticipants, boolean canStartEvent) {
        m.checkNotNullParameter(channelEvents, "channelEvents");
        m.checkNotNullParameter(voiceParticipants, "voiceParticipants");
        return new ModeratorStartStageViewModel$StoreState(channelEvents, voiceParticipants, canStartEvent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModeratorStartStageViewModel$StoreState)) {
            return false;
        }
        ModeratorStartStageViewModel$StoreState moderatorStartStageViewModel$StoreState = (ModeratorStartStageViewModel$StoreState) other;
        return m.areEqual(this.channelEvents, moderatorStartStageViewModel$StoreState.channelEvents) && m.areEqual(this.voiceParticipants, moderatorStartStageViewModel$StoreState.voiceParticipants) && this.canStartEvent == moderatorStartStageViewModel$StoreState.canStartEvent;
    }

    public final boolean getCanStartEvent() {
        return this.canStartEvent;
    }

    public final List<GuildScheduledEvent> getChannelEvents() {
        return this.channelEvents;
    }

    public final List<UserGuildMember> getVoiceParticipants() {
        return this.voiceParticipants;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        List<GuildScheduledEvent> list = this.channelEvents;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<UserGuildMember> list2 = this.voiceParticipants;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        boolean z2 = this.canStartEvent;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(channelEvents=");
        sbU.append(this.channelEvents);
        sbU.append(", voiceParticipants=");
        sbU.append(this.voiceParticipants);
        sbU.append(", canStartEvent=");
        return a.O(sbU, this.canStartEvent, ")");
    }
}

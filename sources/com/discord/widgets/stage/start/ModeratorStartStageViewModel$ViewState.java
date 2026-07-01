package com.discord.widgets.stage.start;

import b.d.b.a.a;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ModeratorStartStageViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ModeratorStartStageViewModel$ViewState {
    private final boolean channelEventActive;
    private final List<GuildScheduledEvent> channelEvents;
    private final List<ModeratorStartStageItem> items;

    /* JADX WARN: Multi-variable type inference failed */
    public ModeratorStartStageViewModel$ViewState(List<GuildScheduledEvent> list, List<? extends ModeratorStartStageItem> list2, boolean z2) {
        m.checkNotNullParameter(list, "channelEvents");
        m.checkNotNullParameter(list2, "items");
        this.channelEvents = list;
        this.items = list2;
        this.channelEventActive = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModeratorStartStageViewModel$ViewState copy$default(ModeratorStartStageViewModel$ViewState moderatorStartStageViewModel$ViewState, List list, List list2, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = moderatorStartStageViewModel$ViewState.channelEvents;
        }
        if ((i & 2) != 0) {
            list2 = moderatorStartStageViewModel$ViewState.items;
        }
        if ((i & 4) != 0) {
            z2 = moderatorStartStageViewModel$ViewState.channelEventActive;
        }
        return moderatorStartStageViewModel$ViewState.copy(list, list2, z2);
    }

    public final List<GuildScheduledEvent> component1() {
        return this.channelEvents;
    }

    public final List<ModeratorStartStageItem> component2() {
        return this.items;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getChannelEventActive() {
        return this.channelEventActive;
    }

    public final ModeratorStartStageViewModel$ViewState copy(List<GuildScheduledEvent> channelEvents, List<? extends ModeratorStartStageItem> items, boolean channelEventActive) {
        m.checkNotNullParameter(channelEvents, "channelEvents");
        m.checkNotNullParameter(items, "items");
        return new ModeratorStartStageViewModel$ViewState(channelEvents, items, channelEventActive);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModeratorStartStageViewModel$ViewState)) {
            return false;
        }
        ModeratorStartStageViewModel$ViewState moderatorStartStageViewModel$ViewState = (ModeratorStartStageViewModel$ViewState) other;
        return m.areEqual(this.channelEvents, moderatorStartStageViewModel$ViewState.channelEvents) && m.areEqual(this.items, moderatorStartStageViewModel$ViewState.items) && this.channelEventActive == moderatorStartStageViewModel$ViewState.channelEventActive;
    }

    public final boolean getChannelEventActive() {
        return this.channelEventActive;
    }

    public final List<GuildScheduledEvent> getChannelEvents() {
        return this.channelEvents;
    }

    public final List<ModeratorStartStageItem> getItems() {
        return this.items;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        List<GuildScheduledEvent> list = this.channelEvents;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<ModeratorStartStageItem> list2 = this.items;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        boolean z2 = this.channelEventActive;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(channelEvents=");
        sbU.append(this.channelEvents);
        sbU.append(", items=");
        sbU.append(this.items);
        sbU.append(", channelEventActive=");
        return a.O(sbU, this.channelEventActive, ")");
    }
}

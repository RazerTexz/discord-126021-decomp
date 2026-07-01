package com.discord.widgets.channels.list;

import b.d.b.a.a;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.guild.Guild;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemCategory;
import com.discord.widgets.channels.list.items.ChannelListItemEventsSeparator;
import com.discord.widgets.channels.list.items.ChannelListItemGuildJoinRequest;
import com.discord.widgets.channels.list.items.ChannelListItemInvite;
import com.discord.widgets.channels.list.items.ChannelListItemMfaNotice;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelListModel {
    public static final WidgetChannelListModel$Companion Companion = new WidgetChannelListModel$Companion(null);
    private final List<GuildScheduledEvent> guildScheduledEvents;
    private final boolean isGuildSelected;
    private final List<ChannelListItem> items;
    private final Guild selectedGuild;
    private final boolean showEmptyState;
    private final boolean showPremiumGuildHint;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChannelListModel(Guild guild, List<? extends ChannelListItem> list, boolean z2, boolean z3, boolean z4, List<GuildScheduledEvent> list2) {
        m.checkNotNullParameter(list, "items");
        m.checkNotNullParameter(list2, "guildScheduledEvents");
        this.selectedGuild = guild;
        this.items = list;
        this.isGuildSelected = z2;
        this.showPremiumGuildHint = z3;
        this.showEmptyState = z4;
        this.guildScheduledEvents = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChannelListModel copy$default(WidgetChannelListModel widgetChannelListModel, Guild guild, List list, boolean z2, boolean z3, boolean z4, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = widgetChannelListModel.selectedGuild;
        }
        if ((i & 2) != 0) {
            list = widgetChannelListModel.items;
        }
        List list3 = list;
        if ((i & 4) != 0) {
            z2 = widgetChannelListModel.isGuildSelected;
        }
        boolean z5 = z2;
        if ((i & 8) != 0) {
            z3 = widgetChannelListModel.showPremiumGuildHint;
        }
        boolean z6 = z3;
        if ((i & 16) != 0) {
            z4 = widgetChannelListModel.showEmptyState;
        }
        boolean z7 = z4;
        if ((i & 32) != 0) {
            list2 = widgetChannelListModel.guildScheduledEvents;
        }
        return widgetChannelListModel.copy(guild, list3, z5, z6, z7, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getSelectedGuild() {
        return this.selectedGuild;
    }

    public final List<ChannelListItem> component2() {
        return this.items;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsGuildSelected() {
        return this.isGuildSelected;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getShowPremiumGuildHint() {
        return this.showPremiumGuildHint;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getShowEmptyState() {
        return this.showEmptyState;
    }

    public final List<GuildScheduledEvent> component6() {
        return this.guildScheduledEvents;
    }

    public final WidgetChannelListModel copy(Guild selectedGuild, List<? extends ChannelListItem> items, boolean isGuildSelected, boolean showPremiumGuildHint, boolean showEmptyState, List<GuildScheduledEvent> guildScheduledEvents) {
        m.checkNotNullParameter(items, "items");
        m.checkNotNullParameter(guildScheduledEvents, "guildScheduledEvents");
        return new WidgetChannelListModel(selectedGuild, items, isGuildSelected, showPremiumGuildHint, showEmptyState, guildScheduledEvents);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelListModel)) {
            return false;
        }
        WidgetChannelListModel widgetChannelListModel = (WidgetChannelListModel) other;
        return m.areEqual(this.selectedGuild, widgetChannelListModel.selectedGuild) && m.areEqual(this.items, widgetChannelListModel.items) && this.isGuildSelected == widgetChannelListModel.isGuildSelected && this.showPremiumGuildHint == widgetChannelListModel.showPremiumGuildHint && this.showEmptyState == widgetChannelListModel.showEmptyState && m.areEqual(this.guildScheduledEvents, widgetChannelListModel.guildScheduledEvents);
    }

    public final List<GuildScheduledEvent> getGuildScheduledEvents() {
        return this.guildScheduledEvents;
    }

    public final List<ChannelListItem> getItems() {
        return this.items;
    }

    public final Guild getSelectedGuild() {
        return this.selectedGuild;
    }

    public final boolean getShowEmptyState() {
        return this.showEmptyState;
    }

    public final boolean getShowPremiumGuildHint() {
        return this.showPremiumGuildHint;
    }

    public final boolean getStartsWithPaddedElement() {
        ChannelListItem channelListItem = (ChannelListItem) u.firstOrNull((List) this.items);
        if (channelListItem != null) {
            return (channelListItem instanceof ChannelListItemInvite) || (channelListItem instanceof ChannelListItemMfaNotice) || (channelListItem instanceof ChannelListItemCategory) || (channelListItem instanceof ChannelListItemEventsSeparator) || (channelListItem instanceof ChannelListItemGuildJoinRequest);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Guild guild = this.selectedGuild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        List<ChannelListItem> list = this.items;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.isGuildSelected;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode2 + r2) * 31;
        boolean z3 = this.showPremiumGuildHint;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (i + r3) * 31;
        boolean z4 = this.showEmptyState;
        int i3 = (i2 + (z4 ? 1 : z4)) * 31;
        List<GuildScheduledEvent> list2 = this.guildScheduledEvents;
        return i3 + (list2 != null ? list2.hashCode() : 0);
    }

    public final boolean isGuildSelected() {
        return this.isGuildSelected;
    }

    public String toString() {
        StringBuilder sbU = a.U("WidgetChannelListModel(selectedGuild=");
        sbU.append(this.selectedGuild);
        sbU.append(", items=");
        sbU.append(this.items);
        sbU.append(", isGuildSelected=");
        sbU.append(this.isGuildSelected);
        sbU.append(", showPremiumGuildHint=");
        sbU.append(this.showPremiumGuildHint);
        sbU.append(", showEmptyState=");
        sbU.append(this.showEmptyState);
        sbU.append(", guildScheduledEvents=");
        return a.L(sbU, this.guildScheduledEvents, ")");
    }

    public /* synthetic */ WidgetChannelListModel(Guild guild, List list, boolean z2, boolean z3, boolean z4, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(guild, list, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? false : z4, (i & 32) != 0 ? n.emptyList() : list2);
    }
}

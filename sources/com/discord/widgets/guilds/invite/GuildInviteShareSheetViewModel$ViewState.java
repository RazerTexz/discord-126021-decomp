package com.discord.widgets.guilds.invite;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelInvite$Settings;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildInviteShareSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildInviteShareSheetViewModel$ViewState {
    private final Channel channel;
    private final long guildId;
    private final boolean hasResults;
    private final boolean hasSearchResults;
    private final GuildInvite invite;
    private final ModelInvite$Settings inviteSettings;
    private final List<InviteSuggestionItemV2> inviteSuggestionItems;
    private final String searchQuery;
    private final Map<String, Set<Long>> sentInvites;
    private final boolean showInviteSettings;

    /* JADX WARN: Multi-variable type inference failed */
    public GuildInviteShareSheetViewModel$ViewState(GuildInvite guildInvite, ModelInvite$Settings modelInvite$Settings, List<? extends InviteSuggestionItemV2> list, Channel channel, String str, Map<String, ? extends Set<Long>> map, boolean z2, long j) {
        m.checkNotNullParameter(list, "inviteSuggestionItems");
        m.checkNotNullParameter(str, "searchQuery");
        m.checkNotNullParameter(map, "sentInvites");
        this.invite = guildInvite;
        this.inviteSettings = modelInvite$Settings;
        this.inviteSuggestionItems = list;
        this.channel = channel;
        this.searchQuery = str;
        this.sentInvites = map;
        this.showInviteSettings = z2;
        this.guildId = j;
        this.hasResults = !list.isEmpty();
        this.hasSearchResults = list.size() > 1 && !(list.get(0) instanceof InviteSuggestionItemV2$SearchNoResultsItem);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildInviteShareSheetViewModel$ViewState copy$default(GuildInviteShareSheetViewModel$ViewState guildInviteShareSheetViewModel$ViewState, GuildInvite guildInvite, ModelInvite$Settings modelInvite$Settings, List list, Channel channel, String str, Map map, boolean z2, long j, int i, Object obj) {
        return guildInviteShareSheetViewModel$ViewState.copy((i & 1) != 0 ? guildInviteShareSheetViewModel$ViewState.invite : guildInvite, (i & 2) != 0 ? guildInviteShareSheetViewModel$ViewState.inviteSettings : modelInvite$Settings, (i & 4) != 0 ? guildInviteShareSheetViewModel$ViewState.inviteSuggestionItems : list, (i & 8) != 0 ? guildInviteShareSheetViewModel$ViewState.channel : channel, (i & 16) != 0 ? guildInviteShareSheetViewModel$ViewState.searchQuery : str, (i & 32) != 0 ? guildInviteShareSheetViewModel$ViewState.sentInvites : map, (i & 64) != 0 ? guildInviteShareSheetViewModel$ViewState.showInviteSettings : z2, (i & 128) != 0 ? guildInviteShareSheetViewModel$ViewState.guildId : j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildInvite getInvite() {
        return this.invite;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ModelInvite$Settings getInviteSettings() {
        return this.inviteSettings;
    }

    public final List<InviteSuggestionItemV2> component3() {
        return this.inviteSuggestionItems;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSearchQuery() {
        return this.searchQuery;
    }

    public final Map<String, Set<Long>> component6() {
        return this.sentInvites;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getShowInviteSettings() {
        return this.showInviteSettings;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final GuildInviteShareSheetViewModel$ViewState copy(GuildInvite invite, ModelInvite$Settings inviteSettings, List<? extends InviteSuggestionItemV2> inviteSuggestionItems, Channel channel, String searchQuery, Map<String, ? extends Set<Long>> sentInvites, boolean showInviteSettings, long guildId) {
        m.checkNotNullParameter(inviteSuggestionItems, "inviteSuggestionItems");
        m.checkNotNullParameter(searchQuery, "searchQuery");
        m.checkNotNullParameter(sentInvites, "sentInvites");
        return new GuildInviteShareSheetViewModel$ViewState(invite, inviteSettings, inviteSuggestionItems, channel, searchQuery, sentInvites, showInviteSettings, guildId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildInviteShareSheetViewModel$ViewState)) {
            return false;
        }
        GuildInviteShareSheetViewModel$ViewState guildInviteShareSheetViewModel$ViewState = (GuildInviteShareSheetViewModel$ViewState) other;
        return m.areEqual(this.invite, guildInviteShareSheetViewModel$ViewState.invite) && m.areEqual(this.inviteSettings, guildInviteShareSheetViewModel$ViewState.inviteSettings) && m.areEqual(this.inviteSuggestionItems, guildInviteShareSheetViewModel$ViewState.inviteSuggestionItems) && m.areEqual(this.channel, guildInviteShareSheetViewModel$ViewState.channel) && m.areEqual(this.searchQuery, guildInviteShareSheetViewModel$ViewState.searchQuery) && m.areEqual(this.sentInvites, guildInviteShareSheetViewModel$ViewState.sentInvites) && this.showInviteSettings == guildInviteShareSheetViewModel$ViewState.showInviteSettings && this.guildId == guildInviteShareSheetViewModel$ViewState.guildId;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final boolean getHasResults() {
        return this.hasResults;
    }

    public final boolean getHasSearchResults() {
        return this.hasSearchResults;
    }

    public final GuildInvite getInvite() {
        return this.invite;
    }

    public final ModelInvite$Settings getInviteSettings() {
        return this.inviteSettings;
    }

    public final List<InviteSuggestionItemV2> getInviteSuggestionItems() {
        return this.inviteSuggestionItems;
    }

    public final String getSearchQuery() {
        return this.searchQuery;
    }

    public final Map<String, Set<Long>> getSentInvites() {
        return this.sentInvites;
    }

    public final boolean getShowInviteSettings() {
        return this.showInviteSettings;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        GuildInvite guildInvite = this.invite;
        int iHashCode = (guildInvite != null ? guildInvite.hashCode() : 0) * 31;
        ModelInvite$Settings modelInvite$Settings = this.inviteSettings;
        int iHashCode2 = (iHashCode + (modelInvite$Settings != null ? modelInvite$Settings.hashCode() : 0)) * 31;
        List<InviteSuggestionItemV2> list = this.inviteSuggestionItems;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        Channel channel = this.channel;
        int iHashCode4 = (iHashCode3 + (channel != null ? channel.hashCode() : 0)) * 31;
        String str = this.searchQuery;
        int iHashCode5 = (iHashCode4 + (str != null ? str.hashCode() : 0)) * 31;
        Map<String, Set<Long>> map = this.sentInvites;
        int iHashCode6 = (iHashCode5 + (map != null ? map.hashCode() : 0)) * 31;
        boolean z2 = this.showInviteSettings;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return b.a(this.guildId) + ((iHashCode6 + r1) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(invite=");
        sbU.append(this.invite);
        sbU.append(", inviteSettings=");
        sbU.append(this.inviteSettings);
        sbU.append(", inviteSuggestionItems=");
        sbU.append(this.inviteSuggestionItems);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", searchQuery=");
        sbU.append(this.searchQuery);
        sbU.append(", sentInvites=");
        sbU.append(this.sentInvites);
        sbU.append(", showInviteSettings=");
        sbU.append(this.showInviteSettings);
        sbU.append(", guildId=");
        return a.C(sbU, this.guildId, ")");
    }

    public /* synthetic */ GuildInviteShareSheetViewModel$ViewState(GuildInvite guildInvite, ModelInvite$Settings modelInvite$Settings, List list, Channel channel, String str, Map map, boolean z2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(guildInvite, modelInvite$Settings, list, channel, (i & 16) != 0 ? "" : str, map, z2, j);
    }
}

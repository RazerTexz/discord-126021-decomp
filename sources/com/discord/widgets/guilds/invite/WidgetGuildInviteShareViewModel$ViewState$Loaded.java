package com.discord.widgets.guilds.invite;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildInviteShareViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildInviteShareViewModel$ViewState$Loaded extends WidgetGuildInviteShareViewModel$ViewState {
    private final List<InviteSuggestionItem> inviteSuggestionItems;
    private final String searchQuery;
    private final Map<String, Set<Long>> sentInvites;
    private final boolean showInviteSettings;
    private final WidgetInviteModel widgetInviteModel;

    public /* synthetic */ WidgetGuildInviteShareViewModel$ViewState$Loaded(WidgetInviteModel widgetInviteModel, List list, String str, Map map, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(widgetInviteModel, list, (i & 4) != 0 ? "" : str, map, (i & 16) != 0 ? true : z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetGuildInviteShareViewModel$ViewState$Loaded copy$default(WidgetGuildInviteShareViewModel$ViewState$Loaded widgetGuildInviteShareViewModel$ViewState$Loaded, WidgetInviteModel widgetInviteModel, List list, String str, Map map, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            widgetInviteModel = widgetGuildInviteShareViewModel$ViewState$Loaded.widgetInviteModel;
        }
        if ((i & 2) != 0) {
            list = widgetGuildInviteShareViewModel$ViewState$Loaded.inviteSuggestionItems;
        }
        List list2 = list;
        if ((i & 4) != 0) {
            str = widgetGuildInviteShareViewModel$ViewState$Loaded.searchQuery;
        }
        String str2 = str;
        if ((i & 8) != 0) {
            map = widgetGuildInviteShareViewModel$ViewState$Loaded.sentInvites;
        }
        Map map2 = map;
        if ((i & 16) != 0) {
            z2 = widgetGuildInviteShareViewModel$ViewState$Loaded.showInviteSettings;
        }
        return widgetGuildInviteShareViewModel$ViewState$Loaded.copy(widgetInviteModel, list2, str2, map2, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final WidgetInviteModel getWidgetInviteModel() {
        return this.widgetInviteModel;
    }

    public final List<InviteSuggestionItem> component2() {
        return this.inviteSuggestionItems;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSearchQuery() {
        return this.searchQuery;
    }

    public final Map<String, Set<Long>> component4() {
        return this.sentInvites;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getShowInviteSettings() {
        return this.showInviteSettings;
    }

    public final WidgetGuildInviteShareViewModel$ViewState$Loaded copy(WidgetInviteModel widgetInviteModel, List<? extends InviteSuggestionItem> inviteSuggestionItems, String searchQuery, Map<String, ? extends Set<Long>> sentInvites, boolean showInviteSettings) {
        m.checkNotNullParameter(widgetInviteModel, "widgetInviteModel");
        m.checkNotNullParameter(inviteSuggestionItems, "inviteSuggestionItems");
        m.checkNotNullParameter(searchQuery, "searchQuery");
        m.checkNotNullParameter(sentInvites, "sentInvites");
        return new WidgetGuildInviteShareViewModel$ViewState$Loaded(widgetInviteModel, inviteSuggestionItems, searchQuery, sentInvites, showInviteSettings);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildInviteShareViewModel$ViewState$Loaded)) {
            return false;
        }
        WidgetGuildInviteShareViewModel$ViewState$Loaded widgetGuildInviteShareViewModel$ViewState$Loaded = (WidgetGuildInviteShareViewModel$ViewState$Loaded) other;
        return m.areEqual(this.widgetInviteModel, widgetGuildInviteShareViewModel$ViewState$Loaded.widgetInviteModel) && m.areEqual(this.inviteSuggestionItems, widgetGuildInviteShareViewModel$ViewState$Loaded.inviteSuggestionItems) && m.areEqual(this.searchQuery, widgetGuildInviteShareViewModel$ViewState$Loaded.searchQuery) && m.areEqual(this.sentInvites, widgetGuildInviteShareViewModel$ViewState$Loaded.sentInvites) && this.showInviteSettings == widgetGuildInviteShareViewModel$ViewState$Loaded.showInviteSettings;
    }

    public final List<InviteSuggestionItem> getInviteSuggestionItems() {
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

    public final WidgetInviteModel getWidgetInviteModel() {
        return this.widgetInviteModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        WidgetInviteModel widgetInviteModel = this.widgetInviteModel;
        int iHashCode = (widgetInviteModel != null ? widgetInviteModel.hashCode() : 0) * 31;
        List<InviteSuggestionItem> list = this.inviteSuggestionItems;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str = this.searchQuery;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Map<String, Set<Long>> map = this.sentInvites;
        int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
        boolean z2 = this.showInviteSettings;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode4 + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(widgetInviteModel=");
        sbU.append(this.widgetInviteModel);
        sbU.append(", inviteSuggestionItems=");
        sbU.append(this.inviteSuggestionItems);
        sbU.append(", searchQuery=");
        sbU.append(this.searchQuery);
        sbU.append(", sentInvites=");
        sbU.append(this.sentInvites);
        sbU.append(", showInviteSettings=");
        return a.O(sbU, this.showInviteSettings, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetGuildInviteShareViewModel$ViewState$Loaded(WidgetInviteModel widgetInviteModel, List<? extends InviteSuggestionItem> list, String str, Map<String, ? extends Set<Long>> map, boolean z2) {
        super(null);
        m.checkNotNullParameter(widgetInviteModel, "widgetInviteModel");
        m.checkNotNullParameter(list, "inviteSuggestionItems");
        m.checkNotNullParameter(str, "searchQuery");
        m.checkNotNullParameter(map, "sentInvites");
        this.widgetInviteModel = widgetInviteModel;
        this.inviteSuggestionItems = list;
        this.searchQuery = str;
        this.sentInvites = map;
        this.showInviteSettings = z2;
    }
}

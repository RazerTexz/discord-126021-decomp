package com.discord.widgets.contact_sync;

import b.d.b.a.a;
import com.discord.api.friendsuggestions.FriendSuggestion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetContactSyncViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetContactSyncViewModel$Item$FriendSuggestionItem extends WidgetContactSyncViewModel$Item {
    private final String key;
    private final boolean selected;
    private final FriendSuggestion suggestion;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetContactSyncViewModel$Item$FriendSuggestionItem(FriendSuggestion friendSuggestion, boolean z2) {
        super(0, null);
        m.checkNotNullParameter(friendSuggestion, "suggestion");
        this.suggestion = friendSuggestion;
        this.selected = z2;
        this.key = String.valueOf(friendSuggestion.getSuggestedUser().getId());
    }

    public static /* synthetic */ WidgetContactSyncViewModel$Item$FriendSuggestionItem copy$default(WidgetContactSyncViewModel$Item$FriendSuggestionItem widgetContactSyncViewModel$Item$FriendSuggestionItem, FriendSuggestion friendSuggestion, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            friendSuggestion = widgetContactSyncViewModel$Item$FriendSuggestionItem.suggestion;
        }
        if ((i & 2) != 0) {
            z2 = widgetContactSyncViewModel$Item$FriendSuggestionItem.selected;
        }
        return widgetContactSyncViewModel$Item$FriendSuggestionItem.copy(friendSuggestion, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final FriendSuggestion getSuggestion() {
        return this.suggestion;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    public final WidgetContactSyncViewModel$Item$FriendSuggestionItem copy(FriendSuggestion suggestion, boolean selected) {
        m.checkNotNullParameter(suggestion, "suggestion");
        return new WidgetContactSyncViewModel$Item$FriendSuggestionItem(suggestion, selected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetContactSyncViewModel$Item$FriendSuggestionItem)) {
            return false;
        }
        WidgetContactSyncViewModel$Item$FriendSuggestionItem widgetContactSyncViewModel$Item$FriendSuggestionItem = (WidgetContactSyncViewModel$Item$FriendSuggestionItem) other;
        return m.areEqual(this.suggestion, widgetContactSyncViewModel$Item$FriendSuggestionItem.suggestion) && this.selected == widgetContactSyncViewModel$Item$FriendSuggestionItem.selected;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final FriendSuggestion getSuggestion() {
        return this.suggestion;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        FriendSuggestion friendSuggestion = this.suggestion;
        int iHashCode = (friendSuggestion != null ? friendSuggestion.hashCode() : 0) * 31;
        boolean z2 = this.selected;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("FriendSuggestionItem(suggestion=");
        sbU.append(this.suggestion);
        sbU.append(", selected=");
        return a.O(sbU, this.selected, ")");
    }
}

package com.discord.widgets.friends;

import b.d.b.a.a;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class FriendsListViewModel$Item$SuggestedFriendsHeader extends FriendsListViewModel$Item {
    private final int count;
    private final boolean isExpanded;
    private final String key;
    private final boolean showExpandButton;

    public FriendsListViewModel$Item$SuggestedFriendsHeader(int i, boolean z2, boolean z3) {
        super(4, null);
        this.count = i;
        this.isExpanded = z2;
        this.showExpandButton = z3;
        this.key = String.valueOf(getType());
    }

    public static /* synthetic */ FriendsListViewModel$Item$SuggestedFriendsHeader copy$default(FriendsListViewModel$Item$SuggestedFriendsHeader friendsListViewModel$Item$SuggestedFriendsHeader, int i, boolean z2, boolean z3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = friendsListViewModel$Item$SuggestedFriendsHeader.count;
        }
        if ((i2 & 2) != 0) {
            z2 = friendsListViewModel$Item$SuggestedFriendsHeader.isExpanded;
        }
        if ((i2 & 4) != 0) {
            z3 = friendsListViewModel$Item$SuggestedFriendsHeader.showExpandButton;
        }
        return friendsListViewModel$Item$SuggestedFriendsHeader.copy(i, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsExpanded() {
        return this.isExpanded;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getShowExpandButton() {
        return this.showExpandButton;
    }

    public final FriendsListViewModel$Item$SuggestedFriendsHeader copy(int count, boolean isExpanded, boolean showExpandButton) {
        return new FriendsListViewModel$Item$SuggestedFriendsHeader(count, isExpanded, showExpandButton);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FriendsListViewModel$Item$SuggestedFriendsHeader)) {
            return false;
        }
        FriendsListViewModel$Item$SuggestedFriendsHeader friendsListViewModel$Item$SuggestedFriendsHeader = (FriendsListViewModel$Item$SuggestedFriendsHeader) other;
        return this.count == friendsListViewModel$Item$SuggestedFriendsHeader.count && this.isExpanded == friendsListViewModel$Item$SuggestedFriendsHeader.isExpanded && this.showExpandButton == friendsListViewModel$Item$SuggestedFriendsHeader.showExpandButton;
    }

    public final int getCount() {
        return this.count;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final boolean getShowExpandButton() {
        return this.showExpandButton;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int i = this.count * 31;
        boolean z2 = this.isExpanded;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i2 = (i + r1) * 31;
        boolean z3 = this.showExpandButton;
        return i2 + (z3 ? 1 : z3);
    }

    public final boolean isExpanded() {
        return this.isExpanded;
    }

    public String toString() {
        StringBuilder sbU = a.U("SuggestedFriendsHeader(count=");
        sbU.append(this.count);
        sbU.append(", isExpanded=");
        sbU.append(this.isExpanded);
        sbU.append(", showExpandButton=");
        return a.O(sbU, this.showExpandButton, ")");
    }
}

package com.discord.widgets.friends;

import androidx.annotation.StringRes;
import b.d.b.a.a;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class FriendsListViewModel$Item$PendingHeader extends FriendsListViewModel$Item {
    private final int count;
    private final boolean isPendingSectionExpanded;
    private final String key;
    private final boolean showExpandButton;
    private final int titleStringResId;

    public FriendsListViewModel$Item$PendingHeader(@StringRes int i, int i2, boolean z2, boolean z3) {
        super(2, null);
        this.titleStringResId = i;
        this.count = i2;
        this.isPendingSectionExpanded = z2;
        this.showExpandButton = z3;
        this.key = String.valueOf(getType());
    }

    public static /* synthetic */ FriendsListViewModel$Item$PendingHeader copy$default(FriendsListViewModel$Item$PendingHeader friendsListViewModel$Item$PendingHeader, int i, int i2, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = friendsListViewModel$Item$PendingHeader.titleStringResId;
        }
        if ((i3 & 2) != 0) {
            i2 = friendsListViewModel$Item$PendingHeader.count;
        }
        if ((i3 & 4) != 0) {
            z2 = friendsListViewModel$Item$PendingHeader.isPendingSectionExpanded;
        }
        if ((i3 & 8) != 0) {
            z3 = friendsListViewModel$Item$PendingHeader.showExpandButton;
        }
        return friendsListViewModel$Item$PendingHeader.copy(i, i2, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTitleStringResId() {
        return this.titleStringResId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsPendingSectionExpanded() {
        return this.isPendingSectionExpanded;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getShowExpandButton() {
        return this.showExpandButton;
    }

    public final FriendsListViewModel$Item$PendingHeader copy(@StringRes int titleStringResId, int count, boolean isPendingSectionExpanded, boolean showExpandButton) {
        return new FriendsListViewModel$Item$PendingHeader(titleStringResId, count, isPendingSectionExpanded, showExpandButton);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FriendsListViewModel$Item$PendingHeader)) {
            return false;
        }
        FriendsListViewModel$Item$PendingHeader friendsListViewModel$Item$PendingHeader = (FriendsListViewModel$Item$PendingHeader) other;
        return this.titleStringResId == friendsListViewModel$Item$PendingHeader.titleStringResId && this.count == friendsListViewModel$Item$PendingHeader.count && this.isPendingSectionExpanded == friendsListViewModel$Item$PendingHeader.isPendingSectionExpanded && this.showExpandButton == friendsListViewModel$Item$PendingHeader.showExpandButton;
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

    public final int getTitleStringResId() {
        return this.titleStringResId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int i = ((this.titleStringResId * 31) + this.count) * 31;
        boolean z2 = this.isPendingSectionExpanded;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i2 = (i + r1) * 31;
        boolean z3 = this.showExpandButton;
        return i2 + (z3 ? 1 : z3);
    }

    public final boolean isPendingSectionExpanded() {
        return this.isPendingSectionExpanded;
    }

    public String toString() {
        StringBuilder sbU = a.U("PendingHeader(titleStringResId=");
        sbU.append(this.titleStringResId);
        sbU.append(", count=");
        sbU.append(this.count);
        sbU.append(", isPendingSectionExpanded=");
        sbU.append(this.isPendingSectionExpanded);
        sbU.append(", showExpandButton=");
        return a.O(sbU, this.showExpandButton, ")");
    }
}

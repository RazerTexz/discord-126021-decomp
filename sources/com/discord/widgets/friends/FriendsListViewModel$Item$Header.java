package com.discord.widgets.friends;

import androidx.annotation.StringRes;
import b.d.b.a.a;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class FriendsListViewModel$Item$Header extends FriendsListViewModel$Item {
    private final int count;
    private final String key;
    private final int titleStringResId;

    public FriendsListViewModel$Item$Header(@StringRes int i, int i2) {
        super(3, null);
        this.titleStringResId = i;
        this.count = i2;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(i);
        this.key = sb.toString();
    }

    public static /* synthetic */ FriendsListViewModel$Item$Header copy$default(FriendsListViewModel$Item$Header friendsListViewModel$Item$Header, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = friendsListViewModel$Item$Header.titleStringResId;
        }
        if ((i3 & 2) != 0) {
            i2 = friendsListViewModel$Item$Header.count;
        }
        return friendsListViewModel$Item$Header.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTitleStringResId() {
        return this.titleStringResId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    public final FriendsListViewModel$Item$Header copy(@StringRes int titleStringResId, int count) {
        return new FriendsListViewModel$Item$Header(titleStringResId, count);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FriendsListViewModel$Item$Header)) {
            return false;
        }
        FriendsListViewModel$Item$Header friendsListViewModel$Item$Header = (FriendsListViewModel$Item$Header) other;
        return this.titleStringResId == friendsListViewModel$Item$Header.titleStringResId && this.count == friendsListViewModel$Item$Header.count;
    }

    public final int getCount() {
        return this.count;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final int getTitleStringResId() {
        return this.titleStringResId;
    }

    public int hashCode() {
        return (this.titleStringResId * 31) + this.count;
    }

    public String toString() {
        StringBuilder sbU = a.U("Header(titleStringResId=");
        sbU.append(this.titleStringResId);
        sbU.append(", count=");
        return a.B(sbU, this.count, ")");
    }
}

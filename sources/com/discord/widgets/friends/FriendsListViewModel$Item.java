package com.discord.widgets.friends;

import com.discord.utilities.analytics.Traits$Location$Section;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class FriendsListViewModel$Item implements MGRecyclerDataPayload {
    public static final FriendsListViewModel$Item$Companion Companion = new FriendsListViewModel$Item$Companion(null);
    public static final int TYPE_CONTACT_SYNC_UPSELL = 6;
    public static final int TYPE_FRIEND = 0;
    public static final int TYPE_HEADER = 3;
    public static final int TYPE_PENDING_FRIEND = 1;
    public static final int TYPE_PENDING_HEADER = 2;
    public static final int TYPE_SUGGESTED_FRIEND = 5;
    public static final int TYPE_SUGGESTED_FRIEND_HEADER = 4;
    private final int type;

    private FriendsListViewModel$Item(int i) {
        this.type = i;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public /* synthetic */ FriendsListViewModel$Item(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }
}

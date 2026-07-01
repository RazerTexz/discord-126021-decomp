package com.discord.stores;

import com.discord.utilities.lazy.memberlist.ChannelMemberList;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreChannelMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelMembers$observeChannelMemberList$1 extends o implements Function0<ChannelMemberList> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreChannelMembers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreChannelMembers$observeChannelMemberList$1(StoreChannelMembers storeChannelMembers, long j, long j2) {
        super(0);
        this.this$0 = storeChannelMembers;
        this.$guildId = j;
        this.$channelId = j2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ChannelMemberList invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ChannelMemberList invoke() {
        return this.this$0.getChannelMemberList(this.$guildId, this.$channelId);
    }
}

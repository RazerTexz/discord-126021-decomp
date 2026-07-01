package com.discord.stores;

import com.discord.utilities.lazy.memberlist.MemberListRow;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.stores.StoreChannelMembers$handleGuildRoleCreateOrUpdate$$inlined$forEach$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: StoreChannelMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelMembers3 extends Lambda implements Function1<Long, MemberListRow> {
    public final /* synthetic */ boolean $allowOwnerIndicator$inlined;
    public final /* synthetic */ long $guildId$inlined;
    public final /* synthetic */ StoreChannelMembers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreChannelMembers3(StoreChannelMembers storeChannelMembers, long j, boolean z2) {
        super(1);
        this.this$0 = storeChannelMembers;
        this.$guildId$inlined = j;
        this.$allowOwnerIndicator$inlined = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ MemberListRow invoke(Long l) {
        return invoke(l.longValue());
    }

    public final MemberListRow invoke(long j) {
        return this.this$0.makeRowMember(this.$guildId$inlined, j, this.$allowOwnerIndicator$inlined);
    }
}

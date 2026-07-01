package com.discord.stores;

import com.discord.models.domain.ModelGuildMemberListUpdate$Group;
import com.discord.utilities.lazy.memberlist.MemberListRow;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreChannelMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelMembers$handleGuildMemberListUpdate$2 extends o implements Function1<ModelGuildMemberListUpdate$Group, MemberListRow> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreChannelMembers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreChannelMembers$handleGuildMemberListUpdate$2(StoreChannelMembers storeChannelMembers, long j) {
        super(1);
        this.this$0 = storeChannelMembers;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ MemberListRow invoke(ModelGuildMemberListUpdate$Group modelGuildMemberListUpdate$Group) {
        return invoke2(modelGuildMemberListUpdate$Group);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final MemberListRow invoke2(ModelGuildMemberListUpdate$Group modelGuildMemberListUpdate$Group) {
        m.checkNotNullParameter(modelGuildMemberListUpdate$Group, "it");
        return StoreChannelMembers.access$makeGroup(this.this$0, this.$guildId, modelGuildMemberListUpdate$Group);
    }
}

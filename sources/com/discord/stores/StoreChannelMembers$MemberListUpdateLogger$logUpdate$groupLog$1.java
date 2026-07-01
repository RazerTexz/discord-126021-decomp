package com.discord.stores;

import com.discord.models.domain.ModelGuildMemberListUpdate$Group;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreChannelMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelMembers$MemberListUpdateLogger$logUpdate$groupLog$1 extends o implements Function1<ModelGuildMemberListUpdate$Group, CharSequence> {
    public static final StoreChannelMembers$MemberListUpdateLogger$logUpdate$groupLog$1 INSTANCE = new StoreChannelMembers$MemberListUpdateLogger$logUpdate$groupLog$1();

    public StoreChannelMembers$MemberListUpdateLogger$logUpdate$groupLog$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(ModelGuildMemberListUpdate$Group modelGuildMemberListUpdate$Group) {
        return invoke2(modelGuildMemberListUpdate$Group);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(ModelGuildMemberListUpdate$Group modelGuildMemberListUpdate$Group) {
        m.checkNotNullParameter(modelGuildMemberListUpdate$Group, "it");
        return String.valueOf(modelGuildMemberListUpdate$Group.getCount());
    }
}

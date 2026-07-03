package com.discord.stores;

import com.discord.models.domain.ModelGuildMemberListUpdate;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreChannelMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelMembers$MemberListUpdateLogger$logUpdate$groupLog$1 extends AbstractC12240o implements Function1<ModelGuildMemberListUpdate.Group, CharSequence> {
    public static final StoreChannelMembers$MemberListUpdateLogger$logUpdate$groupLog$1 INSTANCE = new StoreChannelMembers$MemberListUpdateLogger$logUpdate$groupLog$1();

    public StoreChannelMembers$MemberListUpdateLogger$logUpdate$groupLog$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(ModelGuildMemberListUpdate.Group group) {
        C12238m.checkNotNullParameter(group, "it");
        return String.valueOf(group.getCount());
    }
}

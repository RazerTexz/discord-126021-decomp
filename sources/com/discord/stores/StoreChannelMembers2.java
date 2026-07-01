package com.discord.stores;

import com.discord.models.domain.ModelGuildMemberListUpdate;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.stores.StoreChannelMembers$MemberListUpdateLogger$logUpdate$groupLog$1, reason: use source file name */
/* JADX INFO: compiled from: StoreChannelMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelMembers2 extends Lambda implements Function1<ModelGuildMemberListUpdate.Group, CharSequence> {
    public static final StoreChannelMembers2 INSTANCE = new StoreChannelMembers2();

    public StoreChannelMembers2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(ModelGuildMemberListUpdate.Group group) {
        Intrinsics3.checkNotNullParameter(group, "it");
        return String.valueOf(group.getCount());
    }
}

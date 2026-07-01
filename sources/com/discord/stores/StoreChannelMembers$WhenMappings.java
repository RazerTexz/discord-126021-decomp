package com.discord.stores;

import com.discord.models.domain.ModelGuildMemberListUpdate$Group$Type;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreChannelMembers$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        ModelGuildMemberListUpdate$Group$Type.values();
        int[] iArr = new int[3];
        $EnumSwitchMapping$0 = iArr;
        iArr[ModelGuildMemberListUpdate$Group$Type.ROLE.ordinal()] = 1;
        iArr[ModelGuildMemberListUpdate$Group$Type.OFFLINE.ordinal()] = 2;
        iArr[ModelGuildMemberListUpdate$Group$Type.ONLINE.ordinal()] = 3;
    }
}

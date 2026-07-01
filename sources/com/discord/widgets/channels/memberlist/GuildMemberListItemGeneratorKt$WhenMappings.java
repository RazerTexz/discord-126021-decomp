package com.discord.widgets.channels.memberlist;

import com.discord.utilities.lazy.memberlist.MemberListRow$StatusHeader$Type;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GuildMemberListItemGeneratorKt$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        MemberListRow$StatusHeader$Type.values();
        int[] iArr = new int[2];
        $EnumSwitchMapping$0 = iArr;
        iArr[MemberListRow$StatusHeader$Type.ONLINE.ordinal()] = 1;
        iArr[MemberListRow$StatusHeader$Type.OFFLINE.ordinal()] = 2;
    }
}

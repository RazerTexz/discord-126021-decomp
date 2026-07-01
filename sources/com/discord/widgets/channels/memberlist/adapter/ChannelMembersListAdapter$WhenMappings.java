package com.discord.widgets.channels.memberlist.adapter;


/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ChannelMembersListAdapter$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;

    static {
        ChannelMembersListAdapter$Item$Header$Type.values();
        int[] iArr = new int[3];
        $EnumSwitchMapping$0 = iArr;
        iArr[ChannelMembersListAdapter$Item$Header$Type.ONLINE.ordinal()] = 1;
        iArr[ChannelMembersListAdapter$Item$Header$Type.OFFLINE.ordinal()] = 2;
        iArr[ChannelMembersListAdapter$Item$Header$Type.GROUP_DM.ordinal()] = 3;
        ChannelMembersListAdapter$ViewType.values();
        int[] iArr2 = new int[7];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[ChannelMembersListAdapter$ViewType.HEADER.ordinal()] = 1;
        iArr2[ChannelMembersListAdapter$ViewType.ROLE_HEADER.ordinal()] = 2;
        iArr2[ChannelMembersListAdapter$ViewType.MEMBER.ordinal()] = 3;
        iArr2[ChannelMembersListAdapter$ViewType.LOADING.ordinal()] = 4;
        iArr2[ChannelMembersListAdapter$ViewType.PLACEHOLDER_HEADER.ordinal()] = 5;
        iArr2[ChannelMembersListAdapter$ViewType.ADD_MEMBER.ordinal()] = 6;
        iArr2[ChannelMembersListAdapter$ViewType.JOIN_LEAVE_THREAD.ordinal()] = 7;
    }
}

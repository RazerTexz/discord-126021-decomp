package com.discord.widgets.channels.memberlist;

import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreEmojiCustom;
import com.discord.stores.StoreGuilds;
import com.discord.utilities.lazy.memberlist.MemberListRow;
import com.discord.utilities.lazy.memberlist.MemberListRow$Member;
import com.discord.utilities.lazy.memberlist.MemberListRow$RoleHeader;
import com.discord.utilities.lazy.memberlist.MemberListRow$StatusHeader;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$Item;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$Item$Header;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$Item$Header$Type;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$Item$Member;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$Item$RoleHeader;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildMemberListItemGenerator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildMemberListItemGeneratorKt$generateGuildMemberListItems$listItems$1 extends o implements Function1<MemberListRow, ChannelMembersListAdapter$Item> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ Guild $guild;
    public final /* synthetic */ Map $guildRoles;
    public final /* synthetic */ StoreEmojiCustom $storeCustomEmojis;
    public final /* synthetic */ StoreGuilds $storeGuilds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMemberListItemGeneratorKt$generateGuildMemberListItems$listItems$1(StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom, Guild guild, Channel channel, Map map) {
        super(1);
        this.$storeGuilds = storeGuilds;
        this.$storeCustomEmojis = storeEmojiCustom;
        this.$guild = guild;
        this.$channel = channel;
        this.$guildRoles = map;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ChannelMembersListAdapter$Item invoke2(MemberListRow memberListRow) {
        ChannelMembersListAdapter$Item channelMembersListAdapter$Item$RoleHeader;
        ChannelMembersListAdapter$Item$Header$Type channelMembersListAdapter$Item$Header$Type;
        m.checkNotNullParameter(memberListRow, "row");
        if (memberListRow instanceof MemberListRow$StatusHeader) {
            String rowId = memberListRow.getRowId();
            MemberListRow$StatusHeader memberListRow$StatusHeader = (MemberListRow$StatusHeader) memberListRow;
            int iOrdinal = memberListRow$StatusHeader.getType().ordinal();
            if (iOrdinal == 0) {
                channelMembersListAdapter$Item$Header$Type = ChannelMembersListAdapter$Item$Header$Type.ONLINE;
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                channelMembersListAdapter$Item$Header$Type = ChannelMembersListAdapter$Item$Header$Type.OFFLINE;
            }
            channelMembersListAdapter$Item$RoleHeader = new ChannelMembersListAdapter$Item$Header(rowId, channelMembersListAdapter$Item$Header$Type, memberListRow$StatusHeader.getMemberCount());
        } else {
            if (memberListRow instanceof MemberListRow$Member) {
                MemberListRow$Member memberListRow$Member = (MemberListRow$Member) memberListRow;
                boolean zAccess$calculateCanDisplayStatusEmoji = GuildMemberListItemGeneratorKt.access$calculateCanDisplayStatusEmoji(this.$storeGuilds, this.$storeCustomEmojis, memberListRow$Member.getUserId(), this.$guild, this.$channel, memberListRow$Member.getPresence(), this.$guildRoles);
                long userId = memberListRow$Member.getUserId();
                Guild guild = this.$guild;
                channelMembersListAdapter$Item$RoleHeader = new ChannelMembersListAdapter$Item$Member(userId, guild != null ? Long.valueOf(guild.getId()) : null, memberListRow$Member.getName(), memberListRow$Member.isBot(), memberListRow$Member.getTagText(), memberListRow$Member.getTagVerified(), memberListRow$Member.getPresence(), memberListRow$Member.getColor(), memberListRow$Member.getAvatarUrl(), memberListRow$Member.getShowOwnerIndicator(), memberListRow$Member.getPremiumSince(), memberListRow$Member.isApplicationStreaming(), zAccess$calculateCanDisplayStatusEmoji, memberListRow$Member.getUserFlags());
            } else {
                if (!(memberListRow instanceof MemberListRow$RoleHeader)) {
                    throw new NoWhenBranchMatchedException();
                }
                MemberListRow$RoleHeader memberListRow$RoleHeader = (MemberListRow$RoleHeader) memberListRow;
                long roleId = memberListRow$RoleHeader.getRoleId();
                String roleName = memberListRow$RoleHeader.getRoleName();
                int memberCount = memberListRow$RoleHeader.getMemberCount();
                Guild guild2 = this.$guild;
                channelMembersListAdapter$Item$RoleHeader = new ChannelMembersListAdapter$Item$RoleHeader(roleId, roleName, memberCount, guild2 != null ? Long.valueOf(guild2.getId()) : null);
            }
        }
        return channelMembersListAdapter$Item$RoleHeader;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ChannelMembersListAdapter$Item invoke(MemberListRow memberListRow) {
        return invoke2(memberListRow);
    }
}

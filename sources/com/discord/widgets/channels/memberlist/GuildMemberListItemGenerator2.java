package com.discord.widgets.channels.memberlist;

import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreEmojiCustom;
import com.discord.stores.StoreGuilds;
import com.discord.utilities.lazy.memberlist.MemberListRow;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.GuildMemberListItemGeneratorKt$generateGuildMemberListItems$listItems$1, reason: use source file name */
/* JADX INFO: compiled from: GuildMemberListItemGenerator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildMemberListItemGenerator2 extends Lambda implements Function1<MemberListRow, ChannelMembersListAdapter.Item> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ Guild $guild;
    public final /* synthetic */ Map $guildRoles;
    public final /* synthetic */ StoreEmojiCustom $storeCustomEmojis;
    public final /* synthetic */ StoreGuilds $storeGuilds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMemberListItemGenerator2(StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom, Guild guild, Channel channel, Map map) {
        super(1);
        this.$storeGuilds = storeGuilds;
        this.$storeCustomEmojis = storeEmojiCustom;
        this.$guild = guild;
        this.$channel = channel;
        this.$guildRoles = map;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ChannelMembersListAdapter.Item invoke(MemberListRow memberListRow) {
        ChannelMembersListAdapter.Item roleHeader;
        ChannelMembersListAdapter.Item.Header.Type type;
        Intrinsics3.checkNotNullParameter(memberListRow, "row");
        if (memberListRow instanceof MemberListRow.StatusHeader) {
            String rowId = memberListRow.getRowId();
            MemberListRow.StatusHeader statusHeader = (MemberListRow.StatusHeader) memberListRow;
            int iOrdinal = statusHeader.getType().ordinal();
            if (iOrdinal == 0) {
                type = ChannelMembersListAdapter.Item.Header.Type.ONLINE;
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                type = ChannelMembersListAdapter.Item.Header.Type.OFFLINE;
            }
            roleHeader = new ChannelMembersListAdapter.Item.Header(rowId, type, statusHeader.getMemberCount());
        } else {
            if (memberListRow instanceof MemberListRow.Member) {
                MemberListRow.Member member = (MemberListRow.Member) memberListRow;
                boolean zCalculateCanDisplayStatusEmoji = GuildMemberListItemGenerator.calculateCanDisplayStatusEmoji(this.$storeGuilds, this.$storeCustomEmojis, member.getUserId(), this.$guild, this.$channel, member.getPresence(), this.$guildRoles);
                long userId = member.getUserId();
                Guild guild = this.$guild;
                roleHeader = new ChannelMembersListAdapter.Item.Member(userId, guild != null ? Long.valueOf(guild.getId()) : null, member.getName(), member.isBot(), member.getTagText(), member.getTagVerified(), member.getPresence(), member.getColor(), member.getAvatarUrl(), member.getShowOwnerIndicator(), member.getPremiumSince(), member.isApplicationStreaming(), zCalculateCanDisplayStatusEmoji, member.getUserFlags());
            } else {
                if (!(memberListRow instanceof MemberListRow.RoleHeader)) {
                    throw new NoWhenBranchMatchedException();
                }
                MemberListRow.RoleHeader roleHeader2 = (MemberListRow.RoleHeader) memberListRow;
                long roleId = roleHeader2.getRoleId();
                String roleName = roleHeader2.getRoleName();
                int memberCount = roleHeader2.getMemberCount();
                Guild guild2 = this.$guild;
                roleHeader = new ChannelMembersListAdapter.Item.RoleHeader(roleId, roleName, memberCount, guild2 != null ? Long.valueOf(guild2.getId()) : null);
            }
        }
        return roleHeader;
    }
}

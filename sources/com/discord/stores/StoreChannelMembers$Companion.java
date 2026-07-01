package com.discord.stores;

import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.lazy.memberlist.MemberListRow$Member;
import com.discord.utilities.user.UserUtils;
import d0.z.d.m;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreChannelMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelMembers$Companion {
    private StoreChannelMembers$Companion() {
    }

    public final MemberListRow$Member makeRowMember(long userId, Map<Long, GuildMember> guildMembers, Map<Long, ? extends User> users, Presence presence, boolean isUserStreaming, boolean showOwnerIndicator) {
        m.checkNotNullParameter(users, "users");
        GuildMember guildMember = guildMembers != null ? guildMembers.get(Long.valueOf(userId)) : null;
        User user = users.get(Long.valueOf(userId));
        if (user == null || guildMember == null) {
            return null;
        }
        return new MemberListRow$Member(userId, GuildMember.Companion.getNickOrUsername(guildMember, user), user.getIsBot(), Integer.valueOf(user.getIsSystemUser() ? 2131896165 : 2131887282), UserUtils.INSTANCE.isVerifiedBot(user), presence, guildMember.getColor() != -16777216 ? Integer.valueOf(guildMember.getColor()) : null, IconUtils.getForGuildMemberOrUser$default(IconUtils.INSTANCE, user, guildMember, null, false, 12, null), showOwnerIndicator, guildMember.getPremiumSince(), isUserStreaming, user.getFlags() | user.getPublicFlags());
    }

    public /* synthetic */ StoreChannelMembers$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

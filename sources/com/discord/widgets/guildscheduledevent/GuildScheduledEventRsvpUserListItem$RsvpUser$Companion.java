package com.discord.widgets.guildscheduledevent;

import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildScheduledEventRsvpUserListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventRsvpUserListItem$RsvpUser$Companion {
    private GuildScheduledEventRsvpUserListItem$RsvpUser$Companion() {
    }

    public final GuildScheduledEventRsvpUserListItem$RsvpUser from(GuildScheduledEventUser guildScheduledEventUser, long guildId) {
        m.checkNotNullParameter(guildScheduledEventUser, "guildScheduledEventUser");
        return new GuildScheduledEventRsvpUserListItem$RsvpUser(guildScheduledEventUser.getUser().getId(), guildScheduledEventUser.getUser().getUsername(), guildScheduledEventUser.getUser().getAvatar(), guildScheduledEventUser.getUser().getDiscriminator(), guildScheduledEventUser.getGuildMember().getNick(), guildScheduledEventUser.getGuildMember().getAvatarHash(), guildId);
    }

    public /* synthetic */ GuildScheduledEventRsvpUserListItem$RsvpUser$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

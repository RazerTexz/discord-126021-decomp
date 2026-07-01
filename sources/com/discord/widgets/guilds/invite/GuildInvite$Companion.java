package com.discord.widgets.guilds.invite;

import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.user.User;
import com.discord.models.domain.ModelInvite;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildInvite$Companion {
    private GuildInvite$Companion() {
    }

    public final GuildInvite createFromModelInvite(ModelInvite invite) {
        boolean zAreEqual;
        m.checkNotNullParameter(invite, "invite");
        GuildScheduledEvent guildScheduledEvent = invite.getGuildScheduledEvent();
        Long lValueOf = null;
        if ((guildScheduledEvent != null ? guildScheduledEvent.getChannelId() : null) != null) {
            GuildScheduledEvent guildScheduledEvent2 = invite.getGuildScheduledEvent();
            Long channelId = guildScheduledEvent2 != null ? guildScheduledEvent2.getChannelId() : null;
            Channel channel = invite.getChannel();
            zAreEqual = m.areEqual(channelId, channel != null ? Long.valueOf(channel.getId()) : null);
        } else {
            zAreEqual = true;
        }
        String str = invite.code;
        m.checkNotNullExpressionValue(str, "invite.code");
        Guild guild = invite.guild;
        Long lValueOf2 = guild != null ? Long.valueOf(guild.getId()) : null;
        Channel channel2 = invite.getChannel();
        Long lValueOf3 = channel2 != null ? Long.valueOf(channel2.getId()) : null;
        User inviter = invite.getInviter();
        Long lValueOf4 = inviter != null ? Long.valueOf(inviter.getId()) : null;
        boolean zIsStatic = invite.isStatic();
        long expirationTime = invite.getExpirationTime();
        if (zAreEqual) {
            GuildScheduledEvent guildScheduledEvent3 = invite.getGuildScheduledEvent();
            if (guildScheduledEvent3 != null) {
                lValueOf = Long.valueOf(guildScheduledEvent3.getId());
            }
        } else if (zAreEqual) {
            throw new NoWhenBranchMatchedException();
        }
        return new GuildInvite(str, lValueOf2, lValueOf3, lValueOf4, zIsStatic, expirationTime, lValueOf);
    }

    public /* synthetic */ GuildInvite$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

package com.discord.widgets.guilds.invite;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.user.User;
import com.discord.models.domain.ModelInvite;
import com.discord.models.invite.InviteUtils;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildInvite implements Serializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Long channelId;
    private final long expirationTimeMs;
    private final Long guildId;
    private final Long guildScheduledEventId;
    private final String inviteCode;
    private final Long inviterId;
    private final boolean isStaticInvite;

    /* JADX INFO: compiled from: GuildInvite.kt */
    public static final class Companion {
        private Companion() {
        }

        public final GuildInvite createFromModelInvite(ModelInvite invite) {
            boolean zAreEqual;
            Intrinsics3.checkNotNullParameter(invite, "invite");
            GuildScheduledEvent guildScheduledEvent = invite.getGuildScheduledEvent();
            Long lValueOf = null;
            if ((guildScheduledEvent != null ? guildScheduledEvent.getChannelId() : null) != null) {
                GuildScheduledEvent guildScheduledEvent2 = invite.getGuildScheduledEvent();
                Long channelId = guildScheduledEvent2 != null ? guildScheduledEvent2.getChannelId() : null;
                Channel channel = invite.getChannel();
                zAreEqual = Intrinsics3.areEqual(channelId, channel != null ? Long.valueOf(channel.getId()) : null);
            } else {
                zAreEqual = true;
            }
            String str = invite.code;
            Intrinsics3.checkNotNullExpressionValue(str, "invite.code");
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

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GuildInvite(String str, Long l, Long l2, Long l3, boolean z2, long j, Long l4) {
        Intrinsics3.checkNotNullParameter(str, "inviteCode");
        this.inviteCode = str;
        this.guildId = l;
        this.channelId = l2;
        this.inviterId = l3;
        this.isStaticInvite = z2;
        this.expirationTimeMs = j;
        this.guildScheduledEventId = l4;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getInviteCode() {
        return this.inviteCode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getInviterId() {
        return this.inviterId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsStaticInvite() {
        return this.isStaticInvite;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getExpirationTimeMs() {
        return this.expirationTimeMs;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Long getGuildScheduledEventId() {
        return this.guildScheduledEventId;
    }

    public final GuildInvite copy(String inviteCode, Long guildId, Long channelId, Long inviterId, boolean isStaticInvite, long expirationTimeMs, Long guildScheduledEventId) {
        Intrinsics3.checkNotNullParameter(inviteCode, "inviteCode");
        return new GuildInvite(inviteCode, guildId, channelId, inviterId, isStaticInvite, expirationTimeMs, guildScheduledEventId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildInvite)) {
            return false;
        }
        GuildInvite guildInvite = (GuildInvite) other;
        return Intrinsics3.areEqual(this.inviteCode, guildInvite.inviteCode) && Intrinsics3.areEqual(this.guildId, guildInvite.guildId) && Intrinsics3.areEqual(this.channelId, guildInvite.channelId) && Intrinsics3.areEqual(this.inviterId, guildInvite.inviterId) && this.isStaticInvite == guildInvite.isStaticInvite && this.expirationTimeMs == guildInvite.expirationTimeMs && Intrinsics3.areEqual(this.guildScheduledEventId, guildInvite.guildScheduledEventId);
    }

    public final Long getChannelId() {
        return this.channelId;
    }

    public final long getExpirationTimeMs() {
        return this.expirationTimeMs;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final Long getGuildScheduledEventId() {
        return this.guildScheduledEventId;
    }

    public final String getInviteCode() {
        return this.inviteCode;
    }

    public final Long getInviterId() {
        return this.inviterId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v20 */
    public int hashCode() {
        String str = this.inviteCode;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.guildId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.channelId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.inviterId;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        boolean z2 = this.isStaticInvite;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int iA = (b.a(this.expirationTimeMs) + ((iHashCode4 + r2) * 31)) * 31;
        Long l4 = this.guildScheduledEventId;
        return iA + (l4 != null ? l4.hashCode() : 0);
    }

    public final boolean isStaticInvite() {
        return this.isStaticInvite;
    }

    public final String toLink() {
        return InviteUtils.INSTANCE.createLinkFromCode(this.inviteCode, this.guildScheduledEventId);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildInvite(inviteCode=");
        sbU.append(this.inviteCode);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", inviterId=");
        sbU.append(this.inviterId);
        sbU.append(", isStaticInvite=");
        sbU.append(this.isStaticInvite);
        sbU.append(", expirationTimeMs=");
        sbU.append(this.expirationTimeMs);
        sbU.append(", guildScheduledEventId=");
        return outline.G(sbU, this.guildScheduledEventId, ")");
    }
}

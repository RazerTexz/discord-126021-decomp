package com.discord.models.domain;

import android.content.res.Resources;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.user.User;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ModelInvite implements Serializable {
    public static final String URL_FORMAT = "%1$s/%2$s";
    public static final String URL_FORMAT_WITH_EVENT = "%1$s/%2$s?event=%3$s";
    private int approximateMemberCount;
    private int approximatePresenceCount;
    private Channel channel;
    public String code;
    private String createdAt;
    public Guild guild;
    private GuildScheduledEvent guildScheduledEvent;
    private User inviter;
    private final boolean isStatic;
    private int maxAge;
    private int maxUses;
    private ModelMemberVerificationForm memberVerificationForm;
    private boolean newMember;
    private boolean revoked;
    private int targetType;
    private boolean temporary;
    private int uses;

    private ModelInvite(Channel channel, String str, Guild guild) {
        this.channel = channel;
        this.code = str;
        this.guild = guild;
        this.isStatic = str != null;
    }

    public static ModelInvite createForStaticUrl(String str, Guild guild) {
        return new ModelInvite(null, str, guild);
    }

    public static ModelInvite createForTesting(Channel channel) {
        return new ModelInvite(channel, null, null);
    }

    public static String getInviteStoreKey(String str, Long l) {
        if (l == null) {
            return str;
        }
        return str + "?event=" + l;
    }

    private boolean isMultiUserDm(Channel channel) {
        return channel.getType() == 3;
    }

    private boolean isPublic(Channel channel) {
        int type = channel.getType();
        return (type == 1 || type == 3) ? false : true;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelInvite;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelInvite)) {
            return false;
        }
        ModelInvite modelInvite = (ModelInvite) obj;
        if (!modelInvite.canEqual(this) || getMaxAge() != modelInvite.getMaxAge() || isRevoked() != modelInvite.isRevoked() || isTemporary() != modelInvite.isTemporary() || getTargetType() != modelInvite.getTargetType() || getUses() != modelInvite.getUses() || getMaxUses() != modelInvite.getMaxUses() || getApproximatePresenceCount() != modelInvite.getApproximatePresenceCount() || getApproximateMemberCount() != modelInvite.getApproximateMemberCount() || isNewMember() != modelInvite.isNewMember() || isStatic() != modelInvite.isStatic()) {
            return false;
        }
        User inviter = getInviter();
        User inviter2 = modelInvite.getInviter();
        if (inviter != null ? !inviter.equals(inviter2) : inviter2 != null) {
            return false;
        }
        Guild guild = getGuild();
        Guild guild2 = modelInvite.getGuild();
        if (guild != null ? !guild.equals(guild2) : guild2 != null) {
            return false;
        }
        ModelMemberVerificationForm memberVerificationForm = getMemberVerificationForm();
        ModelMemberVerificationForm memberVerificationForm2 = modelInvite.getMemberVerificationForm();
        if (memberVerificationForm != null ? !memberVerificationForm.equals(memberVerificationForm2) : memberVerificationForm2 != null) {
            return false;
        }
        GuildScheduledEvent guildScheduledEvent = getGuildScheduledEvent();
        GuildScheduledEvent guildScheduledEvent2 = modelInvite.getGuildScheduledEvent();
        if (guildScheduledEvent != null ? !guildScheduledEvent.equals(guildScheduledEvent2) : guildScheduledEvent2 != null) {
            return false;
        }
        Channel channel = getChannel();
        Channel channel2 = modelInvite.getChannel();
        if (channel != null ? !channel.equals(channel2) : channel2 != null) {
            return false;
        }
        if (getCreatedAt() != modelInvite.getCreatedAt()) {
            return false;
        }
        String code = getCode();
        String code2 = modelInvite.getCode();
        return code != null ? code.equals(code2) : code2 == null;
    }

    public int getApproximateMemberCount() {
        return this.approximateMemberCount;
    }

    public int getApproximatePresenceCount() {
        return this.approximatePresenceCount;
    }

    public Channel getChannel() {
        return this.channel;
    }

    public String getCode() {
        return this.code;
    }

    public long getCreatedAt() {
        return TimeUtils.parseUTCDate(this.createdAt);
    }

    public long getExpirationTime() {
        return getCreatedAt() + ((long) (this.maxAge * 1000));
    }

    public Guild getGuild() {
        return this.guild;
    }

    public GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    public String getInviteType() {
        if (this.channel == null) {
            return null;
        }
        int i = this.targetType;
        ModelInvite$InviteTargetTypes modelInvite$InviteTargetTypes = ModelInvite$InviteTargetTypes.STREAM;
        if (i == ModelInvite$InviteTargetTypes.access$000(modelInvite$InviteTargetTypes)) {
            return ModelInvite$InviteTargetTypes.access$100(modelInvite$InviteTargetTypes);
        }
        int i2 = this.targetType;
        ModelInvite$InviteTargetTypes modelInvite$InviteTargetTypes2 = ModelInvite$InviteTargetTypes.EMBEDDED_APPLICATION;
        if (i2 == ModelInvite$InviteTargetTypes.access$000(modelInvite$InviteTargetTypes2)) {
            return ModelInvite$InviteTargetTypes.access$100(modelInvite$InviteTargetTypes2);
        }
        if (isMultiUserDm(this.channel)) {
            return ModelInvite$InviteTargetTypes.access$100(ModelInvite$InviteTargetTypes.GDM);
        }
        if (isPublic(this.channel)) {
            return ModelInvite$InviteTargetTypes.access$100(ModelInvite$InviteTargetTypes.SERVER);
        }
        return null;
    }

    public User getInviter() {
        return this.inviter;
    }

    public int getMaxAge() {
        return this.maxAge;
    }

    public int getMaxUses() {
        return this.maxUses;
    }

    public ModelMemberVerificationForm getMemberVerificationForm() {
        return this.memberVerificationForm;
    }

    public int getTargetType() {
        return this.targetType;
    }

    public long getTimeToExpirationMillis() {
        return getExpirationTime() - ClockFactory.get().currentTimeMillis();
    }

    public int getUses() {
        return this.uses;
    }

    public int hashCode() {
        int approximateMemberCount = (((getApproximateMemberCount() + ((getApproximatePresenceCount() + ((getMaxUses() + ((getUses() + ((getTargetType() + ((((((getMaxAge() + 59) * 59) + (isRevoked() ? 79 : 97)) * 59) + (isTemporary() ? 79 : 97)) * 59)) * 59)) * 59)) * 59)) * 59)) * 59) + (isNewMember() ? 79 : 97)) * 59;
        int i = isStatic() ? 79 : 97;
        User inviter = getInviter();
        int iHashCode = ((approximateMemberCount + i) * 59) + (inviter == null ? 43 : inviter.hashCode());
        Guild guild = getGuild();
        int iHashCode2 = (iHashCode * 59) + (guild == null ? 43 : guild.hashCode());
        ModelMemberVerificationForm memberVerificationForm = getMemberVerificationForm();
        int iHashCode3 = (iHashCode2 * 59) + (memberVerificationForm == null ? 43 : memberVerificationForm.hashCode());
        GuildScheduledEvent guildScheduledEvent = getGuildScheduledEvent();
        int iHashCode4 = (iHashCode3 * 59) + (guildScheduledEvent == null ? 43 : guildScheduledEvent.hashCode());
        Channel channel = getChannel();
        int i2 = iHashCode4 * 59;
        int iHashCode5 = channel == null ? 43 : channel.hashCode();
        long createdAt = getCreatedAt();
        int i3 = ((i2 + iHashCode5) * 59) + ((int) (createdAt ^ (createdAt >>> 32)));
        String code = getCode();
        return (i3 * 59) + (code != null ? code.hashCode() : 43);
    }

    public boolean isNewMember() {
        return this.newMember;
    }

    public boolean isRevoked() {
        return this.revoked;
    }

    public boolean isStatic() {
        return this.isStatic;
    }

    public boolean isTemporary() {
        return this.temporary;
    }

    public void setGuildScheduledEvent(GuildScheduledEvent guildScheduledEvent) {
        this.guildScheduledEvent = guildScheduledEvent;
    }

    public String toLink(Resources resources, String str) {
        Channel channel;
        GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
        return (guildScheduledEvent == null || (channel = this.channel) == null || !guildScheduledEvent.p(channel.getId())) ? String.format(URL_FORMAT, str, this.code) : String.format(URL_FORMAT_WITH_EVENT, str, this.code, Long.valueOf(this.guildScheduledEvent.getId()));
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelInvite(inviter=");
        sbU.append(getInviter());
        sbU.append(", guild=");
        sbU.append(getGuild());
        sbU.append(", memberVerificationForm=");
        sbU.append(getMemberVerificationForm());
        sbU.append(", guildScheduledEvent=");
        sbU.append(getGuildScheduledEvent());
        sbU.append(", channel=");
        sbU.append(getChannel());
        sbU.append(", createdAt=");
        sbU.append(getCreatedAt());
        sbU.append(", code=");
        sbU.append(getCode());
        sbU.append(", maxAge=");
        sbU.append(getMaxAge());
        sbU.append(", revoked=");
        sbU.append(isRevoked());
        sbU.append(", temporary=");
        sbU.append(isTemporary());
        sbU.append(", targetType=");
        sbU.append(getTargetType());
        sbU.append(", uses=");
        sbU.append(getUses());
        sbU.append(", maxUses=");
        sbU.append(getMaxUses());
        sbU.append(", approximatePresenceCount=");
        sbU.append(getApproximatePresenceCount());
        sbU.append(", approximateMemberCount=");
        sbU.append(getApproximateMemberCount());
        sbU.append(", newMember=");
        sbU.append(isNewMember());
        sbU.append(", isStatic=");
        sbU.append(isStatic());
        sbU.append(")");
        return sbU.toString();
    }
}

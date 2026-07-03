package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackGuild.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuild {
    private final Long guildId;
    private final Boolean guildIsVip;
    private final Long guildMemberNumRoles;
    private final Long guildMemberPerms;
    private final Long guildNumChannels;
    private final Long guildNumRoles;
    private final Long guildNumTextChannels;
    private final Long guildNumVoiceChannels;
    private final Long guildSizeTotal;
    private final Boolean isMember;
    private final Boolean isOwner;
    private final Long numVoiceChannelsActive;

    public TrackGuild() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095);
    }

    public TrackGuild(Long l, Long l2, Long l3, Long l4, Long l5, Long l6, Long l7, Long l8, Boolean bool, Boolean bool2, Long l9, Boolean bool3) {
        this.guildId = l;
        this.guildSizeTotal = l2;
        this.guildMemberNumRoles = l3;
        this.guildMemberPerms = l4;
        this.guildNumChannels = l5;
        this.guildNumTextChannels = l6;
        this.guildNumVoiceChannels = l7;
        this.guildNumRoles = l8;
        this.guildIsVip = bool;
        this.isMember = bool2;
        this.numVoiceChannelsActive = l9;
        this.isOwner = bool3;
    }

    /* JADX INFO: renamed from: a */
    public static TrackGuild m7530a(TrackGuild trackGuild, Long l, Long l2, Long l3, Long l4, Long l5, Long l6, Long l7, Long l8, Boolean bool, Boolean bool2, Long l9, Boolean bool3, int i) {
        return new TrackGuild((i & 1) != 0 ? trackGuild.guildId : null, (i & 2) != 0 ? trackGuild.guildSizeTotal : null, (i & 4) != 0 ? trackGuild.guildMemberNumRoles : null, (i & 8) != 0 ? trackGuild.guildMemberPerms : null, (i & 16) != 0 ? trackGuild.guildNumChannels : null, (i & 32) != 0 ? trackGuild.guildNumTextChannels : null, (i & 64) != 0 ? trackGuild.guildNumVoiceChannels : null, (i & 128) != 0 ? trackGuild.guildNumRoles : null, (i & 256) != 0 ? trackGuild.guildIsVip : null, (i & 512) != 0 ? trackGuild.isMember : bool2, (i & 1024) != 0 ? trackGuild.numVoiceChannelsActive : null, (i & 2048) != 0 ? trackGuild.isOwner : bool3);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuild)) {
            return false;
        }
        TrackGuild trackGuild = (TrackGuild) other;
        return C12238m.areEqual(this.guildId, trackGuild.guildId) && C12238m.areEqual(this.guildSizeTotal, trackGuild.guildSizeTotal) && C12238m.areEqual(this.guildMemberNumRoles, trackGuild.guildMemberNumRoles) && C12238m.areEqual(this.guildMemberPerms, trackGuild.guildMemberPerms) && C12238m.areEqual(this.guildNumChannels, trackGuild.guildNumChannels) && C12238m.areEqual(this.guildNumTextChannels, trackGuild.guildNumTextChannels) && C12238m.areEqual(this.guildNumVoiceChannels, trackGuild.guildNumVoiceChannels) && C12238m.areEqual(this.guildNumRoles, trackGuild.guildNumRoles) && C12238m.areEqual(this.guildIsVip, trackGuild.guildIsVip) && C12238m.areEqual(this.isMember, trackGuild.isMember) && C12238m.areEqual(this.numVoiceChannelsActive, trackGuild.numVoiceChannelsActive) && C12238m.areEqual(this.isOwner, trackGuild.isOwner);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.guildSizeTotal;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.guildMemberNumRoles;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.guildMemberPerms;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.guildNumChannels;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.guildNumTextChannels;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.guildNumVoiceChannels;
        int iHashCode7 = (iHashCode6 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.guildNumRoles;
        int iHashCode8 = (iHashCode7 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Boolean bool = this.guildIsVip;
        int iHashCode9 = (iHashCode8 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.isMember;
        int iHashCode10 = (iHashCode9 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l9 = this.numVoiceChannelsActive;
        int iHashCode11 = (iHashCode10 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Boolean bool3 = this.isOwner;
        return iHashCode11 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackGuild(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", guildSizeTotal=");
        sbM833U.append(this.guildSizeTotal);
        sbM833U.append(", guildMemberNumRoles=");
        sbM833U.append(this.guildMemberNumRoles);
        sbM833U.append(", guildMemberPerms=");
        sbM833U.append(this.guildMemberPerms);
        sbM833U.append(", guildNumChannels=");
        sbM833U.append(this.guildNumChannels);
        sbM833U.append(", guildNumTextChannels=");
        sbM833U.append(this.guildNumTextChannels);
        sbM833U.append(", guildNumVoiceChannels=");
        sbM833U.append(this.guildNumVoiceChannels);
        sbM833U.append(", guildNumRoles=");
        sbM833U.append(this.guildNumRoles);
        sbM833U.append(", guildIsVip=");
        sbM833U.append(this.guildIsVip);
        sbM833U.append(", isMember=");
        sbM833U.append(this.isMember);
        sbM833U.append(", numVoiceChannelsActive=");
        sbM833U.append(this.numVoiceChannelsActive);
        sbM833U.append(", isOwner=");
        return C1643a.m816D(sbM833U, this.isOwner, ")");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TrackGuild(Long l, Long l2, Long l3, Long l4, Long l5, Long l6, Long l7, Long l8, Boolean bool, Boolean bool2, Long l9, Boolean bool3, int i) {
        this((i & 1) != 0 ? null : l, null, null, null, null, null, null, null, null, null, null, null);
        int i2 = i & 2;
        int i3 = i & 4;
        int i4 = i & 8;
        int i5 = i & 16;
        int i6 = i & 32;
        int i7 = i & 64;
        int i8 = i & 128;
        int i9 = i & 256;
        int i10 = i & 512;
        int i11 = i & 1024;
        int i12 = i & 2048;
    }
}

package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ModelChannelFollowerStatsDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelChannelFollowerStatsDto {
    private final Integer channelsFollowing;
    private final Integer guildMembers;
    private final Integer guildsFollowing;
    private final Integer subscribersGainedSinceLastPost;
    private final Integer subscribersLostSinceLastPost;
    private final Integer usersSeenEver;

    public ModelChannelFollowerStatsDto(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6) {
        this.guildsFollowing = num;
        this.channelsFollowing = num2;
        this.guildMembers = num3;
        this.usersSeenEver = num4;
        this.subscribersGainedSinceLastPost = num5;
        this.subscribersLostSinceLastPost = num6;
    }

    public static /* synthetic */ ModelChannelFollowerStatsDto copy$default(ModelChannelFollowerStatsDto modelChannelFollowerStatsDto, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, int i, Object obj) {
        if ((i & 1) != 0) {
            num = modelChannelFollowerStatsDto.guildsFollowing;
        }
        if ((i & 2) != 0) {
            num2 = modelChannelFollowerStatsDto.channelsFollowing;
        }
        Integer num7 = num2;
        if ((i & 4) != 0) {
            num3 = modelChannelFollowerStatsDto.guildMembers;
        }
        Integer num8 = num3;
        if ((i & 8) != 0) {
            num4 = modelChannelFollowerStatsDto.usersSeenEver;
        }
        Integer num9 = num4;
        if ((i & 16) != 0) {
            num5 = modelChannelFollowerStatsDto.subscribersGainedSinceLastPost;
        }
        Integer num10 = num5;
        if ((i & 32) != 0) {
            num6 = modelChannelFollowerStatsDto.subscribersLostSinceLastPost;
        }
        return modelChannelFollowerStatsDto.copy(num, num7, num8, num9, num10, num6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getGuildsFollowing() {
        return this.guildsFollowing;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getChannelsFollowing() {
        return this.channelsFollowing;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getGuildMembers() {
        return this.guildMembers;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getUsersSeenEver() {
        return this.usersSeenEver;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getSubscribersGainedSinceLastPost() {
        return this.subscribersGainedSinceLastPost;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getSubscribersLostSinceLastPost() {
        return this.subscribersLostSinceLastPost;
    }

    public final ModelChannelFollowerStatsDto copy(Integer guildsFollowing, Integer channelsFollowing, Integer guildMembers, Integer usersSeenEver, Integer subscribersGainedSinceLastPost, Integer subscribersLostSinceLastPost) {
        return new ModelChannelFollowerStatsDto(guildsFollowing, channelsFollowing, guildMembers, usersSeenEver, subscribersGainedSinceLastPost, subscribersLostSinceLastPost);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelChannelFollowerStatsDto)) {
            return false;
        }
        ModelChannelFollowerStatsDto modelChannelFollowerStatsDto = (ModelChannelFollowerStatsDto) other;
        return m.areEqual(this.guildsFollowing, modelChannelFollowerStatsDto.guildsFollowing) && m.areEqual(this.channelsFollowing, modelChannelFollowerStatsDto.channelsFollowing) && m.areEqual(this.guildMembers, modelChannelFollowerStatsDto.guildMembers) && m.areEqual(this.usersSeenEver, modelChannelFollowerStatsDto.usersSeenEver) && m.areEqual(this.subscribersGainedSinceLastPost, modelChannelFollowerStatsDto.subscribersGainedSinceLastPost) && m.areEqual(this.subscribersLostSinceLastPost, modelChannelFollowerStatsDto.subscribersLostSinceLastPost);
    }

    public final Integer getChannelsFollowing() {
        return this.channelsFollowing;
    }

    public final Integer getGuildMembers() {
        return this.guildMembers;
    }

    public final Integer getGuildsFollowing() {
        return this.guildsFollowing;
    }

    public final Integer getSubscribersGainedSinceLastPost() {
        return this.subscribersGainedSinceLastPost;
    }

    public final Integer getSubscribersLostSinceLastPost() {
        return this.subscribersLostSinceLastPost;
    }

    public final Integer getUsersSeenEver() {
        return this.usersSeenEver;
    }

    public int hashCode() {
        Integer num = this.guildsFollowing;
        int iHashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.channelsFollowing;
        int iHashCode2 = (iHashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.guildMembers;
        int iHashCode3 = (iHashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.usersSeenEver;
        int iHashCode4 = (iHashCode3 + (num4 != null ? num4.hashCode() : 0)) * 31;
        Integer num5 = this.subscribersGainedSinceLastPost;
        int iHashCode5 = (iHashCode4 + (num5 != null ? num5.hashCode() : 0)) * 31;
        Integer num6 = this.subscribersLostSinceLastPost;
        return iHashCode5 + (num6 != null ? num6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelChannelFollowerStatsDto(guildsFollowing=");
        sbU.append(this.guildsFollowing);
        sbU.append(", channelsFollowing=");
        sbU.append(this.channelsFollowing);
        sbU.append(", guildMembers=");
        sbU.append(this.guildMembers);
        sbU.append(", usersSeenEver=");
        sbU.append(this.usersSeenEver);
        sbU.append(", subscribersGainedSinceLastPost=");
        sbU.append(this.subscribersGainedSinceLastPost);
        sbU.append(", subscribersLostSinceLastPost=");
        return a.F(sbU, this.subscribersLostSinceLastPost, ")");
    }
}

package com.discord.models.domain;

import b.d.b.a.a;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: ModelChannelFollowerStats.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelChannelFollowerStats {
    public static final ModelChannelFollowerStats$Companion Companion = new ModelChannelFollowerStats$Companion(null);
    private final Integer channelsFollowing;
    private final Integer guildMembers;
    private final Integer guildsFollowing;
    private final long lastFetched;
    private final Integer subscribersGainedSinceLastPost;
    private final Integer subscribersLostSinceLastPost;
    private final Integer usersSeenEver;

    public ModelChannelFollowerStats() {
        this(0L, null, null, null, null, null, null, Opcodes.LAND, null);
    }

    public ModelChannelFollowerStats(long j, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6) {
        this.lastFetched = j;
        this.channelsFollowing = num;
        this.guildMembers = num2;
        this.guildsFollowing = num3;
        this.usersSeenEver = num4;
        this.subscribersGainedSinceLastPost = num5;
        this.subscribersLostSinceLastPost = num6;
    }

    public static /* synthetic */ ModelChannelFollowerStats copy$default(ModelChannelFollowerStats modelChannelFollowerStats, long j, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, int i, Object obj) {
        return modelChannelFollowerStats.copy((i & 1) != 0 ? modelChannelFollowerStats.lastFetched : j, (i & 2) != 0 ? modelChannelFollowerStats.channelsFollowing : num, (i & 4) != 0 ? modelChannelFollowerStats.guildMembers : num2, (i & 8) != 0 ? modelChannelFollowerStats.guildsFollowing : num3, (i & 16) != 0 ? modelChannelFollowerStats.usersSeenEver : num4, (i & 32) != 0 ? modelChannelFollowerStats.subscribersGainedSinceLastPost : num5, (i & 64) != 0 ? modelChannelFollowerStats.subscribersLostSinceLastPost : num6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getLastFetched() {
        return this.lastFetched;
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
    public final Integer getGuildsFollowing() {
        return this.guildsFollowing;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getUsersSeenEver() {
        return this.usersSeenEver;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getSubscribersGainedSinceLastPost() {
        return this.subscribersGainedSinceLastPost;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getSubscribersLostSinceLastPost() {
        return this.subscribersLostSinceLastPost;
    }

    public final ModelChannelFollowerStats copy(long lastFetched, Integer channelsFollowing, Integer guildMembers, Integer guildsFollowing, Integer usersSeenEver, Integer subscribersGainedSinceLastPost, Integer subscribersLostSinceLastPost) {
        return new ModelChannelFollowerStats(lastFetched, channelsFollowing, guildMembers, guildsFollowing, usersSeenEver, subscribersGainedSinceLastPost, subscribersLostSinceLastPost);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelChannelFollowerStats)) {
            return false;
        }
        ModelChannelFollowerStats modelChannelFollowerStats = (ModelChannelFollowerStats) other;
        return this.lastFetched == modelChannelFollowerStats.lastFetched && m.areEqual(this.channelsFollowing, modelChannelFollowerStats.channelsFollowing) && m.areEqual(this.guildMembers, modelChannelFollowerStats.guildMembers) && m.areEqual(this.guildsFollowing, modelChannelFollowerStats.guildsFollowing) && m.areEqual(this.usersSeenEver, modelChannelFollowerStats.usersSeenEver) && m.areEqual(this.subscribersGainedSinceLastPost, modelChannelFollowerStats.subscribersGainedSinceLastPost) && m.areEqual(this.subscribersLostSinceLastPost, modelChannelFollowerStats.subscribersLostSinceLastPost);
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

    public final long getLastFetched() {
        return this.lastFetched;
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
        long j = this.lastFetched;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        Integer num = this.channelsFollowing;
        int iHashCode = (i + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.guildMembers;
        int iHashCode2 = (iHashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.guildsFollowing;
        int iHashCode3 = (iHashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.usersSeenEver;
        int iHashCode4 = (iHashCode3 + (num4 != null ? num4.hashCode() : 0)) * 31;
        Integer num5 = this.subscribersGainedSinceLastPost;
        int iHashCode5 = (iHashCode4 + (num5 != null ? num5.hashCode() : 0)) * 31;
        Integer num6 = this.subscribersLostSinceLastPost;
        return iHashCode5 + (num6 != null ? num6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelChannelFollowerStats(lastFetched=");
        sbU.append(this.lastFetched);
        sbU.append(", channelsFollowing=");
        sbU.append(this.channelsFollowing);
        sbU.append(", guildMembers=");
        sbU.append(this.guildMembers);
        sbU.append(", guildsFollowing=");
        sbU.append(this.guildsFollowing);
        sbU.append(", usersSeenEver=");
        sbU.append(this.usersSeenEver);
        sbU.append(", subscribersGainedSinceLastPost=");
        sbU.append(this.subscribersGainedSinceLastPost);
        sbU.append(", subscribersLostSinceLastPost=");
        return a.F(sbU, this.subscribersLostSinceLastPost, ")");
    }

    public /* synthetic */ ModelChannelFollowerStats(long j, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ClockFactory.get().currentTimeMillis() : j, (i & 2) != 0 ? 0 : num, (i & 4) != 0 ? 0 : num2, (i & 8) != 0 ? 0 : num3, (i & 16) != 0 ? 0 : num4, (i & 32) != 0 ? 0 : num5, (i & 64) != 0 ? 0 : num6);
    }
}

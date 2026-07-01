package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: ModelChannelFollowerStats.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelChannelFollowerStats {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer channelsFollowing;
    private final Integer guildMembers;
    private final Integer guildsFollowing;
    private final long lastFetched;
    private final Integer subscribersGainedSinceLastPost;
    private final Integer subscribersLostSinceLastPost;
    private final Integer usersSeenEver;

    /* JADX INFO: compiled from: ModelChannelFollowerStats.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ModelChannelFollowerStats fromResponse(ModelChannelFollowerStatsDto dto) {
            return dto == null ? new ModelChannelFollowerStats(0L, null, null, null, null, null, null, Opcodes.LAND, null) : new ModelChannelFollowerStats(0L, dto.getChannelsFollowing(), dto.getGuildMembers(), dto.getGuildsFollowing(), dto.getUsersSeenEver(), dto.getSubscribersGainedSinceLastPost(), dto.getSubscribersLostSinceLastPost(), 1, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

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
        return this.lastFetched == modelChannelFollowerStats.lastFetched && Intrinsics3.areEqual(this.channelsFollowing, modelChannelFollowerStats.channelsFollowing) && Intrinsics3.areEqual(this.guildMembers, modelChannelFollowerStats.guildMembers) && Intrinsics3.areEqual(this.guildsFollowing, modelChannelFollowerStats.guildsFollowing) && Intrinsics3.areEqual(this.usersSeenEver, modelChannelFollowerStats.usersSeenEver) && Intrinsics3.areEqual(this.subscribersGainedSinceLastPost, modelChannelFollowerStats.subscribersGainedSinceLastPost) && Intrinsics3.areEqual(this.subscribersLostSinceLastPost, modelChannelFollowerStats.subscribersLostSinceLastPost);
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
        StringBuilder sbU = outline.U("ModelChannelFollowerStats(lastFetched=");
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
        return outline.F(sbU, this.subscribersLostSinceLastPost, ")");
    }

    public /* synthetic */ ModelChannelFollowerStats(long j, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ClockFactory.get().currentTimeMillis() : j, (i & 2) != 0 ? 0 : num, (i & 4) != 0 ? 0 : num2, (i & 8) != 0 ? 0 : num3, (i & 16) != 0 ? 0 : num4, (i & 32) != 0 ? 0 : num5, (i & 64) != 0 ? 0 : num6);
    }
}

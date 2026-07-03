package com.discord.api.stageinstance;

import com.discord.api.guildmember.GuildMember;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: RecommendedStageInstance.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RecommendedStageInstance {
    private final RecommendedStageInstanceGuild guild;
    private final StageInstance instance;
    private final int participantCount;
    private final List<GuildMember> sampleSpeakerMembers;
    private final double score;
    private final int source;
    private final List<Long> speakers;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final StageInstance getInstance() {
        return this.instance;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getParticipantCount() {
        return this.participantCount;
    }

    /* JADX INFO: renamed from: c */
    public final List<GuildMember> m8219c() {
        return this.sampleSpeakerMembers;
    }

    /* JADX INFO: renamed from: d */
    public final List<Long> m8220d() {
        return this.speakers;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecommendedStageInstance)) {
            return false;
        }
        RecommendedStageInstance recommendedStageInstance = (RecommendedStageInstance) other;
        return C12238m.areEqual(this.guild, recommendedStageInstance.guild) && C12238m.areEqual(this.instance, recommendedStageInstance.instance) && C12238m.areEqual(this.speakers, recommendedStageInstance.speakers) && C12238m.areEqual(this.sampleSpeakerMembers, recommendedStageInstance.sampleSpeakerMembers) && this.participantCount == recommendedStageInstance.participantCount && this.source == recommendedStageInstance.source && Double.compare(this.score, recommendedStageInstance.score) == 0;
    }

    public int hashCode() {
        RecommendedStageInstanceGuild recommendedStageInstanceGuild = this.guild;
        int iHashCode = (recommendedStageInstanceGuild != null ? recommendedStageInstanceGuild.hashCode() : 0) * 31;
        StageInstance stageInstance = this.instance;
        int iHashCode2 = (iHashCode + (stageInstance != null ? stageInstance.hashCode() : 0)) * 31;
        List<Long> list = this.speakers;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        List<GuildMember> list2 = this.sampleSpeakerMembers;
        int iHashCode4 = (((((iHashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31) + this.participantCount) * 31) + this.source) * 31;
        long jDoubleToLongBits = Double.doubleToLongBits(this.score);
        return iHashCode4 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("RecommendedStageInstance(guild=");
        sbM833U.append(this.guild);
        sbM833U.append(", instance=");
        sbM833U.append(this.instance);
        sbM833U.append(", speakers=");
        sbM833U.append(this.speakers);
        sbM833U.append(", sampleSpeakerMembers=");
        sbM833U.append(this.sampleSpeakerMembers);
        sbM833U.append(", participantCount=");
        sbM833U.append(this.participantCount);
        sbM833U.append(", source=");
        sbM833U.append(this.source);
        sbM833U.append(", score=");
        sbM833U.append(this.score);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}

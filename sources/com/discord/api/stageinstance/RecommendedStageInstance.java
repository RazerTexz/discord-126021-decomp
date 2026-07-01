package com.discord.api.stageinstance;

import b.d.b.a.a;
import com.discord.api.guildmember.GuildMember;
import d0.z.d.m;
import java.util.List;

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

    public final List<GuildMember> c() {
        return this.sampleSpeakerMembers;
    }

    public final List<Long> d() {
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
        return m.areEqual(this.guild, recommendedStageInstance.guild) && m.areEqual(this.instance, recommendedStageInstance.instance) && m.areEqual(this.speakers, recommendedStageInstance.speakers) && m.areEqual(this.sampleSpeakerMembers, recommendedStageInstance.sampleSpeakerMembers) && this.participantCount == recommendedStageInstance.participantCount && this.source == recommendedStageInstance.source && Double.compare(this.score, recommendedStageInstance.score) == 0;
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
        StringBuilder sbU = a.U("RecommendedStageInstance(guild=");
        sbU.append(this.guild);
        sbU.append(", instance=");
        sbU.append(this.instance);
        sbU.append(", speakers=");
        sbU.append(this.speakers);
        sbU.append(", sampleSpeakerMembers=");
        sbU.append(this.sampleSpeakerMembers);
        sbU.append(", participantCount=");
        sbU.append(this.participantCount);
        sbU.append(", source=");
        sbU.append(this.source);
        sbU.append(", score=");
        sbU.append(this.score);
        sbU.append(")");
        return sbU.toString();
    }
}

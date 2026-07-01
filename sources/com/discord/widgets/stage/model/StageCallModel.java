package com.discord.widgets.stage.model;

import b.d.b.a.a;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem$AudienceItem;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem$SpeakerItem;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StageCallModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StageCallModel {
    public static final StageCallModel$Companion Companion = new StageCallModel$Companion(null);
    private final List<StageCallItem$AudienceItem> audience;
    private final Guild guild;
    private final boolean isLurking;
    private final List<StageMediaParticipant> mediaParticipants;
    private final int myStageRoles;
    private final int numBlockedUsers;
    private final int numSpeakers;
    private final int requestingToSpeakCount;
    private final List<StageCallItem$SpeakerItem> speakerItems;
    private final List<StoreVoiceParticipants$VoiceUser> speakingVoiceUsers;
    private final StageInstance stageInstance;

    private StageCallModel(int i, List<StageCallItem$SpeakerItem> list, List<StageMediaParticipant> list2, List<StageCallItem$AudienceItem> list3, List<StoreVoiceParticipants$VoiceUser> list4, int i2, StageInstance stageInstance, int i3, Guild guild, boolean z2, int i4) {
        this.myStageRoles = i;
        this.speakerItems = list;
        this.mediaParticipants = list2;
        this.audience = list3;
        this.speakingVoiceUsers = list4;
        this.requestingToSpeakCount = i2;
        this.stageInstance = stageInstance;
        this.numBlockedUsers = i3;
        this.guild = guild;
        this.isLurking = z2;
        this.numSpeakers = i4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-YvLQhEs$default, reason: not valid java name */
    public static /* synthetic */ StageCallModel m39copyYvLQhEs$default(StageCallModel stageCallModel, int i, List list, List list2, List list3, List list4, int i2, StageInstance stageInstance, int i3, Guild guild, boolean z2, int i4, int i5, Object obj) {
        return stageCallModel.m41copyYvLQhEs((i5 & 1) != 0 ? stageCallModel.myStageRoles : i, (i5 & 2) != 0 ? stageCallModel.speakerItems : list, (i5 & 4) != 0 ? stageCallModel.mediaParticipants : list2, (i5 & 8) != 0 ? stageCallModel.audience : list3, (i5 & 16) != 0 ? stageCallModel.speakingVoiceUsers : list4, (i5 & 32) != 0 ? stageCallModel.requestingToSpeakCount : i2, (i5 & 64) != 0 ? stageCallModel.stageInstance : stageInstance, (i5 & 128) != 0 ? stageCallModel.numBlockedUsers : i3, (i5 & 256) != 0 ? stageCallModel.guild : guild, (i5 & 512) != 0 ? stageCallModel.isLurking : z2, (i5 & 1024) != 0 ? stageCallModel.numSpeakers : i4);
    }

    /* JADX INFO: renamed from: component1-1LxfuJo, reason: not valid java name and from getter */
    public final int getMyStageRoles() {
        return this.myStageRoles;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsLurking() {
        return this.isLurking;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getNumSpeakers() {
        return this.numSpeakers;
    }

    public final List<StageCallItem$SpeakerItem> component2() {
        return this.speakerItems;
    }

    public final List<StageMediaParticipant> component3() {
        return this.mediaParticipants;
    }

    public final List<StageCallItem$AudienceItem> component4() {
        return this.audience;
    }

    public final List<StoreVoiceParticipants$VoiceUser> component5() {
        return this.speakingVoiceUsers;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getRequestingToSpeakCount() {
        return this.requestingToSpeakCount;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getNumBlockedUsers() {
        return this.numBlockedUsers;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: copy-YvLQhEs, reason: not valid java name */
    public final StageCallModel m41copyYvLQhEs(int myStageRoles, List<StageCallItem$SpeakerItem> speakerItems, List<StageMediaParticipant> mediaParticipants, List<StageCallItem$AudienceItem> audience, List<StoreVoiceParticipants$VoiceUser> speakingVoiceUsers, int requestingToSpeakCount, StageInstance stageInstance, int numBlockedUsers, Guild guild, boolean isLurking, int numSpeakers) {
        m.checkNotNullParameter(speakerItems, "speakerItems");
        m.checkNotNullParameter(mediaParticipants, "mediaParticipants");
        m.checkNotNullParameter(audience, "audience");
        m.checkNotNullParameter(speakingVoiceUsers, "speakingVoiceUsers");
        return new StageCallModel(myStageRoles, speakerItems, mediaParticipants, audience, speakingVoiceUsers, requestingToSpeakCount, stageInstance, numBlockedUsers, guild, isLurking, numSpeakers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StageCallModel)) {
            return false;
        }
        StageCallModel stageCallModel = (StageCallModel) other;
        return this.myStageRoles == stageCallModel.myStageRoles && m.areEqual(this.speakerItems, stageCallModel.speakerItems) && m.areEqual(this.mediaParticipants, stageCallModel.mediaParticipants) && m.areEqual(this.audience, stageCallModel.audience) && m.areEqual(this.speakingVoiceUsers, stageCallModel.speakingVoiceUsers) && this.requestingToSpeakCount == stageCallModel.requestingToSpeakCount && m.areEqual(this.stageInstance, stageCallModel.stageInstance) && this.numBlockedUsers == stageCallModel.numBlockedUsers && m.areEqual(this.guild, stageCallModel.guild) && this.isLurking == stageCallModel.isLurking && this.numSpeakers == stageCallModel.numSpeakers;
    }

    public final List<StageCallItem$AudienceItem> getAudience() {
        return this.audience;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final List<StageMediaParticipant> getMediaParticipants() {
        return this.mediaParticipants;
    }

    /* JADX INFO: renamed from: getMyStageRoles-1LxfuJo, reason: not valid java name */
    public final int m42getMyStageRoles1LxfuJo() {
        return this.myStageRoles;
    }

    public final int getNumBlockedUsers() {
        return this.numBlockedUsers;
    }

    public final int getNumSpeakers() {
        return this.numSpeakers;
    }

    public final int getRequestingToSpeakCount() {
        return this.requestingToSpeakCount;
    }

    public final List<StageCallItem$SpeakerItem> getSpeakerItems() {
        return this.speakerItems;
    }

    public final List<StoreVoiceParticipants$VoiceUser> getSpeakingVoiceUsers() {
        return this.speakingVoiceUsers;
    }

    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19, types: [int] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v27 */
    public int hashCode() {
        int i = this.myStageRoles * 31;
        List<StageCallItem$SpeakerItem> list = this.speakerItems;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        List<StageMediaParticipant> list2 = this.mediaParticipants;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<StageCallItem$AudienceItem> list3 = this.audience;
        int iHashCode3 = (iHashCode2 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<StoreVoiceParticipants$VoiceUser> list4 = this.speakingVoiceUsers;
        int iHashCode4 = (((iHashCode3 + (list4 != null ? list4.hashCode() : 0)) * 31) + this.requestingToSpeakCount) * 31;
        StageInstance stageInstance = this.stageInstance;
        int iHashCode5 = (((iHashCode4 + (stageInstance != null ? stageInstance.hashCode() : 0)) * 31) + this.numBlockedUsers) * 31;
        Guild guild = this.guild;
        int iHashCode6 = (iHashCode5 + (guild != null ? guild.hashCode() : 0)) * 31;
        boolean z2 = this.isLurking;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return ((iHashCode6 + r1) * 31) + this.numSpeakers;
    }

    public final boolean isLurking() {
        return this.isLurking;
    }

    public String toString() {
        StringBuilder sbU = a.U("StageCallModel(myStageRoles=");
        sbU.append(StageRoles.m34toStringimpl(this.myStageRoles));
        sbU.append(", speakerItems=");
        sbU.append(this.speakerItems);
        sbU.append(", mediaParticipants=");
        sbU.append(this.mediaParticipants);
        sbU.append(", audience=");
        sbU.append(this.audience);
        sbU.append(", speakingVoiceUsers=");
        sbU.append(this.speakingVoiceUsers);
        sbU.append(", requestingToSpeakCount=");
        sbU.append(this.requestingToSpeakCount);
        sbU.append(", stageInstance=");
        sbU.append(this.stageInstance);
        sbU.append(", numBlockedUsers=");
        sbU.append(this.numBlockedUsers);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", isLurking=");
        sbU.append(this.isLurking);
        sbU.append(", numSpeakers=");
        return a.B(sbU, this.numSpeakers, ")");
    }

    public /* synthetic */ StageCallModel(int i, List list, List list2, List list3, List list4, int i2, StageInstance stageInstance, int i3, Guild guild, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list, list2, list3, list4, i2, stageInstance, i3, guild, z2, i4);
    }
}

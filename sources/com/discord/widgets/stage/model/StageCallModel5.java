package com.discord.widgets.stage.model;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.stage.model.StageMediaParticipant, reason: use source file name */
/* JADX INFO: compiled from: StageCallModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StageCallModel5 {
    private final Channel channel;
    private final String id;
    private final boolean isBlocked;
    private final boolean isModerator;
    private final StageCallItem.MediaType mediaType;
    private final StoreVoiceParticipants.VoiceUser voiceUser;

    public StageCallModel5(String str, StoreVoiceParticipants.VoiceUser voiceUser, Channel channel, boolean z2, boolean z3, StageCallItem.MediaType mediaType) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(voiceUser, "voiceUser");
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(mediaType, "mediaType");
        this.id = str;
        this.voiceUser = voiceUser;
        this.channel = channel;
        this.isModerator = z2;
        this.isBlocked = z3;
        this.mediaType = mediaType;
    }

    public static /* synthetic */ StageCallModel5 copy$default(StageCallModel5 stageCallModel5, String str, StoreVoiceParticipants.VoiceUser voiceUser, Channel channel, boolean z2, boolean z3, StageCallItem.MediaType mediaType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stageCallModel5.id;
        }
        if ((i & 2) != 0) {
            voiceUser = stageCallModel5.voiceUser;
        }
        StoreVoiceParticipants.VoiceUser voiceUser2 = voiceUser;
        if ((i & 4) != 0) {
            channel = stageCallModel5.channel;
        }
        Channel channel2 = channel;
        if ((i & 8) != 0) {
            z2 = stageCallModel5.isModerator;
        }
        boolean z4 = z2;
        if ((i & 16) != 0) {
            z3 = stageCallModel5.isBlocked;
        }
        boolean z5 = z3;
        if ((i & 32) != 0) {
            mediaType = stageCallModel5.mediaType;
        }
        return stageCallModel5.copy(str, voiceUser2, channel2, z4, z5, mediaType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StoreVoiceParticipants.VoiceUser getVoiceUser() {
        return this.voiceUser;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsModerator() {
        return this.isModerator;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsBlocked() {
        return this.isBlocked;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final StageCallItem.MediaType getMediaType() {
        return this.mediaType;
    }

    public final StageCallModel5 copy(String id2, StoreVoiceParticipants.VoiceUser voiceUser, Channel channel, boolean isModerator, boolean isBlocked, StageCallItem.MediaType mediaType) {
        Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(voiceUser, "voiceUser");
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(mediaType, "mediaType");
        return new StageCallModel5(id2, voiceUser, channel, isModerator, isBlocked, mediaType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StageCallModel5)) {
            return false;
        }
        StageCallModel5 stageCallModel5 = (StageCallModel5) other;
        return Intrinsics3.areEqual(this.id, stageCallModel5.id) && Intrinsics3.areEqual(this.voiceUser, stageCallModel5.voiceUser) && Intrinsics3.areEqual(this.channel, stageCallModel5.channel) && this.isModerator == stageCallModel5.isModerator && this.isBlocked == stageCallModel5.isBlocked && Intrinsics3.areEqual(this.mediaType, stageCallModel5.mediaType);
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final String getId() {
        return this.id;
    }

    public final StageCallItem.MediaType getMediaType() {
        return this.mediaType;
    }

    public final StoreVoiceParticipants.VoiceUser getVoiceUser() {
        return this.voiceUser;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        StoreVoiceParticipants.VoiceUser voiceUser = this.voiceUser;
        int iHashCode2 = (iHashCode + (voiceUser != null ? voiceUser.hashCode() : 0)) * 31;
        Channel channel = this.channel;
        int iHashCode3 = (iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31;
        boolean z2 = this.isModerator;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode3 + r2) * 31;
        boolean z3 = this.isBlocked;
        int i2 = (i + (z3 ? 1 : z3)) * 31;
        StageCallItem.MediaType mediaType = this.mediaType;
        return i2 + (mediaType != null ? mediaType.hashCode() : 0);
    }

    public final boolean isBlocked() {
        return this.isBlocked;
    }

    public final boolean isModerator() {
        return this.isModerator;
    }

    public String toString() {
        StringBuilder sbU = outline.U("StageMediaParticipant(id=");
        sbU.append(this.id);
        sbU.append(", voiceUser=");
        sbU.append(this.voiceUser);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", isModerator=");
        sbU.append(this.isModerator);
        sbU.append(", isBlocked=");
        sbU.append(this.isBlocked);
        sbU.append(", mediaType=");
        sbU.append(this.mediaType);
        sbU.append(")");
        return sbU.toString();
    }
}

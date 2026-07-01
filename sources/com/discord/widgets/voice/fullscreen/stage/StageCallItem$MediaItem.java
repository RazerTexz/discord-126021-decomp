package com.discord.widgets.voice.fullscreen.stage;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.views.calls.VideoCallParticipantView$ParticipantData;
import com.discord.widgets.voice.fullscreen.CallParticipant$UserOrStreamParticipant;
import d0.z.d.m;

/* JADX INFO: compiled from: StageCallItem.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class StageCallItem$MediaItem extends StageCallItem implements StageCallParticipantItem {
    private final Channel channel;
    private final boolean isBlocked;
    private final boolean isModerator;
    private final StageCallItem$MediaType mediaType;
    private final VideoCallParticipantView$ParticipantData participantData;
    private final CallParticipant$UserOrStreamParticipant userOrStreamParticipant;
    private final StoreVoiceParticipants$VoiceUser voiceUser;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageCallItem$MediaItem(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser, Channel channel, boolean z2, boolean z3, StageCallItem$MediaType stageCallItem$MediaType, CallParticipant$UserOrStreamParticipant callParticipant$UserOrStreamParticipant) {
        super("media-" + storeVoiceParticipants$VoiceUser.getUser().getId() + '-' + stageCallItem$MediaType, 6, null);
        m.checkNotNullParameter(storeVoiceParticipants$VoiceUser, "voiceUser");
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(stageCallItem$MediaType, "mediaType");
        m.checkNotNullParameter(callParticipant$UserOrStreamParticipant, "userOrStreamParticipant");
        this.voiceUser = storeVoiceParticipants$VoiceUser;
        this.channel = channel;
        this.isModerator = z2;
        this.isBlocked = z3;
        this.mediaType = stageCallItem$MediaType;
        this.userOrStreamParticipant = callParticipant$UserOrStreamParticipant;
        this.participantData = callParticipant$UserOrStreamParticipant.getParticipantData();
    }

    public static /* synthetic */ StageCallItem$MediaItem copy$default(StageCallItem$MediaItem stageCallItem$MediaItem, StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser, Channel channel, boolean z2, boolean z3, StageCallItem$MediaType stageCallItem$MediaType, CallParticipant$UserOrStreamParticipant callParticipant$UserOrStreamParticipant, int i, Object obj) {
        if ((i & 1) != 0) {
            storeVoiceParticipants$VoiceUser = stageCallItem$MediaItem.getVoiceUser();
        }
        if ((i & 2) != 0) {
            channel = stageCallItem$MediaItem.getChannel();
        }
        Channel channel2 = channel;
        if ((i & 4) != 0) {
            z2 = stageCallItem$MediaItem.isModerator;
        }
        boolean z4 = z2;
        if ((i & 8) != 0) {
            z3 = stageCallItem$MediaItem.isBlocked;
        }
        boolean z5 = z3;
        if ((i & 16) != 0) {
            stageCallItem$MediaType = stageCallItem$MediaItem.mediaType;
        }
        StageCallItem$MediaType stageCallItem$MediaType2 = stageCallItem$MediaType;
        if ((i & 32) != 0) {
            callParticipant$UserOrStreamParticipant = stageCallItem$MediaItem.userOrStreamParticipant;
        }
        return stageCallItem$MediaItem.copy(storeVoiceParticipants$VoiceUser, channel2, z4, z5, stageCallItem$MediaType2, callParticipant$UserOrStreamParticipant);
    }

    public final StoreVoiceParticipants$VoiceUser component1() {
        return getVoiceUser();
    }

    public final Channel component2() {
        return getChannel();
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsModerator() {
        return this.isModerator;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsBlocked() {
        return this.isBlocked;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final StageCallItem$MediaType getMediaType() {
        return this.mediaType;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final CallParticipant$UserOrStreamParticipant getUserOrStreamParticipant() {
        return this.userOrStreamParticipant;
    }

    public final StageCallItem$MediaItem copy(StoreVoiceParticipants$VoiceUser voiceUser, Channel channel, boolean isModerator, boolean isBlocked, StageCallItem$MediaType mediaType, CallParticipant$UserOrStreamParticipant userOrStreamParticipant) {
        m.checkNotNullParameter(voiceUser, "voiceUser");
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(mediaType, "mediaType");
        m.checkNotNullParameter(userOrStreamParticipant, "userOrStreamParticipant");
        return new StageCallItem$MediaItem(voiceUser, channel, isModerator, isBlocked, mediaType, userOrStreamParticipant);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StageCallItem$MediaItem)) {
            return false;
        }
        StageCallItem$MediaItem stageCallItem$MediaItem = (StageCallItem$MediaItem) other;
        return m.areEqual(getVoiceUser(), stageCallItem$MediaItem.getVoiceUser()) && m.areEqual(getChannel(), stageCallItem$MediaItem.getChannel()) && this.isModerator == stageCallItem$MediaItem.isModerator && this.isBlocked == stageCallItem$MediaItem.isBlocked && m.areEqual(this.mediaType, stageCallItem$MediaItem.mediaType) && m.areEqual(this.userOrStreamParticipant, stageCallItem$MediaItem.userOrStreamParticipant);
    }

    @Override // com.discord.widgets.voice.fullscreen.stage.StageCallParticipantItem
    public Channel getChannel() {
        return this.channel;
    }

    public final StageCallItem$MediaType getMediaType() {
        return this.mediaType;
    }

    public final VideoCallParticipantView$ParticipantData getParticipantData() {
        return this.participantData;
    }

    public final CallParticipant$UserOrStreamParticipant getUserOrStreamParticipant() {
        return this.userOrStreamParticipant;
    }

    @Override // com.discord.widgets.voice.fullscreen.stage.StageCallParticipantItem
    public StoreVoiceParticipants$VoiceUser getVoiceUser() {
        return this.voiceUser;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        StoreVoiceParticipants$VoiceUser voiceUser = getVoiceUser();
        int iHashCode = (voiceUser != null ? voiceUser.hashCode() : 0) * 31;
        Channel channel = getChannel();
        int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
        boolean z2 = this.isModerator;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode2 + r2) * 31;
        boolean z3 = this.isBlocked;
        int i2 = (i + (z3 ? 1 : z3)) * 31;
        StageCallItem$MediaType stageCallItem$MediaType = this.mediaType;
        int iHashCode3 = (i2 + (stageCallItem$MediaType != null ? stageCallItem$MediaType.hashCode() : 0)) * 31;
        CallParticipant$UserOrStreamParticipant callParticipant$UserOrStreamParticipant = this.userOrStreamParticipant;
        return iHashCode3 + (callParticipant$UserOrStreamParticipant != null ? callParticipant$UserOrStreamParticipant.hashCode() : 0);
    }

    public final boolean isBlocked() {
        return this.isBlocked;
    }

    public final boolean isModerator() {
        return this.isModerator;
    }

    public String toString() {
        StringBuilder sbU = a.U("MediaItem(voiceUser=");
        sbU.append(getVoiceUser());
        sbU.append(", channel=");
        sbU.append(getChannel());
        sbU.append(", isModerator=");
        sbU.append(this.isModerator);
        sbU.append(", isBlocked=");
        sbU.append(this.isBlocked);
        sbU.append(", mediaType=");
        sbU.append(this.mediaType);
        sbU.append(", userOrStreamParticipant=");
        sbU.append(this.userOrStreamParticipant);
        sbU.append(")");
        return sbU.toString();
    }
}

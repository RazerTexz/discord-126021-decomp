package com.discord.widgets.voice.fullscreen.stage;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import d0.z.d.m;

/* JADX INFO: compiled from: StageCallItem.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class StageCallItem$SpeakerItem extends StageCallItem implements StageCallParticipantItem {
    private final Channel channel;
    private final boolean isBlocked;
    private final boolean isModerator;
    private final String positionKey;
    private final int speakersPerRow;
    private final StoreVoiceParticipants$VoiceUser voiceUser;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageCallItem$SpeakerItem(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser, Channel channel, boolean z2, String str, int i, boolean z3) {
        super("speaker-" + storeVoiceParticipants$VoiceUser.getUser().getId(), 1, null);
        m.checkNotNullParameter(storeVoiceParticipants$VoiceUser, "voiceUser");
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(str, "positionKey");
        this.voiceUser = storeVoiceParticipants$VoiceUser;
        this.channel = channel;
        this.isModerator = z2;
        this.positionKey = str;
        this.speakersPerRow = i;
        this.isBlocked = z3;
    }

    public static /* synthetic */ StageCallItem$SpeakerItem copy$default(StageCallItem$SpeakerItem stageCallItem$SpeakerItem, StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser, Channel channel, boolean z2, String str, int i, boolean z3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            storeVoiceParticipants$VoiceUser = stageCallItem$SpeakerItem.getVoiceUser();
        }
        if ((i2 & 2) != 0) {
            channel = stageCallItem$SpeakerItem.getChannel();
        }
        Channel channel2 = channel;
        if ((i2 & 4) != 0) {
            z2 = stageCallItem$SpeakerItem.isModerator;
        }
        boolean z4 = z2;
        if ((i2 & 8) != 0) {
            str = stageCallItem$SpeakerItem.positionKey;
        }
        String str2 = str;
        if ((i2 & 16) != 0) {
            i = stageCallItem$SpeakerItem.speakersPerRow;
        }
        int i3 = i;
        if ((i2 & 32) != 0) {
            z3 = stageCallItem$SpeakerItem.isBlocked;
        }
        return stageCallItem$SpeakerItem.copy(storeVoiceParticipants$VoiceUser, channel2, z4, str2, i3, z3);
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
    public final String getPositionKey() {
        return this.positionKey;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getSpeakersPerRow() {
        return this.speakersPerRow;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsBlocked() {
        return this.isBlocked;
    }

    public final StageCallItem$SpeakerItem copy(StoreVoiceParticipants$VoiceUser voiceUser, Channel channel, boolean isModerator, String positionKey, int speakersPerRow, boolean isBlocked) {
        m.checkNotNullParameter(voiceUser, "voiceUser");
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(positionKey, "positionKey");
        return new StageCallItem$SpeakerItem(voiceUser, channel, isModerator, positionKey, speakersPerRow, isBlocked);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StageCallItem$SpeakerItem)) {
            return false;
        }
        StageCallItem$SpeakerItem stageCallItem$SpeakerItem = (StageCallItem$SpeakerItem) other;
        return m.areEqual(getVoiceUser(), stageCallItem$SpeakerItem.getVoiceUser()) && m.areEqual(getChannel(), stageCallItem$SpeakerItem.getChannel()) && this.isModerator == stageCallItem$SpeakerItem.isModerator && m.areEqual(this.positionKey, stageCallItem$SpeakerItem.positionKey) && this.speakersPerRow == stageCallItem$SpeakerItem.speakersPerRow && this.isBlocked == stageCallItem$SpeakerItem.isBlocked;
    }

    @Override // com.discord.widgets.voice.fullscreen.stage.StageCallParticipantItem
    public Channel getChannel() {
        return this.channel;
    }

    public final String getPositionKey() {
        return this.positionKey;
    }

    public final int getSpeakersPerRow() {
        return this.speakersPerRow;
    }

    @Override // com.discord.widgets.voice.fullscreen.stage.StageCallParticipantItem
    public StoreVoiceParticipants$VoiceUser getVoiceUser() {
        return this.voiceUser;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
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
        String str = this.positionKey;
        int iHashCode3 = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.speakersPerRow) * 31;
        boolean z3 = this.isBlocked;
        return iHashCode3 + (z3 ? 1 : z3);
    }

    public final boolean isBlocked() {
        return this.isBlocked;
    }

    public final boolean isModerator() {
        return this.isModerator;
    }

    public String toString() {
        StringBuilder sbU = a.U("SpeakerItem(voiceUser=");
        sbU.append(getVoiceUser());
        sbU.append(", channel=");
        sbU.append(getChannel());
        sbU.append(", isModerator=");
        sbU.append(this.isModerator);
        sbU.append(", positionKey=");
        sbU.append(this.positionKey);
        sbU.append(", speakersPerRow=");
        sbU.append(this.speakersPerRow);
        sbU.append(", isBlocked=");
        return a.O(sbU, this.isBlocked, ")");
    }
}

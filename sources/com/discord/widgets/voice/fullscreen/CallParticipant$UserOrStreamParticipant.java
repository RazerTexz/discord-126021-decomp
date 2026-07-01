package com.discord.widgets.voice.fullscreen;

import b.d.b.a.a;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.views.calls.VideoCallParticipantView$ParticipantData;
import d0.z.d.m;

/* JADX INFO: compiled from: CallParticipant.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class CallParticipant$UserOrStreamParticipant extends CallParticipant {
    private final String id;
    private final VideoCallParticipantView$ParticipantData participantData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallParticipant$UserOrStreamParticipant(VideoCallParticipantView$ParticipantData videoCallParticipantView$ParticipantData) {
        super(null);
        m.checkNotNullParameter(videoCallParticipantView$ParticipantData, "participantData");
        this.participantData = videoCallParticipantView$ParticipantData;
        this.id = videoCallParticipantView$ParticipantData.id;
    }

    public static /* synthetic */ CallParticipant$UserOrStreamParticipant copy$default(CallParticipant$UserOrStreamParticipant callParticipant$UserOrStreamParticipant, VideoCallParticipantView$ParticipantData videoCallParticipantView$ParticipantData, int i, Object obj) {
        if ((i & 1) != 0) {
            videoCallParticipantView$ParticipantData = callParticipant$UserOrStreamParticipant.participantData;
        }
        return callParticipant$UserOrStreamParticipant.copy(videoCallParticipantView$ParticipantData);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final VideoCallParticipantView$ParticipantData getParticipantData() {
        return this.participantData;
    }

    public final CallParticipant$UserOrStreamParticipant copy(VideoCallParticipantView$ParticipantData participantData) {
        m.checkNotNullParameter(participantData, "participantData");
        return new CallParticipant$UserOrStreamParticipant(participantData);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof CallParticipant$UserOrStreamParticipant) && m.areEqual(this.participantData, ((CallParticipant$UserOrStreamParticipant) other).participantData);
        }
        return true;
    }

    @Override // com.discord.widgets.voice.fullscreen.CallParticipant
    public String getId() {
        return this.id;
    }

    public final VideoCallParticipantView$ParticipantData getParticipantData() {
        return this.participantData;
    }

    @Override // com.discord.widgets.voice.fullscreen.CallParticipant
    public boolean hasActiveVideo() {
        VideoCallParticipantView$ParticipantData videoCallParticipantView$ParticipantData = this.participantData;
        VoiceState voiceState = videoCallParticipantView$ParticipantData.voiceParticipant.getVoiceState();
        return (voiceState != null && voiceState.getSelfVideo()) || videoCallParticipantView$ParticipantData.applicationStreamState != null;
    }

    public int hashCode() {
        VideoCallParticipantView$ParticipantData videoCallParticipantView$ParticipantData = this.participantData;
        if (videoCallParticipantView$ParticipantData != null) {
            return videoCallParticipantView$ParticipantData.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("UserOrStreamParticipant(participantData=");
        sbU.append(this.participantData);
        sbU.append(")");
        return sbU.toString();
    }
}

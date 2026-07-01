package com.discord.views.calls;

import android.content.Context;
import android.view.View;
import b.d.b.a.a;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.view.grid.FrameGridLayout$Data;
import d0.z.d.m;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import org.webrtc.RendererCommon$ScalingType;

/* JADX INFO: compiled from: VideoCallParticipantView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class VideoCallParticipantView$ParticipantData implements FrameGridLayout$Data {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final String id;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final StoreVoiceParticipants$VoiceUser voiceParticipant;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final boolean mirrorVideo;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final RendererCommon$ScalingType scalingType;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final RendererCommon$ScalingType scalingTypeMismatchOrientation;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final VideoCallParticipantView$ParticipantData$ApplicationStreamState applicationStreamState;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final VideoCallParticipantView$ParticipantData$Type type;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final boolean showLabel;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final boolean isFocused;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final VideoCallParticipantView$ParticipantData$a streamQualityIndicatorData;

    public VideoCallParticipantView$ParticipantData(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser, boolean z2, RendererCommon$ScalingType rendererCommon$ScalingType, RendererCommon$ScalingType rendererCommon$ScalingType2, VideoCallParticipantView$ParticipantData$ApplicationStreamState videoCallParticipantView$ParticipantData$ApplicationStreamState, VideoCallParticipantView$ParticipantData$Type videoCallParticipantView$ParticipantData$Type, boolean z3, boolean z4, VideoCallParticipantView$ParticipantData$a videoCallParticipantView$ParticipantData$a) {
        m.checkNotNullParameter(storeVoiceParticipants$VoiceUser, "voiceParticipant");
        m.checkNotNullParameter(videoCallParticipantView$ParticipantData$Type, "type");
        this.voiceParticipant = storeVoiceParticipants$VoiceUser;
        this.mirrorVideo = z2;
        this.scalingType = rendererCommon$ScalingType;
        this.scalingTypeMismatchOrientation = rendererCommon$ScalingType2;
        this.applicationStreamState = videoCallParticipantView$ParticipantData$ApplicationStreamState;
        this.type = videoCallParticipantView$ParticipantData$Type;
        this.showLabel = z3;
        this.isFocused = z4;
        this.streamQualityIndicatorData = videoCallParticipantView$ParticipantData$a;
        StringBuilder sb = new StringBuilder();
        sb.append(storeVoiceParticipants$VoiceUser.getUser().getId());
        sb.append(videoCallParticipantView$ParticipantData$Type);
        this.id = sb.toString();
    }

    public static VideoCallParticipantView$ParticipantData a(VideoCallParticipantView$ParticipantData videoCallParticipantView$ParticipantData, StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser, boolean z2, RendererCommon$ScalingType rendererCommon$ScalingType, RendererCommon$ScalingType rendererCommon$ScalingType2, VideoCallParticipantView$ParticipantData$ApplicationStreamState videoCallParticipantView$ParticipantData$ApplicationStreamState, VideoCallParticipantView$ParticipantData$Type videoCallParticipantView$ParticipantData$Type, boolean z3, boolean z4, VideoCallParticipantView$ParticipantData$a videoCallParticipantView$ParticipantData$a, int i) {
        StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser2 = (i & 1) != 0 ? videoCallParticipantView$ParticipantData.voiceParticipant : null;
        boolean z5 = (i & 2) != 0 ? videoCallParticipantView$ParticipantData.mirrorVideo : z2;
        RendererCommon$ScalingType rendererCommon$ScalingType3 = (i & 4) != 0 ? videoCallParticipantView$ParticipantData.scalingType : rendererCommon$ScalingType;
        RendererCommon$ScalingType rendererCommon$ScalingType4 = (i & 8) != 0 ? videoCallParticipantView$ParticipantData.scalingTypeMismatchOrientation : rendererCommon$ScalingType2;
        VideoCallParticipantView$ParticipantData$ApplicationStreamState videoCallParticipantView$ParticipantData$ApplicationStreamState2 = (i & 16) != 0 ? videoCallParticipantView$ParticipantData.applicationStreamState : null;
        VideoCallParticipantView$ParticipantData$Type videoCallParticipantView$ParticipantData$Type2 = (i & 32) != 0 ? videoCallParticipantView$ParticipantData.type : null;
        boolean z6 = (i & 64) != 0 ? videoCallParticipantView$ParticipantData.showLabel : z3;
        boolean z7 = (i & 128) != 0 ? videoCallParticipantView$ParticipantData.isFocused : z4;
        VideoCallParticipantView$ParticipantData$a videoCallParticipantView$ParticipantData$a2 = (i & 256) != 0 ? videoCallParticipantView$ParticipantData.streamQualityIndicatorData : videoCallParticipantView$ParticipantData$a;
        Objects.requireNonNull(videoCallParticipantView$ParticipantData);
        m.checkNotNullParameter(storeVoiceParticipants$VoiceUser2, "voiceParticipant");
        m.checkNotNullParameter(videoCallParticipantView$ParticipantData$Type2, "type");
        return new VideoCallParticipantView$ParticipantData(storeVoiceParticipants$VoiceUser2, z5, rendererCommon$ScalingType3, rendererCommon$ScalingType4, videoCallParticipantView$ParticipantData$ApplicationStreamState2, videoCallParticipantView$ParticipantData$Type2, z6, z7, videoCallParticipantView$ParticipantData$a2);
    }

    public final Integer b() {
        VoiceState voiceState;
        int iOrdinal = this.type.ordinal();
        if (iOrdinal == 0) {
            VoiceState voiceState2 = this.voiceParticipant.getVoiceState();
            if (voiceState2 == null || !voiceState2.getSelfVideo()) {
                return null;
            }
            return this.voiceParticipant.getCallStreamId();
        }
        if (iOrdinal != 1) {
            throw new NoWhenBranchMatchedException();
        }
        VideoCallParticipantView$ParticipantData$ApplicationStreamState videoCallParticipantView$ParticipantData$ApplicationStreamState = this.applicationStreamState;
        if ((videoCallParticipantView$ParticipantData$ApplicationStreamState == VideoCallParticipantView$ParticipantData$ApplicationStreamState.CONNECTING || videoCallParticipantView$ParticipantData$ApplicationStreamState == VideoCallParticipantView$ParticipantData$ApplicationStreamState.ACTIVE || videoCallParticipantView$ParticipantData$ApplicationStreamState == VideoCallParticipantView$ParticipantData$ApplicationStreamState.PAUSED) && (voiceState = this.voiceParticipant.getVoiceState()) != null && voiceState.getSelfStream()) {
            return this.voiceParticipant.getApplicationStreamId();
        }
        return null;
    }

    @Override // com.discord.utilities.view.grid.FrameGridLayout$Data
    public View createView(Context context) {
        m.checkNotNullParameter(context, "context");
        return new VideoCallParticipantView(context, null, 0, 6);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoCallParticipantView$ParticipantData)) {
            return false;
        }
        VideoCallParticipantView$ParticipantData videoCallParticipantView$ParticipantData = (VideoCallParticipantView$ParticipantData) other;
        return m.areEqual(this.voiceParticipant, videoCallParticipantView$ParticipantData.voiceParticipant) && this.mirrorVideo == videoCallParticipantView$ParticipantData.mirrorVideo && m.areEqual(this.scalingType, videoCallParticipantView$ParticipantData.scalingType) && m.areEqual(this.scalingTypeMismatchOrientation, videoCallParticipantView$ParticipantData.scalingTypeMismatchOrientation) && m.areEqual(this.applicationStreamState, videoCallParticipantView$ParticipantData.applicationStreamState) && m.areEqual(this.type, videoCallParticipantView$ParticipantData.type) && this.showLabel == videoCallParticipantView$ParticipantData.showLabel && this.isFocused == videoCallParticipantView$ParticipantData.isFocused && m.areEqual(this.streamQualityIndicatorData, videoCallParticipantView$ParticipantData.streamQualityIndicatorData);
    }

    @Override // com.discord.utilities.view.grid.FrameGridLayout$Data
    public String getId() {
        return this.id;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser = this.voiceParticipant;
        int iHashCode = (storeVoiceParticipants$VoiceUser != null ? storeVoiceParticipants$VoiceUser.hashCode() : 0) * 31;
        boolean z2 = this.mirrorVideo;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        RendererCommon$ScalingType rendererCommon$ScalingType = this.scalingType;
        int iHashCode2 = (i + (rendererCommon$ScalingType != null ? rendererCommon$ScalingType.hashCode() : 0)) * 31;
        RendererCommon$ScalingType rendererCommon$ScalingType2 = this.scalingTypeMismatchOrientation;
        int iHashCode3 = (iHashCode2 + (rendererCommon$ScalingType2 != null ? rendererCommon$ScalingType2.hashCode() : 0)) * 31;
        VideoCallParticipantView$ParticipantData$ApplicationStreamState videoCallParticipantView$ParticipantData$ApplicationStreamState = this.applicationStreamState;
        int iHashCode4 = (iHashCode3 + (videoCallParticipantView$ParticipantData$ApplicationStreamState != null ? videoCallParticipantView$ParticipantData$ApplicationStreamState.hashCode() : 0)) * 31;
        VideoCallParticipantView$ParticipantData$Type videoCallParticipantView$ParticipantData$Type = this.type;
        int iHashCode5 = (iHashCode4 + (videoCallParticipantView$ParticipantData$Type != null ? videoCallParticipantView$ParticipantData$Type.hashCode() : 0)) * 31;
        boolean z3 = this.showLabel;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (iHashCode5 + r3) * 31;
        boolean z4 = this.isFocused;
        int i3 = (i2 + (z4 ? 1 : z4)) * 31;
        VideoCallParticipantView$ParticipantData$a videoCallParticipantView$ParticipantData$a = this.streamQualityIndicatorData;
        return i3 + (videoCallParticipantView$ParticipantData$a != null ? videoCallParticipantView$ParticipantData$a.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ParticipantData(voiceParticipant=");
        sbU.append(this.voiceParticipant);
        sbU.append(", mirrorVideo=");
        sbU.append(this.mirrorVideo);
        sbU.append(", scalingType=");
        sbU.append(this.scalingType);
        sbU.append(", scalingTypeMismatchOrientation=");
        sbU.append(this.scalingTypeMismatchOrientation);
        sbU.append(", applicationStreamState=");
        sbU.append(this.applicationStreamState);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", showLabel=");
        sbU.append(this.showLabel);
        sbU.append(", isFocused=");
        sbU.append(this.isFocused);
        sbU.append(", streamQualityIndicatorData=");
        sbU.append(this.streamQualityIndicatorData);
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VideoCallParticipantView$ParticipantData(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser, boolean z2, RendererCommon$ScalingType rendererCommon$ScalingType, RendererCommon$ScalingType rendererCommon$ScalingType2, VideoCallParticipantView$ParticipantData$ApplicationStreamState videoCallParticipantView$ParticipantData$ApplicationStreamState, VideoCallParticipantView$ParticipantData$Type videoCallParticipantView$ParticipantData$Type, boolean z3, boolean z4, VideoCallParticipantView$ParticipantData$a videoCallParticipantView$ParticipantData$a, int i) {
        this(storeVoiceParticipants$VoiceUser, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? RendererCommon$ScalingType.SCALE_ASPECT_BALANCED : rendererCommon$ScalingType, (i & 8) != 0 ? RendererCommon$ScalingType.SCALE_ASPECT_FIT : rendererCommon$ScalingType2, (i & 16) != 0 ? null : videoCallParticipantView$ParticipantData$ApplicationStreamState, (i & 32) != 0 ? VideoCallParticipantView$ParticipantData$Type.DEFAULT : videoCallParticipantView$ParticipantData$Type, (i & 64) != 0 ? false : z3, (i & 128) != 0 ? false : z4, null);
        int i2 = i & 256;
    }
}

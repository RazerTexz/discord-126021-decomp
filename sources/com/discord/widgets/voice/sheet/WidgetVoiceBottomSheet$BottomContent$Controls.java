package com.discord.widgets.voice.sheet;

import b.d.b.a.a;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$InputMode;
import com.discord.stores.StoreAudioManagerV2$State;
import com.discord.widgets.voice.model.CameraState;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetVoiceBottomSheet$BottomContent$Controls extends WidgetVoiceBottomSheet$BottomContent {
    private final StoreAudioManagerV2$State audioManagerState;
    private final CameraState cameraState;
    private final MediaEngineConnection$InputMode inputMode;
    private final boolean isMuted;
    private final boolean isScreensharing;
    private final boolean showScreenShareSparkle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceBottomSheet$BottomContent$Controls(MediaEngineConnection$InputMode mediaEngineConnection$InputMode, StoreAudioManagerV2$State storeAudioManagerV2$State, boolean z2, CameraState cameraState, boolean z3, boolean z4) {
        super(null);
        m.checkNotNullParameter(mediaEngineConnection$InputMode, "inputMode");
        m.checkNotNullParameter(storeAudioManagerV2$State, "audioManagerState");
        m.checkNotNullParameter(cameraState, "cameraState");
        this.inputMode = mediaEngineConnection$InputMode;
        this.audioManagerState = storeAudioManagerV2$State;
        this.isMuted = z2;
        this.cameraState = cameraState;
        this.showScreenShareSparkle = z3;
        this.isScreensharing = z4;
    }

    public static /* synthetic */ WidgetVoiceBottomSheet$BottomContent$Controls copy$default(WidgetVoiceBottomSheet$BottomContent$Controls widgetVoiceBottomSheet$BottomContent$Controls, MediaEngineConnection$InputMode mediaEngineConnection$InputMode, StoreAudioManagerV2$State storeAudioManagerV2$State, boolean z2, CameraState cameraState, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            mediaEngineConnection$InputMode = widgetVoiceBottomSheet$BottomContent$Controls.inputMode;
        }
        if ((i & 2) != 0) {
            storeAudioManagerV2$State = widgetVoiceBottomSheet$BottomContent$Controls.audioManagerState;
        }
        StoreAudioManagerV2$State storeAudioManagerV2$State2 = storeAudioManagerV2$State;
        if ((i & 4) != 0) {
            z2 = widgetVoiceBottomSheet$BottomContent$Controls.isMuted;
        }
        boolean z5 = z2;
        if ((i & 8) != 0) {
            cameraState = widgetVoiceBottomSheet$BottomContent$Controls.cameraState;
        }
        CameraState cameraState2 = cameraState;
        if ((i & 16) != 0) {
            z3 = widgetVoiceBottomSheet$BottomContent$Controls.showScreenShareSparkle;
        }
        boolean z6 = z3;
        if ((i & 32) != 0) {
            z4 = widgetVoiceBottomSheet$BottomContent$Controls.isScreensharing;
        }
        return widgetVoiceBottomSheet$BottomContent$Controls.copy(mediaEngineConnection$InputMode, storeAudioManagerV2$State2, z5, cameraState2, z6, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MediaEngineConnection$InputMode getInputMode() {
        return this.inputMode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StoreAudioManagerV2$State getAudioManagerState() {
        return this.audioManagerState;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsMuted() {
        return this.isMuted;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final CameraState getCameraState() {
        return this.cameraState;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getShowScreenShareSparkle() {
        return this.showScreenShareSparkle;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsScreensharing() {
        return this.isScreensharing;
    }

    public final WidgetVoiceBottomSheet$BottomContent$Controls copy(MediaEngineConnection$InputMode inputMode, StoreAudioManagerV2$State audioManagerState, boolean isMuted, CameraState cameraState, boolean showScreenShareSparkle, boolean isScreensharing) {
        m.checkNotNullParameter(inputMode, "inputMode");
        m.checkNotNullParameter(audioManagerState, "audioManagerState");
        m.checkNotNullParameter(cameraState, "cameraState");
        return new WidgetVoiceBottomSheet$BottomContent$Controls(inputMode, audioManagerState, isMuted, cameraState, showScreenShareSparkle, isScreensharing);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetVoiceBottomSheet$BottomContent$Controls)) {
            return false;
        }
        WidgetVoiceBottomSheet$BottomContent$Controls widgetVoiceBottomSheet$BottomContent$Controls = (WidgetVoiceBottomSheet$BottomContent$Controls) other;
        return m.areEqual(this.inputMode, widgetVoiceBottomSheet$BottomContent$Controls.inputMode) && m.areEqual(this.audioManagerState, widgetVoiceBottomSheet$BottomContent$Controls.audioManagerState) && this.isMuted == widgetVoiceBottomSheet$BottomContent$Controls.isMuted && m.areEqual(this.cameraState, widgetVoiceBottomSheet$BottomContent$Controls.cameraState) && this.showScreenShareSparkle == widgetVoiceBottomSheet$BottomContent$Controls.showScreenShareSparkle && this.isScreensharing == widgetVoiceBottomSheet$BottomContent$Controls.isScreensharing;
    }

    public final StoreAudioManagerV2$State getAudioManagerState() {
        return this.audioManagerState;
    }

    public final CameraState getCameraState() {
        return this.cameraState;
    }

    public final MediaEngineConnection$InputMode getInputMode() {
        return this.inputMode;
    }

    public final boolean getShowScreenShareSparkle() {
        return this.showScreenShareSparkle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        MediaEngineConnection$InputMode mediaEngineConnection$InputMode = this.inputMode;
        int iHashCode = (mediaEngineConnection$InputMode != null ? mediaEngineConnection$InputMode.hashCode() : 0) * 31;
        StoreAudioManagerV2$State storeAudioManagerV2$State = this.audioManagerState;
        int iHashCode2 = (iHashCode + (storeAudioManagerV2$State != null ? storeAudioManagerV2$State.hashCode() : 0)) * 31;
        boolean z2 = this.isMuted;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode2 + r2) * 31;
        CameraState cameraState = this.cameraState;
        int iHashCode3 = (i + (cameraState != null ? cameraState.hashCode() : 0)) * 31;
        boolean z3 = this.showScreenShareSparkle;
        ?? r1 = z3;
        if (z3) {
            r1 = 1;
        }
        int i2 = (iHashCode3 + r1) * 31;
        boolean z4 = this.isScreensharing;
        return i2 + (z4 ? 1 : z4);
    }

    public final boolean isMuted() {
        return this.isMuted;
    }

    public final boolean isScreensharing() {
        return this.isScreensharing;
    }

    public String toString() {
        StringBuilder sbU = a.U("Controls(inputMode=");
        sbU.append(this.inputMode);
        sbU.append(", audioManagerState=");
        sbU.append(this.audioManagerState);
        sbU.append(", isMuted=");
        sbU.append(this.isMuted);
        sbU.append(", cameraState=");
        sbU.append(this.cameraState);
        sbU.append(", showScreenShareSparkle=");
        sbU.append(this.showScreenShareSparkle);
        sbU.append(", isScreensharing=");
        return a.O(sbU, this.isScreensharing, ")");
    }
}

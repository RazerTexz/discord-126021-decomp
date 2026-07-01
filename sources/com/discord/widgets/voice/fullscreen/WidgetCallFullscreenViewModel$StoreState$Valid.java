package com.discord.widgets.voice.fullscreen;

import b.d.b.a.a;
import com.discord.api.application.ApplicationAsset;
import com.discord.rtcconnection.RtcConnection$Quality;
import com.discord.stores.StoreConnectivity$DelayedState;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.model.StageCallModel;
import com.discord.widgets.voice.model.CallModel;
import d0.z.d.m;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetCallFullscreenViewModel$StoreState$Valid extends WidgetCallFullscreenViewModel$StoreState {
    private final CallModel callModel;
    private final int channelMentionsCount;
    private final StoreConnectivity$DelayedState connectivityState;
    private final Map<Long, ApplicationAsset> embeddedAppBackgrounds;
    private final boolean isScreenReaderEnabled;
    private final boolean isTextInVoiceChannelSelected;
    private final boolean isTextInVoiceEnabled;
    private final Long myPermissions;
    private final StageRoles myStageRoles;
    private final Boolean noiseCancellation;
    private final StageCallModel stageCallModel;
    private final boolean stopOffscreenVideo;
    private final RtcConnection$Quality streamQuality;
    private final float streamVolume;
    private final int totalMentionsCount;
    private final int unreadsCount;

    public /* synthetic */ WidgetCallFullscreenViewModel$StoreState$Valid(CallModel callModel, StageCallModel stageCallModel, Boolean bool, Long l, float f, RtcConnection$Quality rtcConnection$Quality, boolean z2, int i, StoreConnectivity$DelayedState storeConnectivity$DelayedState, StageRoles stageRoles, boolean z3, boolean z4, boolean z5, int i2, int i3, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(callModel, stageCallModel, bool, l, f, rtcConnection$Quality, z2, i, storeConnectivity$DelayedState, stageRoles, z3, z4, z5, i2, i3, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-G15NlYY$default, reason: not valid java name */
    public static /* synthetic */ WidgetCallFullscreenViewModel$StoreState$Valid m65copyG15NlYY$default(WidgetCallFullscreenViewModel$StoreState$Valid widgetCallFullscreenViewModel$StoreState$Valid, CallModel callModel, StageCallModel stageCallModel, Boolean bool, Long l, float f, RtcConnection$Quality rtcConnection$Quality, boolean z2, int i, StoreConnectivity$DelayedState storeConnectivity$DelayedState, StageRoles stageRoles, boolean z3, boolean z4, boolean z5, int i2, int i3, Map map, int i4, Object obj) {
        return widgetCallFullscreenViewModel$StoreState$Valid.m67copyG15NlYY((i4 & 1) != 0 ? widgetCallFullscreenViewModel$StoreState$Valid.callModel : callModel, (i4 & 2) != 0 ? widgetCallFullscreenViewModel$StoreState$Valid.stageCallModel : stageCallModel, (i4 & 4) != 0 ? widgetCallFullscreenViewModel$StoreState$Valid.noiseCancellation : bool, (i4 & 8) != 0 ? widgetCallFullscreenViewModel$StoreState$Valid.myPermissions : l, (i4 & 16) != 0 ? widgetCallFullscreenViewModel$StoreState$Valid.streamVolume : f, (i4 & 32) != 0 ? widgetCallFullscreenViewModel$StoreState$Valid.streamQuality : rtcConnection$Quality, (i4 & 64) != 0 ? widgetCallFullscreenViewModel$StoreState$Valid.isScreenReaderEnabled : z2, (i4 & 128) != 0 ? widgetCallFullscreenViewModel$StoreState$Valid.totalMentionsCount : i, (i4 & 256) != 0 ? widgetCallFullscreenViewModel$StoreState$Valid.connectivityState : storeConnectivity$DelayedState, (i4 & 512) != 0 ? widgetCallFullscreenViewModel$StoreState$Valid.myStageRoles : stageRoles, (i4 & 1024) != 0 ? widgetCallFullscreenViewModel$StoreState$Valid.stopOffscreenVideo : z3, (i4 & 2048) != 0 ? widgetCallFullscreenViewModel$StoreState$Valid.isTextInVoiceEnabled : z4, (i4 & 4096) != 0 ? widgetCallFullscreenViewModel$StoreState$Valid.isTextInVoiceChannelSelected : z5, (i4 & 8192) != 0 ? widgetCallFullscreenViewModel$StoreState$Valid.channelMentionsCount : i2, (i4 & 16384) != 0 ? widgetCallFullscreenViewModel$StoreState$Valid.unreadsCount : i3, (i4 & 32768) != 0 ? widgetCallFullscreenViewModel$StoreState$Valid.embeddedAppBackgrounds : map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CallModel getCallModel() {
        return this.callModel;
    }

    /* JADX INFO: renamed from: component10-twRsX-0, reason: not valid java name and from getter */
    public final StageRoles getMyStageRoles() {
        return this.myStageRoles;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getStopOffscreenVideo() {
        return this.stopOffscreenVideo;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getIsTextInVoiceEnabled() {
        return this.isTextInVoiceEnabled;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getIsTextInVoiceChannelSelected() {
        return this.isTextInVoiceChannelSelected;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getChannelMentionsCount() {
        return this.channelMentionsCount;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getUnreadsCount() {
        return this.unreadsCount;
    }

    public final Map<Long, ApplicationAsset> component16() {
        return this.embeddedAppBackgrounds;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StageCallModel getStageCallModel() {
        return this.stageCallModel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getNoiseCancellation() {
        return this.noiseCancellation;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getMyPermissions() {
        return this.myPermissions;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final float getStreamVolume() {
        return this.streamVolume;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final RtcConnection$Quality getStreamQuality() {
        return this.streamQuality;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsScreenReaderEnabled() {
        return this.isScreenReaderEnabled;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getTotalMentionsCount() {
        return this.totalMentionsCount;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final StoreConnectivity$DelayedState getConnectivityState() {
        return this.connectivityState;
    }

    /* JADX INFO: renamed from: copy-G15NlYY, reason: not valid java name */
    public final WidgetCallFullscreenViewModel$StoreState$Valid m67copyG15NlYY(CallModel callModel, StageCallModel stageCallModel, Boolean noiseCancellation, Long myPermissions, float streamVolume, RtcConnection$Quality streamQuality, boolean isScreenReaderEnabled, int totalMentionsCount, StoreConnectivity$DelayedState connectivityState, StageRoles myStageRoles, boolean stopOffscreenVideo, boolean isTextInVoiceEnabled, boolean isTextInVoiceChannelSelected, int channelMentionsCount, int unreadsCount, Map<Long, ApplicationAsset> embeddedAppBackgrounds) {
        m.checkNotNullParameter(callModel, "callModel");
        m.checkNotNullParameter(connectivityState, "connectivityState");
        m.checkNotNullParameter(embeddedAppBackgrounds, "embeddedAppBackgrounds");
        return new WidgetCallFullscreenViewModel$StoreState$Valid(callModel, stageCallModel, noiseCancellation, myPermissions, streamVolume, streamQuality, isScreenReaderEnabled, totalMentionsCount, connectivityState, myStageRoles, stopOffscreenVideo, isTextInVoiceEnabled, isTextInVoiceChannelSelected, channelMentionsCount, unreadsCount, embeddedAppBackgrounds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetCallFullscreenViewModel$StoreState$Valid)) {
            return false;
        }
        WidgetCallFullscreenViewModel$StoreState$Valid widgetCallFullscreenViewModel$StoreState$Valid = (WidgetCallFullscreenViewModel$StoreState$Valid) other;
        return m.areEqual(this.callModel, widgetCallFullscreenViewModel$StoreState$Valid.callModel) && m.areEqual(this.stageCallModel, widgetCallFullscreenViewModel$StoreState$Valid.stageCallModel) && m.areEqual(this.noiseCancellation, widgetCallFullscreenViewModel$StoreState$Valid.noiseCancellation) && m.areEqual(this.myPermissions, widgetCallFullscreenViewModel$StoreState$Valid.myPermissions) && Float.compare(this.streamVolume, widgetCallFullscreenViewModel$StoreState$Valid.streamVolume) == 0 && m.areEqual(this.streamQuality, widgetCallFullscreenViewModel$StoreState$Valid.streamQuality) && this.isScreenReaderEnabled == widgetCallFullscreenViewModel$StoreState$Valid.isScreenReaderEnabled && this.totalMentionsCount == widgetCallFullscreenViewModel$StoreState$Valid.totalMentionsCount && m.areEqual(this.connectivityState, widgetCallFullscreenViewModel$StoreState$Valid.connectivityState) && m.areEqual(this.myStageRoles, widgetCallFullscreenViewModel$StoreState$Valid.myStageRoles) && this.stopOffscreenVideo == widgetCallFullscreenViewModel$StoreState$Valid.stopOffscreenVideo && this.isTextInVoiceEnabled == widgetCallFullscreenViewModel$StoreState$Valid.isTextInVoiceEnabled && this.isTextInVoiceChannelSelected == widgetCallFullscreenViewModel$StoreState$Valid.isTextInVoiceChannelSelected && this.channelMentionsCount == widgetCallFullscreenViewModel$StoreState$Valid.channelMentionsCount && this.unreadsCount == widgetCallFullscreenViewModel$StoreState$Valid.unreadsCount && m.areEqual(this.embeddedAppBackgrounds, widgetCallFullscreenViewModel$StoreState$Valid.embeddedAppBackgrounds);
    }

    public final CallModel getCallModel() {
        return this.callModel;
    }

    public final int getChannelMentionsCount() {
        return this.channelMentionsCount;
    }

    public final StoreConnectivity$DelayedState getConnectivityState() {
        return this.connectivityState;
    }

    public final Map<Long, ApplicationAsset> getEmbeddedAppBackgrounds() {
        return this.embeddedAppBackgrounds;
    }

    public final Long getMyPermissions() {
        return this.myPermissions;
    }

    /* JADX INFO: renamed from: getMyStageRoles-twRsX-0, reason: not valid java name */
    public final StageRoles m68getMyStageRolestwRsX0() {
        return this.myStageRoles;
    }

    public final Boolean getNoiseCancellation() {
        return this.noiseCancellation;
    }

    public final StageCallModel getStageCallModel() {
        return this.stageCallModel;
    }

    public final boolean getStopOffscreenVideo() {
        return this.stopOffscreenVideo;
    }

    public final RtcConnection$Quality getStreamQuality() {
        return this.streamQuality;
    }

    public final float getStreamVolume() {
        return this.streamVolume;
    }

    public final int getTotalMentionsCount() {
        return this.totalMentionsCount;
    }

    public final int getUnreadsCount() {
        return this.unreadsCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r0v25, types: [int] */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        CallModel callModel = this.callModel;
        int iHashCode = (callModel != null ? callModel.hashCode() : 0) * 31;
        StageCallModel stageCallModel = this.stageCallModel;
        int iHashCode2 = (iHashCode + (stageCallModel != null ? stageCallModel.hashCode() : 0)) * 31;
        Boolean bool = this.noiseCancellation;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l = this.myPermissions;
        int iFloatToIntBits = (Float.floatToIntBits(this.streamVolume) + ((iHashCode3 + (l != null ? l.hashCode() : 0)) * 31)) * 31;
        RtcConnection$Quality rtcConnection$Quality = this.streamQuality;
        int iHashCode4 = (iFloatToIntBits + (rtcConnection$Quality != null ? rtcConnection$Quality.hashCode() : 0)) * 31;
        boolean z2 = this.isScreenReaderEnabled;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = (((iHashCode4 + r0) * 31) + this.totalMentionsCount) * 31;
        StoreConnectivity$DelayedState storeConnectivity$DelayedState = this.connectivityState;
        int iHashCode5 = (i + (storeConnectivity$DelayedState != null ? storeConnectivity$DelayedState.hashCode() : 0)) * 31;
        StageRoles stageRoles = this.myStageRoles;
        int iHashCode6 = (iHashCode5 + (stageRoles != null ? stageRoles.hashCode() : 0)) * 31;
        boolean z3 = this.stopOffscreenVideo;
        ?? r1 = z3;
        if (z3) {
            r1 = 1;
        }
        int i2 = (iHashCode6 + r1) * 31;
        boolean z4 = this.isTextInVoiceEnabled;
        ?? r2 = z4;
        if (z4) {
            r2 = 1;
        }
        int i3 = (i2 + r2) * 31;
        boolean z5 = this.isTextInVoiceChannelSelected;
        int i4 = (((((i3 + (z5 ? 1 : z5)) * 31) + this.channelMentionsCount) * 31) + this.unreadsCount) * 31;
        Map<Long, ApplicationAsset> map = this.embeddedAppBackgrounds;
        return i4 + (map != null ? map.hashCode() : 0);
    }

    public final boolean isScreenReaderEnabled() {
        return this.isScreenReaderEnabled;
    }

    public final boolean isTextInVoiceChannelSelected() {
        return this.isTextInVoiceChannelSelected;
    }

    public final boolean isTextInVoiceEnabled() {
        return this.isTextInVoiceEnabled;
    }

    public String toString() {
        StringBuilder sbU = a.U("Valid(callModel=");
        sbU.append(this.callModel);
        sbU.append(", stageCallModel=");
        sbU.append(this.stageCallModel);
        sbU.append(", noiseCancellation=");
        sbU.append(this.noiseCancellation);
        sbU.append(", myPermissions=");
        sbU.append(this.myPermissions);
        sbU.append(", streamVolume=");
        sbU.append(this.streamVolume);
        sbU.append(", streamQuality=");
        sbU.append(this.streamQuality);
        sbU.append(", isScreenReaderEnabled=");
        sbU.append(this.isScreenReaderEnabled);
        sbU.append(", totalMentionsCount=");
        sbU.append(this.totalMentionsCount);
        sbU.append(", connectivityState=");
        sbU.append(this.connectivityState);
        sbU.append(", myStageRoles=");
        sbU.append(this.myStageRoles);
        sbU.append(", stopOffscreenVideo=");
        sbU.append(this.stopOffscreenVideo);
        sbU.append(", isTextInVoiceEnabled=");
        sbU.append(this.isTextInVoiceEnabled);
        sbU.append(", isTextInVoiceChannelSelected=");
        sbU.append(this.isTextInVoiceChannelSelected);
        sbU.append(", channelMentionsCount=");
        sbU.append(this.channelMentionsCount);
        sbU.append(", unreadsCount=");
        sbU.append(this.unreadsCount);
        sbU.append(", embeddedAppBackgrounds=");
        return a.M(sbU, this.embeddedAppBackgrounds, ")");
    }

    private WidgetCallFullscreenViewModel$StoreState$Valid(CallModel callModel, StageCallModel stageCallModel, Boolean bool, Long l, float f, RtcConnection$Quality rtcConnection$Quality, boolean z2, int i, StoreConnectivity$DelayedState storeConnectivity$DelayedState, StageRoles stageRoles, boolean z3, boolean z4, boolean z5, int i2, int i3, Map<Long, ApplicationAsset> map) {
        super(null);
        this.callModel = callModel;
        this.stageCallModel = stageCallModel;
        this.noiseCancellation = bool;
        this.myPermissions = l;
        this.streamVolume = f;
        this.streamQuality = rtcConnection$Quality;
        this.isScreenReaderEnabled = z2;
        this.totalMentionsCount = i;
        this.connectivityState = storeConnectivity$DelayedState;
        this.myStageRoles = stageRoles;
        this.stopOffscreenVideo = z3;
        this.isTextInVoiceEnabled = z4;
        this.isTextInVoiceChannelSelected = z5;
        this.channelMentionsCount = i2;
        this.unreadsCount = i3;
        this.embeddedAppBackgrounds = map;
    }
}

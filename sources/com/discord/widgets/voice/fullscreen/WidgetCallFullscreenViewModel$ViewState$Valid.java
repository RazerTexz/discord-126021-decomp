package com.discord.widgets.voice.fullscreen;

import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import b.d.b.a.a;
import co.discord.media_engine.VideoInputDeviceDescription;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$InputMode;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.model.StageCallModel;
import com.discord.widgets.voice.controls.VoiceControlsOutputSelectorState;
import com.discord.widgets.voice.model.CallModel;
import com.discord.widgets.voice.model.CameraState;
import d0.g;
import d0.g0.t;
import d0.t.n0;
import d0.z.d.m;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetCallFullscreenViewModel$ViewState$Valid extends WidgetCallFullscreenViewModel$ViewState {
    private final GuildScheduledEvent activeEvent;
    private final Map<String, CallParticipant$UserOrStreamParticipant> allVideoParticipants;

    /* JADX INFO: renamed from: analyticsVideoLayout$delegate, reason: from kotlin metadata */
    private final Lazy analyticsVideoLayout;
    private final CallModel callModel;
    private final CameraState cameraState;
    private final Long channelPermissions;
    private final WidgetCallFullscreenViewModel$DisplayMode displayMode;
    private final String focusedParticipantKey;
    private final boolean isAnyoneUsingVideo;
    private final boolean isControlFadingDisabled;
    private final boolean isDeafened;
    private final boolean isIdleFooter;
    private final boolean isIdleHeader;
    private final boolean isMovingToAudience;
    private final boolean isPushToTalk;
    private final boolean isStreamFocused;
    private final boolean isSwitchCameraButtonVisible;
    private final boolean isTextInVoiceChannelSelected;
    private final boolean isTextInVoiceEnabled;
    private final boolean isUpdatingRequestToSpeak;
    private final boolean isVideoCallGridVisible;
    private final boolean lockCallScreenControls;

    /* JADX INFO: renamed from: menuItems$delegate, reason: from kotlin metadata */
    private final Lazy menuItems;
    private final Boolean noiseCancellation;
    private final VoiceControlsOutputSelectorState outputSelectorState;
    private final WidgetCallFullscreenViewModel$OverlayStatus overlayStatus;
    private final float perceptualStreamVolume;
    private final CallParticipant$UserOrStreamParticipant pipParticipant;
    private final List<StoreVoiceParticipants$VoiceUser> privateCallUserListItems;
    private final int requestingToSpeakCount;
    private final boolean showFooter;
    private final boolean showHeader;
    private final boolean showLowConnectivityBar;
    private final boolean showParticipantsHiddenView;
    private final boolean showStreamVolume;
    private final StageCallModel stageCallModel;
    private final StageRoles stageRoles;
    private final GuildScheduledEvent startableEvent;
    private final boolean startedAsVideo;
    private final boolean stopOffscreenVideo;
    private final int textInVoiceMentionsCount;
    private final int textInVoiceUnreadsCount;

    /* JADX INFO: renamed from: titleText$delegate, reason: from kotlin metadata */
    private final Lazy titleText;
    private final int totalMentionsCount;
    private final List<CallParticipant> visibleVideoParticipants;

    public /* synthetic */ WidgetCallFullscreenViewModel$ViewState$Valid(CallModel callModel, StageCallModel stageCallModel, WidgetCallFullscreenViewModel$OverlayStatus widgetCallFullscreenViewModel$OverlayStatus, List list, boolean z2, boolean z3, boolean z4, boolean z5, CameraState cameraState, WidgetCallFullscreenViewModel$DisplayMode widgetCallFullscreenViewModel$DisplayMode, VoiceControlsOutputSelectorState voiceControlsOutputSelectorState, String str, boolean z6, CallParticipant$UserOrStreamParticipant callParticipant$UserOrStreamParticipant, Boolean bool, List list2, boolean z7, boolean z8, boolean z9, float f, int i, boolean z10, StageRoles stageRoles, boolean z11, boolean z12, int i2, boolean z13, Long l, GuildScheduledEvent guildScheduledEvent, GuildScheduledEvent guildScheduledEvent2, int i3, int i4, boolean z14, boolean z15, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(callModel, stageCallModel, widgetCallFullscreenViewModel$OverlayStatus, list, z2, z3, z4, z5, cameraState, widgetCallFullscreenViewModel$DisplayMode, voiceControlsOutputSelectorState, str, z6, callParticipant$UserOrStreamParticipant, bool, list2, z7, z8, z9, f, i, z10, stageRoles, z11, z12, i2, z13, l, guildScheduledEvent, guildScheduledEvent2, i3, i4, z14, z15, map);
    }

    public static final /* synthetic */ Set access$computeMenuItems(WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid, boolean z2, boolean z3, boolean z4, VideoInputDeviceDescription videoInputDeviceDescription, List list, boolean z5) {
        return widgetCallFullscreenViewModel$ViewState$Valid.computeMenuItems(z2, z3, z4, videoInputDeviceDescription, list, z5);
    }

    private final Set<WidgetCallFullscreenViewModel$MenuItem> computeMenuItems(boolean canManageChannel, boolean isConnected, boolean isStageChannel, VideoInputDeviceDescription selectedVideoInputDevice, List<VideoInputDeviceDescription> availableVideoInputDevices, boolean isTextInVoiceEnabled) {
        HashSet hashSetHashSetOf = n0.hashSetOf(WidgetCallFullscreenViewModel$MenuItem.VOICE_SETTINGS);
        if (canManageChannel) {
            hashSetHashSetOf.add(WidgetCallFullscreenViewModel$MenuItem.CHANNEL_SETTINGS);
        }
        if (isConnected && StoreStream.Companion.getUserSettings().getIsMobileOverlayEnabled()) {
            hashSetHashSetOf.add(WidgetCallFullscreenViewModel$MenuItem.LAUNCH_OVERLAY);
        }
        if (selectedVideoInputDevice != null && availableVideoInputDevices.size() > 1) {
            hashSetHashSetOf.add(WidgetCallFullscreenViewModel$MenuItem.SWITCH_CAMERA);
        }
        if (!isStageChannel && isTextInVoiceEnabled) {
            hashSetHashSetOf.add(WidgetCallFullscreenViewModel$MenuItem.TEXT_IN_VOICE);
        }
        if (!isStageChannel) {
            hashSetHashSetOf.add(WidgetCallFullscreenViewModel$MenuItem.SHOW_PARTICIPANT_LIST);
        }
        return hashSetHashSetOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-J3xfKWQ$default, reason: not valid java name */
    public static /* synthetic */ WidgetCallFullscreenViewModel$ViewState$Valid m69copyJ3xfKWQ$default(WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid, CallModel callModel, StageCallModel stageCallModel, WidgetCallFullscreenViewModel$OverlayStatus widgetCallFullscreenViewModel$OverlayStatus, List list, boolean z2, boolean z3, boolean z4, boolean z5, CameraState cameraState, WidgetCallFullscreenViewModel$DisplayMode widgetCallFullscreenViewModel$DisplayMode, VoiceControlsOutputSelectorState voiceControlsOutputSelectorState, String str, boolean z6, CallParticipant$UserOrStreamParticipant callParticipant$UserOrStreamParticipant, Boolean bool, List list2, boolean z7, boolean z8, boolean z9, float f, int i, boolean z10, StageRoles stageRoles, boolean z11, boolean z12, int i2, boolean z13, Long l, GuildScheduledEvent guildScheduledEvent, GuildScheduledEvent guildScheduledEvent2, int i3, int i4, boolean z14, boolean z15, Map map, int i5, int i6, Object obj) {
        return widgetCallFullscreenViewModel$ViewState$Valid.m71copyJ3xfKWQ((i5 & 1) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.callModel : callModel, (i5 & 2) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.stageCallModel : stageCallModel, (i5 & 4) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.overlayStatus : widgetCallFullscreenViewModel$OverlayStatus, (i5 & 8) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.visibleVideoParticipants : list, (i5 & 16) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.isIdleFooter : z2, (i5 & 32) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.isIdleHeader : z3, (i5 & 64) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.isControlFadingDisabled : z4, (i5 & 128) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.isSwitchCameraButtonVisible : z5, (i5 & 256) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.cameraState : cameraState, (i5 & 512) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.displayMode : widgetCallFullscreenViewModel$DisplayMode, (i5 & 1024) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.outputSelectorState : voiceControlsOutputSelectorState, (i5 & 2048) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.focusedParticipantKey : str, (i5 & 4096) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.isAnyoneUsingVideo : z6, (i5 & 8192) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.pipParticipant : callParticipant$UserOrStreamParticipant, (i5 & 16384) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.noiseCancellation : bool, (i5 & 32768) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.privateCallUserListItems : list2, (i5 & 65536) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.showParticipantsHiddenView : z7, (i5 & 131072) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.lockCallScreenControls : z8, (i5 & 262144) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.startedAsVideo : z9, (i5 & 524288) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.perceptualStreamVolume : f, (i5 & 1048576) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.totalMentionsCount : i, (i5 & 2097152) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.showLowConnectivityBar : z10, (i5 & 4194304) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.stageRoles : stageRoles, (i5 & 8388608) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.isUpdatingRequestToSpeak : z11, (i5 & 16777216) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.isMovingToAudience : z12, (i5 & 33554432) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.requestingToSpeakCount : i2, (i5 & 67108864) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.stopOffscreenVideo : z13, (i5 & 134217728) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.channelPermissions : l, (i5 & 268435456) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.startableEvent : guildScheduledEvent, (i5 & 536870912) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.activeEvent : guildScheduledEvent2, (i5 & BasicMeasure.EXACTLY) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.textInVoiceMentionsCount : i3, (i5 & Integer.MIN_VALUE) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.textInVoiceUnreadsCount : i4, (i6 & 1) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.isTextInVoiceEnabled : z14, (i6 & 2) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.isTextInVoiceChannelSelected : z15, (i6 & 4) != 0 ? widgetCallFullscreenViewModel$ViewState$Valid.allVideoParticipants : map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CallModel getCallModel() {
        return this.callModel;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final WidgetCallFullscreenViewModel$DisplayMode getDisplayMode() {
        return this.displayMode;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final VoiceControlsOutputSelectorState getOutputSelectorState() {
        return this.outputSelectorState;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getFocusedParticipantKey() {
        return this.focusedParticipantKey;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getIsAnyoneUsingVideo() {
        return this.isAnyoneUsingVideo;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final CallParticipant$UserOrStreamParticipant getPipParticipant() {
        return this.pipParticipant;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Boolean getNoiseCancellation() {
        return this.noiseCancellation;
    }

    public final List<StoreVoiceParticipants$VoiceUser> component16() {
        return this.privateCallUserListItems;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final boolean getShowParticipantsHiddenView() {
        return this.showParticipantsHiddenView;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final boolean getLockCallScreenControls() {
        return this.lockCallScreenControls;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final boolean getStartedAsVideo() {
        return this.startedAsVideo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StageCallModel getStageCallModel() {
        return this.stageCallModel;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final float getPerceptualStreamVolume() {
        return this.perceptualStreamVolume;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final int getTotalMentionsCount() {
        return this.totalMentionsCount;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final boolean getShowLowConnectivityBar() {
        return this.showLowConnectivityBar;
    }

    /* JADX INFO: renamed from: component23-twRsX-0, reason: not valid java name and from getter */
    public final StageRoles getStageRoles() {
        return this.stageRoles;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final boolean getIsUpdatingRequestToSpeak() {
        return this.isUpdatingRequestToSpeak;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final boolean getIsMovingToAudience() {
        return this.isMovingToAudience;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final int getRequestingToSpeakCount() {
        return this.requestingToSpeakCount;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final boolean getStopOffscreenVideo() {
        return this.stopOffscreenVideo;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final Long getChannelPermissions() {
        return this.channelPermissions;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final GuildScheduledEvent getStartableEvent() {
        return this.startableEvent;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final WidgetCallFullscreenViewModel$OverlayStatus getOverlayStatus() {
        return this.overlayStatus;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final GuildScheduledEvent getActiveEvent() {
        return this.activeEvent;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final int getTextInVoiceMentionsCount() {
        return this.textInVoiceMentionsCount;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final int getTextInVoiceUnreadsCount() {
        return this.textInVoiceUnreadsCount;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final boolean getIsTextInVoiceEnabled() {
        return this.isTextInVoiceEnabled;
    }

    /* JADX INFO: renamed from: component34, reason: from getter */
    public final boolean getIsTextInVoiceChannelSelected() {
        return this.isTextInVoiceChannelSelected;
    }

    public final Map<String, CallParticipant$UserOrStreamParticipant> component35() {
        return this.allVideoParticipants;
    }

    public final List<CallParticipant> component4() {
        return this.visibleVideoParticipants;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsIdleFooter() {
        return this.isIdleFooter;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsIdleHeader() {
        return this.isIdleHeader;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsControlFadingDisabled() {
        return this.isControlFadingDisabled;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsSwitchCameraButtonVisible() {
        return this.isSwitchCameraButtonVisible;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final CameraState getCameraState() {
        return this.cameraState;
    }

    /* JADX INFO: renamed from: copy-J3xfKWQ, reason: not valid java name */
    public final WidgetCallFullscreenViewModel$ViewState$Valid m71copyJ3xfKWQ(CallModel callModel, StageCallModel stageCallModel, WidgetCallFullscreenViewModel$OverlayStatus overlayStatus, List<? extends CallParticipant> visibleVideoParticipants, boolean isIdleFooter, boolean isIdleHeader, boolean isControlFadingDisabled, boolean isSwitchCameraButtonVisible, CameraState cameraState, WidgetCallFullscreenViewModel$DisplayMode displayMode, VoiceControlsOutputSelectorState outputSelectorState, String focusedParticipantKey, boolean isAnyoneUsingVideo, CallParticipant$UserOrStreamParticipant pipParticipant, Boolean noiseCancellation, List<StoreVoiceParticipants$VoiceUser> privateCallUserListItems, boolean showParticipantsHiddenView, boolean lockCallScreenControls, boolean startedAsVideo, float perceptualStreamVolume, int totalMentionsCount, boolean showLowConnectivityBar, StageRoles stageRoles, boolean isUpdatingRequestToSpeak, boolean isMovingToAudience, int requestingToSpeakCount, boolean stopOffscreenVideo, Long channelPermissions, GuildScheduledEvent startableEvent, GuildScheduledEvent activeEvent, int textInVoiceMentionsCount, int textInVoiceUnreadsCount, boolean isTextInVoiceEnabled, boolean isTextInVoiceChannelSelected, Map<String, CallParticipant$UserOrStreamParticipant> allVideoParticipants) {
        m.checkNotNullParameter(callModel, "callModel");
        m.checkNotNullParameter(overlayStatus, "overlayStatus");
        m.checkNotNullParameter(visibleVideoParticipants, "visibleVideoParticipants");
        m.checkNotNullParameter(cameraState, "cameraState");
        m.checkNotNullParameter(displayMode, "displayMode");
        m.checkNotNullParameter(outputSelectorState, "outputSelectorState");
        m.checkNotNullParameter(privateCallUserListItems, "privateCallUserListItems");
        m.checkNotNullParameter(allVideoParticipants, "allVideoParticipants");
        return new WidgetCallFullscreenViewModel$ViewState$Valid(callModel, stageCallModel, overlayStatus, visibleVideoParticipants, isIdleFooter, isIdleHeader, isControlFadingDisabled, isSwitchCameraButtonVisible, cameraState, displayMode, outputSelectorState, focusedParticipantKey, isAnyoneUsingVideo, pipParticipant, noiseCancellation, privateCallUserListItems, showParticipantsHiddenView, lockCallScreenControls, startedAsVideo, perceptualStreamVolume, totalMentionsCount, showLowConnectivityBar, stageRoles, isUpdatingRequestToSpeak, isMovingToAudience, requestingToSpeakCount, stopOffscreenVideo, channelPermissions, startableEvent, activeEvent, textInVoiceMentionsCount, textInVoiceUnreadsCount, isTextInVoiceEnabled, isTextInVoiceChannelSelected, allVideoParticipants);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
            return false;
        }
        WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid = (WidgetCallFullscreenViewModel$ViewState$Valid) other;
        return m.areEqual(this.callModel, widgetCallFullscreenViewModel$ViewState$Valid.callModel) && m.areEqual(this.stageCallModel, widgetCallFullscreenViewModel$ViewState$Valid.stageCallModel) && m.areEqual(this.overlayStatus, widgetCallFullscreenViewModel$ViewState$Valid.overlayStatus) && m.areEqual(this.visibleVideoParticipants, widgetCallFullscreenViewModel$ViewState$Valid.visibleVideoParticipants) && this.isIdleFooter == widgetCallFullscreenViewModel$ViewState$Valid.isIdleFooter && this.isIdleHeader == widgetCallFullscreenViewModel$ViewState$Valid.isIdleHeader && this.isControlFadingDisabled == widgetCallFullscreenViewModel$ViewState$Valid.isControlFadingDisabled && this.isSwitchCameraButtonVisible == widgetCallFullscreenViewModel$ViewState$Valid.isSwitchCameraButtonVisible && m.areEqual(this.cameraState, widgetCallFullscreenViewModel$ViewState$Valid.cameraState) && m.areEqual(this.displayMode, widgetCallFullscreenViewModel$ViewState$Valid.displayMode) && m.areEqual(this.outputSelectorState, widgetCallFullscreenViewModel$ViewState$Valid.outputSelectorState) && m.areEqual(this.focusedParticipantKey, widgetCallFullscreenViewModel$ViewState$Valid.focusedParticipantKey) && this.isAnyoneUsingVideo == widgetCallFullscreenViewModel$ViewState$Valid.isAnyoneUsingVideo && m.areEqual(this.pipParticipant, widgetCallFullscreenViewModel$ViewState$Valid.pipParticipant) && m.areEqual(this.noiseCancellation, widgetCallFullscreenViewModel$ViewState$Valid.noiseCancellation) && m.areEqual(this.privateCallUserListItems, widgetCallFullscreenViewModel$ViewState$Valid.privateCallUserListItems) && this.showParticipantsHiddenView == widgetCallFullscreenViewModel$ViewState$Valid.showParticipantsHiddenView && this.lockCallScreenControls == widgetCallFullscreenViewModel$ViewState$Valid.lockCallScreenControls && this.startedAsVideo == widgetCallFullscreenViewModel$ViewState$Valid.startedAsVideo && Float.compare(this.perceptualStreamVolume, widgetCallFullscreenViewModel$ViewState$Valid.perceptualStreamVolume) == 0 && this.totalMentionsCount == widgetCallFullscreenViewModel$ViewState$Valid.totalMentionsCount && this.showLowConnectivityBar == widgetCallFullscreenViewModel$ViewState$Valid.showLowConnectivityBar && m.areEqual(this.stageRoles, widgetCallFullscreenViewModel$ViewState$Valid.stageRoles) && this.isUpdatingRequestToSpeak == widgetCallFullscreenViewModel$ViewState$Valid.isUpdatingRequestToSpeak && this.isMovingToAudience == widgetCallFullscreenViewModel$ViewState$Valid.isMovingToAudience && this.requestingToSpeakCount == widgetCallFullscreenViewModel$ViewState$Valid.requestingToSpeakCount && this.stopOffscreenVideo == widgetCallFullscreenViewModel$ViewState$Valid.stopOffscreenVideo && m.areEqual(this.channelPermissions, widgetCallFullscreenViewModel$ViewState$Valid.channelPermissions) && m.areEqual(this.startableEvent, widgetCallFullscreenViewModel$ViewState$Valid.startableEvent) && m.areEqual(this.activeEvent, widgetCallFullscreenViewModel$ViewState$Valid.activeEvent) && this.textInVoiceMentionsCount == widgetCallFullscreenViewModel$ViewState$Valid.textInVoiceMentionsCount && this.textInVoiceUnreadsCount == widgetCallFullscreenViewModel$ViewState$Valid.textInVoiceUnreadsCount && this.isTextInVoiceEnabled == widgetCallFullscreenViewModel$ViewState$Valid.isTextInVoiceEnabled && this.isTextInVoiceChannelSelected == widgetCallFullscreenViewModel$ViewState$Valid.isTextInVoiceChannelSelected && m.areEqual(this.allVideoParticipants, widgetCallFullscreenViewModel$ViewState$Valid.allVideoParticipants);
    }

    public final GuildScheduledEvent getActiveEvent() {
        return this.activeEvent;
    }

    public final Map<String, CallParticipant$UserOrStreamParticipant> getAllVideoParticipants() {
        return this.allVideoParticipants;
    }

    public final String getAnalyticsVideoLayout() {
        return (String) this.analyticsVideoLayout.getValue();
    }

    public final CallModel getCallModel() {
        return this.callModel;
    }

    public final CameraState getCameraState() {
        return this.cameraState;
    }

    public final Long getChannelPermissions() {
        return this.channelPermissions;
    }

    public final WidgetCallFullscreenViewModel$DisplayMode getDisplayMode() {
        return this.displayMode;
    }

    public final String getFocusedParticipantKey() {
        return this.focusedParticipantKey;
    }

    public final boolean getLockCallScreenControls() {
        return this.lockCallScreenControls;
    }

    public final Set<WidgetCallFullscreenViewModel$MenuItem> getMenuItems() {
        return (Set) this.menuItems.getValue();
    }

    public final Boolean getNoiseCancellation() {
        return this.noiseCancellation;
    }

    public final VoiceControlsOutputSelectorState getOutputSelectorState() {
        return this.outputSelectorState;
    }

    public final WidgetCallFullscreenViewModel$OverlayStatus getOverlayStatus() {
        return this.overlayStatus;
    }

    public final float getPerceptualStreamVolume() {
        return this.perceptualStreamVolume;
    }

    public final CallParticipant$UserOrStreamParticipant getPipParticipant() {
        return this.pipParticipant;
    }

    public final List<StoreVoiceParticipants$VoiceUser> getPrivateCallUserListItems() {
        return this.privateCallUserListItems;
    }

    public final int getRequestingToSpeakCount() {
        return this.requestingToSpeakCount;
    }

    public final boolean getShowFooter() {
        return this.showFooter;
    }

    public final boolean getShowHeader() {
        return this.showHeader;
    }

    public final boolean getShowLowConnectivityBar() {
        return this.showLowConnectivityBar;
    }

    public final boolean getShowParticipantsHiddenView() {
        return this.showParticipantsHiddenView;
    }

    public final boolean getShowStreamVolume() {
        return this.showStreamVolume;
    }

    public final StageCallModel getStageCallModel() {
        return this.stageCallModel;
    }

    /* JADX INFO: renamed from: getStageRoles-twRsX-0, reason: not valid java name */
    public final StageRoles m72getStageRolestwRsX0() {
        return this.stageRoles;
    }

    public final GuildScheduledEvent getStartableEvent() {
        return this.startableEvent;
    }

    public final boolean getStartedAsVideo() {
        return this.startedAsVideo;
    }

    public final boolean getStopOffscreenVideo() {
        return this.stopOffscreenVideo;
    }

    public final int getTextInVoiceMentionsCount() {
        return this.textInVoiceMentionsCount;
    }

    public final int getTextInVoiceUnreadsCount() {
        return this.textInVoiceUnreadsCount;
    }

    public final String getTitleText() {
        return (String) this.titleText.getValue();
    }

    public final int getTotalMentionsCount() {
        return this.totalMentionsCount;
    }

    public final List<CallParticipant> getVisibleVideoParticipants() {
        return this.visibleVideoParticipants;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v42, types: [int] */
    /* JADX WARN: Type inference failed for: r0v47, types: [int] */
    /* JADX WARN: Type inference failed for: r0v49, types: [int] */
    /* JADX WARN: Type inference failed for: r0v52, types: [int] */
    /* JADX WARN: Type inference failed for: r0v65, types: [int] */
    /* JADX WARN: Type inference failed for: r0v68 */
    /* JADX WARN: Type inference failed for: r0v72 */
    /* JADX WARN: Type inference failed for: r0v73 */
    /* JADX WARN: Type inference failed for: r0v74 */
    /* JADX WARN: Type inference failed for: r0v76 */
    /* JADX WARN: Type inference failed for: r0v78 */
    /* JADX WARN: Type inference failed for: r0v79 */
    /* JADX WARN: Type inference failed for: r0v80 */
    /* JADX WARN: Type inference failed for: r0v81 */
    /* JADX WARN: Type inference failed for: r0v82 */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v100 */
    /* JADX WARN: Type inference failed for: r2v101 */
    /* JADX WARN: Type inference failed for: r2v102 */
    /* JADX WARN: Type inference failed for: r2v103 */
    /* JADX WARN: Type inference failed for: r2v104 */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v30, types: [int] */
    /* JADX WARN: Type inference failed for: r2v41, types: [int] */
    /* JADX WARN: Type inference failed for: r2v43, types: [int] */
    /* JADX WARN: Type inference failed for: r2v45, types: [int] */
    /* JADX WARN: Type inference failed for: r2v79 */
    /* JADX WARN: Type inference failed for: r2v80 */
    /* JADX WARN: Type inference failed for: r2v81 */
    /* JADX WARN: Type inference failed for: r2v85 */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r2v91 */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r2v97 */
    /* JADX WARN: Type inference failed for: r2v98 */
    /* JADX WARN: Type inference failed for: r2v99 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        CallModel callModel = this.callModel;
        int iHashCode = (callModel != null ? callModel.hashCode() : 0) * 31;
        StageCallModel stageCallModel = this.stageCallModel;
        int iHashCode2 = (iHashCode + (stageCallModel != null ? stageCallModel.hashCode() : 0)) * 31;
        WidgetCallFullscreenViewModel$OverlayStatus widgetCallFullscreenViewModel$OverlayStatus = this.overlayStatus;
        int iHashCode3 = (iHashCode2 + (widgetCallFullscreenViewModel$OverlayStatus != null ? widgetCallFullscreenViewModel$OverlayStatus.hashCode() : 0)) * 31;
        List<CallParticipant> list = this.visibleVideoParticipants;
        int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.isIdleFooter;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode4 + r2) * 31;
        boolean z3 = this.isIdleHeader;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (i + r3) * 31;
        boolean z4 = this.isControlFadingDisabled;
        ?? r4 = z4;
        if (z4) {
            r4 = 1;
        }
        int i3 = (i2 + r4) * 31;
        boolean z5 = this.isSwitchCameraButtonVisible;
        ?? r5 = z5;
        if (z5) {
            r5 = 1;
        }
        int i4 = (i3 + r5) * 31;
        CameraState cameraState = this.cameraState;
        int iHashCode5 = (i4 + (cameraState != null ? cameraState.hashCode() : 0)) * 31;
        WidgetCallFullscreenViewModel$DisplayMode widgetCallFullscreenViewModel$DisplayMode = this.displayMode;
        int iHashCode6 = (iHashCode5 + (widgetCallFullscreenViewModel$DisplayMode != null ? widgetCallFullscreenViewModel$DisplayMode.hashCode() : 0)) * 31;
        VoiceControlsOutputSelectorState voiceControlsOutputSelectorState = this.outputSelectorState;
        int iHashCode7 = (iHashCode6 + (voiceControlsOutputSelectorState != null ? voiceControlsOutputSelectorState.hashCode() : 0)) * 31;
        String str = this.focusedParticipantKey;
        int iHashCode8 = (iHashCode7 + (str != null ? str.hashCode() : 0)) * 31;
        boolean z6 = this.isAnyoneUsingVideo;
        ?? r6 = z6;
        if (z6) {
            r6 = 1;
        }
        int i5 = (iHashCode8 + r6) * 31;
        CallParticipant$UserOrStreamParticipant callParticipant$UserOrStreamParticipant = this.pipParticipant;
        int iHashCode9 = (i5 + (callParticipant$UserOrStreamParticipant != null ? callParticipant$UserOrStreamParticipant.hashCode() : 0)) * 31;
        Boolean bool = this.noiseCancellation;
        int iHashCode10 = (iHashCode9 + (bool != null ? bool.hashCode() : 0)) * 31;
        List<StoreVoiceParticipants$VoiceUser> list2 = this.privateCallUserListItems;
        int iHashCode11 = (iHashCode10 + (list2 != null ? list2.hashCode() : 0)) * 31;
        boolean z7 = this.showParticipantsHiddenView;
        ?? r7 = z7;
        if (z7) {
            r7 = 1;
        }
        int i6 = (iHashCode11 + r7) * 31;
        boolean z8 = this.lockCallScreenControls;
        ?? r8 = z8;
        if (z8) {
            r8 = 1;
        }
        int i7 = (i6 + r8) * 31;
        boolean z9 = this.startedAsVideo;
        ?? r9 = z9;
        if (z9) {
            r9 = 1;
        }
        int iFloatToIntBits = (((Float.floatToIntBits(this.perceptualStreamVolume) + ((i7 + r9) * 31)) * 31) + this.totalMentionsCount) * 31;
        boolean z10 = this.showLowConnectivityBar;
        ?? r0 = z10;
        if (z10) {
            r0 = 1;
        }
        int i8 = (iFloatToIntBits + r0) * 31;
        StageRoles stageRoles = this.stageRoles;
        int iHashCode12 = (i8 + (stageRoles != null ? stageRoles.hashCode() : 0)) * 31;
        boolean z11 = this.isUpdatingRequestToSpeak;
        ?? r1 = z11;
        if (z11) {
            r1 = 1;
        }
        int i9 = (iHashCode12 + r1) * 31;
        boolean z12 = this.isMovingToAudience;
        ?? r10 = z12;
        if (z12) {
            r10 = 1;
        }
        int i10 = (((i9 + r10) * 31) + this.requestingToSpeakCount) * 31;
        boolean z13 = this.stopOffscreenVideo;
        ?? r11 = z13;
        if (z13) {
            r11 = 1;
        }
        int i11 = (i10 + r11) * 31;
        Long l = this.channelPermissions;
        int iHashCode13 = (i11 + (l != null ? l.hashCode() : 0)) * 31;
        GuildScheduledEvent guildScheduledEvent = this.startableEvent;
        int iHashCode14 = (iHashCode13 + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0)) * 31;
        GuildScheduledEvent guildScheduledEvent2 = this.activeEvent;
        int iHashCode15 = (((((iHashCode14 + (guildScheduledEvent2 != null ? guildScheduledEvent2.hashCode() : 0)) * 31) + this.textInVoiceMentionsCount) * 31) + this.textInVoiceUnreadsCount) * 31;
        boolean z14 = this.isTextInVoiceEnabled;
        ?? r12 = z14;
        if (z14) {
            r12 = 1;
        }
        int i12 = (iHashCode15 + r12) * 31;
        boolean z15 = this.isTextInVoiceChannelSelected;
        int i13 = (i12 + (z15 ? 1 : z15)) * 31;
        Map<String, CallParticipant$UserOrStreamParticipant> map = this.allVideoParticipants;
        return i13 + (map != null ? map.hashCode() : 0);
    }

    public final boolean isAnyoneUsingVideo() {
        return this.isAnyoneUsingVideo;
    }

    public final boolean isControlFadingDisabled() {
        return this.isControlFadingDisabled;
    }

    /* JADX INFO: renamed from: isDeafened, reason: from getter */
    public final boolean getIsDeafened() {
        return this.isDeafened;
    }

    public final boolean isIdleFooter() {
        return this.isIdleFooter;
    }

    public final boolean isIdleHeader() {
        return this.isIdleHeader;
    }

    public final boolean isMovingToAudience() {
        return this.isMovingToAudience;
    }

    /* JADX INFO: renamed from: isPushToTalk, reason: from getter */
    public final boolean getIsPushToTalk() {
        return this.isPushToTalk;
    }

    /* JADX INFO: renamed from: isStreamFocused, reason: from getter */
    public final boolean getIsStreamFocused() {
        return this.isStreamFocused;
    }

    public final boolean isSwitchCameraButtonVisible() {
        return this.isSwitchCameraButtonVisible;
    }

    public final boolean isTextInVoiceChannelSelected() {
        return this.isTextInVoiceChannelSelected;
    }

    public final boolean isTextInVoiceEnabled() {
        return this.isTextInVoiceEnabled;
    }

    public final boolean isUpdatingRequestToSpeak() {
        return this.isUpdatingRequestToSpeak;
    }

    /* JADX INFO: renamed from: isVideoCallGridVisible, reason: from getter */
    public final boolean getIsVideoCallGridVisible() {
        return this.isVideoCallGridVisible;
    }

    public String toString() {
        StringBuilder sbU = a.U("Valid(callModel=");
        sbU.append(this.callModel);
        sbU.append(", stageCallModel=");
        sbU.append(this.stageCallModel);
        sbU.append(", overlayStatus=");
        sbU.append(this.overlayStatus);
        sbU.append(", visibleVideoParticipants=");
        sbU.append(this.visibleVideoParticipants);
        sbU.append(", isIdleFooter=");
        sbU.append(this.isIdleFooter);
        sbU.append(", isIdleHeader=");
        sbU.append(this.isIdleHeader);
        sbU.append(", isControlFadingDisabled=");
        sbU.append(this.isControlFadingDisabled);
        sbU.append(", isSwitchCameraButtonVisible=");
        sbU.append(this.isSwitchCameraButtonVisible);
        sbU.append(", cameraState=");
        sbU.append(this.cameraState);
        sbU.append(", displayMode=");
        sbU.append(this.displayMode);
        sbU.append(", outputSelectorState=");
        sbU.append(this.outputSelectorState);
        sbU.append(", focusedParticipantKey=");
        sbU.append(this.focusedParticipantKey);
        sbU.append(", isAnyoneUsingVideo=");
        sbU.append(this.isAnyoneUsingVideo);
        sbU.append(", pipParticipant=");
        sbU.append(this.pipParticipant);
        sbU.append(", noiseCancellation=");
        sbU.append(this.noiseCancellation);
        sbU.append(", privateCallUserListItems=");
        sbU.append(this.privateCallUserListItems);
        sbU.append(", showParticipantsHiddenView=");
        sbU.append(this.showParticipantsHiddenView);
        sbU.append(", lockCallScreenControls=");
        sbU.append(this.lockCallScreenControls);
        sbU.append(", startedAsVideo=");
        sbU.append(this.startedAsVideo);
        sbU.append(", perceptualStreamVolume=");
        sbU.append(this.perceptualStreamVolume);
        sbU.append(", totalMentionsCount=");
        sbU.append(this.totalMentionsCount);
        sbU.append(", showLowConnectivityBar=");
        sbU.append(this.showLowConnectivityBar);
        sbU.append(", stageRoles=");
        sbU.append(this.stageRoles);
        sbU.append(", isUpdatingRequestToSpeak=");
        sbU.append(this.isUpdatingRequestToSpeak);
        sbU.append(", isMovingToAudience=");
        sbU.append(this.isMovingToAudience);
        sbU.append(", requestingToSpeakCount=");
        sbU.append(this.requestingToSpeakCount);
        sbU.append(", stopOffscreenVideo=");
        sbU.append(this.stopOffscreenVideo);
        sbU.append(", channelPermissions=");
        sbU.append(this.channelPermissions);
        sbU.append(", startableEvent=");
        sbU.append(this.startableEvent);
        sbU.append(", activeEvent=");
        sbU.append(this.activeEvent);
        sbU.append(", textInVoiceMentionsCount=");
        sbU.append(this.textInVoiceMentionsCount);
        sbU.append(", textInVoiceUnreadsCount=");
        sbU.append(this.textInVoiceUnreadsCount);
        sbU.append(", isTextInVoiceEnabled=");
        sbU.append(this.isTextInVoiceEnabled);
        sbU.append(", isTextInVoiceChannelSelected=");
        sbU.append(this.isTextInVoiceChannelSelected);
        sbU.append(", allVideoParticipants=");
        return a.M(sbU, this.allVideoParticipants, ")");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private WidgetCallFullscreenViewModel$ViewState$Valid(CallModel callModel, StageCallModel stageCallModel, WidgetCallFullscreenViewModel$OverlayStatus widgetCallFullscreenViewModel$OverlayStatus, List<? extends CallParticipant> list, boolean z2, boolean z3, boolean z4, boolean z5, CameraState cameraState, WidgetCallFullscreenViewModel$DisplayMode widgetCallFullscreenViewModel$DisplayMode, VoiceControlsOutputSelectorState voiceControlsOutputSelectorState, String str, boolean z6, CallParticipant$UserOrStreamParticipant callParticipant$UserOrStreamParticipant, Boolean bool, List<StoreVoiceParticipants$VoiceUser> list2, boolean z7, boolean z8, boolean z9, float f, int i, boolean z10, StageRoles stageRoles, boolean z11, boolean z12, int i2, boolean z13, Long l, GuildScheduledEvent guildScheduledEvent, GuildScheduledEvent guildScheduledEvent2, int i3, int i4, boolean z14, boolean z15, Map<String, CallParticipant$UserOrStreamParticipant> map) {
        super(null);
        this.callModel = callModel;
        this.stageCallModel = stageCallModel;
        this.overlayStatus = widgetCallFullscreenViewModel$OverlayStatus;
        this.visibleVideoParticipants = list;
        this.isIdleFooter = z2;
        this.isIdleHeader = z3;
        this.isControlFadingDisabled = z4;
        this.isSwitchCameraButtonVisible = z5;
        this.cameraState = cameraState;
        this.displayMode = widgetCallFullscreenViewModel$DisplayMode;
        this.outputSelectorState = voiceControlsOutputSelectorState;
        this.focusedParticipantKey = str;
        this.isAnyoneUsingVideo = z6;
        this.pipParticipant = callParticipant$UserOrStreamParticipant;
        this.noiseCancellation = bool;
        this.privateCallUserListItems = list2;
        this.showParticipantsHiddenView = z7;
        this.lockCallScreenControls = z8;
        this.startedAsVideo = z9;
        this.perceptualStreamVolume = f;
        this.totalMentionsCount = i;
        this.showLowConnectivityBar = z10;
        this.stageRoles = stageRoles;
        this.isUpdatingRequestToSpeak = z11;
        this.isMovingToAudience = z12;
        this.requestingToSpeakCount = i2;
        this.stopOffscreenVideo = z13;
        this.channelPermissions = l;
        this.startableEvent = guildScheduledEvent;
        this.activeEvent = guildScheduledEvent2;
        this.textInVoiceMentionsCount = i3;
        this.textInVoiceUnreadsCount = i4;
        this.isTextInVoiceEnabled = z14;
        this.isTextInVoiceChannelSelected = z15;
        this.allVideoParticipants = map;
        this.menuItems = g.lazy(new WidgetCallFullscreenViewModel$ViewState$Valid$menuItems$2(this));
        this.titleText = g.lazy(new WidgetCallFullscreenViewModel$ViewState$Valid$titleText$2(this));
        boolean z16 = false;
        this.isStreamFocused = str != null && t.endsWith$default(str, "STREAM", false, 2, null);
        boolean z17 = (list.isEmpty() ^ true) && !callModel.isStreaming() && widgetCallFullscreenViewModel$DisplayMode == WidgetCallFullscreenViewModel$DisplayMode.GRID;
        this.isVideoCallGridVisible = z17;
        this.isPushToTalk = callModel.getInputMode() == MediaEngineConnection$InputMode.PUSH_TO_TALK;
        this.showFooter = (z17 && z2 && !z8) ? false : true;
        this.showHeader = (z17 && z3 && !z8) ? false : true;
        if (callModel.getActiveStream() != null && !callModel.isStreaming()) {
            z16 = true;
        }
        this.showStreamVolume = z16;
        this.analyticsVideoLayout = g.lazy(new WidgetCallFullscreenViewModel$ViewState$Valid$analyticsVideoLayout$2(this));
        this.isDeafened = callModel.isDeafenedByAnySource();
    }
}

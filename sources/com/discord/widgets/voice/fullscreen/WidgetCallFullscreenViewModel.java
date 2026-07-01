package com.discord.widgets.voice.fullscreen;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import b.a.d.d0;
import co.discord.media_engine.VideoInputDeviceDescription;
import co.discord.media_engine.VideoInputDeviceFacing;
import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guild.GuildMaxVideoChannelUsers$Limited;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.api.permission.Permission;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.RtcConnection$Metadata;
import com.discord.rtcconnection.RtcConnection$Quality;
import com.discord.rtcconnection.VideoMetadata;
import com.discord.rtcconnection.audio.DiscordAudioManager$AudioDevice;
import com.discord.rtcconnection.audio.DiscordAudioManager$DeviceTypes;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$InputMode;
import com.discord.rtcconnection.socket.io.Payloads$ResolutionType;
import com.discord.stores.SelectedChannelAnalyticsLocation;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreApplication;
import com.discord.stores.StoreApplicationAssets;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreApplicationStreaming$ActiveApplicationStream;
import com.discord.stores.StoreApplicationStreaming$ActiveApplicationStream$State;
import com.discord.stores.StoreAudioManagerV2;
import com.discord.stores.StoreAudioManagerV2$State;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreConnectivity;
import com.discord.stores.StoreConnectivity$State;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreMediaEngine;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreMediaSettings$SelfMuteFailure;
import com.discord.stores.StoreMentions;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreNavigation$PanelAction;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStreamRtcConnection;
import com.discord.stores.StoreTabsNavigation;
import com.discord.stores.StoreUserSettings;
import com.discord.stores.StoreVideoStreams$UserStreams;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.EmbeddedActivityUtilsKt;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.permissions.VideoPermissionsManager;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.video.VideoPlayerIdleDetector;
import com.discord.utilities.voice.PerceptualVolumeUtils;
import com.discord.utilities.voice.VoiceEngineServiceController;
import com.discord.views.calls.VideoCallParticipantView$ParticipantData;
import com.discord.views.calls.VideoCallParticipantView$ParticipantData$ApplicationStreamState;
import com.discord.views.calls.VideoCallParticipantView$ParticipantData$Type;
import com.discord.views.calls.VideoCallParticipantView$ParticipantData$a;
import com.discord.views.calls.VideoCallParticipantView$StreamFps;
import com.discord.views.calls.VideoCallParticipantView$StreamResolution;
import com.discord.views.calls.VideoCallParticipantView$StreamResolution$a;
import com.discord.views.calls.VideoCallParticipantView$StreamResolution$b;
import com.discord.widgets.channels.TextInVoiceOnboardingManager;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.model.StageCallModel;
import com.discord.widgets.stage.model.StageMediaParticipant;
import com.discord.widgets.voice.controls.VoiceControlsOutputSelectorState;
import com.discord.widgets.voice.model.CallModel;
import com.discord.widgets.voice.model.CameraState;
import d0.d0.f;
import d0.t.h0;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import j0.p.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.webrtc.RendererCommon$ScalingType;
import rx.Observable;
import rx.Scheduler;
import rx.Subscription;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreenViewModel extends d0<WidgetCallFullscreenViewModel$ViewState> {
    private final StoreAccessibility accessibilityStore;
    private List<? extends CallParticipant> allVideoParticipants;
    private final StoreAnalytics analyticsStore;
    private final StoreApplicationAssets applicationAssetsStore;
    private final StoreApplication applicationStore;
    private final StoreApplicationStreaming applicationStreamingStore;
    private final StoreAudioManagerV2 audioManagerStore;
    private String autotargetStreamKey;
    private final Scheduler backgroundThreadScheduler;
    private Integer bottomSheetState;
    private long channelId;
    private final StoreChannelsSelected channelsSelectedStore;
    private final Clock clock;
    private final StoreConnectivity connectivityStore;
    private final PublishSubject<WidgetCallFullscreenViewModel$Event> eventSubject;
    private final StoreExperiments experimentsStore;
    private String focusedVideoParticipantKey;
    private Subscription forwardVideoGridInteractionSubscription;
    private final StoreGuildSelected guildSelectedStore;
    private WidgetCallFullscreenViewModel$ParticipantTap lastParticipantTap;
    private boolean logStreamQualityIndicatorViewed;
    private final StoreMediaEngine mediaEngineStore;
    private final StoreMediaSettings mediaSettingsStore;
    private final StoreMentions mentionsStore;
    private WidgetCallFullscreenViewModel$StoreState mostRecentStoreState;
    private final PublishSubject<List<VideoCallParticipantView$ParticipantData>> offScreenSubject;
    private final StorePermissions permissionsStore;
    private final StoreVoiceChannelSelected selectedVoiceChannelStore;
    private boolean showStageCallBottomSheet;
    private final StoreStageChannels stageStore;
    private Boolean startedAsVideo;
    private final StoreAnalytics storeAnalytics;
    private final StoreChannels storeChannels;
    private final StoreNavigation storeNavigation;
    private Subscription storeObservableSubscription;
    private final StoreStreamRtcConnection streamRtcConnectionStore;
    private final StoreTabsNavigation tabsNavigationStore;
    private final StoreUserSettings userSettingsStore;
    private final VideoPermissionsManager videoPermissionsManager;
    private final VideoPlayerIdleDetector videoPlayerIdleDetectorFooter;
    private final VideoPlayerIdleDetector videoPlayerIdleDetectorHeader;
    private final VoiceEngineServiceController voiceEngineServiceController;
    private boolean wasEverConnected;
    private boolean wasEverMultiParticipant;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetCallFullscreenViewModel(long j, StoreChannels storeChannels, StoreNavigation storeNavigation, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreGuildSelected storeGuildSelected, StoreTabsNavigation storeTabsNavigation, StoreUserSettings storeUserSettings, StoreApplicationStreaming storeApplicationStreaming, StoreMediaEngine storeMediaEngine, StoreMediaSettings storeMediaSettings, StorePermissions storePermissions, Clock clock, Scheduler scheduler, VideoPermissionsManager videoPermissionsManager, VoiceEngineServiceController voiceEngineServiceController, StoreStreamRtcConnection storeStreamRtcConnection, StoreAccessibility storeAccessibility, StoreAudioManagerV2 storeAudioManagerV2, StoreMentions storeMentions, StoreAnalytics storeAnalytics, StoreConnectivity storeConnectivity, StoreStageChannels storeStageChannels, StoreAnalytics storeAnalytics2, StoreExperiments storeExperiments, StoreChannelsSelected storeChannelsSelected, StoreApplication storeApplication, StoreApplicationAssets storeApplicationAssets, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Scheduler scheduler2;
        StoreChannels channels = (i & 2) != 0 ? StoreStream.Companion.getChannels() : storeChannels;
        StoreNavigation navigation = (i & 4) != 0 ? StoreStream.Companion.getNavigation() : storeNavigation;
        StoreVoiceChannelSelected voiceChannelSelected = (i & 8) != 0 ? StoreStream.Companion.getVoiceChannelSelected() : storeVoiceChannelSelected;
        StoreGuildSelected guildSelected = (i & 16) != 0 ? StoreStream.Companion.getGuildSelected() : storeGuildSelected;
        StoreTabsNavigation tabsNavigation = (i & 32) != 0 ? StoreStream.Companion.getTabsNavigation() : storeTabsNavigation;
        StoreUserSettings userSettings = (i & 64) != 0 ? StoreStream.Companion.getUserSettings() : storeUserSettings;
        StoreApplicationStreaming applicationStreaming = (i & 128) != 0 ? StoreStream.Companion.getApplicationStreaming() : storeApplicationStreaming;
        StoreMediaEngine mediaEngine = (i & 256) != 0 ? StoreStream.Companion.getMediaEngine() : storeMediaEngine;
        StoreMediaSettings mediaSettings = (i & 512) != 0 ? StoreStream.Companion.getMediaSettings() : storeMediaSettings;
        StorePermissions permissions = (i & 1024) != 0 ? StoreStream.Companion.getPermissions() : storePermissions;
        Clock clock2 = (i & 2048) != 0 ? ClockFactory.get() : clock;
        if ((i & 4096) != 0) {
            Scheduler schedulerA = a.a();
            m.checkNotNullExpressionValue(schedulerA, "Schedulers.computation()");
            scheduler2 = schedulerA;
        } else {
            scheduler2 = scheduler;
        }
        this(j, channels, navigation, voiceChannelSelected, guildSelected, tabsNavigation, userSettings, applicationStreaming, mediaEngine, mediaSettings, permissions, clock2, scheduler2, (i & 8192) != 0 ? new VideoPermissionsManager(null, 1, null) : videoPermissionsManager, (i & 16384) != 0 ? VoiceEngineServiceController.Companion.getINSTANCE() : voiceEngineServiceController, (32768 & i) != 0 ? StoreStream.Companion.getStreamRtcConnection() : storeStreamRtcConnection, (65536 & i) != 0 ? StoreStream.Companion.getAccessibility() : storeAccessibility, (131072 & i) != 0 ? StoreStream.Companion.getAudioManagerV2() : storeAudioManagerV2, (262144 & i) != 0 ? StoreStream.Companion.getMentions() : storeMentions, (524288 & i) != 0 ? StoreStream.Companion.getAnalytics() : storeAnalytics, (1048576 & i) != 0 ? StoreStream.Companion.getConnectivity() : storeConnectivity, (2097152 & i) != 0 ? StoreStream.Companion.getStageChannels() : storeStageChannels, (4194304 & i) != 0 ? StoreStream.Companion.getAnalytics() : storeAnalytics2, (8388608 & i) != 0 ? StoreStream.Companion.getExperiments() : storeExperiments, (16777216 & i) != 0 ? StoreStream.Companion.getChannelsSelected() : storeChannelsSelected, (33554432 & i) != 0 ? StoreStream.Companion.getApplication() : storeApplication, (i & 67108864) != 0 ? StoreStream.Companion.getApplicationAssets() : storeApplicationAssets, str);
    }

    public static final /* synthetic */ StoreAccessibility access$getAccessibilityStore$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.accessibilityStore;
    }

    public static final /* synthetic */ StoreApplicationAssets access$getApplicationAssetsStore$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.applicationAssetsStore;
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.channelId;
    }

    public static final /* synthetic */ StoreChannelsSelected access$getChannelsSelectedStore$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.channelsSelectedStore;
    }

    public static final /* synthetic */ StoreConnectivity access$getConnectivityStore$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.connectivityStore;
    }

    public static final /* synthetic */ StoreExperiments access$getExperimentsStore$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.experimentsStore;
    }

    public static final /* synthetic */ Subscription access$getForwardVideoGridInteractionSubscription$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.forwardVideoGridInteractionSubscription;
    }

    public static final /* synthetic */ StoreMentions access$getMentionsStore$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.mentionsStore;
    }

    public static final /* synthetic */ StorePermissions access$getPermissionsStore$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.permissionsStore;
    }

    public static final /* synthetic */ StoreStageChannels access$getStageStore$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.stageStore;
    }

    public static final /* synthetic */ Subscription access$getStoreObservableSubscription$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.storeObservableSubscription;
    }

    public static final /* synthetic */ StoreStreamRtcConnection access$getStreamRtcConnectionStore$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.streamRtcConnectionStore;
    }

    public static final /* synthetic */ VideoPlayerIdleDetector access$getVideoPlayerIdleDetectorFooter$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.videoPlayerIdleDetectorFooter;
    }

    public static final /* synthetic */ VideoPlayerIdleDetector access$getVideoPlayerIdleDetectorHeader$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.videoPlayerIdleDetectorHeader;
    }

    public static final /* synthetic */ WidgetCallFullscreenViewModel$ViewState access$getViewState$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.getViewState();
    }

    public static final /* synthetic */ void access$setChannelId$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel, long j) {
        widgetCallFullscreenViewModel.channelId = j;
    }

    public static final /* synthetic */ void access$setForwardVideoGridInteractionSubscription$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel, Subscription subscription) {
        widgetCallFullscreenViewModel.forwardVideoGridInteractionSubscription = subscription;
    }

    public static final /* synthetic */ void access$setOffScreenVideoParticipants(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel, List list) {
        widgetCallFullscreenViewModel.setOffScreenVideoParticipants(list);
    }

    public static final /* synthetic */ void access$setStoreObservableSubscription$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel, Subscription subscription) {
        widgetCallFullscreenViewModel.storeObservableSubscription = subscription;
    }

    private final CallParticipant addStreamQualityMetadata(CallParticipant callParticipant, RtcConnection$Quality streamQuality) {
        boolean z2 = callParticipant instanceof CallParticipant$UserOrStreamParticipant;
        if (z2 || (callParticipant instanceof CallParticipant$EmbeddedActivityParticipant)) {
            return callParticipant;
        }
        if (!z2) {
            throw new NoWhenBranchMatchedException();
        }
        CallParticipant$UserOrStreamParticipant callParticipant$UserOrStreamParticipant = (CallParticipant$UserOrStreamParticipant) callParticipant;
        VideoCallParticipantView$ParticipantData participantData = callParticipant$UserOrStreamParticipant.getParticipantData();
        StoreVideoStreams$UserStreams streams = participantData.voiceParticipant.getStreams();
        VideoMetadata applicationStreamMetadata = streams != null ? streams.getApplicationStreamMetadata() : null;
        if (applicationStreamMetadata != null) {
            m.checkNotNullParameter(applicationStreamMetadata, "metadata");
            VideoCallParticipantView$StreamResolution videoCallParticipantView$StreamResolution$a = applicationStreamMetadata.type == Payloads$ResolutionType.Source ? VideoCallParticipantView$StreamResolution$b.a : new VideoCallParticipantView$StreamResolution$a(applicationStreamMetadata.maxHeight);
            Integer num = applicationStreamMetadata.maxFrameRate;
            VideoCallParticipantView$StreamFps videoCallParticipantView$StreamFps = num != null ? new VideoCallParticipantView$StreamFps(num.intValue()) : null;
            participantData = VideoCallParticipantView$ParticipantData.a(participantData, null, false, null, null, null, null, false, false, new VideoCallParticipantView$ParticipantData$a(videoCallParticipantView$StreamResolution$a.b() || (videoCallParticipantView$StreamFps != null && videoCallParticipantView$StreamFps.a()), videoCallParticipantView$StreamResolution$a, videoCallParticipantView$StreamFps, streamQuality == RtcConnection$Quality.BAD), 255);
        }
        return callParticipant$UserOrStreamParticipant.copy(participantData);
    }

    @MainThread
    private final void cancelTapForwardingJob() {
        Subscription subscription = this.forwardVideoGridInteractionSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.forwardVideoGridInteractionSubscription = null;
    }

    @MainThread
    private final void clearFocusedVideoParticipant() {
        WidgetCallFullscreenViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
            viewState = null;
        }
        WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid = (WidgetCallFullscreenViewModel$ViewState$Valid) viewState;
        if (widgetCallFullscreenViewModel$ViewState$Valid != null) {
            this.focusedVideoParticipantKey = null;
            stopWatchingStreamIfEnded();
            updateViewState2((WidgetCallFullscreenViewModel$ViewState) WidgetCallFullscreenViewModel$ViewState$Valid.m69copyJ3xfKWQ$default(widgetCallFullscreenViewModel$ViewState$Valid, null, null, null, computeVisibleVideoParticipants(), false, false, false, false, null, null, null, this.focusedVideoParticipantKey, false, computePipParticipant(widgetCallFullscreenViewModel$ViewState$Valid.getCallModel().getMyId(), widgetCallFullscreenViewModel$ViewState$Valid.getCallModel().getSelectedVideoDevice(), widgetCallFullscreenViewModel$ViewState$Valid.getCallModel().isStreaming(), widgetCallFullscreenViewModel$ViewState$Valid.getCameraState()), null, null, false, false, false, 0.0f, 0, false, null, false, false, 0, false, null, null, null, 0, 0, false, false, null, -10249, 7, null));
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0047  */
    @MainThread
    private final CallParticipant$UserOrStreamParticipant computePipParticipant(long myUserId, VideoInputDeviceDescription selectedVideoInputDevice, boolean isStreaming, CameraState cameraState) {
        Object next;
        boolean z2;
        if (this.allVideoParticipants.isEmpty()) {
            return null;
        }
        Iterator<T> it = this.allVideoParticipants.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            CallParticipant callParticipant = (CallParticipant) next;
            if (callParticipant instanceof CallParticipant$UserOrStreamParticipant) {
                CallParticipant$UserOrStreamParticipant callParticipant$UserOrStreamParticipant = (CallParticipant$UserOrStreamParticipant) callParticipant;
                VoiceState voiceState = callParticipant$UserOrStreamParticipant.getParticipantData().voiceParticipant.getVoiceState();
                if (voiceState != null && voiceState.getSelfVideo() && callParticipant$UserOrStreamParticipant.getParticipantData().voiceParticipant.isMe()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
        } while (!z2);
        CallParticipant callParticipant2 = (CallParticipant) next;
        boolean z3 = isStreaming && cameraState == CameraState.CAMERA_ON;
        String str = this.focusedVideoParticipantKey;
        boolean z4 = isOneOnOneMeCall(this.allVideoParticipants) || (str != null && !m.areEqual(str, String.valueOf(myUserId))) || z3;
        if (callParticipant2 == null || !(callParticipant2 instanceof CallParticipant$UserOrStreamParticipant) || !z4) {
            return null;
        }
        CallParticipant$UserOrStreamParticipant callParticipant$UserOrStreamParticipant2 = (CallParticipant$UserOrStreamParticipant) callParticipant2;
        return callParticipant$UserOrStreamParticipant2.copy(VideoCallParticipantView$ParticipantData.a(callParticipant$UserOrStreamParticipant2.getParticipantData(), null, (selectedVideoInputDevice != null ? selectedVideoInputDevice.getFacing() : null) == VideoInputDeviceFacing.Front, null, null, null, null, false, false, null, 445));
    }

    @MainThread
    private final List<CallParticipant> computeVisibleVideoParticipants() {
        Object next;
        Object objCopy;
        String str = this.focusedVideoParticipantKey;
        Object obj = null;
        if (str != null) {
            Iterator<T> it = this.allVideoParticipants.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!m.areEqual(getParticipantFocusKey((CallParticipant) next), str));
            CallParticipant callParticipant = (CallParticipant) next;
            if (callParticipant != null) {
                if (callParticipant instanceof CallParticipant$UserOrStreamParticipant) {
                    CallParticipant$UserOrStreamParticipant callParticipant$UserOrStreamParticipant = (CallParticipant$UserOrStreamParticipant) callParticipant;
                    VideoCallParticipantView$ParticipantData participantData = callParticipant$UserOrStreamParticipant.getParticipantData();
                    RendererCommon$ScalingType rendererCommon$ScalingType = participantData.scalingType;
                    RendererCommon$ScalingType rendererCommon$ScalingType2 = participantData.scalingTypeMismatchOrientation;
                    RendererCommon$ScalingType rendererCommon$ScalingType3 = RendererCommon$ScalingType.SCALE_ASPECT_FIT;
                    if (rendererCommon$ScalingType != rendererCommon$ScalingType3 || rendererCommon$ScalingType2 != rendererCommon$ScalingType3) {
                        objCopy = callParticipant$UserOrStreamParticipant;
                        objCopy = callParticipant$UserOrStreamParticipant.copy(VideoCallParticipantView$ParticipantData.a(callParticipant$UserOrStreamParticipant.getParticipantData(), null, false, rendererCommon$ScalingType3, rendererCommon$ScalingType3, null, null, false, false, null, 499));
                    }
                } else if (!(callParticipant instanceof CallParticipant$EmbeddedActivityParticipant)) {
                    objCopy = callParticipant;
                    throw new NoWhenBranchMatchedException();
                }
                objCopy = callParticipant;
                return d0.t.m.listOf(objCopy);
            }
            this.focusedVideoParticipantKey = null;
            stopWatchingStreamIfEnded();
        }
        if (isOneOnOneMeCall(this.allVideoParticipants)) {
            for (Object obj2 : this.allVideoParticipants) {
                CallParticipant callParticipant2 = (CallParticipant) obj2;
                if ((callParticipant2 instanceof CallParticipant$EmbeddedActivityParticipant) || ((callParticipant2 instanceof CallParticipant$UserOrStreamParticipant) && !((CallParticipant$UserOrStreamParticipant) callParticipant2).getParticipantData().voiceParticipant.isMe())) {
                    obj = obj2;
                    break;
                }
            }
            CallParticipant callParticipant3 = (CallParticipant) obj;
            if (callParticipant3 != null) {
                return d0.t.m.listOf(callParticipant3);
            }
        }
        return this.allVideoParticipants;
    }

    private final List<StoreVoiceParticipants$VoiceUser> createPrivateCallParticipantListItems(CallModel callModel) {
        return u.toList(callModel.getParticipants().values());
    }

    private final Comparator<StoreVoiceParticipants$VoiceUser> createUserItemsComparator(boolean prioritizeSpectators, String mySpectatingStreamKey) {
        return new WidgetCallFullscreenViewModel$createUserItemsComparator$1(mySpectatingStreamKey, prioritizeSpectators);
    }

    public static /* synthetic */ Comparator createUserItemsComparator$default(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return widgetCallFullscreenViewModel.createUserItemsComparator(z2, str);
    }

    private final List<CallParticipant> createVideoGridEntriesForParticipant(StoreVoiceParticipants$VoiceUser participant, long channelId, StoreApplicationStreaming$ActiveApplicationStream activeApplicationStream, RtcConnection$Quality streamQuality, VideoInputDeviceDescription selectedVideoInputDevice, boolean showLabels) {
        VoiceState voiceState;
        ModelApplicationStream stream;
        ArrayList arrayList = new ArrayList();
        if (!participant.isConnected() && !participant.isRinging()) {
            return n.emptyList();
        }
        String encodedStreamKey = null;
        arrayList.add(new CallParticipant$UserOrStreamParticipant(new VideoCallParticipantView$ParticipantData(participant, participant.isMe() && ((selectedVideoInputDevice != null ? selectedVideoInputDevice.getFacing() : null) == VideoInputDeviceFacing.Front), null, null, null, null, showLabels, false, null, 444)));
        if (participant.getApplicationStream() == null || (voiceState = participant.getVoiceState()) == null || !voiceState.getSelfStream()) {
            if (activeApplicationStream != null) {
                ModelApplicationStream stream2 = activeApplicationStream.getStream();
                if (participant.getUser().getId() == stream2.getOwnerId()) {
                    VideoCallParticipantView$ParticipantData$ApplicationStreamState participantStreamState = getParticipantStreamState(activeApplicationStream.getState());
                    RendererCommon$ScalingType rendererCommon$ScalingType = RendererCommon$ScalingType.SCALE_ASPECT_FIT;
                    VideoCallParticipantView$ParticipantData videoCallParticipantView$ParticipantData = new VideoCallParticipantView$ParticipantData(participant, false, rendererCommon$ScalingType, rendererCommon$ScalingType, participantStreamState, VideoCallParticipantView$ParticipantData$Type.APPLICATION_STREAMING, showLabels, false, null, 384);
                    if (isStreamFocused(stream2)) {
                        arrayList.add(new CallParticipant$UserOrStreamParticipant(videoCallParticipantView$ParticipantData));
                    } else {
                        stopWatchingStreamIfEnded();
                    }
                }
            }
        } else {
            if (participant.getApplicationStream().getChannelId() != channelId) {
                return arrayList;
            }
            if (activeApplicationStream != null && (stream = activeApplicationStream.getStream()) != null) {
                encodedStreamKey = stream.getEncodedStreamKey();
            }
            VideoCallParticipantView$ParticipantData$ApplicationStreamState participantStreamState2 = m.areEqual(encodedStreamKey, participant.getApplicationStream().getEncodedStreamKey()) ? getParticipantStreamState(activeApplicationStream.getState()) : VideoCallParticipantView$ParticipantData$ApplicationStreamState.INACTIVE;
            RendererCommon$ScalingType rendererCommon$ScalingType2 = RendererCommon$ScalingType.SCALE_ASPECT_FIT;
            arrayList.add(new CallParticipant$UserOrStreamParticipant(new VideoCallParticipantView$ParticipantData(participant, false, rendererCommon$ScalingType2, rendererCommon$ScalingType2, participantStreamState2, VideoCallParticipantView$ParticipantData$Type.APPLICATION_STREAMING, showLabels, false, null, 384)));
        }
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(addStreamQualityMetadata((CallParticipant) it.next(), streamQuality));
        }
        return arrayList2;
    }

    private final void emitServerDeafenedDialogEvent() {
        PublishSubject<WidgetCallFullscreenViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(WidgetCallFullscreenViewModel$Event$ShowServerDeafenedDialog.INSTANCE);
    }

    private final void emitServerMutedDialogEvent() {
        PublishSubject<WidgetCallFullscreenViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(WidgetCallFullscreenViewModel$Event$ShowServerMutedDialog.INSTANCE);
    }

    private final void emitShowNoScreenSharePermissionDialogEvent() {
        PublishSubject<WidgetCallFullscreenViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(WidgetCallFullscreenViewModel$Event$ShowNoScreenSharePermissionDialog.INSTANCE);
    }

    private final void emitShowNoVadPermissionDialogEvent() {
        PublishSubject<WidgetCallFullscreenViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(WidgetCallFullscreenViewModel$Event$ShowNoVadPermissionDialog.INSTANCE);
    }

    private final void emitShowNoVideoPermissionDialogEvent() {
        PublishSubject<WidgetCallFullscreenViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(WidgetCallFullscreenViewModel$Event$ShowNoVideoPermissionDialog.INSTANCE);
    }

    private final void emitSuppressedDialogEvent() {
        PublishSubject<WidgetCallFullscreenViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(WidgetCallFullscreenViewModel$Event$ShowSuppressedDialog.INSTANCE);
    }

    private final void enqueueStreamFeedbackSheet(String streamKey, String mediaSessionId, int triggerRateDenominator) {
        PublishSubject<WidgetCallFullscreenViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new WidgetCallFullscreenViewModel$Event$EnqueueStreamFeedbackSheet(streamKey, mediaSessionId, triggerRateDenominator));
    }

    private final String getParticipantFocusKey(CallParticipant callParticipant) {
        if (!(callParticipant instanceof CallParticipant$UserOrStreamParticipant)) {
            if (callParticipant instanceof CallParticipant$EmbeddedActivityParticipant) {
                return String.valueOf(((CallParticipant$EmbeddedActivityParticipant) callParticipant).getApplication().getId());
            }
            throw new NoWhenBranchMatchedException();
        }
        CallParticipant$UserOrStreamParticipant callParticipant$UserOrStreamParticipant = (CallParticipant$UserOrStreamParticipant) callParticipant;
        long id2 = callParticipant$UserOrStreamParticipant.getParticipantData().voiceParticipant.getUser().getId();
        int iOrdinal = callParticipant$UserOrStreamParticipant.getParticipantData().type.ordinal();
        if (iOrdinal == 0) {
            return String.valueOf(id2);
        }
        if (iOrdinal != 1) {
            throw new NoWhenBranchMatchedException();
        }
        return id2 + "--STREAM";
    }

    private final VideoCallParticipantView$ParticipantData$ApplicationStreamState getParticipantStreamState(StoreApplicationStreaming$ActiveApplicationStream$State applicationStreamState) {
        int iOrdinal = applicationStreamState.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return VideoCallParticipantView$ParticipantData$ApplicationStreamState.ACTIVE;
            }
            if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    return VideoCallParticipantView$ParticipantData$ApplicationStreamState.ENDED;
                }
                if (iOrdinal == 4) {
                    return VideoCallParticipantView$ParticipantData$ApplicationStreamState.PAUSED;
                }
                if (iOrdinal == 5) {
                    return VideoCallParticipantView$ParticipantData$ApplicationStreamState.INACTIVE;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        return VideoCallParticipantView$ParticipantData$ApplicationStreamState.CONNECTING;
    }

    private final boolean hasVideoPermission() {
        WidgetCallFullscreenViewModel$StoreState widgetCallFullscreenViewModel$StoreState = this.mostRecentStoreState;
        if (!(widgetCallFullscreenViewModel$StoreState instanceof WidgetCallFullscreenViewModel$StoreState$Valid)) {
            widgetCallFullscreenViewModel$StoreState = null;
        }
        WidgetCallFullscreenViewModel$StoreState$Valid widgetCallFullscreenViewModel$StoreState$Valid = (WidgetCallFullscreenViewModel$StoreState$Valid) widgetCallFullscreenViewModel$StoreState;
        if (widgetCallFullscreenViewModel$StoreState$Valid == null) {
            return false;
        }
        VideoPermissionsManager videoPermissionsManager = this.videoPermissionsManager;
        Channel channel = widgetCallFullscreenViewModel$StoreState$Valid.getCallModel().getChannel();
        Guild guild = widgetCallFullscreenViewModel$StoreState$Valid.getCallModel().getGuild();
        return videoPermissionsManager.hasVideoPermission(channel, guild != null ? guild.getAfkChannelId() : null, widgetCallFullscreenViewModel$StoreState$Valid.getMyPermissions());
    }

    private final boolean isOneOnOneMeCall(List<? extends CallParticipant> callParticipants) {
        boolean z2;
        if (callParticipants.size() == 2) {
            if (callParticipants.isEmpty()) {
                z2 = false;
            } else {
                for (CallParticipant callParticipant : callParticipants) {
                    if ((callParticipant instanceof CallParticipant$UserOrStreamParticipant) && ((CallParticipant$UserOrStreamParticipant) callParticipant).getParticipantData().voiceParticipant.isMe()) {
                        z2 = true;
                    }
                }
                z2 = false;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    private final boolean isStreamFocused(ModelApplicationStream stream) {
        return m.areEqual(this.focusedVideoParticipantKey, stream.getOwnerId() + "--STREAM");
    }

    private final Observable<WidgetCallFullscreenViewModel$StoreState> observeStoreState() {
        Observable observableY = this.storeChannels.observeChannel(this.channelId).Y(new WidgetCallFullscreenViewModel$observeStoreState$1(this));
        m.checkNotNullExpressionValue(observableY, "storeChannels.observeCha…}\n        }\n      }\n    }");
        return observableY;
    }

    @MainThread
    private final void onIdleStateChanged(Boolean isIdleFooter, Boolean isIdleHeader) {
        WidgetCallFullscreenViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
            viewState = null;
        }
        WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid = (WidgetCallFullscreenViewModel$ViewState$Valid) viewState;
        if (widgetCallFullscreenViewModel$ViewState$Valid != null) {
            boolean z2 = isIdleFooter != null && (m.areEqual(isIdleFooter, Boolean.valueOf(widgetCallFullscreenViewModel$ViewState$Valid.isIdleFooter())) ^ true);
            boolean z3 = isIdleHeader != null && (m.areEqual(isIdleHeader, Boolean.valueOf(widgetCallFullscreenViewModel$ViewState$Valid.isIdleHeader())) ^ true);
            if (z2) {
                if (isIdleFooter != null) {
                    isIdleFooter.booleanValue();
                    updateViewState2((WidgetCallFullscreenViewModel$ViewState) WidgetCallFullscreenViewModel$ViewState$Valid.m69copyJ3xfKWQ$default(widgetCallFullscreenViewModel$ViewState$Valid, null, null, null, null, isIdleFooter.booleanValue(), false, false, false, null, null, null, null, false, null, null, null, false, false, false, 0.0f, 0, false, null, false, false, 0, false, null, null, null, 0, 0, false, false, null, -17, 7, null));
                }
                if (isIdleFooter != null) {
                    isIdleFooter.booleanValue();
                    this.eventSubject.k.onNext(new WidgetCallFullscreenViewModel$Event$OnIdleStateChanged(isIdleFooter.booleanValue()));
                }
            }
            if (!z3 || isIdleHeader == null) {
                return;
            }
            isIdleHeader.booleanValue();
            updateViewState2((WidgetCallFullscreenViewModel$ViewState) WidgetCallFullscreenViewModel$ViewState$Valid.m69copyJ3xfKWQ$default(widgetCallFullscreenViewModel$ViewState$Valid, null, null, null, null, false, isIdleHeader.booleanValue(), false, false, null, null, null, null, false, null, null, null, false, false, false, 0.0f, 0, false, null, false, false, 0, false, null, null, null, 0, 0, false, false, null, -33, 7, null));
        }
    }

    public static /* synthetic */ void onIdleStateChanged$default(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        if ((i & 2) != 0) {
            bool2 = null;
        }
        widgetCallFullscreenViewModel.onIdleStateChanged(bool, bool2);
    }

    @MainThread
    private final void setOffScreenVideoParticipants(List<VideoCallParticipantView$ParticipantData> visibleVideoParticipants) {
        WidgetCallFullscreenViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
            viewState = null;
        }
        WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid = (WidgetCallFullscreenViewModel$ViewState$Valid) viewState;
        if (widgetCallFullscreenViewModel$ViewState$Valid == null || !widgetCallFullscreenViewModel$ViewState$Valid.getStopOffscreenVideo()) {
            return;
        }
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(visibleVideoParticipants, 10));
        Iterator<T> it = visibleVideoParticipants.iterator();
        while (it.hasNext()) {
            arrayList.add(((VideoCallParticipantView$ParticipantData) it.next()).com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_ID java.lang.String);
        }
        HashSet hashSet = u.toHashSet(arrayList);
        for (CallParticipant callParticipant : computeVisibleVideoParticipants()) {
            if (callParticipant instanceof CallParticipant$UserOrStreamParticipant) {
                VideoCallParticipantView$ParticipantData participantData = ((CallParticipant$UserOrStreamParticipant) callParticipant).getParticipantData();
                if (participantData.type == VideoCallParticipantView$ParticipantData$Type.DEFAULT) {
                    this.mediaSettingsStore.setUserOffScreen(participantData.voiceParticipant.getUser().getId(), !hashSet.contains(participantData.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_ID java.lang.String));
                }
            }
        }
    }

    private final boolean shouldShowMoreAudioOutputs(CallModel callModel) {
        List<DiscordAudioManager$AudioDevice> audioDevices = callModel.getAudioManagerState().getAudioDevices();
        if (!(audioDevices instanceof Collection) || !audioDevices.isEmpty()) {
            for (DiscordAudioManager$AudioDevice discordAudioManager$AudioDevice : audioDevices) {
                if (discordAudioManager$AudioDevice.type == DiscordAudioManager$DeviceTypes.BLUETOOTH_HEADSET && discordAudioManager$AudioDevice.isAvailable) {
                    return true;
                }
            }
        }
        return false;
    }

    @MainThread
    private final void startTapForwardingJob() {
        cancelTapForwardingJob();
        Observable<Long> observableE0 = Observable.e0(255L, TimeUnit.MILLISECONDS, this.backgroundThreadScheduler);
        m.checkNotNullExpressionValue(observableE0, "Observable\n        .time…ackgroundThreadScheduler)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableE0, this, null, 2, null), WidgetCallFullscreenViewModel.class, (Context) null, new WidgetCallFullscreenViewModel$startTapForwardingJob$1(this), (Function1) null, (Function0) null, (Function0) null, new WidgetCallFullscreenViewModel$startTapForwardingJob$2(this), 58, (Object) null);
    }

    @MainThread
    private final void stopWatchingStream() {
        StoreApplicationStreaming$ActiveApplicationStream activeStream;
        ModelApplicationStream stream;
        WidgetCallFullscreenViewModel$ViewState widgetCallFullscreenViewModel$ViewStateRequireViewState = requireViewState();
        if (!(widgetCallFullscreenViewModel$ViewStateRequireViewState instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
            widgetCallFullscreenViewModel$ViewStateRequireViewState = null;
        }
        WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid = (WidgetCallFullscreenViewModel$ViewState$Valid) widgetCallFullscreenViewModel$ViewStateRequireViewState;
        if (widgetCallFullscreenViewModel$ViewState$Valid == null || (activeStream = widgetCallFullscreenViewModel$ViewState$Valid.getCallModel().getActiveStream()) == null || (stream = activeStream.getStream()) == null) {
            return;
        }
        this.applicationStreamingStore.stopStream(stream.getEncodedStreamKey());
        CallModel callModel = widgetCallFullscreenViewModel$ViewState$Valid.getCallModel();
        if (isStreamFocused(stream)) {
            this.focusedVideoParticipantKey = null;
            updateViewState2((WidgetCallFullscreenViewModel$ViewState) WidgetCallFullscreenViewModel$ViewState$Valid.m69copyJ3xfKWQ$default(widgetCallFullscreenViewModel$ViewState$Valid, null, null, null, computeVisibleVideoParticipants(), false, false, false, false, null, null, null, this.focusedVideoParticipantKey, false, computePipParticipant(callModel.getMyId(), callModel.getSelectedVideoDevice(), callModel.isStreaming(), widgetCallFullscreenViewModel$ViewState$Valid.getCameraState()), null, null, false, false, false, 0.0f, 0, false, null, false, false, 0, false, null, null, null, 0, 0, false, false, null, -10249, 7, null));
        }
    }

    @MainThread
    private final void stopWatchingStreamIfEnded() {
        WidgetCallFullscreenViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
            viewState = null;
        }
        WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid = (WidgetCallFullscreenViewModel$ViewState$Valid) viewState;
        if (widgetCallFullscreenViewModel$ViewState$Valid != null) {
            StoreApplicationStreaming$ActiveApplicationStream activeStream = widgetCallFullscreenViewModel$ViewState$Valid.getCallModel().getActiveStream();
            StoreApplicationStreaming$ActiveApplicationStream activeStream2 = widgetCallFullscreenViewModel$ViewState$Valid.getCallModel().getActiveStream();
            if (activeStream2 != null) {
                activeStream2.getStream();
            }
            if ((activeStream != null ? activeStream.getState() : null) == StoreApplicationStreaming$ActiveApplicationStream$State.ENDED) {
                stopWatchingStream();
            }
        }
    }

    public final void disableControlFading() {
        WidgetCallFullscreenViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
            viewState = null;
        }
        WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid = (WidgetCallFullscreenViewModel$ViewState$Valid) viewState;
        if (widgetCallFullscreenViewModel$ViewState$Valid != null && !widgetCallFullscreenViewModel$ViewState$Valid.isControlFadingDisabled()) {
            updateViewState2((WidgetCallFullscreenViewModel$ViewState) WidgetCallFullscreenViewModel$ViewState$Valid.m69copyJ3xfKWQ$default(widgetCallFullscreenViewModel$ViewState$Valid, null, null, null, null, false, false, true, false, null, null, null, null, false, null, null, null, false, false, false, 0.0f, 0, false, null, false, false, 0, false, null, null, null, 0, 0, false, false, null, -65, 7, null));
        }
    }

    @MainThread
    public final void disconnect() {
        this.videoPlayerIdleDetectorFooter.onPreventIdle();
        this.videoPlayerIdleDetectorHeader.onPreventIdle();
        this.selectedVoiceChannelStore.clear();
        if (!this.wasEverConnected || this.wasEverMultiParticipant) {
            WidgetCallFullscreenViewModel$ViewState viewState = getViewState();
            if (!(viewState instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
                viewState = null;
            }
            WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid = (WidgetCallFullscreenViewModel$ViewState$Valid) viewState;
            if (widgetCallFullscreenViewModel$ViewState$Valid != null) {
                CallModel callModel = widgetCallFullscreenViewModel$ViewState$Valid.getCallModel();
                RtcConnection$Metadata rtcConnectionMetadata = callModel.getRtcConnectionMetadata();
                this.eventSubject.k.onNext(new WidgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet(this.channelId, rtcConnectionMetadata != null ? rtcConnectionMetadata.rtcConnectionId : null, rtcConnectionMetadata != null ? rtcConnectionMetadata.mediaSessionId : null, callModel.getCallDurationMs(this.clock), callModel.getCallFeedbackTriggerRateDenominator()));
            }
        }
    }

    @MainThread
    public final void focusVideoParticipant(String participantKey) {
        m.checkNotNullParameter(participantKey, "participantKey");
        WidgetCallFullscreenViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
            viewState = null;
        }
        WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid = (WidgetCallFullscreenViewModel$ViewState$Valid) viewState;
        if (widgetCallFullscreenViewModel$ViewState$Valid != null) {
            if (!isOneOnOneMeCall(this.allVideoParticipants)) {
                this.focusedVideoParticipantKey = participantKey;
            }
            updateViewState2((WidgetCallFullscreenViewModel$ViewState) WidgetCallFullscreenViewModel$ViewState$Valid.m69copyJ3xfKWQ$default(widgetCallFullscreenViewModel$ViewState$Valid, null, null, null, computeVisibleVideoParticipants(), false, false, false, false, null, null, null, this.focusedVideoParticipantKey, false, computePipParticipant(widgetCallFullscreenViewModel$ViewState$Valid.getCallModel().getMyId(), widgetCallFullscreenViewModel$ViewState$Valid.getCallModel().getSelectedVideoDevice(), widgetCallFullscreenViewModel$ViewState$Valid.getCallModel().isStreaming(), widgetCallFullscreenViewModel$ViewState$Valid.getCameraState()), null, null, false, false, false, 0.0f, 0, false, null, false, false, 0, false, null, null, null, 0, 0, false, false, null, -10249, 7, null));
        }
    }

    public final boolean getShowStageCallBottomSheet() {
        return this.showStageCallBottomSheet;
    }

    @MainThread
    public final void handleBottomSheetState(int bottomSheetState) {
        this.bottomSheetState = Integer.valueOf(bottomSheetState);
    }

    /* JADX WARN: Code duplicated, block: B:141:0x034a  */
    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1096)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1050)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:130)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
     */
    @MainThread
    public final void handleStoreState(WidgetCallFullscreenViewModel$StoreState storeState) {
        boolean z2;
        VoiceState voiceState;
        VoiceState voiceState2;
        CallModel callModel;
        int i;
        int i2;
        int i3;
        List<? extends CallParticipant> listEmptyList;
        StageCallModel stageCallModel;
        List<StageMediaParticipant> mediaParticipants;
        VoiceControlsOutputSelectorState voiceControlsOutputSelectorState;
        WidgetCallFullscreenViewModel$ViewState widgetCallFullscreenViewModel$ViewState;
        boolean z3;
        Object next;
        Object next2;
        String str;
        StageRoles stageRolesM68getMyStageRolestwRsX0;
        StageRoles stageRolesM68getMyStageRolestwRsX1;
        boolean z4;
        ModelApplicationStream applicationStream;
        ModelApplicationStream stream;
        CallModel callModel2;
        m.checkNotNullParameter(storeState, "storeState");
        if (m.areEqual(storeState, WidgetCallFullscreenViewModel$StoreState$Invalid.INSTANCE)) {
            updateViewState2((WidgetCallFullscreenViewModel$ViewState) WidgetCallFullscreenViewModel$ViewState$Invalid.INSTANCE);
        } else if (storeState instanceof WidgetCallFullscreenViewModel$StoreState$Valid) {
            WidgetCallFullscreenViewModel$StoreState$Valid widgetCallFullscreenViewModel$StoreState$Valid = (WidgetCallFullscreenViewModel$StoreState$Valid) storeState;
            boolean zD = ChannelUtils.D(widgetCallFullscreenViewModel$StoreState$Valid.getCallModel().getChannel());
            if (!zD && new TextInVoiceOnboardingManager().shouldShowTextInVoiceOnboarding(widgetCallFullscreenViewModel$StoreState$Valid.getCallModel().getMyId(), Long.valueOf(widgetCallFullscreenViewModel$StoreState$Valid.getCallModel().getChannel().getGuildId()))) {
                this.eventSubject.k.onNext(WidgetCallFullscreenViewModel$Event$ShowTextInVoiceNux.INSTANCE);
            }
            if (this.startedAsVideo == null) {
                this.startedAsVideo = Boolean.valueOf(widgetCallFullscreenViewModel$StoreState$Valid.getCallModel().getIsVideoCall());
            }
            WidgetCallFullscreenViewModel$StoreState widgetCallFullscreenViewModel$StoreState = this.mostRecentStoreState;
            if (!(widgetCallFullscreenViewModel$StoreState instanceof WidgetCallFullscreenViewModel$StoreState$Valid)) {
                widgetCallFullscreenViewModel$StoreState = null;
            }
            WidgetCallFullscreenViewModel$StoreState$Valid widgetCallFullscreenViewModel$StoreState$Valid2 = (WidgetCallFullscreenViewModel$StoreState$Valid) widgetCallFullscreenViewModel$StoreState;
            boolean zIsChannelSelected = (widgetCallFullscreenViewModel$StoreState$Valid2 == null || (callModel2 = widgetCallFullscreenViewModel$StoreState$Valid2.getCallModel()) == null) ? false : callModel2.isChannelSelected();
            boolean zIsChannelSelected2 = widgetCallFullscreenViewModel$StoreState$Valid.getCallModel().isChannelSelected();
            if (zIsChannelSelected && !zIsChannelSelected2) {
                updateViewState2((WidgetCallFullscreenViewModel$ViewState) WidgetCallFullscreenViewModel$ViewState$Invalid.INSTANCE);
                return;
            }
            WidgetCallFullscreenViewModel$OverlayStatus widgetCallFullscreenViewModel$OverlayStatus = this.userSettingsStore.getIsMobileOverlayEnabled() ? WidgetCallFullscreenViewModel$OverlayStatus.ENABLED : WidgetCallFullscreenViewModel$OverlayStatus.DISABLED;
            VideoInputDeviceDescription selectedVideoDevice = widgetCallFullscreenViewModel$StoreState$Valid.getCallModel().getSelectedVideoDevice();
            Collection<StoreVoiceParticipants$VoiceUser> collectionValues = widgetCallFullscreenViewModel$StoreState$Valid.getCallModel().getParticipants().values();
            if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
                Iterator<T> it = collectionValues.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    }
                    StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser = (StoreVoiceParticipants$VoiceUser) it.next();
                    if (storeVoiceParticipants$VoiceUser.isConnected() && (((voiceState = storeVoiceParticipants$VoiceUser.getVoiceState()) != null && voiceState.getSelfVideo()) || ((voiceState2 = storeVoiceParticipants$VoiceUser.getVoiceState()) != null && voiceState2.getSelfStream()))) {
                        z2 = true;
                        break;
                    }
                }
            } else {
                z2 = false;
                break;
            }
            WidgetCallFullscreenViewModel$StoreState widgetCallFullscreenViewModel$StoreState2 = this.mostRecentStoreState;
            if (!(widgetCallFullscreenViewModel$StoreState2 instanceof WidgetCallFullscreenViewModel$StoreState$Valid)) {
                widgetCallFullscreenViewModel$StoreState2 = null;
            }
            WidgetCallFullscreenViewModel$StoreState$Valid widgetCallFullscreenViewModel$StoreState$Valid3 = (WidgetCallFullscreenViewModel$StoreState$Valid) widgetCallFullscreenViewModel$StoreState2;
            int channelMentionsCount = widgetCallFullscreenViewModel$StoreState$Valid3 != null ? widgetCallFullscreenViewModel$StoreState$Valid3.getChannelMentionsCount() : 0;
            WidgetCallFullscreenViewModel$StoreState widgetCallFullscreenViewModel$StoreState3 = this.mostRecentStoreState;
            if (!(widgetCallFullscreenViewModel$StoreState3 instanceof WidgetCallFullscreenViewModel$StoreState$Valid)) {
                widgetCallFullscreenViewModel$StoreState3 = null;
            }
            WidgetCallFullscreenViewModel$StoreState$Valid widgetCallFullscreenViewModel$StoreState$Valid4 = (WidgetCallFullscreenViewModel$StoreState$Valid) widgetCallFullscreenViewModel$StoreState3;
            int unreadsCount = widgetCallFullscreenViewModel$StoreState$Valid4 != null ? widgetCallFullscreenViewModel$StoreState$Valid4.getUnreadsCount() : 0;
            WidgetCallFullscreenViewModel$ViewState viewState = getViewState();
            if (!(viewState instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
                viewState = null;
            }
            WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid = (WidgetCallFullscreenViewModel$ViewState$Valid) viewState;
            boolean zIsIdleFooter = widgetCallFullscreenViewModel$ViewState$Valid != null ? widgetCallFullscreenViewModel$ViewState$Valid.isIdleFooter() : false;
            WidgetCallFullscreenViewModel$ViewState viewState2 = getViewState();
            if (!(viewState2 instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
                viewState2 = null;
            }
            WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid2 = (WidgetCallFullscreenViewModel$ViewState$Valid) viewState2;
            boolean zIsIdleHeader = widgetCallFullscreenViewModel$ViewState$Valid2 != null ? widgetCallFullscreenViewModel$ViewState$Valid2.isIdleHeader() : false;
            WidgetCallFullscreenViewModel$ViewState viewState3 = getViewState();
            if (!(viewState3 instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
                viewState3 = null;
            }
            WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid3 = (WidgetCallFullscreenViewModel$ViewState$Valid) viewState3;
            boolean zIsControlFadingDisabled = widgetCallFullscreenViewModel$ViewState$Valid3 != null ? widgetCallFullscreenViewModel$ViewState$Valid3.isControlFadingDisabled() : false;
            StoreApplicationStreaming$ActiveApplicationStream activeStream = widgetCallFullscreenViewModel$StoreState$Valid.getCallModel().getActiveStream();
            String encodedStreamKey = (activeStream == null || (stream = activeStream.getStream()) == null) ? null : stream.getEncodedStreamKey();
            CallModel callModel3 = widgetCallFullscreenViewModel$StoreState$Valid.getCallModel();
            if (!callModel3.isConnected() || zD) {
                callModel = callModel3;
                i = unreadsCount;
                i2 = channelMentionsCount;
                i3 = 10;
                if (!widgetCallFullscreenViewModel$StoreState$Valid.getCallModel().isConnected() || (stageCallModel = widgetCallFullscreenViewModel$StoreState$Valid.getStageCallModel()) == null || (mediaParticipants = stageCallModel.getMediaParticipants()) == null) {
                    listEmptyList = n.emptyList();
                } else {
                    ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(mediaParticipants, 10));
                    Iterator<T> it2 = mediaParticipants.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(createVideoGridEntriesForParticipant(((StageMediaParticipant) it2.next()).getVoiceUser(), widgetCallFullscreenViewModel$StoreState$Valid.getCallModel().getChannel().getId(), widgetCallFullscreenViewModel$StoreState$Valid.getCallModel().getActiveStream(), widgetCallFullscreenViewModel$StoreState$Valid.getStreamQuality(), widgetCallFullscreenViewModel$StoreState$Valid.getCallModel().getSelectedVideoDevice(), !zIsIdleFooter));
                    }
                    listEmptyList = o.flatten(arrayList);
                    if (listEmptyList == null) {
                        listEmptyList = n.emptyList();
                    }
                }
            } else {
                Map<Long, EmbeddedActivity> embeddedActivitiesForChannel = callModel3.getEmbeddedActivitiesForChannel();
                Iterator<Long> it3 = embeddedActivitiesForChannel.keySet().iterator();
                while (it3.hasNext()) {
                    long jLongValue = it3.next().longValue();
                    this.applicationStore.fetchIfNonexisting(jLongValue);
                    this.applicationAssetsStore.fetchIfNonExisting(jLongValue);
                }
                ArrayList arrayList2 = new ArrayList(embeddedActivitiesForChannel.size());
                Iterator<Map$Entry<Long, EmbeddedActivity>> it4 = embeddedActivitiesForChannel.entrySet().iterator();
                while (it4.hasNext()) {
                    Map$Entry<Long, EmbeddedActivity> next3 = it4.next();
                    long jLongValue2 = next3.getKey().longValue();
                    EmbeddedActivity value = next3.getValue();
                    Application application = callModel3.getApplications().get(Long.valueOf(jLongValue2));
                    arrayList2.add(application != null ? new CallParticipant$EmbeddedActivityParticipant(value, EmbeddedActivityUtilsKt.getActivityParticipants(value, callModel3.getParticipants()), com.discord.models.commands.Application.Companion.fromApiApplication(application), widgetCallFullscreenViewModel$StoreState$Valid.getEmbeddedAppBackgrounds().get(Long.valueOf(jLongValue2))) : null);
                    it4 = it4;
                    unreadsCount = unreadsCount;
                }
                int i4 = unreadsCount;
                List listFilterNotNull = u.filterNotNull(arrayList2);
                List listSortedWith = u.sortedWith(callModel3.getParticipants().values(), createUserItemsComparator$default(this, false, encodedStreamKey, 1, null));
                ArrayList arrayList3 = new ArrayList(o.collectionSizeOrDefault(listSortedWith, 10));
                Iterator it5 = listSortedWith.iterator();
                while (it5.hasNext()) {
                    arrayList3.add(createVideoGridEntriesForParticipant((StoreVoiceParticipants$VoiceUser) it5.next(), widgetCallFullscreenViewModel$StoreState$Valid.getCallModel().getChannel().getId(), widgetCallFullscreenViewModel$StoreState$Valid.getCallModel().getActiveStream(), widgetCallFullscreenViewModel$StoreState$Valid.getStreamQuality(), widgetCallFullscreenViewModel$StoreState$Valid.getCallModel().getSelectedVideoDevice(), !zIsIdleFooter));
                    callModel3 = callModel3;
                    it5 = it5;
                    channelMentionsCount = channelMentionsCount;
                }
                callModel = callModel3;
                i2 = channelMentionsCount;
                i = i4;
                i3 = 10;
                List listFlatten = o.flatten(arrayList3);
                ArrayList arrayList4 = new ArrayList();
                for (Object obj : listFlatten) {
                    if (!widgetCallFullscreenViewModel$StoreState$Valid.getCallModel().getVoiceSettings().getVoiceParticipantsHidden() || ((CallParticipant) obj).hasActiveVideo()) {
                        arrayList4.add(obj);
                    }
                }
                listEmptyList = u.plus((Collection) listFilterNotNull, (Iterable) arrayList4);
            }
            List<? extends CallParticipant> list = listEmptyList;
            this.allVideoParticipants = list;
            if (isOneOnOneMeCall(list)) {
                this.focusedVideoParticipantKey = null;
            }
            List<CallParticipant> listComputeVisibleVideoParticipants = computeVisibleVideoParticipants();
            CameraState cameraState = (!zD && callModel.isConnected()) ? selectedVideoDevice != null ? CameraState.CAMERA_ON : CameraState.CAMERA_OFF : CameraState.CAMERA_DISABLED;
            CameraState cameraState2 = cameraState;
            boolean z5 = (callModel.getVideoDevices().size() >= 2) && cameraState2 == CameraState.CAMERA_ON;
            WidgetCallFullscreenViewModel$DisplayMode widgetCallFullscreenViewModel$DisplayMode = (!ChannelUtils.B(callModel.getChannel()) || z2) ? zD ? WidgetCallFullscreenViewModel$DisplayMode.STAGE : WidgetCallFullscreenViewModel$DisplayMode.GRID : WidgetCallFullscreenViewModel$DisplayMode.PRIVATE_CALL_PARTICIPANTS;
            StoreAudioManagerV2$State audioManagerState = callModel.getAudioManagerState();
            boolean zShouldShowMoreAudioOutputs = shouldShowMoreAudioOutputs(widgetCallFullscreenViewModel$StoreState$Valid.getCallModel());
            DiscordAudioManager$DeviceTypes activeAudioDevice = audioManagerState.getActiveAudioDevice();
            if (zShouldShowMoreAudioOutputs) {
                int iOrdinal = activeAudioDevice.ordinal();
                voiceControlsOutputSelectorState = iOrdinal != 2 ? iOrdinal != 5 ? VoiceControlsOutputSelectorState.SPEAKER_OFF_AND_MORE : VoiceControlsOutputSelectorState.BLUETOOTH_ON_AND_MORE : VoiceControlsOutputSelectorState.SPEAKER_ON_AND_MORE;
            } else {
                voiceControlsOutputSelectorState = activeAudioDevice == DiscordAudioManager$DeviceTypes.SPEAKERPHONE ? VoiceControlsOutputSelectorState.SPEAKER_ON : VoiceControlsOutputSelectorState.SPEAKER_OFF;
            }
            VoiceControlsOutputSelectorState voiceControlsOutputSelectorState2 = voiceControlsOutputSelectorState;
            String str2 = this.autotargetStreamKey;
            if (str2 != null && (!list.isEmpty())) {
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it6 = list.iterator();
                    while (true) {
                        if (!it6.hasNext()) {
                            z4 = false;
                            break;
                        }
                        CallParticipant callParticipant = (CallParticipant) it6.next();
                        if (!(callParticipant instanceof CallParticipant$UserOrStreamParticipant)) {
                            callParticipant = null;
                        }
                        CallParticipant$UserOrStreamParticipant callParticipant$UserOrStreamParticipant = (CallParticipant$UserOrStreamParticipant) callParticipant;
                        if (m.areEqual((callParticipant$UserOrStreamParticipant == null || (applicationStream = callParticipant$UserOrStreamParticipant.getParticipantData().voiceParticipant.getApplicationStream()) == null) ? null : applicationStream.getEncodedStreamKey(), str2)) {
                            z4 = true;
                            break;
                        }
                    }
                } else {
                    z4 = false;
                    break;
                }
                if (z4) {
                    targetAndFocusStream(str2);
                }
                this.autotargetStreamKey = null;
            }
            CallParticipant$UserOrStreamParticipant callParticipant$UserOrStreamParticipantComputePipParticipant = computePipParticipant(callModel.getMyId(), callModel.getSelectedVideoDevice(), callModel.isStreaming(), cameraState2);
            CallModel callModel4 = callModel;
            List<StoreVoiceParticipants$VoiceUser> listCreatePrivateCallParticipantListItems = createPrivateCallParticipantListItems(callModel4);
            StoreConnectivity$State state = widgetCallFullscreenViewModel$StoreState$Valid.getConnectivityState().getState();
            boolean z6 = (state == StoreConnectivity$State.OFFLINE || state == StoreConnectivity$State.OFFLINE_AIRPLANE_MODE) && widgetCallFullscreenViewModel$DisplayMode == WidgetCallFullscreenViewModel$DisplayMode.PRIVATE_CALL_PARTICIPANTS;
            if (ChannelUtils.D(callModel4.getChannel())) {
                WidgetCallFullscreenViewModel$StoreState widgetCallFullscreenViewModel$StoreState4 = this.mostRecentStoreState;
                if (!(widgetCallFullscreenViewModel$StoreState4 instanceof WidgetCallFullscreenViewModel$StoreState$Valid)) {
                    widgetCallFullscreenViewModel$StoreState4 = null;
                }
                WidgetCallFullscreenViewModel$StoreState$Valid widgetCallFullscreenViewModel$StoreState$Valid5 = (WidgetCallFullscreenViewModel$StoreState$Valid) widgetCallFullscreenViewModel$StoreState4;
                if (widgetCallFullscreenViewModel$StoreState$Valid5 != null && (stageRolesM68getMyStageRolestwRsX0 = widgetCallFullscreenViewModel$StoreState$Valid5.m68getMyStageRolestwRsX0()) != null && !StageRoles.m33isSpeakerimpl(stageRolesM68getMyStageRolestwRsX0.m35unboximpl()) && (stageRolesM68getMyStageRolestwRsX1 = widgetCallFullscreenViewModel$StoreState$Valid.m68getMyStageRolestwRsX0()) != null && StageRoles.m33isSpeakerimpl(stageRolesM68getMyStageRolestwRsX1.m35unboximpl()) && !PermissionUtils.can(Permission.USE_VAD, widgetCallFullscreenViewModel$StoreState$Valid.getMyPermissions()) && callModel4.getInputMode() != MediaEngineConnection$InputMode.PUSH_TO_TALK) {
                    emitShowNoVadPermissionDialogEvent();
                }
            }
            this.wasEverMultiParticipant = this.wasEverMultiParticipant || widgetCallFullscreenViewModel$StoreState$Valid.getCallModel().getNumUsersConnected() > 1;
            this.wasEverConnected = this.wasEverConnected || widgetCallFullscreenViewModel$StoreState$Valid.getCallModel().isConnected();
            ArrayList<CallParticipant$UserOrStreamParticipant> arrayList5 = new ArrayList();
            for (Object obj2 : list) {
                if (obj2 instanceof CallParticipant$UserOrStreamParticipant) {
                    arrayList5.add(obj2);
                }
            }
            ArrayList arrayList6 = new ArrayList(o.collectionSizeOrDefault(arrayList5, i3));
            for (CallParticipant$UserOrStreamParticipant callParticipant$UserOrStreamParticipant2 : arrayList5) {
                Objects.requireNonNull(callParticipant$UserOrStreamParticipant2, "null cannot be cast to non-null type com.discord.widgets.voice.fullscreen.CallParticipant.UserOrStreamParticipant");
                int iOrdinal2 = callParticipant$UserOrStreamParticipant2.getParticipantData().type.ordinal();
                if (iOrdinal2 == 0) {
                    str = "USER";
                } else {
                    if (iOrdinal2 != 1) {
                        throw new NoWhenBranchMatchedException();
                    }
                    str = "STREAM";
                }
                arrayList6.add(d0.o.to(str + '-' + callParticipant$UserOrStreamParticipant2.getParticipantData().voiceParticipant.getUser().getId(), callParticipant$UserOrStreamParticipant2));
            }
            Map map = h0.toMap(arrayList6);
            if (i2 < widgetCallFullscreenViewModel$StoreState$Valid.getChannelMentionsCount() || i < widgetCallFullscreenViewModel$StoreState$Valid.getUnreadsCount()) {
                widgetCallFullscreenViewModel$ViewState = null;
                VideoPlayerIdleDetector.onInteraction$default(this.videoPlayerIdleDetectorHeader, false, 1, null);
                z3 = false;
            } else {
                z3 = zIsIdleHeader;
                widgetCallFullscreenViewModel$ViewState = null;
            }
            StageCallModel stageCallModel2 = widgetCallFullscreenViewModel$StoreState$Valid.getStageCallModel();
            String str3 = this.focusedVideoParticipantKey;
            Boolean noiseCancellation = widgetCallFullscreenViewModel$StoreState$Valid.getNoiseCancellation();
            boolean z7 = widgetCallFullscreenViewModel$StoreState$Valid.getCallModel().getVoiceSettings().getVoiceParticipantsHidden() && !callModel4.isStreaming() && listComputeVisibleVideoParticipants.isEmpty() && widgetCallFullscreenViewModel$DisplayMode == WidgetCallFullscreenViewModel$DisplayMode.GRID;
            boolean zIsScreenReaderEnabled = widgetCallFullscreenViewModel$StoreState$Valid.isScreenReaderEnabled();
            Boolean bool = this.startedAsVideo;
            boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
            float fAmplitudeToPerceptual = PerceptualVolumeUtils.INSTANCE.amplitudeToPerceptual(widgetCallFullscreenViewModel$StoreState$Valid.getStreamVolume(), 300.0f);
            int iCoerceAtLeast = f.coerceAtLeast(widgetCallFullscreenViewModel$StoreState$Valid.getTotalMentionsCount() - widgetCallFullscreenViewModel$StoreState$Valid.getChannelMentionsCount(), 0);
            StageRoles stageRolesM68getMyStageRolestwRsX2 = widgetCallFullscreenViewModel$StoreState$Valid.m68getMyStageRolestwRsX0();
            WidgetCallFullscreenViewModel$ViewState viewState4 = getViewState();
            if (!(viewState4 instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
                viewState4 = widgetCallFullscreenViewModel$ViewState;
            }
            WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid4 = (WidgetCallFullscreenViewModel$ViewState$Valid) viewState4;
            boolean z8 = widgetCallFullscreenViewModel$ViewState$Valid4 != null && widgetCallFullscreenViewModel$ViewState$Valid4.isUpdatingRequestToSpeak();
            WidgetCallFullscreenViewModel$ViewState viewState5 = getViewState();
            if (!(viewState5 instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
                viewState5 = widgetCallFullscreenViewModel$ViewState;
            }
            WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid5 = (WidgetCallFullscreenViewModel$ViewState$Valid) viewState5;
            boolean z9 = widgetCallFullscreenViewModel$ViewState$Valid5 != null && widgetCallFullscreenViewModel$ViewState$Valid5.isMovingToAudience();
            StageCallModel stageCallModel3 = widgetCallFullscreenViewModel$StoreState$Valid.getStageCallModel();
            int requestingToSpeakCount = stageCallModel3 != null ? stageCallModel3.getRequestingToSpeakCount() : 0;
            boolean stopOffscreenVideo = widgetCallFullscreenViewModel$StoreState$Valid.getStopOffscreenVideo();
            Long myPermissions = widgetCallFullscreenViewModel$StoreState$Valid.getMyPermissions();
            Iterator it7 = u.sortedWith(widgetCallFullscreenViewModel$StoreState$Valid.getCallModel().getGuildScheduledEvents(), new WidgetCallFullscreenViewModel$handleStoreState$$inlined$sortedBy$1()).iterator();
            do {
                if (!it7.hasNext()) {
                    next = widgetCallFullscreenViewModel$ViewState;
                    break;
                }
                next = it7.next();
            } while (!GuildScheduledEventUtilitiesKt.getEventTiming((GuildScheduledEvent) next).isStartable());
            GuildScheduledEvent guildScheduledEvent = (GuildScheduledEvent) next;
            Iterator<T> it8 = widgetCallFullscreenViewModel$StoreState$Valid.getCallModel().getGuildScheduledEvents().iterator();
            do {
                if (!it8.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it8.next();
            } while (!(((GuildScheduledEvent) next2).getStatus() == GuildScheduledEventStatus.ACTIVE));
            updateViewState2((WidgetCallFullscreenViewModel$ViewState) new WidgetCallFullscreenViewModel$ViewState$Valid(callModel4, stageCallModel2, widgetCallFullscreenViewModel$OverlayStatus, listComputeVisibleVideoParticipants, zIsIdleFooter, z3, zIsControlFadingDisabled, z5, cameraState2, widgetCallFullscreenViewModel$DisplayMode, voiceControlsOutputSelectorState2, str3, z2, callParticipant$UserOrStreamParticipantComputePipParticipant, noiseCancellation, listCreatePrivateCallParticipantListItems, z7, zIsScreenReaderEnabled, zBooleanValue, fAmplitudeToPerceptual, iCoerceAtLeast, z6, stageRolesM68getMyStageRolestwRsX2, z8, z9, requestingToSpeakCount, stopOffscreenVideo, myPermissions, guildScheduledEvent, (GuildScheduledEvent) next2, widgetCallFullscreenViewModel$StoreState$Valid.getChannelMentionsCount(), widgetCallFullscreenViewModel$StoreState$Valid.getUnreadsCount(), widgetCallFullscreenViewModel$StoreState$Valid.isTextInVoiceEnabled(), widgetCallFullscreenViewModel$StoreState$Valid.isTextInVoiceChannelSelected(), map, null));
        }
        this.mostRecentStoreState = storeState;
    }

    @Override // b.a.d.d0
    public /* bridge */ /* synthetic */ WidgetCallFullscreenViewModel$ViewState modifyPendingViewState(WidgetCallFullscreenViewModel$ViewState widgetCallFullscreenViewModel$ViewState, WidgetCallFullscreenViewModel$ViewState widgetCallFullscreenViewModel$ViewState2) {
        return modifyPendingViewState2(widgetCallFullscreenViewModel$ViewState, widgetCallFullscreenViewModel$ViewState2);
    }

    @MainThread
    public final void moveMeToAudience() {
        WidgetCallFullscreenViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
            viewState = null;
        }
        WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid = (WidgetCallFullscreenViewModel$ViewState$Valid) viewState;
        if (widgetCallFullscreenViewModel$ViewState$Valid == null || widgetCallFullscreenViewModel$ViewState$Valid.isMovingToAudience()) {
            return;
        }
        updateViewState2((WidgetCallFullscreenViewModel$ViewState) WidgetCallFullscreenViewModel$ViewState$Valid.m69copyJ3xfKWQ$default(widgetCallFullscreenViewModel$ViewState$Valid, null, null, null, null, false, false, false, false, null, null, null, null, false, null, null, null, false, false, false, 0.0f, 0, false, null, false, true, 0, false, null, null, null, 0, 0, false, false, null, -16777217, 7, null));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApiSerializeNulls().setMeSuppressed(widgetCallFullscreenViewModel$ViewState$Valid.getCallModel().getChannel(), true), false, 1, null), this, null, 2, null), WidgetCallFullscreenViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, new WidgetCallFullscreenViewModel$moveMeToAudience$1(this), WidgetCallFullscreenViewModel$moveMeToAudience$2.INSTANCE, 30, (Object) null);
    }

    public final Observable<WidgetCallFullscreenViewModel$Event> observeEvents() {
        PublishSubject<WidgetCallFullscreenViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onCameraPermissionsGranted() {
        StoreMediaEngine.selectDefaultVideoDevice$default(this.mediaEngineStore, null, 1, null);
        PublishSubject<WidgetCallFullscreenViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new WidgetCallFullscreenViewModel$Event$AccessibilityAnnouncement(2131887386));
    }

    @Override // b.a.d.d0, androidx.view.ViewModel
    @MainThread
    public void onCleared() {
        super.onCleared();
        this.videoPlayerIdleDetectorFooter.dispose();
        this.videoPlayerIdleDetectorHeader.dispose();
    }

    @MainThread
    public final void onDeafenPressed() {
        CallModel callModel;
        this.videoPlayerIdleDetectorFooter.onPreventIdle();
        this.videoPlayerIdleDetectorHeader.onPreventIdle();
        WidgetCallFullscreenViewModel$StoreState widgetCallFullscreenViewModel$StoreState = this.mostRecentStoreState;
        if (!(widgetCallFullscreenViewModel$StoreState instanceof WidgetCallFullscreenViewModel$StoreState$Valid)) {
            widgetCallFullscreenViewModel$StoreState = null;
        }
        WidgetCallFullscreenViewModel$StoreState$Valid widgetCallFullscreenViewModel$StoreState$Valid = (WidgetCallFullscreenViewModel$StoreState$Valid) widgetCallFullscreenViewModel$StoreState;
        if (widgetCallFullscreenViewModel$StoreState$Valid != null && (callModel = widgetCallFullscreenViewModel$StoreState$Valid.getCallModel()) != null && callModel.isServerDeafened()) {
            emitServerDeafenedDialogEvent();
            return;
        }
        this.mediaSettingsStore.toggleSelfDeafened();
        WidgetCallFullscreenViewModel$ViewState viewState = getViewState();
        WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid = (WidgetCallFullscreenViewModel$ViewState$Valid) (viewState instanceof WidgetCallFullscreenViewModel$ViewState$Valid ? viewState : null);
        if (widgetCallFullscreenViewModel$ViewState$Valid != null) {
            this.eventSubject.k.onNext(new WidgetCallFullscreenViewModel$Event$AccessibilityAnnouncement(widgetCallFullscreenViewModel$ViewState$Valid.getIsDeafened() ? 2131897172 : 2131897156));
        }
    }

    @MainThread
    public final void onEmptyStateTapped() {
        startTapForwardingJob();
    }

    @MainThread
    public final void onGridParticipantLongPressed(CallParticipant participant) {
        m.checkNotNullParameter(participant, "participant");
        if (participant instanceof CallParticipant$UserOrStreamParticipant) {
            CallParticipant$UserOrStreamParticipant callParticipant$UserOrStreamParticipant = (CallParticipant$UserOrStreamParticipant) participant;
            if (callParticipant$UserOrStreamParticipant.getParticipantData().type == VideoCallParticipantView$ParticipantData$Type.DEFAULT) {
                PublishSubject<WidgetCallFullscreenViewModel$Event> publishSubject = this.eventSubject;
                publishSubject.k.onNext(new WidgetCallFullscreenViewModel$Event$ShowUserSheet(callParticipant$UserOrStreamParticipant.getParticipantData().voiceParticipant.getUser().getId(), this.channelId));
            }
        }
    }

    @MainThread
    public final void onGridParticipantTapped(CallParticipant callParticipant) {
        m.checkNotNullParameter(callParticipant, "callParticipant");
        if (callParticipant instanceof CallParticipant$EmbeddedActivityParticipant) {
            this.eventSubject.k.onNext(WidgetCallFullscreenViewModel$Event$ShowActivitiesDesktopOnlyDialog.INSTANCE);
        }
        String participantFocusKey = getParticipantFocusKey(callParticipant);
        WidgetCallFullscreenViewModel$ParticipantTap widgetCallFullscreenViewModel$ParticipantTap = new WidgetCallFullscreenViewModel$ParticipantTap(participantFocusKey, this.clock.currentTimeMillis());
        WidgetCallFullscreenViewModel$ParticipantTap widgetCallFullscreenViewModel$ParticipantTap2 = this.lastParticipantTap;
        this.lastParticipantTap = widgetCallFullscreenViewModel$ParticipantTap;
        if (widgetCallFullscreenViewModel$ParticipantTap2 == null || (!m.areEqual(widgetCallFullscreenViewModel$ParticipantTap2.getParticipantFocusKey(), participantFocusKey))) {
            startTapForwardingJob();
            return;
        }
        if (!(widgetCallFullscreenViewModel$ParticipantTap.getTimestamp() - widgetCallFullscreenViewModel$ParticipantTap2.getTimestamp() <= 255) || !(callParticipant instanceof CallParticipant$UserOrStreamParticipant)) {
            startTapForwardingJob();
            return;
        }
        if (!m.areEqual(this.focusedVideoParticipantKey, participantFocusKey)) {
            focusVideoParticipant(participantFocusKey);
        } else {
            clearFocusedVideoParticipant();
        }
        cancelTapForwardingJob();
        this.lastParticipantTap = null;
    }

    @MainThread
    public final void onMuteClicked() {
        this.videoPlayerIdleDetectorFooter.onPreventIdle();
        this.videoPlayerIdleDetectorHeader.onPreventIdle();
        WidgetCallFullscreenViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
            viewState = null;
        }
        WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid = (WidgetCallFullscreenViewModel$ViewState$Valid) viewState;
        if (widgetCallFullscreenViewModel$ViewState$Valid != null) {
            CallModel callModel = widgetCallFullscreenViewModel$ViewState$Valid.getCallModel();
            if (callModel.isSuppressed()) {
                emitSuppressedDialogEvent();
                return;
            } else if (callModel.isMuted()) {
                emitServerMutedDialogEvent();
                return;
            }
        }
        StoreMediaSettings$SelfMuteFailure storeMediaSettings$SelfMuteFailure = this.mediaSettingsStore.toggleSelfMuted();
        if (storeMediaSettings$SelfMuteFailure != null) {
            if (storeMediaSettings$SelfMuteFailure.ordinal() != 0) {
                return;
            }
            emitShowNoVadPermissionDialogEvent();
        } else if (widgetCallFullscreenViewModel$ViewState$Valid != null) {
            boolean zIsMeMutedByAnySource = widgetCallFullscreenViewModel$ViewState$Valid.getCallModel().isMeMutedByAnySource();
            this.eventSubject.k.onNext(new WidgetCallFullscreenViewModel$Event$AccessibilityAnnouncement(zIsMeMutedByAnySource ? 2131897173 : 2131897169));
        }
    }

    @MainThread
    public final void onPushToTalkPressed(boolean isPressed) {
        if (isPressed) {
            this.videoPlayerIdleDetectorFooter.endIdleDetection();
            this.videoPlayerIdleDetectorHeader.endIdleDetection();
        } else {
            startIdle();
        }
        this.mediaEngineStore.setPttActive(isPressed);
    }

    @MainThread
    public final void onScreenShareClick() {
        WidgetCallFullscreenViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
            viewState = null;
        }
        WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid = (WidgetCallFullscreenViewModel$ViewState$Valid) viewState;
        if (widgetCallFullscreenViewModel$ViewState$Valid != null) {
            if (widgetCallFullscreenViewModel$ViewState$Valid.getCallModel().isStreaming()) {
                stopScreenShare();
            } else {
                if (!hasVideoPermission()) {
                    emitShowNoScreenSharePermissionDialogEvent();
                    return;
                }
                PublishSubject<WidgetCallFullscreenViewModel$Event> publishSubject = this.eventSubject;
                publishSubject.k.onNext(WidgetCallFullscreenViewModel$Event$RequestStartStream.INSTANCE);
            }
        }
    }

    @MainThread
    public final void onShowParticipantsPressed() {
        this.mediaSettingsStore.updateVoiceParticipantsHidden(false);
    }

    public final void onStreamPerceptualVolumeChanged(float perceptualVolume, boolean fromUser) {
        if (fromUser) {
            this.streamRtcConnectionStore.updateStreamVolume(PerceptualVolumeUtils.INSTANCE.perceptualToAmplitude(perceptualVolume, 300.0f));
            this.audioManagerStore.updateMediaVolume(perceptualVolume / 300.0f);
        }
    }

    @MainThread
    public final void onStreamQualityIndicatorClicked(VideoCallParticipantView$StreamResolution resolution, VideoCallParticipantView$StreamFps fps) {
        m.checkNotNullParameter(resolution, "resolution");
        if (resolution.b() || (fps != null && fps.a())) {
            PublishSubject<WidgetCallFullscreenViewModel$Event> publishSubject = this.eventSubject;
            publishSubject.k.onNext(WidgetCallFullscreenViewModel$Event$NavigateToPremiumSettings.INSTANCE);
        }
    }

    @MainThread
    public final void onStreamQualityIndicatorShown(VideoCallParticipantView$StreamResolution resolution, VideoCallParticipantView$StreamFps fps) {
        m.checkNotNullParameter(resolution, "resolution");
        boolean zB = resolution.b();
        Boolean boolValueOf = fps != null ? Boolean.valueOf(fps.a()) : null;
        if (this.logStreamQualityIndicatorViewed) {
            if (zB || m.areEqual(boolValueOf, Boolean.TRUE)) {
                this.logStreamQualityIndicatorViewed = false;
                this.storeAnalytics.streamQualityIndicatorViewed(zB, boolValueOf);
            }
        }
    }

    @MainThread
    public final void onTextInVoiceTapped() {
        WidgetCallFullscreenViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
            viewState = null;
        }
        WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid = (WidgetCallFullscreenViewModel$ViewState$Valid) viewState;
        if (widgetCallFullscreenViewModel$ViewState$Valid != null) {
            ChannelSelector.selectChannel$default(ChannelSelector.Companion.getInstance(), widgetCallFullscreenViewModel$ViewState$Valid.getCallModel().getChannel(), null, SelectedChannelAnalyticsLocation.TEXT_IN_VOICE, 2, null);
            StoreNavigation.setNavigationPanelAction$default(this.storeNavigation, StoreNavigation$PanelAction.CLOSE, null, 2, null);
        }
    }

    public final void onVisitCommunityButtonClicked(long guildId) {
        this.guildSelectedStore.set(guildId);
        StoreTabsNavigation.selectHomeTab$default(this.tabsNavigationStore, StoreNavigation$PanelAction.CLOSE, false, 2, null);
    }

    public final void requestStopWatchingStreamFromUserInput() {
        StoreApplicationStreaming$ActiveApplicationStream activeStream;
        ModelApplicationStream stream;
        stopWatchingStream();
        WidgetCallFullscreenViewModel$ViewState widgetCallFullscreenViewModel$ViewStateRequireViewState = requireViewState();
        if (!(widgetCallFullscreenViewModel$ViewStateRequireViewState instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
            widgetCallFullscreenViewModel$ViewStateRequireViewState = null;
        }
        WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid = (WidgetCallFullscreenViewModel$ViewState$Valid) widgetCallFullscreenViewModel$ViewStateRequireViewState;
        if (widgetCallFullscreenViewModel$ViewState$Valid == null || (activeStream = widgetCallFullscreenViewModel$ViewState$Valid.getCallModel().getActiveStream()) == null || (stream = activeStream.getStream()) == null) {
            return;
        }
        CallModel callModel = widgetCallFullscreenViewModel$ViewState$Valid.getCallModel();
        String encodedStreamKey = stream.getEncodedStreamKey();
        RtcConnection$Metadata rtcConnectionMetadata = callModel.getRtcConnectionMetadata();
        enqueueStreamFeedbackSheet(encodedStreamKey, rtcConnectionMetadata != null ? rtcConnectionMetadata.mediaSessionId : null, callModel.getStreamFeedbackTriggerRateDenominator());
    }

    public final void selectTextChannelAfterFinish() {
        Guild guild;
        WidgetCallFullscreenViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
            viewState = null;
        }
        WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid = (WidgetCallFullscreenViewModel$ViewState$Valid) viewState;
        if (widgetCallFullscreenViewModel$ViewState$Valid == null || !widgetCallFullscreenViewModel$ViewState$Valid.isTextInVoiceEnabled() || !widgetCallFullscreenViewModel$ViewState$Valid.isTextInVoiceChannelSelected() || (guild = widgetCallFullscreenViewModel$ViewState$Valid.getCallModel().getGuild()) == null) {
            return;
        }
        ChannelSelector.Companion.getInstance().selectPreviousChannel(guild.getId());
    }

    public final void setShowStageCallBottomSheet(boolean z2) {
        this.showStageCallBottomSheet = z2;
    }

    public final void setTargetChannelId(long channelId) {
        Subscription subscription = this.storeObservableSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.channelId = channelId;
        Observable<WidgetCallFullscreenViewModel$StoreState> observableR = observeStoreState().r();
        m.checkNotNullExpressionValue(observableR, "observeStoreState()\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetCallFullscreenViewModel.class, (Context) null, new WidgetCallFullscreenViewModel$setTargetChannelId$1(this), (Function1) null, (Function0) null, (Function0) null, new WidgetCallFullscreenViewModel$setTargetChannelId$2(this), 58, (Object) null);
    }

    @MainThread
    public final void startIdle() {
        WidgetCallFullscreenViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
            viewState = null;
        }
        WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid = (WidgetCallFullscreenViewModel$ViewState$Valid) viewState;
        if (widgetCallFullscreenViewModel$ViewState$Valid == null || widgetCallFullscreenViewModel$ViewState$Valid.isControlFadingDisabled() || widgetCallFullscreenViewModel$ViewState$Valid.getDisplayMode() != WidgetCallFullscreenViewModel$DisplayMode.GRID) {
            return;
        }
        Integer num = this.bottomSheetState;
        if (num != null && num.intValue() == 3) {
            return;
        }
        this.videoPlayerIdleDetectorFooter.beginIdleDetection();
        this.videoPlayerIdleDetectorHeader.beginIdleDetection();
    }

    @MainThread
    public final void startScreenShare(Intent intent) {
        m.checkNotNullParameter(intent, "intent");
        this.videoPlayerIdleDetectorFooter.onPreventIdle();
        this.videoPlayerIdleDetectorHeader.onPreventIdle();
        this.voiceEngineServiceController.startStream(intent);
    }

    @MainThread
    public final void stopIdle() {
        this.videoPlayerIdleDetectorFooter.endIdleDetection();
        this.videoPlayerIdleDetectorHeader.endIdleDetection();
    }

    @MainThread
    public final void stopScreenShare() {
        StoreApplicationStreaming$ActiveApplicationStream activeStream;
        ModelApplicationStream stream;
        this.videoPlayerIdleDetectorFooter.onPreventIdle();
        this.videoPlayerIdleDetectorHeader.onPreventIdle();
        this.voiceEngineServiceController.stopStream();
        WidgetCallFullscreenViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
            viewState = null;
        }
        WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid = (WidgetCallFullscreenViewModel$ViewState$Valid) viewState;
        if (widgetCallFullscreenViewModel$ViewState$Valid == null || (activeStream = widgetCallFullscreenViewModel$ViewState$Valid.getCallModel().getActiveStream()) == null || (stream = activeStream.getStream()) == null) {
            return;
        }
        CallModel callModel = widgetCallFullscreenViewModel$ViewState$Valid.getCallModel();
        String encodedStreamKey = stream.getEncodedStreamKey();
        RtcConnection$Metadata rtcConnectionMetadata = callModel.getRtcConnectionMetadata();
        enqueueStreamFeedbackSheet(encodedStreamKey, rtcConnectionMetadata != null ? rtcConnectionMetadata.mediaSessionId : null, callModel.getStreamFeedbackTriggerRateDenominator());
    }

    @MainThread
    public final void switchCameraInputPressed() {
        this.videoPlayerIdleDetectorFooter.onPreventIdle();
        this.videoPlayerIdleDetectorHeader.onPreventIdle();
        WidgetCallFullscreenViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
            viewState = null;
        }
        WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid = (WidgetCallFullscreenViewModel$ViewState$Valid) viewState;
        if (widgetCallFullscreenViewModel$ViewState$Valid == null || widgetCallFullscreenViewModel$ViewState$Valid.getCameraState() == CameraState.CAMERA_DISABLED) {
            return;
        }
        if (widgetCallFullscreenViewModel$ViewState$Valid.getCameraState() == CameraState.CAMERA_ON) {
            this.mediaEngineStore.cycleVideoInputDevice();
        }
    }

    @MainThread
    public final void targetAndFocusStream(String streamKey) {
        m.checkNotNullParameter(streamKey, "streamKey");
        targetStream(streamKey);
        focusVideoParticipant(ModelApplicationStream.Companion.decodeStreamKey(streamKey).getOwnerId() + "--STREAM");
    }

    @MainThread
    public final void targetStream(String streamKey) {
        m.checkNotNullParameter(streamKey, "streamKey");
        StoreApplicationStreaming.targetStream$default(this.applicationStreamingStore, streamKey, false, 2, null);
    }

    @MainThread
    public final void toggleCameraPressed() {
        this.videoPlayerIdleDetectorFooter.onPreventIdle();
        this.videoPlayerIdleDetectorHeader.onPreventIdle();
        WidgetCallFullscreenViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
            viewState = null;
        }
        WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid = (WidgetCallFullscreenViewModel$ViewState$Valid) viewState;
        if (widgetCallFullscreenViewModel$ViewState$Valid == null || widgetCallFullscreenViewModel$ViewState$Valid.getCameraState() == CameraState.CAMERA_DISABLED) {
            return;
        }
        if (!hasVideoPermission()) {
            emitShowNoVideoPermissionDialogEvent();
            return;
        }
        if (widgetCallFullscreenViewModel$ViewState$Valid.getCameraState() == CameraState.CAMERA_ON) {
            this.mediaEngineStore.selectVideoInputDevice(null);
            this.eventSubject.k.onNext(new WidgetCallFullscreenViewModel$Event$AccessibilityAnnouncement(2131887385));
            return;
        }
        int numUsersConnected = widgetCallFullscreenViewModel$ViewState$Valid.getCallModel().getNumUsersConnected();
        GuildMaxVideoChannelUsers guildMaxVideoChannelMembers = widgetCallFullscreenViewModel$ViewState$Valid.getCallModel().getGuildMaxVideoChannelMembers();
        if (guildMaxVideoChannelMembers instanceof GuildMaxVideoChannelUsers$Limited) {
            GuildMaxVideoChannelUsers$Limited guildMaxVideoChannelUsers$Limited = (GuildMaxVideoChannelUsers$Limited) guildMaxVideoChannelMembers;
            if (numUsersConnected > guildMaxVideoChannelUsers$Limited.getLimit()) {
                this.eventSubject.k.onNext(new WidgetCallFullscreenViewModel$Event$ShowCameraCapacityDialog(guildMaxVideoChannelUsers$Limited.getLimit()));
                return;
            }
        }
        this.eventSubject.k.onNext(WidgetCallFullscreenViewModel$Event$ShowRequestCameraPermissionsDialog.INSTANCE);
    }

    @MainThread
    public final void toggleRequestToSpeak() {
        WidgetCallFullscreenViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
            viewState = null;
        }
        WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid = (WidgetCallFullscreenViewModel$ViewState$Valid) viewState;
        if (widgetCallFullscreenViewModel$ViewState$Valid == null || widgetCallFullscreenViewModel$ViewState$Valid.isUpdatingRequestToSpeak()) {
            return;
        }
        updateViewState2((WidgetCallFullscreenViewModel$ViewState) WidgetCallFullscreenViewModel$ViewState$Valid.m69copyJ3xfKWQ$default(widgetCallFullscreenViewModel$ViewState$Valid, null, null, null, null, false, false, false, false, null, null, null, null, false, null, null, null, false, false, false, 0.0f, 0, false, null, true, false, 0, false, null, null, null, 0, 0, false, false, null, -8388609, 7, null));
        Channel channel = widgetCallFullscreenViewModel$ViewState$Valid.getCallModel().getChannel();
        boolean z2 = !widgetCallFullscreenViewModel$ViewState$Valid.getCallModel().isMyHandRaised();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(!z2 ? RestAPI.Companion.getApiSerializeNulls().setMeSuppressed(channel, true) : RestAPI.requestToSpeak$default(RestAPI.Companion.getApi(), channel, null, 2, null), false, 1, null), this, null, 2, null), WidgetCallFullscreenViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, new WidgetCallFullscreenViewModel$toggleRequestToSpeak$1(this), new WidgetCallFullscreenViewModel$toggleRequestToSpeak$2(z2, channel), 30, (Object) null);
    }

    @MainThread
    public final void tryConnectToVoice() {
        this.selectedVoiceChannelStore.selectVoiceChannel(this.channelId);
    }

    public final void updateOffScreenParticipantsFromScroll(List<VideoCallParticipantView$ParticipantData> visibleVideoParticipants) {
        m.checkNotNullParameter(visibleVideoParticipants, "visibleVideoParticipants");
        this.offScreenSubject.k.onNext(visibleVideoParticipants);
    }

    @Override // b.a.d.d0
    public /* bridge */ /* synthetic */ void updateViewState(WidgetCallFullscreenViewModel$ViewState widgetCallFullscreenViewModel$ViewState) {
        updateViewState2(widgetCallFullscreenViewModel$ViewState);
    }

    /* JADX INFO: renamed from: modifyPendingViewState, reason: avoid collision after fix types in other method */
    public WidgetCallFullscreenViewModel$ViewState modifyPendingViewState2(WidgetCallFullscreenViewModel$ViewState previousViewState, WidgetCallFullscreenViewModel$ViewState pendingViewState) {
        m.checkNotNullParameter(pendingViewState, "pendingViewState");
        if (!(previousViewState instanceof WidgetCallFullscreenViewModel$ViewState$Valid) || !(pendingViewState instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
            return pendingViewState;
        }
        WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid = (WidgetCallFullscreenViewModel$ViewState$Valid) pendingViewState;
        boolean zIsIdleFooter = widgetCallFullscreenViewModel$ViewState$Valid.isIdleFooter();
        List<CallParticipant> visibleVideoParticipants = widgetCallFullscreenViewModel$ViewState$Valid.getVisibleVideoParticipants();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(visibleVideoParticipants, 10));
        for (Object objCopy : visibleVideoParticipants) {
            boolean z2 = (zIsIdleFooter || widgetCallFullscreenViewModel$ViewState$Valid.getVisibleVideoParticipants().size() == 1) ? false : true;
            boolean z3 = this.focusedVideoParticipantKey != null;
            if (objCopy instanceof CallParticipant$UserOrStreamParticipant) {
                CallParticipant$UserOrStreamParticipant callParticipant$UserOrStreamParticipant = (CallParticipant$UserOrStreamParticipant) objCopy;
                if (callParticipant$UserOrStreamParticipant.getParticipantData().showLabel != z2 || callParticipant$UserOrStreamParticipant.getParticipantData().isFocused != z3) {
                    objCopy = callParticipant$UserOrStreamParticipant.copy(VideoCallParticipantView$ParticipantData.a(callParticipant$UserOrStreamParticipant.getParticipantData(), null, false, null, null, null, null, z2, z3, null, 319));
                }
            }
            arrayList.add(objCopy);
        }
        return WidgetCallFullscreenViewModel$ViewState$Valid.m69copyJ3xfKWQ$default(widgetCallFullscreenViewModel$ViewState$Valid, null, null, null, arrayList, false, false, false, false, null, null, null, null, false, null, null, null, false, false, false, 0.0f, 0, false, null, false, false, 0, false, null, null, null, 0, 0, false, false, null, -9, 7, null);
    }

    /* JADX INFO: renamed from: updateViewState, reason: avoid collision after fix types in other method */
    public void updateViewState2(WidgetCallFullscreenViewModel$ViewState viewState) {
        Object next;
        StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser;
        User user;
        CallModel callModel;
        m.checkNotNullParameter(viewState, "viewState");
        WidgetCallFullscreenViewModel$ViewState viewState2 = getViewState();
        if (!(viewState2 instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
            viewState2 = null;
        }
        WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid = (WidgetCallFullscreenViewModel$ViewState$Valid) viewState2;
        String analyticsVideoLayout = widgetCallFullscreenViewModel$ViewState$Valid != null ? widgetCallFullscreenViewModel$ViewState$Valid.getAnalyticsVideoLayout() : null;
        WidgetCallFullscreenViewModel$DisplayMode displayMode = widgetCallFullscreenViewModel$ViewState$Valid != null ? widgetCallFullscreenViewModel$ViewState$Valid.getDisplayMode() : null;
        super.updateViewState(viewState);
        if (!(viewState instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
            this.streamRtcConnectionStore.updateFocusedParticipant(null);
            RtcConnection rtcConnection = StoreStream.Companion.getRtcConnection().getRtcConnection();
            if (rtcConnection != null) {
                rtcConnection.w(null);
                return;
            }
            return;
        }
        WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid2 = (WidgetCallFullscreenViewModel$ViewState$Valid) viewState;
        String analyticsVideoLayout2 = widgetCallFullscreenViewModel$ViewState$Valid2.getAnalyticsVideoLayout();
        if (analyticsVideoLayout2 != null && (!m.areEqual(analyticsVideoLayout2, analyticsVideoLayout))) {
            long myId = widgetCallFullscreenViewModel$ViewState$Valid2.getCallModel().getMyId();
            WidgetCallFullscreenViewModel$ViewState viewState3 = getViewState();
            if (!(viewState3 instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
                viewState3 = null;
            }
            WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid3 = (WidgetCallFullscreenViewModel$ViewState$Valid) viewState3;
            this.analyticsStore.trackVideoLayoutToggled(analyticsVideoLayout2, myId, (widgetCallFullscreenViewModel$ViewState$Valid3 == null || (callModel = widgetCallFullscreenViewModel$ViewState$Valid3.getCallModel()) == null) ? null : callModel.getChannel());
        }
        WidgetCallFullscreenViewModel$DisplayMode displayMode2 = widgetCallFullscreenViewModel$ViewState$Valid2.getDisplayMode();
        if (displayMode2 != displayMode) {
            int iOrdinal = displayMode2.ordinal();
            if (iOrdinal == 0) {
                startIdle();
            } else if (iOrdinal == 2) {
                this.videoPlayerIdleDetectorHeader.endIdleDetection();
                this.videoPlayerIdleDetectorFooter.endIdleDetection();
            }
        }
        String focusedParticipantKey = widgetCallFullscreenViewModel$ViewState$Valid2.getFocusedParticipantKey();
        Iterator<T> it = widgetCallFullscreenViewModel$ViewState$Valid2.getVisibleVideoParticipants().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!m.areEqual(getParticipantFocusKey((CallParticipant) next), focusedParticipantKey));
        CallParticipant callParticipant = (CallParticipant) next;
        if (callParticipant != null ? callParticipant instanceof CallParticipant$UserOrStreamParticipant : true) {
            CallParticipant$UserOrStreamParticipant callParticipant$UserOrStreamParticipant = (CallParticipant$UserOrStreamParticipant) callParticipant;
            VideoCallParticipantView$ParticipantData participantData = callParticipant$UserOrStreamParticipant != null ? callParticipant$UserOrStreamParticipant.getParticipantData() : null;
            Long lValueOf = (participantData == null || (storeVoiceParticipants$VoiceUser = participantData.voiceParticipant) == null || (user = storeVoiceParticipants$VoiceUser.getUser()) == null) ? null : Long.valueOf(user.getId());
            VideoCallParticipantView$ParticipantData$Type videoCallParticipantView$ParticipantData$Type = participantData != null ? participantData.type : null;
            if (videoCallParticipantView$ParticipantData$Type == null) {
                this.streamRtcConnectionStore.updateFocusedParticipant(null);
                RtcConnection rtcConnection2 = StoreStream.Companion.getRtcConnection().getRtcConnection();
                if (rtcConnection2 != null) {
                    rtcConnection2.w(null);
                    return;
                }
                return;
            }
            int iOrdinal2 = videoCallParticipantView$ParticipantData$Type.ordinal();
            if (iOrdinal2 != 0) {
                if (iOrdinal2 != 1) {
                    return;
                }
                this.streamRtcConnectionStore.updateFocusedParticipant(lValueOf);
                RtcConnection rtcConnection3 = StoreStream.Companion.getRtcConnection().getRtcConnection();
                if (rtcConnection3 != null) {
                    rtcConnection3.w(null);
                    return;
                }
                return;
            }
            this.streamRtcConnectionStore.updateFocusedParticipant(null);
            RtcConnection rtcConnection4 = StoreStream.Companion.getRtcConnection().getRtcConnection();
            if (rtcConnection4 != null) {
                rtcConnection4.w(lValueOf);
            }
            if (lValueOf != null) {
                this.mediaSettingsStore.setUserOffScreen(lValueOf.longValue(), false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreenViewModel(long j, StoreChannels storeChannels, StoreNavigation storeNavigation, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreGuildSelected storeGuildSelected, StoreTabsNavigation storeTabsNavigation, StoreUserSettings storeUserSettings, StoreApplicationStreaming storeApplicationStreaming, StoreMediaEngine storeMediaEngine, StoreMediaSettings storeMediaSettings, StorePermissions storePermissions, Clock clock, Scheduler scheduler, VideoPermissionsManager videoPermissionsManager, VoiceEngineServiceController voiceEngineServiceController, StoreStreamRtcConnection storeStreamRtcConnection, StoreAccessibility storeAccessibility, StoreAudioManagerV2 storeAudioManagerV2, StoreMentions storeMentions, StoreAnalytics storeAnalytics, StoreConnectivity storeConnectivity, StoreStageChannels storeStageChannels, StoreAnalytics storeAnalytics2, StoreExperiments storeExperiments, StoreChannelsSelected storeChannelsSelected, StoreApplication storeApplication, StoreApplicationAssets storeApplicationAssets, String str) {
        super(WidgetCallFullscreenViewModel$ViewState$Uninitialized.INSTANCE);
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storeNavigation, "storeNavigation");
        m.checkNotNullParameter(storeVoiceChannelSelected, "selectedVoiceChannelStore");
        m.checkNotNullParameter(storeGuildSelected, "guildSelectedStore");
        m.checkNotNullParameter(storeTabsNavigation, "tabsNavigationStore");
        m.checkNotNullParameter(storeUserSettings, "userSettingsStore");
        m.checkNotNullParameter(storeApplicationStreaming, "applicationStreamingStore");
        m.checkNotNullParameter(storeMediaEngine, "mediaEngineStore");
        m.checkNotNullParameter(storeMediaSettings, "mediaSettingsStore");
        m.checkNotNullParameter(storePermissions, "permissionsStore");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(scheduler, "backgroundThreadScheduler");
        m.checkNotNullParameter(videoPermissionsManager, "videoPermissionsManager");
        m.checkNotNullParameter(voiceEngineServiceController, "voiceEngineServiceController");
        m.checkNotNullParameter(storeStreamRtcConnection, "streamRtcConnectionStore");
        m.checkNotNullParameter(storeAccessibility, "accessibilityStore");
        m.checkNotNullParameter(storeAudioManagerV2, "audioManagerStore");
        m.checkNotNullParameter(storeMentions, "mentionsStore");
        m.checkNotNullParameter(storeAnalytics, "analyticsStore");
        m.checkNotNullParameter(storeConnectivity, "connectivityStore");
        m.checkNotNullParameter(storeStageChannels, "stageStore");
        m.checkNotNullParameter(storeAnalytics2, "storeAnalytics");
        m.checkNotNullParameter(storeExperiments, "experimentsStore");
        m.checkNotNullParameter(storeChannelsSelected, "channelsSelectedStore");
        m.checkNotNullParameter(storeApplication, "applicationStore");
        m.checkNotNullParameter(storeApplicationAssets, "applicationAssetsStore");
        this.channelId = j;
        this.storeChannels = storeChannels;
        this.storeNavigation = storeNavigation;
        this.selectedVoiceChannelStore = storeVoiceChannelSelected;
        this.guildSelectedStore = storeGuildSelected;
        this.tabsNavigationStore = storeTabsNavigation;
        this.userSettingsStore = storeUserSettings;
        this.applicationStreamingStore = storeApplicationStreaming;
        this.mediaEngineStore = storeMediaEngine;
        this.mediaSettingsStore = storeMediaSettings;
        this.permissionsStore = storePermissions;
        this.clock = clock;
        this.backgroundThreadScheduler = scheduler;
        this.videoPermissionsManager = videoPermissionsManager;
        this.voiceEngineServiceController = voiceEngineServiceController;
        this.streamRtcConnectionStore = storeStreamRtcConnection;
        this.accessibilityStore = storeAccessibility;
        this.audioManagerStore = storeAudioManagerV2;
        this.mentionsStore = storeMentions;
        this.analyticsStore = storeAnalytics;
        this.connectivityStore = storeConnectivity;
        this.stageStore = storeStageChannels;
        this.storeAnalytics = storeAnalytics2;
        this.experimentsStore = storeExperiments;
        this.channelsSelectedStore = storeChannelsSelected;
        this.applicationStore = storeApplication;
        this.applicationAssetsStore = storeApplicationAssets;
        this.showStageCallBottomSheet = j != StoreStream.Companion.getVoiceChannelSelected().getSelectedVoiceChannelId();
        this.logStreamQualityIndicatorViewed = true;
        this.eventSubject = PublishSubject.k0();
        PublishSubject<List<VideoCallParticipantView$ParticipantData>> publishSubjectK0 = PublishSubject.k0();
        this.offScreenSubject = publishSubjectK0;
        this.videoPlayerIdleDetectorFooter = new VideoPlayerIdleDetector(0L, null, null, new WidgetCallFullscreenViewModel$videoPlayerIdleDetectorFooter$1(this), 7, null);
        this.videoPlayerIdleDetectorHeader = new VideoPlayerIdleDetector(0L, null, null, new WidgetCallFullscreenViewModel$videoPlayerIdleDetectorHeader$1(this), 7, null);
        this.allVideoParticipants = n.emptyList();
        if (str != null) {
            this.autotargetStreamKey = str;
            storeVoiceChannelSelected.selectVoiceChannel(ModelApplicationStream.Companion.decodeStreamKey(str).getChannelId());
        }
        Observable<List<VideoCallParticipantView$ParticipantData>> observableP = publishSubjectK0.p(1000L, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableP, "offScreenSubject\n       …0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableP, WidgetCallFullscreenViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetCallFullscreenViewModel$1(this), 62, (Object) null);
    }
}

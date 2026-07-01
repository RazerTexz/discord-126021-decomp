package com.discord.widgets.voice.fullscreen;

import a0.a.a.b;
import android.content.Intent;
import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import co.discord.media_engine.DeviceDescription4;
import co.discord.media_engine.DeviceDescription5;
import com.discord.R;
import com.discord.api.application.Application;
import com.discord.api.application.ApplicationAsset;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.api.permission.Permission;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.VideoMetadata;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.rtcconnection.socket.io.Payloads;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreApplication;
import com.discord.stores.StoreApplicationAssets;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreAudioManagerV2;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreChannelsSelected3;
import com.discord.stores.StoreConnectivity;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreMediaEngine;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreMentions;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStreamRtcConnection;
import com.discord.stores.StoreTabsNavigation;
import com.discord.stores.StoreUserSettings;
import com.discord.stores.StoreVideoStreams;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.EmbeddedActivityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities5;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.permissions.VideoPermissionsManager;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableCombineLatestOverloads2;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.video.VideoPlayerIdleDetector;
import com.discord.utilities.voice.PerceptualVolumeUtils;
import com.discord.utilities.voice.VoiceEngineServiceController;
import com.discord.views.calls.VideoCallParticipantView;
import com.discord.widgets.channels.TextInVoiceOnboardingManager;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.model.StageCallModel;
import com.discord.widgets.stage.model.StageCallModel5;
import com.discord.widgets.voice.controls.VoiceControlsOutputSelectorState;
import com.discord.widgets.voice.fullscreen.CallParticipant;
import com.discord.widgets.voice.model.CallModel;
import com.discord.widgets.voice.model.CameraState;
import d0.LazyJVM;
import d0.Tuples;
import d0.d0._Ranges;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.t._Collections;
import d0.u.a;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.p.Schedulers2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.webrtc.RendererCommon;
import rx.Observable;
import rx.Scheduler;
import rx.Subscription;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreenViewModel extends AppViewModel<ViewState> {
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
    private final PublishSubject<Event> eventSubject;
    private final StoreExperiments experimentsStore;
    private String focusedVideoParticipantKey;
    private Subscription forwardVideoGridInteractionSubscription;
    private final StoreGuildSelected guildSelectedStore;
    private ParticipantTap lastParticipantTap;
    private boolean logStreamQualityIndicatorViewed;
    private final StoreMediaEngine mediaEngineStore;
    private final StoreMediaSettings mediaSettingsStore;
    private final StoreMentions mentionsStore;
    private StoreState mostRecentStoreState;
    private final PublishSubject<List<VideoCallParticipantView.ParticipantData>> offScreenSubject;
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

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends VideoCallParticipantView.ParticipantData>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends VideoCallParticipantView.ParticipantData> list) {
            invoke2((List<VideoCallParticipantView.ParticipantData>) list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<VideoCallParticipantView.ParticipantData> list) {
            WidgetCallFullscreenViewModel widgetCallFullscreenViewModel = WidgetCallFullscreenViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(list, "it");
            widgetCallFullscreenViewModel.setOffScreenVideoParticipants(list);
        }
    }

    /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
    public enum DisplayMode {
        GRID,
        STAGE,
        PRIVATE_CALL_PARTICIPANTS
    }

    /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
        public static final /* data */ class AccessibilityAnnouncement extends Event {
            private final int messageResId;

            public AccessibilityAnnouncement(@StringRes int i) {
                super(null);
                this.messageResId = i;
            }

            public static /* synthetic */ AccessibilityAnnouncement copy$default(AccessibilityAnnouncement accessibilityAnnouncement, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = accessibilityAnnouncement.messageResId;
                }
                return accessibilityAnnouncement.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getMessageResId() {
                return this.messageResId;
            }

            public final AccessibilityAnnouncement copy(@StringRes int messageResId) {
                return new AccessibilityAnnouncement(messageResId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof AccessibilityAnnouncement) && this.messageResId == ((AccessibilityAnnouncement) other).messageResId;
                }
                return true;
            }

            public final int getMessageResId() {
                return this.messageResId;
            }

            public int hashCode() {
                return this.messageResId;
            }

            public String toString() {
                return outline.B(outline.U("AccessibilityAnnouncement(messageResId="), this.messageResId, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
        public static final /* data */ class EnqueueCallFeedbackSheet extends Event {
            private final long callDuration;
            private final long channelId;
            private final String mediaSessionId;
            private final String rtcConnectionId;
            private final int triggerRateDenominator;

            public EnqueueCallFeedbackSheet(long j, String str, String str2, long j2, int i) {
                super(null);
                this.channelId = j;
                this.rtcConnectionId = str;
                this.mediaSessionId = str2;
                this.callDuration = j2;
                this.triggerRateDenominator = i;
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getRtcConnectionId() {
                return this.rtcConnectionId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getMediaSessionId() {
                return this.mediaSessionId;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final long getCallDuration() {
                return this.callDuration;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final int getTriggerRateDenominator() {
                return this.triggerRateDenominator;
            }

            public final EnqueueCallFeedbackSheet copy(long channelId, String rtcConnectionId, String mediaSessionId, long callDuration, int triggerRateDenominator) {
                return new EnqueueCallFeedbackSheet(channelId, rtcConnectionId, mediaSessionId, callDuration, triggerRateDenominator);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EnqueueCallFeedbackSheet)) {
                    return false;
                }
                EnqueueCallFeedbackSheet enqueueCallFeedbackSheet = (EnqueueCallFeedbackSheet) other;
                return this.channelId == enqueueCallFeedbackSheet.channelId && Intrinsics3.areEqual(this.rtcConnectionId, enqueueCallFeedbackSheet.rtcConnectionId) && Intrinsics3.areEqual(this.mediaSessionId, enqueueCallFeedbackSheet.mediaSessionId) && this.callDuration == enqueueCallFeedbackSheet.callDuration && this.triggerRateDenominator == enqueueCallFeedbackSheet.triggerRateDenominator;
            }

            public final long getCallDuration() {
                return this.callDuration;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final String getMediaSessionId() {
                return this.mediaSessionId;
            }

            public final String getRtcConnectionId() {
                return this.rtcConnectionId;
            }

            public final int getTriggerRateDenominator() {
                return this.triggerRateDenominator;
            }

            public int hashCode() {
                int iA = b.a(this.channelId) * 31;
                String str = this.rtcConnectionId;
                int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.mediaSessionId;
                return ((b.a(this.callDuration) + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31)) * 31) + this.triggerRateDenominator;
            }

            public String toString() {
                StringBuilder sbU = outline.U("EnqueueCallFeedbackSheet(channelId=");
                sbU.append(this.channelId);
                sbU.append(", rtcConnectionId=");
                sbU.append(this.rtcConnectionId);
                sbU.append(", mediaSessionId=");
                sbU.append(this.mediaSessionId);
                sbU.append(", callDuration=");
                sbU.append(this.callDuration);
                sbU.append(", triggerRateDenominator=");
                return outline.B(sbU, this.triggerRateDenominator, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
        public static final /* data */ class EnqueueStreamFeedbackSheet extends Event {
            private final String mediaSessionId;
            private final String streamKey;
            private final int triggerRateDenominator;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EnqueueStreamFeedbackSheet(String str, String str2, int i) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "streamKey");
                this.streamKey = str;
                this.mediaSessionId = str2;
                this.triggerRateDenominator = i;
            }

            public static /* synthetic */ EnqueueStreamFeedbackSheet copy$default(EnqueueStreamFeedbackSheet enqueueStreamFeedbackSheet, String str, String str2, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = enqueueStreamFeedbackSheet.streamKey;
                }
                if ((i2 & 2) != 0) {
                    str2 = enqueueStreamFeedbackSheet.mediaSessionId;
                }
                if ((i2 & 4) != 0) {
                    i = enqueueStreamFeedbackSheet.triggerRateDenominator;
                }
                return enqueueStreamFeedbackSheet.copy(str, str2, i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getStreamKey() {
                return this.streamKey;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getMediaSessionId() {
                return this.mediaSessionId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final int getTriggerRateDenominator() {
                return this.triggerRateDenominator;
            }

            public final EnqueueStreamFeedbackSheet copy(String streamKey, String mediaSessionId, int triggerRateDenominator) {
                Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
                return new EnqueueStreamFeedbackSheet(streamKey, mediaSessionId, triggerRateDenominator);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EnqueueStreamFeedbackSheet)) {
                    return false;
                }
                EnqueueStreamFeedbackSheet enqueueStreamFeedbackSheet = (EnqueueStreamFeedbackSheet) other;
                return Intrinsics3.areEqual(this.streamKey, enqueueStreamFeedbackSheet.streamKey) && Intrinsics3.areEqual(this.mediaSessionId, enqueueStreamFeedbackSheet.mediaSessionId) && this.triggerRateDenominator == enqueueStreamFeedbackSheet.triggerRateDenominator;
            }

            public final String getMediaSessionId() {
                return this.mediaSessionId;
            }

            public final String getStreamKey() {
                return this.streamKey;
            }

            public final int getTriggerRateDenominator() {
                return this.triggerRateDenominator;
            }

            public int hashCode() {
                String str = this.streamKey;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.mediaSessionId;
                return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.triggerRateDenominator;
            }

            public String toString() {
                StringBuilder sbU = outline.U("EnqueueStreamFeedbackSheet(streamKey=");
                sbU.append(this.streamKey);
                sbU.append(", mediaSessionId=");
                sbU.append(this.mediaSessionId);
                sbU.append(", triggerRateDenominator=");
                return outline.B(sbU, this.triggerRateDenominator, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
        public static final class NavigateToPremiumSettings extends Event {
            public static final NavigateToPremiumSettings INSTANCE = new NavigateToPremiumSettings();

            private NavigateToPremiumSettings() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
        public static final /* data */ class OnIdleStateChanged extends Event {
            private final boolean isIdle;

            public OnIdleStateChanged(boolean z2) {
                super(null);
                this.isIdle = z2;
            }

            public static /* synthetic */ OnIdleStateChanged copy$default(OnIdleStateChanged onIdleStateChanged, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = onIdleStateChanged.isIdle;
                }
                return onIdleStateChanged.copy(z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getIsIdle() {
                return this.isIdle;
            }

            public final OnIdleStateChanged copy(boolean isIdle) {
                return new OnIdleStateChanged(isIdle);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof OnIdleStateChanged) && this.isIdle == ((OnIdleStateChanged) other).isIdle;
                }
                return true;
            }

            public int hashCode() {
                boolean z2 = this.isIdle;
                if (z2) {
                    return 1;
                }
                return z2 ? 1 : 0;
            }

            public final boolean isIdle() {
                return this.isIdle;
            }

            public String toString() {
                return outline.O(outline.U("OnIdleStateChanged(isIdle="), this.isIdle, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
        public static final class RequestStartStream extends Event {
            public static final RequestStartStream INSTANCE = new RequestStartStream();

            private RequestStartStream() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
        public static final class ShowActivitiesDesktopOnlyDialog extends Event {
            public static final ShowActivitiesDesktopOnlyDialog INSTANCE = new ShowActivitiesDesktopOnlyDialog();

            private ShowActivitiesDesktopOnlyDialog() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
        public static final /* data */ class ShowCameraCapacityDialog extends Event {
            private final int guildMaxVideoChannelUsers;

            public ShowCameraCapacityDialog(int i) {
                super(null);
                this.guildMaxVideoChannelUsers = i;
            }

            public static /* synthetic */ ShowCameraCapacityDialog copy$default(ShowCameraCapacityDialog showCameraCapacityDialog, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = showCameraCapacityDialog.guildMaxVideoChannelUsers;
                }
                return showCameraCapacityDialog.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getGuildMaxVideoChannelUsers() {
                return this.guildMaxVideoChannelUsers;
            }

            public final ShowCameraCapacityDialog copy(int guildMaxVideoChannelUsers) {
                return new ShowCameraCapacityDialog(guildMaxVideoChannelUsers);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowCameraCapacityDialog) && this.guildMaxVideoChannelUsers == ((ShowCameraCapacityDialog) other).guildMaxVideoChannelUsers;
                }
                return true;
            }

            public final int getGuildMaxVideoChannelUsers() {
                return this.guildMaxVideoChannelUsers;
            }

            public int hashCode() {
                return this.guildMaxVideoChannelUsers;
            }

            public String toString() {
                return outline.B(outline.U("ShowCameraCapacityDialog(guildMaxVideoChannelUsers="), this.guildMaxVideoChannelUsers, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
        public static final class ShowGuildVideoAtCapacityDialog extends Event {
            public static final ShowGuildVideoAtCapacityDialog INSTANCE = new ShowGuildVideoAtCapacityDialog();

            private ShowGuildVideoAtCapacityDialog() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
        public static final class ShowNoScreenSharePermissionDialog extends Event {
            public static final ShowNoScreenSharePermissionDialog INSTANCE = new ShowNoScreenSharePermissionDialog();

            private ShowNoScreenSharePermissionDialog() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
        public static final class ShowNoVadPermissionDialog extends Event {
            public static final ShowNoVadPermissionDialog INSTANCE = new ShowNoVadPermissionDialog();

            private ShowNoVadPermissionDialog() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
        public static final class ShowNoVideoPermissionDialog extends Event {
            public static final ShowNoVideoPermissionDialog INSTANCE = new ShowNoVideoPermissionDialog();

            private ShowNoVideoPermissionDialog() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
        public static final class ShowRequestCameraPermissionsDialog extends Event {
            public static final ShowRequestCameraPermissionsDialog INSTANCE = new ShowRequestCameraPermissionsDialog();

            private ShowRequestCameraPermissionsDialog() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
        public static final class ShowServerDeafenedDialog extends Event {
            public static final ShowServerDeafenedDialog INSTANCE = new ShowServerDeafenedDialog();

            private ShowServerDeafenedDialog() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
        public static final class ShowServerMutedDialog extends Event {
            public static final ShowServerMutedDialog INSTANCE = new ShowServerMutedDialog();

            private ShowServerMutedDialog() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
        public static final class ShowSuppressedDialog extends Event {
            public static final ShowSuppressedDialog INSTANCE = new ShowSuppressedDialog();

            private ShowSuppressedDialog() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
        public static final class ShowTextInVoiceNux extends Event {
            public static final ShowTextInVoiceNux INSTANCE = new ShowTextInVoiceNux();

            private ShowTextInVoiceNux() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
        public static final /* data */ class ShowUserSheet extends Event {
            private final long channelId;
            private final long userId;

            public ShowUserSheet(long j, long j2) {
                super(null);
                this.userId = j;
                this.channelId = j2;
            }

            public static /* synthetic */ ShowUserSheet copy$default(ShowUserSheet showUserSheet, long j, long j2, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = showUserSheet.userId;
                }
                if ((i & 2) != 0) {
                    j2 = showUserSheet.channelId;
                }
                return showUserSheet.copy(j, j2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getUserId() {
                return this.userId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            public final ShowUserSheet copy(long userId, long channelId) {
                return new ShowUserSheet(userId, channelId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowUserSheet)) {
                    return false;
                }
                ShowUserSheet showUserSheet = (ShowUserSheet) other;
                return this.userId == showUserSheet.userId && this.channelId == showUserSheet.channelId;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final long getUserId() {
                return this.userId;
            }

            public int hashCode() {
                return b.a(this.channelId) + (b.a(this.userId) * 31);
            }

            public String toString() {
                StringBuilder sbU = outline.U("ShowUserSheet(userId=");
                sbU.append(this.userId);
                sbU.append(", channelId=");
                return outline.C(sbU, this.channelId, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
    public enum MenuItem {
        LAUNCH_OVERLAY,
        CHANNEL_SETTINGS,
        VOICE_SETTINGS,
        SWITCH_CAMERA,
        SHOW_PARTICIPANT_LIST,
        TEXT_IN_VOICE
    }

    /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
    public enum OverlayStatus {
        DISABLED,
        ENABLED
    }

    /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
    public static final /* data */ class ParticipantTap {
        private final String participantFocusKey;
        private final long timestamp;

        public ParticipantTap(String str, long j) {
            Intrinsics3.checkNotNullParameter(str, "participantFocusKey");
            this.participantFocusKey = str;
            this.timestamp = j;
        }

        public static /* synthetic */ ParticipantTap copy$default(ParticipantTap participantTap, String str, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = participantTap.participantFocusKey;
            }
            if ((i & 2) != 0) {
                j = participantTap.timestamp;
            }
            return participantTap.copy(str, j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getParticipantFocusKey() {
            return this.participantFocusKey;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        public final ParticipantTap copy(String participantFocusKey, long timestamp) {
            Intrinsics3.checkNotNullParameter(participantFocusKey, "participantFocusKey");
            return new ParticipantTap(participantFocusKey, timestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ParticipantTap)) {
                return false;
            }
            ParticipantTap participantTap = (ParticipantTap) other;
            return Intrinsics3.areEqual(this.participantFocusKey, participantTap.participantFocusKey) && this.timestamp == participantTap.timestamp;
        }

        public final String getParticipantFocusKey() {
            return this.participantFocusKey;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            String str = this.participantFocusKey;
            return b.a(this.timestamp) + ((str != null ? str.hashCode() : 0) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ParticipantTap(participantFocusKey=");
            sbU.append(this.participantFocusKey);
            sbU.append(", timestamp=");
            return outline.C(sbU, this.timestamp, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
    public static abstract class StoreState {

        /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
        public static final /* data */ class Valid extends StoreState {
            private final CallModel callModel;
            private final int channelMentionsCount;
            private final StoreConnectivity.DelayedState connectivityState;
            private final Map<Long, ApplicationAsset> embeddedAppBackgrounds;
            private final boolean isScreenReaderEnabled;
            private final boolean isTextInVoiceChannelSelected;
            private final boolean isTextInVoiceEnabled;
            private final Long myPermissions;
            private final StageRoles myStageRoles;
            private final Boolean noiseCancellation;
            private final StageCallModel stageCallModel;
            private final boolean stopOffscreenVideo;
            private final RtcConnection.Quality streamQuality;
            private final float streamVolume;
            private final int totalMentionsCount;
            private final int unreadsCount;

            public /* synthetic */ Valid(CallModel callModel, StageCallModel stageCallModel, Boolean bool, Long l, float f, RtcConnection.Quality quality, boolean z2, int i, StoreConnectivity.DelayedState delayedState, StageRoles stageRoles, boolean z3, boolean z4, boolean z5, int i2, int i3, Map map, DefaultConstructorMarker defaultConstructorMarker) {
                this(callModel, stageCallModel, bool, l, f, quality, z2, i, delayedState, stageRoles, z3, z4, z5, i2, i3, map);
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
            public final RtcConnection.Quality getStreamQuality() {
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
            public final StoreConnectivity.DelayedState getConnectivityState() {
                return this.connectivityState;
            }

            /* JADX INFO: renamed from: copy-G15NlYY, reason: not valid java name */
            public final Valid m67copyG15NlYY(CallModel callModel, StageCallModel stageCallModel, Boolean noiseCancellation, Long myPermissions, float streamVolume, RtcConnection.Quality streamQuality, boolean isScreenReaderEnabled, int totalMentionsCount, StoreConnectivity.DelayedState connectivityState, StageRoles myStageRoles, boolean stopOffscreenVideo, boolean isTextInVoiceEnabled, boolean isTextInVoiceChannelSelected, int channelMentionsCount, int unreadsCount, Map<Long, ApplicationAsset> embeddedAppBackgrounds) {
                Intrinsics3.checkNotNullParameter(callModel, "callModel");
                Intrinsics3.checkNotNullParameter(connectivityState, "connectivityState");
                Intrinsics3.checkNotNullParameter(embeddedAppBackgrounds, "embeddedAppBackgrounds");
                return new Valid(callModel, stageCallModel, noiseCancellation, myPermissions, streamVolume, streamQuality, isScreenReaderEnabled, totalMentionsCount, connectivityState, myStageRoles, stopOffscreenVideo, isTextInVoiceEnabled, isTextInVoiceChannelSelected, channelMentionsCount, unreadsCount, embeddedAppBackgrounds);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.callModel, valid.callModel) && Intrinsics3.areEqual(this.stageCallModel, valid.stageCallModel) && Intrinsics3.areEqual(this.noiseCancellation, valid.noiseCancellation) && Intrinsics3.areEqual(this.myPermissions, valid.myPermissions) && Float.compare(this.streamVolume, valid.streamVolume) == 0 && Intrinsics3.areEqual(this.streamQuality, valid.streamQuality) && this.isScreenReaderEnabled == valid.isScreenReaderEnabled && this.totalMentionsCount == valid.totalMentionsCount && Intrinsics3.areEqual(this.connectivityState, valid.connectivityState) && Intrinsics3.areEqual(this.myStageRoles, valid.myStageRoles) && this.stopOffscreenVideo == valid.stopOffscreenVideo && this.isTextInVoiceEnabled == valid.isTextInVoiceEnabled && this.isTextInVoiceChannelSelected == valid.isTextInVoiceChannelSelected && this.channelMentionsCount == valid.channelMentionsCount && this.unreadsCount == valid.unreadsCount && Intrinsics3.areEqual(this.embeddedAppBackgrounds, valid.embeddedAppBackgrounds);
            }

            public final CallModel getCallModel() {
                return this.callModel;
            }

            public final int getChannelMentionsCount() {
                return this.channelMentionsCount;
            }

            public final StoreConnectivity.DelayedState getConnectivityState() {
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

            public final RtcConnection.Quality getStreamQuality() {
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
                RtcConnection.Quality quality = this.streamQuality;
                int iHashCode4 = (iFloatToIntBits + (quality != null ? quality.hashCode() : 0)) * 31;
                boolean z2 = this.isScreenReaderEnabled;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = (((iHashCode4 + r0) * 31) + this.totalMentionsCount) * 31;
                StoreConnectivity.DelayedState delayedState = this.connectivityState;
                int iHashCode5 = (i + (delayedState != null ? delayedState.hashCode() : 0)) * 31;
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
                StringBuilder sbU = outline.U("Valid(callModel=");
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
                return outline.M(sbU, this.embeddedAppBackgrounds, ")");
            }

            private Valid(CallModel callModel, StageCallModel stageCallModel, Boolean bool, Long l, float f, RtcConnection.Quality quality, boolean z2, int i, StoreConnectivity.DelayedState delayedState, StageRoles stageRoles, boolean z3, boolean z4, boolean z5, int i2, int i3, Map<Long, ApplicationAsset> map) {
                super(null);
                this.callModel = callModel;
                this.stageCallModel = stageCallModel;
                this.noiseCancellation = bool;
                this.myPermissions = l;
                this.streamVolume = f;
                this.streamQuality = quality;
                this.isScreenReaderEnabled = z2;
                this.totalMentionsCount = i;
                this.connectivityState = delayedState;
                this.myStageRoles = stageRoles;
                this.stopOffscreenVideo = z3;
                this.isTextInVoiceEnabled = z4;
                this.isTextInVoiceChannelSelected = z5;
                this.channelMentionsCount = i2;
                this.unreadsCount = i3;
                this.embeddedAppBackgrounds = map;
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
        public static final /* data */ class Valid extends ViewState {
            private final GuildScheduledEvent activeEvent;
            private final Map<String, CallParticipant.UserOrStreamParticipant> allVideoParticipants;

            /* JADX INFO: renamed from: analyticsVideoLayout$delegate, reason: from kotlin metadata */
            private final Lazy analyticsVideoLayout;
            private final CallModel callModel;
            private final CameraState cameraState;
            private final Long channelPermissions;
            private final DisplayMode displayMode;
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
            private final OverlayStatus overlayStatus;
            private final float perceptualStreamVolume;
            private final CallParticipant.UserOrStreamParticipant pipParticipant;
            private final List<StoreVoiceParticipants.VoiceUser> privateCallUserListItems;
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

            public /* synthetic */ Valid(CallModel callModel, StageCallModel stageCallModel, OverlayStatus overlayStatus, List list, boolean z2, boolean z3, boolean z4, boolean z5, CameraState cameraState, DisplayMode displayMode, VoiceControlsOutputSelectorState voiceControlsOutputSelectorState, String str, boolean z6, CallParticipant.UserOrStreamParticipant userOrStreamParticipant, Boolean bool, List list2, boolean z7, boolean z8, boolean z9, float f, int i, boolean z10, StageRoles stageRoles, boolean z11, boolean z12, int i2, boolean z13, Long l, GuildScheduledEvent guildScheduledEvent, GuildScheduledEvent guildScheduledEvent2, int i3, int i4, boolean z14, boolean z15, Map map, DefaultConstructorMarker defaultConstructorMarker) {
                this(callModel, stageCallModel, overlayStatus, list, z2, z3, z4, z5, cameraState, displayMode, voiceControlsOutputSelectorState, str, z6, userOrStreamParticipant, bool, list2, z7, z8, z9, f, i, z10, stageRoles, z11, z12, i2, z13, l, guildScheduledEvent, guildScheduledEvent2, i3, i4, z14, z15, map);
            }

            private final Set<MenuItem> computeMenuItems(boolean canManageChannel, boolean isConnected, boolean isStageChannel, DeviceDescription4 selectedVideoInputDevice, List<DeviceDescription4> availableVideoInputDevices, boolean isTextInVoiceEnabled) {
                HashSet hashSetHashSetOf = Sets5.hashSetOf(MenuItem.VOICE_SETTINGS);
                if (canManageChannel) {
                    hashSetHashSetOf.add(MenuItem.CHANNEL_SETTINGS);
                }
                if (isConnected && StoreStream.INSTANCE.getUserSettings().getIsMobileOverlayEnabled()) {
                    hashSetHashSetOf.add(MenuItem.LAUNCH_OVERLAY);
                }
                if (selectedVideoInputDevice != null && availableVideoInputDevices.size() > 1) {
                    hashSetHashSetOf.add(MenuItem.SWITCH_CAMERA);
                }
                if (!isStageChannel && isTextInVoiceEnabled) {
                    hashSetHashSetOf.add(MenuItem.TEXT_IN_VOICE);
                }
                if (!isStageChannel) {
                    hashSetHashSetOf.add(MenuItem.SHOW_PARTICIPANT_LIST);
                }
                return hashSetHashSetOf;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: copy-J3xfKWQ$default, reason: not valid java name */
            public static /* synthetic */ Valid m69copyJ3xfKWQ$default(Valid valid, CallModel callModel, StageCallModel stageCallModel, OverlayStatus overlayStatus, List list, boolean z2, boolean z3, boolean z4, boolean z5, CameraState cameraState, DisplayMode displayMode, VoiceControlsOutputSelectorState voiceControlsOutputSelectorState, String str, boolean z6, CallParticipant.UserOrStreamParticipant userOrStreamParticipant, Boolean bool, List list2, boolean z7, boolean z8, boolean z9, float f, int i, boolean z10, StageRoles stageRoles, boolean z11, boolean z12, int i2, boolean z13, Long l, GuildScheduledEvent guildScheduledEvent, GuildScheduledEvent guildScheduledEvent2, int i3, int i4, boolean z14, boolean z15, Map map, int i5, int i6, Object obj) {
                return valid.m71copyJ3xfKWQ((i5 & 1) != 0 ? valid.callModel : callModel, (i5 & 2) != 0 ? valid.stageCallModel : stageCallModel, (i5 & 4) != 0 ? valid.overlayStatus : overlayStatus, (i5 & 8) != 0 ? valid.visibleVideoParticipants : list, (i5 & 16) != 0 ? valid.isIdleFooter : z2, (i5 & 32) != 0 ? valid.isIdleHeader : z3, (i5 & 64) != 0 ? valid.isControlFadingDisabled : z4, (i5 & 128) != 0 ? valid.isSwitchCameraButtonVisible : z5, (i5 & 256) != 0 ? valid.cameraState : cameraState, (i5 & 512) != 0 ? valid.displayMode : displayMode, (i5 & 1024) != 0 ? valid.outputSelectorState : voiceControlsOutputSelectorState, (i5 & 2048) != 0 ? valid.focusedParticipantKey : str, (i5 & 4096) != 0 ? valid.isAnyoneUsingVideo : z6, (i5 & 8192) != 0 ? valid.pipParticipant : userOrStreamParticipant, (i5 & 16384) != 0 ? valid.noiseCancellation : bool, (i5 & 32768) != 0 ? valid.privateCallUserListItems : list2, (i5 & 65536) != 0 ? valid.showParticipantsHiddenView : z7, (i5 & 131072) != 0 ? valid.lockCallScreenControls : z8, (i5 & 262144) != 0 ? valid.startedAsVideo : z9, (i5 & 524288) != 0 ? valid.perceptualStreamVolume : f, (i5 & 1048576) != 0 ? valid.totalMentionsCount : i, (i5 & 2097152) != 0 ? valid.showLowConnectivityBar : z10, (i5 & 4194304) != 0 ? valid.stageRoles : stageRoles, (i5 & 8388608) != 0 ? valid.isUpdatingRequestToSpeak : z11, (i5 & 16777216) != 0 ? valid.isMovingToAudience : z12, (i5 & 33554432) != 0 ? valid.requestingToSpeakCount : i2, (i5 & 67108864) != 0 ? valid.stopOffscreenVideo : z13, (i5 & 134217728) != 0 ? valid.channelPermissions : l, (i5 & 268435456) != 0 ? valid.startableEvent : guildScheduledEvent, (i5 & 536870912) != 0 ? valid.activeEvent : guildScheduledEvent2, (i5 & BasicMeasure.EXACTLY) != 0 ? valid.textInVoiceMentionsCount : i3, (i5 & Integer.MIN_VALUE) != 0 ? valid.textInVoiceUnreadsCount : i4, (i6 & 1) != 0 ? valid.isTextInVoiceEnabled : z14, (i6 & 2) != 0 ? valid.isTextInVoiceChannelSelected : z15, (i6 & 4) != 0 ? valid.allVideoParticipants : map);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CallModel getCallModel() {
                return this.callModel;
            }

            /* JADX INFO: renamed from: component10, reason: from getter */
            public final DisplayMode getDisplayMode() {
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
            public final CallParticipant.UserOrStreamParticipant getPipParticipant() {
                return this.pipParticipant;
            }

            /* JADX INFO: renamed from: component15, reason: from getter */
            public final Boolean getNoiseCancellation() {
                return this.noiseCancellation;
            }

            public final List<StoreVoiceParticipants.VoiceUser> component16() {
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
            public final OverlayStatus getOverlayStatus() {
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

            public final Map<String, CallParticipant.UserOrStreamParticipant> component35() {
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
            public final Valid m71copyJ3xfKWQ(CallModel callModel, StageCallModel stageCallModel, OverlayStatus overlayStatus, List<? extends CallParticipant> visibleVideoParticipants, boolean isIdleFooter, boolean isIdleHeader, boolean isControlFadingDisabled, boolean isSwitchCameraButtonVisible, CameraState cameraState, DisplayMode displayMode, VoiceControlsOutputSelectorState outputSelectorState, String focusedParticipantKey, boolean isAnyoneUsingVideo, CallParticipant.UserOrStreamParticipant pipParticipant, Boolean noiseCancellation, List<StoreVoiceParticipants.VoiceUser> privateCallUserListItems, boolean showParticipantsHiddenView, boolean lockCallScreenControls, boolean startedAsVideo, float perceptualStreamVolume, int totalMentionsCount, boolean showLowConnectivityBar, StageRoles stageRoles, boolean isUpdatingRequestToSpeak, boolean isMovingToAudience, int requestingToSpeakCount, boolean stopOffscreenVideo, Long channelPermissions, GuildScheduledEvent startableEvent, GuildScheduledEvent activeEvent, int textInVoiceMentionsCount, int textInVoiceUnreadsCount, boolean isTextInVoiceEnabled, boolean isTextInVoiceChannelSelected, Map<String, CallParticipant.UserOrStreamParticipant> allVideoParticipants) {
                Intrinsics3.checkNotNullParameter(callModel, "callModel");
                Intrinsics3.checkNotNullParameter(overlayStatus, "overlayStatus");
                Intrinsics3.checkNotNullParameter(visibleVideoParticipants, "visibleVideoParticipants");
                Intrinsics3.checkNotNullParameter(cameraState, "cameraState");
                Intrinsics3.checkNotNullParameter(displayMode, "displayMode");
                Intrinsics3.checkNotNullParameter(outputSelectorState, "outputSelectorState");
                Intrinsics3.checkNotNullParameter(privateCallUserListItems, "privateCallUserListItems");
                Intrinsics3.checkNotNullParameter(allVideoParticipants, "allVideoParticipants");
                return new Valid(callModel, stageCallModel, overlayStatus, visibleVideoParticipants, isIdleFooter, isIdleHeader, isControlFadingDisabled, isSwitchCameraButtonVisible, cameraState, displayMode, outputSelectorState, focusedParticipantKey, isAnyoneUsingVideo, pipParticipant, noiseCancellation, privateCallUserListItems, showParticipantsHiddenView, lockCallScreenControls, startedAsVideo, perceptualStreamVolume, totalMentionsCount, showLowConnectivityBar, stageRoles, isUpdatingRequestToSpeak, isMovingToAudience, requestingToSpeakCount, stopOffscreenVideo, channelPermissions, startableEvent, activeEvent, textInVoiceMentionsCount, textInVoiceUnreadsCount, isTextInVoiceEnabled, isTextInVoiceChannelSelected, allVideoParticipants);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.callModel, valid.callModel) && Intrinsics3.areEqual(this.stageCallModel, valid.stageCallModel) && Intrinsics3.areEqual(this.overlayStatus, valid.overlayStatus) && Intrinsics3.areEqual(this.visibleVideoParticipants, valid.visibleVideoParticipants) && this.isIdleFooter == valid.isIdleFooter && this.isIdleHeader == valid.isIdleHeader && this.isControlFadingDisabled == valid.isControlFadingDisabled && this.isSwitchCameraButtonVisible == valid.isSwitchCameraButtonVisible && Intrinsics3.areEqual(this.cameraState, valid.cameraState) && Intrinsics3.areEqual(this.displayMode, valid.displayMode) && Intrinsics3.areEqual(this.outputSelectorState, valid.outputSelectorState) && Intrinsics3.areEqual(this.focusedParticipantKey, valid.focusedParticipantKey) && this.isAnyoneUsingVideo == valid.isAnyoneUsingVideo && Intrinsics3.areEqual(this.pipParticipant, valid.pipParticipant) && Intrinsics3.areEqual(this.noiseCancellation, valid.noiseCancellation) && Intrinsics3.areEqual(this.privateCallUserListItems, valid.privateCallUserListItems) && this.showParticipantsHiddenView == valid.showParticipantsHiddenView && this.lockCallScreenControls == valid.lockCallScreenControls && this.startedAsVideo == valid.startedAsVideo && Float.compare(this.perceptualStreamVolume, valid.perceptualStreamVolume) == 0 && this.totalMentionsCount == valid.totalMentionsCount && this.showLowConnectivityBar == valid.showLowConnectivityBar && Intrinsics3.areEqual(this.stageRoles, valid.stageRoles) && this.isUpdatingRequestToSpeak == valid.isUpdatingRequestToSpeak && this.isMovingToAudience == valid.isMovingToAudience && this.requestingToSpeakCount == valid.requestingToSpeakCount && this.stopOffscreenVideo == valid.stopOffscreenVideo && Intrinsics3.areEqual(this.channelPermissions, valid.channelPermissions) && Intrinsics3.areEqual(this.startableEvent, valid.startableEvent) && Intrinsics3.areEqual(this.activeEvent, valid.activeEvent) && this.textInVoiceMentionsCount == valid.textInVoiceMentionsCount && this.textInVoiceUnreadsCount == valid.textInVoiceUnreadsCount && this.isTextInVoiceEnabled == valid.isTextInVoiceEnabled && this.isTextInVoiceChannelSelected == valid.isTextInVoiceChannelSelected && Intrinsics3.areEqual(this.allVideoParticipants, valid.allVideoParticipants);
            }

            public final GuildScheduledEvent getActiveEvent() {
                return this.activeEvent;
            }

            public final Map<String, CallParticipant.UserOrStreamParticipant> getAllVideoParticipants() {
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

            public final DisplayMode getDisplayMode() {
                return this.displayMode;
            }

            public final String getFocusedParticipantKey() {
                return this.focusedParticipantKey;
            }

            public final boolean getLockCallScreenControls() {
                return this.lockCallScreenControls;
            }

            public final Set<MenuItem> getMenuItems() {
                return (Set) this.menuItems.getValue();
            }

            public final Boolean getNoiseCancellation() {
                return this.noiseCancellation;
            }

            public final VoiceControlsOutputSelectorState getOutputSelectorState() {
                return this.outputSelectorState;
            }

            public final OverlayStatus getOverlayStatus() {
                return this.overlayStatus;
            }

            public final float getPerceptualStreamVolume() {
                return this.perceptualStreamVolume;
            }

            public final CallParticipant.UserOrStreamParticipant getPipParticipant() {
                return this.pipParticipant;
            }

            public final List<StoreVoiceParticipants.VoiceUser> getPrivateCallUserListItems() {
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
                OverlayStatus overlayStatus = this.overlayStatus;
                int iHashCode3 = (iHashCode2 + (overlayStatus != null ? overlayStatus.hashCode() : 0)) * 31;
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
                DisplayMode displayMode = this.displayMode;
                int iHashCode6 = (iHashCode5 + (displayMode != null ? displayMode.hashCode() : 0)) * 31;
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
                CallParticipant.UserOrStreamParticipant userOrStreamParticipant = this.pipParticipant;
                int iHashCode9 = (i5 + (userOrStreamParticipant != null ? userOrStreamParticipant.hashCode() : 0)) * 31;
                Boolean bool = this.noiseCancellation;
                int iHashCode10 = (iHashCode9 + (bool != null ? bool.hashCode() : 0)) * 31;
                List<StoreVoiceParticipants.VoiceUser> list2 = this.privateCallUserListItems;
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
                Map<String, CallParticipant.UserOrStreamParticipant> map = this.allVideoParticipants;
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
                StringBuilder sbU = outline.U("Valid(callModel=");
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
                return outline.M(sbU, this.allVideoParticipants, ")");
            }

            /* JADX WARN: Multi-variable type inference failed */
            private Valid(CallModel callModel, StageCallModel stageCallModel, OverlayStatus overlayStatus, List<? extends CallParticipant> list, boolean z2, boolean z3, boolean z4, boolean z5, CameraState cameraState, DisplayMode displayMode, VoiceControlsOutputSelectorState voiceControlsOutputSelectorState, String str, boolean z6, CallParticipant.UserOrStreamParticipant userOrStreamParticipant, Boolean bool, List<StoreVoiceParticipants.VoiceUser> list2, boolean z7, boolean z8, boolean z9, float f, int i, boolean z10, StageRoles stageRoles, boolean z11, boolean z12, int i2, boolean z13, Long l, GuildScheduledEvent guildScheduledEvent, GuildScheduledEvent guildScheduledEvent2, int i3, int i4, boolean z14, boolean z15, Map<String, CallParticipant.UserOrStreamParticipant> map) {
                super(null);
                this.callModel = callModel;
                this.stageCallModel = stageCallModel;
                this.overlayStatus = overlayStatus;
                this.visibleVideoParticipants = list;
                this.isIdleFooter = z2;
                this.isIdleHeader = z3;
                this.isControlFadingDisabled = z4;
                this.isSwitchCameraButtonVisible = z5;
                this.cameraState = cameraState;
                this.displayMode = displayMode;
                this.outputSelectorState = voiceControlsOutputSelectorState;
                this.focusedParticipantKey = str;
                this.isAnyoneUsingVideo = z6;
                this.pipParticipant = userOrStreamParticipant;
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
                this.menuItems = LazyJVM.lazy(new WidgetCallFullscreenViewModel3(this));
                this.titleText = LazyJVM.lazy(new WidgetCallFullscreenViewModel4(this));
                boolean z16 = false;
                this.isStreamFocused = str != null && StringsJVM.endsWith$default(str, "STREAM", false, 2, null);
                boolean z17 = (list.isEmpty() ^ true) && !callModel.isStreaming() && displayMode == DisplayMode.GRID;
                this.isVideoCallGridVisible = z17;
                this.isPushToTalk = callModel.getInputMode() == MediaEngineConnection.InputMode.PUSH_TO_TALK;
                this.showFooter = (z17 && z2 && !z8) ? false : true;
                this.showHeader = (z17 && z3 && !z8) ? false : true;
                if (callModel.getActiveStream() != null && !callModel.isStreaming()) {
                    z16 = true;
                }
                this.showStreamVolume = z16;
                this.analyticsVideoLayout = LazyJVM.lazy(new WidgetCallFullscreenViewModel2(this));
                this.isDeafened = callModel.isDeafenedByAnySource();
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;

        static {
            DisplayMode.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[DisplayMode.GRID.ordinal()] = 1;
            iArr[DisplayMode.PRIVATE_CALL_PARTICIPANTS.ordinal()] = 2;
            VideoCallParticipantView.ParticipantData.Type.values();
            int[] iArr2 = new int[2];
            $EnumSwitchMapping$1 = iArr2;
            VideoCallParticipantView.ParticipantData.Type type = VideoCallParticipantView.ParticipantData.Type.DEFAULT;
            iArr2[type.ordinal()] = 1;
            VideoCallParticipantView.ParticipantData.Type type2 = VideoCallParticipantView.ParticipantData.Type.APPLICATION_STREAMING;
            iArr2[type2.ordinal()] = 2;
            DiscordAudioManager.DeviceTypes.values();
            int[] iArr3 = new int[6];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[DiscordAudioManager.DeviceTypes.BLUETOOTH_HEADSET.ordinal()] = 1;
            iArr3[DiscordAudioManager.DeviceTypes.SPEAKERPHONE.ordinal()] = 2;
            VideoCallParticipantView.ParticipantData.Type.values();
            int[] iArr4 = new int[2];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[type2.ordinal()] = 1;
            iArr4[type.ordinal()] = 2;
            VideoCallParticipantView.ParticipantData.Type.values();
            int[] iArr5 = new int[2];
            $EnumSwitchMapping$4 = iArr5;
            iArr5[type2.ordinal()] = 1;
            iArr5[type.ordinal()] = 2;
            StoreApplicationStreaming.ActiveApplicationStream.State.values();
            int[] iArr6 = new int[6];
            $EnumSwitchMapping$5 = iArr6;
            iArr6[StoreApplicationStreaming.ActiveApplicationStream.State.CONNECTING.ordinal()] = 1;
            iArr6[StoreApplicationStreaming.ActiveApplicationStream.State.RECONNECTING.ordinal()] = 2;
            iArr6[StoreApplicationStreaming.ActiveApplicationStream.State.ACTIVE.ordinal()] = 3;
            iArr6[StoreApplicationStreaming.ActiveApplicationStream.State.PAUSED.ordinal()] = 4;
            iArr6[StoreApplicationStreaming.ActiveApplicationStream.State.DENIED_FULL.ordinal()] = 5;
            iArr6[StoreApplicationStreaming.ActiveApplicationStream.State.ENDED.ordinal()] = 6;
            StoreMediaSettings.SelfMuteFailure.values();
            int[] iArr7 = new int[1];
            $EnumSwitchMapping$6 = iArr7;
            iArr7[StoreMediaSettings.SelfMuteFailure.CANNOT_USE_VAD.ordinal()] = 1;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$moveMeToAudience$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ViewState viewStateAccess$getViewState$p = WidgetCallFullscreenViewModel.access$getViewState$p(WidgetCallFullscreenViewModel.this);
            if (!(viewStateAccess$getViewState$p instanceof ViewState.Valid)) {
                viewStateAccess$getViewState$p = null;
            }
            ViewState.Valid valid = (ViewState.Valid) viewStateAccess$getViewState$p;
            if (valid != null) {
                WidgetCallFullscreenViewModel.this.updateViewState((ViewState) ViewState.Valid.m69copyJ3xfKWQ$default(valid, null, null, null, null, false, false, false, false, null, null, null, null, false, null, null, null, false, false, false, 0.0f, 0, false, null, false, false, 0, false, null, null, null, 0, 0, false, false, null, -16777217, 7, null));
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$moveMeToAudience$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$observeStoreState$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
    public static final class AnonymousClass1<T, R> implements Func1<Channel, Observable<? extends StoreState>> {
        public AnonymousClass1() {
        }

        @Override // j0.k.Func1
        public final Observable<? extends StoreState> call(final Channel channel) {
            return CallModel.INSTANCE.get(WidgetCallFullscreenViewModel.this.channelId).Y(new Func1<CallModel, Observable<? extends StoreState>>() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel.observeStoreState.1.1

                /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$observeStoreState$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
                public static final class C03631 extends Lambda implements Function14<StageCallModel, Long, Float, RtcConnection.Quality, Boolean, Integer, StoreConnectivity.DelayedState, StageRoles, Experiment, Boolean, Channel, Map<Long, ? extends Integer>, Integer, Map<Long, ? extends ApplicationAsset>, StoreState> {
                    public final /* synthetic */ CallModel $callModel;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C03631(CallModel callModel) {
                        super(14);
                        this.$callModel = callModel;
                    }

                    @Override // kotlin.jvm.functions.Function14
                    public /* bridge */ /* synthetic */ StoreState invoke(StageCallModel stageCallModel, Long l, Float f, RtcConnection.Quality quality, Boolean bool, Integer num, StoreConnectivity.DelayedState delayedState, StageRoles stageRoles, Experiment experiment, Boolean bool2, Channel channel, Map<Long, ? extends Integer> map, Integer num2, Map<Long, ? extends ApplicationAsset> map2) {
                        return invoke(stageCallModel, l, f, quality, bool.booleanValue(), num.intValue(), delayedState, stageRoles, experiment, bool2.booleanValue(), channel, (Map<Long, Integer>) map, num2.intValue(), (Map<Long, ApplicationAsset>) map2);
                    }

                    public final StoreState invoke(StageCallModel stageCallModel, Long l, Float f, RtcConnection.Quality quality, boolean z2, int i, StoreConnectivity.DelayedState delayedState, StageRoles stageRoles, Experiment experiment, boolean z3, Channel channel, Map<Long, Integer> map, int i2, Map<Long, ApplicationAsset> map2) {
                        Intrinsics3.checkNotNullParameter(delayedState, "connectivityState");
                        Intrinsics3.checkNotNullParameter(map, "mentionsMap");
                        Intrinsics3.checkNotNullParameter(map2, "embeddedAppBackgrounds");
                        CallModel callModel = this.$callModel;
                        if (callModel == null) {
                            return StoreState.Invalid.INSTANCE;
                        }
                        boolean z4 = callModel.getVoiceSettings().getNoiseProcessing() == StoreMediaSettings.NoiseProcessing.Cancellation;
                        CallModel callModel2 = this.$callModel;
                        Boolean boolValueOf = Boolean.valueOf(z4);
                        Intrinsics3.checkNotNullExpressionValue(f, "streamVolume");
                        float fFloatValue = f.floatValue();
                        boolean z5 = experiment != null && experiment.getBucket() == 1;
                        boolean z6 = channel != null && ChannelUtils.J(channel);
                        Integer num = map.get(Long.valueOf(WidgetCallFullscreenViewModel.this.channelId));
                        return new StoreState.Valid(callModel2, stageCallModel, boolValueOf, l, fFloatValue, quality, z2, i, delayedState, stageRoles, z5, z3, z6, num != null ? num.intValue() : 0, i2, map2, null);
                    }
                }

                @Override // j0.k.Func1
                public final Observable<? extends StoreState> call(CallModel callModel) {
                    Observable<StageCallModel> observableObserveStageCallModel = StageCallModel.INSTANCE.observeStageCallModel(WidgetCallFullscreenViewModel.this.channelId);
                    Observable<Long> observableObservePermissionsForChannel = WidgetCallFullscreenViewModel.this.permissionsStore.observePermissionsForChannel(WidgetCallFullscreenViewModel.this.channelId);
                    Observable<Float> observableR = WidgetCallFullscreenViewModel.this.streamRtcConnectionStore.observeStreamVolume().r();
                    Intrinsics3.checkNotNullExpressionValue(observableR, "streamRtcConnectionStore…().distinctUntilChanged()");
                    Observable<RtcConnection.Quality> observableR2 = WidgetCallFullscreenViewModel.this.streamRtcConnectionStore.observeConnectionQuality().r();
                    Intrinsics3.checkNotNullExpressionValue(observableR2, "streamRtcConnectionStore…().distinctUntilChanged()");
                    Observable<Boolean> observableObserveScreenreaderEnabled = WidgetCallFullscreenViewModel.this.accessibilityStore.observeScreenreaderEnabled();
                    Observable<Integer> observableObserveTotalMentions = WidgetCallFullscreenViewModel.this.mentionsStore.observeTotalMentions();
                    Observable<StoreConnectivity.DelayedState> observableObserveState = WidgetCallFullscreenViewModel.this.connectivityStore.observeState();
                    Observable<StageRoles> observableR3 = WidgetCallFullscreenViewModel.this.stageStore.observeMyRoles(WidgetCallFullscreenViewModel.this.channelId).r();
                    Intrinsics3.checkNotNullExpressionValue(observableR3, "stageStore.observeMyRole…d).distinctUntilChanged()");
                    Observable<Experiment> observableObserveUserExperiment = WidgetCallFullscreenViewModel.this.experimentsStore.observeUserExperiment("2021-03_stop_offscreen_video_streams", true);
                    TextInVoiceFeatureFlag instance = TextInVoiceFeatureFlag.INSTANCE.getINSTANCE();
                    Channel channel2 = channel;
                    Observable<Boolean> observableObserveEnabled = instance.observeEnabled(channel2 != null ? Long.valueOf(channel2.getGuildId()) : null);
                    Observable<Channel> observableObserveSelectedChannel = WidgetCallFullscreenViewModel.this.channelsSelectedStore.observeSelectedChannel();
                    StoreStream.Companion companion = StoreStream.INSTANCE;
                    return ObservableCombineLatestOverloads2.combineLatest(observableObserveStageCallModel, observableObservePermissionsForChannel, observableR, observableR2, observableObserveScreenreaderEnabled, observableObserveTotalMentions, observableObserveState, observableR3, observableObserveUserExperiment, observableObserveEnabled, observableObserveSelectedChannel, companion.getMentions().observeMentionCounts(), companion.getReadStates().observeUnreadCountForChannel(WidgetCallFullscreenViewModel.this.channelId, new UtcDateTime(callModel != null ? callModel.getTimeConnectedMs() : 0L)), WidgetCallFullscreenViewModel.this.applicationAssetsStore.observeEmbeddedAppBackgrounds(), new C03631(callModel));
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$setTargetChannelId$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            WidgetCallFullscreenViewModel.this.storeObservableSubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$setTargetChannelId$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            WidgetCallFullscreenViewModel widgetCallFullscreenViewModel = WidgetCallFullscreenViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            widgetCallFullscreenViewModel.handleStoreState(storeState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$startTapForwardingJob$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            WidgetCallFullscreenViewModel.this.forwardVideoGridInteractionSubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$startTapForwardingJob$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            boolean isIdle = WidgetCallFullscreenViewModel.this.videoPlayerIdleDetectorFooter.getIsIdle();
            WidgetCallFullscreenViewModel.this.videoPlayerIdleDetectorFooter.onInteraction(WidgetCallFullscreenViewModel.this.videoPlayerIdleDetectorHeader.getIsIdle());
            WidgetCallFullscreenViewModel.this.videoPlayerIdleDetectorHeader.onInteraction(isIdle);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$toggleRequestToSpeak$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ViewState viewStateAccess$getViewState$p = WidgetCallFullscreenViewModel.access$getViewState$p(WidgetCallFullscreenViewModel.this);
            if (!(viewStateAccess$getViewState$p instanceof ViewState.Valid)) {
                viewStateAccess$getViewState$p = null;
            }
            ViewState.Valid valid = (ViewState.Valid) viewStateAccess$getViewState$p;
            if (valid != null) {
                WidgetCallFullscreenViewModel.this.updateViewState((ViewState) ViewState.Valid.m69copyJ3xfKWQ$default(valid, null, null, null, null, false, false, false, false, null, null, null, null, false, null, null, null, false, false, false, 0.0f, 0, false, null, false, false, 0, false, null, null, null, 0, 0, false, false, null, -8388609, 7, null));
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$toggleRequestToSpeak$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ boolean $isRaisingMyHand;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(boolean z2, Channel channel) {
            super(1);
            this.$isRaisingMyHand = z2;
            this.$channel = channel;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r3) {
            if (this.$isRaisingMyHand) {
                AnalyticsTracker.INSTANCE.requestToSpeakInitiated(this.$channel.getId());
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetCallFullscreenViewModel(long j, StoreChannels storeChannels, StoreNavigation storeNavigation, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreGuildSelected storeGuildSelected, StoreTabsNavigation storeTabsNavigation, StoreUserSettings storeUserSettings, StoreApplicationStreaming storeApplicationStreaming, StoreMediaEngine storeMediaEngine, StoreMediaSettings storeMediaSettings, StorePermissions storePermissions, Clock clock, Scheduler scheduler, VideoPermissionsManager videoPermissionsManager, VoiceEngineServiceController voiceEngineServiceController, StoreStreamRtcConnection storeStreamRtcConnection, StoreAccessibility storeAccessibility, StoreAudioManagerV2 storeAudioManagerV2, StoreMentions storeMentions, StoreAnalytics storeAnalytics, StoreConnectivity storeConnectivity, StoreStageChannels storeStageChannels, StoreAnalytics storeAnalytics2, StoreExperiments storeExperiments, StoreChannelsSelected storeChannelsSelected, StoreApplication storeApplication, StoreApplicationAssets storeApplicationAssets, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Scheduler scheduler2;
        StoreChannels channels = (i & 2) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreNavigation navigation = (i & 4) != 0 ? StoreStream.INSTANCE.getNavigation() : storeNavigation;
        StoreVoiceChannelSelected voiceChannelSelected = (i & 8) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected;
        StoreGuildSelected guildSelected = (i & 16) != 0 ? StoreStream.INSTANCE.getGuildSelected() : storeGuildSelected;
        StoreTabsNavigation tabsNavigation = (i & 32) != 0 ? StoreStream.INSTANCE.getTabsNavigation() : storeTabsNavigation;
        StoreUserSettings userSettings = (i & 64) != 0 ? StoreStream.INSTANCE.getUserSettings() : storeUserSettings;
        StoreApplicationStreaming applicationStreaming = (i & 128) != 0 ? StoreStream.INSTANCE.getApplicationStreaming() : storeApplicationStreaming;
        StoreMediaEngine mediaEngine = (i & 256) != 0 ? StoreStream.INSTANCE.getMediaEngine() : storeMediaEngine;
        StoreMediaSettings mediaSettings = (i & 512) != 0 ? StoreStream.INSTANCE.getMediaSettings() : storeMediaSettings;
        StorePermissions permissions = (i & 1024) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions;
        Clock clock2 = (i & 2048) != 0 ? ClockFactory.get() : clock;
        if ((i & 4096) != 0) {
            Scheduler schedulerA = Schedulers2.a();
            Intrinsics3.checkNotNullExpressionValue(schedulerA, "Schedulers.computation()");
            scheduler2 = schedulerA;
        } else {
            scheduler2 = scheduler;
        }
        this(j, channels, navigation, voiceChannelSelected, guildSelected, tabsNavigation, userSettings, applicationStreaming, mediaEngine, mediaSettings, permissions, clock2, scheduler2, (i & 8192) != 0 ? new VideoPermissionsManager(null, 1, null) : videoPermissionsManager, (i & 16384) != 0 ? VoiceEngineServiceController.INSTANCE.getINSTANCE() : voiceEngineServiceController, (32768 & i) != 0 ? StoreStream.INSTANCE.getStreamRtcConnection() : storeStreamRtcConnection, (65536 & i) != 0 ? StoreStream.INSTANCE.getAccessibility() : storeAccessibility, (131072 & i) != 0 ? StoreStream.INSTANCE.getAudioManagerV2() : storeAudioManagerV2, (262144 & i) != 0 ? StoreStream.INSTANCE.getMentions() : storeMentions, (524288 & i) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics, (1048576 & i) != 0 ? StoreStream.INSTANCE.getConnectivity() : storeConnectivity, (2097152 & i) != 0 ? StoreStream.INSTANCE.getStageChannels() : storeStageChannels, (4194304 & i) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics2, (8388608 & i) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments, (16777216 & i) != 0 ? StoreStream.INSTANCE.getChannelsSelected() : storeChannelsSelected, (33554432 & i) != 0 ? StoreStream.INSTANCE.getApplication() : storeApplication, (i & 67108864) != 0 ? StoreStream.INSTANCE.getApplicationAssets() : storeApplicationAssets, str);
    }

    public static final /* synthetic */ ViewState access$getViewState$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.getViewState();
    }

    private final CallParticipant addStreamQualityMetadata(CallParticipant callParticipant, RtcConnection.Quality streamQuality) {
        boolean z2 = callParticipant instanceof CallParticipant.UserOrStreamParticipant;
        if (z2 || (callParticipant instanceof CallParticipant.EmbeddedActivityParticipant)) {
            return callParticipant;
        }
        if (!z2) {
            throw new NoWhenBranchMatchedException();
        }
        CallParticipant.UserOrStreamParticipant userOrStreamParticipant = (CallParticipant.UserOrStreamParticipant) callParticipant;
        VideoCallParticipantView.ParticipantData participantData = userOrStreamParticipant.getParticipantData();
        StoreVideoStreams.UserStreams streams = participantData.voiceParticipant.getStreams();
        VideoMetadata applicationStreamMetadata = streams != null ? streams.getApplicationStreamMetadata() : null;
        if (applicationStreamMetadata != null) {
            Intrinsics3.checkNotNullParameter(applicationStreamMetadata, "metadata");
            VideoCallParticipantView.StreamResolution aVar = applicationStreamMetadata.type == Payloads.ResolutionType.Source ? VideoCallParticipantView.StreamResolution.b.a : new VideoCallParticipantView.StreamResolution.a(applicationStreamMetadata.maxHeight);
            Integer num = applicationStreamMetadata.maxFrameRate;
            VideoCallParticipantView.StreamFps streamFps = num != null ? new VideoCallParticipantView.StreamFps(num.intValue()) : null;
            participantData = VideoCallParticipantView.ParticipantData.a(participantData, null, false, null, null, null, null, false, false, new VideoCallParticipantView.ParticipantData.a(aVar.b() || (streamFps != null && streamFps.a()), aVar, streamFps, streamQuality == RtcConnection.Quality.BAD), 255);
        }
        return userOrStreamParticipant.copy(participantData);
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
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            this.focusedVideoParticipantKey = null;
            stopWatchingStreamIfEnded();
            updateViewState((ViewState) ViewState.Valid.m69copyJ3xfKWQ$default(valid, null, null, null, computeVisibleVideoParticipants(), false, false, false, false, null, null, null, this.focusedVideoParticipantKey, false, computePipParticipant(valid.getCallModel().getMyId(), valid.getCallModel().getSelectedVideoDevice(), valid.getCallModel().isStreaming(), valid.getCameraState()), null, null, false, false, false, 0.0f, 0, false, null, false, false, 0, false, null, null, null, 0, 0, false, false, null, -10249, 7, null));
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0047  */
    @MainThread
    private final CallParticipant.UserOrStreamParticipant computePipParticipant(long myUserId, DeviceDescription4 selectedVideoInputDevice, boolean isStreaming, CameraState cameraState) {
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
            if (callParticipant instanceof CallParticipant.UserOrStreamParticipant) {
                CallParticipant.UserOrStreamParticipant userOrStreamParticipant = (CallParticipant.UserOrStreamParticipant) callParticipant;
                VoiceState voiceState = userOrStreamParticipant.getParticipantData().voiceParticipant.getVoiceState();
                if (voiceState != null && voiceState.getSelfVideo() && userOrStreamParticipant.getParticipantData().voiceParticipant.isMe()) {
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
        boolean z4 = isOneOnOneMeCall(this.allVideoParticipants) || (str != null && !Intrinsics3.areEqual(str, String.valueOf(myUserId))) || z3;
        if (callParticipant2 == null || !(callParticipant2 instanceof CallParticipant.UserOrStreamParticipant) || !z4) {
            return null;
        }
        CallParticipant.UserOrStreamParticipant userOrStreamParticipant2 = (CallParticipant.UserOrStreamParticipant) callParticipant2;
        return userOrStreamParticipant2.copy(VideoCallParticipantView.ParticipantData.a(userOrStreamParticipant2.getParticipantData(), null, (selectedVideoInputDevice != null ? selectedVideoInputDevice.getFacing() : null) == DeviceDescription5.Front, null, null, null, null, false, false, null, 445));
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
            } while (!Intrinsics3.areEqual(getParticipantFocusKey((CallParticipant) next), str));
            CallParticipant callParticipant = (CallParticipant) next;
            if (callParticipant != null) {
                if (callParticipant instanceof CallParticipant.UserOrStreamParticipant) {
                    CallParticipant.UserOrStreamParticipant userOrStreamParticipant = (CallParticipant.UserOrStreamParticipant) callParticipant;
                    VideoCallParticipantView.ParticipantData participantData = userOrStreamParticipant.getParticipantData();
                    RendererCommon.ScalingType scalingType = participantData.scalingType;
                    RendererCommon.ScalingType scalingType2 = participantData.scalingTypeMismatchOrientation;
                    RendererCommon.ScalingType scalingType3 = RendererCommon.ScalingType.SCALE_ASPECT_FIT;
                    if (scalingType != scalingType3 || scalingType2 != scalingType3) {
                        objCopy = userOrStreamParticipant;
                        objCopy = userOrStreamParticipant.copy(VideoCallParticipantView.ParticipantData.a(userOrStreamParticipant.getParticipantData(), null, false, scalingType3, scalingType3, null, null, false, false, null, 499));
                    }
                } else if (!(callParticipant instanceof CallParticipant.EmbeddedActivityParticipant)) {
                    objCopy = callParticipant;
                    throw new NoWhenBranchMatchedException();
                }
                objCopy = callParticipant;
                return CollectionsJVM.listOf(objCopy);
            }
            this.focusedVideoParticipantKey = null;
            stopWatchingStreamIfEnded();
        }
        if (isOneOnOneMeCall(this.allVideoParticipants)) {
            for (Object obj2 : this.allVideoParticipants) {
                CallParticipant callParticipant2 = (CallParticipant) obj2;
                if ((callParticipant2 instanceof CallParticipant.EmbeddedActivityParticipant) || ((callParticipant2 instanceof CallParticipant.UserOrStreamParticipant) && !((CallParticipant.UserOrStreamParticipant) callParticipant2).getParticipantData().voiceParticipant.isMe())) {
                    obj = obj2;
                    break;
                }
            }
            CallParticipant callParticipant3 = (CallParticipant) obj;
            if (callParticipant3 != null) {
                return CollectionsJVM.listOf(callParticipant3);
            }
        }
        return this.allVideoParticipants;
    }

    private final List<StoreVoiceParticipants.VoiceUser> createPrivateCallParticipantListItems(CallModel callModel) {
        return _Collections.toList(callModel.getParticipants().values());
    }

    private final Comparator<StoreVoiceParticipants.VoiceUser> createUserItemsComparator(final boolean prioritizeSpectators, final String mySpectatingStreamKey) {
        return new Comparator<StoreVoiceParticipants.VoiceUser>() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel.createUserItemsComparator.1
            @Override // java.util.Comparator
            public final int compare(StoreVoiceParticipants.VoiceUser voiceUser, StoreVoiceParticipants.VoiceUser voiceUser2) {
                boolean z2 = false;
                boolean z3 = mySpectatingStreamKey != null;
                ModelApplicationStream applicationStream = voiceUser.getApplicationStream();
                String encodedStreamKey = applicationStream != null ? applicationStream.getEncodedStreamKey() : null;
                ModelApplicationStream applicationStream2 = voiceUser2.getApplicationStream();
                String encodedStreamKey2 = applicationStream2 != null ? applicationStream2.getEncodedStreamKey() : null;
                boolean z4 = encodedStreamKey != null;
                boolean z5 = encodedStreamKey2 != null;
                VoiceState voiceState = voiceUser.getVoiceState();
                boolean z6 = voiceState != null && voiceState.getSelfVideo();
                VoiceState voiceState2 = voiceUser2.getVoiceState();
                boolean z7 = voiceState2 != null && voiceState2.getSelfVideo();
                boolean z8 = z3 && Intrinsics3.areEqual(encodedStreamKey, mySpectatingStreamKey);
                if (z3 && Intrinsics3.areEqual(encodedStreamKey2, mySpectatingStreamKey)) {
                    z2 = true;
                }
                boolean z9 = prioritizeSpectators;
                if (!z9 || !z8) {
                    if (z9 && z2) {
                        return 1;
                    }
                    if (!z9 || !z3 || !Intrinsics3.areEqual(voiceUser.getWatchingStream(), mySpectatingStreamKey) || !(!Intrinsics3.areEqual(voiceUser2.getWatchingStream(), mySpectatingStreamKey))) {
                        if (prioritizeSpectators && z3 && Intrinsics3.areEqual(voiceUser2.getWatchingStream(), mySpectatingStreamKey) && (!Intrinsics3.areEqual(voiceUser.getWatchingStream(), mySpectatingStreamKey))) {
                            return 1;
                        }
                        if (!z4 || z5) {
                            if (!z4 && z5) {
                                return 1;
                            }
                            if (!z6 || z7) {
                                if (z6 || !z7) {
                                    return UserUtils.INSTANCE.compareUserNames(voiceUser.getUser(), voiceUser2.getUser(), voiceUser.getNickname(), voiceUser2.getNickname());
                                }
                                return 1;
                            }
                        }
                    }
                }
                return -1;
            }
        };
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

    private final List<CallParticipant> createVideoGridEntriesForParticipant(StoreVoiceParticipants.VoiceUser participant, long channelId, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, RtcConnection.Quality streamQuality, DeviceDescription4 selectedVideoInputDevice, boolean showLabels) {
        VoiceState voiceState;
        ModelApplicationStream stream;
        ArrayList arrayList = new ArrayList();
        if (!participant.isConnected() && !participant.isRinging()) {
            return Collections2.emptyList();
        }
        String encodedStreamKey = null;
        arrayList.add(new CallParticipant.UserOrStreamParticipant(new VideoCallParticipantView.ParticipantData(participant, participant.isMe() && ((selectedVideoInputDevice != null ? selectedVideoInputDevice.getFacing() : null) == DeviceDescription5.Front), null, null, null, null, showLabels, false, null, 444)));
        if (participant.getApplicationStream() == null || (voiceState = participant.getVoiceState()) == null || !voiceState.getSelfStream()) {
            if (activeApplicationStream != null) {
                ModelApplicationStream stream2 = activeApplicationStream.getStream();
                if (participant.getUser().getId() == stream2.getOwnerId()) {
                    VideoCallParticipantView.ParticipantData.ApplicationStreamState participantStreamState = getParticipantStreamState(activeApplicationStream.getState());
                    RendererCommon.ScalingType scalingType = RendererCommon.ScalingType.SCALE_ASPECT_FIT;
                    VideoCallParticipantView.ParticipantData participantData = new VideoCallParticipantView.ParticipantData(participant, false, scalingType, scalingType, participantStreamState, VideoCallParticipantView.ParticipantData.Type.APPLICATION_STREAMING, showLabels, false, null, 384);
                    if (isStreamFocused(stream2)) {
                        arrayList.add(new CallParticipant.UserOrStreamParticipant(participantData));
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
            VideoCallParticipantView.ParticipantData.ApplicationStreamState participantStreamState2 = Intrinsics3.areEqual(encodedStreamKey, participant.getApplicationStream().getEncodedStreamKey()) ? getParticipantStreamState(activeApplicationStream.getState()) : VideoCallParticipantView.ParticipantData.ApplicationStreamState.INACTIVE;
            RendererCommon.ScalingType scalingType2 = RendererCommon.ScalingType.SCALE_ASPECT_FIT;
            arrayList.add(new CallParticipant.UserOrStreamParticipant(new VideoCallParticipantView.ParticipantData(participant, false, scalingType2, scalingType2, participantStreamState2, VideoCallParticipantView.ParticipantData.Type.APPLICATION_STREAMING, showLabels, false, null, 384)));
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(addStreamQualityMetadata((CallParticipant) it.next(), streamQuality));
        }
        return arrayList2;
    }

    private final void emitServerDeafenedDialogEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.ShowServerDeafenedDialog.INSTANCE);
    }

    private final void emitServerMutedDialogEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.ShowServerMutedDialog.INSTANCE);
    }

    private final void emitShowNoScreenSharePermissionDialogEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.ShowNoScreenSharePermissionDialog.INSTANCE);
    }

    private final void emitShowNoVadPermissionDialogEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.ShowNoVadPermissionDialog.INSTANCE);
    }

    private final void emitShowNoVideoPermissionDialogEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.ShowNoVideoPermissionDialog.INSTANCE);
    }

    private final void emitSuppressedDialogEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.ShowSuppressedDialog.INSTANCE);
    }

    private final void enqueueStreamFeedbackSheet(String streamKey, String mediaSessionId, int triggerRateDenominator) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.EnqueueStreamFeedbackSheet(streamKey, mediaSessionId, triggerRateDenominator));
    }

    private final String getParticipantFocusKey(CallParticipant callParticipant) {
        if (!(callParticipant instanceof CallParticipant.UserOrStreamParticipant)) {
            if (callParticipant instanceof CallParticipant.EmbeddedActivityParticipant) {
                return String.valueOf(((CallParticipant.EmbeddedActivityParticipant) callParticipant).getApplication().getId());
            }
            throw new NoWhenBranchMatchedException();
        }
        CallParticipant.UserOrStreamParticipant userOrStreamParticipant = (CallParticipant.UserOrStreamParticipant) callParticipant;
        long id2 = userOrStreamParticipant.getParticipantData().voiceParticipant.getUser().getId();
        int iOrdinal = userOrStreamParticipant.getParticipantData().type.ordinal();
        if (iOrdinal == 0) {
            return String.valueOf(id2);
        }
        if (iOrdinal != 1) {
            throw new NoWhenBranchMatchedException();
        }
        return id2 + "--STREAM";
    }

    private final VideoCallParticipantView.ParticipantData.ApplicationStreamState getParticipantStreamState(StoreApplicationStreaming.ActiveApplicationStream.State applicationStreamState) {
        int iOrdinal = applicationStreamState.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return VideoCallParticipantView.ParticipantData.ApplicationStreamState.ACTIVE;
            }
            if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    return VideoCallParticipantView.ParticipantData.ApplicationStreamState.ENDED;
                }
                if (iOrdinal == 4) {
                    return VideoCallParticipantView.ParticipantData.ApplicationStreamState.PAUSED;
                }
                if (iOrdinal == 5) {
                    return VideoCallParticipantView.ParticipantData.ApplicationStreamState.INACTIVE;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        return VideoCallParticipantView.ParticipantData.ApplicationStreamState.CONNECTING;
    }

    private final boolean hasVideoPermission() {
        StoreState storeState = this.mostRecentStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid == null) {
            return false;
        }
        VideoPermissionsManager videoPermissionsManager = this.videoPermissionsManager;
        Channel channel = valid.getCallModel().getChannel();
        Guild guild = valid.getCallModel().getGuild();
        return videoPermissionsManager.hasVideoPermission(channel, guild != null ? guild.getAfkChannelId() : null, valid.getMyPermissions());
    }

    private final boolean isOneOnOneMeCall(List<? extends CallParticipant> callParticipants) {
        boolean z2;
        if (callParticipants.size() == 2) {
            if (callParticipants.isEmpty()) {
                z2 = false;
            } else {
                for (CallParticipant callParticipant : callParticipants) {
                    if ((callParticipant instanceof CallParticipant.UserOrStreamParticipant) && ((CallParticipant.UserOrStreamParticipant) callParticipant).getParticipantData().voiceParticipant.isMe()) {
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
        return Intrinsics3.areEqual(this.focusedVideoParticipantKey, stream.getOwnerId() + "--STREAM");
    }

    private final Observable<StoreState> observeStoreState() {
        Observable observableY = this.storeChannels.observeChannel(this.channelId).Y(new AnonymousClass1());
        Intrinsics3.checkNotNullExpressionValue(observableY, "storeChannels.observeCha…}\n        }\n      }\n    }");
        return observableY;
    }

    @MainThread
    private final void onIdleStateChanged(Boolean isIdleFooter, Boolean isIdleHeader) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            boolean z2 = isIdleFooter != null && (Intrinsics3.areEqual(isIdleFooter, Boolean.valueOf(valid.isIdleFooter())) ^ true);
            boolean z3 = isIdleHeader != null && (Intrinsics3.areEqual(isIdleHeader, Boolean.valueOf(valid.isIdleHeader())) ^ true);
            if (z2) {
                if (isIdleFooter != null) {
                    isIdleFooter.booleanValue();
                    updateViewState((ViewState) ViewState.Valid.m69copyJ3xfKWQ$default(valid, null, null, null, null, isIdleFooter.booleanValue(), false, false, false, null, null, null, null, false, null, null, null, false, false, false, 0.0f, 0, false, null, false, false, 0, false, null, null, null, 0, 0, false, false, null, -17, 7, null));
                }
                if (isIdleFooter != null) {
                    isIdleFooter.booleanValue();
                    this.eventSubject.k.onNext(new Event.OnIdleStateChanged(isIdleFooter.booleanValue()));
                }
            }
            if (!z3 || isIdleHeader == null) {
                return;
            }
            isIdleHeader.booleanValue();
            updateViewState((ViewState) ViewState.Valid.m69copyJ3xfKWQ$default(valid, null, null, null, null, false, isIdleHeader.booleanValue(), false, false, null, null, null, null, false, null, null, null, false, false, false, 0.0f, 0, false, null, false, false, 0, false, null, null, null, 0, 0, false, false, null, -33, 7, null));
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
    private final void setOffScreenVideoParticipants(List<VideoCallParticipantView.ParticipantData> visibleVideoParticipants) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid == null || !valid.getStopOffscreenVideo()) {
            return;
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(visibleVideoParticipants, 10));
        Iterator<T> it = visibleVideoParticipants.iterator();
        while (it.hasNext()) {
            arrayList.add(((VideoCallParticipantView.ParticipantData) it.next()).com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_ID java.lang.String);
        }
        HashSet hashSet = _Collections.toHashSet(arrayList);
        for (CallParticipant callParticipant : computeVisibleVideoParticipants()) {
            if (callParticipant instanceof CallParticipant.UserOrStreamParticipant) {
                VideoCallParticipantView.ParticipantData participantData = ((CallParticipant.UserOrStreamParticipant) callParticipant).getParticipantData();
                if (participantData.type == VideoCallParticipantView.ParticipantData.Type.DEFAULT) {
                    this.mediaSettingsStore.setUserOffScreen(participantData.voiceParticipant.getUser().getId(), !hashSet.contains(participantData.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_ID java.lang.String));
                }
            }
        }
    }

    private final boolean shouldShowMoreAudioOutputs(CallModel callModel) {
        List<DiscordAudioManager.AudioDevice> audioDevices = callModel.getAudioManagerState().getAudioDevices();
        if (!(audioDevices instanceof Collection) || !audioDevices.isEmpty()) {
            for (DiscordAudioManager.AudioDevice audioDevice : audioDevices) {
                if (audioDevice.type == DiscordAudioManager.DeviceTypes.BLUETOOTH_HEADSET && audioDevice.isAvailable) {
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
        Intrinsics3.checkNotNullExpressionValue(observableE0, "Observable\n        .time…ackgroundThreadScheduler)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableE0, this, null, 2, null), (Class<?>) WidgetCallFullscreenViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass1()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }

    @MainThread
    private final void stopWatchingStream() {
        StoreApplicationStreaming.ActiveApplicationStream activeStream;
        ModelApplicationStream stream;
        ViewState viewStateRequireViewState = requireViewState();
        if (!(viewStateRequireViewState instanceof ViewState.Valid)) {
            viewStateRequireViewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewStateRequireViewState;
        if (valid == null || (activeStream = valid.getCallModel().getActiveStream()) == null || (stream = activeStream.getStream()) == null) {
            return;
        }
        this.applicationStreamingStore.stopStream(stream.getEncodedStreamKey());
        CallModel callModel = valid.getCallModel();
        if (isStreamFocused(stream)) {
            this.focusedVideoParticipantKey = null;
            updateViewState((ViewState) ViewState.Valid.m69copyJ3xfKWQ$default(valid, null, null, null, computeVisibleVideoParticipants(), false, false, false, false, null, null, null, this.focusedVideoParticipantKey, false, computePipParticipant(callModel.getMyId(), callModel.getSelectedVideoDevice(), callModel.isStreaming(), valid.getCameraState()), null, null, false, false, false, 0.0f, 0, false, null, false, false, 0, false, null, null, null, 0, 0, false, false, null, -10249, 7, null));
        }
    }

    @MainThread
    private final void stopWatchingStreamIfEnded() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            StoreApplicationStreaming.ActiveApplicationStream activeStream = valid.getCallModel().getActiveStream();
            StoreApplicationStreaming.ActiveApplicationStream activeStream2 = valid.getCallModel().getActiveStream();
            if (activeStream2 != null) {
                activeStream2.getStream();
            }
            if ((activeStream != null ? activeStream.getState() : null) == StoreApplicationStreaming.ActiveApplicationStream.State.ENDED) {
                stopWatchingStream();
            }
        }
    }

    public final void disableControlFading() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null && !valid.isControlFadingDisabled()) {
            updateViewState((ViewState) ViewState.Valid.m69copyJ3xfKWQ$default(valid, null, null, null, null, false, false, true, false, null, null, null, null, false, null, null, null, false, false, false, 0.0f, 0, false, null, false, false, 0, false, null, null, null, 0, 0, false, false, null, -65, 7, null));
        }
    }

    @MainThread
    public final void disconnect() {
        this.videoPlayerIdleDetectorFooter.onPreventIdle();
        this.videoPlayerIdleDetectorHeader.onPreventIdle();
        this.selectedVoiceChannelStore.clear();
        if (!this.wasEverConnected || this.wasEverMultiParticipant) {
            ViewState viewState = getViewState();
            if (!(viewState instanceof ViewState.Valid)) {
                viewState = null;
            }
            ViewState.Valid valid = (ViewState.Valid) viewState;
            if (valid != null) {
                CallModel callModel = valid.getCallModel();
                RtcConnection.Metadata rtcConnectionMetadata = callModel.getRtcConnectionMetadata();
                this.eventSubject.k.onNext(new Event.EnqueueCallFeedbackSheet(this.channelId, rtcConnectionMetadata != null ? rtcConnectionMetadata.rtcConnectionId : null, rtcConnectionMetadata != null ? rtcConnectionMetadata.mediaSessionId : null, callModel.getCallDurationMs(this.clock), callModel.getCallFeedbackTriggerRateDenominator()));
            }
        }
    }

    @MainThread
    public final void focusVideoParticipant(String participantKey) {
        Intrinsics3.checkNotNullParameter(participantKey, "participantKey");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            if (!isOneOnOneMeCall(this.allVideoParticipants)) {
                this.focusedVideoParticipantKey = participantKey;
            }
            updateViewState((ViewState) ViewState.Valid.m69copyJ3xfKWQ$default(valid, null, null, null, computeVisibleVideoParticipants(), false, false, false, false, null, null, null, this.focusedVideoParticipantKey, false, computePipParticipant(valid.getCallModel().getMyId(), valid.getCallModel().getSelectedVideoDevice(), valid.getCallModel().isStreaming(), valid.getCameraState()), null, null, false, false, false, 0.0f, 0, false, null, false, false, 0, false, null, null, null, 0, 0, false, false, null, -10249, 7, null));
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
    @MainThread
    public final void handleStoreState(StoreState storeState) {
        boolean z2;
        VoiceState voiceState;
        VoiceState voiceState2;
        CallModel callModel;
        int i;
        int i2;
        int i3;
        List<? extends CallParticipant> listEmptyList;
        StageCallModel stageCallModel;
        List<StageCallModel5> mediaParticipants;
        VoiceControlsOutputSelectorState voiceControlsOutputSelectorState;
        ViewState viewState;
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
        Intrinsics3.checkNotNullParameter(storeState, "storeState");
        if (Intrinsics3.areEqual(storeState, StoreState.Invalid.INSTANCE)) {
            updateViewState((ViewState) ViewState.Invalid.INSTANCE);
        } else if (storeState instanceof StoreState.Valid) {
            StoreState.Valid valid = (StoreState.Valid) storeState;
            boolean zD = ChannelUtils.D(valid.getCallModel().getChannel());
            if (!zD && new TextInVoiceOnboardingManager().shouldShowTextInVoiceOnboarding(valid.getCallModel().getMyId(), Long.valueOf(valid.getCallModel().getChannel().getGuildId()))) {
                this.eventSubject.k.onNext(Event.ShowTextInVoiceNux.INSTANCE);
            }
            if (this.startedAsVideo == null) {
                this.startedAsVideo = Boolean.valueOf(valid.getCallModel().getIsVideoCall());
            }
            StoreState storeState2 = this.mostRecentStoreState;
            if (!(storeState2 instanceof StoreState.Valid)) {
                storeState2 = null;
            }
            StoreState.Valid valid2 = (StoreState.Valid) storeState2;
            boolean zIsChannelSelected = (valid2 == null || (callModel2 = valid2.getCallModel()) == null) ? false : callModel2.isChannelSelected();
            boolean zIsChannelSelected2 = valid.getCallModel().isChannelSelected();
            if (zIsChannelSelected && !zIsChannelSelected2) {
                updateViewState((ViewState) ViewState.Invalid.INSTANCE);
                return;
            }
            OverlayStatus overlayStatus = this.userSettingsStore.getIsMobileOverlayEnabled() ? OverlayStatus.ENABLED : OverlayStatus.DISABLED;
            DeviceDescription4 selectedVideoDevice = valid.getCallModel().getSelectedVideoDevice();
            Collection<StoreVoiceParticipants.VoiceUser> collectionValues = valid.getCallModel().getParticipants().values();
            if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
                Iterator<T> it = collectionValues.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    }
                    StoreVoiceParticipants.VoiceUser voiceUser = (StoreVoiceParticipants.VoiceUser) it.next();
                    if (voiceUser.isConnected() && (((voiceState = voiceUser.getVoiceState()) != null && voiceState.getSelfVideo()) || ((voiceState2 = voiceUser.getVoiceState()) != null && voiceState2.getSelfStream()))) {
                        z2 = true;
                        break;
                    }
                }
            } else {
                z2 = false;
                break;
            }
            StoreState storeState3 = this.mostRecentStoreState;
            if (!(storeState3 instanceof StoreState.Valid)) {
                storeState3 = null;
            }
            StoreState.Valid valid3 = (StoreState.Valid) storeState3;
            int channelMentionsCount = valid3 != null ? valid3.getChannelMentionsCount() : 0;
            StoreState storeState4 = this.mostRecentStoreState;
            if (!(storeState4 instanceof StoreState.Valid)) {
                storeState4 = null;
            }
            StoreState.Valid valid4 = (StoreState.Valid) storeState4;
            int unreadsCount = valid4 != null ? valid4.getUnreadsCount() : 0;
            ViewState viewState2 = getViewState();
            if (!(viewState2 instanceof ViewState.Valid)) {
                viewState2 = null;
            }
            ViewState.Valid valid5 = (ViewState.Valid) viewState2;
            boolean zIsIdleFooter = valid5 != null ? valid5.isIdleFooter() : false;
            ViewState viewState3 = getViewState();
            if (!(viewState3 instanceof ViewState.Valid)) {
                viewState3 = null;
            }
            ViewState.Valid valid6 = (ViewState.Valid) viewState3;
            boolean zIsIdleHeader = valid6 != null ? valid6.isIdleHeader() : false;
            ViewState viewState4 = getViewState();
            if (!(viewState4 instanceof ViewState.Valid)) {
                viewState4 = null;
            }
            ViewState.Valid valid7 = (ViewState.Valid) viewState4;
            boolean zIsControlFadingDisabled = valid7 != null ? valid7.isControlFadingDisabled() : false;
            StoreApplicationStreaming.ActiveApplicationStream activeStream = valid.getCallModel().getActiveStream();
            String encodedStreamKey = (activeStream == null || (stream = activeStream.getStream()) == null) ? null : stream.getEncodedStreamKey();
            CallModel callModel3 = valid.getCallModel();
            if (!callModel3.isConnected() || zD) {
                callModel = callModel3;
                i = unreadsCount;
                i2 = channelMentionsCount;
                i3 = 10;
                if (!valid.getCallModel().isConnected() || (stageCallModel = valid.getStageCallModel()) == null || (mediaParticipants = stageCallModel.getMediaParticipants()) == null) {
                    listEmptyList = Collections2.emptyList();
                } else {
                    ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(mediaParticipants, 10));
                    Iterator<T> it2 = mediaParticipants.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(createVideoGridEntriesForParticipant(((StageCallModel5) it2.next()).getVoiceUser(), valid.getCallModel().getChannel().getId(), valid.getCallModel().getActiveStream(), valid.getStreamQuality(), valid.getCallModel().getSelectedVideoDevice(), !zIsIdleFooter));
                    }
                    listEmptyList = Iterables2.flatten(arrayList);
                    if (listEmptyList == null) {
                        listEmptyList = Collections2.emptyList();
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
                Iterator<Map.Entry<Long, EmbeddedActivity>> it4 = embeddedActivitiesForChannel.entrySet().iterator();
                while (it4.hasNext()) {
                    Map.Entry<Long, EmbeddedActivity> next3 = it4.next();
                    long jLongValue2 = next3.getKey().longValue();
                    EmbeddedActivity value = next3.getValue();
                    Application application = callModel3.getApplications().get(Long.valueOf(jLongValue2));
                    arrayList2.add(application != null ? new CallParticipant.EmbeddedActivityParticipant(value, EmbeddedActivityUtils.getActivityParticipants(value, callModel3.getParticipants()), com.discord.models.commands.Application.INSTANCE.fromApiApplication(application), valid.getEmbeddedAppBackgrounds().get(Long.valueOf(jLongValue2))) : null);
                    it4 = it4;
                    unreadsCount = unreadsCount;
                }
                int i4 = unreadsCount;
                List listFilterNotNull = _Collections.filterNotNull(arrayList2);
                List listSortedWith = _Collections.sortedWith(callModel3.getParticipants().values(), createUserItemsComparator$default(this, false, encodedStreamKey, 1, null));
                ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(listSortedWith, 10));
                Iterator it5 = listSortedWith.iterator();
                while (it5.hasNext()) {
                    arrayList3.add(createVideoGridEntriesForParticipant((StoreVoiceParticipants.VoiceUser) it5.next(), valid.getCallModel().getChannel().getId(), valid.getCallModel().getActiveStream(), valid.getStreamQuality(), valid.getCallModel().getSelectedVideoDevice(), !zIsIdleFooter));
                    callModel3 = callModel3;
                    it5 = it5;
                    channelMentionsCount = channelMentionsCount;
                }
                callModel = callModel3;
                i2 = channelMentionsCount;
                i = i4;
                i3 = 10;
                List listFlatten = Iterables2.flatten(arrayList3);
                ArrayList arrayList4 = new ArrayList();
                for (Object obj : listFlatten) {
                    if (!valid.getCallModel().getVoiceSettings().getVoiceParticipantsHidden() || ((CallParticipant) obj).hasActiveVideo()) {
                        arrayList4.add(obj);
                    }
                }
                listEmptyList = _Collections.plus((Collection) listFilterNotNull, (Iterable) arrayList4);
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
            DisplayMode displayMode = (!ChannelUtils.B(callModel.getChannel()) || z2) ? zD ? DisplayMode.STAGE : DisplayMode.GRID : DisplayMode.PRIVATE_CALL_PARTICIPANTS;
            StoreAudioManagerV2.State audioManagerState = callModel.getAudioManagerState();
            boolean zShouldShowMoreAudioOutputs = shouldShowMoreAudioOutputs(valid.getCallModel());
            DiscordAudioManager.DeviceTypes activeAudioDevice = audioManagerState.getActiveAudioDevice();
            if (zShouldShowMoreAudioOutputs) {
                int iOrdinal = activeAudioDevice.ordinal();
                voiceControlsOutputSelectorState = iOrdinal != 2 ? iOrdinal != 5 ? VoiceControlsOutputSelectorState.SPEAKER_OFF_AND_MORE : VoiceControlsOutputSelectorState.BLUETOOTH_ON_AND_MORE : VoiceControlsOutputSelectorState.SPEAKER_ON_AND_MORE;
            } else {
                voiceControlsOutputSelectorState = activeAudioDevice == DiscordAudioManager.DeviceTypes.SPEAKERPHONE ? VoiceControlsOutputSelectorState.SPEAKER_ON : VoiceControlsOutputSelectorState.SPEAKER_OFF;
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
                        if (!(callParticipant instanceof CallParticipant.UserOrStreamParticipant)) {
                            callParticipant = null;
                        }
                        CallParticipant.UserOrStreamParticipant userOrStreamParticipant = (CallParticipant.UserOrStreamParticipant) callParticipant;
                        if (Intrinsics3.areEqual((userOrStreamParticipant == null || (applicationStream = userOrStreamParticipant.getParticipantData().voiceParticipant.getApplicationStream()) == null) ? null : applicationStream.getEncodedStreamKey(), str2)) {
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
            CallParticipant.UserOrStreamParticipant userOrStreamParticipantComputePipParticipant = computePipParticipant(callModel.getMyId(), callModel.getSelectedVideoDevice(), callModel.isStreaming(), cameraState2);
            CallModel callModel4 = callModel;
            List<StoreVoiceParticipants.VoiceUser> listCreatePrivateCallParticipantListItems = createPrivateCallParticipantListItems(callModel4);
            StoreConnectivity.State state = valid.getConnectivityState().getState();
            boolean z6 = (state == StoreConnectivity.State.OFFLINE || state == StoreConnectivity.State.OFFLINE_AIRPLANE_MODE) && displayMode == DisplayMode.PRIVATE_CALL_PARTICIPANTS;
            if (ChannelUtils.D(callModel4.getChannel())) {
                StoreState storeState5 = this.mostRecentStoreState;
                if (!(storeState5 instanceof StoreState.Valid)) {
                    storeState5 = null;
                }
                StoreState.Valid valid8 = (StoreState.Valid) storeState5;
                if (valid8 != null && (stageRolesM68getMyStageRolestwRsX0 = valid8.m68getMyStageRolestwRsX0()) != null && !StageRoles.m33isSpeakerimpl(stageRolesM68getMyStageRolestwRsX0.m35unboximpl()) && (stageRolesM68getMyStageRolestwRsX1 = valid.m68getMyStageRolestwRsX0()) != null && StageRoles.m33isSpeakerimpl(stageRolesM68getMyStageRolestwRsX1.m35unboximpl()) && !PermissionUtils.can(Permission.USE_VAD, valid.getMyPermissions()) && callModel4.getInputMode() != MediaEngineConnection.InputMode.PUSH_TO_TALK) {
                    emitShowNoVadPermissionDialogEvent();
                }
            }
            this.wasEverMultiParticipant = this.wasEverMultiParticipant || valid.getCallModel().getNumUsersConnected() > 1;
            this.wasEverConnected = this.wasEverConnected || valid.getCallModel().isConnected();
            ArrayList<CallParticipant.UserOrStreamParticipant> arrayList5 = new ArrayList();
            for (Object obj2 : list) {
                if (obj2 instanceof CallParticipant.UserOrStreamParticipant) {
                    arrayList5.add(obj2);
                }
            }
            ArrayList arrayList6 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList5, i3));
            for (CallParticipant.UserOrStreamParticipant userOrStreamParticipant2 : arrayList5) {
                Objects.requireNonNull(userOrStreamParticipant2, "null cannot be cast to non-null type com.discord.widgets.voice.fullscreen.CallParticipant.UserOrStreamParticipant");
                int iOrdinal2 = userOrStreamParticipant2.getParticipantData().type.ordinal();
                if (iOrdinal2 == 0) {
                    str = "USER";
                } else {
                    if (iOrdinal2 != 1) {
                        throw new NoWhenBranchMatchedException();
                    }
                    str = "STREAM";
                }
                arrayList6.add(Tuples.to(str + '-' + userOrStreamParticipant2.getParticipantData().voiceParticipant.getUser().getId(), userOrStreamParticipant2));
            }
            Map map = Maps6.toMap(arrayList6);
            if (i2 < valid.getChannelMentionsCount() || i < valid.getUnreadsCount()) {
                viewState = null;
                VideoPlayerIdleDetector.onInteraction$default(this.videoPlayerIdleDetectorHeader, false, 1, null);
                z3 = false;
            } else {
                z3 = zIsIdleHeader;
                viewState = null;
            }
            StageCallModel stageCallModel2 = valid.getStageCallModel();
            String str3 = this.focusedVideoParticipantKey;
            Boolean noiseCancellation = valid.getNoiseCancellation();
            boolean z7 = valid.getCallModel().getVoiceSettings().getVoiceParticipantsHidden() && !callModel4.isStreaming() && listComputeVisibleVideoParticipants.isEmpty() && displayMode == DisplayMode.GRID;
            boolean zIsScreenReaderEnabled = valid.isScreenReaderEnabled();
            Boolean bool = this.startedAsVideo;
            boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
            float fAmplitudeToPerceptual = PerceptualVolumeUtils.INSTANCE.amplitudeToPerceptual(valid.getStreamVolume(), 300.0f);
            int iCoerceAtLeast = _Ranges.coerceAtLeast(valid.getTotalMentionsCount() - valid.getChannelMentionsCount(), 0);
            StageRoles stageRolesM68getMyStageRolestwRsX2 = valid.m68getMyStageRolestwRsX0();
            ViewState viewState5 = getViewState();
            if (!(viewState5 instanceof ViewState.Valid)) {
                viewState5 = viewState;
            }
            ViewState.Valid valid9 = (ViewState.Valid) viewState5;
            boolean z8 = valid9 != null && valid9.isUpdatingRequestToSpeak();
            ViewState viewState6 = getViewState();
            if (!(viewState6 instanceof ViewState.Valid)) {
                viewState6 = viewState;
            }
            ViewState.Valid valid10 = (ViewState.Valid) viewState6;
            boolean z9 = valid10 != null && valid10.isMovingToAudience();
            StageCallModel stageCallModel3 = valid.getStageCallModel();
            int requestingToSpeakCount = stageCallModel3 != null ? stageCallModel3.getRequestingToSpeakCount() : 0;
            boolean stopOffscreenVideo = valid.getStopOffscreenVideo();
            Long myPermissions = valid.getMyPermissions();
            Iterator it7 = _Collections.sortedWith(valid.getCallModel().getGuildScheduledEvents(), new Comparator() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$handleStoreState$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return a.compareValues(((GuildScheduledEvent) t).getScheduledStartTime(), ((GuildScheduledEvent) t2).getScheduledStartTime());
                }
            }).iterator();
            do {
                if (!it7.hasNext()) {
                    next = viewState;
                    break;
                }
                next = it7.next();
            } while (!GuildScheduledEventUtilities5.getEventTiming((GuildScheduledEvent) next).isStartable());
            GuildScheduledEvent guildScheduledEvent = (GuildScheduledEvent) next;
            Iterator<T> it8 = valid.getCallModel().getGuildScheduledEvents().iterator();
            do {
                if (!it8.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it8.next();
            } while (!(((GuildScheduledEvent) next2).getStatus() == GuildScheduledEventStatus.ACTIVE));
            updateViewState((ViewState) new ViewState.Valid(callModel4, stageCallModel2, overlayStatus, listComputeVisibleVideoParticipants, zIsIdleFooter, z3, zIsControlFadingDisabled, z5, cameraState2, displayMode, voiceControlsOutputSelectorState2, str3, z2, userOrStreamParticipantComputePipParticipant, noiseCancellation, listCreatePrivateCallParticipantListItems, z7, zIsScreenReaderEnabled, zBooleanValue, fAmplitudeToPerceptual, iCoerceAtLeast, z6, stageRolesM68getMyStageRolestwRsX2, z8, z9, requestingToSpeakCount, stopOffscreenVideo, myPermissions, guildScheduledEvent, (GuildScheduledEvent) next2, valid.getChannelMentionsCount(), valid.getUnreadsCount(), valid.isTextInVoiceEnabled(), valid.isTextInVoiceChannelSelected(), map, null));
        }
        this.mostRecentStoreState = storeState;
    }

    @MainThread
    public final void moveMeToAudience() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid == null || valid.isMovingToAudience()) {
            return;
        }
        updateViewState((ViewState) ViewState.Valid.m69copyJ3xfKWQ$default(valid, null, null, null, null, false, false, false, false, null, null, null, null, false, null, null, null, false, false, false, 0.0f, 0, false, null, false, true, 0, false, null, null, null, 0, 0, false, false, null, -16777217, 7, null));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApiSerializeNulls().setMeSuppressed(valid.getCallModel().getChannel(), true), false, 1, null), this, null, 2, null), (Class<?>) WidgetCallFullscreenViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : new AnonymousClass1()), AnonymousClass2.INSTANCE);
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onCameraPermissionsGranted() {
        StoreMediaEngine.selectDefaultVideoDevice$default(this.mediaEngineStore, null, 1, null);
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.AccessibilityAnnouncement(R.string.camera_a11y_turned_on));
    }

    @Override // b.a.d.AppViewModel, androidx.view.ViewModel
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
        StoreState storeState = this.mostRecentStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid != null && (callModel = valid.getCallModel()) != null && callModel.isServerDeafened()) {
            emitServerDeafenedDialogEvent();
            return;
        }
        this.mediaSettingsStore.toggleSelfDeafened();
        ViewState viewState = getViewState();
        ViewState.Valid valid2 = (ViewState.Valid) (viewState instanceof ViewState.Valid ? viewState : null);
        if (valid2 != null) {
            this.eventSubject.k.onNext(new Event.AccessibilityAnnouncement(valid2.getIsDeafened() ? R.string.voice_channel_undeafened : R.string.voice_channel_deafened));
        }
    }

    @MainThread
    public final void onEmptyStateTapped() {
        startTapForwardingJob();
    }

    @MainThread
    public final void onGridParticipantLongPressed(CallParticipant participant) {
        Intrinsics3.checkNotNullParameter(participant, "participant");
        if (participant instanceof CallParticipant.UserOrStreamParticipant) {
            CallParticipant.UserOrStreamParticipant userOrStreamParticipant = (CallParticipant.UserOrStreamParticipant) participant;
            if (userOrStreamParticipant.getParticipantData().type == VideoCallParticipantView.ParticipantData.Type.DEFAULT) {
                PublishSubject<Event> publishSubject = this.eventSubject;
                publishSubject.k.onNext(new Event.ShowUserSheet(userOrStreamParticipant.getParticipantData().voiceParticipant.getUser().getId(), this.channelId));
            }
        }
    }

    @MainThread
    public final void onGridParticipantTapped(CallParticipant callParticipant) {
        Intrinsics3.checkNotNullParameter(callParticipant, "callParticipant");
        if (callParticipant instanceof CallParticipant.EmbeddedActivityParticipant) {
            this.eventSubject.k.onNext(Event.ShowActivitiesDesktopOnlyDialog.INSTANCE);
        }
        String participantFocusKey = getParticipantFocusKey(callParticipant);
        ParticipantTap participantTap = new ParticipantTap(participantFocusKey, this.clock.currentTimeMillis());
        ParticipantTap participantTap2 = this.lastParticipantTap;
        this.lastParticipantTap = participantTap;
        if (participantTap2 == null || (!Intrinsics3.areEqual(participantTap2.getParticipantFocusKey(), participantFocusKey))) {
            startTapForwardingJob();
            return;
        }
        if (!(participantTap.getTimestamp() - participantTap2.getTimestamp() <= 255) || !(callParticipant instanceof CallParticipant.UserOrStreamParticipant)) {
            startTapForwardingJob();
            return;
        }
        if (!Intrinsics3.areEqual(this.focusedVideoParticipantKey, participantFocusKey)) {
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
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            CallModel callModel = valid.getCallModel();
            if (callModel.isSuppressed()) {
                emitSuppressedDialogEvent();
                return;
            } else if (callModel.isMuted()) {
                emitServerMutedDialogEvent();
                return;
            }
        }
        StoreMediaSettings.SelfMuteFailure selfMuteFailure = this.mediaSettingsStore.toggleSelfMuted();
        if (selfMuteFailure != null) {
            if (selfMuteFailure.ordinal() != 0) {
                return;
            }
            emitShowNoVadPermissionDialogEvent();
        } else if (valid != null) {
            boolean zIsMeMutedByAnySource = valid.getCallModel().isMeMutedByAnySource();
            this.eventSubject.k.onNext(new Event.AccessibilityAnnouncement(zIsMeMutedByAnySource ? R.string.voice_channel_unmuted : R.string.voice_channel_muted));
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
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            if (valid.getCallModel().isStreaming()) {
                stopScreenShare();
            } else {
                if (!hasVideoPermission()) {
                    emitShowNoScreenSharePermissionDialogEvent();
                    return;
                }
                PublishSubject<Event> publishSubject = this.eventSubject;
                publishSubject.k.onNext(Event.RequestStartStream.INSTANCE);
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
    public final void onStreamQualityIndicatorClicked(VideoCallParticipantView.StreamResolution resolution, VideoCallParticipantView.StreamFps fps) {
        Intrinsics3.checkNotNullParameter(resolution, "resolution");
        if (resolution.b() || (fps != null && fps.a())) {
            PublishSubject<Event> publishSubject = this.eventSubject;
            publishSubject.k.onNext(Event.NavigateToPremiumSettings.INSTANCE);
        }
    }

    @MainThread
    public final void onStreamQualityIndicatorShown(VideoCallParticipantView.StreamResolution resolution, VideoCallParticipantView.StreamFps fps) {
        Intrinsics3.checkNotNullParameter(resolution, "resolution");
        boolean zB = resolution.b();
        Boolean boolValueOf = fps != null ? Boolean.valueOf(fps.a()) : null;
        if (this.logStreamQualityIndicatorViewed) {
            if (zB || Intrinsics3.areEqual(boolValueOf, Boolean.TRUE)) {
                this.logStreamQualityIndicatorViewed = false;
                this.storeAnalytics.streamQualityIndicatorViewed(zB, boolValueOf);
            }
        }
    }

    @MainThread
    public final void onTextInVoiceTapped() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), valid.getCallModel().getChannel(), null, StoreChannelsSelected3.TEXT_IN_VOICE, 2, null);
            StoreNavigation.setNavigationPanelAction$default(this.storeNavigation, StoreNavigation.PanelAction.CLOSE, null, 2, null);
        }
    }

    public final void onVisitCommunityButtonClicked(long guildId) {
        this.guildSelectedStore.set(guildId);
        StoreTabsNavigation.selectHomeTab$default(this.tabsNavigationStore, StoreNavigation.PanelAction.CLOSE, false, 2, null);
    }

    public final void requestStopWatchingStreamFromUserInput() {
        StoreApplicationStreaming.ActiveApplicationStream activeStream;
        ModelApplicationStream stream;
        stopWatchingStream();
        ViewState viewStateRequireViewState = requireViewState();
        if (!(viewStateRequireViewState instanceof ViewState.Valid)) {
            viewStateRequireViewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewStateRequireViewState;
        if (valid == null || (activeStream = valid.getCallModel().getActiveStream()) == null || (stream = activeStream.getStream()) == null) {
            return;
        }
        CallModel callModel = valid.getCallModel();
        String encodedStreamKey = stream.getEncodedStreamKey();
        RtcConnection.Metadata rtcConnectionMetadata = callModel.getRtcConnectionMetadata();
        enqueueStreamFeedbackSheet(encodedStreamKey, rtcConnectionMetadata != null ? rtcConnectionMetadata.mediaSessionId : null, callModel.getStreamFeedbackTriggerRateDenominator());
    }

    public final void selectTextChannelAfterFinish() {
        Guild guild;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid == null || !valid.isTextInVoiceEnabled() || !valid.isTextInVoiceChannelSelected() || (guild = valid.getCallModel().getGuild()) == null) {
            return;
        }
        ChannelSelector.INSTANCE.getInstance().selectPreviousChannel(guild.getId());
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
        Observable<StoreState> observableR = observeStoreState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeStoreState()\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), (Class<?>) WidgetCallFullscreenViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass1()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }

    @MainThread
    public final void startIdle() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid == null || valid.isControlFadingDisabled() || valid.getDisplayMode() != DisplayMode.GRID) {
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
        Intrinsics3.checkNotNullParameter(intent, "intent");
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
        StoreApplicationStreaming.ActiveApplicationStream activeStream;
        ModelApplicationStream stream;
        this.videoPlayerIdleDetectorFooter.onPreventIdle();
        this.videoPlayerIdleDetectorHeader.onPreventIdle();
        this.voiceEngineServiceController.stopStream();
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid == null || (activeStream = valid.getCallModel().getActiveStream()) == null || (stream = activeStream.getStream()) == null) {
            return;
        }
        CallModel callModel = valid.getCallModel();
        String encodedStreamKey = stream.getEncodedStreamKey();
        RtcConnection.Metadata rtcConnectionMetadata = callModel.getRtcConnectionMetadata();
        enqueueStreamFeedbackSheet(encodedStreamKey, rtcConnectionMetadata != null ? rtcConnectionMetadata.mediaSessionId : null, callModel.getStreamFeedbackTriggerRateDenominator());
    }

    @MainThread
    public final void switchCameraInputPressed() {
        this.videoPlayerIdleDetectorFooter.onPreventIdle();
        this.videoPlayerIdleDetectorHeader.onPreventIdle();
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid == null || valid.getCameraState() == CameraState.CAMERA_DISABLED) {
            return;
        }
        if (valid.getCameraState() == CameraState.CAMERA_ON) {
            this.mediaEngineStore.cycleVideoInputDevice();
        }
    }

    @MainThread
    public final void targetAndFocusStream(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        targetStream(streamKey);
        focusVideoParticipant(ModelApplicationStream.INSTANCE.decodeStreamKey(streamKey).getOwnerId() + "--STREAM");
    }

    @MainThread
    public final void targetStream(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        StoreApplicationStreaming.targetStream$default(this.applicationStreamingStore, streamKey, false, 2, null);
    }

    @MainThread
    public final void toggleCameraPressed() {
        this.videoPlayerIdleDetectorFooter.onPreventIdle();
        this.videoPlayerIdleDetectorHeader.onPreventIdle();
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid == null || valid.getCameraState() == CameraState.CAMERA_DISABLED) {
            return;
        }
        if (!hasVideoPermission()) {
            emitShowNoVideoPermissionDialogEvent();
            return;
        }
        if (valid.getCameraState() == CameraState.CAMERA_ON) {
            this.mediaEngineStore.selectVideoInputDevice(null);
            this.eventSubject.k.onNext(new Event.AccessibilityAnnouncement(R.string.camera_a11y_turned_off));
            return;
        }
        int numUsersConnected = valid.getCallModel().getNumUsersConnected();
        GuildMaxVideoChannelUsers guildMaxVideoChannelMembers = valid.getCallModel().getGuildMaxVideoChannelMembers();
        if (guildMaxVideoChannelMembers instanceof GuildMaxVideoChannelUsers.Limited) {
            GuildMaxVideoChannelUsers.Limited limited = (GuildMaxVideoChannelUsers.Limited) guildMaxVideoChannelMembers;
            if (numUsersConnected > limited.getLimit()) {
                this.eventSubject.k.onNext(new Event.ShowCameraCapacityDialog(limited.getLimit()));
                return;
            }
        }
        this.eventSubject.k.onNext(Event.ShowRequestCameraPermissionsDialog.INSTANCE);
    }

    @MainThread
    public final void toggleRequestToSpeak() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid == null || valid.isUpdatingRequestToSpeak()) {
            return;
        }
        updateViewState((ViewState) ViewState.Valid.m69copyJ3xfKWQ$default(valid, null, null, null, null, false, false, false, false, null, null, null, null, false, null, null, null, false, false, false, 0.0f, 0, false, null, true, false, 0, false, null, null, null, 0, 0, false, false, null, -8388609, 7, null));
        Channel channel = valid.getCallModel().getChannel();
        boolean z2 = !valid.getCallModel().isMyHandRaised();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(!z2 ? RestAPI.INSTANCE.getApiSerializeNulls().setMeSuppressed(channel, true) : RestAPI.requestToSpeak$default(RestAPI.INSTANCE.getApi(), channel, null, 2, null), false, 1, null), this, null, 2, null), (Class<?>) WidgetCallFullscreenViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : new AnonymousClass1()), new AnonymousClass2(z2, channel));
    }

    @MainThread
    public final void tryConnectToVoice() {
        this.selectedVoiceChannelStore.selectVoiceChannel(this.channelId);
    }

    public final void updateOffScreenParticipantsFromScroll(List<VideoCallParticipantView.ParticipantData> visibleVideoParticipants) {
        Intrinsics3.checkNotNullParameter(visibleVideoParticipants, "visibleVideoParticipants");
        this.offScreenSubject.k.onNext(visibleVideoParticipants);
    }

    @Override // b.a.d.AppViewModel
    public ViewState modifyPendingViewState(ViewState previousViewState, ViewState pendingViewState) {
        Intrinsics3.checkNotNullParameter(pendingViewState, "pendingViewState");
        if (!(previousViewState instanceof ViewState.Valid) || !(pendingViewState instanceof ViewState.Valid)) {
            return pendingViewState;
        }
        ViewState.Valid valid = (ViewState.Valid) pendingViewState;
        boolean zIsIdleFooter = valid.isIdleFooter();
        List<CallParticipant> visibleVideoParticipants = valid.getVisibleVideoParticipants();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(visibleVideoParticipants, 10));
        for (Object objCopy : visibleVideoParticipants) {
            boolean z2 = (zIsIdleFooter || valid.getVisibleVideoParticipants().size() == 1) ? false : true;
            boolean z3 = this.focusedVideoParticipantKey != null;
            if (objCopy instanceof CallParticipant.UserOrStreamParticipant) {
                CallParticipant.UserOrStreamParticipant userOrStreamParticipant = (CallParticipant.UserOrStreamParticipant) objCopy;
                if (userOrStreamParticipant.getParticipantData().showLabel != z2 || userOrStreamParticipant.getParticipantData().isFocused != z3) {
                    objCopy = userOrStreamParticipant.copy(VideoCallParticipantView.ParticipantData.a(userOrStreamParticipant.getParticipantData(), null, false, null, null, null, null, z2, z3, null, 319));
                }
            }
            arrayList.add(objCopy);
        }
        return ViewState.Valid.m69copyJ3xfKWQ$default(valid, null, null, null, arrayList, false, false, false, false, null, null, null, null, false, null, null, null, false, false, false, 0.0f, 0, false, null, false, false, 0, false, null, null, null, 0, 0, false, false, null, -9, 7, null);
    }

    @Override // b.a.d.AppViewModel
    public void updateViewState(ViewState viewState) {
        Object next;
        StoreVoiceParticipants.VoiceUser voiceUser;
        User user;
        CallModel callModel;
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        ViewState viewState2 = getViewState();
        if (!(viewState2 instanceof ViewState.Valid)) {
            viewState2 = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState2;
        String analyticsVideoLayout = valid != null ? valid.getAnalyticsVideoLayout() : null;
        DisplayMode displayMode = valid != null ? valid.getDisplayMode() : null;
        super.updateViewState(viewState);
        if (!(viewState instanceof ViewState.Valid)) {
            this.streamRtcConnectionStore.updateFocusedParticipant(null);
            RtcConnection rtcConnection = StoreStream.INSTANCE.getRtcConnection().getRtcConnection();
            if (rtcConnection != null) {
                rtcConnection.w(null);
                return;
            }
            return;
        }
        ViewState.Valid valid2 = (ViewState.Valid) viewState;
        String analyticsVideoLayout2 = valid2.getAnalyticsVideoLayout();
        if (analyticsVideoLayout2 != null && (!Intrinsics3.areEqual(analyticsVideoLayout2, analyticsVideoLayout))) {
            long myId = valid2.getCallModel().getMyId();
            ViewState viewState3 = getViewState();
            if (!(viewState3 instanceof ViewState.Valid)) {
                viewState3 = null;
            }
            ViewState.Valid valid3 = (ViewState.Valid) viewState3;
            this.analyticsStore.trackVideoLayoutToggled(analyticsVideoLayout2, myId, (valid3 == null || (callModel = valid3.getCallModel()) == null) ? null : callModel.getChannel());
        }
        DisplayMode displayMode2 = valid2.getDisplayMode();
        if (displayMode2 != displayMode) {
            int iOrdinal = displayMode2.ordinal();
            if (iOrdinal == 0) {
                startIdle();
            } else if (iOrdinal == 2) {
                this.videoPlayerIdleDetectorHeader.endIdleDetection();
                this.videoPlayerIdleDetectorFooter.endIdleDetection();
            }
        }
        String focusedParticipantKey = valid2.getFocusedParticipantKey();
        Iterator<T> it = valid2.getVisibleVideoParticipants().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics3.areEqual(getParticipantFocusKey((CallParticipant) next), focusedParticipantKey));
        CallParticipant callParticipant = (CallParticipant) next;
        if (callParticipant != null ? callParticipant instanceof CallParticipant.UserOrStreamParticipant : true) {
            CallParticipant.UserOrStreamParticipant userOrStreamParticipant = (CallParticipant.UserOrStreamParticipant) callParticipant;
            VideoCallParticipantView.ParticipantData participantData = userOrStreamParticipant != null ? userOrStreamParticipant.getParticipantData() : null;
            Long lValueOf = (participantData == null || (voiceUser = participantData.voiceParticipant) == null || (user = voiceUser.getUser()) == null) ? null : Long.valueOf(user.getId());
            VideoCallParticipantView.ParticipantData.Type type = participantData != null ? participantData.type : null;
            if (type == null) {
                this.streamRtcConnectionStore.updateFocusedParticipant(null);
                RtcConnection rtcConnection2 = StoreStream.INSTANCE.getRtcConnection().getRtcConnection();
                if (rtcConnection2 != null) {
                    rtcConnection2.w(null);
                    return;
                }
                return;
            }
            int iOrdinal2 = type.ordinal();
            if (iOrdinal2 != 0) {
                if (iOrdinal2 != 1) {
                    return;
                }
                this.streamRtcConnectionStore.updateFocusedParticipant(lValueOf);
                RtcConnection rtcConnection3 = StoreStream.INSTANCE.getRtcConnection().getRtcConnection();
                if (rtcConnection3 != null) {
                    rtcConnection3.w(null);
                    return;
                }
                return;
            }
            this.streamRtcConnectionStore.updateFocusedParticipant(null);
            RtcConnection rtcConnection4 = StoreStream.INSTANCE.getRtcConnection().getRtcConnection();
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
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeNavigation, "storeNavigation");
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "selectedVoiceChannelStore");
        Intrinsics3.checkNotNullParameter(storeGuildSelected, "guildSelectedStore");
        Intrinsics3.checkNotNullParameter(storeTabsNavigation, "tabsNavigationStore");
        Intrinsics3.checkNotNullParameter(storeUserSettings, "userSettingsStore");
        Intrinsics3.checkNotNullParameter(storeApplicationStreaming, "applicationStreamingStore");
        Intrinsics3.checkNotNullParameter(storeMediaEngine, "mediaEngineStore");
        Intrinsics3.checkNotNullParameter(storeMediaSettings, "mediaSettingsStore");
        Intrinsics3.checkNotNullParameter(storePermissions, "permissionsStore");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(scheduler, "backgroundThreadScheduler");
        Intrinsics3.checkNotNullParameter(videoPermissionsManager, "videoPermissionsManager");
        Intrinsics3.checkNotNullParameter(voiceEngineServiceController, "voiceEngineServiceController");
        Intrinsics3.checkNotNullParameter(storeStreamRtcConnection, "streamRtcConnectionStore");
        Intrinsics3.checkNotNullParameter(storeAccessibility, "accessibilityStore");
        Intrinsics3.checkNotNullParameter(storeAudioManagerV2, "audioManagerStore");
        Intrinsics3.checkNotNullParameter(storeMentions, "mentionsStore");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "analyticsStore");
        Intrinsics3.checkNotNullParameter(storeConnectivity, "connectivityStore");
        Intrinsics3.checkNotNullParameter(storeStageChannels, "stageStore");
        Intrinsics3.checkNotNullParameter(storeAnalytics2, "storeAnalytics");
        Intrinsics3.checkNotNullParameter(storeExperiments, "experimentsStore");
        Intrinsics3.checkNotNullParameter(storeChannelsSelected, "channelsSelectedStore");
        Intrinsics3.checkNotNullParameter(storeApplication, "applicationStore");
        Intrinsics3.checkNotNullParameter(storeApplicationAssets, "applicationAssetsStore");
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
        this.showStageCallBottomSheet = j != StoreStream.INSTANCE.getVoiceChannelSelected().getSelectedVoiceChannelId();
        this.logStreamQualityIndicatorViewed = true;
        this.eventSubject = PublishSubject.k0();
        PublishSubject<List<VideoCallParticipantView.ParticipantData>> publishSubjectK0 = PublishSubject.k0();
        this.offScreenSubject = publishSubjectK0;
        long j2 = 0;
        Scheduler scheduler2 = null;
        Scheduler scheduler3 = null;
        int i = 7;
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.videoPlayerIdleDetectorFooter = new VideoPlayerIdleDetector(j2, scheduler2, scheduler3, new WidgetCallFullscreenViewModel5(this), i, defaultConstructorMarker);
        this.videoPlayerIdleDetectorHeader = new VideoPlayerIdleDetector(j2, scheduler2, scheduler3, new WidgetCallFullscreenViewModel6(this), i, defaultConstructorMarker);
        this.allVideoParticipants = Collections2.emptyList();
        if (str != null) {
            this.autotargetStreamKey = str;
            storeVoiceChannelSelected.selectVoiceChannel(ModelApplicationStream.INSTANCE.decodeStreamKey(str).getChannelId());
        }
        Observable<List<VideoCallParticipantView.ParticipantData>> observableP = publishSubjectK0.p(1000L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableP, "offScreenSubject\n       …0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe(observableP, (Class<?>) WidgetCallFullscreenViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}

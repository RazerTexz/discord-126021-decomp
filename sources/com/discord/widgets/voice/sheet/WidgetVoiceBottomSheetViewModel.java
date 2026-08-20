package com.discord.widgets.voice.sheet;

import android.content.Intent;
import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import androidx.view.ViewModelKt;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreApplication;
import com.discord.stores.StoreApplicationStreamPreviews;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreCalls;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreEmbeddedActivities;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMediaEngine;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.tooltips.TooltipManager;
import com.discord.utilities.error.Error;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.VideoPermissionsManager;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.voice.VoiceChannelJoinability;
import com.discord.utilities.voice.VoiceEngineServiceController;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.voice.fullscreen.ParticipantsListItemGenerator;
import com.discord.widgets.voice.model.CallModel;
import com.discord.widgets.voice.model.CameraState;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import org.objectweb.asm.Opcodes;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p008a.p026j.C1100a;
import p007b.p008a.p058v.C1311a;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12113l;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12163u;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func3;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceBottomSheetViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final StoreApplication applicationStore;
    private final StoreCalls callsStore;
    private final long channelId;
    private final StoreChannels channelStore;
    private final Clock clock;
    private final StoreEmbeddedActivities embeddedActivitiesStore;
    private final PublishSubject<Event> eventSubject;
    private Set<String> fetchedPreviews;
    private final boolean forwardToFullscreenIfVideoActivated;
    private final StoreGuilds guildsStore;
    private final StoreMediaEngine mediaEngineStore;
    private final StoreMediaSettings mediaSettingsStore;
    private StoreState mostRecentStoreState;
    private final StorePermissions permissionsStore;
    private final StoreVoiceChannelSelected selectedVoiceChannelStore;
    private final StoreApplicationStreamPreviews storeApplicationStreamPreviews;
    private final TooltipManager tooltipManager;
    private final StoreUserSettings userSettingsStore;
    private final VideoPermissionsManager videoPermissionsManager;
    private final VoiceEngineServiceController voiceEngineServiceController;
    private Boolean wasConnected;
    private boolean wasEverConnected;
    private boolean wasEverMultiParticipant;

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheetViewModel$1 */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
    public static final class C106021 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C106021() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "storeState");
            WidgetVoiceBottomSheetViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(final long channelId, final StorePermissions permissionsStore, StoreChannels channelsStore) {
            Observable observableM11099Y = channelsStore.observeChannel(channelId).m11099Y(new InterfaceC12589b<Channel, Observable<? extends StoreState>>() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheetViewModel$Companion$observeStoreState$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends WidgetVoiceBottomSheetViewModel.StoreState> call(Channel channel) {
                    return Observable.m11075i(CallModel.INSTANCE.get(channelId), permissionsStore.observePermissionsForChannel(channelId), TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().observeEnabled(channel != null ? Long.valueOf(channel.getGuildId()) : null), new Func3<CallModel, Long, Boolean, WidgetVoiceBottomSheetViewModel.StoreState>() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheetViewModel$Companion$observeStoreState$1.1
                        @Override // p658rx.functions.Func3
                        public final WidgetVoiceBottomSheetViewModel.StoreState call(CallModel callModel, Long l, Boolean bool) {
                            if (callModel != null) {
                                if (C12148n0.setOf((Object[]) new Integer[]{2, 13, 1, 3}).contains(Integer.valueOf(callModel.getChannel().getType()))) {
                                    Boolean boolValueOf = Boolean.valueOf(callModel.getVoiceSettings().getNoiseProcessing() == StoreMediaSettings.NoiseProcessing.Cancellation);
                                    C12238m.checkNotNullExpressionValue(bool, "textInVoiceEnabled");
                                    return new WidgetVoiceBottomSheetViewModel.StoreState.Valid(callModel, boolValueOf, l, bool.booleanValue());
                                }
                            }
                            return WidgetVoiceBottomSheetViewModel.StoreState.Invalid.INSTANCE;
                        }
                    });
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11099Y, "channelsStore.observeCha…      }\n        }\n      }");
            return observableM11099Y;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
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
                return C1643a.m814B(C1643a.m833U("AccessibilityAnnouncement(messageResId="), this.messageResId, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
        public static final class Dismiss extends Event {
            public static final Dismiss INSTANCE = new Dismiss();

            private Dismiss() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
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
                return this.channelId == enqueueCallFeedbackSheet.channelId && C12238m.areEqual(this.rtcConnectionId, enqueueCallFeedbackSheet.rtcConnectionId) && C12238m.areEqual(this.mediaSessionId, enqueueCallFeedbackSheet.mediaSessionId) && this.callDuration == enqueueCallFeedbackSheet.callDuration && this.triggerRateDenominator == enqueueCallFeedbackSheet.triggerRateDenominator;
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
                int iM3a = C0002b.m3a(this.channelId) * 31;
                String str = this.rtcConnectionId;
                int iHashCode = (iM3a + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.mediaSessionId;
                return ((C0002b.m3a(this.callDuration) + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31)) * 31) + this.triggerRateDenominator;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("EnqueueCallFeedbackSheet(channelId=");
                sbM833U.append(this.channelId);
                sbM833U.append(", rtcConnectionId=");
                sbM833U.append(this.rtcConnectionId);
                sbM833U.append(", mediaSessionId=");
                sbM833U.append(this.mediaSessionId);
                sbM833U.append(", callDuration=");
                sbM833U.append(this.callDuration);
                sbM833U.append(", triggerRateDenominator=");
                return C1643a.m814B(sbM833U, this.triggerRateDenominator, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
        public static final class ExpandSheet extends Event {
            public static final ExpandSheet INSTANCE = new ExpandSheet();

            private ExpandSheet() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
        public static final /* data */ class LaunchStageChannel extends Event {
            private final long channelId;

            public LaunchStageChannel(long j) {
                super(null);
                this.channelId = j;
            }

            public static /* synthetic */ LaunchStageChannel copy$default(LaunchStageChannel launchStageChannel, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = launchStageChannel.channelId;
                }
                return launchStageChannel.copy(j);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            public final LaunchStageChannel copy(long channelId) {
                return new LaunchStageChannel(channelId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof LaunchStageChannel) && this.channelId == ((LaunchStageChannel) other).channelId;
                }
                return true;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public int hashCode() {
                return C0002b.m3a(this.channelId);
            }

            public String toString() {
                return C1643a.m815C(C1643a.m833U("LaunchStageChannel(channelId="), this.channelId, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
        public static final /* data */ class LaunchVideoCall extends Event {
            private final String autoTargetStreamKey;
            private final long channelId;

            public LaunchVideoCall(long j, String str) {
                super(null);
                this.channelId = j;
                this.autoTargetStreamKey = str;
            }

            public static /* synthetic */ LaunchVideoCall copy$default(LaunchVideoCall launchVideoCall, long j, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = launchVideoCall.channelId;
                }
                if ((i & 2) != 0) {
                    str = launchVideoCall.autoTargetStreamKey;
                }
                return launchVideoCall.copy(j, str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getAutoTargetStreamKey() {
                return this.autoTargetStreamKey;
            }

            public final LaunchVideoCall copy(long channelId, String autoTargetStreamKey) {
                return new LaunchVideoCall(channelId, autoTargetStreamKey);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LaunchVideoCall)) {
                    return false;
                }
                LaunchVideoCall launchVideoCall = (LaunchVideoCall) other;
                return this.channelId == launchVideoCall.channelId && C12238m.areEqual(this.autoTargetStreamKey, launchVideoCall.autoTargetStreamKey);
            }

            public final String getAutoTargetStreamKey() {
                return this.autoTargetStreamKey;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public int hashCode() {
                int iM3a = C0002b.m3a(this.channelId) * 31;
                String str = this.autoTargetStreamKey;
                return iM3a + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("LaunchVideoCall(channelId=");
                sbM833U.append(this.channelId);
                sbM833U.append(", autoTargetStreamKey=");
                return C1643a.m822J(sbM833U, this.autoTargetStreamKey, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
        public static final class RequestStartStream extends Event {
            public static final RequestStartStream INSTANCE = new RequestStartStream();

            private RequestStartStream() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
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
                return C1643a.m814B(C1643a.m833U("ShowCameraCapacityDialog(guildMaxVideoChannelUsers="), this.guildMaxVideoChannelUsers, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
        public static final /* data */ class ShowEventEnd extends Event {
            private final GuildScheduledEvent guildScheduledEvent;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowEventEnd(GuildScheduledEvent guildScheduledEvent) {
                super(null);
                C12238m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
                this.guildScheduledEvent = guildScheduledEvent;
            }

            public static /* synthetic */ ShowEventEnd copy$default(ShowEventEnd showEventEnd, GuildScheduledEvent guildScheduledEvent, int i, Object obj) {
                if ((i & 1) != 0) {
                    guildScheduledEvent = showEventEnd.guildScheduledEvent;
                }
                return showEventEnd.copy(guildScheduledEvent);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final GuildScheduledEvent getGuildScheduledEvent() {
                return this.guildScheduledEvent;
            }

            public final ShowEventEnd copy(GuildScheduledEvent guildScheduledEvent) {
                C12238m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
                return new ShowEventEnd(guildScheduledEvent);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowEventEnd) && C12238m.areEqual(this.guildScheduledEvent, ((ShowEventEnd) other).guildScheduledEvent);
                }
                return true;
            }

            public final GuildScheduledEvent getGuildScheduledEvent() {
                return this.guildScheduledEvent;
            }

            public int hashCode() {
                GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
                if (guildScheduledEvent != null) {
                    return guildScheduledEvent.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("ShowEventEnd(guildScheduledEvent=");
                sbM833U.append(this.guildScheduledEvent);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
        public static final class ShowGuildVideoAtCapacityDialog extends Event {
            public static final ShowGuildVideoAtCapacityDialog INSTANCE = new ShowGuildVideoAtCapacityDialog();

            private ShowGuildVideoAtCapacityDialog() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
        public static final class ShowNoScreenSharePermissionDialog extends Event {
            public static final ShowNoScreenSharePermissionDialog INSTANCE = new ShowNoScreenSharePermissionDialog();

            private ShowNoScreenSharePermissionDialog() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
        public static final class ShowNoVideoDevicesAvailableToast extends Event {
            public static final ShowNoVideoDevicesAvailableToast INSTANCE = new ShowNoVideoDevicesAvailableToast();

            private ShowNoVideoDevicesAvailableToast() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
        public static final class ShowNoVideoPermissionDialog extends Event {
            public static final ShowNoVideoPermissionDialog INSTANCE = new ShowNoVideoPermissionDialog();

            private ShowNoVideoPermissionDialog() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
        public static final class ShowNoiseCancellationBottomSheet extends Event {
            public static final ShowNoiseCancellationBottomSheet INSTANCE = new ShowNoiseCancellationBottomSheet();

            private ShowNoiseCancellationBottomSheet() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
        public static final class ShowOverlayNux extends Event {
            public static final ShowOverlayNux INSTANCE = new ShowOverlayNux();

            private ShowOverlayNux() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
        public static final class ShowRequestCameraPermissionsDialog extends Event {
            public static final ShowRequestCameraPermissionsDialog INSTANCE = new ShowRequestCameraPermissionsDialog();

            private ShowRequestCameraPermissionsDialog() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
        public static final class ShowServerDeafenedDialog extends Event {
            public static final ShowServerDeafenedDialog INSTANCE = new ShowServerDeafenedDialog();

            private ShowServerDeafenedDialog() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
        public static final class ShowServerMutedDialog extends Event {
            public static final ShowServerMutedDialog INSTANCE = new ShowServerMutedDialog();

            private ShowServerMutedDialog() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
        public static final class ShowSuppressedDialog extends Event {
            public static final ShowSuppressedDialog INSTANCE = new ShowSuppressedDialog();

            private ShowSuppressedDialog() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
        public static final /* data */ class ShowToast extends Event {
            private final int toastResId;

            public ShowToast(@StringRes int i) {
                super(null);
                this.toastResId = i;
            }

            public static /* synthetic */ ShowToast copy$default(ShowToast showToast, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = showToast.toastResId;
                }
                return showToast.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getToastResId() {
                return this.toastResId;
            }

            public final ShowToast copy(@StringRes int toastResId) {
                return new ShowToast(toastResId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowToast) && this.toastResId == ((ShowToast) other).toastResId;
                }
                return true;
            }

            public final int getToastResId() {
                return this.toastResId;
            }

            public int hashCode() {
                return this.toastResId;
            }

            public String toString() {
                return C1643a.m814B(C1643a.m833U("ShowToast(toastResId="), this.toastResId, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
    public static abstract class StoreState {

        /* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
        public static final /* data */ class Valid extends StoreState {
            private final CallModel callModel;
            private final Long myPermissions;
            private final Boolean noiseCancellation;
            private final boolean textInVoiceEnabled;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(CallModel callModel, Boolean bool, Long l, boolean z2) {
                super(null);
                C12238m.checkNotNullParameter(callModel, "callModel");
                this.callModel = callModel;
                this.noiseCancellation = bool;
                this.myPermissions = l;
                this.textInVoiceEnabled = z2;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, CallModel callModel, Boolean bool, Long l, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    callModel = valid.callModel;
                }
                if ((i & 2) != 0) {
                    bool = valid.noiseCancellation;
                }
                if ((i & 4) != 0) {
                    l = valid.myPermissions;
                }
                if ((i & 8) != 0) {
                    z2 = valid.textInVoiceEnabled;
                }
                return valid.copy(callModel, bool, l, z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CallModel getCallModel() {
                return this.callModel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Boolean getNoiseCancellation() {
                return this.noiseCancellation;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final Long getMyPermissions() {
                return this.myPermissions;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getTextInVoiceEnabled() {
                return this.textInVoiceEnabled;
            }

            public final Valid copy(CallModel callModel, Boolean noiseCancellation, Long myPermissions, boolean textInVoiceEnabled) {
                C12238m.checkNotNullParameter(callModel, "callModel");
                return new Valid(callModel, noiseCancellation, myPermissions, textInVoiceEnabled);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return C12238m.areEqual(this.callModel, valid.callModel) && C12238m.areEqual(this.noiseCancellation, valid.noiseCancellation) && C12238m.areEqual(this.myPermissions, valid.myPermissions) && this.textInVoiceEnabled == valid.textInVoiceEnabled;
            }

            public final CallModel getCallModel() {
                return this.callModel;
            }

            public final Long getMyPermissions() {
                return this.myPermissions;
            }

            public final Boolean getNoiseCancellation() {
                return this.noiseCancellation;
            }

            public final boolean getTextInVoiceEnabled() {
                return this.textInVoiceEnabled;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v8, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v4 */
            /* JADX WARN: Type inference failed for: r1v6 */
            public int hashCode() {
                CallModel callModel = this.callModel;
                int iHashCode = (callModel != null ? callModel.hashCode() : 0) * 31;
                Boolean bool = this.noiseCancellation;
                int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
                Long l = this.myPermissions;
                int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
                boolean z2 = this.textInVoiceEnabled;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                return iHashCode3 + r1;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Valid(callModel=");
                sbM833U.append(this.callModel);
                sbM833U.append(", noiseCancellation=");
                sbM833U.append(this.noiseCancellation);
                sbM833U.append(", myPermissions=");
                sbM833U.append(this.myPermissions);
                sbM833U.append(", textInVoiceEnabled=");
                return C1643a.m827O(sbM833U, this.textInVoiceEnabled, ")");
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
    public static final /* data */ class ViewState implements WidgetVoiceBottomSheet.ViewState {
        private final WidgetVoiceBottomSheet.BottomContent bottomContent;
        private final WidgetVoiceBottomSheet.CenterContent centerContent;
        private final Channel channel;
        private final boolean isDeafened;
        private final Boolean isNoiseCancellationActive;
        private final boolean showInviteOption;
        private final String subtitle;
        private final String title;

        public ViewState(String str, String str2, Channel channel, boolean z2, Boolean bool, boolean z3, WidgetVoiceBottomSheet.CenterContent centerContent, WidgetVoiceBottomSheet.BottomContent bottomContent) {
            C12238m.checkNotNullParameter(str, "title");
            C12238m.checkNotNullParameter(channel, "channel");
            C12238m.checkNotNullParameter(centerContent, "centerContent");
            this.title = str;
            this.subtitle = str2;
            this.channel = channel;
            this.showInviteOption = z2;
            this.isNoiseCancellationActive = bool;
            this.isDeafened = z3;
            this.centerContent = centerContent;
            this.bottomContent = bottomContent;
        }

        public final String component1() {
            return getTitle();
        }

        public final String component2() {
            return getSubtitle();
        }

        public final Channel component3() {
            return getChannel();
        }

        public final boolean component4() {
            return getShowInviteOption();
        }

        public final Boolean component5() {
            return getIsNoiseCancellationActive();
        }

        public final boolean component6() {
            return getIsDeafened();
        }

        public final WidgetVoiceBottomSheet.CenterContent component7() {
            return getCenterContent();
        }

        public final WidgetVoiceBottomSheet.BottomContent component8() {
            return getBottomContent();
        }

        public final ViewState copy(String title, String subtitle, Channel channel, boolean showInviteOption, Boolean isNoiseCancellationActive, boolean isDeafened, WidgetVoiceBottomSheet.CenterContent centerContent, WidgetVoiceBottomSheet.BottomContent bottomContent) {
            C12238m.checkNotNullParameter(title, "title");
            C12238m.checkNotNullParameter(channel, "channel");
            C12238m.checkNotNullParameter(centerContent, "centerContent");
            return new ViewState(title, subtitle, channel, showInviteOption, isNoiseCancellationActive, isDeafened, centerContent, bottomContent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return C12238m.areEqual(getTitle(), viewState.getTitle()) && C12238m.areEqual(getSubtitle(), viewState.getSubtitle()) && C12238m.areEqual(getChannel(), viewState.getChannel()) && getShowInviteOption() == viewState.getShowInviteOption() && C12238m.areEqual(getIsNoiseCancellationActive(), viewState.getIsNoiseCancellationActive()) && getIsDeafened() == viewState.getIsDeafened() && C12238m.areEqual(getCenterContent(), viewState.getCenterContent()) && C12238m.areEqual(getBottomContent(), viewState.getBottomContent());
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.ViewState
        public WidgetVoiceBottomSheet.BottomContent getBottomContent() {
            return this.bottomContent;
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.ViewState
        public WidgetVoiceBottomSheet.CenterContent getCenterContent() {
            return this.centerContent;
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.ViewState
        public Channel getChannel() {
            return this.channel;
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.ViewState
        public boolean getShowInviteOption() {
            return this.showInviteOption;
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.ViewState
        public String getSubtitle() {
            return this.subtitle;
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.ViewState
        public String getTitle() {
            return this.title;
        }

        public int hashCode() {
            String title = getTitle();
            int iHashCode = (title != null ? title.hashCode() : 0) * 31;
            String subtitle = getSubtitle();
            int iHashCode2 = (iHashCode + (subtitle != null ? subtitle.hashCode() : 0)) * 31;
            Channel channel = getChannel();
            int iHashCode3 = (iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31;
            boolean showInviteOption = getShowInviteOption();
            int i = showInviteOption;
            if (showInviteOption) {
                i = 1;
            }
            int i2 = (iHashCode3 + i) * 31;
            Boolean isNoiseCancellationActive = getIsNoiseCancellationActive();
            int iHashCode4 = (i2 + (isNoiseCancellationActive != null ? isNoiseCancellationActive.hashCode() : 0)) * 31;
            boolean isDeafened = getIsDeafened();
            int i3 = (iHashCode4 + (isDeafened ? 1 : isDeafened)) * 31;
            WidgetVoiceBottomSheet.CenterContent centerContent = getCenterContent();
            int iHashCode5 = (i3 + (centerContent != null ? centerContent.hashCode() : 0)) * 31;
            WidgetVoiceBottomSheet.BottomContent bottomContent = getBottomContent();
            return iHashCode5 + (bottomContent != null ? bottomContent.hashCode() : 0);
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.ViewState
        /* JADX INFO: renamed from: isDeafened, reason: from getter */
        public boolean getIsDeafened() {
            return this.isDeafened;
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.ViewState
        /* JADX INFO: renamed from: isNoiseCancellationActive, reason: from getter */
        public Boolean getIsNoiseCancellationActive() {
            return this.isNoiseCancellationActive;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ViewState(title=");
            sbM833U.append(getTitle());
            sbM833U.append(", subtitle=");
            sbM833U.append(getSubtitle());
            sbM833U.append(", channel=");
            sbM833U.append(getChannel());
            sbM833U.append(", showInviteOption=");
            sbM833U.append(getShowInviteOption());
            sbM833U.append(", isNoiseCancellationActive=");
            sbM833U.append(getIsNoiseCancellationActive());
            sbM833U.append(", isDeafened=");
            sbM833U.append(getIsDeafened());
            sbM833U.append(", centerContent=");
            sbM833U.append(getCenterContent());
            sbM833U.append(", bottomContent=");
            sbM833U.append(getBottomContent());
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            StoreMediaSettings.SelfMuteFailure.values();
            int[] iArr = new int[1];
            $EnumSwitchMapping$0 = iArr;
            iArr[StoreMediaSettings.SelfMuteFailure.CANNOT_USE_VAD.ordinal()] = 1;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheetViewModel$tryConnectToVoice$1 */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
    @InterfaceC12188e(m10084c = "com.discord.widgets.voice.sheet.WidgetVoiceBottomSheetViewModel$tryConnectToVoice$1", m10085f = "WidgetVoiceBottomSheetViewModel.kt", m10086l = {Opcodes.IRETURN, 180}, m10087m = "invokeSuspend")
    public static final class C106041 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ StoreMediaEngine $mediaEngine;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C106041(StoreMediaEngine storeMediaEngine, Continuation continuation) {
            super(2, continuation);
            this.$mediaEngine = storeMediaEngine;
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            return WidgetVoiceBottomSheetViewModel.this.new C106041(this.$mediaEngine, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C106041) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    C12113l.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C12113l.throwOnFailure(obj);
                }
                return Unit.f27425a;
            }
            C12113l.throwOnFailure(obj);
            StoreMediaEngine storeMediaEngine = this.$mediaEngine;
            this.label = 1;
            obj = storeMediaEngine.getDefaultVideoDeviceGUID(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            if (obj != null) {
                WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel = WidgetVoiceBottomSheetViewModel.this;
                widgetVoiceBottomSheetViewModel.joinVoiceChannel(widgetVoiceBottomSheetViewModel.channelId);
                StoreMediaEngine storeMediaEngine2 = this.$mediaEngine;
                this.label = 2;
                if (storeMediaEngine2.selectDefaultVideoDeviceAsync(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                WidgetVoiceBottomSheetViewModel.this.eventSubject.f27650k.onNext((T) Event.ShowNoVideoDevicesAvailableToast.INSTANCE);
            }
            return Unit.f27425a;
        }
    }

    public WidgetVoiceBottomSheetViewModel(long j, boolean z2, StoreChannels storeChannels, StorePermissions storePermissions, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreMediaSettings storeMediaSettings, StoreMediaEngine storeMediaEngine, StoreUserSettings storeUserSettings, StoreCalls storeCalls, StoreGuilds storeGuilds, VideoPermissionsManager videoPermissionsManager, StoreApplicationStreamPreviews storeApplicationStreamPreviews, VoiceEngineServiceController voiceEngineServiceController, Clock clock, TooltipManager tooltipManager, StoreEmbeddedActivities storeEmbeddedActivities, StoreApplication storeApplication, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        TooltipManager tooltipManager2;
        TooltipManager tooltipManager3;
        StoreChannels channels = (i & 4) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StorePermissions permissions = (i & 8) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions;
        StoreVoiceChannelSelected voiceChannelSelected = (i & 16) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected;
        StoreMediaSettings mediaSettings = (i & 32) != 0 ? StoreStream.INSTANCE.getMediaSettings() : storeMediaSettings;
        StoreMediaEngine mediaEngine = (i & 64) != 0 ? StoreStream.INSTANCE.getMediaEngine() : storeMediaEngine;
        StoreUserSettings userSettings = (i & 128) != 0 ? StoreStream.INSTANCE.getUserSettings() : storeUserSettings;
        StoreCalls calls = (i & 256) != 0 ? StoreStream.INSTANCE.getCalls() : storeCalls;
        StoreGuilds guilds = (i & 512) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        VideoPermissionsManager videoPermissionsManager2 = (i & 1024) != 0 ? new VideoPermissionsManager(null, 1, null) : videoPermissionsManager;
        StoreApplicationStreamPreviews applicationStreamPreviews = (i & 2048) != 0 ? StoreStream.INSTANCE.getApplicationStreamPreviews() : storeApplicationStreamPreviews;
        VoiceEngineServiceController instance = (i & 4096) != 0 ? VoiceEngineServiceController.INSTANCE.getINSTANCE() : voiceEngineServiceController;
        Clock clock2 = (i & 8192) != 0 ? ClockFactory.get() : clock;
        if ((i & 16384) != 0) {
            AppLog appLog = AppLog.f14950g;
            C12238m.checkNotNullParameter(appLog, "logger");
            WeakReference<C1100a> weakReference = C1100a.b.f1460a;
            C1100a c1100a = weakReference != null ? weakReference.get() : null;
            if (c1100a == null) {
                c1100a = new C1100a(appLog);
                C1100a.b.f1460a = new WeakReference<>(c1100a);
            }
            TooltipManager.C6647a c6647a = TooltipManager.C6647a.f18975d;
            C12238m.checkNotNullParameter(c1100a, "floatingViewManager");
            WeakReference<TooltipManager> weakReference2 = TooltipManager.C6647a.f18972a;
            TooltipManager tooltipManager4 = weakReference2 != null ? weakReference2.get() : null;
            if (tooltipManager4 == null) {
                tooltipManager3 = new TooltipManager((C1311a) TooltipManager.C6647a.f18973b.getValue(), (Set) TooltipManager.C6647a.f18974c.getValue(), 0, c1100a, 4);
                TooltipManager.C6647a.f18972a = new WeakReference<>(tooltipManager3);
            } else {
                tooltipManager3 = tooltipManager4;
            }
            tooltipManager2 = tooltipManager3;
        } else {
            tooltipManager2 = tooltipManager;
        }
        this(j, z2, channels, permissions, voiceChannelSelected, mediaSettings, mediaEngine, userSettings, calls, guilds, videoPermissionsManager2, applicationStreamPreviews, instance, clock2, tooltipManager2, (32768 & i) != 0 ? StoreStream.INSTANCE.getEmbeddedActivities() : storeEmbeddedActivities, (65536 & i) != 0 ? StoreStream.INSTANCE.getApplication() : storeApplication, (i & 131072) != 0 ? INSTANCE.observeStoreState(j, permissions, channels) : observable);
    }

    private final void emitServerDeafenedDialogEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(Event.ShowServerDeafenedDialog.INSTANCE);
    }

    private final void emitServerMutedDialogEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(Event.ShowServerMutedDialog.INSTANCE);
    }

    private final void emitShowNoScreenSharePermissionDialogEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(Event.ShowNoScreenSharePermissionDialog.INSTANCE);
    }

    private final void emitShowNoVideoPermissionDialogEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(Event.ShowNoVideoPermissionDialog.INSTANCE);
    }

    private final void emitSuppressedDialogEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(Event.ShowSuppressedDialog.INSTANCE);
    }

    private final GuildScheduledEvent getGuildScheduledEventToEnd() {
        StoreState storeState = this.mostRecentStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            return null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        return GuildScheduledEventUtilities.INSTANCE.getGuildScheduledEventToEndForCall(valid.getCallModel(), valid.getMyPermissions(), this.guildsStore);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        ModelApplicationStream stream;
        this.mostRecentStoreState = storeState;
        if (storeState instanceof StoreState.Valid) {
            StoreState.Valid valid = (StoreState.Valid) storeState;
            boolean z2 = valid.getCallModel().isConnected() && this.forwardToFullscreenIfVideoActivated && (valid.getCallModel().getIsVideoCall() || valid.getTextInVoiceEnabled());
            if (valid.getCallModel().isConnected() && ChannelUtils.m7669D(valid.getCallModel().getChannel())) {
                this.eventSubject.f27650k.onNext(new Event.LaunchStageChannel(valid.getCallModel().getChannel().getId()));
            }
            String encodedStreamKey = null;
            if (z2) {
                this.eventSubject.f27650k.onNext(new Event.LaunchVideoCall(valid.getCallModel().getChannel().getId(), null));
                return;
            }
            Channel channel = valid.getCallModel().getChannel();
            String strM7679c = ChannelUtils.m7679c(channel);
            Guild guild = valid.getCallModel().getGuild();
            String name = guild != null ? guild.getName() : null;
            StoreApplicationStreaming.ActiveApplicationStream activeStream = valid.getCallModel().getActiveStream();
            if (activeStream != null && (stream = activeStream.getStream()) != null) {
                encodedStreamKey = stream.getEncodedStreamKey();
            }
            String str = encodedStreamKey;
            Map<Long, EmbeddedActivity> embeddedActivitiesForChannel = valid.getCallModel().getEmbeddedActivitiesForChannel();
            List<CallParticipantsAdapter.ListItem> listCreateConnectedListItems = ParticipantsListItemGenerator.INSTANCE.createConnectedListItems(valid.getCallModel().getParticipants(), str, channel, valid.getCallModel(), C12163u.toList(embeddedActivitiesForChannel.values()), valid.getCallModel().getApplications());
            Iterator<Long> it = embeddedActivitiesForChannel.keySet().iterator();
            while (it.hasNext()) {
                this.applicationStore.fetchIfNonexisting(it.next().longValue());
            }
            WidgetVoiceBottomSheet.CenterContent listItems = ParticipantsListItemGenerator.INSTANCE.refreshStreams(listCreateConnectedListItems, this.fetchedPreviews, this.storeApplicationStreamPreviews) ? new WidgetVoiceBottomSheet.CenterContent.ListItems(listCreateConnectedListItems) : new WidgetVoiceBottomSheet.CenterContent.Empty(listCreateConnectedListItems);
            boolean zIsConnected = valid.getCallModel().isConnected();
            this.wasEverConnected = this.wasEverConnected || zIsConnected;
            boolean z3 = valid.getCallModel().getVoiceChannelJoinability() != VoiceChannelJoinability.PERMISSIONS_MISSING;
            Boolean bool = this.wasConnected;
            if (bool != null && !bool.booleanValue() && zIsConnected && valid.getCallModel().isSuppressed()) {
                emitSuppressedDialogEvent();
            }
            this.wasConnected = Boolean.valueOf(zIsConnected);
            this.wasEverMultiParticipant = this.wasEverMultiParticipant || valid.getCallModel().getNumUsersConnected() > 1;
            updateViewState(new ViewState(strM7679c, name, valid.getCallModel().getChannel(), valid.getCallModel().canInvite() && !ChannelUtils.m7669D(valid.getCallModel().getChannel()), valid.getNoiseCancellation(), valid.getCallModel().isDeafenedByAnySource(), listItems, !zIsConnected ? new WidgetVoiceBottomSheet.BottomContent.Connect(z3) : new WidgetVoiceBottomSheet.BottomContent.Controls(valid.getCallModel().getInputMode(), valid.getCallModel().getAudioManagerState(), valid.getCallModel().isMeMutedByAnySource(), valid.getCallModel().getCameraState(), hasVideoPermission(), valid.getCallModel().isStreaming())));
        }
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

    @MainThread
    private final void joinVoiceChannel(long channelId) {
        this.selectedVoiceChannelStore.selectVoiceChannel(channelId);
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(Event.ExpandSheet.INSTANCE);
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        C12238m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onCameraButtonPressed() {
        if (!hasVideoPermission()) {
            emitShowNoVideoPermissionDialogEvent();
            return;
        }
        WidgetVoiceBottomSheet.BottomContent bottomContent = requireViewState().getBottomContent();
        if (!(bottomContent instanceof WidgetVoiceBottomSheet.BottomContent.Controls)) {
            bottomContent = null;
        }
        WidgetVoiceBottomSheet.BottomContent.Controls controls = (WidgetVoiceBottomSheet.BottomContent.Controls) bottomContent;
        CameraState cameraState = controls != null ? controls.getCameraState() : null;
        if (cameraState == CameraState.CAMERA_DISABLED) {
            return;
        }
        if (cameraState == CameraState.CAMERA_ON) {
            this.mediaEngineStore.selectVideoInputDevice(null);
            return;
        }
        StoreState storeState = this.mostRecentStoreState;
        StoreState.Valid valid = (StoreState.Valid) (storeState instanceof StoreState.Valid ? storeState : null);
        if (valid != null) {
            int numUsersConnected = valid.getCallModel().getNumUsersConnected();
            GuildMaxVideoChannelUsers guildMaxVideoChannelMembers = valid.getCallModel().getGuildMaxVideoChannelMembers();
            if (guildMaxVideoChannelMembers instanceof GuildMaxVideoChannelUsers.Limited) {
                GuildMaxVideoChannelUsers.Limited limited = (GuildMaxVideoChannelUsers.Limited) guildMaxVideoChannelMembers;
                if (numUsersConnected > limited.getLimit()) {
                    this.eventSubject.f27650k.onNext(new Event.ShowCameraCapacityDialog(limited.getLimit()));
                    return;
                }
            }
            this.eventSubject.f27650k.onNext(Event.ShowRequestCameraPermissionsDialog.INSTANCE);
        }
    }

    @MainThread
    public final void onCameraPermissionsGranted() {
        StoreMediaEngine.selectDefaultVideoDevice$default(this.mediaEngineStore, null, 1, null);
    }

    @MainThread
    public final void onDeafenPressed() {
        CallModel callModel;
        StoreState storeState = this.mostRecentStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid == null || (callModel = valid.getCallModel()) == null) {
            return;
        }
        if (callModel.isServerDeafened()) {
            emitServerDeafenedDialogEvent();
            return;
        }
        this.mediaSettingsStore.toggleSelfDeafened();
        this.eventSubject.f27650k.onNext(new Event.AccessibilityAnnouncement(callModel.isDeafenedByAnySource() ? C5419R.string.voice_channel_undeafened : C5419R.string.voice_channel_deafened));
    }

    @MainThread
    public final void onDisconnect() {
        this.selectedVoiceChannelStore.clear();
        this.eventSubject.f27650k.onNext(Event.Dismiss.INSTANCE);
        StoreState storeState = this.mostRecentStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid == null) {
            return;
        }
        if (!this.wasEverConnected || this.wasEverMultiParticipant) {
            CallModel callModel = valid.getCallModel();
            RtcConnection.Metadata rtcConnectionMetadata = callModel.getRtcConnectionMetadata();
            this.eventSubject.f27650k.onNext(new Event.EnqueueCallFeedbackSheet(this.channelId, rtcConnectionMetadata != null ? rtcConnectionMetadata.rtcConnectionId : null, rtcConnectionMetadata != null ? rtcConnectionMetadata.mediaSessionId : null, callModel.getCallDurationMs(this.clock), callModel.getCallFeedbackTriggerRateDenominator()));
        }
    }

    @MainThread
    public final void onDisconnectPressed() {
        GuildScheduledEvent guildScheduledEventToEnd = getGuildScheduledEventToEnd();
        if (guildScheduledEventToEnd == null) {
            onDisconnect();
            return;
        }
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(new Event.ShowEventEnd(guildScheduledEventToEnd));
    }

    @MainThread
    public final void onMutePressed() {
        StoreState storeState = this.mostRecentStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid != null) {
            if (valid.getCallModel().isSuppressed()) {
                emitSuppressedDialogEvent();
                return;
            } else if (valid.getCallModel().isMuted()) {
                emitServerMutedDialogEvent();
                return;
            }
        }
        StoreMediaSettings.SelfMuteFailure selfMuteFailure = this.mediaSettingsStore.toggleSelfMuted();
        if (selfMuteFailure != null) {
            if (selfMuteFailure.ordinal() != 0) {
                return;
            }
            this.eventSubject.f27650k.onNext(new Event.ShowToast(C5419R.string.vad_permission_small));
            return;
        }
        WidgetVoiceBottomSheet.BottomContent bottomContent = requireViewState().getBottomContent();
        if (bottomContent == null || !(bottomContent instanceof WidgetVoiceBottomSheet.BottomContent.Controls)) {
            return;
        }
        this.eventSubject.f27650k.onNext(new Event.AccessibilityAnnouncement(((WidgetVoiceBottomSheet.BottomContent.Controls) bottomContent).isMuted() ? C5419R.string.voice_channel_unmuted : C5419R.string.voice_channel_muted));
    }

    @MainThread
    public final void onNoiseCancellationPressed() {
        Boolean isNoiseCancellationActive = requireViewState().getIsNoiseCancellationActive();
        if (isNoiseCancellationActive != null) {
            boolean zBooleanValue = isNoiseCancellationActive.booleanValue();
            TooltipManager tooltipManager = this.tooltipManager;
            NoiseCancellationTooltip noiseCancellationTooltip = NoiseCancellationTooltip.INSTANCE;
            if (tooltipManager.m8513b(noiseCancellationTooltip, true)) {
                this.tooltipManager.m8512a(noiseCancellationTooltip);
                PublishSubject<Event> publishSubject = this.eventSubject;
                publishSubject.f27650k.onNext(Event.ShowNoiseCancellationBottomSheet.INSTANCE);
                return;
            }
            this.mediaSettingsStore.toggleNoiseCancellation();
            if (zBooleanValue) {
                PublishSubject<Event> publishSubject2 = this.eventSubject;
                publishSubject2.f27650k.onNext(new Event.ShowToast(C5419R.string.noise_cancellation_off));
            } else {
                PublishSubject<Event> publishSubject3 = this.eventSubject;
                publishSubject3.f27650k.onNext(new Event.ShowToast(C5419R.string.noise_cancellation_on));
            }
        }
    }

    @MainThread
    public final void onPttPressed(boolean pressed) {
        this.mediaEngineStore.setPttActive(pressed);
    }

    @MainThread
    public final void onScreenSharePressed() {
        ViewState viewState = getViewState();
        WidgetVoiceBottomSheet.BottomContent bottomContent = viewState != null ? viewState.getBottomContent() : null;
        WidgetVoiceBottomSheet.BottomContent.Controls controls = (WidgetVoiceBottomSheet.BottomContent.Controls) (bottomContent instanceof WidgetVoiceBottomSheet.BottomContent.Controls ? bottomContent : null);
        if (controls != null) {
            if (controls.isScreensharing()) {
                this.voiceEngineServiceController.stopStream();
            } else if (!hasVideoPermission()) {
                emitShowNoScreenSharePermissionDialogEvent();
            } else {
                this.eventSubject.f27650k.onNext(Event.RequestStartStream.INSTANCE);
            }
        }
    }

    @MainThread
    public final void onStreamPreviewClicked(String streamKey) {
        C12238m.checkNotNullParameter(streamKey, "streamKey");
        StoreState storeState = this.mostRecentStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid != null) {
            if (valid.getCallModel().getVoiceChannelJoinability() == VoiceChannelJoinability.GUILD_VIDEO_AT_CAPACITY) {
                PublishSubject<Event> publishSubject = this.eventSubject;
                publishSubject.f27650k.onNext(Event.ShowGuildVideoAtCapacityDialog.INSTANCE);
            } else {
                ModelApplicationStream modelApplicationStreamDecodeStreamKey = ModelApplicationStream.INSTANCE.decodeStreamKey(streamKey);
                PublishSubject<Event> publishSubject2 = this.eventSubject;
                publishSubject2.f27650k.onNext(new Event.LaunchVideoCall(modelApplicationStreamDecodeStreamKey.getChannelId(), streamKey));
            }
        }
    }

    @MainThread
    public final void onToggleRingingPressed(StoreVoiceParticipants.VoiceUser voiceUser) {
        C12238m.checkNotNullParameter(voiceUser, "voiceUser");
        if (voiceUser.isRinging()) {
            this.callsStore.stopRinging(this.channelId, C12145m.listOf(Long.valueOf(voiceUser.getUser().getId())));
        } else {
            this.callsStore.ring(this.channelId, C12145m.listOf(Long.valueOf(voiceUser.getUser().getId())));
        }
    }

    public final void startStream(Intent intent) {
        C12238m.checkNotNullParameter(intent, "intent");
        this.voiceEngineServiceController.startStream(intent);
    }

    @MainThread
    public final void tryConnectToVoice(boolean useVideo) {
        StoreState storeState = this.mostRecentStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid != null) {
            if (valid.getCallModel().getVoiceChannelJoinability() == VoiceChannelJoinability.GUILD_VIDEO_AT_CAPACITY) {
                this.eventSubject.f27650k.onNext(Event.ShowGuildVideoAtCapacityDialog.INSTANCE);
                return;
            }
            if (!this.userSettingsStore.getIsMobileOverlayEnabled()) {
                this.eventSubject.f27650k.onNext(Event.ShowOverlayNux.INSTANCE);
            }
            if (!useVideo) {
                joinVoiceChannel(this.channelId);
            } else if (!hasVideoPermission()) {
                emitShowNoVideoPermissionDialogEvent();
            } else {
                C3404f.m4211H0(ViewModelKt.getViewModelScope(this), null, null, new C106041(StoreStream.INSTANCE.getMediaEngine(), null), 3, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceBottomSheetViewModel(long j, boolean z2, StoreChannels storeChannels, StorePermissions storePermissions, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreMediaSettings storeMediaSettings, StoreMediaEngine storeMediaEngine, StoreUserSettings storeUserSettings, StoreCalls storeCalls, StoreGuilds storeGuilds, VideoPermissionsManager videoPermissionsManager, StoreApplicationStreamPreviews storeApplicationStreamPreviews, VoiceEngineServiceController voiceEngineServiceController, Clock clock, TooltipManager tooltipManager, StoreEmbeddedActivities storeEmbeddedActivities, StoreApplication storeApplication, Observable<StoreState> observable) {
        super(null, 1, null);
        C12238m.checkNotNullParameter(storeChannels, "channelStore");
        C12238m.checkNotNullParameter(storePermissions, "permissionsStore");
        C12238m.checkNotNullParameter(storeVoiceChannelSelected, "selectedVoiceChannelStore");
        C12238m.checkNotNullParameter(storeMediaSettings, "mediaSettingsStore");
        C12238m.checkNotNullParameter(storeMediaEngine, "mediaEngineStore");
        C12238m.checkNotNullParameter(storeUserSettings, "userSettingsStore");
        C12238m.checkNotNullParameter(storeCalls, "callsStore");
        C12238m.checkNotNullParameter(storeGuilds, "guildsStore");
        C12238m.checkNotNullParameter(videoPermissionsManager, "videoPermissionsManager");
        C12238m.checkNotNullParameter(storeApplicationStreamPreviews, "storeApplicationStreamPreviews");
        C12238m.checkNotNullParameter(voiceEngineServiceController, "voiceEngineServiceController");
        C12238m.checkNotNullParameter(clock, "clock");
        C12238m.checkNotNullParameter(tooltipManager, "tooltipManager");
        C12238m.checkNotNullParameter(storeEmbeddedActivities, "embeddedActivitiesStore");
        C12238m.checkNotNullParameter(storeApplication, "applicationStore");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        this.forwardToFullscreenIfVideoActivated = z2;
        this.channelStore = storeChannels;
        this.permissionsStore = storePermissions;
        this.selectedVoiceChannelStore = storeVoiceChannelSelected;
        this.mediaSettingsStore = storeMediaSettings;
        this.mediaEngineStore = storeMediaEngine;
        this.userSettingsStore = storeUserSettings;
        this.callsStore = storeCalls;
        this.guildsStore = storeGuilds;
        this.videoPermissionsManager = videoPermissionsManager;
        this.storeApplicationStreamPreviews = storeApplicationStreamPreviews;
        this.voiceEngineServiceController = voiceEngineServiceController;
        this.clock = clock;
        this.tooltipManager = tooltipManager;
        this.embeddedActivitiesStore = storeEmbeddedActivities;
        this.applicationStore = storeApplication;
        this.eventSubject = PublishSubject.m11133k0();
        this.fetchedPreviews = new LinkedHashSet();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) WidgetVoiceBottomSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C106021());
    }
}

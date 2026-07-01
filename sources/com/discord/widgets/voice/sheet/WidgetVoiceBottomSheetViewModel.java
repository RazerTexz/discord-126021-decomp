package com.discord.widgets.voice.sheet;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import androidx.view.ViewModelKt;
import b.a.d.d0;
import b.a.j.a;
import b.a.j.a$b;
import b.i.a.f.e.o.f;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guild.GuildMaxVideoChannelUsers$Limited;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection$Metadata;
import com.discord.stores.StoreApplication;
import com.discord.stores.StoreApplicationStreamPreviews;
import com.discord.stores.StoreApplicationStreaming$ActiveApplicationStream;
import com.discord.stores.StoreCalls;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreEmbeddedActivities;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMediaEngine;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreMediaSettings$SelfMuteFailure;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.tooltips.TooltipManager;
import com.discord.tooltips.TooltipManager$a;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.permissions.VideoPermissionsManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.voice.VoiceChannelJoinability;
import com.discord.utilities.voice.VoiceEngineServiceController;
import com.discord.widgets.voice.fullscreen.ParticipantsListItemGenerator;
import com.discord.widgets.voice.model.CallModel;
import com.discord.widgets.voice.model.CameraState;
import d0.t.u;
import d0.z.d.m;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceBottomSheetViewModel extends d0<WidgetVoiceBottomSheetViewModel$ViewState> {
    public static final WidgetVoiceBottomSheetViewModel$Companion Companion = new WidgetVoiceBottomSheetViewModel$Companion(null);
    private final StoreApplication applicationStore;
    private final StoreCalls callsStore;
    private final long channelId;
    private final StoreChannels channelStore;
    private final Clock clock;
    private final StoreEmbeddedActivities embeddedActivitiesStore;
    private final PublishSubject<WidgetVoiceBottomSheetViewModel$Event> eventSubject;
    private Set<String> fetchedPreviews;
    private final boolean forwardToFullscreenIfVideoActivated;
    private final StoreGuilds guildsStore;
    private final StoreMediaEngine mediaEngineStore;
    private final StoreMediaSettings mediaSettingsStore;
    private WidgetVoiceBottomSheetViewModel$StoreState mostRecentStoreState;
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

    public WidgetVoiceBottomSheetViewModel(long j, boolean z2, StoreChannels storeChannels, StorePermissions storePermissions, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreMediaSettings storeMediaSettings, StoreMediaEngine storeMediaEngine, StoreUserSettings storeUserSettings, StoreCalls storeCalls, StoreGuilds storeGuilds, VideoPermissionsManager videoPermissionsManager, StoreApplicationStreamPreviews storeApplicationStreamPreviews, VoiceEngineServiceController voiceEngineServiceController, Clock clock, TooltipManager tooltipManager, StoreEmbeddedActivities storeEmbeddedActivities, StoreApplication storeApplication, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        TooltipManager tooltipManager2;
        TooltipManager tooltipManager3;
        StoreChannels channels = (i & 4) != 0 ? StoreStream.Companion.getChannels() : storeChannels;
        StorePermissions permissions = (i & 8) != 0 ? StoreStream.Companion.getPermissions() : storePermissions;
        StoreVoiceChannelSelected voiceChannelSelected = (i & 16) != 0 ? StoreStream.Companion.getVoiceChannelSelected() : storeVoiceChannelSelected;
        StoreMediaSettings mediaSettings = (i & 32) != 0 ? StoreStream.Companion.getMediaSettings() : storeMediaSettings;
        StoreMediaEngine mediaEngine = (i & 64) != 0 ? StoreStream.Companion.getMediaEngine() : storeMediaEngine;
        StoreUserSettings userSettings = (i & 128) != 0 ? StoreStream.Companion.getUserSettings() : storeUserSettings;
        StoreCalls calls = (i & 256) != 0 ? StoreStream.Companion.getCalls() : storeCalls;
        StoreGuilds guilds = (i & 512) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds;
        VideoPermissionsManager videoPermissionsManager2 = (i & 1024) != 0 ? new VideoPermissionsManager(null, 1, null) : videoPermissionsManager;
        StoreApplicationStreamPreviews applicationStreamPreviews = (i & 2048) != 0 ? StoreStream.Companion.getApplicationStreamPreviews() : storeApplicationStreamPreviews;
        VoiceEngineServiceController instance = (i & 4096) != 0 ? VoiceEngineServiceController.Companion.getINSTANCE() : voiceEngineServiceController;
        Clock clock2 = (i & 8192) != 0 ? ClockFactory.get() : clock;
        if ((i & 16384) != 0) {
            AppLog appLog = AppLog.g;
            m.checkNotNullParameter(appLog, "logger");
            WeakReference<a> weakReference = a$b.a;
            a aVar = weakReference != null ? weakReference.get() : null;
            if (aVar == null) {
                aVar = new a(appLog);
                a$b.a = new WeakReference<>(aVar);
            }
            TooltipManager$a tooltipManager$a = TooltipManager$a.d;
            m.checkNotNullParameter(aVar, "floatingViewManager");
            WeakReference<TooltipManager> weakReference2 = TooltipManager$a.a;
            TooltipManager tooltipManager4 = weakReference2 != null ? weakReference2.get() : null;
            if (tooltipManager4 == null) {
                tooltipManager3 = new TooltipManager((b.a.v.a) TooltipManager$a.f2815b.getValue(), (Set) TooltipManager$a.c.getValue(), 0, aVar, 4);
                TooltipManager$a.a = new WeakReference<>(tooltipManager3);
            } else {
                tooltipManager3 = tooltipManager4;
            }
            tooltipManager2 = tooltipManager3;
        } else {
            tooltipManager2 = tooltipManager;
        }
        this(j, z2, channels, permissions, voiceChannelSelected, mediaSettings, mediaEngine, userSettings, calls, guilds, videoPermissionsManager2, applicationStreamPreviews, instance, clock2, tooltipManager2, (32768 & i) != 0 ? StoreStream.Companion.getEmbeddedActivities() : storeEmbeddedActivities, (65536 & i) != 0 ? StoreStream.Companion.getApplication() : storeApplication, (i & 131072) != 0 ? WidgetVoiceBottomSheetViewModel$Companion.access$observeStoreState(Companion, j, permissions, channels) : observable);
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel) {
        return widgetVoiceBottomSheetViewModel.channelId;
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel) {
        return widgetVoiceBottomSheetViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel, WidgetVoiceBottomSheetViewModel$StoreState widgetVoiceBottomSheetViewModel$StoreState) {
        widgetVoiceBottomSheetViewModel.handleStoreState(widgetVoiceBottomSheetViewModel$StoreState);
    }

    public static final /* synthetic */ void access$joinVoiceChannel(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel, long j) {
        widgetVoiceBottomSheetViewModel.joinVoiceChannel(j);
    }

    private final void emitServerDeafenedDialogEvent() {
        PublishSubject<WidgetVoiceBottomSheetViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(WidgetVoiceBottomSheetViewModel$Event$ShowServerDeafenedDialog.INSTANCE);
    }

    private final void emitServerMutedDialogEvent() {
        PublishSubject<WidgetVoiceBottomSheetViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(WidgetVoiceBottomSheetViewModel$Event$ShowServerMutedDialog.INSTANCE);
    }

    private final void emitShowNoScreenSharePermissionDialogEvent() {
        PublishSubject<WidgetVoiceBottomSheetViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(WidgetVoiceBottomSheetViewModel$Event$ShowNoScreenSharePermissionDialog.INSTANCE);
    }

    private final void emitShowNoVideoPermissionDialogEvent() {
        PublishSubject<WidgetVoiceBottomSheetViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(WidgetVoiceBottomSheetViewModel$Event$ShowNoVideoPermissionDialog.INSTANCE);
    }

    private final void emitSuppressedDialogEvent() {
        PublishSubject<WidgetVoiceBottomSheetViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(WidgetVoiceBottomSheetViewModel$Event$ShowSuppressedDialog.INSTANCE);
    }

    private final GuildScheduledEvent getGuildScheduledEventToEnd() {
        WidgetVoiceBottomSheetViewModel$StoreState widgetVoiceBottomSheetViewModel$StoreState = this.mostRecentStoreState;
        if (!(widgetVoiceBottomSheetViewModel$StoreState instanceof WidgetVoiceBottomSheetViewModel$StoreState$Valid)) {
            return null;
        }
        WidgetVoiceBottomSheetViewModel$StoreState$Valid widgetVoiceBottomSheetViewModel$StoreState$Valid = (WidgetVoiceBottomSheetViewModel$StoreState$Valid) widgetVoiceBottomSheetViewModel$StoreState;
        return GuildScheduledEventUtilities.Companion.getGuildScheduledEventToEndForCall(widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel(), widgetVoiceBottomSheetViewModel$StoreState$Valid.getMyPermissions(), this.guildsStore);
    }

    @MainThread
    private final void handleStoreState(WidgetVoiceBottomSheetViewModel$StoreState storeState) {
        ModelApplicationStream stream;
        this.mostRecentStoreState = storeState;
        if (storeState instanceof WidgetVoiceBottomSheetViewModel$StoreState$Valid) {
            WidgetVoiceBottomSheetViewModel$StoreState$Valid widgetVoiceBottomSheetViewModel$StoreState$Valid = (WidgetVoiceBottomSheetViewModel$StoreState$Valid) storeState;
            boolean z2 = widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().isConnected() && this.forwardToFullscreenIfVideoActivated && (widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().getIsVideoCall() || widgetVoiceBottomSheetViewModel$StoreState$Valid.getTextInVoiceEnabled());
            if (widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().isConnected() && ChannelUtils.D(widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().getChannel())) {
                this.eventSubject.k.onNext(new WidgetVoiceBottomSheetViewModel$Event$LaunchStageChannel(widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().getChannel().getId()));
            }
            String encodedStreamKey = null;
            if (z2) {
                this.eventSubject.k.onNext(new WidgetVoiceBottomSheetViewModel$Event$LaunchVideoCall(widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().getChannel().getId(), null));
                return;
            }
            Channel channel = widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().getChannel();
            String strC = ChannelUtils.c(channel);
            Guild guild = widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().getGuild();
            String name = guild != null ? guild.getName() : null;
            StoreApplicationStreaming$ActiveApplicationStream activeStream = widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().getActiveStream();
            if (activeStream != null && (stream = activeStream.getStream()) != null) {
                encodedStreamKey = stream.getEncodedStreamKey();
            }
            String str = encodedStreamKey;
            Map<Long, EmbeddedActivity> embeddedActivitiesForChannel = widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().getEmbeddedActivitiesForChannel();
            List<CallParticipantsAdapter$ListItem> listCreateConnectedListItems = ParticipantsListItemGenerator.Companion.createConnectedListItems(widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().getParticipants(), str, channel, widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel(), u.toList(embeddedActivitiesForChannel.values()), widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().getApplications());
            Iterator<Long> it = embeddedActivitiesForChannel.keySet().iterator();
            while (it.hasNext()) {
                this.applicationStore.fetchIfNonexisting(it.next().longValue());
            }
            WidgetVoiceBottomSheet$CenterContent widgetVoiceBottomSheet$CenterContent$ListItems = ParticipantsListItemGenerator.Companion.refreshStreams(listCreateConnectedListItems, this.fetchedPreviews, this.storeApplicationStreamPreviews) ? new WidgetVoiceBottomSheet$CenterContent$ListItems(listCreateConnectedListItems) : new WidgetVoiceBottomSheet$CenterContent$Empty(listCreateConnectedListItems);
            boolean zIsConnected = widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().isConnected();
            this.wasEverConnected = this.wasEverConnected || zIsConnected;
            boolean z3 = widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().getVoiceChannelJoinability() != VoiceChannelJoinability.PERMISSIONS_MISSING;
            Boolean bool = this.wasConnected;
            if (bool != null && !bool.booleanValue() && zIsConnected && widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().isSuppressed()) {
                emitSuppressedDialogEvent();
            }
            this.wasConnected = Boolean.valueOf(zIsConnected);
            this.wasEverMultiParticipant = this.wasEverMultiParticipant || widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().getNumUsersConnected() > 1;
            updateViewState(new WidgetVoiceBottomSheetViewModel$ViewState(strC, name, widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().getChannel(), widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().canInvite() && !ChannelUtils.D(widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().getChannel()), widgetVoiceBottomSheetViewModel$StoreState$Valid.getNoiseCancellation(), widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().isDeafenedByAnySource(), widgetVoiceBottomSheet$CenterContent$ListItems, !zIsConnected ? new WidgetVoiceBottomSheet$BottomContent$Connect(z3) : new WidgetVoiceBottomSheet$BottomContent$Controls(widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().getInputMode(), widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().getAudioManagerState(), widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().isMeMutedByAnySource(), widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().getCameraState(), hasVideoPermission(), widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().isStreaming())));
        }
    }

    private final boolean hasVideoPermission() {
        WidgetVoiceBottomSheetViewModel$StoreState widgetVoiceBottomSheetViewModel$StoreState = this.mostRecentStoreState;
        if (!(widgetVoiceBottomSheetViewModel$StoreState instanceof WidgetVoiceBottomSheetViewModel$StoreState$Valid)) {
            widgetVoiceBottomSheetViewModel$StoreState = null;
        }
        WidgetVoiceBottomSheetViewModel$StoreState$Valid widgetVoiceBottomSheetViewModel$StoreState$Valid = (WidgetVoiceBottomSheetViewModel$StoreState$Valid) widgetVoiceBottomSheetViewModel$StoreState;
        if (widgetVoiceBottomSheetViewModel$StoreState$Valid == null) {
            return false;
        }
        VideoPermissionsManager videoPermissionsManager = this.videoPermissionsManager;
        Channel channel = widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().getChannel();
        Guild guild = widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().getGuild();
        return videoPermissionsManager.hasVideoPermission(channel, guild != null ? guild.getAfkChannelId() : null, widgetVoiceBottomSheetViewModel$StoreState$Valid.getMyPermissions());
    }

    @MainThread
    private final void joinVoiceChannel(long channelId) {
        this.selectedVoiceChannelStore.selectVoiceChannel(channelId);
        PublishSubject<WidgetVoiceBottomSheetViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(WidgetVoiceBottomSheetViewModel$Event$ExpandSheet.INSTANCE);
    }

    public final Observable<WidgetVoiceBottomSheetViewModel$Event> observeEvents() {
        PublishSubject<WidgetVoiceBottomSheetViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onCameraButtonPressed() {
        if (!hasVideoPermission()) {
            emitShowNoVideoPermissionDialogEvent();
            return;
        }
        WidgetVoiceBottomSheet$BottomContent bottomContent = requireViewState().getBottomContent();
        if (!(bottomContent instanceof WidgetVoiceBottomSheet$BottomContent$Controls)) {
            bottomContent = null;
        }
        WidgetVoiceBottomSheet$BottomContent$Controls widgetVoiceBottomSheet$BottomContent$Controls = (WidgetVoiceBottomSheet$BottomContent$Controls) bottomContent;
        CameraState cameraState = widgetVoiceBottomSheet$BottomContent$Controls != null ? widgetVoiceBottomSheet$BottomContent$Controls.getCameraState() : null;
        if (cameraState == CameraState.CAMERA_DISABLED) {
            return;
        }
        if (cameraState == CameraState.CAMERA_ON) {
            this.mediaEngineStore.selectVideoInputDevice(null);
            return;
        }
        WidgetVoiceBottomSheetViewModel$StoreState widgetVoiceBottomSheetViewModel$StoreState = this.mostRecentStoreState;
        WidgetVoiceBottomSheetViewModel$StoreState$Valid widgetVoiceBottomSheetViewModel$StoreState$Valid = (WidgetVoiceBottomSheetViewModel$StoreState$Valid) (widgetVoiceBottomSheetViewModel$StoreState instanceof WidgetVoiceBottomSheetViewModel$StoreState$Valid ? widgetVoiceBottomSheetViewModel$StoreState : null);
        if (widgetVoiceBottomSheetViewModel$StoreState$Valid != null) {
            int numUsersConnected = widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().getNumUsersConnected();
            GuildMaxVideoChannelUsers guildMaxVideoChannelMembers = widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().getGuildMaxVideoChannelMembers();
            if (guildMaxVideoChannelMembers instanceof GuildMaxVideoChannelUsers$Limited) {
                GuildMaxVideoChannelUsers$Limited guildMaxVideoChannelUsers$Limited = (GuildMaxVideoChannelUsers$Limited) guildMaxVideoChannelMembers;
                if (numUsersConnected > guildMaxVideoChannelUsers$Limited.getLimit()) {
                    this.eventSubject.k.onNext(new WidgetVoiceBottomSheetViewModel$Event$ShowCameraCapacityDialog(guildMaxVideoChannelUsers$Limited.getLimit()));
                    return;
                }
            }
            this.eventSubject.k.onNext(WidgetVoiceBottomSheetViewModel$Event$ShowRequestCameraPermissionsDialog.INSTANCE);
        }
    }

    @MainThread
    public final void onCameraPermissionsGranted() {
        StoreMediaEngine.selectDefaultVideoDevice$default(this.mediaEngineStore, null, 1, null);
    }

    @MainThread
    public final void onDeafenPressed() {
        CallModel callModel;
        WidgetVoiceBottomSheetViewModel$StoreState widgetVoiceBottomSheetViewModel$StoreState = this.mostRecentStoreState;
        if (!(widgetVoiceBottomSheetViewModel$StoreState instanceof WidgetVoiceBottomSheetViewModel$StoreState$Valid)) {
            widgetVoiceBottomSheetViewModel$StoreState = null;
        }
        WidgetVoiceBottomSheetViewModel$StoreState$Valid widgetVoiceBottomSheetViewModel$StoreState$Valid = (WidgetVoiceBottomSheetViewModel$StoreState$Valid) widgetVoiceBottomSheetViewModel$StoreState;
        if (widgetVoiceBottomSheetViewModel$StoreState$Valid == null || (callModel = widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel()) == null) {
            return;
        }
        if (callModel.isServerDeafened()) {
            emitServerDeafenedDialogEvent();
            return;
        }
        this.mediaSettingsStore.toggleSelfDeafened();
        this.eventSubject.k.onNext(new WidgetVoiceBottomSheetViewModel$Event$AccessibilityAnnouncement(callModel.isDeafenedByAnySource() ? 2131897172 : 2131897156));
    }

    @MainThread
    public final void onDisconnect() {
        this.selectedVoiceChannelStore.clear();
        this.eventSubject.k.onNext(WidgetVoiceBottomSheetViewModel$Event$Dismiss.INSTANCE);
        WidgetVoiceBottomSheetViewModel$StoreState widgetVoiceBottomSheetViewModel$StoreState = this.mostRecentStoreState;
        if (!(widgetVoiceBottomSheetViewModel$StoreState instanceof WidgetVoiceBottomSheetViewModel$StoreState$Valid)) {
            widgetVoiceBottomSheetViewModel$StoreState = null;
        }
        WidgetVoiceBottomSheetViewModel$StoreState$Valid widgetVoiceBottomSheetViewModel$StoreState$Valid = (WidgetVoiceBottomSheetViewModel$StoreState$Valid) widgetVoiceBottomSheetViewModel$StoreState;
        if (widgetVoiceBottomSheetViewModel$StoreState$Valid == null) {
            return;
        }
        if (!this.wasEverConnected || this.wasEverMultiParticipant) {
            CallModel callModel = widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel();
            RtcConnection$Metadata rtcConnectionMetadata = callModel.getRtcConnectionMetadata();
            this.eventSubject.k.onNext(new WidgetVoiceBottomSheetViewModel$Event$EnqueueCallFeedbackSheet(this.channelId, rtcConnectionMetadata != null ? rtcConnectionMetadata.rtcConnectionId : null, rtcConnectionMetadata != null ? rtcConnectionMetadata.mediaSessionId : null, callModel.getCallDurationMs(this.clock), callModel.getCallFeedbackTriggerRateDenominator()));
        }
    }

    @MainThread
    public final void onDisconnectPressed() {
        GuildScheduledEvent guildScheduledEventToEnd = getGuildScheduledEventToEnd();
        if (guildScheduledEventToEnd == null) {
            onDisconnect();
            return;
        }
        PublishSubject<WidgetVoiceBottomSheetViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new WidgetVoiceBottomSheetViewModel$Event$ShowEventEnd(guildScheduledEventToEnd));
    }

    @MainThread
    public final void onMutePressed() {
        WidgetVoiceBottomSheetViewModel$StoreState widgetVoiceBottomSheetViewModel$StoreState = this.mostRecentStoreState;
        if (!(widgetVoiceBottomSheetViewModel$StoreState instanceof WidgetVoiceBottomSheetViewModel$StoreState$Valid)) {
            widgetVoiceBottomSheetViewModel$StoreState = null;
        }
        WidgetVoiceBottomSheetViewModel$StoreState$Valid widgetVoiceBottomSheetViewModel$StoreState$Valid = (WidgetVoiceBottomSheetViewModel$StoreState$Valid) widgetVoiceBottomSheetViewModel$StoreState;
        if (widgetVoiceBottomSheetViewModel$StoreState$Valid != null) {
            if (widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().isSuppressed()) {
                emitSuppressedDialogEvent();
                return;
            } else if (widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().isMuted()) {
                emitServerMutedDialogEvent();
                return;
            }
        }
        StoreMediaSettings$SelfMuteFailure storeMediaSettings$SelfMuteFailure = this.mediaSettingsStore.toggleSelfMuted();
        if (storeMediaSettings$SelfMuteFailure != null) {
            if (storeMediaSettings$SelfMuteFailure.ordinal() != 0) {
                return;
            }
            this.eventSubject.k.onNext(new WidgetVoiceBottomSheetViewModel$Event$ShowToast(2131897019));
            return;
        }
        WidgetVoiceBottomSheet$BottomContent bottomContent = requireViewState().getBottomContent();
        if (bottomContent == null || !(bottomContent instanceof WidgetVoiceBottomSheet$BottomContent$Controls)) {
            return;
        }
        this.eventSubject.k.onNext(new WidgetVoiceBottomSheetViewModel$Event$AccessibilityAnnouncement(((WidgetVoiceBottomSheet$BottomContent$Controls) bottomContent).isMuted() ? 2131897173 : 2131897169));
    }

    @MainThread
    public final void onNoiseCancellationPressed() {
        Boolean isNoiseCancellationActive = requireViewState().getIsNoiseCancellationActive();
        if (isNoiseCancellationActive != null) {
            boolean zBooleanValue = isNoiseCancellationActive.booleanValue();
            TooltipManager tooltipManager = this.tooltipManager;
            NoiseCancellationTooltip noiseCancellationTooltip = NoiseCancellationTooltip.INSTANCE;
            if (tooltipManager.b(noiseCancellationTooltip, true)) {
                this.tooltipManager.a(noiseCancellationTooltip);
                PublishSubject<WidgetVoiceBottomSheetViewModel$Event> publishSubject = this.eventSubject;
                publishSubject.k.onNext(WidgetVoiceBottomSheetViewModel$Event$ShowNoiseCancellationBottomSheet.INSTANCE);
                return;
            }
            this.mediaSettingsStore.toggleNoiseCancellation();
            if (zBooleanValue) {
                PublishSubject<WidgetVoiceBottomSheetViewModel$Event> publishSubject2 = this.eventSubject;
                publishSubject2.k.onNext(new WidgetVoiceBottomSheetViewModel$Event$ShowToast(2131893295));
            } else {
                PublishSubject<WidgetVoiceBottomSheetViewModel$Event> publishSubject3 = this.eventSubject;
                publishSubject3.k.onNext(new WidgetVoiceBottomSheetViewModel$Event$ShowToast(2131893296));
            }
        }
    }

    @MainThread
    public final void onPttPressed(boolean pressed) {
        this.mediaEngineStore.setPttActive(pressed);
    }

    @MainThread
    public final void onScreenSharePressed() {
        WidgetVoiceBottomSheetViewModel$ViewState viewState = getViewState();
        WidgetVoiceBottomSheet$BottomContent bottomContent = viewState != null ? viewState.getBottomContent() : null;
        WidgetVoiceBottomSheet$BottomContent$Controls widgetVoiceBottomSheet$BottomContent$Controls = (WidgetVoiceBottomSheet$BottomContent$Controls) (bottomContent instanceof WidgetVoiceBottomSheet$BottomContent$Controls ? bottomContent : null);
        if (widgetVoiceBottomSheet$BottomContent$Controls != null) {
            if (widgetVoiceBottomSheet$BottomContent$Controls.isScreensharing()) {
                this.voiceEngineServiceController.stopStream();
            } else if (!hasVideoPermission()) {
                emitShowNoScreenSharePermissionDialogEvent();
            } else {
                this.eventSubject.k.onNext(WidgetVoiceBottomSheetViewModel$Event$RequestStartStream.INSTANCE);
            }
        }
    }

    @MainThread
    public final void onStreamPreviewClicked(String streamKey) {
        m.checkNotNullParameter(streamKey, "streamKey");
        WidgetVoiceBottomSheetViewModel$StoreState widgetVoiceBottomSheetViewModel$StoreState = this.mostRecentStoreState;
        if (!(widgetVoiceBottomSheetViewModel$StoreState instanceof WidgetVoiceBottomSheetViewModel$StoreState$Valid)) {
            widgetVoiceBottomSheetViewModel$StoreState = null;
        }
        WidgetVoiceBottomSheetViewModel$StoreState$Valid widgetVoiceBottomSheetViewModel$StoreState$Valid = (WidgetVoiceBottomSheetViewModel$StoreState$Valid) widgetVoiceBottomSheetViewModel$StoreState;
        if (widgetVoiceBottomSheetViewModel$StoreState$Valid != null) {
            if (widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().getVoiceChannelJoinability() == VoiceChannelJoinability.GUILD_VIDEO_AT_CAPACITY) {
                PublishSubject<WidgetVoiceBottomSheetViewModel$Event> publishSubject = this.eventSubject;
                publishSubject.k.onNext(WidgetVoiceBottomSheetViewModel$Event$ShowGuildVideoAtCapacityDialog.INSTANCE);
            } else {
                ModelApplicationStream modelApplicationStreamDecodeStreamKey = ModelApplicationStream.Companion.decodeStreamKey(streamKey);
                PublishSubject<WidgetVoiceBottomSheetViewModel$Event> publishSubject2 = this.eventSubject;
                publishSubject2.k.onNext(new WidgetVoiceBottomSheetViewModel$Event$LaunchVideoCall(modelApplicationStreamDecodeStreamKey.getChannelId(), streamKey));
            }
        }
    }

    @MainThread
    public final void onToggleRingingPressed(StoreVoiceParticipants$VoiceUser voiceUser) {
        m.checkNotNullParameter(voiceUser, "voiceUser");
        if (voiceUser.isRinging()) {
            this.callsStore.stopRinging(this.channelId, d0.t.m.listOf(Long.valueOf(voiceUser.getUser().getId())));
        } else {
            this.callsStore.ring(this.channelId, d0.t.m.listOf(Long.valueOf(voiceUser.getUser().getId())));
        }
    }

    public final void startStream(Intent intent) {
        m.checkNotNullParameter(intent, "intent");
        this.voiceEngineServiceController.startStream(intent);
    }

    @MainThread
    public final void tryConnectToVoice(boolean useVideo) {
        WidgetVoiceBottomSheetViewModel$StoreState widgetVoiceBottomSheetViewModel$StoreState = this.mostRecentStoreState;
        if (!(widgetVoiceBottomSheetViewModel$StoreState instanceof WidgetVoiceBottomSheetViewModel$StoreState$Valid)) {
            widgetVoiceBottomSheetViewModel$StoreState = null;
        }
        WidgetVoiceBottomSheetViewModel$StoreState$Valid widgetVoiceBottomSheetViewModel$StoreState$Valid = (WidgetVoiceBottomSheetViewModel$StoreState$Valid) widgetVoiceBottomSheetViewModel$StoreState;
        if (widgetVoiceBottomSheetViewModel$StoreState$Valid != null) {
            if (widgetVoiceBottomSheetViewModel$StoreState$Valid.getCallModel().getVoiceChannelJoinability() == VoiceChannelJoinability.GUILD_VIDEO_AT_CAPACITY) {
                this.eventSubject.k.onNext(WidgetVoiceBottomSheetViewModel$Event$ShowGuildVideoAtCapacityDialog.INSTANCE);
                return;
            }
            if (!this.userSettingsStore.getIsMobileOverlayEnabled()) {
                this.eventSubject.k.onNext(WidgetVoiceBottomSheetViewModel$Event$ShowOverlayNux.INSTANCE);
            }
            if (!useVideo) {
                joinVoiceChannel(this.channelId);
            } else if (!hasVideoPermission()) {
                emitShowNoVideoPermissionDialogEvent();
            } else {
                f.H0(ViewModelKt.getViewModelScope(this), null, null, new WidgetVoiceBottomSheetViewModel$tryConnectToVoice$1(this, StoreStream.Companion.getMediaEngine(), null), 3, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceBottomSheetViewModel(long j, boolean z2, StoreChannels storeChannels, StorePermissions storePermissions, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreMediaSettings storeMediaSettings, StoreMediaEngine storeMediaEngine, StoreUserSettings storeUserSettings, StoreCalls storeCalls, StoreGuilds storeGuilds, VideoPermissionsManager videoPermissionsManager, StoreApplicationStreamPreviews storeApplicationStreamPreviews, VoiceEngineServiceController voiceEngineServiceController, Clock clock, TooltipManager tooltipManager, StoreEmbeddedActivities storeEmbeddedActivities, StoreApplication storeApplication, Observable<WidgetVoiceBottomSheetViewModel$StoreState> observable) {
        super(null, 1, null);
        m.checkNotNullParameter(storeChannels, "channelStore");
        m.checkNotNullParameter(storePermissions, "permissionsStore");
        m.checkNotNullParameter(storeVoiceChannelSelected, "selectedVoiceChannelStore");
        m.checkNotNullParameter(storeMediaSettings, "mediaSettingsStore");
        m.checkNotNullParameter(storeMediaEngine, "mediaEngineStore");
        m.checkNotNullParameter(storeUserSettings, "userSettingsStore");
        m.checkNotNullParameter(storeCalls, "callsStore");
        m.checkNotNullParameter(storeGuilds, "guildsStore");
        m.checkNotNullParameter(videoPermissionsManager, "videoPermissionsManager");
        m.checkNotNullParameter(storeApplicationStreamPreviews, "storeApplicationStreamPreviews");
        m.checkNotNullParameter(voiceEngineServiceController, "voiceEngineServiceController");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(tooltipManager, "tooltipManager");
        m.checkNotNullParameter(storeEmbeddedActivities, "embeddedActivitiesStore");
        m.checkNotNullParameter(storeApplication, "applicationStore");
        m.checkNotNullParameter(observable, "storeStateObservable");
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
        this.eventSubject = PublishSubject.k0();
        this.fetchedPreviews = new LinkedHashSet();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetVoiceBottomSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetVoiceBottomSheetViewModel$1(this), 62, (Object) null);
    }
}

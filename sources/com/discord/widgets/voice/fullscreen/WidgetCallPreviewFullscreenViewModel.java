package com.discord.widgets.voice.fullscreen;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.stores.SelectedChannelAnalyticsLocation;
import com.discord.stores.StoreApplication;
import com.discord.stores.StoreApplicationStreamPreviews;
import com.discord.stores.StoreApplicationStreaming$ActiveApplicationStream;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreMentions;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreNavigation$PanelAction;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserSettings;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.voice.VoiceChannelJoinability;
import com.discord.widgets.voice.sheet.CallParticipantsAdapter$ListItem;
import d0.d0.f;
import d0.t.u;
import d0.z.d.m;
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

/* JADX INFO: compiled from: WidgetCallPreviewFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallPreviewFullscreenViewModel extends d0<WidgetCallPreviewFullscreenViewModel$ViewState> {
    public static final WidgetCallPreviewFullscreenViewModel$Companion Companion = new WidgetCallPreviewFullscreenViewModel$Companion(null);
    private final PublishSubject<WidgetCallPreviewFullscreenViewModel$Event> eventSubject;
    private Set<String> fetchedPreviews;
    private final StoreMediaSettings mediaSettingsStore;
    private WidgetCallPreviewFullscreenViewModel$StoreState mostRecentStoreState;
    private final StoreApplication storeApplication;
    private final StoreApplicationStreamPreviews storeApplicationStreamPreviews;
    private final StoreChannels storeChannels;
    private final StoreChannelsSelected storeChannelsSelected;
    private final StoreMentions storeMentions;
    private final StoreNavigation storeNavigation;
    private final StoreUser storeUser;
    private final StoreUserSettings storeUserSettings;
    private final StoreVoiceChannelSelected storeVoiceChannelSelected;
    private long voiceChannelId;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetCallPreviewFullscreenViewModel(long j, StoreChannels storeChannels, StoreMentions storeMentions, StoreNavigation storeNavigation, StoreUserSettings storeUserSettings, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreChannelsSelected storeChannelsSelected, StoreApplicationStreamPreviews storeApplicationStreamPreviews, StoreApplication storeApplication, StoreUser storeUser, Observable observable, StoreMediaSettings storeMediaSettings, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreChannels channels = (i & 2) != 0 ? StoreStream.Companion.getChannels() : storeChannels;
        StoreMentions mentions = (i & 4) != 0 ? StoreStream.Companion.getMentions() : storeMentions;
        StoreNavigation navigation = (i & 8) != 0 ? StoreStream.Companion.getNavigation() : storeNavigation;
        StoreUserSettings userSettings = (i & 16) != 0 ? StoreStream.Companion.getUserSettings() : storeUserSettings;
        StoreVoiceChannelSelected voiceChannelSelected = (i & 32) != 0 ? StoreStream.Companion.getVoiceChannelSelected() : storeVoiceChannelSelected;
        StoreChannelsSelected channelsSelected = (i & 64) != 0 ? StoreStream.Companion.getChannelsSelected() : storeChannelsSelected;
        StoreApplicationStreamPreviews applicationStreamPreviews = (i & 128) != 0 ? StoreStream.Companion.getApplicationStreamPreviews() : storeApplicationStreamPreviews;
        StoreApplication application = (i & 256) != 0 ? StoreStream.Companion.getApplication() : storeApplication;
        StoreUser users = (i & 512) != 0 ? StoreStream.Companion.getUsers() : storeUser;
        this(j, channels, mentions, navigation, userSettings, voiceChannelSelected, channelsSelected, applicationStreamPreviews, application, users, (i & 1024) != 0 ? WidgetCallPreviewFullscreenViewModel$Companion.access$observeStoreState(Companion, j, users, channels, channelsSelected, mentions, voiceChannelSelected) : observable, (i & 2048) != 0 ? StoreStream.Companion.getMediaSettings() : storeMediaSettings);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetCallPreviewFullscreenViewModel widgetCallPreviewFullscreenViewModel, WidgetCallPreviewFullscreenViewModel$StoreState widgetCallPreviewFullscreenViewModel$StoreState) {
        widgetCallPreviewFullscreenViewModel.handleStoreState(widgetCallPreviewFullscreenViewModel$StoreState);
    }

    private final void handleStoreState(WidgetCallPreviewFullscreenViewModel$StoreState storeState) {
        ModelApplicationStream stream;
        if (storeState instanceof WidgetCallPreviewFullscreenViewModel$StoreState$Valid) {
            this.mostRecentStoreState = storeState;
            WidgetCallPreviewFullscreenViewModel$StoreState$Valid widgetCallPreviewFullscreenViewModel$StoreState$Valid = (WidgetCallPreviewFullscreenViewModel$StoreState$Valid) storeState;
            Map<Long, EmbeddedActivity> embeddedActivitiesForChannel = widgetCallPreviewFullscreenViewModel$StoreState$Valid.getCallModel().getEmbeddedActivitiesForChannel();
            StoreApplicationStreaming$ActiveApplicationStream activeStream = widgetCallPreviewFullscreenViewModel$StoreState$Valid.getCallModel().getActiveStream();
            List<CallParticipantsAdapter$ListItem> listCreateConnectedListItems = ParticipantsListItemGenerator.Companion.createConnectedListItems(widgetCallPreviewFullscreenViewModel$StoreState$Valid.getCallModel().getParticipants(), (activeStream == null || (stream = activeStream.getStream()) == null) ? null : stream.getEncodedStreamKey(), widgetCallPreviewFullscreenViewModel$StoreState$Valid.getVoiceChannel(), widgetCallPreviewFullscreenViewModel$StoreState$Valid.getCallModel(), u.toList(embeddedActivitiesForChannel.values()), widgetCallPreviewFullscreenViewModel$StoreState$Valid.getCallModel().getApplications());
            Channel selectedVoiceChannel = widgetCallPreviewFullscreenViewModel$StoreState$Valid.getSelectedVoiceChannel();
            if (selectedVoiceChannel != null) {
                long id2 = selectedVoiceChannel.getId();
                long j = this.voiceChannelId;
                if (id2 == j) {
                    this.eventSubject.k.onNext(new WidgetCallPreviewFullscreenViewModel$Event$LaunchVideoCall(j, null));
                    return;
                }
            }
            Iterator<Long> it = embeddedActivitiesForChannel.keySet().iterator();
            while (it.hasNext()) {
                this.storeApplication.fetchIfNonexisting(it.next().longValue());
            }
            updateViewState(new WidgetCallPreviewFullscreenViewModel$ViewState(widgetCallPreviewFullscreenViewModel$StoreState$Valid.getVoiceChannel(), ChannelUtils.J(widgetCallPreviewFullscreenViewModel$StoreState$Valid.getSelectedTextChannel()), widgetCallPreviewFullscreenViewModel$StoreState$Valid.isTextInVoiceEnabled(), ChannelUtils.c(widgetCallPreviewFullscreenViewModel$StoreState$Valid.getVoiceChannel()), f.coerceAtLeast(widgetCallPreviewFullscreenViewModel$StoreState$Valid.getTotalMentionsCount() - widgetCallPreviewFullscreenViewModel$StoreState$Valid.getChannelMentionsCount(), 0), widgetCallPreviewFullscreenViewModel$StoreState$Valid.getChannelMentionsCount(), widgetCallPreviewFullscreenViewModel$StoreState$Valid.getCallModel().getVoiceChannelJoinability() != VoiceChannelJoinability.PERMISSIONS_MISSING, ParticipantsListItemGenerator.Companion.refreshStreams(listCreateConnectedListItems, this.fetchedPreviews, this.storeApplicationStreamPreviews) ? new WidgetCallPreviewFullscreenViewModel$ParticipantsList$ListItems(listCreateConnectedListItems) : new WidgetCallPreviewFullscreenViewModel$ParticipantsList$Empty(listCreateConnectedListItems), widgetCallPreviewFullscreenViewModel$StoreState$Valid.isNsfwUnconsented(), widgetCallPreviewFullscreenViewModel$StoreState$Valid.isChannelNsfw(), widgetCallPreviewFullscreenViewModel$StoreState$Valid.getNsfwAllowed()));
        }
    }

    @MainThread
    private final void joinVoiceChannel(long channelId) {
        this.storeVoiceChannelSelected.selectVoiceChannel(channelId);
        PublishSubject<WidgetCallPreviewFullscreenViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new WidgetCallPreviewFullscreenViewModel$Event$LaunchVideoCall(this.voiceChannelId, null));
    }

    public static /* synthetic */ void tryConnectToVoice$default(WidgetCallPreviewFullscreenViewModel widgetCallPreviewFullscreenViewModel, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        widgetCallPreviewFullscreenViewModel.tryConnectToVoice(z2);
    }

    public final Observable<WidgetCallPreviewFullscreenViewModel$Event> observeEvents() {
        PublishSubject<WidgetCallPreviewFullscreenViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onStreamPreviewClicked(String streamKey) {
        m.checkNotNullParameter(streamKey, "streamKey");
        WidgetCallPreviewFullscreenViewModel$StoreState widgetCallPreviewFullscreenViewModel$StoreState = this.mostRecentStoreState;
        if (!(widgetCallPreviewFullscreenViewModel$StoreState instanceof WidgetCallPreviewFullscreenViewModel$StoreState$Valid)) {
            widgetCallPreviewFullscreenViewModel$StoreState = null;
        }
        WidgetCallPreviewFullscreenViewModel$StoreState$Valid widgetCallPreviewFullscreenViewModel$StoreState$Valid = (WidgetCallPreviewFullscreenViewModel$StoreState$Valid) widgetCallPreviewFullscreenViewModel$StoreState;
        if (widgetCallPreviewFullscreenViewModel$StoreState$Valid != null) {
            if (widgetCallPreviewFullscreenViewModel$StoreState$Valid.getCallModel().getVoiceChannelJoinability() == VoiceChannelJoinability.GUILD_VIDEO_AT_CAPACITY) {
                PublishSubject<WidgetCallPreviewFullscreenViewModel$Event> publishSubject = this.eventSubject;
                publishSubject.k.onNext(WidgetCallPreviewFullscreenViewModel$Event$ShowGuildVideoAtCapacityDialog.INSTANCE);
            } else {
                ModelApplicationStream modelApplicationStreamDecodeStreamKey = ModelApplicationStream.Companion.decodeStreamKey(streamKey);
                PublishSubject<WidgetCallPreviewFullscreenViewModel$Event> publishSubject2 = this.eventSubject;
                publishSubject2.k.onNext(new WidgetCallPreviewFullscreenViewModel$Event$LaunchVideoCall(modelApplicationStreamDecodeStreamKey.getChannelId(), streamKey));
            }
        }
    }

    @MainThread
    public final void onTextInVoiceTapped() {
        ChannelSelector channelSelector$Companion = ChannelSelector.Companion.getInstance();
        WidgetCallPreviewFullscreenViewModel$ViewState viewState = getViewState();
        ChannelSelector.selectChannel$default(channelSelector$Companion, viewState != null ? viewState.getVoiceChannel() : null, null, SelectedChannelAnalyticsLocation.TEXT_IN_VOICE, 2, null);
        StoreNavigation.setNavigationPanelAction$default(this.storeNavigation, StoreNavigation$PanelAction.CLOSE, null, 2, null);
    }

    public final void selectTextChannelAfterFinish() {
        Channel voiceChannel;
        WidgetCallPreviewFullscreenViewModel$ViewState viewState = getViewState();
        if (viewState == null || (voiceChannel = viewState.getVoiceChannel()) == null) {
            return;
        }
        long guildId = voiceChannel.getGuildId();
        if (viewState.isTextInVoiceChannelSelected()) {
            ChannelSelector.Companion.getInstance().selectPreviousChannel(guildId);
        }
    }

    @MainThread
    public final void tryConnectToVoice(boolean muted) {
        WidgetCallPreviewFullscreenViewModel$StoreState widgetCallPreviewFullscreenViewModel$StoreState = this.mostRecentStoreState;
        if (widgetCallPreviewFullscreenViewModel$StoreState instanceof WidgetCallPreviewFullscreenViewModel$StoreState$Valid) {
            if (((WidgetCallPreviewFullscreenViewModel$StoreState$Valid) widgetCallPreviewFullscreenViewModel$StoreState).getCallModel().getVoiceChannelJoinability() == VoiceChannelJoinability.GUILD_VIDEO_AT_CAPACITY) {
                this.eventSubject.k.onNext(WidgetCallPreviewFullscreenViewModel$Event$ShowGuildVideoAtCapacityDialog.INSTANCE);
                return;
            }
            if (!this.storeUserSettings.getIsMobileOverlayEnabled()) {
                this.eventSubject.k.onNext(WidgetCallPreviewFullscreenViewModel$Event$ShowOverlayNux.INSTANCE);
            }
            if (muted) {
                this.mediaSettingsStore.setSelfMuted(true);
            }
            joinVoiceChannel(this.voiceChannelId);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallPreviewFullscreenViewModel(long j, StoreChannels storeChannels, StoreMentions storeMentions, StoreNavigation storeNavigation, StoreUserSettings storeUserSettings, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreChannelsSelected storeChannelsSelected, StoreApplicationStreamPreviews storeApplicationStreamPreviews, StoreApplication storeApplication, StoreUser storeUser, Observable<WidgetCallPreviewFullscreenViewModel$StoreState> observable, StoreMediaSettings storeMediaSettings) {
        super(null, 1, null);
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storeMentions, "storeMentions");
        m.checkNotNullParameter(storeNavigation, "storeNavigation");
        m.checkNotNullParameter(storeUserSettings, "storeUserSettings");
        m.checkNotNullParameter(storeVoiceChannelSelected, "storeVoiceChannelSelected");
        m.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        m.checkNotNullParameter(storeApplicationStreamPreviews, "storeApplicationStreamPreviews");
        m.checkNotNullParameter(storeApplication, "storeApplication");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(observable, "storeStateObservable");
        m.checkNotNullParameter(storeMediaSettings, "mediaSettingsStore");
        this.voiceChannelId = j;
        this.storeChannels = storeChannels;
        this.storeMentions = storeMentions;
        this.storeNavigation = storeNavigation;
        this.storeUserSettings = storeUserSettings;
        this.storeVoiceChannelSelected = storeVoiceChannelSelected;
        this.storeChannelsSelected = storeChannelsSelected;
        this.storeApplicationStreamPreviews = storeApplicationStreamPreviews;
        this.storeApplication = storeApplication;
        this.storeUser = storeUser;
        this.mediaSettingsStore = storeMediaSettings;
        this.eventSubject = PublishSubject.k0();
        this.fetchedPreviews = new LinkedHashSet();
        Observable observableR = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null).r();
        m.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, WidgetCallPreviewFullscreenViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetCallPreviewFullscreenViewModel$1(this), 62, (Object) null);
    }
}

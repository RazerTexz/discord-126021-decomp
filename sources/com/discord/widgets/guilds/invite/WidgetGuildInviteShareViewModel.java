package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.res.Resources;
import b.a.d.d0;
import com.discord.BuildConfig;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelInvite;
import com.discord.models.domain.ModelInvite$Settings;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreMessages;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableCombineLatestOverloadsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.h0;
import d0.z.d.m;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetGuildInviteShareViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareViewModel extends d0<WidgetGuildInviteShareViewModel$ViewState> implements AppComponent {
    private final Long eventId;
    private final BehaviorSubject<String> filterPublisher;
    private final long guildId;
    private final InviteGenerator inviteGenerator;
    private final String inviteStoreKey;
    private final InviteSuggestionsManager inviteSuggestionsManager;
    private final BehaviorSubject<Unit> refreshUiSubject;
    private final Resources resources;
    private final BehaviorSubject<Long> selectedChannelSubject;
    private final BehaviorSubject<Map<String, Set<Long>>> sentInvitesSubject;
    private final StoreChannels storeChannels;
    private final StoreGuildScheduledEvents storeGuildScheduledEvents;
    private final StoreGuilds storeGuilds;
    private final StoreInstantInvites storeInstantInvites;
    private final StoreInviteSettings storeInviteSettings;
    private final StoreStageInstances storeStageInstances;
    private final StoreUser storeUser;
    private final boolean subscribeOnInit;

    public /* synthetic */ WidgetGuildInviteShareViewModel(StoreChannels storeChannels, StoreGuilds storeGuilds, StoreInviteSettings storeInviteSettings, StoreUser storeUser, StoreStageInstances storeStageInstances, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreInstantInvites storeInstantInvites, InviteGenerator inviteGenerator, InviteSuggestionsManager inviteSuggestionsManager, Resources resources, boolean z2, long j, Long l, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.Companion.getChannels() : storeChannels, (i & 2) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds, (i & 4) != 0 ? StoreStream.Companion.getInviteSettings() : storeInviteSettings, (i & 8) != 0 ? StoreStream.Companion.getUsers() : storeUser, (i & 16) != 0 ? StoreStream.Companion.getStageInstances() : storeStageInstances, (i & 32) != 0 ? StoreStream.Companion.getGuildScheduledEvents() : storeGuildScheduledEvents, (i & 64) != 0 ? StoreStream.Companion.getInstantInvites() : storeInstantInvites, (i & 128) != 0 ? new InviteGenerator() : inviteGenerator, (i & 256) != 0 ? new InviteSuggestionsManager(null, null, null, null, null, 31, null) : inviteSuggestionsManager, resources, (i & 1024) != 0 ? true : z2, j, l, str);
    }

    public static final /* synthetic */ void access$generateInviteLinkFromViewState(WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel, WidgetGuildInviteShareViewModel$ViewState$Loaded widgetGuildInviteShareViewModel$ViewState$Loaded) {
        widgetGuildInviteShareViewModel.generateInviteLinkFromViewState(widgetGuildInviteShareViewModel$ViewState$Loaded);
    }

    public static final /* synthetic */ String access$getInviteLink$p(WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel, ModelInvite modelInvite) {
        return widgetGuildInviteShareViewModel.getInviteLink(modelInvite);
    }

    public static final /* synthetic */ void access$updateSentInvites(WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel, Map map) {
        widgetGuildInviteShareViewModel.updateSentInvites(map);
    }

    public static final /* synthetic */ void access$updateViewState(WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel, WidgetGuildInviteShareViewModel$ViewState widgetGuildInviteShareViewModel$ViewState) {
        widgetGuildInviteShareViewModel.updateViewState(widgetGuildInviteShareViewModel$ViewState);
    }

    private final void generateInviteLinkFromViewState(WidgetGuildInviteShareViewModel$ViewState$Loaded viewState) {
        WidgetInviteModel widgetInviteModel = viewState.getWidgetInviteModel();
        if (widgetInviteModel.isValidInvite() || widgetInviteModel.isGeneratingInvite() || widgetInviteModel.getTargetChannel() == null) {
            return;
        }
        this.inviteGenerator.generateForAppComponent(this, widgetInviteModel.getTargetChannel().getId());
    }

    private final String getInviteLink(ModelInvite modelInvite) {
        return modelInvite == null ? BuildConfig.HOST_INVITE : modelInvite.toLink(this.resources, BuildConfig.HOST_INVITE);
    }

    private final Observable<WidgetInviteModel> observeWidgetInviteViewModel(long guildId, Long eventId, String inviteStoreKey) {
        Observable<WidgetInviteModel> observableR = ObservableExtensionsKt.computationLatest(ObservableCombineLatestOverloadsKt.combineLatest(this.storeInviteSettings.getInviteSettings(), this.storeInviteSettings.getInvitableChannels(guildId), this.inviteGenerator.getGenerationState(), this.selectedChannelSubject, StoreUser.observeMe$default(this.storeUser, false, 1, null), this.storeChannels.observeDMs(), this.storeGuilds.observeGuild(guildId), this.storeStageInstances.observeStageInstancesForGuild(guildId), this.storeGuildScheduledEvents.observeGuildScheduledEvent(eventId, Long.valueOf(guildId)), this.storeInstantInvites.observeInvite(inviteStoreKey), WidgetGuildInviteShareViewModel$observeWidgetInviteViewModel$1.INSTANCE)).r();
        m.checkNotNullExpressionValue(observableR, "combineLatest(\n        s…  .distinctUntilChanged()");
        return observableR;
    }

    private final void updateSentInvites(Map<String, ? extends Set<Long>> sentInvites) {
        this.sentInvitesSubject.onNext(sentInvites);
    }

    public final void generateInviteLink(long channelId) {
        this.inviteGenerator.generateForAppComponent(this, channelId);
    }

    public final Experiment getDefaultInviteExperiment() {
        return this.storeInviteSettings.getInviteGuildExperiment(this.guildId, true);
    }

    public final Long getEventId() {
        return this.eventId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final InviteGenerator getInviteGenerator() {
        return this.inviteGenerator;
    }

    public final String getInviteStoreKey() {
        return this.inviteStoreKey;
    }

    public final InviteSuggestionsManager getInviteSuggestionsManager() {
        return this.inviteSuggestionsManager;
    }

    public final Resources getResources() {
        return this.resources;
    }

    public final StoreChannels getStoreChannels() {
        return this.storeChannels;
    }

    public final StoreGuildScheduledEvents getStoreGuildScheduledEvents() {
        return this.storeGuildScheduledEvents;
    }

    public final StoreGuilds getStoreGuilds() {
        return this.storeGuilds;
    }

    public final StoreInstantInvites getStoreInstantInvites() {
        return this.storeInstantInvites;
    }

    public final StoreInviteSettings getStoreInviteSettings() {
        return this.storeInviteSettings;
    }

    public final StoreStageInstances getStoreStageInstances() {
        return this.storeStageInstances;
    }

    public final StoreUser getStoreUser() {
        return this.storeUser;
    }

    public final boolean getSubscribeOnInit() {
        return this.subscribeOnInit;
    }

    public final Observable<WidgetGuildInviteShareViewModel$ViewState$Loaded> observeViewStateFromStores$app_productionGoogleRelease(long guildId, Long eventId, String inviteStoreKey) {
        Observable<WidgetGuildInviteShareViewModel$ViewState$Loaded> observableG = Observable.g(observeWidgetInviteViewModel(guildId, eventId, inviteStoreKey), this.inviteSuggestionsManager.observeInviteSuggestions(), this.filterPublisher, this.sentInvitesSubject, this.refreshUiSubject, new WidgetGuildInviteShareViewModel$observeViewStateFromStores$1(this));
        m.checkNotNullExpressionValue(observableG, "Observable.combineLatest…iteSettings\n      )\n    }");
        return observableG;
    }

    public final void refreshUi() {
        this.refreshUiSubject.onNext(Unit.a);
    }

    public final void selectChannel(long channelId) {
        this.selectedChannelSubject.onNext(Long.valueOf(channelId));
    }

    public final void sendInviteToChannel(long channelId, WidgetGuildInviteShareViewModel$ViewState$Loaded viewState, ModelInvite invite) {
        m.checkNotNullParameter(viewState, "viewState");
        String inviteLink = getInviteLink(invite);
        StoreMessages messages = StoreStream.Companion.getMessages();
        MeUser me2 = viewState.getWidgetInviteModel().getMe();
        m.checkNotNullExpressionValue(inviteLink, "inviteLink");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreMessages.sendMessage$default(messages, channelId, me2, inviteLink, null, null, null, null, null, null, null, null, null, null, null, null, 32736, null), this, null, 2, null), WidgetGuildInviteShareViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildInviteShareViewModel$sendInviteToChannel$1(this, invite, viewState, inviteLink), 62, (Object) null);
    }

    public final void sendInviteToUser(long userId, WidgetGuildInviteShareViewModel$ViewState$Loaded viewState, ModelInvite invite) {
        m.checkNotNullParameter(viewState, "viewState");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().createOrFetchDM(userId), false, 1, null), this, null, 2, null), WidgetGuildInviteShareViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildInviteShareViewModel$sendInviteToUser$1(this, viewState, invite), 62, (Object) null);
    }

    public final void updateInviteSettings(ModelInvite$Settings settings) {
        m.checkNotNullParameter(settings, "settings");
        this.storeInviteSettings.setInviteSettings(settings);
    }

    public final void updateSearchQuery(String searchQuery) {
        m.checkNotNullParameter(searchQuery, "searchQuery");
        this.filterPublisher.onNext(searchQuery);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInviteShareViewModel(StoreChannels storeChannels, StoreGuilds storeGuilds, StoreInviteSettings storeInviteSettings, StoreUser storeUser, StoreStageInstances storeStageInstances, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreInstantInvites storeInstantInvites, InviteGenerator inviteGenerator, InviteSuggestionsManager inviteSuggestionsManager, Resources resources, boolean z2, long j, Long l, String str) {
        super(WidgetGuildInviteShareViewModel$ViewState$Uninitialized.INSTANCE);
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeInviteSettings, "storeInviteSettings");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(storeStageInstances, "storeStageInstances");
        m.checkNotNullParameter(storeGuildScheduledEvents, "storeGuildScheduledEvents");
        m.checkNotNullParameter(storeInstantInvites, "storeInstantInvites");
        m.checkNotNullParameter(inviteGenerator, "inviteGenerator");
        m.checkNotNullParameter(inviteSuggestionsManager, "inviteSuggestionsManager");
        m.checkNotNullParameter(resources, "resources");
        this.storeChannels = storeChannels;
        this.storeGuilds = storeGuilds;
        this.storeInviteSettings = storeInviteSettings;
        this.storeUser = storeUser;
        this.storeStageInstances = storeStageInstances;
        this.storeGuildScheduledEvents = storeGuildScheduledEvents;
        this.storeInstantInvites = storeInstantInvites;
        this.inviteGenerator = inviteGenerator;
        this.inviteSuggestionsManager = inviteSuggestionsManager;
        this.resources = resources;
        this.subscribeOnInit = z2;
        this.guildId = j;
        this.eventId = l;
        this.inviteStoreKey = str;
        BehaviorSubject<Map<String, Set<Long>>> behaviorSubjectL0 = BehaviorSubject.l0(h0.emptyMap());
        m.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(emptyMap())");
        this.sentInvitesSubject = behaviorSubjectL0;
        this.filterPublisher = BehaviorSubject.l0("");
        BehaviorSubject<Long> behaviorSubjectL1 = BehaviorSubject.l0(null);
        m.checkNotNullExpressionValue(behaviorSubjectL1, "BehaviorSubject.create(null as ChannelId?)");
        this.selectedChannelSubject = behaviorSubjectL1;
        BehaviorSubject<Unit> behaviorSubjectL2 = BehaviorSubject.l0(Unit.a);
        m.checkNotNullExpressionValue(behaviorSubjectL2, "BehaviorSubject.create(Unit)");
        this.refreshUiSubject = behaviorSubjectL2;
        if (z2) {
            Observable<WidgetGuildInviteShareViewModel$ViewState$Loaded> observableU = observeViewStateFromStores$app_productionGoogleRelease(j, l, str).u(new WidgetGuildInviteShareViewModel$1(this));
            m.checkNotNullExpressionValue(observableU, "observeViewStateFromStor…romViewState(viewState) }");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationBuffered(observableU), this, null, 2, null), WidgetGuildInviteShareViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildInviteShareViewModel$2(this), 62, (Object) null);
        }
    }
}

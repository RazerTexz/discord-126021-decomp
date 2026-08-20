package com.discord.widgets.guilds.invite;

import android.content.res.Resources;
import com.discord.BuildConfig;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.stageinstance.StageInstance;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelInvite;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreMessages;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.messagesend.MessageResult;
import com.discord.utilities.p501rx.ObservableCombineLatestOverloadsKt;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12150o0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Func5;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetGuildInviteShareViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareViewModel extends AbstractC0859d0<ViewState> implements AppComponent {
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

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel$2 */
    /* JADX INFO: compiled from: WidgetGuildInviteShareViewModel.kt */
    public static final /* synthetic */ class C87082 extends C12236k implements Function1<ViewState, Unit> {
        public C87082(WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel) {
            super(1, widgetGuildInviteShareViewModel, WidgetGuildInviteShareViewModel.class, "updateViewState", "updateViewState(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetGuildInviteShareViewModel) this.receiver).updateViewState(viewState);
        }
    }

    /* JADX INFO: compiled from: WidgetGuildInviteShareViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetGuildInviteShareViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final List<InviteSuggestionItem> inviteSuggestionItems;
            private final String searchQuery;
            private final Map<String, Set<Long>> sentInvites;
            private final boolean showInviteSettings;
            private final WidgetInviteModel widgetInviteModel;

            public /* synthetic */ Loaded(WidgetInviteModel widgetInviteModel, List list, String str, Map map, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(widgetInviteModel, list, (i & 4) != 0 ? "" : str, map, (i & 16) != 0 ? true : z2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, WidgetInviteModel widgetInviteModel, List list, String str, Map map, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    widgetInviteModel = loaded.widgetInviteModel;
                }
                if ((i & 2) != 0) {
                    list = loaded.inviteSuggestionItems;
                }
                List list2 = list;
                if ((i & 4) != 0) {
                    str = loaded.searchQuery;
                }
                String str2 = str;
                if ((i & 8) != 0) {
                    map = loaded.sentInvites;
                }
                Map map2 = map;
                if ((i & 16) != 0) {
                    z2 = loaded.showInviteSettings;
                }
                return loaded.copy(widgetInviteModel, list2, str2, map2, z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final WidgetInviteModel getWidgetInviteModel() {
                return this.widgetInviteModel;
            }

            public final List<InviteSuggestionItem> component2() {
                return this.inviteSuggestionItems;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getSearchQuery() {
                return this.searchQuery;
            }

            public final Map<String, Set<Long>> component4() {
                return this.sentInvites;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final boolean getShowInviteSettings() {
                return this.showInviteSettings;
            }

            public final Loaded copy(WidgetInviteModel widgetInviteModel, List<? extends InviteSuggestionItem> inviteSuggestionItems, String searchQuery, Map<String, ? extends Set<Long>> sentInvites, boolean showInviteSettings) {
                C12238m.checkNotNullParameter(widgetInviteModel, "widgetInviteModel");
                C12238m.checkNotNullParameter(inviteSuggestionItems, "inviteSuggestionItems");
                C12238m.checkNotNullParameter(searchQuery, "searchQuery");
                C12238m.checkNotNullParameter(sentInvites, "sentInvites");
                return new Loaded(widgetInviteModel, inviteSuggestionItems, searchQuery, sentInvites, showInviteSettings);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return C12238m.areEqual(this.widgetInviteModel, loaded.widgetInviteModel) && C12238m.areEqual(this.inviteSuggestionItems, loaded.inviteSuggestionItems) && C12238m.areEqual(this.searchQuery, loaded.searchQuery) && C12238m.areEqual(this.sentInvites, loaded.sentInvites) && this.showInviteSettings == loaded.showInviteSettings;
            }

            public final List<InviteSuggestionItem> getInviteSuggestionItems() {
                return this.inviteSuggestionItems;
            }

            public final String getSearchQuery() {
                return this.searchQuery;
            }

            public final Map<String, Set<Long>> getSentInvites() {
                return this.sentInvites;
            }

            public final boolean getShowInviteSettings() {
                return this.showInviteSettings;
            }

            public final WidgetInviteModel getWidgetInviteModel() {
                return this.widgetInviteModel;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v10, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v4 */
            /* JADX WARN: Type inference failed for: r1v6 */
            public int hashCode() {
                WidgetInviteModel widgetInviteModel = this.widgetInviteModel;
                int iHashCode = (widgetInviteModel != null ? widgetInviteModel.hashCode() : 0) * 31;
                List<InviteSuggestionItem> list = this.inviteSuggestionItems;
                int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
                String str = this.searchQuery;
                int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
                Map<String, Set<Long>> map = this.sentInvites;
                int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
                boolean z2 = this.showInviteSettings;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                return iHashCode4 + r1;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(widgetInviteModel=");
                sbM833U.append(this.widgetInviteModel);
                sbM833U.append(", inviteSuggestionItems=");
                sbM833U.append(this.inviteSuggestionItems);
                sbM833U.append(", searchQuery=");
                sbM833U.append(this.searchQuery);
                sbM833U.append(", sentInvites=");
                sbM833U.append(this.sentInvites);
                sbM833U.append(", showInviteSettings=");
                return C1643a.m827O(sbM833U, this.showInviteSettings, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(WidgetInviteModel widgetInviteModel, List<? extends InviteSuggestionItem> list, String str, Map<String, ? extends Set<Long>> map, boolean z2) {
                super(null);
                C12238m.checkNotNullParameter(widgetInviteModel, "widgetInviteModel");
                C12238m.checkNotNullParameter(list, "inviteSuggestionItems");
                C12238m.checkNotNullParameter(str, "searchQuery");
                C12238m.checkNotNullParameter(map, "sentInvites");
                this.widgetInviteModel = widgetInviteModel;
                this.inviteSuggestionItems = list;
                this.searchQuery = str;
                this.sentInvites = map;
                this.showInviteSettings = z2;
            }
        }

        /* JADX INFO: compiled from: WidgetGuildInviteShareViewModel.kt */
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel$observeWidgetInviteViewModel$1 */
    /* JADX INFO: compiled from: WidgetGuildInviteShareViewModel.kt */
    public static final class C87091 extends AbstractC12240o implements Function10<ModelInvite.Settings, Map<Long, ? extends Channel>, InviteGenerator.InviteGenerationState, Long, MeUser, List<? extends Channel>, Guild, Map<Long, ? extends StageInstance>, GuildScheduledEvent, StoreInstantInvites.InviteState, WidgetInviteModel> {
        public static final C87091 INSTANCE = new C87091();

        public C87091() {
            super(10);
        }

        @Override // kotlin.jvm.functions.Function10
        public /* bridge */ /* synthetic */ WidgetInviteModel invoke(ModelInvite.Settings settings, Map<Long, ? extends Channel> map, InviteGenerator.InviteGenerationState inviteGenerationState, Long l, MeUser meUser, List<? extends Channel> list, Guild guild, Map<Long, ? extends StageInstance> map2, GuildScheduledEvent guildScheduledEvent, StoreInstantInvites.InviteState inviteState) {
            return invoke2(settings, (Map<Long, Channel>) map, inviteGenerationState, l, meUser, (List<Channel>) list, guild, (Map<Long, StageInstance>) map2, guildScheduledEvent, inviteState);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final WidgetInviteModel invoke2(ModelInvite.Settings settings, Map<Long, Channel> map, InviteGenerator.InviteGenerationState inviteGenerationState, Long l, MeUser meUser, List<Channel> list, Guild guild, Map<Long, StageInstance> map2, GuildScheduledEvent guildScheduledEvent, StoreInstantInvites.InviteState inviteState) {
            StoreInstantInvites.InviteState inviteState2 = inviteState;
            C12238m.checkNotNullParameter(settings, "settings");
            C12238m.checkNotNullParameter(map, "invitableChannels");
            C12238m.checkNotNullParameter(inviteGenerationState, "inviteGenerationState");
            C12238m.checkNotNullParameter(meUser, "me");
            C12238m.checkNotNullParameter(list, "dms");
            C12238m.checkNotNullParameter(map2, "guildStageInstances");
            C12238m.checkNotNullParameter(inviteState2, "storeInvite");
            WidgetInviteModel.Companion companion = WidgetInviteModel.INSTANCE;
            if (!(inviteState2 instanceof StoreInstantInvites.InviteState.Resolved)) {
                inviteState2 = null;
            }
            StoreInstantInvites.InviteState.Resolved resolved = (StoreInstantInvites.InviteState.Resolved) inviteState2;
            return companion.create(settings, map, inviteGenerationState, l, meUser, list, guild, map2, guildScheduledEvent, resolved != null ? resolved.getInvite() : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel$sendInviteToChannel$1 */
    /* JADX INFO: compiled from: WidgetGuildInviteShareViewModel.kt */
    public static final class C87101 extends AbstractC12240o implements Function1<MessageResult, Unit> {
        public final /* synthetic */ ModelInvite $invite;
        public final /* synthetic */ String $inviteLink;
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C87101(ModelInvite modelInvite, ViewState.Loaded loaded, String str) {
            super(1);
            this.$invite = modelInvite;
            this.$viewState = loaded;
            this.$inviteLink = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MessageResult messageResult) {
            invoke2(messageResult);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MessageResult messageResult) {
            C12238m.checkNotNullParameter(messageResult, "result");
            if (messageResult instanceof MessageResult.Success) {
                MessageResult.Success success = (MessageResult.Success) messageResult;
                StoreStream.INSTANCE.getAnalytics().inviteSent(this.$invite, success.getMessage(), "Guild Create Invite Suggestion");
                Map<String, Set<Long>> sentInvites = this.$viewState.getSentInvites();
                String str = this.$inviteLink;
                C12238m.checkNotNullExpressionValue(str, "inviteLink");
                Set<Long> setEmptySet = sentInvites.get(str);
                if (setEmptySet == null) {
                    setEmptySet = C12148n0.emptySet();
                }
                WidgetGuildInviteShareViewModel.this.updateSentInvites(C12136h0.plus(sentInvites, C12134g0.mapOf(C12116o.m10073to(this.$inviteLink, C12150o0.plus(setEmptySet, Long.valueOf(success.getMessage().getChannelId()))))));
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel$sendInviteToUser$1 */
    /* JADX INFO: compiled from: WidgetGuildInviteShareViewModel.kt */
    public static final class C87111 extends AbstractC12240o implements Function1<Channel, Unit> {
        public final /* synthetic */ ModelInvite $invite;
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C87111(ViewState.Loaded loaded, ModelInvite modelInvite) {
            super(1);
            this.$viewState = loaded;
            this.$invite = modelInvite;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            C12238m.checkNotNullParameter(channel, "channel");
            WidgetGuildInviteShareViewModel.this.sendInviteToChannel(channel.getId(), this.$viewState, this.$invite);
        }
    }

    public /* synthetic */ WidgetGuildInviteShareViewModel(StoreChannels storeChannels, StoreGuilds storeGuilds, StoreInviteSettings storeInviteSettings, StoreUser storeUser, StoreStageInstances storeStageInstances, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreInstantInvites storeInstantInvites, InviteGenerator inviteGenerator, InviteSuggestionsManager inviteSuggestionsManager, Resources resources, boolean z2, long j, Long l, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 4) != 0 ? StoreStream.INSTANCE.getInviteSettings() : storeInviteSettings, (i & 8) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 16) != 0 ? StoreStream.INSTANCE.getStageInstances() : storeStageInstances, (i & 32) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents, (i & 64) != 0 ? StoreStream.INSTANCE.getInstantInvites() : storeInstantInvites, (i & 128) != 0 ? new InviteGenerator() : inviteGenerator, (i & 256) != 0 ? new InviteSuggestionsManager(null, null, null, null, null, 31, null) : inviteSuggestionsManager, resources, (i & 1024) != 0 ? true : z2, j, l, str);
    }

    private final void generateInviteLinkFromViewState(ViewState.Loaded viewState) {
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
        Observable<WidgetInviteModel> observableM11112r = ObservableExtensionsKt.computationLatest(ObservableCombineLatestOverloadsKt.combineLatest(this.storeInviteSettings.getInviteSettings(), this.storeInviteSettings.getInvitableChannels(guildId), this.inviteGenerator.getGenerationState(), this.selectedChannelSubject, StoreUser.observeMe$default(this.storeUser, false, 1, null), this.storeChannels.observeDMs(), this.storeGuilds.observeGuild(guildId), this.storeStageInstances.observeStageInstancesForGuild(guildId), this.storeGuildScheduledEvents.observeGuildScheduledEvent(eventId, Long.valueOf(guildId)), this.storeInstantInvites.observeInvite(inviteStoreKey), C87091.INSTANCE)).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "combineLatest(\n        s…  .distinctUntilChanged()");
        return observableM11112r;
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

    public final Observable<ViewState.Loaded> observeViewStateFromStores$app_productionGoogleRelease(long guildId, Long eventId, String inviteStoreKey) {
        Observable<ViewState.Loaded> observableM11072g = Observable.m11072g(observeWidgetInviteViewModel(guildId, eventId, inviteStoreKey), this.inviteSuggestionsManager.observeInviteSuggestions(), this.filterPublisher, this.sentInvitesSubject, this.refreshUiSubject, new Func5<WidgetInviteModel, List<? extends InviteSuggestion>, String, Map<String, ? extends Set<? extends Long>>, Unit, ViewState.Loaded>() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel$observeViewStateFromStores$1
            @Override // p658rx.functions.Func5
            public /* bridge */ /* synthetic */ WidgetGuildInviteShareViewModel.ViewState.Loaded call(WidgetInviteModel widgetInviteModel, List<? extends InviteSuggestion> list, String str, Map<String, ? extends Set<? extends Long>> map, Unit unit) {
                return call2(widgetInviteModel, list, str, (Map<String, ? extends Set<Long>>) map, unit);
            }

            /* JADX WARN: Code duplicated, block: B:49:0x00e0  */
            /* JADX WARN: Code duplicated, block: B:52:0x00f3  */
            /* JADX WARN: Code duplicated, block: B:54:0x00fd  */
            /* JADX WARN: Code duplicated, block: B:55:0x0119  */
            /* JADX WARN: Code duplicated, block: B:57:0x011d  */
            /* JADX WARN: Code duplicated, block: B:77:0x0140 A[SYNTHETIC] */
            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final WidgetGuildInviteShareViewModel.ViewState.Loaded call2(WidgetInviteModel widgetInviteModel, List<? extends InviteSuggestion> list, String str, Map<String, ? extends Set<Long>> map, Unit unit) {
                boolean zContains;
                ArrayList arrayList;
                List listListOf;
                InviteSuggestionItem userItem;
                boolean z2;
                C12238m.checkNotNullExpressionValue(map, "sentInvites");
                String inviteLink = this.this$0.getInviteLink(widgetInviteModel.getInvite());
                C12238m.checkNotNullExpressionValue(inviteLink, "widgetInviteModel.invite.inviteLink");
                Set<Long> setEmptySet = map.get(inviteLink);
                if (setEmptySet == null) {
                    setEmptySet = C12148n0.emptySet();
                }
                Set<Long> set = setEmptySet;
                boolean z3 = false;
                if (str == null || C12103t.isBlank(str)) {
                    C12238m.checkNotNullExpressionValue(list, "inviteSuggestions");
                } else {
                    ArrayList arrayListM840a0 = C1643a.m840a0(list, "inviteSuggestions");
                    for (Object obj : list) {
                        InviteSuggestion inviteSuggestion = (InviteSuggestion) obj;
                        if (inviteSuggestion instanceof InviteSuggestion.ChannelItem) {
                            zContains = C12106w.contains((CharSequence) ChannelUtils.m7679c(((InviteSuggestion.ChannelItem) inviteSuggestion).getChannel()), (CharSequence) str, true);
                        } else {
                            if (!(inviteSuggestion instanceof InviteSuggestion.UserSuggestion)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            zContains = C12106w.contains((CharSequence) ((InviteSuggestion.UserSuggestion) inviteSuggestion).getUser().getUsername(), (CharSequence) str, true);
                        }
                        if (zContains) {
                            arrayListM840a0.add(obj);
                        }
                    }
                    list = arrayListM840a0;
                }
                List<Channel> dms = widgetInviteModel.getDms();
                ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(dms, 10));
                for (Channel channel : dms) {
                    User userM7677a = ChannelUtils.m7677a(channel);
                    arrayList2.add(C12116o.m10073to(userM7677a != null ? Long.valueOf(userM7677a.getId()) : null, Long.valueOf(channel.getId())));
                }
                Map map2 = C12136h0.toMap(arrayList2);
                if (true ^ list.isEmpty()) {
                    arrayList = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
                    for (InviteSuggestion inviteSuggestion2 : list) {
                        if (inviteSuggestion2 instanceof InviteSuggestion.ChannelItem) {
                            InviteSuggestion.ChannelItem channelItem = (InviteSuggestion.ChannelItem) inviteSuggestion2;
                            userItem = new InviteSuggestionItem.ChannelItem(channelItem.getChannel(), set.contains(Long.valueOf(channelItem.getChannel().getId())));
                        } else {
                            if (inviteSuggestion2 instanceof InviteSuggestion.UserSuggestion) {
                                throw new NoWhenBranchMatchedException();
                            }
                            InviteSuggestion.UserSuggestion userSuggestion = (InviteSuggestion.UserSuggestion) inviteSuggestion2;
                            userItem = new InviteSuggestionItem.UserItem(userSuggestion.getUser(), C12163u.contains(set, map2.get(Long.valueOf(userSuggestion.getUser().getId()))));
                        }
                        arrayList.add(userItem);
                    }
                    listListOf = arrayList;
                } else if (str == null || C12103t.isBlank(str)) {
                    arrayList = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
                    while (r11.hasNext()) {
                        if (inviteSuggestion2 instanceof InviteSuggestion.ChannelItem) {
                            InviteSuggestion.ChannelItem channelItem2 = (InviteSuggestion.ChannelItem) inviteSuggestion2;
                            userItem = new InviteSuggestionItem.ChannelItem(channelItem2.getChannel(), set.contains(Long.valueOf(channelItem2.getChannel().getId())));
                        } else {
                            if (inviteSuggestion2 instanceof InviteSuggestion.UserSuggestion) {
                                throw new NoWhenBranchMatchedException();
                            }
                            InviteSuggestion.UserSuggestion userSuggestion2 = (InviteSuggestion.UserSuggestion) inviteSuggestion2;
                            userItem = new InviteSuggestionItem.UserItem(userSuggestion2.getUser(), C12163u.contains(set, map2.get(Long.valueOf(userSuggestion2.getUser().getId()))));
                        }
                        arrayList.add(userItem);
                    }
                    listListOf = arrayList;
                } else {
                    listListOf = C12145m.listOf(InviteSuggestionItem.INSTANCE);
                }
                if (widgetInviteModel.getInvite() != null) {
                    if (!widgetInviteModel.getInvite().isStatic() && !widgetInviteModel.isInviteFromStore()) {
                        z3 = true;
                    }
                    z2 = z3;
                } else {
                    z2 = true;
                }
                C12238m.checkNotNullExpressionValue(widgetInviteModel, "widgetInviteModel");
                C12238m.checkNotNullExpressionValue(str, "filter");
                return new WidgetGuildInviteShareViewModel.ViewState.Loaded(widgetInviteModel, listListOf, str, map, z2);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11072g, "Observable.combineLatest…iteSettings\n      )\n    }");
        return observableM11072g;
    }

    public final void refreshUi() {
        this.refreshUiSubject.onNext(Unit.f27425a);
    }

    public final void selectChannel(long channelId) {
        this.selectedChannelSubject.onNext(Long.valueOf(channelId));
    }

    public final void sendInviteToChannel(long channelId, ViewState.Loaded viewState, ModelInvite invite) {
        C12238m.checkNotNullParameter(viewState, "viewState");
        String inviteLink = getInviteLink(invite);
        StoreMessages messages = StoreStream.INSTANCE.getMessages();
        MeUser me2 = viewState.getWidgetInviteModel().getMe();
        C12238m.checkNotNullExpressionValue(inviteLink, "inviteLink");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(StoreMessages.sendMessage$default(messages, channelId, me2, inviteLink, null, null, null, null, null, null, null, null, null, null, null, null, 32736, null), this, null, 2, null), (Class<?>) WidgetGuildInviteShareViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C87101(invite, viewState, inviteLink));
    }

    public final void sendInviteToUser(long userId, ViewState.Loaded viewState, ModelInvite invite) {
        C12238m.checkNotNullParameter(viewState, "viewState");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().createOrFetchDM(userId), false, 1, null), this, null, 2, null), (Class<?>) WidgetGuildInviteShareViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C87111(viewState, invite));
    }

    public final void updateInviteSettings(ModelInvite.Settings settings) {
        C12238m.checkNotNullParameter(settings, "settings");
        this.storeInviteSettings.setInviteSettings(settings);
    }

    public final void updateSearchQuery(String searchQuery) {
        C12238m.checkNotNullParameter(searchQuery, "searchQuery");
        this.filterPublisher.onNext(searchQuery);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInviteShareViewModel(StoreChannels storeChannels, StoreGuilds storeGuilds, StoreInviteSettings storeInviteSettings, StoreUser storeUser, StoreStageInstances storeStageInstances, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreInstantInvites storeInstantInvites, InviteGenerator inviteGenerator, InviteSuggestionsManager inviteSuggestionsManager, Resources resources, boolean z2, long j, Long l, String str) {
        super(ViewState.Uninitialized.INSTANCE);
        C12238m.checkNotNullParameter(storeChannels, "storeChannels");
        C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
        C12238m.checkNotNullParameter(storeInviteSettings, "storeInviteSettings");
        C12238m.checkNotNullParameter(storeUser, "storeUser");
        C12238m.checkNotNullParameter(storeStageInstances, "storeStageInstances");
        C12238m.checkNotNullParameter(storeGuildScheduledEvents, "storeGuildScheduledEvents");
        C12238m.checkNotNullParameter(storeInstantInvites, "storeInstantInvites");
        C12238m.checkNotNullParameter(inviteGenerator, "inviteGenerator");
        C12238m.checkNotNullParameter(inviteSuggestionsManager, "inviteSuggestionsManager");
        C12238m.checkNotNullParameter(resources, "resources");
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
        BehaviorSubject<Map<String, Set<Long>>> behaviorSubjectM11130l0 = BehaviorSubject.m11130l0(C12136h0.emptyMap());
        C12238m.checkNotNullExpressionValue(behaviorSubjectM11130l0, "BehaviorSubject.create(emptyMap())");
        this.sentInvitesSubject = behaviorSubjectM11130l0;
        this.filterPublisher = BehaviorSubject.m11130l0("");
        BehaviorSubject<Long> behaviorSubjectM11130l1 = BehaviorSubject.m11130l0(null);
        C12238m.checkNotNullExpressionValue(behaviorSubjectM11130l1, "BehaviorSubject.create(null as ChannelId?)");
        this.selectedChannelSubject = behaviorSubjectM11130l1;
        BehaviorSubject<Unit> behaviorSubjectM11130l2 = BehaviorSubject.m11130l0(Unit.f27425a);
        C12238m.checkNotNullExpressionValue(behaviorSubjectM11130l2, "BehaviorSubject.create(Unit)");
        this.refreshUiSubject = behaviorSubjectM11130l2;
        if (z2) {
            Observable<ViewState.Loaded> observableM11115u = observeViewStateFromStores$app_productionGoogleRelease(j, l, str).m11115u(new Action1<ViewState.Loaded>() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel.1
                @Override // p658rx.functions.Action1
                public final void call(ViewState.Loaded loaded) {
                    WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel = WidgetGuildInviteShareViewModel.this;
                    C12238m.checkNotNullExpressionValue(loaded, "viewState");
                    widgetGuildInviteShareViewModel.generateInviteLinkFromViewState(loaded);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11115u, "observeViewStateFromStor…romViewState(viewState) }");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationBuffered(observableM11115u), this, null, 2, null), (Class<?>) WidgetGuildInviteShareViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C87082(this));
        }
    }
}

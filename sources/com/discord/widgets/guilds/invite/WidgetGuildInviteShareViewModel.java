package com.discord.widgets.guilds.invite;

import android.content.res.Resources;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
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
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableCombineLatestOverloads2;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guilds.invite.InviteGenerator;
import com.discord.widgets.guilds.invite.InviteSuggestion;
import com.discord.widgets.guilds.invite.InviteSuggestionItem;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel;
import com.discord.widgets.guilds.invite.WidgetInviteModel;
import d0.Tuples;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t.Sets5;
import d0.t._Collections;
import d0.t._Sets;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
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
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func5;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetGuildInviteShareViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareViewModel extends AppViewModel<ViewState> implements AppComponent {
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

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildInviteShareViewModel.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<ViewState, Unit> {
        public AnonymousClass2(WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel) {
            super(1, widgetGuildInviteShareViewModel, WidgetGuildInviteShareViewModel.class, "updateViewState", "updateViewState(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
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
                Intrinsics3.checkNotNullParameter(widgetInviteModel, "widgetInviteModel");
                Intrinsics3.checkNotNullParameter(inviteSuggestionItems, "inviteSuggestionItems");
                Intrinsics3.checkNotNullParameter(searchQuery, "searchQuery");
                Intrinsics3.checkNotNullParameter(sentInvites, "sentInvites");
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
                return Intrinsics3.areEqual(this.widgetInviteModel, loaded.widgetInviteModel) && Intrinsics3.areEqual(this.inviteSuggestionItems, loaded.inviteSuggestionItems) && Intrinsics3.areEqual(this.searchQuery, loaded.searchQuery) && Intrinsics3.areEqual(this.sentInvites, loaded.sentInvites) && this.showInviteSettings == loaded.showInviteSettings;
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
                StringBuilder sbU = outline.U("Loaded(widgetInviteModel=");
                sbU.append(this.widgetInviteModel);
                sbU.append(", inviteSuggestionItems=");
                sbU.append(this.inviteSuggestionItems);
                sbU.append(", searchQuery=");
                sbU.append(this.searchQuery);
                sbU.append(", sentInvites=");
                sbU.append(this.sentInvites);
                sbU.append(", showInviteSettings=");
                return outline.O(sbU, this.showInviteSettings, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(WidgetInviteModel widgetInviteModel, List<? extends InviteSuggestionItem> list, String str, Map<String, ? extends Set<Long>> map, boolean z2) {
                super(null);
                Intrinsics3.checkNotNullParameter(widgetInviteModel, "widgetInviteModel");
                Intrinsics3.checkNotNullParameter(list, "inviteSuggestionItems");
                Intrinsics3.checkNotNullParameter(str, "searchQuery");
                Intrinsics3.checkNotNullParameter(map, "sentInvites");
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

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel$observeWidgetInviteViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildInviteShareViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function10<ModelInvite.Settings, Map<Long, ? extends Channel>, InviteGenerator.InviteGenerationState, Long, MeUser, List<? extends Channel>, Guild, Map<Long, ? extends StageInstance>, GuildScheduledEvent, StoreInstantInvites.InviteState, WidgetInviteModel> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(10);
        }

        @Override // kotlin.jvm.functions.Function10
        public /* bridge */ /* synthetic */ WidgetInviteModel invoke(ModelInvite.Settings settings, Map<Long, ? extends Channel> map, InviteGenerator.InviteGenerationState inviteGenerationState, Long l, MeUser meUser, List<? extends Channel> list, Guild guild, Map<Long, ? extends StageInstance> map2, GuildScheduledEvent guildScheduledEvent, StoreInstantInvites.InviteState inviteState) {
            return invoke2(settings, (Map<Long, Channel>) map, inviteGenerationState, l, meUser, (List<Channel>) list, guild, (Map<Long, StageInstance>) map2, guildScheduledEvent, inviteState);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final WidgetInviteModel invoke2(ModelInvite.Settings settings, Map<Long, Channel> map, InviteGenerator.InviteGenerationState inviteGenerationState, Long l, MeUser meUser, List<Channel> list, Guild guild, Map<Long, StageInstance> map2, GuildScheduledEvent guildScheduledEvent, StoreInstantInvites.InviteState inviteState) {
            StoreInstantInvites.InviteState inviteState2 = inviteState;
            Intrinsics3.checkNotNullParameter(settings, "settings");
            Intrinsics3.checkNotNullParameter(map, "invitableChannels");
            Intrinsics3.checkNotNullParameter(inviteGenerationState, "inviteGenerationState");
            Intrinsics3.checkNotNullParameter(meUser, "me");
            Intrinsics3.checkNotNullParameter(list, "dms");
            Intrinsics3.checkNotNullParameter(map2, "guildStageInstances");
            Intrinsics3.checkNotNullParameter(inviteState2, "storeInvite");
            WidgetInviteModel.Companion companion = WidgetInviteModel.INSTANCE;
            if (!(inviteState2 instanceof StoreInstantInvites.InviteState.Resolved)) {
                inviteState2 = null;
            }
            StoreInstantInvites.InviteState.Resolved resolved = (StoreInstantInvites.InviteState.Resolved) inviteState2;
            return companion.create(settings, map, inviteGenerationState, l, meUser, list, guild, map2, guildScheduledEvent, resolved != null ? resolved.getInvite() : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel$sendInviteToChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildInviteShareViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<MessageQueue4, Unit> {
        public final /* synthetic */ ModelInvite $invite;
        public final /* synthetic */ String $inviteLink;
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelInvite modelInvite, ViewState.Loaded loaded, String str) {
            super(1);
            this.$invite = modelInvite;
            this.$viewState = loaded;
            this.$inviteLink = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MessageQueue4 messageQueue4) {
            invoke2(messageQueue4);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MessageQueue4 messageQueue4) {
            Intrinsics3.checkNotNullParameter(messageQueue4, "result");
            if (messageQueue4 instanceof MessageQueue4.Success) {
                MessageQueue4.Success success = (MessageQueue4.Success) messageQueue4;
                StoreStream.INSTANCE.getAnalytics().inviteSent(this.$invite, success.getMessage(), "Guild Create Invite Suggestion");
                Map<String, Set<Long>> sentInvites = this.$viewState.getSentInvites();
                String str = this.$inviteLink;
                Intrinsics3.checkNotNullExpressionValue(str, "inviteLink");
                Set<Long> setEmptySet = sentInvites.get(str);
                if (setEmptySet == null) {
                    setEmptySet = Sets5.emptySet();
                }
                WidgetGuildInviteShareViewModel.this.updateSentInvites(Maps6.plus(sentInvites, MapsJVM.mapOf(Tuples.to(this.$inviteLink, _Sets.plus(setEmptySet, Long.valueOf(success.getMessage().getChannelId()))))));
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel$sendInviteToUser$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildInviteShareViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ ModelInvite $invite;
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ViewState.Loaded loaded, ModelInvite modelInvite) {
            super(1);
            this.$viewState = loaded;
            this.$invite = modelInvite;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
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
        Observable<WidgetInviteModel> observableR = ObservableExtensionsKt.computationLatest(ObservableCombineLatestOverloads2.combineLatest(this.storeInviteSettings.getInviteSettings(), this.storeInviteSettings.getInvitableChannels(guildId), this.inviteGenerator.getGenerationState(), this.selectedChannelSubject, StoreUser.observeMe$default(this.storeUser, false, 1, null), this.storeChannels.observeDMs(), this.storeGuilds.observeGuild(guildId), this.storeStageInstances.observeStageInstancesForGuild(guildId), this.storeGuildScheduledEvents.observeGuildScheduledEvent(eventId, Long.valueOf(guildId)), this.storeInstantInvites.observeInvite(inviteStoreKey), AnonymousClass1.INSTANCE)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "combineLatest(\n        s…  .distinctUntilChanged()");
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

    public final Observable<ViewState.Loaded> observeViewStateFromStores$app_productionGoogleRelease(long guildId, Long eventId, String inviteStoreKey) {
        Observable<ViewState.Loaded> observableG = Observable.g(observeWidgetInviteViewModel(guildId, eventId, inviteStoreKey), this.inviteSuggestionsManager.observeInviteSuggestions(), this.filterPublisher, this.sentInvitesSubject, this.refreshUiSubject, new Func5<WidgetInviteModel, List<? extends InviteSuggestion>, String, Map<String, ? extends Set<? extends Long>>, Unit, ViewState.Loaded>() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel$observeViewStateFromStores$1
            @Override // rx.functions.Func5
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
                Intrinsics3.checkNotNullExpressionValue(map, "sentInvites");
                String inviteLink = this.this$0.getInviteLink(widgetInviteModel.getInvite());
                Intrinsics3.checkNotNullExpressionValue(inviteLink, "widgetInviteModel.invite.inviteLink");
                Set<Long> setEmptySet = map.get(inviteLink);
                if (setEmptySet == null) {
                    setEmptySet = Sets5.emptySet();
                }
                Set<Long> set = setEmptySet;
                boolean z3 = false;
                if (str == null || StringsJVM.isBlank(str)) {
                    Intrinsics3.checkNotNullExpressionValue(list, "inviteSuggestions");
                } else {
                    ArrayList arrayListA0 = outline.a0(list, "inviteSuggestions");
                    for (Object obj : list) {
                        InviteSuggestion inviteSuggestion = (InviteSuggestion) obj;
                        if (inviteSuggestion instanceof InviteSuggestion.ChannelItem) {
                            zContains = Strings4.contains((CharSequence) ChannelUtils.c(((InviteSuggestion.ChannelItem) inviteSuggestion).getChannel()), (CharSequence) str, true);
                        } else {
                            if (!(inviteSuggestion instanceof InviteSuggestion.UserSuggestion)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            zContains = Strings4.contains((CharSequence) ((InviteSuggestion.UserSuggestion) inviteSuggestion).getUser().getUsername(), (CharSequence) str, true);
                        }
                        if (zContains) {
                            arrayListA0.add(obj);
                        }
                    }
                    list = arrayListA0;
                }
                List<Channel> dms = widgetInviteModel.getDms();
                ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(dms, 10));
                for (Channel channel : dms) {
                    User userA = ChannelUtils.a(channel);
                    arrayList2.add(Tuples.to(userA != null ? Long.valueOf(userA.getId()) : null, Long.valueOf(channel.getId())));
                }
                Map map2 = Maps6.toMap(arrayList2);
                if (true ^ list.isEmpty()) {
                    arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                    for (InviteSuggestion inviteSuggestion2 : list) {
                        if (inviteSuggestion2 instanceof InviteSuggestion.ChannelItem) {
                            InviteSuggestion.ChannelItem channelItem = (InviteSuggestion.ChannelItem) inviteSuggestion2;
                            userItem = new InviteSuggestionItem.ChannelItem(channelItem.getChannel(), set.contains(Long.valueOf(channelItem.getChannel().getId())));
                        } else {
                            if (inviteSuggestion2 instanceof InviteSuggestion.UserSuggestion) {
                                throw new NoWhenBranchMatchedException();
                            }
                            InviteSuggestion.UserSuggestion userSuggestion = (InviteSuggestion.UserSuggestion) inviteSuggestion2;
                            userItem = new InviteSuggestionItem.UserItem(userSuggestion.getUser(), _Collections.contains(set, map2.get(Long.valueOf(userSuggestion.getUser().getId()))));
                        }
                        arrayList.add(userItem);
                    }
                    listListOf = arrayList;
                } else if (str == null || StringsJVM.isBlank(str)) {
                    arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                    while (r11.hasNext()) {
                        if (inviteSuggestion2 instanceof InviteSuggestion.ChannelItem) {
                            InviteSuggestion.ChannelItem channelItem2 = (InviteSuggestion.ChannelItem) inviteSuggestion2;
                            userItem = new InviteSuggestionItem.ChannelItem(channelItem2.getChannel(), set.contains(Long.valueOf(channelItem2.getChannel().getId())));
                        } else {
                            if (inviteSuggestion2 instanceof InviteSuggestion.UserSuggestion) {
                                throw new NoWhenBranchMatchedException();
                            }
                            InviteSuggestion.UserSuggestion userSuggestion2 = (InviteSuggestion.UserSuggestion) inviteSuggestion2;
                            userItem = new InviteSuggestionItem.UserItem(userSuggestion2.getUser(), _Collections.contains(set, map2.get(Long.valueOf(userSuggestion2.getUser().getId()))));
                        }
                        arrayList.add(userItem);
                    }
                    listListOf = arrayList;
                } else {
                    listListOf = CollectionsJVM.listOf(InviteSuggestionItem.INSTANCE);
                }
                if (widgetInviteModel.getInvite() != null) {
                    if (!widgetInviteModel.getInvite().isStatic() && !widgetInviteModel.isInviteFromStore()) {
                        z3 = true;
                    }
                    z2 = z3;
                } else {
                    z2 = true;
                }
                Intrinsics3.checkNotNullExpressionValue(widgetInviteModel, "widgetInviteModel");
                Intrinsics3.checkNotNullExpressionValue(str, "filter");
                return new WidgetGuildInviteShareViewModel.ViewState.Loaded(widgetInviteModel, listListOf, str, map, z2);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "Observable.combineLatest…iteSettings\n      )\n    }");
        return observableG;
    }

    public final void refreshUi() {
        this.refreshUiSubject.onNext(Unit.a);
    }

    public final void selectChannel(long channelId) {
        this.selectedChannelSubject.onNext(Long.valueOf(channelId));
    }

    public final void sendInviteToChannel(long channelId, ViewState.Loaded viewState, ModelInvite invite) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        String inviteLink = getInviteLink(invite);
        StoreMessages messages = StoreStream.INSTANCE.getMessages();
        MeUser me2 = viewState.getWidgetInviteModel().getMe();
        Intrinsics3.checkNotNullExpressionValue(inviteLink, "inviteLink");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(StoreMessages.sendMessage$default(messages, channelId, me2, inviteLink, null, null, null, null, null, null, null, null, null, null, null, null, 32736, null), this, null, 2, null), (Class<?>) WidgetGuildInviteShareViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(invite, viewState, inviteLink));
    }

    public final void sendInviteToUser(long userId, ViewState.Loaded viewState, ModelInvite invite) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().createOrFetchDM(userId), false, 1, null), this, null, 2, null), (Class<?>) WidgetGuildInviteShareViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(viewState, invite));
    }

    public final void updateInviteSettings(ModelInvite.Settings settings) {
        Intrinsics3.checkNotNullParameter(settings, "settings");
        this.storeInviteSettings.setInviteSettings(settings);
    }

    public final void updateSearchQuery(String searchQuery) {
        Intrinsics3.checkNotNullParameter(searchQuery, "searchQuery");
        this.filterPublisher.onNext(searchQuery);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInviteShareViewModel(StoreChannels storeChannels, StoreGuilds storeGuilds, StoreInviteSettings storeInviteSettings, StoreUser storeUser, StoreStageInstances storeStageInstances, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreInstantInvites storeInstantInvites, InviteGenerator inviteGenerator, InviteSuggestionsManager inviteSuggestionsManager, Resources resources, boolean z2, long j, Long l, String str) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeInviteSettings, "storeInviteSettings");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storeStageInstances, "storeStageInstances");
        Intrinsics3.checkNotNullParameter(storeGuildScheduledEvents, "storeGuildScheduledEvents");
        Intrinsics3.checkNotNullParameter(storeInstantInvites, "storeInstantInvites");
        Intrinsics3.checkNotNullParameter(inviteGenerator, "inviteGenerator");
        Intrinsics3.checkNotNullParameter(inviteSuggestionsManager, "inviteSuggestionsManager");
        Intrinsics3.checkNotNullParameter(resources, "resources");
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
        BehaviorSubject<Map<String, Set<Long>>> behaviorSubjectL0 = BehaviorSubject.l0(Maps6.emptyMap());
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(emptyMap())");
        this.sentInvitesSubject = behaviorSubjectL0;
        this.filterPublisher = BehaviorSubject.l0("");
        BehaviorSubject<Long> behaviorSubjectL1 = BehaviorSubject.l0(null);
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL1, "BehaviorSubject.create(null as ChannelId?)");
        this.selectedChannelSubject = behaviorSubjectL1;
        BehaviorSubject<Unit> behaviorSubjectL2 = BehaviorSubject.l0(Unit.a);
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL2, "BehaviorSubject.create(Unit)");
        this.refreshUiSubject = behaviorSubjectL2;
        if (z2) {
            Observable<ViewState.Loaded> observableU = observeViewStateFromStores$app_productionGoogleRelease(j, l, str).u(new Action1<ViewState.Loaded>() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel.1
                @Override // rx.functions.Action1
                public final void call(ViewState.Loaded loaded) {
                    WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel = WidgetGuildInviteShareViewModel.this;
                    Intrinsics3.checkNotNullExpressionValue(loaded, "viewState");
                    widgetGuildInviteShareViewModel.generateInviteLinkFromViewState(loaded);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableU, "observeViewStateFromStor…romViewState(viewState) }");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationBuffered(observableU), this, null, 2, null), (Class<?>) WidgetGuildInviteShareViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(this));
        }
    }
}

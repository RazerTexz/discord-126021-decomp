package com.discord.widgets.guilds.invite;

import a0.a.a.b;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.BuildConfig;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.stageinstance.StageInstance;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreMessages;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.guilds.GuildUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.utilities.recycler.DiffKeyProvider;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guilds.invite.GuildInvite;
import com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel;
import com.discord.widgets.guilds.invite.InviteSuggestion;
import com.discord.widgets.guilds.invite.InviteSuggestionItemV2;
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
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func7;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: GuildInviteShareSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildInviteShareSheetViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Long channelId;
    private StoreState currentStoreState;
    private final long guildId;
    private boolean hasTrackedSuggestionsViewed;
    private GuildInvite invite;
    private final Logger logger;
    private String searchQuery;
    private BehaviorSubject<String> searchQuerySubject;
    private Map<String, ? extends Set<Long>> sentInvites;
    private final StoreAnalytics storeAnalytics;
    private final StoreInviteSettings storeInviteSettings;
    private final StoreMessages storeMessages;
    private Channel targetChannel;
    private final TargetChannelSelector targetChannelSelector;

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: GuildInviteShareSheetViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            GuildInviteShareSheetViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: GuildInviteShareSheetViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            GuildInviteShareSheetViewModel guildInviteShareSheetViewModel = GuildInviteShareSheetViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(str, "searchQuery");
            guildInviteShareSheetViewModel.updateSearchQuery(str);
        }
    }

    /* JADX INFO: compiled from: GuildInviteShareSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(long guildId, InviteSuggestionsManager inviteSuggestionsManager, StoreInviteSettings storeInviteSettings, StoreUser storeUser, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreStageInstances storeStageInstances) {
            Observable<StoreState> observableE = Observable.e(storeInviteSettings.getInviteSettings(), storeInviteSettings.getInvitableChannels(guildId), StoreUser.observeMe$default(storeUser, false, 1, null), storeChannels.observeDMs(), storeGuilds.observeGuild(guildId), inviteSuggestionsManager.observeInviteSuggestions(), storeStageInstances.observeStageInstancesForGuild(guildId), new Func7<ModelInvite.Settings, Map<Long, ? extends Channel>, MeUser, List<? extends Channel>, Guild, List<? extends InviteSuggestion>, Map<Long, ? extends StageInstance>, StoreState>() { // from class: com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel$Companion$observeStoreState$1
                @Override // rx.functions.Func7
                public /* bridge */ /* synthetic */ GuildInviteShareSheetViewModel.StoreState call(ModelInvite.Settings settings, Map<Long, ? extends Channel> map, MeUser meUser, List<? extends Channel> list, Guild guild, List<? extends InviteSuggestion> list2, Map<Long, ? extends StageInstance> map2) {
                    return call2(settings, (Map<Long, Channel>) map, meUser, (List<Channel>) list, guild, list2, (Map<Long, StageInstance>) map2);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final GuildInviteShareSheetViewModel.StoreState call2(ModelInvite.Settings settings, Map<Long, Channel> map, MeUser meUser, List<Channel> list, Guild guild, List<? extends InviteSuggestion> list2, Map<Long, StageInstance> map2) {
                    if (guild == null) {
                        return GuildInviteShareSheetViewModel.StoreState.Invalid.INSTANCE;
                    }
                    Intrinsics3.checkNotNullExpressionValue(settings, "inviteSettings");
                    Intrinsics3.checkNotNullExpressionValue(map, "invitableChannels");
                    Intrinsics3.checkNotNullExpressionValue(meUser, "me");
                    Intrinsics3.checkNotNullExpressionValue(list, "dms");
                    Intrinsics3.checkNotNullExpressionValue(list2, "inviteSuggestions");
                    Intrinsics3.checkNotNullExpressionValue(map2, "guildStageInstances");
                    return new GuildInviteShareSheetViewModel.StoreState.Valid(settings, map, meUser, list, guild, list2, map2);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableE, "Observable.combineLatest…      )\n        }\n      }");
            return observableE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GuildInviteShareSheetViewModel.kt */
    public static abstract class StoreState {

        /* JADX INFO: compiled from: GuildInviteShareSheetViewModel.kt */
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GuildInviteShareSheetViewModel.kt */
        public static final /* data */ class Valid extends StoreState {
            private final List<Channel> dms;
            private final Guild guild;
            private final Map<Long, StageInstance> guildStageInstances;
            private final Map<Long, Channel> invitableChannels;
            private final ModelInvite.Settings inviteSettings;
            private final List<InviteSuggestion> inviteSuggestions;
            private final MeUser me;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Valid(ModelInvite.Settings settings, Map<Long, Channel> map, MeUser meUser, List<Channel> list, Guild guild, List<? extends InviteSuggestion> list2, Map<Long, StageInstance> map2) {
                super(null);
                Intrinsics3.checkNotNullParameter(settings, "inviteSettings");
                Intrinsics3.checkNotNullParameter(map, "invitableChannels");
                Intrinsics3.checkNotNullParameter(meUser, "me");
                Intrinsics3.checkNotNullParameter(list, "dms");
                Intrinsics3.checkNotNullParameter(guild, "guild");
                Intrinsics3.checkNotNullParameter(list2, "inviteSuggestions");
                Intrinsics3.checkNotNullParameter(map2, "guildStageInstances");
                this.inviteSettings = settings;
                this.invitableChannels = map;
                this.me = meUser;
                this.dms = list;
                this.guild = guild;
                this.inviteSuggestions = list2;
                this.guildStageInstances = map2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Valid copy$default(Valid valid, ModelInvite.Settings settings, Map map, MeUser meUser, List list, Guild guild, List list2, Map map2, int i, Object obj) {
                if ((i & 1) != 0) {
                    settings = valid.inviteSettings;
                }
                if ((i & 2) != 0) {
                    map = valid.invitableChannels;
                }
                Map map3 = map;
                if ((i & 4) != 0) {
                    meUser = valid.me;
                }
                MeUser meUser2 = meUser;
                if ((i & 8) != 0) {
                    list = valid.dms;
                }
                List list3 = list;
                if ((i & 16) != 0) {
                    guild = valid.guild;
                }
                Guild guild2 = guild;
                if ((i & 32) != 0) {
                    list2 = valid.inviteSuggestions;
                }
                List list4 = list2;
                if ((i & 64) != 0) {
                    map2 = valid.guildStageInstances;
                }
                return valid.copy(settings, map3, meUser2, list3, guild2, list4, map2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelInvite.Settings getInviteSettings() {
                return this.inviteSettings;
            }

            public final Map<Long, Channel> component2() {
                return this.invitableChannels;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final MeUser getMe() {
                return this.me;
            }

            public final List<Channel> component4() {
                return this.dms;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            public final List<InviteSuggestion> component6() {
                return this.inviteSuggestions;
            }

            public final Map<Long, StageInstance> component7() {
                return this.guildStageInstances;
            }

            public final Valid copy(ModelInvite.Settings inviteSettings, Map<Long, Channel> invitableChannels, MeUser me2, List<Channel> dms, Guild guild, List<? extends InviteSuggestion> inviteSuggestions, Map<Long, StageInstance> guildStageInstances) {
                Intrinsics3.checkNotNullParameter(inviteSettings, "inviteSettings");
                Intrinsics3.checkNotNullParameter(invitableChannels, "invitableChannels");
                Intrinsics3.checkNotNullParameter(me2, "me");
                Intrinsics3.checkNotNullParameter(dms, "dms");
                Intrinsics3.checkNotNullParameter(guild, "guild");
                Intrinsics3.checkNotNullParameter(inviteSuggestions, "inviteSuggestions");
                Intrinsics3.checkNotNullParameter(guildStageInstances, "guildStageInstances");
                return new Valid(inviteSettings, invitableChannels, me2, dms, guild, inviteSuggestions, guildStageInstances);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.inviteSettings, valid.inviteSettings) && Intrinsics3.areEqual(this.invitableChannels, valid.invitableChannels) && Intrinsics3.areEqual(this.me, valid.me) && Intrinsics3.areEqual(this.dms, valid.dms) && Intrinsics3.areEqual(this.guild, valid.guild) && Intrinsics3.areEqual(this.inviteSuggestions, valid.inviteSuggestions) && Intrinsics3.areEqual(this.guildStageInstances, valid.guildStageInstances);
            }

            public final List<Channel> getDms() {
                return this.dms;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final Map<Long, StageInstance> getGuildStageInstances() {
                return this.guildStageInstances;
            }

            public final Map<Long, Channel> getInvitableChannels() {
                return this.invitableChannels;
            }

            public final ModelInvite.Settings getInviteSettings() {
                return this.inviteSettings;
            }

            public final List<InviteSuggestion> getInviteSuggestions() {
                return this.inviteSuggestions;
            }

            public final MeUser getMe() {
                return this.me;
            }

            public int hashCode() {
                ModelInvite.Settings settings = this.inviteSettings;
                int iHashCode = (settings != null ? settings.hashCode() : 0) * 31;
                Map<Long, Channel> map = this.invitableChannels;
                int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
                MeUser meUser = this.me;
                int iHashCode3 = (iHashCode2 + (meUser != null ? meUser.hashCode() : 0)) * 31;
                List<Channel> list = this.dms;
                int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
                Guild guild = this.guild;
                int iHashCode5 = (iHashCode4 + (guild != null ? guild.hashCode() : 0)) * 31;
                List<InviteSuggestion> list2 = this.inviteSuggestions;
                int iHashCode6 = (iHashCode5 + (list2 != null ? list2.hashCode() : 0)) * 31;
                Map<Long, StageInstance> map2 = this.guildStageInstances;
                return iHashCode6 + (map2 != null ? map2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(inviteSettings=");
                sbU.append(this.inviteSettings);
                sbU.append(", invitableChannels=");
                sbU.append(this.invitableChannels);
                sbU.append(", me=");
                sbU.append(this.me);
                sbU.append(", dms=");
                sbU.append(this.dms);
                sbU.append(", guild=");
                sbU.append(this.guild);
                sbU.append(", inviteSuggestions=");
                sbU.append(this.inviteSuggestions);
                sbU.append(", guildStageInstances=");
                return outline.M(sbU, this.guildStageInstances, ")");
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel$generateInviteForChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: GuildInviteShareSheetViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelInvite, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
            invoke2(modelInvite);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelInvite modelInvite) {
            Intrinsics3.checkNotNullParameter(modelInvite, "invite");
            GuildInviteShareSheetViewModel.this.handleInviteCreationSuccess(modelInvite);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel$generateInviteForChannel$2, reason: invalid class name */
    /* JADX INFO: compiled from: GuildInviteShareSheetViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            GuildInviteShareSheetViewModel.this.handleInviteCreationFailure();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel$sendInviteToChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: GuildInviteShareSheetViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<MessageQueue4, Unit> {
        public final /* synthetic */ GuildInvite $invite;
        public final /* synthetic */ String $inviteLink;
        public final /* synthetic */ ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(GuildInvite guildInvite, ViewState viewState, String str) {
            super(1);
            this.$invite = guildInvite;
            this.$viewState = viewState;
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
                GuildInviteShareSheetViewModel.this.storeAnalytics.inviteSent(this.$invite, this.$viewState.getChannel(), success.getMessage(), "Guild Create Invite Suggestion");
                Map<String, Set<Long>> sentInvites = this.$viewState.getSentInvites();
                Set<Long> setEmptySet = sentInvites.get(this.$inviteLink);
                if (setEmptySet == null) {
                    setEmptySet = Sets5.emptySet();
                }
                GuildInviteShareSheetViewModel.this.updateSentInvites(Maps6.plus(sentInvites, MapsJVM.mapOf(Tuples.to(this.$inviteLink, _Sets.plus(setEmptySet, Long.valueOf(success.getMessage().getChannelId()))))));
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel$sendInviteToUser$1, reason: invalid class name */
    /* JADX INFO: compiled from: GuildInviteShareSheetViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            GuildInviteShareSheetViewModel.this.sendInviteToChannel(channel.getId());
        }
    }

    public /* synthetic */ GuildInviteShareSheetViewModel(Long l, long j, StoreInviteSettings storeInviteSettings, StoreAnalytics storeAnalytics, StoreMessages storeMessages, TargetChannelSelector targetChannelSelector, Logger logger, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableObserveStoreState;
        StoreInviteSettings inviteSettings = (i & 4) != 0 ? StoreStream.INSTANCE.getInviteSettings() : storeInviteSettings;
        StoreAnalytics analytics = (i & 8) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics;
        StoreMessages messages = (i & 16) != 0 ? StoreStream.INSTANCE.getMessages() : storeMessages;
        TargetChannelSelector targetChannelSelector2 = (i & 32) != 0 ? new TargetChannelSelector() : targetChannelSelector;
        Logger logger2 = (i & 64) != 0 ? AppLog.g : logger;
        if ((i & 128) != 0) {
            Companion companion = INSTANCE;
            InviteSuggestionsManager inviteSuggestionsManager = new InviteSuggestionsManager(null, null, null, null, null, 31, null);
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableObserveStoreState = companion.observeStoreState(j, inviteSuggestionsManager, companion2.getInviteSettings(), companion2.getUsers(), companion2.getChannels(), companion2.getGuilds(), companion2.getStageInstances());
        } else {
            observableObserveStoreState = observable;
        }
        this(l, j, inviteSettings, analytics, messages, targetChannelSelector2, logger2, observableObserveStoreState);
    }

    private final ViewState createViewState(String searchQuery, Map<String, ? extends Set<Long>> sentInvites, StoreState.Valid storeState, GuildInvite generatedInvite) {
        String link;
        List arrayList;
        DiffKeyProvider userItem;
        boolean zContains;
        Collections.sort(new ArrayList(storeState.getInvitableChannels().values()), ChannelUtils.h(Channel.INSTANCE));
        if (generatedInvite == null || (link = generatedInvite.toLink()) == null) {
            link = BuildConfig.HOST_INVITE;
        }
        Set<Long> setEmptySet = sentInvites.get(link);
        if (setEmptySet == null) {
            setEmptySet = Sets5.emptySet();
        }
        Set<Long> set = setEmptySet;
        List<InviteSuggestion> inviteSuggestions = storeState.getInviteSuggestions();
        if (!StringsJVM.isBlank(searchQuery)) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : inviteSuggestions) {
                InviteSuggestion inviteSuggestion = (InviteSuggestion) obj;
                if (inviteSuggestion instanceof InviteSuggestion.ChannelItem) {
                    zContains = Strings4.contains((CharSequence) ChannelUtils.c(((InviteSuggestion.ChannelItem) inviteSuggestion).getChannel()), (CharSequence) searchQuery, true);
                } else {
                    if (!(inviteSuggestion instanceof InviteSuggestion.UserSuggestion)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    zContains = Strings4.contains((CharSequence) ((InviteSuggestion.UserSuggestion) inviteSuggestion).getUser().getUsername(), (CharSequence) searchQuery, true);
                }
                if (zContains) {
                    arrayList2.add(obj);
                }
            }
            inviteSuggestions = arrayList2;
        }
        List<Channel> dms = storeState.getDms();
        ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(dms, 10));
        Iterator<T> it = dms.iterator();
        while (true) {
            Long lValueOf = null;
            if (!it.hasNext()) {
                break;
            }
            Channel channel = (Channel) it.next();
            User userA = ChannelUtils.a(channel);
            if (userA != null) {
                lValueOf = Long.valueOf(userA.getId());
            }
            arrayList3.add(Tuples.to(lValueOf, Long.valueOf(channel.getId())));
        }
        Map map = Maps6.toMap(arrayList3);
        if ((!inviteSuggestions.isEmpty()) || StringsJVM.isBlank(searchQuery)) {
            arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(inviteSuggestions, 10));
            for (InviteSuggestion inviteSuggestion2 : inviteSuggestions) {
                if (inviteSuggestion2 instanceof InviteSuggestion.ChannelItem) {
                    InviteSuggestion.ChannelItem channelItem = (InviteSuggestion.ChannelItem) inviteSuggestion2;
                    userItem = new InviteSuggestionItemV2.ChannelItem(channelItem.getChannel(), set.contains(Long.valueOf(channelItem.getChannel().getId())), searchQuery);
                } else {
                    if (!(inviteSuggestion2 instanceof InviteSuggestion.UserSuggestion)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    InviteSuggestion.UserSuggestion userSuggestion = (InviteSuggestion.UserSuggestion) inviteSuggestion2;
                    userItem = new InviteSuggestionItemV2.UserItem(userSuggestion.getUser(), _Collections.contains(set, map.get(Long.valueOf(userSuggestion.getUser().getId()))), searchQuery);
                }
                arrayList.add(userItem);
            }
        } else {
            arrayList = CollectionsJVM.listOf(InviteSuggestionItemV2.SearchNoResultsItem.INSTANCE);
        }
        return new ViewState(generatedInvite, storeState.getInviteSettings(), arrayList, storeState.getInvitableChannels().get(generatedInvite != null ? generatedInvite.getChannelId() : null), searchQuery, sentInvites, generatedInvite != null ? !generatedInvite.isStaticInvite() : true, storeState.getGuild().getId());
    }

    private final void generateInviteForChannel(long targetChannelId) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(StoreInviteSettings.generateInvite$default(this.storeInviteSettings, targetChannelId, null, 2, null), false, 1, null), this, null, 2, null), (Class<?>) GuildInviteShareSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    @MainThread
    private final void handleInviteCreationFailure() {
        Guild guild;
        String vanityUrlCode;
        StoreState storeState = this.currentStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid == null || (vanityUrlCode = (guild = valid.getGuild()).getVanityUrlCode()) == null) {
            return;
        }
        ModelInvite modelInviteCreateForStaticUrl = ModelInvite.createForStaticUrl(vanityUrlCode, GuildUtils.createApiGuild(guild));
        GuildInvite.Companion companion = GuildInvite.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(modelInviteCreateForStaticUrl, "vanityUrlInvite");
        GuildInvite guildInviteCreateFromModelInvite = companion.createFromModelInvite(modelInviteCreateForStaticUrl);
        this.invite = guildInviteCreateFromModelInvite;
        updateViewState(createViewState(this.searchQuery, this.sentInvites, valid, guildInviteCreateFromModelInvite));
    }

    @MainThread
    private final void handleInviteCreationSuccess(ModelInvite invite) {
        GuildInvite guildInviteCreateFromModelInvite = GuildInvite.INSTANCE.createFromModelInvite(invite);
        this.invite = guildInviteCreateFromModelInvite;
        StoreState storeState = this.currentStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid != null) {
            updateViewState(createViewState(this.searchQuery, this.sentInvites, valid, guildInviteCreateFromModelInvite));
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x008f  */
    /* JADX WARN: Code duplicated, block: B:30:0x009b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x009d  */
    @MainThread
    private final void handleStoreState(StoreState storeState) {
        StoreState storeState2 = this.currentStoreState;
        if (Intrinsics3.areEqual(storeState, StoreState.Invalid.INSTANCE)) {
            Logger logger = this.logger;
            StringBuilder sbU = outline.U("invalid StoreState in ");
            sbU.append(GuildInviteShareSheetViewModel.class.getSimpleName());
            Logger.e$default(logger, sbU.toString(), null, null, 6, null);
            return;
        }
        if (storeState instanceof StoreState.Valid) {
            Channel channel = this.targetChannel;
            StoreState.Valid valid = (StoreState.Valid) storeState;
            Channel targetChannel = this.targetChannelSelector.getTargetChannel(valid.getInvitableChannels(), this.channelId);
            Guild guild = valid.getGuild();
            String vanityUrlCode = valid.getGuild().getVanityUrlCode();
            StageInstance stageInstance = valid.getGuildStageInstances().get(this.channelId);
            String inviteCode = stageInstance != null ? stageInstance.getInviteCode() : null;
            if (this.invite == null) {
                boolean z2 = true;
                boolean z3 = this.channelId == null;
                if (storeState2 == null) {
                    if (vanityUrlCode != null && vanityUrlCode.length() != 0) {
                        z2 = false;
                    }
                    if (!z2 && z3) {
                        ModelInvite modelInviteCreateForStaticUrl = ModelInvite.createForStaticUrl(vanityUrlCode, GuildUtils.createApiGuild(guild));
                        GuildInvite.Companion companion = GuildInvite.INSTANCE;
                        Intrinsics3.checkNotNullExpressionValue(modelInviteCreateForStaticUrl, "vanityUrlInvite");
                        this.invite = companion.createFromModelInvite(modelInviteCreateForStaticUrl);
                    } else if (channel != null) {
                        if (inviteCode != null) {
                            ModelInvite modelInviteCreateForStaticUrl2 = ModelInvite.createForStaticUrl(inviteCode, GuildUtils.createApiGuild(guild));
                            GuildInvite.Companion companion2 = GuildInvite.INSTANCE;
                            Intrinsics3.checkNotNullExpressionValue(modelInviteCreateForStaticUrl2, "stageInstanceInvite");
                            this.invite = companion2.createFromModelInvite(modelInviteCreateForStaticUrl2);
                        }
                    } else if (inviteCode != null) {
                        ModelInvite modelInviteCreateForStaticUrl3 = ModelInvite.createForStaticUrl(inviteCode, GuildUtils.createApiGuild(guild));
                        GuildInvite.Companion companion3 = GuildInvite.INSTANCE;
                        Intrinsics3.checkNotNullExpressionValue(modelInviteCreateForStaticUrl3, "stageInstanceInvite");
                        this.invite = companion3.createFromModelInvite(modelInviteCreateForStaticUrl3);
                    }
                } else if (channel != null && targetChannel != null) {
                    generateInviteForChannel(targetChannel.getId());
                } else if (inviteCode != null) {
                    ModelInvite modelInviteCreateForStaticUrl4 = ModelInvite.createForStaticUrl(inviteCode, GuildUtils.createApiGuild(guild));
                    GuildInvite.Companion companion4 = GuildInvite.INSTANCE;
                    Intrinsics3.checkNotNullExpressionValue(modelInviteCreateForStaticUrl4, "stageInstanceInvite");
                    this.invite = companion4.createFromModelInvite(modelInviteCreateForStaticUrl4);
                }
            }
            this.targetChannel = targetChannel;
            updateViewState(createViewState(this.searchQuery, this.sentInvites, valid, this.invite));
        }
        this.currentStoreState = storeState;
    }

    @MainThread
    private final void sendInviteToChannel(long channelId) {
        ViewState viewState;
        GuildInvite guildInvite;
        StoreState storeState = this.currentStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid == null || (viewState = getViewState()) == null || (guildInvite = this.invite) == null) {
            return;
        }
        String link = guildInvite.toLink();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(StoreMessages.sendMessage$default(this.storeMessages, channelId, valid.getMe(), link, null, null, null, null, null, null, null, null, null, null, null, null, 32736, null), this, null, 2, null), (Class<?>) GuildInviteShareSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(guildInvite, viewState, link));
    }

    private final void sendInviteToUser(long userId) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().createOrFetchDM(userId), false, 1, null), this, null, 2, null), (Class<?>) GuildInviteShareSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    @MainThread
    private final void updateSearchQuery(String searchQuery) {
        StoreState storeState = this.currentStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid == null || Intrinsics3.areEqual(searchQuery, this.searchQuery)) {
            return;
        }
        this.searchQuery = searchQuery;
        updateViewState(createViewState(searchQuery, this.sentInvites, valid, this.invite));
    }

    @MainThread
    private final void updateSentInvites(Map<String, ? extends Set<Long>> sentInvites) {
        this.sentInvites = sentInvites;
        StoreState storeState = this.currentStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid != null) {
            updateViewState(createViewState(this.searchQuery, sentInvites, valid, this.invite));
        }
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final void onSearchTextChanged(String searchQuery) {
        Intrinsics3.checkNotNullParameter(searchQuery, "searchQuery");
        this.searchQuerySubject.onNext(searchQuery);
    }

    @MainThread
    public final void sendInvite(InviteSuggestionItemV2 item) {
        Intrinsics3.checkNotNullParameter(item, "item");
        if (item instanceof InviteSuggestionItemV2.ChannelItem) {
            sendInviteToChannel(((InviteSuggestionItemV2.ChannelItem) item).getChannel().getId());
        } else if (item instanceof InviteSuggestionItemV2.UserItem) {
            sendInviteToUser(((InviteSuggestionItemV2.UserItem) item).getUser().getId());
        }
    }

    @MainThread
    public final void updateInvite(GuildInvite invite) {
        Intrinsics3.checkNotNullParameter(invite, "invite");
        this.invite = invite;
        ViewState viewState = getViewState();
        if (viewState != null) {
            StoreState storeState = this.currentStoreState;
            if (!(storeState instanceof StoreState.Valid)) {
                storeState = null;
            }
            StoreState.Valid valid = (StoreState.Valid) storeState;
            if (valid != null) {
                updateViewState(ViewState.copy$default(viewState, invite, null, null, valid.getInvitableChannels().get(invite.getChannelId()), null, null, false, 0L, 246, null));
            }
        }
    }

    @Override // b.a.d.AppViewModel
    @MainThread
    public void updateViewState(ViewState viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        super.updateViewState(viewState);
        if (!viewState.getHasSearchResults() || this.hasTrackedSuggestionsViewed) {
            return;
        }
        long guildId = viewState.getGuildId();
        List<InviteSuggestionItemV2> inviteSuggestionItems = viewState.getInviteSuggestionItems();
        StoreAnalytics storeAnalytics = this.storeAnalytics;
        ArrayList arrayList = new ArrayList();
        for (Object obj : inviteSuggestionItems) {
            if (obj instanceof InviteSuggestionItemV2.ChannelItem) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((InviteSuggestionItemV2.ChannelItem) it.next()).getChannel());
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : inviteSuggestionItems) {
            if (obj2 instanceof InviteSuggestionItemV2.UserItem) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(((InviteSuggestionItemV2.UserItem) it2.next()).getUser());
        }
        storeAnalytics.inviteSuggestionOpened(guildId, arrayList2, arrayList4);
        this.hasTrackedSuggestionsViewed = true;
    }

    /* JADX INFO: compiled from: GuildInviteShareSheetViewModel.kt */
    public static final /* data */ class ViewState {
        private final Channel channel;
        private final long guildId;
        private final boolean hasResults;
        private final boolean hasSearchResults;
        private final GuildInvite invite;
        private final ModelInvite.Settings inviteSettings;
        private final List<InviteSuggestionItemV2> inviteSuggestionItems;
        private final String searchQuery;
        private final Map<String, Set<Long>> sentInvites;
        private final boolean showInviteSettings;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(GuildInvite guildInvite, ModelInvite.Settings settings, List<? extends InviteSuggestionItemV2> list, Channel channel, String str, Map<String, ? extends Set<Long>> map, boolean z2, long j) {
            Intrinsics3.checkNotNullParameter(list, "inviteSuggestionItems");
            Intrinsics3.checkNotNullParameter(str, "searchQuery");
            Intrinsics3.checkNotNullParameter(map, "sentInvites");
            this.invite = guildInvite;
            this.inviteSettings = settings;
            this.inviteSuggestionItems = list;
            this.channel = channel;
            this.searchQuery = str;
            this.sentInvites = map;
            this.showInviteSettings = z2;
            this.guildId = j;
            this.hasResults = !list.isEmpty();
            this.hasSearchResults = list.size() > 1 && !(list.get(0) instanceof InviteSuggestionItemV2.SearchNoResultsItem);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, GuildInvite guildInvite, ModelInvite.Settings settings, List list, Channel channel, String str, Map map, boolean z2, long j, int i, Object obj) {
            return viewState.copy((i & 1) != 0 ? viewState.invite : guildInvite, (i & 2) != 0 ? viewState.inviteSettings : settings, (i & 4) != 0 ? viewState.inviteSuggestionItems : list, (i & 8) != 0 ? viewState.channel : channel, (i & 16) != 0 ? viewState.searchQuery : str, (i & 32) != 0 ? viewState.sentInvites : map, (i & 64) != 0 ? viewState.showInviteSettings : z2, (i & 128) != 0 ? viewState.guildId : j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final GuildInvite getInvite() {
            return this.invite;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ModelInvite.Settings getInviteSettings() {
            return this.inviteSettings;
        }

        public final List<InviteSuggestionItemV2> component3() {
            return this.inviteSuggestionItems;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getSearchQuery() {
            return this.searchQuery;
        }

        public final Map<String, Set<Long>> component6() {
            return this.sentInvites;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getShowInviteSettings() {
            return this.showInviteSettings;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        public final ViewState copy(GuildInvite invite, ModelInvite.Settings inviteSettings, List<? extends InviteSuggestionItemV2> inviteSuggestionItems, Channel channel, String searchQuery, Map<String, ? extends Set<Long>> sentInvites, boolean showInviteSettings, long guildId) {
            Intrinsics3.checkNotNullParameter(inviteSuggestionItems, "inviteSuggestionItems");
            Intrinsics3.checkNotNullParameter(searchQuery, "searchQuery");
            Intrinsics3.checkNotNullParameter(sentInvites, "sentInvites");
            return new ViewState(invite, inviteSettings, inviteSuggestionItems, channel, searchQuery, sentInvites, showInviteSettings, guildId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.invite, viewState.invite) && Intrinsics3.areEqual(this.inviteSettings, viewState.inviteSettings) && Intrinsics3.areEqual(this.inviteSuggestionItems, viewState.inviteSuggestionItems) && Intrinsics3.areEqual(this.channel, viewState.channel) && Intrinsics3.areEqual(this.searchQuery, viewState.searchQuery) && Intrinsics3.areEqual(this.sentInvites, viewState.sentInvites) && this.showInviteSettings == viewState.showInviteSettings && this.guildId == viewState.guildId;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final boolean getHasResults() {
            return this.hasResults;
        }

        public final boolean getHasSearchResults() {
            return this.hasSearchResults;
        }

        public final GuildInvite getInvite() {
            return this.invite;
        }

        public final ModelInvite.Settings getInviteSettings() {
            return this.inviteSettings;
        }

        public final List<InviteSuggestionItemV2> getInviteSuggestionItems() {
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

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v14, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v9 */
        public int hashCode() {
            GuildInvite guildInvite = this.invite;
            int iHashCode = (guildInvite != null ? guildInvite.hashCode() : 0) * 31;
            ModelInvite.Settings settings = this.inviteSettings;
            int iHashCode2 = (iHashCode + (settings != null ? settings.hashCode() : 0)) * 31;
            List<InviteSuggestionItemV2> list = this.inviteSuggestionItems;
            int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
            Channel channel = this.channel;
            int iHashCode4 = (iHashCode3 + (channel != null ? channel.hashCode() : 0)) * 31;
            String str = this.searchQuery;
            int iHashCode5 = (iHashCode4 + (str != null ? str.hashCode() : 0)) * 31;
            Map<String, Set<Long>> map = this.sentInvites;
            int iHashCode6 = (iHashCode5 + (map != null ? map.hashCode() : 0)) * 31;
            boolean z2 = this.showInviteSettings;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return b.a(this.guildId) + ((iHashCode6 + r1) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(invite=");
            sbU.append(this.invite);
            sbU.append(", inviteSettings=");
            sbU.append(this.inviteSettings);
            sbU.append(", inviteSuggestionItems=");
            sbU.append(this.inviteSuggestionItems);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", searchQuery=");
            sbU.append(this.searchQuery);
            sbU.append(", sentInvites=");
            sbU.append(this.sentInvites);
            sbU.append(", showInviteSettings=");
            sbU.append(this.showInviteSettings);
            sbU.append(", guildId=");
            return outline.C(sbU, this.guildId, ")");
        }

        public /* synthetic */ ViewState(GuildInvite guildInvite, ModelInvite.Settings settings, List list, Channel channel, String str, Map map, boolean z2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(guildInvite, settings, list, channel, (i & 16) != 0 ? "" : str, map, z2, j);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildInviteShareSheetViewModel(Long l, long j, StoreInviteSettings storeInviteSettings, StoreAnalytics storeAnalytics, StoreMessages storeMessages, TargetChannelSelector targetChannelSelector, Logger logger, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeInviteSettings, "storeInviteSettings");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        Intrinsics3.checkNotNullParameter(storeMessages, "storeMessages");
        Intrinsics3.checkNotNullParameter(targetChannelSelector, "targetChannelSelector");
        Intrinsics3.checkNotNullParameter(logger, "logger");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = l;
        this.guildId = j;
        this.storeInviteSettings = storeInviteSettings;
        this.storeAnalytics = storeAnalytics;
        this.storeMessages = storeMessages;
        this.targetChannelSelector = targetChannelSelector;
        this.logger = logger;
        BehaviorSubject<String> behaviorSubjectL0 = BehaviorSubject.l0("");
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(\"\")");
        this.searchQuerySubject = behaviorSubjectL0;
        this.searchQuery = "";
        this.sentInvites = Maps6.emptyMap();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) GuildInviteShareSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        Observable<String> observableP = this.searchQuerySubject.p(250L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableP, "searchQuerySubject\n     …0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableP, this, null, 2, null), (Class<?>) GuildInviteShareSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }
}

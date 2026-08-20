package com.discord.widgets.guilds.invite;

import androidx.annotation.MainThread;
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
import com.discord.utilities.guilds.GuildUtilsKt;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.messagesend.MessageResult;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.recycler.DiffKeyProvider;
import com.discord.utilities.rest.RestAPI;
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
import p001a0.p002a.p003a.C0002b;
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
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func7;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: GuildInviteShareSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildInviteShareSheetViewModel extends AbstractC0859d0<ViewState> {

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

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel$1 */
    /* JADX INFO: compiled from: GuildInviteShareSheetViewModel.kt */
    public static final class C86201 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C86201() {
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
            GuildInviteShareSheetViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel$2 */
    /* JADX INFO: compiled from: GuildInviteShareSheetViewModel.kt */
    public static final class C86212 extends AbstractC12240o implements Function1<String, Unit> {
        public C86212() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            GuildInviteShareSheetViewModel guildInviteShareSheetViewModel = GuildInviteShareSheetViewModel.this;
            C12238m.checkNotNullExpressionValue(str, "searchQuery");
            guildInviteShareSheetViewModel.updateSearchQuery(str);
        }
    }

    /* JADX INFO: compiled from: GuildInviteShareSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(long guildId, InviteSuggestionsManager inviteSuggestionsManager, StoreInviteSettings storeInviteSettings, StoreUser storeUser, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreStageInstances storeStageInstances) {
            Observable<StoreState> observableM11069e = Observable.m11069e(storeInviteSettings.getInviteSettings(), storeInviteSettings.getInvitableChannels(guildId), StoreUser.observeMe$default(storeUser, false, 1, null), storeChannels.observeDMs(), storeGuilds.observeGuild(guildId), inviteSuggestionsManager.observeInviteSuggestions(), storeStageInstances.observeStageInstancesForGuild(guildId), new Func7<ModelInvite.Settings, Map<Long, ? extends Channel>, MeUser, List<? extends Channel>, Guild, List<? extends InviteSuggestion>, Map<Long, ? extends StageInstance>, StoreState>() { // from class: com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel$Companion$observeStoreState$1
                @Override // p658rx.functions.Func7
                public /* bridge */ /* synthetic */ GuildInviteShareSheetViewModel.StoreState call(ModelInvite.Settings settings, Map<Long, ? extends Channel> map, MeUser meUser, List<? extends Channel> list, Guild guild, List<? extends InviteSuggestion> list2, Map<Long, ? extends StageInstance> map2) {
                    return call2(settings, (Map<Long, Channel>) map, meUser, (List<Channel>) list, guild, list2, (Map<Long, StageInstance>) map2);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final GuildInviteShareSheetViewModel.StoreState call2(ModelInvite.Settings settings, Map<Long, Channel> map, MeUser meUser, List<Channel> list, Guild guild, List<? extends InviteSuggestion> list2, Map<Long, StageInstance> map2) {
                    if (guild == null) {
                        return GuildInviteShareSheetViewModel.StoreState.Invalid.INSTANCE;
                    }
                    C12238m.checkNotNullExpressionValue(settings, "inviteSettings");
                    C12238m.checkNotNullExpressionValue(map, "invitableChannels");
                    C12238m.checkNotNullExpressionValue(meUser, "me");
                    C12238m.checkNotNullExpressionValue(list, "dms");
                    C12238m.checkNotNullExpressionValue(list2, "inviteSuggestions");
                    C12238m.checkNotNullExpressionValue(map2, "guildStageInstances");
                    return new GuildInviteShareSheetViewModel.StoreState.Valid(settings, map, meUser, list, guild, list2, map2);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11069e, "Observable.combineLatest…      )\n        }\n      }");
            return observableM11069e;
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
                C12238m.checkNotNullParameter(settings, "inviteSettings");
                C12238m.checkNotNullParameter(map, "invitableChannels");
                C12238m.checkNotNullParameter(meUser, "me");
                C12238m.checkNotNullParameter(list, "dms");
                C12238m.checkNotNullParameter(guild, "guild");
                C12238m.checkNotNullParameter(list2, "inviteSuggestions");
                C12238m.checkNotNullParameter(map2, "guildStageInstances");
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
                C12238m.checkNotNullParameter(inviteSettings, "inviteSettings");
                C12238m.checkNotNullParameter(invitableChannels, "invitableChannels");
                C12238m.checkNotNullParameter(me2, "me");
                C12238m.checkNotNullParameter(dms, "dms");
                C12238m.checkNotNullParameter(guild, "guild");
                C12238m.checkNotNullParameter(inviteSuggestions, "inviteSuggestions");
                C12238m.checkNotNullParameter(guildStageInstances, "guildStageInstances");
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
                return C12238m.areEqual(this.inviteSettings, valid.inviteSettings) && C12238m.areEqual(this.invitableChannels, valid.invitableChannels) && C12238m.areEqual(this.me, valid.me) && C12238m.areEqual(this.dms, valid.dms) && C12238m.areEqual(this.guild, valid.guild) && C12238m.areEqual(this.inviteSuggestions, valid.inviteSuggestions) && C12238m.areEqual(this.guildStageInstances, valid.guildStageInstances);
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
                StringBuilder sbM833U = C1643a.m833U("Valid(inviteSettings=");
                sbM833U.append(this.inviteSettings);
                sbM833U.append(", invitableChannels=");
                sbM833U.append(this.invitableChannels);
                sbM833U.append(", me=");
                sbM833U.append(this.me);
                sbM833U.append(", dms=");
                sbM833U.append(this.dms);
                sbM833U.append(", guild=");
                sbM833U.append(this.guild);
                sbM833U.append(", inviteSuggestions=");
                sbM833U.append(this.inviteSuggestions);
                sbM833U.append(", guildStageInstances=");
                return C1643a.m825M(sbM833U, this.guildStageInstances, ")");
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel$generateInviteForChannel$1 */
    /* JADX INFO: compiled from: GuildInviteShareSheetViewModel.kt */
    public static final class C86221 extends AbstractC12240o implements Function1<ModelInvite, Unit> {
        public C86221() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
            invoke2(modelInvite);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelInvite modelInvite) {
            C12238m.checkNotNullParameter(modelInvite, "invite");
            GuildInviteShareSheetViewModel.this.handleInviteCreationSuccess(modelInvite);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel$generateInviteForChannel$2 */
    /* JADX INFO: compiled from: GuildInviteShareSheetViewModel.kt */
    public static final class C86232 extends AbstractC12240o implements Function1<Error, Unit> {
        public C86232() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            GuildInviteShareSheetViewModel.this.handleInviteCreationFailure();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel$sendInviteToChannel$1 */
    /* JADX INFO: compiled from: GuildInviteShareSheetViewModel.kt */
    public static final class C86241 extends AbstractC12240o implements Function1<MessageResult, Unit> {
        public final /* synthetic */ GuildInvite $invite;
        public final /* synthetic */ String $inviteLink;
        public final /* synthetic */ ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C86241(GuildInvite guildInvite, ViewState viewState, String str) {
            super(1);
            this.$invite = guildInvite;
            this.$viewState = viewState;
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
                GuildInviteShareSheetViewModel.this.storeAnalytics.inviteSent(this.$invite, this.$viewState.getChannel(), success.getMessage(), "Guild Create Invite Suggestion");
                Map<String, Set<Long>> sentInvites = this.$viewState.getSentInvites();
                Set<Long> setEmptySet = sentInvites.get(this.$inviteLink);
                if (setEmptySet == null) {
                    setEmptySet = C12148n0.emptySet();
                }
                GuildInviteShareSheetViewModel.this.updateSentInvites(C12136h0.plus(sentInvites, C12134g0.mapOf(C12116o.m10073to(this.$inviteLink, C12150o0.plus(setEmptySet, Long.valueOf(success.getMessage().getChannelId()))))));
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel$sendInviteToUser$1 */
    /* JADX INFO: compiled from: GuildInviteShareSheetViewModel.kt */
    public static final class C86251 extends AbstractC12240o implements Function1<Channel, Unit> {
        public C86251() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            C12238m.checkNotNullParameter(channel, "channel");
            GuildInviteShareSheetViewModel.this.sendInviteToChannel(channel.getId());
        }
    }

    public /* synthetic */ GuildInviteShareSheetViewModel(Long l, long j, StoreInviteSettings storeInviteSettings, StoreAnalytics storeAnalytics, StoreMessages storeMessages, TargetChannelSelector targetChannelSelector, Logger logger, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableObserveStoreState;
        StoreInviteSettings inviteSettings = (i & 4) != 0 ? StoreStream.INSTANCE.getInviteSettings() : storeInviteSettings;
        StoreAnalytics analytics = (i & 8) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics;
        StoreMessages messages = (i & 16) != 0 ? StoreStream.INSTANCE.getMessages() : storeMessages;
        TargetChannelSelector targetChannelSelector2 = (i & 32) != 0 ? new TargetChannelSelector() : targetChannelSelector;
        Logger logger2 = (i & 64) != 0 ? AppLog.f14950g : logger;
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
        Collections.sort(new ArrayList(storeState.getInvitableChannels().values()), ChannelUtils.m7684h(Channel.INSTANCE));
        if (generatedInvite == null || (link = generatedInvite.toLink()) == null) {
            link = BuildConfig.HOST_INVITE;
        }
        Set<Long> setEmptySet = sentInvites.get(link);
        if (setEmptySet == null) {
            setEmptySet = C12148n0.emptySet();
        }
        Set<Long> set = setEmptySet;
        List<InviteSuggestion> inviteSuggestions = storeState.getInviteSuggestions();
        if (!C12103t.isBlank(searchQuery)) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : inviteSuggestions) {
                InviteSuggestion inviteSuggestion = (InviteSuggestion) obj;
                if (inviteSuggestion instanceof InviteSuggestion.ChannelItem) {
                    zContains = C12106w.contains((CharSequence) ChannelUtils.m7679c(((InviteSuggestion.ChannelItem) inviteSuggestion).getChannel()), (CharSequence) searchQuery, true);
                } else {
                    if (!(inviteSuggestion instanceof InviteSuggestion.UserSuggestion)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    zContains = C12106w.contains((CharSequence) ((InviteSuggestion.UserSuggestion) inviteSuggestion).getUser().getUsername(), (CharSequence) searchQuery, true);
                }
                if (zContains) {
                    arrayList2.add(obj);
                }
            }
            inviteSuggestions = arrayList2;
        }
        List<Channel> dms = storeState.getDms();
        ArrayList arrayList3 = new ArrayList(C12149o.collectionSizeOrDefault(dms, 10));
        Iterator<T> it = dms.iterator();
        while (true) {
            Long lValueOf = null;
            if (!it.hasNext()) {
                break;
            }
            Channel channel = (Channel) it.next();
            User userM7677a = ChannelUtils.m7677a(channel);
            if (userM7677a != null) {
                lValueOf = Long.valueOf(userM7677a.getId());
            }
            arrayList3.add(C12116o.m10073to(lValueOf, Long.valueOf(channel.getId())));
        }
        Map map = C12136h0.toMap(arrayList3);
        if ((!inviteSuggestions.isEmpty()) || C12103t.isBlank(searchQuery)) {
            arrayList = new ArrayList(C12149o.collectionSizeOrDefault(inviteSuggestions, 10));
            for (InviteSuggestion inviteSuggestion2 : inviteSuggestions) {
                if (inviteSuggestion2 instanceof InviteSuggestion.ChannelItem) {
                    InviteSuggestion.ChannelItem channelItem = (InviteSuggestion.ChannelItem) inviteSuggestion2;
                    userItem = new InviteSuggestionItemV2.ChannelItem(channelItem.getChannel(), set.contains(Long.valueOf(channelItem.getChannel().getId())), searchQuery);
                } else {
                    if (!(inviteSuggestion2 instanceof InviteSuggestion.UserSuggestion)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    InviteSuggestion.UserSuggestion userSuggestion = (InviteSuggestion.UserSuggestion) inviteSuggestion2;
                    userItem = new InviteSuggestionItemV2.UserItem(userSuggestion.getUser(), C12163u.contains(set, map.get(Long.valueOf(userSuggestion.getUser().getId()))), searchQuery);
                }
                arrayList.add(userItem);
            }
        } else {
            arrayList = C12145m.listOf(InviteSuggestionItemV2.SearchNoResultsItem.INSTANCE);
        }
        return new ViewState(generatedInvite, storeState.getInviteSettings(), arrayList, storeState.getInvitableChannels().get(generatedInvite != null ? generatedInvite.getChannelId() : null), searchQuery, sentInvites, generatedInvite != null ? !generatedInvite.isStaticInvite() : true, storeState.getGuild().getId());
    }

    private final void generateInviteForChannel(long targetChannelId) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(StoreInviteSettings.generateInvite$default(this.storeInviteSettings, targetChannelId, null, 2, null), false, 1, null), this, null, 2, null), (Class<?>) GuildInviteShareSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C86232()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C86221());
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
        ModelInvite modelInviteCreateForStaticUrl = ModelInvite.createForStaticUrl(vanityUrlCode, GuildUtilsKt.createApiGuild(guild));
        GuildInvite.Companion companion = GuildInvite.INSTANCE;
        C12238m.checkNotNullExpressionValue(modelInviteCreateForStaticUrl, "vanityUrlInvite");
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
        if (C12238m.areEqual(storeState, StoreState.Invalid.INSTANCE)) {
            Logger logger = this.logger;
            StringBuilder sbM833U = C1643a.m833U("invalid StoreState in ");
            sbM833U.append(GuildInviteShareSheetViewModel.class.getSimpleName());
            Logger.e$default(logger, sbM833U.toString(), null, null, 6, null);
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
                        ModelInvite modelInviteCreateForStaticUrl = ModelInvite.createForStaticUrl(vanityUrlCode, GuildUtilsKt.createApiGuild(guild));
                        GuildInvite.Companion companion = GuildInvite.INSTANCE;
                        C12238m.checkNotNullExpressionValue(modelInviteCreateForStaticUrl, "vanityUrlInvite");
                        this.invite = companion.createFromModelInvite(modelInviteCreateForStaticUrl);
                    } else if (channel != null) {
                        if (inviteCode != null) {
                            ModelInvite modelInviteCreateForStaticUrl2 = ModelInvite.createForStaticUrl(inviteCode, GuildUtilsKt.createApiGuild(guild));
                            GuildInvite.Companion companion2 = GuildInvite.INSTANCE;
                            C12238m.checkNotNullExpressionValue(modelInviteCreateForStaticUrl2, "stageInstanceInvite");
                            this.invite = companion2.createFromModelInvite(modelInviteCreateForStaticUrl2);
                        }
                    } else if (inviteCode != null) {
                        ModelInvite modelInviteCreateForStaticUrl3 = ModelInvite.createForStaticUrl(inviteCode, GuildUtilsKt.createApiGuild(guild));
                        GuildInvite.Companion companion3 = GuildInvite.INSTANCE;
                        C12238m.checkNotNullExpressionValue(modelInviteCreateForStaticUrl3, "stageInstanceInvite");
                        this.invite = companion3.createFromModelInvite(modelInviteCreateForStaticUrl3);
                    }
                } else if (channel != null && targetChannel != null) {
                    generateInviteForChannel(targetChannel.getId());
                } else if (inviteCode != null) {
                    ModelInvite modelInviteCreateForStaticUrl4 = ModelInvite.createForStaticUrl(inviteCode, GuildUtilsKt.createApiGuild(guild));
                    GuildInvite.Companion companion4 = GuildInvite.INSTANCE;
                    C12238m.checkNotNullExpressionValue(modelInviteCreateForStaticUrl4, "stageInstanceInvite");
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
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(StoreMessages.sendMessage$default(this.storeMessages, channelId, valid.getMe(), link, null, null, null, null, null, null, null, null, null, null, null, null, 32736, null), this, null, 2, null), (Class<?>) GuildInviteShareSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C86241(guildInvite, viewState, link));
    }

    private final void sendInviteToUser(long userId) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().createOrFetchDM(userId), false, 1, null), this, null, 2, null), (Class<?>) GuildInviteShareSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C86251());
    }

    @MainThread
    private final void updateSearchQuery(String searchQuery) {
        StoreState storeState = this.currentStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid == null || C12238m.areEqual(searchQuery, this.searchQuery)) {
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
        C12238m.checkNotNullParameter(searchQuery, "searchQuery");
        this.searchQuerySubject.onNext(searchQuery);
    }

    @MainThread
    public final void sendInvite(InviteSuggestionItemV2 item) {
        C12238m.checkNotNullParameter(item, "item");
        if (item instanceof InviteSuggestionItemV2.ChannelItem) {
            sendInviteToChannel(((InviteSuggestionItemV2.ChannelItem) item).getChannel().getId());
        } else if (item instanceof InviteSuggestionItemV2.UserItem) {
            sendInviteToUser(((InviteSuggestionItemV2.UserItem) item).getUser().getId());
        }
    }

    @MainThread
    public final void updateInvite(GuildInvite invite) {
        C12238m.checkNotNullParameter(invite, "invite");
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

    @Override // p007b.p008a.p018d.AbstractC0859d0
    @MainThread
    public void updateViewState(ViewState viewState) {
        C12238m.checkNotNullParameter(viewState, "viewState");
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
        ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
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
        ArrayList arrayList4 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList3, 10));
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
            C12238m.checkNotNullParameter(list, "inviteSuggestionItems");
            C12238m.checkNotNullParameter(str, "searchQuery");
            C12238m.checkNotNullParameter(map, "sentInvites");
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
            C12238m.checkNotNullParameter(inviteSuggestionItems, "inviteSuggestionItems");
            C12238m.checkNotNullParameter(searchQuery, "searchQuery");
            C12238m.checkNotNullParameter(sentInvites, "sentInvites");
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
            return C12238m.areEqual(this.invite, viewState.invite) && C12238m.areEqual(this.inviteSettings, viewState.inviteSettings) && C12238m.areEqual(this.inviteSuggestionItems, viewState.inviteSuggestionItems) && C12238m.areEqual(this.channel, viewState.channel) && C12238m.areEqual(this.searchQuery, viewState.searchQuery) && C12238m.areEqual(this.sentInvites, viewState.sentInvites) && this.showInviteSettings == viewState.showInviteSettings && this.guildId == viewState.guildId;
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
            return C0002b.m3a(this.guildId) + ((iHashCode6 + r1) * 31);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ViewState(invite=");
            sbM833U.append(this.invite);
            sbM833U.append(", inviteSettings=");
            sbM833U.append(this.inviteSettings);
            sbM833U.append(", inviteSuggestionItems=");
            sbM833U.append(this.inviteSuggestionItems);
            sbM833U.append(", channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", searchQuery=");
            sbM833U.append(this.searchQuery);
            sbM833U.append(", sentInvites=");
            sbM833U.append(this.sentInvites);
            sbM833U.append(", showInviteSettings=");
            sbM833U.append(this.showInviteSettings);
            sbM833U.append(", guildId=");
            return C1643a.m815C(sbM833U, this.guildId, ")");
        }

        public /* synthetic */ ViewState(GuildInvite guildInvite, ModelInvite.Settings settings, List list, Channel channel, String str, Map map, boolean z2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(guildInvite, settings, list, channel, (i & 16) != 0 ? "" : str, map, z2, j);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildInviteShareSheetViewModel(Long l, long j, StoreInviteSettings storeInviteSettings, StoreAnalytics storeAnalytics, StoreMessages storeMessages, TargetChannelSelector targetChannelSelector, Logger logger, Observable<StoreState> observable) {
        super(null, 1, null);
        C12238m.checkNotNullParameter(storeInviteSettings, "storeInviteSettings");
        C12238m.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        C12238m.checkNotNullParameter(storeMessages, "storeMessages");
        C12238m.checkNotNullParameter(targetChannelSelector, "targetChannelSelector");
        C12238m.checkNotNullParameter(logger, "logger");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = l;
        this.guildId = j;
        this.storeInviteSettings = storeInviteSettings;
        this.storeAnalytics = storeAnalytics;
        this.storeMessages = storeMessages;
        this.targetChannelSelector = targetChannelSelector;
        this.logger = logger;
        BehaviorSubject<String> behaviorSubjectM11130l0 = BehaviorSubject.m11130l0("");
        C12238m.checkNotNullExpressionValue(behaviorSubjectM11130l0, "BehaviorSubject.create(\"\")");
        this.searchQuerySubject = behaviorSubjectM11130l0;
        this.searchQuery = "";
        this.sentInvites = C12136h0.emptyMap();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) GuildInviteShareSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C86201());
        Observable<String> observableM11110p = this.searchQuerySubject.m11110p(250L, TimeUnit.MILLISECONDS);
        C12238m.checkNotNullExpressionValue(observableM11110p, "searchQuerySubject\n     …0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11110p, this, null, 2, null), (Class<?>) GuildInviteShareSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C86212());
    }
}

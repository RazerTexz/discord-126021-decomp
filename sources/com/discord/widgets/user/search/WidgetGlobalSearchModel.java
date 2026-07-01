package com.discord.widgets.user.search;

import a0.a.a.b;
import androidx.annotation.StringRes;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.frecency.FrecencyTracker;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableWithLeadingEdgeThrottle;
import com.discord.utilities.search.SearchUtils;
import com.discord.utilities.string.StringUtils2;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.user.search.WidgetGlobalSearchGuildsModel;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.f0._Sequences2;
import d0.f0.n;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.g0._Strings;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.t._Collections;
import d0.u.a;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.Sequence;
import rx.Observable;
import rx.functions.Func2;
import rx.functions.Func4;
import rx.functions.Func6;
import rx.functions.Func7;
import rx.functions.Func8;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetGlobalSearchModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<Channel, Map<Long, Long>, Boolean> DEFAULT_PERMISSIONS_PREDICATE;
    private static final Pattern DISCRIMINATOR_PATTERN;
    private static final int MAX_RESULTS = 50;
    public static final int SEARCH_TYPE_GENERAL = 0;
    public static final int SEARCH_TYPE_GUILD = 3;
    public static final int SEARCH_TYPE_TEXT_CHANNEL = 2;
    public static final int SEARCH_TYPE_USER = 1;
    public static final int SEARCH_TYPE_VOICE_CHANNEL = 4;
    public static final int TYPE_CHANNEL = 0;
    public static final int TYPE_GUILD = 2;
    public static final int TYPE_HEADER = -1;
    public static final int TYPE_USER = 1;
    private final List<ItemDataPayload> data;
    private final String filter;
    private final List<WidgetGlobalSearchGuildsModel.Item> guildsList;
    private final int searchType;

    /* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
    public static final /* data */ class ChannelContext {
        private final Map<Long, Channel> activeJoinedThreads;
        private final Map<Long, Long> channelPerms;
        private final Map<Long, Channel> channels;
        private final Map<Long, Channel> channelsPrivate;
        private final Map<Long, List<Long>> guildToChannels;
        private final Map<Long, Guild> guilds;
        private final Set<Long> smallGuildIds;
        private final Set<Long> unreadChannelIds;
        private final Set<Long> unreadGuildIds;

        /* JADX WARN: Multi-variable type inference failed */
        public ChannelContext(Map<Long, Guild> map, Map<Long, Channel> map2, Map<Long, Channel> map3, Map<Long, Long> map4, Map<Long, Channel> map5, Map<Long, ? extends List<Long>> map6, Set<Long> set, Set<Long> set2) {
            Intrinsics3.checkNotNullParameter(map, "guilds");
            Intrinsics3.checkNotNullParameter(map2, "channels");
            Intrinsics3.checkNotNullParameter(map3, "activeJoinedThreads");
            Intrinsics3.checkNotNullParameter(map4, "channelPerms");
            Intrinsics3.checkNotNullParameter(map5, "channelsPrivate");
            Intrinsics3.checkNotNullParameter(map6, "guildToChannels");
            Intrinsics3.checkNotNullParameter(set, "unreadChannelIds");
            Intrinsics3.checkNotNullParameter(set2, "unreadGuildIds");
            this.guilds = map;
            this.channels = map2;
            this.activeJoinedThreads = map3;
            this.channelPerms = map4;
            this.channelsPrivate = map5;
            this.guildToChannels = map6;
            this.unreadChannelIds = set;
            this.unreadGuildIds = set2;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Long, Guild> entry : map.entrySet()) {
                if (entry.getValue().getMemberCount() <= 200) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            this.smallGuildIds = linkedHashMap.keySet();
        }

        public final Map<Long, Guild> component1() {
            return this.guilds;
        }

        public final Map<Long, Channel> component2() {
            return this.channels;
        }

        public final Map<Long, Channel> component3() {
            return this.activeJoinedThreads;
        }

        public final Map<Long, Long> component4() {
            return this.channelPerms;
        }

        public final Map<Long, Channel> component5() {
            return this.channelsPrivate;
        }

        public final Map<Long, List<Long>> component6() {
            return this.guildToChannels;
        }

        public final Set<Long> component7() {
            return this.unreadChannelIds;
        }

        public final Set<Long> component8() {
            return this.unreadGuildIds;
        }

        public final ChannelContext copy(Map<Long, Guild> guilds, Map<Long, Channel> channels, Map<Long, Channel> activeJoinedThreads, Map<Long, Long> channelPerms, Map<Long, Channel> channelsPrivate, Map<Long, ? extends List<Long>> guildToChannels, Set<Long> unreadChannelIds, Set<Long> unreadGuildIds) {
            Intrinsics3.checkNotNullParameter(guilds, "guilds");
            Intrinsics3.checkNotNullParameter(channels, "channels");
            Intrinsics3.checkNotNullParameter(activeJoinedThreads, "activeJoinedThreads");
            Intrinsics3.checkNotNullParameter(channelPerms, "channelPerms");
            Intrinsics3.checkNotNullParameter(channelsPrivate, "channelsPrivate");
            Intrinsics3.checkNotNullParameter(guildToChannels, "guildToChannels");
            Intrinsics3.checkNotNullParameter(unreadChannelIds, "unreadChannelIds");
            Intrinsics3.checkNotNullParameter(unreadGuildIds, "unreadGuildIds");
            return new ChannelContext(guilds, channels, activeJoinedThreads, channelPerms, channelsPrivate, guildToChannels, unreadChannelIds, unreadGuildIds);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelContext)) {
                return false;
            }
            ChannelContext channelContext = (ChannelContext) other;
            return Intrinsics3.areEqual(this.guilds, channelContext.guilds) && Intrinsics3.areEqual(this.channels, channelContext.channels) && Intrinsics3.areEqual(this.activeJoinedThreads, channelContext.activeJoinedThreads) && Intrinsics3.areEqual(this.channelPerms, channelContext.channelPerms) && Intrinsics3.areEqual(this.channelsPrivate, channelContext.channelsPrivate) && Intrinsics3.areEqual(this.guildToChannels, channelContext.guildToChannels) && Intrinsics3.areEqual(this.unreadChannelIds, channelContext.unreadChannelIds) && Intrinsics3.areEqual(this.unreadGuildIds, channelContext.unreadGuildIds);
        }

        public final Map<Long, Channel> getActiveJoinedThreads() {
            return this.activeJoinedThreads;
        }

        public final Map<Long, Long> getChannelPerms() {
            return this.channelPerms;
        }

        public final Map<Long, Channel> getChannels() {
            return this.channels;
        }

        public final Map<Long, Channel> getChannelsPrivate() {
            return this.channelsPrivate;
        }

        public final Map<Long, List<Long>> getGuildToChannels() {
            return this.guildToChannels;
        }

        public final Map<Long, Guild> getGuilds() {
            return this.guilds;
        }

        public final Set<Long> getSmallGuildIds() {
            return this.smallGuildIds;
        }

        public final Set<Long> getUnreadChannelIds() {
            return this.unreadChannelIds;
        }

        public final Set<Long> getUnreadGuildIds() {
            return this.unreadGuildIds;
        }

        public int hashCode() {
            Map<Long, Guild> map = this.guilds;
            int iHashCode = (map != null ? map.hashCode() : 0) * 31;
            Map<Long, Channel> map2 = this.channels;
            int iHashCode2 = (iHashCode + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, Channel> map3 = this.activeJoinedThreads;
            int iHashCode3 = (iHashCode2 + (map3 != null ? map3.hashCode() : 0)) * 31;
            Map<Long, Long> map4 = this.channelPerms;
            int iHashCode4 = (iHashCode3 + (map4 != null ? map4.hashCode() : 0)) * 31;
            Map<Long, Channel> map5 = this.channelsPrivate;
            int iHashCode5 = (iHashCode4 + (map5 != null ? map5.hashCode() : 0)) * 31;
            Map<Long, List<Long>> map6 = this.guildToChannels;
            int iHashCode6 = (iHashCode5 + (map6 != null ? map6.hashCode() : 0)) * 31;
            Set<Long> set = this.unreadChannelIds;
            int iHashCode7 = (iHashCode6 + (set != null ? set.hashCode() : 0)) * 31;
            Set<Long> set2 = this.unreadGuildIds;
            return iHashCode7 + (set2 != null ? set2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ChannelContext(guilds=");
            sbU.append(this.guilds);
            sbU.append(", channels=");
            sbU.append(this.channels);
            sbU.append(", activeJoinedThreads=");
            sbU.append(this.activeJoinedThreads);
            sbU.append(", channelPerms=");
            sbU.append(this.channelPerms);
            sbU.append(", channelsPrivate=");
            sbU.append(this.channelsPrivate);
            sbU.append(", guildToChannels=");
            sbU.append(this.guildToChannels);
            sbU.append(", unreadChannelIds=");
            sbU.append(this.unreadChannelIds);
            sbU.append(", unreadGuildIds=");
            return outline.N(sbU, this.unreadGuildIds, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WidgetGlobalSearchModel create$default(Companion companion, SearchContext searchContext, UsersContext usersContext, ChannelContext channelContext, WidgetGlobalSearchGuildsModel widgetGlobalSearchGuildsModel, Function1 function1, Function1 function2, int i, Object obj) {
            if ((i & 16) != 0) {
                function1 = null;
            }
            Function1 function3 = function1;
            if ((i & 32) != 0) {
                function2 = WidgetGlobalSearchModel$Companion$create$1.INSTANCE;
            }
            return companion.create(searchContext, usersContext, channelContext, widgetGlobalSearchGuildsModel, function3, function2);
        }

        private final Observable<WidgetGlobalSearchModel> get(Observable<String> filterPublisher, final Function2<? super Channel, ? super Map<Long, Long>, Boolean> permissionsPredicate, Function1<? super ItemDataPayload, Boolean> resultsFilter, Function1<? super SearchContext, Long> lastChannelIdProvider) {
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable("");
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<List<Long>> observableObserveRecentSelectedGuildIds = companion.getGuildSelected().observeRecentSelectedGuildIds();
            Observable<Long> observableObserveId = companion.getChannelsSelected().observeId();
            Observable<Long> observableObservePreviousId = companion.getChannelsSelected().observePreviousId();
            Observable<Long> observableObserveSelectedVoiceChannelId = companion.getVoiceChannelSelected().observeSelectedVoiceChannelId();
            Observable<Map<Long, Long>> observableObserveRecentMessageIds = companion.getMessagesMostRecent().observeRecentMessageIds();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            Observable observableLeadingEdgeThrottle = ObservableExtensionsKt.leadingEdgeThrottle(observableObserveRecentMessageIds, 10L, timeUnit);
            Observable<Map<Long, Integer>> observableObserveMentionCounts = companion.getMentions().observeMentionCounts();
            final WidgetGlobalSearchModel$Companion$get$partialSearchContextObservable$1 widgetGlobalSearchModel$Companion$get$partialSearchContextObservable$1 = WidgetGlobalSearchModel$Companion$get$partialSearchContextObservable$1.INSTANCE;
            Object obj = widgetGlobalSearchModel$Companion$get$partialSearchContextObservable$1;
            if (widgetGlobalSearchModel$Companion$get$partialSearchContextObservable$1 != null) {
                obj = new Func7() { // from class: com.discord.widgets.user.search.WidgetGlobalSearchModel$sam$rx_functions_Func7$0
                    @Override // rx.functions.Func7
                    public final /* synthetic */ Object call(Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
                        return widgetGlobalSearchModel$Companion$get$partialSearchContextObservable$1.invoke(obj2, obj3, obj4, obj5, obj6, obj7, obj8);
                    }
                };
            }
            Observable observableR = ObservableWithLeadingEdgeThrottle.combineLatest(scalarSynchronousObservable, observableObserveRecentSelectedGuildIds, observableObserveId, observableObservePreviousId, observableObserveSelectedVoiceChannelId, observableLeadingEdgeThrottle, observableObserveMentionCounts, (Func7) obj, 2L, timeUnit).r();
            WidgetGlobalSearchModel$Companion$get$searchContextObservable$1 widgetGlobalSearchModel$Companion$get$searchContextObservable$1 = new Func2<String, SearchContext, SearchContext>() { // from class: com.discord.widgets.user.search.WidgetGlobalSearchModel$Companion$get$searchContextObservable$1
                @Override // rx.functions.Func2
                public final WidgetGlobalSearchModel.SearchContext call(String str, WidgetGlobalSearchModel.SearchContext searchContext) {
                    Intrinsics3.checkNotNullExpressionValue(str, "filterStr");
                    return searchContext.copy((126 & 1) != 0 ? searchContext.filter : str, (126 & 2) != 0 ? searchContext.recentGuildIds : null, (126 & 4) != 0 ? searchContext.selectedChannelId : 0L, (126 & 8) != 0 ? searchContext.prevSelectedChannelId : 0L, (126 & 16) != 0 ? searchContext.selectedVoiceChannelId : 0L, (126 & 32) != 0 ? searchContext.mostRecent : null, (126 & 64) != 0 ? searchContext.mentionCounts : null);
                }
            };
            TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
            Observable observableR2 = ObservableWithLeadingEdgeThrottle.combineLatest(filterPublisher, observableR, widgetGlobalSearchModel$Companion$get$searchContextObservable$1, 250L, timeUnit2).r();
            Observable<Map<Long, User>> observableObserveAllUsers = companion.getUsers().observeAllUsers();
            Observable<Map<Long, Presence>> observableObserveAllPresences = companion.getPresences().observeAllPresences();
            Observable<Map<Long, Integer>> observableObserve = companion.getUserRelationships().observe();
            Observable<Map<Long, Map<Long, GuildMember>>> observableObserveComputed = companion.getGuilds().observeComputed();
            final WidgetGlobalSearchModel$Companion$get$usersContextObservable$1 widgetGlobalSearchModel$Companion$get$usersContextObservable$1 = WidgetGlobalSearchModel$Companion$get$usersContextObservable$1.INSTANCE;
            Object obj2 = widgetGlobalSearchModel$Companion$get$usersContextObservable$1;
            if (widgetGlobalSearchModel$Companion$get$usersContextObservable$1 != null) {
                obj2 = new Func4() { // from class: com.discord.widgets.user.search.WidgetGlobalSearchModel$sam$rx_functions_Func4$0
                    @Override // rx.functions.Func4
                    public final /* synthetic */ Object call(Object obj3, Object obj4, Object obj5, Object obj6) {
                        return widgetGlobalSearchModel$Companion$get$usersContextObservable$1.invoke(obj3, obj4, obj5, obj6);
                    }
                };
            }
            Observable observableR3 = ObservableWithLeadingEdgeThrottle.combineLatest(observableObserveAllUsers, observableObserveAllPresences, observableObserve, observableObserveComputed, (Func4) obj2, 10L, timeUnit).r();
            Observable<Map<Long, Guild>> observableObserveGuilds = companion.getGuilds().observeGuilds();
            Observable<Map<Long, Channel>> observableObserveGuildAndPrivateChannels = companion.getChannels().observeGuildAndPrivateChannels();
            Observable<Map<Long, Channel>> observableObserveAllActiveJoinedThreadsChannelsById = companion.getThreadsActiveJoined().observeAllActiveJoinedThreadsChannelsById();
            Observable<Map<Long, Long>> observableObservePermissionsForAllChannels = companion.getPermissions().observePermissionsForAllChannels();
            Observable<Map<Long, Channel>> observableObservePrivateChannels = companion.getChannels().observePrivateChannels();
            Observable<Map<Long, List<Long>>> observableObserveIds = companion.getChannels().observeIds(true);
            Observable<Set<Long>> unreadChannelIds = companion.getReadStates().getUnreadChannelIds();
            Observable<Set<Long>> unreadGuildIds = companion.getReadStates().getUnreadGuildIds();
            final WidgetGlobalSearchModel$Companion$get$channelContextObservable$1 widgetGlobalSearchModel$Companion$get$channelContextObservable$1 = WidgetGlobalSearchModel$Companion$get$channelContextObservable$1.INSTANCE;
            Object obj3 = widgetGlobalSearchModel$Companion$get$channelContextObservable$1;
            if (widgetGlobalSearchModel$Companion$get$channelContextObservable$1 != null) {
                obj3 = new Func8() { // from class: com.discord.widgets.user.search.WidgetGlobalSearchModel$sam$rx_functions_Func8$0
                    @Override // rx.functions.Func8
                    public final /* synthetic */ Object call(Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11) {
                        return widgetGlobalSearchModel$Companion$get$channelContextObservable$1.invoke(obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11);
                    }
                };
            }
            Observable observableR4 = ObservableWithLeadingEdgeThrottle.combineLatest(observableObserveGuilds, observableObserveGuildAndPrivateChannels, observableObserveAllActiveJoinedThreadsChannelsById, observableObservePermissionsForAllChannels, observableObservePrivateChannels, observableObserveIds, unreadChannelIds, unreadGuildIds, (Func8) obj3, 3L, timeUnit).G(new Func1<ChannelContext, ChannelContext>() { // from class: com.discord.widgets.user.search.WidgetGlobalSearchModel$Companion$get$channelContextObservable$2
                @Override // j0.k.Func1
                public final WidgetGlobalSearchModel.ChannelContext call(WidgetGlobalSearchModel.ChannelContext channelContext) {
                    Map mapPlus = Maps6.plus(channelContext.getChannels(), channelContext.getActiveJoinedThreads());
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry entry : mapPlus.entrySet()) {
                        if (((Boolean) permissionsPredicate.invoke((Channel) entry.getValue(), channelContext.getChannelPerms())).booleanValue()) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                    return channelContext.copy((253 & 1) != 0 ? channelContext.guilds : null, (253 & 2) != 0 ? channelContext.channels : linkedHashMap, (253 & 4) != 0 ? channelContext.activeJoinedThreads : null, (253 & 8) != 0 ? channelContext.channelPerms : null, (253 & 16) != 0 ? channelContext.channelsPrivate : null, (253 & 32) != 0 ? channelContext.guildToChannels : null, (253 & 64) != 0 ? channelContext.unreadChannelIds : null, (253 & 128) != 0 ? channelContext.unreadGuildIds : null);
                }
            }).r();
            Observable observableR5 = ObservableWithLeadingEdgeThrottle.combineLatest(observableR2, observableR4, companion.getUserGuildSettings().observeGuildSettings(), companion.getGuildsSorted().observeOrderedGuilds(), new Func4<SearchContext, ChannelContext, Map<Long, ? extends ModelNotificationSettings>, LinkedHashMap<Long, Guild>, WidgetGlobalSearchGuildsModel>() { // from class: com.discord.widgets.user.search.WidgetGlobalSearchModel$Companion$get$guildsListObservable$1
                @Override // rx.functions.Func4
                public final WidgetGlobalSearchGuildsModel call(WidgetGlobalSearchModel.SearchContext searchContext, WidgetGlobalSearchModel.ChannelContext channelContext, Map<Long, ? extends ModelNotificationSettings> map, LinkedHashMap<Long, Guild> linkedHashMap) {
                    WidgetGlobalSearchGuildsModel.Companion companion2 = WidgetGlobalSearchGuildsModel.INSTANCE;
                    List<Long> recentGuildIds = searchContext.getRecentGuildIds();
                    long selectedVoiceChannelId = searchContext.getSelectedVoiceChannelId();
                    Set<Long> unreadGuildIds2 = channelContext.getUnreadGuildIds();
                    Map<Long, Integer> mentionCounts = searchContext.getMentionCounts();
                    Map<Long, Channel> channelsPrivate = channelContext.getChannelsPrivate();
                    Intrinsics3.checkNotNullExpressionValue(linkedHashMap, "sortedGuilds");
                    Map<Long, List<Long>> guildToChannels = channelContext.getGuildToChannels();
                    Intrinsics3.checkNotNullExpressionValue(map, "guildSettings");
                    return companion2.create(recentGuildIds, selectedVoiceChannelId, unreadGuildIds2, mentionCounts, channelsPrivate, linkedHashMap, guildToChannels, map);
                }
            }, 5L, timeUnit).r();
            ScalarSynchronousObservable scalarSynchronousObservable2 = new ScalarSynchronousObservable(resultsFilter);
            ScalarSynchronousObservable scalarSynchronousObservable3 = new ScalarSynchronousObservable(lastChannelIdProvider);
            final WidgetGlobalSearchModel$Companion$get$1 widgetGlobalSearchModel$Companion$get$1 = new WidgetGlobalSearchModel$Companion$get$1(this);
            Observable<WidgetGlobalSearchModel> observableR6 = ObservableWithLeadingEdgeThrottle.combineLatest(observableR2, observableR3, observableR4, observableR5, scalarSynchronousObservable2, scalarSynchronousObservable3, new Func6() { // from class: com.discord.widgets.user.search.WidgetGlobalSearchModel$sam$rx_functions_Func6$0
                @Override // rx.functions.Func6
                public final /* synthetic */ Object call(Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
                    return widgetGlobalSearchModel$Companion$get$1.invoke(obj4, obj5, obj6, obj7, obj8, obj9);
                }
            }, 200L, timeUnit2).r();
            Intrinsics3.checkNotNullExpressionValue(observableR6, "ObservableWithLeadingEdg…  .distinctUntilChanged()");
            return observableR6;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Observable get$default(Companion companion, Observable observable, Function2 function2, Function1 function1, Function1 function3, int i, Object obj) {
            if ((i & 4) != 0) {
                function1 = null;
            }
            return companion.get(observable, function2, function1, function3);
        }

        private final Sequence<User> getDefaultUserSearch(SearchContext searchContext, ChannelContext channelContext, UsersContext usersContext, Set<Long> selectedGuildUserIds) {
            Sequence sequenceMapNotNull = _Sequences2.mapNotNull(getRecentChannelIds(searchContext), new WidgetGlobalSearchModel$Companion$getDefaultUserSearch$recentDmUserIds$1(channelContext));
            return _Sequences2.filterNot(_Sequences2.take(_Sequences2.mapNotNull(_Sequences2.distinct(_Sequences2.plus(_Sequences2.plus(sequenceMapNotNull, (Iterable) selectedGuildUserIds), n.flattenSequenceOfIterable(_Sequences2.mapNotNull(_Collections.asSequence(channelContext.getSmallGuildIds()), new WidgetGlobalSearchModel$Companion$getDefaultUserSearch$smallGuildUserIds$1(usersContext))))), new WidgetGlobalSearchModel$Companion$getDefaultUserSearch$1(usersContext)), 100), WidgetGlobalSearchModel$Companion$getDefaultUserSearch$2.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Observable getForSend$default(Companion companion, Observable observable, Function1 function1, int i, Object obj) {
            if ((i & 2) != 0) {
                function1 = null;
            }
            return companion.getForSend(observable, function1);
        }

        private final Sequence<Long> getRecentChannelIds(SearchContext searchContext) {
            return searchContext.getFrecencyChannels().isEmpty() ^ true ? _Collections.asSequence(searchContext.getFrecencyChannels()) : _Sequences2.map(_Sequences2.take(_Collections.asSequence(_Collections.sortedWith(searchContext.getMostRecent().entrySet(), new Comparator() { // from class: com.discord.widgets.user.search.WidgetGlobalSearchModel$Companion$getRecentChannelIds$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return a.compareValues((Long) ((Map.Entry) t).getValue(), (Long) ((Map.Entry) t2).getValue());
                }
            })), 50), WidgetGlobalSearchModel$Companion$getRecentChannelIds$2.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final WidgetGlobalSearchModel create(final SearchContext searchContext, UsersContext usersContext, ChannelContext channelContext, WidgetGlobalSearchGuildsModel widgetGuildsListModel, Function1<? super ItemDataPayload, Boolean> resultsFilter, Function1<? super SearchContext, Long> lastChannelIdProvider) {
            Set<Long> setEmptySet;
            Sequence sequenceMapNotNull;
            Sequence sequenceMapNotNull2;
            Intrinsics3.checkNotNullParameter(searchContext, "searchContext");
            Intrinsics3.checkNotNullParameter(usersContext, "usersContext");
            Intrinsics3.checkNotNullParameter(channelContext, "channelContext");
            Intrinsics3.checkNotNullParameter(widgetGuildsListModel, "widgetGuildsListModel");
            Intrinsics3.checkNotNullParameter(lastChannelIdProvider, "lastChannelIdProvider");
            WidgetGlobalSearchModel$Companion$create$2 widgetGlobalSearchModel$Companion$create$2 = new WidgetGlobalSearchModel$Companion$create$2(usersContext, searchContext, channelContext);
            WidgetGlobalSearchModel$Companion$create$3 widgetGlobalSearchModel$Companion$create$3 = new WidgetGlobalSearchModel$Companion$create$3(channelContext, searchContext);
            WidgetGlobalSearchModel$Companion$create$4 widgetGlobalSearchModel$Companion$create$4 = new WidgetGlobalSearchModel$Companion$create$4(channelContext, widgetGlobalSearchModel$Companion$create$2, searchContext);
            int searchType = searchContext.getSearchType();
            String sanitizedFilter = searchContext.getSanitizedFilter();
            Map<Long, GuildMember> map = usersContext.getMembers().get(_Collections.first((List) searchContext.getRecentGuildIds()));
            if (map == null || (setEmptySet = map.keySet()) == null) {
                setEmptySet = Sets5.emptySet();
            }
            Set<Long> set = setEmptySet;
            if (searchType != 1) {
                if (searchType == 2) {
                    sequenceMapNotNull2 = _Sequences2.mapNotNull(_Sequences2.filter(_Collections.asSequence(channelContext.getChannels().values()), WidgetGlobalSearchModel$Companion$create$filteredResults$3.INSTANCE), new WidgetGlobalSearchModel$Companion$create$filteredResults$4(widgetGlobalSearchModel$Companion$create$4, sanitizedFilter));
                } else if (searchType == 3) {
                    sequenceMapNotNull2 = _Sequences2.mapNotNull(_Collections.asSequence(channelContext.getGuilds().values()), new WidgetGlobalSearchModel$Companion$create$filteredResults$2(widgetGlobalSearchModel$Companion$create$3, sanitizedFilter));
                } else if (searchType == 4) {
                    sequenceMapNotNull2 = _Sequences2.sortedWith(_Sequences2.mapNotNull(_Sequences2.filter(_Sequences2.filter(_Collections.asSequence(channelContext.getChannels().values()), WidgetGlobalSearchModel$Companion$create$filteredResults$5.INSTANCE), new WidgetGlobalSearchModel$Companion$create$filteredResults$6(channelContext)), new WidgetGlobalSearchModel$Companion$create$filteredResults$7(widgetGlobalSearchModel$Companion$create$4, sanitizedFilter)), new Comparator() { // from class: com.discord.widgets.user.search.WidgetGlobalSearchModel$Companion$create$$inlined$sortedBy$1
                        /* JADX WARN: Code duplicated, block: B:13:0x0039  */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            int iIntValue;
                            Channel channel = ((WidgetGlobalSearchModel.ItemDataPayload) t).getChannel();
                            int iIntValue2 = Integer.MAX_VALUE;
                            if (channel != null) {
                                Integer numValueOf = Integer.valueOf(searchContext.getRecentGuildIds().indexOf(Long.valueOf(channel.getGuildId())));
                                if (!(numValueOf.intValue() != -1)) {
                                    numValueOf = null;
                                }
                                if (numValueOf != null) {
                                    iIntValue = numValueOf.intValue();
                                } else {
                                    iIntValue = Integer.MAX_VALUE;
                                }
                            } else {
                                iIntValue = Integer.MAX_VALUE;
                            }
                            Integer numValueOf2 = Integer.valueOf(iIntValue);
                            Channel channel2 = ((WidgetGlobalSearchModel.ItemDataPayload) t2).getChannel();
                            if (channel2 != null) {
                                Integer numValueOf3 = Integer.valueOf(searchContext.getRecentGuildIds().indexOf(Long.valueOf(channel2.getGuildId())));
                                Integer num = numValueOf3.intValue() != -1 ? numValueOf3 : null;
                                if (num != null) {
                                    iIntValue2 = num.intValue();
                                }
                            }
                            return a.compareValues(numValueOf2, Integer.valueOf(iIntValue2));
                        }
                    });
                } else if (StringsJVM.isBlank(sanitizedFilter)) {
                    sequenceMapNotNull2 = _Sequences2.mapNotNull(_Sequences2.filter(_Sequences2.mapNotNull(_Collections.asSequence(_Collections.union(searchContext.getMentionCounts().keySet(), _Sequences2.asIterable(getRecentChannelIds(searchContext)))), new WidgetGlobalSearchModel$Companion$create$filteredResults$9(channelContext)), WidgetGlobalSearchModel$Companion$create$filteredResults$10.INSTANCE), new WidgetGlobalSearchModel$Companion$create$filteredResults$11(widgetGlobalSearchModel$Companion$create$4, sanitizedFilter));
                } else {
                    HashSet hashSet = new HashSet();
                    sequenceMapNotNull2 = _Sequences2.plus(_Sequences2.mapNotNull(_Sequences2.filter(_Collections.asSequence(channelContext.getChannels().values()), WidgetGlobalSearchModel$Companion$create$filteredResults$channelResults$1.INSTANCE), new WidgetGlobalSearchModel$Companion$create$filteredResults$channelResults$2(hashSet, widgetGlobalSearchModel$Companion$create$2, usersContext, sanitizedFilter, widgetGlobalSearchModel$Companion$create$4)), _Sequences2.mapNotNull(_Sequences2.filterNot(_Collections.asSequence(set), new WidgetGlobalSearchModel$Companion$create$filteredResults$selectedGuildUserResults$1(hashSet)), new WidgetGlobalSearchModel$Companion$create$filteredResults$selectedGuildUserResults$2(widgetGlobalSearchModel$Companion$create$2, usersContext, sanitizedFilter)));
                }
                sequenceMapNotNull = sequenceMapNotNull2;
            } else {
                sequenceMapNotNull = _Sequences2.mapNotNull(StringsJVM.isBlank(sanitizedFilter) ? getDefaultUserSearch(searchContext, channelContext, usersContext, set) : _Collections.asSequence(usersContext.getUsers().values()), new WidgetGlobalSearchModel$Companion$create$filteredResults$1(widgetGlobalSearchModel$Companion$create$2, sanitizedFilter));
            }
            if (resultsFilter != null) {
                sequenceMapNotNull = _Sequences2.filter(sequenceMapNotNull, resultsFilter);
            }
            Sequence sequenceTake = _Sequences2.take(_Sequences2.sortedWith(sequenceMapNotNull, new Comparator() { // from class: com.discord.widgets.user.search.WidgetGlobalSearchModel$Companion$create$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    WidgetGlobalSearchScoreStrategy widgetGlobalSearchScoreStrategy = WidgetGlobalSearchScoreStrategy.INSTANCE;
                    return a.compareValues(Integer.valueOf(widgetGlobalSearchScoreStrategy.score((WidgetGlobalSearchModel.ItemDataPayload) t2, searchContext.getSearchType(), searchContext.getFrecencyChannels())), Integer.valueOf(widgetGlobalSearchScoreStrategy.score((WidgetGlobalSearchModel.ItemDataPayload) t, searchContext.getSearchType(), searchContext.getFrecencyChannels())));
                }
            }), 50);
            if (searchType == 0 && StringsJVM.isBlank(searchContext.getFilter())) {
                Channel channel = channelContext.getChannels().get(lastChannelIdProvider.invoke(searchContext));
                ItemDataPayload itemDataPayloadInvoke2 = channel != null ? widgetGlobalSearchModel$Companion$create$4.invoke(channel, "") : null;
                return new WidgetGlobalSearchModel(sanitizedFilter, searchType, _Sequences2.toList(itemDataPayloadInvoke2 == null ? _Sequences2.plus(n.sequenceOf(new ItemHeader(R.string.suggestions, 0, false, 6, null)), sequenceTake) : _Sequences2.plus(_Sequences2.plus(n.sequenceOf(new ItemHeader(R.string.quickswitcher_last_channel, 0, false, 6, null), itemDataPayloadInvoke2), n.sequenceOf(new ItemHeader(R.string.suggestions, 0, 0 == true ? 1 : 0, 6, null))), _Sequences2.filterNot(sequenceTake, new WidgetGlobalSearchModel$Companion$create$results$1(channel)))), widgetGuildsListModel.getItems());
            }
            if (_Sequences2.firstOrNull(sequenceTake) != null) {
                sequenceTake = _Sequences2.plus(n.sequenceOf(new ItemHeader(R.string.suggestions, 0, false, 6, null)), sequenceTake);
            }
            return new WidgetGlobalSearchModel(sanitizedFilter, searchType, _Sequences2.toList(sequenceTake), null, 8, null);
        }

        public final MatchedResult getEMPTY_MATCH_RESULT() {
            return new MatchedResult("", -1, 0);
        }

        public final Observable<WidgetGlobalSearchModel> getForNav(Observable<String> filterPublisher) {
            Intrinsics3.checkNotNullParameter(filterPublisher, "filterPublisher");
            return get$default(this, filterPublisher, WidgetGlobalSearchModel.DEFAULT_PERMISSIONS_PREDICATE, null, WidgetGlobalSearchModel$Companion$getForNav$1.INSTANCE, 4, null);
        }

        public final Observable<WidgetGlobalSearchModel> getForSend(Observable<String> filterPublisher, Function1<? super ItemDataPayload, Boolean> resultsFilter) {
            Intrinsics3.checkNotNullParameter(filterPublisher, "filterPublisher");
            return get(filterPublisher, WidgetGlobalSearchModel$Companion$getForSend$1.INSTANCE, resultsFilter, WidgetGlobalSearchModel$Companion$getForSend$2.INSTANCE);
        }

        public final MatchedResult toFuzzyMatchedResult(String str, String str2) {
            Intrinsics3.checkNotNullParameter(str, "$this$toFuzzyMatchedResult");
            Intrinsics3.checkNotNullParameter(str2, "filter");
            SearchUtils searchUtils = SearchUtils.INSTANCE;
            Locale locale = Locale.ROOT;
            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
            String lowerCase = str2.toLowerCase(locale);
            Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
            String lowerCase2 = str.toLowerCase(locale);
            Intrinsics3.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
            if (searchUtils.fuzzyMatch(lowerCase, StringUtils2.stripAccents(lowerCase2))) {
                return new MatchedResult(str, -1, str2.length());
            }
            return null;
        }

        public final MatchedResult toMatchedResult(String str, String str2) {
            Intrinsics3.checkNotNullParameter(str, "$this$toMatchedResult");
            Intrinsics3.checkNotNullParameter(str2, "filter");
            int iIndexOf$default = Strings4.indexOf$default((CharSequence) str, str2, 0, true, 2, (Object) null);
            if (iIndexOf$default != -1) {
                return new MatchedResult(str, iIndexOf$default, str2.length());
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
    public interface ItemDataPayload extends MGRecyclerDataPayload {
        Channel getChannel();

        MatchedResult getMatchedResult();

        int getMentions();

        boolean getUnread();
    }

    /* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
    public static final /* data */ class MatchedResult {
        private final int filterLength;
        private final int firstMatchIndex;
        private final CharSequence value;

        public MatchedResult(CharSequence charSequence, int i, int i2) {
            Intrinsics3.checkNotNullParameter(charSequence, "value");
            this.value = charSequence;
            this.firstMatchIndex = i;
            this.filterLength = i2;
        }

        public static /* synthetic */ MatchedResult copy$default(MatchedResult matchedResult, CharSequence charSequence, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                charSequence = matchedResult.value;
            }
            if ((i3 & 2) != 0) {
                i = matchedResult.firstMatchIndex;
            }
            if ((i3 & 4) != 0) {
                i2 = matchedResult.filterLength;
            }
            return matchedResult.copy(charSequence, i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CharSequence getValue() {
            return this.value;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getFirstMatchIndex() {
            return this.firstMatchIndex;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getFilterLength() {
            return this.filterLength;
        }

        public final MatchedResult copy(CharSequence value, int firstMatchIndex, int filterLength) {
            Intrinsics3.checkNotNullParameter(value, "value");
            return new MatchedResult(value, firstMatchIndex, filterLength);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MatchedResult)) {
                return false;
            }
            MatchedResult matchedResult = (MatchedResult) other;
            return Intrinsics3.areEqual(this.value, matchedResult.value) && this.firstMatchIndex == matchedResult.firstMatchIndex && this.filterLength == matchedResult.filterLength;
        }

        public final int getFilterLength() {
            return this.filterLength;
        }

        public final int getFirstMatchIndex() {
            return this.firstMatchIndex;
        }

        public final CharSequence getValue() {
            return this.value;
        }

        public int hashCode() {
            CharSequence charSequence = this.value;
            return ((((charSequence != null ? charSequence.hashCode() : 0) * 31) + this.firstMatchIndex) * 31) + this.filterLength;
        }

        public String toString() {
            StringBuilder sbU = outline.U("MatchedResult(value=");
            sbU.append(this.value);
            sbU.append(", firstMatchIndex=");
            sbU.append(this.firstMatchIndex);
            sbU.append(", filterLength=");
            return outline.B(sbU, this.filterLength, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
    public static final /* data */ class SearchContext {
        private final String filter;
        private final Collection<Long> frecencyChannels;
        private final boolean hasDiscriminator;
        private final Map<Long, Integer> mentionCounts;
        private final Map<Long, Long> mostRecent;
        private final long prevSelectedChannelId;
        private final List<Long> recentGuildIds;
        private final String sanitizedFilter;
        private final int searchType;
        private final long selectedChannelId;
        private final long selectedVoiceChannelId;

        public SearchContext(String str, List<Long> list, long j, long j2, long j3, Map<Long, Long> map, Map<Long, Integer> map2) {
            int i;
            String strSubstring;
            Intrinsics3.checkNotNullParameter(str, "filter");
            Intrinsics3.checkNotNullParameter(list, "recentGuildIds");
            Intrinsics3.checkNotNullParameter(map, "mostRecent");
            Intrinsics3.checkNotNullParameter(map2, "mentionCounts");
            this.filter = str;
            this.recentGuildIds = list;
            this.selectedChannelId = j;
            this.prevSelectedChannelId = j2;
            this.selectedVoiceChannelId = j3;
            this.mostRecent = map;
            this.mentionCounts = map2;
            this.frecencyChannels = FrecencyTracker.getSortedKeys$default(StoreStream.INSTANCE.getChannelsSelected().getFrecency(), 0L, 1, null);
            Character chFirstOrNull = _Strings.firstOrNull(str);
            if (chFirstOrNull != null && chFirstOrNull.charValue() == '@') {
                i = 1;
            } else if (chFirstOrNull != null && chFirstOrNull.charValue() == '#') {
                i = 2;
            } else if (chFirstOrNull != null && chFirstOrNull.charValue() == '!') {
                i = 4;
            } else {
                i = (chFirstOrNull != null && chFirstOrNull.charValue() == '*') ? 3 : 0;
            }
            this.searchType = i;
            if (i != 0) {
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                strSubstring = str.substring(1);
                Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            } else {
                strSubstring = str;
            }
            this.sanitizedFilter = strSubstring;
            this.hasDiscriminator = (i == 0 || i == 1) ? WidgetGlobalSearchModel.DISCRIMINATOR_PATTERN.matcher(str).find() : false;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFilter() {
            return this.filter;
        }

        public final List<Long> component2() {
            return this.recentGuildIds;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getSelectedChannelId() {
            return this.selectedChannelId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getPrevSelectedChannelId() {
            return this.prevSelectedChannelId;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final long getSelectedVoiceChannelId() {
            return this.selectedVoiceChannelId;
        }

        public final Map<Long, Long> component6() {
            return this.mostRecent;
        }

        public final Map<Long, Integer> component7() {
            return this.mentionCounts;
        }

        public final SearchContext copy(String filter, List<Long> recentGuildIds, long selectedChannelId, long prevSelectedChannelId, long selectedVoiceChannelId, Map<Long, Long> mostRecent, Map<Long, Integer> mentionCounts) {
            Intrinsics3.checkNotNullParameter(filter, "filter");
            Intrinsics3.checkNotNullParameter(recentGuildIds, "recentGuildIds");
            Intrinsics3.checkNotNullParameter(mostRecent, "mostRecent");
            Intrinsics3.checkNotNullParameter(mentionCounts, "mentionCounts");
            return new SearchContext(filter, recentGuildIds, selectedChannelId, prevSelectedChannelId, selectedVoiceChannelId, mostRecent, mentionCounts);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SearchContext)) {
                return false;
            }
            SearchContext searchContext = (SearchContext) other;
            return Intrinsics3.areEqual(this.filter, searchContext.filter) && Intrinsics3.areEqual(this.recentGuildIds, searchContext.recentGuildIds) && this.selectedChannelId == searchContext.selectedChannelId && this.prevSelectedChannelId == searchContext.prevSelectedChannelId && this.selectedVoiceChannelId == searchContext.selectedVoiceChannelId && Intrinsics3.areEqual(this.mostRecent, searchContext.mostRecent) && Intrinsics3.areEqual(this.mentionCounts, searchContext.mentionCounts);
        }

        public final String getFilter() {
            return this.filter;
        }

        public final Collection<Long> getFrecencyChannels() {
            return this.frecencyChannels;
        }

        public final boolean getHasDiscriminator() {
            return this.hasDiscriminator;
        }

        public final Map<Long, Integer> getMentionCounts() {
            return this.mentionCounts;
        }

        public final Map<Long, Long> getMostRecent() {
            return this.mostRecent;
        }

        public final long getPrevSelectedChannelId() {
            return this.prevSelectedChannelId;
        }

        public final List<Long> getRecentGuildIds() {
            return this.recentGuildIds;
        }

        public final String getSanitizedFilter() {
            return this.sanitizedFilter;
        }

        public final int getSearchType() {
            return this.searchType;
        }

        public final long getSelectedChannelId() {
            return this.selectedChannelId;
        }

        public final long getSelectedVoiceChannelId() {
            return this.selectedVoiceChannelId;
        }

        public int hashCode() {
            String str = this.filter;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            List<Long> list = this.recentGuildIds;
            int iA = (b.a(this.selectedVoiceChannelId) + ((b.a(this.prevSelectedChannelId) + ((b.a(this.selectedChannelId) + ((iHashCode + (list != null ? list.hashCode() : 0)) * 31)) * 31)) * 31)) * 31;
            Map<Long, Long> map = this.mostRecent;
            int iHashCode2 = (iA + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, Integer> map2 = this.mentionCounts;
            return iHashCode2 + (map2 != null ? map2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("SearchContext(filter=");
            sbU.append(this.filter);
            sbU.append(", recentGuildIds=");
            sbU.append(this.recentGuildIds);
            sbU.append(", selectedChannelId=");
            sbU.append(this.selectedChannelId);
            sbU.append(", prevSelectedChannelId=");
            sbU.append(this.prevSelectedChannelId);
            sbU.append(", selectedVoiceChannelId=");
            sbU.append(this.selectedVoiceChannelId);
            sbU.append(", mostRecent=");
            sbU.append(this.mostRecent);
            sbU.append(", mentionCounts=");
            return outline.M(sbU, this.mentionCounts, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
    public static final /* data */ class UsersContext {
        private final Map<Long, Map<Long, GuildMember>> members;
        private final Map<Long, Presence> presences;
        private final Map<Long, Integer> relationships;
        private final Map<Long, User> users;

        /* JADX WARN: Multi-variable type inference failed */
        public UsersContext(Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, Integer> map3, Map<Long, ? extends Map<Long, GuildMember>> map4) {
            Intrinsics3.checkNotNullParameter(map, "users");
            Intrinsics3.checkNotNullParameter(map2, "presences");
            Intrinsics3.checkNotNullParameter(map3, "relationships");
            Intrinsics3.checkNotNullParameter(map4, "members");
            this.users = map;
            this.presences = map2;
            this.relationships = map3;
            this.members = map4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UsersContext copy$default(UsersContext usersContext, Map map, Map map2, Map map3, Map map4, int i, Object obj) {
            if ((i & 1) != 0) {
                map = usersContext.users;
            }
            if ((i & 2) != 0) {
                map2 = usersContext.presences;
            }
            if ((i & 4) != 0) {
                map3 = usersContext.relationships;
            }
            if ((i & 8) != 0) {
                map4 = usersContext.members;
            }
            return usersContext.copy(map, map2, map3, map4);
        }

        public final Map<Long, User> component1() {
            return this.users;
        }

        public final Map<Long, Presence> component2() {
            return this.presences;
        }

        public final Map<Long, Integer> component3() {
            return this.relationships;
        }

        public final Map<Long, Map<Long, GuildMember>> component4() {
            return this.members;
        }

        public final UsersContext copy(Map<Long, ? extends User> users, Map<Long, Presence> presences, Map<Long, Integer> relationships, Map<Long, ? extends Map<Long, GuildMember>> members) {
            Intrinsics3.checkNotNullParameter(users, "users");
            Intrinsics3.checkNotNullParameter(presences, "presences");
            Intrinsics3.checkNotNullParameter(relationships, "relationships");
            Intrinsics3.checkNotNullParameter(members, "members");
            return new UsersContext(users, presences, relationships, members);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UsersContext)) {
                return false;
            }
            UsersContext usersContext = (UsersContext) other;
            return Intrinsics3.areEqual(this.users, usersContext.users) && Intrinsics3.areEqual(this.presences, usersContext.presences) && Intrinsics3.areEqual(this.relationships, usersContext.relationships) && Intrinsics3.areEqual(this.members, usersContext.members);
        }

        public final Map<Long, Map<Long, GuildMember>> getMembers() {
            return this.members;
        }

        public final Map<Long, Presence> getPresences() {
            return this.presences;
        }

        public final Map<Long, Integer> getRelationships() {
            return this.relationships;
        }

        public final Map<Long, User> getUsers() {
            return this.users;
        }

        public int hashCode() {
            Map<Long, User> map = this.users;
            int iHashCode = (map != null ? map.hashCode() : 0) * 31;
            Map<Long, Presence> map2 = this.presences;
            int iHashCode2 = (iHashCode + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, Integer> map3 = this.relationships;
            int iHashCode3 = (iHashCode2 + (map3 != null ? map3.hashCode() : 0)) * 31;
            Map<Long, Map<Long, GuildMember>> map4 = this.members;
            return iHashCode3 + (map4 != null ? map4.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("UsersContext(users=");
            sbU.append(this.users);
            sbU.append(", presences=");
            sbU.append(this.presences);
            sbU.append(", relationships=");
            sbU.append(this.relationships);
            sbU.append(", members=");
            return outline.M(sbU, this.members, ")");
        }
    }

    static {
        Pattern patternCompile = Pattern.compile("[^\\s]#\\d{0,4}$", 0);
        Intrinsics3.checkNotNullExpressionValue(patternCompile, "java.util.regex.Pattern.compile(this, flags)");
        DISCRIMINATOR_PATTERN = patternCompile;
        DEFAULT_PERMISSIONS_PREDICATE = WidgetGlobalSearchModel$Companion$DEFAULT_PERMISSIONS_PREDICATE$1.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetGlobalSearchModel(String str, int i, List<? extends ItemDataPayload> list, List<WidgetGlobalSearchGuildsModel.Item> list2) {
        Intrinsics3.checkNotNullParameter(str, "filter");
        Intrinsics3.checkNotNullParameter(list, "data");
        this.filter = str;
        this.searchType = i;
        this.data = list;
        this.guildsList = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetGlobalSearchModel copy$default(WidgetGlobalSearchModel widgetGlobalSearchModel, String str, int i, List list, List list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = widgetGlobalSearchModel.filter;
        }
        if ((i2 & 2) != 0) {
            i = widgetGlobalSearchModel.searchType;
        }
        if ((i2 & 4) != 0) {
            list = widgetGlobalSearchModel.data;
        }
        if ((i2 & 8) != 0) {
            list2 = widgetGlobalSearchModel.guildsList;
        }
        return widgetGlobalSearchModel.copy(str, i, list, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFilter() {
        return this.filter;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getSearchType() {
        return this.searchType;
    }

    public final List<ItemDataPayload> component3() {
        return this.data;
    }

    public final List<WidgetGlobalSearchGuildsModel.Item> component4() {
        return this.guildsList;
    }

    public final WidgetGlobalSearchModel copy(String filter, int searchType, List<? extends ItemDataPayload> data, List<WidgetGlobalSearchGuildsModel.Item> guildsList) {
        Intrinsics3.checkNotNullParameter(filter, "filter");
        Intrinsics3.checkNotNullParameter(data, "data");
        return new WidgetGlobalSearchModel(filter, searchType, data, guildsList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGlobalSearchModel)) {
            return false;
        }
        WidgetGlobalSearchModel widgetGlobalSearchModel = (WidgetGlobalSearchModel) other;
        return Intrinsics3.areEqual(this.filter, widgetGlobalSearchModel.filter) && this.searchType == widgetGlobalSearchModel.searchType && Intrinsics3.areEqual(this.data, widgetGlobalSearchModel.data) && Intrinsics3.areEqual(this.guildsList, widgetGlobalSearchModel.guildsList);
    }

    public final List<ItemDataPayload> getData() {
        return this.data;
    }

    public final String getFilter() {
        return this.filter;
    }

    public final List<WidgetGlobalSearchGuildsModel.Item> getGuildsList() {
        return this.guildsList;
    }

    public final int getSearchType() {
        return this.searchType;
    }

    public int hashCode() {
        String str = this.filter;
        int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + this.searchType) * 31;
        List<ItemDataPayload> list = this.data;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<WidgetGlobalSearchGuildsModel.Item> list2 = this.guildsList;
        return iHashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("WidgetGlobalSearchModel(filter=");
        sbU.append(this.filter);
        sbU.append(", searchType=");
        sbU.append(this.searchType);
        sbU.append(", data=");
        sbU.append(this.data);
        sbU.append(", guildsList=");
        return outline.L(sbU, this.guildsList, ")");
    }

    /* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
    public static final /* data */ class ItemChannel implements ItemDataPayload {
        private final Channel channel;
        private final Guild guild;
        private final String key;
        private final MatchedResult matchedResult;
        private final int mentions;
        private final Channel parentChannel;
        private final int type;
        private final boolean unread;

        public ItemChannel(MatchedResult matchedResult, Channel channel, Channel channel2, Guild guild, int i, boolean z2) {
            Intrinsics3.checkNotNullParameter(matchedResult, "matchedResult");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            this.matchedResult = matchedResult;
            this.channel = channel;
            this.parentChannel = channel2;
            this.guild = guild;
            this.mentions = i;
            this.unread = z2;
            this.key = String.valueOf(getChannel().getId());
        }

        public static /* synthetic */ ItemChannel copy$default(ItemChannel itemChannel, MatchedResult matchedResult, Channel channel, Channel channel2, Guild guild, int i, boolean z2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                matchedResult = itemChannel.getMatchedResult();
            }
            if ((i2 & 2) != 0) {
                channel = itemChannel.getChannel();
            }
            Channel channel3 = channel;
            if ((i2 & 4) != 0) {
                channel2 = itemChannel.parentChannel;
            }
            Channel channel4 = channel2;
            if ((i2 & 8) != 0) {
                guild = itemChannel.guild;
            }
            Guild guild2 = guild;
            if ((i2 & 16) != 0) {
                i = itemChannel.getMentions();
            }
            int i3 = i;
            if ((i2 & 32) != 0) {
                z2 = itemChannel.getUnread();
            }
            return itemChannel.copy(matchedResult, channel3, channel4, guild2, i3, z2);
        }

        public final MatchedResult component1() {
            return getMatchedResult();
        }

        public final Channel component2() {
            return getChannel();
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Channel getParentChannel() {
            return this.parentChannel;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final int component5() {
            return getMentions();
        }

        public final boolean component6() {
            return getUnread();
        }

        public final ItemChannel copy(MatchedResult matchedResult, Channel channel, Channel parentChannel, Guild guild, int mentions, boolean unread) {
            Intrinsics3.checkNotNullParameter(matchedResult, "matchedResult");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return new ItemChannel(matchedResult, channel, parentChannel, guild, mentions, unread);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ItemChannel)) {
                return false;
            }
            ItemChannel itemChannel = (ItemChannel) other;
            return Intrinsics3.areEqual(getMatchedResult(), itemChannel.getMatchedResult()) && Intrinsics3.areEqual(getChannel(), itemChannel.getChannel()) && Intrinsics3.areEqual(this.parentChannel, itemChannel.parentChannel) && Intrinsics3.areEqual(this.guild, itemChannel.guild) && getMentions() == itemChannel.getMentions() && getUnread() == itemChannel.getUnread();
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public MatchedResult getMatchedResult() {
            return this.matchedResult;
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public int getMentions() {
            return this.mentions;
        }

        public final Channel getParentChannel() {
            return this.parentChannel;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public boolean getUnread() {
            return this.unread;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        public int hashCode() {
            MatchedResult matchedResult = getMatchedResult();
            int iHashCode = (matchedResult != null ? matchedResult.hashCode() : 0) * 31;
            Channel channel = getChannel();
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            Channel channel2 = this.parentChannel;
            int iHashCode3 = (iHashCode2 + (channel2 != null ? channel2.hashCode() : 0)) * 31;
            Guild guild = this.guild;
            int mentions = (getMentions() + ((iHashCode3 + (guild != null ? guild.hashCode() : 0)) * 31)) * 31;
            boolean unread = getUnread();
            ?? r0 = unread;
            if (unread) {
                r0 = 1;
            }
            return mentions + r0;
        }

        public String toString() {
            return String.valueOf(MentionUtils.CHANNELS_CHAR) + ChannelUtils.c(getChannel());
        }

        public /* synthetic */ ItemChannel(MatchedResult matchedResult, Channel channel, Channel channel2, Guild guild, int i, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(matchedResult, channel, channel2, guild, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? false : z2);
        }
    }

    public /* synthetic */ WidgetGlobalSearchModel(String str, int i, List list, List list2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, list, (i2 & 8) != 0 ? null : list2);
    }

    /* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
    public static final /* data */ class ItemGuild implements ItemDataPayload {
        private final Channel channel;
        private final Guild guild;
        private final String key;
        private final MatchedResult matchedResult;
        private final int mentions;
        private final int type;
        private final boolean unread;

        public ItemGuild(MatchedResult matchedResult, Guild guild, Channel channel, int i, boolean z2) {
            Intrinsics3.checkNotNullParameter(matchedResult, "matchedResult");
            Intrinsics3.checkNotNullParameter(guild, "guild");
            this.matchedResult = matchedResult;
            this.guild = guild;
            this.channel = channel;
            this.mentions = i;
            this.unread = z2;
            this.type = 2;
            this.key = String.valueOf(guild.getId());
        }

        public static /* synthetic */ ItemGuild copy$default(ItemGuild itemGuild, MatchedResult matchedResult, Guild guild, Channel channel, int i, boolean z2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                matchedResult = itemGuild.getMatchedResult();
            }
            if ((i2 & 2) != 0) {
                guild = itemGuild.guild;
            }
            Guild guild2 = guild;
            if ((i2 & 4) != 0) {
                channel = itemGuild.getChannel();
            }
            Channel channel2 = channel;
            if ((i2 & 8) != 0) {
                i = itemGuild.getMentions();
            }
            int i3 = i;
            if ((i2 & 16) != 0) {
                z2 = itemGuild.getUnread();
            }
            return itemGuild.copy(matchedResult, guild2, channel2, i3, z2);
        }

        public final MatchedResult component1() {
            return getMatchedResult();
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final Channel component3() {
            return getChannel();
        }

        public final int component4() {
            return getMentions();
        }

        public final boolean component5() {
            return getUnread();
        }

        public final ItemGuild copy(MatchedResult matchedResult, Guild guild, Channel channel, int mentions, boolean unread) {
            Intrinsics3.checkNotNullParameter(matchedResult, "matchedResult");
            Intrinsics3.checkNotNullParameter(guild, "guild");
            return new ItemGuild(matchedResult, guild, channel, mentions, unread);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ItemGuild)) {
                return false;
            }
            ItemGuild itemGuild = (ItemGuild) other;
            return Intrinsics3.areEqual(getMatchedResult(), itemGuild.getMatchedResult()) && Intrinsics3.areEqual(this.guild, itemGuild.guild) && Intrinsics3.areEqual(getChannel(), itemGuild.getChannel()) && getMentions() == itemGuild.getMentions() && getUnread() == itemGuild.getUnread();
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public MatchedResult getMatchedResult() {
            return this.matchedResult;
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public int getMentions() {
            return this.mentions;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public boolean getUnread() {
            return this.unread;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        public int hashCode() {
            MatchedResult matchedResult = getMatchedResult();
            int iHashCode = (matchedResult != null ? matchedResult.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            Channel channel = getChannel();
            int mentions = (getMentions() + ((iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31)) * 31;
            boolean unread = getUnread();
            ?? r0 = unread;
            if (unread) {
                r0 = 1;
            }
            return mentions + r0;
        }

        public String toString() {
            return String.valueOf('*') + this.guild.getName();
        }

        public /* synthetic */ ItemGuild(MatchedResult matchedResult, Guild guild, Channel channel, int i, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(matchedResult, guild, (i2 & 4) != 0 ? null : channel, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? false : z2);
        }
    }

    /* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
    public static final /* data */ class ItemUser implements ItemDataPayload {
        private final List<CharSequence> aliases;
        private final Channel channel;
        private final boolean isFriend;
        private final String key;
        private final MatchedResult matchedResult;
        private final int mentions;
        private final Presence presence;
        private final int type;
        private final boolean unread;
        private final User user;

        /* JADX WARN: Multi-variable type inference failed */
        public ItemUser(MatchedResult matchedResult, User user, List<? extends CharSequence> list, boolean z2, Presence presence, Channel channel, int i, boolean z3) {
            Intrinsics3.checkNotNullParameter(matchedResult, "matchedResult");
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(list, "aliases");
            this.matchedResult = matchedResult;
            this.user = user;
            this.aliases = list;
            this.isFriend = z2;
            this.presence = presence;
            this.channel = channel;
            this.mentions = i;
            this.unread = z3;
            this.type = 1;
            this.key = String.valueOf(user.getId());
        }

        public final MatchedResult component1() {
            return getMatchedResult();
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        public final List<CharSequence> component3() {
            return this.aliases;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsFriend() {
            return this.isFriend;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Presence getPresence() {
            return this.presence;
        }

        public final Channel component6() {
            return getChannel();
        }

        public final int component7() {
            return getMentions();
        }

        public final boolean component8() {
            return getUnread();
        }

        public final ItemUser copy(MatchedResult matchedResult, User user, List<? extends CharSequence> aliases, boolean isFriend, Presence presence, Channel channel, int mentions, boolean unread) {
            Intrinsics3.checkNotNullParameter(matchedResult, "matchedResult");
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(aliases, "aliases");
            return new ItemUser(matchedResult, user, aliases, isFriend, presence, channel, mentions, unread);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ItemUser)) {
                return false;
            }
            ItemUser itemUser = (ItemUser) other;
            return Intrinsics3.areEqual(getMatchedResult(), itemUser.getMatchedResult()) && Intrinsics3.areEqual(this.user, itemUser.user) && Intrinsics3.areEqual(this.aliases, itemUser.aliases) && this.isFriend == itemUser.isFriend && Intrinsics3.areEqual(this.presence, itemUser.presence) && Intrinsics3.areEqual(getChannel(), itemUser.getChannel()) && getMentions() == itemUser.getMentions() && getUnread() == itemUser.getUnread();
        }

        public final List<CharSequence> getAliases() {
            return this.aliases;
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public Channel getChannel() {
            return this.channel;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public MatchedResult getMatchedResult() {
            return this.matchedResult;
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public int getMentions() {
            return this.mentions;
        }

        public final Presence getPresence() {
            return this.presence;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public boolean getUnread() {
            return this.unread;
        }

        public final User getUser() {
            return this.user;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v16 */
        /* JADX WARN: Type inference failed for: r2v7, types: [int] */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            MatchedResult matchedResult = getMatchedResult();
            int iHashCode = (matchedResult != null ? matchedResult.hashCode() : 0) * 31;
            User user = this.user;
            int iHashCode2 = (iHashCode + (user != null ? user.hashCode() : 0)) * 31;
            List<CharSequence> list = this.aliases;
            int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
            boolean z2 = this.isFriend;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode3 + r2) * 31;
            Presence presence = this.presence;
            int iHashCode4 = (i + (presence != null ? presence.hashCode() : 0)) * 31;
            Channel channel = getChannel();
            int mentions = (getMentions() + ((iHashCode4 + (channel != null ? channel.hashCode() : 0)) * 31)) * 31;
            boolean unread = getUnread();
            return mentions + (unread ? 1 : unread);
        }

        public final boolean isFriend() {
            return this.isFriend;
        }

        public String toString() {
            StringBuilder sbQ = outline.Q(MentionUtils.MENTIONS_CHAR);
            sbQ.append(getMatchedResult().getValue());
            return sbQ.toString();
        }

        public /* synthetic */ ItemUser(MatchedResult matchedResult, User user, List list, boolean z2, Presence presence, Channel channel, int i, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(matchedResult, user, list, (i2 & 8) != 0 ? false : z2, presence, (i2 & 32) != 0 ? null : channel, (i2 & 64) != 0 ? 0 : i, (i2 & 128) != 0 ? false : z3);
        }
    }

    /* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
    public static final /* data */ class ItemHeader implements ItemDataPayload {
        private final Channel channel;
        private final String key;
        private final MatchedResult matchedResult;
        private final int mentions;
        private final int name;
        private final int type;
        private final boolean unread;

        public ItemHeader(@StringRes int i, int i2, boolean z2) {
            this.name = i;
            this.mentions = i2;
            this.unread = z2;
            this.matchedResult = WidgetGlobalSearchModel.INSTANCE.getEMPTY_MATCH_RESULT();
            this.type = -1;
            this.key = outline.q("header", i);
        }

        public static /* synthetic */ ItemHeader copy$default(ItemHeader itemHeader, int i, int i2, boolean z2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = itemHeader.name;
            }
            if ((i3 & 2) != 0) {
                i2 = itemHeader.getMentions();
            }
            if ((i3 & 4) != 0) {
                z2 = itemHeader.getUnread();
            }
            return itemHeader.copy(i, i2, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getName() {
            return this.name;
        }

        public final int component2() {
            return getMentions();
        }

        public final boolean component3() {
            return getUnread();
        }

        public final ItemHeader copy(@StringRes int name, int mentions, boolean unread) {
            return new ItemHeader(name, mentions, unread);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ItemHeader)) {
                return false;
            }
            ItemHeader itemHeader = (ItemHeader) other;
            return this.name == itemHeader.name && getMentions() == itemHeader.getMentions() && getUnread() == itemHeader.getUnread();
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public Channel getChannel() {
            return this.channel;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public MatchedResult getMatchedResult() {
            return this.matchedResult;
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public int getMentions() {
            return this.mentions;
        }

        public final int getName() {
            return this.name;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public boolean getUnread() {
            return this.unread;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        public int hashCode() {
            int mentions = (getMentions() + (this.name * 31)) * 31;
            boolean unread = getUnread();
            ?? r0 = unread;
            if (unread) {
                r0 = 1;
            }
            return mentions + r0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ItemHeader(name=");
            sbU.append(this.name);
            sbU.append(", mentions=");
            sbU.append(getMentions());
            sbU.append(", unread=");
            sbU.append(getUnread());
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ ItemHeader(int i, int i2, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? false : z2);
        }
    }
}

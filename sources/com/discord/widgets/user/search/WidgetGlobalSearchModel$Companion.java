package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableWithLeadingEdgeThrottle;
import com.discord.utilities.search.SearchUtils;
import com.discord.utilities.string.StringUtilsKt;
import d0.f0.n;
import d0.f0.q;
import d0.g0.t;
import d0.g0.w;
import d0.t.n0;
import d0.t.u;
import d0.z.d.m;
import j0.l.e.k;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.Sequence;
import rx.Observable;
import rx.functions.Func4;
import rx.functions.Func7;
import rx.functions.Func8;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion {
    private WidgetGlobalSearchModel$Companion() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetGlobalSearchModel create$default(WidgetGlobalSearchModel$Companion widgetGlobalSearchModel$Companion, WidgetGlobalSearchModel$SearchContext widgetGlobalSearchModel$SearchContext, WidgetGlobalSearchModel$UsersContext widgetGlobalSearchModel$UsersContext, WidgetGlobalSearchModel$ChannelContext widgetGlobalSearchModel$ChannelContext, WidgetGlobalSearchGuildsModel widgetGlobalSearchGuildsModel, Function1 function1, Function1 function2, int i, Object obj) {
        if ((i & 16) != 0) {
            function1 = null;
        }
        Function1 function3 = function1;
        if ((i & 32) != 0) {
            function2 = WidgetGlobalSearchModel$Companion$create$1.INSTANCE;
        }
        return widgetGlobalSearchModel$Companion.create(widgetGlobalSearchModel$SearchContext, widgetGlobalSearchModel$UsersContext, widgetGlobalSearchModel$ChannelContext, widgetGlobalSearchGuildsModel, function3, function2);
    }

    private final Observable<WidgetGlobalSearchModel> get(Observable<String> filterPublisher, Function2<? super Channel, ? super Map<Long, Long>, Boolean> permissionsPredicate, Function1<? super WidgetGlobalSearchModel$ItemDataPayload, Boolean> resultsFilter, Function1<? super WidgetGlobalSearchModel$SearchContext, Long> lastChannelIdProvider) {
        k kVar = new k("");
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<List<Long>> observableObserveRecentSelectedGuildIds = storeStream$Companion.getGuildSelected().observeRecentSelectedGuildIds();
        Observable<Long> observableObserveId = storeStream$Companion.getChannelsSelected().observeId();
        Observable<Long> observableObservePreviousId = storeStream$Companion.getChannelsSelected().observePreviousId();
        Observable<Long> observableObserveSelectedVoiceChannelId = storeStream$Companion.getVoiceChannelSelected().observeSelectedVoiceChannelId();
        Observable<Map<Long, Long>> observableObserveRecentMessageIds = storeStream$Companion.getMessagesMostRecent().observeRecentMessageIds();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        Observable observableLeadingEdgeThrottle = ObservableExtensionsKt.leadingEdgeThrottle(observableObserveRecentMessageIds, 10L, timeUnit);
        Observable<Map<Long, Integer>> observableObserveMentionCounts = storeStream$Companion.getMentions().observeMentionCounts();
        WidgetGlobalSearchModel$Companion$get$partialSearchContextObservable$1 widgetGlobalSearchModel$Companion$get$partialSearchContextObservable$1 = WidgetGlobalSearchModel$Companion$get$partialSearchContextObservable$1.INSTANCE;
        Object widgetGlobalSearchModel$sam$rx_functions_Func7$0 = widgetGlobalSearchModel$Companion$get$partialSearchContextObservable$1;
        if (widgetGlobalSearchModel$Companion$get$partialSearchContextObservable$1 != null) {
            widgetGlobalSearchModel$sam$rx_functions_Func7$0 = new WidgetGlobalSearchModel$sam$rx_functions_Func7$0(widgetGlobalSearchModel$Companion$get$partialSearchContextObservable$1);
        }
        Observable observableR = ObservableWithLeadingEdgeThrottle.combineLatest(kVar, observableObserveRecentSelectedGuildIds, observableObserveId, observableObservePreviousId, observableObserveSelectedVoiceChannelId, observableLeadingEdgeThrottle, observableObserveMentionCounts, (Func7) widgetGlobalSearchModel$sam$rx_functions_Func7$0, 2L, timeUnit).r();
        WidgetGlobalSearchModel$Companion$get$searchContextObservable$1 widgetGlobalSearchModel$Companion$get$searchContextObservable$1 = WidgetGlobalSearchModel$Companion$get$searchContextObservable$1.INSTANCE;
        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
        Observable observableR2 = ObservableWithLeadingEdgeThrottle.combineLatest(filterPublisher, observableR, widgetGlobalSearchModel$Companion$get$searchContextObservable$1, 250L, timeUnit2).r();
        Observable<Map<Long, User>> observableObserveAllUsers = storeStream$Companion.getUsers().observeAllUsers();
        Observable<Map<Long, Presence>> observableObserveAllPresences = storeStream$Companion.getPresences().observeAllPresences();
        Observable<Map<Long, Integer>> observableObserve = storeStream$Companion.getUserRelationships().observe();
        Observable<Map<Long, Map<Long, GuildMember>>> observableObserveComputed = storeStream$Companion.getGuilds().observeComputed();
        WidgetGlobalSearchModel$Companion$get$usersContextObservable$1 widgetGlobalSearchModel$Companion$get$usersContextObservable$1 = WidgetGlobalSearchModel$Companion$get$usersContextObservable$1.INSTANCE;
        Object widgetGlobalSearchModel$sam$rx_functions_Func4$0 = widgetGlobalSearchModel$Companion$get$usersContextObservable$1;
        if (widgetGlobalSearchModel$Companion$get$usersContextObservable$1 != null) {
            widgetGlobalSearchModel$sam$rx_functions_Func4$0 = new WidgetGlobalSearchModel$sam$rx_functions_Func4$0(widgetGlobalSearchModel$Companion$get$usersContextObservable$1);
        }
        Observable observableR3 = ObservableWithLeadingEdgeThrottle.combineLatest(observableObserveAllUsers, observableObserveAllPresences, observableObserve, observableObserveComputed, (Func4) widgetGlobalSearchModel$sam$rx_functions_Func4$0, 10L, timeUnit).r();
        Observable<Map<Long, Guild>> observableObserveGuilds = storeStream$Companion.getGuilds().observeGuilds();
        Observable<Map<Long, Channel>> observableObserveGuildAndPrivateChannels = storeStream$Companion.getChannels().observeGuildAndPrivateChannels();
        Observable<Map<Long, Channel>> observableObserveAllActiveJoinedThreadsChannelsById = storeStream$Companion.getThreadsActiveJoined().observeAllActiveJoinedThreadsChannelsById();
        Observable<Map<Long, Long>> observableObservePermissionsForAllChannels = storeStream$Companion.getPermissions().observePermissionsForAllChannels();
        Observable<Map<Long, Channel>> observableObservePrivateChannels = storeStream$Companion.getChannels().observePrivateChannels();
        Observable<Map<Long, List<Long>>> observableObserveIds = storeStream$Companion.getChannels().observeIds(true);
        Observable<Set<Long>> unreadChannelIds = storeStream$Companion.getReadStates().getUnreadChannelIds();
        Observable<Set<Long>> unreadGuildIds = storeStream$Companion.getReadStates().getUnreadGuildIds();
        WidgetGlobalSearchModel$Companion$get$channelContextObservable$1 widgetGlobalSearchModel$Companion$get$channelContextObservable$1 = WidgetGlobalSearchModel$Companion$get$channelContextObservable$1.INSTANCE;
        Object widgetGlobalSearchModel$sam$rx_functions_Func8$0 = widgetGlobalSearchModel$Companion$get$channelContextObservable$1;
        if (widgetGlobalSearchModel$Companion$get$channelContextObservable$1 != null) {
            widgetGlobalSearchModel$sam$rx_functions_Func8$0 = new WidgetGlobalSearchModel$sam$rx_functions_Func8$0(widgetGlobalSearchModel$Companion$get$channelContextObservable$1);
        }
        Observable observableR4 = ObservableWithLeadingEdgeThrottle.combineLatest(observableObserveGuilds, observableObserveGuildAndPrivateChannels, observableObserveAllActiveJoinedThreadsChannelsById, observableObservePermissionsForAllChannels, observableObservePrivateChannels, observableObserveIds, unreadChannelIds, unreadGuildIds, (Func8) widgetGlobalSearchModel$sam$rx_functions_Func8$0, 3L, timeUnit).G(new WidgetGlobalSearchModel$Companion$get$channelContextObservable$2(permissionsPredicate)).r();
        Observable<WidgetGlobalSearchModel> observableR5 = ObservableWithLeadingEdgeThrottle.combineLatest(observableR2, observableR3, observableR4, ObservableWithLeadingEdgeThrottle.combineLatest(observableR2, observableR4, storeStream$Companion.getUserGuildSettings().observeGuildSettings(), storeStream$Companion.getGuildsSorted().observeOrderedGuilds(), WidgetGlobalSearchModel$Companion$get$guildsListObservable$1.INSTANCE, 5L, timeUnit).r(), new k(resultsFilter), new k(lastChannelIdProvider), new WidgetGlobalSearchModel$sam$rx_functions_Func6$0(new WidgetGlobalSearchModel$Companion$get$1(this)), 200L, timeUnit2).r();
        m.checkNotNullExpressionValue(observableR5, "ObservableWithLeadingEdg…  .distinctUntilChanged()");
        return observableR5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Observable get$default(WidgetGlobalSearchModel$Companion widgetGlobalSearchModel$Companion, Observable observable, Function2 function2, Function1 function1, Function1 function3, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        return widgetGlobalSearchModel$Companion.get(observable, function2, function1, function3);
    }

    private final Sequence<User> getDefaultUserSearch(WidgetGlobalSearchModel$SearchContext searchContext, WidgetGlobalSearchModel$ChannelContext channelContext, WidgetGlobalSearchModel$UsersContext usersContext, Set<Long> selectedGuildUserIds) {
        Sequence sequenceMapNotNull = q.mapNotNull(getRecentChannelIds(searchContext), new WidgetGlobalSearchModel$Companion$getDefaultUserSearch$recentDmUserIds$1(channelContext));
        return q.filterNot(q.take(q.mapNotNull(q.distinct(q.plus(q.plus(sequenceMapNotNull, (Iterable) selectedGuildUserIds), n.flattenSequenceOfIterable(q.mapNotNull(u.asSequence(channelContext.getSmallGuildIds()), new WidgetGlobalSearchModel$Companion$getDefaultUserSearch$smallGuildUserIds$1(usersContext))))), new WidgetGlobalSearchModel$Companion$getDefaultUserSearch$1(usersContext)), 100), WidgetGlobalSearchModel$Companion$getDefaultUserSearch$2.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Observable getForSend$default(WidgetGlobalSearchModel$Companion widgetGlobalSearchModel$Companion, Observable observable, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        return widgetGlobalSearchModel$Companion.getForSend(observable, function1);
    }

    private final Sequence<Long> getRecentChannelIds(WidgetGlobalSearchModel$SearchContext widgetGlobalSearchModel$SearchContext) {
        return widgetGlobalSearchModel$SearchContext.getFrecencyChannels().isEmpty() ^ true ? u.asSequence(widgetGlobalSearchModel$SearchContext.getFrecencyChannels()) : q.map(q.take(u.asSequence(u.sortedWith(widgetGlobalSearchModel$SearchContext.getMostRecent().entrySet(), new WidgetGlobalSearchModel$Companion$getRecentChannelIds$$inlined$sortedBy$1())), 50), WidgetGlobalSearchModel$Companion$getRecentChannelIds$2.INSTANCE);
    }

    public final WidgetGlobalSearchModel create(WidgetGlobalSearchModel$SearchContext searchContext, WidgetGlobalSearchModel$UsersContext usersContext, WidgetGlobalSearchModel$ChannelContext channelContext, WidgetGlobalSearchGuildsModel widgetGuildsListModel, Function1<? super WidgetGlobalSearchModel$ItemDataPayload, Boolean> resultsFilter, Function1<? super WidgetGlobalSearchModel$SearchContext, Long> lastChannelIdProvider) {
        Set<Long> setEmptySet;
        Sequence sequenceMapNotNull;
        Sequence sequenceMapNotNull2;
        m.checkNotNullParameter(searchContext, "searchContext");
        m.checkNotNullParameter(usersContext, "usersContext");
        m.checkNotNullParameter(channelContext, "channelContext");
        m.checkNotNullParameter(widgetGuildsListModel, "widgetGuildsListModel");
        m.checkNotNullParameter(lastChannelIdProvider, "lastChannelIdProvider");
        WidgetGlobalSearchModel$Companion$create$2 widgetGlobalSearchModel$Companion$create$2 = new WidgetGlobalSearchModel$Companion$create$2(usersContext, searchContext, channelContext);
        WidgetGlobalSearchModel$Companion$create$3 widgetGlobalSearchModel$Companion$create$3 = new WidgetGlobalSearchModel$Companion$create$3(channelContext, searchContext);
        WidgetGlobalSearchModel$Companion$create$4 widgetGlobalSearchModel$Companion$create$4 = new WidgetGlobalSearchModel$Companion$create$4(channelContext, widgetGlobalSearchModel$Companion$create$2, searchContext);
        int searchType = searchContext.getSearchType();
        String sanitizedFilter = searchContext.getSanitizedFilter();
        Map<Long, GuildMember> map = usersContext.getMembers().get(u.first((List) searchContext.getRecentGuildIds()));
        if (map == null || (setEmptySet = map.keySet()) == null) {
            setEmptySet = n0.emptySet();
        }
        Set<Long> set = setEmptySet;
        if (searchType != 1) {
            if (searchType == 2) {
                sequenceMapNotNull2 = q.mapNotNull(q.filter(u.asSequence(channelContext.getChannels().values()), WidgetGlobalSearchModel$Companion$create$filteredResults$3.INSTANCE), new WidgetGlobalSearchModel$Companion$create$filteredResults$4(widgetGlobalSearchModel$Companion$create$4, sanitizedFilter));
            } else if (searchType == 3) {
                sequenceMapNotNull2 = q.mapNotNull(u.asSequence(channelContext.getGuilds().values()), new WidgetGlobalSearchModel$Companion$create$filteredResults$2(widgetGlobalSearchModel$Companion$create$3, sanitizedFilter));
            } else if (searchType == 4) {
                sequenceMapNotNull2 = q.sortedWith(q.mapNotNull(q.filter(q.filter(u.asSequence(channelContext.getChannels().values()), WidgetGlobalSearchModel$Companion$create$filteredResults$5.INSTANCE), new WidgetGlobalSearchModel$Companion$create$filteredResults$6(channelContext)), new WidgetGlobalSearchModel$Companion$create$filteredResults$7(widgetGlobalSearchModel$Companion$create$4, sanitizedFilter)), new WidgetGlobalSearchModel$Companion$create$$inlined$sortedBy$1(searchContext));
            } else if (t.isBlank(sanitizedFilter)) {
                sequenceMapNotNull2 = q.mapNotNull(q.filter(q.mapNotNull(u.asSequence(u.union(searchContext.getMentionCounts().keySet(), q.asIterable(getRecentChannelIds(searchContext)))), new WidgetGlobalSearchModel$Companion$create$filteredResults$9(channelContext)), WidgetGlobalSearchModel$Companion$create$filteredResults$10.INSTANCE), new WidgetGlobalSearchModel$Companion$create$filteredResults$11(widgetGlobalSearchModel$Companion$create$4, sanitizedFilter));
            } else {
                HashSet hashSet = new HashSet();
                sequenceMapNotNull2 = q.plus(q.mapNotNull(q.filter(u.asSequence(channelContext.getChannels().values()), WidgetGlobalSearchModel$Companion$create$filteredResults$channelResults$1.INSTANCE), new WidgetGlobalSearchModel$Companion$create$filteredResults$channelResults$2(hashSet, widgetGlobalSearchModel$Companion$create$2, usersContext, sanitizedFilter, widgetGlobalSearchModel$Companion$create$4)), q.mapNotNull(q.filterNot(u.asSequence(set), new WidgetGlobalSearchModel$Companion$create$filteredResults$selectedGuildUserResults$1(hashSet)), new WidgetGlobalSearchModel$Companion$create$filteredResults$selectedGuildUserResults$2(widgetGlobalSearchModel$Companion$create$2, usersContext, sanitizedFilter)));
            }
            sequenceMapNotNull = sequenceMapNotNull2;
        } else {
            sequenceMapNotNull = q.mapNotNull(t.isBlank(sanitizedFilter) ? getDefaultUserSearch(searchContext, channelContext, usersContext, set) : u.asSequence(usersContext.getUsers().values()), new WidgetGlobalSearchModel$Companion$create$filteredResults$1(widgetGlobalSearchModel$Companion$create$2, sanitizedFilter));
        }
        if (resultsFilter != null) {
            sequenceMapNotNull = q.filter(sequenceMapNotNull, resultsFilter);
        }
        Sequence sequenceTake = q.take(q.sortedWith(sequenceMapNotNull, new WidgetGlobalSearchModel$Companion$create$$inlined$sortedByDescending$1(searchContext)), 50);
        if (searchType == 0 && t.isBlank(searchContext.getFilter())) {
            Channel channel = channelContext.getChannels().get(lastChannelIdProvider.invoke(searchContext));
            WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayloadInvoke2 = channel != null ? widgetGlobalSearchModel$Companion$create$4.invoke2(channel, "") : null;
            return new WidgetGlobalSearchModel(sanitizedFilter, searchType, q.toList(widgetGlobalSearchModel$ItemDataPayloadInvoke2 == null ? q.plus(n.sequenceOf(new WidgetGlobalSearchModel$ItemHeader(2131896107, 0, false, 6, null)), sequenceTake) : q.plus(q.plus(n.sequenceOf(new WidgetGlobalSearchModel$ItemHeader(2131894662, 0, false, 6, null), widgetGlobalSearchModel$ItemDataPayloadInvoke2), n.sequenceOf(new WidgetGlobalSearchModel$ItemHeader(2131896107, 0, false, 6, null))), q.filterNot(sequenceTake, new WidgetGlobalSearchModel$Companion$create$results$1(channel)))), widgetGuildsListModel.getItems());
        }
        if (q.firstOrNull(sequenceTake) != null) {
            sequenceTake = q.plus(n.sequenceOf(new WidgetGlobalSearchModel$ItemHeader(2131896107, 0, false, 6, null)), sequenceTake);
        }
        return new WidgetGlobalSearchModel(sanitizedFilter, searchType, q.toList(sequenceTake), null, 8, null);
    }

    public final WidgetGlobalSearchModel$MatchedResult getEMPTY_MATCH_RESULT() {
        return new WidgetGlobalSearchModel$MatchedResult("", -1, 0);
    }

    public final Observable<WidgetGlobalSearchModel> getForNav(Observable<String> filterPublisher) {
        m.checkNotNullParameter(filterPublisher, "filterPublisher");
        return get$default(this, filterPublisher, WidgetGlobalSearchModel.access$getDEFAULT_PERMISSIONS_PREDICATE$cp(), null, WidgetGlobalSearchModel$Companion$getForNav$1.INSTANCE, 4, null);
    }

    public final Observable<WidgetGlobalSearchModel> getForSend(Observable<String> filterPublisher, Function1<? super WidgetGlobalSearchModel$ItemDataPayload, Boolean> resultsFilter) {
        m.checkNotNullParameter(filterPublisher, "filterPublisher");
        return get(filterPublisher, WidgetGlobalSearchModel$Companion$getForSend$1.INSTANCE, resultsFilter, WidgetGlobalSearchModel$Companion$getForSend$2.INSTANCE);
    }

    public final WidgetGlobalSearchModel$MatchedResult toFuzzyMatchedResult(String str, String str2) {
        m.checkNotNullParameter(str, "$this$toFuzzyMatchedResult");
        m.checkNotNullParameter(str2, "filter");
        SearchUtils searchUtils = SearchUtils.INSTANCE;
        Locale locale = Locale.ROOT;
        m.checkNotNullExpressionValue(locale, "Locale.ROOT");
        String lowerCase = str2.toLowerCase(locale);
        m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        m.checkNotNullExpressionValue(locale, "Locale.ROOT");
        String lowerCase2 = str.toLowerCase(locale);
        m.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
        if (searchUtils.fuzzyMatch(lowerCase, StringUtilsKt.stripAccents(lowerCase2))) {
            return new WidgetGlobalSearchModel$MatchedResult(str, -1, str2.length());
        }
        return null;
    }

    public final WidgetGlobalSearchModel$MatchedResult toMatchedResult(String str, String str2) {
        m.checkNotNullParameter(str, "$this$toMatchedResult");
        m.checkNotNullParameter(str2, "filter");
        int iIndexOf$default = w.indexOf$default((CharSequence) str, str2, 0, true, 2, (Object) null);
        if (iIndexOf$default != -1) {
            return new WidgetGlobalSearchModel$MatchedResult(str, iIndexOf$default, str2.length());
        }
        return null;
    }

    public /* synthetic */ WidgetGlobalSearchModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

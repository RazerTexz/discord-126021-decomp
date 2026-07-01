package com.discord.utilities.search.suggestion;

import android.content.Context;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.node.answer.HasAnswerOption;
import com.discord.utilities.search.query.node.content.ContentNode;
import com.discord.utilities.search.query.node.filter.FilterNode;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.suggestion.entries.ChannelSuggestion;
import com.discord.utilities.search.suggestion.entries.FilterSuggestion;
import com.discord.utilities.search.suggestion.entries.HasSuggestion;
import com.discord.utilities.search.suggestion.entries.RecentQuerySuggestion;
import com.discord.utilities.search.suggestion.entries.SearchSuggestion;
import com.discord.utilities.search.suggestion.entries.UserSuggestion;
import com.discord.utilities.search.suggestion.entries.UserSuggestion$TargetType;
import com.discord.utilities.search.validation.SearchData;
import d0.g0.w;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import j0.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: SearchSuggestionEngine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SearchSuggestionEngine {
    public static final SearchSuggestionEngine INSTANCE;
    private static final int MAX_ENTRY_TYPE_COUNT;
    private static final int MAX_USER_SORTING_THRESHOLD;
    private static final SerializedSubject<CharSequence, CharSequence> membersRequestSubject;
    private static Long targetGuildId;

    static {
        SearchSuggestionEngine searchSuggestionEngine = new SearchSuggestionEngine();
        INSTANCE = searchSuggestionEngine;
        MAX_ENTRY_TYPE_COUNT = 10;
        MAX_USER_SORTING_THRESHOLD = 100;
        membersRequestSubject = new SerializedSubject<>(PublishSubject.k0());
        searchSuggestionEngine.setupMemberRequestSubscription();
    }

    private SearchSuggestionEngine() {
    }

    private final List<ChannelSuggestion> getChannelSuggestions(CharSequence rawContent, FilterType currentFilter, Map<Long, Channel> channels, Map<Long, Long> channelPermissions) {
        if (currentFilter != FilterType.IN) {
            return n.emptyList();
        }
        Collection<Channel> collectionValues = channels.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (PermissionUtils.can(Permission.VIEW_CHANNEL, (Long) a.d((Channel) obj, channelPermissions))) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (ChannelSuggestion.Companion.canComplete(ChannelUtils.c((Channel) obj2), rawContent)) {
                arrayList2.add(obj2);
            }
        }
        List<Channel> listSortedWith = u.sortedWith(arrayList2, ChannelUtils.h(Channel.Companion));
        ArrayList arrayList3 = new ArrayList(o.collectionSizeOrDefault(listSortedWith, 10));
        for (Channel channel : listSortedWith) {
            arrayList3.add(new ChannelSuggestion(ChannelUtils.c(channel), channel.getId()));
        }
        return u.take(arrayList3, MAX_ENTRY_TYPE_COUNT);
    }

    private final FilterType getCurrentFilterType(List<? extends QueryNode> input) {
        if (input.isEmpty()) {
            return null;
        }
        QueryNode queryNode = (QueryNode) u.last((List) input);
        if (queryNode instanceof FilterNode) {
            return ((FilterNode) queryNode).getFilterType();
        }
        if (input.size() == 1) {
            return null;
        }
        QueryNode queryNode2 = input.get(n.getLastIndex(input) - 1);
        if ((queryNode instanceof ContentNode) && (queryNode2 instanceof FilterNode)) {
            return ((FilterNode) queryNode2).getFilterType();
        }
        return null;
    }

    private final List<SearchSuggestion> getFilterSuggestions(CharSequence rawContent, SearchStringProvider searchStringProvider, boolean includeInChannels) {
        FilterType[] filterTypeArrValues = FilterType.values();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 4; i++) {
            FilterType filterType = filterTypeArrValues[i];
            if (includeInChannels || filterType != FilterType.IN) {
                arrayList.add(filterType);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (FilterSuggestion.Companion.canComplete(rawContent, (FilterType) obj, searchStringProvider)) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList(o.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(new FilterSuggestion((FilterType) it.next()));
        }
        return arrayList3;
    }

    private final List<SearchSuggestion> getHasSuggestions(CharSequence rawContent, FilterType currentFilterType, SearchStringProvider searchStringProvider) {
        if (currentFilterType != FilterType.HAS) {
            return n.emptyList();
        }
        HasAnswerOption[] hasAnswerOptionArrValues = HasAnswerOption.values();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 7; i++) {
            HasAnswerOption hasAnswerOption = hasAnswerOptionArrValues[i];
            if (HasSuggestion.Companion.canComplete(rawContent, hasAnswerOption, searchStringProvider)) {
                arrayList.add(hasAnswerOption);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new HasSuggestion((HasAnswerOption) it.next()));
        }
        return arrayList2;
    }

    private final Collection<SearchSuggestion> getHistorySuggestions(Collection<? extends List<? extends QueryNode>> recentQueries) {
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(recentQueries, 10));
        Iterator<T> it = recentQueries.iterator();
        while (it.hasNext()) {
            arrayList.add(new RecentQuerySuggestion((List) it.next()));
        }
        return arrayList;
    }

    private final CharSequence getRawContent(List<? extends QueryNode> input) {
        if (input.isEmpty()) {
            return "";
        }
        QueryNode queryNode = (QueryNode) u.last((List) input);
        if (!(queryNode instanceof ContentNode)) {
            return "";
        }
        String string = ((ContentNode) queryNode).getContent().toString();
        Objects.requireNonNull(string, "null cannot be cast to non-null type kotlin.CharSequence");
        return w.trim(string).toString();
    }

    public static final List<SearchSuggestion> getSuggestions(List<? extends QueryNode> input, SearchData searchData, SearchStringProvider searchStringProvider, Collection<? extends List<? extends QueryNode>> recentQueries) {
        m.checkNotNullParameter(input, "input");
        m.checkNotNullParameter(searchData, "searchData");
        m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        m.checkNotNullParameter(recentQueries, "recentQueries");
        ArrayList arrayList = new ArrayList();
        SearchSuggestionEngine searchSuggestionEngine = INSTANCE;
        FilterType currentFilterType = searchSuggestionEngine.getCurrentFilterType(input);
        CharSequence rawContent = searchSuggestionEngine.getRawContent(input);
        if (currentFilterType != null) {
            arrayList.addAll(searchSuggestionEngine.getUserSuggestions(rawContent, currentFilterType, searchData.getUsers()));
            arrayList.addAll(searchSuggestionEngine.getChannelSuggestions(rawContent, currentFilterType, searchData.getChannels(), searchData.getChannelPermissions()));
            arrayList.addAll(searchSuggestionEngine.getHasSuggestions(rawContent, currentFilterType, searchStringProvider));
        } else {
            arrayList.addAll(searchSuggestionEngine.getFilterSuggestions(rawContent, searchStringProvider, !searchData.getChannels().isEmpty()));
        }
        if (input.isEmpty()) {
            arrayList.addAll(searchSuggestionEngine.getHistorySuggestions(recentQueries));
        }
        return arrayList;
    }

    private final Collection<UserSuggestion> getUserSuggestions(CharSequence rawContent, FilterType currentFilter, Map<Long, UserGuildMember> users) {
        UserSuggestion$TargetType userSuggestion$TargetType;
        int iOrdinal = currentFilter.ordinal();
        if (iOrdinal == 0) {
            userSuggestion$TargetType = UserSuggestion$TargetType.FROM;
        } else {
            if (iOrdinal != 1) {
                return n.emptyList();
            }
            userSuggestion$TargetType = UserSuggestion$TargetType.MENTIONS;
        }
        membersRequestSubject.k.onNext(rawContent);
        TreeSet treeSet = new TreeSet();
        boolean z2 = users.size() < MAX_USER_SORTING_THRESHOLD;
        Iterator<Map$Entry<Long, UserGuildMember>> it = users.entrySet().iterator();
        while (it.hasNext()) {
            UserGuildMember value = it.next().getValue();
            User user = value.getUser();
            GuildMember guildMember = value.getGuildMember();
            if (UserSuggestion.Companion.canComplete(user.getUsername(), user.getDiscriminator(), value.getNickname(), rawContent)) {
                treeSet.add(new UserSuggestion(user, userSuggestion$TargetType, guildMember));
                if (!z2 && treeSet.size() >= MAX_ENTRY_TYPE_COUNT) {
                    return treeSet;
                }
            }
        }
        return u.take(treeSet, MAX_ENTRY_TYPE_COUNT);
    }

    private final void setupMemberRequestSubscription() {
        Observable<R> observableG = membersRequestSubject.P(750L, TimeUnit.MILLISECONDS).G(SearchSuggestionEngine$setupMemberRequestSubscription$1.INSTANCE);
        SearchSuggestionEngine$setupMemberRequestSubscription$2 searchSuggestionEngine$setupMemberRequestSubscription$2 = SearchSuggestionEngine$setupMemberRequestSubscription$2.INSTANCE;
        Object searchSuggestionEngine$sam$rx_functions_Func1$0 = searchSuggestionEngine$setupMemberRequestSubscription$2;
        if (searchSuggestionEngine$setupMemberRequestSubscription$2 != null) {
            searchSuggestionEngine$sam$rx_functions_Func1$0 = new SearchSuggestionEngine$sam$rx_functions_Func1$0(searchSuggestionEngine$setupMemberRequestSubscription$2);
        }
        Observable observableR = observableG.y((b) searchSuggestionEngine$sam$rx_functions_Func1$0).r();
        m.checkNotNullExpressionValue(observableR, "membersRequestSubject\n  …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, SearchSuggestionEngine.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, SearchSuggestionEngine$setupMemberRequestSubscription$3.INSTANCE, 62, (Object) null);
    }

    public final Long getTargetGuildId() {
        return targetGuildId;
    }

    public final void setTargetGuildId(Long l) {
        targetGuildId = l;
    }
}

package com.discord.utilities.search.suggestion;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreGatewayConnection;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.node.answer.HasNode2;
import com.discord.utilities.search.query.node.content.ContentNode;
import com.discord.utilities.search.query.node.filter.FilterNode;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.suggestion.entries.ChannelSuggestion;
import com.discord.utilities.search.suggestion.entries.FilterSuggestion;
import com.discord.utilities.search.suggestion.entries.HasSuggestion;
import com.discord.utilities.search.suggestion.entries.RecentQuerySuggestion;
import com.discord.utilities.search.suggestion.entries.SearchSuggestion;
import com.discord.utilities.search.suggestion.entries.UserSuggestion;
import com.discord.utilities.search.validation.SearchData;
import d0.g0.Strings4;
import d0.g0.k;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
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

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            FilterType.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[FilterType.FROM.ordinal()] = 1;
            iArr[FilterType.MENTIONS.ordinal()] = 2;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.search.suggestion.SearchSuggestionEngine$setupMemberRequestSubscription$2, reason: invalid class name */
    /* JADX INFO: compiled from: SearchSuggestionEngine.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<CharSequence, Boolean> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1, k.class, "isNotEmpty", "isNotEmpty(Ljava/lang/CharSequence;)Z", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(CharSequence charSequence) {
            return Boolean.valueOf(invoke((String) charSequence));
        }

        public final boolean invoke(String str) {
            Intrinsics3.checkNotNullParameter(str, "p1");
            return str.length() > 0;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.search.suggestion.SearchSuggestionEngine$setupMemberRequestSubscription$3, reason: invalid class name */
    /* JADX INFO: compiled from: SearchSuggestionEngine.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<String, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            StoreGatewayConnection gatewaySocket = StoreStream.INSTANCE.getGatewaySocket();
            Long targetGuildId = SearchSuggestionEngine.INSTANCE.getTargetGuildId();
            if (targetGuildId != null) {
                StoreGatewayConnection.requestGuildMembers$default(gatewaySocket, targetGuildId.longValue(), str, null, null, 12, null);
            }
        }
    }

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
            return Collections2.emptyList();
        }
        Collection<Channel> collectionValues = channels.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (PermissionUtils.can(Permission.VIEW_CHANNEL, (Long) outline.d((Channel) obj, channelPermissions))) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (ChannelSuggestion.INSTANCE.canComplete(ChannelUtils.c((Channel) obj2), rawContent)) {
                arrayList2.add(obj2);
            }
        }
        List<Channel> listSortedWith = _Collections.sortedWith(arrayList2, ChannelUtils.h(Channel.INSTANCE));
        ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(listSortedWith, 10));
        for (Channel channel : listSortedWith) {
            arrayList3.add(new ChannelSuggestion(ChannelUtils.c(channel), channel.getId()));
        }
        return _Collections.take(arrayList3, MAX_ENTRY_TYPE_COUNT);
    }

    private final FilterType getCurrentFilterType(List<? extends QueryNode> input) {
        if (input.isEmpty()) {
            return null;
        }
        QueryNode queryNode = (QueryNode) _Collections.last((List) input);
        if (queryNode instanceof FilterNode) {
            return ((FilterNode) queryNode).getFilterType();
        }
        if (input.size() == 1) {
            return null;
        }
        QueryNode queryNode2 = input.get(Collections2.getLastIndex(input) - 1);
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
            if (FilterSuggestion.INSTANCE.canComplete(rawContent, (FilterType) obj, searchStringProvider)) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(new FilterSuggestion((FilterType) it.next()));
        }
        return arrayList3;
    }

    private final List<SearchSuggestion> getHasSuggestions(CharSequence rawContent, FilterType currentFilterType, SearchStringProvider searchStringProvider) {
        if (currentFilterType != FilterType.HAS) {
            return Collections2.emptyList();
        }
        HasNode2[] hasNode2ArrValues = HasNode2.values();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 7; i++) {
            HasNode2 hasNode2 = hasNode2ArrValues[i];
            if (HasSuggestion.INSTANCE.canComplete(rawContent, hasNode2, searchStringProvider)) {
                arrayList.add(hasNode2);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new HasSuggestion((HasNode2) it.next()));
        }
        return arrayList2;
    }

    private final Collection<SearchSuggestion> getHistorySuggestions(Collection<? extends List<? extends QueryNode>> recentQueries) {
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(recentQueries, 10));
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
        QueryNode queryNode = (QueryNode) _Collections.last((List) input);
        if (!(queryNode instanceof ContentNode)) {
            return "";
        }
        String string = ((ContentNode) queryNode).getContent().toString();
        Objects.requireNonNull(string, "null cannot be cast to non-null type kotlin.CharSequence");
        return Strings4.trim(string).toString();
    }

    public static final List<SearchSuggestion> getSuggestions(List<? extends QueryNode> input, SearchData searchData, SearchStringProvider searchStringProvider, Collection<? extends List<? extends QueryNode>> recentQueries) {
        Intrinsics3.checkNotNullParameter(input, "input");
        Intrinsics3.checkNotNullParameter(searchData, "searchData");
        Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        Intrinsics3.checkNotNullParameter(recentQueries, "recentQueries");
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
        UserSuggestion.TargetType targetType;
        int iOrdinal = currentFilter.ordinal();
        if (iOrdinal == 0) {
            targetType = UserSuggestion.TargetType.FROM;
        } else {
            if (iOrdinal != 1) {
                return Collections2.emptyList();
            }
            targetType = UserSuggestion.TargetType.MENTIONS;
        }
        membersRequestSubject.k.onNext(rawContent);
        TreeSet treeSet = new TreeSet();
        boolean z2 = users.size() < MAX_USER_SORTING_THRESHOLD;
        Iterator<Map.Entry<Long, UserGuildMember>> it = users.entrySet().iterator();
        while (it.hasNext()) {
            UserGuildMember value = it.next().getValue();
            User user = value.getUser();
            GuildMember guildMember = value.getGuildMember();
            if (UserSuggestion.INSTANCE.canComplete(user.getUsername(), user.getDiscriminator(), value.getNickname(), rawContent)) {
                treeSet.add(new UserSuggestion(user, targetType, guildMember));
                if (!z2 && treeSet.size() >= MAX_ENTRY_TYPE_COUNT) {
                    return treeSet;
                }
            }
        }
        return _Collections.take(treeSet, MAX_ENTRY_TYPE_COUNT);
    }

    private final void setupMemberRequestSubscription() {
        Observable<R> observableG = membersRequestSubject.P(750L, TimeUnit.MILLISECONDS).G(new Func1<CharSequence, String>() { // from class: com.discord.utilities.search.suggestion.SearchSuggestionEngine.setupMemberRequestSubscription.1
            @Override // j0.k.Func1
            public final String call(CharSequence charSequence) {
                return charSequence.toString();
            }
        });
        final AnonymousClass2 anonymousClass2 = AnonymousClass2.INSTANCE;
        Object obj = anonymousClass2;
        if (anonymousClass2 != null) {
            obj = new Func1() { // from class: com.discord.utilities.search.suggestion.SearchSuggestionEngine$sam$rx_functions_Func1$0
                @Override // j0.k.Func1
                public final /* synthetic */ Object call(Object obj2) {
                    return anonymousClass2.invoke(obj2);
                }
            };
        }
        Observable observableR = observableG.y((Func1) obj).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "membersRequestSubject\n  …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(observableR, (Class<?>) SearchSuggestionEngine.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), AnonymousClass3.INSTANCE);
    }

    public final Long getTargetGuildId() {
        return targetGuildId;
    }

    public final void setTargetGuildId(Long l) {
        targetGuildId = l;
    }
}

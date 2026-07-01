package com.discord.stores;

import android.content.Context;
import com.discord.utilities.analytics.Traits$Payment$Type;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.node.answer.ChannelNode;
import com.discord.utilities.search.query.node.answer.HasAnswerOption;
import com.discord.utilities.search.query.node.answer.HasNode;
import com.discord.utilities.search.query.node.answer.UserNode;
import com.discord.utilities.search.query.node.content.ContentNode;
import com.discord.utilities.search.query.node.filter.FilterNode;
import com.discord.utilities.search.query.parsing.QueryParser;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.suggestion.entries.ChannelSuggestion;
import com.discord.utilities.search.suggestion.entries.UserSuggestion;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import j0.p.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: StoreSearchInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSearchInput {
    private final SerializedSubject<List<QueryNode>, List<QueryNode>> astSubject;
    private final Observable<List<QueryNode>> currentParsedInput;
    private final Observable<List<QueryNode>> forcedInput;
    private final PublishSubject<List<QueryNode>> forcedInputSubject;
    private final SerializedSubject<String, String> inputSubject;
    private Subscription inputSubscription;
    private final Observable<Boolean> isInputValid;
    private final SerializedSubject<Boolean, Boolean> isInputValidSubject;

    public StoreSearchInput() {
        SerializedSubject<List<QueryNode>, List<QueryNode>> serializedSubject = new SerializedSubject<>(BehaviorSubject.k0());
        this.astSubject = serializedSubject;
        this.inputSubject = new SerializedSubject<>(BehaviorSubject.l0(""));
        SerializedSubject<Boolean, Boolean> serializedSubject2 = new SerializedSubject<>(BehaviorSubject.l0(Boolean.FALSE));
        this.isInputValidSubject = serializedSubject2;
        PublishSubject<List<QueryNode>> publishSubjectK0 = PublishSubject.k0();
        this.forcedInputSubject = publishSubjectK0;
        this.isInputValid = serializedSubject2;
        this.currentParsedInput = serializedSubject;
        m.checkNotNullExpressionValue(publishSubjectK0, "forcedInputSubject");
        this.forcedInput = publishSubjectK0;
        Observable observableX = ObservableExtensionsKt.leadingEdgeThrottle(serializedSubject, 50L, TimeUnit.MILLISECONDS).G(StoreSearchInput$1.INSTANCE).X(a.a());
        m.checkNotNullExpressionValue(observableX, "astSubject\n        .lead…Schedulers.computation())");
        ObservableExtensionsKt.appSubscribe$default(observableX, (Context) null, "validateSearchInput", (Function1) null, new StoreSearchInput$2(this), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }

    public static final /* synthetic */ void access$handleInputSubscription(StoreSearchInput storeSearchInput, Subscription subscription) {
        storeSearchInput.handleInputSubscription(subscription);
    }

    public static final /* synthetic */ SerializedSubject access$isInputValidSubject$p(StoreSearchInput storeSearchInput) {
        return storeSearchInput.isInputValidSubject;
    }

    private final int getAnswerReplacementStart(List<? extends QueryNode> query) {
        if (query.size() <= 1) {
            return 0;
        }
        int lastIndex = n.getLastIndex(query);
        QueryNode queryNode = query.get(lastIndex);
        int i = lastIndex - 1;
        QueryNode queryNode2 = query.get(i);
        if (queryNode instanceof FilterNode) {
            return lastIndex;
        }
        if ((queryNode instanceof ContentNode) && (queryNode2 instanceof FilterNode)) {
            return i;
        }
        return -1;
    }

    private final synchronized void handleInputSubscription(Subscription subscription) {
        Subscription subscription2 = this.inputSubscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        this.inputSubscription = subscription;
    }

    private final void replaceAndPublish(int replacementIndex, List<? extends QueryNode> replacement, List<QueryNode> query) {
        if (replacementIndex < 0 || replacementIndex > query.size()) {
            return;
        }
        query.subList(replacementIndex, query.size()).clear();
        query.addAll(replacementIndex, replacement);
        this.forcedInputSubject.k.onNext(query);
    }

    public final void clear() {
        handleInputSubscription(null);
        this.inputSubject.k.onNext("");
    }

    public final Observable<List<QueryNode>> getCurrentParsedInput() {
        return this.currentParsedInput;
    }

    public final Observable<List<QueryNode>> getForcedInput() {
        return this.forcedInput;
    }

    public final void init(SearchStringProvider searchStringProvider) {
        m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        Observable observableX = ObservableExtensionsKt.leadingEdgeThrottle(this.inputSubject, 100L, TimeUnit.MILLISECONDS).r().G(new StoreSearchInput$init$1(new QueryParser(searchStringProvider))).X(a.a());
        m.checkNotNullExpressionValue(observableX, "inputSubject\n        .le…Schedulers.computation())");
        ObservableExtensionsKt.appSubscribe$default(observableX, StoreSearchInput.class, (Context) null, new StoreSearchInput$init$2(this), (Function1) null, (Function0) null, (Function0) null, new StoreSearchInput$init$3(this.astSubject), 58, (Object) null);
    }

    public final Observable<Boolean> isInputValid() {
        return this.isInputValid;
    }

    public final void onFilterClicked(FilterType filterType, SearchStringProvider searchStringProvider, List<QueryNode> query) {
        FilterNode filterNode;
        int lastIndex;
        m.checkNotNullParameter(filterType, "filterType");
        m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        m.checkNotNullParameter(query, "query");
        ArrayList arrayList = new ArrayList(query);
        int iOrdinal = filterType.ordinal();
        if (iOrdinal == 0) {
            filterNode = new FilterNode(FilterType.FROM, searchStringProvider.getFromFilterString());
        } else if (iOrdinal == 1) {
            filterNode = new FilterNode(FilterType.MENTIONS, searchStringProvider.getMentionsFilterString());
        } else if (iOrdinal == 2) {
            filterNode = new FilterNode(FilterType.HAS, searchStringProvider.getHasFilterString());
        } else {
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            filterNode = new FilterNode(FilterType.IN, searchStringProvider.getInFilterString());
        }
        if (arrayList.isEmpty()) {
            lastIndex = 0;
        } else {
            lastIndex = ((QueryNode) u.last((List) arrayList)) instanceof ContentNode ? n.getLastIndex(query) : query.size();
        }
        replaceAndPublish(lastIndex, d0.t.m.listOf(filterNode), query);
    }

    public final void onFromUserClicked(UserSuggestion userSuggestion, CharSequence fromFilterString, List<QueryNode> query) {
        m.checkNotNullParameter(userSuggestion, "userSuggestion");
        m.checkNotNullParameter(fromFilterString, "fromFilterString");
        m.checkNotNullParameter(query, "query");
        replaceAndPublish(getAnswerReplacementStart(query), n.listOf((Object[]) new QueryNode[]{new FilterNode(FilterType.FROM, fromFilterString), new UserNode(userSuggestion.getUserName(), userSuggestion.getDiscriminator())}), query);
    }

    public final void onHasClicked(HasAnswerOption hasAnswerOption, CharSequence hasFilterString, CharSequence hasAnswerString, List<QueryNode> query) {
        m.checkNotNullParameter(hasAnswerOption, "hasAnswerOption");
        m.checkNotNullParameter(hasFilterString, "hasFilterString");
        m.checkNotNullParameter(hasAnswerString, "hasAnswerString");
        m.checkNotNullParameter(query, "query");
        replaceAndPublish(getAnswerReplacementStart(query), n.listOf((Object[]) new QueryNode[]{new FilterNode(FilterType.HAS, hasFilterString), new HasNode(hasAnswerOption, hasAnswerString)}), query);
    }

    public final void onInChannelClicked(ChannelSuggestion channelSuggestion, CharSequence inFilterString, List<QueryNode> query) {
        m.checkNotNullParameter(channelSuggestion, "channelSuggestion");
        m.checkNotNullParameter(inFilterString, "inFilterString");
        m.checkNotNullParameter(query, "query");
        replaceAndPublish(getAnswerReplacementStart(query), n.listOf((Object[]) new QueryNode[]{new FilterNode(FilterType.IN, inFilterString), new ChannelNode(channelSuggestion.getChannelName())}), query);
    }

    public final void onMentionsUserClicked(UserSuggestion userSuggestion, CharSequence mentionsFilterString, List<QueryNode> query) {
        m.checkNotNullParameter(userSuggestion, "userSuggestion");
        m.checkNotNullParameter(mentionsFilterString, "mentionsFilterString");
        m.checkNotNullParameter(query, "query");
        replaceAndPublish(getAnswerReplacementStart(query), n.listOf((Object[]) new QueryNode[]{new FilterNode(FilterType.MENTIONS, mentionsFilterString), new UserNode(userSuggestion.getUserName(), userSuggestion.getDiscriminator())}), query);
    }

    public final void onQueryClicked(List<? extends QueryNode> query) {
        m.checkNotNullParameter(query, "query");
        this.forcedInputSubject.k.onNext(query);
    }

    public final void updateInput(String input) {
        m.checkNotNullParameter(input, "input");
        this.inputSubject.k.onNext(input);
    }
}

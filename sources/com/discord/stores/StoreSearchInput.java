package com.discord.stores;

import com.discord.simpleast.core.parser.Parser;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.node.answer.ChannelNode;
import com.discord.utilities.search.query.node.answer.HasNode;
import com.discord.utilities.search.query.node.answer.HasNode2;
import com.discord.utilities.search.query.node.answer.UserNode;
import com.discord.utilities.search.query.node.content.ContentNode;
import com.discord.utilities.search.query.node.filter.FilterNode;
import com.discord.utilities.search.query.parsing.QueryParser;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.suggestion.entries.ChannelSuggestion;
import com.discord.utilities.search.suggestion.entries.UserSuggestion;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.p.Schedulers2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
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

    /* JADX INFO: renamed from: com.discord.stores.StoreSearchInput$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreSearchInput.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Boolean, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            StoreSearchInput.this.isInputValidSubject.k.onNext((T) bool);
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            FilterType.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[FilterType.FROM.ordinal()] = 1;
            iArr[FilterType.MENTIONS.ordinal()] = 2;
            iArr[FilterType.IN.ordinal()] = 3;
            iArr[FilterType.HAS.ordinal()] = 4;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreSearchInput$init$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreSearchInput.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Subscription, Unit> {
        public AnonymousClass2(StoreSearchInput storeSearchInput) {
            super(1, storeSearchInput, StoreSearchInput.class, "handleInputSubscription", "handleInputSubscription(Lrx/Subscription;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            ((StoreSearchInput) this.receiver).handleInputSubscription(subscription);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreSearchInput$init$3, reason: invalid class name */
    /* JADX INFO: compiled from: StoreSearchInput.kt */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<List<? extends QueryNode>, Unit> {
        public AnonymousClass3(SerializedSubject serializedSubject) {
            super(1, serializedSubject, SerializedSubject.class, "onNext", "onNext(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends QueryNode> list) {
            invoke2(list);
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends QueryNode> list) {
            ((SerializedSubject) this.receiver).k.onNext((T) list);
        }
    }

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
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "forcedInputSubject");
        this.forcedInput = publishSubjectK0;
        Observable observableX = ObservableExtensionsKt.leadingEdgeThrottle(serializedSubject, 50L, TimeUnit.MILLISECONDS).G(new Func1<List<? extends QueryNode>, Boolean>() { // from class: com.discord.stores.StoreSearchInput.1
            @Override // j0.k.Func1
            public final Boolean call(List<? extends QueryNode> list) {
                Intrinsics3.checkNotNullExpressionValue(list, "it");
                boolean z2 = true;
                if ((list instanceof Collection) && list.isEmpty()) {
                    z2 = false;
                } else {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        if (!(((QueryNode) it.next()) instanceof FilterNode)) {
                        }
                    }
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            }
        }).X(Schedulers2.a());
        Intrinsics3.checkNotNullExpressionValue(observableX, "astSubject\n        .lead…Schedulers.computation())");
        ObservableExtensionsKt.appSubscribe(observableX, (117 & 1) != 0 ? null : null, "validateSearchInput", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new AnonymousClass2(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass3.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.AnonymousClass4.INSTANCE : null));
    }

    private final int getAnswerReplacementStart(List<? extends QueryNode> query) {
        if (query.size() <= 1) {
            return 0;
        }
        int lastIndex = Collections2.getLastIndex(query);
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
        Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        final QueryParser queryParser = new QueryParser(searchStringProvider);
        Observable observableX = ObservableExtensionsKt.leadingEdgeThrottle(this.inputSubject, 100L, TimeUnit.MILLISECONDS).r().G(new Func1<String, List<QueryNode>>() { // from class: com.discord.stores.StoreSearchInput.init.1
            @Override // j0.k.Func1
            public final List<QueryNode> call(String str) {
                QueryParser queryParser2 = queryParser;
                Intrinsics3.checkNotNullExpressionValue(str, "it");
                return Parser.parse$default(queryParser2, str, null, null, 4, null);
            }
        }).X(Schedulers2.a());
        Intrinsics3.checkNotNullExpressionValue(observableX, "inputSubject\n        .le…Schedulers.computation())");
        ObservableExtensionsKt.appSubscribe(observableX, (Class<?>) StoreSearchInput.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass2(this)), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3(this.astSubject));
    }

    public final Observable<Boolean> isInputValid() {
        return this.isInputValid;
    }

    public final void onFilterClicked(FilterType filterType, SearchStringProvider searchStringProvider, List<QueryNode> query) {
        FilterNode filterNode;
        int lastIndex;
        Intrinsics3.checkNotNullParameter(filterType, "filterType");
        Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        Intrinsics3.checkNotNullParameter(query, "query");
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
            lastIndex = ((QueryNode) _Collections.last((List) arrayList)) instanceof ContentNode ? Collections2.getLastIndex(query) : query.size();
        }
        replaceAndPublish(lastIndex, CollectionsJVM.listOf(filterNode), query);
    }

    public final void onFromUserClicked(UserSuggestion userSuggestion, CharSequence fromFilterString, List<QueryNode> query) {
        Intrinsics3.checkNotNullParameter(userSuggestion, "userSuggestion");
        Intrinsics3.checkNotNullParameter(fromFilterString, "fromFilterString");
        Intrinsics3.checkNotNullParameter(query, "query");
        replaceAndPublish(getAnswerReplacementStart(query), Collections2.listOf((Object[]) new QueryNode[]{new FilterNode(FilterType.FROM, fromFilterString), new UserNode(userSuggestion.getUserName(), userSuggestion.getDiscriminator())}), query);
    }

    public final void onHasClicked(HasNode2 hasAnswerOption, CharSequence hasFilterString, CharSequence hasAnswerString, List<QueryNode> query) {
        Intrinsics3.checkNotNullParameter(hasAnswerOption, "hasAnswerOption");
        Intrinsics3.checkNotNullParameter(hasFilterString, "hasFilterString");
        Intrinsics3.checkNotNullParameter(hasAnswerString, "hasAnswerString");
        Intrinsics3.checkNotNullParameter(query, "query");
        replaceAndPublish(getAnswerReplacementStart(query), Collections2.listOf((Object[]) new QueryNode[]{new FilterNode(FilterType.HAS, hasFilterString), new HasNode(hasAnswerOption, hasAnswerString)}), query);
    }

    public final void onInChannelClicked(ChannelSuggestion channelSuggestion, CharSequence inFilterString, List<QueryNode> query) {
        Intrinsics3.checkNotNullParameter(channelSuggestion, "channelSuggestion");
        Intrinsics3.checkNotNullParameter(inFilterString, "inFilterString");
        Intrinsics3.checkNotNullParameter(query, "query");
        replaceAndPublish(getAnswerReplacementStart(query), Collections2.listOf((Object[]) new QueryNode[]{new FilterNode(FilterType.IN, inFilterString), new ChannelNode(channelSuggestion.getChannelName())}), query);
    }

    public final void onMentionsUserClicked(UserSuggestion userSuggestion, CharSequence mentionsFilterString, List<QueryNode> query) {
        Intrinsics3.checkNotNullParameter(userSuggestion, "userSuggestion");
        Intrinsics3.checkNotNullParameter(mentionsFilterString, "mentionsFilterString");
        Intrinsics3.checkNotNullParameter(query, "query");
        replaceAndPublish(getAnswerReplacementStart(query), Collections2.listOf((Object[]) new QueryNode[]{new FilterNode(FilterType.MENTIONS, mentionsFilterString), new UserNode(userSuggestion.getUserName(), userSuggestion.getDiscriminator())}), query);
    }

    public final void onQueryClicked(List<? extends QueryNode> query) {
        Intrinsics3.checkNotNullParameter(query, "query");
        this.forcedInputSubject.k.onNext(query);
    }

    public final void updateInput(String input) {
        Intrinsics3.checkNotNullParameter(input, "input");
        this.inputSubject.k.onNext(input);
    }
}

package com.discord.stores;

import com.discord.simpleast.core.parser.Parser;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p653p.C12781a;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.PublishSubject;
import p658rx.subjects.SerializedSubject;

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

    /* JADX INFO: renamed from: com.discord.stores.StoreSearchInput$2 */
    /* JADX INFO: compiled from: StoreSearchInput.kt */
    public static final class C63892 extends AbstractC12240o implements Function1<Boolean, Unit> {
        public C63892() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.f27425a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            StoreSearchInput.this.isInputValidSubject.f27653k.onNext((T) bool);
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

    /* JADX INFO: renamed from: com.discord.stores.StoreSearchInput$init$2 */
    /* JADX INFO: compiled from: StoreSearchInput.kt */
    public static final /* synthetic */ class C63912 extends C12236k implements Function1<Subscription, Unit> {
        public C63912(StoreSearchInput storeSearchInput) {
            super(1, storeSearchInput, StoreSearchInput.class, "handleInputSubscription", "handleInputSubscription(Lrx/Subscription;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            ((StoreSearchInput) this.receiver).handleInputSubscription(subscription);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreSearchInput$init$3 */
    /* JADX INFO: compiled from: StoreSearchInput.kt */
    public static final /* synthetic */ class C63923 extends C12236k implements Function1<List<? extends QueryNode>, Unit> {
        public C63923(SerializedSubject serializedSubject) {
            super(1, serializedSubject, SerializedSubject.class, "onNext", "onNext(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends QueryNode> list) {
            invoke2(list);
            return Unit.f27425a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends QueryNode> list) {
            ((SerializedSubject) this.receiver).f27653k.onNext((T) list);
        }
    }

    public StoreSearchInput() {
        SerializedSubject<List<QueryNode>, List<QueryNode>> serializedSubject = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.astSubject = serializedSubject;
        this.inputSubject = new SerializedSubject<>(BehaviorSubject.m11130l0(""));
        SerializedSubject<Boolean, Boolean> serializedSubject2 = new SerializedSubject<>(BehaviorSubject.m11130l0(Boolean.FALSE));
        this.isInputValidSubject = serializedSubject2;
        PublishSubject<List<QueryNode>> publishSubjectM11133k0 = PublishSubject.m11133k0();
        this.forcedInputSubject = publishSubjectM11133k0;
        this.isInputValid = serializedSubject2;
        this.currentParsedInput = serializedSubject;
        C12238m.checkNotNullExpressionValue(publishSubjectM11133k0, "forcedInputSubject");
        this.forcedInput = publishSubjectM11133k0;
        Observable observableM11098X = ObservableExtensionsKt.leadingEdgeThrottle(serializedSubject, 50L, TimeUnit.MILLISECONDS).m11083G(new InterfaceC12589b<List<? extends QueryNode>, Boolean>() { // from class: com.discord.stores.StoreSearchInput.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(List<? extends QueryNode> list) {
                C12238m.checkNotNullExpressionValue(list, "it");
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
        }).m11098X(C12781a.m10873a());
        C12238m.checkNotNullExpressionValue(observableM11098X, "astSubject\n        .lead…Schedulers.computation())");
        ObservableExtensionsKt.appSubscribe(observableM11098X, (117 & 1) != 0 ? null : null, "validateSearchInput", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new C63892(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
    }

    private final int getAnswerReplacementStart(List<? extends QueryNode> query) {
        if (query.size() <= 1) {
            return 0;
        }
        int lastIndex = C12147n.getLastIndex(query);
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
        this.forcedInputSubject.f27650k.onNext(query);
    }

    public final void clear() {
        handleInputSubscription(null);
        this.inputSubject.f27653k.onNext("");
    }

    public final Observable<List<QueryNode>> getCurrentParsedInput() {
        return this.currentParsedInput;
    }

    public final Observable<List<QueryNode>> getForcedInput() {
        return this.forcedInput;
    }

    public final void init(SearchStringProvider searchStringProvider) {
        C12238m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        final QueryParser queryParser = new QueryParser(searchStringProvider);
        Observable observableM11098X = ObservableExtensionsKt.leadingEdgeThrottle(this.inputSubject, 100L, TimeUnit.MILLISECONDS).m11112r().m11083G(new InterfaceC12589b<String, List<QueryNode>>() { // from class: com.discord.stores.StoreSearchInput.init.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final List<QueryNode> call(String str) {
                QueryParser queryParser2 = queryParser;
                C12238m.checkNotNullExpressionValue(str, "it");
                return Parser.parse$default(queryParser2, str, null, null, 4, null);
            }
        }).m11098X(C12781a.m10873a());
        C12238m.checkNotNullExpressionValue(observableM11098X, "inputSubject\n        .le…Schedulers.computation())");
        ObservableExtensionsKt.appSubscribe(observableM11098X, (Class<?>) StoreSearchInput.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C63912(this)), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C63923(this.astSubject));
    }

    public final Observable<Boolean> isInputValid() {
        return this.isInputValid;
    }

    public final void onFilterClicked(FilterType filterType, SearchStringProvider searchStringProvider, List<QueryNode> query) {
        FilterNode filterNode;
        int lastIndex;
        C12238m.checkNotNullParameter(filterType, "filterType");
        C12238m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        C12238m.checkNotNullParameter(query, "query");
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
            lastIndex = ((QueryNode) C12163u.last((List) arrayList)) instanceof ContentNode ? C12147n.getLastIndex(query) : query.size();
        }
        replaceAndPublish(lastIndex, C12145m.listOf(filterNode), query);
    }

    public final void onFromUserClicked(UserSuggestion userSuggestion, CharSequence fromFilterString, List<QueryNode> query) {
        C12238m.checkNotNullParameter(userSuggestion, "userSuggestion");
        C12238m.checkNotNullParameter(fromFilterString, "fromFilterString");
        C12238m.checkNotNullParameter(query, "query");
        replaceAndPublish(getAnswerReplacementStart(query), C12147n.listOf((Object[]) new QueryNode[]{new FilterNode(FilterType.FROM, fromFilterString), new UserNode(userSuggestion.getUserName(), userSuggestion.getDiscriminator())}), query);
    }

    public final void onHasClicked(HasAnswerOption hasAnswerOption, CharSequence hasFilterString, CharSequence hasAnswerString, List<QueryNode> query) {
        C12238m.checkNotNullParameter(hasAnswerOption, "hasAnswerOption");
        C12238m.checkNotNullParameter(hasFilterString, "hasFilterString");
        C12238m.checkNotNullParameter(hasAnswerString, "hasAnswerString");
        C12238m.checkNotNullParameter(query, "query");
        replaceAndPublish(getAnswerReplacementStart(query), C12147n.listOf((Object[]) new QueryNode[]{new FilterNode(FilterType.HAS, hasFilterString), new HasNode(hasAnswerOption, hasAnswerString)}), query);
    }

    public final void onInChannelClicked(ChannelSuggestion channelSuggestion, CharSequence inFilterString, List<QueryNode> query) {
        C12238m.checkNotNullParameter(channelSuggestion, "channelSuggestion");
        C12238m.checkNotNullParameter(inFilterString, "inFilterString");
        C12238m.checkNotNullParameter(query, "query");
        replaceAndPublish(getAnswerReplacementStart(query), C12147n.listOf((Object[]) new QueryNode[]{new FilterNode(FilterType.IN, inFilterString), new ChannelNode(channelSuggestion.getChannelName())}), query);
    }

    public final void onMentionsUserClicked(UserSuggestion userSuggestion, CharSequence mentionsFilterString, List<QueryNode> query) {
        C12238m.checkNotNullParameter(userSuggestion, "userSuggestion");
        C12238m.checkNotNullParameter(mentionsFilterString, "mentionsFilterString");
        C12238m.checkNotNullParameter(query, "query");
        replaceAndPublish(getAnswerReplacementStart(query), C12147n.listOf((Object[]) new QueryNode[]{new FilterNode(FilterType.MENTIONS, mentionsFilterString), new UserNode(userSuggestion.getUserName(), userSuggestion.getDiscriminator())}), query);
    }

    public final void onQueryClicked(List<? extends QueryNode> query) {
        C12238m.checkNotNullParameter(query, "query");
        this.forcedInputSubject.f27650k.onNext(query);
    }

    public final void updateInput(String input) {
        C12238m.checkNotNullParameter(input, "input");
        this.inputSubject.f27653k.onNext(input);
    }
}

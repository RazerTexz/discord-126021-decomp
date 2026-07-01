package com.discord.utilities.search.network;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelSearchResponse;
import com.discord.stores.StoreSearch;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.a.OnSubscribeDefer;
import j0.l.a.OnSubscribeRedo6;
import j0.l.c.TrampolineScheduler;
import j0.l.e.InternalObservableUtils;
import j0.l.e.ScalarSynchronousObservable;
import j0.p.Schedulers2;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;

/* JADX INFO: compiled from: SearchFetcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public class SearchFetcher {
    private AtomicInteger indexingRetryCount = new AtomicInteger(0);

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            StoreSearch.SearchTarget.Type.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[StoreSearch.SearchTarget.Type.GUILD.ordinal()] = 1;
            iArr[StoreSearch.SearchTarget.Type.CHANNEL.ordinal()] = 2;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.search.network.SearchFetcher$getRestObservable$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchFetcher.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<AtomicInteger, Integer> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Integer invoke(AtomicInteger atomicInteger) {
            Intrinsics3.checkNotNullParameter(atomicInteger, "$this$getNullIfZero");
            int i = atomicInteger.get();
            if (i != 0) {
                return Integer.valueOf(i);
            }
            return null;
        }
    }

    private final Observable<ModelSearchResponse> getRestObservable(final StoreSearch.SearchTarget searchTarget, final Long oldestMessageId, final SearchQuery searchQuery) {
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        final Map<String, List<String>> params = searchQuery.getParams();
        Observable observableA = Observable.h0(new OnSubscribeDefer(new Func0<Observable<Integer>>() { // from class: com.discord.utilities.search.network.SearchFetcher.getRestObservable.2
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public final Observable<Integer> call() {
                return new ScalarSynchronousObservable(AnonymousClass1.INSTANCE.invoke(SearchFetcher.this.indexingRetryCount));
            }
        })).A(new Func1<Integer, Observable<? extends ModelSearchResponse>>() { // from class: com.discord.utilities.search.network.SearchFetcher.getRestObservable.3
            @Override // j0.k.Func1
            public final Observable<? extends ModelSearchResponse> call(Integer num) {
                int iOrdinal = searchTarget.getType().ordinal();
                if (iOrdinal == 0) {
                    return RestAPI.INSTANCE.getApi().searchGuildMessages(searchTarget.getId(), oldestMessageId, (List) params.get("author_id"), (List) params.get("mentions"), (List) params.get(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID), (List) params.get("has"), (List) params.get("content"), num, Boolean.valueOf(searchQuery.getIncludeNsfw()));
                }
                if (iOrdinal == 1) {
                    return RestAPI.INSTANCE.getApi().searchChannelMessages(searchTarget.getId(), oldestMessageId, (List) params.get("author_id"), (List) params.get("mentions"), (List) params.get("has"), (List) params.get("content"), num, Boolean.valueOf(searchQuery.getIncludeNsfw()));
                }
                throw new NoWhenBranchMatchedException();
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableA, "Observable\n        .defe…  )\n          }\n        }");
        return ObservableExtensionsKt.restSubscribeOn$default(observableA, false, 1, null);
    }

    private final boolean isIndexing(ModelSearchResponse modelSearchResponse) {
        Integer errorCode = modelSearchResponse.getErrorCode();
        return errorCode != null && errorCode.intValue() == 111000;
    }

    public Observable<ModelSearchResponse> makeQuery(StoreSearch.SearchTarget searchTarget, Long oldestMessageId, SearchQuery searchQuery) {
        Intrinsics3.checkNotNullParameter(searchTarget, "searchTarget");
        Intrinsics3.checkNotNullParameter(searchQuery, "searchQuery");
        final AtomicLong atomicLong = new AtomicLong();
        Observable<ModelSearchResponse> observableU = getRestObservable(searchTarget, oldestMessageId, searchQuery).u(new Action1<ModelSearchResponse>() { // from class: com.discord.utilities.search.network.SearchFetcher.makeQuery.1
            @Override // rx.functions.Action1
            public final void call(ModelSearchResponse modelSearchResponse) {
                SearchFetcher searchFetcher = SearchFetcher.this;
                Intrinsics3.checkNotNullExpressionValue(modelSearchResponse, "searchResponse");
                if (searchFetcher.isIndexing(modelSearchResponse)) {
                    atomicLong.set(modelSearchResponse.getRetryMillis());
                    SearchFetcher.this.indexingRetryCount.incrementAndGet();
                }
            }
        });
        InternalObservableUtils.c cVar = new InternalObservableUtils.c(new Func1<Observable<? extends Void>, Observable<?>>() { // from class: com.discord.utilities.search.network.SearchFetcher.makeQuery.2
            @Override // j0.k.Func1
            public final Observable<?> call(Observable<? extends Void> observable) {
                return observable.A(new Func1<Void, Observable<? extends Long>>() { // from class: com.discord.utilities.search.network.SearchFetcher.makeQuery.2.1
                    @Override // j0.k.Func1
                    public final Observable<? extends Long> call(Void r3) {
                        return Observable.d0(atomicLong.get(), TimeUnit.MILLISECONDS);
                    }
                });
            }
        });
        AtomicReference<Schedulers2> atomicReference = Schedulers2.a;
        Observable<ModelSearchResponse> observableB0 = Observable.h0(new OnSubscribeRedo6(observableU, cVar, false, true, TrampolineScheduler.a)).b0(new Func1<ModelSearchResponse, Boolean>() { // from class: com.discord.utilities.search.network.SearchFetcher.makeQuery.3
            @Override // j0.k.Func1
            public final Boolean call(ModelSearchResponse modelSearchResponse) {
                SearchFetcher searchFetcher = SearchFetcher.this;
                Intrinsics3.checkNotNullExpressionValue(modelSearchResponse, "it");
                return Boolean.valueOf(!searchFetcher.isIndexing(modelSearchResponse));
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableB0, "getRestObservable(search…ntil { !it.isIndexing() }");
        return observableB0;
    }
}

package com.discord.utilities.search.network;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelSearchResponse;
import com.discord.stores.StoreSearch;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p643a.C12634j;
import p637j0.p642l.p643a.C12687y;
import p637j0.p642l.p645c.C12708m;
import p637j0.p642l.p647e.C12721k;
import p637j0.p642l.p647e.EnumC12715e;
import p637j0.p653p.C12781a;
import p658rx.Observable;
import p658rx.functions.Action1;
import p658rx.functions.Func0;

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

    /* JADX INFO: renamed from: com.discord.utilities.search.network.SearchFetcher$getRestObservable$1 */
    /* JADX INFO: compiled from: SearchFetcher.kt */
    public static final class C69041 extends AbstractC12240o implements Function1<AtomicInteger, Integer> {
        public static final C69041 INSTANCE = new C69041();

        public C69041() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Integer invoke(AtomicInteger atomicInteger) {
            C12238m.checkNotNullParameter(atomicInteger, "$this$getNullIfZero");
            int i = atomicInteger.get();
            if (i != 0) {
                return Integer.valueOf(i);
            }
            return null;
        }
    }

    private final Observable<ModelSearchResponse> getRestObservable(final StoreSearch.SearchTarget searchTarget, final Long oldestMessageId, final SearchQuery searchQuery) {
        C69041 c69041 = C69041.INSTANCE;
        final Map<String, List<String>> params = searchQuery.getParams();
        Observable observableM11082A = Observable.m11074h0(new C12634j(new Func0<Observable<Integer>>() { // from class: com.discord.utilities.search.network.SearchFetcher.getRestObservable.2
            @Override // p658rx.functions.Func0, java.util.concurrent.Callable
            public final Observable<Integer> call() {
                return new C12721k(C69041.INSTANCE.invoke(SearchFetcher.this.indexingRetryCount));
            }
        })).m11082A(new InterfaceC12589b<Integer, Observable<? extends ModelSearchResponse>>() { // from class: com.discord.utilities.search.network.SearchFetcher.getRestObservable.3
            @Override // p637j0.p641k.InterfaceC12589b
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
        C12238m.checkNotNullExpressionValue(observableM11082A, "Observable\n        .defe…  )\n          }\n        }");
        return ObservableExtensionsKt.restSubscribeOn$default(observableM11082A, false, 1, null);
    }

    private final boolean isIndexing(ModelSearchResponse modelSearchResponse) {
        Integer errorCode = modelSearchResponse.getErrorCode();
        return errorCode != null && errorCode.intValue() == 111000;
    }

    public Observable<ModelSearchResponse> makeQuery(StoreSearch.SearchTarget searchTarget, Long oldestMessageId, SearchQuery searchQuery) {
        C12238m.checkNotNullParameter(searchTarget, "searchTarget");
        C12238m.checkNotNullParameter(searchQuery, "searchQuery");
        final AtomicLong atomicLong = new AtomicLong();
        Observable<ModelSearchResponse> observableM11115u = getRestObservable(searchTarget, oldestMessageId, searchQuery).m11115u(new Action1<ModelSearchResponse>() { // from class: com.discord.utilities.search.network.SearchFetcher.makeQuery.1
            @Override // p658rx.functions.Action1
            public final void call(ModelSearchResponse modelSearchResponse) {
                SearchFetcher searchFetcher = SearchFetcher.this;
                C12238m.checkNotNullExpressionValue(modelSearchResponse, "searchResponse");
                if (searchFetcher.isIndexing(modelSearchResponse)) {
                    atomicLong.set(modelSearchResponse.getRetryMillis());
                    SearchFetcher.this.indexingRetryCount.incrementAndGet();
                }
            }
        });
        EnumC12715e.c cVar = new EnumC12715e.c(new InterfaceC12589b<Observable<? extends Void>, Observable<?>>() { // from class: com.discord.utilities.search.network.SearchFetcher.makeQuery.2
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<?> call(Observable<? extends Void> observable) {
                return observable.m11082A(new InterfaceC12589b<Void, Observable<? extends Long>>() { // from class: com.discord.utilities.search.network.SearchFetcher.makeQuery.2.1
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Observable<? extends Long> call(Void r3) {
                        return Observable.m11068d0(atomicLong.get(), TimeUnit.MILLISECONDS);
                    }
                });
            }
        });
        AtomicReference<C12781a> atomicReference = C12781a.f27393a;
        Observable<ModelSearchResponse> observableM11103b0 = Observable.m11074h0(new C12687y(observableM11115u, cVar, false, true, C12708m.f27250a)).m11103b0(new InterfaceC12589b<ModelSearchResponse, Boolean>() { // from class: com.discord.utilities.search.network.SearchFetcher.makeQuery.3
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(ModelSearchResponse modelSearchResponse) {
                SearchFetcher searchFetcher = SearchFetcher.this;
                C12238m.checkNotNullExpressionValue(modelSearchResponse, "it");
                return Boolean.valueOf(!searchFetcher.isIndexing(modelSearchResponse));
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11103b0, "getRestObservable(search…ntil { !it.isIndexing() }");
        return observableM11103b0;
    }
}

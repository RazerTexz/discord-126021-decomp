package com.discord.stores;

import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelApplicationStreamPreview;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.time.Clock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import retrofit2.HttpException;

/* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationStreamPreviews extends StoreV2 {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final long READ_PREVIEW_DEFAULT_RETRY_DELAY_MS = 10000;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private final HashMap<String, Integer> fetchAttempts;
    private final HashMap<String, Subscription> fetchStreamPreviewSubscriptions;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;
    private final Map<String, StreamPreview> streamKeyToPreviewMap;
    private Map<String, ? extends StreamPreview> streamKeyToPreviewMapSnapshot;

    /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
    public static abstract class StreamPreview {

        /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
        public static final class Fetching extends StreamPreview {
            public static final Fetching INSTANCE = new Fetching();

            private Fetching() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
        public static final /* data */ class Resolved extends StreamPreview {
            private final String url;

            public Resolved(String str) {
                super(null);
                this.url = str;
            }

            public static /* synthetic */ Resolved copy$default(Resolved resolved, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = resolved.url;
                }
                return resolved.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getUrl() {
                return this.url;
            }

            public final Resolved copy(String url) {
                return new Resolved(url);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Resolved) && C12238m.areEqual(this.url, ((Resolved) other).url);
                }
                return true;
            }

            public final String getUrl() {
                return this.url;
            }

            public int hashCode() {
                String str = this.url;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return C1643a.m822J(C1643a.m833U("Resolved(url="), this.url, ")");
            }
        }

        private StreamPreview() {
        }

        public /* synthetic */ StreamPreview(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreamPreviews$fetchStreamPreview$1 */
    /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
    public static final class C57351 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57351(String str) {
            super(0);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreApplicationStreamPreviews.this.handleFetchStart(this.$streamKey);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreamPreviews$fetchStreamPreview$2 */
    /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
    public static final class C57362 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57362(String str) {
            super(1);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            StoreApplicationStreamPreviews.this.fetchStreamPreviewSubscriptions.put(this.$streamKey, subscription);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreamPreviews$fetchStreamPreview$3 */
    /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
    public static final class C57373 extends AbstractC12240o implements Function1<ModelApplicationStreamPreview, Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreamPreviews$fetchStreamPreview$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ ModelApplicationStreamPreview $res;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ModelApplicationStreamPreview modelApplicationStreamPreview) {
                super(0);
                this.$res = modelApplicationStreamPreview;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C57373 c57373 = C57373.this;
                StoreApplicationStreamPreviews.this.handleFetchSuccess(c57373.$streamKey, this.$res.getUrl());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57373(String str) {
            super(1);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelApplicationStreamPreview modelApplicationStreamPreview) {
            invoke2(modelApplicationStreamPreview);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelApplicationStreamPreview modelApplicationStreamPreview) {
            C12238m.checkNotNullParameter(modelApplicationStreamPreview, "res");
            StoreApplicationStreamPreviews.this.dispatcher.schedule(new AnonymousClass1(modelApplicationStreamPreview));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreamPreviews$fetchStreamPreview$4 */
    /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
    public static final class C57384 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreamPreviews$fetchStreamPreview$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$error = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C57384 c57384 = C57384.this;
                StoreApplicationStreamPreviews.this.handleFetchFailed(c57384.$streamKey, this.$error);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57384(String str) {
            super(1);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "error");
            StoreApplicationStreamPreviews.this.dispatcher.schedule(new AnonymousClass1(error));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreamPreviews$fetchStreamPreview$5 */
    /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
    public static final class C57395 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57395(String str) {
            super(0);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreApplicationStreamPreviews.this.fetchStreamPreviewSubscriptions.remove(this.$streamKey);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreamPreviews$handleFetchFailed$1 */
    /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
    public static final class C57401 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57401(String str) {
            super(1);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            StoreApplicationStreamPreviews.this.fetchStreamPreviewSubscriptions.put(this.$streamKey, subscription);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreamPreviews$handleFetchFailed$2 */
    /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
    public static final class C57412 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57412(String str) {
            super(0);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreApplicationStreamPreviews.this.fetchStreamPreviewSubscriptions.remove(this.$streamKey);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreamPreviews$handleFetchFailed$3 */
    /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
    public static final class C57423 extends AbstractC12240o implements Function1<Long, Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreamPreviews$handleFetchFailed$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C57423 c57423 = C57423.this;
                StoreApplicationStreamPreviews.this.fetchStreamPreviewIfNotFetching(c57423.$streamKey);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57423(String str) {
            super(1);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            StoreApplicationStreamPreviews.this.dispatcher.schedule(new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreamPreviews$observeStreamPreview$1 */
    /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
    public static final class C57431 extends AbstractC12240o implements Function0<StreamPreview> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57431(String str) {
            super(0);
            this.$streamKey = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StreamPreview invoke() {
            return StoreApplicationStreamPreviews.this.getStreamKeyToPreviewMap().get(this.$streamKey);
        }
    }

    public /* synthetic */ StoreApplicationStreamPreviews(Dispatcher dispatcher, Clock clock, RestAPI restAPI, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, clock, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 8) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    private final void fetchStreamPreview(String streamKey) {
        this.dispatcher.schedule(new C57351(streamKey));
        Subscription subscription = this.fetchStreamPreviewSubscriptions.get(streamKey);
        if (subscription != null) {
            subscription.unsubscribe();
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn(this.restAPI.getStreamPreview(streamKey, this.clock.currentTimeMillis()), false), (Class<?>) StoreApplicationStreamPreviews.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C57362(streamKey)), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C57384(streamKey)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : new C57395(streamKey)), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C57373(streamKey));
    }

    public final void fetchStreamPreviewIfNotFetching(StreamContext streamContext) {
        C12238m.checkNotNullParameter(streamContext, "streamContext");
        fetchStreamPreviewIfNotFetching(streamContext.getPreview(), streamContext.getStream().getEncodedStreamKey());
    }

    public final Map<String, StreamPreview> getStreamKeyToPreviewMap() {
        return this.streamKeyToPreviewMapSnapshot;
    }

    @StoreThread
    public final void handleFetchFailed(String streamKey, Error error) {
        C12238m.checkNotNullParameter(streamKey, "streamKey");
        C12238m.checkNotNullParameter(error, "error");
        Long lValueOf = null;
        this.streamKeyToPreviewMap.put(streamKey, new StreamPreview.Resolved(null));
        Throwable throwable = error.getThrowable();
        if (!(throwable instanceof HttpException)) {
            throwable = null;
        }
        HttpException httpException = (HttpException) throwable;
        Integer numValueOf = httpException != null ? Integer.valueOf(httpException.m11055a()) : null;
        Error.Response response = error.getResponse();
        C12238m.checkNotNullExpressionValue(response, "error.response");
        Long retryAfterMs = response.getRetryAfterMs();
        Integer num = this.fetchAttempts.get(streamKey);
        if (num == null) {
            num = 0;
        }
        C12238m.checkNotNullExpressionValue(num, "fetchAttempts[streamKey] ?: 0");
        int iIntValue = num.intValue() + 1;
        long jLongValue = ((long) iIntValue) * 10000;
        if (numValueOf == null) {
            lValueOf = Long.valueOf(jLongValue);
        } else if (numValueOf.intValue() == 429) {
            if (retryAfterMs != null) {
                jLongValue = retryAfterMs.longValue();
            }
            lValueOf = Long.valueOf(jLongValue);
        } else if (numValueOf.intValue() != 401 && numValueOf.intValue() != 403) {
            lValueOf = Long.valueOf(jLongValue);
        }
        if (lValueOf != null) {
            Subscription subscription = this.fetchStreamPreviewSubscriptions.get(streamKey);
            if (subscription != null) {
                subscription.unsubscribe();
            }
            Observable<Long> observableM11068d0 = Observable.m11068d0(lValueOf.longValue(), TimeUnit.MILLISECONDS);
            C12238m.checkNotNullExpressionValue(observableM11068d0, "Observable.timer(retryAf…s, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe(observableM11068d0, (Class<?>) StoreApplicationStreamPreviews.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C57401(streamKey)), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : new C57412(streamKey)), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C57423(streamKey));
        }
        this.fetchAttempts.put(streamKey, Integer.valueOf(iIntValue));
        markChanged();
    }

    @StoreThread
    public final void handleFetchStart(String streamKey) {
        C12238m.checkNotNullParameter(streamKey, "streamKey");
        this.streamKeyToPreviewMap.put(streamKey, StreamPreview.Fetching.INSTANCE);
        markChanged();
    }

    @StoreThread
    public final void handleFetchSuccess(String streamKey, String url) {
        C12238m.checkNotNullParameter(streamKey, "streamKey");
        C12238m.checkNotNullParameter(url, "url");
        this.streamKeyToPreviewMap.put(streamKey, new StreamPreview.Resolved(url));
        this.fetchAttempts.remove(streamKey);
        markChanged();
    }

    public final Observable<StreamPreview> observeStreamPreview(ModelApplicationStream applicationStream) {
        C12238m.checkNotNullParameter(applicationStream, "applicationStream");
        return observeStreamPreview(applicationStream.getEncodedStreamKey());
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.streamKeyToPreviewMapSnapshot = new HashMap(this.streamKeyToPreviewMap);
    }

    public final Observable<StreamPreview> observeStreamPreview(String streamKey) {
        C12238m.checkNotNullParameter(streamKey, "streamKey");
        Observable<StreamPreview> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C57431(streamKey), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public StoreApplicationStreamPreviews(Dispatcher dispatcher, Clock clock, RestAPI restAPI, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(clock, "clock");
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.restAPI = restAPI;
        this.observationDeck = observationDeck;
        this.streamKeyToPreviewMap = new HashMap();
        this.streamKeyToPreviewMapSnapshot = C12136h0.emptyMap();
        this.fetchAttempts = new HashMap<>();
        this.fetchStreamPreviewSubscriptions = new HashMap<>();
    }

    @StoreThread
    private final void fetchStreamPreviewIfNotFetching(String streamKey) {
        fetchStreamPreviewIfNotFetching(this.streamKeyToPreviewMap.get(streamKey), streamKey);
    }

    private final void fetchStreamPreviewIfNotFetching(StreamPreview preview, String streamKey) {
        if (preview == null || !(preview instanceof StreamPreview.Fetching)) {
            fetchStreamPreview(streamKey);
        }
    }
}

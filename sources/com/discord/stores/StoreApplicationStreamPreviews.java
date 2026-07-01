package com.discord.stores;

import android.content.Context;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.time.Clock;
import d0.t.h0;
import d0.z.d.m;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import retrofit2.HttpException;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationStreamPreviews extends StoreV2 {
    private static final StoreApplicationStreamPreviews$Companion Companion = new StoreApplicationStreamPreviews$Companion(null);

    @Deprecated
    private static final long READ_PREVIEW_DEFAULT_RETRY_DELAY_MS = 10000;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private final HashMap<String, Integer> fetchAttempts;
    private final HashMap<String, Subscription> fetchStreamPreviewSubscriptions;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;
    private final Map<String, StoreApplicationStreamPreviews$StreamPreview> streamKeyToPreviewMap;
    private Map<String, ? extends StoreApplicationStreamPreviews$StreamPreview> streamKeyToPreviewMapSnapshot;

    public /* synthetic */ StoreApplicationStreamPreviews(Dispatcher dispatcher, Clock clock, RestAPI restAPI, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, clock, (i & 4) != 0 ? RestAPI.Companion.getApi() : restAPI, (i & 8) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ void access$fetchStreamPreviewIfNotFetching(StoreApplicationStreamPreviews storeApplicationStreamPreviews, String str) {
        storeApplicationStreamPreviews.fetchStreamPreviewIfNotFetching(str);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreApplicationStreamPreviews storeApplicationStreamPreviews) {
        return storeApplicationStreamPreviews.dispatcher;
    }

    public static final /* synthetic */ HashMap access$getFetchStreamPreviewSubscriptions$p(StoreApplicationStreamPreviews storeApplicationStreamPreviews) {
        return storeApplicationStreamPreviews.fetchStreamPreviewSubscriptions;
    }

    private final void fetchStreamPreview(String streamKey) {
        this.dispatcher.schedule(new StoreApplicationStreamPreviews$fetchStreamPreview$1(this, streamKey));
        Subscription subscription = this.fetchStreamPreviewSubscriptions.get(streamKey);
        if (subscription != null) {
            subscription.unsubscribe();
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn(this.restAPI.getStreamPreview(streamKey, this.clock.currentTimeMillis()), false), StoreApplicationStreamPreviews.class, (Context) null, new StoreApplicationStreamPreviews$fetchStreamPreview$2(this, streamKey), new StoreApplicationStreamPreviews$fetchStreamPreview$4(this, streamKey), new StoreApplicationStreamPreviews$fetchStreamPreview$5(this, streamKey), (Function0) null, new StoreApplicationStreamPreviews$fetchStreamPreview$3(this, streamKey), 34, (Object) null);
    }

    public final void fetchStreamPreviewIfNotFetching(StreamContext streamContext) {
        m.checkNotNullParameter(streamContext, "streamContext");
        fetchStreamPreviewIfNotFetching(streamContext.getPreview(), streamContext.getStream().getEncodedStreamKey());
    }

    public final Map<String, StoreApplicationStreamPreviews$StreamPreview> getStreamKeyToPreviewMap() {
        return this.streamKeyToPreviewMapSnapshot;
    }

    @StoreThread
    public final void handleFetchFailed(String streamKey, Error error) {
        m.checkNotNullParameter(streamKey, "streamKey");
        m.checkNotNullParameter(error, "error");
        Long lValueOf = null;
        this.streamKeyToPreviewMap.put(streamKey, new StoreApplicationStreamPreviews$StreamPreview$Resolved(null));
        Throwable throwable = error.getThrowable();
        if (!(throwable instanceof HttpException)) {
            throwable = null;
        }
        HttpException httpException = (HttpException) throwable;
        Integer numValueOf = httpException != null ? Integer.valueOf(httpException.a()) : null;
        Error$Response response = error.getResponse();
        m.checkNotNullExpressionValue(response, "error.response");
        Long retryAfterMs = response.getRetryAfterMs();
        Integer num = this.fetchAttempts.get(streamKey);
        if (num == null) {
            num = 0;
        }
        m.checkNotNullExpressionValue(num, "fetchAttempts[streamKey] ?: 0");
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
            Observable<Long> observableD0 = Observable.d0(lValueOf.longValue(), TimeUnit.MILLISECONDS);
            m.checkNotNullExpressionValue(observableD0, "Observable.timer(retryAf…s, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe$default(observableD0, StoreApplicationStreamPreviews.class, (Context) null, new StoreApplicationStreamPreviews$handleFetchFailed$1(this, streamKey), (Function1) null, new StoreApplicationStreamPreviews$handleFetchFailed$2(this, streamKey), (Function0) null, new StoreApplicationStreamPreviews$handleFetchFailed$3(this, streamKey), 42, (Object) null);
        }
        this.fetchAttempts.put(streamKey, Integer.valueOf(iIntValue));
        markChanged();
    }

    @StoreThread
    public final void handleFetchStart(String streamKey) {
        m.checkNotNullParameter(streamKey, "streamKey");
        this.streamKeyToPreviewMap.put(streamKey, StoreApplicationStreamPreviews$StreamPreview$Fetching.INSTANCE);
        markChanged();
    }

    @StoreThread
    public final void handleFetchSuccess(String streamKey, String url) {
        m.checkNotNullParameter(streamKey, "streamKey");
        m.checkNotNullParameter(url, "url");
        this.streamKeyToPreviewMap.put(streamKey, new StoreApplicationStreamPreviews$StreamPreview$Resolved(url));
        this.fetchAttempts.remove(streamKey);
        markChanged();
    }

    public final Observable<StoreApplicationStreamPreviews$StreamPreview> observeStreamPreview(ModelApplicationStream applicationStream) {
        m.checkNotNullParameter(applicationStream, "applicationStream");
        return observeStreamPreview(applicationStream.getEncodedStreamKey());
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.streamKeyToPreviewMapSnapshot = new HashMap(this.streamKeyToPreviewMap);
    }

    public final Observable<StoreApplicationStreamPreviews$StreamPreview> observeStreamPreview(String streamKey) {
        m.checkNotNullParameter(streamKey, "streamKey");
        Observable<StoreApplicationStreamPreviews$StreamPreview> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreApplicationStreamPreviews$observeStreamPreview$1(this, streamKey), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public StoreApplicationStreamPreviews(Dispatcher dispatcher, Clock clock, RestAPI restAPI, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.restAPI = restAPI;
        this.observationDeck = observationDeck;
        this.streamKeyToPreviewMap = new HashMap();
        this.streamKeyToPreviewMapSnapshot = h0.emptyMap();
        this.fetchAttempts = new HashMap<>();
        this.fetchStreamPreviewSubscriptions = new HashMap<>();
    }

    @StoreThread
    private final void fetchStreamPreviewIfNotFetching(String streamKey) {
        fetchStreamPreviewIfNotFetching(this.streamKeyToPreviewMap.get(streamKey), streamKey);
    }

    private final void fetchStreamPreviewIfNotFetching(StoreApplicationStreamPreviews$StreamPreview preview, String streamKey) {
        if (preview == null || !(preview instanceof StoreApplicationStreamPreviews$StreamPreview$Fetching)) {
            fetchStreamPreview(streamKey);
        }
    }
}

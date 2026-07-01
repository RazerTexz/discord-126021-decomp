package com.discord.utilities.friendsuggestions;

import android.content.Context;
import com.discord.api.friendsuggestions.FriendSuggestion;
import com.discord.restapi.RestAPIInterface;
import com.discord.stores.Dispatcher;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: FriendSuggestionsFetcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FriendSuggestionsFetcher {
    private final Dispatcher dispatcher;
    private Subscription fetchSubscription;
    private final Function0<Unit> onFetchFailure;
    private final Function1<List<FriendSuggestion>, Unit> onFetchSuccess;
    private final RestAPIInterface restApi;

    /* JADX WARN: Multi-variable type inference failed */
    public FriendSuggestionsFetcher(Dispatcher dispatcher, RestAPIInterface restAPIInterface, Function1<? super List<FriendSuggestion>, Unit> function1, Function0<Unit> function0) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(restAPIInterface, "restApi");
        m.checkNotNullParameter(function1, "onFetchSuccess");
        m.checkNotNullParameter(function0, "onFetchFailure");
        this.dispatcher = dispatcher;
        this.restApi = restAPIInterface;
        this.onFetchSuccess = function1;
        this.onFetchFailure = function0;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(FriendSuggestionsFetcher friendSuggestionsFetcher) {
        return friendSuggestionsFetcher.dispatcher;
    }

    public static final /* synthetic */ Subscription access$getFetchSubscription$p(FriendSuggestionsFetcher friendSuggestionsFetcher) {
        return friendSuggestionsFetcher.fetchSubscription;
    }

    public static final /* synthetic */ Function0 access$getOnFetchFailure$p(FriendSuggestionsFetcher friendSuggestionsFetcher) {
        return friendSuggestionsFetcher.onFetchFailure;
    }

    public static final /* synthetic */ Function1 access$getOnFetchSuccess$p(FriendSuggestionsFetcher friendSuggestionsFetcher) {
        return friendSuggestionsFetcher.onFetchSuccess;
    }

    public static final /* synthetic */ void access$setFetchSubscription$p(FriendSuggestionsFetcher friendSuggestionsFetcher, Subscription subscription) {
        friendSuggestionsFetcher.fetchSubscription = subscription;
    }

    public final void maybeFetch() {
        Subscription subscription = this.fetchSubscription;
        if (subscription == null || subscription.isUnsubscribed()) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.getFriendSuggestions(), false, 1, null), FriendSuggestionsFetcher.class, (Context) null, new FriendSuggestionsFetcher$maybeFetch$1(this), new FriendSuggestionsFetcher$maybeFetch$3(this), (Function0) null, (Function0) null, new FriendSuggestionsFetcher$maybeFetch$2(this), 50, (Object) null);
        }
    }
}

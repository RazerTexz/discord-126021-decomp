package com.discord.utilities.friendsuggestions;

import com.discord.api.friendsuggestions.FriendSuggestion;
import com.discord.restapi.RestAPIInterface;
import com.discord.stores.Dispatcher;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
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

    /* JADX INFO: renamed from: com.discord.utilities.friendsuggestions.FriendSuggestionsFetcher$maybeFetch$1, reason: invalid class name */
    /* JADX INFO: compiled from: FriendSuggestionsFetcher.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            FriendSuggestionsFetcher.this.fetchSubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.friendsuggestions.FriendSuggestionsFetcher$maybeFetch$2, reason: invalid class name */
    /* JADX INFO: compiled from: FriendSuggestionsFetcher.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<List<? extends FriendSuggestion>, Unit> {

        /* JADX INFO: renamed from: com.discord.utilities.friendsuggestions.FriendSuggestionsFetcher$maybeFetch$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: FriendSuggestionsFetcher.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $response;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$response = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FriendSuggestionsFetcher.this.onFetchSuccess.invoke(this.$response);
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends FriendSuggestion> list) {
            invoke2((List<FriendSuggestion>) list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<FriendSuggestion> list) {
            Intrinsics3.checkNotNullParameter(list, "response");
            FriendSuggestionsFetcher.this.dispatcher.schedule(new AnonymousClass1(list));
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.friendsuggestions.FriendSuggestionsFetcher$maybeFetch$3, reason: invalid class name */
    /* JADX INFO: compiled from: FriendSuggestionsFetcher.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {

        /* JADX INFO: renamed from: com.discord.utilities.friendsuggestions.FriendSuggestionsFetcher$maybeFetch$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: FriendSuggestionsFetcher.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FriendSuggestionsFetcher.this.onFetchFailure.invoke();
            }
        }

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            FriendSuggestionsFetcher.this.dispatcher.schedule(new AnonymousClass1());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FriendSuggestionsFetcher(Dispatcher dispatcher, RestAPIInterface restAPIInterface, Function1<? super List<FriendSuggestion>, Unit> function1, Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(restAPIInterface, "restApi");
        Intrinsics3.checkNotNullParameter(function1, "onFetchSuccess");
        Intrinsics3.checkNotNullParameter(function0, "onFetchFailure");
        this.dispatcher = dispatcher;
        this.restApi = restAPIInterface;
        this.onFetchSuccess = function1;
        this.onFetchFailure = function0;
    }

    public final void maybeFetch() {
        Subscription subscription = this.fetchSubscription;
        if (subscription == null || subscription.isUnsubscribed()) {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.getFriendSuggestions(), false, 1, null), (Class<?>) FriendSuggestionsFetcher.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass1()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass3()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
        }
    }
}

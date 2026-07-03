package com.discord.utilities.friendsuggestions;

import com.discord.api.friendsuggestions.FriendSuggestion;
import com.discord.restapi.RestAPIInterface;
import com.discord.stores.Dispatcher;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: FriendSuggestionsFetcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FriendSuggestionsFetcher {
    private final Dispatcher dispatcher;
    private Subscription fetchSubscription;
    private final Function0<Unit> onFetchFailure;
    private final Function1<List<FriendSuggestion>, Unit> onFetchSuccess;
    private final RestAPIInterface restApi;

    /* JADX INFO: renamed from: com.discord.utilities.friendsuggestions.FriendSuggestionsFetcher$maybeFetch$1 */
    /* JADX INFO: compiled from: FriendSuggestionsFetcher.kt */
    public static final class C67581 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C67581() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            FriendSuggestionsFetcher.this.fetchSubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.friendsuggestions.FriendSuggestionsFetcher$maybeFetch$2 */
    /* JADX INFO: compiled from: FriendSuggestionsFetcher.kt */
    public static final class C67592 extends AbstractC12240o implements Function1<List<? extends FriendSuggestion>, Unit> {

        /* JADX INFO: renamed from: com.discord.utilities.friendsuggestions.FriendSuggestionsFetcher$maybeFetch$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: FriendSuggestionsFetcher.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ List $response;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$response = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FriendSuggestionsFetcher.this.onFetchSuccess.invoke(this.$response);
            }
        }

        public C67592() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends FriendSuggestion> list) {
            invoke2((List<FriendSuggestion>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<FriendSuggestion> list) {
            C12238m.checkNotNullParameter(list, "response");
            FriendSuggestionsFetcher.this.dispatcher.schedule(new AnonymousClass1(list));
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.friendsuggestions.FriendSuggestionsFetcher$maybeFetch$3 */
    /* JADX INFO: compiled from: FriendSuggestionsFetcher.kt */
    public static final class C67603 extends AbstractC12240o implements Function1<Error, Unit> {

        /* JADX INFO: renamed from: com.discord.utilities.friendsuggestions.FriendSuggestionsFetcher$maybeFetch$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: FriendSuggestionsFetcher.kt */
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
                FriendSuggestionsFetcher.this.onFetchFailure.invoke();
            }
        }

        public C67603() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            FriendSuggestionsFetcher.this.dispatcher.schedule(new AnonymousClass1());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FriendSuggestionsFetcher(Dispatcher dispatcher, RestAPIInterface restAPIInterface, Function1<? super List<FriendSuggestion>, Unit> function1, Function0<Unit> function0) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(restAPIInterface, "restApi");
        C12238m.checkNotNullParameter(function1, "onFetchSuccess");
        C12238m.checkNotNullParameter(function0, "onFetchFailure");
        this.dispatcher = dispatcher;
        this.restApi = restAPIInterface;
        this.onFetchSuccess = function1;
        this.onFetchFailure = function0;
    }

    public final void maybeFetch() {
        Subscription subscription = this.fetchSubscription;
        if (subscription == null || subscription.isUnsubscribed()) {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.getFriendSuggestions(), false, 1, null), (Class<?>) FriendSuggestionsFetcher.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C67581()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C67603()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C67592());
        }
    }
}

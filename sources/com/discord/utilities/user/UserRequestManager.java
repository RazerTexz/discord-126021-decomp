package com.discord.utilities.user;

import com.discord.api.user.User;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: UserRequestManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserRequestManager {
    private final Function1<User, Unit> onFlush;
    private final HashMap<Long, Subscription> userRequests;

    /* JADX INFO: renamed from: com.discord.utilities.user.UserRequestManager$requestUser$1, reason: invalid class name */
    /* JADX INFO: compiled from: UserRequestManager.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<User, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            if (user != null) {
                UserRequestManager.this.onFlush.invoke(user);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.user.UserRequestManager$requestUser$2, reason: invalid class name */
    /* JADX INFO: compiled from: UserRequestManager.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
            super(0);
            this.$userId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            UserRequestManager.this.onRequestEnded(this.$userId);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.user.UserRequestManager$requestUser$3, reason: invalid class name */
    /* JADX INFO: compiled from: UserRequestManager.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Subscription, Unit> {
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(long j) {
            super(1);
            this.$userId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            UserRequestManager.this.onRequestStarted(this.$userId, subscription);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UserRequestManager(Function1<? super User, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "onFlush");
        this.onFlush = function1;
        this.userRequests = new HashMap<>();
    }

    private final synchronized void onRequestEnded(long userId) {
        Subscription subscriptionRemove = this.userRequests.remove(Long.valueOf(userId));
        if (subscriptionRemove != null) {
            subscriptionRemove.unsubscribe();
        }
    }

    private final synchronized void onRequestStarted(long userId, Subscription subscription) {
        this.userRequests.put(Long.valueOf(userId), subscription);
    }

    public final synchronized void requestUser(long userId) {
        if (this.userRequests.containsKey(Long.valueOf(userId))) {
            return;
        }
        Observable observableRestSubscribeOn$default = ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userGet(userId), false, 1, null);
        Class<?> cls = getClass();
        ObservableExtensionsKt.appSubscribe(observableRestSubscribeOn$default, (Class<?>) cls, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass3(userId)), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : new AnonymousClass2(userId)), new AnonymousClass1());
    }

    public final synchronized void requestUsers(Collection<Long> userIds) {
        Intrinsics3.checkNotNullParameter(userIds, "userIds");
        Iterator<T> it = userIds.iterator();
        while (it.hasNext()) {
            requestUser(((Number) it.next()).longValue());
        }
    }
}

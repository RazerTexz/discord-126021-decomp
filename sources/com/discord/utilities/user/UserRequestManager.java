package com.discord.utilities.user;

import com.discord.api.user.User;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: UserRequestManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserRequestManager {
    private final Function1<User, Unit> onFlush;
    private final HashMap<Long, Subscription> userRequests;

    /* JADX INFO: renamed from: com.discord.utilities.user.UserRequestManager$requestUser$1 */
    /* JADX INFO: compiled from: UserRequestManager.kt */
    public static final class C69841 extends AbstractC12240o implements Function1<User, Unit> {
        public C69841() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            if (user != null) {
                UserRequestManager.this.onFlush.invoke(user);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.user.UserRequestManager$requestUser$2 */
    /* JADX INFO: compiled from: UserRequestManager.kt */
    public static final class C69852 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69852(long j) {
            super(0);
            this.$userId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            UserRequestManager.this.onRequestEnded(this.$userId);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.user.UserRequestManager$requestUser$3 */
    /* JADX INFO: compiled from: UserRequestManager.kt */
    public static final class C69863 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69863(long j) {
            super(1);
            this.$userId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, "it");
            UserRequestManager.this.onRequestStarted(this.$userId, subscription);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UserRequestManager(Function1<? super User, Unit> function1) {
        C12238m.checkNotNullParameter(function1, "onFlush");
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
        ObservableExtensionsKt.appSubscribe(observableRestSubscribeOn$default, (Class<?>) cls, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C69863(userId)), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : new C69852(userId)), new C69841());
    }

    public final synchronized void requestUsers(Collection<Long> userIds) {
        C12238m.checkNotNullParameter(userIds, "userIds");
        Iterator<T> it = userIds.iterator();
        while (it.hasNext()) {
            requestUser(((Number) it.next()).longValue());
        }
    }
}

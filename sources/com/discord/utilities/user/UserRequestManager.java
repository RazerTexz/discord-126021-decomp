package com.discord.utilities.user;

import android.content.Context;
import com.discord.api.user.User;
import com.discord.utilities.analytics.Traits$Payment$Type;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
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

    /* JADX WARN: Multi-variable type inference failed */
    public UserRequestManager(Function1<? super User, Unit> function1) {
        m.checkNotNullParameter(function1, "onFlush");
        this.onFlush = function1;
        this.userRequests = new HashMap<>();
    }

    public static final /* synthetic */ Function1 access$getOnFlush$p(UserRequestManager userRequestManager) {
        return userRequestManager.onFlush;
    }

    public static final /* synthetic */ void access$onRequestEnded(UserRequestManager userRequestManager, long j) {
        userRequestManager.onRequestEnded(j);
    }

    public static final /* synthetic */ void access$onRequestStarted(UserRequestManager userRequestManager, long j, Subscription subscription) {
        userRequestManager.onRequestStarted(j, subscription);
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
        Observable observableRestSubscribeOn$default = ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().userGet(userId), false, 1, null);
        Class<?> cls = getClass();
        UserRequestManager$requestUser$1 userRequestManager$requestUser$1 = new UserRequestManager$requestUser$1(this);
        ObservableExtensionsKt.appSubscribe$default(observableRestSubscribeOn$default, cls, (Context) null, new UserRequestManager$requestUser$3(this, userId), (Function1) null, (Function0) null, new UserRequestManager$requestUser$2(this, userId), userRequestManager$requestUser$1, 26, (Object) null);
    }

    public final synchronized void requestUsers(Collection<Long> userIds) {
        m.checkNotNullParameter(userIds, "userIds");
        Iterator<T> it = userIds.iterator();
        while (it.hasNext()) {
            requestUser(((Number) it.next()).longValue());
        }
    }
}

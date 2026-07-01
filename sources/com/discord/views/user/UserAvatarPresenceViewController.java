package com.discord.views.user;

import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import com.discord.utilities.viewcontroller.RxViewController;
import com.discord.views.user.UserAvatarPresenceView;
import com.discord.widgets.user.presence.ModelRichPresence;
import d0.z.d.Intrinsics3;
import rx.Observable;
import rx.functions.Func3;

/* JADX INFO: compiled from: UserAvatarPresenceViewController.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserAvatarPresenceViewController extends RxViewController<UserAvatarPresenceView, UserAvatarPresenceView.a> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public long userId;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final StoreUser storeUser;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final StoreUserPresence storeUserPresence;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final StreamContextService streamContextService;

    /* JADX INFO: compiled from: UserAvatarPresenceViewController.kt */
    public static final class a<T1, T2, T3, R> implements Func3<User, ModelRichPresence, StreamContext, UserAvatarPresenceView.a> {
        public static final a a = new a();

        @Override // rx.functions.Func3
        public UserAvatarPresenceView.a call(User user, ModelRichPresence modelRichPresence, StreamContext streamContext) {
            User user2 = user;
            ModelRichPresence modelRichPresence2 = modelRichPresence;
            StreamContext streamContext2 = streamContext;
            Intrinsics3.checkNotNullExpressionValue(user2, "user");
            return new UserAvatarPresenceView.a(user2, modelRichPresence2 != null ? modelRichPresence2.getPresence() : null, streamContext2, true, null, 16);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserAvatarPresenceViewController(UserAvatarPresenceView userAvatarPresenceView, StoreUser storeUser, StoreUserPresence storeUserPresence, StreamContextService streamContextService, int i) {
        super(userAvatarPresenceView);
        StoreUser users = (i & 2) != 0 ? StoreStream.INSTANCE.getUsers() : null;
        StoreUserPresence presences = (i & 4) != 0 ? StoreStream.INSTANCE.getPresences() : null;
        StreamContextService streamContextService2 = (i & 8) != 0 ? new StreamContextService(null, null, null, null, null, null, null, null, 255, null) : null;
        Intrinsics3.checkNotNullParameter(userAvatarPresenceView, "view");
        Intrinsics3.checkNotNullParameter(users, "storeUser");
        Intrinsics3.checkNotNullParameter(presences, "storeUserPresence");
        Intrinsics3.checkNotNullParameter(streamContextService2, "streamContextService");
        this.storeUser = users;
        this.storeUserPresence = presences;
        this.streamContextService = streamContextService2;
    }

    @Override // com.discord.utilities.viewcontroller.RxViewController
    public void configureView(UserAvatarPresenceView.a aVar) {
        UserAvatarPresenceView.a aVar2 = aVar;
        Intrinsics3.checkNotNullParameter(aVar2, "viewState");
        getView().a(aVar2);
    }

    @Override // com.discord.utilities.viewcontroller.RxViewController
    public Observable<UserAvatarPresenceView.a> observeState() {
        Observable<R> observableG = this.storeUser.observeUser(this.userId).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable<UserAvatarPresenceView.a> observableI = Observable.i(observableG, ModelRichPresence.INSTANCE.get(this.userId, this.storeUserPresence), this.streamContextService.getForUser(this.userId, false), a.a);
        Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…nce = true,\n      )\n    }");
        return observableI;
    }
}

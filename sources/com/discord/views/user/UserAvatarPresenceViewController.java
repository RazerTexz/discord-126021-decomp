package com.discord.views.user;

import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import com.discord.utilities.viewcontroller.RxViewController;
import com.discord.widgets.user.presence.ModelRichPresence;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.functions.Func3;

/* JADX INFO: compiled from: UserAvatarPresenceViewController.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserAvatarPresenceViewController extends RxViewController<UserAvatarPresenceView, UserAvatarPresenceView.C7131a> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public long userId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final StoreUser storeUser;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final StoreUserPresence storeUserPresence;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final StreamContextService streamContextService;

    /* JADX INFO: renamed from: com.discord.views.user.UserAvatarPresenceViewController$a */
    /* JADX INFO: compiled from: UserAvatarPresenceViewController.kt */
    public static final class C7135a<T1, T2, T3, R> implements Func3<User, ModelRichPresence, StreamContext, UserAvatarPresenceView.C7131a> {

        /* JADX INFO: renamed from: a */
        public static final C7135a f19365a = new C7135a();

        @Override // p658rx.functions.Func3
        public UserAvatarPresenceView.C7131a call(User user, ModelRichPresence modelRichPresence, StreamContext streamContext) {
            User user2 = user;
            ModelRichPresence modelRichPresence2 = modelRichPresence;
            StreamContext streamContext2 = streamContext;
            C12238m.checkNotNullExpressionValue(user2, "user");
            return new UserAvatarPresenceView.C7131a(user2, modelRichPresence2 != null ? modelRichPresence2.getPresence() : null, streamContext2, true, null, 16);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserAvatarPresenceViewController(UserAvatarPresenceView userAvatarPresenceView, StoreUser storeUser, StoreUserPresence storeUserPresence, StreamContextService streamContextService, int i) {
        super(userAvatarPresenceView);
        StoreUser users = (i & 2) != 0 ? StoreStream.INSTANCE.getUsers() : null;
        StoreUserPresence presences = (i & 4) != 0 ? StoreStream.INSTANCE.getPresences() : null;
        StreamContextService streamContextService2 = (i & 8) != 0 ? new StreamContextService(null, null, null, null, null, null, null, null, 255, null) : null;
        C12238m.checkNotNullParameter(userAvatarPresenceView, "view");
        C12238m.checkNotNullParameter(users, "storeUser");
        C12238m.checkNotNullParameter(presences, "storeUserPresence");
        C12238m.checkNotNullParameter(streamContextService2, "streamContextService");
        this.storeUser = users;
        this.storeUserPresence = presences;
        this.streamContextService = streamContextService2;
    }

    @Override // com.discord.utilities.viewcontroller.RxViewController
    public void configureView(UserAvatarPresenceView.C7131a c7131a) {
        UserAvatarPresenceView.C7131a c7131a2 = c7131a;
        C12238m.checkNotNullParameter(c7131a2, "viewState");
        getView().m8622a(c7131a2);
    }

    @Override // com.discord.utilities.viewcontroller.RxViewController
    public Observable<UserAvatarPresenceView.C7131a> observeState() {
        Observable<R> observableM11083G = this.storeUser.observeUser(this.userId).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
        C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
        Observable<UserAvatarPresenceView.C7131a> observableM11075i = Observable.m11075i(observableM11083G, ModelRichPresence.INSTANCE.get(this.userId, this.storeUserPresence), this.streamContextService.getForUser(this.userId, false), C7135a.f19365a);
        C12238m.checkNotNullExpressionValue(observableM11075i, "Observable.combineLatest…nce = true,\n      )\n    }");
        return observableM11075i;
    }
}

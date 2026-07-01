package com.discord.views.user;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import com.discord.utilities.streams.StreamContextService;
import com.discord.utilities.viewcontroller.RxViewController;
import com.discord.widgets.user.presence.ModelRichPresence;
import d0.z.d.m;
import rx.Observable;

/* JADX INFO: compiled from: UserAvatarPresenceViewController.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserAvatarPresenceViewController extends RxViewController<UserAvatarPresenceView, UserAvatarPresenceView$a> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public long userId;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final StoreUser storeUser;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final StoreUserPresence storeUserPresence;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final StreamContextService streamContextService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserAvatarPresenceViewController(UserAvatarPresenceView userAvatarPresenceView, StoreUser storeUser, StoreUserPresence storeUserPresence, StreamContextService streamContextService, int i) {
        super(userAvatarPresenceView);
        StoreUser users = (i & 2) != 0 ? StoreStream.Companion.getUsers() : null;
        StoreUserPresence presences = (i & 4) != 0 ? StoreStream.Companion.getPresences() : null;
        StreamContextService streamContextService2 = (i & 8) != 0 ? new StreamContextService(null, null, null, null, null, null, null, null, 255, null) : null;
        m.checkNotNullParameter(userAvatarPresenceView, "view");
        m.checkNotNullParameter(users, "storeUser");
        m.checkNotNullParameter(presences, "storeUserPresence");
        m.checkNotNullParameter(streamContextService2, "streamContextService");
        this.storeUser = users;
        this.storeUserPresence = presences;
        this.streamContextService = streamContextService2;
    }

    @Override // com.discord.utilities.viewcontroller.RxViewController
    public void configureView(UserAvatarPresenceView$a userAvatarPresenceView$a) {
        UserAvatarPresenceView$a userAvatarPresenceView$a2 = userAvatarPresenceView$a;
        m.checkNotNullParameter(userAvatarPresenceView$a2, "viewState");
        getView().a(userAvatarPresenceView$a2);
    }

    @Override // com.discord.utilities.viewcontroller.RxViewController
    public Observable<UserAvatarPresenceView$a> observeState() {
        Observable<R> observableG = this.storeUser.observeUser(this.userId).y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable<UserAvatarPresenceView$a> observableI = Observable.i(observableG, ModelRichPresence.Companion.get(this.userId, this.storeUserPresence), this.streamContextService.getForUser(this.userId, false), UserAvatarPresenceViewController$a.a);
        m.checkNotNullExpressionValue(observableI, "Observable.combineLatest…nce = true,\n      )\n    }");
        return observableI;
    }
}

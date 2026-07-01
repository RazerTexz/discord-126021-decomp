package com.discord.widgets.chat.managereactions;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: ManageReactionsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsModelProvider$get$2<T, R> implements b<MeUser, Observable<? extends ManageReactionsModel>> {
    public final /* synthetic */ ManageReactionsModelProvider$get$1 $getCanManageMessagesObs$1;
    public final /* synthetic */ Observable $guildMembersObservable;
    public final /* synthetic */ Observable $reactionsObs;
    public final /* synthetic */ ManageReactionsModelProvider this$0;

    public ManageReactionsModelProvider$get$2(ManageReactionsModelProvider manageReactionsModelProvider, ManageReactionsModelProvider$get$1 manageReactionsModelProvider$get$1, Observable observable, Observable observable2) {
        this.this$0 = manageReactionsModelProvider;
        this.$getCanManageMessagesObs$1 = manageReactionsModelProvider$get$1;
        this.$reactionsObs = observable;
        this.$guildMembersObservable = observable2;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends ManageReactionsModel> call(MeUser meUser) {
        return call2(meUser);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ManageReactionsModel> call2(MeUser meUser) {
        return Observable.i(this.$getCanManageMessagesObs$1.invoke(meUser.getMfaEnabled()), this.$reactionsObs, this.$guildMembersObservable, ManageReactionsModelProvider$get$2$1.INSTANCE).Y(new ManageReactionsModelProvider$get$2$2(this, meUser));
    }
}

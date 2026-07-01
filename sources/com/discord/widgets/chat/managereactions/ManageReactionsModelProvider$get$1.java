package com.discord.widgets.chat.managereactions;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: ManageReactionsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsModelProvider$get$1 extends o implements Function1<Boolean, Observable<Boolean>> {
    public final /* synthetic */ ManageReactionsModelProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManageReactionsModelProvider$get$1(ManageReactionsModelProvider manageReactionsModelProvider) {
        super(1);
        this.this$0 = manageReactionsModelProvider;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Observable<Boolean> invoke(Boolean bool) {
        return invoke(bool.booleanValue());
    }

    public final Observable<Boolean> invoke(boolean z2) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<Boolean> observableJ = Observable.j(storeStream$Companion.getPermissions().observePermissionsForChannel(this.this$0.getChannelId()), storeStream$Companion.getGuilds().observeFromChannelId(this.this$0.getChannelId()), new ManageReactionsModelProvider$get$1$1(z2));
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…ld.mfaLevel\n      )\n    }");
        return observableJ;
    }
}

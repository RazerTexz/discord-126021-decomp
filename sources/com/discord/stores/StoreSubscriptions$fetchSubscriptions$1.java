package com.discord.stores;

import android.content.Context;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSubscriptions$fetchSubscriptions$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreSubscriptions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreSubscriptions$fetchSubscriptions$1(StoreSubscriptions storeSubscriptions) {
        super(0);
        this.this$0 = storeSubscriptions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (StoreSubscriptions.access$getSubscriptionsState$p(this.this$0) instanceof StoreSubscriptions$SubscriptionsState$Loading) {
            return;
        }
        StoreSubscriptions.access$handleSubscriptionsFetchStart(this.this$0);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(StoreSubscriptions.access$getRestAPI$p(this.this$0).getSubscriptions(), false, 1, null), this.this$0.getClass(), (Context) null, (Function1) null, new StoreSubscriptions$fetchSubscriptions$1$2(this), (Function0) null, (Function0) null, new StoreSubscriptions$fetchSubscriptions$1$1(this), 54, (Object) null);
    }
}

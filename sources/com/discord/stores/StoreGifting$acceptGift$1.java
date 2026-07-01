package com.discord.stores;

import android.content.Context;
import com.discord.models.domain.ModelGift;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import j0.p.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: StoreGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifting$acceptGift$1 extends o implements Function0<Unit> {
    public final /* synthetic */ ModelGift $gift;
    public final /* synthetic */ StoreGifting this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifting$acceptGift$1(StoreGifting storeGifting, ModelGift modelGift) {
        super(0);
        this.this$0 = storeGifting;
        this.$gift = modelGift;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGifting.access$setGifts(this.this$0, this.$gift.getCode(), new StoreGifting$GiftState$Redeeming(this.$gift));
        Observable<Void> observableX = RestAPI.Companion.getApi().acceptGift(this.$gift.getCode()).X(a.c());
        m.checkNotNullExpressionValue(observableX, "RestAPI\n        .api\n   …scribeOn(Schedulers.io())");
        ObservableExtensionsKt.appSubscribe$default(observableX, this.this$0.getClass(), (Context) null, (Function1) null, new StoreGifting$acceptGift$1$1(this), (Function0) null, (Function0) null, new StoreGifting$acceptGift$1$2(this), 54, (Object) null);
    }
}

package com.discord.widgets.settings.premium;

import com.discord.models.domain.ModelGift;
import com.discord.stores.StoreGooglePlayPurchases$Event;
import com.discord.stores.StoreGooglePlayPurchases$Event$PurchaseQuerySuccess;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsGiftingViewModel$handleGooglePlayPurchaseEvent$2 extends o implements Function1<ModelGift, Unit> {
    public final /* synthetic */ StoreGooglePlayPurchases$Event $event;
    public final /* synthetic */ SettingsGiftingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsGiftingViewModel$handleGooglePlayPurchaseEvent$2(SettingsGiftingViewModel settingsGiftingViewModel, StoreGooglePlayPurchases$Event storeGooglePlayPurchases$Event) {
        super(1);
        this.this$0 = settingsGiftingViewModel;
        this.$event = storeGooglePlayPurchases$Event;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelGift modelGift) {
        invoke2(modelGift);
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelGift modelGift) {
        m.checkNotNullParameter(modelGift, "it");
        SettingsGiftingViewModel.access$getStoreEntitlements$p(this.this$0).fetchMyGiftEntitlements();
        SettingsGiftingViewModel.access$getGiftPurchaseEventSubject$p(this.this$0).k.onNext((T) new SettingsGiftingViewModel$GiftPurchaseEvent$CompleteGiftPurchase(((StoreGooglePlayPurchases$Event$PurchaseQuerySuccess) this.$event).getNewSkuName(), modelGift.getCode()));
    }
}

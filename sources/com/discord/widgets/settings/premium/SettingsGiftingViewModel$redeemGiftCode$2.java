package com.discord.widgets.settings.premium;

import com.discord.stores.StoreGifting$GiftState;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SettingsGiftingViewModel$redeemGiftCode$2 extends k implements Function1<StoreGifting$GiftState, Unit> {
    public SettingsGiftingViewModel$redeemGiftCode$2(SettingsGiftingViewModel settingsGiftingViewModel) {
        super(1, settingsGiftingViewModel, SettingsGiftingViewModel.class, "onHandleGiftCode", "onHandleGiftCode(Lcom/discord/stores/StoreGifting$GiftState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreGifting$GiftState storeGifting$GiftState) {
        invoke2(storeGifting$GiftState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreGifting$GiftState storeGifting$GiftState) {
        m.checkNotNullParameter(storeGifting$GiftState, "p1");
        SettingsGiftingViewModel.access$onHandleGiftCode((SettingsGiftingViewModel) this.receiver, storeGifting$GiftState);
    }
}

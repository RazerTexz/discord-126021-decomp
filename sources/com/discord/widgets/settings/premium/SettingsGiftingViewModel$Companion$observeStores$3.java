package com.discord.widgets.settings.premium;

import com.discord.models.domain.ModelGift;
import com.discord.stores.StoreEntitlements$State;
import com.discord.stores.StoreOutboundPromotions$State;
import d0.z.d.k;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SettingsGiftingViewModel$Companion$observeStores$3 extends k implements Function4<StoreEntitlements$State, List<? extends ModelGift>, StoreOutboundPromotions$State, Boolean, SettingsGiftingViewModel$StoreState> {
    public static final SettingsGiftingViewModel$Companion$observeStores$3 INSTANCE = new SettingsGiftingViewModel$Companion$observeStores$3();

    public SettingsGiftingViewModel$Companion$observeStores$3() {
        super(4, SettingsGiftingViewModel$StoreState.class, "<init>", "<init>(Lcom/discord/stores/StoreEntitlements$State;Ljava/util/List;Lcom/discord/stores/StoreOutboundPromotions$State;Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ SettingsGiftingViewModel$StoreState invoke(StoreEntitlements$State storeEntitlements$State, List<? extends ModelGift> list, StoreOutboundPromotions$State storeOutboundPromotions$State, Boolean bool) {
        return invoke(storeEntitlements$State, (List<ModelGift>) list, storeOutboundPromotions$State, bool.booleanValue());
    }

    public final SettingsGiftingViewModel$StoreState invoke(StoreEntitlements$State storeEntitlements$State, List<ModelGift> list, StoreOutboundPromotions$State storeOutboundPromotions$State, boolean z2) {
        m.checkNotNullParameter(storeEntitlements$State, "p1");
        m.checkNotNullParameter(list, "p2");
        m.checkNotNullParameter(storeOutboundPromotions$State, "p3");
        return new SettingsGiftingViewModel$StoreState(storeEntitlements$State, list, storeOutboundPromotions$State, z2);
    }
}

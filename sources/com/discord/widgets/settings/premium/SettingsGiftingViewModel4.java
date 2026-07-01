package com.discord.widgets.settings.premium;

import com.discord.models.domain.ModelGift;
import com.discord.stores.StoreEntitlements;
import com.discord.stores.StoreOutboundPromotions;
import com.discord.widgets.settings.premium.SettingsGiftingViewModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.functions.Function4;

/* JADX INFO: renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$Companion$observeStores$3, reason: use source file name */
/* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SettingsGiftingViewModel4 extends FunctionReferenceImpl implements Function4<StoreEntitlements.State, List<? extends ModelGift>, StoreOutboundPromotions.State, Boolean, SettingsGiftingViewModel.StoreState> {
    public static final SettingsGiftingViewModel4 INSTANCE = new SettingsGiftingViewModel4();

    public SettingsGiftingViewModel4() {
        super(4, SettingsGiftingViewModel.StoreState.class, "<init>", "<init>(Lcom/discord/stores/StoreEntitlements$State;Ljava/util/List;Lcom/discord/stores/StoreOutboundPromotions$State;Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ SettingsGiftingViewModel.StoreState invoke(StoreEntitlements.State state, List<? extends ModelGift> list, StoreOutboundPromotions.State state2, Boolean bool) {
        return invoke(state, (List<ModelGift>) list, state2, bool.booleanValue());
    }

    public final SettingsGiftingViewModel.StoreState invoke(StoreEntitlements.State state, List<ModelGift> list, StoreOutboundPromotions.State state2, boolean z2) {
        Intrinsics3.checkNotNullParameter(state, "p1");
        Intrinsics3.checkNotNullParameter(list, "p2");
        Intrinsics3.checkNotNullParameter(state2, "p3");
        return new SettingsGiftingViewModel.StoreState(state, list, state2, z2);
    }
}

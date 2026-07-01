package com.discord.widgets.guild_role_subscriptions;

import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.widgets.guild_role_subscriptions.PriceTierPickerBottomSheetViewModel;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.PriceTierPickerBottomSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* JADX INFO: compiled from: PriceTierPickerBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PriceTierPickerBottomSheetViewModel2 extends Lambda implements Function0<PriceTierPickerBottomSheetViewModel.StoreState> {
    public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PriceTierPickerBottomSheetViewModel2(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        super(0);
        this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final PriceTierPickerBottomSheetViewModel.StoreState invoke() {
        return new PriceTierPickerBottomSheetViewModel.StoreState(this.$storeGuildRoleSubscriptions.getPriceTierStateSnapshot());
    }
}

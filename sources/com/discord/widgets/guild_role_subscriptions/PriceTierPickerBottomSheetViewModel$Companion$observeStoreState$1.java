package com.discord.widgets.guild_role_subscriptions;

import com.discord.stores.StoreGuildRoleSubscriptions;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: PriceTierPickerBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PriceTierPickerBottomSheetViewModel$Companion$observeStoreState$1 extends o implements Function0<PriceTierPickerBottomSheetViewModel$StoreState> {
    public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PriceTierPickerBottomSheetViewModel$Companion$observeStoreState$1(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        super(0);
        this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ PriceTierPickerBottomSheetViewModel$StoreState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final PriceTierPickerBottomSheetViewModel$StoreState invoke() {
        return new PriceTierPickerBottomSheetViewModel$StoreState(this.$storeGuildRoleSubscriptions.getPriceTierStateSnapshot());
    }
}

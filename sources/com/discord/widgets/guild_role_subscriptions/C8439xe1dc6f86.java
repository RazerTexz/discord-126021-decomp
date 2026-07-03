package com.discord.widgets.guild_role_subscriptions;

import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.widgets.guild_role_subscriptions.PriceTierPickerBottomSheetViewModel;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.PriceTierPickerBottomSheetViewModel$Companion$observeStoreState$1 */
/* JADX INFO: compiled from: PriceTierPickerBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8439xe1dc6f86 extends AbstractC12240o implements Function0<PriceTierPickerBottomSheetViewModel.StoreState> {
    public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8439xe1dc6f86(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        super(0);
        this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final PriceTierPickerBottomSheetViewModel.StoreState invoke() {
        return new PriceTierPickerBottomSheetViewModel.StoreState(this.$storeGuildRoleSubscriptions.getPriceTierStateSnapshot());
    }
}

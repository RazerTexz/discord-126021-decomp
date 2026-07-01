package com.discord.widgets.guild_role_subscriptions;

import b.d.b.a.a;
import com.discord.stores.StoreGuildRoleSubscriptions$PriceTierState;
import d0.z.d.m;

/* JADX INFO: compiled from: PriceTierPickerBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class PriceTierPickerBottomSheetViewModel$StoreState {
    private final StoreGuildRoleSubscriptions$PriceTierState priceTierState;

    public PriceTierPickerBottomSheetViewModel$StoreState(StoreGuildRoleSubscriptions$PriceTierState storeGuildRoleSubscriptions$PriceTierState) {
        m.checkNotNullParameter(storeGuildRoleSubscriptions$PriceTierState, "priceTierState");
        this.priceTierState = storeGuildRoleSubscriptions$PriceTierState;
    }

    public static /* synthetic */ PriceTierPickerBottomSheetViewModel$StoreState copy$default(PriceTierPickerBottomSheetViewModel$StoreState priceTierPickerBottomSheetViewModel$StoreState, StoreGuildRoleSubscriptions$PriceTierState storeGuildRoleSubscriptions$PriceTierState, int i, Object obj) {
        if ((i & 1) != 0) {
            storeGuildRoleSubscriptions$PriceTierState = priceTierPickerBottomSheetViewModel$StoreState.priceTierState;
        }
        return priceTierPickerBottomSheetViewModel$StoreState.copy(storeGuildRoleSubscriptions$PriceTierState);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreGuildRoleSubscriptions$PriceTierState getPriceTierState() {
        return this.priceTierState;
    }

    public final PriceTierPickerBottomSheetViewModel$StoreState copy(StoreGuildRoleSubscriptions$PriceTierState priceTierState) {
        m.checkNotNullParameter(priceTierState, "priceTierState");
        return new PriceTierPickerBottomSheetViewModel$StoreState(priceTierState);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof PriceTierPickerBottomSheetViewModel$StoreState) && m.areEqual(this.priceTierState, ((PriceTierPickerBottomSheetViewModel$StoreState) other).priceTierState);
        }
        return true;
    }

    public final StoreGuildRoleSubscriptions$PriceTierState getPriceTierState() {
        return this.priceTierState;
    }

    public int hashCode() {
        StoreGuildRoleSubscriptions$PriceTierState storeGuildRoleSubscriptions$PriceTierState = this.priceTierState;
        if (storeGuildRoleSubscriptions$PriceTierState != null) {
            return storeGuildRoleSubscriptions$PriceTierState.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(priceTierState=");
        sbU.append(this.priceTierState);
        sbU.append(")");
        return sbU.toString();
    }
}

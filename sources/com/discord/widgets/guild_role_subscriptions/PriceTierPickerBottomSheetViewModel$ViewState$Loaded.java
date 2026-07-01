package com.discord.widgets.guild_role_subscriptions;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: PriceTierPickerBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class PriceTierPickerBottomSheetViewModel$ViewState$Loaded extends PriceTierPickerBottomSheetViewModel$ViewState {
    private final List<Integer> priceTiers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PriceTierPickerBottomSheetViewModel$ViewState$Loaded(List<Integer> list) {
        super(null);
        m.checkNotNullParameter(list, "priceTiers");
        this.priceTiers = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PriceTierPickerBottomSheetViewModel$ViewState$Loaded copy$default(PriceTierPickerBottomSheetViewModel$ViewState$Loaded priceTierPickerBottomSheetViewModel$ViewState$Loaded, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = priceTierPickerBottomSheetViewModel$ViewState$Loaded.priceTiers;
        }
        return priceTierPickerBottomSheetViewModel$ViewState$Loaded.copy(list);
    }

    public final List<Integer> component1() {
        return this.priceTiers;
    }

    public final PriceTierPickerBottomSheetViewModel$ViewState$Loaded copy(List<Integer> priceTiers) {
        m.checkNotNullParameter(priceTiers, "priceTiers");
        return new PriceTierPickerBottomSheetViewModel$ViewState$Loaded(priceTiers);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof PriceTierPickerBottomSheetViewModel$ViewState$Loaded) && m.areEqual(this.priceTiers, ((PriceTierPickerBottomSheetViewModel$ViewState$Loaded) other).priceTiers);
        }
        return true;
    }

    public final List<Integer> getPriceTiers() {
        return this.priceTiers;
    }

    public int hashCode() {
        List<Integer> list = this.priceTiers;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.L(a.U("Loaded(priceTiers="), this.priceTiers, ")");
    }
}

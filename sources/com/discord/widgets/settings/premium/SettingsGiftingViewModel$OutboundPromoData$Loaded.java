package com.discord.widgets.settings.premium;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsGiftingViewModel$OutboundPromoData$Loaded extends SettingsGiftingViewModel$OutboundPromoData {
    private final List<SettingsGiftingViewModel$OutboundPromoItem> outboundPromos;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsGiftingViewModel$OutboundPromoData$Loaded(List<SettingsGiftingViewModel$OutboundPromoItem> list) {
        super(null);
        m.checkNotNullParameter(list, "outboundPromos");
        this.outboundPromos = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SettingsGiftingViewModel$OutboundPromoData$Loaded copy$default(SettingsGiftingViewModel$OutboundPromoData$Loaded settingsGiftingViewModel$OutboundPromoData$Loaded, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = settingsGiftingViewModel$OutboundPromoData$Loaded.outboundPromos;
        }
        return settingsGiftingViewModel$OutboundPromoData$Loaded.copy(list);
    }

    public final List<SettingsGiftingViewModel$OutboundPromoItem> component1() {
        return this.outboundPromos;
    }

    public final SettingsGiftingViewModel$OutboundPromoData$Loaded copy(List<SettingsGiftingViewModel$OutboundPromoItem> outboundPromos) {
        m.checkNotNullParameter(outboundPromos, "outboundPromos");
        return new SettingsGiftingViewModel$OutboundPromoData$Loaded(outboundPromos);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof SettingsGiftingViewModel$OutboundPromoData$Loaded) && m.areEqual(this.outboundPromos, ((SettingsGiftingViewModel$OutboundPromoData$Loaded) other).outboundPromos);
        }
        return true;
    }

    public final List<SettingsGiftingViewModel$OutboundPromoItem> getOutboundPromos() {
        return this.outboundPromos;
    }

    public int hashCode() {
        List<SettingsGiftingViewModel$OutboundPromoItem> list = this.outboundPromos;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.L(a.U("Loaded(outboundPromos="), this.outboundPromos, ")");
    }
}

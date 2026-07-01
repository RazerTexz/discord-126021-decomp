package com.discord.widgets.settings.billing;


/* JADX INFO: compiled from: PaymentSourceAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PaymentSourceAdapter$PaymentSourceAddItem implements PaymentSourceAdapter$Item {
    private final int type = 1;
    private final String key = "AddPaymentSource";

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }
}

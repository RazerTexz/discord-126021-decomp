package com.discord.utilities.gifting;

import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: GiftingUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum GiftingUtils$SkuTypes {
    DURABLE_PRIMARY(1),
    DURABLE(2),
    CONSUMABLE(3),
    BUNDLE(4),
    SUBSCRIPTION(5);

    private final int id;

    GiftingUtils$SkuTypes(int i) {
        this.id = i;
    }

    public final int getId() {
        return this.id;
    }
}

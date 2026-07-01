package com.discord.restapi;


/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$GenerateGiftCode {
    private final long skuId;
    private final Long subscriptionPlanId;

    public RestAPIParams$GenerateGiftCode(long j, Long l) {
        this.skuId = j;
        this.subscriptionPlanId = l;
    }

    public final long getSkuId() {
        return this.skuId;
    }

    public final Long getSubscriptionPlanId() {
        return this.subscriptionPlanId;
    }
}

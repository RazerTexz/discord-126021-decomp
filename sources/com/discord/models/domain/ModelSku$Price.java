package com.discord.models.domain;

import b.d.b.a.a;
import com.discord.api.premium.PremiumTier;
import d0.z.d.m;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModelSku.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelSku$Price {
    private final int amount;
    private final String currency;
    private final Map<PremiumTier, ModelSku$ModelPremiumSkuPrice> premium;

    public ModelSku$Price(int i, String str, Map<PremiumTier, ModelSku$ModelPremiumSkuPrice> map) {
        m.checkNotNullParameter(str, "currency");
        this.amount = i;
        this.currency = str;
        this.premium = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelSku$Price copy$default(ModelSku$Price modelSku$Price, int i, String str, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = modelSku$Price.amount;
        }
        if ((i2 & 2) != 0) {
            str = modelSku$Price.currency;
        }
        if ((i2 & 4) != 0) {
            map = modelSku$Price.premium;
        }
        return modelSku$Price.copy(i, str, map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getAmount() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    public final Map<PremiumTier, ModelSku$ModelPremiumSkuPrice> component3() {
        return this.premium;
    }

    public final ModelSku$Price copy(int amount, String currency, Map<PremiumTier, ModelSku$ModelPremiumSkuPrice> premium) {
        m.checkNotNullParameter(currency, "currency");
        return new ModelSku$Price(amount, currency, premium);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelSku$Price)) {
            return false;
        }
        ModelSku$Price modelSku$Price = (ModelSku$Price) other;
        return this.amount == modelSku$Price.amount && m.areEqual(this.currency, modelSku$Price.currency) && m.areEqual(this.premium, modelSku$Price.premium);
    }

    public final int getAmount() {
        return this.amount;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final Map<PremiumTier, ModelSku$ModelPremiumSkuPrice> getPremium() {
        return this.premium;
    }

    public int hashCode() {
        int i = this.amount * 31;
        String str = this.currency;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        Map<PremiumTier, ModelSku$ModelPremiumSkuPrice> map = this.premium;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Price(amount=");
        sbU.append(this.amount);
        sbU.append(", currency=");
        sbU.append(this.currency);
        sbU.append(", premium=");
        return a.M(sbU, this.premium, ")");
    }

    public /* synthetic */ ModelSku$Price(int i, String str, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? null : map);
    }
}

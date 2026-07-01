package com.discord.stores;

import b.d.b.a.a;
import com.android.billingclient.api.SkuDetails;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: StoreGooglePlaySkuDetails.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreGooglePlaySkuDetails$State$Loaded extends StoreGooglePlaySkuDetails$State {
    private final Map<String, SkuDetails> skuDetails;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StoreGooglePlaySkuDetails$State$Loaded(Map<String, ? extends SkuDetails> map) {
        super(null);
        m.checkNotNullParameter(map, "skuDetails");
        this.skuDetails = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreGooglePlaySkuDetails$State$Loaded copy$default(StoreGooglePlaySkuDetails$State$Loaded storeGooglePlaySkuDetails$State$Loaded, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = storeGooglePlaySkuDetails$State$Loaded.skuDetails;
        }
        return storeGooglePlaySkuDetails$State$Loaded.copy(map);
    }

    public final Map<String, SkuDetails> component1() {
        return this.skuDetails;
    }

    public final StoreGooglePlaySkuDetails$State$Loaded copy(Map<String, ? extends SkuDetails> skuDetails) {
        m.checkNotNullParameter(skuDetails, "skuDetails");
        return new StoreGooglePlaySkuDetails$State$Loaded(skuDetails);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreGooglePlaySkuDetails$State$Loaded) && m.areEqual(this.skuDetails, ((StoreGooglePlaySkuDetails$State$Loaded) other).skuDetails);
        }
        return true;
    }

    public final Map<String, SkuDetails> getSkuDetails() {
        return this.skuDetails;
    }

    public int hashCode() {
        Map<String, SkuDetails> map = this.skuDetails;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.M(a.U("Loaded(skuDetails="), this.skuDetails, ")");
    }
}

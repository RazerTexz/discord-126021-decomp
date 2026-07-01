package com.discord.utilities.analytics;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: Traits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class Traits$StoreSku {
    private final long applicationId;
    private final long skuId;
    private final int skuType;
    private final String storeTitle;

    public Traits$StoreSku(long j, int i, long j2, String str) {
        m.checkNotNullParameter(str, "storeTitle");
        this.skuId = j;
        this.skuType = i;
        this.applicationId = j2;
        this.storeTitle = str;
    }

    public static /* synthetic */ Traits$StoreSku copy$default(Traits$StoreSku traits$StoreSku, long j, int i, long j2, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = traits$StoreSku.skuId;
        }
        long j3 = j;
        if ((i2 & 2) != 0) {
            i = traits$StoreSku.skuType;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            j2 = traits$StoreSku.applicationId;
        }
        long j4 = j2;
        if ((i2 & 8) != 0) {
            str = traits$StoreSku.storeTitle;
        }
        return traits$StoreSku.copy(j3, i3, j4, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getSkuId() {
        return this.skuId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getSkuType() {
        return this.skuType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getApplicationId() {
        return this.applicationId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getStoreTitle() {
        return this.storeTitle;
    }

    public final Traits$StoreSku copy(long skuId, int skuType, long applicationId, String storeTitle) {
        m.checkNotNullParameter(storeTitle, "storeTitle");
        return new Traits$StoreSku(skuId, skuType, applicationId, storeTitle);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Traits$StoreSku)) {
            return false;
        }
        Traits$StoreSku traits$StoreSku = (Traits$StoreSku) other;
        return this.skuId == traits$StoreSku.skuId && this.skuType == traits$StoreSku.skuType && this.applicationId == traits$StoreSku.applicationId && m.areEqual(this.storeTitle, traits$StoreSku.storeTitle);
    }

    public final long getApplicationId() {
        return this.applicationId;
    }

    public final long getSkuId() {
        return this.skuId;
    }

    public final int getSkuType() {
        return this.skuType;
    }

    public final String getStoreTitle() {
        return this.storeTitle;
    }

    public int hashCode() {
        int iA = (b.a(this.applicationId) + (((b.a(this.skuId) * 31) + this.skuType) * 31)) * 31;
        String str = this.storeTitle;
        return iA + (str != null ? str.hashCode() : 0);
    }

    public final void serializeTo(Map<String, Object> properties) {
        m.checkNotNullParameter(properties, "properties");
        properties.put("sku_id", Long.valueOf(this.skuId));
        properties.put("sku_type", Integer.valueOf(this.skuType));
        properties.put(ModelAuditLogEntry.CHANGE_KEY_APPLICATION_ID, Long.valueOf(this.applicationId));
        properties.put("store_title", this.storeTitle);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreSku(skuId=");
        sbU.append(this.skuId);
        sbU.append(", skuType=");
        sbU.append(this.skuType);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", storeTitle=");
        return a.J(sbU, this.storeTitle, ")");
    }
}

package com.discord.models.domain;

import b.d.b.a.a;
import com.discord.api.application.Application;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: ModelSku.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelSku {
    private final Application application;
    private final long applicationId;
    private final Map<Integer, ModelSku$ExternalSkuStrategy> externalSkuStrategies;
    private final int flags;
    private final long id;
    private final String name;
    private final boolean premium;
    private final ModelSku$Price price;
    private final int type;

    public ModelSku(long j, String str, long j2, Application application, boolean z2, int i, ModelSku$Price modelSku$Price, int i2, Map<Integer, ModelSku$ExternalSkuStrategy> map) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.applicationId = j;
        this.name = str;
        this.id = j2;
        this.application = application;
        this.premium = z2;
        this.type = i;
        this.price = modelSku$Price;
        this.flags = i2;
        this.externalSkuStrategies = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelSku copy$default(ModelSku modelSku, long j, String str, long j2, Application application, boolean z2, int i, ModelSku$Price modelSku$Price, int i2, Map map, int i3, Object obj) {
        return modelSku.copy((i3 & 1) != 0 ? modelSku.applicationId : j, (i3 & 2) != 0 ? modelSku.name : str, (i3 & 4) != 0 ? modelSku.id : j2, (i3 & 8) != 0 ? modelSku.application : application, (i3 & 16) != 0 ? modelSku.premium : z2, (i3 & 32) != 0 ? modelSku.type : i, (i3 & 64) != 0 ? modelSku.price : modelSku$Price, (i3 & 128) != 0 ? modelSku.flags : i2, (i3 & 256) != 0 ? modelSku.externalSkuStrategies : map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getApplicationId() {
        return this.applicationId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getPremium() {
        return this.premium;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final ModelSku$Price getPrice() {
        return this.price;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getFlags() {
        return this.flags;
    }

    public final Map<Integer, ModelSku$ExternalSkuStrategy> component9() {
        return this.externalSkuStrategies;
    }

    public final ModelSku copy(long applicationId, String name, long id2, Application application, boolean premium, int type, ModelSku$Price price, int flags, Map<Integer, ModelSku$ExternalSkuStrategy> externalSkuStrategies) {
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new ModelSku(applicationId, name, id2, application, premium, type, price, flags, externalSkuStrategies);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelSku)) {
            return false;
        }
        ModelSku modelSku = (ModelSku) other;
        return this.applicationId == modelSku.applicationId && m.areEqual(this.name, modelSku.name) && this.id == modelSku.id && m.areEqual(this.application, modelSku.application) && this.premium == modelSku.premium && this.type == modelSku.type && m.areEqual(this.price, modelSku.price) && this.flags == modelSku.flags && m.areEqual(this.externalSkuStrategies, modelSku.externalSkuStrategies);
    }

    public final Application getApplication() {
        return this.application;
    }

    public final long getApplicationId() {
        return this.applicationId;
    }

    public final Map<Integer, ModelSku$ExternalSkuStrategy> getExternalSkuStrategies() {
        return this.externalSkuStrategies;
    }

    public final int getFlags() {
        return this.flags;
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getPremium() {
        return this.premium;
    }

    public final ModelSku$Price getPrice() {
        return this.price;
    }

    public final ModelSku$SkuCategory getSkuCategory() {
        long j = this.id;
        if (j == ModelSkuKt.PREMIUM_TIER_1_SKU_ID) {
            return ModelSku$SkuCategory.NITRO_CLASSIC;
        }
        return j == ModelSkuKt.PREMIUM_TIER_2_SKU_ID ? ModelSku$SkuCategory.NITRO : ModelSku$SkuCategory.GAME;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    public int hashCode() {
        long j = this.applicationId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int iHashCode = str != null ? str.hashCode() : 0;
        long j2 = this.id;
        int i2 = (((i + iHashCode) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        Application application = this.application;
        int iHashCode2 = (i2 + (application != null ? application.hashCode() : 0)) * 31;
        boolean z2 = this.premium;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i3 = (((iHashCode2 + r0) * 31) + this.type) * 31;
        ModelSku$Price modelSku$Price = this.price;
        int iHashCode3 = (((i3 + (modelSku$Price != null ? modelSku$Price.hashCode() : 0)) * 31) + this.flags) * 31;
        Map<Integer, ModelSku$ExternalSkuStrategy> map = this.externalSkuStrategies;
        return iHashCode3 + (map != null ? map.hashCode() : 0);
    }

    public final boolean isAvailable() {
        return (this.flags & 4) > 0;
    }

    public final boolean isStickerPack() {
        return (this.flags & 16) > 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelSku(applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", application=");
        sbU.append(this.application);
        sbU.append(", premium=");
        sbU.append(this.premium);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", price=");
        sbU.append(this.price);
        sbU.append(", flags=");
        sbU.append(this.flags);
        sbU.append(", externalSkuStrategies=");
        return a.M(sbU, this.externalSkuStrategies, ")");
    }
}

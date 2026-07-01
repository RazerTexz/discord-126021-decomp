package com.discord.models.sticker.dto;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelSku;
import com.discord.models.store.dto.ModelStoreAsset;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ModelStickerPackStoreListing.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelStickerPackStoreListing {
    private final String description;
    private final long id;
    private final ModelSku sku;
    private final ModelStoreAsset thumbnail;
    private final String unpublishedAt;

    public ModelStickerPackStoreListing(ModelSku modelSku, long j, String str, String str2, ModelStoreAsset modelStoreAsset) {
        Intrinsics3.checkNotNullParameter(modelSku, "sku");
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        this.sku = modelSku;
        this.id = j;
        this.description = str;
        this.unpublishedAt = str2;
        this.thumbnail = modelStoreAsset;
    }

    public static /* synthetic */ ModelStickerPackStoreListing copy$default(ModelStickerPackStoreListing modelStickerPackStoreListing, ModelSku modelSku, long j, String str, String str2, ModelStoreAsset modelStoreAsset, int i, Object obj) {
        if ((i & 1) != 0) {
            modelSku = modelStickerPackStoreListing.sku;
        }
        if ((i & 2) != 0) {
            j = modelStickerPackStoreListing.id;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            str = modelStickerPackStoreListing.description;
        }
        String str3 = str;
        if ((i & 8) != 0) {
            str2 = modelStickerPackStoreListing.unpublishedAt;
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            modelStoreAsset = modelStickerPackStoreListing.thumbnail;
        }
        return modelStickerPackStoreListing.copy(modelSku, j2, str3, str4, modelStoreAsset);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelSku getSku() {
        return this.sku;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUnpublishedAt() {
        return this.unpublishedAt;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final ModelStoreAsset getThumbnail() {
        return this.thumbnail;
    }

    public final ModelStickerPackStoreListing copy(ModelSku sku, long id2, String description, String unpublishedAt, ModelStoreAsset thumbnail) {
        Intrinsics3.checkNotNullParameter(sku, "sku");
        Intrinsics3.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        return new ModelStickerPackStoreListing(sku, id2, description, unpublishedAt, thumbnail);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelStickerPackStoreListing)) {
            return false;
        }
        ModelStickerPackStoreListing modelStickerPackStoreListing = (ModelStickerPackStoreListing) other;
        return Intrinsics3.areEqual(this.sku, modelStickerPackStoreListing.sku) && this.id == modelStickerPackStoreListing.id && Intrinsics3.areEqual(this.description, modelStickerPackStoreListing.description) && Intrinsics3.areEqual(this.unpublishedAt, modelStickerPackStoreListing.unpublishedAt) && Intrinsics3.areEqual(this.thumbnail, modelStickerPackStoreListing.thumbnail);
    }

    public final String getDescription() {
        return this.description;
    }

    public final long getId() {
        return this.id;
    }

    public final ModelSku getSku() {
        return this.sku;
    }

    public final ModelStoreAsset getThumbnail() {
        return this.thumbnail;
    }

    public final String getUnpublishedAt() {
        return this.unpublishedAt;
    }

    public final long getUnpublishedAtDate() {
        return TimeUtils.parseUTCDate(this.unpublishedAt);
    }

    public int hashCode() {
        ModelSku modelSku = this.sku;
        int iHashCode = modelSku != null ? modelSku.hashCode() : 0;
        long j = this.id;
        int i = ((iHashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        String str = this.description;
        int iHashCode2 = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.unpublishedAt;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ModelStoreAsset modelStoreAsset = this.thumbnail;
        return iHashCode3 + (modelStoreAsset != null ? modelStoreAsset.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelStickerPackStoreListing(sku=");
        sbU.append(this.sku);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", unpublishedAt=");
        sbU.append(this.unpublishedAt);
        sbU.append(", thumbnail=");
        sbU.append(this.thumbnail);
        sbU.append(")");
        return sbU.toString();
    }
}

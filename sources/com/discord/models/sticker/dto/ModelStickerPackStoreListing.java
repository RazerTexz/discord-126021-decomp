package com.discord.models.sticker.dto;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelSku;
import com.discord.models.store.dto.ModelStoreAsset;
import com.discord.utilities.time.TimeUtils;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ModelStickerPackStoreListing.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelStickerPackStoreListing {
    private final String description;
    private final long id;
    private final ModelSku sku;
    private final ModelStoreAsset thumbnail;
    private final String unpublishedAt;

    public ModelStickerPackStoreListing(ModelSku modelSku, long j, String str, String str2, ModelStoreAsset modelStoreAsset) {
        C12238m.checkNotNullParameter(modelSku, "sku");
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
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
        C12238m.checkNotNullParameter(sku, "sku");
        C12238m.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
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
        return C12238m.areEqual(this.sku, modelStickerPackStoreListing.sku) && this.id == modelStickerPackStoreListing.id && C12238m.areEqual(this.description, modelStickerPackStoreListing.description) && C12238m.areEqual(this.unpublishedAt, modelStickerPackStoreListing.unpublishedAt) && C12238m.areEqual(this.thumbnail, modelStickerPackStoreListing.thumbnail);
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
        StringBuilder sbM833U = C1643a.m833U("ModelStickerPackStoreListing(sku=");
        sbM833U.append(this.sku);
        sbM833U.append(", id=");
        sbM833U.append(this.id);
        sbM833U.append(", description=");
        sbM833U.append(this.description);
        sbM833U.append(", unpublishedAt=");
        sbM833U.append(this.unpublishedAt);
        sbM833U.append(", thumbnail=");
        sbM833U.append(this.thumbnail);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}

package com.discord.models.sticker.dto;

import b.d.b.a.a;
import com.discord.api.sticker.Sticker;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelSku;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ModelStickerPack.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelStickerPack {
    private final Long bannerAssetId;
    private final Long coverStickerId;
    private final String description;
    private final long id;
    private final String name;
    private final long skuId;
    private final List<Sticker> stickers;
    private final ModelStickerPackStoreListing storeListing;

    public ModelStickerPack(long j, List<Sticker> list, String str, ModelStickerPackStoreListing modelStickerPackStoreListing, long j2, Long l, String str2, Long l2) {
        m.checkNotNullParameter(list, "stickers");
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.id = j;
        this.stickers = list;
        this.name = str;
        this.storeListing = modelStickerPackStoreListing;
        this.skuId = j2;
        this.coverStickerId = l;
        this.description = str2;
        this.bannerAssetId = l2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelStickerPack copy$default(ModelStickerPack modelStickerPack, long j, List list, String str, ModelStickerPackStoreListing modelStickerPackStoreListing, long j2, Long l, String str2, Long l2, int i, Object obj) {
        return modelStickerPack.copy((i & 1) != 0 ? modelStickerPack.id : j, (i & 2) != 0 ? modelStickerPack.stickers : list, (i & 4) != 0 ? modelStickerPack.name : str, (i & 8) != 0 ? modelStickerPack.storeListing : modelStickerPackStoreListing, (i & 16) != 0 ? modelStickerPack.skuId : j2, (i & 32) != 0 ? modelStickerPack.coverStickerId : l, (i & 64) != 0 ? modelStickerPack.description : str2, (i & 128) != 0 ? modelStickerPack.bannerAssetId : l2);
    }

    public final boolean canBePurchased() {
        ModelStickerPackStoreListing modelStickerPackStoreListing = this.storeListing;
        return modelStickerPackStoreListing != null && modelStickerPackStoreListing.getSku().isAvailable();
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public final List<Sticker> component2() {
        return this.stickers;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ModelStickerPackStoreListing getStoreListing() {
        return this.storeListing;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getSkuId() {
        return this.skuId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getCoverStickerId() {
        return this.coverStickerId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Long getBannerAssetId() {
        return this.bannerAssetId;
    }

    public final ModelStickerPack copy(long id2, List<Sticker> stickers, String name, ModelStickerPackStoreListing storeListing, long skuId, Long coverStickerId, String description, Long bannerAssetId) {
        m.checkNotNullParameter(stickers, "stickers");
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new ModelStickerPack(id2, stickers, name, storeListing, skuId, coverStickerId, description, bannerAssetId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelStickerPack)) {
            return false;
        }
        ModelStickerPack modelStickerPack = (ModelStickerPack) other;
        return this.id == modelStickerPack.id && m.areEqual(this.stickers, modelStickerPack.stickers) && m.areEqual(this.name, modelStickerPack.name) && m.areEqual(this.storeListing, modelStickerPack.storeListing) && this.skuId == modelStickerPack.skuId && m.areEqual(this.coverStickerId, modelStickerPack.coverStickerId) && m.areEqual(this.description, modelStickerPack.description) && m.areEqual(this.bannerAssetId, modelStickerPack.bannerAssetId);
    }

    public final Long getBannerAssetId() {
        return this.bannerAssetId;
    }

    public final Sticker getCoverSticker() {
        Object next;
        long id2;
        Long l;
        Iterator<T> it = this.stickers.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            id2 = ((Sticker) next).getId();
            l = this.coverStickerId;
        } while (!(l != null && id2 == l.longValue()));
        Sticker sticker = (Sticker) next;
        return sticker != null ? sticker : this.stickers.get(0);
    }

    public final Long getCoverStickerId() {
        return this.coverStickerId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final long getSkuId() {
        return this.skuId;
    }

    public final List<Sticker> getStickers() {
        return this.stickers;
    }

    public final ModelStickerPackStoreListing getStoreListing() {
        return this.storeListing;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        List<Sticker> list = this.stickers;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        ModelStickerPackStoreListing modelStickerPackStoreListing = this.storeListing;
        int iHashCode3 = modelStickerPackStoreListing != null ? modelStickerPackStoreListing.hashCode() : 0;
        long j2 = this.skuId;
        int i2 = (((iHashCode2 + iHashCode3) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        Long l = this.coverStickerId;
        int iHashCode4 = (i2 + (l != null ? l.hashCode() : 0)) * 31;
        String str2 = this.description;
        int iHashCode5 = (iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Long l2 = this.bannerAssetId;
        return iHashCode5 + (l2 != null ? l2.hashCode() : 0);
    }

    public final boolean isAnimatedPack() {
        List<Sticker> list = this.stickers;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((Sticker) it.next()).l()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isLimitedPack() {
        ModelStickerPackStoreListing modelStickerPackStoreListing = this.storeListing;
        return (modelStickerPackStoreListing != null ? modelStickerPackStoreListing.getUnpublishedAt() : null) != null;
    }

    public final boolean isPremiumPack() {
        ModelSku sku;
        ModelStickerPackStoreListing modelStickerPackStoreListing = this.storeListing;
        if (modelStickerPackStoreListing == null || (sku = modelStickerPackStoreListing.getSku()) == null) {
            return false;
        }
        return sku.getPremium();
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelStickerPack(id=");
        sbU.append(this.id);
        sbU.append(", stickers=");
        sbU.append(this.stickers);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", storeListing=");
        sbU.append(this.storeListing);
        sbU.append(", skuId=");
        sbU.append(this.skuId);
        sbU.append(", coverStickerId=");
        sbU.append(this.coverStickerId);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", bannerAssetId=");
        return a.G(sbU, this.bannerAssetId, ")");
    }
}

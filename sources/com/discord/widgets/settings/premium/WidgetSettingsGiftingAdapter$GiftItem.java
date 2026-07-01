package com.discord.widgets.settings.premium;

import b.d.b.a.a;
import com.discord.models.domain.ModelEntitlement;
import com.discord.models.domain.ModelGift;
import com.discord.models.domain.ModelSku;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetSettingsGiftingAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetSettingsGiftingAdapter$GiftItem implements MGRecyclerDataPayload {
    public static final WidgetSettingsGiftingAdapter$GiftItem$Companion Companion = new WidgetSettingsGiftingAdapter$GiftItem$Companion(null);
    public static final int TYPE_GIFT = 2;
    public static final int TYPE_NO_GIFTS = 0;
    public static final int TYPE_SKU = 1;
    private final Integer copies;
    private final ModelEntitlement entitlement;
    private final Boolean expanded;
    private final ModelGift gift;
    private final Boolean isLastItem;
    private final String key;
    private final Long planId;
    private final ModelSku sku;
    private final int type;
    private final int typeInt;
    private final Boolean wasCopied;

    public WidgetSettingsGiftingAdapter$GiftItem(int i, ModelGift modelGift, ModelEntitlement modelEntitlement, Boolean bool, ModelSku modelSku, Integer num, Long l, Boolean bool2, Boolean bool3) {
        this.typeInt = i;
        this.gift = modelGift;
        this.entitlement = modelEntitlement;
        this.expanded = bool;
        this.sku = modelSku;
        this.copies = num;
        this.planId = l;
        this.isLastItem = bool2;
        this.wasCopied = bool3;
        this.type = i;
        int type = getType();
        String strValueOf = "";
        if (type != 0) {
            if (type == 1) {
                strValueOf = String.valueOf(modelSku != null ? Long.valueOf(modelSku.getId()) : null);
            } else if (type == 2) {
                strValueOf = String.valueOf(modelEntitlement != null ? Long.valueOf(modelEntitlement.getId()) : null);
            }
        }
        this.key = strValueOf;
    }

    public static /* synthetic */ WidgetSettingsGiftingAdapter$GiftItem copy$default(WidgetSettingsGiftingAdapter$GiftItem widgetSettingsGiftingAdapter$GiftItem, int i, ModelGift modelGift, ModelEntitlement modelEntitlement, Boolean bool, ModelSku modelSku, Integer num, Long l, Boolean bool2, Boolean bool3, int i2, Object obj) {
        return widgetSettingsGiftingAdapter$GiftItem.copy((i2 & 1) != 0 ? widgetSettingsGiftingAdapter$GiftItem.typeInt : i, (i2 & 2) != 0 ? widgetSettingsGiftingAdapter$GiftItem.gift : modelGift, (i2 & 4) != 0 ? widgetSettingsGiftingAdapter$GiftItem.entitlement : modelEntitlement, (i2 & 8) != 0 ? widgetSettingsGiftingAdapter$GiftItem.expanded : bool, (i2 & 16) != 0 ? widgetSettingsGiftingAdapter$GiftItem.sku : modelSku, (i2 & 32) != 0 ? widgetSettingsGiftingAdapter$GiftItem.copies : num, (i2 & 64) != 0 ? widgetSettingsGiftingAdapter$GiftItem.planId : l, (i2 & 128) != 0 ? widgetSettingsGiftingAdapter$GiftItem.isLastItem : bool2, (i2 & 256) != 0 ? widgetSettingsGiftingAdapter$GiftItem.wasCopied : bool3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTypeInt() {
        return this.typeInt;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ModelGift getGift() {
        return this.gift;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ModelEntitlement getEntitlement() {
        return this.entitlement;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getExpanded() {
        return this.expanded;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final ModelSku getSku() {
        return this.sku;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getCopies() {
        return this.copies;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Long getPlanId() {
        return this.planId;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Boolean getIsLastItem() {
        return this.isLastItem;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Boolean getWasCopied() {
        return this.wasCopied;
    }

    public final WidgetSettingsGiftingAdapter$GiftItem copy(int typeInt, ModelGift gift, ModelEntitlement entitlement, Boolean expanded, ModelSku sku, Integer copies, Long planId, Boolean isLastItem, Boolean wasCopied) {
        return new WidgetSettingsGiftingAdapter$GiftItem(typeInt, gift, entitlement, expanded, sku, copies, planId, isLastItem, wasCopied);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetSettingsGiftingAdapter$GiftItem)) {
            return false;
        }
        WidgetSettingsGiftingAdapter$GiftItem widgetSettingsGiftingAdapter$GiftItem = (WidgetSettingsGiftingAdapter$GiftItem) other;
        return this.typeInt == widgetSettingsGiftingAdapter$GiftItem.typeInt && m.areEqual(this.gift, widgetSettingsGiftingAdapter$GiftItem.gift) && m.areEqual(this.entitlement, widgetSettingsGiftingAdapter$GiftItem.entitlement) && m.areEqual(this.expanded, widgetSettingsGiftingAdapter$GiftItem.expanded) && m.areEqual(this.sku, widgetSettingsGiftingAdapter$GiftItem.sku) && m.areEqual(this.copies, widgetSettingsGiftingAdapter$GiftItem.copies) && m.areEqual(this.planId, widgetSettingsGiftingAdapter$GiftItem.planId) && m.areEqual(this.isLastItem, widgetSettingsGiftingAdapter$GiftItem.isLastItem) && m.areEqual(this.wasCopied, widgetSettingsGiftingAdapter$GiftItem.wasCopied);
    }

    public final Integer getCopies() {
        return this.copies;
    }

    public final ModelEntitlement getEntitlement() {
        return this.entitlement;
    }

    public final Boolean getExpanded() {
        return this.expanded;
    }

    public final ModelGift getGift() {
        return this.gift;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Long getPlanId() {
        return this.planId;
    }

    public final ModelSku getSku() {
        return this.sku;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final int getTypeInt() {
        return this.typeInt;
    }

    public final Boolean getWasCopied() {
        return this.wasCopied;
    }

    public int hashCode() {
        int i = this.typeInt * 31;
        ModelGift modelGift = this.gift;
        int iHashCode = (i + (modelGift != null ? modelGift.hashCode() : 0)) * 31;
        ModelEntitlement modelEntitlement = this.entitlement;
        int iHashCode2 = (iHashCode + (modelEntitlement != null ? modelEntitlement.hashCode() : 0)) * 31;
        Boolean bool = this.expanded;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        ModelSku modelSku = this.sku;
        int iHashCode4 = (iHashCode3 + (modelSku != null ? modelSku.hashCode() : 0)) * 31;
        Integer num = this.copies;
        int iHashCode5 = (iHashCode4 + (num != null ? num.hashCode() : 0)) * 31;
        Long l = this.planId;
        int iHashCode6 = (iHashCode5 + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool2 = this.isLastItem;
        int iHashCode7 = (iHashCode6 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.wasCopied;
        return iHashCode7 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public final Boolean isLastItem() {
        return this.isLastItem;
    }

    public String toString() {
        StringBuilder sbU = a.U("GiftItem(typeInt=");
        sbU.append(this.typeInt);
        sbU.append(", gift=");
        sbU.append(this.gift);
        sbU.append(", entitlement=");
        sbU.append(this.entitlement);
        sbU.append(", expanded=");
        sbU.append(this.expanded);
        sbU.append(", sku=");
        sbU.append(this.sku);
        sbU.append(", copies=");
        sbU.append(this.copies);
        sbU.append(", planId=");
        sbU.append(this.planId);
        sbU.append(", isLastItem=");
        sbU.append(this.isLastItem);
        sbU.append(", wasCopied=");
        return a.D(sbU, this.wasCopied, ")");
    }

    public /* synthetic */ WidgetSettingsGiftingAdapter$GiftItem(int i, ModelGift modelGift, ModelEntitlement modelEntitlement, Boolean bool, ModelSku modelSku, Integer num, Long l, Boolean bool2, Boolean bool3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : modelGift, (i2 & 4) != 0 ? null : modelEntitlement, (i2 & 8) != 0 ? null : bool, (i2 & 16) != 0 ? null : modelSku, (i2 & 32) != 0 ? null : num, (i2 & 64) != 0 ? null : l, (i2 & 128) != 0 ? null : bool2, (i2 & 256) == 0 ? bool3 : null);
    }
}

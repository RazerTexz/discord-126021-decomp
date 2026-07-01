package com.discord.utilities.billing;

import androidx.annotation.DrawableRes;
import d0.z.d.m;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GooglePlaySku.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GooglePlaySku$Companion {
    private GooglePlaySku$Companion() {
    }

    public final GooglePlaySku fromSkuName(String skuName) {
        m.checkNotNullParameter(skuName, "skuName");
        return (GooglePlaySku) GooglePlaySku.access$getSkusBySkuName$cp().get(skuName);
    }

    public final List<String> getALL_SKU_NAMES() {
        return GooglePlaySku.access$getALL_SKU_NAMES$cp();
    }

    @DrawableRes
    public final int getBorderResource(GooglePlaySku$Type skuType) {
        m.checkNotNullParameter(skuType, "skuType");
        int iOrdinal = skuType.ordinal();
        if (iOrdinal == 0) {
            return 2131231118;
        }
        if (iOrdinal == 1) {
            return 2131231116;
        }
        if (iOrdinal == 2) {
            return 2131231125;
        }
        if (iOrdinal == 3) {
            return 2131231124;
        }
        if (iOrdinal == 4) {
            return 2131231122;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final GooglePlaySku getDowngrade(String skuName) {
        m.checkNotNullParameter(skuName, "skuName");
        GooglePlaySku[] googlePlaySkuArrValues = GooglePlaySku.values();
        int i = 0;
        while (true) {
            if (i >= 19) {
                return null;
            }
            GooglePlaySku googlePlaySku = googlePlaySkuArrValues[i];
            GooglePlaySku upgrade = googlePlaySku.getUpgrade();
            if (m.areEqual(upgrade != null ? upgrade.getSkuName() : null, skuName)) {
                return googlePlaySku;
            }
            i++;
        }
    }

    public /* synthetic */ GooglePlaySku$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

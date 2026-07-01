package com.discord.api.activity;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ActivityAssets.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ActivityAssets {
    private final String largeImage;
    private final String largeText;
    private final String smallImage;
    private final String smallText;

    public ActivityAssets(String str, String str2, String str3, String str4) {
        this.largeImage = str;
        this.largeText = str2;
        this.smallImage = str3;
        this.smallText = str4;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getLargeImage() {
        return this.largeImage;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getLargeText() {
        return this.largeText;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getSmallImage() {
        return this.smallImage;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getSmallText() {
        return this.smallText;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityAssets)) {
            return false;
        }
        ActivityAssets activityAssets = (ActivityAssets) other;
        return Intrinsics3.areEqual(this.largeImage, activityAssets.largeImage) && Intrinsics3.areEqual(this.largeText, activityAssets.largeText) && Intrinsics3.areEqual(this.smallImage, activityAssets.smallImage) && Intrinsics3.areEqual(this.smallText, activityAssets.smallText);
    }

    public int hashCode() {
        String str = this.largeImage;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.largeText;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.smallImage;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.smallText;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ActivityAssets(largeImage=");
        sbU.append(this.largeImage);
        sbU.append(", largeText=");
        sbU.append(this.largeText);
        sbU.append(", smallImage=");
        sbU.append(this.smallImage);
        sbU.append(", smallText=");
        return outline.J(sbU, this.smallText, ")");
    }
}

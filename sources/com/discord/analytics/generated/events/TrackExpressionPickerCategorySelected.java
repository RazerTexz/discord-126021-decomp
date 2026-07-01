package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackExpressionPickerCategorySelected.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackExpressionPickerCategorySelected implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence tab = null;
    private final Long guildId = null;
    private final Long stickerPackId = null;
    private final transient String analyticsSchemaTypeName = "expression_picker_category_selected";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackExpressionPickerCategorySelected)) {
            return false;
        }
        TrackExpressionPickerCategorySelected trackExpressionPickerCategorySelected = (TrackExpressionPickerCategorySelected) other;
        return Intrinsics3.areEqual(this.tab, trackExpressionPickerCategorySelected.tab) && Intrinsics3.areEqual(this.guildId, trackExpressionPickerCategorySelected.guildId) && Intrinsics3.areEqual(this.stickerPackId, trackExpressionPickerCategorySelected.stickerPackId);
    }

    public int hashCode() {
        CharSequence charSequence = this.tab;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.guildId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.stickerPackId;
        return iHashCode2 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackExpressionPickerCategorySelected(tab=");
        sbU.append(this.tab);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", stickerPackId=");
        return outline.G(sbU, this.stickerPackId, ")");
    }
}

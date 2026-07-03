package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackExpressionPickerCategoryCollapseToggled.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackExpressionPickerCategoryCollapseToggled implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence tab = null;
    private final Boolean collapsed = null;
    private final Long guildId = null;
    private final Long stickerPackId = null;
    private final transient String analyticsSchemaTypeName = "expression_picker_category_collapse_toggled";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackExpressionPickerCategoryCollapseToggled)) {
            return false;
        }
        TrackExpressionPickerCategoryCollapseToggled trackExpressionPickerCategoryCollapseToggled = (TrackExpressionPickerCategoryCollapseToggled) other;
        return C12238m.areEqual(this.tab, trackExpressionPickerCategoryCollapseToggled.tab) && C12238m.areEqual(this.collapsed, trackExpressionPickerCategoryCollapseToggled.collapsed) && C12238m.areEqual(this.guildId, trackExpressionPickerCategoryCollapseToggled.guildId) && C12238m.areEqual(this.stickerPackId, trackExpressionPickerCategoryCollapseToggled.stickerPackId);
    }

    public int hashCode() {
        CharSequence charSequence = this.tab;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.collapsed;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l = this.guildId;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.stickerPackId;
        return iHashCode3 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackExpressionPickerCategoryCollapseToggled(tab=");
        sbM833U.append(this.tab);
        sbM833U.append(", collapsed=");
        sbM833U.append(this.collapsed);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", stickerPackId=");
        return C1643a.m819G(sbM833U, this.stickerPackId, ")");
    }
}

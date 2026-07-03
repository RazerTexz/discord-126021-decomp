package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackGuildTemplateSelected.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildTemplateSelected implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence templateName = null;
    private final CharSequence templateCode = null;
    private final transient String analyticsSchemaTypeName = "guild_template_selected";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildTemplateSelected)) {
            return false;
        }
        TrackGuildTemplateSelected trackGuildTemplateSelected = (TrackGuildTemplateSelected) other;
        return C12238m.areEqual(this.templateName, trackGuildTemplateSelected.templateName) && C12238m.areEqual(this.templateCode, trackGuildTemplateSelected.templateCode);
    }

    public int hashCode() {
        CharSequence charSequence = this.templateName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.templateCode;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackGuildTemplateSelected(templateName=");
        sbM833U.append(this.templateName);
        sbM833U.append(", templateCode=");
        return C1643a.m817E(sbM833U, this.templateCode, ")");
    }
}

package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackGuildTemplate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildTemplate {
    private final CharSequence guildTemplateCode = null;
    private final CharSequence guildTemplateName = null;
    private final CharSequence guildTemplateDescription = null;
    private final Long guildTemplateGuildId = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildTemplate)) {
            return false;
        }
        TrackGuildTemplate trackGuildTemplate = (TrackGuildTemplate) other;
        return Intrinsics3.areEqual(this.guildTemplateCode, trackGuildTemplate.guildTemplateCode) && Intrinsics3.areEqual(this.guildTemplateName, trackGuildTemplate.guildTemplateName) && Intrinsics3.areEqual(this.guildTemplateDescription, trackGuildTemplate.guildTemplateDescription) && Intrinsics3.areEqual(this.guildTemplateGuildId, trackGuildTemplate.guildTemplateGuildId);
    }

    public int hashCode() {
        CharSequence charSequence = this.guildTemplateCode;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.guildTemplateName;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.guildTemplateDescription;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l = this.guildTemplateGuildId;
        return iHashCode3 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGuildTemplate(guildTemplateCode=");
        sbU.append(this.guildTemplateCode);
        sbU.append(", guildTemplateName=");
        sbU.append(this.guildTemplateName);
        sbU.append(", guildTemplateDescription=");
        sbU.append(this.guildTemplateDescription);
        sbU.append(", guildTemplateGuildId=");
        return outline.G(sbU, this.guildTemplateGuildId, ")");
    }
}

package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.guildTemplateCode, trackGuildTemplate.guildTemplateCode) && C12238m.areEqual(this.guildTemplateName, trackGuildTemplate.guildTemplateName) && C12238m.areEqual(this.guildTemplateDescription, trackGuildTemplate.guildTemplateDescription) && C12238m.areEqual(this.guildTemplateGuildId, trackGuildTemplate.guildTemplateGuildId);
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
        StringBuilder sbM833U = C1643a.m833U("TrackGuildTemplate(guildTemplateCode=");
        sbM833U.append(this.guildTemplateCode);
        sbM833U.append(", guildTemplateName=");
        sbM833U.append(this.guildTemplateName);
        sbM833U.append(", guildTemplateDescription=");
        sbM833U.append(this.guildTemplateDescription);
        sbM833U.append(", guildTemplateGuildId=");
        return C1643a.m819G(sbM833U, this.guildTemplateGuildId, ")");
    }
}

package com.discord.api.stageinstance;

import com.discord.api.guild.GuildFeature;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Set;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: RecommendedStageInstanceGuild.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RecommendedStageInstanceGuild {
    private final Set<GuildFeature> features;
    private final String icon;
    private final long id;
    private final String name;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecommendedStageInstanceGuild)) {
            return false;
        }
        RecommendedStageInstanceGuild recommendedStageInstanceGuild = (RecommendedStageInstanceGuild) other;
        return this.id == recommendedStageInstanceGuild.id && C12238m.areEqual(this.name, recommendedStageInstanceGuild.name) && C12238m.areEqual(this.icon, recommendedStageInstanceGuild.icon) && C12238m.areEqual(this.features, recommendedStageInstanceGuild.features);
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.icon;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Set<GuildFeature> set = this.features;
        return iHashCode2 + (set != null ? set.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("RecommendedStageInstanceGuild(id=");
        sbM833U.append(this.id);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", icon=");
        sbM833U.append(this.icon);
        sbM833U.append(", features=");
        return C1643a.m826N(sbM833U, this.features, ")");
    }
}

package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackGuildProgramStatusUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildProgramStatusUpdated implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long programType = null;
    private final CharSequence programName = null;
    private final Long statusType = null;
    private final CharSequence status = null;
    private final Long guildId = null;
    private final CharSequence actionSource = null;
    private final transient String analyticsSchemaTypeName = "guild_program_status_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildProgramStatusUpdated)) {
            return false;
        }
        TrackGuildProgramStatusUpdated trackGuildProgramStatusUpdated = (TrackGuildProgramStatusUpdated) other;
        return C12238m.areEqual(this.programType, trackGuildProgramStatusUpdated.programType) && C12238m.areEqual(this.programName, trackGuildProgramStatusUpdated.programName) && C12238m.areEqual(this.statusType, trackGuildProgramStatusUpdated.statusType) && C12238m.areEqual(this.status, trackGuildProgramStatusUpdated.status) && C12238m.areEqual(this.guildId, trackGuildProgramStatusUpdated.guildId) && C12238m.areEqual(this.actionSource, trackGuildProgramStatusUpdated.actionSource);
    }

    public int hashCode() {
        Long l = this.programType;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.programName;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.statusType;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.status;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.actionSource;
        return iHashCode5 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackGuildProgramStatusUpdated(programType=");
        sbM833U.append(this.programType);
        sbM833U.append(", programName=");
        sbM833U.append(this.programName);
        sbM833U.append(", statusType=");
        sbM833U.append(this.statusType);
        sbM833U.append(", status=");
        sbM833U.append(this.status);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", actionSource=");
        return C1643a.m817E(sbM833U, this.actionSource, ")");
    }
}

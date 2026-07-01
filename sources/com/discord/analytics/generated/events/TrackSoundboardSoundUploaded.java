package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackSoundboardSoundUploaded.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSoundboardSoundUploaded implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final Boolean success = null;
    private final Long reasonCode = null;
    private final CharSequence reasonMessage = null;
    private final CharSequence mimeType = null;
    private final Float durationS = null;
    private final transient String analyticsSchemaTypeName = "soundboard_sound_uploaded";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSoundboardSoundUploaded)) {
            return false;
        }
        TrackSoundboardSoundUploaded trackSoundboardSoundUploaded = (TrackSoundboardSoundUploaded) other;
        return Intrinsics3.areEqual(this.guildId, trackSoundboardSoundUploaded.guildId) && Intrinsics3.areEqual(this.success, trackSoundboardSoundUploaded.success) && Intrinsics3.areEqual(this.reasonCode, trackSoundboardSoundUploaded.reasonCode) && Intrinsics3.areEqual(this.reasonMessage, trackSoundboardSoundUploaded.reasonMessage) && Intrinsics3.areEqual(this.mimeType, trackSoundboardSoundUploaded.mimeType) && Intrinsics3.areEqual(this.durationS, trackSoundboardSoundUploaded.durationS);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Boolean bool = this.success;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l2 = this.reasonCode;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.reasonMessage;
        int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.mimeType;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Float f = this.durationS;
        return iHashCode5 + (f != null ? f.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSoundboardSoundUploaded(guildId=");
        sbU.append(this.guildId);
        sbU.append(", success=");
        sbU.append(this.success);
        sbU.append(", reasonCode=");
        sbU.append(this.reasonCode);
        sbU.append(", reasonMessage=");
        sbU.append(this.reasonMessage);
        sbU.append(", mimeType=");
        sbU.append(this.mimeType);
        sbU.append(", durationS=");
        sbU.append(this.durationS);
        sbU.append(")");
        return sbU.toString();
    }
}

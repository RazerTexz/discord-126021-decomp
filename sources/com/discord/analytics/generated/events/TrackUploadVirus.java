package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackUploadVirus.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUploadVirus implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long channelId = null;
    private final Long messageId = null;
    private final CharSequence fileName = null;
    private final CharSequence fileHash = null;
    private final CharSequence virusName = null;
    private final CharSequence hit = null;
    private final transient String analyticsSchemaTypeName = "upload_virus";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUploadVirus)) {
            return false;
        }
        TrackUploadVirus trackUploadVirus = (TrackUploadVirus) other;
        return C12238m.areEqual(this.channelId, trackUploadVirus.channelId) && C12238m.areEqual(this.messageId, trackUploadVirus.messageId) && C12238m.areEqual(this.fileName, trackUploadVirus.fileName) && C12238m.areEqual(this.fileHash, trackUploadVirus.fileHash) && C12238m.areEqual(this.virusName, trackUploadVirus.virusName) && C12238m.areEqual(this.hit, trackUploadVirus.hit);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.messageId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.fileName;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.fileHash;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.virusName;
        int iHashCode5 = (iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.hit;
        return iHashCode5 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackUploadVirus(channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", fileName=");
        sbM833U.append(this.fileName);
        sbM833U.append(", fileHash=");
        sbM833U.append(this.fileHash);
        sbM833U.append(", virusName=");
        sbM833U.append(this.virusName);
        sbM833U.append(", hit=");
        return C1643a.m817E(sbM833U, this.hit, ")");
    }
}

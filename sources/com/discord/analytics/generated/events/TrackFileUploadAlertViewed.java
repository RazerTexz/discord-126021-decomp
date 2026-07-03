package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackFileUploadAlertViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackFileUploadAlertViewed implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence alertType = null;
    private final Long numAttachments = null;
    private final Long maxAttachmentSize = null;
    private final Long totalAttachmentSize = null;
    private final Boolean hasImage = null;
    private final Boolean hasVideo = null;
    private final Boolean isPremium = null;
    private final Float imageCompressionQuality = null;
    private final Boolean imageCompressionSettingEnabled = null;
    private final Boolean previewEnabled = null;
    private final transient String analyticsSchemaTypeName = "file_upload_alert_viewed";

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: c */
    public void mo7508c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackFileUploadAlertViewed)) {
            return false;
        }
        TrackFileUploadAlertViewed trackFileUploadAlertViewed = (TrackFileUploadAlertViewed) other;
        return C12238m.areEqual(this.alertType, trackFileUploadAlertViewed.alertType) && C12238m.areEqual(this.numAttachments, trackFileUploadAlertViewed.numAttachments) && C12238m.areEqual(this.maxAttachmentSize, trackFileUploadAlertViewed.maxAttachmentSize) && C12238m.areEqual(this.totalAttachmentSize, trackFileUploadAlertViewed.totalAttachmentSize) && C12238m.areEqual(this.hasImage, trackFileUploadAlertViewed.hasImage) && C12238m.areEqual(this.hasVideo, trackFileUploadAlertViewed.hasVideo) && C12238m.areEqual(this.isPremium, trackFileUploadAlertViewed.isPremium) && C12238m.areEqual(this.imageCompressionQuality, trackFileUploadAlertViewed.imageCompressionQuality) && C12238m.areEqual(this.imageCompressionSettingEnabled, trackFileUploadAlertViewed.imageCompressionSettingEnabled) && C12238m.areEqual(this.previewEnabled, trackFileUploadAlertViewed.previewEnabled);
    }

    public int hashCode() {
        CharSequence charSequence = this.alertType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.numAttachments;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.maxAttachmentSize;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.totalAttachmentSize;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool = this.hasImage;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.hasVideo;
        int iHashCode6 = (iHashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.isPremium;
        int iHashCode7 = (iHashCode6 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Float f = this.imageCompressionQuality;
        int iHashCode8 = (iHashCode7 + (f != null ? f.hashCode() : 0)) * 31;
        Boolean bool4 = this.imageCompressionSettingEnabled;
        int iHashCode9 = (iHashCode8 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.previewEnabled;
        return iHashCode9 + (bool5 != null ? bool5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackFileUploadAlertViewed(alertType=");
        sbM833U.append(this.alertType);
        sbM833U.append(", numAttachments=");
        sbM833U.append(this.numAttachments);
        sbM833U.append(", maxAttachmentSize=");
        sbM833U.append(this.maxAttachmentSize);
        sbM833U.append(", totalAttachmentSize=");
        sbM833U.append(this.totalAttachmentSize);
        sbM833U.append(", hasImage=");
        sbM833U.append(this.hasImage);
        sbM833U.append(", hasVideo=");
        sbM833U.append(this.hasVideo);
        sbM833U.append(", isPremium=");
        sbM833U.append(this.isPremium);
        sbM833U.append(", imageCompressionQuality=");
        sbM833U.append(this.imageCompressionQuality);
        sbM833U.append(", imageCompressionSettingEnabled=");
        sbM833U.append(this.imageCompressionSettingEnabled);
        sbM833U.append(", previewEnabled=");
        return C1643a.m816D(sbM833U, this.previewEnabled, ")");
    }
}

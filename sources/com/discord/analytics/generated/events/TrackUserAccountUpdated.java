package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackUserAccountUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUserAccountUpdated implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Boolean isUserSetDiscriminator = null;
    private final Long oldDiscriminator = null;
    private final Long newDiscriminator = null;
    private final CharSequence oldUsername = null;
    private final CharSequence newUsername = null;
    private final CharSequence oldEmail = null;
    private final CharSequence newEmail = null;
    private final Boolean hasBanner = null;
    private final Boolean hasBannerColor = null;
    private final Boolean hasBio = null;
    private final Boolean hasPremium = null;
    private final Boolean hasAvatar = null;
    private final Boolean hasAnimatedAvatar = null;
    private final Boolean updatedBio = null;
    private final Boolean updatedBanner = null;
    private final Boolean updatedBannerColor = null;
    private final Boolean updatedAvatar = null;
    private final Long bioCustomEmojiCount = null;
    private final Boolean hasPronouns = null;
    private final Boolean updatedPronouns = null;
    private final Boolean updatedPassword = null;
    private final transient String analyticsSchemaTypeName = "user_account_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUserAccountUpdated)) {
            return false;
        }
        TrackUserAccountUpdated trackUserAccountUpdated = (TrackUserAccountUpdated) other;
        return m.areEqual(this.isUserSetDiscriminator, trackUserAccountUpdated.isUserSetDiscriminator) && m.areEqual(this.oldDiscriminator, trackUserAccountUpdated.oldDiscriminator) && m.areEqual(this.newDiscriminator, trackUserAccountUpdated.newDiscriminator) && m.areEqual(this.oldUsername, trackUserAccountUpdated.oldUsername) && m.areEqual(this.newUsername, trackUserAccountUpdated.newUsername) && m.areEqual(this.oldEmail, trackUserAccountUpdated.oldEmail) && m.areEqual(this.newEmail, trackUserAccountUpdated.newEmail) && m.areEqual(this.hasBanner, trackUserAccountUpdated.hasBanner) && m.areEqual(this.hasBannerColor, trackUserAccountUpdated.hasBannerColor) && m.areEqual(this.hasBio, trackUserAccountUpdated.hasBio) && m.areEqual(this.hasPremium, trackUserAccountUpdated.hasPremium) && m.areEqual(this.hasAvatar, trackUserAccountUpdated.hasAvatar) && m.areEqual(this.hasAnimatedAvatar, trackUserAccountUpdated.hasAnimatedAvatar) && m.areEqual(this.updatedBio, trackUserAccountUpdated.updatedBio) && m.areEqual(this.updatedBanner, trackUserAccountUpdated.updatedBanner) && m.areEqual(this.updatedBannerColor, trackUserAccountUpdated.updatedBannerColor) && m.areEqual(this.updatedAvatar, trackUserAccountUpdated.updatedAvatar) && m.areEqual(this.bioCustomEmojiCount, trackUserAccountUpdated.bioCustomEmojiCount) && m.areEqual(this.hasPronouns, trackUserAccountUpdated.hasPronouns) && m.areEqual(this.updatedPronouns, trackUserAccountUpdated.updatedPronouns) && m.areEqual(this.updatedPassword, trackUserAccountUpdated.updatedPassword);
    }

    public int hashCode() {
        Boolean bool = this.isUserSetDiscriminator;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Long l = this.oldDiscriminator;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.newDiscriminator;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.oldUsername;
        int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.newUsername;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.oldEmail;
        int iHashCode6 = (iHashCode5 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.newEmail;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Boolean bool2 = this.hasBanner;
        int iHashCode8 = (iHashCode7 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.hasBannerColor;
        int iHashCode9 = (iHashCode8 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.hasBio;
        int iHashCode10 = (iHashCode9 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.hasPremium;
        int iHashCode11 = (iHashCode10 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.hasAvatar;
        int iHashCode12 = (iHashCode11 + (bool6 != null ? bool6.hashCode() : 0)) * 31;
        Boolean bool7 = this.hasAnimatedAvatar;
        int iHashCode13 = (iHashCode12 + (bool7 != null ? bool7.hashCode() : 0)) * 31;
        Boolean bool8 = this.updatedBio;
        int iHashCode14 = (iHashCode13 + (bool8 != null ? bool8.hashCode() : 0)) * 31;
        Boolean bool9 = this.updatedBanner;
        int iHashCode15 = (iHashCode14 + (bool9 != null ? bool9.hashCode() : 0)) * 31;
        Boolean bool10 = this.updatedBannerColor;
        int iHashCode16 = (iHashCode15 + (bool10 != null ? bool10.hashCode() : 0)) * 31;
        Boolean bool11 = this.updatedAvatar;
        int iHashCode17 = (iHashCode16 + (bool11 != null ? bool11.hashCode() : 0)) * 31;
        Long l3 = this.bioCustomEmojiCount;
        int iHashCode18 = (iHashCode17 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool12 = this.hasPronouns;
        int iHashCode19 = (iHashCode18 + (bool12 != null ? bool12.hashCode() : 0)) * 31;
        Boolean bool13 = this.updatedPronouns;
        int iHashCode20 = (iHashCode19 + (bool13 != null ? bool13.hashCode() : 0)) * 31;
        Boolean bool14 = this.updatedPassword;
        return iHashCode20 + (bool14 != null ? bool14.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackUserAccountUpdated(isUserSetDiscriminator=");
        sbU.append(this.isUserSetDiscriminator);
        sbU.append(", oldDiscriminator=");
        sbU.append(this.oldDiscriminator);
        sbU.append(", newDiscriminator=");
        sbU.append(this.newDiscriminator);
        sbU.append(", oldUsername=");
        sbU.append(this.oldUsername);
        sbU.append(", newUsername=");
        sbU.append(this.newUsername);
        sbU.append(", oldEmail=");
        sbU.append(this.oldEmail);
        sbU.append(", newEmail=");
        sbU.append(this.newEmail);
        sbU.append(", hasBanner=");
        sbU.append(this.hasBanner);
        sbU.append(", hasBannerColor=");
        sbU.append(this.hasBannerColor);
        sbU.append(", hasBio=");
        sbU.append(this.hasBio);
        sbU.append(", hasPremium=");
        sbU.append(this.hasPremium);
        sbU.append(", hasAvatar=");
        sbU.append(this.hasAvatar);
        sbU.append(", hasAnimatedAvatar=");
        sbU.append(this.hasAnimatedAvatar);
        sbU.append(", updatedBio=");
        sbU.append(this.updatedBio);
        sbU.append(", updatedBanner=");
        sbU.append(this.updatedBanner);
        sbU.append(", updatedBannerColor=");
        sbU.append(this.updatedBannerColor);
        sbU.append(", updatedAvatar=");
        sbU.append(this.updatedAvatar);
        sbU.append(", bioCustomEmojiCount=");
        sbU.append(this.bioCustomEmojiCount);
        sbU.append(", hasPronouns=");
        sbU.append(this.hasPronouns);
        sbU.append(", updatedPronouns=");
        sbU.append(this.updatedPronouns);
        sbU.append(", updatedPassword=");
        return a.D(sbU, this.updatedPassword, ")");
    }
}

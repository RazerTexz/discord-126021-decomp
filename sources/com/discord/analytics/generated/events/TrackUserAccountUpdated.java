package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.isUserSetDiscriminator, trackUserAccountUpdated.isUserSetDiscriminator) && C12238m.areEqual(this.oldDiscriminator, trackUserAccountUpdated.oldDiscriminator) && C12238m.areEqual(this.newDiscriminator, trackUserAccountUpdated.newDiscriminator) && C12238m.areEqual(this.oldUsername, trackUserAccountUpdated.oldUsername) && C12238m.areEqual(this.newUsername, trackUserAccountUpdated.newUsername) && C12238m.areEqual(this.oldEmail, trackUserAccountUpdated.oldEmail) && C12238m.areEqual(this.newEmail, trackUserAccountUpdated.newEmail) && C12238m.areEqual(this.hasBanner, trackUserAccountUpdated.hasBanner) && C12238m.areEqual(this.hasBannerColor, trackUserAccountUpdated.hasBannerColor) && C12238m.areEqual(this.hasBio, trackUserAccountUpdated.hasBio) && C12238m.areEqual(this.hasPremium, trackUserAccountUpdated.hasPremium) && C12238m.areEqual(this.hasAvatar, trackUserAccountUpdated.hasAvatar) && C12238m.areEqual(this.hasAnimatedAvatar, trackUserAccountUpdated.hasAnimatedAvatar) && C12238m.areEqual(this.updatedBio, trackUserAccountUpdated.updatedBio) && C12238m.areEqual(this.updatedBanner, trackUserAccountUpdated.updatedBanner) && C12238m.areEqual(this.updatedBannerColor, trackUserAccountUpdated.updatedBannerColor) && C12238m.areEqual(this.updatedAvatar, trackUserAccountUpdated.updatedAvatar) && C12238m.areEqual(this.bioCustomEmojiCount, trackUserAccountUpdated.bioCustomEmojiCount) && C12238m.areEqual(this.hasPronouns, trackUserAccountUpdated.hasPronouns) && C12238m.areEqual(this.updatedPronouns, trackUserAccountUpdated.updatedPronouns) && C12238m.areEqual(this.updatedPassword, trackUserAccountUpdated.updatedPassword);
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
        StringBuilder sbM833U = C1643a.m833U("TrackUserAccountUpdated(isUserSetDiscriminator=");
        sbM833U.append(this.isUserSetDiscriminator);
        sbM833U.append(", oldDiscriminator=");
        sbM833U.append(this.oldDiscriminator);
        sbM833U.append(", newDiscriminator=");
        sbM833U.append(this.newDiscriminator);
        sbM833U.append(", oldUsername=");
        sbM833U.append(this.oldUsername);
        sbM833U.append(", newUsername=");
        sbM833U.append(this.newUsername);
        sbM833U.append(", oldEmail=");
        sbM833U.append(this.oldEmail);
        sbM833U.append(", newEmail=");
        sbM833U.append(this.newEmail);
        sbM833U.append(", hasBanner=");
        sbM833U.append(this.hasBanner);
        sbM833U.append(", hasBannerColor=");
        sbM833U.append(this.hasBannerColor);
        sbM833U.append(", hasBio=");
        sbM833U.append(this.hasBio);
        sbM833U.append(", hasPremium=");
        sbM833U.append(this.hasPremium);
        sbM833U.append(", hasAvatar=");
        sbM833U.append(this.hasAvatar);
        sbM833U.append(", hasAnimatedAvatar=");
        sbM833U.append(this.hasAnimatedAvatar);
        sbM833U.append(", updatedBio=");
        sbM833U.append(this.updatedBio);
        sbM833U.append(", updatedBanner=");
        sbM833U.append(this.updatedBanner);
        sbM833U.append(", updatedBannerColor=");
        sbM833U.append(this.updatedBannerColor);
        sbM833U.append(", updatedAvatar=");
        sbM833U.append(this.updatedAvatar);
        sbM833U.append(", bioCustomEmojiCount=");
        sbM833U.append(this.bioCustomEmojiCount);
        sbM833U.append(", hasPronouns=");
        sbM833U.append(this.hasPronouns);
        sbM833U.append(", updatedPronouns=");
        sbM833U.append(this.updatedPronouns);
        sbM833U.append(", updatedPassword=");
        return C1643a.m816D(sbM833U, this.updatedPassword, ")");
    }
}

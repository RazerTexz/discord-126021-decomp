package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackUpdateUserSettings.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUpdateUserSettings implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Boolean convertEmoticons = null;
    private final Boolean developerMode = null;
    private final Boolean enableTtsCommand = null;
    private final Long friendSourceFlags = null;
    private final List<Long> guildPositions = null;
    private final Boolean inlineAttachmentMedia = null;
    private final Boolean inlineEmbedMedia = null;
    private final Boolean gifAutoPlay = null;
    private final CharSequence locale = null;
    private final Boolean messageDisplayCompact = null;
    private final Boolean renderEmbeds = null;
    private final Boolean renderReactions = null;
    private final Boolean animateEmoji = null;
    private final List<Long> restrictedGuilds = null;
    private final Boolean showCurrentGame = null;
    private final CharSequence theme = null;
    private final Boolean detectPlatformAccounts = null;
    private final CharSequence status = null;
    private final Boolean defaultGuildsRestricted = null;
    private final Long explicitContentFilter = null;
    private final Long afkTimeout = null;
    private final Long timezoneOffset = null;
    private final Boolean disableGamesTab = null;
    private final Long numServerFolders = null;
    private final Boolean streamNotificationsEnabled = null;
    private final Boolean hasCustomStatus = null;
    private final Boolean allowAccessibilityDetection = null;
    private final Boolean contactSyncEnabled = null;
    private final Boolean nativePhoneIntegrationEnabled = null;
    private final Long animateStickers = null;
    private final Boolean viewNsfwGuilds = null;
    private final Boolean passwordless = null;
    private final transient String analyticsSchemaTypeName = "update_user_settings";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUpdateUserSettings)) {
            return false;
        }
        TrackUpdateUserSettings trackUpdateUserSettings = (TrackUpdateUserSettings) other;
        return C12238m.areEqual(this.convertEmoticons, trackUpdateUserSettings.convertEmoticons) && C12238m.areEqual(this.developerMode, trackUpdateUserSettings.developerMode) && C12238m.areEqual(this.enableTtsCommand, trackUpdateUserSettings.enableTtsCommand) && C12238m.areEqual(this.friendSourceFlags, trackUpdateUserSettings.friendSourceFlags) && C12238m.areEqual(this.guildPositions, trackUpdateUserSettings.guildPositions) && C12238m.areEqual(this.inlineAttachmentMedia, trackUpdateUserSettings.inlineAttachmentMedia) && C12238m.areEqual(this.inlineEmbedMedia, trackUpdateUserSettings.inlineEmbedMedia) && C12238m.areEqual(this.gifAutoPlay, trackUpdateUserSettings.gifAutoPlay) && C12238m.areEqual(this.locale, trackUpdateUserSettings.locale) && C12238m.areEqual(this.messageDisplayCompact, trackUpdateUserSettings.messageDisplayCompact) && C12238m.areEqual(this.renderEmbeds, trackUpdateUserSettings.renderEmbeds) && C12238m.areEqual(this.renderReactions, trackUpdateUserSettings.renderReactions) && C12238m.areEqual(this.animateEmoji, trackUpdateUserSettings.animateEmoji) && C12238m.areEqual(this.restrictedGuilds, trackUpdateUserSettings.restrictedGuilds) && C12238m.areEqual(this.showCurrentGame, trackUpdateUserSettings.showCurrentGame) && C12238m.areEqual(this.theme, trackUpdateUserSettings.theme) && C12238m.areEqual(this.detectPlatformAccounts, trackUpdateUserSettings.detectPlatformAccounts) && C12238m.areEqual(this.status, trackUpdateUserSettings.status) && C12238m.areEqual(this.defaultGuildsRestricted, trackUpdateUserSettings.defaultGuildsRestricted) && C12238m.areEqual(this.explicitContentFilter, trackUpdateUserSettings.explicitContentFilter) && C12238m.areEqual(this.afkTimeout, trackUpdateUserSettings.afkTimeout) && C12238m.areEqual(this.timezoneOffset, trackUpdateUserSettings.timezoneOffset) && C12238m.areEqual(this.disableGamesTab, trackUpdateUserSettings.disableGamesTab) && C12238m.areEqual(this.numServerFolders, trackUpdateUserSettings.numServerFolders) && C12238m.areEqual(this.streamNotificationsEnabled, trackUpdateUserSettings.streamNotificationsEnabled) && C12238m.areEqual(this.hasCustomStatus, trackUpdateUserSettings.hasCustomStatus) && C12238m.areEqual(this.allowAccessibilityDetection, trackUpdateUserSettings.allowAccessibilityDetection) && C12238m.areEqual(this.contactSyncEnabled, trackUpdateUserSettings.contactSyncEnabled) && C12238m.areEqual(this.nativePhoneIntegrationEnabled, trackUpdateUserSettings.nativePhoneIntegrationEnabled) && C12238m.areEqual(this.animateStickers, trackUpdateUserSettings.animateStickers) && C12238m.areEqual(this.viewNsfwGuilds, trackUpdateUserSettings.viewNsfwGuilds) && C12238m.areEqual(this.passwordless, trackUpdateUserSettings.passwordless);
    }

    public int hashCode() {
        Boolean bool = this.convertEmoticons;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.developerMode;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.enableTtsCommand;
        int iHashCode3 = (iHashCode2 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Long l = this.friendSourceFlags;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        List<Long> list = this.guildPositions;
        int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        Boolean bool4 = this.inlineAttachmentMedia;
        int iHashCode6 = (iHashCode5 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.inlineEmbedMedia;
        int iHashCode7 = (iHashCode6 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.gifAutoPlay;
        int iHashCode8 = (iHashCode7 + (bool6 != null ? bool6.hashCode() : 0)) * 31;
        CharSequence charSequence = this.locale;
        int iHashCode9 = (iHashCode8 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool7 = this.messageDisplayCompact;
        int iHashCode10 = (iHashCode9 + (bool7 != null ? bool7.hashCode() : 0)) * 31;
        Boolean bool8 = this.renderEmbeds;
        int iHashCode11 = (iHashCode10 + (bool8 != null ? bool8.hashCode() : 0)) * 31;
        Boolean bool9 = this.renderReactions;
        int iHashCode12 = (iHashCode11 + (bool9 != null ? bool9.hashCode() : 0)) * 31;
        Boolean bool10 = this.animateEmoji;
        int iHashCode13 = (iHashCode12 + (bool10 != null ? bool10.hashCode() : 0)) * 31;
        List<Long> list2 = this.restrictedGuilds;
        int iHashCode14 = (iHashCode13 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Boolean bool11 = this.showCurrentGame;
        int iHashCode15 = (iHashCode14 + (bool11 != null ? bool11.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.theme;
        int iHashCode16 = (iHashCode15 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Boolean bool12 = this.detectPlatformAccounts;
        int iHashCode17 = (iHashCode16 + (bool12 != null ? bool12.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.status;
        int iHashCode18 = (iHashCode17 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool13 = this.defaultGuildsRestricted;
        int iHashCode19 = (iHashCode18 + (bool13 != null ? bool13.hashCode() : 0)) * 31;
        Long l2 = this.explicitContentFilter;
        int iHashCode20 = (iHashCode19 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.afkTimeout;
        int iHashCode21 = (iHashCode20 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.timezoneOffset;
        int iHashCode22 = (iHashCode21 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Boolean bool14 = this.disableGamesTab;
        int iHashCode23 = (iHashCode22 + (bool14 != null ? bool14.hashCode() : 0)) * 31;
        Long l5 = this.numServerFolders;
        int iHashCode24 = (iHashCode23 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Boolean bool15 = this.streamNotificationsEnabled;
        int iHashCode25 = (iHashCode24 + (bool15 != null ? bool15.hashCode() : 0)) * 31;
        Boolean bool16 = this.hasCustomStatus;
        int iHashCode26 = (iHashCode25 + (bool16 != null ? bool16.hashCode() : 0)) * 31;
        Boolean bool17 = this.allowAccessibilityDetection;
        int iHashCode27 = (iHashCode26 + (bool17 != null ? bool17.hashCode() : 0)) * 31;
        Boolean bool18 = this.contactSyncEnabled;
        int iHashCode28 = (iHashCode27 + (bool18 != null ? bool18.hashCode() : 0)) * 31;
        Boolean bool19 = this.nativePhoneIntegrationEnabled;
        int iHashCode29 = (iHashCode28 + (bool19 != null ? bool19.hashCode() : 0)) * 31;
        Long l6 = this.animateStickers;
        int iHashCode30 = (iHashCode29 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Boolean bool20 = this.viewNsfwGuilds;
        int iHashCode31 = (iHashCode30 + (bool20 != null ? bool20.hashCode() : 0)) * 31;
        Boolean bool21 = this.passwordless;
        return iHashCode31 + (bool21 != null ? bool21.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackUpdateUserSettings(convertEmoticons=");
        sbM833U.append(this.convertEmoticons);
        sbM833U.append(", developerMode=");
        sbM833U.append(this.developerMode);
        sbM833U.append(", enableTtsCommand=");
        sbM833U.append(this.enableTtsCommand);
        sbM833U.append(", friendSourceFlags=");
        sbM833U.append(this.friendSourceFlags);
        sbM833U.append(", guildPositions=");
        sbM833U.append(this.guildPositions);
        sbM833U.append(", inlineAttachmentMedia=");
        sbM833U.append(this.inlineAttachmentMedia);
        sbM833U.append(", inlineEmbedMedia=");
        sbM833U.append(this.inlineEmbedMedia);
        sbM833U.append(", gifAutoPlay=");
        sbM833U.append(this.gifAutoPlay);
        sbM833U.append(", locale=");
        sbM833U.append(this.locale);
        sbM833U.append(", messageDisplayCompact=");
        sbM833U.append(this.messageDisplayCompact);
        sbM833U.append(", renderEmbeds=");
        sbM833U.append(this.renderEmbeds);
        sbM833U.append(", renderReactions=");
        sbM833U.append(this.renderReactions);
        sbM833U.append(", animateEmoji=");
        sbM833U.append(this.animateEmoji);
        sbM833U.append(", restrictedGuilds=");
        sbM833U.append(this.restrictedGuilds);
        sbM833U.append(", showCurrentGame=");
        sbM833U.append(this.showCurrentGame);
        sbM833U.append(", theme=");
        sbM833U.append(this.theme);
        sbM833U.append(", detectPlatformAccounts=");
        sbM833U.append(this.detectPlatformAccounts);
        sbM833U.append(", status=");
        sbM833U.append(this.status);
        sbM833U.append(", defaultGuildsRestricted=");
        sbM833U.append(this.defaultGuildsRestricted);
        sbM833U.append(", explicitContentFilter=");
        sbM833U.append(this.explicitContentFilter);
        sbM833U.append(", afkTimeout=");
        sbM833U.append(this.afkTimeout);
        sbM833U.append(", timezoneOffset=");
        sbM833U.append(this.timezoneOffset);
        sbM833U.append(", disableGamesTab=");
        sbM833U.append(this.disableGamesTab);
        sbM833U.append(", numServerFolders=");
        sbM833U.append(this.numServerFolders);
        sbM833U.append(", streamNotificationsEnabled=");
        sbM833U.append(this.streamNotificationsEnabled);
        sbM833U.append(", hasCustomStatus=");
        sbM833U.append(this.hasCustomStatus);
        sbM833U.append(", allowAccessibilityDetection=");
        sbM833U.append(this.allowAccessibilityDetection);
        sbM833U.append(", contactSyncEnabled=");
        sbM833U.append(this.contactSyncEnabled);
        sbM833U.append(", nativePhoneIntegrationEnabled=");
        sbM833U.append(this.nativePhoneIntegrationEnabled);
        sbM833U.append(", animateStickers=");
        sbM833U.append(this.animateStickers);
        sbM833U.append(", viewNsfwGuilds=");
        sbM833U.append(this.viewNsfwGuilds);
        sbM833U.append(", passwordless=");
        return C1643a.m816D(sbM833U, this.passwordless, ")");
    }
}

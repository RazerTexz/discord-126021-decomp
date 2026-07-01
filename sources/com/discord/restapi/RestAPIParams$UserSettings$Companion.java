package com.discord.restapi;

import com.discord.api.presence.ClientStatus;
import com.discord.models.domain.ModelGuildFolder;
import d0.z.d.m;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$UserSettings$Companion {
    private RestAPIParams$UserSettings$Companion() {
    }

    public final RestAPIParams$UserSettings createWithAllowAccessibilityDetection(Boolean allowAccessibilityDetection) {
        return new RestAPIParams$UserSettings(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, allowAccessibilityDetection, null, null, null, 491519, null);
    }

    public final RestAPIParams$UserSettings createWithAllowAnimatedEmojis(Boolean allowAnimatedEmojis) {
        return new RestAPIParams$UserSettings(null, null, null, null, null, null, null, null, null, null, null, null, null, null, allowAnimatedEmojis, null, null, null, null, 507903, null);
    }

    public final RestAPIParams$UserSettings createWithBlockedMessageBar(boolean blockedMessageBar) {
        return new RestAPIParams$UserSettings(null, null, null, null, null, Boolean.valueOf(blockedMessageBar), null, null, null, null, null, null, null, null, null, null, null, null, null, 524255, null);
    }

    public final RestAPIParams$UserSettings createWithContactSyncUpsellShown() {
        return new RestAPIParams$UserSettings(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Boolean.TRUE, null, 393215, null);
    }

    public final RestAPIParams$UserSettings createWithDeveloperMode(boolean developerMode) {
        return new RestAPIParams$UserSettings(null, Boolean.valueOf(developerMode), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524285, null);
    }

    public final RestAPIParams$UserSettings createWithExplicitContentFilter(int explicitContentFilter) {
        return new RestAPIParams$UserSettings(null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(explicitContentFilter), null, null, null, null, null, 516095, null);
    }

    public final RestAPIParams$UserSettings createWithFriendDiscoveryFlags(Integer friendDiscoveryFlags) {
        return new RestAPIParams$UserSettings(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, friendDiscoveryFlags, 262143, null);
    }

    public final RestAPIParams$UserSettings createWithFriendSourceFlags(Boolean all, Boolean mutualGuilds, Boolean mutualFriends) {
        return new RestAPIParams$UserSettings(null, null, null, null, null, null, null, null, null, null, null, null, new RestAPIParams$UserSettings$FriendSourceFlags(all, mutualGuilds, mutualFriends), null, null, null, null, null, null, 520191, null);
    }

    public final RestAPIParams$UserSettings createWithGuildFolders(List<ModelGuildFolder> guildFolders) {
        m.checkNotNullParameter(guildFolders, "guildFolders");
        return new RestAPIParams$UserSettings(null, null, null, null, null, null, null, null, null, null, guildFolders, null, null, null, null, null, null, null, null, 523263, null);
    }

    public final RestAPIParams$UserSettings createWithInlineAttachmentMedia(boolean inlineAttachmentMedia) {
        return new RestAPIParams$UserSettings(null, null, null, null, Boolean.valueOf(inlineAttachmentMedia), null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524271, null);
    }

    public final RestAPIParams$UserSettings createWithInlineEmbedMedia(boolean inlineEmbedMedia) {
        return new RestAPIParams$UserSettings(null, null, null, Boolean.valueOf(inlineEmbedMedia), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524279, null);
    }

    public final RestAPIParams$UserSettings createWithLocale(String locale) {
        m.checkNotNullParameter(locale, "locale");
        return new RestAPIParams$UserSettings(null, null, null, null, null, null, locale, null, null, null, null, null, null, null, null, null, null, null, null, 524223, null);
    }

    public final RestAPIParams$UserSettings createWithRenderEmbeds(boolean renderEmbeds) {
        return new RestAPIParams$UserSettings(null, null, Boolean.valueOf(renderEmbeds), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524283, null);
    }

    public final RestAPIParams$UserSettings createWithRestrictedGuilds(Boolean defaultGuildsRestricted, Collection<Long> restrictedGuilds) {
        return new RestAPIParams$UserSettings(null, null, null, null, null, null, null, restrictedGuilds, null, null, null, defaultGuildsRestricted, null, null, null, null, null, null, null, 522111, null);
    }

    public final RestAPIParams$UserSettings createWithShowCurrentGame(boolean showCurrentGame) {
        return new RestAPIParams$UserSettings(null, null, null, null, null, null, null, null, null, Boolean.valueOf(showCurrentGame), null, null, null, null, null, null, null, null, null, 523775, null);
    }

    public final RestAPIParams$UserSettings createWithStatus(ClientStatus status) {
        m.checkNotNullParameter(status, "status");
        String strName = status.name();
        Locale locale = Locale.ROOT;
        m.checkNotNullExpressionValue(locale, "Locale.ROOT");
        Objects.requireNonNull(strName, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strName.toLowerCase(locale);
        m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return new RestAPIParams$UserSettings(null, null, null, null, null, null, null, null, lowerCase, null, null, null, null, null, null, null, null, null, null, 524031, null);
    }

    public final RestAPIParams$UserSettings createWithStickerAnimationSettings(Integer stickerAnimationSettings) {
        return new RestAPIParams$UserSettings(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, stickerAnimationSettings, null, null, 458751, null);
    }

    public final RestAPIParams$UserSettings createWithTheme(String theme) {
        m.checkNotNullParameter(theme, "theme");
        return new RestAPIParams$UserSettings(theme, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524286, null);
    }

    public /* synthetic */ RestAPIParams$UserSettings$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

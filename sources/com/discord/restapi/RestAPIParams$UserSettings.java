package com.discord.restapi;

import com.discord.api.presence.ClientStatus;
import com.discord.models.domain.ModelGuildFolder;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$UserSettings {
    public static final RestAPIParams$UserSettings$Companion Companion = new RestAPIParams$UserSettings$Companion(null);
    private final Boolean allowAccessibilityDetection;
    private final Boolean animateEmoji;
    private final Integer animateStickers;
    private final Boolean blockedMessageBar;
    private final Boolean contactSyncEnabled;
    private final Boolean defaultGuildsRestricted;
    private final Boolean developerMode;
    private final Integer explicitContentFilter;
    private final Integer friendDiscoveryFlags;
    private final RestAPIParams$UserSettings$FriendSourceFlags friendSourceFlags;
    private final Collection<ModelGuildFolder> guildFolders;
    private final Boolean inlineAttachmentMedia;
    private final Boolean inlineEmbedMedia;
    private final String locale;
    private final Boolean renderEmbeds;
    private final Collection<Long> restrictedGuilds;
    private final Boolean showCurrentGame;
    private final String status;
    private final String theme;

    private RestAPIParams$UserSettings(String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, String str2, Collection<Long> collection, String str3, Boolean bool6, Collection<ModelGuildFolder> collection2, Boolean bool7, RestAPIParams$UserSettings$FriendSourceFlags restAPIParams$UserSettings$FriendSourceFlags, Integer num, Boolean bool8, Boolean bool9, Integer num2, Boolean bool10, Integer num3) {
        this.theme = str;
        this.developerMode = bool;
        this.renderEmbeds = bool2;
        this.inlineEmbedMedia = bool3;
        this.inlineAttachmentMedia = bool4;
        this.blockedMessageBar = bool5;
        this.locale = str2;
        this.restrictedGuilds = collection;
        this.status = str3;
        this.showCurrentGame = bool6;
        this.guildFolders = collection2;
        this.defaultGuildsRestricted = bool7;
        this.friendSourceFlags = restAPIParams$UserSettings$FriendSourceFlags;
        this.explicitContentFilter = num;
        this.animateEmoji = bool8;
        this.allowAccessibilityDetection = bool9;
        this.animateStickers = num2;
        this.contactSyncEnabled = bool10;
        this.friendDiscoveryFlags = num3;
    }

    public static final RestAPIParams$UserSettings createWithAllowAccessibilityDetection(Boolean bool) {
        return Companion.createWithAllowAccessibilityDetection(bool);
    }

    public static final RestAPIParams$UserSettings createWithAllowAnimatedEmojis(Boolean bool) {
        return Companion.createWithAllowAnimatedEmojis(bool);
    }

    public static final RestAPIParams$UserSettings createWithBlockedMessageBar(boolean z2) {
        return Companion.createWithBlockedMessageBar(z2);
    }

    public static final RestAPIParams$UserSettings createWithContactSyncUpsellShown() {
        return Companion.createWithContactSyncUpsellShown();
    }

    public static final RestAPIParams$UserSettings createWithDeveloperMode(boolean z2) {
        return Companion.createWithDeveloperMode(z2);
    }

    public static final RestAPIParams$UserSettings createWithExplicitContentFilter(int i) {
        return Companion.createWithExplicitContentFilter(i);
    }

    public static final RestAPIParams$UserSettings createWithFriendDiscoveryFlags(Integer num) {
        return Companion.createWithFriendDiscoveryFlags(num);
    }

    public static final RestAPIParams$UserSettings createWithFriendSourceFlags(Boolean bool, Boolean bool2, Boolean bool3) {
        return Companion.createWithFriendSourceFlags(bool, bool2, bool3);
    }

    public static final RestAPIParams$UserSettings createWithGuildFolders(List<ModelGuildFolder> list) {
        return Companion.createWithGuildFolders(list);
    }

    public static final RestAPIParams$UserSettings createWithInlineAttachmentMedia(boolean z2) {
        return Companion.createWithInlineAttachmentMedia(z2);
    }

    public static final RestAPIParams$UserSettings createWithInlineEmbedMedia(boolean z2) {
        return Companion.createWithInlineEmbedMedia(z2);
    }

    public static final RestAPIParams$UserSettings createWithLocale(String str) {
        return Companion.createWithLocale(str);
    }

    public static final RestAPIParams$UserSettings createWithRenderEmbeds(boolean z2) {
        return Companion.createWithRenderEmbeds(z2);
    }

    public static final RestAPIParams$UserSettings createWithRestrictedGuilds(Boolean bool, Collection<Long> collection) {
        return Companion.createWithRestrictedGuilds(bool, collection);
    }

    public static final RestAPIParams$UserSettings createWithShowCurrentGame(boolean z2) {
        return Companion.createWithShowCurrentGame(z2);
    }

    public static final RestAPIParams$UserSettings createWithStatus(ClientStatus clientStatus) {
        return Companion.createWithStatus(clientStatus);
    }

    public static final RestAPIParams$UserSettings createWithStickerAnimationSettings(Integer num) {
        return Companion.createWithStickerAnimationSettings(num);
    }

    public static final RestAPIParams$UserSettings createWithTheme(String str) {
        return Companion.createWithTheme(str);
    }

    public /* synthetic */ RestAPIParams$UserSettings(String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, String str2, Collection collection, String str3, Boolean bool6, Collection collection2, Boolean bool7, RestAPIParams$UserSettings$FriendSourceFlags restAPIParams$UserSettings$FriendSourceFlags, Integer num, Boolean bool8, Boolean bool9, Integer num2, Boolean bool10, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : bool3, (i & 16) != 0 ? null : bool4, (i & 32) != 0 ? null : bool5, (i & 64) != 0 ? null : str2, (i & 128) != 0 ? null : collection, (i & 256) != 0 ? null : str3, (i & 512) != 0 ? null : bool6, (i & 1024) != 0 ? null : collection2, (i & 2048) != 0 ? null : bool7, (i & 4096) != 0 ? null : restAPIParams$UserSettings$FriendSourceFlags, (i & 8192) != 0 ? null : num, (i & 16384) != 0 ? null : bool8, (i & 32768) != 0 ? null : bool9, (i & 65536) != 0 ? null : num2, (i & 131072) != 0 ? null : bool10, (i & 262144) != 0 ? null : num3);
    }
}

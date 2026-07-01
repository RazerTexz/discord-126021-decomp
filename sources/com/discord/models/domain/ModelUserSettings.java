package com.discord.models.domain;

import android.text.TextUtils;
import b.a.m.a.d0;
import b.d.b.a.a;
import com.discord.api.presence.ClientStatus;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class ModelUserSettings implements Model {
    public static final int EXPLICIT_CONTENT_FILTER_DISABLED = 0;
    public static final int EXPLICIT_CONTENT_FILTER_FRIENDS_AND_NON_FRIENDS = 2;
    public static final int EXPLICIT_CONTENT_FILTER_NON_FRIENDS = 1;
    public static final int STICKER_ANIMATION_ALWAYS_ANIMATE = 0;
    public static final int STICKER_ANIMATION_ANIMATE_ON_INTERACTION = 1;
    public static final int STICKER_ANIMATION_NEVER_ANIMATE = 2;
    public static final String THEME_DARK = "dark";
    public static final String THEME_LIGHT = "light";
    public static final String THEME_PURE_EVIL = "pureEvil";
    private Boolean allowAccessibilityDetection;
    private Boolean animateEmoji;
    private Integer animateStickers;
    private Boolean contactSyncUpsellShown;
    private ModelCustomStatusSetting customStatus;
    private Boolean defaultGuildsRestricted;
    private Boolean developerMode;
    private Integer explicitContentFilter;
    private Integer friendDiscoveryFlags;
    private ModelUserSettings$FriendSourceFlags friendSourceFlags;
    private List<ModelGuildFolder> guildFolders;
    private Boolean inlineAttachmentMedia;
    private Boolean inlineEmbedMedia;
    private String locale;
    private Boolean renderEmbeds;
    private List<Long> restrictedGuilds;
    private Boolean showCurrentGame;
    private ClientStatus status;
    private String theme;

    private static List<ModelGuildFolder> convertFromPositions(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(new ModelGuildFolder(null, Collections.singletonList(list.get(i)), null, null));
        }
        return arrayList;
    }

    public static String getDefaultLocale() {
        return getLocaleString(Locale.getDefault());
    }

    public static Locale getLocaleObject(String str) {
        return str.contains("-") ? new Locale(str.split("-")[0], str.split("-")[1]) : new Locale(str);
    }

    private static String getLocaleString(Locale locale) {
        String string;
        if (TextUtils.isEmpty(locale.getCountry())) {
            string = "";
        } else {
            StringBuilder sbQ = a.Q('-');
            sbQ.append(locale.getCountry().toUpperCase(Locale.getDefault()));
            string = sbQ.toString();
        }
        return locale.getLanguage() + string;
    }

    @Override // com.discord.models.domain.Model
    public void assignField(Model$JsonReader model$JsonReader) throws IOException {
        String strNextName = model$JsonReader.nextName();
        strNextName.hashCode();
        switch (strNextName) {
            case "animate_emoji":
                this.animateEmoji = model$JsonReader.nextBooleanOrNull();
                break;
            case "inline_attachment_media":
                this.inlineAttachmentMedia = model$JsonReader.nextBooleanOrNull();
                break;
            case "explicit_content_filter":
                this.explicitContentFilter = model$JsonReader.nextIntOrNull();
                break;
            case "guild_positions":
                List<ModelGuildFolder> list = this.guildFolders;
                if (list == null || list.isEmpty()) {
                    this.guildFolders = convertFromPositions(model$JsonReader.nextList(new b.a.m.a.a(model$JsonReader)));
                    break;
                }
                break;
            case "show_current_game":
                this.showCurrentGame = Boolean.valueOf(model$JsonReader.nextBoolean(false));
                break;
            case "restricted_guilds":
                this.restrictedGuilds = model$JsonReader.nextList(new b.a.m.a.a(model$JsonReader));
                break;
            case "render_embeds":
                this.renderEmbeds = model$JsonReader.nextBooleanOrNull();
                break;
            case "locale":
                this.locale = model$JsonReader.nextString(this.locale);
                break;
            case "allow_accessibility_detection":
                this.allowAccessibilityDetection = model$JsonReader.nextBooleanOrNull();
                break;
            case "status":
                this.status = (ClientStatus) InboundGatewayGsonParser.fromJson(model$JsonReader, ClientStatus.class);
                break;
            case "guild_folders":
                List<ModelGuildFolder> listNextList = model$JsonReader.nextList(new d0(model$JsonReader));
                if (!listNextList.isEmpty()) {
                    this.guildFolders = listNextList;
                    break;
                }
                break;
            case "theme":
                this.theme = model$JsonReader.nextString(this.theme);
                break;
            case "developer_mode":
                this.developerMode = Boolean.valueOf(model$JsonReader.nextBoolean(false));
                break;
            case "inline_embed_media":
                this.inlineEmbedMedia = model$JsonReader.nextBooleanOrNull();
                break;
            case "contact_sync_enabled":
                this.contactSyncUpsellShown = model$JsonReader.nextBooleanOrNull();
                break;
            case "custom_status":
                this.customStatus = ModelCustomStatusSetting$Parser.INSTANCE.parse(model$JsonReader);
                break;
            case "friend_source_flags":
                this.friendSourceFlags = (ModelUserSettings$FriendSourceFlags) model$JsonReader.parse(new ModelUserSettings$FriendSourceFlags());
                break;
            case "animate_stickers":
                this.animateStickers = model$JsonReader.nextIntOrNull();
                break;
            case "friend_discovery_flags":
                this.friendDiscoveryFlags = Integer.valueOf(model$JsonReader.nextInt(0));
                break;
            case "default_guilds_restricted":
                this.defaultGuildsRestricted = model$JsonReader.nextBooleanOrNull();
                break;
            default:
                model$JsonReader.skipValue();
                break;
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelUserSettings;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelUserSettings)) {
            return false;
        }
        ModelUserSettings modelUserSettings = (ModelUserSettings) obj;
        if (!modelUserSettings.canEqual(this)) {
            return false;
        }
        Boolean renderEmbeds = getRenderEmbeds();
        Boolean renderEmbeds2 = modelUserSettings.getRenderEmbeds();
        if (renderEmbeds != null ? !renderEmbeds.equals(renderEmbeds2) : renderEmbeds2 != null) {
            return false;
        }
        Boolean inlineEmbedMedia = getInlineEmbedMedia();
        Boolean inlineEmbedMedia2 = modelUserSettings.getInlineEmbedMedia();
        if (inlineEmbedMedia != null ? !inlineEmbedMedia.equals(inlineEmbedMedia2) : inlineEmbedMedia2 != null) {
            return false;
        }
        Boolean inlineAttachmentMedia = getInlineAttachmentMedia();
        Boolean inlineAttachmentMedia2 = modelUserSettings.getInlineAttachmentMedia();
        if (inlineAttachmentMedia != null ? !inlineAttachmentMedia.equals(inlineAttachmentMedia2) : inlineAttachmentMedia2 != null) {
            return false;
        }
        Boolean developerMode = getDeveloperMode();
        Boolean developerMode2 = modelUserSettings.getDeveloperMode();
        if (developerMode != null ? !developerMode.equals(developerMode2) : developerMode2 != null) {
            return false;
        }
        Boolean defaultGuildsRestricted = getDefaultGuildsRestricted();
        Boolean defaultGuildsRestricted2 = modelUserSettings.getDefaultGuildsRestricted();
        if (defaultGuildsRestricted != null ? !defaultGuildsRestricted.equals(defaultGuildsRestricted2) : defaultGuildsRestricted2 != null) {
            return false;
        }
        Integer explicitContentFilter = getExplicitContentFilter();
        Integer explicitContentFilter2 = modelUserSettings.getExplicitContentFilter();
        if (explicitContentFilter != null ? !explicitContentFilter.equals(explicitContentFilter2) : explicitContentFilter2 != null) {
            return false;
        }
        Integer friendDiscoveryFlags = getFriendDiscoveryFlags();
        Integer friendDiscoveryFlags2 = modelUserSettings.getFriendDiscoveryFlags();
        if (friendDiscoveryFlags != null ? !friendDiscoveryFlags.equals(friendDiscoveryFlags2) : friendDiscoveryFlags2 != null) {
            return false;
        }
        Boolean contactSyncUpsellShown = getContactSyncUpsellShown();
        Boolean contactSyncUpsellShown2 = modelUserSettings.getContactSyncUpsellShown();
        if (contactSyncUpsellShown != null ? !contactSyncUpsellShown.equals(contactSyncUpsellShown2) : contactSyncUpsellShown2 != null) {
            return false;
        }
        Boolean showCurrentGame = getShowCurrentGame();
        Boolean showCurrentGame2 = modelUserSettings.getShowCurrentGame();
        if (showCurrentGame != null ? !showCurrentGame.equals(showCurrentGame2) : showCurrentGame2 != null) {
            return false;
        }
        Boolean animateEmoji = getAnimateEmoji();
        Boolean animateEmoji2 = modelUserSettings.getAnimateEmoji();
        if (animateEmoji != null ? !animateEmoji.equals(animateEmoji2) : animateEmoji2 != null) {
            return false;
        }
        Boolean allowAccessibilityDetection = getAllowAccessibilityDetection();
        Boolean allowAccessibilityDetection2 = modelUserSettings.getAllowAccessibilityDetection();
        if (allowAccessibilityDetection != null ? !allowAccessibilityDetection.equals(allowAccessibilityDetection2) : allowAccessibilityDetection2 != null) {
            return false;
        }
        Integer animateStickers = getAnimateStickers();
        Integer animateStickers2 = modelUserSettings.getAnimateStickers();
        if (animateStickers != null ? !animateStickers.equals(animateStickers2) : animateStickers2 != null) {
            return false;
        }
        String theme = getTheme();
        String theme2 = modelUserSettings.getTheme();
        if (theme != null ? !theme.equals(theme2) : theme2 != null) {
            return false;
        }
        List<ModelGuildFolder> guildFolders = getGuildFolders();
        List<ModelGuildFolder> guildFolders2 = modelUserSettings.getGuildFolders();
        if (guildFolders != null ? !guildFolders.equals(guildFolders2) : guildFolders2 != null) {
            return false;
        }
        String locale = getLocale();
        String locale2 = modelUserSettings.getLocale();
        if (locale != null ? !locale.equals(locale2) : locale2 != null) {
            return false;
        }
        List<Long> restrictedGuilds = getRestrictedGuilds();
        List<Long> restrictedGuilds2 = modelUserSettings.getRestrictedGuilds();
        if (restrictedGuilds != null ? !restrictedGuilds.equals(restrictedGuilds2) : restrictedGuilds2 != null) {
            return false;
        }
        ModelUserSettings$FriendSourceFlags friendSourceFlags = getFriendSourceFlags();
        ModelUserSettings$FriendSourceFlags friendSourceFlags2 = modelUserSettings.getFriendSourceFlags();
        if (friendSourceFlags != null ? !friendSourceFlags.equals(friendSourceFlags2) : friendSourceFlags2 != null) {
            return false;
        }
        ClientStatus status = getStatus();
        ClientStatus status2 = modelUserSettings.getStatus();
        if (status != null ? !status.equals(status2) : status2 != null) {
            return false;
        }
        ModelCustomStatusSetting customStatus = getCustomStatus();
        ModelCustomStatusSetting customStatus2 = modelUserSettings.getCustomStatus();
        return customStatus != null ? customStatus.equals(customStatus2) : customStatus2 == null;
    }

    public Boolean getAllowAccessibilityDetection() {
        return this.allowAccessibilityDetection;
    }

    public Boolean getAnimateEmoji() {
        return this.animateEmoji;
    }

    public Integer getAnimateStickers() {
        return this.animateStickers;
    }

    public Boolean getContactSyncUpsellShown() {
        return this.contactSyncUpsellShown;
    }

    public ModelCustomStatusSetting getCustomStatus() {
        return this.customStatus;
    }

    public Boolean getDefaultGuildsRestricted() {
        return this.defaultGuildsRestricted;
    }

    public Boolean getDeveloperMode() {
        return this.developerMode;
    }

    public Integer getExplicitContentFilter() {
        return this.explicitContentFilter;
    }

    public Integer getFriendDiscoveryFlags() {
        return this.friendDiscoveryFlags;
    }

    public ModelUserSettings$FriendSourceFlags getFriendSourceFlags() {
        return this.friendSourceFlags;
    }

    public List<ModelGuildFolder> getGuildFolders() {
        return this.guildFolders;
    }

    public Boolean getInlineAttachmentMedia() {
        return this.inlineAttachmentMedia;
    }

    public Boolean getInlineEmbedMedia() {
        return this.inlineEmbedMedia;
    }

    public String getLocale() {
        return this.locale;
    }

    public Boolean getRenderEmbeds() {
        return this.renderEmbeds;
    }

    public List<Long> getRestrictedGuilds() {
        return this.restrictedGuilds;
    }

    public Boolean getShowCurrentGame() {
        return this.showCurrentGame;
    }

    public ClientStatus getStatus() {
        return this.status;
    }

    public String getTheme() {
        return this.theme;
    }

    public int hashCode() {
        Boolean renderEmbeds = getRenderEmbeds();
        int iHashCode = renderEmbeds == null ? 43 : renderEmbeds.hashCode();
        Boolean inlineEmbedMedia = getInlineEmbedMedia();
        int iHashCode2 = ((iHashCode + 59) * 59) + (inlineEmbedMedia == null ? 43 : inlineEmbedMedia.hashCode());
        Boolean inlineAttachmentMedia = getInlineAttachmentMedia();
        int iHashCode3 = (iHashCode2 * 59) + (inlineAttachmentMedia == null ? 43 : inlineAttachmentMedia.hashCode());
        Boolean developerMode = getDeveloperMode();
        int iHashCode4 = (iHashCode3 * 59) + (developerMode == null ? 43 : developerMode.hashCode());
        Boolean defaultGuildsRestricted = getDefaultGuildsRestricted();
        int iHashCode5 = (iHashCode4 * 59) + (defaultGuildsRestricted == null ? 43 : defaultGuildsRestricted.hashCode());
        Integer explicitContentFilter = getExplicitContentFilter();
        int iHashCode6 = (iHashCode5 * 59) + (explicitContentFilter == null ? 43 : explicitContentFilter.hashCode());
        Integer friendDiscoveryFlags = getFriendDiscoveryFlags();
        int iHashCode7 = (iHashCode6 * 59) + (friendDiscoveryFlags == null ? 43 : friendDiscoveryFlags.hashCode());
        Boolean contactSyncUpsellShown = getContactSyncUpsellShown();
        int iHashCode8 = (iHashCode7 * 59) + (contactSyncUpsellShown == null ? 43 : contactSyncUpsellShown.hashCode());
        Boolean showCurrentGame = getShowCurrentGame();
        int iHashCode9 = (iHashCode8 * 59) + (showCurrentGame == null ? 43 : showCurrentGame.hashCode());
        Boolean animateEmoji = getAnimateEmoji();
        int iHashCode10 = (iHashCode9 * 59) + (animateEmoji == null ? 43 : animateEmoji.hashCode());
        Boolean allowAccessibilityDetection = getAllowAccessibilityDetection();
        int iHashCode11 = (iHashCode10 * 59) + (allowAccessibilityDetection == null ? 43 : allowAccessibilityDetection.hashCode());
        Integer animateStickers = getAnimateStickers();
        int iHashCode12 = (iHashCode11 * 59) + (animateStickers == null ? 43 : animateStickers.hashCode());
        String theme = getTheme();
        int iHashCode13 = (iHashCode12 * 59) + (theme == null ? 43 : theme.hashCode());
        List<ModelGuildFolder> guildFolders = getGuildFolders();
        int iHashCode14 = (iHashCode13 * 59) + (guildFolders == null ? 43 : guildFolders.hashCode());
        String locale = getLocale();
        int iHashCode15 = (iHashCode14 * 59) + (locale == null ? 43 : locale.hashCode());
        List<Long> restrictedGuilds = getRestrictedGuilds();
        int iHashCode16 = (iHashCode15 * 59) + (restrictedGuilds == null ? 43 : restrictedGuilds.hashCode());
        ModelUserSettings$FriendSourceFlags friendSourceFlags = getFriendSourceFlags();
        int iHashCode17 = (iHashCode16 * 59) + (friendSourceFlags == null ? 43 : friendSourceFlags.hashCode());
        ClientStatus status = getStatus();
        int iHashCode18 = (iHashCode17 * 59) + (status == null ? 43 : status.hashCode());
        ModelCustomStatusSetting customStatus = getCustomStatus();
        return (iHashCode18 * 59) + (customStatus != null ? customStatus.hashCode() : 43);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelUserSettings(theme=");
        sbU.append(getTheme());
        sbU.append(", guildFolders=");
        sbU.append(getGuildFolders());
        sbU.append(", renderEmbeds=");
        sbU.append(getRenderEmbeds());
        sbU.append(", inlineEmbedMedia=");
        sbU.append(getInlineEmbedMedia());
        sbU.append(", inlineAttachmentMedia=");
        sbU.append(getInlineAttachmentMedia());
        sbU.append(", developerMode=");
        sbU.append(getDeveloperMode());
        sbU.append(", locale=");
        sbU.append(getLocale());
        sbU.append(", restrictedGuilds=");
        sbU.append(getRestrictedGuilds());
        sbU.append(", defaultGuildsRestricted=");
        sbU.append(getDefaultGuildsRestricted());
        sbU.append(", friendSourceFlags=");
        sbU.append(getFriendSourceFlags());
        sbU.append(", explicitContentFilter=");
        sbU.append(getExplicitContentFilter());
        sbU.append(", friendDiscoveryFlags=");
        sbU.append(getFriendDiscoveryFlags());
        sbU.append(", contactSyncUpsellShown=");
        sbU.append(getContactSyncUpsellShown());
        sbU.append(", status=");
        sbU.append(getStatus());
        sbU.append(", customStatus=");
        sbU.append(getCustomStatus());
        sbU.append(", showCurrentGame=");
        sbU.append(getShowCurrentGame());
        sbU.append(", animateEmoji=");
        sbU.append(getAnimateEmoji());
        sbU.append(", allowAccessibilityDetection=");
        sbU.append(getAllowAccessibilityDetection());
        sbU.append(", animateStickers=");
        sbU.append(getAnimateStickers());
        sbU.append(")");
        return sbU.toString();
    }
}

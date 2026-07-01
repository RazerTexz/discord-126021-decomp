package com.discord.utilities.accessibility;

import com.discord.api.permission.Permission;

/* JADX INFO: compiled from: AccessibilityFeatureFlags.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum AccessibilityFeatureFlags {
    NONE(0),
    SCREENREADER(1),
    REDUCED_MOTION(2),
    REDUCED_TRANSPARENCY(4),
    HIGH_CONTRAST(8),
    BOLD_TEXT(16),
    GRAYSCALE(32),
    INVERT_COLORS(64),
    PREFERS_COLOR_SCHEME_LIGHT(128),
    PREFERS_COLOR_SCHEME_DARK(256),
    CHAT_FONT_SCALE_INCREASED(512),
    CHAT_FONT_SCALE_DECREASED(Permission.VIEW_CHANNEL),
    ZOOM_LEVEL_INCREASED(Permission.SEND_MESSAGES),
    ZOOM_LEVEL_DECREASED(Permission.SEND_TTS_MESSAGES),
    MESSAGE_GROUP_SPACING_INCREASED(Permission.MANAGE_MESSAGES),
    MESSAGE_GROUP_SPACING_DECREASED(Permission.EMBED_LINKS),
    DARK_SIDEBAR(Permission.ATTACH_FILES),
    REDUCED_MOTION_FROM_USER_SETTINGS(Permission.READ_MESSAGE_HISTORY),
    SATURATION_LEVEL_DECREASED(Permission.MENTION_EVERYONE),
    FORCED_COLORS(Permission.USE_EXTERNAL_EMOJIS),
    FORCED_COLORS_FROM_USER_SETTINGS(Permission.VIEW_GUILD_ANALYTICS);

    private final long value;

    AccessibilityFeatureFlags(long j) {
        this.value = j;
    }

    public final long getValue() {
        return this.value;
    }
}

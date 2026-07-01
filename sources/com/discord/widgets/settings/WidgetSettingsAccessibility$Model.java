package com.discord.widgets.settings;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetSettingsAccessibility.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetSettingsAccessibility$Model {
    public static final WidgetSettingsAccessibility$Model$Companion Companion = new WidgetSettingsAccessibility$Model$Companion(null);
    private final boolean allowAnimatedEmoji;
    private final boolean autoPlayGifs;
    private final int currentStickerAnimationSettings;
    private final boolean reducedMotionEnabled;

    public WidgetSettingsAccessibility$Model(boolean z2, boolean z3, boolean z4, int i) {
        this.reducedMotionEnabled = z2;
        this.allowAnimatedEmoji = z3;
        this.autoPlayGifs = z4;
        this.currentStickerAnimationSettings = i;
    }

    public static /* synthetic */ WidgetSettingsAccessibility$Model copy$default(WidgetSettingsAccessibility$Model widgetSettingsAccessibility$Model, boolean z2, boolean z3, boolean z4, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = widgetSettingsAccessibility$Model.reducedMotionEnabled;
        }
        if ((i2 & 2) != 0) {
            z3 = widgetSettingsAccessibility$Model.allowAnimatedEmoji;
        }
        if ((i2 & 4) != 0) {
            z4 = widgetSettingsAccessibility$Model.autoPlayGifs;
        }
        if ((i2 & 8) != 0) {
            i = widgetSettingsAccessibility$Model.currentStickerAnimationSettings;
        }
        return widgetSettingsAccessibility$Model.copy(z2, z3, z4, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getReducedMotionEnabled() {
        return this.reducedMotionEnabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getAllowAnimatedEmoji() {
        return this.allowAnimatedEmoji;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getAutoPlayGifs() {
        return this.autoPlayGifs;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getCurrentStickerAnimationSettings() {
        return this.currentStickerAnimationSettings;
    }

    public final WidgetSettingsAccessibility$Model copy(boolean reducedMotionEnabled, boolean allowAnimatedEmoji, boolean autoPlayGifs, int currentStickerAnimationSettings) {
        return new WidgetSettingsAccessibility$Model(reducedMotionEnabled, allowAnimatedEmoji, autoPlayGifs, currentStickerAnimationSettings);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetSettingsAccessibility$Model)) {
            return false;
        }
        WidgetSettingsAccessibility$Model widgetSettingsAccessibility$Model = (WidgetSettingsAccessibility$Model) other;
        return this.reducedMotionEnabled == widgetSettingsAccessibility$Model.reducedMotionEnabled && this.allowAnimatedEmoji == widgetSettingsAccessibility$Model.allowAnimatedEmoji && this.autoPlayGifs == widgetSettingsAccessibility$Model.autoPlayGifs && this.currentStickerAnimationSettings == widgetSettingsAccessibility$Model.currentStickerAnimationSettings;
    }

    public final boolean getAllowAnimatedEmoji() {
        return this.allowAnimatedEmoji;
    }

    public final boolean getAutoPlayGifs() {
        return this.autoPlayGifs;
    }

    public final int getCurrentStickerAnimationSettings() {
        return this.currentStickerAnimationSettings;
    }

    public final boolean getReducedMotionEnabled() {
        return this.reducedMotionEnabled;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        boolean z2 = this.reducedMotionEnabled;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.allowAnimatedEmoji;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.autoPlayGifs;
        return ((i2 + (z4 ? 1 : z4)) * 31) + this.currentStickerAnimationSettings;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(reducedMotionEnabled=");
        sbU.append(this.reducedMotionEnabled);
        sbU.append(", allowAnimatedEmoji=");
        sbU.append(this.allowAnimatedEmoji);
        sbU.append(", autoPlayGifs=");
        sbU.append(this.autoPlayGifs);
        sbU.append(", currentStickerAnimationSettings=");
        return a.B(sbU, this.currentStickerAnimationSettings, ")");
    }
}

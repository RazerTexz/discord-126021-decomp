package com.discord.utilities.analytics;


/* JADX INFO: compiled from: AnalyticsTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum AnalyticsTracker$PremiumUpsellType {
    EmojiPickerHeaderViewed("emoji_picker_search"),
    EmojiPickerLockedItemClicked("emoji_picker_emoji_clicked"),
    StreamQualityIndicator("stream_quality_indicator"),
    EmojiAutocompleteInline("emoji_autocomplete_inline"),
    EmojiAutocompleteModal("emoji_autocomplete_modal"),
    CustomProfileUpsellModal("custom profiles upsell modal"),
    CustomProfileBannerUpsell("custom profiles settings banner upsell"),
    StickerPickerUpsell("sticker_picker_upsell"),
    EmptyStickerPickerUpsell("empty_sticker_picker_upsell"),
    PerGuildIdentityUpsellModal("per server identity upsell modal"),
    PerGuildIdentityInline("per server identity upsell inline");

    private final String analyticsName;

    AnalyticsTracker$PremiumUpsellType(String str) {
        this.analyticsName = str;
    }

    public final String getAnalyticsName() {
        return this.analyticsName;
    }
}

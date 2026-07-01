package com.discord.widgets.stickers;

import androidx.fragment.app.FragmentManager;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AnalyticsTracker$PremiumUpsellType;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.analytics.Traits$Location$Section;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: UnsendableStickerPremiumUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UnsendableStickerPremiumUpsellDialog$Companion {
    private UnsendableStickerPremiumUpsellDialog$Companion() {
    }

    public final void show(FragmentManager fragmentManager) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        new UnsendableStickerPremiumUpsellDialog().show(fragmentManager, UnsendableStickerPremiumUpsellDialog.class.getSimpleName());
        AnalyticsTracker.premiumUpsellViewed$default(AnalyticsTracker.INSTANCE, AnalyticsTracker$PremiumUpsellType.StickerPickerUpsell, new Traits$Location(null, Traits$Location$Section.STICKER_PICKER_UPSELL, null, null, null, 29, null), null, null, 12, null);
    }

    public /* synthetic */ UnsendableStickerPremiumUpsellDialog$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

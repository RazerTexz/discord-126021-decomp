package com.discord.widgets.stickers;

import androidx.fragment.app.FragmentManager;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.analytics.Traits$Location$Section;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StickerPremiumUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StickerPremiumUpsellDialog$Companion {
    private StickerPremiumUpsellDialog$Companion() {
    }

    public final void show(FragmentManager fragmentManager, Traits$Location analyticsLocation) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(analyticsLocation, "analyticsLocation");
        AnalyticsTracker.INSTANCE.openModal(Traits$Location$Section.STICKER_PREMIUM_TIER_2_UPSELL_MODAL, analyticsLocation);
        new StickerPremiumUpsellDialog().show(fragmentManager, StickerPremiumUpsellDialog.class.getSimpleName());
    }

    public /* synthetic */ StickerPremiumUpsellDialog$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

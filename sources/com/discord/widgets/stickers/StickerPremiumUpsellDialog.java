package com.discord.widgets.stickers;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.PremiumStickerUpsellDialogBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.GooglePlaySku;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: StickerPremiumUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StickerPremiumUpsellDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(StickerPremiumUpsellDialog.class, "binding", "getBinding()Lcom/discord/databinding/PremiumStickerUpsellDialogBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: StickerPremiumUpsellDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, Traits.Location analyticsLocation) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(analyticsLocation, "analyticsLocation");
            AnalyticsTracker.INSTANCE.openModal(Traits.Location.Section.STICKER_PREMIUM_TIER_2_UPSELL_MODAL, analyticsLocation);
            new StickerPremiumUpsellDialog().show(fragmentManager, StickerPremiumUpsellDialog.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public StickerPremiumUpsellDialog() {
        super(R.layout.premium_sticker_upsell_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, StickerPremiumUpsellDialog2.INSTANCE, null, 2, null);
    }

    private final PremiumStickerUpsellDialogBinding getBinding() {
        return (PremiumStickerUpsellDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialogRequireDialog = requireDialog();
        Intrinsics3.checkNotNullExpressionValue(dialogRequireDialog, "requireDialog()");
        Window window = dialogRequireDialog.getWindow();
        if (window != null) {
            window.setLayout(-1, -2);
        }
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        requireDialog().setCanceledOnTouchOutside(true);
        String skuPrice = PremiumUtils.INSTANCE.getSkuPrice(GooglePlaySku.PREMIUM_TIER_2_MONTHLY.getSkuName());
        if (skuPrice != null) {
            TextView textView = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.premiumUpsellDescription");
            FormatUtils.m(textView, R.string.premium_upsell_feature_pretext, new Object[]{skuPrice}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        } else {
            TextView textView2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.premiumUpsellDescription");
            FormatUtils.m(textView2, R.string.premium_upsell_feature_pretext_without_price, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
        }
        TextView textView3 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.premiumUpsellPerkBoosts");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        FormatUtils.m(textView3, R.string.premium_upsell_feature_free_guild_subscription, new Object[]{StringResourceUtils.getI18nPluralString(contextRequireContext, R.plurals.premium_upsell_feature_free_guild_subscription_numFreeGuildSubscriptions, 2, 2)}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.stickers.StickerPremiumUpsellDialog.onViewBoundOrOnResume.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StickerPremiumUpsellDialog.this.dismiss();
            }
        });
        getBinding().f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.stickers.StickerPremiumUpsellDialog.onViewBoundOrOnResume.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StickerPremiumUpsellDialog.this.dismiss();
                WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
                Context contextRequireContext2 = StickerPremiumUpsellDialog.this.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                companion.launch(contextRequireContext2, 1, Traits.Location.Section.STICKER_PREMIUM_TIER_2_UPSELL_MODAL);
            }
        });
        getBinding().f2136b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.stickers.StickerPremiumUpsellDialog.onViewBoundOrOnResume.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StickerPremiumUpsellDialog.this.dismiss();
            }
        });
    }
}

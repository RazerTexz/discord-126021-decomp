package com.discord.widgets.stickers;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.PremiumStickerUpsellDialogBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.GooglePlaySku;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StickerPremiumUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StickerPremiumUpsellDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(StickerPremiumUpsellDialog.class, "binding", "getBinding()Lcom/discord/databinding/PremiumStickerUpsellDialogBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: StickerPremiumUpsellDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, Traits.Location analyticsLocation) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(analyticsLocation, "analyticsLocation");
            AnalyticsTracker.INSTANCE.openModal(Traits.Location.Section.STICKER_PREMIUM_TIER_2_UPSELL_MODAL, analyticsLocation);
            new StickerPremiumUpsellDialog().show(fragmentManager, StickerPremiumUpsellDialog.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public StickerPremiumUpsellDialog() {
        super(C5419R.layout.premium_sticker_upsell_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, StickerPremiumUpsellDialog$binding$2.INSTANCE, null, 2, null);
    }

    private final PremiumStickerUpsellDialogBinding getBinding() {
        return (PremiumStickerUpsellDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialogRequireDialog = requireDialog();
        C12238m.checkNotNullExpressionValue(dialogRequireDialog, "requireDialog()");
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
            TextView textView = getBinding().f15216d;
            C12238m.checkNotNullExpressionValue(textView, "binding.premiumUpsellDescription");
            C1107b.m221m(textView, C5419R.string.premium_upsell_feature_pretext, new Object[]{skuPrice}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        } else {
            TextView textView2 = getBinding().f15216d;
            C12238m.checkNotNullExpressionValue(textView2, "binding.premiumUpsellDescription");
            C1107b.m221m(textView2, C5419R.string.premium_upsell_feature_pretext_without_price, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
        }
        TextView textView3 = getBinding().f15217e;
        C12238m.checkNotNullExpressionValue(textView3, "binding.premiumUpsellPerkBoosts");
        Context contextRequireContext = requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        C1107b.m221m(textView3, C5419R.string.premium_upsell_feature_free_guild_subscription, new Object[]{StringResourceUtilsKt.getI18nPluralString(contextRequireContext, C5419R.plurals.premium_upsell_feature_free_guild_subscription_numFreeGuildSubscriptions, 2, 2)}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        getBinding().f15215c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.stickers.StickerPremiumUpsellDialog.onViewBoundOrOnResume.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StickerPremiumUpsellDialog.this.dismiss();
            }
        });
        getBinding().f15218f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.stickers.StickerPremiumUpsellDialog.onViewBoundOrOnResume.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StickerPremiumUpsellDialog.this.dismiss();
                WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
                Context contextRequireContext2 = StickerPremiumUpsellDialog.this.requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                companion.launch(contextRequireContext2, 1, Traits.Location.Section.STICKER_PREMIUM_TIER_2_UPSELL_MODAL);
            }
        });
        getBinding().f15214b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.stickers.StickerPremiumUpsellDialog.onViewBoundOrOnResume.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StickerPremiumUpsellDialog.this.dismiss();
            }
        });
    }
}

package com.discord.widgets.stickers;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.app.AppDialog;
import com.discord.databinding.PremiumStickerUpsellDialogBinding;
import com.discord.utilities.billing.GooglePlaySku;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: StickerPremiumUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StickerPremiumUpsellDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(StickerPremiumUpsellDialog.class, "binding", "getBinding()Lcom/discord/databinding/PremiumStickerUpsellDialogBinding;", 0)};
    public static final StickerPremiumUpsellDialog$Companion Companion = new StickerPremiumUpsellDialog$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public StickerPremiumUpsellDialog() {
        super(R$layout.premium_sticker_upsell_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, StickerPremiumUpsellDialog$binding$2.INSTANCE, null, 2, null);
    }

    private final PremiumStickerUpsellDialogBinding getBinding() {
        return (PremiumStickerUpsellDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialogRequireDialog = requireDialog();
        m.checkNotNullExpressionValue(dialogRequireDialog, "requireDialog()");
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
            m.checkNotNullExpressionValue(textView, "binding.premiumUpsellDescription");
            b.n(textView, 2131894507, new Object[]{skuPrice}, null, 4);
        } else {
            TextView textView2 = getBinding().d;
            m.checkNotNullExpressionValue(textView2, "binding.premiumUpsellDescription");
            b.n(textView2, 2131894509, new Object[0], null, 4);
        }
        TextView textView3 = getBinding().e;
        m.checkNotNullExpressionValue(textView3, "binding.premiumUpsellPerkBoosts");
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        b.n(textView3, 2131894505, new Object[]{StringResourceUtilsKt.getI18nPluralString(contextRequireContext, R$plurals.premium_upsell_feature_free_guild_subscription_numFreeGuildSubscriptions, 2, 2)}, null, 4);
        getBinding().c.setOnClickListener(new StickerPremiumUpsellDialog$onViewBoundOrOnResume$1(this));
        getBinding().f.setOnClickListener(new StickerPremiumUpsellDialog$onViewBoundOrOnResume$2(this));
        getBinding().f2136b.setOnClickListener(new StickerPremiumUpsellDialog$onViewBoundOrOnResume$3(this));
    }
}

package com.discord.widgets.stickers;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.StickerPremiumUpsellDialogBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: UnsendableStickerPremiumUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UnsendableStickerPremiumUpsellDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(UnsendableStickerPremiumUpsellDialog.class, "binding", "getBinding()Lcom/discord/databinding/StickerPremiumUpsellDialogBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: UnsendableStickerPremiumUpsellDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            new UnsendableStickerPremiumUpsellDialog().show(fragmentManager, UnsendableStickerPremiumUpsellDialog.class.getSimpleName());
            AnalyticsTracker.premiumUpsellViewed$default(AnalyticsTracker.INSTANCE, AnalyticsTracker.PremiumUpsellType.StickerPickerUpsell, new Traits.Location(null, Traits.Location.Section.STICKER_PICKER_UPSELL, null, null, null, 29, null), null, null, 12, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public UnsendableStickerPremiumUpsellDialog() {
        super(C5419R.layout.sticker_premium_upsell_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, UnsendableStickerPremiumUpsellDialog$binding$2.INSTANCE, null, 2, null);
    }

    private final StickerPremiumUpsellDialogBinding getBinding() {
        return (StickerPremiumUpsellDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().f15279c;
        C12238m.checkNotNullExpressionValue(textView, "binding.stickerPremiumUpsellDescription");
        textView.setText(C1107b.m213e(this, C5419R.string.premium_upsell_global_stickers_description_mobile, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null));
        getBinding().f15278b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.stickers.UnsendableStickerPremiumUpsellDialog.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UnsendableStickerPremiumUpsellDialog.this.dismiss();
            }
        });
        getBinding().f15280d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.stickers.UnsendableStickerPremiumUpsellDialog.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
                Context contextRequireContext = UnsendableStickerPremiumUpsellDialog.this.requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                WidgetSettingsPremium.Companion.launch$default(companion, contextRequireContext, null, Traits.Location.Section.EXPRESSION_PICKER, 2, null);
                UnsendableStickerPremiumUpsellDialog.this.dismiss();
            }
        });
    }
}

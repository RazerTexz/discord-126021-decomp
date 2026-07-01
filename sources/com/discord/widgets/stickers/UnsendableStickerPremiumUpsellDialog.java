package com.discord.widgets.stickers;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.databinding.StickerPremiumUpsellDialogBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: UnsendableStickerPremiumUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UnsendableStickerPremiumUpsellDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(UnsendableStickerPremiumUpsellDialog.class, "binding", "getBinding()Lcom/discord/databinding/StickerPremiumUpsellDialogBinding;", 0)};
    public static final UnsendableStickerPremiumUpsellDialog$Companion Companion = new UnsendableStickerPremiumUpsellDialog$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public UnsendableStickerPremiumUpsellDialog() {
        super(R$layout.sticker_premium_upsell_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, UnsendableStickerPremiumUpsellDialog$binding$2.INSTANCE, null, 2, null);
    }

    private final StickerPremiumUpsellDialogBinding getBinding() {
        return (StickerPremiumUpsellDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().c;
        m.checkNotNullExpressionValue(textView, "binding.stickerPremiumUpsellDescription");
        textView.setText(b.k(this, 2131894513, new Object[0], null, 4));
        getBinding().f2154b.setOnClickListener(new UnsendableStickerPremiumUpsellDialog$onViewBound$1(this));
        getBinding().d.setOnClickListener(new UnsendableStickerPremiumUpsellDialog$onViewBound$2(this));
    }
}

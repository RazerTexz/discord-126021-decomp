package com.discord.widgets.stickers;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.StickerPremiumUpsellDialogBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.stickers.UnsendableStickerPremiumUpsellDialog$binding$2, reason: use source file name */
/* JADX INFO: compiled from: UnsendableStickerPremiumUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class UnsendableStickerPremiumUpsellDialog2 extends FunctionReferenceImpl implements Function1<View, StickerPremiumUpsellDialogBinding> {
    public static final UnsendableStickerPremiumUpsellDialog2 INSTANCE = new UnsendableStickerPremiumUpsellDialog2();

    public UnsendableStickerPremiumUpsellDialog2() {
        super(1, StickerPremiumUpsellDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/StickerPremiumUpsellDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final StickerPremiumUpsellDialogBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.sticker_premium_upsell_close_button;
        TextView textView = (TextView) view.findViewById(R.id.sticker_premium_upsell_close_button);
        if (textView != null) {
            i = R.id.sticker_premium_upsell_description;
            TextView textView2 = (TextView) view.findViewById(R.id.sticker_premium_upsell_description);
            if (textView2 != null) {
                i = R.id.sticker_premium_upsell_subscribe_button;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.sticker_premium_upsell_subscribe_button);
                if (materialButton != null) {
                    return new StickerPremiumUpsellDialogBinding((RelativeLayout) view, textView, textView2, materialButton);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

package com.discord.widgets.stickers;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.StickerPremiumUpsellDialogBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: UnsendableStickerPremiumUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class UnsendableStickerPremiumUpsellDialog$binding$2 extends C12236k implements Function1<View, StickerPremiumUpsellDialogBinding> {
    public static final UnsendableStickerPremiumUpsellDialog$binding$2 INSTANCE = new UnsendableStickerPremiumUpsellDialog$binding$2();

    public UnsendableStickerPremiumUpsellDialog$binding$2() {
        super(1, StickerPremiumUpsellDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/StickerPremiumUpsellDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final StickerPremiumUpsellDialogBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.sticker_premium_upsell_close_button;
        TextView textView = (TextView) view.findViewById(C5419R.id.sticker_premium_upsell_close_button);
        if (textView != null) {
            i = C5419R.id.sticker_premium_upsell_description;
            TextView textView2 = (TextView) view.findViewById(C5419R.id.sticker_premium_upsell_description);
            if (textView2 != null) {
                i = C5419R.id.sticker_premium_upsell_subscribe_button;
                MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.sticker_premium_upsell_subscribe_button);
                if (materialButton != null) {
                    return new StickerPremiumUpsellDialogBinding((RelativeLayout) view, textView, textView2, materialButton);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

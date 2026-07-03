package com.discord.widgets.stickers;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.PremiumStickerUpsellDialogBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StickerPremiumUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class StickerPremiumUpsellDialog$binding$2 extends C12236k implements Function1<View, PremiumStickerUpsellDialogBinding> {
    public static final StickerPremiumUpsellDialog$binding$2 INSTANCE = new StickerPremiumUpsellDialog$binding$2();

    public StickerPremiumUpsellDialog$binding$2() {
        super(1, PremiumStickerUpsellDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/PremiumStickerUpsellDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final PremiumStickerUpsellDialogBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.close_button;
        TextView textView = (TextView) view.findViewById(C5419R.id.close_button);
        if (textView != null) {
            i = C5419R.id.premium_upsell_close;
            ImageView imageView = (ImageView) view.findViewById(C5419R.id.premium_upsell_close);
            if (imageView != null) {
                i = C5419R.id.premium_upsell_description;
                TextView textView2 = (TextView) view.findViewById(C5419R.id.premium_upsell_description);
                if (textView2 != null) {
                    i = C5419R.id.premium_upsell_perk_boosts;
                    TextView textView3 = (TextView) view.findViewById(C5419R.id.premium_upsell_perk_boosts);
                    if (textView3 != null) {
                        i = C5419R.id.subscribe_button;
                        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.subscribe_button);
                        if (materialButton != null) {
                            return new PremiumStickerUpsellDialogBinding((RelativeLayout) view, textView, imageView, textView2, textView3, materialButton);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

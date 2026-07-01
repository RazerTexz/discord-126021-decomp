package com.discord.widgets.stickers;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.databinding.PremiumStickerUpsellDialogBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StickerPremiumUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class StickerPremiumUpsellDialog$binding$2 extends k implements Function1<View, PremiumStickerUpsellDialogBinding> {
    public static final StickerPremiumUpsellDialog$binding$2 INSTANCE = new StickerPremiumUpsellDialog$binding$2();

    public StickerPremiumUpsellDialog$binding$2() {
        super(1, PremiumStickerUpsellDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/PremiumStickerUpsellDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ PremiumStickerUpsellDialogBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final PremiumStickerUpsellDialogBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.close_button;
        TextView textView = (TextView) view.findViewById(R$id.close_button);
        if (textView != null) {
            i = R$id.premium_upsell_close;
            ImageView imageView = (ImageView) view.findViewById(R$id.premium_upsell_close);
            if (imageView != null) {
                i = R$id.premium_upsell_description;
                TextView textView2 = (TextView) view.findViewById(R$id.premium_upsell_description);
                if (textView2 != null) {
                    i = R$id.premium_upsell_perk_boosts;
                    TextView textView3 = (TextView) view.findViewById(R$id.premium_upsell_perk_boosts);
                    if (textView3 != null) {
                        i = R$id.subscribe_button;
                        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.subscribe_button);
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

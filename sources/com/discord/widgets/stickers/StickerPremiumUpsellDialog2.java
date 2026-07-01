package com.discord.widgets.stickers;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.PremiumStickerUpsellDialogBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.stickers.StickerPremiumUpsellDialog$binding$2, reason: use source file name */
/* JADX INFO: compiled from: StickerPremiumUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class StickerPremiumUpsellDialog2 extends FunctionReferenceImpl implements Function1<View, PremiumStickerUpsellDialogBinding> {
    public static final StickerPremiumUpsellDialog2 INSTANCE = new StickerPremiumUpsellDialog2();

    public StickerPremiumUpsellDialog2() {
        super(1, PremiumStickerUpsellDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/PremiumStickerUpsellDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final PremiumStickerUpsellDialogBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.close_button;
        TextView textView = (TextView) view.findViewById(R.id.close_button);
        if (textView != null) {
            i = R.id.premium_upsell_close;
            ImageView imageView = (ImageView) view.findViewById(R.id.premium_upsell_close);
            if (imageView != null) {
                i = R.id.premium_upsell_description;
                TextView textView2 = (TextView) view.findViewById(R.id.premium_upsell_description);
                if (textView2 != null) {
                    i = R.id.premium_upsell_perk_boosts;
                    TextView textView3 = (TextView) view.findViewById(R.id.premium_upsell_perk_boosts);
                    if (textView3 != null) {
                        i = R.id.subscribe_button;
                        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.subscribe_button);
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

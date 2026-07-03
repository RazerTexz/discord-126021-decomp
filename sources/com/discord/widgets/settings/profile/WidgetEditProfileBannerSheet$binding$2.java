package com.discord.widgets.settings.profile;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetEditProfileBannerSheetBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetEditProfileBannerSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetEditProfileBannerSheet$binding$2 extends C12236k implements Function1<View, WidgetEditProfileBannerSheetBinding> {
    public static final WidgetEditProfileBannerSheet$binding$2 INSTANCE = new WidgetEditProfileBannerSheet$binding$2();

    public WidgetEditProfileBannerSheet$binding$2() {
        super(1, WidgetEditProfileBannerSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetEditProfileBannerSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetEditProfileBannerSheetBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.banner_change_image_item_container;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.banner_change_image_item_container);
        if (linearLayout != null) {
            i = C5419R.id.banner_change_image_item_description;
            MaterialTextView materialTextView = (MaterialTextView) view.findViewById(C5419R.id.banner_change_image_item_description);
            if (materialTextView != null) {
                i = C5419R.id.banner_change_image_item_title;
                MaterialTextView materialTextView2 = (MaterialTextView) view.findViewById(C5419R.id.banner_change_image_item_title);
                if (materialTextView2 != null) {
                    i = C5419R.id.banner_color_item_container;
                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(C5419R.id.banner_color_item_container);
                    if (constraintLayout != null) {
                        i = C5419R.id.banner_color_item_description;
                        MaterialTextView materialTextView3 = (MaterialTextView) view.findViewById(C5419R.id.banner_color_item_description);
                        if (materialTextView3 != null) {
                            i = C5419R.id.banner_color_item_title;
                            MaterialTextView materialTextView4 = (MaterialTextView) view.findViewById(C5419R.id.banner_color_item_title);
                            if (materialTextView4 != null) {
                                i = C5419R.id.banner_color_preview;
                                ImageView imageView = (ImageView) view.findViewById(C5419R.id.banner_color_preview);
                                if (imageView != null) {
                                    i = C5419R.id.banner_remove_image_item;
                                    MaterialTextView materialTextView5 = (MaterialTextView) view.findViewById(C5419R.id.banner_remove_image_item);
                                    if (materialTextView5 != null) {
                                        i = C5419R.id.premium_upsell_button;
                                        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.premium_upsell_button);
                                        if (materialButton != null) {
                                            return new WidgetEditProfileBannerSheetBinding((LinearLayout) view, linearLayout, materialTextView, materialTextView2, constraintLayout, materialTextView3, materialTextView4, imageView, materialTextView5, materialButton);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

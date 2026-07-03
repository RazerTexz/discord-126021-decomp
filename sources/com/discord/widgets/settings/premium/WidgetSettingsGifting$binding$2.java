package com.discord.widgets.settings.premium;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetSettingsGiftingBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.premium.GiftSelectView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsGifting$binding$2 extends C12236k implements Function1<View, WidgetSettingsGiftingBinding> {
    public static final WidgetSettingsGifting$binding$2 INSTANCE = new WidgetSettingsGifting$binding$2();

    public WidgetSettingsGifting$binding$2() {
        super(1, WidgetSettingsGiftingBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsGiftingBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsGiftingBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.dimmer_view;
        DimmerView dimmerView = (DimmerView) view.findViewById(C5419R.id.dimmer_view);
        if (dimmerView != null) {
            i = C5419R.id.gift_select_premium_tier_1_month;
            GiftSelectView giftSelectView = (GiftSelectView) view.findViewById(C5419R.id.gift_select_premium_tier_1_month);
            if (giftSelectView != null) {
                i = C5419R.id.gift_select_premium_tier_1_year;
                GiftSelectView giftSelectView2 = (GiftSelectView) view.findViewById(C5419R.id.gift_select_premium_tier_1_year);
                if (giftSelectView2 != null) {
                    i = C5419R.id.gift_select_premium_tier_2_month;
                    GiftSelectView giftSelectView3 = (GiftSelectView) view.findViewById(C5419R.id.gift_select_premium_tier_2_month);
                    if (giftSelectView3 != null) {
                        i = C5419R.id.gift_select_premium_tier_2_year;
                        GiftSelectView giftSelectView4 = (GiftSelectView) view.findViewById(C5419R.id.gift_select_premium_tier_2_year);
                        if (giftSelectView4 != null) {
                            i = C5419R.id.premium_tier_1_gift_learn_more;
                            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.premium_tier_1_gift_learn_more);
                            if (linkifiedTextView != null) {
                                i = C5419R.id.premium_tier_2_gift_learn_more;
                                LinkifiedTextView linkifiedTextView2 = (LinkifiedTextView) view.findViewById(C5419R.id.premium_tier_2_gift_learn_more);
                                if (linkifiedTextView2 != null) {
                                    i = C5419R.id.settings_gifting_flipper;
                                    AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.settings_gifting_flipper);
                                    if (appViewFlipper != null) {
                                        i = C5419R.id.settings_gifting_gift_code_input_progress;
                                        ProgressBar progressBar = (ProgressBar) view.findViewById(C5419R.id.settings_gifting_gift_code_input_progress);
                                        if (progressBar != null) {
                                            i = C5419R.id.settings_gifting_gift_code_input_wrap;
                                            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.settings_gifting_gift_code_input_wrap);
                                            if (textInputLayout != null) {
                                                i = C5419R.id.settings_gifting_gifts_you_purchased_header;
                                                TextView textView = (TextView) view.findViewById(C5419R.id.settings_gifting_gifts_you_purchased_header);
                                                if (textView != null) {
                                                    i = C5419R.id.settings_gifting_gifts_you_purchased_recycler;
                                                    RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.settings_gifting_gifts_you_purchased_recycler);
                                                    if (recyclerView != null) {
                                                        i = C5419R.id.settings_gifting_purchase_gift_section;
                                                        LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.settings_gifting_purchase_gift_section);
                                                        if (linearLayout != null) {
                                                            i = C5419R.id.settings_gifting_redeem_codes_header;
                                                            TextView textView2 = (TextView) view.findViewById(C5419R.id.settings_gifting_redeem_codes_header);
                                                            if (textView2 != null) {
                                                                i = C5419R.id.settings_gifting_retry;
                                                                MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.settings_gifting_retry);
                                                                if (materialButton != null) {
                                                                    i = C5419R.id.settings_gifting_select_classic_gift_header;
                                                                    TextView textView3 = (TextView) view.findViewById(C5419R.id.settings_gifting_select_classic_gift_header);
                                                                    if (textView3 != null) {
                                                                        i = C5419R.id.settings_gifting_select_gift_header;
                                                                        TextView textView4 = (TextView) view.findViewById(C5419R.id.settings_gifting_select_gift_header);
                                                                        if (textView4 != null) {
                                                                            i = C5419R.id.settings_gifting_your_gifts_header;
                                                                            TextView textView5 = (TextView) view.findViewById(C5419R.id.settings_gifting_your_gifts_header);
                                                                            if (textView5 != null) {
                                                                                i = C5419R.id.settings_gifting_your_gifts_recycler;
                                                                                RecyclerView recyclerView2 = (RecyclerView) view.findViewById(C5419R.id.settings_gifting_your_gifts_recycler);
                                                                                if (recyclerView2 != null) {
                                                                                    return new WidgetSettingsGiftingBinding((CoordinatorLayout) view, dimmerView, giftSelectView, giftSelectView2, giftSelectView3, giftSelectView4, linkifiedTextView, linkifiedTextView2, appViewFlipper, progressBar, textInputLayout, textView, recyclerView, linearLayout, textView2, materialButton, textView3, textView4, textView5, recyclerView2);
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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

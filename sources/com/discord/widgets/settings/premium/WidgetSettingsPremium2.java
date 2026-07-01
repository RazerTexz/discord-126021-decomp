package com.discord.widgets.settings.premium;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.a.i.LayoutAccountCreditsListBinding;
import b.a.i.LayoutPremiumSettingsPaymentBinding;
import b.a.i.ViewPremiumSettingsPerksBinding;
import b.a.i.ViewPremiumSettingsTier1Binding;
import b.a.i.ViewPremiumSettingsTier2Binding;
import b.a.i.WidgetSettingsPremiumPriceChangeNoticeBinding;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetSettingsPremiumBinding;
import com.discord.views.ActiveSubscriptionView;
import com.discord.views.premium.AccountCreditView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsPremium.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsPremium2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsPremiumBinding> {
    public static final WidgetSettingsPremium2 INSTANCE = new WidgetSettingsPremium2();

    public WidgetSettingsPremium2() {
        super(1, WidgetSettingsPremiumBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsPremiumBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsPremiumBinding invoke(View view) {
        int i;
        Intrinsics3.checkNotNullParameter(view, "p1");
        View viewFindViewById = view.findViewById(R.id.account_credits);
        int i2 = R.id.premium_settings_grandfathered;
        if (viewFindViewById != null) {
            AccountCreditView accountCreditView = (AccountCreditView) viewFindViewById.findViewById(R.id.credit_nitro);
            if (accountCreditView != null) {
                AccountCreditView accountCreditView2 = (AccountCreditView) viewFindViewById.findViewById(R.id.credit_nitro_classic);
                if (accountCreditView2 != null) {
                    View viewFindViewById2 = viewFindViewById.findViewById(R.id.credit_nitro_divider);
                    if (viewFindViewById2 != null) {
                        LayoutAccountCreditsListBinding layoutAccountCreditsListBinding = new LayoutAccountCreditsListBinding((CardView) viewFindViewById, accountCreditView, accountCreditView2, viewFindViewById2);
                        View viewFindViewById3 = view.findViewById(R.id.payment);
                        if (viewFindViewById3 != null) {
                            int i3 = R.id.active_subscriptions_bottom_button;
                            MaterialButton materialButton = (MaterialButton) viewFindViewById3.findViewById(R.id.active_subscriptions_bottom_button);
                            if (materialButton != null) {
                                i3 = R.id.premium_settings_billing_divider;
                                View viewFindViewById4 = viewFindViewById3.findViewById(R.id.premium_settings_billing_divider);
                                if (viewFindViewById4 != null) {
                                    i3 = R.id.premium_settings_billing_information;
                                    TextView textView = (TextView) viewFindViewById3.findViewById(R.id.premium_settings_billing_information);
                                    if (textView != null) {
                                        i3 = R.id.premium_settings_google_play_manage;
                                        TextView textView2 = (TextView) viewFindViewById3.findViewById(R.id.premium_settings_google_play_manage);
                                        if (textView2 != null) {
                                            LinearLayout linearLayout = (LinearLayout) viewFindViewById3;
                                            i3 = R.id.premium_settings_payment_header;
                                            TextView textView3 = (TextView) viewFindViewById3.findViewById(R.id.premium_settings_payment_header);
                                            if (textView3 != null) {
                                                LayoutPremiumSettingsPaymentBinding layoutPremiumSettingsPaymentBinding = new LayoutPremiumSettingsPaymentBinding(linearLayout, materialButton, viewFindViewById4, textView, textView2, linearLayout, textView3);
                                                View viewFindViewById5 = view.findViewById(R.id.premium_perks);
                                                if (viewFindViewById5 != null) {
                                                    int i4 = R.id.guild_subscription_perk;
                                                    TextView textView4 = (TextView) viewFindViewById5.findViewById(R.id.guild_subscription_perk);
                                                    if (textView4 != null) {
                                                        i4 = R.id.identity_perk;
                                                        TextView textView5 = (TextView) viewFindViewById5.findViewById(R.id.identity_perk);
                                                        if (textView5 != null) {
                                                            i4 = R.id.max_guilds_perk;
                                                            TextView textView6 = (TextView) viewFindViewById5.findViewById(R.id.max_guilds_perk);
                                                            if (textView6 != null) {
                                                                i4 = R.id.max_message_length_perk;
                                                                TextView textView7 = (TextView) viewFindViewById5.findViewById(R.id.max_message_length_perk);
                                                                if (textView7 != null) {
                                                                    i4 = R.id.upload_size_perk;
                                                                    TextView textView8 = (TextView) viewFindViewById5.findViewById(R.id.upload_size_perk);
                                                                    if (textView8 != null) {
                                                                        ViewPremiumSettingsPerksBinding viewPremiumSettingsPerksBinding = new ViewPremiumSettingsPerksBinding((LinearLayout) viewFindViewById5, textView4, textView5, textView6, textView7, textView8);
                                                                        ActiveSubscriptionView activeSubscriptionView = (ActiveSubscriptionView) view.findViewById(R.id.premium_settings_active_guild_subscription);
                                                                        if (activeSubscriptionView != null) {
                                                                            ActiveSubscriptionView activeSubscriptionView2 = (ActiveSubscriptionView) view.findViewById(R.id.premium_settings_active_subscription);
                                                                            if (activeSubscriptionView2 != null) {
                                                                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.premium_settings_credit_container);
                                                                                if (linearLayout2 != null) {
                                                                                    TextView textView9 = (TextView) view.findViewById(R.id.premium_settings_credit_header);
                                                                                    if (textView9 != null) {
                                                                                        TextView textView10 = (TextView) view.findViewById(R.id.premium_settings_grandfathered);
                                                                                        if (textView10 != null) {
                                                                                            TextView textView11 = (TextView) view.findViewById(R.id.premium_settings_legalese);
                                                                                            if (textView11 != null) {
                                                                                                View viewFindViewById6 = view.findViewById(R.id.premium_settings_price_change_notice);
                                                                                                if (viewFindViewById6 != null) {
                                                                                                    CardView cardView = (CardView) viewFindViewById6;
                                                                                                    TextView textView12 = (TextView) viewFindViewById6.findViewById(R.id.textview);
                                                                                                    if (textView12 == null) {
                                                                                                        throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById6.getResources().getResourceName(R.id.textview)));
                                                                                                    }
                                                                                                    WidgetSettingsPremiumPriceChangeNoticeBinding widgetSettingsPremiumPriceChangeNoticeBinding = new WidgetSettingsPremiumPriceChangeNoticeBinding(cardView, cardView, textView12);
                                                                                                    MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.premium_settings_retry);
                                                                                                    if (materialButton2 != null) {
                                                                                                        ScrollView scrollView = (ScrollView) view.findViewById(R.id.premium_settings_scrollview);
                                                                                                        if (scrollView != null) {
                                                                                                            Button button = (Button) view.findViewById(R.id.premium_settings_status_notice_button);
                                                                                                            if (button != null) {
                                                                                                                CardView cardView2 = (CardView) view.findViewById(R.id.premium_settings_status_notice_container);
                                                                                                                if (cardView2 != null) {
                                                                                                                    TextView textView13 = (TextView) view.findViewById(R.id.premium_settings_status_notice_tv);
                                                                                                                    if (textView13 != null) {
                                                                                                                        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.premium_settings_subscription_container);
                                                                                                                        if (linearLayout3 != null) {
                                                                                                                            TextView textView14 = (TextView) view.findViewById(R.id.premium_settings_subscriptions_header);
                                                                                                                            if (textView14 != null) {
                                                                                                                                AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.premium_settings_view_flipper);
                                                                                                                                if (appViewFlipper != null) {
                                                                                                                                    View viewFindViewById7 = view.findViewById(R.id.premium_tier_1);
                                                                                                                                    if (viewFindViewById7 != null) {
                                                                                                                                        int i5 = R.id.premium_settings_premium_classic;
                                                                                                                                        MaterialButton materialButton3 = (MaterialButton) viewFindViewById7.findViewById(R.id.premium_settings_premium_classic);
                                                                                                                                        if (materialButton3 != null) {
                                                                                                                                            i5 = R.id.tier_1_guild_subscription_perk;
                                                                                                                                            TextView textView15 = (TextView) viewFindViewById7.findViewById(R.id.tier_1_guild_subscription_perk);
                                                                                                                                            if (textView15 != null) {
                                                                                                                                                i5 = R.id.tier1_upload_size_perk;
                                                                                                                                                TextView textView16 = (TextView) viewFindViewById7.findViewById(R.id.tier1_upload_size_perk);
                                                                                                                                                if (textView16 != null) {
                                                                                                                                                    ViewPremiumSettingsTier1Binding viewPremiumSettingsTier1Binding = new ViewPremiumSettingsTier1Binding((LinearLayout) viewFindViewById7, materialButton3, textView15, textView16);
                                                                                                                                                    View viewFindViewById8 = view.findViewById(R.id.premium_tier_2);
                                                                                                                                                    if (viewFindViewById8 != null) {
                                                                                                                                                        int i6 = R.id.premium_settings_nitro;
                                                                                                                                                        ImageView imageView = (ImageView) viewFindViewById8.findViewById(R.id.premium_settings_nitro);
                                                                                                                                                        if (imageView != null) {
                                                                                                                                                            i6 = R.id.premium_settings_nitro_wumpus;
                                                                                                                                                            ImageView imageView2 = (ImageView) viewFindViewById8.findViewById(R.id.premium_settings_nitro_wumpus);
                                                                                                                                                            if (imageView2 != null) {
                                                                                                                                                                i6 = R.id.premium_settings_premium;
                                                                                                                                                                MaterialButton materialButton4 = (MaterialButton) viewFindViewById8.findViewById(R.id.premium_settings_premium);
                                                                                                                                                                if (materialButton4 != null) {
                                                                                                                                                                    return new WidgetSettingsPremiumBinding((CoordinatorLayout) view, layoutAccountCreditsListBinding, layoutPremiumSettingsPaymentBinding, viewPremiumSettingsPerksBinding, activeSubscriptionView, activeSubscriptionView2, linearLayout2, textView9, textView10, textView11, widgetSettingsPremiumPriceChangeNoticeBinding, materialButton2, scrollView, button, cardView2, textView13, linearLayout3, textView14, appViewFlipper, viewPremiumSettingsTier1Binding, new ViewPremiumSettingsTier2Binding((LinearLayout) viewFindViewById8, imageView, imageView2, materialButton4));
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                        throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById8.getResources().getResourceName(i6)));
                                                                                                                                                    }
                                                                                                                                                    i2 = R.id.premium_tier_2;
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                        throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById7.getResources().getResourceName(i5)));
                                                                                                                                    }
                                                                                                                                    i2 = R.id.premium_tier_1;
                                                                                                                                } else {
                                                                                                                                    i2 = R.id.premium_settings_view_flipper;
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                i2 = R.id.premium_settings_subscriptions_header;
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            i2 = R.id.premium_settings_subscription_container;
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        i2 = R.id.premium_settings_status_notice_tv;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    i2 = R.id.premium_settings_status_notice_container;
                                                                                                                }
                                                                                                            } else {
                                                                                                                i2 = R.id.premium_settings_status_notice_button;
                                                                                                            }
                                                                                                        } else {
                                                                                                            i2 = R.id.premium_settings_scrollview;
                                                                                                        }
                                                                                                    } else {
                                                                                                        i2 = R.id.premium_settings_retry;
                                                                                                    }
                                                                                                } else {
                                                                                                    i2 = R.id.premium_settings_price_change_notice;
                                                                                                }
                                                                                            } else {
                                                                                                i2 = R.id.premium_settings_legalese;
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        i2 = R.id.premium_settings_credit_header;
                                                                                    }
                                                                                } else {
                                                                                    i2 = R.id.premium_settings_credit_container;
                                                                                }
                                                                            } else {
                                                                                i2 = R.id.premium_settings_active_subscription;
                                                                            }
                                                                        } else {
                                                                            i2 = R.id.premium_settings_active_guild_subscription;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById5.getResources().getResourceName(i4)));
                                                }
                                                i2 = R.id.premium_perks;
                                            }
                                        }
                                    }
                                }
                            }
                            throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById3.getResources().getResourceName(i3)));
                        }
                        i2 = R.id.payment;
                    } else {
                        i = R.id.credit_nitro_divider;
                    }
                } else {
                    i = R.id.credit_nitro_classic;
                }
            } else {
                i = R.id.credit_nitro;
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById.getResources().getResourceName(i)));
        }
        i2 = R.id.account_credits;
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }
}

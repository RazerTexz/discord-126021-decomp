package com.discord.widgets.settings.premium;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetSettingsPremiumBinding;
import com.discord.views.ActiveSubscriptionView;
import com.discord.views.premium.AccountCreditView;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.C0915a3;
import p007b.p008a.p025i.C0918a6;
import p007b.p008a.p025i.C0923b3;
import p007b.p008a.p025i.C0952f0;
import p007b.p008a.p025i.C1045s0;
import p007b.p008a.p025i.C1096z2;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsPremium.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsPremium$binding$2 extends C12236k implements Function1<View, WidgetSettingsPremiumBinding> {
    public static final WidgetSettingsPremium$binding$2 INSTANCE = new WidgetSettingsPremium$binding$2();

    public WidgetSettingsPremium$binding$2() {
        super(1, WidgetSettingsPremiumBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsPremiumBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsPremiumBinding invoke(View view) {
        int i;
        C12238m.checkNotNullParameter(view, "p1");
        View viewFindViewById = view.findViewById(C5419R.id.account_credits);
        int i2 = C5419R.id.premium_settings_grandfathered;
        if (viewFindViewById != null) {
            AccountCreditView accountCreditView = (AccountCreditView) viewFindViewById.findViewById(C5419R.id.credit_nitro);
            if (accountCreditView != null) {
                AccountCreditView accountCreditView2 = (AccountCreditView) viewFindViewById.findViewById(C5419R.id.credit_nitro_classic);
                if (accountCreditView2 != null) {
                    View viewFindViewById2 = viewFindViewById.findViewById(C5419R.id.credit_nitro_divider);
                    if (viewFindViewById2 != null) {
                        C0952f0 c0952f0 = new C0952f0((CardView) viewFindViewById, accountCreditView, accountCreditView2, viewFindViewById2);
                        View viewFindViewById3 = view.findViewById(C5419R.id.payment);
                        if (viewFindViewById3 != null) {
                            int i3 = C5419R.id.active_subscriptions_bottom_button;
                            MaterialButton materialButton = (MaterialButton) viewFindViewById3.findViewById(C5419R.id.active_subscriptions_bottom_button);
                            if (materialButton != null) {
                                i3 = C5419R.id.premium_settings_billing_divider;
                                View viewFindViewById4 = viewFindViewById3.findViewById(C5419R.id.premium_settings_billing_divider);
                                if (viewFindViewById4 != null) {
                                    i3 = C5419R.id.premium_settings_billing_information;
                                    TextView textView = (TextView) viewFindViewById3.findViewById(C5419R.id.premium_settings_billing_information);
                                    if (textView != null) {
                                        i3 = C5419R.id.premium_settings_google_play_manage;
                                        TextView textView2 = (TextView) viewFindViewById3.findViewById(C5419R.id.premium_settings_google_play_manage);
                                        if (textView2 != null) {
                                            LinearLayout linearLayout = (LinearLayout) viewFindViewById3;
                                            i3 = C5419R.id.premium_settings_payment_header;
                                            TextView textView3 = (TextView) viewFindViewById3.findViewById(C5419R.id.premium_settings_payment_header);
                                            if (textView3 != null) {
                                                C1045s0 c1045s0 = new C1045s0(linearLayout, materialButton, viewFindViewById4, textView, textView2, linearLayout, textView3);
                                                View viewFindViewById5 = view.findViewById(C5419R.id.premium_perks);
                                                if (viewFindViewById5 != null) {
                                                    int i4 = C5419R.id.guild_subscription_perk;
                                                    TextView textView4 = (TextView) viewFindViewById5.findViewById(C5419R.id.guild_subscription_perk);
                                                    if (textView4 != null) {
                                                        i4 = C5419R.id.identity_perk;
                                                        TextView textView5 = (TextView) viewFindViewById5.findViewById(C5419R.id.identity_perk);
                                                        if (textView5 != null) {
                                                            i4 = C5419R.id.max_guilds_perk;
                                                            TextView textView6 = (TextView) viewFindViewById5.findViewById(C5419R.id.max_guilds_perk);
                                                            if (textView6 != null) {
                                                                i4 = C5419R.id.max_message_length_perk;
                                                                TextView textView7 = (TextView) viewFindViewById5.findViewById(C5419R.id.max_message_length_perk);
                                                                if (textView7 != null) {
                                                                    i4 = C5419R.id.upload_size_perk;
                                                                    TextView textView8 = (TextView) viewFindViewById5.findViewById(C5419R.id.upload_size_perk);
                                                                    if (textView8 != null) {
                                                                        C1096z2 c1096z2 = new C1096z2((LinearLayout) viewFindViewById5, textView4, textView5, textView6, textView7, textView8);
                                                                        ActiveSubscriptionView activeSubscriptionView = (ActiveSubscriptionView) view.findViewById(C5419R.id.premium_settings_active_guild_subscription);
                                                                        if (activeSubscriptionView != null) {
                                                                            ActiveSubscriptionView activeSubscriptionView2 = (ActiveSubscriptionView) view.findViewById(C5419R.id.premium_settings_active_subscription);
                                                                            if (activeSubscriptionView2 != null) {
                                                                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(C5419R.id.premium_settings_credit_container);
                                                                                if (linearLayout2 != null) {
                                                                                    TextView textView9 = (TextView) view.findViewById(C5419R.id.premium_settings_credit_header);
                                                                                    if (textView9 != null) {
                                                                                        TextView textView10 = (TextView) view.findViewById(C5419R.id.premium_settings_grandfathered);
                                                                                        if (textView10 != null) {
                                                                                            TextView textView11 = (TextView) view.findViewById(C5419R.id.premium_settings_legalese);
                                                                                            if (textView11 != null) {
                                                                                                View viewFindViewById6 = view.findViewById(C5419R.id.premium_settings_price_change_notice);
                                                                                                if (viewFindViewById6 != null) {
                                                                                                    CardView cardView = (CardView) viewFindViewById6;
                                                                                                    TextView textView12 = (TextView) viewFindViewById6.findViewById(C5419R.id.textview);
                                                                                                    if (textView12 == null) {
                                                                                                        throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById6.getResources().getResourceName(C5419R.id.textview)));
                                                                                                    }
                                                                                                    C0918a6 c0918a6 = new C0918a6(cardView, cardView, textView12);
                                                                                                    MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.premium_settings_retry);
                                                                                                    if (materialButton2 != null) {
                                                                                                        ScrollView scrollView = (ScrollView) view.findViewById(C5419R.id.premium_settings_scrollview);
                                                                                                        if (scrollView != null) {
                                                                                                            Button button = (Button) view.findViewById(C5419R.id.premium_settings_status_notice_button);
                                                                                                            if (button != null) {
                                                                                                                CardView cardView2 = (CardView) view.findViewById(C5419R.id.premium_settings_status_notice_container);
                                                                                                                if (cardView2 != null) {
                                                                                                                    TextView textView13 = (TextView) view.findViewById(C5419R.id.premium_settings_status_notice_tv);
                                                                                                                    if (textView13 != null) {
                                                                                                                        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(C5419R.id.premium_settings_subscription_container);
                                                                                                                        if (linearLayout3 != null) {
                                                                                                                            TextView textView14 = (TextView) view.findViewById(C5419R.id.premium_settings_subscriptions_header);
                                                                                                                            if (textView14 != null) {
                                                                                                                                AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.premium_settings_view_flipper);
                                                                                                                                if (appViewFlipper != null) {
                                                                                                                                    View viewFindViewById7 = view.findViewById(C5419R.id.premium_tier_1);
                                                                                                                                    if (viewFindViewById7 != null) {
                                                                                                                                        int i5 = C5419R.id.premium_settings_premium_classic;
                                                                                                                                        MaterialButton materialButton3 = (MaterialButton) viewFindViewById7.findViewById(C5419R.id.premium_settings_premium_classic);
                                                                                                                                        if (materialButton3 != null) {
                                                                                                                                            i5 = C5419R.id.tier_1_guild_subscription_perk;
                                                                                                                                            TextView textView15 = (TextView) viewFindViewById7.findViewById(C5419R.id.tier_1_guild_subscription_perk);
                                                                                                                                            if (textView15 != null) {
                                                                                                                                                i5 = C5419R.id.tier1_upload_size_perk;
                                                                                                                                                TextView textView16 = (TextView) viewFindViewById7.findViewById(C5419R.id.tier1_upload_size_perk);
                                                                                                                                                if (textView16 != null) {
                                                                                                                                                    C0915a3 c0915a3 = new C0915a3((LinearLayout) viewFindViewById7, materialButton3, textView15, textView16);
                                                                                                                                                    View viewFindViewById8 = view.findViewById(C5419R.id.premium_tier_2);
                                                                                                                                                    if (viewFindViewById8 != null) {
                                                                                                                                                        int i6 = C5419R.id.premium_settings_nitro;
                                                                                                                                                        ImageView imageView = (ImageView) viewFindViewById8.findViewById(C5419R.id.premium_settings_nitro);
                                                                                                                                                        if (imageView != null) {
                                                                                                                                                            i6 = C5419R.id.premium_settings_nitro_wumpus;
                                                                                                                                                            ImageView imageView2 = (ImageView) viewFindViewById8.findViewById(C5419R.id.premium_settings_nitro_wumpus);
                                                                                                                                                            if (imageView2 != null) {
                                                                                                                                                                i6 = C5419R.id.premium_settings_premium;
                                                                                                                                                                MaterialButton materialButton4 = (MaterialButton) viewFindViewById8.findViewById(C5419R.id.premium_settings_premium);
                                                                                                                                                                if (materialButton4 != null) {
                                                                                                                                                                    return new WidgetSettingsPremiumBinding((CoordinatorLayout) view, c0952f0, c1045s0, c1096z2, activeSubscriptionView, activeSubscriptionView2, linearLayout2, textView9, textView10, textView11, c0918a6, materialButton2, scrollView, button, cardView2, textView13, linearLayout3, textView14, appViewFlipper, c0915a3, new C0923b3((LinearLayout) viewFindViewById8, imageView, imageView2, materialButton4));
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                        throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById8.getResources().getResourceName(i6)));
                                                                                                                                                    }
                                                                                                                                                    i2 = C5419R.id.premium_tier_2;
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                        throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById7.getResources().getResourceName(i5)));
                                                                                                                                    }
                                                                                                                                    i2 = C5419R.id.premium_tier_1;
                                                                                                                                } else {
                                                                                                                                    i2 = C5419R.id.premium_settings_view_flipper;
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                i2 = C5419R.id.premium_settings_subscriptions_header;
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            i2 = C5419R.id.premium_settings_subscription_container;
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        i2 = C5419R.id.premium_settings_status_notice_tv;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    i2 = C5419R.id.premium_settings_status_notice_container;
                                                                                                                }
                                                                                                            } else {
                                                                                                                i2 = C5419R.id.premium_settings_status_notice_button;
                                                                                                            }
                                                                                                        } else {
                                                                                                            i2 = C5419R.id.premium_settings_scrollview;
                                                                                                        }
                                                                                                    } else {
                                                                                                        i2 = C5419R.id.premium_settings_retry;
                                                                                                    }
                                                                                                } else {
                                                                                                    i2 = C5419R.id.premium_settings_price_change_notice;
                                                                                                }
                                                                                            } else {
                                                                                                i2 = C5419R.id.premium_settings_legalese;
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        i2 = C5419R.id.premium_settings_credit_header;
                                                                                    }
                                                                                } else {
                                                                                    i2 = C5419R.id.premium_settings_credit_container;
                                                                                }
                                                                            } else {
                                                                                i2 = C5419R.id.premium_settings_active_subscription;
                                                                            }
                                                                        } else {
                                                                            i2 = C5419R.id.premium_settings_active_guild_subscription;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById5.getResources().getResourceName(i4)));
                                                }
                                                i2 = C5419R.id.premium_perks;
                                            }
                                        }
                                    }
                                }
                            }
                            throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById3.getResources().getResourceName(i3)));
                        }
                        i2 = C5419R.id.payment;
                    } else {
                        i = C5419R.id.credit_nitro_divider;
                    }
                } else {
                    i = C5419R.id.credit_nitro_classic;
                }
            } else {
                i = C5419R.id.credit_nitro;
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById.getResources().getResourceName(i)));
        }
        i2 = C5419R.id.account_credits;
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }
}

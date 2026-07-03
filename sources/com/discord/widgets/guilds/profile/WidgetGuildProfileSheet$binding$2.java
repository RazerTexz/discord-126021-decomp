package com.discord.widgets.guilds.profile;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGuildProfileSheetBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildProfileSheet$binding$2 extends C12236k implements Function1<View, WidgetGuildProfileSheetBinding> {
    public static final WidgetGuildProfileSheet$binding$2 INSTANCE = new WidgetGuildProfileSheet$binding$2();

    public WidgetGuildProfileSheet$binding$2() {
        super(1, WidgetGuildProfileSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildProfileSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildProfileSheetBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.guild_profile_sheet_actions_top_barrier;
        Barrier barrier = (Barrier) view.findViewById(C5419R.id.guild_profile_sheet_actions_top_barrier);
        if (barrier != null) {
            i = C5419R.id.guild_profile_sheet_banner;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.guild_profile_sheet_banner);
            if (simpleDraweeView != null) {
                i = C5419R.id.guild_profile_sheet_boosts;
                MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.guild_profile_sheet_boosts);
                if (materialButton != null) {
                    i = C5419R.id.guild_profile_sheet_constraint_layout;
                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(C5419R.id.guild_profile_sheet_constraint_layout);
                    if (constraintLayout != null) {
                        i = C5419R.id.guild_profile_sheet_content_container;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.guild_profile_sheet_content_container);
                        if (linearLayout != null) {
                            i = C5419R.id.guild_profile_sheet_content_container_bottom_divider;
                            View viewFindViewById = view.findViewById(C5419R.id.guild_profile_sheet_content_container_bottom_divider);
                            if (viewFindViewById != null) {
                                i = C5419R.id.guild_profile_sheet_description;
                                TextView textView = (TextView) view.findViewById(C5419R.id.guild_profile_sheet_description);
                                if (textView != null) {
                                    i = C5419R.id.guild_profile_sheet_flipper;
                                    AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.guild_profile_sheet_flipper);
                                    if (appViewFlipper != null) {
                                        i = C5419R.id.guild_profile_sheet_guild_verified_premium_icon;
                                        ImageView imageView = (ImageView) view.findViewById(C5419R.id.guild_profile_sheet_guild_verified_premium_icon);
                                        if (imageView != null) {
                                            i = C5419R.id.guild_profile_sheet_icon;
                                            SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) view.findViewById(C5419R.id.guild_profile_sheet_icon);
                                            if (simpleDraweeView2 != null) {
                                                i = C5419R.id.guild_profile_sheet_icon_card;
                                                CardView cardView = (CardView) view.findViewById(C5419R.id.guild_profile_sheet_icon_card);
                                                if (cardView != null) {
                                                    i = C5419R.id.guild_profile_sheet_icon_name;
                                                    TextView textView2 = (TextView) view.findViewById(C5419R.id.guild_profile_sheet_icon_name);
                                                    if (textView2 != null) {
                                                        i = C5419R.id.guild_profile_sheet_invite;
                                                        MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.guild_profile_sheet_invite);
                                                        if (materialButton2 != null) {
                                                            i = C5419R.id.guild_profile_sheet_member_count;
                                                            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(C5419R.id.guild_profile_sheet_member_count);
                                                            if (linearLayout2 != null) {
                                                                i = C5419R.id.guild_profile_sheet_member_count_text;
                                                                TextView textView3 = (TextView) view.findViewById(C5419R.id.guild_profile_sheet_member_count_text);
                                                                if (textView3 != null) {
                                                                    i = C5419R.id.guild_profile_sheet_name;
                                                                    TextView textView4 = (TextView) view.findViewById(C5419R.id.guild_profile_sheet_name);
                                                                    if (textView4 != null) {
                                                                        i = C5419R.id.guild_profile_sheet_notifications;
                                                                        MaterialButton materialButton3 = (MaterialButton) view.findViewById(C5419R.id.guild_profile_sheet_notifications);
                                                                        if (materialButton3 != null) {
                                                                            i = C5419R.id.guild_profile_sheet_online_count;
                                                                            LinearLayout linearLayout3 = (LinearLayout) view.findViewById(C5419R.id.guild_profile_sheet_online_count);
                                                                            if (linearLayout3 != null) {
                                                                                i = C5419R.id.guild_profile_sheet_online_count_text;
                                                                                TextView textView5 = (TextView) view.findViewById(C5419R.id.guild_profile_sheet_online_count_text);
                                                                                if (textView5 != null) {
                                                                                    i = C5419R.id.guild_profile_sheet_settings;
                                                                                    MaterialButton materialButton4 = (MaterialButton) view.findViewById(C5419R.id.guild_profile_sheet_settings);
                                                                                    if (materialButton4 != null) {
                                                                                        i = C5419R.id.guild_profile_sheet_tab_items;
                                                                                        LinearLayout linearLayout4 = (LinearLayout) view.findViewById(C5419R.id.guild_profile_sheet_tab_items);
                                                                                        if (linearLayout4 != null) {
                                                                                            i = C5419R.id.widget_guild_hub_profile_actions;
                                                                                            ViewStub viewStub = (ViewStub) view.findViewById(C5419R.id.widget_guild_hub_profile_actions);
                                                                                            if (viewStub != null) {
                                                                                                i = C5419R.id.widget_guild_profile_actions;
                                                                                                ViewStub viewStub2 = (ViewStub) view.findViewById(C5419R.id.widget_guild_profile_actions);
                                                                                                if (viewStub2 != null) {
                                                                                                    return new WidgetGuildProfileSheetBinding((NestedScrollView) view, barrier, simpleDraweeView, materialButton, constraintLayout, linearLayout, viewFindViewById, textView, appViewFlipper, imageView, simpleDraweeView2, cardView, textView2, materialButton2, linearLayout2, textView3, textView4, materialButton3, linearLayout3, textView5, materialButton4, linearLayout4, viewStub, viewStub2);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

package com.discord.widgets.settings.guildboost;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetSettingsBoostBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.guildboost.GuildBoostMarketingView;
import com.discord.views.guildboost.GuildBoostSubscriptionUpsellView;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.C1055t3;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsGuildBoost$binding$2 extends C12236k implements Function1<View, WidgetSettingsBoostBinding> {
    public static final WidgetSettingsGuildBoost$binding$2 INSTANCE = new WidgetSettingsGuildBoost$binding$2();

    public WidgetSettingsGuildBoost$binding$2() {
        super(1, WidgetSettingsBoostBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsBoostBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsBoostBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.no_guilds;
        View viewFindViewById = view.findViewById(C5419R.id.no_guilds);
        if (viewFindViewById != null) {
            int i2 = C5419R.id.settings_boost_no_guilds_image;
            ImageView imageView = (ImageView) viewFindViewById.findViewById(C5419R.id.settings_boost_no_guilds_image);
            if (imageView != null) {
                i2 = C5419R.id.settings_boost_no_guilds_subtitle;
                TextView textView = (TextView) viewFindViewById.findViewById(C5419R.id.settings_boost_no_guilds_subtitle);
                if (textView != null) {
                    i2 = C5419R.id.settings_boost_no_guilds_title;
                    TextView textView2 = (TextView) viewFindViewById.findViewById(C5419R.id.settings_boost_no_guilds_title);
                    if (textView2 != null) {
                        C1055t3 c1055t3 = new C1055t3((LinearLayoutCompat) viewFindViewById, imageView, textView, textView2);
                        i = C5419R.id.settings_boost_flipper;
                        AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.settings_boost_flipper);
                        if (appViewFlipper != null) {
                            i = C5419R.id.settings_boost_marketing_view;
                            GuildBoostMarketingView guildBoostMarketingView = (GuildBoostMarketingView) view.findViewById(C5419R.id.settings_boost_marketing_view);
                            if (guildBoostMarketingView != null) {
                                i = C5419R.id.settings_boost_recycler;
                                RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.settings_boost_recycler);
                                if (recyclerView != null) {
                                    i = C5419R.id.settings_boost_retry;
                                    MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.settings_boost_retry);
                                    if (materialButton != null) {
                                        i = C5419R.id.settings_boost_sample_guilds;
                                        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(C5419R.id.settings_boost_sample_guilds);
                                        if (recyclerView2 != null) {
                                            i = C5419R.id.settings_boost_subtext;
                                            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.settings_boost_subtext);
                                            if (linkifiedTextView != null) {
                                                i = C5419R.id.settings_boost_subtext_container;
                                                LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.settings_boost_subtext_container);
                                                if (linearLayout != null) {
                                                    i = C5419R.id.settings_boost_upsell_view;
                                                    GuildBoostSubscriptionUpsellView guildBoostSubscriptionUpsellView = (GuildBoostSubscriptionUpsellView) view.findViewById(C5419R.id.settings_boost_upsell_view);
                                                    if (guildBoostSubscriptionUpsellView != null) {
                                                        return new WidgetSettingsBoostBinding((CoordinatorLayout) view, c1055t3, appViewFlipper, guildBoostMarketingView, recyclerView, materialButton, recyclerView2, linkifiedTextView, linearLayout, guildBoostSubscriptionUpsellView);
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
            throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById.getResources().getResourceName(i2)));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

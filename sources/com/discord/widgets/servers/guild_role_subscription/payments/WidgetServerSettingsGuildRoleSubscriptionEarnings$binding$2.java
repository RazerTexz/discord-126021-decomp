package com.discord.widgets.servers.guild_role_subscription.payments;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.ViewServerSettingsGuildRoleSubscriptionUnavailableNoticeBinding;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEarnings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsGuildRoleSubscriptionEarnings$binding$2 extends C12236k implements Function1<View, ViewServerSettingsGuildRoleSubscriptionUnavailableNoticeBinding> {
    public static final WidgetServerSettingsGuildRoleSubscriptionEarnings$binding$2 INSTANCE = new WidgetServerSettingsGuildRoleSubscriptionEarnings$binding$2();

    public WidgetServerSettingsGuildRoleSubscriptionEarnings$binding$2() {
        super(1, ViewServerSettingsGuildRoleSubscriptionUnavailableNoticeBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ViewServerSettingsGuildRoleSubscriptionUnavailableNoticeBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ViewServerSettingsGuildRoleSubscriptionUnavailableNoticeBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.action_bar_toolbar;
        Toolbar toolbar = (Toolbar) view.findViewById(C5419R.id.action_bar_toolbar);
        if (toolbar != null) {
            i = C5419R.id.app_bar_layout;
            AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(C5419R.id.app_bar_layout);
            if (appBarLayout != null) {
                i = C5419R.id.art;
                ImageView imageView = (ImageView) view.findViewById(C5419R.id.art);
                if (imageView != null) {
                    i = C5419R.id.description;
                    TextView textView = (TextView) view.findViewById(C5419R.id.description);
                    if (textView != null) {
                        i = C5419R.id.title;
                        TextView textView2 = (TextView) view.findViewById(C5419R.id.title);
                        if (textView2 != null) {
                            return new ViewServerSettingsGuildRoleSubscriptionUnavailableNoticeBinding((ConstraintLayout) view, toolbar, appBarLayout, imageView, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

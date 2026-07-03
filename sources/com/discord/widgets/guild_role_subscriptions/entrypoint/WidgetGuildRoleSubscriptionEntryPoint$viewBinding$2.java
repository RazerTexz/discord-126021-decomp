package com.discord.widgets.guild_role_subscriptions.entrypoint;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetGuildRoleSubscriptionEntryPointBinding;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPoint.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildRoleSubscriptionEntryPoint$viewBinding$2 extends C12236k implements Function1<View, WidgetGuildRoleSubscriptionEntryPointBinding> {
    public static final WidgetGuildRoleSubscriptionEntryPoint$viewBinding$2 INSTANCE = new WidgetGuildRoleSubscriptionEntryPoint$viewBinding$2();

    public WidgetGuildRoleSubscriptionEntryPoint$viewBinding$2() {
        super(1, WidgetGuildRoleSubscriptionEntryPointBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildRoleSubscriptionEntryPointBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildRoleSubscriptionEntryPointBinding invoke(View view) {
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
                            return new WidgetGuildRoleSubscriptionEntryPointBinding((ConstraintLayout) view, toolbar, appBarLayout, imageView, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

package com.discord.widgets.guild_role_subscriptions.entrypoint;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetGuildRoleSubscriptionEntryPointBinding;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPoint.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildRoleSubscriptionEntryPoint$viewBinding$2 extends k implements Function1<View, WidgetGuildRoleSubscriptionEntryPointBinding> {
    public static final WidgetGuildRoleSubscriptionEntryPoint$viewBinding$2 INSTANCE = new WidgetGuildRoleSubscriptionEntryPoint$viewBinding$2();

    public WidgetGuildRoleSubscriptionEntryPoint$viewBinding$2() {
        super(1, WidgetGuildRoleSubscriptionEntryPointBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildRoleSubscriptionEntryPointBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildRoleSubscriptionEntryPointBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildRoleSubscriptionEntryPointBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = 2131361878;
        Toolbar toolbar = (Toolbar) view.findViewById(2131361878);
        if (toolbar != null) {
            i = R$id.app_bar_layout;
            AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R$id.app_bar_layout);
            if (appBarLayout != null) {
                i = R$id.art;
                ImageView imageView = (ImageView) view.findViewById(R$id.art);
                if (imageView != null) {
                    i = R$id.description;
                    TextView textView = (TextView) view.findViewById(R$id.description);
                    if (textView != null) {
                        i = 2131365869;
                        TextView textView2 = (TextView) view.findViewById(2131365869);
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

package com.discord.widgets.servers.guild_role_subscription.payments;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.databinding.ViewServerSettingsGuildRoleSubscriptionUnavailableNoticeBinding;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEarnings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsGuildRoleSubscriptionEarnings$binding$2 extends k implements Function1<View, ViewServerSettingsGuildRoleSubscriptionUnavailableNoticeBinding> {
    public static final WidgetServerSettingsGuildRoleSubscriptionEarnings$binding$2 INSTANCE = new WidgetServerSettingsGuildRoleSubscriptionEarnings$binding$2();

    public WidgetServerSettingsGuildRoleSubscriptionEarnings$binding$2() {
        super(1, ViewServerSettingsGuildRoleSubscriptionUnavailableNoticeBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ViewServerSettingsGuildRoleSubscriptionUnavailableNoticeBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ViewServerSettingsGuildRoleSubscriptionUnavailableNoticeBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ViewServerSettingsGuildRoleSubscriptionUnavailableNoticeBinding invoke2(View view) {
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
                            return new ViewServerSettingsGuildRoleSubscriptionUnavailableNoticeBinding((ConstraintLayout) view, toolbar, appBarLayout, imageView, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

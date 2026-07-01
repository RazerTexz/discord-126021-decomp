package com.discord.widgets.servers.guild_role_subscription.payments;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.ViewServerSettingsGuildRoleSubscriptionUnavailableNoticeBinding;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.payments.WidgetServerSettingsGuildRoleSubscriptionEarnings$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEarnings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsGuildRoleSubscriptionEarnings2 extends FunctionReferenceImpl implements Function1<View, ViewServerSettingsGuildRoleSubscriptionUnavailableNoticeBinding> {
    public static final WidgetServerSettingsGuildRoleSubscriptionEarnings2 INSTANCE = new WidgetServerSettingsGuildRoleSubscriptionEarnings2();

    public WidgetServerSettingsGuildRoleSubscriptionEarnings2() {
        super(1, ViewServerSettingsGuildRoleSubscriptionUnavailableNoticeBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ViewServerSettingsGuildRoleSubscriptionUnavailableNoticeBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ViewServerSettingsGuildRoleSubscriptionUnavailableNoticeBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.action_bar_toolbar;
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.action_bar_toolbar);
        if (toolbar != null) {
            i = R.id.app_bar_layout;
            AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.app_bar_layout);
            if (appBarLayout != null) {
                i = R.id.art;
                ImageView imageView = (ImageView) view.findViewById(R.id.art);
                if (imageView != null) {
                    i = R.id.description;
                    TextView textView = (TextView) view.findViewById(R.id.description);
                    if (textView != null) {
                        i = R.id.title;
                        TextView textView2 = (TextView) view.findViewById(R.id.title);
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

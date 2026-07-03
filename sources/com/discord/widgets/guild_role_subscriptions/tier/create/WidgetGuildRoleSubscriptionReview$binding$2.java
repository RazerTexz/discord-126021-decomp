package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetGuildRoleSubscriptionTierReviewBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionReview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildRoleSubscriptionReview$binding$2 extends C12236k implements Function1<View, WidgetGuildRoleSubscriptionTierReviewBinding> {
    public static final WidgetGuildRoleSubscriptionReview$binding$2 INSTANCE = new WidgetGuildRoleSubscriptionReview$binding$2();

    public WidgetGuildRoleSubscriptionReview$binding$2() {
        super(1, WidgetGuildRoleSubscriptionTierReviewBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierReviewBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildRoleSubscriptionTierReviewBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.subscription_tier_review_recycler);
        if (recyclerView != null) {
            return new WidgetGuildRoleSubscriptionTierReviewBinding((LinearLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.subscription_tier_review_recycler)));
    }
}

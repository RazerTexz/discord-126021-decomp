package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.content.Intent;
import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.discord.app.AppFragment;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefit$onViewBound$5 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefit this$0;

    public WidgetGuildRoleSubscriptionTierBenefit$onViewBound$5(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        this.this$0 = widgetGuildRoleSubscriptionTierBenefit;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
        Intent intent = new Intent();
        intent.putExtra("RESULT_EXTRA_EXISTING_BENEFIT", WidgetGuildRoleSubscriptionTierBenefit.access$getExistingBenefit$p(this.this$0));
        fragmentActivityRequireActivity.setResult(-1, intent);
        AppFragment.hideKeyboard$default(this.this$0, null, 1, null);
        fragmentActivityRequireActivity.finish();
    }
}

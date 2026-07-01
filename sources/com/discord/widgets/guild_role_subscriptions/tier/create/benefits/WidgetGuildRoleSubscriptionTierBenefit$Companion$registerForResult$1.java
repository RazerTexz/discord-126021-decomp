package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import d0.z.d.m;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefit$Companion$registerForResult$1<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ Function2 $onBenefitUpdate;

    public WidgetGuildRoleSubscriptionTierBenefit$Companion$registerForResult$1(Function2 function2) {
        this.$onBenefitUpdate = function2;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
    }

    /* JADX INFO: renamed from: onActivityResult, reason: avoid collision after fix types in other method */
    public final void onActivityResult2(ActivityResult activityResult) {
        m.checkNotNullExpressionValue(activityResult, "activityResult");
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            Benefit benefit = data != null ? (Benefit) data.getParcelableExtra("RESULT_EXTRA_BENEFIT") : null;
            Intent data2 = activityResult.getData();
            Benefit benefit2 = data2 != null ? (Benefit) data2.getParcelableExtra("RESULT_EXTRA_EXISTING_BENEFIT") : null;
            if (benefit == null && benefit2 == null) {
                return;
            }
            this.$onBenefitUpdate.invoke(benefit2, benefit);
        }
    }
}

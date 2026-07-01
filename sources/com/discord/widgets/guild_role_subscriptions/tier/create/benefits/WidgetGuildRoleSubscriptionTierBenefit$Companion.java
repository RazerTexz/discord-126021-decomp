package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import b.a.d.j;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.app.AppFragment;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefit$Companion {
    private WidgetGuildRoleSubscriptionTierBenefit$Companion() {
    }

    public static /* synthetic */ void launch$default(WidgetGuildRoleSubscriptionTierBenefit$Companion widgetGuildRoleSubscriptionTierBenefit$Companion, Context context, ActivityResultLauncher activityResultLauncher, long j, GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType, String str, Benefit benefit, int i, Object obj) {
        widgetGuildRoleSubscriptionTierBenefit$Companion.launch(context, activityResultLauncher, j, guildRoleSubscriptionBenefitType, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : benefit);
    }

    public final void launch(Context context, ActivityResultLauncher<Intent> launcher, long guildId, GuildRoleSubscriptionBenefitType benefitType, String tierName, Benefit benefit) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(launcher, "launcher");
        m.checkNotNullParameter(benefitType, "benefitType");
        j jVar = j.g;
        Intent intent = new Intent();
        intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        intent.putExtra("INTENT_EXTRA_EXISTING_BENEFIT", benefit);
        intent.putExtra("INTENT_EXTRA_BENEFIT_TYPE", benefitType);
        intent.putExtra("INTENT_EXTRA_TIER_NAME", tierName);
        jVar.f(context, launcher, WidgetGuildRoleSubscriptionTierBenefit.class, intent);
    }

    public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function2<? super Benefit, ? super Benefit, Unit> onBenefitUpdate) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(onBenefitUpdate, "onBenefitUpdate");
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new WidgetGuildRoleSubscriptionTierBenefit$Companion$registerForResult$1(onBenefitUpdate));
        m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…  }\n          }\n        }");
        return activityResultLauncherRegisterForActivityResult;
    }

    public /* synthetic */ WidgetGuildRoleSubscriptionTierBenefit$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

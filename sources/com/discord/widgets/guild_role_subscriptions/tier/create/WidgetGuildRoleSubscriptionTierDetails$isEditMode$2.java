package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.os.Bundle;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierDetails$isEditMode$2 extends o implements Function0<Boolean> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierDetails this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierDetails$isEditMode$2(WidgetGuildRoleSubscriptionTierDetails widgetGuildRoleSubscriptionTierDetails) {
        super(0);
        this.this$0 = widgetGuildRoleSubscriptionTierDetails;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        Bundle arguments = this.this$0.getArguments();
        if (arguments != null) {
            return arguments.getBoolean("INTENT_IS_EDIT_MODE", false);
        }
        return false;
    }
}

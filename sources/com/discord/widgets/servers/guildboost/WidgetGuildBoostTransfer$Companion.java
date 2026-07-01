package com.discord.widgets.servers.guildboost;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelGuildBoostSlot;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildBoostTransfer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildBoostTransfer$Companion {
    private WidgetGuildBoostTransfer$Companion() {
    }

    public static /* synthetic */ void create$default(WidgetGuildBoostTransfer$Companion widgetGuildBoostTransfer$Companion, Context context, long j, long j2, ModelGuildBoostSlot modelGuildBoostSlot, int i, Object obj) {
        if ((i & 8) != 0) {
            modelGuildBoostSlot = null;
        }
        widgetGuildBoostTransfer$Companion.create(context, j, j2, modelGuildBoostSlot);
    }

    public final void create(Context context, long previousGuildId, long targetGuildId, ModelGuildBoostSlot slot) {
        ModelAppliedGuildBoost premiumGuildSubscription;
        m.checkNotNullParameter(context, "context");
        Long lValueOf = null;
        Intent intentPutExtra = new Intent().putExtra("PREVIOUS_GUILD_ID", previousGuildId).putExtra("TARGET_GUILD_ID", targetGuildId).putExtra("SLOT_ID", slot != null ? Long.valueOf(slot.getId()) : null);
        if (slot != null && (premiumGuildSubscription = slot.getPremiumGuildSubscription()) != null) {
            lValueOf = Long.valueOf(premiumGuildSubscription.getId());
        }
        Intent intentPutExtra2 = intentPutExtra.putExtra("SUBSCRIPTION_ID", lValueOf);
        m.checkNotNullExpressionValue(intentPutExtra2, "Intent()\n          .putE…iumGuildSubscription?.id)");
        j.d(context, WidgetGuildBoostTransfer.class, intentPutExtra2);
    }

    public /* synthetic */ WidgetGuildBoostTransfer$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

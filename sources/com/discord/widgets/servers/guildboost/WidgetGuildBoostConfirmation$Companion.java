package com.discord.widgets.servers.guildboost;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildBoostConfirmation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildBoostConfirmation$Companion {
    private WidgetGuildBoostConfirmation$Companion() {
    }

    public final void create(Context context, long guildId, long slotId) {
        m.checkNotNullParameter(context, "context");
        Intent intentPutExtra = new Intent().putExtra("GUILD_ID", guildId).putExtra("SLOT_ID", slotId);
        m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…NT_EXTRA_SLOT_ID, slotId)");
        j.d(context, WidgetGuildBoostConfirmation.class, intentPutExtra);
    }

    public /* synthetic */ WidgetGuildBoostConfirmation$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

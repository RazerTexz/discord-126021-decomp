package com.discord.widgets.settings.premium;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.premium.BlockRussianPurchasesUtils;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetSettingsGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGifting$Companion {
    private WidgetSettingsGifting$Companion() {
    }

    public static /* synthetic */ void launch$default(WidgetSettingsGifting$Companion widgetSettingsGifting$Companion, Context context, Traits$Location traits$Location, int i, Object obj) {
        if ((i & 2) != 0) {
            traits$Location = null;
        }
        widgetSettingsGifting$Companion.launch(context, traits$Location);
    }

    public final void launch(Context context, Traits$Location location) {
        m.checkNotNullParameter(context, "context");
        if (BlockRussianPurchasesUtils.Companion.getINSTANCE().showDialog()) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("com.discord.intent.extra.EXTRA_LOCATION", location);
        j.d(context, WidgetSettingsGifting.class, intent);
    }

    public /* synthetic */ WidgetSettingsGifting$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

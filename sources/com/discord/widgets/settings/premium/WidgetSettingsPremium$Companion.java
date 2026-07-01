package com.discord.widgets.settings.premium;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.stores.StoreStream;
import com.discord.utilities.premium.BlockRussianPurchasesUtils;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetSettingsPremium.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPremium$Companion {
    private WidgetSettingsPremium$Companion() {
    }

    public static /* synthetic */ void launch$default(WidgetSettingsPremium$Companion widgetSettingsPremium$Companion, Context context, Integer num, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        widgetSettingsPremium$Companion.launch(context, num, str);
    }

    public final void launch(Context context, Integer scrollToSection, String locationSection) {
        m.checkNotNullParameter(context, "context");
        if (BlockRussianPurchasesUtils.Companion.getINSTANCE().showDialog()) {
            return;
        }
        StoreStream.Companion.getAnalytics().onUserSettingsPaneViewed("Discord Nitro", locationSection);
        j.d(context, WidgetSettingsPremium.class, new Intent().putExtra("intent_section", scrollToSection).putExtra("analytics_location_section", locationSection));
    }

    public /* synthetic */ WidgetSettingsPremium$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

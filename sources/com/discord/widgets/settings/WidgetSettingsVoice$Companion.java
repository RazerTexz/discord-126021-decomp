package com.discord.widgets.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Build$VERSION;
import android.provider.Settings;
import androidx.annotation.IdRes;
import b.a.d.j;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetSettingsVoice.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsVoice$Companion {
    private WidgetSettingsVoice$Companion() {
    }

    public static final /* synthetic */ boolean access$hasOverlayPermission(WidgetSettingsVoice$Companion widgetSettingsVoice$Companion, Context context) {
        return widgetSettingsVoice$Companion.hasOverlayPermission(context);
    }

    private final boolean hasOverlayPermission(Context context) {
        return Build$VERSION.SDK_INT <= 22 || Settings.canDrawOverlays(context);
    }

    public static /* synthetic */ void launch$default(WidgetSettingsVoice$Companion widgetSettingsVoice$Companion, Context context, Integer num, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        widgetSettingsVoice$Companion.launch(context, num, z2);
    }

    public final void launch(Context context, @IdRes Integer targetResId, boolean isTargetAutoToggle) {
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        if (targetResId != null) {
            intent.putExtra("ARG_TARGET_RES_ID", targetResId.intValue());
        }
        if (isTargetAutoToggle) {
            intent.putExtra("ARG_TARGET_AUTO_TOGGLE", isTargetAutoToggle);
        }
        j.d(context, WidgetSettingsVoice.class, intent);
        StoreAnalytics.onUserSettingsPaneViewed$default(StoreStream.Companion.getAnalytics(), "Voice & Video", null, 2, null);
    }

    public /* synthetic */ WidgetSettingsVoice$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

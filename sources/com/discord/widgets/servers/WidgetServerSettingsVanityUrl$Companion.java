package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import b.a.d.j;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsVanityUrl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsVanityUrl$Companion {
    private WidgetServerSettingsVanityUrl$Companion() {
    }

    public static final /* synthetic */ void access$translateLeft(WidgetServerSettingsVanityUrl$Companion widgetServerSettingsVanityUrl$Companion, View view, int i) {
        widgetServerSettingsVanityUrl$Companion.translateLeft(view, i);
    }

    public static final /* synthetic */ void access$translateToOriginX(WidgetServerSettingsVanityUrl$Companion widgetServerSettingsVanityUrl$Companion, View view) {
        widgetServerSettingsVanityUrl$Companion.translateToOriginX(view);
    }

    private final void translateLeft(View view, int i) {
        view.animate().translationXBy(-i).setDuration(250L).setInterpolator(new AccelerateDecelerateInterpolator()).start();
    }

    private final void translateToOriginX(View view) {
        view.animate().translationX(0.0f).setDuration(250L).setInterpolator(new AccelerateDecelerateInterpolator()).start();
    }

    public final void create(Context context, long guildId) {
        m.checkNotNullParameter(context, "context");
        StoreStream.Companion.getAnalytics().onGuildSettingsPaneViewed("VANITY_URL", guildId);
        Intent intentPutExtra = new Intent().putExtra(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, guildId);
        m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_EXTRA_GUILD_ID, guildId)");
        j.d(context, WidgetServerSettingsVanityUrl.class, intentPutExtra);
    }

    public /* synthetic */ WidgetServerSettingsVanityUrl$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

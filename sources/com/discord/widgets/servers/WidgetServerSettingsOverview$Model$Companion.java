package com.discord.widgets.servers;

import android.content.Context;
import android.content.res.Resources;
import com.discord.R$plurals;
import com.discord.stores.StoreStream;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsOverview$Model$Companion {
    private WidgetServerSettingsOverview$Model$Companion() {
    }

    public final Observable<WidgetServerSettingsOverview$Model> get(long guildId) {
        Observable<R> observableY = StoreStream.Companion.getGuilds().observeGuild(guildId).Y(new WidgetServerSettingsOverview$Model$Companion$get$1(guildId));
        m.checkNotNullExpressionValue(observableY, "StoreStream\n            …        }\n              }");
        Observable<WidgetServerSettingsOverview$Model> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
        m.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
        return observableR;
    }

    public final CharSequence getAfkTimeout(Context context, int afkTimeout) {
        m.checkNotNullParameter(context, "context");
        if (afkTimeout == 60) {
            Resources resources = context.getResources();
            m.checkNotNullExpressionValue(resources, "context.resources");
            return StringResourceUtilsKt.getQuantityString(resources, context, R$plurals.duration_minutes_minutes, 1, 1);
        }
        if (afkTimeout == 300) {
            Resources resources2 = context.getResources();
            m.checkNotNullExpressionValue(resources2, "context.resources");
            return StringResourceUtilsKt.getQuantityString(resources2, context, R$plurals.duration_minutes_minutes, 5, 5);
        }
        if (afkTimeout == 900) {
            Resources resources3 = context.getResources();
            m.checkNotNullExpressionValue(resources3, "context.resources");
            return StringResourceUtilsKt.getQuantityString(resources3, context, R$plurals.duration_minutes_minutes, 15, 15);
        }
        if (afkTimeout == 1800) {
            Resources resources4 = context.getResources();
            m.checkNotNullExpressionValue(resources4, "context.resources");
            return StringResourceUtilsKt.getQuantityString(resources4, context, R$plurals.duration_minutes_minutes, 30, 30);
        }
        if (afkTimeout != 3600) {
            return "";
        }
        Resources resources5 = context.getResources();
        m.checkNotNullExpressionValue(resources5, "context.resources");
        return StringResourceUtilsKt.getQuantityString(resources5, context, R$plurals.duration_hours_hours, 1, 1);
    }

    public /* synthetic */ WidgetServerSettingsOverview$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

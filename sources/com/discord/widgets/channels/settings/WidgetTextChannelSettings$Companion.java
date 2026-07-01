package com.discord.widgets.channels.settings;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import b.a.d.j;
import com.discord.utilities.resources.DurationUnit;
import com.discord.utilities.resources.DurationUtilsKt;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextChannelSettings$Companion {
    private WidgetTextChannelSettings$Companion() {
    }

    public static /* synthetic */ void setDurationSecondsLabel$default(WidgetTextChannelSettings$Companion widgetTextChannelSettings$Companion, TextView textView, int i, Context context, int i2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            i2 = 2131889270;
        }
        widgetTextChannelSettings$Companion.setDurationSecondsLabel(textView, i, context, i2);
    }

    public final List<Integer> getSLOWMODE_COOLDOWN_VALUES() {
        return WidgetTextChannelSettings.access$getSLOWMODE_COOLDOWN_VALUES$cp();
    }

    public final void launch(long channelId, Context context) {
        m.checkNotNullParameter(context, "context");
        Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
        m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…RA_CHANNEL_ID, channelId)");
        j.d(context, WidgetTextChannelSettings.class, intentPutExtra);
    }

    public final void setDurationSecondsLabel(TextView textView, int seconds, Context context, int zeroLabel) {
        m.checkNotNullParameter(textView, "textView");
        m.checkNotNullParameter(context, "context");
        if (seconds == 0) {
            textView.setText(context.getString(zeroLabel));
            return;
        }
        if (1 <= seconds && 60 > seconds) {
            DurationUtilsKt.setDurationText(textView, DurationUnit.SECONDS, seconds);
            return;
        }
        if (60 <= seconds && 3600 > seconds) {
            DurationUtilsKt.setDurationText(textView, DurationUnit.MINS, seconds / 60);
        } else if (3600 <= seconds && 86400 > seconds) {
            DurationUtilsKt.setDurationText(textView, DurationUnit.HOURS, seconds / 3600);
        } else {
            DurationUtilsKt.setDurationText(textView, DurationUnit.DAYS, seconds / 86400);
        }
    }

    public /* synthetic */ WidgetTextChannelSettings$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

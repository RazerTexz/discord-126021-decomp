package com.discord.widgets.voice.fullscreen;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import androidx.core.app.ActivityOptionsCompat;
import com.discord.app.AppActivity$Call;
import com.discord.app.AppTransitionActivity$Transition;
import com.discord.utilities.device.DeviceUtils;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$Companion {
    private WidgetCallFullscreen$Companion() {
    }

    public static /* synthetic */ void launch$default(WidgetCallFullscreen$Companion widgetCallFullscreen$Companion, Context context, long j, boolean z2, String str, AppTransitionActivity$Transition appTransitionActivity$Transition, int i, Object obj) {
        widgetCallFullscreen$Companion.launch(context, j, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : appTransitionActivity$Transition);
    }

    public final int getUnreadIndicatorMarginDp(Resources resources) {
        m.checkNotNullParameter(resources, "resources");
        if (resources.getConfiguration().orientation != 2) {
            return DeviceUtils.INSTANCE.isTablet(resources) ? 36 : 32;
        }
        return DeviceUtils.INSTANCE.isTablet(resources) ? 36 : 28;
    }

    public final int getUnreadIndicatorMarginLeftDp(Resources resources) {
        m.checkNotNullParameter(resources, "resources");
        if (resources.getConfiguration().orientation != 2) {
            if (DeviceUtils.INSTANCE.isTablet(resources)) {
                return 40;
            }
        } else if (DeviceUtils.INSTANCE.isTablet(resources)) {
            return 40;
        }
        return 32;
    }

    public final void launch(Context context, long channelId, boolean connectOnLaunch, String streamKey, AppTransitionActivity$Transition transition) {
        ActivityOptionsCompat activityOptions;
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, (Class<?>) AppActivity$Call.class);
        intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
        intent.putExtra("com.discord.intent.extra.EXTRA_STREAM_KEY", streamKey);
        intent.putExtra("INTENT_EXTRA_CONNECT_ON_LAUNCH", connectOnLaunch);
        context.startActivity(intent, (transition == null || (activityOptions = transition.toActivityOptions(context)) == null) ? null : activityOptions.toBundle());
    }

    public /* synthetic */ WidgetCallFullscreen$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

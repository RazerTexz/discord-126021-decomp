package com.discord.widgets.voice.fullscreen;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.app.AppTransitionActivity$Transition;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallPreviewFullscreen$Companion {
    private WidgetCallPreviewFullscreen$Companion() {
    }

    public static /* synthetic */ void launch$default(WidgetCallPreviewFullscreen$Companion widgetCallPreviewFullscreen$Companion, Context context, long j, AppTransitionActivity$Transition appTransitionActivity$Transition, int i, Object obj) {
        if ((i & 4) != 0) {
            appTransitionActivity$Transition = null;
        }
        widgetCallPreviewFullscreen$Companion.launch(context, j, appTransitionActivity$Transition);
    }

    public final void launch(Context context, long channelId, AppTransitionActivity$Transition transition) {
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, (Class<?>) WidgetCallFullscreen.class);
        intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
        intent.putExtra("transition", transition);
        j.d(context, WidgetCallPreviewFullscreen.class, intent);
    }

    public /* synthetic */ WidgetCallPreviewFullscreen$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

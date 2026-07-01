package com.discord.widgets.voice.fullscreen;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetStartCallSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetStartCallSheet$Companion {
    private WidgetStartCallSheet$Companion() {
    }

    public final void show(long voiceChannelId, FragmentManager fragmentManager) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetStartCallSheet widgetStartCallSheet = new WidgetStartCallSheet();
        Bundle bundle = new Bundle();
        bundle.putLong("ARG_VOICE_CHANNEL_ID", voiceChannelId);
        widgetStartCallSheet.setArguments(bundle);
        widgetStartCallSheet.show(fragmentManager, WidgetStartCallSheet.class.getName());
    }

    public /* synthetic */ WidgetStartCallSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

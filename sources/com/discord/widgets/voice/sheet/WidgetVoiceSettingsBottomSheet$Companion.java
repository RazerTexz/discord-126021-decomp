package com.discord.widgets.voice.sheet;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceSettingsBottomSheet$Companion {
    private WidgetVoiceSettingsBottomSheet$Companion() {
    }

    public static /* synthetic */ void show$default(WidgetVoiceSettingsBottomSheet$Companion widgetVoiceSettingsBottomSheet$Companion, Long l, FragmentManager fragmentManager, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        widgetVoiceSettingsBottomSheet$Companion.show(l, fragmentManager);
    }

    public final void show(Long channelId, FragmentManager fragmentManager) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetVoiceSettingsBottomSheet widgetVoiceSettingsBottomSheet = new WidgetVoiceSettingsBottomSheet();
        Bundle bundle = new Bundle();
        if (channelId != null) {
            bundle.putLong("ARG_CHANNEL_ID", channelId.longValue());
        }
        widgetVoiceSettingsBottomSheet.setArguments(bundle);
        widgetVoiceSettingsBottomSheet.show(fragmentManager, WidgetVoiceSettingsBottomSheet.class.getName());
    }

    public /* synthetic */ WidgetVoiceSettingsBottomSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

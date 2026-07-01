package com.discord.widgets.voice.sheet;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceBottomSheet$Companion {
    private WidgetVoiceBottomSheet$Companion() {
    }

    public final WidgetVoiceBottomSheet show(FragmentManager fragmentManager, long channelId, boolean forwardToFullscreenIfVideoActivated, WidgetVoiceBottomSheet$FeatureContext featureContext) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(featureContext, "featureContext");
        WidgetVoiceBottomSheet widgetVoiceBottomSheet = new WidgetVoiceBottomSheet();
        Bundle bundle = new Bundle();
        bundle.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
        bundle.putSerializable("ARG_FEATURE_CONTEXT", featureContext);
        bundle.putBoolean("ARG_FORWARD_TO_FULLSCREEN_IF_VIDEO_ACTIVATED", forwardToFullscreenIfVideoActivated);
        widgetVoiceBottomSheet.setArguments(bundle);
        widgetVoiceBottomSheet.show(fragmentManager, WidgetVoiceBottomSheet.class.getSimpleName());
        return widgetVoiceBottomSheet;
    }

    public /* synthetic */ WidgetVoiceBottomSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

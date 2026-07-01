package com.discord.widgets.channels.list;

import android.content.Context;
import androidx.annotation.ColorInt;
import com.discord.utilities.color.ColorCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemChannelStageVoice$Companion {
    private WidgetChannelsListAdapter$ItemChannelStageVoice$Companion() {
    }

    public static final /* synthetic */ int access$getVoiceChannelColor(WidgetChannelsListAdapter$ItemChannelStageVoice$Companion widgetChannelsListAdapter$ItemChannelStageVoice$Companion, boolean z2, Context context) {
        return widgetChannelsListAdapter$ItemChannelStageVoice$Companion.getVoiceChannelColor(z2, context);
    }

    @ColorInt
    private final int getVoiceChannelColor(boolean isSelected, Context context) {
        return isSelected ? ColorCompat.getThemedColor(context, 2130969005) : ColorCompat.getThemedColor(context, 2130968965);
    }

    public /* synthetic */ WidgetChannelsListAdapter$ItemChannelStageVoice$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

package com.discord.widgets.channels;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelPickerBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelPickerBottomSheet$Companion {
    private WidgetChannelPickerBottomSheet$Companion() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void launch$default(WidgetChannelPickerBottomSheet$Companion widgetChannelPickerBottomSheet$Companion, Fragment fragment, String str, long j, Long l, Function0 function0, boolean z2, int i, Object obj) {
        widgetChannelPickerBottomSheet$Companion.launch(fragment, str, j, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : function0, (i & 32) != 0 ? false : z2);
    }

    public final void launch(Fragment fragment, String requestKey, long guildId, Long selectedChannelId, Function0<Unit> onCancel, boolean hideAnnouncementChannels) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(requestKey, "requestKey");
        WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet = new WidgetChannelPickerBottomSheet();
        Bundle bundle = new Bundle();
        bundle.putString("INTENT_EXTRA_REQUEST_CODE", requestKey);
        bundle.putLong("ARG_CHANNEL_PICKER_GUILD_ID", guildId);
        bundle.putBoolean("ARG_HIDE_ANNOUNCEMENT_CHANNELS", hideAnnouncementChannels);
        if (selectedChannelId != null) {
            bundle.putLong("ARG_SELECTED_CHANNEL_ID", selectedChannelId.longValue());
        }
        widgetChannelPickerBottomSheet.setArguments(bundle);
        widgetChannelPickerBottomSheet.setOnCancel(onCancel);
        FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
        widgetChannelPickerBottomSheet.show(parentFragmentManager, WidgetChannelPickerBottomSheet.class.getName());
    }

    public final void registerForResult(Fragment fragment, String requestKey, Function3<? super Long, ? super String, ? super Integer, Unit> onChannelSelected, Function0<Unit> onCreateChannelSelected) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(requestKey, "requestKey");
        m.checkNotNullParameter(onChannelSelected, "onChannelSelected");
        m.checkNotNullParameter(onCreateChannelSelected, "onCreateChannelSelected");
        FragmentKt.setFragmentResultListener(fragment, requestKey, new WidgetChannelPickerBottomSheet$Companion$registerForResult$1(requestKey, onCreateChannelSelected, onChannelSelected));
    }

    public /* synthetic */ WidgetChannelPickerBottomSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

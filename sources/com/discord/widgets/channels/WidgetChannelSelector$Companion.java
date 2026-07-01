package com.discord.widgets.channels;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSelector$Companion {
    private WidgetChannelSelector$Companion() {
    }

    public static /* synthetic */ void launch$default(WidgetChannelSelector$Companion widgetChannelSelector$Companion, Fragment fragment, long j, String str, boolean z2, int i, WidgetChannelSelector$FilterFunction widgetChannelSelector$FilterFunction, int i2, Object obj) {
        widgetChannelSelector$Companion.launch(fragment, j, str, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? 2131893305 : i, (i2 & 32) != 0 ? null : widgetChannelSelector$FilterFunction);
    }

    public static /* synthetic */ void launchForInactiveStages$default(WidgetChannelSelector$Companion widgetChannelSelector$Companion, Fragment fragment, long j, String str, boolean z2, int i, int i2, Object obj) {
        widgetChannelSelector$Companion.launchForInactiveStages(fragment, j, str, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? 2131893305 : i);
    }

    public static /* synthetic */ void launchForText$default(WidgetChannelSelector$Companion widgetChannelSelector$Companion, Fragment fragment, long j, String str, boolean z2, int i, int i2, Object obj) {
        widgetChannelSelector$Companion.launchForText(fragment, j, str, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? 2131893305 : i);
    }

    public static /* synthetic */ void launchForVocal$default(WidgetChannelSelector$Companion widgetChannelSelector$Companion, Fragment fragment, long j, String str, boolean z2, int i, int i2, Object obj) {
        widgetChannelSelector$Companion.launchForVocal(fragment, j, str, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? 2131893305 : i);
    }

    public static /* synthetic */ void launchForVoice$default(WidgetChannelSelector$Companion widgetChannelSelector$Companion, Fragment fragment, long j, String str, boolean z2, int i, int i2, Object obj) {
        widgetChannelSelector$Companion.launchForVoice(fragment, j, str, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? 2131893305 : i);
    }

    public static /* synthetic */ void registerForResult$default(WidgetChannelSelector$Companion widgetChannelSelector$Companion, Fragment fragment, String str, boolean z2, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        widgetChannelSelector$Companion.registerForResult(fragment, str, z2, function2);
    }

    public final void launch(Fragment fragment, long guildId, String requestKey, boolean includeNoChannel, int noChannelStringId, WidgetChannelSelector$FilterFunction filterFunction) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(requestKey, "requestKey");
        WidgetChannelSelector widgetChannelSelector = new WidgetChannelSelector();
        Bundle bundle = new Bundle();
        bundle.putString("INTENT_EXTRA_REQUEST_CODE", requestKey);
        bundle.putLong(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, guildId);
        bundle.putBoolean("INTENT_EXTRA_INCLUDE_NO_CHANNEL", includeNoChannel);
        bundle.putInt("INTENT_EXTRA_NO_CHANNEL_STRING_ID", noChannelStringId);
        bundle.putSerializable("INTENT_EXTRA_FILTER_FUNCTION", filterFunction);
        widgetChannelSelector.setArguments(bundle);
        FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
        widgetChannelSelector.show(parentFragmentManager, WidgetChannelSelector.class.getName());
    }

    public final void launchForInactiveStages(Fragment fragment, long guildId, String requestKey, boolean includeNoChannel, int noChannelStringId) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(requestKey, "requestKey");
        launch(fragment, guildId, requestKey, includeNoChannel, noChannelStringId, WidgetChannelSelector$InactiveStageChannelFilterFunction.INSTANCE);
    }

    public final void launchForText(Fragment fragment, long guildId, String requestKey, boolean includeNoChannel, int noChannelStringId) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(requestKey, "requestKey");
        launch(fragment, guildId, requestKey, includeNoChannel, noChannelStringId, new WidgetChannelSelector$TypeFilterFunction(0));
    }

    public final void launchForVocal(Fragment fragment, long guildId, String requestKey, boolean includeNoChannel, int noChannelStringId) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(requestKey, "requestKey");
        launch(fragment, guildId, requestKey, includeNoChannel, noChannelStringId, WidgetChannelSelector$VocalChannelFilterFunction.INSTANCE);
    }

    public final void launchForVoice(Fragment fragment, long guildId, String requestKey, boolean includeNoChannel, int noChannelStringId) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(requestKey, "requestKey");
        launch(fragment, guildId, requestKey, includeNoChannel, noChannelStringId, new WidgetChannelSelector$TypeFilterFunction(2));
    }

    public final void registerForResult(Fragment fragment, String requestKey, boolean allowNullChannel, Function2<? super Long, ? super String, Unit> onChannelSelected) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(requestKey, "requestKey");
        m.checkNotNullParameter(onChannelSelected, "onChannelSelected");
        FragmentKt.setFragmentResultListener(fragment, requestKey, new WidgetChannelSelector$Companion$registerForResult$1(requestKey, allowNullChannel, onChannelSelected));
    }

    public /* synthetic */ WidgetChannelSelector$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

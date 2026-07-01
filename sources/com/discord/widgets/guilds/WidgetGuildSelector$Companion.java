package com.discord.widgets.guilds;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildSelector$Companion {
    private WidgetGuildSelector$Companion() {
    }

    public static /* synthetic */ void launch$default(WidgetGuildSelector$Companion widgetGuildSelector$Companion, Fragment fragment, String str, boolean z2, int i, WidgetGuildSelector$FilterFunction widgetGuildSelector$FilterFunction, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "GUILD_SELECTOR_DEFAULT_REQUEST_KEY";
        }
        String str2 = str;
        boolean z3 = (i2 & 4) != 0 ? false : z2;
        int i3 = (i2 & 8) != 0 ? 2131893305 : i;
        if ((i2 & 16) != 0) {
            widgetGuildSelector$FilterFunction = null;
        }
        widgetGuildSelector$Companion.launch(fragment, str2, z3, i3, widgetGuildSelector$FilterFunction);
    }

    public static /* synthetic */ void registerForResult$default(WidgetGuildSelector$Companion widgetGuildSelector$Companion, Fragment fragment, String str, boolean z2, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "GUILD_SELECTOR_DEFAULT_REQUEST_KEY";
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        widgetGuildSelector$Companion.registerForResult(fragment, str, z2, function2);
    }

    public final void launch(Fragment fragment, String requestKey, boolean includeNoGuild, int noGuildStringId, WidgetGuildSelector$FilterFunction filterFunction) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(requestKey, "requestKey");
        WidgetGuildSelector widgetGuildSelector = new WidgetGuildSelector();
        Bundle bundle = new Bundle();
        bundle.putString("INTENT_EXTRA_REQUEST_CODE", requestKey);
        bundle.putBoolean("INTENT_EXTRA_INCLUDE_NO_GUILD", includeNoGuild);
        bundle.putInt("INTENT_EXTRA_NO_GUILD_STRING_ID", noGuildStringId);
        bundle.putSerializable("INTENT_EXTRA_FILTER_FUNCTION", filterFunction);
        widgetGuildSelector.setArguments(bundle);
        FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
        widgetGuildSelector.show(parentFragmentManager, WidgetGuildSelector.class.getName());
    }

    public final void registerForResult(Fragment fragment, String requestKey, boolean allowNullGuild, Function2<? super Long, ? super String, Unit> onGuildSelected) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(requestKey, "requestKey");
        m.checkNotNullParameter(onGuildSelected, "onGuildSelected");
        FragmentKt.setFragmentResultListener(fragment, requestKey, new WidgetGuildSelector$Companion$registerForResult$1(requestKey, allowNullGuild, onGuildSelected));
    }

    public /* synthetic */ WidgetGuildSelector$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

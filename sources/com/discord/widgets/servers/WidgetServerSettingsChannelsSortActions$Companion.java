package com.discord.widgets.servers;

import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsChannelsSortActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsChannelsSortActions$Companion {
    private WidgetServerSettingsChannelsSortActions$Companion() {
    }

    public final void show(FragmentManager fragmentManager, Function1<? super Integer, Unit> sortTypeSelectedListener) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(sortTypeSelectedListener, "sortTypeSelectedListener");
        WidgetServerSettingsChannelsSortActions widgetServerSettingsChannelsSortActions = new WidgetServerSettingsChannelsSortActions();
        widgetServerSettingsChannelsSortActions.setSortTypeSelectedListener(sortTypeSelectedListener);
        widgetServerSettingsChannelsSortActions.show(fragmentManager, "javaClass");
    }

    public /* synthetic */ WidgetServerSettingsChannelsSortActions$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

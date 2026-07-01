package com.discord.widgets.settings.connections;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetSettingsUserConnectionsAdd.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnectionsAdd$Companion {
    private WidgetSettingsUserConnectionsAdd$Companion() {
    }

    public final void show(Fragment fragment) {
        m.checkNotNullParameter(fragment, "fragment");
        WidgetSettingsUserConnectionsAdd widgetSettingsUserConnectionsAdd = new WidgetSettingsUserConnectionsAdd();
        FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
        widgetSettingsUserConnectionsAdd.show(parentFragmentManager, "javaClass");
    }

    public /* synthetic */ WidgetSettingsUserConnectionsAdd$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

package com.discord.widgets.user;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetUserStatusSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserStatusSheet$Companion {
    private WidgetUserStatusSheet$Companion() {
    }

    public final void show(Fragment fragment) {
        m.checkNotNullParameter(fragment, "fragment");
        WidgetUserStatusSheet widgetUserStatusSheet = new WidgetUserStatusSheet();
        FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
        widgetUserStatusSheet.show(parentFragmentManager, "javaClass");
    }

    public /* synthetic */ WidgetUserStatusSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

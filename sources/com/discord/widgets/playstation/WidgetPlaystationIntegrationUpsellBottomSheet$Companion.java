package com.discord.widgets.playstation;

import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetPlaystationIntegrationUpsellBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPlaystationIntegrationUpsellBottomSheet$Companion {
    private WidgetPlaystationIntegrationUpsellBottomSheet$Companion() {
    }

    public final void show(FragmentManager fragmentManager) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        new WidgetPlaystationIntegrationUpsellBottomSheet().show(fragmentManager, WidgetPlaystationIntegrationUpsellBottomSheet.class.getSimpleName());
    }

    public /* synthetic */ WidgetPlaystationIntegrationUpsellBottomSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

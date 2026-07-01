package com.discord.widgets.hubs;

import androidx.fragment.app.FragmentManager;
import b.c.a.a0.d;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetHubAddServerConfirmationDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddServerConfirmationDialog$Companion {
    private WidgetHubAddServerConfirmationDialog$Companion() {
    }

    public final WidgetHubAddServerConfirmationDialog show(FragmentManager fragmentManager, AddServerConfirmationArgs args) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(args, "args");
        WidgetHubAddServerConfirmationDialog widgetHubAddServerConfirmationDialog = new WidgetHubAddServerConfirmationDialog();
        widgetHubAddServerConfirmationDialog.setArguments(d.e2(args));
        widgetHubAddServerConfirmationDialog.show(fragmentManager, a0.getOrCreateKotlinClass(WidgetHubAddServerConfirmationDialog.class).toString());
        return widgetHubAddServerConfirmationDialog;
    }

    public /* synthetic */ WidgetHubAddServerConfirmationDialog$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

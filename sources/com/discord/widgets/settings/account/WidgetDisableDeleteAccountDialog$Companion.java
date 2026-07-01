package com.discord.widgets.settings.account;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetDisableDeleteAccountDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDisableDeleteAccountDialog$Companion {
    private WidgetDisableDeleteAccountDialog$Companion() {
    }

    public final void show(FragmentManager fragmentManager, WidgetDisableDeleteAccountDialog$Mode mode) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(mode, "mode");
        WidgetDisableDeleteAccountDialog widgetDisableDeleteAccountDialog = new WidgetDisableDeleteAccountDialog();
        Bundle bundle = new Bundle();
        bundle.putInt("extra_mode", mode.ordinal());
        widgetDisableDeleteAccountDialog.setArguments(bundle);
        String tag = widgetDisableDeleteAccountDialog.getTag();
        if (tag == null) {
            tag = "";
        }
        widgetDisableDeleteAccountDialog.show(fragmentManager, tag);
    }

    public /* synthetic */ WidgetDisableDeleteAccountDialog$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

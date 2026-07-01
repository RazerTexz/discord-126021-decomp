package com.discord.widgets.settings.account;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetEnableSMSBackupDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableSMSBackupDialog$Companion {
    private WidgetEnableSMSBackupDialog$Companion() {
    }

    public final void show(FragmentManager fragmentManager, boolean enable) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetEnableSMSBackupDialog widgetEnableSMSBackupDialog = new WidgetEnableSMSBackupDialog();
        Bundle bundle = new Bundle();
        bundle.putBoolean("extra_enable", enable);
        widgetEnableSMSBackupDialog.setArguments(bundle);
        String tag = widgetEnableSMSBackupDialog.getTag();
        if (tag == null) {
            tag = "";
        }
        widgetEnableSMSBackupDialog.show(fragmentManager, tag);
    }

    public /* synthetic */ WidgetEnableSMSBackupDialog$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

package com.discord.widgets.settings.account.mfa;

import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetEnableMFAKey.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableMFAKey$Companion {
    private WidgetEnableMFAKey$Companion() {
    }

    public static final /* synthetic */ boolean access$isPackageInstalled(WidgetEnableMFAKey$Companion widgetEnableMFAKey$Companion, String str, PackageManager packageManager) {
        return widgetEnableMFAKey$Companion.isPackageInstalled(str, packageManager);
    }

    private final boolean isPackageInstalled(String packageName, PackageManager packageManager) {
        try {
            packageManager.getPackageInfo(packageName, 0);
            return true;
        } catch (PackageManager$NameNotFoundException unused) {
            return false;
        }
    }

    public /* synthetic */ WidgetEnableMFAKey$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

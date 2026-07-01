package com.discord.widgets.settings.account;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetSettingsAccountEmailEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountEmailEdit$Companion {
    private WidgetSettingsAccountEmailEdit$Companion() {
    }

    public final void launch(Context context, boolean shouldConfirmEmail) {
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("extra_should_confirm_email", shouldConfirmEmail);
        j.d(context, WidgetSettingsAccountEmailEdit.class, intent);
    }

    public /* synthetic */ WidgetSettingsAccountEmailEdit$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

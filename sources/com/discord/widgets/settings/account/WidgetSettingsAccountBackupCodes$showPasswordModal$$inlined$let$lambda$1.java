package com.discord.widgets.settings.account;

import android.content.Context;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetSettingsAccountBackupCodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountBackupCodes$showPasswordModal$$inlined$let$lambda$1 extends o implements Function2<Context, String, Unit> {
    public final /* synthetic */ WidgetSettingsAccountBackupCodes this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccountBackupCodes$showPasswordModal$$inlined$let$lambda$1(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        super(2);
        this.this$0 = widgetSettingsAccountBackupCodes;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Context context, String str) {
        invoke2(context, str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Context context, String str) {
        m.checkNotNullParameter(context, "<anonymous parameter 0>");
        m.checkNotNullParameter(str, "newPassword");
        WidgetSettingsAccountBackupCodes.access$setPassword$p(this.this$0, str);
        WidgetSettingsAccountBackupCodes.access$sendVerificationKey(this.this$0);
    }
}

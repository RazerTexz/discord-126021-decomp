package com.discord.widgets.settings.account;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes$showPasswordModal$$inlined$let$lambda$1 */
/* JADX INFO: compiled from: WidgetSettingsAccountBackupCodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C9738x1d9e6125 extends AbstractC12240o implements Function2<Context, String, Unit> {
    public final /* synthetic */ WidgetSettingsAccountBackupCodes this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9738x1d9e6125(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        super(2);
        this.this$0 = widgetSettingsAccountBackupCodes;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Context context, String str) {
        invoke2(context, str);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Context context, String str) {
        C12238m.checkNotNullParameter(context, "<anonymous parameter 0>");
        C12238m.checkNotNullParameter(str, "newPassword");
        this.this$0.password = str;
        this.this$0.sendVerificationKey();
    }
}

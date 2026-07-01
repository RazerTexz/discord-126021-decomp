package com.discord.widgets.settings.account;

import android.content.Context;
import com.discord.api.auth.mfa.DisableMfaRequestBody;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetSettingsAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccount$showRemove2FAModal$1 extends o implements Function2<Context, String, Unit> {
    public final /* synthetic */ WidgetSettingsAccount this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccount$showRemove2FAModal$1(WidgetSettingsAccount widgetSettingsAccount) {
        super(2);
        this.this$0 = widgetSettingsAccount;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Context context, String str) {
        invoke2(context, str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Context context, String str) {
        m.checkNotNullParameter(context, "<anonymous parameter 0>");
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(RestAPI.Companion.getApi().disableMFA(new DisableMfaRequestBody(str)), this.this$0, null, 2, null), WidgetSettingsAccount.access$getBinding$p(this.this$0).f2591b, 0L, 2, null), false, 1, null), WidgetSettingsAccount.class, this.this$0.requireContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsAccount$showRemove2FAModal$1$1(this), 60, (Object) null);
    }
}

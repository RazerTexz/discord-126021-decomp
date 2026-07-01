package com.discord.widgets.settings.account;

import android.content.Context;
import android.view.View;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEnableSMSBackupDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableSMSBackupDialog$enableSMSBackup$1 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ WidgetEnableSMSBackupDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEnableSMSBackupDialog$enableSMSBackup$1(WidgetEnableSMSBackupDialog widgetEnableSMSBackupDialog) {
        super(1);
        this.this$0 = widgetEnableSMSBackupDialog;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        WidgetEnableSMSBackupDialog.access$getBinding$p(this.this$0).d.setIsLoading(false);
        View view = this.this$0.getView();
        Context context = view != null ? view.getContext() : null;
        Error$Response response = error.getResponse();
        m.checkNotNullExpressionValue(response, "it.response");
        b.a.d.m.h(context, response.getMessage(), 0, null, 12);
    }
}

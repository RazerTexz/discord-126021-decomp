package com.discord.widgets.settings.account;

import android.content.Context;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetDisableDeleteAccountDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDisableDeleteAccountDialog$onDisableClicked$1 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ WidgetDisableDeleteAccountDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDisableDeleteAccountDialog$onDisableClicked$1(WidgetDisableDeleteAccountDialog widgetDisableDeleteAccountDialog) {
        super(1);
        this.this$0 = widgetDisableDeleteAccountDialog;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        WidgetDisableDeleteAccountDialog.access$getBinding$p(this.this$0).e.setIsLoading(false);
        Error$Response response = error.getResponse();
        m.checkNotNullExpressionValue(response, "it.response");
        int code = response.getCode();
        if (code == 50018) {
            TextInputLayout textInputLayout = WidgetDisableDeleteAccountDialog.access$getBinding$p(this.this$0).g;
            m.checkNotNullExpressionValue(textInputLayout, "binding.disableDeletePasswordWrap");
            Error$Response response2 = error.getResponse();
            m.checkNotNullExpressionValue(response2, "it.response");
            textInputLayout.setError(response2.getMessage());
            return;
        }
        if (code != 60008) {
            Context context = this.this$0.getContext();
            Error$Response response3 = error.getResponse();
            m.checkNotNullExpressionValue(response3, "it.response");
            b.a.d.m.h(context, response3.getMessage(), 0, null, 12);
            return;
        }
        TextInputLayout textInputLayout2 = WidgetDisableDeleteAccountDialog.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.disableDeleteCodeWrap");
        Error$Response response4 = error.getResponse();
        m.checkNotNullExpressionValue(response4, "it.response");
        textInputLayout2.setError(response4.getMessage());
    }
}

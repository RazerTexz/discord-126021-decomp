package com.discord.widgets.auth;

import com.discord.app.AppActivity;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import d0.t.g0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2Authorize$onViewBoundOrOnResume$1 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ WidgetOauth2Authorize this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetOauth2Authorize$onViewBoundOrOnResume$1(WidgetOauth2Authorize widgetOauth2Authorize) {
        super(1);
        this.this$0 = widgetOauth2Authorize;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) throws Exception {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) throws Exception {
        m.checkNotNullParameter(error, "error");
        Error$Response response = error.getResponse();
        m.checkNotNullExpressionValue(response, "error.response");
        Map<String, List<String>> messages = response.getMessages();
        m.checkNotNullExpressionValue(messages, "it");
        if (!(!messages.isEmpty())) {
            messages = null;
        }
        if (messages == null) {
            Error$Response response2 = error.getResponse();
            m.checkNotNullExpressionValue(response2, "error.response");
            messages = g0.mapOf(d0.o.to("_root", d0.t.m.listOf(response2.getMessage())));
        }
        error.setShowErrorToasts(!WidgetOauth2Authorize.access$getValidationManager$p(this.this$0).setErrors(messages).isEmpty());
        AppActivity appActivity = this.this$0.getAppActivity();
        if (appActivity != null) {
            appActivity.onBackPressed();
        }
    }
}

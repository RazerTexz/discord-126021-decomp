package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.discord.utilities.view.validators.ValidationManager;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2Authorize$authorizeApplication$1 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ WidgetOauth2Authorize this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetOauth2Authorize$authorizeApplication$1(WidgetOauth2Authorize widgetOauth2Authorize) {
        super(1);
        this.this$0 = widgetOauth2Authorize;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "error");
        WidgetAuthCaptcha$Companion widgetAuthCaptcha$Companion = WidgetAuthCaptcha.Companion;
        Context contextRequireContext = this.this$0.requireContext();
        ActivityResultLauncher<Intent> captchaLauncher = this.this$0.getCaptchaLauncher();
        ValidationManager validationManagerAccess$getValidationManager$p = WidgetOauth2Authorize.access$getValidationManager$p(this.this$0);
        Error$Response response = error.getResponse();
        m.checkNotNullExpressionValue(response, "error.response");
        Map<String, List<String>> messages = response.getMessages();
        m.checkNotNullExpressionValue(messages, "error.response.messages");
        widgetAuthCaptcha$Companion.processErrorsForCaptcha(contextRequireContext, captchaLauncher, u.toMutableList((Collection) validationManagerAccess$getValidationManager$p.setErrors(messages)), error);
    }
}

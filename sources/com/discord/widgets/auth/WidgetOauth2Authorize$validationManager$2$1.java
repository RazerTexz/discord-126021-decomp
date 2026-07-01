package com.discord.widgets.auth;

import android.view.View;
import b.a.d.m;
import b.a.k.b;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.InputValidator;

/* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2Authorize$validationManager$2$1 extends Input<View> {
    public final /* synthetic */ WidgetOauth2Authorize$validationManager$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetOauth2Authorize$validationManager$2$1(WidgetOauth2Authorize$validationManager$2 widgetOauth2Authorize$validationManager$2, String str, View view, InputValidator[] inputValidatorArr) {
        super(str, view, inputValidatorArr);
        this.this$0 = widgetOauth2Authorize$validationManager$2;
    }

    @Override // com.discord.utilities.view.validators.Input
    public boolean setErrorMessage(CharSequence errorMessage) {
        if (errorMessage == null) {
            return false;
        }
        m.h(getView().getContext(), b.l(errorMessage, new Object[0], null, 2), 1, null, 8);
        return true;
    }
}

package com.discord.widgets.auth;

import android.view.View;
import b.a.d.m;
import b.a.k.b;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.InputValidator;
import d0.g0.s;
import d0.g0.w;
import d0.t.u;

/* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2Authorize$validationManager$2$2 extends Input<View> {
    public final /* synthetic */ WidgetOauth2Authorize$validationManager$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetOauth2Authorize$validationManager$2$2(WidgetOauth2Authorize$validationManager$2 widgetOauth2Authorize$validationManager$2, String str, View view, InputValidator[] inputValidatorArr) {
        super(str, view, inputValidatorArr);
        this.this$0 = widgetOauth2Authorize$validationManager$2;
    }

    @Override // com.discord.utilities.view.validators.Input
    public boolean setErrorMessage(CharSequence errorMessage) {
        if (errorMessage == null) {
            return false;
        }
        Integer intOrNull = s.toIntOrNull(errorMessage.toString());
        String string = (String) u.getOrNull(w.split$default((CharSequence) this.this$0.this$0.getOauth2ViewModel().getOauthAuthorize().getScope(), new char[]{' '}, false, 0, 6, (Object) null), intOrNull != null ? intOrNull.intValue() : -1);
        if (string == null) {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            sb.append(errorMessage);
            sb.append(']');
            string = sb.toString();
        }
        m.h(getView().getContext(), b.j(getView(), 2131893490, new Object[]{string}, null, 4), 1, null, 8);
        return true;
    }
}

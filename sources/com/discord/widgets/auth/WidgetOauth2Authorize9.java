package com.discord.widgets.auth;

import android.view.View;
import android.widget.LinearLayout;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import d0.g0.StringNumberConversions;
import d0.g0.Strings4;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$validationManager$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2Authorize9 extends Lambda implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetOauth2Authorize this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetOauth2Authorize9(WidgetOauth2Authorize widgetOauth2Authorize) {
        super(0);
        this.this$0 = widgetOauth2Authorize;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        LinearLayout linearLayout = this.this$0.getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.oauthAuthorizeLoading");
        LinearLayout linearLayout2 = this.this$0.getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.oauthAuthorizeLoading");
        return new ValidationManager(new Input<View>("_root", linearLayout, new InputValidator[0]) { // from class: com.discord.widgets.auth.WidgetOauth2Authorize$validationManager$2.1
            @Override // com.discord.utilities.view.validators.Input
            public boolean setErrorMessage(CharSequence errorMessage) {
                if (errorMessage == null) {
                    return false;
                }
                AppToast.h(getView().getContext(), FormatUtils.g(errorMessage, new Object[0], (2 & 2) != 0 ? FormatUtils.e.j : null), 1, null, 8);
                return true;
            }
        }, new Input<View>("scope", linearLayout2, new InputValidator[0]) { // from class: com.discord.widgets.auth.WidgetOauth2Authorize$validationManager$2.2
            @Override // com.discord.utilities.view.validators.Input
            public boolean setErrorMessage(CharSequence errorMessage) {
                if (errorMessage == null) {
                    return false;
                }
                Integer intOrNull = StringNumberConversions.toIntOrNull(errorMessage.toString());
                String string = (String) _Collections.getOrNull(Strings4.split$default((CharSequence) WidgetOauth2Authorize9.this.this$0.getOauth2ViewModel().getOauthAuthorize().getScope(), new char[]{' '}, false, 0, 6, (Object) null), intOrNull != null ? intOrNull.intValue() : -1);
                if (string == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append('[');
                    sb.append(errorMessage);
                    sb.append(']');
                    string = sb.toString();
                }
                AppToast.h(getView().getContext(), FormatUtils.d(getView(), R.string.oauth2_request_invalid_scope, new Object[]{string}, (4 & 4) != 0 ? FormatUtils.c.j : null), 1, null, 8);
                return true;
            }
        });
    }
}

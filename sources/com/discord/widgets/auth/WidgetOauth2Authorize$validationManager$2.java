package com.discord.widgets.auth;

import android.view.View;
import android.widget.LinearLayout;
import com.discord.C5419R;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import kotlin.jvm.functions.Function0;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p507d0.p579g0.C12102s;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2Authorize$validationManager$2 extends AbstractC12240o implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetOauth2Authorize this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetOauth2Authorize$validationManager$2(WidgetOauth2Authorize widgetOauth2Authorize) {
        super(0);
        this.this$0 = widgetOauth2Authorize;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        LinearLayout linearLayout = this.this$0.getBinding().f17336h;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.oauthAuthorizeLoading");
        LinearLayout linearLayout2 = this.this$0.getBinding().f17336h;
        C12238m.checkNotNullExpressionValue(linearLayout2, "binding.oauthAuthorizeLoading");
        return new ValidationManager(new Input<View>("_root", linearLayout, new InputValidator[0]) { // from class: com.discord.widgets.auth.WidgetOauth2Authorize$validationManager$2.1
            @Override // com.discord.utilities.view.validators.Input
            public boolean setErrorMessage(CharSequence errorMessage) {
                if (errorMessage == null) {
                    return false;
                }
                C0876m.m170h(getView().getContext(), C1107b.m215g(errorMessage, new Object[0], (2 & 2) != 0 ? C1107b.e.f1494j : null), 1, null, 8);
                return true;
            }
        }, new Input<View>("scope", linearLayout2, new InputValidator[0]) { // from class: com.discord.widgets.auth.WidgetOauth2Authorize$validationManager$2.2
            @Override // com.discord.utilities.view.validators.Input
            public boolean setErrorMessage(CharSequence errorMessage) {
                if (errorMessage == null) {
                    return false;
                }
                Integer intOrNull = C12102s.toIntOrNull(errorMessage.toString());
                String string = (String) C12163u.getOrNull(C12106w.split$default((CharSequence) WidgetOauth2Authorize$validationManager$2.this.this$0.getOauth2ViewModel().getOauthAuthorize().getScope(), new char[]{' '}, false, 0, 6, (Object) null), intOrNull != null ? intOrNull.intValue() : -1);
                if (string == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append('[');
                    sb.append(errorMessage);
                    sb.append(']');
                    string = sb.toString();
                }
                C0876m.m170h(getView().getContext(), C1107b.m212d(getView(), C5419R.string.oauth2_request_invalid_scope, new Object[]{string}, (4 & 4) != 0 ? C1107b.c.f1492j : null), 1, null, 8);
                return true;
            }
        });
    }
}

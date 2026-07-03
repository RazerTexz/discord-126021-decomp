package com.discord.widgets.hubs;

import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.view.validators.ValidationManager;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubEmailFlow.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEmailFlow$validationManager$2 extends AbstractC12240o implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetHubEmailFlow this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEmailFlow$validationManager$2(WidgetHubEmailFlow widgetHubEmailFlow) {
        super(0);
        this.this$0 = widgetHubEmailFlow;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        AuthUtils authUtils = AuthUtils.INSTANCE;
        TextInputLayout textInputLayout = this.this$0.getBinding().f17175c.f820d;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.discordHubEmailI…scriptionEmailInputLayout");
        return authUtils.createEmailValidationManager(textInputLayout);
    }
}

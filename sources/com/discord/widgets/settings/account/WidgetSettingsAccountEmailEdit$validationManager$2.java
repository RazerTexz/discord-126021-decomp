package com.discord.widgets.settings.account;

import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.view.validators.ValidationManager;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsAccountEmailEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountEmailEdit$validationManager$2 extends AbstractC12240o implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetSettingsAccountEmailEdit this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccountEmailEdit$validationManager$2(WidgetSettingsAccountEmailEdit widgetSettingsAccountEmailEdit) {
        super(0);
        this.this$0 = widgetSettingsAccountEmailEdit;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        AuthUtils authUtils = AuthUtils.INSTANCE;
        TextInputLayout textInputLayout = this.this$0.getBinding().f17837d;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.editAccountEmailWrap");
        return authUtils.createEmailValidationManager(textInputLayout);
    }
}

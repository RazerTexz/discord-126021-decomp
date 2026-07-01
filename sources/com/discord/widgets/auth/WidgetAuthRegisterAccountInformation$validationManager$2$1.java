package com.discord.widgets.auth;

import android.widget.CheckBox;
import com.discord.utilities.view.validators.InputValidator;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetAuthRegisterAccountInformation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthRegisterAccountInformation$validationManager$2$1 implements InputValidator<CheckBox> {
    public final /* synthetic */ WidgetAuthRegisterAccountInformation$validationManager$2 this$0;

    public WidgetAuthRegisterAccountInformation$validationManager$2$1(WidgetAuthRegisterAccountInformation$validationManager$2 widgetAuthRegisterAccountInformation$validationManager$2) {
        this.this$0 = widgetAuthRegisterAccountInformation$validationManager$2;
    }

    @Override // com.discord.utilities.view.validators.InputValidator
    public /* bridge */ /* synthetic */ CharSequence getErrorMessage(CheckBox checkBox) {
        return getErrorMessage2(checkBox);
    }

    /* JADX INFO: renamed from: getErrorMessage, reason: avoid collision after fix types in other method */
    public CharSequence getErrorMessage2(CheckBox view) {
        m.checkNotNullParameter(view, "view");
        if ((WidgetAuthRegisterAccountInformation.access$isConsentRequired$p(this.this$0.this$0) && view.isChecked()) || !WidgetAuthRegisterAccountInformation.access$isConsentRequired$p(this.this$0.this$0)) {
            return null;
        }
        return view.getContext().getString(2131896294);
    }
}

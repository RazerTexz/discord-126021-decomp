package com.discord.widgets.auth;

import android.widget.CheckBox;
import com.discord.utilities.view.validators.InputValidator;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetAuthBirthday.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthBirthday$validationManager$2$1 implements InputValidator<CheckBox> {
    public final /* synthetic */ WidgetAuthBirthday$validationManager$2 this$0;

    public WidgetAuthBirthday$validationManager$2$1(WidgetAuthBirthday$validationManager$2 widgetAuthBirthday$validationManager$2) {
        this.this$0 = widgetAuthBirthday$validationManager$2;
    }

    @Override // com.discord.utilities.view.validators.InputValidator
    public /* bridge */ /* synthetic */ CharSequence getErrorMessage(CheckBox checkBox) {
        return getErrorMessage2(checkBox);
    }

    /* JADX INFO: renamed from: getErrorMessage, reason: avoid collision after fix types in other method */
    public CharSequence getErrorMessage2(CheckBox view) {
        m.checkNotNullParameter(view, "view");
        if ((WidgetAuthBirthday.access$isConsentRequired$p(this.this$0.this$0) && view.isChecked()) || !WidgetAuthBirthday.access$isConsentRequired$p(this.this$0.this$0)) {
            return null;
        }
        return view.getContext().getString(2131896294);
    }
}

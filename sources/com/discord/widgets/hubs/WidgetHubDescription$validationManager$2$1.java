package com.discord.widgets.hubs;

import android.widget.LinearLayout;
import com.discord.utilities.view.validators.InputValidator;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetHubDescription.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescription$validationManager$2$1 implements InputValidator<LinearLayout> {
    public final /* synthetic */ WidgetHubDescription$validationManager$2 this$0;

    public WidgetHubDescription$validationManager$2$1(WidgetHubDescription$validationManager$2 widgetHubDescription$validationManager$2) {
        this.this$0 = widgetHubDescription$validationManager$2;
    }

    @Override // com.discord.utilities.view.validators.InputValidator
    public /* bridge */ /* synthetic */ CharSequence getErrorMessage(LinearLayout linearLayout) {
        return getErrorMessage2(linearLayout);
    }

    /* JADX INFO: renamed from: getErrorMessage, reason: avoid collision after fix types in other method */
    public CharSequence getErrorMessage2(LinearLayout view) {
        m.checkNotNullParameter(view, "view");
        if (this.this$0.this$0.getViewModel().getCategory() != null) {
            return null;
        }
        return view.getContext().getString(2131887038);
    }
}

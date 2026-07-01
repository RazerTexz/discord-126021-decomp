package com.discord.widgets.auth;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetAuthRegisterAccountInformation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthRegisterAccountInformation$configureUI$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetAuthRegisterAccountInformation this$0;

    public WidgetAuthRegisterAccountInformation$configureUI$2(WidgetAuthRegisterAccountInformation widgetAuthRegisterAccountInformation) {
        this.this$0 = widgetAuthRegisterAccountInformation;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetAuthRegisterAccountInformation.register$default(this.this$0, null, 1, null);
    }
}

package com.discord.widgets.auth;

import android.content.Intent;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.app.AppActivity;

/* JADX INFO: compiled from: WidgetAuthUndeleteAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthUndeleteAccount$onViewBoundOrOnResume$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetAuthUndeleteAccount this$0;

    public WidgetAuthUndeleteAccount$onViewBoundOrOnResume$2(WidgetAuthUndeleteAccount widgetAuthUndeleteAccount) {
        this.this$0 = widgetAuthUndeleteAccount;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("RESULT_EXTRA_UNDELETE", true);
        AppActivity appActivity = this.this$0.getAppActivity();
        if (appActivity != null) {
            appActivity.setResult(-1, intent);
        }
        AppActivity appActivity2 = this.this$0.getAppActivity();
        if (appActivity2 != null) {
            appActivity2.finish();
        }
    }
}

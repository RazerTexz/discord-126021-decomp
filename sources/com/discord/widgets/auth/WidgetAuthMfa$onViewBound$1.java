package com.discord.widgets.auth;

import android.content.Context;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import com.discord.R$id;
import d0.z.d.m;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetAuthMfa.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthMfa$onViewBound$1<T1, T2> implements Action2<MenuItem, Context> {
    public final /* synthetic */ WidgetAuthMfa this$0;

    public WidgetAuthMfa$onViewBound$1(WidgetAuthMfa widgetAuthMfa) {
        this.this$0 = widgetAuthMfa;
    }

    @Override // rx.functions.Action2
    public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
        call2(menuItem, context);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(MenuItem menuItem, Context context) {
        m.checkNotNullExpressionValue(menuItem, "menuItem");
        switch (menuItem.getItemId()) {
            case R$id.menu_auth_mfa_backup_codes /* 2131364363 */:
                WidgetAuthMfa.access$showBackupCodesDialog(this.this$0);
                break;
            case R$id.menu_auth_mfa_info /* 2131364364 */:
                WidgetAuthMfa.access$showInfoDialog(this.this$0);
                break;
        }
    }
}

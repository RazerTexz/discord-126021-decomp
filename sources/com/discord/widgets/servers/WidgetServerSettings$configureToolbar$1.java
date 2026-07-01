package com.discord.widgets.servers;

import android.content.Context;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetServerSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettings$configureToolbar$1<T1, T2> implements Action2<MenuItem, Context> {
    public final /* synthetic */ Guild $guild;
    public final /* synthetic */ WidgetServerSettings this$0;

    public WidgetServerSettings$configureToolbar$1(WidgetServerSettings widgetServerSettings, Guild guild) {
        this.this$0 = widgetServerSettings;
        this.$guild = guild;
    }

    @Override // rx.functions.Action2
    public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
        call2(menuItem, context);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(MenuItem menuItem, Context context) {
        m.checkNotNullExpressionValue(menuItem, "menuItem");
        if (menuItem.getItemId() != 2131364405) {
            return;
        }
        WidgetServerDeleteDialog$Companion widgetServerDeleteDialog$Companion = WidgetServerDeleteDialog.Companion;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetServerDeleteDialog$Companion.show(parentFragmentManager, this.$guild.getId());
    }
}

package com.discord.widgets.servers.settings.members;

import android.content.Context;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.user.WidgetPruneUsers;
import com.discord.widgets.user.WidgetPruneUsers$Companion;
import d0.z.d.m;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetServerSettingsMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsMembers$configureUI$1<T1, T2> implements Action2<MenuItem, Context> {
    public final /* synthetic */ WidgetServerSettingsMembersModel $model;
    public final /* synthetic */ WidgetServerSettingsMembers this$0;

    public WidgetServerSettingsMembers$configureUI$1(WidgetServerSettingsMembers widgetServerSettingsMembers, WidgetServerSettingsMembersModel widgetServerSettingsMembersModel) {
        this.this$0 = widgetServerSettingsMembers;
        this.$model = widgetServerSettingsMembersModel;
    }

    @Override // rx.functions.Action2
    public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
        call2(menuItem, context);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(MenuItem menuItem, Context context) {
        m.checkNotNullExpressionValue(menuItem, "menuItem");
        if (menuItem.getItemId() != 2131364407) {
            return;
        }
        WidgetPruneUsers$Companion widgetPruneUsers$Companion = WidgetPruneUsers.Companion;
        long id2 = this.$model.getGuild().getId();
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetPruneUsers$Companion.create(id2, parentFragmentManager);
    }
}

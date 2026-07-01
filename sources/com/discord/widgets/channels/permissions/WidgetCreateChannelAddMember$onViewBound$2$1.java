package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import java.util.Map;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetCreateChannelAddMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateChannelAddMember$onViewBound$2$1<T1, T2> implements Action2<MenuItem, Context> {
    public final /* synthetic */ Map $selected;
    public final /* synthetic */ WidgetCreateChannelAddMember$onViewBound$2 this$0;

    public WidgetCreateChannelAddMember$onViewBound$2$1(WidgetCreateChannelAddMember$onViewBound$2 widgetCreateChannelAddMember$onViewBound$2, Map map) {
        this.this$0 = widgetCreateChannelAddMember$onViewBound$2;
        this.$selected = map;
    }

    @Override // rx.functions.Action2
    public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
        call2(menuItem, context);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(MenuItem menuItem, Context context) {
        m.checkNotNullExpressionValue(menuItem, "menuItem");
        if (menuItem.getItemId() != 2131364382) {
            return;
        }
        WidgetCreateChannelAddMember widgetCreateChannelAddMember = this.this$0.this$0;
        Map map = this.$selected;
        m.checkNotNullExpressionValue(map, "selected");
        WidgetCreateChannelAddMember.access$addPermissionOverwrites(widgetCreateChannelAddMember, map);
    }
}

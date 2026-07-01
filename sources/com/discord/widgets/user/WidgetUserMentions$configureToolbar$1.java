package com.discord.widgets.user;

import android.content.Context;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentions$configureToolbar$1<T1, T2> implements Action2<MenuItem, Context> {
    public final /* synthetic */ String $guildName;
    public final /* synthetic */ WidgetUserMentions this$0;

    public WidgetUserMentions$configureToolbar$1(WidgetUserMentions widgetUserMentions, String str) {
        this.this$0 = widgetUserMentions;
        this.$guildName = str;
    }

    @Override // rx.functions.Action2
    public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
        call2(menuItem, context);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(MenuItem menuItem, Context context) {
        m.checkNotNullExpressionValue(menuItem, "menuItem");
        if (menuItem.getItemId() == 2131364418) {
            WidgetUserMentions$WidgetUserMentionFilter$Companion widgetUserMentions$WidgetUserMentionFilter$Companion = WidgetUserMentions$WidgetUserMentionFilter.Companion;
            FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            widgetUserMentions$WidgetUserMentionFilter$Companion.show(parentFragmentManager, this.$guildName, WidgetUserMentions.access$getMentionsLoader$p(this.this$0).getFilters(), new WidgetUserMentions$configureToolbar$1$1(this));
        }
    }
}

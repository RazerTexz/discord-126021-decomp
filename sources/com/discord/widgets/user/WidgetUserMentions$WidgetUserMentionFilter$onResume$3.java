package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import com.discord.views.CheckedSetting;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentions$WidgetUserMentionFilter$onResume$3<T> implements Action1<Boolean> {
    public final /* synthetic */ WidgetUserMentions$WidgetUserMentionFilter this$0;

    public WidgetUserMentions$WidgetUserMentionFilter$onResume$3(WidgetUserMentions$WidgetUserMentionFilter widgetUserMentions$WidgetUserMentionFilter) {
        this.this$0 = widgetUserMentions$WidgetUserMentionFilter;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        WidgetUserMentions$WidgetUserMentionFilter widgetUserMentions$WidgetUserMentionFilter = this.this$0;
        WidgetUserMentions$Model$MessageLoader$Filters widgetUserMentions$Model$MessageLoader$FiltersAccess$getFilters$p = WidgetUserMentions$WidgetUserMentionFilter.access$getFilters$p(widgetUserMentions$WidgetUserMentionFilter);
        CheckedSetting checkedSetting = WidgetUserMentions$WidgetUserMentionFilter.access$getBinding$p(this.this$0).c;
        m.checkNotNullExpressionValue(checkedSetting, "binding.userMentionsFilterIncludeRoles");
        WidgetUserMentions$WidgetUserMentionFilter.access$updateFilters(widgetUserMentions$WidgetUserMentionFilter, WidgetUserMentions$Model$MessageLoader$Filters.copy$default(widgetUserMentions$Model$MessageLoader$FiltersAccess$getFilters$p, 0L, false, false, checkedSetting.isChecked(), 7, null));
        WidgetUserMentions$WidgetUserMentionFilter.access$delayedDismiss(this.this$0);
    }
}

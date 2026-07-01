package com.discord.widgets.quickmentions;

import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.material.tabs.TabLayout$Tab;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetQuickMentionsDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetQuickMentionsDialog$onViewBoundOrOnResume$2 extends o implements Function2<TabLayout$Tab, Integer, Unit> {
    public final /* synthetic */ WidgetQuickMentionsDialog$TabsAdapter $adapter;
    public final /* synthetic */ WidgetQuickMentionsDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetQuickMentionsDialog$onViewBoundOrOnResume$2(WidgetQuickMentionsDialog widgetQuickMentionsDialog, WidgetQuickMentionsDialog$TabsAdapter widgetQuickMentionsDialog$TabsAdapter) {
        super(2);
        this.this$0 = widgetQuickMentionsDialog;
        this.$adapter = widgetQuickMentionsDialog$TabsAdapter;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(TabLayout$Tab tabLayout$Tab, Integer num) {
        invoke(tabLayout$Tab, num.intValue());
        return Unit.a;
    }

    public final void invoke(TabLayout$Tab tabLayout$Tab, int i) {
        m.checkNotNullParameter(tabLayout$Tab, "tab");
        tabLayout$Tab.setText(this.this$0.getString(this.$adapter.getItemTitleResId(i)));
    }
}

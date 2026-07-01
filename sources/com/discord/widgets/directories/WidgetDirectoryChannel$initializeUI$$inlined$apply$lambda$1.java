package com.discord.widgets.directories;

import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout$Tab;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoryChannel$initializeUI$$inlined$apply$lambda$1 extends o implements Function2<TabLayout$Tab, Integer, Unit> {
    public final /* synthetic */ TabLayout $this_apply;
    public final /* synthetic */ WidgetDirectoryChannel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoryChannel$initializeUI$$inlined$apply$lambda$1(TabLayout tabLayout, WidgetDirectoryChannel widgetDirectoryChannel) {
        super(2);
        this.$this_apply = tabLayout;
        this.this$0 = widgetDirectoryChannel;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(TabLayout$Tab tabLayout$Tab, Integer num) {
        invoke(tabLayout$Tab, num.intValue());
        return Unit.a;
    }

    public final void invoke(TabLayout$Tab tabLayout$Tab, int i) {
        m.checkNotNullParameter(tabLayout$Tab, "tab");
        this.this$0.getViewModel().withViewState(new WidgetDirectoryChannel$initializeUI$$inlined$apply$lambda$1$1(this, i, tabLayout$Tab));
    }
}

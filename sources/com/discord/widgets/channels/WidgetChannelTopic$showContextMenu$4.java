package com.discord.widgets.channels;

import android.view.MenuItem;
import android.view.MenuItem$OnMenuItemClickListener;
import androidx.fragment.app.FragmentManager;
import b.a.k.b;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.notice.WidgetNoticeDialog$Companion;
import d0.o;
import d0.t.g0;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelTopic.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelTopic$showContextMenu$4 implements MenuItem$OnMenuItemClickListener {
    public final /* synthetic */ CharSequence $channelTitle;
    public final /* synthetic */ WidgetChannelTopic this$0;

    public WidgetChannelTopic$showContextMenu$4(WidgetChannelTopic widgetChannelTopic, CharSequence charSequence) {
        this.this$0 = widgetChannelTopic;
        this.$channelTitle = charSequence;
    }

    @Override // android.view.MenuItem$OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        WidgetNoticeDialog$Companion widgetNoticeDialog$Companion = WidgetNoticeDialog.Companion;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetNoticeDialog$Companion.show$default(widgetNoticeDialog$Companion, parentFragmentManager, b.k(this.this$0, 2131892533, new Object[]{this.$channelTitle}, null, 4), b.k(this.this$0, 2131892527, new Object[]{this.$channelTitle}, null, 4), b.k(this.this$0, 2131892526, new Object[0], null, 4), b.k(this.this$0, 2131887437, new Object[0], null, 4), g0.mapOf(o.to(2131364555, new WidgetChannelTopic$showContextMenu$4$1(this))), null, null, null, 2130969885, null, null, 0, null, 15808, null);
        return true;
    }
}

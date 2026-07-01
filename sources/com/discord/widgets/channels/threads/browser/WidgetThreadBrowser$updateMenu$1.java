package com.discord.widgets.channels.threads.browser;

import android.content.Context;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import com.discord.R$id;
import com.discord.utilities.channel.ChannelSelector;
import d0.z.d.m;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetThreadBrowser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowser$updateMenu$1<T1, T2> implements Action2<MenuItem, Context> {
    public final /* synthetic */ WidgetThreadBrowser this$0;

    public WidgetThreadBrowser$updateMenu$1(WidgetThreadBrowser widgetThreadBrowser) {
        this.this$0 = widgetThreadBrowser;
    }

    @Override // rx.functions.Action2
    public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
        call2(menuItem, context);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(MenuItem menuItem, Context context) {
        m.checkNotNullExpressionValue(menuItem, "menuItem");
        switch (menuItem.getItemId()) {
            case R$id.menu_thread_browser_create_thread /* 2131364416 */:
                ChannelSelector.openCreateThread$default(ChannelSelector.Companion.getInstance(), WidgetThreadBrowser.access$getGuildId$p(this.this$0), WidgetThreadBrowser.access$getChannelId$p(this.this$0), null, "Thread Browser Toolbar", 4, null);
                this.this$0.requireAppActivity().finish();
                break;
            case R$id.menu_thread_browser_filters /* 2131364417 */:
                WidgetThreadBrowserFilterSheet$Companion widgetThreadBrowserFilterSheet$Companion = WidgetThreadBrowserFilterSheet.Companion;
                FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
                m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                widgetThreadBrowserFilterSheet$Companion.show(parentFragmentManager, WidgetThreadBrowser.access$getGuildId$p(this.this$0), WidgetThreadBrowser.access$getChannelId$p(this.this$0));
                break;
        }
    }
}

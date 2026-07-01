package com.discord.widgets.channels.threads.browser;

import android.view.Menu;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import com.discord.R$id;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetThreadBrowser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowser$updateMenu$2<T> implements Action1<Menu> {
    public final /* synthetic */ Boolean $canCreateThread;
    public final /* synthetic */ int $selectedPage;
    public final /* synthetic */ WidgetThreadBrowser this$0;

    public WidgetThreadBrowser$updateMenu$2(WidgetThreadBrowser widgetThreadBrowser, int i, Boolean bool) {
        this.this$0 = widgetThreadBrowser;
        this.$selectedPage = i;
        this.$canCreateThread = bool;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Menu menu) {
        call2(menu);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Menu menu) {
        MenuItem menuItemFindItem = menu.findItem(R$id.menu_thread_browser_filters);
        if (menuItemFindItem != null) {
            menuItemFindItem.setVisible(this.$selectedPage == WidgetThreadBrowser.access$getARCHIVED_PAGE$p(this.this$0));
        }
        MenuItem menuItemFindItem2 = menu.findItem(R$id.menu_thread_browser_create_thread);
        if (menuItemFindItem2 != null) {
            menuItemFindItem2.setVisible(this.$selectedPage == WidgetThreadBrowser.access$getACTIVE_PAGE$p(this.this$0) && m.areEqual(this.$canCreateThread, Boolean.TRUE));
        }
    }
}

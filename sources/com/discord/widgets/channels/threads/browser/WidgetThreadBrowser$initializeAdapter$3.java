package com.discord.widgets.channels.threads.browser;

import androidx.viewpager.widget.ViewPager$OnPageChangeListener;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;

/* JADX INFO: compiled from: WidgetThreadBrowser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowser$initializeAdapter$3 implements ViewPager$OnPageChangeListener {
    public final /* synthetic */ WidgetThreadBrowser this$0;

    public WidgetThreadBrowser$initializeAdapter$3(WidgetThreadBrowser widgetThreadBrowser) {
        this.this$0 = widgetThreadBrowser;
    }

    @Override // androidx.viewpager.widget.ViewPager$OnPageChangeListener
    public void onPageScrollStateChanged(int state) {
    }

    @Override // androidx.viewpager.widget.ViewPager$OnPageChangeListener
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override // androidx.viewpager.widget.ViewPager$OnPageChangeListener
    public void onPageSelected(int position) {
        WidgetThreadBrowser widgetThreadBrowser = this.this$0;
        WidgetThreadBrowserViewModel$ViewState widgetThreadBrowserViewModel$ViewStateAccess$getPreviousViewState$p = WidgetThreadBrowser.access$getPreviousViewState$p(widgetThreadBrowser);
        if (!(widgetThreadBrowserViewModel$ViewStateAccess$getPreviousViewState$p instanceof WidgetThreadBrowserViewModel$ViewState$Browser)) {
            widgetThreadBrowserViewModel$ViewStateAccess$getPreviousViewState$p = null;
        }
        WidgetThreadBrowserViewModel$ViewState$Browser widgetThreadBrowserViewModel$ViewState$Browser = (WidgetThreadBrowserViewModel$ViewState$Browser) widgetThreadBrowserViewModel$ViewStateAccess$getPreviousViewState$p;
        WidgetThreadBrowser.access$updateMenu(widgetThreadBrowser, position, widgetThreadBrowserViewModel$ViewState$Browser != null ? Boolean.valueOf(widgetThreadBrowserViewModel$ViewState$Browser.getCanCreateThread()) : null);
        if (position == WidgetThreadBrowser.access$getACTIVE_PAGE$p(this.this$0)) {
            StoreStream.Companion.getAnalytics().trackThreadBrowserTabChanged(WidgetThreadBrowser.access$getChannelId$p(this.this$0), "Active Threads");
        } else if (position == WidgetThreadBrowser.access$getARCHIVED_PAGE$p(this.this$0)) {
            WidgetThreadBrowser.access$getArchivedViewModel$p(this.this$0).trackTabChanged();
        }
    }
}

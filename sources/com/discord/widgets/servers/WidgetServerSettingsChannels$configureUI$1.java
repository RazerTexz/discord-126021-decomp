package com.discord.widgets.servers;

import android.content.Context;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import com.discord.R$id;
import d0.z.d.m;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsChannels$configureUI$1<T1, T2> implements Action2<MenuItem, Context> {
    public final /* synthetic */ WidgetServerSettingsChannels this$0;

    public WidgetServerSettingsChannels$configureUI$1(WidgetServerSettingsChannels widgetServerSettingsChannels) {
        this.this$0 = widgetServerSettingsChannels;
    }

    @Override // rx.functions.Action2
    public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
        call2(menuItem, context);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(MenuItem menuItem, Context context) {
        m.checkNotNullExpressionValue(menuItem, "menuItem");
        switch (menuItem.getItemId()) {
            case R$id.menu_sort_channel /* 2131364413 */:
                WidgetServerSettingsChannelsSortActions$Companion widgetServerSettingsChannelsSortActions$Companion = WidgetServerSettingsChannelsSortActions.Companion;
                FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
                m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                widgetServerSettingsChannelsSortActions$Companion.show(childFragmentManager, new WidgetServerSettingsChannels$configureUI$1$1(this));
                break;
            case R$id.menu_sort_done /* 2131364414 */:
                WidgetServerSettingsChannels.access$getChannelSortTypeSubject$p(this.this$0).onNext(-1);
                break;
        }
    }
}

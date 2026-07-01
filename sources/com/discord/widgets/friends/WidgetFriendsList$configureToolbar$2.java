package com.discord.widgets.friends;

import android.view.Menu;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import com.discord.R$id;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetFriendsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsList$configureToolbar$2<T> implements Action1<Menu> {
    public final /* synthetic */ WidgetFriendsList this$0;

    public WidgetFriendsList$configureToolbar$2(WidgetFriendsList widgetFriendsList) {
        this.this$0 = widgetFriendsList;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Menu menu) {
        call2(menu);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Menu menu) {
        MenuItem menuItemFindItem = menu.findItem(R$id.menu_friends_contact_sync);
        if (menuItemFindItem != null) {
            menuItemFindItem.setVisible(WidgetFriendsList.access$getShowContactSyncIcon$p(this.this$0));
        }
    }
}

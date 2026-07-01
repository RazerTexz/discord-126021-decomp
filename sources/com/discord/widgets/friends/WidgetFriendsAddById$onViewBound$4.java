package com.discord.widgets.friends;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.app.AppFragment;

/* JADX INFO: compiled from: WidgetFriendsAddById.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsAddById$onViewBound$4 implements View$OnClickListener {
    public final /* synthetic */ WidgetFriendsAddById this$0;

    public WidgetFriendsAddById$onViewBound$4(WidgetFriendsAddById widgetFriendsAddById) {
        this.this$0 = widgetFriendsAddById;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        AppFragment.hideKeyboard$default(this.this$0, null, 1, null);
    }
}

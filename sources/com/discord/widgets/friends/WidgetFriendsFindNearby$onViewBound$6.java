package com.discord.widgets.friends;

import android.view.View;
import android.view.View$OnClickListener;
import b.a.d.f;
import b.d.b.a.a;
import com.discord.utilities.uri.UriHandler;

/* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsFindNearby$onViewBound$6 implements View$OnClickListener {
    public static final WidgetFriendsFindNearby$onViewBound$6 INSTANCE = new WidgetFriendsFindNearby$onViewBound$6();

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        UriHandler.handle$default(UriHandler.INSTANCE, a.x(view, "it", "it.context"), f.a.a(360014894392L, null), false, false, null, 28, null);
    }
}

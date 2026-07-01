package com.discord.widgets.chat;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreNotices$Notice;
import com.discord.stores.StoreStream;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.search.results.WidgetSearchResults;
import d0.e0.c;
import d0.t.n;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetUrlActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetUrlActions$Companion {
    private WidgetUrlActions$Companion() {
    }

    public final void launch(FragmentManager fragmentManager, String url) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(url, "url");
        WidgetUrlActions widgetUrlActions = new WidgetUrlActions();
        Bundle bundle = new Bundle();
        bundle.putString("INTENT_URL", url);
        widgetUrlActions.setArguments(bundle);
        widgetUrlActions.show(fragmentManager, WidgetUrlActions.class.getName());
    }

    public final void requestNotice(String url) {
        m.checkNotNullParameter(url, "url");
        StoreStream.Companion.getNotices().requestToShow(new StoreNotices$Notice(url, null, 0L, 0, false, n.listOf((Object[]) new c[]{a0.getOrCreateKotlinClass(WidgetHome.class), a0.getOrCreateKotlinClass(WidgetSearchResults.class)}), 0L, false, 0L, new WidgetUrlActions$Companion$requestNotice$notice$1(url), 150, null));
    }

    public /* synthetic */ WidgetUrlActions$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

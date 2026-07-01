package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import b.a.d.f;
import b.d.b.a.a;
import com.discord.utilities.uri.UriHandler;

/* JADX INFO: compiled from: NotificationHighlightsSettingsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationHighlightsSettingsView$updateView$2 implements View$OnClickListener {
    public final /* synthetic */ NotificationHighlightsSettingsView this$0;

    public NotificationHighlightsSettingsView$updateView$2(NotificationHighlightsSettingsView notificationHighlightsSettingsView) {
        this.this$0 = notificationHighlightsSettingsView;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        UriHandler.handle$default(UriHandler.INSTANCE, a.I(NotificationHighlightsSettingsView.access$getBinding$p(this.this$0).f2130b, "binding.highlightsLearnMore", "binding.highlightsLearnMore.context"), f.a.a(5304469213079L, null), false, false, null, 28, null);
    }
}

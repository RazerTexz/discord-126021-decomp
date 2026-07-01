package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.domain.ModelNotificationSettings;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: NotificationHighlightsSettingsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationHighlightsSettingsView$updateView$1 implements View$OnClickListener {
    public final /* synthetic */ int $notifyHighlights;
    public final /* synthetic */ Function1 $onToggled;
    public final /* synthetic */ NotificationHighlightsSettingsView this$0;

    public NotificationHighlightsSettingsView$updateView$1(NotificationHighlightsSettingsView notificationHighlightsSettingsView, int i, Function1 function1) {
        this.this$0 = notificationHighlightsSettingsView;
        this.$notifyHighlights = i;
        this.$onToggled = function1;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        NotificationHighlightsSettingsView.access$getBinding$p(this.this$0).c.toggle();
        int i = this.$notifyHighlights;
        int i2 = ModelNotificationSettings.HIGHLIGHTS_DISABLED;
        if (i == i2) {
            i2 = ModelNotificationSettings.HIGHLIGHTS_ENABLED;
        }
        this.$onToggled.invoke(Integer.valueOf(i2));
    }
}

package com.discord.widgets.settings.connections;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Type;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsUserConnectionsAddXbox.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnectionsAddXbox$onViewBound$2$1<T> implements Action1<Error> {
    public final /* synthetic */ WidgetSettingsUserConnectionsAddXbox$onViewBound$2 this$0;

    public WidgetSettingsUserConnectionsAddXbox$onViewBound$2$1(WidgetSettingsUserConnectionsAddXbox$onViewBound$2 widgetSettingsUserConnectionsAddXbox$onViewBound$2) {
        this.this$0 = widgetSettingsUserConnectionsAddXbox$onViewBound$2;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Error error) {
        call2(error);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Error error) {
        WidgetSettingsUserConnectionsAddXbox widgetSettingsUserConnectionsAddXbox = this.this$0.this$0;
        m.checkNotNullExpressionValue(error, "error");
        WidgetSettingsUserConnectionsAddXbox.access$trackXboxLinkFailed(widgetSettingsUserConnectionsAddXbox, error);
        if (error.getType() == Error$Type.DISCORD_REQUEST_ERROR) {
            error.setShowErrorToasts(false);
            WidgetSettingsUserConnectionsAddXbox.access$showPinError(this.this$0.this$0);
        }
    }
}

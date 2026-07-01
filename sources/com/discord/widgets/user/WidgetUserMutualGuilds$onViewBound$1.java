package com.discord.widgets.user;

import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import b.a.d.j;
import com.discord.app.AppFragment;
import d0.e0.c;
import d0.z.d.m;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: WidgetUserMutualGuilds.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMutualGuilds$onViewBound$1 implements Action0 {
    public final /* synthetic */ WidgetUserMutualGuilds this$0;

    public WidgetUserMutualGuilds$onViewBound$1(WidgetUserMutualGuilds widgetUserMutualGuilds) {
        this.this$0 = widgetUserMutualGuilds;
    }

    @Override // rx.functions.Action0
    public final void call() {
        Context contextRequireContext = this.this$0.requireContext();
        List<c<? extends AppFragment>> list = j.a;
        m.checkNotNullParameter(contextRequireContext, "context");
        Intent intent = new Intent();
        intent.addFlags(67108864);
        j.c(contextRequireContext, false, intent, 2);
    }
}

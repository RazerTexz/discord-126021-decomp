package com.discord.widgets.channels.settings;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.channel.Channel;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextChannelSettings$confirmDelete$2 implements View$OnClickListener {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ WidgetTextChannelSettings this$0;

    public WidgetTextChannelSettings$confirmDelete$2(WidgetTextChannelSettings widgetTextChannelSettings, Channel channel) {
        this.this$0 = widgetTextChannelSettings;
        this.$channel = channel;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().deleteChannel(this.$channel.getId()), false, 1, null), this.this$0, null, 2, null);
        m.checkNotNullExpressionValue(view, "v");
        ObservableExtensionsKt.appSubscribe$default(observableUi$default, view.getContext(), "javaClass", (Function1) null, new WidgetTextChannelSettings$confirmDelete$2$2(this), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
    }
}

package com.discord.widgets.voice.settings;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.channel.Channel;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: WidgetVoiceChannelSettings.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceChannelSettings$confirmDelete$2 implements View$OnClickListener {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ WidgetVoiceChannelSettings this$0;

    public WidgetVoiceChannelSettings$confirmDelete$2(WidgetVoiceChannelSettings widgetVoiceChannelSettings, Channel channel) {
        this.this$0 = widgetVoiceChannelSettings;
        this.$channel = channel;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().deleteChannel(this.$channel.getId()), false, 1, null), this.this$0, null, 2, null);
        m.checkNotNullExpressionValue(view, "v");
        ObservableExtensionsKt.appSubscribe$default(observableUi$default, view.getContext(), "javaClass", (Function1) null, new WidgetVoiceChannelSettings$confirmDelete$2$2(this), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
    }
}

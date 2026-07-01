package com.discord.widgets.chat.pins;

import android.content.Context;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import d0.z.d.m;
import j0.l.e.k;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelPinnedMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelPinnedMessages$Model$Companion {
    private WidgetChannelPinnedMessages$Model$Companion() {
    }

    public final Observable<WidgetChannelPinnedMessages$Model> get(Context context, long channelId) {
        m.checkNotNullParameter(context, "context");
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Channel channelFindChannelById = storeStream$Companion.getChannels().findChannelById(channelId);
        if (channelFindChannelById != null) {
            Observable observableY = storeStream$Companion.getPinnedMessages().observeForChannel(channelId).Y(new WidgetChannelPinnedMessages$Model$Companion$get$1(channelFindChannelById, context));
            m.checkNotNullExpressionValue(observableY, "getPinnedMessages().obse…              }\n        }");
            return observableY;
        }
        k kVar = new k(null);
        m.checkNotNullExpressionValue(kVar, "Observable.just(null)");
        return kVar;
    }

    public /* synthetic */ WidgetChannelPinnedMessages$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

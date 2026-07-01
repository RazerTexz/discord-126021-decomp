package com.discord.widgets.channels;

import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSelector$Model$Companion {
    private WidgetChannelSelector$Model$Companion() {
    }

    public final Observable<List<WidgetChannelSelector$Model$Item>> get(long guildId, boolean includeNoChannel, WidgetChannelSelector$FilterFunction filterFunction) {
        m.checkNotNullParameter(filterFunction, "filterFunction");
        Observable observableG = StoreChannels.observeChannelsForGuild$default(StoreStream.Companion.getChannels(), guildId, null, 2, null).G(new WidgetChannelSelector$Model$Companion$get$1(filterFunction, includeNoChannel));
        m.checkNotNullExpressionValue(observableG, "StoreStream.getChannels(… { Item(it) }\n          }");
        Observable<List<WidgetChannelSelector$Model$Item>> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
        m.checkNotNullExpressionValue(observableR, "StoreStream.getChannels(…  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetChannelSelector$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

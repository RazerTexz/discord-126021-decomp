package com.discord.utilities.channel;

import com.discord.stores.Dispatcher;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelSelector$Companion {
    private ChannelSelector$Companion() {
    }

    public final ChannelSelector getInstance() {
        ChannelSelector channelSelectorAccess$getINSTANCE$cp = ChannelSelector.access$getINSTANCE$cp();
        if (channelSelectorAccess$getINSTANCE$cp == null) {
            m.throwUninitializedPropertyAccessException("INSTANCE");
        }
        return channelSelectorAccess$getINSTANCE$cp;
    }

    public final void init(StoreStream stream, Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(stream, "stream");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        ChannelSelector.access$setINSTANCE$cp(new ChannelSelector(stream, dispatcher, observationDeck));
    }

    public /* synthetic */ ChannelSelector$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

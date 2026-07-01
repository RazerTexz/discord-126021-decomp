package com.discord.stores;

import d0.t.n;
import java.util.List;

/* JADX INFO: compiled from: StoreApplicationStreaming.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum StoreApplicationStreaming$ActiveApplicationStream$State {
    CONNECTING,
    ACTIVE,
    RECONNECTING,
    ENDED,
    PAUSED,
    DENIED_FULL;


    @Deprecated
    private static final List<StoreApplicationStreaming$ActiveApplicationStream$State> ACTIVE_STATES;
    private static final StoreApplicationStreaming$ActiveApplicationStream$State$Companion Companion;

    static {
        StoreApplicationStreaming$ActiveApplicationStream$State storeApplicationStreaming$ActiveApplicationStream$State = CONNECTING;
        StoreApplicationStreaming$ActiveApplicationStream$State storeApplicationStreaming$ActiveApplicationStream$State2 = ACTIVE;
        StoreApplicationStreaming$ActiveApplicationStream$State storeApplicationStreaming$ActiveApplicationStream$State3 = RECONNECTING;
        StoreApplicationStreaming$ActiveApplicationStream$State storeApplicationStreaming$ActiveApplicationStream$State4 = PAUSED;
        Companion = new StoreApplicationStreaming$ActiveApplicationStream$State$Companion(null);
        ACTIVE_STATES = n.listOf((Object[]) new StoreApplicationStreaming$ActiveApplicationStream$State[]{storeApplicationStreaming$ActiveApplicationStream$State, storeApplicationStreaming$ActiveApplicationStream$State2, storeApplicationStreaming$ActiveApplicationStream$State3, storeApplicationStreaming$ActiveApplicationStream$State4});
    }

    public static final /* synthetic */ List access$getACTIVE_STATES$cp() {
        return ACTIVE_STATES;
    }

    public final boolean isStreamActive() {
        return ACTIVE_STATES.contains(this);
    }
}

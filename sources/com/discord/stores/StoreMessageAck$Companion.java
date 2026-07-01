package com.discord.stores;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreMessageAck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageAck$Companion {
    private StoreMessageAck$Companion() {
    }

    public final boolean isNonThreadChannel(StoreMessageAck$Companion$ThreadAckState storeMessageAck$Companion$ThreadAckState) {
        return storeMessageAck$Companion$ThreadAckState instanceof StoreMessageAck$Companion$ThreadAckState$NotThread;
    }

    public final boolean isThreadAndAbleToAck(StoreMessageAck$Companion$ThreadAckState storeMessageAck$Companion$ThreadAckState) {
        return (storeMessageAck$Companion$ThreadAckState instanceof StoreMessageAck$Companion$ThreadAckState$Thread) && ((StoreMessageAck$Companion$ThreadAckState$Thread) storeMessageAck$Companion$ThreadAckState).getCanAckThread();
    }

    public final boolean isThreadAndUnableToAck(StoreMessageAck$Companion$ThreadAckState storeMessageAck$Companion$ThreadAckState) {
        return (storeMessageAck$Companion$ThreadAckState instanceof StoreMessageAck$Companion$ThreadAckState$Thread) && !((StoreMessageAck$Companion$ThreadAckState$Thread) storeMessageAck$Companion$ThreadAckState).getCanAckThread();
    }

    public /* synthetic */ StoreMessageAck$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

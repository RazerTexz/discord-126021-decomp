package com.discord.stores;

import androidx.core.app.NotificationCompat;
import rx.functions.Action0;

/* JADX INFO: compiled from: StoreReadStates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreReadStates$computeUnreadMarker$4$3 implements Action0 {
    public final /* synthetic */ StoreReadStates$computeUnreadMarker$4 this$0;

    public StoreReadStates$computeUnreadMarker$4$3(StoreReadStates$computeUnreadMarker$4 storeReadStates$computeUnreadMarker$4) {
        this.this$0 = storeReadStates$computeUnreadMarker$4;
    }

    @Override // rx.functions.Action0
    public final void call() {
        StoreReadStates.access$clearMarker(this.this$0.this$0);
    }
}

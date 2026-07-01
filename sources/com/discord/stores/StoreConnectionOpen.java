package com.discord.stores;

import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.s;
import java.util.concurrent.TimeUnit;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: StoreConnectionOpen.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreConnectionOpen extends StoreV2 {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a0.mutableProperty1(new s(StoreConnectionOpen.class, "isConnectionOpen", "isConnectionOpen()Z", 0))};

    /* JADX INFO: renamed from: isConnectionOpen$delegate, reason: from kotlin metadata */
    private final StoreV2$MarkChangedDelegate isConnectionOpen = new StoreV2$MarkChangedDelegate(Boolean.FALSE, null, 2, null);

    public static final /* synthetic */ boolean access$isConnectionOpen$p(StoreConnectionOpen storeConnectionOpen) {
        return storeConnectionOpen.isConnectionOpen();
    }

    public static final /* synthetic */ void access$setConnectionOpen$p(StoreConnectionOpen storeConnectionOpen, boolean z2) {
        storeConnectionOpen.setConnectionOpen(z2);
    }

    private final boolean isConnectionOpen() {
        return ((Boolean) this.isConnectionOpen.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public static /* synthetic */ Observable observeConnectionOpen$default(StoreConnectionOpen storeConnectionOpen, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        return storeConnectionOpen.observeConnectionOpen(z2);
    }

    private final void setConnectionOpen(boolean z2) {
        this.isConnectionOpen.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z2));
    }

    @StoreThread
    public final void handleConnected(boolean connected) {
        if (connected) {
            return;
        }
        setConnectionOpen(false);
    }

    @StoreThread
    public final void handleConnectionOpen() {
        setConnectionOpen(true);
    }

    public final Observable<Boolean> observeConnectionOpen(boolean delayForUI) {
        Observable<Boolean> observableConnectRx$default = ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreConnectionOpen$observeConnectionOpen$1(this), 14, null);
        if (delayForUI) {
            observableConnectRx$default = observableConnectRx$default.q(100L, TimeUnit.MILLISECONDS);
        }
        m.checkNotNullExpressionValue(observableConnectRx$default, "ObservationDeckProvider\n…            }\n          }");
        return observableConnectRx$default;
    }
}

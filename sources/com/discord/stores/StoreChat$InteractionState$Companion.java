package com.discord.stores;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreChat.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChat$InteractionState$Companion {
    private StoreChat$InteractionState$Companion() {
    }

    public static final /* synthetic */ int access$getScrollState$p(StoreChat$InteractionState$Companion storeChat$InteractionState$Companion, LinearLayoutManager linearLayoutManager) {
        return storeChat$InteractionState$Companion.getScrollState(linearLayoutManager);
    }

    private final int getScrollState(LinearLayoutManager linearLayoutManager) {
        if (linearLayoutManager == null) {
            return 0;
        }
        int itemCount = linearLayoutManager.getItemCount() - 1;
        int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        int iMax = Math.max(0, itemCount - 15);
        int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        boolean z2 = 1 <= iFindFirstVisibleItemPosition && 15 >= iFindFirstVisibleItemPosition;
        int i = iFindFirstVisibleItemPosition <= 0 ? 1 : 0;
        if (iFindLastVisibleItemPosition == itemCount || iFindLastVisibleItemPosition >= iMax) {
            i |= 2;
        }
        return z2 ? i | 4 : i;
    }

    public /* synthetic */ StoreChat$InteractionState$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

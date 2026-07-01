package com.discord.widgets.botuikit;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUserSettings;
import d0.z.d.m;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: ComponentChatListState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ComponentChatListState {
    public static final ComponentChatListState INSTANCE = new ComponentChatListState();

    private ComponentChatListState() {
    }

    public final Observable<Map<Long, ComponentChatListState$ComponentStoreState>> observeChatListComponentState() {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<Map<Long, ComponentChatListState$ComponentStoreState>> observableI = Observable.i(storeStream$Companion.getInteractions().observeComponentInteractionState(), storeStream$Companion.getLocalActionComponentState().observeSelectComponentSelections(), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(storeStream$Companion.getUserSettings(), false, 1, null), ComponentChatListState$observeChatListComponentState$1.INSTANCE);
        m.checkNotNullExpressionValue(observableI, "Observable.combineLatest…s\n        )\n      }\n    }");
        return observableI;
    }
}

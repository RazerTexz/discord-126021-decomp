package com.discord.widgets.user;

import com.discord.stores.StoreUserPresence;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetUserStatusSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserStatusSheetViewModel$Companion {
    private WidgetUserStatusSheetViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(WidgetUserStatusSheetViewModel$Companion widgetUserStatusSheetViewModel$Companion, StoreUserPresence storeUserPresence) {
        return widgetUserStatusSheetViewModel$Companion.observeStoreState(storeUserPresence);
    }

    private final Observable<WidgetUserStatusSheetViewModel$StoreState> observeStoreState(StoreUserPresence storePresences) {
        Observable observableG = storePresences.observeLocalPresence().G(WidgetUserStatusSheetViewModel$Companion$observeStoreState$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "storePresences\n         …          )\n            }");
        return observableG;
    }

    public /* synthetic */ WidgetUserStatusSheetViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

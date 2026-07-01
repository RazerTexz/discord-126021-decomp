package com.discord.widgets.user;

import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreEmoji$EmojiContext$Global;
import com.discord.stores.StoreUserSettings;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetUserSetCustomStatusViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSetCustomStatusViewModel$Companion {
    private WidgetUserSetCustomStatusViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(WidgetUserSetCustomStatusViewModel$Companion widgetUserSetCustomStatusViewModel$Companion, StoreUserSettings storeUserSettings, StoreEmoji storeEmoji) {
        return widgetUserSetCustomStatusViewModel$Companion.observeStoreState(storeUserSettings, storeEmoji);
    }

    private final Observable<WidgetUserSetCustomStatusViewModel$StoreState> observeStoreState(StoreUserSettings storeUserSettings, StoreEmoji storeEmoji) {
        Observable<WidgetUserSetCustomStatusViewModel$StoreState> observableZ = Observable.j(storeUserSettings.observeCustomStatus(), storeEmoji.getEmojiSet(StoreEmoji$EmojiContext$Global.INSTANCE, false, false), WidgetUserSetCustomStatusViewModel$Companion$observeStoreState$1.INSTANCE).Z(1);
        m.checkNotNullExpressionValue(observableZ, "Observable.combineLatest…        )\n      }.take(1)");
        return observableZ;
    }

    public final WidgetUserSetCustomStatusViewModel$FormState$Expiration getDEFAULT_EXPIRATION() {
        return WidgetUserSetCustomStatusViewModel.access$getDEFAULT_EXPIRATION$cp();
    }

    public /* synthetic */ WidgetUserSetCustomStatusViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

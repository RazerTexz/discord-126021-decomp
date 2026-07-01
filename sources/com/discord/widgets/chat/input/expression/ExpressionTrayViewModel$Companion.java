package com.discord.widgets.chat.input.expression;

import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreExpressionPickerNavigation;
import com.discord.stores.StoreGuildStickers;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUser;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: ExpressionTrayViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ExpressionTrayViewModel$Companion {
    private ExpressionTrayViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(ExpressionTrayViewModel$Companion expressionTrayViewModel$Companion, StoreExpressionPickerNavigation storeExpressionPickerNavigation, StoreChannelsSelected storeChannelsSelected, StoreUser storeUser, StoreGuildStickers storeGuildStickers, StoreGuilds storeGuilds) {
        return expressionTrayViewModel$Companion.observeStoreState(storeExpressionPickerNavigation, storeChannelsSelected, storeUser, storeGuildStickers, storeGuilds);
    }

    private final Observable<ExpressionTrayViewModel$StoreState> observeStoreState(StoreExpressionPickerNavigation storeExpressionPickerNavigation, StoreChannelsSelected storeChannelsSelected, StoreUser storeUser, StoreGuildStickers storeGuildStickers, StoreGuilds storeGuilds) {
        Observable<ExpressionTrayViewModel$StoreState> observableG = Observable.g(storeExpressionPickerNavigation.observeSelectedTab(), storeChannelsSelected.observeResolvedSelectedChannel(), StoreUser.observeMe$default(storeUser, false, 1, null), storeGuildStickers.observeGuildStickers(), storeGuilds.observeGuilds(), ExpressionTrayViewModel$Companion$observeStoreState$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "Observable.combineLatest…aft\n          )\n        }");
        return observableG;
    }

    public /* synthetic */ ExpressionTrayViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

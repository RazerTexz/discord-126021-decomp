package com.discord.widgets.guild_role_subscriptions;

import android.content.Context;
import b.a.d.d0;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreGuildRoleSubscriptions$PriceTierState;
import com.discord.stores.StoreGuildRoleSubscriptions$PriceTierState$Failed;
import com.discord.stores.StoreGuildRoleSubscriptions$PriceTierState$Loaded;
import com.discord.stores.StoreGuildRoleSubscriptions$PriceTierState$Loading;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: PriceTierPickerBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PriceTierPickerBottomSheetViewModel extends d0<PriceTierPickerBottomSheetViewModel$ViewState> {
    public static final PriceTierPickerBottomSheetViewModel$Companion Companion = new PriceTierPickerBottomSheetViewModel$Companion(null);

    public PriceTierPickerBottomSheetViewModel() {
        this(null, null, 3, null);
    }

    public /* synthetic */ PriceTierPickerBottomSheetViewModel(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.Companion.getGuildRoleSubscriptions() : storeGuildRoleSubscriptions, (i & 2) != 0 ? PriceTierPickerBottomSheetViewModel$Companion.observeStoreState$default(Companion, null, null, 3, null) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(PriceTierPickerBottomSheetViewModel priceTierPickerBottomSheetViewModel, PriceTierPickerBottomSheetViewModel$StoreState priceTierPickerBottomSheetViewModel$StoreState) {
        priceTierPickerBottomSheetViewModel.handleStoreState(priceTierPickerBottomSheetViewModel$StoreState);
    }

    private final void handleStoreState(PriceTierPickerBottomSheetViewModel$StoreState storeState) {
        StoreGuildRoleSubscriptions$PriceTierState priceTierState = storeState.getPriceTierState();
        if (priceTierState instanceof StoreGuildRoleSubscriptions$PriceTierState$Loading) {
            updateViewState(PriceTierPickerBottomSheetViewModel$ViewState$Loading.INSTANCE);
        } else if (priceTierState instanceof StoreGuildRoleSubscriptions$PriceTierState$Failed) {
            updateViewState(PriceTierPickerBottomSheetViewModel$ViewState$Failed.INSTANCE);
        } else if (priceTierState instanceof StoreGuildRoleSubscriptions$PriceTierState$Loaded) {
            updateViewState(new PriceTierPickerBottomSheetViewModel$ViewState$Loaded(((StoreGuildRoleSubscriptions$PriceTierState$Loaded) storeState.getPriceTierState()).getPriceTiers()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PriceTierPickerBottomSheetViewModel(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, Observable<PriceTierPickerBottomSheetViewModel$StoreState> observable) {
        super(null, 1, null);
        m.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        m.checkNotNullParameter(observable, "storeObservable");
        storeGuildRoleSubscriptions.fetchPriceTiersIfNonExisting();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), PriceTierPickerBottomSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new PriceTierPickerBottomSheetViewModel$1(this), 62, (Object) null);
    }
}

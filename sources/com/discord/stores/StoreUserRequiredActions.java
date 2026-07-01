package com.discord.stores;

import com.discord.api.requiredaction.UserRequiredActionUpdate;
import com.discord.models.domain.ModelPayload;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import d0.z.d.m;
import rx.Observable;

/* JADX INFO: compiled from: StoreUserRequiredActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserRequiredActions extends StoreV2 {
    private final ObservationDeck observationDeck;
    private RequiredAction userRequiredAction;

    public StoreUserRequiredActions(ObservationDeck observationDeck) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.observationDeck = observationDeck;
        this.userRequiredAction = RequiredAction.NONE;
    }

    public static final /* synthetic */ RequiredAction access$getUserRequiredAction$p(StoreUserRequiredActions storeUserRequiredActions) {
        return storeUserRequiredActions.userRequiredAction;
    }

    public static final /* synthetic */ void access$setUserRequiredAction$p(StoreUserRequiredActions storeUserRequiredActions, RequiredAction requiredAction) {
        storeUserRequiredActions.userRequiredAction = requiredAction;
    }

    @StoreThread
    private final void updateUserRequiredAction(RequiredAction userRequiredAction) {
        if (userRequiredAction == RequiredAction.REQUIRE_CAPTCHA) {
            userRequiredAction = RequiredAction.REQUIRE_VERIFIED_PHONE;
        }
        this.userRequiredAction = userRequiredAction;
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        updateUserRequiredAction(RequiredAction.Companion.fromApiString(payload != null ? payload.getRequiredAction() : null));
        markChanged();
    }

    @StoreThread
    public final void handleUserRequiredActionUpdate(UserRequiredActionUpdate userRequiredActionUpdate) {
        m.checkNotNullParameter(userRequiredActionUpdate, "userRequiredActionUpdate");
        updateUserRequiredAction(RequiredAction.Companion.fromApiString(userRequiredActionUpdate.getRequiredAction()));
        markChanged();
    }

    public final Observable<RequiredAction> observeUserRequiredAction() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreUserRequiredActions$observeUserRequiredAction$1(this), 14, null);
    }
}

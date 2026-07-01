package com.discord.stores;

import com.discord.api.requiredaction.UserRequiredActionUpdate;
import com.discord.models.domain.ModelPayload;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.stores.updates.ObservationDeck;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* JADX INFO: compiled from: StoreUserRequiredActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserRequiredActions extends StoreV2 {
    private final ObservationDeck observationDeck;
    private RequiredAction userRequiredAction;

    /* JADX INFO: renamed from: com.discord.stores.StoreUserRequiredActions$observeUserRequiredAction$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUserRequiredActions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<RequiredAction> {
        public AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RequiredAction invoke() {
            return StoreUserRequiredActions.this.userRequiredAction;
        }
    }

    public StoreUserRequiredActions(ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.observationDeck = observationDeck;
        this.userRequiredAction = RequiredAction.NONE;
    }

    @Store3
    private final void updateUserRequiredAction(RequiredAction userRequiredAction) {
        if (userRequiredAction == RequiredAction.REQUIRE_CAPTCHA) {
            userRequiredAction = RequiredAction.REQUIRE_VERIFIED_PHONE;
        }
        this.userRequiredAction = userRequiredAction;
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        updateUserRequiredAction(RequiredAction.INSTANCE.fromApiString(payload != null ? payload.getRequiredAction() : null));
        markChanged();
    }

    @Store3
    public final void handleUserRequiredActionUpdate(UserRequiredActionUpdate userRequiredActionUpdate) {
        Intrinsics3.checkNotNullParameter(userRequiredActionUpdate, "userRequiredActionUpdate");
        updateUserRequiredAction(RequiredAction.INSTANCE.fromApiString(userRequiredActionUpdate.getRequiredAction()));
        markChanged();
    }

    public final Observable<RequiredAction> observeUserRequiredAction() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }
}

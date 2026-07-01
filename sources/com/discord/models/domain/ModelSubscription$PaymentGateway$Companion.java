package com.discord.models.domain;

import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModelSubscription.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelSubscription$PaymentGateway$Companion {
    private ModelSubscription$PaymentGateway$Companion() {
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001c  */
    /* JADX WARN: Code duplicated, block: B:16:? A[RETURN, SYNTHETIC] */
    public final ModelSubscription$PaymentGateway from(Integer paymentGatewayInt) {
        ModelSubscription$PaymentGateway modelSubscription$PaymentGateway;
        ModelSubscription$PaymentGateway[] modelSubscription$PaymentGatewayArrValues = ModelSubscription$PaymentGateway.values();
        for (int i = 0; i < 5; i++) {
            modelSubscription$PaymentGateway = modelSubscription$PaymentGatewayArrValues[i];
            if (m.areEqual(modelSubscription$PaymentGateway.getIntRepresentation(), paymentGatewayInt)) {
                if (modelSubscription$PaymentGateway != null) {
                    return modelSubscription$PaymentGateway;
                }
                return ModelSubscription$PaymentGateway.UNKNOWN;
            }
        }
        modelSubscription$PaymentGateway = null;
        if (modelSubscription$PaymentGateway != null) {
            return modelSubscription$PaymentGateway;
        }
        return ModelSubscription$PaymentGateway.UNKNOWN;
    }

    public /* synthetic */ ModelSubscription$PaymentGateway$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

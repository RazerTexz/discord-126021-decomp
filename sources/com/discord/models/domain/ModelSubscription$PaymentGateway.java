package com.discord.models.domain;


/* JADX INFO: compiled from: ModelSubscription.kt */
/* JADX INFO: loaded from: classes.dex */
public enum ModelSubscription$PaymentGateway {
    STRIPE(1),
    BRAINTREE(2),
    APPLE(3),
    GOOGLE(4),
    UNKNOWN(null);

    public static final ModelSubscription$PaymentGateway$Companion Companion = new ModelSubscription$PaymentGateway$Companion(null);
    private final Integer intRepresentation;

    ModelSubscription$PaymentGateway(Integer num) {
        this.intRepresentation = num;
    }

    public final Integer getIntRepresentation() {
        return this.intRepresentation;
    }
}

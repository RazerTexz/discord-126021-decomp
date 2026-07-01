package com.discord.models.domain;


/* JADX INFO: compiled from: ModelSku.kt */
/* JADX INFO: loaded from: classes.dex */
public enum ModelSku$ExternalStrategyTypes {
    CONSTANT(1),
    APPLE(2),
    GOOGLE(3),
    UNKNOWN(null);

    public static final ModelSku$ExternalStrategyTypes$Companion Companion = new ModelSku$ExternalStrategyTypes$Companion(null);
    private final Integer intRepresentation;

    ModelSku$ExternalStrategyTypes(Integer num) {
        this.intRepresentation = num;
    }

    public final Integer getIntRepresentation() {
        return this.intRepresentation;
    }
}

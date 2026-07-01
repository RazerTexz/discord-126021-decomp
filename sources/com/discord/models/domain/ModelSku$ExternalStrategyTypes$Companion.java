package com.discord.models.domain;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModelSku.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelSku$ExternalStrategyTypes$Companion {
    private ModelSku$ExternalStrategyTypes$Companion() {
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0025  */
    /* JADX WARN: Code duplicated, block: B:22:? A[RETURN, SYNTHETIC] */
    public final ModelSku$ExternalStrategyTypes from(int externalStrategyInt) {
        ModelSku$ExternalStrategyTypes modelSku$ExternalStrategyTypes;
        ModelSku$ExternalStrategyTypes[] modelSku$ExternalStrategyTypesArrValues = ModelSku$ExternalStrategyTypes.values();
        for (int i = 0; i < 4; i++) {
            modelSku$ExternalStrategyTypes = modelSku$ExternalStrategyTypesArrValues[i];
            Integer intRepresentation = modelSku$ExternalStrategyTypes.getIntRepresentation();
            if (intRepresentation != null && intRepresentation.intValue() == externalStrategyInt) {
                if (modelSku$ExternalStrategyTypes != null) {
                    return modelSku$ExternalStrategyTypes;
                }
                return ModelSku$ExternalStrategyTypes.UNKNOWN;
            }
        }
        modelSku$ExternalStrategyTypes = null;
        if (modelSku$ExternalStrategyTypes != null) {
            return modelSku$ExternalStrategyTypes;
        }
        return ModelSku$ExternalStrategyTypes.UNKNOWN;
    }

    public /* synthetic */ ModelSku$ExternalStrategyTypes$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

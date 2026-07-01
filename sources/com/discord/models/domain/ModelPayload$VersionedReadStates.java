package com.discord.models.domain;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ModelPayload$VersionedReadStates extends ModelPayload$VersionedModel<ModelReadState> {
    @Override // com.discord.models.domain.ModelPayload$VersionedModel
    public /* bridge */ /* synthetic */ ModelReadState parseEntry(Model$JsonReader model$JsonReader) throws IOException {
        return parseEntry(model$JsonReader);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.models.domain.ModelPayload$VersionedModel
    public ModelReadState parseEntry(Model$JsonReader model$JsonReader) {
        return ModelReadState$Parser.INSTANCE.parse(model$JsonReader);
    }
}

package com.discord.models.domain;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ModelPayload$VersionedUserGuildSettings extends ModelPayload$VersionedModel<ModelNotificationSettings> {
    @Override // com.discord.models.domain.ModelPayload$VersionedModel
    public /* bridge */ /* synthetic */ ModelNotificationSettings parseEntry(Model$JsonReader model$JsonReader) throws IOException {
        return parseEntry(model$JsonReader);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.models.domain.ModelPayload$VersionedModel
    public ModelNotificationSettings parseEntry(Model$JsonReader model$JsonReader) throws IOException {
        return (ModelNotificationSettings) model$JsonReader.parse(new ModelNotificationSettings());
    }
}

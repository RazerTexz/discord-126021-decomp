package com.discord.models.domain;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ModelAuditLogEntry$ValueFactory implements Model$JsonReader$ItemFactory<Object> {
    private final Model$JsonReader reader;

    public ModelAuditLogEntry$ValueFactory(Model$JsonReader model$JsonReader) {
        this.reader = model$JsonReader;
    }

    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public Object get() throws IOException {
        int iOrdinal = this.reader.peek().ordinal();
        if (iOrdinal == 2) {
            return this.reader.parse(new ModelAuditLogEntry$ChangeNameId());
        }
        if (iOrdinal == 5) {
            return this.reader.nextStringOrNull();
        }
        if (iOrdinal != 6) {
            return null;
        }
        return this.reader.nextLongOrNull();
    }
}

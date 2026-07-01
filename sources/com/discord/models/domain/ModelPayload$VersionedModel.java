package com.discord.models.domain;

import b.a.m.a.t;
import b.d.b.a.a;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class ModelPayload$VersionedModel<T> implements Model {
    public static final int DEFAULT_VERSION = -1;
    private List<T> entries;
    private boolean partial;
    private int version;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x000f  */
    @Override // com.discord.models.domain.Model
    public void assignField(Model$JsonReader model$JsonReader) throws IOException {
        String strNextName = model$JsonReader.nextName();
        strNextName.hashCode();
        switch (strNextName) {
            case "entries":
                this.entries = model$JsonReader.nextList(new t(this, model$JsonReader));
                break;
            case "partial":
                this.partial = model$JsonReader.nextBoolean(this.partial);
                break;
            case "version":
                this.version = model$JsonReader.nextInt(-1);
                break;
            default:
                model$JsonReader.skipValue();
                break;
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelPayload$VersionedModel;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelPayload$VersionedModel)) {
            return false;
        }
        ModelPayload$VersionedModel modelPayload$VersionedModel = (ModelPayload$VersionedModel) obj;
        if (!modelPayload$VersionedModel.canEqual(this) || getVersion() != modelPayload$VersionedModel.getVersion() || isPartial() != modelPayload$VersionedModel.isPartial()) {
            return false;
        }
        List<T> entries = getEntries();
        List<T> entries2 = modelPayload$VersionedModel.getEntries();
        return entries != null ? entries.equals(entries2) : entries2 == null;
    }

    public List<T> getEntries() {
        return this.entries;
    }

    public int getVersion() {
        return this.version;
    }

    public int hashCode() {
        int version = ((getVersion() + 59) * 59) + (isPartial() ? 79 : 97);
        List<T> entries = getEntries();
        return (version * 59) + (entries == null ? 43 : entries.hashCode());
    }

    public boolean isPartial() {
        return this.partial;
    }

    public abstract T parseEntry(Model$JsonReader model$JsonReader) throws IOException;

    public String toString() {
        StringBuilder sbU = a.U("ModelPayload.VersionedModel(version=");
        sbU.append(getVersion());
        sbU.append(", entries=");
        sbU.append(getEntries());
        sbU.append(", partial=");
        sbU.append(isPartial());
        sbU.append(")");
        return sbU.toString();
    }
}

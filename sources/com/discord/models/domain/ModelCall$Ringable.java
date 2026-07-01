package com.discord.models.domain;

import b.d.b.a.a;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ModelCall$Ringable implements Model {
    private boolean ringable;

    @Override // com.discord.models.domain.Model
    public void assignField(Model$JsonReader model$JsonReader) throws IOException {
        String strNextName = model$JsonReader.nextName();
        strNextName.hashCode();
        if (strNextName.equals("ringable")) {
            this.ringable = model$JsonReader.nextBoolean(this.ringable);
        } else {
            model$JsonReader.skipValue();
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelCall$Ringable;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelCall$Ringable)) {
            return false;
        }
        ModelCall$Ringable modelCall$Ringable = (ModelCall$Ringable) obj;
        return modelCall$Ringable.canEqual(this) && isRingable() == modelCall$Ringable.isRingable();
    }

    public int hashCode() {
        return 59 + (isRingable() ? 79 : 97);
    }

    public boolean isRingable() {
        return this.ringable;
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelCall.Ringable(ringable=");
        sbU.append(isRingable());
        sbU.append(")");
        return sbU.toString();
    }
}

package com.discord.stores;

import b.d.b.a.a;
import com.discord.models.domain.ModelPayload;
import d0.z.d.m;

/* JADX INFO: compiled from: ReadyPayloadUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ReadyPayloadUtils$HydrateResult$Success extends ReadyPayloadUtils$HydrateResult {
    private final ModelPayload payload;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadyPayloadUtils$HydrateResult$Success(ModelPayload modelPayload) {
        super(null);
        m.checkNotNullParameter(modelPayload, "payload");
        this.payload = modelPayload;
    }

    public static /* synthetic */ ReadyPayloadUtils$HydrateResult$Success copy$default(ReadyPayloadUtils$HydrateResult$Success readyPayloadUtils$HydrateResult$Success, ModelPayload modelPayload, int i, Object obj) {
        if ((i & 1) != 0) {
            modelPayload = readyPayloadUtils$HydrateResult$Success.payload;
        }
        return readyPayloadUtils$HydrateResult$Success.copy(modelPayload);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelPayload getPayload() {
        return this.payload;
    }

    public final ReadyPayloadUtils$HydrateResult$Success copy(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        return new ReadyPayloadUtils$HydrateResult$Success(payload);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ReadyPayloadUtils$HydrateResult$Success) && m.areEqual(this.payload, ((ReadyPayloadUtils$HydrateResult$Success) other).payload);
        }
        return true;
    }

    public final ModelPayload getPayload() {
        return this.payload;
    }

    public int hashCode() {
        ModelPayload modelPayload = this.payload;
        if (modelPayload != null) {
            return modelPayload.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Success(payload=");
        sbU.append(this.payload);
        sbU.append(")");
        return sbU.toString();
    }
}

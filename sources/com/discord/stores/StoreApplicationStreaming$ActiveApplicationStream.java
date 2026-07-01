package com.discord.stores;

import b.d.b.a.a;
import com.discord.models.domain.ModelApplicationStream;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreApplicationStreaming.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreApplicationStreaming$ActiveApplicationStream {
    private final StoreApplicationStreaming$ActiveApplicationStream$State state;
    private final ModelApplicationStream stream;

    public StoreApplicationStreaming$ActiveApplicationStream(StoreApplicationStreaming$ActiveApplicationStream$State storeApplicationStreaming$ActiveApplicationStream$State, ModelApplicationStream modelApplicationStream) {
        m.checkNotNullParameter(storeApplicationStreaming$ActiveApplicationStream$State, "state");
        m.checkNotNullParameter(modelApplicationStream, "stream");
        this.state = storeApplicationStreaming$ActiveApplicationStream$State;
        this.stream = modelApplicationStream;
    }

    public static /* synthetic */ StoreApplicationStreaming$ActiveApplicationStream copy$default(StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream, StoreApplicationStreaming$ActiveApplicationStream$State storeApplicationStreaming$ActiveApplicationStream$State, ModelApplicationStream modelApplicationStream, int i, Object obj) {
        if ((i & 1) != 0) {
            storeApplicationStreaming$ActiveApplicationStream$State = storeApplicationStreaming$ActiveApplicationStream.state;
        }
        if ((i & 2) != 0) {
            modelApplicationStream = storeApplicationStreaming$ActiveApplicationStream.stream;
        }
        return storeApplicationStreaming$ActiveApplicationStream.copy(storeApplicationStreaming$ActiveApplicationStream$State, modelApplicationStream);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreApplicationStreaming$ActiveApplicationStream$State getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ModelApplicationStream getStream() {
        return this.stream;
    }

    public final StoreApplicationStreaming$ActiveApplicationStream copy(StoreApplicationStreaming$ActiveApplicationStream$State state, ModelApplicationStream stream) {
        m.checkNotNullParameter(state, "state");
        m.checkNotNullParameter(stream, "stream");
        return new StoreApplicationStreaming$ActiveApplicationStream(state, stream);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreApplicationStreaming$ActiveApplicationStream)) {
            return false;
        }
        StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream = (StoreApplicationStreaming$ActiveApplicationStream) other;
        return m.areEqual(this.state, storeApplicationStreaming$ActiveApplicationStream.state) && m.areEqual(this.stream, storeApplicationStreaming$ActiveApplicationStream.stream);
    }

    public final StoreApplicationStreaming$ActiveApplicationStream$State getState() {
        return this.state;
    }

    public final ModelApplicationStream getStream() {
        return this.stream;
    }

    public int hashCode() {
        StoreApplicationStreaming$ActiveApplicationStream$State storeApplicationStreaming$ActiveApplicationStream$State = this.state;
        int iHashCode = (storeApplicationStreaming$ActiveApplicationStream$State != null ? storeApplicationStreaming$ActiveApplicationStream$State.hashCode() : 0) * 31;
        ModelApplicationStream modelApplicationStream = this.stream;
        return iHashCode + (modelApplicationStream != null ? modelApplicationStream.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ActiveApplicationStream(state=");
        sbU.append(this.state);
        sbU.append(", stream=");
        sbU.append(this.stream);
        sbU.append(")");
        return sbU.toString();
    }
}

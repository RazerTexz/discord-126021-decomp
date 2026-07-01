package com.discord.models.domain;

import b.a.m.a.o;
import b.d.b.a.a;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ModelPayload$Hello implements Model {
    private int heartbeatInterval;
    private List<String> trace;

    @Override // com.discord.models.domain.Model
    public void assignField(Model$JsonReader model$JsonReader) throws IOException {
        String strNextName = model$JsonReader.nextName();
        strNextName.hashCode();
        if (strNextName.equals("_trace")) {
            this.trace = model$JsonReader.nextList(new o(model$JsonReader));
        } else if (strNextName.equals("heartbeat_interval")) {
            this.heartbeatInterval = model$JsonReader.nextInt(this.heartbeatInterval);
        } else {
            model$JsonReader.skipValue();
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelPayload$Hello;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelPayload$Hello)) {
            return false;
        }
        ModelPayload$Hello modelPayload$Hello = (ModelPayload$Hello) obj;
        if (!modelPayload$Hello.canEqual(this) || getHeartbeatInterval() != modelPayload$Hello.getHeartbeatInterval()) {
            return false;
        }
        List<String> trace = getTrace();
        List<String> trace2 = modelPayload$Hello.getTrace();
        return trace != null ? trace.equals(trace2) : trace2 == null;
    }

    public int getHeartbeatInterval() {
        return this.heartbeatInterval;
    }

    public List<String> getTrace() {
        return this.trace;
    }

    public int hashCode() {
        int heartbeatInterval = getHeartbeatInterval() + 59;
        List<String> trace = getTrace();
        return (heartbeatInterval * 59) + (trace == null ? 43 : trace.hashCode());
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelPayload.Hello(heartbeatInterval=");
        sbU.append(getHeartbeatInterval());
        sbU.append(", trace=");
        sbU.append(getTrace());
        sbU.append(")");
        return sbU.toString();
    }
}

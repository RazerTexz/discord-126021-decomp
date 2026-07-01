package com.discord.models.domain;

import b.a.m.a.c0;
import b.d.b.a.a;
import com.discord.api.activity.Activity;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ModelSession implements Model {
    private boolean active;
    private List<Activity> activities;
    private ModelSession$ClientInfo clientInfo;
    private long lastModified;
    private String sessionId;
    private String status;

    @Override // com.discord.models.domain.Model
    public void assignField(Model$JsonReader model$JsonReader) throws IOException {
        String strNextName = model$JsonReader.nextName();
        strNextName.hashCode();
        switch (strNextName) {
            case "active":
                this.active = model$JsonReader.nextBoolean(this.active);
                break;
            case "status":
                this.status = model$JsonReader.nextString(this.status);
                break;
            case "client_info":
                this.clientInfo = (ModelSession$ClientInfo) model$JsonReader.parse(new ModelSession$ClientInfo());
                break;
            case "last_modified":
                this.lastModified = model$JsonReader.nextLong(this.lastModified);
                break;
            case "session_id":
                this.sessionId = model$JsonReader.nextString(this.sessionId);
                break;
            case "activities":
                this.activities = model$JsonReader.nextList(new c0(model$JsonReader));
                break;
            default:
                model$JsonReader.skipValue();
                break;
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelSession;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelSession)) {
            return false;
        }
        ModelSession modelSession = (ModelSession) obj;
        if (!modelSession.canEqual(this) || getLastModified() != modelSession.getLastModified() || isActive() != modelSession.isActive()) {
            return false;
        }
        String sessionId = getSessionId();
        String sessionId2 = modelSession.getSessionId();
        if (sessionId != null ? !sessionId.equals(sessionId2) : sessionId2 != null) {
            return false;
        }
        String status = getStatus();
        String status2 = modelSession.getStatus();
        if (status != null ? !status.equals(status2) : status2 != null) {
            return false;
        }
        List<Activity> activities = getActivities();
        List<Activity> activities2 = modelSession.getActivities();
        if (activities != null ? !activities.equals(activities2) : activities2 != null) {
            return false;
        }
        ModelSession$ClientInfo clientInfo = getClientInfo();
        ModelSession$ClientInfo clientInfo2 = modelSession.getClientInfo();
        return clientInfo != null ? clientInfo.equals(clientInfo2) : clientInfo2 == null;
    }

    public List<Activity> getActivities() {
        return this.activities;
    }

    public ModelSession$ClientInfo getClientInfo() {
        return this.clientInfo;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getStatus() {
        return this.status;
    }

    public int hashCode() {
        long lastModified = getLastModified();
        int i = ((((int) (lastModified ^ (lastModified >>> 32))) + 59) * 59) + (isActive() ? 79 : 97);
        String sessionId = getSessionId();
        int iHashCode = (i * 59) + (sessionId == null ? 43 : sessionId.hashCode());
        String status = getStatus();
        int iHashCode2 = (iHashCode * 59) + (status == null ? 43 : status.hashCode());
        List<Activity> activities = getActivities();
        int iHashCode3 = (iHashCode2 * 59) + (activities == null ? 43 : activities.hashCode());
        ModelSession$ClientInfo clientInfo = getClientInfo();
        return (iHashCode3 * 59) + (clientInfo != null ? clientInfo.hashCode() : 43);
    }

    public boolean isActive() {
        return this.active;
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelSession(sessionId=");
        sbU.append(getSessionId());
        sbU.append(", lastModified=");
        sbU.append(getLastModified());
        sbU.append(", status=");
        sbU.append(getStatus());
        sbU.append(", activities=");
        sbU.append(getActivities());
        sbU.append(", clientInfo=");
        sbU.append(getClientInfo());
        sbU.append(", active=");
        sbU.append(isActive());
        sbU.append(")");
        return sbU.toString();
    }
}

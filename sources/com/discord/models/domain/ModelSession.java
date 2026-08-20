package com.discord.models.domain;

import com.discord.api.activity.Activity;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import java.io.IOException;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes.dex */
public class ModelSession implements Model {
    private boolean active;
    private List<Activity> activities;
    private ClientInfo clientInfo;
    private long lastModified;
    private String sessionId;
    private String status;

    public static class ClientInfo implements Model {
        private String client;
        private int number;

        /* JADX INFO: renamed from: os */
        private String f18578os;

        @Override // com.discord.models.domain.Model
        public void assignField(Model.JsonReader jsonReader) throws IOException {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "client":
                    this.client = jsonReader.nextString(this.client);
                    break;
                case "number":
                    this.number = jsonReader.nextInt(this.number);
                    break;
                case "os":
                    this.f18578os = jsonReader.nextString(this.f18578os);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }

        public boolean canEqual(Object obj) {
            return obj instanceof ClientInfo;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ClientInfo)) {
                return false;
            }
            ClientInfo clientInfo = (ClientInfo) obj;
            if (!clientInfo.canEqual(this) || getNumber() != clientInfo.getNumber()) {
                return false;
            }
            String os = getOs();
            String os2 = clientInfo.getOs();
            if (os != null ? !os.equals(os2) : os2 != null) {
                return false;
            }
            String client = getClient();
            String client2 = clientInfo.getClient();
            return client != null ? client.equals(client2) : client2 == null;
        }

        public String getClient() {
            return this.client;
        }

        public int getNumber() {
            return this.number;
        }

        public String getOs() {
            return this.f18578os;
        }

        public int hashCode() {
            int number = getNumber() + 59;
            String os = getOs();
            int iHashCode = (number * 59) + (os == null ? 43 : os.hashCode());
            String client = getClient();
            return (iHashCode * 59) + (client != null ? client.hashCode() : 43);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ModelSession.ClientInfo(os=");
            sbM833U.append(getOs());
            sbM833U.append(", client=");
            sbM833U.append(getClient());
            sbM833U.append(", number=");
            sbM833U.append(getNumber());
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    @Override // com.discord.models.domain.Model
    public void assignField(final Model.JsonReader jsonReader) throws IOException {
        String strNextName = jsonReader.nextName();
        strNextName.hashCode();
        switch (strNextName) {
            case "active":
                this.active = jsonReader.nextBoolean(this.active);
                break;
            case "status":
                this.status = jsonReader.nextString(this.status);
                break;
            case "client_info":
                this.clientInfo = (ClientInfo) jsonReader.parse(new ClientInfo());
                break;
            case "last_modified":
                this.lastModified = jsonReader.nextLong(this.lastModified);
                break;
            case "session_id":
                this.sessionId = jsonReader.nextString(this.sessionId);
                break;
            case "activities":
                this.activities = jsonReader.nextList(new Model.JsonReader.ItemFactory() { // from class: b.a.m.a.c0
                    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                    public final Object get() {
                        return (Activity) InboundGatewayGsonParser.fromJson(jsonReader, Activity.class);
                    }
                });
                break;
            default:
                jsonReader.skipValue();
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
        ClientInfo clientInfo = getClientInfo();
        ClientInfo clientInfo2 = modelSession.getClientInfo();
        return clientInfo != null ? clientInfo.equals(clientInfo2) : clientInfo2 == null;
    }

    public List<Activity> getActivities() {
        return this.activities;
    }

    public ClientInfo getClientInfo() {
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
        ClientInfo clientInfo = getClientInfo();
        return (iHashCode3 * 59) + (clientInfo != null ? clientInfo.hashCode() : 43);
    }

    public boolean isActive() {
        return this.active;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ModelSession(sessionId=");
        sbM833U.append(getSessionId());
        sbM833U.append(", lastModified=");
        sbM833U.append(getLastModified());
        sbM833U.append(", status=");
        sbM833U.append(getStatus());
        sbM833U.append(", activities=");
        sbM833U.append(getActivities());
        sbM833U.append(", clientInfo=");
        sbM833U.append(getClientInfo());
        sbM833U.append(", active=");
        sbM833U.append(isActive());
        sbM833U.append(")");
        return sbM833U.toString();
    }
}

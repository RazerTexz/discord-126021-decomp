package com.discord.models.domain;

import b.d.b.a.a;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ModelSession$ClientInfo implements Model {
    private String client;
    private int number;
    private String os;

    @Override // com.discord.models.domain.Model
    public void assignField(Model$JsonReader model$JsonReader) throws IOException {
        String strNextName = model$JsonReader.nextName();
        strNextName.hashCode();
        switch (strNextName) {
            case "client":
                this.client = model$JsonReader.nextString(this.client);
                break;
            case "number":
                this.number = model$JsonReader.nextInt(this.number);
                break;
            case "os":
                this.os = model$JsonReader.nextString(this.os);
                break;
            default:
                model$JsonReader.skipValue();
                break;
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelSession$ClientInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelSession$ClientInfo)) {
            return false;
        }
        ModelSession$ClientInfo modelSession$ClientInfo = (ModelSession$ClientInfo) obj;
        if (!modelSession$ClientInfo.canEqual(this) || getNumber() != modelSession$ClientInfo.getNumber()) {
            return false;
        }
        String os = getOs();
        String os2 = modelSession$ClientInfo.getOs();
        if (os != null ? !os.equals(os2) : os2 != null) {
            return false;
        }
        String client = getClient();
        String client2 = modelSession$ClientInfo.getClient();
        return client != null ? client.equals(client2) : client2 == null;
    }

    public String getClient() {
        return this.client;
    }

    public int getNumber() {
        return this.number;
    }

    public String getOs() {
        return this.os;
    }

    public int hashCode() {
        int number = getNumber() + 59;
        String os = getOs();
        int iHashCode = (number * 59) + (os == null ? 43 : os.hashCode());
        String client = getClient();
        return (iHashCode * 59) + (client != null ? client.hashCode() : 43);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelSession.ClientInfo(os=");
        sbU.append(getOs());
        sbU.append(", client=");
        sbU.append(getClient());
        sbU.append(", number=");
        sbU.append(getNumber());
        sbU.append(")");
        return sbU.toString();
    }
}

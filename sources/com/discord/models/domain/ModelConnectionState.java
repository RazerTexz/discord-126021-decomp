package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.models.domain.Model;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ModelConnectionState implements Model {
    private String code;
    private String providerId;
    private String state;

    @Override // com.discord.models.domain.Model
    public void assignField(Model.JsonReader jsonReader) throws IOException {
        String strNextName = jsonReader.nextName();
        strNextName.hashCode();
        switch (strNextName) {
            case "code":
                this.code = jsonReader.nextString("");
                break;
            case "state":
                this.state = jsonReader.nextString("");
                break;
            case "provider_id":
                this.providerId = jsonReader.nextString("");
                break;
            default:
                jsonReader.skipValue();
                break;
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelConnectionState;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelConnectionState)) {
            return false;
        }
        ModelConnectionState modelConnectionState = (ModelConnectionState) obj;
        if (!modelConnectionState.canEqual(this)) {
            return false;
        }
        String code = getCode();
        String code2 = modelConnectionState.getCode();
        if (code != null ? !code.equals(code2) : code2 != null) {
            return false;
        }
        String state = getState();
        String state2 = modelConnectionState.getState();
        if (state != null ? !state.equals(state2) : state2 != null) {
            return false;
        }
        String providerId = getProviderId();
        String providerId2 = modelConnectionState.getProviderId();
        return providerId != null ? providerId.equals(providerId2) : providerId2 == null;
    }

    public String getCode() {
        return this.code;
    }

    public String getProviderId() {
        return this.providerId;
    }

    public String getState() {
        return this.state;
    }

    public int hashCode() {
        String code = getCode();
        int iHashCode = code == null ? 43 : code.hashCode();
        String state = getState();
        int iHashCode2 = ((iHashCode + 59) * 59) + (state == null ? 43 : state.hashCode());
        String providerId = getProviderId();
        return (iHashCode2 * 59) + (providerId != null ? providerId.hashCode() : 43);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelConnectionState(code=");
        sbU.append(getCode());
        sbU.append(", state=");
        sbU.append(getState());
        sbU.append(", providerId=");
        sbU.append(getProviderId());
        sbU.append(")");
        return sbU.toString();
    }
}

package com.discord.models.domain;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import p007b.p008a.p033m.p034a.C1130a;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes.dex */
public class ModelMessageDelete implements Model {
    private long channelId;
    private List<Long> messageIds;

    public ModelMessageDelete() {
    }

    @Override // com.discord.models.domain.Model
    public void assignField(Model.JsonReader jsonReader) throws IOException {
        String strNextName = jsonReader.nextName();
        strNextName.hashCode();
        switch (strNextName) {
            case "channel_id":
                this.channelId = jsonReader.nextLong(this.channelId);
                break;
            case "id":
                this.messageIds = Collections.singletonList(Long.valueOf(jsonReader.nextLong(0L)));
                break;
            case "ids":
                this.messageIds = jsonReader.nextList(new C1130a(jsonReader));
                break;
            default:
                jsonReader.skipValue();
                break;
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelMessageDelete;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelMessageDelete)) {
            return false;
        }
        ModelMessageDelete modelMessageDelete = (ModelMessageDelete) obj;
        if (!modelMessageDelete.canEqual(this) || getChannelId() != modelMessageDelete.getChannelId()) {
            return false;
        }
        List<Long> messageIds = getMessageIds();
        List<Long> messageIds2 = modelMessageDelete.getMessageIds();
        return messageIds != null ? messageIds.equals(messageIds2) : messageIds2 == null;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public List<Long> getMessageIds() {
        return this.messageIds;
    }

    public int hashCode() {
        long channelId = getChannelId();
        List<Long> messageIds = getMessageIds();
        return ((((int) (channelId ^ (channelId >>> 32))) + 59) * 59) + (messageIds == null ? 43 : messageIds.hashCode());
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ModelMessageDelete(channelId=");
        sbM833U.append(getChannelId());
        sbM833U.append(", messageIds=");
        sbM833U.append(getMessageIds());
        sbM833U.append(")");
        return sbM833U.toString();
    }

    public ModelMessageDelete(long j, long j2) {
        this.channelId = j;
        this.messageIds = Collections.singletonList(Long.valueOf(j2));
    }
}

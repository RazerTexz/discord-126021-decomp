package com.discord.models.domain;

import b.a.m.a.a;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ModelMessageDelete implements Model {
    private long channelId;
    private List<Long> messageIds;

    public ModelMessageDelete() {
    }

    @Override // com.discord.models.domain.Model
    public void assignField(Model$JsonReader model$JsonReader) throws IOException {
        String strNextName = model$JsonReader.nextName();
        strNextName.hashCode();
        switch (strNextName) {
            case "channel_id":
                this.channelId = model$JsonReader.nextLong(this.channelId);
                break;
            case "id":
                this.messageIds = Collections.singletonList(Long.valueOf(model$JsonReader.nextLong(0L)));
                break;
            case "ids":
                this.messageIds = model$JsonReader.nextList(new a(model$JsonReader));
                break;
            default:
                model$JsonReader.skipValue();
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
        StringBuilder sbU = b.d.b.a.a.U("ModelMessageDelete(channelId=");
        sbU.append(getChannelId());
        sbU.append(", messageIds=");
        sbU.append(getMessageIds());
        sbU.append(")");
        return sbU.toString();
    }

    public ModelMessageDelete(long j, long j2) {
        this.channelId = j;
        this.messageIds = Collections.singletonList(Long.valueOf(j2));
    }
}

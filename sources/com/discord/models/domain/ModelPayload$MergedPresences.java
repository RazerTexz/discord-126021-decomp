package com.discord.models.domain;

import b.a.m.a.p;
import b.a.m.a.r;
import b.d.b.a.a;
import com.discord.api.presence.Presence;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ModelPayload$MergedPresences implements Model {
    private List<Presence> friends;
    private List<List<Presence>> guilds;

    public static /* synthetic */ List access$000(ModelPayload$MergedPresences modelPayload$MergedPresences) {
        return modelPayload$MergedPresences.friends;
    }

    public static /* synthetic */ List access$100(ModelPayload$MergedPresences modelPayload$MergedPresences) {
        return modelPayload$MergedPresences.guilds;
    }

    @Override // com.discord.models.domain.Model
    public void assignField(Model$JsonReader model$JsonReader) throws IOException {
        String strNextName = model$JsonReader.nextName();
        strNextName.hashCode();
        if (strNextName.equals("guilds")) {
            this.guilds = model$JsonReader.nextList(new r(model$JsonReader));
        } else if (strNextName.equals("friends")) {
            this.friends = model$JsonReader.nextList(new p(model$JsonReader));
        } else {
            model$JsonReader.skipValue();
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelPayload$MergedPresences;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelPayload$MergedPresences)) {
            return false;
        }
        ModelPayload$MergedPresences modelPayload$MergedPresences = (ModelPayload$MergedPresences) obj;
        if (!modelPayload$MergedPresences.canEqual(this)) {
            return false;
        }
        List<Presence> friends = getFriends();
        List<Presence> friends2 = modelPayload$MergedPresences.getFriends();
        if (friends != null ? !friends.equals(friends2) : friends2 != null) {
            return false;
        }
        List<List<Presence>> guilds = getGuilds();
        List<List<Presence>> guilds2 = modelPayload$MergedPresences.getGuilds();
        return guilds != null ? guilds.equals(guilds2) : guilds2 == null;
    }

    public List<Presence> getFriends() {
        return this.friends;
    }

    public List<List<Presence>> getGuilds() {
        return this.guilds;
    }

    public int hashCode() {
        List<Presence> friends = getFriends();
        int iHashCode = friends == null ? 43 : friends.hashCode();
        List<List<Presence>> guilds = getGuilds();
        return ((iHashCode + 59) * 59) + (guilds != null ? guilds.hashCode() : 43);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelPayload.MergedPresences(friends=");
        sbU.append(getFriends());
        sbU.append(", guilds=");
        sbU.append(getGuilds());
        sbU.append(")");
        return sbU.toString();
    }
}

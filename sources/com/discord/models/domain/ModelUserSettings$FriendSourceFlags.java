package com.discord.models.domain;

import b.d.b.a.a;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ModelUserSettings$FriendSourceFlags implements Model {
    private boolean all;
    private boolean mutualFriends;
    private boolean mutualGuilds;

    @Override // com.discord.models.domain.Model
    public void assignField(Model$JsonReader model$JsonReader) throws IOException {
        String strNextName = model$JsonReader.nextName();
        strNextName.hashCode();
        switch (strNextName) {
            case "mutual_guilds":
                this.mutualGuilds = model$JsonReader.nextBoolean(this.mutualGuilds);
                break;
            case "all":
                this.all = model$JsonReader.nextBoolean(this.all);
                break;
            case "mutual_friends":
                this.mutualFriends = model$JsonReader.nextBoolean(this.mutualFriends);
                break;
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelUserSettings$FriendSourceFlags;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelUserSettings$FriendSourceFlags)) {
            return false;
        }
        ModelUserSettings$FriendSourceFlags modelUserSettings$FriendSourceFlags = (ModelUserSettings$FriendSourceFlags) obj;
        return modelUserSettings$FriendSourceFlags.canEqual(this) && isAll() == modelUserSettings$FriendSourceFlags.isAll() && isMutualGuilds() == modelUserSettings$FriendSourceFlags.isMutualGuilds() && isMutualFriends() == modelUserSettings$FriendSourceFlags.isMutualFriends();
    }

    public int hashCode() {
        return (((((isAll() ? 79 : 97) + 59) * 59) + (isMutualGuilds() ? 79 : 97)) * 59) + (isMutualFriends() ? 79 : 97);
    }

    public boolean isAll() {
        return this.all;
    }

    public boolean isMutualFriends() {
        return this.mutualFriends;
    }

    public boolean isMutualGuilds() {
        return this.mutualGuilds;
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelUserSettings.FriendSourceFlags(all=");
        sbU.append(isAll());
        sbU.append(", mutualGuilds=");
        sbU.append(isMutualGuilds());
        sbU.append(", mutualFriends=");
        sbU.append(isMutualFriends());
        sbU.append(")");
        return sbU.toString();
    }
}

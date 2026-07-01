package com.discord.api.science;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: Science.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Science$Event$MapObject extends Science$Event {
    private final Map<String, Object> properties;
    private final String type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Science$Event$MapObject(String str, Map<String, ? extends Object> map) {
        super(null);
        m.checkNotNullParameter(str, "type");
        m.checkNotNullParameter(map, "properties");
        this.type = str;
        this.properties = map;
    }

    @Override // com.discord.api.science.Science$Event
    /* JADX INFO: renamed from: a, reason: from getter */
    public String getType() {
        return this.type;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Science$Event$MapObject)) {
            return false;
        }
        Science$Event$MapObject science$Event$MapObject = (Science$Event$MapObject) other;
        return m.areEqual(this.type, science$Event$MapObject.type) && m.areEqual(this.properties, science$Event$MapObject.properties);
    }

    public int hashCode() {
        String str = this.type;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, Object> map = this.properties;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("MapObject(type=");
        sbU.append(this.type);
        sbU.append(", properties=");
        return a.M(sbU, this.properties, ")");
    }
}

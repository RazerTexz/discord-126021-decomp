package com.discord.restapi;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$ThreadCreationSettings {
    private final Integer autoArchiveDuration;
    private final String name;
    private final int type;

    public RestAPIParams$ThreadCreationSettings(String str, int i, Integer num) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.name = str;
        this.type = i;
        this.autoArchiveDuration = num;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final Integer getAutoArchiveDuration() {
        return this.autoArchiveDuration;
    }

    public static /* synthetic */ RestAPIParams$ThreadCreationSettings copy$default(RestAPIParams$ThreadCreationSettings restAPIParams$ThreadCreationSettings, String str, int i, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = restAPIParams$ThreadCreationSettings.name;
        }
        if ((i2 & 2) != 0) {
            i = restAPIParams$ThreadCreationSettings.type;
        }
        if ((i2 & 4) != 0) {
            num = restAPIParams$ThreadCreationSettings.autoArchiveDuration;
        }
        return restAPIParams$ThreadCreationSettings.copy(str, i, num);
    }

    public final RestAPIParams$ThreadCreationSettings copy(String name, int type, Integer autoArchiveDuration) {
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new RestAPIParams$ThreadCreationSettings(name, type, autoArchiveDuration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$ThreadCreationSettings)) {
            return false;
        }
        RestAPIParams$ThreadCreationSettings restAPIParams$ThreadCreationSettings = (RestAPIParams$ThreadCreationSettings) other;
        return m.areEqual(this.name, restAPIParams$ThreadCreationSettings.name) && this.type == restAPIParams$ThreadCreationSettings.type && m.areEqual(this.autoArchiveDuration, restAPIParams$ThreadCreationSettings.autoArchiveDuration);
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + this.type) * 31;
        Integer num = this.autoArchiveDuration;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ThreadCreationSettings(name=");
        sbU.append(this.name);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", autoArchiveDuration=");
        return a.F(sbU, this.autoArchiveDuration, ")");
    }

    public /* synthetic */ RestAPIParams$ThreadCreationSettings(String str, int i, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i2 & 4) != 0 ? null : num);
    }
}

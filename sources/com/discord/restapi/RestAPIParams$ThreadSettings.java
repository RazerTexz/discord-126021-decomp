package com.discord.restapi;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$ThreadSettings {
    private final Boolean archived;
    private final Integer autoArchiveDuration;
    private final Boolean locked;

    public RestAPIParams$ThreadSettings() {
        this(null, null, null, 7, null);
    }

    public RestAPIParams$ThreadSettings(Boolean bool, Boolean bool2, Integer num) {
        this.archived = bool;
        this.locked = bool2;
        this.autoArchiveDuration = num;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final Boolean getArchived() {
        return this.archived;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final Boolean getLocked() {
        return this.locked;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final Integer getAutoArchiveDuration() {
        return this.autoArchiveDuration;
    }

    public static /* synthetic */ RestAPIParams$ThreadSettings copy$default(RestAPIParams$ThreadSettings restAPIParams$ThreadSettings, Boolean bool, Boolean bool2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = restAPIParams$ThreadSettings.archived;
        }
        if ((i & 2) != 0) {
            bool2 = restAPIParams$ThreadSettings.locked;
        }
        if ((i & 4) != 0) {
            num = restAPIParams$ThreadSettings.autoArchiveDuration;
        }
        return restAPIParams$ThreadSettings.copy(bool, bool2, num);
    }

    public final RestAPIParams$ThreadSettings copy(Boolean archived, Boolean locked, Integer autoArchiveDuration) {
        return new RestAPIParams$ThreadSettings(archived, locked, autoArchiveDuration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$ThreadSettings)) {
            return false;
        }
        RestAPIParams$ThreadSettings restAPIParams$ThreadSettings = (RestAPIParams$ThreadSettings) other;
        return m.areEqual(this.archived, restAPIParams$ThreadSettings.archived) && m.areEqual(this.locked, restAPIParams$ThreadSettings.locked) && m.areEqual(this.autoArchiveDuration, restAPIParams$ThreadSettings.autoArchiveDuration);
    }

    public int hashCode() {
        Boolean bool = this.archived;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.locked;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Integer num = this.autoArchiveDuration;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ThreadSettings(archived=");
        sbU.append(this.archived);
        sbU.append(", locked=");
        sbU.append(this.locked);
        sbU.append(", autoArchiveDuration=");
        return a.F(sbU, this.autoArchiveDuration, ")");
    }

    public /* synthetic */ RestAPIParams$ThreadSettings(Boolean bool, Boolean bool2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : num);
    }
}

package com.discord.api.localizedstring;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: compiled from: LocalizedString.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class LocalizedString implements Serializable {
    private final String default;
    private final Map<String, String> localizations;

    public LocalizedString(String str, Map<String, String> map) {
        Intrinsics3.checkNotNullParameter(str, "default");
        Intrinsics3.checkNotNullParameter(map, "localizations");
        this.default = str;
        this.localizations = map;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getDefault() {
        return this.default;
    }

    public final Map<String, String> b() {
        return this.localizations;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocalizedString)) {
            return false;
        }
        LocalizedString localizedString = (LocalizedString) other;
        return Intrinsics3.areEqual(this.default, localizedString.default) && Intrinsics3.areEqual(this.localizations, localizedString.localizations);
    }

    public int hashCode() {
        String str = this.default;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, String> map = this.localizations;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("LocalizedString(default=");
        sbU.append(this.default);
        sbU.append(", localizations=");
        return outline.M(sbU, this.localizations, ")");
    }
}

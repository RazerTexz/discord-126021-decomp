package com.discord.api.localizedstring;

import java.io.Serializable;
import java.util.Map;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: LocalizedString.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class LocalizedString implements Serializable {
    private final String default;
    private final Map<String, String> localizations;

    public LocalizedString(String str, Map<String, String> map) {
        C12238m.checkNotNullParameter(str, "default");
        C12238m.checkNotNullParameter(map, "localizations");
        this.default = str;
        this.localizations = map;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getDefault() {
        return this.default;
    }

    /* JADX INFO: renamed from: b */
    public final Map<String, String> m8017b() {
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
        return C12238m.areEqual(this.default, localizedString.default) && C12238m.areEqual(this.localizations, localizedString.localizations);
    }

    public int hashCode() {
        String str = this.default;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, String> map = this.localizations;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("LocalizedString(default=");
        sbM833U.append(this.default);
        sbM833U.append(", localizations=");
        return C1643a.m825M(sbM833U, this.localizations, ")");
    }
}

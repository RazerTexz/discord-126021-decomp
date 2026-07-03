package com.discord.models.phone;

import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: PhoneCountryCode.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class PhoneCountryCode {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final PhoneCountryCode DEFAULT_COUNTRY_CODE = new PhoneCountryCode("United States", "US", "+1");
    private static final PhoneCountryCode MISSING_COUNTRY_CODE = new PhoneCountryCode("", "", "");
    private final String alpha2;
    private final String name;
    private final String phoneCountryCode;

    /* JADX INFO: compiled from: PhoneCountryCode.kt */
    public static final class Companion {
        private Companion() {
        }

        public final PhoneCountryCode getDEFAULT_COUNTRY_CODE() {
            return PhoneCountryCode.DEFAULT_COUNTRY_CODE;
        }

        public final PhoneCountryCode getMISSING_COUNTRY_CODE() {
            return PhoneCountryCode.MISSING_COUNTRY_CODE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PhoneCountryCode(String str, String str2, String str3) {
        C1643a.m872q0(str, ModelAuditLogEntry.CHANGE_KEY_NAME, str2, "alpha2", str3, "phoneCountryCode");
        this.name = str;
        this.alpha2 = str2;
        this.phoneCountryCode = str3;
    }

    public static /* synthetic */ PhoneCountryCode copy$default(PhoneCountryCode phoneCountryCode, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = phoneCountryCode.name;
        }
        if ((i & 2) != 0) {
            str2 = phoneCountryCode.alpha2;
        }
        if ((i & 4) != 0) {
            str3 = phoneCountryCode.phoneCountryCode;
        }
        return phoneCountryCode.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAlpha2() {
        return this.alpha2;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPhoneCountryCode() {
        return this.phoneCountryCode;
    }

    public final PhoneCountryCode copy(String name, String alpha2, String phoneCountryCode) {
        C12238m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(alpha2, "alpha2");
        C12238m.checkNotNullParameter(phoneCountryCode, "phoneCountryCode");
        return new PhoneCountryCode(name, alpha2, phoneCountryCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PhoneCountryCode)) {
            return false;
        }
        PhoneCountryCode phoneCountryCode = (PhoneCountryCode) other;
        return C12238m.areEqual(this.name, phoneCountryCode.name) && C12238m.areEqual(this.alpha2, phoneCountryCode.alpha2) && C12238m.areEqual(this.phoneCountryCode, phoneCountryCode.phoneCountryCode);
    }

    public final String getAlpha2() {
        return this.alpha2;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPhoneCountryCode() {
        return this.phoneCountryCode;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.alpha2;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.phoneCountryCode;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("PhoneCountryCode(name=");
        sbM833U.append(this.name);
        sbM833U.append(", alpha2=");
        sbM833U.append(this.alpha2);
        sbM833U.append(", phoneCountryCode=");
        return C1643a.m822J(sbM833U, this.phoneCountryCode, ")");
    }
}

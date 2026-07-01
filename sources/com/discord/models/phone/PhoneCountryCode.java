package com.discord.models.phone;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
        outline.q0(str, ModelAuditLogEntry.CHANGE_KEY_NAME, str2, "alpha2", str3, "phoneCountryCode");
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
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(alpha2, "alpha2");
        Intrinsics3.checkNotNullParameter(phoneCountryCode, "phoneCountryCode");
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
        return Intrinsics3.areEqual(this.name, phoneCountryCode.name) && Intrinsics3.areEqual(this.alpha2, phoneCountryCode.alpha2) && Intrinsics3.areEqual(this.phoneCountryCode, phoneCountryCode.phoneCountryCode);
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
        StringBuilder sbU = outline.U("PhoneCountryCode(name=");
        sbU.append(this.name);
        sbU.append(", alpha2=");
        sbU.append(this.alpha2);
        sbU.append(", phoneCountryCode=");
        return outline.J(sbU, this.phoneCountryCode, ")");
    }
}

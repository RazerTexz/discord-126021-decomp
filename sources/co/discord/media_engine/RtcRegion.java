package co.discord.media_engine;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Arrays;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: RtcRegion.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RtcRegion {
    private final String[] ips;
    private final String region;

    public RtcRegion(String str, String[] strArr) {
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_REGION);
        C12238m.checkNotNullParameter(strArr, "ips");
        this.region = str;
        this.ips = strArr;
    }

    public static /* synthetic */ RtcRegion copy$default(RtcRegion rtcRegion, String str, String[] strArr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rtcRegion.region;
        }
        if ((i & 2) != 0) {
            strArr = rtcRegion.ips;
        }
        return rtcRegion.copy(str, strArr);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRegion() {
        return this.region;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String[] getIps() {
        return this.ips;
    }

    public final RtcRegion copy(String region, String[] ips) {
        C12238m.checkNotNullParameter(region, ModelAuditLogEntry.CHANGE_KEY_REGION);
        C12238m.checkNotNullParameter(ips, "ips");
        return new RtcRegion(region, ips);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RtcRegion)) {
            return false;
        }
        RtcRegion rtcRegion = (RtcRegion) other;
        return C12238m.areEqual(this.region, rtcRegion.region) && C12238m.areEqual(this.ips, rtcRegion.ips);
    }

    public final String[] getIps() {
        return this.ips;
    }

    public final String getRegion() {
        return this.region;
    }

    public int hashCode() {
        String str = this.region;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String[] strArr = this.ips;
        return iHashCode + (strArr != null ? Arrays.hashCode(strArr) : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("RtcRegion(region=");
        sbM833U.append(this.region);
        sbM833U.append(", ips=");
        return C1643a.m822J(sbM833U, Arrays.toString(this.ips), ")");
    }
}

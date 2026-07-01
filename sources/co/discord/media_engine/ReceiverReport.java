package co.discord.media_engine;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: Statistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ReceiverReport {
    private final long bitrate;
    private final int fractionLost;
    private final String id;

    public ReceiverReport(String str, long j, int i) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        this.id = str;
        this.bitrate = j;
        this.fractionLost = i;
    }

    public static /* synthetic */ ReceiverReport copy$default(ReceiverReport receiverReport, String str, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = receiverReport.id;
        }
        if ((i2 & 2) != 0) {
            j = receiverReport.bitrate;
        }
        if ((i2 & 4) != 0) {
            i = receiverReport.fractionLost;
        }
        return receiverReport.copy(str, j, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getBitrate() {
        return this.bitrate;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getFractionLost() {
        return this.fractionLost;
    }

    public final ReceiverReport copy(String id2, long bitrate, int fractionLost) {
        Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        return new ReceiverReport(id2, bitrate, fractionLost);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReceiverReport)) {
            return false;
        }
        ReceiverReport receiverReport = (ReceiverReport) other;
        return Intrinsics3.areEqual(this.id, receiverReport.id) && this.bitrate == receiverReport.bitrate && this.fractionLost == receiverReport.fractionLost;
    }

    public final long getBitrate() {
        return this.bitrate;
    }

    public final int getFractionLost() {
        return this.fractionLost;
    }

    public final String getId() {
        return this.id;
    }

    public int hashCode() {
        String str = this.id;
        return ((b.a(this.bitrate) + ((str != null ? str.hashCode() : 0) * 31)) * 31) + this.fractionLost;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ReceiverReport(id=");
        sbU.append(this.id);
        sbU.append(", bitrate=");
        sbU.append(this.bitrate);
        sbU.append(", fractionLost=");
        return outline.B(sbU, this.fractionLost, ")");
    }
}

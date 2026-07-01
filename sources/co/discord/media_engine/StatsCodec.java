package co.discord.media_engine;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: Statistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class StatsCodec {
    private final int id;
    private final String name;

    public StatsCodec(int i, String str) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.id = i;
        this.name = str;
    }

    public static /* synthetic */ StatsCodec copy$default(StatsCodec statsCodec, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = statsCodec.id;
        }
        if ((i2 & 2) != 0) {
            str = statsCodec.name;
        }
        return statsCodec.copy(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final StatsCodec copy(int id2, String name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new StatsCodec(id2, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StatsCodec)) {
            return false;
        }
        StatsCodec statsCodec = (StatsCodec) other;
        return this.id == statsCodec.id && Intrinsics3.areEqual(this.name, statsCodec.name);
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int i = this.id * 31;
        String str = this.name;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("StatsCodec(id=");
        sbU.append(this.id);
        sbU.append(", name=");
        return outline.J(sbU, this.name, ")");
    }
}

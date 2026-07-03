package co.discord.media_engine;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Statistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class StatsCodec {
    private final int id;
    private final String name;

    public StatsCodec(int i, String str) {
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
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
        C12238m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
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
        return this.id == statsCodec.id && C12238m.areEqual(this.name, statsCodec.name);
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
        StringBuilder sbM833U = C1643a.m833U("StatsCodec(id=");
        sbM833U.append(this.id);
        sbM833U.append(", name=");
        return C1643a.m822J(sbM833U, this.name, ")");
    }
}

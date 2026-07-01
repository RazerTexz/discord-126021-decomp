package com.discord.utilities.system;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: ProcfsReader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ProcfsReader$Stat {
    private final long rssPages;
    private final long systemTime;
    private final long totalTime;
    private final long userTime;

    public ProcfsReader$Stat(long j, long j2, long j3, long j4) {
        this.userTime = j;
        this.systemTime = j2;
        this.totalTime = j3;
        this.rssPages = j4;
    }

    public static /* synthetic */ ProcfsReader$Stat copy$default(ProcfsReader$Stat procfsReader$Stat, long j, long j2, long j3, long j4, int i, Object obj) {
        return procfsReader$Stat.copy((i & 1) != 0 ? procfsReader$Stat.userTime : j, (i & 2) != 0 ? procfsReader$Stat.systemTime : j2, (i & 4) != 0 ? procfsReader$Stat.totalTime : j3, (i & 8) != 0 ? procfsReader$Stat.rssPages : j4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getUserTime() {
        return this.userTime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getSystemTime() {
        return this.systemTime;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getTotalTime() {
        return this.totalTime;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getRssPages() {
        return this.rssPages;
    }

    public final ProcfsReader$Stat copy(long userTime, long systemTime, long totalTime, long rssPages) {
        return new ProcfsReader$Stat(userTime, systemTime, totalTime, rssPages);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProcfsReader$Stat)) {
            return false;
        }
        ProcfsReader$Stat procfsReader$Stat = (ProcfsReader$Stat) other;
        return this.userTime == procfsReader$Stat.userTime && this.systemTime == procfsReader$Stat.systemTime && this.totalTime == procfsReader$Stat.totalTime && this.rssPages == procfsReader$Stat.rssPages;
    }

    public final long getRssPages() {
        return this.rssPages;
    }

    public final long getSystemTime() {
        return this.systemTime;
    }

    public final long getTotalTime() {
        return this.totalTime;
    }

    public final long getUserTime() {
        return this.userTime;
    }

    public int hashCode() {
        return b.a(this.rssPages) + ((b.a(this.totalTime) + ((b.a(this.systemTime) + (b.a(this.userTime) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("Stat(userTime=");
        sbU.append(this.userTime);
        sbU.append(", systemTime=");
        sbU.append(this.systemTime);
        sbU.append(", totalTime=");
        sbU.append(this.totalTime);
        sbU.append(", rssPages=");
        return a.C(sbU, this.rssPages, ")");
    }
}

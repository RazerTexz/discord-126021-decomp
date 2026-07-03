package com.discord.utilities.system;

import java.io.File;
import java.util.List;
import kotlin.Lazy;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p579g0.C12102s;
import p507d0.p579g0.C12106w;
import p507d0.p591y.C12205f;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ProcfsReader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ProcfsReader {
    public static final ProcfsReader INSTANCE = new ProcfsReader();

    /* JADX INFO: renamed from: pid$delegate, reason: from kotlin metadata */
    private static final Lazy pid = C12083g.lazy(ProcfsReader$pid$2.INSTANCE);
    private static final Stat default = new Stat(0, 0, 0, 0);

    /* JADX INFO: compiled from: ProcfsReader.kt */
    public static final /* data */ class Stat {
        private final long rssPages;
        private final long systemTime;
        private final long totalTime;
        private final long userTime;

        public Stat(long j, long j2, long j3, long j4) {
            this.userTime = j;
            this.systemTime = j2;
            this.totalTime = j3;
            this.rssPages = j4;
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

        public final Stat copy(long userTime, long systemTime, long totalTime, long rssPages) {
            return new Stat(userTime, systemTime, totalTime, rssPages);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Stat)) {
                return false;
            }
            Stat stat = (Stat) other;
            return this.userTime == stat.userTime && this.systemTime == stat.systemTime && this.totalTime == stat.totalTime && this.rssPages == stat.rssPages;
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
            return C0002b.m3a(this.rssPages) + ((C0002b.m3a(this.totalTime) + ((C0002b.m3a(this.systemTime) + (C0002b.m3a(this.userTime) * 31)) * 31)) * 31);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Stat(userTime=");
            sbM833U.append(this.userTime);
            sbM833U.append(", systemTime=");
            sbM833U.append(this.systemTime);
            sbM833U.append(", totalTime=");
            sbM833U.append(this.totalTime);
            sbM833U.append(", rssPages=");
            return C1643a.m815C(sbM833U, this.rssPages, ")");
        }
    }

    private ProcfsReader() {
    }

    private final int getPid() {
        return ((Number) pid.getValue()).intValue();
    }

    private final Stat parsePidStats(String input) {
        if (input.length() == 0) {
            return default;
        }
        List listSplit$default = C12106w.split$default((CharSequence) input, new char[]{' '}, false, 0, 6, (Object) null);
        long j = toLong((String) listSplit$default.get(13));
        long j2 = toLong((String) listSplit$default.get(14));
        return new Stat(j, j2, j + j2, toLong((String) listSplit$default.get(23)));
    }

    private final String readFile(File file) {
        try {
            if (file.exists()) {
                return C12205f.readText$default(file, null, 1, null);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private final long toLong(String s2) {
        Long longOrNull = C12102s.toLongOrNull(s2);
        if (longOrNull != null) {
            return longOrNull.longValue();
        }
        return 0L;
    }

    public final Stat readStatFile() {
        return readStatFile(new File(C1643a.m814B(C1643a.m833U("/proc/"), getPid(), "/stat")));
    }

    public final Stat readStatFile(File file) {
        C12238m.checkNotNullParameter(file, "file");
        String file2 = readFile(file);
        return file2 != null ? parsePidStats(file2) : default;
    }
}

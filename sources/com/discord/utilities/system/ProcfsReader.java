package com.discord.utilities.system;

import a0.a.a.b;
import b.d.b.a.outline;
import d0.LazyJVM;
import d0.g0.StringNumberConversions;
import d0.g0.Strings4;
import d0.y.FileReadWrite;
import d0.z.d.Intrinsics3;
import java.io.File;
import java.util.List;
import kotlin.Lazy;

/* JADX INFO: compiled from: ProcfsReader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ProcfsReader {
    public static final ProcfsReader INSTANCE = new ProcfsReader();

    /* JADX INFO: renamed from: pid$delegate, reason: from kotlin metadata */
    private static final Lazy pid = LazyJVM.lazy(ProcfsReader2.INSTANCE);
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
            return b.a(this.rssPages) + ((b.a(this.totalTime) + ((b.a(this.systemTime) + (b.a(this.userTime) * 31)) * 31)) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Stat(userTime=");
            sbU.append(this.userTime);
            sbU.append(", systemTime=");
            sbU.append(this.systemTime);
            sbU.append(", totalTime=");
            sbU.append(this.totalTime);
            sbU.append(", rssPages=");
            return outline.C(sbU, this.rssPages, ")");
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
        List listSplit$default = Strings4.split$default((CharSequence) input, new char[]{' '}, false, 0, 6, (Object) null);
        long j = toLong((String) listSplit$default.get(13));
        long j2 = toLong((String) listSplit$default.get(14));
        return new Stat(j, j2, j + j2, toLong((String) listSplit$default.get(23)));
    }

    private final String readFile(File file) {
        try {
            if (file.exists()) {
                return FileReadWrite.readText$default(file, null, 1, null);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private final long toLong(String s2) {
        Long longOrNull = StringNumberConversions.toLongOrNull(s2);
        if (longOrNull != null) {
            return longOrNull.longValue();
        }
        return 0L;
    }

    public final Stat readStatFile() {
        return readStatFile(new File(outline.B(outline.U("/proc/"), getPid(), "/stat")));
    }

    public final Stat readStatFile(File file) {
        Intrinsics3.checkNotNullParameter(file, "file");
        String file2 = readFile(file);
        return file2 != null ? parsePidStats(file2) : default;
    }
}

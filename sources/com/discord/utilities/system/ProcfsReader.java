package com.discord.utilities.system;

import b.d.b.a.a;
import d0.g;
import d0.g0.s;
import d0.g0.w;
import d0.y.f;
import d0.z.d.m;
import java.io.File;
import java.util.List;
import kotlin.Lazy;

/* JADX INFO: compiled from: ProcfsReader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ProcfsReader {
    public static final ProcfsReader INSTANCE = new ProcfsReader();

    /* JADX INFO: renamed from: pid$delegate, reason: from kotlin metadata */
    private static final Lazy pid = g.lazy(ProcfsReader$pid$2.INSTANCE);
    private static final ProcfsReader$Stat default = new ProcfsReader$Stat(0, 0, 0, 0);

    private ProcfsReader() {
    }

    private final int getPid() {
        return ((Number) pid.getValue()).intValue();
    }

    private final ProcfsReader$Stat parsePidStats(String input) {
        if (input.length() == 0) {
            return default;
        }
        List listSplit$default = w.split$default((CharSequence) input, new char[]{' '}, false, 0, 6, (Object) null);
        long j = toLong((String) listSplit$default.get(13));
        long j2 = toLong((String) listSplit$default.get(14));
        return new ProcfsReader$Stat(j, j2, j + j2, toLong((String) listSplit$default.get(23)));
    }

    private final String readFile(File file) {
        try {
            if (file.exists()) {
                return f.readText$default(file, null, 1, null);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private final long toLong(String s2) {
        Long longOrNull = s.toLongOrNull(s2);
        if (longOrNull != null) {
            return longOrNull.longValue();
        }
        return 0L;
    }

    public final ProcfsReader$Stat readStatFile() {
        return readStatFile(new File(a.B(a.U("/proc/"), getPid(), "/stat")));
    }

    public final ProcfsReader$Stat readStatFile(File file) {
        m.checkNotNullParameter(file, "file");
        String file2 = readFile(file);
        return file2 != null ? parsePidStats(file2) : default;
    }
}

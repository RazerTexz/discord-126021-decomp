package com.discord.utilities.debug;

import android.os.Build;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.logging.LoggingProvider;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.utilities.debug.DebugPrintableCollection, reason: use source file name */
/* JADX INFO: compiled from: DebugPrintable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DebugPrintable3 {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static String libdiscordVersion = null;
    private static final int maxDebugPrintableStringLength = 524288;
    private long idCounter = 1;
    private final Map<Long, DebugPrintable5> collection = new LinkedHashMap();
    private final Object sync = new Object();

    /* JADX INFO: renamed from: com.discord.utilities.debug.DebugPrintableCollection$Companion, reason: from kotlin metadata */
    /* JADX INFO: compiled from: DebugPrintable.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void initialize(String libdiscordVersion) {
            Intrinsics3.checkNotNullParameter(libdiscordVersion, "libdiscordVersion");
            DebugPrintable3.libdiscordVersion = libdiscordVersion;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ long add$default(DebugPrintable3 debugPrintable3, DebugPrintable debugPrintable, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return debugPrintable3.add(debugPrintable, str);
    }

    private final void addSystemEntry(DebugPrintable2 dp) {
        dp.appendLine("System:");
        dp.appendKeyValue("libdiscordVersion", libdiscordVersion);
        dp.appendKeyValue("SDK_INT", Integer.valueOf(Build.VERSION.SDK_INT));
        dp.append("\n");
    }

    private final void removeDeadReferencesLocked() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Long, DebugPrintable5> entry : this.collection.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            if (entry.getValue().getReference().get() == null) {
                arrayList.add(Long.valueOf(jLongValue));
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.collection.remove(Long.valueOf(((Number) it.next()).longValue()));
        }
    }

    public final long add(DebugPrintable ref, String tag) {
        long j;
        Intrinsics3.checkNotNullParameter(ref, "ref");
        synchronized (this.sync) {
            j = this.idCounter;
            this.idCounter = j + 1;
            long j2 = 0;
            while (this.collection.containsKey(Long.valueOf(j))) {
                j = this.idCounter;
                this.idCounter = j + 1;
                j2++;
                if (j2 < 0) {
                    break;
                }
            }
            this.collection.put(Long.valueOf(j), new DebugPrintable5(tag, ref));
            removeDeadReferencesLocked();
        }
        return j;
    }

    public final void debugPrint(StringBuilder sb) {
        Intrinsics3.checkNotNullParameter(sb, "sb");
        DebugPrintable2 debugPrintable2 = new DebugPrintable2(sb);
        synchronized (this.sync) {
            addSystemEntry(debugPrintable2);
            for (Map.Entry<Long, DebugPrintable5> entry : this.collection.entrySet()) {
                long jLongValue = entry.getKey().longValue();
                DebugPrintable5 value = entry.getValue();
                DebugPrintable debugPrintable = value.getReference().get();
                if (debugPrintable != null) {
                    Intrinsics3.checkNotNullExpressionValue(debugPrintable, "printableRef.reference.get() ?: continue");
                    sb.append(jLongValue);
                    if (value.getTag() != null) {
                        sb.append(' ');
                        sb.append(value.getTag());
                    }
                    sb.append(":\n");
                    try {
                        debugPrintable.debugPrint(debugPrintable2);
                    } catch (Exception e) {
                        sb.append("Exception: " + e);
                    }
                    sb.append('\n');
                    if (sb.length() > 524288) {
                        sb.delete(524288, sb.length() - 1);
                        sb.append(" {truncated}");
                        break;
                    }
                }
            }
        }
    }

    public final void remove(long debugPrintableId) {
        synchronized (this.sync) {
            if (this.collection.remove(Long.valueOf(debugPrintableId)) == null) {
                Logger.w$default(LoggingProvider.INSTANCE.get(), "DebugPrintable", "Unable to locate tag '" + debugPrintableId + '\'', null, 4, null);
            }
        }
    }
}

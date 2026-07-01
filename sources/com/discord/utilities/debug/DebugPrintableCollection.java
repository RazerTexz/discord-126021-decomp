package com.discord.utilities.debug;

import android.os.Build$VERSION;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.logging.LoggingProvider;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: compiled from: DebugPrintable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DebugPrintableCollection {
    public static final DebugPrintableCollection$Companion Companion = new DebugPrintableCollection$Companion(null);
    private static String libdiscordVersion = null;
    private static final int maxDebugPrintableStringLength = 524288;
    private long idCounter = 1;
    private final Map<Long, DebugPrintableRef> collection = new LinkedHashMap();
    private final Object sync = new Object();

    public static final /* synthetic */ String access$getLibdiscordVersion$cp() {
        return libdiscordVersion;
    }

    public static final /* synthetic */ void access$setLibdiscordVersion$cp(String str) {
        libdiscordVersion = str;
    }

    public static /* synthetic */ long add$default(DebugPrintableCollection debugPrintableCollection, DebugPrintable debugPrintable, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return debugPrintableCollection.add(debugPrintable, str);
    }

    private final void addSystemEntry(DebugPrintBuilder dp) {
        dp.appendLine("System:");
        dp.appendKeyValue("libdiscordVersion", libdiscordVersion);
        dp.appendKeyValue("SDK_INT", Integer.valueOf(Build$VERSION.SDK_INT));
        dp.append("\n");
    }

    private final void removeDeadReferencesLocked() {
        ArrayList arrayList = new ArrayList();
        for (Map$Entry<Long, DebugPrintableRef> map$Entry : this.collection.entrySet()) {
            long jLongValue = map$Entry.getKey().longValue();
            if (map$Entry.getValue().getReference().get() == null) {
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
        m.checkNotNullParameter(ref, "ref");
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
            this.collection.put(Long.valueOf(j), new DebugPrintableRef(tag, ref));
            removeDeadReferencesLocked();
        }
        return j;
    }

    public final void debugPrint(StringBuilder sb) {
        m.checkNotNullParameter(sb, "sb");
        DebugPrintBuilder debugPrintBuilder = new DebugPrintBuilder(sb);
        synchronized (this.sync) {
            addSystemEntry(debugPrintBuilder);
            for (Map$Entry<Long, DebugPrintableRef> map$Entry : this.collection.entrySet()) {
                long jLongValue = map$Entry.getKey().longValue();
                DebugPrintableRef value = map$Entry.getValue();
                DebugPrintable debugPrintable = value.getReference().get();
                if (debugPrintable != null) {
                    m.checkNotNullExpressionValue(debugPrintable, "printableRef.reference.get() ?: continue");
                    sb.append(jLongValue);
                    if (value.getTag() != null) {
                        sb.append(' ');
                        sb.append(value.getTag());
                    }
                    sb.append(":\n");
                    try {
                        debugPrintable.debugPrint(debugPrintBuilder);
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

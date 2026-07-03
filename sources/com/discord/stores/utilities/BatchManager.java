package com.discord.stores.utilities;

import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: BatchManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BatchManager {
    private final Map<String, Batched<?>> batches;
    private final Clock clock;
    private final CoroutineScope scope;

    public BatchManager(CoroutineDispatcher coroutineDispatcher, Clock clock) {
        C12238m.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        C12238m.checkNotNullParameter(clock, "clock");
        this.clock = clock;
        this.scope = C3404f.m4275c(coroutineDispatcher);
        this.batches = new LinkedHashMap();
    }

    public static /* synthetic */ Batched createBatched$default(BatchManager batchManager, String str, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 100;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = 300;
        }
        return batchManager.createBatched(str, j3, j2);
    }

    public final <T> Batched<T> createBatched(String type, long debounceDelayMs, long maxDebounceDelayMs) {
        C12238m.checkNotNullParameter(type, "type");
        Batched<T> batched = new Batched<>(type, debounceDelayMs, maxDebounceDelayMs, this.scope, this.clock);
        this.batches.put(type, batched);
        return batched;
    }

    public final void dispose() {
        C3404f.m4335r(this.scope, null);
    }

    public final void flushBatches(String incomingType) {
        for (Map.Entry<String, Batched<?>> entry : this.batches.entrySet()) {
            String key = entry.getKey();
            Batched<?> value = entry.getValue();
            if (!C12238m.areEqual(key, incomingType)) {
                value.flush();
            }
        }
    }

    public /* synthetic */ BatchManager(CoroutineDispatcher coroutineDispatcher, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineDispatcher, (i & 2) != 0 ? ClockFactory.get() : clock);
    }
}

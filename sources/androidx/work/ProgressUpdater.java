package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.UUID;
import p007b.p225i.p355b.p359d.p360a.InterfaceFutureC4539a;

/* JADX INFO: loaded from: classes.dex */
public interface ProgressUpdater {
    @NonNull
    InterfaceFutureC4539a<Void> updateProgress(@NonNull Context context, @NonNull UUID uuid, @NonNull Data data);
}

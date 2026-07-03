package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.UUID;
import p007b.p225i.p355b.p359d.p360a.InterfaceFutureC4539a;

/* JADX INFO: loaded from: classes.dex */
public interface ForegroundUpdater {
    @NonNull
    InterfaceFutureC4539a<Void> setForegroundAsync(@NonNull Context context, @NonNull UUID uuid, @NonNull ForegroundInfo foregroundInfo);
}

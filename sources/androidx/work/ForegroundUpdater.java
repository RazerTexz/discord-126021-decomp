package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import b.i.b.d.a.ListenableFuture8;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public interface ForegroundUpdater {
    @NonNull
    ListenableFuture8<Void> setForegroundAsync(@NonNull Context context, @NonNull UUID uuid, @NonNull ForegroundInfo foregroundInfo);
}

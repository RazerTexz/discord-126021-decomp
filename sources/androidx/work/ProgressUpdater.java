package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import b.i.b.d.a.a;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public interface ProgressUpdater {
    @NonNull
    a<Void> updateProgress(@NonNull Context context, @NonNull UUID uuid, @NonNull Data data);
}

package b.i.c.o;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;

/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    @NonNull
    public abstract Task<PendingDynamicLinkData> a(@NonNull Intent intent);
}

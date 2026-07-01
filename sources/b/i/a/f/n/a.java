package b.i.a.f.n;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public interface a<TResult, TContinuationResult> {
    @RecentlyNonNull
    TContinuationResult a(@RecentlyNonNull Task<TResult> task) throws Exception;
}

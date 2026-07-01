package androidx.core.app;

import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public interface JobIntentService$CompatJobEngine {
    IBinder compatGetBinder();

    JobIntentService$GenericWorkItem dequeueWork();
}

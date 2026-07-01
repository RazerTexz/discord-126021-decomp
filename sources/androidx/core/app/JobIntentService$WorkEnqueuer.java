package androidx.core.app;

import android.content.ComponentName;
import android.content.Intent;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class JobIntentService$WorkEnqueuer {
    public final ComponentName mComponentName;
    public boolean mHasJobId;
    public int mJobId;

    public JobIntentService$WorkEnqueuer(ComponentName componentName) {
        this.mComponentName = componentName;
    }

    public abstract void enqueueWork(Intent intent);

    public void ensureJobId(int i) {
        if (!this.mHasJobId) {
            this.mHasJobId = true;
            this.mJobId = i;
        } else {
            if (this.mJobId == i) {
                return;
            }
            StringBuilder sbV = a.V("Given job ID ", i, " is different than previous ");
            sbV.append(this.mJobId);
            throw new IllegalArgumentException(sbV.toString());
        }
    }

    public void serviceProcessingFinished() {
    }

    public void serviceProcessingStarted() {
    }

    public void serviceStartReceived() {
    }
}

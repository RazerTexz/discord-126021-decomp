package androidx.media;

import android.os.Bundle;
import androidx.annotation.Nullable;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserServiceCompat$Result<T> {
    private final Object mDebug;
    private boolean mDetachCalled;
    private int mFlags;
    private boolean mSendErrorCalled;
    private boolean mSendResultCalled;

    public MediaBrowserServiceCompat$Result(Object obj) {
        this.mDebug = obj;
    }

    private void checkExtraFields(@Nullable Bundle bundle) {
        if (bundle != null && bundle.containsKey("android.media.browse.extra.DOWNLOAD_PROGRESS")) {
            float f = bundle.getFloat("android.media.browse.extra.DOWNLOAD_PROGRESS");
            if (f < -1.0E-5f || f > 1.00001f) {
                throw new IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0]");
            }
        }
    }

    public void detach() {
        if (this.mDetachCalled) {
            StringBuilder sbU = a.U("detach() called when detach() had already been called for: ");
            sbU.append(this.mDebug);
            throw new IllegalStateException(sbU.toString());
        }
        if (this.mSendResultCalled) {
            StringBuilder sbU2 = a.U("detach() called when sendResult() had already been called for: ");
            sbU2.append(this.mDebug);
            throw new IllegalStateException(sbU2.toString());
        }
        if (!this.mSendErrorCalled) {
            this.mDetachCalled = true;
        } else {
            StringBuilder sbU3 = a.U("detach() called when sendError() had already been called for: ");
            sbU3.append(this.mDebug);
            throw new IllegalStateException(sbU3.toString());
        }
    }

    public int getFlags() {
        return this.mFlags;
    }

    public boolean isDone() {
        return this.mDetachCalled || this.mSendResultCalled || this.mSendErrorCalled;
    }

    public void onErrorSent(@Nullable Bundle bundle) {
        StringBuilder sbU = a.U("It is not supported to send an error for ");
        sbU.append(this.mDebug);
        throw new UnsupportedOperationException(sbU.toString());
    }

    public void onProgressUpdateSent(@Nullable Bundle bundle) {
        StringBuilder sbU = a.U("It is not supported to send an interim update for ");
        sbU.append(this.mDebug);
        throw new UnsupportedOperationException(sbU.toString());
    }

    public void onResultSent(@Nullable T t) {
    }

    public void sendError(@Nullable Bundle bundle) {
        if (this.mSendResultCalled || this.mSendErrorCalled) {
            StringBuilder sbU = a.U("sendError() called when either sendResult() or sendError() had already been called for: ");
            sbU.append(this.mDebug);
            throw new IllegalStateException(sbU.toString());
        }
        this.mSendErrorCalled = true;
        onErrorSent(bundle);
    }

    public void sendProgressUpdate(@Nullable Bundle bundle) {
        if (this.mSendResultCalled || this.mSendErrorCalled) {
            StringBuilder sbU = a.U("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: ");
            sbU.append(this.mDebug);
            throw new IllegalStateException(sbU.toString());
        }
        checkExtraFields(bundle);
        onProgressUpdateSent(bundle);
    }

    public void sendResult(@Nullable T t) {
        if (this.mSendResultCalled || this.mSendErrorCalled) {
            StringBuilder sbU = a.U("sendResult() called when either sendResult() or sendError() had already been called for: ");
            sbU.append(this.mDebug);
            throw new IllegalStateException(sbU.toString());
        }
        this.mSendResultCalled = true;
        onResultSent(t);
    }

    public void setFlags(int i) {
        this.mFlags = i;
    }
}

package androidx.asynclayoutinflater.view;

import android.content.Context;
import android.os.Handler;
import android.os.Handler$Callback;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class AsyncLayoutInflater {
    private static final String TAG = "AsyncLayoutInflater";
    public LayoutInflater mInflater;
    private Handler$Callback mHandlerCallback = new AsyncLayoutInflater$1(this);
    public Handler mHandler = new Handler(this.mHandlerCallback);
    public AsyncLayoutInflater$InflateThread mInflateThread = AsyncLayoutInflater$InflateThread.getInstance();

    public AsyncLayoutInflater(@NonNull Context context) {
        this.mInflater = new AsyncLayoutInflater$BasicInflater(context);
    }

    @UiThread
    public void inflate(@LayoutRes int i, @Nullable ViewGroup viewGroup, @NonNull AsyncLayoutInflater$OnInflateFinishedListener asyncLayoutInflater$OnInflateFinishedListener) {
        Objects.requireNonNull(asyncLayoutInflater$OnInflateFinishedListener, "callback argument may not be null!");
        AsyncLayoutInflater$InflateRequest asyncLayoutInflater$InflateRequestObtainRequest = this.mInflateThread.obtainRequest();
        asyncLayoutInflater$InflateRequestObtainRequest.inflater = this;
        asyncLayoutInflater$InflateRequestObtainRequest.resid = i;
        asyncLayoutInflater$InflateRequestObtainRequest.parent = viewGroup;
        asyncLayoutInflater$InflateRequestObtainRequest.callback = asyncLayoutInflater$OnInflateFinishedListener;
        this.mInflateThread.enqueue(asyncLayoutInflater$InflateRequestObtainRequest);
    }
}

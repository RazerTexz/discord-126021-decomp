package androidx.core.app;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.RequiresApi;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class ActivityCompat$SharedElementCallback21Impl extends android.app.SharedElementCallback {
    private final SharedElementCallback mCallback;

    public ActivityCompat$SharedElementCallback21Impl(SharedElementCallback sharedElementCallback) {
        this.mCallback = sharedElementCallback;
    }

    @Override // android.app.SharedElementCallback
    public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
        return this.mCallback.onCaptureSharedElementSnapshot(view, matrix, rectF);
    }

    @Override // android.app.SharedElementCallback
    public View onCreateSnapshotView(Context context, Parcelable parcelable) {
        return this.mCallback.onCreateSnapshotView(context, parcelable);
    }

    @Override // android.app.SharedElementCallback
    public void onMapSharedElements(List<String> list, Map<String, View> map) {
        this.mCallback.onMapSharedElements(list, map);
    }

    @Override // android.app.SharedElementCallback
    public void onRejectSharedElements(List<View> list) {
        this.mCallback.onRejectSharedElements(list);
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
        this.mCallback.onSharedElementEnd(list, list2, list3);
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
        this.mCallback.onSharedElementStart(list, list2, list3);
    }

    @Override // android.app.SharedElementCallback
    @RequiresApi(23)
    public void onSharedElementsArrived(List<String> list, List<View> list2, android.app.SharedElementCallback$OnSharedElementsReadyListener sharedElementCallback$OnSharedElementsReadyListener) {
        this.mCallback.onSharedElementsArrived(list, list2, new ActivityCompat$SharedElementCallback21Impl$1(this, sharedElementCallback$OnSharedElementsReadyListener));
    }
}

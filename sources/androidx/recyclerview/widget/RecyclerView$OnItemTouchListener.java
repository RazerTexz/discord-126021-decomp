package androidx.recyclerview.widget;

import android.view.MotionEvent;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface RecyclerView$OnItemTouchListener {
    boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);

    void onRequestDisallowInterceptTouchEvent(boolean z2);

    void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);
}

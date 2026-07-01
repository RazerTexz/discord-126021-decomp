package androidx.recyclerview.widget;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface RecyclerView$OnChildAttachStateChangeListener {
    void onChildViewAttachedToWindow(@NonNull View view);

    void onChildViewDetachedFromWindow(@NonNull View view);
}

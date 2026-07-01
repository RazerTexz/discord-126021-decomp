package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public interface ViewBoundsCheck$Callback {
    View getChildAt(int i);

    int getChildEnd(View view);

    int getChildStart(View view);

    int getParentEnd();

    int getParentStart();
}

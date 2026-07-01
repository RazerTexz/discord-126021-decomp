package androidx.drawerlayout.widget;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface DrawerLayout$DrawerListener {
    void onDrawerClosed(@NonNull View view);

    void onDrawerOpened(@NonNull View view);

    void onDrawerSlide(@NonNull View view, float f);

    void onDrawerStateChanged(int i);
}

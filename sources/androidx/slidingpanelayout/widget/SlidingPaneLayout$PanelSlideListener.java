package androidx.slidingpanelayout.widget;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface SlidingPaneLayout$PanelSlideListener {
    void onPanelClosed(@NonNull View view);

    void onPanelOpened(@NonNull View view);

    void onPanelSlide(@NonNull View view, float f);
}

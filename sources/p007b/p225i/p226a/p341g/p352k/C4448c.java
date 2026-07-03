package p007b.p225i.p226a.p341g.p352k;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.C10817R;
import com.google.android.material.timepicker.ClockFaceView;

/* JADX INFO: renamed from: b.i.a.g.k.c */
/* JADX INFO: compiled from: ClockFaceView.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4448c extends AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ClockFaceView f11859a;

    public C4448c(ClockFaceView clockFaceView) {
        this.f11859a = clockFaceView;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        int iIntValue = ((Integer) view.getTag(C10817R.id.material_value_index)).intValue();
        if (iIntValue > 0) {
            accessibilityNodeInfoCompat.setTraversalAfter(this.f11859a.f21189p.get(iIntValue - 1));
        }
        accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, iIntValue, 1, false, view.isSelected()));
    }
}

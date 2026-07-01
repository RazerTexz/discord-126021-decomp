package b.i.a.g.d;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.datepicker.MaterialCalendarGridView;

/* JADX INFO: renamed from: b.i.a.g.d.f, reason: use source file name */
/* JADX INFO: compiled from: MaterialCalendarGridView.java */
/* JADX INFO: loaded from: classes3.dex */
public class MaterialCalendarGridView2 extends AccessibilityDelegateCompat {
    public MaterialCalendarGridView2(MaterialCalendarGridView materialCalendarGridView) {
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setCollectionInfo(null);
    }
}

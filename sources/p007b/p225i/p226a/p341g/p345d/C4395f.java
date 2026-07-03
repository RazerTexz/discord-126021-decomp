package p007b.p225i.p226a.p341g.p345d;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.datepicker.MaterialCalendarGridView;

/* JADX INFO: renamed from: b.i.a.g.d.f */
/* JADX INFO: compiled from: MaterialCalendarGridView.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4395f extends AccessibilityDelegateCompat {
    public C4395f(MaterialCalendarGridView materialCalendarGridView) {
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setCollectionInfo(null);
    }
}

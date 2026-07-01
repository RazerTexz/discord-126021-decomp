package b.i.a.g.j;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textfield.TextInputLayout$AccessibilityDelegate;

/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class h$c extends TextInputLayout$AccessibilityDelegate {
    public final /* synthetic */ h a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$c(h hVar, TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.a = hVar;
    }

    @Override // com.google.android.material.textfield.TextInputLayout$AccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        if (!h.e(this.a.a.getEditText())) {
            accessibilityNodeInfoCompat.setClassName(Spinner.class.getName());
        }
        if (accessibilityNodeInfoCompat.isShowingHintText()) {
            accessibilityNodeInfoCompat.setHintText(null);
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onPopulateAccessibilityEvent(View view, @NonNull AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(view, accessibilityEvent);
        AutoCompleteTextView autoCompleteTextViewD = h.d(this.a.a.getEditText());
        if (accessibilityEvent.getEventType() == 1 && this.a.n.isTouchExplorationEnabled() && !h.e(this.a.a.getEditText())) {
            h.g(this.a, autoCompleteTextViewD);
        }
    }
}

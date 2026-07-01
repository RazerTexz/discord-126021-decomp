package com.google.android.material.textfield;

import android.os.Build$VERSION;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$id;

/* JADX INFO: loaded from: classes3.dex */
public class TextInputLayout$AccessibilityDelegate extends AccessibilityDelegateCompat {
    private final TextInputLayout layout;

    public TextInputLayout$AccessibilityDelegate(@NonNull TextInputLayout textInputLayout) {
        this.layout = textInputLayout;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        EditText editText = this.layout.getEditText();
        CharSequence text = editText != null ? editText.getText() : null;
        CharSequence hint = this.layout.getHint();
        CharSequence error = this.layout.getError();
        CharSequence placeholderText = this.layout.getPlaceholderText();
        int counterMaxLength = this.layout.getCounterMaxLength();
        CharSequence counterOverflowDescription = this.layout.getCounterOverflowDescription();
        boolean z2 = !TextUtils.isEmpty(text);
        boolean z3 = !TextUtils.isEmpty(hint);
        boolean z4 = !this.layout.isHintExpanded();
        boolean z5 = !TextUtils.isEmpty(error);
        boolean z6 = z5 || !TextUtils.isEmpty(counterOverflowDescription);
        String string = z3 ? hint.toString() : "";
        if (z2) {
            accessibilityNodeInfoCompat.setText(text);
        } else if (!TextUtils.isEmpty(string)) {
            accessibilityNodeInfoCompat.setText(string);
            if (z4 && placeholderText != null) {
                accessibilityNodeInfoCompat.setText(string + ", " + ((Object) placeholderText));
            }
        } else if (placeholderText != null) {
            accessibilityNodeInfoCompat.setText(placeholderText);
        }
        if (!TextUtils.isEmpty(string)) {
            if (Build$VERSION.SDK_INT >= 26) {
                accessibilityNodeInfoCompat.setHintText(string);
            } else {
                if (z2) {
                    string = ((Object) text) + ", " + string;
                }
                accessibilityNodeInfoCompat.setText(string);
            }
            accessibilityNodeInfoCompat.setShowingHintText(!z2);
        }
        if (text == null || text.length() != counterMaxLength) {
            counterMaxLength = -1;
        }
        accessibilityNodeInfoCompat.setMaxTextLength(counterMaxLength);
        if (z6) {
            if (!z5) {
                error = counterOverflowDescription;
            }
            accessibilityNodeInfoCompat.setError(error);
        }
        if (editText != null) {
            editText.setLabelFor(R$id.textinput_helper_text);
        }
    }
}

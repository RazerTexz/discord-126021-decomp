package com.discord.widgets.chat.list;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import defpackage.SpoilerSpan;
import java.util.ArrayList;

/* JADX INFO: compiled from: ChatListItemMessageAccessibilityDelegate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatListItemMessageAccessibilityDelegate extends AccessibilityDelegateCompat {
    private final TextView nameView;
    private final TextView tagView;
    private final TextView textView;
    private final TextView timestampView;

    public ChatListItemMessageAccessibilityDelegate(TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        Intrinsics3.checkNotNullParameter(textView, "textView");
        this.textView = textView;
        this.nameView = textView2;
        this.tagView = textView3;
        this.timestampView = textView4;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
        super.onInitializeAccessibilityNodeInfo(host, info);
        if (info == null || host == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.textView.getText());
        for (SpoilerSpan spoilerSpan : (SpoilerSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), SpoilerSpan.class)) {
            if (!spoilerSpan.l) {
                spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(spoilerSpan), spannableStringBuilder.getSpanEnd(spoilerSpan), FormatUtils.d(host, R.string.spoiler_hidden_a11y_label, new Object[0], (4 & 4) != 0 ? FormatUtils.c.j : null));
            }
        }
        ArrayList arrayList = new ArrayList();
        TextView textView = this.nameView;
        if (textView != null) {
            CharSequence text = textView.getText();
            Intrinsics3.checkNotNullExpressionValue(text, "nameView.text");
            arrayList.add(text);
        }
        TextView textView2 = this.tagView;
        if (textView2 != null) {
            if (textView2.getVisibility() == 0) {
                CharSequence text2 = this.tagView.getText();
                Intrinsics3.checkNotNullExpressionValue(text2, "tagView.text");
                arrayList.add(text2);
            }
        }
        TextView textView3 = this.timestampView;
        if (textView3 != null) {
            CharSequence text3 = textView3.getText();
            Intrinsics3.checkNotNullExpressionValue(text3, "timestampView.text");
            arrayList.add(text3);
        }
        if (!arrayList.isEmpty()) {
            spannableStringBuilder.replace(0, 0, (CharSequence) outline.J(new StringBuilder(), _Collections.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null), "\n"));
        }
        TextView textView4 = this.nameView;
        if (textView4 != null) {
            textView4.setImportantForAccessibility(4);
        }
        TextView textView5 = this.tagView;
        if (textView5 != null) {
            textView5.setImportantForAccessibility(4);
        }
        TextView textView6 = this.timestampView;
        if (textView6 != null) {
            textView6.setImportantForAccessibility(4);
        }
        this.textView.setImportantForAccessibility(4);
        info.setText(spannableStringBuilder);
        info.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        info.setMovementGranularities(15);
    }
}

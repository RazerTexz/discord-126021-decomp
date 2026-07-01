package com.discord.widgets.chat.list;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import b.a.k.b;
import b.d.b.a.a;
import d0.t.u;
import d0.z.d.m;
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
        m.checkNotNullParameter(textView, "textView");
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
                spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(spoilerSpan), spannableStringBuilder.getSpanEnd(spoilerSpan), b.j(host, 2131895746, new Object[0], null, 4));
            }
        }
        ArrayList arrayList = new ArrayList();
        TextView textView = this.nameView;
        if (textView != null) {
            CharSequence text = textView.getText();
            m.checkNotNullExpressionValue(text, "nameView.text");
            arrayList.add(text);
        }
        TextView textView2 = this.tagView;
        if (textView2 != null) {
            if (textView2.getVisibility() == 0) {
                CharSequence text2 = this.tagView.getText();
                m.checkNotNullExpressionValue(text2, "tagView.text");
                arrayList.add(text2);
            }
        }
        TextView textView3 = this.timestampView;
        if (textView3 != null) {
            CharSequence text3 = textView3.getText();
            m.checkNotNullExpressionValue(text3, "timestampView.text");
            arrayList.add(text3);
        }
        if (!arrayList.isEmpty()) {
            spannableStringBuilder.replace(0, 0, (CharSequence) a.J(new StringBuilder(), u.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null), "\n"));
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
        info.removeAction(AccessibilityNodeInfoCompat$AccessibilityActionCompat.ACTION_CLICK);
        info.setMovementGranularities(15);
    }
}

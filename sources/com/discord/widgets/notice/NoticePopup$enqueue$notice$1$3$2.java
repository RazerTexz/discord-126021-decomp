package com.discord.widgets.notice;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import com.discord.databinding.WidgetNoticePopupBinding;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import d0.z.d.m;

/* JADX INFO: compiled from: NoticePopup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NoticePopup$enqueue$notice$1$3$2 implements Runnable {
    public final /* synthetic */ WidgetNoticePopupBinding $binding;

    public NoticePopup$enqueue$notice$1$3$2(WidgetNoticePopupBinding widgetNoticePopupBinding) {
        this.$binding = widgetNoticePopupBinding;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.$binding.c;
        m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.popupBody");
        Layout layout = simpleDraweeSpanTextView.getLayout();
        int lineCount = layout != null ? layout.getLineCount() : 0;
        SimpleDraweeSpanTextView simpleDraweeSpanTextView2 = this.$binding.c;
        m.checkNotNullExpressionValue(simpleDraweeSpanTextView2, "binding.popupBody");
        if (lineCount > simpleDraweeSpanTextView2.getMaxLines()) {
            SimpleDraweeSpanTextView simpleDraweeSpanTextView3 = this.$binding.c;
            m.checkNotNullExpressionValue(simpleDraweeSpanTextView3, "binding.popupBody");
            Layout layout2 = simpleDraweeSpanTextView3.getLayout();
            SimpleDraweeSpanTextView simpleDraweeSpanTextView4 = this.$binding.c;
            m.checkNotNullExpressionValue(simpleDraweeSpanTextView4, "binding.popupBody");
            int lineEnd = layout2.getLineEnd(simpleDraweeSpanTextView4.getMaxLines() - 1);
            SimpleDraweeSpanTextView simpleDraweeSpanTextView5 = this.$binding.c;
            m.checkNotNullExpressionValue(simpleDraweeSpanTextView5, "binding.popupBody");
            CharSequence charSequenceSubSequence = simpleDraweeSpanTextView5.getText().subSequence(0, lineEnd - 1);
            SimpleDraweeSpanTextView simpleDraweeSpanTextView6 = this.$binding.c;
            m.checkNotNullExpressionValue(simpleDraweeSpanTextView6, "binding.popupBody");
            simpleDraweeSpanTextView6.setText(new SpannableStringBuilder(charSequenceSubSequence).append((CharSequence) "…"));
        }
    }
}

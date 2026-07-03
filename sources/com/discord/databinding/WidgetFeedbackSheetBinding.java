package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.voice.feedback.FeedbackView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetFeedbackSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f16623a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f16624b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final NestedScrollView f16625c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final FeedbackView f16626d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f16627e;

    public WidgetFeedbackSheetBinding(@NonNull NestedScrollView nestedScrollView, @NonNull ImageView imageView, @NonNull NestedScrollView nestedScrollView2, @NonNull FeedbackView feedbackView, @NonNull TextView textView) {
        this.f16623a = nestedScrollView;
        this.f16624b = imageView;
        this.f16625c = nestedScrollView2;
        this.f16626d = feedbackView;
        this.f16627e = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16623a;
    }
}

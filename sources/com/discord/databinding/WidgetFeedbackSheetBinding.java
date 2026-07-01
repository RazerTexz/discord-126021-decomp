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

    @NonNull
    public final NestedScrollView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2385b;

    @NonNull
    public final NestedScrollView c;

    @NonNull
    public final FeedbackView d;

    @NonNull
    public final TextView e;

    public WidgetFeedbackSheetBinding(@NonNull NestedScrollView nestedScrollView, @NonNull ImageView imageView, @NonNull NestedScrollView nestedScrollView2, @NonNull FeedbackView feedbackView, @NonNull TextView textView) {
        this.a = nestedScrollView;
        this.f2385b = imageView;
        this.c = nestedScrollView2;
        this.d = feedbackView;
        this.e = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}

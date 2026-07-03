package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;

/* JADX INFO: loaded from: classes.dex */
public final class ForumPostTagViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f15096a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeSpanTextView f15097b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15098c;

    public ForumPostTagViewBinding(@NonNull View view, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull TextView textView) {
        this.f15096a = view;
        this.f15097b = simpleDraweeSpanTextView;
        this.f15098c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15096a;
    }
}

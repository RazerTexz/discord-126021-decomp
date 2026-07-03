package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.UploadProgressView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemUploadProgressBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f16348a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f16349b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f16350c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final UploadProgressView f16351d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final UploadProgressView f16352e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final UploadProgressView f16353f;

    public WidgetChatListAdapterItemUploadProgressBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull UploadProgressView uploadProgressView, @NonNull UploadProgressView uploadProgressView2, @NonNull UploadProgressView uploadProgressView3) {
        this.f16348a = linearLayout;
        this.f16349b = imageView;
        this.f16350c = imageView2;
        this.f16351d = uploadProgressView;
        this.f16352e = uploadProgressView2;
        this.f16353f = uploadProgressView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16348a;
    }
}

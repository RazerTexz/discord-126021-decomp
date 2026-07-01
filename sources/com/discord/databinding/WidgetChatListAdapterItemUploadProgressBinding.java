package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.UploadProgressView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemUploadProgressBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2342b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final UploadProgressView d;

    @NonNull
    public final UploadProgressView e;

    @NonNull
    public final UploadProgressView f;

    public WidgetChatListAdapterItemUploadProgressBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull UploadProgressView uploadProgressView, @NonNull UploadProgressView uploadProgressView2, @NonNull UploadProgressView uploadProgressView3) {
        this.a = linearLayout;
        this.f2342b = imageView;
        this.c = imageView2;
        this.d = uploadProgressView;
        this.e = uploadProgressView2;
        this.f = uploadProgressView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}

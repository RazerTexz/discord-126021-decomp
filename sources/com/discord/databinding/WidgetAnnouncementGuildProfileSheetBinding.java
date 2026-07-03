package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetAnnouncementGuildProfileSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f15648a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f15649b;

    public WidgetAnnouncementGuildProfileSheetBinding(@NonNull NestedScrollView nestedScrollView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ImageView imageView) {
        this.f15648a = nestedScrollView;
        this.f15649b = simpleDraweeView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15648a;
    }
}

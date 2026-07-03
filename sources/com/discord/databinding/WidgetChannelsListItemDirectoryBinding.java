package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelsListItemDirectoryBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f16037a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f16038b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f16039c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f16040d;

    public WidgetChannelsListItemDirectoryBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f16037a = linearLayout;
        this.f16038b = imageView;
        this.f16039c = textView;
        this.f16040d = textView2;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static WidgetChannelsListItemDirectoryBinding m8406a(@NonNull View view) {
        int i = C5419R.id.directory_channel_icon;
        ImageView imageView = (ImageView) view.findViewById(C5419R.id.directory_channel_icon);
        if (imageView != null) {
            i = C5419R.id.directory_channel_name;
            TextView textView = (TextView) view.findViewById(C5419R.id.directory_channel_name);
            if (textView != null) {
                i = C5419R.id.directory_channel_unread_count;
                TextView textView2 = (TextView) view.findViewById(C5419R.id.directory_channel_unread_count);
                if (textView2 != null) {
                    return new WidgetChannelsListItemDirectoryBinding((LinearLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16037a;
    }
}

package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.R;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelsListItemDirectoryBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2291b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public WidgetChannelsListItemDirectoryBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = linearLayout;
        this.f2291b = imageView;
        this.c = textView;
        this.d = textView2;
    }

    @NonNull
    public static WidgetChannelsListItemDirectoryBinding a(@NonNull View view) {
        int i = R.id.directory_channel_icon;
        ImageView imageView = (ImageView) view.findViewById(R.id.directory_channel_icon);
        if (imageView != null) {
            i = R.id.directory_channel_name;
            TextView textView = (TextView) view.findViewById(R.id.directory_channel_name);
            if (textView != null) {
                i = R.id.directory_channel_unread_count;
                TextView textView2 = (TextView) view.findViewById(R.id.directory_channel_unread_count);
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
        return this.a;
    }
}

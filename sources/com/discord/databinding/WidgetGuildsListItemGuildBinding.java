package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.R;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildsListItemGuildBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2461b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final SimpleDraweeView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final FrameLayout f;

    @NonNull
    public final ImageView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final ImageView i;

    public WidgetGuildsListItemGuildBinding(@NonNull View view, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView3, @NonNull TextView textView2, @NonNull ImageView imageView4) {
        this.a = view;
        this.f2461b = imageView;
        this.c = imageView2;
        this.d = simpleDraweeView;
        this.e = textView;
        this.f = frameLayout;
        this.g = imageView3;
        this.h = textView2;
        this.i = imageView4;
    }

    @NonNull
    public static WidgetGuildsListItemGuildBinding a(@NonNull View view) {
        int i = R.id.guilds_item_application_status;
        ImageView imageView = (ImageView) view.findViewById(R.id.guilds_item_application_status);
        if (imageView != null) {
            i = R.id.guilds_item_application_stream;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.guilds_item_application_stream);
            if (imageView2 != null) {
                i = R.id.guilds_item_avatar;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.guilds_item_avatar);
                if (simpleDraweeView != null) {
                    i = R.id.guilds_item_avatar_text;
                    TextView textView = (TextView) view.findViewById(R.id.guilds_item_avatar_text);
                    if (textView != null) {
                        i = R.id.guilds_item_avatar_wrap;
                        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.guilds_item_avatar_wrap);
                        if (frameLayout != null) {
                            i = R.id.guilds_item_event_status;
                            ImageView imageView3 = (ImageView) view.findViewById(R.id.guilds_item_event_status);
                            if (imageView3 != null) {
                                i = R.id.guilds_item_mentions;
                                TextView textView2 = (TextView) view.findViewById(R.id.guilds_item_mentions);
                                if (textView2 != null) {
                                    i = R.id.guilds_item_voice;
                                    ImageView imageView4 = (ImageView) view.findViewById(R.id.guilds_item_voice);
                                    if (imageView4 != null) {
                                        return new WidgetGuildsListItemGuildBinding(view, imageView, imageView2, simpleDraweeView, textView, frameLayout, imageView3, textView2, imageView4);
                                    }
                                }
                            }
                        }
                    }
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

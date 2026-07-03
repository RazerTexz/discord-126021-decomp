package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildsListItemGuildBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f17106a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f17107b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f17108c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SimpleDraweeView f17109d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f17110e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final FrameLayout f17111f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final ImageView f17112g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final TextView f17113h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final ImageView f17114i;

    public WidgetGuildsListItemGuildBinding(@NonNull View view, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView3, @NonNull TextView textView2, @NonNull ImageView imageView4) {
        this.f17106a = view;
        this.f17107b = imageView;
        this.f17108c = imageView2;
        this.f17109d = simpleDraweeView;
        this.f17110e = textView;
        this.f17111f = frameLayout;
        this.f17112g = imageView3;
        this.f17113h = textView2;
        this.f17114i = imageView4;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static WidgetGuildsListItemGuildBinding m8419a(@NonNull View view) {
        int i = C5419R.id.guilds_item_application_status;
        ImageView imageView = (ImageView) view.findViewById(C5419R.id.guilds_item_application_status);
        if (imageView != null) {
            i = C5419R.id.guilds_item_application_stream;
            ImageView imageView2 = (ImageView) view.findViewById(C5419R.id.guilds_item_application_stream);
            if (imageView2 != null) {
                i = C5419R.id.guilds_item_avatar;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.guilds_item_avatar);
                if (simpleDraweeView != null) {
                    i = C5419R.id.guilds_item_avatar_text;
                    TextView textView = (TextView) view.findViewById(C5419R.id.guilds_item_avatar_text);
                    if (textView != null) {
                        i = C5419R.id.guilds_item_avatar_wrap;
                        FrameLayout frameLayout = (FrameLayout) view.findViewById(C5419R.id.guilds_item_avatar_wrap);
                        if (frameLayout != null) {
                            i = C5419R.id.guilds_item_event_status;
                            ImageView imageView3 = (ImageView) view.findViewById(C5419R.id.guilds_item_event_status);
                            if (imageView3 != null) {
                                i = C5419R.id.guilds_item_mentions;
                                TextView textView2 = (TextView) view.findViewById(C5419R.id.guilds_item_mentions);
                                if (textView2 != null) {
                                    i = C5419R.id.guilds_item_voice;
                                    ImageView imageView4 = (ImageView) view.findViewById(C5419R.id.guilds_item_voice);
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
        return this.f17106a;
    }
}

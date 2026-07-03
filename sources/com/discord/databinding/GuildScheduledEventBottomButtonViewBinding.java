package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;

/* JADX INFO: loaded from: classes.dex */
public final class GuildScheduledEventBottomButtonViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f15126a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f15127b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f15128c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15129d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final ImageView f15130e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f15131f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final ImageView f15132g;

    public GuildScheduledEventBottomButtonViewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull ImageView imageView3, @NonNull TextView textView2, @NonNull ImageView imageView4) {
        this.f15126a = constraintLayout;
        this.f15127b = imageView;
        this.f15128c = imageView2;
        this.f15129d = textView;
        this.f15130e = imageView3;
        this.f15131f = textView2;
        this.f15132g = imageView4;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static GuildScheduledEventBottomButtonViewBinding m8386a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(C5419R.layout.guild_scheduled_event_bottom_button_view, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        int i = C5419R.id.extra_button;
        ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.extra_button);
        if (imageView != null) {
            i = C5419R.id.primary_button;
            ImageView imageView2 = (ImageView) viewInflate.findViewById(C5419R.id.primary_button);
            if (imageView2 != null) {
                i = C5419R.id.primary_button_text;
                TextView textView = (TextView) viewInflate.findViewById(C5419R.id.primary_button_text);
                if (textView != null) {
                    i = C5419R.id.secondary_button;
                    ImageView imageView3 = (ImageView) viewInflate.findViewById(C5419R.id.secondary_button);
                    if (imageView3 != null) {
                        i = C5419R.id.secondary_button_text;
                        TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.secondary_button_text);
                        if (textView2 != null) {
                            i = C5419R.id.share_button;
                            ImageView imageView4 = (ImageView) viewInflate.findViewById(C5419R.id.share_button);
                            if (imageView4 != null) {
                                return new GuildScheduledEventBottomButtonViewBinding((ConstraintLayout) viewInflate, imageView, imageView2, textView, imageView3, textView2, imageView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15126a;
    }
}

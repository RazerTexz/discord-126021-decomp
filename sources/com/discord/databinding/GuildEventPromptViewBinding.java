package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: loaded from: classes.dex */
public final class GuildEventPromptViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f15121a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f15122b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f15123c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialTextView f15124d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final MaterialTextView f15125e;

    public GuildEventPromptViewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull MaterialTextView materialTextView, @NonNull MaterialTextView materialTextView2) {
        this.f15121a = constraintLayout;
        this.f15122b = imageView2;
        this.f15123c = imageView3;
        this.f15124d = materialTextView;
        this.f15125e = materialTextView2;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static GuildEventPromptViewBinding m8385a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(C5419R.layout.guild_event_prompt_view, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        int i = C5419R.id.arrow;
        ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.arrow);
        if (imageView != null) {
            i = C5419R.id.icon;
            ImageView imageView2 = (ImageView) viewInflate.findViewById(C5419R.id.icon);
            if (imageView2 != null) {
                i = C5419R.id.icon_bg;
                ImageView imageView3 = (ImageView) viewInflate.findViewById(C5419R.id.icon_bg);
                if (imageView3 != null) {
                    i = C5419R.id.subtitle;
                    MaterialTextView materialTextView = (MaterialTextView) viewInflate.findViewById(C5419R.id.subtitle);
                    if (materialTextView != null) {
                        i = C5419R.id.title;
                        MaterialTextView materialTextView2 = (MaterialTextView) viewInflate.findViewById(C5419R.id.title);
                        if (materialTextView2 != null) {
                            return new GuildEventPromptViewBinding((ConstraintLayout) viewInflate, imageView, imageView2, imageView3, materialTextView, materialTextView2);
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
        return this.f15121a;
    }
}

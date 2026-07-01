package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.R;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: loaded from: classes.dex */
public final class GuildEventPromptViewBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2117b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final MaterialTextView d;

    @NonNull
    public final MaterialTextView e;

    public GuildEventPromptViewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull MaterialTextView materialTextView, @NonNull MaterialTextView materialTextView2) {
        this.a = constraintLayout;
        this.f2117b = imageView2;
        this.c = imageView3;
        this.d = materialTextView;
        this.e = materialTextView2;
    }

    @NonNull
    public static GuildEventPromptViewBinding a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.guild_event_prompt_view, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        int i = R.id.arrow;
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.arrow);
        if (imageView != null) {
            i = R.id.icon;
            ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.icon);
            if (imageView2 != null) {
                i = R.id.icon_bg;
                ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.icon_bg);
                if (imageView3 != null) {
                    i = R.id.subtitle;
                    MaterialTextView materialTextView = (MaterialTextView) viewInflate.findViewById(R.id.subtitle);
                    if (materialTextView != null) {
                        i = R.id.title;
                        MaterialTextView materialTextView2 = (MaterialTextView) viewInflate.findViewById(R.id.title);
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
        return this.a;
    }
}

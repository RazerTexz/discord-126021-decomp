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
public final class GuildScheduledEventDateViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f15133a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f15134b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15135c;

    public GuildScheduledEventDateViewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f15133a = constraintLayout;
        this.f15134b = imageView;
        this.f15135c = textView;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static GuildScheduledEventDateViewBinding m8387a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(C5419R.layout.guild_scheduled_event_date_view, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        int i = C5419R.id.guild_scheduled_event_date_view_icon;
        ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.guild_scheduled_event_date_view_icon);
        if (imageView != null) {
            i = C5419R.id.guild_scheduled_event_date_view_text;
            TextView textView = (TextView) viewInflate.findViewById(C5419R.id.guild_scheduled_event_date_view_text);
            if (textView != null) {
                return new GuildScheduledEventDateViewBinding((ConstraintLayout) viewInflate, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15133a;
    }
}

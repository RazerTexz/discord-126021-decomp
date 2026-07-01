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
import com.discord.R;

/* JADX INFO: loaded from: classes.dex */
public final class GuildScheduledEventDateViewBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2119b;

    @NonNull
    public final TextView c;

    public GuildScheduledEventDateViewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.a = constraintLayout;
        this.f2119b = imageView;
        this.c = textView;
    }

    @NonNull
    public static GuildScheduledEventDateViewBinding a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.guild_scheduled_event_date_view, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        int i = R.id.guild_scheduled_event_date_view_icon;
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.guild_scheduled_event_date_view_icon);
        if (imageView != null) {
            i = R.id.guild_scheduled_event_date_view_text;
            TextView textView = (TextView) viewInflate.findViewById(R.id.guild_scheduled_event_date_view_text);
            if (textView != null) {
                return new GuildScheduledEventDateViewBinding((ConstraintLayout) viewInflate, imageView, textView);
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

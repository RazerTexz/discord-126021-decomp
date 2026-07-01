package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.discord.R;
import com.discord.views.GuildView;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: loaded from: classes.dex */
public final class DiscordHubAddServerListItemBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final GuildView f2098b;

    @NonNull
    public final MaterialCardView c;

    @NonNull
    public final TextView d;

    public DiscordHubAddServerListItemBinding(@NonNull FrameLayout frameLayout, @NonNull GuildView guildView, @NonNull MaterialCardView materialCardView, @NonNull TextView textView) {
        this.a = frameLayout;
        this.f2098b = guildView;
        this.c = materialCardView;
        this.d = textView;
    }

    @NonNull
    public static DiscordHubAddServerListItemBinding a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.discord_hub_add_server_list_item, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        int i = R.id.discord_u_add_server_list_item_image;
        GuildView guildView = (GuildView) viewInflate.findViewById(R.id.discord_u_add_server_list_item_image);
        if (guildView != null) {
            i = R.id.discord_u_add_server_list_item_layout;
            MaterialCardView materialCardView = (MaterialCardView) viewInflate.findViewById(R.id.discord_u_add_server_list_item_layout);
            if (materialCardView != null) {
                i = R.id.discord_u_add_server_list_item_text;
                TextView textView = (TextView) viewInflate.findViewById(R.id.discord_u_add_server_list_item_text);
                if (textView != null) {
                    return new DiscordHubAddServerListItemBinding((FrameLayout) viewInflate, guildView, materialCardView, textView);
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

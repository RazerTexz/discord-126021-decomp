package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.discord.views.GuildView;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: loaded from: classes.dex */
public final class DiscordHubAddServerListItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f15046a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final GuildView f15047b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialCardView f15048c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15049d;

    public DiscordHubAddServerListItemBinding(@NonNull FrameLayout frameLayout, @NonNull GuildView guildView, @NonNull MaterialCardView materialCardView, @NonNull TextView textView) {
        this.f15046a = frameLayout;
        this.f15047b = guildView;
        this.f15048c = materialCardView;
        this.f15049d = textView;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static DiscordHubAddServerListItemBinding m8382a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(C5419R.layout.discord_hub_add_server_list_item, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        int i = C5419R.id.discord_u_add_server_list_item_image;
        GuildView guildView = (GuildView) viewInflate.findViewById(C5419R.id.discord_u_add_server_list_item_image);
        if (guildView != null) {
            i = C5419R.id.discord_u_add_server_list_item_layout;
            MaterialCardView materialCardView = (MaterialCardView) viewInflate.findViewById(C5419R.id.discord_u_add_server_list_item_layout);
            if (materialCardView != null) {
                i = C5419R.id.discord_u_add_server_list_item_text;
                TextView textView = (TextView) viewInflate.findViewById(C5419R.id.discord_u_add_server_list_item_text);
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
        return this.f15046a;
    }
}

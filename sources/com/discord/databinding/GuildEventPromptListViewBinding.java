package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.widgets.guildscheduledevent.GuildEventPromptView;

/* JADX INFO: loaded from: classes.dex */
public final class GuildEventPromptListViewBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final GuildEventPromptView f2116b;

    @NonNull
    public final GuildEventPromptView c;

    @NonNull
    public final GuildEventPromptView d;

    public GuildEventPromptListViewBinding(@NonNull LinearLayout linearLayout, @NonNull GuildEventPromptView guildEventPromptView, @NonNull GuildEventPromptView guildEventPromptView2, @NonNull GuildEventPromptView guildEventPromptView3) {
        this.a = linearLayout;
        this.f2116b = guildEventPromptView;
        this.c = guildEventPromptView2;
        this.d = guildEventPromptView3;
    }

    @NonNull
    public static GuildEventPromptListViewBinding a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R$layout.guild_event_prompt_list_view, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        int i = R$id.create_event_button;
        GuildEventPromptView guildEventPromptView = (GuildEventPromptView) viewInflate.findViewById(R$id.create_event_button);
        if (guildEventPromptView != null) {
            i = R$id.start_event_button;
            GuildEventPromptView guildEventPromptView2 = (GuildEventPromptView) viewInflate.findViewById(R$id.start_event_button);
            if (guildEventPromptView2 != null) {
                i = R$id.start_stage_button;
                GuildEventPromptView guildEventPromptView3 = (GuildEventPromptView) viewInflate.findViewById(R$id.start_stage_button);
                if (guildEventPromptView3 != null) {
                    return new GuildEventPromptListViewBinding((LinearLayout) viewInflate, guildEventPromptView, guildEventPromptView2, guildEventPromptView3);
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

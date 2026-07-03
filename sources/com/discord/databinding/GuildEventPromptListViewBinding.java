package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.discord.widgets.guildscheduledevent.GuildEventPromptView;

/* JADX INFO: loaded from: classes.dex */
public final class GuildEventPromptListViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15117a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final GuildEventPromptView f15118b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final GuildEventPromptView f15119c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final GuildEventPromptView f15120d;

    public GuildEventPromptListViewBinding(@NonNull LinearLayout linearLayout, @NonNull GuildEventPromptView guildEventPromptView, @NonNull GuildEventPromptView guildEventPromptView2, @NonNull GuildEventPromptView guildEventPromptView3) {
        this.f15117a = linearLayout;
        this.f15118b = guildEventPromptView;
        this.f15119c = guildEventPromptView2;
        this.f15120d = guildEventPromptView3;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static GuildEventPromptListViewBinding m8384a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(C5419R.layout.guild_event_prompt_list_view, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        int i = C5419R.id.create_event_button;
        GuildEventPromptView guildEventPromptView = (GuildEventPromptView) viewInflate.findViewById(C5419R.id.create_event_button);
        if (guildEventPromptView != null) {
            i = C5419R.id.start_event_button;
            GuildEventPromptView guildEventPromptView2 = (GuildEventPromptView) viewInflate.findViewById(C5419R.id.start_event_button);
            if (guildEventPromptView2 != null) {
                i = C5419R.id.start_stage_button;
                GuildEventPromptView guildEventPromptView3 = (GuildEventPromptView) viewInflate.findViewById(C5419R.id.start_stage_button);
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
        return this.f15117a;
    }
}

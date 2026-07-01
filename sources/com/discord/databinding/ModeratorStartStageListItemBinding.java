package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.guildscheduledevent.GuildEventPromptView;

/* JADX INFO: loaded from: classes.dex */
public final class ModeratorStartStageListItemBinding implements ViewBinding {

    @NonNull
    public final GuildEventPromptView a;

    public ModeratorStartStageListItemBinding(@NonNull GuildEventPromptView guildEventPromptView) {
        this.a = guildEventPromptView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}

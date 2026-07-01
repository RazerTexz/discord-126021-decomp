package com.discord.widgets.stage.start;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b.a.k.b;
import com.discord.R$layout;
import com.discord.databinding.ModeratorStartStageListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;
import com.discord.widgets.guildscheduledevent.GuildEventPromptView;
import d0.z.d.m;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModeratorStartStageAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModeratorStartStageAdapter$ListItemViewHolder extends ModeratorStartStageAdapter$CreateStageEventViewHolder {
    private final ModeratorStartStageListItemBinding binding;
    public final /* synthetic */ ModeratorStartStageAdapter this$0;

    /* JADX WARN: Illegal instructions before constructor call */
    public ModeratorStartStageAdapter$ListItemViewHolder(ModeratorStartStageAdapter moderatorStartStageAdapter, ModeratorStartStageListItemBinding moderatorStartStageListItemBinding) {
        m.checkNotNullParameter(moderatorStartStageListItemBinding, "binding");
        this.this$0 = moderatorStartStageAdapter;
        GuildEventPromptView guildEventPromptView = moderatorStartStageListItemBinding.a;
        m.checkNotNullExpressionValue(guildEventPromptView, "binding.root");
        super(moderatorStartStageAdapter, guildEventPromptView);
        this.binding = moderatorStartStageListItemBinding;
    }

    public final ModeratorStartStageListItemBinding getBinding() {
        return this.binding;
    }

    @Override // com.discord.widgets.stage.start.ModeratorStartStageAdapter$CreateStageEventViewHolder, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ModeratorStartStageItem moderatorStartStageItem) {
        onConfigure(i, moderatorStartStageItem);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.stage.start.ModeratorStartStageAdapter$CreateStageEventViewHolder
    public void onConfigure(int position, ModeratorStartStageItem data) {
        Pair pair;
        m.checkNotNullParameter(data, "data");
        super.onConfigure2(position, data);
        ModeratorStartStageItem$ListItem moderatorStartStageItem$ListItem = (ModeratorStartStageItem$ListItem) data;
        if (moderatorStartStageItem$ListItem instanceof ModeratorStartStageItem$ListItem$StaticOption) {
            ModeratorStartStageItem$ListItem$StaticOption moderatorStartStageItem$ListItem$StaticOption = (ModeratorStartStageItem$ListItem$StaticOption) moderatorStartStageItem$ListItem;
            pair = new Pair(b.h(this.this$0.getContext(), moderatorStartStageItem$ListItem$StaticOption.getTitleRes(), new Object[0], null, 4), b.h(this.this$0.getContext(), moderatorStartStageItem$ListItem$StaticOption.getSubtitleRes(), new Object[0], null, 4));
        } else {
            if (!(moderatorStartStageItem$ListItem instanceof ModeratorStartStageItem$ListItem$Event)) {
                throw new NoWhenBranchMatchedException();
            }
            ModeratorStartStageItem$ListItem$Event moderatorStartStageItem$ListItem$Event = (ModeratorStartStageItem$ListItem$Event) moderatorStartStageItem$ListItem;
            pair = new Pair(moderatorStartStageItem$ListItem$Event.getEvent().getName(), GuildScheduledEventUtilitiesKt.getEventStartingTimeString(moderatorStartStageItem$ListItem$Event.getEvent(), this.this$0.getContext()));
        }
        this.binding.a.configure(moderatorStartStageItem$ListItem.getIconRes(), moderatorStartStageItem$ListItem.getIconBgColorRes(), (CharSequence) pair.component1(), (CharSequence) pair.component2());
    }

    public ModeratorStartStageAdapter$ListItemViewHolder(ModeratorStartStageAdapter moderatorStartStageAdapter, ModeratorStartStageListItemBinding moderatorStartStageListItemBinding, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            View viewInflate = LayoutInflater.from(moderatorStartStageAdapter.getContext()).inflate(R$layout.moderator_start_stage_list_item, (ViewGroup) moderatorStartStageAdapter.getRecycler(), false);
            Objects.requireNonNull(viewInflate, "rootView");
            ModeratorStartStageListItemBinding moderatorStartStageListItemBinding2 = new ModeratorStartStageListItemBinding((GuildEventPromptView) viewInflate);
            m.checkNotNullExpressionValue(moderatorStartStageListItemBinding2, "ModeratorStartStageListI…ontext), recycler, false)");
            moderatorStartStageListItemBinding = moderatorStartStageListItemBinding2;
        }
        this(moderatorStartStageAdapter, moderatorStartStageListItemBinding);
    }
}

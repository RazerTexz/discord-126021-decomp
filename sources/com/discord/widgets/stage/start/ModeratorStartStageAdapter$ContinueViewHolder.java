package com.discord.widgets.stage.start;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$layout;
import com.discord.databinding.ModeratorStartStageContinueItemBinding;
import d0.z.d.m;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModeratorStartStageAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModeratorStartStageAdapter$ContinueViewHolder extends ModeratorStartStageAdapter$CreateStageEventViewHolder {
    private final ModeratorStartStageContinueItemBinding binding;
    public final /* synthetic */ ModeratorStartStageAdapter this$0;

    /* JADX WARN: Illegal instructions before constructor call */
    public ModeratorStartStageAdapter$ContinueViewHolder(ModeratorStartStageAdapter moderatorStartStageAdapter, ModeratorStartStageContinueItemBinding moderatorStartStageContinueItemBinding) {
        m.checkNotNullParameter(moderatorStartStageContinueItemBinding, "binding");
        this.this$0 = moderatorStartStageAdapter;
        ConstraintLayout constraintLayout = moderatorStartStageContinueItemBinding.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        super(moderatorStartStageAdapter, constraintLayout);
        this.binding = moderatorStartStageContinueItemBinding;
    }

    public final ModeratorStartStageContinueItemBinding getBinding() {
        return this.binding;
    }

    public ModeratorStartStageAdapter$ContinueViewHolder(ModeratorStartStageAdapter moderatorStartStageAdapter, ModeratorStartStageContinueItemBinding moderatorStartStageContinueItemBinding, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            View viewInflate = LayoutInflater.from(moderatorStartStageAdapter.getContext()).inflate(R$layout.moderator_start_stage_continue_item, (ViewGroup) moderatorStartStageAdapter.getRecycler(), false);
            Objects.requireNonNull(viewInflate, "rootView");
            ModeratorStartStageContinueItemBinding moderatorStartStageContinueItemBinding2 = new ModeratorStartStageContinueItemBinding((ConstraintLayout) viewInflate);
            m.checkNotNullExpressionValue(moderatorStartStageContinueItemBinding2, "ModeratorStartStageConti…ontext), recycler, false)");
            moderatorStartStageContinueItemBinding = moderatorStartStageContinueItemBinding2;
        }
        this(moderatorStartStageAdapter, moderatorStartStageContinueItemBinding);
    }
}

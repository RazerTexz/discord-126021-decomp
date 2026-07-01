package com.discord.widgets.stage.start;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.ModeratorStartStageHeaderItemBinding;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModeratorStartStageAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModeratorStartStageAdapter$HeaderViewHolder extends ModeratorStartStageAdapter$CreateStageEventViewHolder {
    private final ModeratorStartStageHeaderItemBinding binding;
    public final /* synthetic */ ModeratorStartStageAdapter this$0;

    /* JADX WARN: Illegal instructions before constructor call */
    public ModeratorStartStageAdapter$HeaderViewHolder(ModeratorStartStageAdapter moderatorStartStageAdapter, ModeratorStartStageHeaderItemBinding moderatorStartStageHeaderItemBinding) {
        m.checkNotNullParameter(moderatorStartStageHeaderItemBinding, "binding");
        this.this$0 = moderatorStartStageAdapter;
        ConstraintLayout constraintLayout = moderatorStartStageHeaderItemBinding.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        super(moderatorStartStageAdapter, constraintLayout);
        this.binding = moderatorStartStageHeaderItemBinding;
    }

    public final ModeratorStartStageHeaderItemBinding getBinding() {
        return this.binding;
    }

    public ModeratorStartStageAdapter$HeaderViewHolder(ModeratorStartStageAdapter moderatorStartStageAdapter, ModeratorStartStageHeaderItemBinding moderatorStartStageHeaderItemBinding, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            View viewInflate = LayoutInflater.from(moderatorStartStageAdapter.getContext()).inflate(R$layout.moderator_start_stage_header_item, (ViewGroup) moderatorStartStageAdapter.getRecycler(), false);
            int i2 = R$id.moderator_start_stage_icon;
            ImageView imageView = (ImageView) viewInflate.findViewById(R$id.moderator_start_stage_icon);
            if (imageView != null) {
                i2 = R$id.moderator_start_stage_subtitle;
                TextView textView = (TextView) viewInflate.findViewById(R$id.moderator_start_stage_subtitle);
                if (textView != null) {
                    i2 = R$id.moderator_start_stage_title;
                    TextView textView2 = (TextView) viewInflate.findViewById(R$id.moderator_start_stage_title);
                    if (textView2 != null) {
                        ModeratorStartStageHeaderItemBinding moderatorStartStageHeaderItemBinding2 = new ModeratorStartStageHeaderItemBinding((ConstraintLayout) viewInflate, imageView, textView, textView2);
                        m.checkNotNullExpressionValue(moderatorStartStageHeaderItemBinding2, "ModeratorStartStageHeade…ontext), recycler, false)");
                        moderatorStartStageHeaderItemBinding = moderatorStartStageHeaderItemBinding2;
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
        }
        this(moderatorStartStageAdapter, moderatorStartStageHeaderItemBinding);
    }
}

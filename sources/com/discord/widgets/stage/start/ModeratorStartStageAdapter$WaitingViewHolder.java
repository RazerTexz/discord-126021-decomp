package com.discord.widgets.stage.start;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.databinding.ModeratorStartStageWaitingItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.user.UserSummaryView;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModeratorStartStageAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModeratorStartStageAdapter$WaitingViewHolder extends ModeratorStartStageAdapter$CreateStageEventViewHolder {
    private final ModeratorStartStageWaitingItemBinding binding;
    public final /* synthetic */ ModeratorStartStageAdapter this$0;

    /* JADX WARN: Illegal instructions before constructor call */
    public ModeratorStartStageAdapter$WaitingViewHolder(ModeratorStartStageAdapter moderatorStartStageAdapter, ModeratorStartStageWaitingItemBinding moderatorStartStageWaitingItemBinding) {
        m.checkNotNullParameter(moderatorStartStageWaitingItemBinding, "binding");
        this.this$0 = moderatorStartStageAdapter;
        ConstraintLayout constraintLayout = moderatorStartStageWaitingItemBinding.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        super(moderatorStartStageAdapter, constraintLayout);
        this.binding = moderatorStartStageWaitingItemBinding;
    }

    public final ModeratorStartStageWaitingItemBinding getBinding() {
        return this.binding;
    }

    @Override // com.discord.widgets.stage.start.ModeratorStartStageAdapter$CreateStageEventViewHolder, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ModeratorStartStageItem moderatorStartStageItem) {
        onConfigure(i, moderatorStartStageItem);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.stage.start.ModeratorStartStageAdapter$CreateStageEventViewHolder
    public void onConfigure(int position, ModeratorStartStageItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure2(position, data);
        ModeratorStartStageItem$Waiting moderatorStartStageItem$Waiting = (ModeratorStartStageItem$Waiting) data;
        UserSummaryView.b(this.binding.f2129b, moderatorStartStageItem$Waiting.getUsers(), false, 2);
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.moderatorStartStageWaitingUserText");
        int size = moderatorStartStageItem$Waiting.getUsers().size();
        CharSequence charSequenceH = null;
        if (size == 1) {
            charSequenceH = b.h(this.this$0.getContext(), 2131895765, new Object[]{moderatorStartStageItem$Waiting.getUsers().get(0).getNickOrUserName()}, null, 4);
        } else if (size == 2) {
            charSequenceH = b.h(this.this$0.getContext(), 2131895766, new Object[]{moderatorStartStageItem$Waiting.getUsers().get(0).getNickOrUserName(), moderatorStartStageItem$Waiting.getUsers().get(1).getNickOrUserName()}, null, 4);
        } else if (size == 3) {
            charSequenceH = StringResourceUtilsKt.getI18nPluralString(this.this$0.getContext(), R$plurals.stage_audience_waiting_many_numOthers, moderatorStartStageItem$Waiting.getUsers().size() - 2, moderatorStartStageItem$Waiting.getUsers().get(0).getNickOrUserName(), moderatorStartStageItem$Waiting.getUsers().get(1).getNickOrUserName());
        }
        ViewExtensions.setTextAndVisibilityBy(textView, charSequenceH);
    }

    public ModeratorStartStageAdapter$WaitingViewHolder(ModeratorStartStageAdapter moderatorStartStageAdapter, ModeratorStartStageWaitingItemBinding moderatorStartStageWaitingItemBinding, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            View viewInflate = LayoutInflater.from(moderatorStartStageAdapter.getContext()).inflate(R$layout.moderator_start_stage_waiting_item, (ViewGroup) moderatorStartStageAdapter.getRecycler(), false);
            int i2 = R$id.moderator_start_stage_waiting_user_list;
            UserSummaryView userSummaryView = (UserSummaryView) viewInflate.findViewById(R$id.moderator_start_stage_waiting_user_list);
            if (userSummaryView != null) {
                i2 = R$id.moderator_start_stage_waiting_user_text;
                TextView textView = (TextView) viewInflate.findViewById(R$id.moderator_start_stage_waiting_user_text);
                if (textView != null) {
                    ModeratorStartStageWaitingItemBinding moderatorStartStageWaitingItemBinding2 = new ModeratorStartStageWaitingItemBinding((ConstraintLayout) viewInflate, userSummaryView, textView);
                    m.checkNotNullExpressionValue(moderatorStartStageWaitingItemBinding2, "ModeratorStartStageWaiti…ontext), recycler, false)");
                    moderatorStartStageWaitingItemBinding = moderatorStartStageWaitingItemBinding2;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
        }
        this(moderatorStartStageAdapter, moderatorStartStageWaitingItemBinding);
    }
}

package com.discord.widgets.stage.sheet;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.databinding.StageAudienceBlockedBottomSheetHeaderItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.google.android.material.textview.MaterialTextView;
import d0.z.d.m;

/* JADX INFO: compiled from: StageAudienceBlockedBottomSheetAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageAudienceBlockedBottomSheetAdapter$HeaderViewHolder extends MGRecyclerViewHolder<StageAudienceBlockedBottomSheetAdapter, MGRecyclerDataPayload> {
    private final StageAudienceBlockedBottomSheetHeaderItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageAudienceBlockedBottomSheetAdapter$HeaderViewHolder(StageAudienceBlockedBottomSheetAdapter stageAudienceBlockedBottomSheetAdapter) {
        super(R$layout.stage_audience_blocked_bottom_sheet_header_item, stageAudienceBlockedBottomSheetAdapter);
        m.checkNotNullParameter(stageAudienceBlockedBottomSheetAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.description;
        MaterialTextView materialTextView = (MaterialTextView) view.findViewById(R$id.description);
        if (materialTextView != null) {
            i = 2131365869;
            MaterialTextView materialTextView2 = (MaterialTextView) view.findViewById(2131365869);
            if (materialTextView2 != null) {
                StageAudienceBlockedBottomSheetHeaderItemBinding stageAudienceBlockedBottomSheetHeaderItemBinding = new StageAudienceBlockedBottomSheetHeaderItemBinding((ConstraintLayout) view, materialTextView, materialTextView2);
                m.checkNotNullExpressionValue(stageAudienceBlockedBottomSheetHeaderItemBinding, "StageAudienceBlockedBott…temBinding.bind(itemView)");
                this.binding = stageAudienceBlockedBottomSheetHeaderItemBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (data instanceof StageAudienceBlockedBottomSheetAdapter$ListItem$Header) {
            MaterialTextView materialTextView = this.binding.c;
            m.checkNotNullExpressionValue(materialTextView, "binding.title");
            StageAudienceBlockedBottomSheetAdapter$ListItem$Header stageAudienceBlockedBottomSheetAdapter$ListItem$Header = (StageAudienceBlockedBottomSheetAdapter$ListItem$Header) data;
            materialTextView.setText(b.h(a.x(this.itemView, "itemView", "itemView.context"), 2131895773, new Object[]{StringResourceUtilsKt.getI18nPluralString(a.x(this.itemView, "itemView", "itemView.context"), R$plurals.stage_blocked_users_title_plural_number, stageAudienceBlockedBottomSheetAdapter$ListItem$Header.getNumBlockedUsers(), new Object[0])}, null, 4));
            MaterialTextView materialTextView2 = this.binding.f2144b;
            m.checkNotNullExpressionValue(materialTextView2, "binding.description");
            materialTextView2.setText(b.h(a.x(this.itemView, "itemView", "itemView.context"), 2131895768, new Object[]{StringResourceUtilsKt.getI18nPluralString(a.x(this.itemView, "itemView", "itemView.context"), R$plurals.stage_blocked_users_body_number, stageAudienceBlockedBottomSheetAdapter$ListItem$Header.getNumBlockedUsers(), Integer.valueOf(stageAudienceBlockedBottomSheetAdapter$ListItem$Header.getNumBlockedUsers()))}, null, 4));
        }
    }
}

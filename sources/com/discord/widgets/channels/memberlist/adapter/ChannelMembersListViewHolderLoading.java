package com.discord.widgets.channels.memberlist.adapter;

import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.databinding.WidgetChannelMembersListItemLoadingBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.o;
import d0.t.h0;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: ChannelMembersListViewHolderLoading.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMembersListViewHolderLoading extends RecyclerView$ViewHolder {
    public static final ChannelMembersListViewHolderLoading$Companion Companion = new ChannelMembersListViewHolderLoading$Companion(null);
    private static final Map<Integer, Float> POSITION_PERCENT_MAP;
    private final WidgetChannelMembersListItemLoadingBinding binding;

    static {
        Float fValueOf = Float.valueOf(0.7f);
        Float fValueOf2 = Float.valueOf(0.3f);
        Float fValueOf3 = Float.valueOf(0.6f);
        Float fValueOf4 = Float.valueOf(0.4f);
        POSITION_PERCENT_MAP = h0.mapOf(o.to(0, fValueOf), o.to(1, fValueOf2), o.to(2, fValueOf3), o.to(3, fValueOf4), o.to(4, fValueOf3), o.to(5, Float.valueOf(0.8f)), o.to(6, fValueOf2), o.to(7, Float.valueOf(0.5f)), o.to(8, fValueOf), o.to(9, fValueOf4));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListViewHolderLoading(WidgetChannelMembersListItemLoadingBinding widgetChannelMembersListItemLoadingBinding) {
        super(widgetChannelMembersListItemLoadingBinding.a);
        m.checkNotNullParameter(widgetChannelMembersListItemLoadingBinding, "binding");
        this.binding = widgetChannelMembersListItemLoadingBinding;
    }

    public final void bind(int position) {
        Guideline guideline = this.binding.f2260b;
        Float f = POSITION_PERCENT_MAP.get(Integer.valueOf(position % 10));
        guideline.setGuidelinePercent(f != null ? f.floatValue() : 0.0f);
    }
}

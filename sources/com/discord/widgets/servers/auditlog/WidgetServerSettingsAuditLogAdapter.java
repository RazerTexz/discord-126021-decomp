package com.discord.widgets.servers.auditlog;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogAdapter extends MGRecyclerAdapterSimple<MGRecyclerDataPayload> {
    public static final WidgetServerSettingsAuditLogAdapter$Companion Companion = new WidgetServerSettingsAuditLogAdapter$Companion(null);
    private static final int ENTRY_ITEM = 0;
    private static final int LOADING_ITEM = 1;
    private boolean ensureExpandedIsVisible;
    private Function2<? super Long, ? super Long, Unit> onAuditLogAvatarClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsAuditLogAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        this.onAuditLogAvatarClicked = WidgetServerSettingsAuditLogAdapter$onAuditLogAvatarClicked$1.INSTANCE;
    }

    public static final /* synthetic */ boolean access$getEnsureExpandedIsVisible$p(WidgetServerSettingsAuditLogAdapter widgetServerSettingsAuditLogAdapter) {
        return widgetServerSettingsAuditLogAdapter.ensureExpandedIsVisible;
    }

    public static final /* synthetic */ void access$setEnsureExpandedIsVisible$p(WidgetServerSettingsAuditLogAdapter widgetServerSettingsAuditLogAdapter, boolean z2) {
        widgetServerSettingsAuditLogAdapter.ensureExpandedIsVisible = z2;
    }

    public final void configure(List<? extends MGRecyclerDataPayload> auditLogEntryItems) {
        m.checkNotNullParameter(auditLogEntryItems, "auditLogEntryItems");
        setData(auditLogEntryItems);
    }

    public final Function2<Long, Long, Unit> getOnAuditLogAvatarClicked() {
        return this.onAuditLogAvatarClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnAuditLogAvatarClicked(Function2<? super Long, ? super Long, Unit> function2) {
        m.checkNotNullParameter(function2, "<set-?>");
        this.onAuditLogAvatarClicked = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<?, MGRecyclerDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder(this);
        }
        if (viewType == 1) {
            return new WidgetServerSettingsAuditLogAdapter$AuditLogLoadingViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}

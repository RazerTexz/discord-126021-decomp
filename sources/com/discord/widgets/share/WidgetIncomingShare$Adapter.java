package com.discord.widgets.share;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.R$layout;
import com.discord.databinding.ViewImageBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare$Adapter extends RecyclerView$Adapter<WidgetIncomingShare$Adapter$ViewHolder> {
    private WidgetIncomingShare$ContentModel inputModel;
    private Function1<? super Uri, Unit> onItemClickListener;
    public final /* synthetic */ WidgetIncomingShare this$0;

    public WidgetIncomingShare$Adapter(WidgetIncomingShare widgetIncomingShare, WidgetIncomingShare$ContentModel widgetIncomingShare$ContentModel, Function1<? super Uri, Unit> function1) {
        m.checkNotNullParameter(widgetIncomingShare$ContentModel, "inputModel");
        m.checkNotNullParameter(function1, "onItemClickListener");
        this.this$0 = widgetIncomingShare;
        this.inputModel = widgetIncomingShare$ContentModel;
        this.onItemClickListener = function1;
    }

    public static final /* synthetic */ Function1 access$getOnItemClickListener$p(WidgetIncomingShare$Adapter widgetIncomingShare$Adapter) {
        return widgetIncomingShare$Adapter.onItemClickListener;
    }

    public static final /* synthetic */ void access$setOnItemClickListener$p(WidgetIncomingShare$Adapter widgetIncomingShare$Adapter, Function1 function1) {
        widgetIncomingShare$Adapter.onItemClickListener = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        List<Uri> uris = this.inputModel.getUris();
        if (uris != null) {
            return uris.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        onBindViewHolder((WidgetIncomingShare$Adapter$ViewHolder) recyclerView$ViewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setData(WidgetIncomingShare$ContentModel inputModel, Function1<? super Uri, Unit> onItemClickListener) {
        m.checkNotNullParameter(inputModel, "inputModel");
        m.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        this.inputModel = inputModel;
        this.onItemClickListener = onItemClickListener;
    }

    public void onBindViewHolder(WidgetIncomingShare$Adapter$ViewHolder holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        List<Uri> uris = this.inputModel.getUris();
        holder.bind(uris != null ? uris.get(position) : null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public WidgetIncomingShare$Adapter$ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.view_image, parent, false);
        Objects.requireNonNull(viewInflate, "rootView");
        ViewImageBinding viewImageBinding = new ViewImageBinding((SimpleDraweeView) viewInflate);
        m.checkNotNullExpressionValue(viewImageBinding, "ViewImageBinding.inflate….context), parent, false)");
        return new WidgetIncomingShare$Adapter$ViewHolder(this, viewImageBinding);
    }

    public /* synthetic */ WidgetIncomingShare$Adapter(WidgetIncomingShare widgetIncomingShare, WidgetIncomingShare$ContentModel widgetIncomingShare$ContentModel, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(widgetIncomingShare, widgetIncomingShare$ContentModel, (i & 2) != 0 ? WidgetIncomingShare$Adapter$1.INSTANCE : function1);
    }
}

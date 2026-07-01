package com.discord.widgets.chat.input;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.CommandCategoryItemBinding;
import com.discord.models.commands.Application;
import com.discord.models.domain.ModelAuditLogEntry;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.n;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatInputCategoriesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputApplicationsAdapter extends RecyclerView$Adapter<ApplicationCategoryViewHolder> {
    private List<Application> data = n.emptyList();
    public Function1<? super Application, Unit> onClickApplication;
    private long selectedApplication;

    public ChatInputApplicationsAdapter() {
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public long getItemId(int position) {
        return this.data.get(position).getId();
    }

    public final Function1<Application, Unit> getOnClickApplication() {
        Function1 function1 = this.onClickApplication;
        if (function1 == null) {
            m.throwUninitializedPropertyAccessException("onClickApplication");
        }
        return function1;
    }

    public final int getPositionOfApplication(long applicationId) {
        Iterator<Application> it = this.data.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getId() == applicationId) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        onBindViewHolder((ApplicationCategoryViewHolder) recyclerView$ViewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void selectApplication(long applicationId) {
        if (this.selectedApplication != applicationId) {
            this.selectedApplication = applicationId;
            notifyDataSetChanged();
        }
    }

    public final void setApplicationData(List<Application> data) {
        m.checkNotNullParameter(data, "data");
        this.data = data;
        notifyDataSetChanged();
    }

    public final void setOnClickApplication(Function1<? super Application, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onClickApplication = function1;
    }

    public void onBindViewHolder(ApplicationCategoryViewHolder holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        holder.bind(this.data.get(position), this.selectedApplication == this.data.get(position).getId());
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public ApplicationCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.command_category_item, parent, false);
        int i = R$id.command_category_item_icon;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R$id.command_category_item_icon);
        if (simpleDraweeView != null) {
            i = R$id.overline;
            View viewFindViewById = viewInflate.findViewById(R$id.overline);
            if (viewFindViewById != null) {
                CommandCategoryItemBinding commandCategoryItemBinding = new CommandCategoryItemBinding((FrameLayout) viewInflate, simpleDraweeView, new b.a.i.n(viewFindViewById, viewFindViewById));
                m.checkNotNullExpressionValue(commandCategoryItemBinding, "CommandCategoryItemBindi…tInflater, parent, false)");
                Function1<? super Application, Unit> function1 = this.onClickApplication;
                if (function1 == null) {
                    m.throwUninitializedPropertyAccessException("onClickApplication");
                }
                return new ApplicationCategoryViewHolder(commandCategoryItemBinding, function1);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}

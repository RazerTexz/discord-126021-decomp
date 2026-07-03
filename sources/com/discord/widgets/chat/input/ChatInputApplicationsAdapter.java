package com.discord.widgets.chat.input;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.CommandCategoryItemBinding;
import com.discord.models.commands.Application;
import com.discord.models.domain.ModelAuditLogEntry;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.C1009n;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatInputCategoriesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputApplicationsAdapter extends RecyclerView.Adapter<ApplicationCategoryViewHolder> {
    private List<Application> data = C12147n.emptyList();
    public Function1<? super Application, Unit> onClickApplication;
    private long selectedApplication;

    public ChatInputApplicationsAdapter() {
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return this.data.get(position).getId();
    }

    public final Function1<Application, Unit> getOnClickApplication() {
        Function1 function1 = this.onClickApplication;
        if (function1 == null) {
            C12238m.throwUninitializedPropertyAccessException("onClickApplication");
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

    public final void selectApplication(long applicationId) {
        if (this.selectedApplication != applicationId) {
            this.selectedApplication = applicationId;
            notifyDataSetChanged();
        }
    }

    public final void setApplicationData(List<Application> data) {
        C12238m.checkNotNullParameter(data, "data");
        this.data = data;
        notifyDataSetChanged();
    }

    public final void setOnClickApplication(Function1<? super Application, Unit> function1) {
        C12238m.checkNotNullParameter(function1, "<set-?>");
        this.onClickApplication = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ApplicationCategoryViewHolder holder, int position) {
        C12238m.checkNotNullParameter(holder, "holder");
        holder.bind(this.data.get(position), this.selectedApplication == this.data.get(position).getId());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ApplicationCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        C12238m.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(C5419R.layout.command_category_item, parent, false);
        int i = C5419R.id.command_category_item_icon;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(C5419R.id.command_category_item_icon);
        if (simpleDraweeView != null) {
            i = C5419R.id.overline;
            View viewFindViewById = viewInflate.findViewById(C5419R.id.overline);
            if (viewFindViewById != null) {
                CommandCategoryItemBinding commandCategoryItemBinding = new CommandCategoryItemBinding((FrameLayout) viewInflate, simpleDraweeView, new C1009n(viewFindViewById, viewFindViewById));
                C12238m.checkNotNullExpressionValue(commandCategoryItemBinding, "CommandCategoryItemBindi…tInflater, parent, false)");
                Function1<? super Application, Unit> function1 = this.onClickApplication;
                if (function1 == null) {
                    C12238m.throwUninitializedPropertyAccessException("onClickApplication");
                }
                return new ApplicationCategoryViewHolder(commandCategoryItemBinding, function1);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}

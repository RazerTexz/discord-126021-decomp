package com.discord.widgets.forums;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.ForumBrowserHeaderItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetForumBrowserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowserAdapter$HeaderItem extends MGRecyclerViewHolder<WidgetForumBrowserAdapter, ForumBrowserItem> {
    private final ForumBrowserHeaderItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumBrowserAdapter$HeaderItem(WidgetForumBrowserAdapter widgetForumBrowserAdapter) {
        super(R$layout.forum_browser_header_item, widgetForumBrowserAdapter);
        m.checkNotNullParameter(widgetForumBrowserAdapter, "adapter");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(R$id.header_name);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R$id.header_name)));
        }
        ForumBrowserHeaderItemBinding forumBrowserHeaderItemBinding = new ForumBrowserHeaderItemBinding((ConstraintLayout) view, textView);
        m.checkNotNullExpressionValue(forumBrowserHeaderItemBinding, "ForumBrowserHeaderItemBinding.bind(itemView)");
        this.binding = forumBrowserHeaderItemBinding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ForumBrowserItem forumBrowserItem) {
        onConfigure2(i, forumBrowserItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, ForumBrowserItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        this.binding.f2107b.setText(((ForumBrowserItem$HeaderItem) data).getStringResId());
    }
}

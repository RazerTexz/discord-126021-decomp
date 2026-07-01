package com.discord.widgets.forums;

import android.view.View;
import com.discord.R$layout;
import com.discord.databinding.ForumBrowserPostItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetForumBrowserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowserAdapter$PostItem extends MGRecyclerViewHolder<WidgetForumBrowserAdapter, ForumBrowserItem> {
    private final ForumBrowserPostItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumBrowserAdapter$PostItem(WidgetForumBrowserAdapter widgetForumBrowserAdapter) {
        super(R$layout.forum_browser_post_item, widgetForumBrowserAdapter);
        m.checkNotNullParameter(widgetForumBrowserAdapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        ForumBrowserPostView forumBrowserPostView = (ForumBrowserPostView) view;
        ForumBrowserPostItemBinding forumBrowserPostItemBinding = new ForumBrowserPostItemBinding(forumBrowserPostView, forumBrowserPostView);
        m.checkNotNullExpressionValue(forumBrowserPostItemBinding, "ForumBrowserPostItemBinding.bind(itemView)");
        this.binding = forumBrowserPostItemBinding;
    }

    public static final /* synthetic */ WidgetForumBrowserAdapter access$getAdapter$p(WidgetForumBrowserAdapter$PostItem widgetForumBrowserAdapter$PostItem) {
        return (WidgetForumBrowserAdapter) widgetForumBrowserAdapter$PostItem.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ForumBrowserItem forumBrowserItem) {
        onConfigure2(i, forumBrowserItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, ForumBrowserItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        ForumBrowserItem$PostItem forumBrowserItem$PostItem = (ForumBrowserItem$PostItem) data;
        this.binding.f2108b.configurePost(forumBrowserItem$PostItem.getPost());
        this.binding.f2108b.setOnClickListener(new WidgetForumBrowserAdapter$PostItem$onConfigure$1(this, forumBrowserItem$PostItem));
        ForumBrowserPostView forumBrowserPostView = this.binding.f2108b;
        m.checkNotNullExpressionValue(forumBrowserPostView, "binding.forumBrowserPostView");
        ViewExtensions.setOnLongClickListenerConsumeClick(forumBrowserPostView, new WidgetForumBrowserAdapter$PostItem$onConfigure$2(this, forumBrowserItem$PostItem));
    }
}

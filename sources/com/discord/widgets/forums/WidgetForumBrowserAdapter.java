package com.discord.widgets.forums;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.databinding.ForumBrowserHeaderItemBinding;
import com.discord.databinding.ForumBrowserPostItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.forums.ForumBrowserItem;
import com.discord.widgets.forums.WidgetForumBrowserAdapter;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetForumBrowserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowserAdapter extends MGRecyclerAdapterSimple<ForumBrowserItem> {
    private final RecyclerView.ItemDecoration itemDecoration;
    private final Function1<Channel, Unit> onPostClick;
    private final Function1<Channel, Unit> onPostLongClick;

    /* JADX INFO: compiled from: WidgetForumBrowserAdapter.kt */
    public static final class HeaderItem extends MGRecyclerViewHolder<WidgetForumBrowserAdapter, ForumBrowserItem> {
        private final ForumBrowserHeaderItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeaderItem(WidgetForumBrowserAdapter widgetForumBrowserAdapter) {
            super(R.layout.forum_browser_header_item, widgetForumBrowserAdapter);
            Intrinsics3.checkNotNullParameter(widgetForumBrowserAdapter, "adapter");
            View view = this.itemView;
            TextView textView = (TextView) view.findViewById(R.id.header_name);
            if (textView == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.header_name)));
            }
            ForumBrowserHeaderItemBinding forumBrowserHeaderItemBinding = new ForumBrowserHeaderItemBinding((ConstraintLayout) view, textView);
            Intrinsics3.checkNotNullExpressionValue(forumBrowserHeaderItemBinding, "ForumBrowserHeaderItemBinding.bind(itemView)");
            this.binding = forumBrowserHeaderItemBinding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, ForumBrowserItem data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            this.binding.f2107b.setText(((ForumBrowserItem.HeaderItem) data).getStringResId());
        }
    }

    /* JADX INFO: compiled from: WidgetForumBrowserAdapter.kt */
    public static final class LoadingItem extends MGRecyclerViewHolder<WidgetForumBrowserAdapter, ForumBrowserItem> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoadingItem(WidgetForumBrowserAdapter widgetForumBrowserAdapter) {
            super(R.layout.forum_browser_loading_item, widgetForumBrowserAdapter);
            Intrinsics3.checkNotNullParameter(widgetForumBrowserAdapter, "adapter");
        }
    }

    /* JADX INFO: compiled from: WidgetForumBrowserAdapter.kt */
    public static final class PostItem extends MGRecyclerViewHolder<WidgetForumBrowserAdapter, ForumBrowserItem> {
        private final ForumBrowserPostItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostItem(WidgetForumBrowserAdapter widgetForumBrowserAdapter) {
            super(R.layout.forum_browser_post_item, widgetForumBrowserAdapter);
            Intrinsics3.checkNotNullParameter(widgetForumBrowserAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            ForumBrowserPostView forumBrowserPostView = (ForumBrowserPostView) view;
            ForumBrowserPostItemBinding forumBrowserPostItemBinding = new ForumBrowserPostItemBinding(forumBrowserPostView, forumBrowserPostView);
            Intrinsics3.checkNotNullExpressionValue(forumBrowserPostItemBinding, "ForumBrowserPostItemBinding.bind(itemView)");
            this.binding = forumBrowserPostItemBinding;
        }

        public static final /* synthetic */ WidgetForumBrowserAdapter access$getAdapter$p(PostItem postItem) {
            return (WidgetForumBrowserAdapter) postItem.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, ForumBrowserItem data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            final ForumBrowserItem.PostItem postItem = (ForumBrowserItem.PostItem) data;
            this.binding.f2108b.configurePost(postItem.getPost());
            this.binding.f2108b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.forums.WidgetForumBrowserAdapter$PostItem$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetForumBrowserAdapter.PostItem.access$getAdapter$p(this.this$0).onPostClick.invoke(postItem.getPost().getChannel());
                }
            });
            ForumBrowserPostView forumBrowserPostView = this.binding.f2108b;
            Intrinsics3.checkNotNullExpressionValue(forumBrowserPostView, "binding.forumBrowserPostView");
            ViewExtensions.setOnLongClickListenerConsumeClick(forumBrowserPostView, new WidgetForumBrowserAdapter3(this, postItem));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetForumBrowserAdapter(RecyclerView recyclerView, Function1<? super Channel, Unit> function1, Function1<? super Channel, Unit> function2) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        Intrinsics3.checkNotNullParameter(function1, "onPostClick");
        Intrinsics3.checkNotNullParameter(function2, "onPostLongClick");
        this.onPostClick = function1;
        this.onPostLongClick = function2;
        this.itemDecoration = new RecyclerView.ItemDecoration() { // from class: com.discord.widgets.forums.WidgetForumBrowserAdapter$itemDecoration$1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                Intrinsics3.checkNotNullParameter(outRect, "outRect");
                Intrinsics3.checkNotNullParameter(view, "view");
                Intrinsics3.checkNotNullParameter(parent, "parent");
                Intrinsics3.checkNotNullParameter(state, "state");
                super.getItemOffsets(outRect, view, parent, state);
                int childAdapterPosition = parent.getChildAdapterPosition(view);
                if (childAdapterPosition == -1) {
                    return;
                }
                boolean z2 = childAdapterPosition == 0;
                int type = ((ForumBrowserItem) this.this$0.getInternalData().get(childAdapterPosition)).getType();
                if (type == 0) {
                    outRect.top = DimenUtils.dpToPixels(24);
                    outRect.bottom = DimenUtils.dpToPixels(8);
                    outRect.left = DimenUtils.dpToPixels(16);
                }
                if (type == 1) {
                    outRect.bottom = DimenUtils.dpToPixels(12);
                    outRect.top = z2 ? DimenUtils.dpToPixels(12) : 0;
                }
            }
        };
    }

    public final RecyclerView.ItemDecoration getItemDecoration() {
        return this.itemDecoration;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, ForumBrowserItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new HeaderItem(this);
        }
        if (viewType == 1) {
            return new PostItem(this);
        }
        if (viewType == 2) {
            return new LoadingItem(this);
        }
        throw new IllegalStateException(outline.q("Invalid view type: ", viewType));
    }
}

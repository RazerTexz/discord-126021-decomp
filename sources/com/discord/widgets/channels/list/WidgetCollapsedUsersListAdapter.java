package com.discord.widgets.channels.list;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetCollapsedVoiceUserListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.channels.list.items.CollapsedUser;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetCollapsedUsersListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCollapsedUsersListAdapter extends MGRecyclerAdapterSimple<CollapsedUser> {

    /* JADX INFO: compiled from: WidgetCollapsedUsersListAdapter.kt */
    public static final class OverlapDecoration extends RecyclerView.ItemDecoration {
        private final int offset;

        public OverlapDecoration(int i) {
            this.offset = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics3.checkNotNullParameter(outRect, "outRect");
            Intrinsics3.checkNotNullParameter(view, "view");
            Intrinsics3.checkNotNullParameter(parent, "parent");
            Intrinsics3.checkNotNullParameter(state, "state");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            outRect.set(((RecyclerView.LayoutParams) layoutParams).getViewAdapterPosition() != 0 ? this.offset : 0, 0, 0, 0);
        }
    }

    /* JADX INFO: compiled from: WidgetCollapsedUsersListAdapter.kt */
    public static final class WidgetCollapsedUserListItem extends MGRecyclerViewHolder<WidgetCollapsedUsersListAdapter, CollapsedUser> {
        private final WidgetCollapsedVoiceUserListItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WidgetCollapsedUserListItem(@LayoutRes int i, WidgetCollapsedUsersListAdapter widgetCollapsedUsersListAdapter) {
            super(i, widgetCollapsedUsersListAdapter);
            Intrinsics3.checkNotNullParameter(widgetCollapsedUsersListAdapter, "adapter");
            View view = this.itemView;
            int i2 = R.id.widget_collapsed_user_count;
            TextView textView = (TextView) view.findViewById(R.id.widget_collapsed_user_count);
            if (textView != null) {
                i2 = R.id.widget_collapsed_user_imageview;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.widget_collapsed_user_imageview);
                if (simpleDraweeView != null) {
                    WidgetCollapsedVoiceUserListItemBinding widgetCollapsedVoiceUserListItemBinding = new WidgetCollapsedVoiceUserListItemBinding((FrameLayout) view, textView, simpleDraweeView);
                    Intrinsics3.checkNotNullExpressionValue(widgetCollapsedVoiceUserListItemBinding, "WidgetCollapsedVoiceUser…temBinding.bind(itemView)");
                    this.binding = widgetCollapsedVoiceUserListItemBinding;
                    return;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, CollapsedUser data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            if (data.getExtraCount() <= 0) {
                if (data.getEmptySlot()) {
                    return;
                }
                TextView textView = this.binding.f2352b;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.widgetCollapsedUserCount");
                textView.setVisibility(8);
                SimpleDraweeView simpleDraweeView = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.widgetCollapsedUserImageview");
                IconUtils.setIcon$default(simpleDraweeView, data.getUser(), R.dimen.avatar_size_medium, null, null, null, 56, null);
                return;
            }
            TextView textView2 = this.binding.f2352b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.widgetCollapsedUserCount");
            StringBuilder sb = new StringBuilder();
            sb.append('+');
            sb.append(data.getExtraCount());
            ViewExtensions.setTextAndVisibilityBy(textView2, sb.toString());
            MGImages mGImages = MGImages.INSTANCE;
            SimpleDraweeView simpleDraweeView2 = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.widgetCollapsedUserImageview");
            MGImages.setImage$default(mGImages, simpleDraweeView2, R.drawable.drawable_grey_user_icon, (MGImages.ChangeDetector) null, 4, (Object) null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCollapsedUsersListAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        Context context = recyclerView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "recycler.context");
        recyclerView.addItemDecoration(new OverlapDecoration(-context.getResources().getDimensionPixelSize(R.dimen.avatar_overlap)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, CollapsedUser> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        return new WidgetCollapsedUserListItem(R.layout.widget_collapsed_voice_user_list_item, this);
    }
}

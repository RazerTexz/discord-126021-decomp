package com.discord.widgets.channels.list;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import com.discord.R$id;
import com.discord.databinding.WidgetCollapsedVoiceUserListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.channels.list.items.CollapsedUser;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetCollapsedUsersListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCollapsedUsersListAdapter$WidgetCollapsedUserListItem extends MGRecyclerViewHolder<WidgetCollapsedUsersListAdapter, CollapsedUser> {
    private final WidgetCollapsedVoiceUserListItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCollapsedUsersListAdapter$WidgetCollapsedUserListItem(@LayoutRes int i, WidgetCollapsedUsersListAdapter widgetCollapsedUsersListAdapter) {
        super(i, widgetCollapsedUsersListAdapter);
        m.checkNotNullParameter(widgetCollapsedUsersListAdapter, "adapter");
        View view = this.itemView;
        int i2 = R$id.widget_collapsed_user_count;
        TextView textView = (TextView) view.findViewById(R$id.widget_collapsed_user_count);
        if (textView != null) {
            i2 = R$id.widget_collapsed_user_imageview;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.widget_collapsed_user_imageview);
            if (simpleDraweeView != null) {
                WidgetCollapsedVoiceUserListItemBinding widgetCollapsedVoiceUserListItemBinding = new WidgetCollapsedVoiceUserListItemBinding((FrameLayout) view, textView, simpleDraweeView);
                m.checkNotNullExpressionValue(widgetCollapsedVoiceUserListItemBinding, "WidgetCollapsedVoiceUser…temBinding.bind(itemView)");
                this.binding = widgetCollapsedVoiceUserListItemBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, CollapsedUser collapsedUser) {
        onConfigure2(i, collapsedUser);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, CollapsedUser data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (data.getExtraCount() <= 0) {
            if (data.getEmptySlot()) {
                return;
            }
            TextView textView = this.binding.f2352b;
            m.checkNotNullExpressionValue(textView, "binding.widgetCollapsedUserCount");
            textView.setVisibility(8);
            SimpleDraweeView simpleDraweeView = this.binding.c;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.widgetCollapsedUserImageview");
            IconUtils.setIcon$default(simpleDraweeView, data.getUser(), 2131165294, null, null, null, 56, null);
            return;
        }
        TextView textView2 = this.binding.f2352b;
        m.checkNotNullExpressionValue(textView2, "binding.widgetCollapsedUserCount");
        StringBuilder sb = new StringBuilder();
        sb.append('+');
        sb.append(data.getExtraCount());
        ViewExtensions.setTextAndVisibilityBy(textView2, sb.toString());
        MGImages mGImages = MGImages.INSTANCE;
        SimpleDraweeView simpleDraweeView2 = this.binding.c;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.widgetCollapsedUserImageview");
        MGImages.setImage$default(mGImages, simpleDraweeView2, 2131231232, (MGImages$ChangeDetector) null, 4, (Object) null);
    }
}

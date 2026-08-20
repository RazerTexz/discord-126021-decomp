package com.discord.widgets.settings.account;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsItemBlockedUserBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsBlockedUsersAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsBlockedUsersAdapter extends MGRecyclerAdapterSimple<WidgetSettingsBlockedUsersViewModel.Item> {
    private Function1<? super User, Unit> onClickUnblock;
    private Function1<? super User, Unit> onClickUserProfile;

    /* JADX INFO: compiled from: WidgetSettingsBlockedUsersAdapter.kt */
    public static final class BlockedUserViewHolder extends MGRecyclerViewHolder<WidgetSettingsBlockedUsersAdapter, WidgetSettingsBlockedUsersViewModel.Item> {
        private final WidgetSettingsItemBlockedUserBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BlockedUserViewHolder(@LayoutRes int i, WidgetSettingsBlockedUsersAdapter widgetSettingsBlockedUsersAdapter) {
            super(i, widgetSettingsBlockedUsersAdapter);
            C12238m.checkNotNullParameter(widgetSettingsBlockedUsersAdapter, "adapter");
            View view = this.itemView;
            RelativeLayout relativeLayout = (RelativeLayout) view;
            int i2 = C5419R.id.blocked_user_item_avatar;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.blocked_user_item_avatar);
            if (simpleDraweeView != null) {
                i2 = C5419R.id.blocked_user_item_name;
                TextView textView = (TextView) view.findViewById(C5419R.id.blocked_user_item_name);
                if (textView != null) {
                    i2 = C5419R.id.unblock_user_button;
                    MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.unblock_user_button);
                    if (materialButton != null) {
                        WidgetSettingsItemBlockedUserBinding widgetSettingsItemBlockedUserBinding = new WidgetSettingsItemBlockedUserBinding((RelativeLayout) view, relativeLayout, simpleDraweeView, textView, materialButton);
                        C12238m.checkNotNullExpressionValue(widgetSettingsItemBlockedUserBinding, "WidgetSettingsItemBlocke…serBinding.bind(itemView)");
                        this.binding = widgetSettingsItemBlockedUserBinding;
                        return;
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
        }

        public static final /* synthetic */ WidgetSettingsBlockedUsersAdapter access$getAdapter$p(BlockedUserViewHolder blockedUserViewHolder) {
            return (WidgetSettingsBlockedUsersAdapter) blockedUserViewHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, final WidgetSettingsBlockedUsersViewModel.Item data) {
            C12238m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            this.binding.f17979a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsBlockedUsersAdapter$BlockedUserViewHolder$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetSettingsBlockedUsersAdapter.BlockedUserViewHolder.access$getAdapter$p(this.this$0).getOnClickUserProfile().invoke(data.getUser());
                }
            });
            SimpleDraweeView simpleDraweeView = this.binding.f17980b;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.blockedUserItemAvatar");
            IconUtils.setIcon$default(simpleDraweeView, data.getUser(), C5419R.dimen.avatar_size_standard, null, null, null, 56, null);
            TextView textView = this.binding.f17981c;
            C12238m.checkNotNullExpressionValue(textView, "binding.blockedUserItemName");
            textView.setText(data.getUser().getUsername());
            this.binding.f17982d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsBlockedUsersAdapter$BlockedUserViewHolder$onConfigure$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetSettingsBlockedUsersAdapter.BlockedUserViewHolder.access$getAdapter$p(this.this$0).getOnClickUnblock().invoke(data.getUser());
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsBlockedUsersAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        C12238m.checkNotNullParameter(recyclerView, "recycler");
        this.onClickUnblock = WidgetSettingsBlockedUsersAdapter$onClickUnblock$1.INSTANCE;
        this.onClickUserProfile = WidgetSettingsBlockedUsersAdapter$onClickUserProfile$1.INSTANCE;
    }

    public final Function1<User, Unit> getOnClickUnblock() {
        return this.onClickUnblock;
    }

    public final Function1<User, Unit> getOnClickUserProfile() {
        return this.onClickUserProfile;
    }

    public final void setOnClickUnblock(Function1<? super User, Unit> function1) {
        C12238m.checkNotNullParameter(function1, "<set-?>");
        this.onClickUnblock = function1;
    }

    public final void setOnClickUserProfile(Function1<? super User, Unit> function1) {
        C12238m.checkNotNullParameter(function1, "<set-?>");
        this.onClickUserProfile = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<WidgetSettingsBlockedUsersAdapter, WidgetSettingsBlockedUsersViewModel.Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        C12238m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new BlockedUserViewHolder(C5419R.layout.widget_settings_item_blocked_user, this);
        }
        throw invalidViewTypeException(viewType);
    }
}

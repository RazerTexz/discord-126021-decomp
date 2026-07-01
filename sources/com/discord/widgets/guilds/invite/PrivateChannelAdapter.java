package com.discord.widgets.guilds.invite;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.WidgetGuildInviteShareItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.guilds.invite.InviteSuggestionItem;
import com.discord.widgets.guilds.invite.PrivateChannelAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PrivateChannelAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PrivateChannelAdapter extends MGRecyclerAdapterSimple<InviteSuggestionItem> {
    private Function1<? super InviteSuggestionItem, Unit> onClick;

    /* JADX INFO: compiled from: PrivateChannelAdapter.kt */
    public static final class Item extends MGRecyclerViewHolder<PrivateChannelAdapter, InviteSuggestionItem> {
        private final WidgetGuildInviteShareItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Item(PrivateChannelAdapter privateChannelAdapter) {
            super(R.layout.widget_guild_invite_share_item, privateChannelAdapter);
            Intrinsics3.checkNotNullParameter(privateChannelAdapter, "adapter");
            WidgetGuildInviteShareItemBinding widgetGuildInviteShareItemBindingA = WidgetGuildInviteShareItemBinding.a(this.itemView);
            Intrinsics3.checkNotNullExpressionValue(widgetGuildInviteShareItemBindingA, "WidgetGuildInviteShareItemBinding.bind(itemView)");
            this.binding = widgetGuildInviteShareItemBindingA;
        }

        public static final /* synthetic */ PrivateChannelAdapter access$getAdapter$p(Item item) {
            return (PrivateChannelAdapter) item.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, final InviteSuggestionItem data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            boolean z2 = data instanceof InviteSuggestionItem.ChannelItem;
            if (z2) {
                InviteSuggestionItem.ChannelItem channelItem = (InviteSuggestionItem.ChannelItem) data;
                if (channelItem.getChannel().getType() != 1) {
                    SimpleDraweeView simpleDraweeView = this.binding.f2421b;
                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.itemIconIv");
                    IconUtils.setIcon$default(simpleDraweeView, channelItem.getChannel(), 0, (MGImages.ChangeDetector) null, 12, (Object) null);
                } else {
                    SimpleDraweeView simpleDraweeView2 = this.binding.f2421b;
                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemIconIv");
                    IconUtils.setIcon$default(simpleDraweeView2, ChannelUtils.a(channelItem.getChannel()), 0, null, null, null, 60, null);
                }
                TextView textView = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemNameTv");
                textView.setText(ChannelUtils.c(channelItem.getChannel()));
            } else if (data instanceof InviteSuggestionItem.UserItem) {
                SimpleDraweeView simpleDraweeView3 = this.binding.f2421b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.itemIconIv");
                InviteSuggestionItem.UserItem userItem = (InviteSuggestionItem.UserItem) data;
                IconUtils.setIcon$default(simpleDraweeView3, userItem.getUser(), 0, null, null, null, 60, null);
                TextView textView2 = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.itemNameTv");
                textView2.setText(userItem.getUser().getUsername());
            }
            if (z2 || (data instanceof InviteSuggestionItem.UserItem)) {
                MaterialButton materialButton = this.binding.e;
                Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.itemSent");
                materialButton.setVisibility(data.hasSentInvite() ? 0 : 8);
                MaterialButton materialButton2 = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.itemInviteBtn");
                materialButton2.setVisibility(data.hasSentInvite() ^ true ? 0 : 8);
                this.binding.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.PrivateChannelAdapter$Item$onConfigure$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PrivateChannelAdapter.Item.access$getAdapter$p(this.this$0).getOnClick().invoke(data);
                    }
                });
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivateChannelAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.onClick = PrivateChannelAdapter3.INSTANCE;
    }

    public final Function1<InviteSuggestionItem, Unit> getOnClick() {
        return this.onClick;
    }

    public final void setOnClick(Function1<? super InviteSuggestionItem, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onClick = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public Item onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        return new Item(this);
    }
}

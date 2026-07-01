package com.discord.widgets.servers.guildboost;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.ViewNitroBoostPerksListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: GuildBoostPerkViewAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostPerkViewAdapter extends MGRecyclerAdapterSimple<GuildBoostPerkViewListItem> {

    /* JADX INFO: compiled from: GuildBoostPerkViewAdapter.kt */
    public static final /* data */ class GuildBoostPerkViewListItem implements MGRecyclerDataPayload {
        public static final int TYPE_LIST_ITEM = 1;
        private final int iconResId;
        private final String key;
        private final CharSequence text;
        private final int type;

        public GuildBoostPerkViewListItem(@DrawableRes int i, CharSequence charSequence) {
            Intrinsics3.checkNotNullParameter(charSequence, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            this.iconResId = i;
            this.text = charSequence;
            this.type = 1;
            this.key = charSequence.toString();
        }

        public static /* synthetic */ GuildBoostPerkViewListItem copy$default(GuildBoostPerkViewListItem guildBoostPerkViewListItem, int i, CharSequence charSequence, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = guildBoostPerkViewListItem.iconResId;
            }
            if ((i2 & 2) != 0) {
                charSequence = guildBoostPerkViewListItem.text;
            }
            return guildBoostPerkViewListItem.copy(i, charSequence);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getIconResId() {
            return this.iconResId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final CharSequence getText() {
            return this.text;
        }

        public final GuildBoostPerkViewListItem copy(@DrawableRes int iconResId, CharSequence text) {
            Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            return new GuildBoostPerkViewListItem(iconResId, text);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildBoostPerkViewListItem)) {
                return false;
            }
            GuildBoostPerkViewListItem guildBoostPerkViewListItem = (GuildBoostPerkViewListItem) other;
            return this.iconResId == guildBoostPerkViewListItem.iconResId && Intrinsics3.areEqual(this.text, guildBoostPerkViewListItem.text);
        }

        public final int getIconResId() {
            return this.iconResId;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final CharSequence getText() {
            return this.text;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public int hashCode() {
            int i = this.iconResId * 31;
            CharSequence charSequence = this.text;
            return i + (charSequence != null ? charSequence.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("GuildBoostPerkViewListItem(iconResId=");
            sbU.append(this.iconResId);
            sbU.append(", text=");
            return outline.E(sbU, this.text, ")");
        }
    }

    /* JADX INFO: compiled from: GuildBoostPerkViewAdapter.kt */
    public static final class PerkViewHolder extends MGRecyclerViewHolder<GuildBoostPerkViewAdapter, GuildBoostPerkViewListItem> {
        private final ViewNitroBoostPerksListItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PerkViewHolder(GuildBoostPerkViewAdapter guildBoostPerkViewAdapter) {
            super(R.layout.view_nitro_boost_perks_list_item, guildBoostPerkViewAdapter);
            Intrinsics3.checkNotNullParameter(guildBoostPerkViewAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            TextView textView = (TextView) view;
            ViewNitroBoostPerksListItemBinding viewNitroBoostPerksListItemBinding = new ViewNitroBoostPerksListItemBinding(textView, textView);
            Intrinsics3.checkNotNullExpressionValue(viewNitroBoostPerksListItemBinding, "ViewNitroBoostPerksListItemBinding.bind(itemView)");
            this.binding = viewNitroBoostPerksListItemBinding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, GuildBoostPerkViewListItem data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            TextView textView = this.binding.f2205b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.perkViewContentListItem");
            textView.setText(data.getText());
            TextView textView2 = this.binding.f2205b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.perkViewContentListItem");
            DrawableCompat.setCompoundDrawablesCompat$default(textView2, data.getIconResId(), 0, 0, 0, 14, (Object) null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostPerkViewAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
    }

    public final void configure(List<GuildBoostPerkViewListItem> perkItems) {
        Intrinsics3.checkNotNullParameter(perkItems, "perkItems");
        setData(perkItems);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PerkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            return new PerkViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}

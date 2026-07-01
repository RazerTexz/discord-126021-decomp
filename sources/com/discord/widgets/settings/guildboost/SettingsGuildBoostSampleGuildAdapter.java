package com.discord.widgets.settings.guildboost;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.ViewSettingsBoostedSampleGuildBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.views.guildboost.GuildBoostProgressView;
import com.discord.widgets.settings.guildboost.SettingsGuildBoostSampleGuildAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SettingsGuildBoostSampleGuildAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsGuildBoostSampleGuildAdapter extends MGRecyclerAdapterSimple<Item> {
    private Function1<? super Long, Unit> onGuildClickedListener;

    /* JADX INFO: compiled from: SettingsGuildBoostSampleGuildAdapter.kt */
    public static final class GuildListItem extends MGRecyclerViewHolder<SettingsGuildBoostSampleGuildAdapter, Item> {
        private final ViewSettingsBoostedSampleGuildBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildListItem(SettingsGuildBoostSampleGuildAdapter settingsGuildBoostSampleGuildAdapter) {
            super(R.layout.view_settings_boosted_sample_guild, settingsGuildBoostSampleGuildAdapter);
            Intrinsics3.checkNotNullParameter(settingsGuildBoostSampleGuildAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.boosted_sample_guild_count;
            TextView textView = (TextView) view.findViewById(R.id.boosted_sample_guild_count);
            if (textView != null) {
                i = R.id.boosted_sample_guild_icon;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.boosted_sample_guild_icon);
                if (simpleDraweeView != null) {
                    i = R.id.boosted_sample_guild_name;
                    TextView textView2 = (TextView) view.findViewById(R.id.boosted_sample_guild_name);
                    if (textView2 != null) {
                        i = R.id.boosted_sample_guild_progress;
                        GuildBoostProgressView guildBoostProgressView = (GuildBoostProgressView) view.findViewById(R.id.boosted_sample_guild_progress);
                        if (guildBoostProgressView != null) {
                            ViewSettingsBoostedSampleGuildBinding viewSettingsBoostedSampleGuildBinding = new ViewSettingsBoostedSampleGuildBinding((CardView) view, textView, simpleDraweeView, textView2, guildBoostProgressView);
                            Intrinsics3.checkNotNullExpressionValue(viewSettingsBoostedSampleGuildBinding, "ViewSettingsBoostedSampl…ildBinding.bind(itemView)");
                            this.binding = viewSettingsBoostedSampleGuildBinding;
                            return;
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ SettingsGuildBoostSampleGuildAdapter access$getAdapter$p(GuildListItem guildListItem) {
            return (SettingsGuildBoostSampleGuildAdapter) guildListItem.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, final Item data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            int premiumSubscriptionCount = data.getGuild().getPremiumSubscriptionCount();
            SimpleDraweeView simpleDraweeView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.boostedSampleGuildIcon");
            IconUtils.setIcon$default((ImageView) simpleDraweeView, data.getGuild(), 0, (MGImages.ChangeDetector) null, false, 28, (Object) null);
            TextView textView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.boostedSampleGuildName");
            textView.setText(data.getGuild().getName());
            TextView textView2 = this.binding.f2215b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.boostedSampleGuildCount");
            textView2.setText(StringResourceUtils.getI18nPluralString(outline.x(this.itemView, "itemView", "itemView.context"), R.plurals.premium_guild_subscription_available_numSubscriptions, premiumSubscriptionCount, Integer.valueOf(premiumSubscriptionCount)));
            this.binding.e.a(data.getGuild().getId(), data.getGuild().getPremiumTier(), premiumSubscriptionCount);
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.guildboost.SettingsGuildBoostSampleGuildAdapter$GuildListItem$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function1 function1 = SettingsGuildBoostSampleGuildAdapter.GuildListItem.access$getAdapter$p(this.this$0).onGuildClickedListener;
                    if (function1 != null) {
                    }
                }
            });
        }
    }

    /* JADX INFO: compiled from: SettingsGuildBoostSampleGuildAdapter.kt */
    public static final /* data */ class Item implements MGRecyclerDataPayload {
        public static final int TYPE_GUILD = 1;
        private final Guild guild;
        private final String key;
        private final int type;

        public Item(Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            this.guild = guild;
            this.type = 1;
            this.key = String.valueOf(guild.getId());
        }

        public static /* synthetic */ Item copy$default(Item item, Guild guild, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = item.guild;
            }
            return item.copy(guild);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final Item copy(Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            return new Item(guild);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Item) && Intrinsics3.areEqual(this.guild, ((Item) other).guild);
            }
            return true;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public int hashCode() {
            Guild guild = this.guild;
            if (guild != null) {
                return guild.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Item(guild=");
            sbU.append(this.guild);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsGuildBoostSampleGuildAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
    }

    public final void configure(List<Item> guildBoostItems, Function1<? super Long, Unit> onGuildClickedListener) {
        Intrinsics3.checkNotNullParameter(guildBoostItems, "guildBoostItems");
        Intrinsics3.checkNotNullParameter(onGuildClickedListener, "onGuildClickedListener");
        setData(guildBoostItems);
        this.onGuildClickedListener = onGuildClickedListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public GuildListItem onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            return new GuildListItem(this);
        }
        throw invalidViewTypeException(viewType);
    }
}

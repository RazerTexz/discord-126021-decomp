package com.discord.widgets.settings.guildboost;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.ViewSettingsBoostedBoostListitemBinding;
import com.discord.databinding.ViewSettingsBoostedGuildListitemBinding;
import com.discord.databinding.ViewSettingsBoostedHeaderListitemBinding;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.models.guild.Guild;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.guildboost.GuildBoostProgressView;
import com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoostSubscriptionAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGuildBoostSubscriptionAdapter extends MGRecyclerAdapterSimple<Item> {
    private boolean canCancelBoosts;
    private boolean canUncancelBoosts;
    private Function2<? super Long, ? super Boolean, Unit> cancelListener;
    private Function1<? super Long, Unit> subscribeListener;
    private Function2<? super ModelGuildBoostSlot, ? super Long, Unit> transferListener;

    /* JADX INFO: compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
    public static final class GuildBoostListItem extends MGRecyclerViewHolder<WidgetSettingsGuildBoostSubscriptionAdapter, Item> {
        private final ViewSettingsBoostedBoostListitemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildBoostListItem(WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter) {
            super(C5419R.layout.view_settings_boosted_boost_listitem, widgetSettingsGuildBoostSubscriptionAdapter);
            C12238m.checkNotNullParameter(widgetSettingsGuildBoostSubscriptionAdapter, "adapter");
            View view = this.itemView;
            int i = C5419R.id.boosted_boost_action;
            TextView textView = (TextView) view.findViewById(C5419R.id.boosted_boost_action);
            if (textView != null) {
                i = C5419R.id.boosted_boost_cancelled;
                ImageView imageView = (ImageView) view.findViewById(C5419R.id.boosted_boost_cancelled);
                if (imageView != null) {
                    i = C5419R.id.boosted_boost_cooldown;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.boosted_boost_cooldown);
                    if (textView2 != null) {
                        i = C5419R.id.boosted_boost_date;
                        TextView textView3 = (TextView) view.findViewById(C5419R.id.boosted_boost_date);
                        if (textView3 != null) {
                            ViewSettingsBoostedBoostListitemBinding viewSettingsBoostedBoostListitemBinding = new ViewSettingsBoostedBoostListitemBinding((RelativeLayout) view, textView, imageView, textView2, textView3);
                            C12238m.checkNotNullExpressionValue(viewSettingsBoostedBoostListitemBinding, "ViewSettingsBoostedBoost…temBinding.bind(itemView)");
                            this.binding = viewSettingsBoostedBoostListitemBinding;
                            return;
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetSettingsGuildBoostSubscriptionAdapter access$getAdapter$p(GuildBoostListItem guildBoostListItem) {
            return (WidgetSettingsGuildBoostSubscriptionAdapter) guildBoostListItem.adapter;
        }

        private final void showGuildBoostPopup(View sourceView, boolean hasCooldown, boolean canBeCancelled, boolean canBeUncancelled, final Item.GuildBoostItem data) {
            PopupMenu popupMenu = new PopupMenu(new ContextThemeWrapper(sourceView.getContext(), 2131951663), sourceView);
            popupMenu.getMenuInflater().inflate(C5419R.menu.menu_settings_premium_guild_sub, popupMenu.getMenu());
            MenuItem menuItemFindItem = popupMenu.getMenu().findItem(C5419R.id.menu_settings_premium_guild_sub_transfer);
            MenuItem menuItemFindItem2 = popupMenu.getMenu().findItem(C5419R.id.menu_settings_premium_guild_sub_cancel);
            MenuItem menuItemFindItem3 = popupMenu.getMenu().findItem(C5419R.id.menu_settings_premium_guild_sub_uncancel);
            boolean canceled = data.getBoostSlot().getCanceled();
            C12238m.checkNotNullExpressionValue(menuItemFindItem, "transfer");
            menuItemFindItem.setVisible(!hasCooldown);
            C12238m.checkNotNullExpressionValue(menuItemFindItem2, "cancel");
            menuItemFindItem2.setVisible(!canceled && canBeCancelled);
            C12238m.checkNotNullExpressionValue(menuItemFindItem3, "uncancel");
            menuItemFindItem3.setVisible(canceled && canBeUncancelled);
            menuItemFindItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem$showGuildBoostPopup$1
                @Override // android.view.MenuItem.OnMenuItemClickListener
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    ModelAppliedGuildBoost premiumGuildSubscription = data.getBoostSlot().getPremiumGuildSubscription();
                    if (premiumGuildSubscription == null) {
                        return true;
                    }
                    WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem.access$getAdapter$p(this.this$0).transferListener.invoke(data.getBoostSlot(), Long.valueOf(premiumGuildSubscription.getGuildId()));
                    return true;
                }
            });
            menuItemFindItem2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem$showGuildBoostPopup$2
                @Override // android.view.MenuItem.OnMenuItemClickListener
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem.access$getAdapter$p(this.this$0).cancelListener.invoke(Long.valueOf(data.getBoostSlot().getId()), Boolean.TRUE);
                    return true;
                }
            });
            menuItemFindItem3.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem$showGuildBoostPopup$3
                @Override // android.view.MenuItem.OnMenuItemClickListener
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem.access$getAdapter$p(this.this$0).cancelListener.invoke(Long.valueOf(data.getBoostSlot().getId()), Boolean.FALSE);
                    return true;
                }
            });
            popupMenu.show();
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, final Item data) throws Exception {
            CharSequence string;
            int i;
            char c;
            String strReplace$default;
            String str;
            CharSequence charSequenceM210b;
            int themedDrawableRes$default;
            String boostEndsAt;
            C12238m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            if (!(data instanceof Item.GuildBoostItem)) {
                throw new Exception("Incorrect List Item Type or null data");
            }
            View view = this.itemView;
            C12238m.checkNotNullExpressionValue(view, "itemView");
            Context context = view.getContext();
            long jCurrentTimeMillis = ClockFactory.get().currentTimeMillis();
            Item.GuildBoostItem guildBoostItem = (Item.GuildBoostItem) data;
            final ModelGuildBoostSlot boostSlot = guildBoostItem.getBoostSlot();
            ModelAppliedGuildBoost premiumGuildSubscription = boostSlot.getPremiumGuildSubscription();
            boolean z2 = (premiumGuildSubscription != null ? Long.valueOf(premiumGuildSubscription.getGuildId()) : null) != null;
            boolean z3 = boostSlot.getCooldownExpiresAtTimestamp() > jCurrentTimeMillis;
            ModelAppliedGuildBoost premiumGuildSubscription2 = boostSlot.getPremiumGuildSubscription();
            Long lValueOf = premiumGuildSubscription2 != null ? Long.valueOf((premiumGuildSubscription2.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH) : null;
            boolean canceled = boostSlot.getCanceled();
            ImageView imageView = this.binding.f15570c;
            C12238m.checkNotNullExpressionValue(imageView, "binding.boostedBoostCancelled");
            imageView.setVisibility(canceled ? 0 : 8);
            TextView textView = this.binding.f15572e;
            C12238m.checkNotNullExpressionValue(textView, "binding.boostedBoostDate");
            if (lValueOf == null || (string = DateFormat.format("MMMM dd, yyy", lValueOf.longValue())) == null) {
                string = context.getString(C5419R.string.premium_guild_subscription_unused_slot_description);
            }
            textView.setText(string);
            if (!canceled || (boostEndsAt = guildBoostItem.getBoostEndsAt()) == null) {
                i = 0;
                c = 1;
                strReplace$default = null;
            } else {
                C12238m.checkNotNullExpressionValue(context, "context");
                i = 0;
                c = 1;
                strReplace$default = C12103t.replace$default(C1107b.m210b(context, C5419R.string.premium_guild_subscription_pending_cancelation, new Object[]{TimeUtils.renderUtcDate$default(TimeUtils.INSTANCE, boostEndsAt, context, (String) null, (java.text.DateFormat) null, 0, 28, (Object) null)}, (4 & 4) != 0 ? C1107b.b.f1491j : null).toString(), "*", "", false, 4, (Object) null);
            }
            if (z3) {
                long jMax = Math.max(boostSlot.getCooldownExpiresAtTimestamp() - jCurrentTimeMillis, 0L);
                long j = jMax / 86400000;
                long j2 = jMax - (86400000 * j);
                long j3 = j2 / 3600000;
                str = "context";
                C12238m.checkNotNullExpressionValue(context, str);
                Object[] objArr = new Object[3];
                objArr[i] = String.valueOf(j);
                objArr[c] = String.valueOf(j3);
                objArr[2] = String.valueOf((j2 - (3600000 * j3)) / 60000);
                charSequenceM210b = C1107b.m210b(context, C5419R.string.premium_guild_cooldown_available_countdown, objArr, (4 & 4) != 0 ? C1107b.b.f1491j : null);
            } else {
                str = r10;
                charSequenceM210b = null;
            }
            if (strReplace$default == null && charSequenceM210b == null) {
                TextView textView2 = this.binding.f15571d;
                C12238m.checkNotNullExpressionValue(textView2, "binding.boostedBoostCooldown");
                textView2.setVisibility(8);
            } else if (strReplace$default != null && charSequenceM210b != null) {
                TextView textView3 = this.binding.f15571d;
                C12238m.checkNotNullExpressionValue(textView3, "binding.boostedBoostCooldown");
                ViewExtensions.setTextAndVisibilityBy(textView3, charSequenceM210b + " - " + strReplace$default);
            } else if (strReplace$default != null && charSequenceM210b == null) {
                TextView textView4 = this.binding.f15571d;
                C12238m.checkNotNullExpressionValue(textView4, "binding.boostedBoostCooldown");
                ViewExtensions.setTextAndVisibilityBy(textView4, strReplace$default);
            } else if (strReplace$default == null && charSequenceM210b != null) {
                TextView textView5 = this.binding.f15571d;
                C12238m.checkNotNullExpressionValue(textView5, "binding.boostedBoostCooldown");
                ViewExtensions.setTextAndVisibilityBy(textView5, charSequenceM210b);
            }
            TextView textView6 = this.binding.f15569b;
            C12238m.checkNotNullExpressionValue(textView6, "binding.boostedBoostAction");
            textView6.setText((z2 || z3) ? "" : context.getString(C5419R.string.premium_guild_subscription_select_server_button));
            if (!z3 || (!canceled && ((WidgetSettingsGuildBoostSubscriptionAdapter) this.adapter).canCancelBoosts) || (canceled && ((WidgetSettingsGuildBoostSubscriptionAdapter) this.adapter).canUncancelBoosts)) {
                C12238m.checkNotNullExpressionValue(context, str);
                themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(context, C5419R.attr.ic_overflow, i, 2, (Object) null);
            } else {
                themedDrawableRes$default = 0;
            }
            this.binding.f15569b.setCompoundDrawablesWithIntrinsicBounds(i, i, themedDrawableRes$default, i);
            final boolean z4 = z2;
            final boolean z5 = z3;
            this.binding.f15569b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem$onConfigure$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    if (!z4 && !z5) {
                        WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem.access$getAdapter$p(this.this$0).subscribeListener.invoke(Long.valueOf(boostSlot.getId()));
                        return;
                    }
                    WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem guildBoostListItem = this.this$0;
                    C12238m.checkNotNullExpressionValue(view2, "view");
                    guildBoostListItem.showGuildBoostPopup(view2, z5, WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem.access$getAdapter$p(this.this$0).canCancelBoosts, WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem.access$getAdapter$p(this.this$0).canUncancelBoosts, (WidgetSettingsGuildBoostSubscriptionAdapter.Item.GuildBoostItem) data);
                }
            });
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
    public static final class GuildListItem extends MGRecyclerViewHolder<WidgetSettingsGuildBoostSubscriptionAdapter, Item> {
        private final ViewSettingsBoostedGuildListitemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildListItem(WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter) {
            super(C5419R.layout.view_settings_boosted_guild_listitem, widgetSettingsGuildBoostSubscriptionAdapter);
            C12238m.checkNotNullParameter(widgetSettingsGuildBoostSubscriptionAdapter, "adapter");
            View view = this.itemView;
            int i = C5419R.id.boosted_guild_banner;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.boosted_guild_banner);
            if (simpleDraweeView != null) {
                i = C5419R.id.boosted_guild_gradient;
                View viewFindViewById = view.findViewById(C5419R.id.boosted_guild_gradient);
                if (viewFindViewById != null) {
                    i = C5419R.id.boosted_guild_progress_view;
                    GuildBoostProgressView guildBoostProgressView = (GuildBoostProgressView) view.findViewById(C5419R.id.boosted_guild_progress_view);
                    if (guildBoostProgressView != null) {
                        i = C5419R.id.boosted_sample_guild_count;
                        TextView textView = (TextView) view.findViewById(C5419R.id.boosted_sample_guild_count);
                        if (textView != null) {
                            i = C5419R.id.boosted_sample_guild_icon;
                            SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) view.findViewById(C5419R.id.boosted_sample_guild_icon);
                            if (simpleDraweeView2 != null) {
                                i = C5419R.id.boosted_sample_guild_name;
                                TextView textView2 = (TextView) view.findViewById(C5419R.id.boosted_sample_guild_name);
                                if (textView2 != null) {
                                    ViewSettingsBoostedGuildListitemBinding viewSettingsBoostedGuildListitemBinding = new ViewSettingsBoostedGuildListitemBinding((LinearLayout) view, simpleDraweeView, viewFindViewById, guildBoostProgressView, textView, simpleDraweeView2, textView2);
                                    C12238m.checkNotNullExpressionValue(viewSettingsBoostedGuildListitemBinding, "ViewSettingsBoostedGuild…temBinding.bind(itemView)");
                                    this.binding = viewSettingsBoostedGuildListitemBinding;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, Item data) throws Exception {
            C12238m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            if (data instanceof Item.GuildItem) {
                Item.GuildItem guildItem = (Item.GuildItem) data;
                if (guildItem.getGuild() != null) {
                    View view = this.itemView;
                    C12238m.checkNotNullExpressionValue(view, "itemView");
                    Context context = view.getContext();
                    if (guildItem.getGuild().getBanner() != null) {
                        SimpleDraweeView simpleDraweeView = this.binding.f15574b;
                        IconUtils iconUtils = IconUtils.INSTANCE;
                        Guild guild = guildItem.getGuild();
                        C12238m.checkNotNullExpressionValue(context, "context");
                        simpleDraweeView.setImageURI(IconUtils.getBannerForGuild$default(iconUtils, guild, Integer.valueOf(context.getResources().getDimensionPixelSize(C5419R.dimen.nav_panel_width)), false, 4, null));
                        View view2 = this.binding.f15575c;
                        C12238m.checkNotNullExpressionValue(view2, "binding.boostedGuildGradient");
                        view2.setVisibility(0);
                    } else {
                        SimpleDraweeView simpleDraweeView2 = this.binding.f15574b;
                        C12238m.checkNotNullExpressionValue(context, "context");
                        simpleDraweeView2.setBackgroundResource(DrawableCompat.getThemedDrawableRes$default(context, C5419R.attr.bg_subscription_placeholder_pattern, 0, 2, (Object) null));
                        View view3 = this.binding.f15575c;
                        C12238m.checkNotNullExpressionValue(view3, "binding.boostedGuildGradient");
                        view3.setVisibility(8);
                    }
                    SimpleDraweeView simpleDraweeView3 = this.binding.f15578f;
                    C12238m.checkNotNullExpressionValue(simpleDraweeView3, "binding.boostedSampleGuildIcon");
                    IconUtils.setIcon$default(simpleDraweeView3, IconUtils.getForGuild$default(guildItem.getGuild(), null, false, null, 14, null), 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
                    TextView textView = this.binding.f15579g;
                    C12238m.checkNotNullExpressionValue(textView, "binding.boostedSampleGuildName");
                    textView.setText(guildItem.getGuild().getName());
                    CharSequence i18nPluralString = StringResourceUtilsKt.getI18nPluralString(context, C5419R.plurals.premium_guild_subscription_guild_subsription_subtitle_numSubscriptions, guildItem.getBoostCount(), Integer.valueOf(guildItem.getBoostCount()));
                    TextView textView2 = this.binding.f15577e;
                    C12238m.checkNotNullExpressionValue(textView2, "binding.boostedSampleGuildCount");
                    textView2.setText(C1107b.m210b(context, C5419R.string.premium_guild_subscription_guild_subsription_subtitle, new Object[]{i18nPluralString}, (4 & 4) != 0 ? C1107b.b.f1491j : null));
                    this.binding.f15576d.m8596a(guildItem.getGuild().getId(), guildItem.getGuild().getPremiumTier(), guildItem.getGuild().getPremiumSubscriptionCount());
                    return;
                }
            }
            throw new Exception("Incorrect List Item Type or null data");
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
    public static final class HeaderListItem extends MGRecyclerViewHolder<WidgetSettingsGuildBoostSubscriptionAdapter, Item> {
        private final ViewSettingsBoostedHeaderListitemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeaderListItem(WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter) {
            super(C5419R.layout.view_settings_boosted_header_listitem, widgetSettingsGuildBoostSubscriptionAdapter);
            C12238m.checkNotNullParameter(widgetSettingsGuildBoostSubscriptionAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            TextView textView = (TextView) view;
            ViewSettingsBoostedHeaderListitemBinding viewSettingsBoostedHeaderListitemBinding = new ViewSettingsBoostedHeaderListitemBinding(textView, textView);
            C12238m.checkNotNullExpressionValue(viewSettingsBoostedHeaderListitemBinding, "ViewSettingsBoostedHeade…temBinding.bind(itemView)");
            this.binding = viewSettingsBoostedHeaderListitemBinding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, Item data) throws Exception {
            C12238m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            if (!(data instanceof Item.HeaderItem)) {
                throw new Exception("Incorrect List Item Type or null data");
            }
            TextView textView = this.binding.f15581b;
            C12238m.checkNotNullExpressionValue(textView, "binding.boostedHeader");
            View view = this.itemView;
            C12238m.checkNotNullExpressionValue(view, "itemView");
            textView.setText(view.getContext().getString(((Item.HeaderItem) data).getHeaderStringId()));
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
    public static abstract class Item implements MGRecyclerDataPayload {
        public static final int TYPE_GUILD = 0;
        public static final int TYPE_GUILD_BOOST = 1;
        public static final int TYPE_HEADER = 2;

        /* JADX INFO: compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
        public static final /* data */ class GuildBoostItem extends Item {
            private final String boostEndsAt;
            private final ModelGuildBoostSlot boostSlot;
            private final String key;
            private final int type;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GuildBoostItem(ModelGuildBoostSlot modelGuildBoostSlot, String str) {
                super(null);
                C12238m.checkNotNullParameter(modelGuildBoostSlot, "boostSlot");
                this.boostSlot = modelGuildBoostSlot;
                this.boostEndsAt = str;
                this.type = 1;
                this.key = String.valueOf(modelGuildBoostSlot.getId());
            }

            public static /* synthetic */ GuildBoostItem copy$default(GuildBoostItem guildBoostItem, ModelGuildBoostSlot modelGuildBoostSlot, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGuildBoostSlot = guildBoostItem.boostSlot;
                }
                if ((i & 2) != 0) {
                    str = guildBoostItem.boostEndsAt;
                }
                return guildBoostItem.copy(modelGuildBoostSlot, str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelGuildBoostSlot getBoostSlot() {
                return this.boostSlot;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getBoostEndsAt() {
                return this.boostEndsAt;
            }

            public final GuildBoostItem copy(ModelGuildBoostSlot boostSlot, String boostEndsAt) {
                C12238m.checkNotNullParameter(boostSlot, "boostSlot");
                return new GuildBoostItem(boostSlot, boostEndsAt);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GuildBoostItem)) {
                    return false;
                }
                GuildBoostItem guildBoostItem = (GuildBoostItem) other;
                return C12238m.areEqual(this.boostSlot, guildBoostItem.boostSlot) && C12238m.areEqual(this.boostEndsAt, guildBoostItem.boostEndsAt);
            }

            public final String getBoostEndsAt() {
                return this.boostEndsAt;
            }

            public final ModelGuildBoostSlot getBoostSlot() {
                return this.boostSlot;
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
                ModelGuildBoostSlot modelGuildBoostSlot = this.boostSlot;
                int iHashCode = (modelGuildBoostSlot != null ? modelGuildBoostSlot.hashCode() : 0) * 31;
                String str = this.boostEndsAt;
                return iHashCode + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("GuildBoostItem(boostSlot=");
                sbM833U.append(this.boostSlot);
                sbM833U.append(", boostEndsAt=");
                return C1643a.m822J(sbM833U, this.boostEndsAt, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
        public static final /* data */ class GuildItem extends Item {
            private final int boostCount;
            private final Guild guild;
            private final String key;
            private final int type;

            /* JADX WARN: Multi-variable type inference failed */
            public GuildItem(Guild guild, int i) {
                super(0 == true ? 1 : 0);
                this.guild = guild;
                this.boostCount = i;
                this.key = String.valueOf(guild != null ? Long.valueOf(guild.getId()) : null);
            }

            public static /* synthetic */ GuildItem copy$default(GuildItem guildItem, Guild guild, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    guild = guildItem.guild;
                }
                if ((i2 & 2) != 0) {
                    i = guildItem.boostCount;
                }
                return guildItem.copy(guild, i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getBoostCount() {
                return this.boostCount;
            }

            public final GuildItem copy(Guild guild, int boostCount) {
                return new GuildItem(guild, boostCount);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GuildItem)) {
                    return false;
                }
                GuildItem guildItem = (GuildItem) other;
                return C12238m.areEqual(this.guild, guildItem.guild) && this.boostCount == guildItem.boostCount;
            }

            public final int getBoostCount() {
                return this.boostCount;
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
                return ((guild != null ? guild.hashCode() : 0) * 31) + this.boostCount;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("GuildItem(guild=");
                sbM833U.append(this.guild);
                sbM833U.append(", boostCount=");
                return C1643a.m814B(sbM833U, this.boostCount, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
        public static final /* data */ class HeaderItem extends Item {
            private final int headerStringId;
            private final String key;
            private final int type;

            public HeaderItem(@StringRes int i) {
                super(null);
                this.headerStringId = i;
                this.type = 2;
                this.key = String.valueOf(i);
            }

            public static /* synthetic */ HeaderItem copy$default(HeaderItem headerItem, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = headerItem.headerStringId;
                }
                return headerItem.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getHeaderStringId() {
                return this.headerStringId;
            }

            public final HeaderItem copy(@StringRes int headerStringId) {
                return new HeaderItem(headerStringId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof HeaderItem) && this.headerStringId == ((HeaderItem) other).headerStringId;
                }
                return true;
            }

            public final int getHeaderStringId() {
                return this.headerStringId;
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
                return this.headerStringId;
            }

            public String toString() {
                return C1643a.m814B(C1643a.m833U("HeaderItem(headerStringId="), this.headerStringId, ")");
            }
        }

        private Item() {
        }

        public /* synthetic */ Item(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGuildBoostSubscriptionAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        C12238m.checkNotNullParameter(recyclerView, "recycler");
        this.subscribeListener = WidgetSettingsGuildBoostSubscriptionAdapter$subscribeListener$1.INSTANCE;
        this.transferListener = WidgetSettingsGuildBoostSubscriptionAdapter$transferListener$1.INSTANCE;
        this.cancelListener = WidgetSettingsGuildBoostSubscriptionAdapter$cancelListener$1.INSTANCE;
    }

    public final void configure(List<? extends Item> guildBoostItems, Function1<? super Long, Unit> subscribeListener, Function2<? super ModelGuildBoostSlot, ? super Long, Unit> transferListener, Function2<? super Long, ? super Boolean, Unit> cancelListener, boolean canCancelBoosts, boolean canUncancelBoosts) {
        C12238m.checkNotNullParameter(guildBoostItems, "guildBoostItems");
        C12238m.checkNotNullParameter(subscribeListener, "subscribeListener");
        C12238m.checkNotNullParameter(transferListener, "transferListener");
        C12238m.checkNotNullParameter(cancelListener, "cancelListener");
        setData(guildBoostItems);
        this.subscribeListener = subscribeListener;
        this.transferListener = transferListener;
        this.cancelListener = cancelListener;
        this.canCancelBoosts = canCancelBoosts;
        this.canUncancelBoosts = canUncancelBoosts;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<WidgetSettingsGuildBoostSubscriptionAdapter, Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        C12238m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new GuildListItem(this);
        }
        if (viewType == 1) {
            return new GuildBoostListItem(this);
        }
        if (viewType == 2) {
            return new HeaderListItem(this);
        }
        throw invalidViewTypeException(viewType);
    }
}

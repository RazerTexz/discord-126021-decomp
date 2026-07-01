package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.o;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.permission.Permission;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsEmojisBinding;
import com.discord.databinding.WidgetServerSettingsEmojisHeaderBinding;
import com.discord.databinding.WidgetServerSettingsEmojisItemBinding;
import com.discord.databinding.WidgetServerSettingsEmojisSectionBinding;
import com.discord.dialogs.ImageUploadDialog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiGuild;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.CoreUser;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreEmojiGuild;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.extensions.ImageViewExtensions;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.servers.WidgetServerSettingsEmojis;
import com.discord.widgets.servers.WidgetServerSettingsEmojisEdit;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.g0.StringsJVM;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmojis extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsEmojis.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsEmojisBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int EMOJI_MAX_FILESIZE_KB = 256;
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final int VIEW_INDEX_CONTENT = 1;
    private Adapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private long guildId;
    private final AppLogger2 loggingConfig;
    private Action1<String> uploadEmojiAction;

    /* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
    public static final class Adapter extends MGRecyclerAdapterSimple<Item> {
        private Function2<? super View, ? super ModelEmojiGuild, Unit> onEmojiItemClicked;
        private Function0<Unit> onUploadEmoji;

        /* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
        public static final class EmojiEmptyViewHolder extends MGRecyclerViewHolder<Adapter, Item> {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EmojiEmptyViewHolder(Adapter adapter) {
                super(R.layout.widget_server_settings_emojis_empty, adapter);
                Intrinsics3.checkNotNullParameter(adapter, "adapter");
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public void onConfigure(int position, Item data) {
                Intrinsics3.checkNotNullParameter(data, "data");
            }
        }

        /* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
        public static final class EmojiHeaderViewHolder extends MGRecyclerViewHolder<Adapter, Item> {
            private final WidgetServerSettingsEmojisHeaderBinding binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EmojiHeaderViewHolder(Adapter adapter) {
                super(R.layout.widget_server_settings_emojis_header, adapter);
                Intrinsics3.checkNotNullParameter(adapter, "adapter");
                View view = this.itemView;
                int i = R.id.widget_server_settings_emojis_upload;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.widget_server_settings_emojis_upload);
                if (materialButton != null) {
                    i = R.id.widget_server_settings_emojis_upload_description;
                    TextView textView = (TextView) view.findViewById(R.id.widget_server_settings_emojis_upload_description);
                    if (textView != null) {
                        WidgetServerSettingsEmojisHeaderBinding widgetServerSettingsEmojisHeaderBinding = new WidgetServerSettingsEmojisHeaderBinding((LinearLayout) view, materialButton, textView);
                        Intrinsics3.checkNotNullExpressionValue(widgetServerSettingsEmojisHeaderBinding, "WidgetServerSettingsEmoj…derBinding.bind(itemView)");
                        this.binding = widgetServerSettingsEmojisHeaderBinding;
                        return;
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
            }

            public static final /* synthetic */ Adapter access$getAdapter$p(EmojiHeaderViewHolder emojiHeaderViewHolder) {
                return (Adapter) emojiHeaderViewHolder.adapter;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public void onConfigure(int position, Item data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                TextView textView = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.widgetServerSett…gsEmojisUploadDescription");
                textView.setText(FormatUtils.b(outline.x(this.itemView, "itemView", "itemView.context"), R.string.guild_settings_emoji_upload_to_server_message, new Object[]{String.valueOf(((Item.EmojiHeader) data).getEmojiMax()), String.valueOf(256)}, (4 & 4) != 0 ? FormatUtils.b.j : null));
                this.binding.f2564b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsEmojis$Adapter$EmojiHeaderViewHolder$onConfigure$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WidgetServerSettingsEmojis.Adapter.EmojiHeaderViewHolder.access$getAdapter$p(this.this$0).getOnUploadEmoji().invoke();
                    }
                });
            }
        }

        /* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
        public static final class EmojiItemViewHolder extends MGRecyclerViewHolder<Adapter, Item> {
            private final WidgetServerSettingsEmojisItemBinding binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EmojiItemViewHolder(Adapter adapter) {
                super(R.layout.widget_server_settings_emojis_item, adapter);
                Intrinsics3.checkNotNullParameter(adapter, "adapter");
                View view = this.itemView;
                int i = R.id.server_settings_emojis_avatar;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.server_settings_emojis_avatar);
                if (simpleDraweeView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = R.id.server_settings_emojis_name;
                    TextView textView = (TextView) view.findViewById(R.id.server_settings_emojis_name);
                    if (textView != null) {
                        i = R.id.server_settings_emojis_nickname;
                        TextView textView2 = (TextView) view.findViewById(R.id.server_settings_emojis_nickname);
                        if (textView2 != null) {
                            i = R.id.server_settings_emojis_overflow;
                            ImageView imageView = (ImageView) view.findViewById(R.id.server_settings_emojis_overflow);
                            if (imageView != null) {
                                i = R.id.server_settings_emojis_username;
                                TextView textView3 = (TextView) view.findViewById(R.id.server_settings_emojis_username);
                                if (textView3 != null) {
                                    i = R.id.server_settings_emojis_username_avatar;
                                    SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) view.findViewById(R.id.server_settings_emojis_username_avatar);
                                    if (simpleDraweeView2 != null) {
                                        WidgetServerSettingsEmojisItemBinding widgetServerSettingsEmojisItemBinding = new WidgetServerSettingsEmojisItemBinding(constraintLayout, simpleDraweeView, constraintLayout, textView, textView2, imageView, textView3, simpleDraweeView2);
                                        Intrinsics3.checkNotNullExpressionValue(widgetServerSettingsEmojisItemBinding, "WidgetServerSettingsEmoj…temBinding.bind(itemView)");
                                        this.binding = widgetServerSettingsEmojisItemBinding;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
            }

            public static final /* synthetic */ Adapter access$getAdapter$p(EmojiItemViewHolder emojiItemViewHolder) {
                return (Adapter) emojiItemViewHolder.adapter;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public void onConfigure(int position, final Item data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onConfigure(position, data);
                Item.EmojiItem emojiItem = (Item.EmojiItem) data;
                TextView textView = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverSettingsEmojisName");
                textView.setText(emojiItem.getEmoji().getName());
                TextView textView2 = this.binding.f;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.serverSettingsEmojisUsername");
                textView2.setText(UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, emojiItem.getUser(), null, null, 3, null));
                GuildMember guildMember = emojiItem.getGuildMember();
                String nick = guildMember != null ? guildMember.getNick() : null;
                TextView textView3 = this.binding.e;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.serverSettingsEmojisNickname");
                ViewExtensions.setTextAndVisibilityBy(textView3, nick);
                SimpleDraweeView simpleDraweeView = this.binding.g;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.serverSettingsEmojisUsernameAvatar");
                IconUtils.setIcon$default(simpleDraweeView, new CoreUser(emojiItem.getEmoji().getUser()), R.dimen.avatar_size_standard, null, null, guildMember, 24, null);
                String imageUri = ModelEmojiCustom.getImageUri(emojiItem.getEmoji().getId(), emojiItem.getEmoji().getAnimated(), 64);
                SimpleDraweeView simpleDraweeView2 = this.binding.f2565b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.serverSettingsEmojisAvatar");
                MGImages.setImage$default(simpleDraweeView2, imageUri, R.dimen.emoji_size, R.dimen.emoji_size, true, null, null, 96, null);
                SimpleDraweeView simpleDraweeView3 = this.binding.f2565b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.serverSettingsEmojisAvatar");
                ImageViewExtensions.setGrayscale(simpleDraweeView3, !emojiItem.getEmoji().getAvailable());
                SimpleDraweeView simpleDraweeView4 = this.binding.f2565b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "binding.serverSettingsEmojisAvatar");
                simpleDraweeView4.setImageAlpha(emojiItem.getEmoji().getAvailable() ? 255 : 100);
                this.binding.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsEmojis$Adapter$EmojiItemViewHolder$onConfigure$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Function2<View, ModelEmojiGuild, Unit> onEmojiItemClicked = WidgetServerSettingsEmojis.Adapter.EmojiItemViewHolder.access$getAdapter$p(this.this$0).getOnEmojiItemClicked();
                        Intrinsics3.checkNotNullExpressionValue(view, "it");
                        onEmojiItemClicked.invoke(view, ((WidgetServerSettingsEmojis.Item.EmojiItem) data).getEmoji());
                    }
                });
            }
        }

        /* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
        public static final class EmojiSectionViewHolder extends MGRecyclerViewHolder<Adapter, Item> {
            private final WidgetServerSettingsEmojisSectionBinding binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EmojiSectionViewHolder(Adapter adapter) {
                super(R.layout.widget_server_settings_emojis_section, adapter);
                Intrinsics3.checkNotNullParameter(adapter, "adapter");
                View view = this.itemView;
                TextView textView = (TextView) view.findViewById(R.id.widget_server_settings_emojis_section);
                if (textView == null) {
                    throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.widget_server_settings_emojis_section)));
                }
                WidgetServerSettingsEmojisSectionBinding widgetServerSettingsEmojisSectionBinding = new WidgetServerSettingsEmojisSectionBinding((LinearLayout) view, textView);
                Intrinsics3.checkNotNullExpressionValue(widgetServerSettingsEmojisSectionBinding, "WidgetServerSettingsEmoj…ionBinding.bind(itemView)");
                this.binding = widgetServerSettingsEmojisSectionBinding;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public void onConfigure(int position, Item data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onConfigure(position, data);
                Item.EmojiSection emojiSection = (Item.EmojiSection) data;
                int emojiMax = emojiSection.getEmojiMax() - emojiSection.getEmojiLength();
                View view = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view, "itemView");
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "itemView.context");
                Resources resources = context.getResources();
                Intrinsics3.checkNotNullExpressionValue(resources, "itemView.context.resources");
                CharSequence charSequenceB = FormatUtils.b(outline.x(this.itemView, "itemView", "itemView.context"), R.string.emoji_slots_available, new Object[]{StringResourceUtils.getQuantityString(resources, outline.x(this.itemView, "itemView", "itemView.context"), R.plurals.emoji_slots_available_count, emojiMax, Integer.valueOf(emojiMax))}, (4 & 4) != 0 ? FormatUtils.b.j : null);
                TextView textView = this.binding.f2566b;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.widgetServerSettingsEmojisSection");
                textView.setText(FormatUtils.b(outline.x(this.itemView, "itemView", "itemView.context"), R.string.emoji_section, new Object[]{FormatUtils.b(outline.x(this.itemView, "itemView", "itemView.context"), emojiSection.getTitleId(), new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null), charSequenceB}, (4 & 4) != 0 ? FormatUtils.b.j : null));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(RecyclerView recyclerView) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
            this.onUploadEmoji = WidgetServerSettingsEmojis$Adapter$onUploadEmoji$1.INSTANCE;
            this.onEmojiItemClicked = WidgetServerSettingsEmojis$Adapter$onEmojiItemClicked$1.INSTANCE;
        }

        public final Function2<View, ModelEmojiGuild, Unit> getOnEmojiItemClicked() {
            return this.onEmojiItemClicked;
        }

        public final Function0<Unit> getOnUploadEmoji() {
            return this.onUploadEmoji;
        }

        public final void setOnEmojiItemClicked(Function2<? super View, ? super ModelEmojiGuild, Unit> function2) {
            Intrinsics3.checkNotNullParameter(function2, "<set-?>");
            this.onEmojiItemClicked = function2;
        }

        public final void setOnUploadEmoji(Function0<Unit> function0) {
            Intrinsics3.checkNotNullParameter(function0, "<set-?>");
            this.onUploadEmoji = function0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MGRecyclerViewHolder<Adapter, Item> onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            if (viewType == 0) {
                return new EmojiItemViewHolder(this);
            }
            if (viewType == 1) {
                return new EmojiSectionViewHolder(this);
            }
            if (viewType == 2) {
                return new EmojiHeaderViewHolder(this);
            }
            if (viewType == 3) {
                return new EmojiEmptyViewHolder(this);
            }
            throw invalidViewTypeException(viewType);
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("EMOJIS", guildId);
            AppScreen2.d(context, WidgetServerSettingsEmojis.class, new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
    public static abstract class Item implements MGRecyclerDataPayload {
        public static final int TYPE_EMOJI = 0;
        public static final int TYPE_EMPTY = 3;
        public static final int TYPE_HEADER = 2;
        public static final int TYPE_SECTION = 1;

        /* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
        public static final class EmojiEmpty extends Item {
            public static final EmojiEmpty INSTANCE = new EmojiEmpty();
            private static final int type = 3;
            private static final String key = "EMOJI_EMPTY";

            private EmojiEmpty() {
                super(null);
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return key;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return type;
            }
        }

        /* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
        public static final /* data */ class EmojiHeader extends Item {
            private final int emojiMax;
            private final String key;
            private final int type;

            public EmojiHeader(int i) {
                super(null);
                this.emojiMax = i;
                this.type = 2;
                this.key = "EMOJI_HEADER";
            }

            public static /* synthetic */ EmojiHeader copy$default(EmojiHeader emojiHeader, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = emojiHeader.emojiMax;
                }
                return emojiHeader.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getEmojiMax() {
                return this.emojiMax;
            }

            public final EmojiHeader copy(int emojiMax) {
                return new EmojiHeader(emojiMax);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof EmojiHeader) && this.emojiMax == ((EmojiHeader) other).emojiMax;
                }
                return true;
            }

            public final int getEmojiMax() {
                return this.emojiMax;
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
                return this.emojiMax;
            }

            public String toString() {
                return outline.B(outline.U("EmojiHeader(emojiMax="), this.emojiMax, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
        public static final /* data */ class EmojiItem extends Item {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final ModelEmojiGuild emoji;
            private final GuildMember guildMember;
            private final String key;
            private final int type;
            private final User user;

            /* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
            public static final class Companion {
                private Companion() {
                }

                public final EmojiItem from(ModelEmojiGuild emoji, Map<Long, GuildMember> guildMembers) {
                    Intrinsics3.checkNotNullParameter(emoji, "emoji");
                    Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
                    CoreUser coreUser = new CoreUser(emoji.getUser());
                    return new EmojiItem(emoji, coreUser, guildMembers.get(Long.valueOf(coreUser.getId())));
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EmojiItem(ModelEmojiGuild modelEmojiGuild, User user, GuildMember guildMember) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelEmojiGuild, "emoji");
                Intrinsics3.checkNotNullParameter(user, "user");
                this.emoji = modelEmojiGuild;
                this.user = user;
                this.guildMember = guildMember;
                this.key = String.valueOf(modelEmojiGuild.getId());
            }

            public static /* synthetic */ EmojiItem copy$default(EmojiItem emojiItem, ModelEmojiGuild modelEmojiGuild, User user, GuildMember guildMember, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelEmojiGuild = emojiItem.emoji;
                }
                if ((i & 2) != 0) {
                    user = emojiItem.user;
                }
                if ((i & 4) != 0) {
                    guildMember = emojiItem.guildMember;
                }
                return emojiItem.copy(modelEmojiGuild, user, guildMember);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelEmojiGuild getEmoji() {
                return this.emoji;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final User getUser() {
                return this.user;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final GuildMember getGuildMember() {
                return this.guildMember;
            }

            public final EmojiItem copy(ModelEmojiGuild emoji, User user, GuildMember guildMember) {
                Intrinsics3.checkNotNullParameter(emoji, "emoji");
                Intrinsics3.checkNotNullParameter(user, "user");
                return new EmojiItem(emoji, user, guildMember);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EmojiItem)) {
                    return false;
                }
                EmojiItem emojiItem = (EmojiItem) other;
                return Intrinsics3.areEqual(this.emoji, emojiItem.emoji) && Intrinsics3.areEqual(this.user, emojiItem.user) && Intrinsics3.areEqual(this.guildMember, emojiItem.guildMember);
            }

            public final ModelEmojiGuild getEmoji() {
                return this.emoji;
            }

            public final GuildMember getGuildMember() {
                return this.guildMember;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public final User getUser() {
                return this.user;
            }

            public int hashCode() {
                ModelEmojiGuild modelEmojiGuild = this.emoji;
                int iHashCode = (modelEmojiGuild != null ? modelEmojiGuild.hashCode() : 0) * 31;
                User user = this.user;
                int iHashCode2 = (iHashCode + (user != null ? user.hashCode() : 0)) * 31;
                GuildMember guildMember = this.guildMember;
                return iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("EmojiItem(emoji=");
                sbU.append(this.emoji);
                sbU.append(", user=");
                sbU.append(this.user);
                sbU.append(", guildMember=");
                sbU.append(this.guildMember);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
        public static final /* data */ class EmojiSection extends Item {
            private final int emojiLength;
            private final int emojiMax;
            private final String key;
            private final int titleId;
            private final int type;

            public EmojiSection(int i, int i2, int i3) {
                super(null);
                this.emojiMax = i;
                this.emojiLength = i2;
                this.titleId = i3;
                this.type = 1;
                this.key = String.valueOf(i3);
            }

            public static /* synthetic */ EmojiSection copy$default(EmojiSection emojiSection, int i, int i2, int i3, int i4, Object obj) {
                if ((i4 & 1) != 0) {
                    i = emojiSection.emojiMax;
                }
                if ((i4 & 2) != 0) {
                    i2 = emojiSection.emojiLength;
                }
                if ((i4 & 4) != 0) {
                    i3 = emojiSection.titleId;
                }
                return emojiSection.copy(i, i2, i3);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getEmojiMax() {
                return this.emojiMax;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getEmojiLength() {
                return this.emojiLength;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final int getTitleId() {
                return this.titleId;
            }

            public final EmojiSection copy(int emojiMax, int emojiLength, int titleId) {
                return new EmojiSection(emojiMax, emojiLength, titleId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EmojiSection)) {
                    return false;
                }
                EmojiSection emojiSection = (EmojiSection) other;
                return this.emojiMax == emojiSection.emojiMax && this.emojiLength == emojiSection.emojiLength && this.titleId == emojiSection.titleId;
            }

            public final int getEmojiLength() {
                return this.emojiLength;
            }

            public final int getEmojiMax() {
                return this.emojiMax;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final int getTitleId() {
                return this.titleId;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public int hashCode() {
                return (((this.emojiMax * 31) + this.emojiLength) * 31) + this.titleId;
            }

            public String toString() {
                StringBuilder sbU = outline.U("EmojiSection(emojiMax=");
                sbU.append(this.emojiMax);
                sbU.append(", emojiLength=");
                sbU.append(this.emojiLength);
                sbU.append(", titleId=");
                return outline.B(sbU, this.titleId, ")");
            }
        }

        private Item() {
        }

        public /* synthetic */ Item(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String defaultName;
        private final Guild guild;
        private final List<Item> items;

        /* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
        public static final class Companion {
            private Companion() {
            }

            private final Observable<Permission> canManageEmojisAndStickers(long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableI = Observable.i(companion.getPermissions().observePermissionsForGuild(guildId), companion.getGuilds().observeGuild(guildId), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), new Func3<Long, Guild, MeUser, Permission>() { // from class: com.discord.widgets.servers.WidgetServerSettingsEmojis$Model$Companion$canManageEmojisAndStickers$1
                    @Override // rx.functions.Func3
                    public final WidgetServerSettingsEmojis.Model.Permission call(Long l, Guild guild, MeUser meUser) {
                        if (guild == null || l == null) {
                            return null;
                        }
                        return new WidgetServerSettingsEmojis.Model.Permission(PermissionUtils.canAndIsElevated(Permission.MANAGE_EMOJIS_AND_STICKERS, l, meUser.getMfaEnabled(), guild.getMfaLevel()), guild);
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…ld)\n          }\n        }");
                return ObservableExtensionsKt.computationBuffered(observableI);
            }

            private final Model create(Guild guild, List<ModelEmojiGuild> emojis, Map<Long, GuildMember> guildMembers) {
                if (emojis == null) {
                    return new Model(guild, null, null);
                }
                int guildEmojiMaxCount = PremiumUtils.INSTANCE.getGuildEmojiMaxCount(guild);
                Item.EmojiHeader emojiHeader = new Item.EmojiHeader(guildEmojiMaxCount);
                ArrayList arrayList = new ArrayList();
                for (Object obj : emojis) {
                    if (!((ModelEmojiGuild) obj).getAnimated()) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Item.EmojiItem.INSTANCE.from((ModelEmojiGuild) it.next(), guildMembers));
                }
                List listReversed = _Collections.reversed(arrayList2);
                ArrayList arrayList3 = new ArrayList();
                for (Object obj2 : emojis) {
                    if (((ModelEmojiGuild) obj2).getAnimated()) {
                        arrayList3.add(obj2);
                    }
                }
                ArrayList arrayList4 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList3, 10));
                Iterator it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    arrayList4.add(Item.EmojiItem.INSTANCE.from((ModelEmojiGuild) it2.next(), guildMembers));
                }
                List listReversed2 = _Collections.reversed(arrayList4);
                Item.EmojiSection emojiSection = new Item.EmojiSection(guildEmojiMaxCount, listReversed.size(), R.string.emoji);
                Item.EmojiSection emojiSection2 = new Item.EmojiSection(guildEmojiMaxCount, listReversed2.size(), R.string.animated_emoji);
                ArrayList arrayList5 = new ArrayList(CollectionsJVM.listOf(emojiHeader));
                if (!listReversed.isEmpty()) {
                    arrayList5.addAll(_Collections.plus((Collection) CollectionsJVM.listOf(emojiSection), (Iterable) listReversed));
                }
                if (!listReversed2.isEmpty()) {
                    arrayList5.addAll(_Collections.plus((Collection) CollectionsJVM.listOf(emojiSection2), (Iterable) listReversed2));
                }
                if (listReversed.isEmpty() && listReversed2.isEmpty()) {
                    arrayList5.addAll(CollectionsJVM.listOf(Item.EmojiEmpty.INSTANCE));
                }
                StringBuilder sbU = outline.U("emoji_");
                sbU.append(emojis.size() + 1);
                return new Model(guild, arrayList5, sbU.toString());
            }

            private final Observable<Model> getGuildEmojis(Guild guild) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                final StoreEmojiGuild guildEmojis = companion.getGuildEmojis();
                StoreGuilds guilds = companion.getGuilds();
                final long id2 = guild.getId();
                Observable observableV = ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{guildEmojis, guilds}, false, null, null, new WidgetServerSettingsEmojis$Model$Companion$getGuildEmojis$1(guild, guildEmojis, guilds), 14, null).v(new Action0() { // from class: com.discord.widgets.servers.WidgetServerSettingsEmojis$Model$Companion$getGuildEmojis$2
                    @Override // rx.functions.Action0
                    public final void call() {
                        guildEmojis.fetchGuildEmoji(id2);
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableV, "ObservationDeckProvider.…etchGuildEmoji(guildId) }");
                return ObservableExtensionsKt.computationBuffered(observableV);
            }

            public final Observable<Model> get(long guildId) {
                Observable observableY = canManageEmojisAndStickers(guildId).Y(new Func1<Permission, Observable<? extends Model>>() { // from class: com.discord.widgets.servers.WidgetServerSettingsEmojis$Model$Companion$get$1
                    @Override // j0.k.Func1
                    public final Observable<? extends WidgetServerSettingsEmojis.Model> call(WidgetServerSettingsEmojis.Model.Permission permission) {
                        return (permission == null || !permission.getCanManage()) ? new ScalarSynchronousObservable(null) : WidgetServerSettingsEmojis.Model.INSTANCE.getGuildEmojis(permission.getGuild());
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableY, "canManageEmojisAndSticke…          }\n            }");
                return observableY;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
        public static final /* data */ class Permission {
            private final boolean canManage;
            private final Guild guild;

            public Permission(boolean z2, Guild guild) {
                Intrinsics3.checkNotNullParameter(guild, "guild");
                this.canManage = z2;
                this.guild = guild;
            }

            public static /* synthetic */ Permission copy$default(Permission permission, boolean z2, Guild guild, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = permission.canManage;
                }
                if ((i & 2) != 0) {
                    guild = permission.guild;
                }
                return permission.copy(z2, guild);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getCanManage() {
                return this.canManage;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            public final Permission copy(boolean canManage, Guild guild) {
                Intrinsics3.checkNotNullParameter(guild, "guild");
                return new Permission(canManage, guild);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Permission)) {
                    return false;
                }
                Permission permission = (Permission) other;
                return this.canManage == permission.canManage && Intrinsics3.areEqual(this.guild, permission.guild);
            }

            public final boolean getCanManage() {
                return this.canManage;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v4 */
            /* JADX WARN: Type inference failed for: r0v5 */
            public int hashCode() {
                boolean z2 = this.canManage;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = r0 * 31;
                Guild guild = this.guild;
                return i + (guild != null ? guild.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Permission(canManage=");
                sbU.append(this.canManage);
                sbU.append(", guild=");
                sbU.append(this.guild);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(Guild guild, List<? extends Item> list, String str) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            this.guild = guild;
            this.items = list;
            this.defaultName = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, Guild guild, List list, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = model.guild;
            }
            if ((i & 2) != 0) {
                list = model.items;
            }
            if ((i & 4) != 0) {
                str = model.defaultName;
            }
            return model.copy(guild, list, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final List<Item> component2() {
            return this.items;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getDefaultName() {
            return this.defaultName;
        }

        public final Model copy(Guild guild, List<? extends Item> items, String defaultName) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            return new Model(guild, items, defaultName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.items, model.items) && Intrinsics3.areEqual(this.defaultName, model.defaultName);
        }

        public final String getDefaultName() {
            return this.defaultName;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final List<Item> getItems() {
            return this.items;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            List<Item> list = this.items;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            String str = this.defaultName;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(guild=");
            sbU.append(this.guild);
            sbU.append(", items=");
            sbU.append(this.items);
            sbU.append(", defaultName=");
            return outline.J(sbU, this.defaultName, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEmojis$configureUI$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetServerSettingsEmojis.this.openMediaChooser();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEmojis$configureUI$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
    public static final class AnonymousClass3 extends Lambda implements Function2<View, ModelEmojiGuild, Unit> {
        public AnonymousClass3() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, ModelEmojiGuild modelEmojiGuild) {
            invoke2(view, modelEmojiGuild);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view, ModelEmojiGuild modelEmojiGuild) {
            Intrinsics3.checkNotNullParameter(view, "view");
            Intrinsics3.checkNotNullParameter(modelEmojiGuild, "emoji");
            WidgetServerSettingsEmojis.this.launchEditScreen(view, modelEmojiGuild);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEmojis$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) throws Exception {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) throws Exception {
            WidgetServerSettingsEmojis.this.configureUI(model);
        }
    }

    public WidgetServerSettingsEmojis() {
        super(R.layout.widget_server_settings_emojis);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsEmojis$binding$2.INSTANCE, null, 2, null);
        this.guildId = -1L;
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettingsEmojis$loggingConfig$1.INSTANCE, 3);
    }

    private final void configureToolbar(String guildName) {
        setActionBarTitle(R.string.emoji);
        setActionBarSubtitle(guildName);
    }

    private final void configureUI(final Model model) throws Exception {
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
                return;
            }
            return;
        }
        configureToolbar(model.getGuild().getName());
        List<Item> items = model.getItems();
        if (items == null || items.isEmpty()) {
            return;
        }
        String defaultName = model.getDefaultName();
        if (defaultName == null || StringsJVM.isBlank(defaultName)) {
            return;
        }
        AppViewFlipper appViewFlipper = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.widgetServerSettingsEmojisViewFlipper");
        appViewFlipper.setDisplayedChild(1);
        this.uploadEmojiAction = new Action1<String>() { // from class: com.discord.widgets.servers.WidgetServerSettingsEmojis.configureUI.1
            @Override // rx.functions.Action1
            public final void call(String str) {
                WidgetServerSettingsEmojis widgetServerSettingsEmojis = WidgetServerSettingsEmojis.this;
                String defaultName2 = model.getDefaultName();
                Intrinsics3.checkNotNullExpressionValue(str, "dataUrl");
                widgetServerSettingsEmojis.uploadEmoji(defaultName2, str);
            }
        };
        Adapter adapter = this.adapter;
        if (adapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        adapter.setData(model.getItems());
        Adapter adapter2 = this.adapter;
        if (adapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        adapter2.setOnUploadEmoji(new AnonymousClass2());
        Adapter adapter3 = this.adapter;
        if (adapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        adapter3.setOnEmojiItemClicked(new AnonymousClass3());
    }

    private final WidgetServerSettingsEmojisBinding getBinding() {
        return (WidgetServerSettingsEmojisBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void launchEditScreen(View v, ModelEmojiGuild emoji) {
        WidgetServerSettingsEmojisEdit.Companion companion = WidgetServerSettingsEmojisEdit.INSTANCE;
        Context context = v.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "v.context");
        companion.create(context, this.guildId, emoji.getId(), emoji.getName());
    }

    private final void uploadEmoji(String name, String imageBase64) {
        ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().postGuildEmoji(this.guildId, new RestAPIParams.PostGuildEmoji(name, imageBase64)), false, 1, null), this, null, 2, null).k(o.i(new Action1<ModelEmojiGuild>() { // from class: com.discord.widgets.servers.WidgetServerSettingsEmojis.uploadEmoji.1
            @Override // rx.functions.Action1
            public final void call(ModelEmojiGuild modelEmojiGuild) {
            }
        }, this));
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        MGImages.prepareImageUpload(uri, mimeType, parentFragmentManager, this, this.uploadEmojiAction, ImageUploadDialog.PreviewType.EMOJI);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        MGImages.requestDataUrl(getContext(), uri, mimeType, this.uploadEmojiAction);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        StoreStream.INSTANCE.getGuildEmojis().deactivate();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        this.guildId = getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ID", -1L);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f2562b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.widgetServerSettingsEmojisRecycler");
        this.adapter = (Adapter) companion.configure(new Adapter(recyclerView));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        StoreStream.INSTANCE.getGuildEmojis().activate(this.guildId);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(this.guildId), this, null, 2, null), (Class<?>) WidgetServerSettingsEmojis.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}

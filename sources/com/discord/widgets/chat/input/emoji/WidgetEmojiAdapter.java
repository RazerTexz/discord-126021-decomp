package com.discord.widgets.chat.input.emoji;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.EmojiPickerEmojiItemBinding;
import com.discord.databinding.EmojiPickerPremiumUpsellBinding;
import com.discord.databinding.ExpressionPickerHeaderItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiCategory;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ImageViewExtensions;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.chat.input.emoji.WidgetEmojiAdapter;
import com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.Result2;
import d0.Result3;
import d0.d0._Ranges;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetEmojiAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiAdapter extends WidgetExpressionPickerAdapter {
    private static final int DEFAULT_NUM_COLUMNS = 8;
    private static final int ITEM_TYPE_EMOJI = 1;
    private static final int ITEM_TYPE_PREMIUM_UPSELL = 2;
    private static final int MAX_EMOJI_SIZE_PX = 64;
    private final int emojiSizePx;
    private final FragmentManager fragmentManager;
    private final Function0<Unit> hideKeyboard;
    private final GridLayoutManager layoutManager;
    private final int numColumns;
    private final OnEmojiSelectedListener onEmojiSelectedListener;
    private final Function0<Unit> onGetPremiumCtaClicked;

    /* JADX INFO: compiled from: WidgetEmojiAdapter.kt */
    public static final class EmojiViewHolder extends MGRecyclerViewHolder<WidgetEmojiAdapter, MGRecyclerDataPayload> {
        private final EmojiPickerEmojiItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmojiViewHolder(WidgetEmojiAdapter widgetEmojiAdapter) {
            super(R.layout.emoji_picker_emoji_item, widgetEmojiAdapter);
            Intrinsics3.checkNotNullParameter(widgetEmojiAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view;
            EmojiPickerEmojiItemBinding emojiPickerEmojiItemBinding = new EmojiPickerEmojiItemBinding(simpleDraweeView, simpleDraweeView);
            Intrinsics3.checkNotNullExpressionValue(emojiPickerEmojiItemBinding, "EmojiPickerEmojiItemBinding.bind(itemView)");
            this.binding = emojiPickerEmojiItemBinding;
        }

        public static final /* synthetic */ WidgetEmojiAdapter access$getAdapter$p(EmojiViewHolder emojiViewHolder) {
            return (WidgetEmojiAdapter) emojiViewHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            if (!(data instanceof EmojiItem)) {
                data = null;
            }
            EmojiItem emojiItem = (EmojiItem) data;
            if (emojiItem != null) {
                final Emoji emoji = emojiItem.getEmoji();
                int iCoerceAtMost = _Ranges.coerceAtMost(IconUtils.getMediaProxySize(((WidgetEmojiAdapter) this.adapter).emojiSizePx), 64);
                boolean allowEmojisToAnimate = emojiItem.getAllowEmojisToAnimate();
                SimpleDraweeView simpleDraweeView = this.binding.f2101b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.emojiItemDraweeview");
                String imageUri = emoji.getImageUri(allowEmojisToAnimate, iCoerceAtMost, simpleDraweeView.getContext());
                SimpleDraweeView simpleDraweeView2 = this.binding.f2101b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.emojiItemDraweeview");
                MGImages.setImage$default(simpleDraweeView2, imageUri, 0, 0, true, null, null, 108, null);
                SimpleDraweeView simpleDraweeView3 = this.binding.f2101b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.emojiItemDraweeview");
                ImageViewExtensions.setGrayscale(simpleDraweeView3, (emoji.isUsable() && emoji.isAvailable()) ? false : true);
                SimpleDraweeView simpleDraweeView4 = this.binding.f2101b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "binding.emojiItemDraweeview");
                simpleDraweeView4.setImageAlpha((emoji.isUsable() && emoji.isAvailable()) ? 255 : 100);
                SimpleDraweeView simpleDraweeView5 = this.binding.f2101b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView5, "binding.emojiItemDraweeview");
                simpleDraweeView5.setContentDescription(emoji.getFirstName());
                this.binding.a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.emoji.WidgetEmojiAdapter$EmojiViewHolder$onConfigure$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        if (emoji.isUsable() && emoji.isAvailable()) {
                            StoreStream.INSTANCE.getEmojis().onEmojiUsed(emoji);
                        }
                        WidgetEmojiAdapter.EmojiViewHolder.access$getAdapter$p(this.this$0).onEmojiSelectedListener.onEmojiSelected(emoji);
                        WidgetEmojiAdapter.EmojiViewHolder emojiViewHolder = this.this$0;
                        try {
                            Result2.a aVar = Result2.j;
                            Result2.m97constructorimpl(Boolean.valueOf(emojiViewHolder.binding.f2101b.performHapticFeedback(3)));
                        } catch (Throwable th) {
                            Result2.a aVar2 = Result2.j;
                            Result2.m97constructorimpl(Result3.createFailure(th));
                        }
                    }
                });
                SimpleDraweeView simpleDraweeView6 = this.binding.a;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView6, "binding.root");
                ViewExtensions.setOnLongClickListenerConsumeClick(simpleDraweeView6, new WidgetEmojiAdapter3(this, emojiItem));
            }
        }
    }

    /* JADX INFO: compiled from: WidgetEmojiAdapter.kt */
    public static abstract class HeaderItem implements MGRecyclerDataPayload {
        private final int type;

        /* JADX INFO: compiled from: WidgetEmojiAdapter.kt */
        public static final /* data */ class GuildHeaderItem extends HeaderItem {
            private final String key;
            private final String text;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GuildHeaderItem(String str, String str2) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                Intrinsics3.checkNotNullParameter(str2, "key");
                this.text = str;
                this.key = str2;
            }

            public static /* synthetic */ GuildHeaderItem copy$default(GuildHeaderItem guildHeaderItem, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = guildHeaderItem.text;
                }
                if ((i & 2) != 0) {
                    str2 = guildHeaderItem.getKey();
                }
                return guildHeaderItem.copy(str, str2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getText() {
                return this.text;
            }

            public final String component2() {
                return getKey();
            }

            public final GuildHeaderItem copy(String text, String key) {
                Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                Intrinsics3.checkNotNullParameter(key, "key");
                return new GuildHeaderItem(text, key);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GuildHeaderItem)) {
                    return false;
                }
                GuildHeaderItem guildHeaderItem = (GuildHeaderItem) other;
                return Intrinsics3.areEqual(this.text, guildHeaderItem.text) && Intrinsics3.areEqual(getKey(), guildHeaderItem.getKey());
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final String getText() {
                return this.text;
            }

            public int hashCode() {
                String str = this.text;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                String key = getKey();
                return iHashCode + (key != null ? key.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("GuildHeaderItem(text=");
                sbU.append(this.text);
                sbU.append(", key=");
                sbU.append(getKey());
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public GuildHeaderItem(Guild guild) {
                this(guild.getName(), String.valueOf(guild.getId()));
                Intrinsics3.checkNotNullParameter(guild, "guild");
            }
        }

        /* JADX INFO: compiled from: WidgetEmojiAdapter.kt */
        public static final /* data */ class StandardHeaderItem extends HeaderItem {
            private final EmojiCategory emojiCategory;
            private final String key;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StandardHeaderItem(EmojiCategory emojiCategory) {
                super(null);
                Intrinsics3.checkNotNullParameter(emojiCategory, "emojiCategory");
                this.emojiCategory = emojiCategory;
                this.key = emojiCategory.name();
            }

            public static /* synthetic */ StandardHeaderItem copy$default(StandardHeaderItem standardHeaderItem, EmojiCategory emojiCategory, int i, Object obj) {
                if ((i & 1) != 0) {
                    emojiCategory = standardHeaderItem.emojiCategory;
                }
                return standardHeaderItem.copy(emojiCategory);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final EmojiCategory getEmojiCategory() {
                return this.emojiCategory;
            }

            public final StandardHeaderItem copy(EmojiCategory emojiCategory) {
                Intrinsics3.checkNotNullParameter(emojiCategory, "emojiCategory");
                return new StandardHeaderItem(emojiCategory);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof StandardHeaderItem) && Intrinsics3.areEqual(this.emojiCategory, ((StandardHeaderItem) other).emojiCategory);
                }
                return true;
            }

            public final EmojiCategory getEmojiCategory() {
                return this.emojiCategory;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public int hashCode() {
                EmojiCategory emojiCategory = this.emojiCategory;
                if (emojiCategory != null) {
                    return emojiCategory.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("StandardHeaderItem(emojiCategory=");
                sbU.append(this.emojiCategory);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: WidgetEmojiAdapter.kt */
        public static final /* data */ class StringHeaderItem extends HeaderItem {
            private final String key;
            private final int stringRes;

            public StringHeaderItem(@StringRes int i) {
                super(null);
                this.stringRes = i;
                this.key = String.valueOf(i);
            }

            public static /* synthetic */ StringHeaderItem copy$default(StringHeaderItem stringHeaderItem, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = stringHeaderItem.stringRes;
                }
                return stringHeaderItem.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getStringRes() {
                return this.stringRes;
            }

            public final StringHeaderItem copy(@StringRes int stringRes) {
                return new StringHeaderItem(stringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof StringHeaderItem) && this.stringRes == ((StringHeaderItem) other).stringRes;
                }
                return true;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final int getStringRes() {
                return this.stringRes;
            }

            public int hashCode() {
                return this.stringRes;
            }

            public String toString() {
                return outline.B(outline.U("StringHeaderItem(stringRes="), this.stringRes, ")");
            }
        }

        private HeaderItem() {
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public /* synthetic */ HeaderItem(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetEmojiAdapter.kt */
    public static final class HeaderViewHolder extends MGRecyclerViewHolder<WidgetEmojiAdapter, MGRecyclerDataPayload> implements WidgetExpressionPickerAdapter.StickyHeaderViewHolder {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final ExpressionPickerHeaderItemBinding binding;
        public HeaderItem boundItem;

        /* JADX INFO: compiled from: WidgetEmojiAdapter.kt */
        public static final class Companion {

            public final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    EmojiCategory.values();
                    int[] iArr = new int[11];
                    $EnumSwitchMapping$0 = iArr;
                    iArr[EmojiCategory.FAVORITE.ordinal()] = 1;
                    iArr[EmojiCategory.PEOPLE.ordinal()] = 2;
                    iArr[EmojiCategory.NATURE.ordinal()] = 3;
                    iArr[EmojiCategory.FOOD.ordinal()] = 4;
                    iArr[EmojiCategory.ACTIVITY.ordinal()] = 5;
                    iArr[EmojiCategory.TRAVEL.ordinal()] = 6;
                    iArr[EmojiCategory.OBJECTS.ordinal()] = 7;
                    iArr[EmojiCategory.SYMBOLS.ordinal()] = 8;
                    iArr[EmojiCategory.FLAGS.ordinal()] = 9;
                    iArr[EmojiCategory.CUSTOM.ordinal()] = 10;
                    iArr[EmojiCategory.RECENT.ordinal()] = 11;
                }
            }

            private Companion() {
            }

            @StringRes
            public final int getCategoryString(EmojiCategory emojiCategory) {
                Intrinsics3.checkNotNullParameter(emojiCategory, "emojiCategory");
                switch (emojiCategory) {
                    case FAVORITE:
                        return R.string.category_favorite;
                    case RECENT:
                        return R.string.emoji_category_recent;
                    case CUSTOM:
                        return R.string.emoji_category_custom;
                    case PEOPLE:
                        return R.string.emoji_category_people;
                    case NATURE:
                        return R.string.emoji_category_nature;
                    case FOOD:
                        return R.string.emoji_category_food;
                    case ACTIVITY:
                        return R.string.emoji_category_activity;
                    case TRAVEL:
                        return R.string.emoji_category_travel;
                    case OBJECTS:
                        return R.string.emoji_category_objects;
                    case SYMBOLS:
                        return R.string.emoji_category_symbols;
                    case FLAGS:
                        return R.string.emoji_category_flags;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeaderViewHolder(WidgetEmojiAdapter widgetEmojiAdapter) {
            super(R.layout.expression_picker_header_item, widgetEmojiAdapter);
            Intrinsics3.checkNotNullParameter(widgetEmojiAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            TextView textView = (TextView) view;
            ExpressionPickerHeaderItemBinding expressionPickerHeaderItemBinding = new ExpressionPickerHeaderItemBinding(textView, textView);
            Intrinsics3.checkNotNullExpressionValue(expressionPickerHeaderItemBinding, "ExpressionPickerHeaderItemBinding.bind(itemView)");
            this.binding = expressionPickerHeaderItemBinding;
        }

        @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter.StickyHeaderViewHolder
        public void bind(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            onConfigure(position, data);
        }

        public final HeaderItem getBoundItem() {
            HeaderItem headerItem = this.boundItem;
            if (headerItem == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("boundItem");
            }
            return headerItem;
        }

        @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter.StickyHeaderViewHolder
        public View getItemView() {
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            return view;
        }

        public final void setBoundItem(HeaderItem headerItem) {
            Intrinsics3.checkNotNullParameter(headerItem, "<set-?>");
            this.boundItem = headerItem;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, MGRecyclerDataPayload data) {
            Unit unit;
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            if (!(data instanceof HeaderItem)) {
                data = null;
            }
            HeaderItem headerItem = (HeaderItem) data;
            if (headerItem != null) {
                this.boundItem = headerItem;
                if (headerItem instanceof HeaderItem.StandardHeaderItem) {
                    TextView textView = this.binding.f2105b;
                    Intrinsics3.checkNotNullExpressionValue(textView, "binding.headerItemText");
                    FormatUtils.m(textView, INSTANCE.getCategoryString(((HeaderItem.StandardHeaderItem) headerItem).getEmojiCategory()), new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
                    unit = Unit.a;
                } else if (headerItem instanceof HeaderItem.GuildHeaderItem) {
                    TextView textView2 = this.binding.f2105b;
                    Intrinsics3.checkNotNullExpressionValue(textView2, "binding.headerItemText");
                    textView2.setText(((HeaderItem.GuildHeaderItem) headerItem).getText());
                    unit = Unit.a;
                } else {
                    if (!(headerItem instanceof HeaderItem.StringHeaderItem)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    TextView textView3 = this.binding.f2105b;
                    Intrinsics3.checkNotNullExpressionValue(textView3, "binding.headerItemText");
                    FormatUtils.m(textView3, ((HeaderItem.StringHeaderItem) headerItem).getStringRes(), new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
                    unit = Unit.a;
                }
                KotlinExtensions.getExhaustive(unit);
            }
        }
    }

    /* JADX INFO: compiled from: WidgetEmojiAdapter.kt */
    public static final class PremiumEmojiUpsellViewHolder extends MGRecyclerViewHolder<WidgetEmojiAdapter, MGRecyclerDataPayload> {
        private final EmojiPickerPremiumUpsellBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PremiumEmojiUpsellViewHolder(final WidgetEmojiAdapter widgetEmojiAdapter) {
            super(R.layout.emoji_picker_premium_upsell, widgetEmojiAdapter);
            Intrinsics3.checkNotNullParameter(widgetEmojiAdapter, "adapter");
            View view = this.itemView;
            TextView textView = (TextView) view.findViewById(R.id.emojiPickerPremiumCta);
            if (textView == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.emojiPickerPremiumCta)));
            }
            EmojiPickerPremiumUpsellBinding emojiPickerPremiumUpsellBinding = new EmojiPickerPremiumUpsellBinding((LinearLayout) view, textView);
            Intrinsics3.checkNotNullExpressionValue(emojiPickerPremiumUpsellBinding, "EmojiPickerPremiumUpsellBinding.bind(itemView)");
            this.binding = emojiPickerPremiumUpsellBinding;
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.emoji.WidgetEmojiAdapter.PremiumEmojiUpsellViewHolder.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    widgetEmojiAdapter.onGetPremiumCtaClicked.invoke();
                }
            });
        }
    }

    /* JADX INFO: compiled from: WidgetEmojiAdapter.kt */
    public static final class UpsellItem implements MGRecyclerDataPayload {
        private static final String key;
        public static final UpsellItem INSTANCE = new UpsellItem();
        private static final int type = 2;

        static {
            String name = UpsellItem.class.getName();
            Intrinsics3.checkNotNullExpressionValue(name, "javaClass.name");
            key = name;
        }

        private UpsellItem() {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetEmojiAdapter(RecyclerView recyclerView, FragmentManager fragmentManager, OnEmojiSelectedListener onEmojiSelectedListener, Function0<Unit> function0, Function0<Unit> function1) {
        super(recyclerView, null, 2, 0 == true ? 1 : 0);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(onEmojiSelectedListener, "onEmojiSelectedListener");
        Intrinsics3.checkNotNullParameter(function0, "onGetPremiumCtaClicked");
        Intrinsics3.checkNotNullParameter(function1, "hideKeyboard");
        this.fragmentManager = fragmentManager;
        this.onEmojiSelectedListener = onEmojiSelectedListener;
        this.onGetPremiumCtaClicked = function0;
        this.hideKeyboard = function1;
        Context context = recyclerView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "recycler.context");
        this.emojiSizePx = context.getResources().getDimensionPixelSize(R.dimen.chat_input_emoji_size);
        Context context2 = recyclerView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "recycler.context");
        this.numColumns = WidgetExpressionPickerAdapter.INSTANCE.calculateNumOfColumns(recyclerView, context2.getResources().getDimension(R.dimen.chat_input_emoji_size), 8);
        this.layoutManager = new GridLayoutManager(recyclerView.getContext(), getNumColumns());
        getLayoutManager().setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.discord.widgets.chat.input.emoji.WidgetEmojiAdapter.1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int position) {
                int itemViewType = WidgetEmojiAdapter.this.getItemViewType(position);
                if (itemViewType == 0 || itemViewType == 2) {
                    return WidgetEmojiAdapter.this.getNumColumns();
                }
                return 1;
            }
        });
        recyclerView.setLayoutManager(getLayoutManager());
        recyclerView.setAdapter(this);
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter
    public GridLayoutManager getLayoutManager() {
        return this.layoutManager;
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter
    public int getNumColumns() {
        return this.numColumns;
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration.StickyHeaderAdapter
    public boolean isHeader(int position) {
        return _Collections.getOrNull(getInternalData(), position) instanceof HeaderItem;
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter
    public HeaderViewHolder createStickyHeaderViewHolder(WidgetExpressionPickerAdapter adapter) {
        Intrinsics3.checkNotNullParameter(adapter, "adapter");
        return new HeaderViewHolder((WidgetEmojiAdapter) adapter);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<WidgetEmojiAdapter, MGRecyclerDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new HeaderViewHolder(this);
        }
        if (viewType == 1) {
            return new EmojiViewHolder(this);
        }
        if (viewType == 2) {
            return new PremiumEmojiUpsellViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }

    /* JADX INFO: compiled from: WidgetEmojiAdapter.kt */
    public static final /* data */ class EmojiItem implements MGRecyclerDataPayload {
        private final boolean allowEmojisToAnimate;
        private final Emoji emoji;
        private final String emojiName;
        private final String guildName;
        private final String key;
        private final int type;

        public EmojiItem(String str, Emoji emoji, String str2, boolean z2) {
            Intrinsics3.checkNotNullParameter(emoji, "emoji");
            Intrinsics3.checkNotNullParameter(str2, "emojiName");
            this.guildName = str;
            this.emoji = emoji;
            this.emojiName = str2;
            this.allowEmojisToAnimate = z2;
            this.type = 1;
            String uniqueId = emoji.getUniqueId();
            Intrinsics3.checkNotNullExpressionValue(uniqueId, "emoji.uniqueId");
            this.key = uniqueId;
        }

        public static /* synthetic */ EmojiItem copy$default(EmojiItem emojiItem, String str, Emoji emoji, String str2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = emojiItem.guildName;
            }
            if ((i & 2) != 0) {
                emoji = emojiItem.emoji;
            }
            if ((i & 4) != 0) {
                str2 = emojiItem.emojiName;
            }
            if ((i & 8) != 0) {
                z2 = emojiItem.allowEmojisToAnimate;
            }
            return emojiItem.copy(str, emoji, str2, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getGuildName() {
            return this.guildName;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Emoji getEmoji() {
            return this.emoji;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getEmojiName() {
            return this.emojiName;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getAllowEmojisToAnimate() {
            return this.allowEmojisToAnimate;
        }

        public final EmojiItem copy(String guildName, Emoji emoji, String emojiName, boolean allowEmojisToAnimate) {
            Intrinsics3.checkNotNullParameter(emoji, "emoji");
            Intrinsics3.checkNotNullParameter(emojiName, "emojiName");
            return new EmojiItem(guildName, emoji, emojiName, allowEmojisToAnimate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EmojiItem)) {
                return false;
            }
            EmojiItem emojiItem = (EmojiItem) other;
            return Intrinsics3.areEqual(this.guildName, emojiItem.guildName) && Intrinsics3.areEqual(this.emoji, emojiItem.emoji) && Intrinsics3.areEqual(this.emojiName, emojiItem.emojiName) && this.allowEmojisToAnimate == emojiItem.allowEmojisToAnimate;
        }

        public final boolean getAllowEmojisToAnimate() {
            return this.allowEmojisToAnimate;
        }

        public final Emoji getEmoji() {
            return this.emoji;
        }

        public final String getEmojiName() {
            return this.emojiName;
        }

        public final String getGuildName() {
            return this.guildName;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            String str = this.guildName;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            Emoji emoji = this.emoji;
            int iHashCode2 = (iHashCode + (emoji != null ? emoji.hashCode() : 0)) * 31;
            String str2 = this.emojiName;
            int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z2 = this.allowEmojisToAnimate;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode3 + r1;
        }

        public String toString() {
            StringBuilder sbU = outline.U("EmojiItem(guildName=");
            sbU.append(this.guildName);
            sbU.append(", emoji=");
            sbU.append(this.emoji);
            sbU.append(", emojiName=");
            sbU.append(this.emojiName);
            sbU.append(", allowEmojisToAnimate=");
            return outline.O(sbU, this.allowEmojisToAnimate, ")");
        }

        public /* synthetic */ EmojiItem(String str, Emoji emoji, String str2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, emoji, str2, (i & 8) != 0 ? false : z2);
        }
    }
}

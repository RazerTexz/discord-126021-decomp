package com.discord.widgets.chat.input.autocomplete.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppComponent;
import com.discord.databinding.WidgetChatInputAutocompleteItemBinding;
import com.discord.databinding.WidgetChatInputCommandApplicationHeaderItemBinding;
import com.discord.databinding.WidgetChatInputEmojiAutocompleteUpsellItemBinding;
import com.discord.databinding.WidgetChatInputSlashLoadingItemBinding;
import com.discord.models.commands.Application;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.utilities.views.StickyHeaderItemDecoration;
import com.discord.views.PileView;
import com.discord.views.StatusView;
import com.discord.widgets.chat.input.autocomplete.ApplicationCommandAutocompletable;
import com.discord.widgets.chat.input.autocomplete.ApplicationCommandChoiceAutocompletable;
import com.discord.widgets.chat.input.autocomplete.ApplicationCommandLoadingPlaceholder;
import com.discord.widgets.chat.input.autocomplete.ApplicationPlaceholder;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.ChannelAutocompletable;
import com.discord.widgets.chat.input.autocomplete.EmojiAutocompletable;
import com.discord.widgets.chat.input.autocomplete.EmojiUpsellPlaceholder;
import com.discord.widgets.chat.input.autocomplete.GlobalRoleAutocompletable;
import com.discord.widgets.chat.input.autocomplete.RoleAutocompletable;
import com.discord.widgets.chat.input.autocomplete.UserAutocompletable;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.Collections2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import rx.Emitter;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/* JADX INFO: compiled from: ChatInputAutocompleteAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputAutocompleteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements StickyHeaderItemDecoration.StickyHeaderAdapter {
    private static final int COMMAND_HEADER_HEIGHT = 32;
    public static final int CONTAINER_ROW_MAX_VISIBLE_COUNT = 4;
    private static final int EMOJI_AUTOCOMPLETE_UPSELL_HEIGHT = 52;
    private static final int MENTION_CONTAINER_MAX_SIZE = 176;
    private static final int MENTION_CONTAINER_MAX_SIZE_WITH_STICKERS = 132;
    private static final int MENTION_ROW_HEIGHT_DEFAULT = 44;
    public static final int VIEW_TYPE_AUTOCOMPLETE_ITEM = 0;
    public static final int VIEW_TYPE_COMMAND_HEADER_ITEM = 1;
    public static final int VIEW_TYPE_COMMAND_LOADING_ITEM = 2;
    public static final int VIEW_TYPE_EMOJI_UPSELL_AUTOCOMPLETE = 3;
    private List<? extends Autocompletable> data = Collections2.emptyList();
    private List<Integer> headerPositions = Collections2.emptyList();
    private Function1<? super Autocompletable, Unit> onItemSelected;
    private RecyclerView.OnScrollListener onScrollListener;
    private Function2<? super Integer, ? super Integer, Unit> onScrollPositionListener;
    private RecyclerView recyclerView;
    private StickyHeaderManager stickyHeaderManager;
    private Subscription subscription;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.adapter.ChatInputAutocompleteAdapter$onCreateViewHolder$1, reason: invalid class name */
    /* JADX INFO: compiled from: ChatInputAutocompleteAdapter.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Autocompletable, Unit> {
        public AnonymousClass1(ChatInputAutocompleteAdapter chatInputAutocompleteAdapter) {
            super(1, chatInputAutocompleteAdapter, ChatInputAutocompleteAdapter.class, "onAutocompletableSelected", "onAutocompletableSelected(Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Autocompletable autocompletable) {
            invoke2(autocompletable);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Autocompletable autocompletable) {
            Intrinsics3.checkNotNullParameter(autocompletable, "p1");
            ((ChatInputAutocompleteAdapter) this.receiver).onAutocompletableSelected(autocompletable);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.adapter.ChatInputAutocompleteAdapter$onCreateViewHolder$2, reason: invalid class name */
    /* JADX INFO: compiled from: ChatInputAutocompleteAdapter.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Autocompletable, Unit> {
        public AnonymousClass2(ChatInputAutocompleteAdapter chatInputAutocompleteAdapter) {
            super(1, chatInputAutocompleteAdapter, ChatInputAutocompleteAdapter.class, "onAutocompletableSelected", "onAutocompletableSelected(Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Autocompletable autocompletable) {
            invoke2(autocompletable);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Autocompletable autocompletable) {
            Intrinsics3.checkNotNullParameter(autocompletable, "p1");
            ((ChatInputAutocompleteAdapter) this.receiver).onAutocompletableSelected(autocompletable);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.adapter.ChatInputAutocompleteAdapter$setupScrollObservables$2, reason: invalid class name */
    /* JADX INFO: compiled from: ChatInputAutocompleteAdapter.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Object, Unit> {
        public final /* synthetic */ RecyclerView $recyclerView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(RecyclerView recyclerView) {
            super(1);
            this.$recyclerView = recyclerView;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Object obj) {
            Function2 function2 = ChatInputAutocompleteAdapter.this.onScrollPositionListener;
            if (function2 == null || !(this.$recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
                return;
            }
            RecyclerView.LayoutManager layoutManager = this.$recyclerView.getLayoutManager();
            Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            function2.invoke(Integer.valueOf(linearLayoutManager.findFirstVisibleItemPosition()), Integer.valueOf(linearLayoutManager.findLastVisibleItemPosition()));
        }
    }

    public ChatInputAutocompleteAdapter() {
        setHasStableIds(true);
    }

    private final List<Integer> calculateCommandHeaderPositions(List<? extends Autocompletable> data) {
        ArrayList arrayList = new ArrayList();
        int size = data.size();
        for (int i = 0; i < size; i++) {
            if (data.get(i) instanceof ApplicationPlaceholder) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        return arrayList;
    }

    private final int getDataHeightOrMax(List<? extends Autocompletable> data, int maxAllowedHeight) {
        int i = 0;
        for (Autocompletable autocompletable : data) {
            i += autocompletable instanceof ApplicationPlaceholder ? 32 : autocompletable instanceof EmojiUpsellPlaceholder ? 52 : 44;
            if (i >= maxAllowedHeight) {
                return maxAllowedHeight;
            }
        }
        return i;
    }

    private final void resizeRecyclerToData(List<? extends Autocompletable> data, boolean hasStickers, boolean sizeToMax) {
        ViewGroup.LayoutParams layoutParams;
        int dataHeightOrMax = hasStickers ? 132 : 176;
        if (!sizeToMax) {
            dataHeightOrMax = getDataHeightOrMax(data, dataHeightOrMax);
        }
        int iDpToPixels = DimenUtils.dpToPixels(dataHeightOrMax);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null && (layoutParams = recyclerView.getLayoutParams()) != null) {
            layoutParams.height = iDpToPixels;
        }
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 != null) {
            recyclerView2.requestLayout();
        }
    }

    public static /* synthetic */ void scrollToPosition$default(ChatInputAutocompleteAdapter chatInputAutocompleteAdapter, int i, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        chatInputAutocompleteAdapter.scrollToPosition(i, i2, z2);
    }

    public static /* synthetic */ void setData$default(ChatInputAutocompleteAdapter chatInputAutocompleteAdapter, List list, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        chatInputAutocompleteAdapter.setData(list, z2, z3);
    }

    private final void setupScrollObservables(RecyclerView recyclerView, AppComponent appComponent) {
        Observable observableO = Observable.o(new Action1<Emitter<Object>>() { // from class: com.discord.widgets.chat.input.autocomplete.adapter.ChatInputAutocompleteAdapter.setupScrollObservables.1
            @Override // rx.functions.Action1
            public final void call(final Emitter<Object> emitter) {
                Intrinsics3.checkNotNullParameter(emitter, "emitter");
                ChatInputAutocompleteAdapter.this.onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.discord.widgets.chat.input.autocomplete.adapter.ChatInputAutocompleteAdapter.setupScrollObservables.1.1
                    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                    public void onScrolled(RecyclerView recyclerView2, int dx, int dy) {
                        Intrinsics3.checkNotNullParameter(recyclerView2, "recyclerView");
                        super.onScrolled(recyclerView2, dx, dy);
                        emitter.onNext(0);
                    }
                };
            }
        }, Emitter.BackpressureMode.LATEST);
        Intrinsics3.checkNotNullExpressionValue(observableO, "Observable\n        .crea….BackpressureMode.LATEST)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableO, appComponent, null, 2, null), (Class<?>) ChatInputAutocompleteAdapter.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(recyclerView));
        RecyclerView.OnScrollListener onScrollListener = this.onScrollListener;
        if (onScrollListener != null) {
            recyclerView.addOnScrollListener(onScrollListener);
        }
    }

    private final void setupStickyApplicationHeaders(final RecyclerView recyclerView) {
        this.stickyHeaderManager = new StickyHeaderManager(recyclerView, this);
        recyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.discord.widgets.chat.input.autocomplete.adapter.ChatInputAutocompleteAdapter.setupStickyApplicationHeaders.1
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                StickyHeaderManager stickyHeaderManager = ChatInputAutocompleteAdapter.this.stickyHeaderManager;
                if (stickyHeaderManager != null) {
                    stickyHeaderManager.layoutViews(recyclerView);
                }
            }
        });
        StickyHeaderItemDecoration stickyHeaderItemDecoration = new StickyHeaderItemDecoration(this);
        recyclerView.addItemDecoration(stickyHeaderItemDecoration);
        stickyHeaderItemDecoration.blockClicks(recyclerView);
    }

    public final void configureSubscriptions(AppComponent appComponent) {
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            setupScrollObservables(recyclerView, appComponent);
        }
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration.StickyHeaderAdapter
    public View getAndBindHeaderView(int position) {
        StickyHeaderManager2 stickyHeaderHolder;
        StickyHeaderManager2 stickyHeaderHolder2;
        Autocompletable autocompletable = this.data.get(position);
        if (!(autocompletable instanceof ApplicationPlaceholder)) {
            return null;
        }
        StickyHeaderManager stickyHeaderManager = this.stickyHeaderManager;
        if (stickyHeaderManager != null && (stickyHeaderHolder2 = stickyHeaderManager.getStickyHeaderHolder()) != null) {
            stickyHeaderHolder2.bind((ApplicationPlaceholder) autocompletable);
        }
        StickyHeaderManager stickyHeaderManager2 = this.stickyHeaderManager;
        if (stickyHeaderManager2 == null || (stickyHeaderHolder = stickyHeaderManager2.getStickyHeaderHolder()) == null) {
            return null;
        }
        return stickyHeaderHolder.getItemView();
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration.StickyHeaderAdapter
    public Integer getHeaderPositionForItem(int itemPosition) {
        int iIntValue;
        int size = this.headerPositions.size();
        do {
            size--;
            if (size < 0) {
                return null;
            }
            iIntValue = this.headerPositions.get(size).intValue();
        } while (iIntValue > itemPosition);
        return Integer.valueOf(iIntValue);
    }

    public final Autocompletable getItem(int position) {
        return this.data.get(position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        Autocompletable item = getItem(position);
        if (item instanceof ApplicationCommandAutocompletable) {
            position = ((ApplicationCommandAutocompletable) item).getCommand().hashCode();
        } else if (item instanceof ApplicationCommandChoiceAutocompletable) {
            position = ((ApplicationCommandChoiceAutocompletable) item).getChoice().getValue().hashCode();
        } else if (item instanceof ApplicationCommandLoadingPlaceholder) {
            Application application = ((ApplicationCommandLoadingPlaceholder) item).getApplication();
            if (application != null) {
                return application.getId();
            }
        } else {
            if (item instanceof ApplicationPlaceholder) {
                return ((ApplicationPlaceholder) item).getApplication().getId();
            }
            if (item instanceof ChannelAutocompletable) {
                return ((ChannelAutocompletable) item).getChannel().getId();
            }
            if (item instanceof EmojiAutocompletable) {
                position = ((EmojiAutocompletable) item).getEmoji().getUniqueId().hashCode();
            } else if (item instanceof EmojiUpsellPlaceholder) {
                position = ((EmojiUpsellPlaceholder) item).getLockedFirstThree().hashCode();
            } else {
                if (!(item instanceof GlobalRoleAutocompletable)) {
                    if (item instanceof RoleAutocompletable) {
                        return ((RoleAutocompletable) item).getRole().getId();
                    }
                    if (item instanceof UserAutocompletable) {
                        return ((UserAutocompletable) item).getUser().getId();
                    }
                    throw new NoWhenBranchMatchedException();
                }
                position = ((GlobalRoleAutocompletable) item).getText().hashCode();
            }
        }
        return position;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        Autocompletable autocompletable = this.data.get(position);
        if (autocompletable instanceof ApplicationCommandLoadingPlaceholder) {
            return 2;
        }
        if (autocompletable instanceof ApplicationPlaceholder) {
            return 1;
        }
        return autocompletable instanceof EmojiUpsellPlaceholder ? 3 : 0;
    }

    public final Function1<Autocompletable, Unit> getOnItemSelected() {
        return this.onItemSelected;
    }

    public final Subscription getSubscription() {
        return this.subscription;
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration.StickyHeaderAdapter
    public boolean isHeader(int position) {
        return this.headerPositions.contains(Integer.valueOf(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
        setupStickyApplicationHeaders(recyclerView);
    }

    public final void onAutocompletableSelected(Autocompletable autocompletable) {
        Intrinsics3.checkNotNullParameter(autocompletable, "autocompletable");
        Function1<? super Autocompletable, Unit> function1 = this.onItemSelected;
        if (function1 != null) {
            function1.invoke(autocompletable);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        int itemViewType = getItemViewType(position);
        if (itemViewType == 0) {
            ((AutocompleteItemViewHolder) holder).bind(this.data.get(position));
            return;
        }
        if (itemViewType == 1) {
            Autocompletable autocompletable = this.data.get(position);
            Objects.requireNonNull(autocompletable, "null cannot be cast to non-null type com.discord.widgets.chat.input.autocomplete.ApplicationPlaceholder");
            ((CommandHeaderViewHolder) holder).bind((ApplicationPlaceholder) autocompletable);
        } else if (itemViewType != 2) {
            if (itemViewType != 3) {
                throw new IllegalStateException("Cannot bind. Unknown View Type");
            }
            Autocompletable autocompletable2 = this.data.get(position);
            Objects.requireNonNull(autocompletable2, "null cannot be cast to non-null type com.discord.widgets.chat.input.autocomplete.EmojiUpsellPlaceholder");
            ((EmojiAutocompleteUpsellViewHolder) holder).bind((EmojiUpsellPlaceholder) autocompletable2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        if (viewType == 0) {
            View viewInflate = layoutInflaterFrom.inflate(R.layout.widget_chat_input_autocomplete_item, parent, false);
            int i = R.id.chat_input_icon_barrier;
            Barrier barrier = (Barrier) viewInflate.findViewById(R.id.chat_input_icon_barrier);
            if (barrier != null) {
                i = R.id.chat_input_item_avatar;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R.id.chat_input_item_avatar);
                if (simpleDraweeView != null) {
                    i = R.id.chat_input_item_description;
                    TextView textView = (TextView) viewInflate.findViewById(R.id.chat_input_item_description);
                    if (textView != null) {
                        i = R.id.chat_input_item_divider;
                        View viewFindViewById = viewInflate.findViewById(R.id.chat_input_item_divider);
                        if (viewFindViewById != null) {
                            i = R.id.chat_input_item_emoji;
                            SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) viewInflate.findViewById(R.id.chat_input_item_emoji);
                            if (simpleDraweeSpanTextView != null) {
                                i = R.id.chat_input_item_name;
                                TextView textView2 = (TextView) viewInflate.findViewById(R.id.chat_input_item_name);
                                if (textView2 != null) {
                                    i = R.id.chat_input_item_name_right;
                                    TextView textView3 = (TextView) viewInflate.findViewById(R.id.chat_input_item_name_right);
                                    if (textView3 != null) {
                                        i = R.id.chat_input_item_status;
                                        StatusView statusView = (StatusView) viewInflate.findViewById(R.id.chat_input_item_status);
                                        if (statusView != null) {
                                            WidgetChatInputAutocompleteItemBinding widgetChatInputAutocompleteItemBinding = new WidgetChatInputAutocompleteItemBinding((ConstraintLayout) viewInflate, barrier, simpleDraweeView, textView, viewFindViewById, simpleDraweeSpanTextView, textView2, textView3, statusView);
                                            Intrinsics3.checkNotNullExpressionValue(widgetChatInputAutocompleteItemBinding, "WidgetChatInputAutocompl…tInflater, parent, false)");
                                            return new AutocompleteItemViewHolder(widgetChatInputAutocompleteItemBinding, new AnonymousClass1(this));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        if (viewType == 1) {
            WidgetChatInputCommandApplicationHeaderItemBinding widgetChatInputCommandApplicationHeaderItemBindingA = WidgetChatInputCommandApplicationHeaderItemBinding.a(layoutInflaterFrom, parent, false);
            Intrinsics3.checkNotNullExpressionValue(widgetChatInputCommandApplicationHeaderItemBindingA, "WidgetChatInputCommandAp…tInflater, parent, false)");
            return new CommandHeaderViewHolder(widgetChatInputCommandApplicationHeaderItemBindingA);
        }
        if (viewType != 2) {
            if (viewType != 3) {
                throw new IllegalStateException(outline.q("Cannot create view holder. Unknown View Type: ", viewType));
            }
            View viewInflate2 = layoutInflaterFrom.inflate(R.layout.widget_chat_input_emoji_autocomplete_upsell_item, parent, false);
            int i2 = R.id.chat_input_emoji_upsell_pile;
            PileView pileView = (PileView) viewInflate2.findViewById(R.id.chat_input_emoji_upsell_pile);
            if (pileView != null) {
                i2 = R.id.chat_input_emoji_upsell_text;
                TextView textView4 = (TextView) viewInflate2.findViewById(R.id.chat_input_emoji_upsell_text);
                if (textView4 != null) {
                    WidgetChatInputEmojiAutocompleteUpsellItemBinding widgetChatInputEmojiAutocompleteUpsellItemBinding = new WidgetChatInputEmojiAutocompleteUpsellItemBinding((LinearLayout) viewInflate2, pileView, textView4);
                    Intrinsics3.checkNotNullExpressionValue(widgetChatInputEmojiAutocompleteUpsellItemBinding, "WidgetChatInputEmojiAuto…tInflater, parent, false)");
                    return new EmojiAutocompleteUpsellViewHolder(widgetChatInputEmojiAutocompleteUpsellItemBinding, new AnonymousClass2(this));
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i2)));
        }
        View viewInflate3 = layoutInflaterFrom.inflate(R.layout.widget_chat_input_slash_loading_item, parent, false);
        int i3 = R.id.application_name_placeholder;
        View viewFindViewById2 = viewInflate3.findViewById(R.id.application_name_placeholder);
        if (viewFindViewById2 != null) {
            i3 = R.id.application_name_start_guideline;
            Guideline guideline = (Guideline) viewInflate3.findViewById(R.id.application_name_start_guideline);
            if (guideline != null) {
                i3 = R.id.description_placeholder;
                View viewFindViewById3 = viewInflate3.findViewById(R.id.description_placeholder);
                if (viewFindViewById3 != null) {
                    i3 = R.id.description_placeholder_end_guideline;
                    Guideline guideline2 = (Guideline) viewInflate3.findViewById(R.id.description_placeholder_end_guideline);
                    if (guideline2 != null) {
                        i3 = R.id.name_placeholder;
                        View viewFindViewById4 = viewInflate3.findViewById(R.id.name_placeholder);
                        if (viewFindViewById4 != null) {
                            i3 = R.id.name_placeholder_end_guideline;
                            Guideline guideline3 = (Guideline) viewInflate3.findViewById(R.id.name_placeholder_end_guideline);
                            if (guideline3 != null) {
                                WidgetChatInputSlashLoadingItemBinding widgetChatInputSlashLoadingItemBinding = new WidgetChatInputSlashLoadingItemBinding((ConstraintLayout) viewInflate3, viewFindViewById2, guideline, viewFindViewById3, guideline2, viewFindViewById4, guideline3);
                                Intrinsics3.checkNotNullExpressionValue(widgetChatInputSlashLoadingItemBinding, "WidgetChatInputSlashLoad…tInflater, parent, false)");
                                return new ApplicationCommandLoadingViewHolder(widgetChatInputSlashLoadingItemBinding);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate3.getResources().getResourceName(i3)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }

    public final void scrollToPosition(int position, int offset, boolean enableListeners) {
        RecyclerView.OnScrollListener onScrollListener;
        RecyclerView recyclerView;
        RecyclerView.OnScrollListener onScrollListener2;
        RecyclerView recyclerView2;
        if (!enableListeners && (onScrollListener2 = this.onScrollListener) != null && (recyclerView2 = this.recyclerView) != null) {
            recyclerView2.removeOnScrollListener(onScrollListener2);
        }
        RecyclerView recyclerView3 = this.recyclerView;
        RecyclerView.LayoutManager layoutManager = recyclerView3 != null ? recyclerView3.getLayoutManager() : null;
        if (layoutManager instanceof LinearLayoutManager) {
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(position, offset);
        }
        if (enableListeners || (onScrollListener = this.onScrollListener) == null || (recyclerView = this.recyclerView) == null) {
            return;
        }
        recyclerView.addOnScrollListener(onScrollListener);
    }

    public final void setData(List<? extends Autocompletable> autocompletables, boolean hasStickers, boolean sizeToMax) {
        Intrinsics3.checkNotNullParameter(autocompletables, "autocompletables");
        this.headerPositions = calculateCommandHeaderPositions(autocompletables);
        resizeRecyclerToData(autocompletables, hasStickers, sizeToMax);
        this.data = autocompletables;
        notifyDataSetChanged();
    }

    public final void setOnItemSelected(Function1<? super Autocompletable, Unit> function1) {
        this.onItemSelected = function1;
    }

    public final void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public final void setVisiblePositionListener(Function2<? super Integer, ? super Integer, Unit> onScrollVisibleDiscoveryCommands) {
        Intrinsics3.checkNotNullParameter(onScrollVisibleDiscoveryCommands, "onScrollVisibleDiscoveryCommands");
        this.onScrollPositionListener = onScrollVisibleDiscoveryCommands;
    }
}

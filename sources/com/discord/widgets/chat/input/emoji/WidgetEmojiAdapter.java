package com.discord.widgets.chat.input.emoji;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter;
import com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter$StickyHeaderViewHolder;
import d0.t.u;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetEmojiAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiAdapter extends WidgetExpressionPickerAdapter {
    public static final WidgetEmojiAdapter$Companion Companion = new WidgetEmojiAdapter$Companion(null);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEmojiAdapter(RecyclerView recyclerView, FragmentManager fragmentManager, OnEmojiSelectedListener onEmojiSelectedListener, Function0<Unit> function0, Function0<Unit> function1) {
        super(recyclerView, null, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(onEmojiSelectedListener, "onEmojiSelectedListener");
        m.checkNotNullParameter(function0, "onGetPremiumCtaClicked");
        m.checkNotNullParameter(function1, "hideKeyboard");
        this.fragmentManager = fragmentManager;
        this.onEmojiSelectedListener = onEmojiSelectedListener;
        this.onGetPremiumCtaClicked = function0;
        this.hideKeyboard = function1;
        Context context = recyclerView.getContext();
        m.checkNotNullExpressionValue(context, "recycler.context");
        this.emojiSizePx = context.getResources().getDimensionPixelSize(2131165319);
        Context context2 = recyclerView.getContext();
        m.checkNotNullExpressionValue(context2, "recycler.context");
        this.numColumns = WidgetExpressionPickerAdapter.Companion.calculateNumOfColumns(recyclerView, context2.getResources().getDimension(2131165319), 8);
        this.layoutManager = new GridLayoutManager(recyclerView.getContext(), getNumColumns());
        getLayoutManager().setSpanSizeLookup(new WidgetEmojiAdapter$1(this));
        recyclerView.setLayoutManager(getLayoutManager());
        recyclerView.setAdapter(this);
    }

    public static final /* synthetic */ int access$getEmojiSizePx$p(WidgetEmojiAdapter widgetEmojiAdapter) {
        return widgetEmojiAdapter.emojiSizePx;
    }

    public static final /* synthetic */ FragmentManager access$getFragmentManager$p(WidgetEmojiAdapter widgetEmojiAdapter) {
        return widgetEmojiAdapter.fragmentManager;
    }

    public static final /* synthetic */ Function0 access$getHideKeyboard$p(WidgetEmojiAdapter widgetEmojiAdapter) {
        return widgetEmojiAdapter.hideKeyboard;
    }

    public static final /* synthetic */ OnEmojiSelectedListener access$getOnEmojiSelectedListener$p(WidgetEmojiAdapter widgetEmojiAdapter) {
        return widgetEmojiAdapter.onEmojiSelectedListener;
    }

    public static final /* synthetic */ Function0 access$getOnGetPremiumCtaClicked$p(WidgetEmojiAdapter widgetEmojiAdapter) {
        return widgetEmojiAdapter.onGetPremiumCtaClicked;
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter
    public /* bridge */ /* synthetic */ WidgetExpressionPickerAdapter$StickyHeaderViewHolder createStickyHeaderViewHolder(WidgetExpressionPickerAdapter widgetExpressionPickerAdapter) {
        return createStickyHeaderViewHolder(widgetExpressionPickerAdapter);
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter
    public GridLayoutManager getLayoutManager() {
        return this.layoutManager;
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter
    public int getNumColumns() {
        return this.numColumns;
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration$StickyHeaderAdapter
    public boolean isHeader(int position) {
        return u.getOrNull(getInternalData(), position) instanceof WidgetEmojiAdapter$HeaderItem;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter
    public WidgetEmojiAdapter$HeaderViewHolder createStickyHeaderViewHolder(WidgetExpressionPickerAdapter adapter) {
        m.checkNotNullParameter(adapter, "adapter");
        return new WidgetEmojiAdapter$HeaderViewHolder((WidgetEmojiAdapter) adapter);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<WidgetEmojiAdapter, MGRecyclerDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new WidgetEmojiAdapter$HeaderViewHolder(this);
        }
        if (viewType == 1) {
            return new WidgetEmojiAdapter$EmojiViewHolder(this);
        }
        if (viewType == 2) {
            return new WidgetEmojiAdapter$PremiumEmojiUpsellViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}

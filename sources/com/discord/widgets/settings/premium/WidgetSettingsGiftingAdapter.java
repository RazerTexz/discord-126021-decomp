package com.discord.widgets.settings.premium;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.models.domain.ModelGift;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetSettingsGiftingAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGiftingAdapter extends MGRecyclerAdapterSimple<WidgetSettingsGiftingAdapter$GiftItem> {
    private Function1<? super String, Unit> onClickCopyListener;
    private Function2<? super Long, ? super Long, Unit> onClickSkuListener;
    private Function2<? super Long, ? super Long, Unit> onGenerateClickListener;
    private Function1<? super ModelGift, Unit> onRevokeClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGiftingAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        this.onClickSkuListener = WidgetSettingsGiftingAdapter$onClickSkuListener$1.INSTANCE;
        this.onClickCopyListener = WidgetSettingsGiftingAdapter$onClickCopyListener$1.INSTANCE;
        this.onRevokeClickListener = WidgetSettingsGiftingAdapter$onRevokeClickListener$1.INSTANCE;
        this.onGenerateClickListener = WidgetSettingsGiftingAdapter$onGenerateClickListener$1.INSTANCE;
    }

    public static final /* synthetic */ Function1 access$getOnClickCopyListener$p(WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter) {
        return widgetSettingsGiftingAdapter.onClickCopyListener;
    }

    public static final /* synthetic */ Function2 access$getOnClickSkuListener$p(WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter) {
        return widgetSettingsGiftingAdapter.onClickSkuListener;
    }

    public static final /* synthetic */ Function2 access$getOnGenerateClickListener$p(WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter) {
        return widgetSettingsGiftingAdapter.onGenerateClickListener;
    }

    public static final /* synthetic */ Function1 access$getOnRevokeClickListener$p(WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter) {
        return widgetSettingsGiftingAdapter.onRevokeClickListener;
    }

    public static final /* synthetic */ void access$setOnClickCopyListener$p(WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter, Function1 function1) {
        widgetSettingsGiftingAdapter.onClickCopyListener = function1;
    }

    public static final /* synthetic */ void access$setOnClickSkuListener$p(WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter, Function2 function2) {
        widgetSettingsGiftingAdapter.onClickSkuListener = function2;
    }

    public static final /* synthetic */ void access$setOnGenerateClickListener$p(WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter, Function2 function2) {
        widgetSettingsGiftingAdapter.onGenerateClickListener = function2;
    }

    public static final /* synthetic */ void access$setOnRevokeClickListener$p(WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter, Function1 function1) {
        widgetSettingsGiftingAdapter.onRevokeClickListener = function1;
    }

    public final void configure(List<WidgetSettingsGiftingAdapter$GiftItem> giftItems, Function2<? super Long, ? super Long, Unit> onClickSkuListener, Function1<? super String, Unit> onClickCopyListener, Function1<? super ModelGift, Unit> onRevokeClickListener, Function2<? super Long, ? super Long, Unit> onGenerateClickListener) {
        m.checkNotNullParameter(giftItems, "giftItems");
        m.checkNotNullParameter(onClickSkuListener, "onClickSkuListener");
        m.checkNotNullParameter(onClickCopyListener, "onClickCopyListener");
        m.checkNotNullParameter(onRevokeClickListener, "onRevokeClickListener");
        m.checkNotNullParameter(onGenerateClickListener, "onGenerateClickListener");
        setData(giftItems);
        this.onClickSkuListener = onClickSkuListener;
        this.onClickCopyListener = onClickCopyListener;
        this.onRevokeClickListener = onRevokeClickListener;
        this.onGenerateClickListener = onGenerateClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<WidgetSettingsGiftingAdapter, WidgetSettingsGiftingAdapter$GiftItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new WidgetSettingsGiftingAdapter$NoGiftsListItem(this);
        }
        if (viewType == 1) {
            return new WidgetSettingsGiftingAdapter$SkuListItem(this);
        }
        if (viewType == 2) {
            return new WidgetSettingsGiftingAdapter$EntitlementListItem(this);
        }
        throw invalidViewTypeException(viewType);
    }
}

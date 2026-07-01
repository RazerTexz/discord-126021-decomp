package com.discord.widgets.search.suggestions;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetSearchSuggestionsItemSuggestionBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.mg_recycler.SingleTypePayload;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.suggestion.entries.FilterSuggestion;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: WidgetSearchSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$FilterViewHolder extends MGRecyclerViewHolder<WidgetSearchSuggestionsAdapter, MGRecyclerDataPayload> {
    private final WidgetSearchSuggestionsItemSuggestionBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSearchSuggestionsAdapter$FilterViewHolder(WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter) {
        super(R$layout.widget_search_suggestions_item_suggestion, widgetSearchSuggestionsAdapter);
        m.checkNotNullParameter(widgetSearchSuggestionsAdapter, "searchSuggestionsAdapter");
        View view = this.itemView;
        int i = R$id.suggestion_example_answer;
        TextView textView = (TextView) view.findViewById(R$id.suggestion_example_answer);
        if (textView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            i = R$id.suggestion_example_filter;
            TextView textView2 = (TextView) view.findViewById(R$id.suggestion_example_filter);
            if (textView2 != null) {
                i = R$id.suggestion_example_icon;
                ImageView imageView = (ImageView) view.findViewById(R$id.suggestion_example_icon);
                if (imageView != null) {
                    WidgetSearchSuggestionsItemSuggestionBinding widgetSearchSuggestionsItemSuggestionBinding = new WidgetSearchSuggestionsItemSuggestionBinding(relativeLayout, textView, relativeLayout, textView2, imageView);
                    m.checkNotNullExpressionValue(widgetSearchSuggestionsItemSuggestionBinding, "WidgetSearchSuggestionsI…ionBinding.bind(itemView)");
                    this.binding = widgetSearchSuggestionsItemSuggestionBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetSearchSuggestionsAdapter access$getAdapter$p(WidgetSearchSuggestionsAdapter$FilterViewHolder widgetSearchSuggestionsAdapter$FilterViewHolder) {
        return (WidgetSearchSuggestionsAdapter) widgetSearchSuggestionsAdapter$FilterViewHolder.adapter;
    }

    @StringRes
    private final int getAnswerText(FilterType filterType) {
        int iOrdinal = filterType.ordinal();
        if (iOrdinal == 0) {
            return 2131895298;
        }
        if (iOrdinal == 1) {
            return 2131895309;
        }
        if (iOrdinal == 2) {
            return 2131895299;
        }
        if (iOrdinal == 3) {
            return 2131895307;
        }
        throw new NoWhenBranchMatchedException();
    }

    @StringRes
    private final int getFilterText(FilterType filterType) {
        int iOrdinal = filterType.ordinal();
        if (iOrdinal == 0) {
            return 2131895325;
        }
        if (iOrdinal == 1) {
            return 2131895329;
        }
        if (iOrdinal == 2) {
            return 2131895326;
        }
        if (iOrdinal == 3) {
            return 2131895327;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Drawable getIconDrawable(Context context, FilterType filterType) {
        int iOrdinal = filterType.ordinal();
        if (iOrdinal == 0) {
            return ContextCompat.getDrawable(context, 2131231912);
        }
        if (iOrdinal == 1) {
            return ContextCompat.getDrawable(context, 2131231914);
        }
        if (iOrdinal == 2) {
            return ContextCompat.getDrawable(context, 2131231534);
        }
        if (iOrdinal == 3) {
            return ContextCompat.getDrawable(context, 2131232186);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    @SuppressLint({"SetTextI18n"})
    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        FilterType filterType = ((FilterSuggestion) ((SingleTypePayload) data).getData()).getFilterType();
        int filterText = getFilterText(filterType);
        int answerText = getAnswerText(filterType);
        this.binding.c.setOnClickListener(new WidgetSearchSuggestionsAdapter$FilterViewHolder$onConfigure$1(this, filterType));
        ImageView imageView = this.binding.e;
        m.checkNotNullExpressionValue(imageView, "binding.suggestionExampleIcon");
        Context context = imageView.getContext();
        m.checkNotNullExpressionValue(context, "binding.suggestionExampleIcon.context");
        imageView.setImageDrawable(getIconDrawable(context, filterType));
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.suggestionExampleFilter");
        textView.setText(b.l("**" + b.h(a.x(this.itemView, "itemView", "itemView.context"), filterText, new Object[0], null, 4) + "**:", new Object[0], null, 2));
        TextView textView2 = this.binding.f2530b;
        m.checkNotNullExpressionValue(textView2, "binding.suggestionExampleAnswer");
        textView2.setText(b.h(a.x(this.itemView, "itemView", "itemView.context"), answerText, new Object[0], null, 4));
    }
}

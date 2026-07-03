package com.discord.utilities.search.query.node.filter;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import androidx.core.app.NotificationCompat;
import com.discord.C5419R;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.spans.TypefaceSpanCompat;
import com.discord.widgets.chat.input.MentionUtilsKt;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: FilterNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class FilterNode extends QueryNode {
    private final FilterType filterType;
    private final CharSequence text;

    public FilterNode(FilterType filterType, CharSequence charSequence) {
        C12238m.checkNotNullParameter(filterType, "filterType");
        C12238m.checkNotNullParameter(charSequence, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        this.filterType = filterType;
        this.text = charSequence;
    }

    public static /* synthetic */ FilterNode copy$default(FilterNode filterNode, FilterType filterType, CharSequence charSequence, int i, Object obj) {
        if ((i & 1) != 0) {
            filterType = filterNode.filterType;
        }
        if ((i & 2) != 0) {
            charSequence = filterNode.getText();
        }
        return filterNode.copy(filterType, charSequence);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final FilterType getFilterType() {
        return this.filterType;
    }

    public final CharSequence component2() {
        return getText();
    }

    public final FilterNode copy(FilterType filterType, CharSequence text) {
        C12238m.checkNotNullParameter(filterType, "filterType");
        C12238m.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        return new FilterNode(filterType, text);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FilterNode)) {
            return false;
        }
        FilterNode filterNode = (FilterNode) other;
        return C12238m.areEqual(this.filterType, filterNode.filterType) && C12238m.areEqual(getText(), filterNode.getText());
    }

    public final FilterType getFilterType() {
        return this.filterType;
    }

    @Override // com.discord.utilities.search.query.node.QueryNode
    public CharSequence getText() {
        return this.text;
    }

    public int hashCode() {
        FilterType filterType = this.filterType;
        int iHashCode = (filterType != null ? filterType.hashCode() : 0) * 31;
        CharSequence text = getText();
        return iHashCode + (text != null ? text.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("FilterNode(filterType=");
        sbM833U.append(this.filterType);
        sbM833U.append(", text=");
        sbM833U.append(getText());
        sbM833U.append(")");
        return sbM833U.toString();
    }

    @Override // com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder builder, Context renderContext) {
        C12238m.checkNotNullParameter(builder, "builder");
        C12238m.checkNotNullParameter(renderContext, "renderContext");
        Typeface themedFont = FontUtils.INSTANCE.getThemedFont(renderContext, C5419R.attr.font_primary_bold);
        TypefaceSpanCompat typefaceSpanCompat = themedFont != null ? new TypefaceSpanCompat(themedFont) : null;
        int length = builder.length();
        StringBuilder sb = new StringBuilder();
        sb.append(getText());
        sb.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        builder.append((CharSequence) sb.toString());
        builder.setSpan(typefaceSpanCompat, length, builder.length(), 33);
    }
}

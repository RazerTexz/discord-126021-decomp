package com.discord.utilities.search.query.node.filter;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.spans.TypefaceSpanCompat;
import com.discord.widgets.chat.input.MentionUtils;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: FilterNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class FilterNode extends QueryNode {
    private final FilterType filterType;
    private final CharSequence text;

    public FilterNode(FilterType filterType, CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(filterType, "filterType");
        Intrinsics3.checkNotNullParameter(charSequence, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
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
        Intrinsics3.checkNotNullParameter(filterType, "filterType");
        Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
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
        return Intrinsics3.areEqual(this.filterType, filterNode.filterType) && Intrinsics3.areEqual(getText(), filterNode.getText());
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
        StringBuilder sbU = outline.U("FilterNode(filterType=");
        sbU.append(this.filterType);
        sbU.append(", text=");
        sbU.append(getText());
        sbU.append(")");
        return sbU.toString();
    }

    @Override // com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder builder, Context renderContext) {
        Intrinsics3.checkNotNullParameter(builder, "builder");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
        Typeface themedFont = FontUtils.INSTANCE.getThemedFont(renderContext, R.attr.font_primary_bold);
        TypefaceSpanCompat typefaceSpanCompat = themedFont != null ? new TypefaceSpanCompat(themedFont) : null;
        int length = builder.length();
        StringBuilder sb = new StringBuilder();
        sb.append(getText());
        sb.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
        builder.append((CharSequence) sb.toString());
        builder.setSpan(typefaceSpanCompat, length, builder.length(), 33);
    }
}

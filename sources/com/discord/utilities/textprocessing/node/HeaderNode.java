package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import androidx.exifinterface.media.ExifInterface;
import com.discord.C5419R;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.spans.VerticalPaddingSpan;
import com.discord.utilities.textprocessing.node.BasicRenderContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: HeaderNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class HeaderNode<T extends BasicRenderContext> extends Node<T> {
    private final int numHeaderIndicators;

    public HeaderNode(int i) {
        super(null, 1, null);
        this.numHeaderIndicators = i;
    }

    @Override // com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder builder, T renderContext) {
        int i;
        int i2;
        TextAppearanceSpan textAppearanceSpan;
        C12238m.checkNotNullParameter(builder, "builder");
        C12238m.checkNotNullParameter(renderContext, "renderContext");
        Context context = renderContext.getContext();
        int length = builder.length();
        Collection<Node<T>> children = getChildren();
        if (children != null) {
            Iterator<T> it = children.iterator();
            while (it.hasNext()) {
                ((Node) it.next()).render(builder, renderContext);
            }
        }
        int i3 = this.numHeaderIndicators;
        if (i3 != 1) {
            i = i3 != 2 ? C5419R.dimen.markdown_messages_header_3_top_padding : C5419R.dimen.markdown_messages_header_2_top_padding;
        } else {
            i = C5419R.dimen.markdown_messages_header_1_top_padding;
        }
        if (i3 != 1) {
            i2 = i3 != 2 ? C5419R.dimen.markdown_messages_header_3_bottom_padding : C5419R.dimen.markdown_messages_header_2_bottom_padding;
        } else {
            i2 = C5419R.dimen.markdown_messages_header_1_bottom_padding;
        }
        if (i3 != 1) {
            textAppearanceSpan = i3 != 2 ? new TextAppearanceSpan(context, 2131952044) : new TextAppearanceSpan(context, 2131952043);
        } else {
            textAppearanceSpan = new TextAppearanceSpan(context, 2131952042);
        }
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(textAppearanceSpan);
        arrayList.add(new VerticalPaddingSpan(context.getResources().getDimensionPixelSize(i), context.getResources().getDimensionPixelSize(i2)));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            builder.setSpan(it2.next(), length, builder.length(), 33);
        }
    }
}

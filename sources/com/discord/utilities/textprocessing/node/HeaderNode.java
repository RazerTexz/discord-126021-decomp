package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import androidx.exifinterface.media.ExifInterface;
import com.discord.R;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.spans.VerticalPaddingSpan;
import com.discord.utilities.textprocessing.node.BasicRenderContext;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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
        Intrinsics3.checkNotNullParameter(builder, "builder");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
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
            i = i3 != 2 ? R.dimen.markdown_messages_header_3_top_padding : R.dimen.markdown_messages_header_2_top_padding;
        } else {
            i = R.dimen.markdown_messages_header_1_top_padding;
        }
        if (i3 != 1) {
            i2 = i3 != 2 ? R.dimen.markdown_messages_header_3_bottom_padding : R.dimen.markdown_messages_header_2_bottom_padding;
        } else {
            i2 = R.dimen.markdown_messages_header_1_bottom_padding;
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

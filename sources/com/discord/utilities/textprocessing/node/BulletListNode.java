package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.style.LeadingMarginSpan;
import androidx.exifinterface.media.ExifInterface;
import com.discord.R;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.spans.BulletSpan;
import com.discord.utilities.spans.VerticalPaddingSpan;
import com.discord.utilities.textprocessing.node.BasicRenderContext;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: BulletListNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BulletListNode<T extends BasicRenderContext> extends Node<T> {
    private static final int MARKDOWN_BULLET_RADIUS = 8;
    private final boolean includesNewline;
    private final int nestedLevel;

    public BulletListNode(int i, boolean z2) {
        super(null, 1, null);
        this.nestedLevel = i;
        this.includesNewline = z2;
    }

    @Override // com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder builder, T renderContext) {
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
        ArrayList arrayList = new ArrayList(3);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.markdown_bullet_gap);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.markdown_bullet_gap) * this.nestedLevel;
        int themedColor = ColorCompat.getThemedColor(context, R.attr.primary_400);
        int dimensionPixelSize3 = context.getResources().getDimensionPixelSize(R.dimen.markdown_bullet_vertical_padding);
        Paint.Style style = this.nestedLevel > 1 ? Paint.Style.STROKE : Paint.Style.FILL;
        arrayList.add(new VerticalPaddingSpan(dimensionPixelSize3, dimensionPixelSize3));
        arrayList.add(new LeadingMarginSpan.Standard(dimensionPixelSize2));
        arrayList.add(new BulletSpan(dimensionPixelSize, themedColor, 8, 0.0f, style, 8, null));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            builder.setSpan(it2.next(), length, builder.length(), 33);
        }
        if (this.includesNewline) {
            builder.append("\n");
        }
    }
}

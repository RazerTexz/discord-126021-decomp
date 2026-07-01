package com.discord.utilities.textprocessing.node;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import androidx.exifinterface.media.ExifInterface;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.spans.QuoteSpan;
import com.discord.utilities.textprocessing.node.BasicRenderContext;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: BlockQuoteNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BlockQuoteNode<T extends BasicRenderContext> extends Node<T> {
    public static final BlockQuoteNode$Companion Companion = new BlockQuoteNode$Companion(null);
    private static final int GAP_WIDTH;
    private static final int STRIPE_WIDTH;
    private static final int TOTAL_LEFT_MARGIN;

    static {
        int iDpToPixels = DimenUtils.dpToPixels(3);
        STRIPE_WIDTH = iDpToPixels;
        int iDpToPixels2 = DimenUtils.dpToPixels(8);
        GAP_WIDTH = iDpToPixels2;
        TOTAL_LEFT_MARGIN = iDpToPixels + iDpToPixels2;
    }

    public BlockQuoteNode() {
        super(null, 1, null);
    }

    public static final /* synthetic */ int access$getTOTAL_LEFT_MARGIN$cp() {
        return TOTAL_LEFT_MARGIN;
    }

    @Override // com.discord.simpleast.core.node.Node
    public /* bridge */ /* synthetic */ void render(SpannableStringBuilder spannableStringBuilder, Object obj) {
        render(spannableStringBuilder, (BasicRenderContext) obj);
    }

    public void render(SpannableStringBuilder builder, T renderContext) {
        m.checkNotNullParameter(builder, "builder");
        m.checkNotNullParameter(renderContext, "renderContext");
        builder.append('\n');
        int iDpToPixels = DimenUtils.dpToPixels(8);
        builder.setSpan(new AbsoluteSizeSpan(iDpToPixels), builder.length() - 1, builder.length(), 33);
        int length = builder.length();
        Collection<Node<T>> children = getChildren();
        if (children != null) {
            Iterator<T> it = children.iterator();
            while (it.hasNext()) {
                ((Node) it.next()).render(builder, renderContext);
            }
        }
        if (builder.length() == length) {
            builder.append(' ');
        }
        builder.setSpan(new QuoteSpan(ColorCompat.getThemedColor(renderContext.getContext(), 2130970272), STRIPE_WIDTH, GAP_WIDTH), length, builder.length(), 13107233);
        builder.append('\n');
        builder.setSpan(new AbsoluteSizeSpan(iDpToPixels), builder.length() - 1, builder.length(), 13107233);
    }
}

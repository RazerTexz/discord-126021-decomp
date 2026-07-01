package com.discord.utilities.textprocessing.node;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import androidx.exifinterface.media.ExifInterface;
import com.discord.R;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.spans.QuoteSpan;
import com.discord.utilities.textprocessing.node.BasicRenderContext;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BlockQuoteNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BlockQuoteNode<T extends BasicRenderContext> extends Node<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int GAP_WIDTH;
    private static final int STRIPE_WIDTH;
    private static final int TOTAL_LEFT_MARGIN;

    /* JADX INFO: compiled from: BlockQuoteNode.kt */
    public static final class Companion {
        private Companion() {
        }

        public final int getTOTAL_LEFT_MARGIN() {
            return BlockQuoteNode.TOTAL_LEFT_MARGIN;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

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

    @Override // com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder builder, T renderContext) {
        Intrinsics3.checkNotNullParameter(builder, "builder");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
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
        builder.setSpan(new QuoteSpan(ColorCompat.getThemedColor(renderContext.getContext(), R.attr.theme_chat_block_quote_divider), STRIPE_WIDTH, GAP_WIDTH), length, builder.length(), 13107233);
        builder.append('\n');
        builder.setSpan(new AbsoluteSizeSpan(iDpToPixels), builder.length() - 1, builder.length(), 13107233);
    }
}

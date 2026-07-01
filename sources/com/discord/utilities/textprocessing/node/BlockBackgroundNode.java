package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.LeadingMarginSpan;
import com.discord.R;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.spans.BlockBackgroundSpan;
import com.discord.utilities.spans.VerticalPaddingSpan;
import com.discord.utilities.textprocessing.node.BasicRenderContext;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import d0.z.d.Intrinsics3;
import java.util.Arrays;

/* JADX INFO: compiled from: BlockBackgroundNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BlockBackgroundNode<R extends BasicRenderContext> extends Node.a<R> implements Spoilerable {
    private final boolean inQuote;
    private boolean isRevealed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlockBackgroundNode(boolean z2, Node<R>... nodeArr) {
        super((Node[]) Arrays.copyOf(nodeArr, nodeArr.length));
        Intrinsics3.checkNotNullParameter(nodeArr, "children");
        this.inQuote = z2;
        this.isRevealed = true;
    }

    private final void ensureEndsWithNewline(SpannableStringBuilder builder) {
        if (builder.length() > 0) {
            char[] cArr = new char[6];
            builder.getChars(builder.length() - 1, builder.length(), cArr, 0);
            if (cArr[0] != '\n') {
                builder.append('\n');
            }
        }
    }

    @Override // com.discord.utilities.textprocessing.node.Spoilerable
    /* JADX INFO: renamed from: isRevealed, reason: from getter */
    public boolean getIsRevealed() {
        return this.isRevealed;
    }

    @Override // com.discord.utilities.textprocessing.node.Spoilerable
    public void setRevealed(boolean z2) {
        this.isRevealed = z2;
    }

    @Override // com.discord.simpleast.core.node.Node.a, com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder builder, R renderContext) {
        int spoilerColorRes;
        Intrinsics3.checkNotNullParameter(builder, "builder");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
        ensureEndsWithNewline(builder);
        int length = builder.length();
        super.render(builder, renderContext);
        ensureEndsWithNewline(builder);
        Context context = renderContext.getContext();
        if (getIsRevealed()) {
            spoilerColorRes = ColorCompat.getThemedColor(context, R.attr.theme_chat_code);
        } else {
            if (!(renderContext instanceof SpoilerNode.RenderContext)) {
                renderContext = null;
            }
            SpoilerNode.RenderContext renderContext2 = (SpoilerNode.RenderContext) renderContext;
            spoilerColorRes = renderContext2 != null ? renderContext2.getSpoilerColorRes() : ColorCompat.getThemedColor(context, R.attr.theme_chat_spoiler_bg);
        }
        builder.setSpan(new BlockBackgroundSpan(spoilerColorRes, ColorCompat.getThemedColor(context, R.attr.theme_chat_codeblock_border), DimenUtils.dpToPixels(1), DimenUtils.dpToPixels(4), this.inQuote ? BlockQuoteNode.INSTANCE.getTOTAL_LEFT_MARGIN() : 0), length, builder.length(), 33);
        builder.setSpan(new LeadingMarginSpan.Standard(15), length, builder.length(), 33);
        int iDpToPixels = DimenUtils.dpToPixels(5);
        builder.setSpan(new VerticalPaddingSpan(iDpToPixels, iDpToPixels), length, builder.length(), 33);
    }
}

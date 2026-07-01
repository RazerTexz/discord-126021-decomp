package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.text.SpannableStringBuilder;
import androidx.exifinterface.media.ExifInterface;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.textprocessing.node.SpoilerNode.RenderContext;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import defpackage.SpoilerSpan;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SpoilerNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpoilerNode<T extends RenderContext> extends Node<T> implements Spoilerable {
    private final String content;
    private int id;
    private boolean isRevealed;

    /* JADX INFO: compiled from: SpoilerNode.kt */
    public interface RenderContext extends BasicRenderContext {
        int getSpoilerColorRes();

        Function1<SpoilerNode<?>, Unit> getSpoilerOnClick();

        int getSpoilerRevealedColorRes();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpoilerNode(String str) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(str, "content");
        this.content = str;
        this.id = -1;
    }

    private final List<Object> createStyles(T renderContext) {
        Context context = renderContext.getContext();
        SpoilerSpan spoilerSpan = new SpoilerSpan(renderContext.getSpoilerColorRes(), renderContext.getSpoilerRevealedColorRes(), getIsRevealed());
        if (getIsRevealed()) {
            return CollectionsJVM.listOf(spoilerSpan);
        }
        Object[] objArr = new Object[2];
        objArr[0] = spoilerSpan;
        Function1<SpoilerNode<?>, Unit> spoilerOnClick = renderContext.getSpoilerOnClick();
        objArr[1] = spoilerOnClick != null ? new ClickableSpan(Integer.valueOf(ColorCompat.getColor(context, R.color.transparent)), false, null, new SpoilerNode2(spoilerOnClick, this, context), 4, null) : null;
        return Collections2.listOfNotNull(objArr);
    }

    public final String getContent() {
        return this.content;
    }

    public final int getId() {
        return this.id;
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

    public final void updateState(int id2, boolean isRevealed) {
        this.id = id2;
        setRevealed(isRevealed);
    }

    @Override // com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder builder, T renderContext) {
        Intrinsics3.checkNotNullParameter(builder, "builder");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
        int length = builder.length();
        Collection<Node<T>> children = getChildren();
        if (children != null) {
            Iterator<T> it = children.iterator();
            while (it.hasNext()) {
                ((Node) it.next()).render(builder, renderContext);
            }
        }
        if (!getIsRevealed()) {
            Object[] spans = builder.getSpans(length, builder.length(), ClickableSpan.class);
            Intrinsics3.checkNotNullExpressionValue(spans, "builder.getSpans(startIn…lickableSpan::class.java)");
            for (Object obj : spans) {
                builder.removeSpan((ClickableSpan) obj);
            }
        }
        Iterator<T> it2 = createStyles(renderContext).iterator();
        while (it2.hasNext()) {
            builder.setSpan(it2.next(), length, builder.length(), 33);
        }
    }
}

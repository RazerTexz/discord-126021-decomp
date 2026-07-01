package com.discord.simpleast.core.node;

import android.text.SpannableStringBuilder;
import androidx.exifinterface.media.ExifInterface;
import b.a.t.b.a.TextNode;
import com.discord.simpleast.core.node.Node;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StyleNode.kt */
/* JADX INFO: loaded from: classes.dex */
public class StyleNode<RC, T> extends Node.a<RC> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<T> styles;

    /* JADX INFO: compiled from: StyleNode.kt */
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: compiled from: StyleNode.kt */
    public interface a<RC> {
        Iterable<?> get(RC rc);
    }

    /* JADX INFO: compiled from: StyleNode.kt */
    public static final class b<RC> extends TextNode<RC> {
        public final a<RC> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, a<RC> aVar) {
            super(str);
            Intrinsics3.checkNotNullParameter(str, "content");
            Intrinsics3.checkNotNullParameter(aVar, "stylesProvider");
            this.a = aVar;
        }

        @Override // b.a.t.b.a.TextNode, com.discord.simpleast.core.node.Node
        public void render(SpannableStringBuilder spannableStringBuilder, RC rc) {
            Intrinsics3.checkNotNullParameter(spannableStringBuilder, "builder");
            int length = spannableStringBuilder.length();
            super.render(spannableStringBuilder, rc);
            Iterator<?> it = this.a.get(rc).iterator();
            while (it.hasNext()) {
                spannableStringBuilder.setSpan(it.next(), length, spannableStringBuilder.length(), 33);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StyleNode(List<? extends T> list) {
        super(new Node[0]);
        Intrinsics3.checkNotNullParameter(list, "styles");
        this.styles = list;
    }

    public static final <RC, T> StyleNode<RC, T> wrapText(String str, List<? extends T> list) {
        Objects.requireNonNull(INSTANCE);
        Intrinsics3.checkNotNullParameter(str, "content");
        Intrinsics3.checkNotNullParameter(list, "styles");
        StyleNode<RC, T> styleNode = new StyleNode<>(list);
        styleNode.addChild(new TextNode(str));
        return styleNode;
    }

    public final List<T> getStyles() {
        return this.styles;
    }

    @Override // com.discord.simpleast.core.node.Node.a, com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder builder, RC renderContext) {
        Intrinsics3.checkNotNullParameter(builder, "builder");
        int length = builder.length();
        super.render(builder, renderContext);
        Iterator<T> it = this.styles.iterator();
        while (it.hasNext()) {
            builder.setSpan(it.next(), length, builder.length(), 33);
        }
    }
}

package com.discord.utilities.search.query.node.content;

import android.content.Context;
import android.text.SpannableStringBuilder;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.utilities.search.query.node.QueryNode;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ContentNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ContentNode extends QueryNode {
    private final CharSequence content;

    public ContentNode(CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(charSequence, "content");
        this.content = charSequence;
    }

    public static /* synthetic */ ContentNode copy$default(ContentNode contentNode, CharSequence charSequence, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = contentNode.content;
        }
        return contentNode.copy(charSequence);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CharSequence getContent() {
        return this.content;
    }

    public final ContentNode copy(CharSequence content) {
        Intrinsics3.checkNotNullParameter(content, "content");
        return new ContentNode(content);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ContentNode) && Intrinsics3.areEqual(this.content, ((ContentNode) other).content);
        }
        return true;
    }

    public final CharSequence getContent() {
        return this.content;
    }

    public int hashCode() {
        CharSequence charSequence = this.content;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.E(outline.U("ContentNode(content="), this.content, ")");
    }

    public ContentNode(ContentNode contentNode, ContentNode contentNode2) {
        Intrinsics3.checkNotNullParameter(contentNode, "node1");
        Intrinsics3.checkNotNullParameter(contentNode2, "node2");
        StringBuilder sb = new StringBuilder();
        sb.append(contentNode.content);
        sb.append(' ');
        sb.append(contentNode2.content);
        this(sb.toString());
    }

    @Override // com.discord.utilities.search.query.node.QueryNode
    public String getText() {
        return this.content.toString();
    }

    @Override // com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder builder, Context renderContext) {
        Intrinsics3.checkNotNullParameter(builder, "builder");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
        builder.append(this.content).append(' ');
    }
}

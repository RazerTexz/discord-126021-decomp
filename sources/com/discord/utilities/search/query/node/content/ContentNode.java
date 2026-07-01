package com.discord.utilities.search.query.node.content;

import android.content.Context;
import android.text.SpannableStringBuilder;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.d.b.a.a;
import com.discord.utilities.search.query.node.QueryNode;
import d0.z.d.m;

/* JADX INFO: compiled from: ContentNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ContentNode extends QueryNode {
    private final CharSequence content;

    public ContentNode(CharSequence charSequence) {
        m.checkNotNullParameter(charSequence, "content");
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
        m.checkNotNullParameter(content, "content");
        return new ContentNode(content);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ContentNode) && m.areEqual(this.content, ((ContentNode) other).content);
        }
        return true;
    }

    public final CharSequence getContent() {
        return this.content;
    }

    @Override // com.discord.utilities.search.query.node.QueryNode
    public /* bridge */ /* synthetic */ CharSequence getText() {
        return getText();
    }

    public int hashCode() {
        CharSequence charSequence = this.content;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    @Override // com.discord.simpleast.core.node.Node
    public /* bridge */ /* synthetic */ void render(SpannableStringBuilder spannableStringBuilder, Context context) {
        render2(spannableStringBuilder, context);
    }

    public String toString() {
        return a.E(a.U("ContentNode(content="), this.content, ")");
    }

    public ContentNode(ContentNode contentNode, ContentNode contentNode2) {
        m.checkNotNullParameter(contentNode, "node1");
        m.checkNotNullParameter(contentNode2, "node2");
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

    /* JADX INFO: renamed from: render, reason: avoid collision after fix types in other method */
    public void render2(SpannableStringBuilder builder, Context renderContext) {
        m.checkNotNullParameter(builder, "builder");
        m.checkNotNullParameter(renderContext, "renderContext");
        builder.append(this.content).append(' ');
    }
}

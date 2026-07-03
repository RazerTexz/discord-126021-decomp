package com.discord.utilities.search.query.node.content;

import android.content.Context;
import android.text.SpannableStringBuilder;
import androidx.core.app.NotificationCompat;
import com.discord.utilities.search.query.node.QueryNode;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ContentNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ContentNode extends QueryNode {
    private final CharSequence content;

    public ContentNode(CharSequence charSequence) {
        C12238m.checkNotNullParameter(charSequence, "content");
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
        C12238m.checkNotNullParameter(content, "content");
        return new ContentNode(content);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ContentNode) && C12238m.areEqual(this.content, ((ContentNode) other).content);
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
        return C1643a.m817E(C1643a.m833U("ContentNode(content="), this.content, ")");
    }

    public ContentNode(ContentNode contentNode, ContentNode contentNode2) {
        C12238m.checkNotNullParameter(contentNode, "node1");
        C12238m.checkNotNullParameter(contentNode2, "node2");
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
        C12238m.checkNotNullParameter(builder, "builder");
        C12238m.checkNotNullParameter(renderContext, "renderContext");
        builder.append(this.content).append(' ');
    }
}

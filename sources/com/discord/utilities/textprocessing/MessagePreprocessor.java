package com.discord.utilities.textprocessing;

import b.a.t.b.c.a;
import b.c.a.a0.d;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.simpleast.code.CodeNode;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.stores.StoreMessageState$State;
import com.discord.utilities.embed.EmbedResourceUtils;
import com.discord.utilities.textprocessing.node.BasicRenderContext;
import com.discord.utilities.textprocessing.node.BlockQuoteNode;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.utilities.textprocessing.node.UrlNode;
import d0.g0.t;
import d0.t.u;
import d0.z.d.e0;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MessagePreprocessor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessagePreprocessor implements a {
    public static final MessagePreprocessor$Companion Companion = new MessagePreprocessor$Companion(null);
    private static final int MAX_JUMBO_EMOJI_COUNT = 27;
    private int customEmojiCount;
    private final List<MessageEmbed> embeds;
    private boolean hasLinkConflictingNode;
    private final Integer maxNodes;
    private final long myUserId;
    private boolean shouldJumboify;
    private List<SpoilerNode<?>> spoilers;
    private final Collection<Integer> visibleSpoilerNodeIndices;

    public MessagePreprocessor(long j, Collection<Integer> collection, List<MessageEmbed> list, boolean z2, Integer num) {
        this.myUserId = j;
        this.visibleSpoilerNodeIndices = collection;
        this.embeds = list;
        this.shouldJumboify = z2;
        this.maxNodes = num;
    }

    public static final /* synthetic */ void access$mergeConsecutiveQuoteNodes(MessagePreprocessor messagePreprocessor, Collection collection) {
        messagePreprocessor.mergeConsecutiveQuoteNodes(collection);
    }

    private final <R extends BasicRenderContext> void constrainAST(Collection<? extends Node<R>> nodes) {
        if (this.maxNodes != null) {
            Objects.requireNonNull(nodes, "null cannot be cast to non-null type kotlin.collections.MutableCollection<com.discord.simpleast.core.node.Node<R>>");
            constrainAST(e0.asMutableCollection(nodes), new MessagePreprocessor$ConstrainState(this.maxNodes.intValue()));
        }
    }

    private final <R extends BasicRenderContext> void mergeConsecutiveQuoteNodes(Collection<Node<R>> nodes) {
        ArrayList arrayList = new ArrayList();
        Iterator<Node<R>> it = nodes.iterator();
        while (true) {
            BlockQuoteNode blockQuoteNode = null;
            while (true) {
                if (!it.hasNext()) {
                    nodes.removeAll(arrayList);
                    return;
                }
                Node<R> next = it.next();
                if (!(next instanceof BlockQuoteNode)) {
                    break;
                }
                if (blockQuoteNode == null) {
                    blockQuoteNode = (BlockQuoteNode) next;
                } else {
                    arrayList.add(next);
                    Collection<Node<R>> children = next.getChildren();
                    if (children != null) {
                        Iterator<Node<R>> it2 = children.iterator();
                        while (it2.hasNext()) {
                            blockQuoteNode.addChild(it2.next());
                        }
                    }
                }
            }
        }
    }

    private final <R extends BasicRenderContext> void processQuoteChildren(Collection<? extends Node<R>> ast) {
        Objects.requireNonNull(ast, "null cannot be cast to non-null type kotlin.collections.MutableCollection<com.discord.simpleast.core.node.Node<R>>");
        mergeConsecutiveQuoteNodes(e0.asMutableCollection(ast));
        MessagePreprocessor$processQuoteChildren$1 messagePreprocessor$processQuoteChildren$1 = new MessagePreprocessor$processQuoteChildren$1(this);
        Iterator<? extends Node<R>> it = ast.iterator();
        while (it.hasNext()) {
            d.k2(it.next(), messagePreprocessor$processQuoteChildren$1);
        }
    }

    private final void processSpoilerChildren() {
        List<SpoilerNode<?>> list = this.spoilers;
        if (!(!(list == null || list.isEmpty()))) {
            list = null;
        }
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (!((SpoilerNode) obj).getIsRevealed()) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                d.i2(((SpoilerNode) it.next()).getChildren(), MessagePreprocessor$processSpoilerChildren$3$1.INSTANCE);
            }
        }
    }

    private final void stripSimpleEmbedLink(Collection<Node<MessageRenderContext>> nodes) {
        List<MessageEmbed> list;
        if (nodes.size() == 1 && (list = this.embeds) != null && list.size() == 1) {
            Node node = (Node) u.elementAt(nodes, 0);
            MessageEmbed messageEmbed = this.embeds.get(0);
            if ((node instanceof UrlNode) && EmbedResourceUtils.INSTANCE.isSimpleEmbed(messageEmbed)) {
                nodes.clear();
            }
        }
    }

    public final long getMyUserId() {
        return this.myUserId;
    }

    public final List<SpoilerNode<?>> getSpoilers() {
        return this.spoilers;
    }

    public final boolean isLinkifyConflicting() {
        if (!this.hasLinkConflictingNode) {
            List<SpoilerNode<?>> list = this.spoilers;
            if (list == null || list.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final <R extends BasicRenderContext> void process(Collection<? extends Node<R>> ast) {
        m.checkNotNullParameter(ast, "ast");
        stripSimpleEmbedLink(e0.asMutableCollection(ast));
        d.i2(ast, this);
        if (this.shouldJumboify) {
            d.i2(ast, MessagePreprocessor$process$1.INSTANCE);
        }
        processSpoilerChildren();
        processQuoteChildren(ast);
        constrainAST(ast);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001f  */
    /* JADX WARN: Code duplicated, block: B:18:0x0034  */
    /* JADX WARN: Code duplicated, block: B:9:0x0019  */
    @Override // b.a.t.b.c.a
    public void processNode(Node<?> node) {
        boolean z2;
        boolean zIsBlank;
        m.checkNotNullParameter(node, "node");
        if (this.shouldJumboify) {
            if (node instanceof EmojiNode) {
                int i = this.customEmojiCount + 1;
                this.customEmojiCount = i;
                if (i <= 27) {
                    zIsBlank = true;
                } else {
                    zIsBlank = false;
                }
            } else if (node instanceof StyleNode) {
                zIsBlank = true;
            } else if (node instanceof b.a.t.b.a.a) {
                zIsBlank = t.isBlank(((b.a.t.b.a.a) node).getContent());
            } else {
                zIsBlank = false;
            }
            if (zIsBlank) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        this.shouldJumboify = z2;
        if (node instanceof CodeNode) {
            this.hasLinkConflictingNode = true;
            return;
        }
        if (node instanceof UrlNode) {
            this.hasLinkConflictingNode = true;
            return;
        }
        if (node instanceof SpoilerNode) {
            List arrayList = this.spoilers;
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.spoilers = arrayList;
            }
            int size = arrayList.size();
            arrayList.add(node);
            Collection<Integer> collection = this.visibleSpoilerNodeIndices;
            ((SpoilerNode) node).updateState(size, collection != null ? collection.contains(Integer.valueOf(size)) : false);
        }
    }

    public /* synthetic */ MessagePreprocessor(long j, Collection collection, List list, boolean z2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (Collection<Integer>) ((i & 2) != 0 ? null : collection), (List<MessageEmbed>) ((i & 4) != 0 ? null : list), (i & 8) != 0 ? true : z2, (i & 16) != 0 ? null : num);
    }

    public MessagePreprocessor(long j, StoreMessageState$State storeMessageState$State) {
        this(j, storeMessageState$State != null ? storeMessageState$State.getVisibleSpoilerNodeIndices() : null, null, false, null, 24, null);
    }

    private final <R extends BasicRenderContext> void constrainAST(Collection<Node<R>> nodes, MessagePreprocessor$ConstrainState state) {
        Iterator<Node<R>> it = nodes.iterator();
        while (it.hasNext()) {
            Node<R> next = it.next();
            if (!m.areEqual(next.getClass(), b.a.t.b.a.a.class)) {
                state.setLimit(state.getLimit() - 1);
            }
            if (state.getLimit() <= 0) {
                it.remove();
            } else if (next.hasChildren()) {
                Collection<Node<R>> children = next.getChildren();
                Objects.requireNonNull(children, "null cannot be cast to non-null type kotlin.collections.MutableCollection<com.discord.simpleast.core.node.Node<R>>");
                constrainAST(e0.asMutableCollection(children), state);
                if (!next.hasChildren()) {
                    it.remove();
                }
            }
        }
    }

    public MessagePreprocessor(long j, StoreMessageState$State storeMessageState$State, List<MessageEmbed> list, boolean z2, Integer num) {
        this(j, storeMessageState$State != null ? storeMessageState$State.getVisibleSpoilerNodeIndices() : null, list, z2, num);
    }
}

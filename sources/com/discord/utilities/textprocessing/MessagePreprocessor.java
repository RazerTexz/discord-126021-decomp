package com.discord.utilities.textprocessing;

import b.a.t.b.a.TextNode;
import b.a.t.b.c.NodeProcessor;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.simpleast.code.CodeNode;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.stores.StoreMessageState;
import com.discord.utilities.embed.EmbedResourceUtils;
import com.discord.utilities.textprocessing.node.BasicRenderContext;
import com.discord.utilities.textprocessing.node.BlockQuoteNode;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.utilities.textprocessing.node.Spoilerable;
import com.discord.utilities.textprocessing.node.UrlNode;
import d0.g0.StringsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.TypeIntrinsics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MessagePreprocessor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessagePreprocessor implements NodeProcessor {
    private static final int MAX_JUMBO_EMOJI_COUNT = 27;
    private int customEmojiCount;
    private final List<MessageEmbed> embeds;
    private boolean hasLinkConflictingNode;
    private final Integer maxNodes;
    private final long myUserId;
    private boolean shouldJumboify;
    private List<SpoilerNode<?>> spoilers;
    private final Collection<Integer> visibleSpoilerNodeIndices;

    /* JADX INFO: compiled from: MessagePreprocessor.kt */
    public static final /* data */ class ConstrainState {
        private int limit;

        public ConstrainState(int i) {
            this.limit = i;
        }

        public static /* synthetic */ ConstrainState copy$default(ConstrainState constrainState, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = constrainState.limit;
            }
            return constrainState.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getLimit() {
            return this.limit;
        }

        public final ConstrainState copy(int limit) {
            return new ConstrainState(limit);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ConstrainState) && this.limit == ((ConstrainState) other).limit;
            }
            return true;
        }

        public final int getLimit() {
            return this.limit;
        }

        public int hashCode() {
            return this.limit;
        }

        public final void setLimit(int i) {
            this.limit = i;
        }

        public String toString() {
            return outline.B(outline.U("ConstrainState(limit="), this.limit, ")");
        }
    }

    public MessagePreprocessor(long j, Collection<Integer> collection, List<MessageEmbed> list, boolean z2, Integer num) {
        this.myUserId = j;
        this.visibleSpoilerNodeIndices = collection;
        this.embeds = list;
        this.shouldJumboify = z2;
        this.maxNodes = num;
    }

    private final <R extends BasicRenderContext> void constrainAST(Collection<? extends Node<R>> nodes) {
        if (this.maxNodes != null) {
            Objects.requireNonNull(nodes, "null cannot be cast to non-null type kotlin.collections.MutableCollection<com.discord.simpleast.core.node.Node<R>>");
            constrainAST(TypeIntrinsics.asMutableCollection(nodes), new ConstrainState(this.maxNodes.intValue()));
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
        mergeConsecutiveQuoteNodes(TypeIntrinsics.asMutableCollection(ast));
        NodeProcessor nodeProcessor = new NodeProcessor() { // from class: com.discord.utilities.textprocessing.MessagePreprocessor.processQuoteChildren.1
            @Override // b.a.t.b.c.NodeProcessor
            public final void processNode(Node<Object> node) {
                Collection<Node<Object>> children = node.getChildren();
                if (children != null) {
                    MessagePreprocessor.this.mergeConsecutiveQuoteNodes(TypeIntrinsics.asMutableCollection(children));
                }
            }
        };
        Iterator<? extends Node<R>> it = ast.iterator();
        while (it.hasNext()) {
            AnimatableValueParser.k2(it.next(), nodeProcessor);
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
                AnimatableValueParser.i2(((SpoilerNode) it.next()).getChildren(), new NodeProcessor() { // from class: com.discord.utilities.textprocessing.MessagePreprocessor$processSpoilerChildren$3$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // b.a.t.b.c.NodeProcessor
                    public final void processNode(Node<Object> node) {
                        if (node instanceof Spoilerable) {
                            ((Spoilerable) node).setRevealed(false);
                        }
                    }
                });
            }
        }
    }

    private final void stripSimpleEmbedLink(Collection<Node<MessageRenderContext>> nodes) {
        List<MessageEmbed> list;
        if (nodes.size() == 1 && (list = this.embeds) != null && list.size() == 1) {
            Node node = (Node) _Collections.elementAt(nodes, 0);
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
        Intrinsics3.checkNotNullParameter(ast, "ast");
        stripSimpleEmbedLink(TypeIntrinsics.asMutableCollection(ast));
        AnimatableValueParser.i2(ast, this);
        if (this.shouldJumboify) {
            AnimatableValueParser.i2(ast, new NodeProcessor() { // from class: com.discord.utilities.textprocessing.MessagePreprocessor.process.1
                @Override // b.a.t.b.c.NodeProcessor
                public final void processNode(Node<Object> node) {
                    if (node instanceof EmojiNode) {
                        ((EmojiNode) node).setJumbo(true);
                    }
                }
            });
        }
        processSpoilerChildren();
        processQuoteChildren(ast);
        constrainAST(ast);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001f  */
    /* JADX WARN: Code duplicated, block: B:18:0x0034  */
    /* JADX WARN: Code duplicated, block: B:9:0x0019  */
    @Override // b.a.t.b.c.NodeProcessor
    public void processNode(Node<?> node) {
        boolean z2;
        boolean zIsBlank;
        Intrinsics3.checkNotNullParameter(node, "node");
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
            } else if (node instanceof TextNode) {
                zIsBlank = StringsJVM.isBlank(((TextNode) node).getContent());
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

    public MessagePreprocessor(long j, StoreMessageState.State state) {
        this(j, state != null ? state.getVisibleSpoilerNodeIndices() : null, null, false, null, 24, null);
    }

    private final <R extends BasicRenderContext> void constrainAST(Collection<Node<R>> nodes, ConstrainState state) {
        Iterator<Node<R>> it = nodes.iterator();
        while (it.hasNext()) {
            Node<R> next = it.next();
            if (!Intrinsics3.areEqual(next.getClass(), TextNode.class)) {
                state.setLimit(state.getLimit() - 1);
            }
            if (state.getLimit() <= 0) {
                it.remove();
            } else if (next.hasChildren()) {
                Collection<Node<R>> children = next.getChildren();
                Objects.requireNonNull(children, "null cannot be cast to non-null type kotlin.collections.MutableCollection<com.discord.simpleast.core.node.Node<R>>");
                constrainAST(TypeIntrinsics.asMutableCollection(children), state);
                if (!next.hasChildren()) {
                    it.remove();
                }
            }
        }
    }

    public MessagePreprocessor(long j, StoreMessageState.State state, List<MessageEmbed> list, boolean z2, Integer num) {
        this(j, state != null ? state.getVisibleSpoilerNodeIndices() : null, list, z2, num);
    }
}

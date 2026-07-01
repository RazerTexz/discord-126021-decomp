package com.discord.utilities.textprocessing;

import b.a.t.b.c.NodeProcessor;
import b.c.a.a0.AnimatableValueParser;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.textprocessing.node.ChannelMentionNode;
import com.discord.utilities.textprocessing.node.RoleMentionNode;
import com.discord.utilities.textprocessing.node.UserMentionNode;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TagsBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TagsBuilder implements NodeProcessor {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Set<Long> taggedChannelIds;
    private Set<Long> taggedRoleIds;
    private Set<Long> taggedUserIds;

    /* JADX INFO: compiled from: TagsBuilder.kt */
    public static final class Companion {
        private Companion() {
        }

        public final TagsBuilder2 extractTags(Collection<? extends Node<?>> ast) {
            Intrinsics3.checkNotNullParameter(ast, "ast");
            TagsBuilder tagsBuilder = new TagsBuilder();
            tagsBuilder.processAst(ast);
            return tagsBuilder.build();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void addChannel(long channelId) {
        Set<Long> hashSet = this.taggedChannelIds;
        if (hashSet == null) {
            hashSet = new HashSet<>(4);
        }
        hashSet.add(Long.valueOf(channelId));
        this.taggedChannelIds = hashSet;
    }

    private final void addRole(long roleId) {
        Set<Long> hashSet = this.taggedRoleIds;
        if (hashSet == null) {
            hashSet = new HashSet<>(4);
        }
        hashSet.add(Long.valueOf(roleId));
        this.taggedRoleIds = hashSet;
    }

    private final void addUser(long userId) {
        Set<Long> hashSet = this.taggedUserIds;
        if (hashSet == null) {
            hashSet = new HashSet<>(4);
        }
        hashSet.add(Long.valueOf(userId));
        this.taggedUserIds = hashSet;
    }

    public final TagsBuilder2 build() {
        Set<Long> setEmptySet = this.taggedUserIds;
        if (setEmptySet == null) {
            setEmptySet = Collections.emptySet();
            Intrinsics3.checkNotNullExpressionValue(setEmptySet, "Collections.emptySet()");
        }
        Set<Long> setEmptySet2 = this.taggedChannelIds;
        if (setEmptySet2 == null) {
            setEmptySet2 = Collections.emptySet();
            Intrinsics3.checkNotNullExpressionValue(setEmptySet2, "Collections.emptySet()");
        }
        Set<Long> setEmptySet3 = this.taggedRoleIds;
        if (setEmptySet3 == null) {
            setEmptySet3 = Collections.emptySet();
            Intrinsics3.checkNotNullExpressionValue(setEmptySet3, "Collections.emptySet()");
        }
        return new TagsBuilder2(setEmptySet, setEmptySet2, setEmptySet3);
    }

    public final void processAst(Collection<? extends Node<?>> ast) {
        Intrinsics3.checkNotNullParameter(ast, "ast");
        AnimatableValueParser.i2(ast, this);
    }

    @Override // b.a.t.b.c.NodeProcessor
    public void processNode(Node<?> node) {
        if (node instanceof UserMentionNode) {
            UserMentionNode userMentionNode = (UserMentionNode) node;
            if (userMentionNode.getType() == UserMentionNode.Type.USER) {
                addUser(userMentionNode.getUserId());
                return;
            }
        }
        if (node instanceof RoleMentionNode) {
            addRole(((RoleMentionNode) node).getRoleId());
        } else if (node instanceof ChannelMentionNode) {
            addChannel(((ChannelMentionNode) node).getChannelId());
        }
    }
}

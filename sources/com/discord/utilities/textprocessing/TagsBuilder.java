package com.discord.utilities.textprocessing;

import com.discord.simpleast.core.node.Node;
import com.discord.utilities.textprocessing.node.ChannelMentionNode;
import com.discord.utilities.textprocessing.node.RoleMentionNode;
import com.discord.utilities.textprocessing.node.UserMentionNode;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p050t.p052b.p055c.InterfaceC1307a;
import p007b.p085c.p086a.p087a0.C1460d;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TagsBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TagsBuilder implements InterfaceC1307a {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Set<Long> taggedChannelIds;
    private Set<Long> taggedRoleIds;
    private Set<Long> taggedUserIds;

    /* JADX INFO: compiled from: TagsBuilder.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Tags extractTags(Collection<? extends Node<?>> ast) {
            C12238m.checkNotNullParameter(ast, "ast");
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

    public final Tags build() {
        Set<Long> setEmptySet = this.taggedUserIds;
        if (setEmptySet == null) {
            setEmptySet = Collections.emptySet();
            C12238m.checkNotNullExpressionValue(setEmptySet, "Collections.emptySet()");
        }
        Set<Long> setEmptySet2 = this.taggedChannelIds;
        if (setEmptySet2 == null) {
            setEmptySet2 = Collections.emptySet();
            C12238m.checkNotNullExpressionValue(setEmptySet2, "Collections.emptySet()");
        }
        Set<Long> setEmptySet3 = this.taggedRoleIds;
        if (setEmptySet3 == null) {
            setEmptySet3 = Collections.emptySet();
            C12238m.checkNotNullExpressionValue(setEmptySet3, "Collections.emptySet()");
        }
        return new Tags(setEmptySet, setEmptySet2, setEmptySet3);
    }

    public final void processAst(Collection<? extends Node<?>> ast) {
        C12238m.checkNotNullParameter(ast, "ast");
        C1460d.m530i2(ast, this);
    }

    @Override // p007b.p008a.p050t.p052b.p055c.InterfaceC1307a
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

package com.discord.widgets.servers.member_verification.form_fields;

import b.d.b.a.outline;
import com.discord.api.role.GuildRole;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.textprocessing.MessageRenderContext;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: MemberVerificationItemTerm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MemberVerificationItemTerm implements MemberVerificationItem {
    private final boolean allowAnimatedEmojis;
    private final List<Node<MessageRenderContext>> ast;
    private final Map<Long, String> channelNames;
    private final int index;
    private final boolean isFirstItem;
    private final boolean isLastItem;
    private final String key;
    private final Map<Long, GuildRole> roles;
    private final String rule;
    private final int type;

    public MemberVerificationItemTerm(int i, String str, List<Node<MessageRenderContext>> list, Map<Long, String> map, Map<Long, GuildRole> map2, boolean z2, boolean z3, boolean z4) {
        Intrinsics3.checkNotNullParameter(str, "rule");
        Intrinsics3.checkNotNullParameter(list, "ast");
        Intrinsics3.checkNotNullParameter(map, "channelNames");
        Intrinsics3.checkNotNullParameter(map2, "roles");
        this.index = i;
        this.rule = str;
        this.ast = list;
        this.channelNames = map;
        this.roles = map2;
        this.allowAnimatedEmojis = z2;
        this.isFirstItem = z3;
        this.isLastItem = z4;
        this.type = 3;
        this.key = getType() + i + str;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRule() {
        return this.rule;
    }

    public final List<Node<MessageRenderContext>> component3() {
        return this.ast;
    }

    public final Map<Long, String> component4() {
        return this.channelNames;
    }

    public final Map<Long, GuildRole> component5() {
        return this.roles;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getAllowAnimatedEmojis() {
        return this.allowAnimatedEmojis;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsFirstItem() {
        return this.isFirstItem;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsLastItem() {
        return this.isLastItem;
    }

    public final MemberVerificationItemTerm copy(int index, String rule, List<Node<MessageRenderContext>> ast, Map<Long, String> channelNames, Map<Long, GuildRole> roles, boolean allowAnimatedEmojis, boolean isFirstItem, boolean isLastItem) {
        Intrinsics3.checkNotNullParameter(rule, "rule");
        Intrinsics3.checkNotNullParameter(ast, "ast");
        Intrinsics3.checkNotNullParameter(channelNames, "channelNames");
        Intrinsics3.checkNotNullParameter(roles, "roles");
        return new MemberVerificationItemTerm(index, rule, ast, channelNames, roles, allowAnimatedEmojis, isFirstItem, isLastItem);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemberVerificationItemTerm)) {
            return false;
        }
        MemberVerificationItemTerm memberVerificationItemTerm = (MemberVerificationItemTerm) other;
        return this.index == memberVerificationItemTerm.index && Intrinsics3.areEqual(this.rule, memberVerificationItemTerm.rule) && Intrinsics3.areEqual(this.ast, memberVerificationItemTerm.ast) && Intrinsics3.areEqual(this.channelNames, memberVerificationItemTerm.channelNames) && Intrinsics3.areEqual(this.roles, memberVerificationItemTerm.roles) && this.allowAnimatedEmojis == memberVerificationItemTerm.allowAnimatedEmojis && this.isFirstItem == memberVerificationItemTerm.isFirstItem && this.isLastItem == memberVerificationItemTerm.isLastItem;
    }

    public final boolean getAllowAnimatedEmojis() {
        return this.allowAnimatedEmojis;
    }

    public final List<Node<MessageRenderContext>> getAst() {
        return this.ast;
    }

    public final Map<Long, String> getChannelNames() {
        return this.channelNames;
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Map<Long, GuildRole> getRoles() {
        return this.roles;
    }

    public final String getRule() {
        return this.rule;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int i = this.index * 31;
        String str = this.rule;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        List<Node<MessageRenderContext>> list = this.ast;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        Map<Long, String> map = this.channelNames;
        int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, GuildRole> map2 = this.roles;
        int iHashCode4 = (iHashCode3 + (map2 != null ? map2.hashCode() : 0)) * 31;
        boolean z2 = this.allowAnimatedEmojis;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i2 = (iHashCode4 + r1) * 31;
        boolean z3 = this.isFirstItem;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i3 = (i2 + r2) * 31;
        boolean z4 = this.isLastItem;
        return i3 + (z4 ? 1 : z4);
    }

    public final boolean isFirstItem() {
        return this.isFirstItem;
    }

    public final boolean isLastItem() {
        return this.isLastItem;
    }

    public String toString() {
        StringBuilder sbU = outline.U("MemberVerificationItemTerm(index=");
        sbU.append(this.index);
        sbU.append(", rule=");
        sbU.append(this.rule);
        sbU.append(", ast=");
        sbU.append(this.ast);
        sbU.append(", channelNames=");
        sbU.append(this.channelNames);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", allowAnimatedEmojis=");
        sbU.append(this.allowAnimatedEmojis);
        sbU.append(", isFirstItem=");
        sbU.append(this.isFirstItem);
        sbU.append(", isLastItem=");
        return outline.O(sbU, this.isLastItem, ")");
    }
}

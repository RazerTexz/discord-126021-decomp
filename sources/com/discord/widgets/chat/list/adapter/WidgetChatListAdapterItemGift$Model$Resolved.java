package com.discord.widgets.chat.list.adapter;

import b.d.b.a.a;
import com.discord.models.domain.ModelGift;
import com.discord.models.user.MeUser;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatListAdapterItemGift$Model$Resolved extends WidgetChatListAdapterItemGift$Model {
    private final ModelGift gift;
    private final boolean inLibrary;
    private final MeUser meUser;
    private final boolean redeeming;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGift$Model$Resolved(ModelGift modelGift, MeUser meUser, boolean z2, boolean z3) {
        super(null);
        m.checkNotNullParameter(modelGift, "gift");
        m.checkNotNullParameter(meUser, "meUser");
        this.gift = modelGift;
        this.meUser = meUser;
        this.inLibrary = z2;
        this.redeeming = z3;
    }

    public static /* synthetic */ WidgetChatListAdapterItemGift$Model$Resolved copy$default(WidgetChatListAdapterItemGift$Model$Resolved widgetChatListAdapterItemGift$Model$Resolved, ModelGift modelGift, MeUser meUser, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            modelGift = widgetChatListAdapterItemGift$Model$Resolved.gift;
        }
        if ((i & 2) != 0) {
            meUser = widgetChatListAdapterItemGift$Model$Resolved.meUser;
        }
        if ((i & 4) != 0) {
            z2 = widgetChatListAdapterItemGift$Model$Resolved.inLibrary;
        }
        if ((i & 8) != 0) {
            z3 = widgetChatListAdapterItemGift$Model$Resolved.redeeming;
        }
        return widgetChatListAdapterItemGift$Model$Resolved.copy(modelGift, meUser, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelGift getGift() {
        return this.gift;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MeUser getMeUser() {
        return this.meUser;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getInLibrary() {
        return this.inLibrary;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getRedeeming() {
        return this.redeeming;
    }

    public final WidgetChatListAdapterItemGift$Model$Resolved copy(ModelGift gift, MeUser meUser, boolean inLibrary, boolean redeeming) {
        m.checkNotNullParameter(gift, "gift");
        m.checkNotNullParameter(meUser, "meUser");
        return new WidgetChatListAdapterItemGift$Model$Resolved(gift, meUser, inLibrary, redeeming);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatListAdapterItemGift$Model$Resolved)) {
            return false;
        }
        WidgetChatListAdapterItemGift$Model$Resolved widgetChatListAdapterItemGift$Model$Resolved = (WidgetChatListAdapterItemGift$Model$Resolved) other;
        return m.areEqual(this.gift, widgetChatListAdapterItemGift$Model$Resolved.gift) && m.areEqual(this.meUser, widgetChatListAdapterItemGift$Model$Resolved.meUser) && this.inLibrary == widgetChatListAdapterItemGift$Model$Resolved.inLibrary && this.redeeming == widgetChatListAdapterItemGift$Model$Resolved.redeeming;
    }

    public final ModelGift getGift() {
        return this.gift;
    }

    public final boolean getInLibrary() {
        return this.inLibrary;
    }

    public final MeUser getMeUser() {
        return this.meUser;
    }

    public final boolean getRedeeming() {
        return this.redeeming;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        ModelGift modelGift = this.gift;
        int iHashCode = (modelGift != null ? modelGift.hashCode() : 0) * 31;
        MeUser meUser = this.meUser;
        int iHashCode2 = (iHashCode + (meUser != null ? meUser.hashCode() : 0)) * 31;
        boolean z2 = this.inLibrary;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        boolean z3 = this.redeeming;
        return i + (z3 ? 1 : z3);
    }

    public String toString() {
        StringBuilder sbU = a.U("Resolved(gift=");
        sbU.append(this.gift);
        sbU.append(", meUser=");
        sbU.append(this.meUser);
        sbU.append(", inLibrary=");
        sbU.append(this.inLibrary);
        sbU.append(", redeeming=");
        return a.O(sbU, this.redeeming, ")");
    }
}

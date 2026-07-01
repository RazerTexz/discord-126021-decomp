package com.discord.widgets.chat.input;

import androidx.annotation.StringRes;
import b.d.b.a.a;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChatInputViewModel$Event$ShowPremiumUpsell extends ChatInputViewModel$Event {
    private final int bodyResId;
    private final int headerResId;
    private final int page;
    private final boolean showLearnMore;
    private final boolean showOtherPages;

    public /* synthetic */ ChatInputViewModel$Event$ShowPremiumUpsell(int i, int i2, int i3, boolean z2, boolean z3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, (i4 & 8) != 0 ? false : z2, (i4 & 16) != 0 ? false : z3);
    }

    public static /* synthetic */ ChatInputViewModel$Event$ShowPremiumUpsell copy$default(ChatInputViewModel$Event$ShowPremiumUpsell chatInputViewModel$Event$ShowPremiumUpsell, int i, int i2, int i3, boolean z2, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = chatInputViewModel$Event$ShowPremiumUpsell.page;
        }
        if ((i4 & 2) != 0) {
            i2 = chatInputViewModel$Event$ShowPremiumUpsell.headerResId;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            i3 = chatInputViewModel$Event$ShowPremiumUpsell.bodyResId;
        }
        int i6 = i3;
        if ((i4 & 8) != 0) {
            z2 = chatInputViewModel$Event$ShowPremiumUpsell.showOtherPages;
        }
        boolean z4 = z2;
        if ((i4 & 16) != 0) {
            z3 = chatInputViewModel$Event$ShowPremiumUpsell.showLearnMore;
        }
        return chatInputViewModel$Event$ShowPremiumUpsell.copy(i, i5, i6, z4, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getPage() {
        return this.page;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getHeaderResId() {
        return this.headerResId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getBodyResId() {
        return this.bodyResId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getShowOtherPages() {
        return this.showOtherPages;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getShowLearnMore() {
        return this.showLearnMore;
    }

    public final ChatInputViewModel$Event$ShowPremiumUpsell copy(int page, @StringRes int headerResId, @StringRes int bodyResId, boolean showOtherPages, boolean showLearnMore) {
        return new ChatInputViewModel$Event$ShowPremiumUpsell(page, headerResId, bodyResId, showOtherPages, showLearnMore);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatInputViewModel$Event$ShowPremiumUpsell)) {
            return false;
        }
        ChatInputViewModel$Event$ShowPremiumUpsell chatInputViewModel$Event$ShowPremiumUpsell = (ChatInputViewModel$Event$ShowPremiumUpsell) other;
        return this.page == chatInputViewModel$Event$ShowPremiumUpsell.page && this.headerResId == chatInputViewModel$Event$ShowPremiumUpsell.headerResId && this.bodyResId == chatInputViewModel$Event$ShowPremiumUpsell.bodyResId && this.showOtherPages == chatInputViewModel$Event$ShowPremiumUpsell.showOtherPages && this.showLearnMore == chatInputViewModel$Event$ShowPremiumUpsell.showLearnMore;
    }

    public final int getBodyResId() {
        return this.bodyResId;
    }

    public final int getHeaderResId() {
        return this.headerResId;
    }

    public final int getPage() {
        return this.page;
    }

    public final boolean getShowLearnMore() {
        return this.showLearnMore;
    }

    public final boolean getShowOtherPages() {
        return this.showOtherPages;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int i = ((((this.page * 31) + this.headerResId) * 31) + this.bodyResId) * 31;
        boolean z2 = this.showOtherPages;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i2 = (i + r1) * 31;
        boolean z3 = this.showLearnMore;
        return i2 + (z3 ? 1 : z3);
    }

    public String toString() {
        StringBuilder sbU = a.U("ShowPremiumUpsell(page=");
        sbU.append(this.page);
        sbU.append(", headerResId=");
        sbU.append(this.headerResId);
        sbU.append(", bodyResId=");
        sbU.append(this.bodyResId);
        sbU.append(", showOtherPages=");
        sbU.append(this.showOtherPages);
        sbU.append(", showLearnMore=");
        return a.O(sbU, this.showLearnMore, ")");
    }

    public ChatInputViewModel$Event$ShowPremiumUpsell(int i, @StringRes int i2, @StringRes int i3, boolean z2, boolean z3) {
        super(null);
        this.page = i;
        this.headerResId = i2;
        this.bodyResId = i3;
        this.showOtherPages = z2;
        this.showLearnMore = z3;
    }
}

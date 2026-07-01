package com.discord.widgets.user;

import b.d.b.a.a;
import com.discord.models.message.Message;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetUserMentions$Model$MessageLoader$LoadingState {
    private final boolean isAllLoaded;
    private final boolean isLoading;
    private final List<Message> mentions;

    public WidgetUserMentions$Model$MessageLoader$LoadingState() {
        this(false, false, null, 7, null);
    }

    public WidgetUserMentions$Model$MessageLoader$LoadingState(boolean z2, boolean z3, List<Message> list) {
        m.checkNotNullParameter(list, "mentions");
        this.isLoading = z2;
        this.isAllLoaded = z3;
        this.mentions = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetUserMentions$Model$MessageLoader$LoadingState copy$default(WidgetUserMentions$Model$MessageLoader$LoadingState widgetUserMentions$Model$MessageLoader$LoadingState, boolean z2, boolean z3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = widgetUserMentions$Model$MessageLoader$LoadingState.isLoading;
        }
        if ((i & 2) != 0) {
            z3 = widgetUserMentions$Model$MessageLoader$LoadingState.isAllLoaded;
        }
        if ((i & 4) != 0) {
            list = widgetUserMentions$Model$MessageLoader$LoadingState.mentions;
        }
        return widgetUserMentions$Model$MessageLoader$LoadingState.copy(z2, z3, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsAllLoaded() {
        return this.isAllLoaded;
    }

    public final List<Message> component3() {
        return this.mentions;
    }

    public final WidgetUserMentions$Model$MessageLoader$LoadingState copy(boolean isLoading, boolean isAllLoaded, List<Message> mentions) {
        m.checkNotNullParameter(mentions, "mentions");
        return new WidgetUserMentions$Model$MessageLoader$LoadingState(isLoading, isAllLoaded, mentions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetUserMentions$Model$MessageLoader$LoadingState)) {
            return false;
        }
        WidgetUserMentions$Model$MessageLoader$LoadingState widgetUserMentions$Model$MessageLoader$LoadingState = (WidgetUserMentions$Model$MessageLoader$LoadingState) other;
        return this.isLoading == widgetUserMentions$Model$MessageLoader$LoadingState.isLoading && this.isAllLoaded == widgetUserMentions$Model$MessageLoader$LoadingState.isAllLoaded && m.areEqual(this.mentions, widgetUserMentions$Model$MessageLoader$LoadingState.mentions);
    }

    public final List<Message> getMentions() {
        return this.mentions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        boolean z2 = this.isLoading;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.isAllLoaded;
        int i2 = (i + (z3 ? 1 : z3)) * 31;
        List<Message> list = this.mentions;
        return i2 + (list != null ? list.hashCode() : 0);
    }

    public final boolean isAllLoaded() {
        return this.isAllLoaded;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public String toString() {
        StringBuilder sbU = a.U("LoadingState(isLoading=");
        sbU.append(this.isLoading);
        sbU.append(", isAllLoaded=");
        sbU.append(this.isAllLoaded);
        sbU.append(", mentions=");
        return a.L(sbU, this.mentions, ")");
    }

    public /* synthetic */ WidgetUserMentions$Model$MessageLoader$LoadingState(boolean z2, boolean z3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, (i & 4) != 0 ? n.emptyList() : list);
    }
}

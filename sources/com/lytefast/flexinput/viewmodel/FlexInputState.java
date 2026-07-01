package com.lytefast.flexinput.viewmodel;

import b.d.b.a.outline;
import com.lytefast.flexinput.model.Attachment;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: FlexInputState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class FlexInputState {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final String inputText;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean showExpandedButtons;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final List<Attachment<Object>> attachments;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final boolean attachmentViewEnabled;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final boolean singleSelectMode;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final Integer showContentDialogIndex;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final boolean ableToSendMessages;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final boolean ableToAttachFiles;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final boolean showExpressionTray;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final boolean showExpressionTrayButtonBadge;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final boolean expressionSuggestionsEnabled;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final Long channelId;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final Long guildId;

    public FlexInputState() {
        this(null, false, null, false, false, null, false, false, false, false, false, null, null, 8191);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FlexInputState(String str, boolean z2, List<? extends Attachment<? extends Object>> list, boolean z3, boolean z4, Integer num, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, Long l, Long l2) {
        Intrinsics3.checkNotNullParameter(str, "inputText");
        Intrinsics3.checkNotNullParameter(list, "attachments");
        this.inputText = str;
        this.showExpandedButtons = z2;
        this.attachments = list;
        this.attachmentViewEnabled = z3;
        this.singleSelectMode = z4;
        this.showContentDialogIndex = num;
        this.ableToSendMessages = z5;
        this.ableToAttachFiles = z6;
        this.showExpressionTray = z7;
        this.showExpressionTrayButtonBadge = z8;
        this.expressionSuggestionsEnabled = z9;
        this.channelId = l;
        this.guildId = l2;
    }

    public static FlexInputState a(FlexInputState flexInputState, String str, boolean z2, List list, boolean z3, boolean z4, Integer num, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, Long l, Long l2, int i) {
        String str2 = (i & 1) != 0 ? flexInputState.inputText : str;
        boolean z10 = (i & 2) != 0 ? flexInputState.showExpandedButtons : z2;
        List list2 = (i & 4) != 0 ? flexInputState.attachments : list;
        boolean z11 = (i & 8) != 0 ? flexInputState.attachmentViewEnabled : z3;
        boolean z12 = (i & 16) != 0 ? flexInputState.singleSelectMode : z4;
        Integer num2 = (i & 32) != 0 ? flexInputState.showContentDialogIndex : num;
        boolean z13 = (i & 64) != 0 ? flexInputState.ableToSendMessages : z5;
        boolean z14 = (i & 128) != 0 ? flexInputState.ableToAttachFiles : z6;
        boolean z15 = (i & 256) != 0 ? flexInputState.showExpressionTray : z7;
        boolean z16 = (i & 512) != 0 ? flexInputState.showExpressionTrayButtonBadge : z8;
        boolean z17 = (i & 1024) != 0 ? flexInputState.expressionSuggestionsEnabled : z9;
        Long l3 = (i & 2048) != 0 ? flexInputState.channelId : l;
        Long l4 = (i & 4096) != 0 ? flexInputState.guildId : l2;
        Objects.requireNonNull(flexInputState);
        Intrinsics3.checkNotNullParameter(str2, "inputText");
        Intrinsics3.checkNotNullParameter(list2, "attachments");
        return new FlexInputState(str2, z10, list2, z11, z12, num2, z13, z14, z15, z16, z17, l3, l4);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FlexInputState)) {
            return false;
        }
        FlexInputState flexInputState = (FlexInputState) other;
        return Intrinsics3.areEqual(this.inputText, flexInputState.inputText) && this.showExpandedButtons == flexInputState.showExpandedButtons && Intrinsics3.areEqual(this.attachments, flexInputState.attachments) && this.attachmentViewEnabled == flexInputState.attachmentViewEnabled && this.singleSelectMode == flexInputState.singleSelectMode && Intrinsics3.areEqual(this.showContentDialogIndex, flexInputState.showContentDialogIndex) && this.ableToSendMessages == flexInputState.ableToSendMessages && this.ableToAttachFiles == flexInputState.ableToAttachFiles && this.showExpressionTray == flexInputState.showExpressionTray && this.showExpressionTrayButtonBadge == flexInputState.showExpressionTrayButtonBadge && this.expressionSuggestionsEnabled == flexInputState.expressionSuggestionsEnabled && Intrinsics3.areEqual(this.channelId, flexInputState.channelId) && Intrinsics3.areEqual(this.guildId, flexInputState.guildId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String str = this.inputText;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z2 = this.showExpandedButtons;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        List<Attachment<Object>> list = this.attachments;
        int iHashCode2 = (i + (list != null ? list.hashCode() : 0)) * 31;
        boolean z3 = this.attachmentViewEnabled;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (iHashCode2 + r3) * 31;
        boolean z4 = this.singleSelectMode;
        ?? r4 = z4;
        if (z4) {
            r4 = 1;
        }
        int i3 = (i2 + r4) * 31;
        Integer num = this.showContentDialogIndex;
        int iHashCode3 = (i3 + (num != null ? num.hashCode() : 0)) * 31;
        boolean z5 = this.ableToSendMessages;
        ?? r5 = z5;
        if (z5) {
            r5 = 1;
        }
        int i4 = (iHashCode3 + r5) * 31;
        boolean z6 = this.ableToAttachFiles;
        ?? r6 = z6;
        if (z6) {
            r6 = 1;
        }
        int i5 = (i4 + r6) * 31;
        boolean z7 = this.showExpressionTray;
        ?? r7 = z7;
        if (z7) {
            r7 = 1;
        }
        int i6 = (i5 + r7) * 31;
        boolean z8 = this.showExpressionTrayButtonBadge;
        ?? r8 = z8;
        if (z8) {
            r8 = 1;
        }
        int i7 = (i6 + r8) * 31;
        boolean z9 = this.expressionSuggestionsEnabled;
        int i8 = (i7 + (z9 ? 1 : z9)) * 31;
        Long l = this.channelId;
        int iHashCode4 = (i8 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.guildId;
        return iHashCode4 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("FlexInputState(inputText=");
        sbU.append(this.inputText);
        sbU.append(", showExpandedButtons=");
        sbU.append(this.showExpandedButtons);
        sbU.append(", attachments=");
        sbU.append(this.attachments);
        sbU.append(", attachmentViewEnabled=");
        sbU.append(this.attachmentViewEnabled);
        sbU.append(", singleSelectMode=");
        sbU.append(this.singleSelectMode);
        sbU.append(", showContentDialogIndex=");
        sbU.append(this.showContentDialogIndex);
        sbU.append(", ableToSendMessages=");
        sbU.append(this.ableToSendMessages);
        sbU.append(", ableToAttachFiles=");
        sbU.append(this.ableToAttachFiles);
        sbU.append(", showExpressionTray=");
        sbU.append(this.showExpressionTray);
        sbU.append(", showExpressionTrayButtonBadge=");
        sbU.append(this.showExpressionTrayButtonBadge);
        sbU.append(", expressionSuggestionsEnabled=");
        sbU.append(this.expressionSuggestionsEnabled);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", guildId=");
        return outline.G(sbU, this.guildId, ")");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlexInputState(String str, boolean z2, List list, boolean z3, boolean z4, Integer num, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, Long l, Long l2, int i) {
        this((i & 1) != 0 ? "" : null, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? Collections2.emptyList() : null, (i & 8) != 0 ? true : z3, (i & 16) != 0 ? true : z4, null, (i & 64) != 0 ? true : z5, (i & 128) != 0 ? true : z6, (i & 256) != 0 ? false : z7, (i & 512) == 0 ? z8 : false, (i & 1024) == 0 ? z9 : true, null, null);
        int i2 = i & 32;
        int i3 = i & 2048;
        int i4 = i & 4096;
    }
}

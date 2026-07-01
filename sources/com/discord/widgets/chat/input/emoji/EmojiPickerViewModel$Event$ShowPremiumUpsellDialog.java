package com.discord.widgets.chat.input.emoji;

import androidx.annotation.StringRes;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: EmojiPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class EmojiPickerViewModel$Event$ShowPremiumUpsellDialog extends EmojiPickerViewModel$Event {
    private final int body;
    private final int header;
    private final int pageNumber;
    private final String sectionName;
    private final boolean showLearnMore;
    private final boolean showOtherPages;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiPickerViewModel$Event$ShowPremiumUpsellDialog(int i, @StringRes int i2, @StringRes int i3, String str, boolean z2, boolean z3) {
        super(null);
        m.checkNotNullParameter(str, "sectionName");
        this.pageNumber = i;
        this.header = i2;
        this.body = i3;
        this.sectionName = str;
        this.showOtherPages = z2;
        this.showLearnMore = z3;
    }

    public static /* synthetic */ EmojiPickerViewModel$Event$ShowPremiumUpsellDialog copy$default(EmojiPickerViewModel$Event$ShowPremiumUpsellDialog emojiPickerViewModel$Event$ShowPremiumUpsellDialog, int i, int i2, int i3, String str, boolean z2, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = emojiPickerViewModel$Event$ShowPremiumUpsellDialog.pageNumber;
        }
        if ((i4 & 2) != 0) {
            i2 = emojiPickerViewModel$Event$ShowPremiumUpsellDialog.header;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            i3 = emojiPickerViewModel$Event$ShowPremiumUpsellDialog.body;
        }
        int i6 = i3;
        if ((i4 & 8) != 0) {
            str = emojiPickerViewModel$Event$ShowPremiumUpsellDialog.sectionName;
        }
        String str2 = str;
        if ((i4 & 16) != 0) {
            z2 = emojiPickerViewModel$Event$ShowPremiumUpsellDialog.showOtherPages;
        }
        boolean z4 = z2;
        if ((i4 & 32) != 0) {
            z3 = emojiPickerViewModel$Event$ShowPremiumUpsellDialog.showLearnMore;
        }
        return emojiPickerViewModel$Event$ShowPremiumUpsellDialog.copy(i, i5, i6, str2, z4, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getPageNumber() {
        return this.pageNumber;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getHeader() {
        return this.header;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getBody() {
        return this.body;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSectionName() {
        return this.sectionName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getShowOtherPages() {
        return this.showOtherPages;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getShowLearnMore() {
        return this.showLearnMore;
    }

    public final EmojiPickerViewModel$Event$ShowPremiumUpsellDialog copy(int pageNumber, @StringRes int header, @StringRes int body, String sectionName, boolean showOtherPages, boolean showLearnMore) {
        m.checkNotNullParameter(sectionName, "sectionName");
        return new EmojiPickerViewModel$Event$ShowPremiumUpsellDialog(pageNumber, header, body, sectionName, showOtherPages, showLearnMore);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmojiPickerViewModel$Event$ShowPremiumUpsellDialog)) {
            return false;
        }
        EmojiPickerViewModel$Event$ShowPremiumUpsellDialog emojiPickerViewModel$Event$ShowPremiumUpsellDialog = (EmojiPickerViewModel$Event$ShowPremiumUpsellDialog) other;
        return this.pageNumber == emojiPickerViewModel$Event$ShowPremiumUpsellDialog.pageNumber && this.header == emojiPickerViewModel$Event$ShowPremiumUpsellDialog.header && this.body == emojiPickerViewModel$Event$ShowPremiumUpsellDialog.body && m.areEqual(this.sectionName, emojiPickerViewModel$Event$ShowPremiumUpsellDialog.sectionName) && this.showOtherPages == emojiPickerViewModel$Event$ShowPremiumUpsellDialog.showOtherPages && this.showLearnMore == emojiPickerViewModel$Event$ShowPremiumUpsellDialog.showLearnMore;
    }

    public final int getBody() {
        return this.body;
    }

    public final int getHeader() {
        return this.header;
    }

    public final int getPageNumber() {
        return this.pageNumber;
    }

    public final String getSectionName() {
        return this.sectionName;
    }

    public final boolean getShowLearnMore() {
        return this.showLearnMore;
    }

    public final boolean getShowOtherPages() {
        return this.showOtherPages;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int i = ((((this.pageNumber * 31) + this.header) * 31) + this.body) * 31;
        String str = this.sectionName;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.showOtherPages;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i2 = (iHashCode + r1) * 31;
        boolean z3 = this.showLearnMore;
        return i2 + (z3 ? 1 : z3);
    }

    public String toString() {
        StringBuilder sbU = a.U("ShowPremiumUpsellDialog(pageNumber=");
        sbU.append(this.pageNumber);
        sbU.append(", header=");
        sbU.append(this.header);
        sbU.append(", body=");
        sbU.append(this.body);
        sbU.append(", sectionName=");
        sbU.append(this.sectionName);
        sbU.append(", showOtherPages=");
        sbU.append(this.showOtherPages);
        sbU.append(", showLearnMore=");
        return a.O(sbU, this.showLearnMore, ")");
    }
}

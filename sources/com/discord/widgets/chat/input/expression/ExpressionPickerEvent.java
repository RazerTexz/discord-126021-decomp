package com.discord.widgets.chat.input.expression;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ExpressionPickerEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ExpressionPickerEvent {

    /* JADX INFO: compiled from: ExpressionPickerEvent.kt */
    public static final class CloseExpressionPicker extends ExpressionPickerEvent {
        public static final CloseExpressionPicker INSTANCE = new CloseExpressionPicker();

        private CloseExpressionPicker() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: ExpressionPickerEvent.kt */
    public static final /* data */ class OpenStickerPicker extends ExpressionPickerEvent {
        private final boolean inline;
        private final String searchText;
        private final Long stickerPackId;

        public OpenStickerPicker() {
            this(null, null, false, 7, null);
        }

        public /* synthetic */ OpenStickerPicker(Long l, String str, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? false : z2);
        }

        public static /* synthetic */ OpenStickerPicker copy$default(OpenStickerPicker openStickerPicker, Long l, String str, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                l = openStickerPicker.stickerPackId;
            }
            if ((i & 2) != 0) {
                str = openStickerPicker.searchText;
            }
            if ((i & 4) != 0) {
                z2 = openStickerPicker.inline;
            }
            return openStickerPicker.copy(l, str, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Long getStickerPackId() {
            return this.stickerPackId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSearchText() {
            return this.searchText;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getInline() {
            return this.inline;
        }

        public final OpenStickerPicker copy(Long stickerPackId, String searchText, boolean inline) {
            return new OpenStickerPicker(stickerPackId, searchText, inline);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OpenStickerPicker)) {
                return false;
            }
            OpenStickerPicker openStickerPicker = (OpenStickerPicker) other;
            return C12238m.areEqual(this.stickerPackId, openStickerPicker.stickerPackId) && C12238m.areEqual(this.searchText, openStickerPicker.searchText) && this.inline == openStickerPicker.inline;
        }

        public final boolean getInline() {
            return this.inline;
        }

        public final String getSearchText() {
            return this.searchText;
        }

        public final Long getStickerPackId() {
            return this.stickerPackId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            Long l = this.stickerPackId;
            int iHashCode = (l != null ? l.hashCode() : 0) * 31;
            String str = this.searchText;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            boolean z2 = this.inline;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode2 + r1;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("OpenStickerPicker(stickerPackId=");
            sbM833U.append(this.stickerPackId);
            sbM833U.append(", searchText=");
            sbM833U.append(this.searchText);
            sbM833U.append(", inline=");
            return C1643a.m827O(sbM833U, this.inline, ")");
        }

        public OpenStickerPicker(Long l, String str, boolean z2) {
            super(null);
            this.stickerPackId = l;
            this.searchText = str;
            this.inline = z2;
        }
    }

    private ExpressionPickerEvent() {
    }

    public /* synthetic */ ExpressionPickerEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

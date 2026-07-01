package com.discord.widgets.mobile_reports;

import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.d.b.a.a;
import com.discord.models.user.User;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MobileReportsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MobileReportsViewModel$MessagePreview {
    private final User author;
    private final String authorName;
    private final int authorNameColor;
    private final boolean hasEmbeds;
    private final DraweeSpanStringBuilder text;

    public MobileReportsViewModel$MessagePreview(DraweeSpanStringBuilder draweeSpanStringBuilder, String str, int i, User user, boolean z2) {
        m.checkNotNullParameter(draweeSpanStringBuilder, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        m.checkNotNullParameter(str, "authorName");
        m.checkNotNullParameter(user, "author");
        this.text = draweeSpanStringBuilder;
        this.authorName = str;
        this.authorNameColor = i;
        this.author = user;
        this.hasEmbeds = z2;
    }

    public static /* synthetic */ MobileReportsViewModel$MessagePreview copy$default(MobileReportsViewModel$MessagePreview mobileReportsViewModel$MessagePreview, DraweeSpanStringBuilder draweeSpanStringBuilder, String str, int i, User user, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            draweeSpanStringBuilder = mobileReportsViewModel$MessagePreview.text;
        }
        if ((i2 & 2) != 0) {
            str = mobileReportsViewModel$MessagePreview.authorName;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            i = mobileReportsViewModel$MessagePreview.authorNameColor;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            user = mobileReportsViewModel$MessagePreview.author;
        }
        User user2 = user;
        if ((i2 & 16) != 0) {
            z2 = mobileReportsViewModel$MessagePreview.hasEmbeds;
        }
        return mobileReportsViewModel$MessagePreview.copy(draweeSpanStringBuilder, str2, i3, user2, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final DraweeSpanStringBuilder getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAuthorName() {
        return this.authorName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getAuthorNameColor() {
        return this.authorNameColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final User getAuthor() {
        return this.author;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getHasEmbeds() {
        return this.hasEmbeds;
    }

    public final MobileReportsViewModel$MessagePreview copy(DraweeSpanStringBuilder text, String authorName, int authorNameColor, User author, boolean hasEmbeds) {
        m.checkNotNullParameter(text, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        m.checkNotNullParameter(authorName, "authorName");
        m.checkNotNullParameter(author, "author");
        return new MobileReportsViewModel$MessagePreview(text, authorName, authorNameColor, author, hasEmbeds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MobileReportsViewModel$MessagePreview)) {
            return false;
        }
        MobileReportsViewModel$MessagePreview mobileReportsViewModel$MessagePreview = (MobileReportsViewModel$MessagePreview) other;
        return m.areEqual(this.text, mobileReportsViewModel$MessagePreview.text) && m.areEqual(this.authorName, mobileReportsViewModel$MessagePreview.authorName) && this.authorNameColor == mobileReportsViewModel$MessagePreview.authorNameColor && m.areEqual(this.author, mobileReportsViewModel$MessagePreview.author) && this.hasEmbeds == mobileReportsViewModel$MessagePreview.hasEmbeds;
    }

    public final User getAuthor() {
        return this.author;
    }

    public final String getAuthorName() {
        return this.authorName;
    }

    public final int getAuthorNameColor() {
        return this.authorNameColor;
    }

    public final boolean getHasEmbeds() {
        return this.hasEmbeds;
    }

    public final DraweeSpanStringBuilder getText() {
        return this.text;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        DraweeSpanStringBuilder draweeSpanStringBuilder = this.text;
        int iHashCode = (draweeSpanStringBuilder != null ? draweeSpanStringBuilder.hashCode() : 0) * 31;
        String str = this.authorName;
        int iHashCode2 = (((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.authorNameColor) * 31;
        User user = this.author;
        int iHashCode3 = (iHashCode2 + (user != null ? user.hashCode() : 0)) * 31;
        boolean z2 = this.hasEmbeds;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode3 + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("MessagePreview(text=");
        sbU.append((Object) this.text);
        sbU.append(", authorName=");
        sbU.append(this.authorName);
        sbU.append(", authorNameColor=");
        sbU.append(this.authorNameColor);
        sbU.append(", author=");
        sbU.append(this.author);
        sbU.append(", hasEmbeds=");
        return a.O(sbU, this.hasEmbeds, ")");
    }

    public /* synthetic */ MobileReportsViewModel$MessagePreview(DraweeSpanStringBuilder draweeSpanStringBuilder, String str, int i, User user, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(draweeSpanStringBuilder, str, i, user, (i2 & 16) != 0 ? false : z2);
    }
}

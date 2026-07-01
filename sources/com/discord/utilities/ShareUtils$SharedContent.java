package com.discord.utilities;

import android.net.Uri;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ShareUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ShareUtils$SharedContent {
    private final CharSequence text;
    private final List<Uri> uris;

    /* JADX WARN: Multi-variable type inference failed */
    public ShareUtils$SharedContent(CharSequence charSequence, List<? extends Uri> list) {
        this.text = charSequence;
        this.uris = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShareUtils$SharedContent copy$default(ShareUtils$SharedContent shareUtils$SharedContent, CharSequence charSequence, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = shareUtils$SharedContent.text;
        }
        if ((i & 2) != 0) {
            list = shareUtils$SharedContent.uris;
        }
        return shareUtils$SharedContent.copy(charSequence, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CharSequence getText() {
        return this.text;
    }

    public final List<Uri> component2() {
        return this.uris;
    }

    public final ShareUtils$SharedContent copy(CharSequence text, List<? extends Uri> uris) {
        return new ShareUtils$SharedContent(text, uris);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShareUtils$SharedContent)) {
            return false;
        }
        ShareUtils$SharedContent shareUtils$SharedContent = (ShareUtils$SharedContent) other;
        return m.areEqual(this.text, shareUtils$SharedContent.text) && m.areEqual(this.uris, shareUtils$SharedContent.uris);
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final List<Uri> getUris() {
        return this.uris;
    }

    public int hashCode() {
        CharSequence charSequence = this.text;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        List<Uri> list = this.uris;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("SharedContent(text=");
        sbU.append(this.text);
        sbU.append(", uris=");
        return a.L(sbU, this.uris, ")");
    }
}

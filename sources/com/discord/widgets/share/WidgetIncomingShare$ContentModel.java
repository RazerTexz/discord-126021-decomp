package com.discord.widgets.share;

import android.net.Uri;
import androidx.appcompat.widget.ActivityChooserModel;
import b.d.b.a.a;
import com.discord.api.activity.Activity;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetIncomingShare$ContentModel {
    public static final WidgetIncomingShare$ContentModel$Companion Companion = new WidgetIncomingShare$ContentModel$Companion(null);
    private final Activity activity;
    private final Uri activityActionUri;
    private final Long preselectedRecipientChannel;
    private final String recipient;
    private final CharSequence sharedText;
    private final List<Uri> uris;

    public WidgetIncomingShare$ContentModel() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetIncomingShare$ContentModel(CharSequence charSequence, List<? extends Uri> list, Long l, String str, Uri uri, Activity activity) {
        this.sharedText = charSequence;
        this.uris = list;
        this.preselectedRecipientChannel = l;
        this.recipient = str;
        this.activityActionUri = uri;
        this.activity = activity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetIncomingShare$ContentModel copy$default(WidgetIncomingShare$ContentModel widgetIncomingShare$ContentModel, CharSequence charSequence, List list, Long l, String str, Uri uri, Activity activity, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = widgetIncomingShare$ContentModel.sharedText;
        }
        if ((i & 2) != 0) {
            list = widgetIncomingShare$ContentModel.uris;
        }
        List list2 = list;
        if ((i & 4) != 0) {
            l = widgetIncomingShare$ContentModel.preselectedRecipientChannel;
        }
        Long l2 = l;
        if ((i & 8) != 0) {
            str = widgetIncomingShare$ContentModel.recipient;
        }
        String str2 = str;
        if ((i & 16) != 0) {
            uri = widgetIncomingShare$ContentModel.activityActionUri;
        }
        Uri uri2 = uri;
        if ((i & 32) != 0) {
            activity = widgetIncomingShare$ContentModel.activity;
        }
        return widgetIncomingShare$ContentModel.copy(charSequence, list2, l2, str2, uri2, activity);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CharSequence getSharedText() {
        return this.sharedText;
    }

    public final List<Uri> component2() {
        return this.uris;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getPreselectedRecipientChannel() {
        return this.preselectedRecipientChannel;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getRecipient() {
        return this.recipient;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Uri getActivityActionUri() {
        return this.activityActionUri;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Activity getActivity() {
        return this.activity;
    }

    public final WidgetIncomingShare$ContentModel copy(CharSequence sharedText, List<? extends Uri> uris, Long preselectedRecipientChannel, String recipient, Uri activityActionUri, Activity activity) {
        return new WidgetIncomingShare$ContentModel(sharedText, uris, preselectedRecipientChannel, recipient, activityActionUri, activity);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetIncomingShare$ContentModel)) {
            return false;
        }
        WidgetIncomingShare$ContentModel widgetIncomingShare$ContentModel = (WidgetIncomingShare$ContentModel) other;
        return m.areEqual(this.sharedText, widgetIncomingShare$ContentModel.sharedText) && m.areEqual(this.uris, widgetIncomingShare$ContentModel.uris) && m.areEqual(this.preselectedRecipientChannel, widgetIncomingShare$ContentModel.preselectedRecipientChannel) && m.areEqual(this.recipient, widgetIncomingShare$ContentModel.recipient) && m.areEqual(this.activityActionUri, widgetIncomingShare$ContentModel.activityActionUri) && m.areEqual(this.activity, widgetIncomingShare$ContentModel.activity);
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final Uri getActivityActionUri() {
        return this.activityActionUri;
    }

    public final Long getPreselectedRecipientChannel() {
        return this.preselectedRecipientChannel;
    }

    public final String getRecipient() {
        return this.recipient;
    }

    public final CharSequence getSharedText() {
        return this.sharedText;
    }

    public final List<Uri> getUris() {
        return this.uris;
    }

    public int hashCode() {
        CharSequence charSequence = this.sharedText;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        List<Uri> list = this.uris;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        Long l = this.preselectedRecipientChannel;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        String str = this.recipient;
        int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        Uri uri = this.activityActionUri;
        int iHashCode5 = (iHashCode4 + (uri != null ? uri.hashCode() : 0)) * 31;
        Activity activity = this.activity;
        return iHashCode5 + (activity != null ? activity.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ContentModel(sharedText=");
        sbU.append(this.sharedText);
        sbU.append(", uris=");
        sbU.append(this.uris);
        sbU.append(", preselectedRecipientChannel=");
        sbU.append(this.preselectedRecipientChannel);
        sbU.append(", recipient=");
        sbU.append(this.recipient);
        sbU.append(", activityActionUri=");
        sbU.append(this.activityActionUri);
        sbU.append(", activity=");
        sbU.append(this.activity);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ WidgetIncomingShare$ContentModel(String str, List list, Long l, String str2, Uri uri, Activity activity, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : uri, (i & 32) == 0 ? activity : null);
    }
}

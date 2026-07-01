package com.discord.widgets.guilds.create;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildCreate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildCreate$Options implements Parcelable {
    public static final Parcelable$Creator<WidgetGuildCreate$Options> CREATOR = new WidgetGuildCreate$Options$Creator();
    private final String analyticsLocation;
    private final boolean closeWithResult;
    private final String customTitle;
    private final boolean showChannelPrompt;
    private final StockGuildTemplate template;

    public WidgetGuildCreate$Options(String str, StockGuildTemplate stockGuildTemplate, boolean z2, String str2, boolean z3) {
        m.checkNotNullParameter(str, "analyticsLocation");
        m.checkNotNullParameter(stockGuildTemplate, "template");
        this.analyticsLocation = str;
        this.template = stockGuildTemplate;
        this.showChannelPrompt = z2;
        this.customTitle = str2;
        this.closeWithResult = z3;
    }

    public static /* synthetic */ WidgetGuildCreate$Options copy$default(WidgetGuildCreate$Options widgetGuildCreate$Options, String str, StockGuildTemplate stockGuildTemplate, boolean z2, String str2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetGuildCreate$Options.analyticsLocation;
        }
        if ((i & 2) != 0) {
            stockGuildTemplate = widgetGuildCreate$Options.template;
        }
        StockGuildTemplate stockGuildTemplate2 = stockGuildTemplate;
        if ((i & 4) != 0) {
            z2 = widgetGuildCreate$Options.showChannelPrompt;
        }
        boolean z4 = z2;
        if ((i & 8) != 0) {
            str2 = widgetGuildCreate$Options.customTitle;
        }
        String str3 = str2;
        if ((i & 16) != 0) {
            z3 = widgetGuildCreate$Options.closeWithResult;
        }
        return widgetGuildCreate$Options.copy(str, stockGuildTemplate2, z4, str3, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAnalyticsLocation() {
        return this.analyticsLocation;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StockGuildTemplate getTemplate() {
        return this.template;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getShowChannelPrompt() {
        return this.showChannelPrompt;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCustomTitle() {
        return this.customTitle;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getCloseWithResult() {
        return this.closeWithResult;
    }

    public final WidgetGuildCreate$Options copy(String analyticsLocation, StockGuildTemplate template, boolean showChannelPrompt, String customTitle, boolean closeWithResult) {
        m.checkNotNullParameter(analyticsLocation, "analyticsLocation");
        m.checkNotNullParameter(template, "template");
        return new WidgetGuildCreate$Options(analyticsLocation, template, showChannelPrompt, customTitle, closeWithResult);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildCreate$Options)) {
            return false;
        }
        WidgetGuildCreate$Options widgetGuildCreate$Options = (WidgetGuildCreate$Options) other;
        return m.areEqual(this.analyticsLocation, widgetGuildCreate$Options.analyticsLocation) && m.areEqual(this.template, widgetGuildCreate$Options.template) && this.showChannelPrompt == widgetGuildCreate$Options.showChannelPrompt && m.areEqual(this.customTitle, widgetGuildCreate$Options.customTitle) && this.closeWithResult == widgetGuildCreate$Options.closeWithResult;
    }

    public final String getAnalyticsLocation() {
        return this.analyticsLocation;
    }

    public final boolean getCloseWithResult() {
        return this.closeWithResult;
    }

    public final String getCustomTitle() {
        return this.customTitle;
    }

    public final boolean getShowChannelPrompt() {
        return this.showChannelPrompt;
    }

    public final StockGuildTemplate getTemplate() {
        return this.template;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String str = this.analyticsLocation;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        StockGuildTemplate stockGuildTemplate = this.template;
        int iHashCode2 = (iHashCode + (stockGuildTemplate != null ? stockGuildTemplate.hashCode() : 0)) * 31;
        boolean z2 = this.showChannelPrompt;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode2 + r2) * 31;
        String str2 = this.customTitle;
        int iHashCode3 = (i + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z3 = this.closeWithResult;
        return iHashCode3 + (z3 ? 1 : z3);
    }

    public String toString() {
        StringBuilder sbU = a.U("Options(analyticsLocation=");
        sbU.append(this.analyticsLocation);
        sbU.append(", template=");
        sbU.append(this.template);
        sbU.append(", showChannelPrompt=");
        sbU.append(this.showChannelPrompt);
        sbU.append(", customTitle=");
        sbU.append(this.customTitle);
        sbU.append(", closeWithResult=");
        return a.O(sbU, this.closeWithResult, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.analyticsLocation);
        parcel.writeString(this.template.name());
        parcel.writeInt(this.showChannelPrompt ? 1 : 0);
        parcel.writeString(this.customTitle);
        parcel.writeInt(this.closeWithResult ? 1 : 0);
    }

    public /* synthetic */ WidgetGuildCreate$Options(String str, StockGuildTemplate stockGuildTemplate, boolean z2, String str2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? StockGuildTemplate.CREATE : stockGuildTemplate, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? false : z3);
    }
}

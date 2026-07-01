package com.discord.widgets.nux;

import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.widgets.nux.GuildTemplateArgs, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildTemplates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildTemplates3 implements Parcelable {
    public static final Parcelable.Creator<WidgetGuildTemplates3> CREATOR = new Creator();
    private final boolean showInvitePrompt;
    private final boolean skipCreationIntent;
    private final String subtitle;
    private final List<GuildTemplates> templates;
    private final String title;

    /* JADX INFO: renamed from: com.discord.widgets.nux.GuildTemplateArgs$Creator */
    public static class Creator implements Parcelable.Creator<WidgetGuildTemplates3> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetGuildTemplates3 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            while (i != 0) {
                arrayList.add((GuildTemplates) Enum.valueOf(GuildTemplates.class, parcel.readString()));
                i--;
            }
            return new WidgetGuildTemplates3(string, string2, arrayList, parcel.readInt() != 0, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetGuildTemplates3[] newArray(int i) {
            return new WidgetGuildTemplates3[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetGuildTemplates3(String str, String str2, List<? extends GuildTemplates> list, boolean z2, boolean z3) {
        Intrinsics3.checkNotNullParameter(str, "title");
        Intrinsics3.checkNotNullParameter(str2, "subtitle");
        Intrinsics3.checkNotNullParameter(list, "templates");
        this.title = str;
        this.subtitle = str2;
        this.templates = list;
        this.showInvitePrompt = z2;
        this.skipCreationIntent = z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetGuildTemplates3 copy$default(WidgetGuildTemplates3 widgetGuildTemplates3, String str, String str2, List list, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetGuildTemplates3.title;
        }
        if ((i & 2) != 0) {
            str2 = widgetGuildTemplates3.subtitle;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            list = widgetGuildTemplates3.templates;
        }
        List list2 = list;
        if ((i & 8) != 0) {
            z2 = widgetGuildTemplates3.showInvitePrompt;
        }
        boolean z4 = z2;
        if ((i & 16) != 0) {
            z3 = widgetGuildTemplates3.skipCreationIntent;
        }
        return widgetGuildTemplates3.copy(str, str3, list2, z4, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    public final List<GuildTemplates> component3() {
        return this.templates;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getShowInvitePrompt() {
        return this.showInvitePrompt;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getSkipCreationIntent() {
        return this.skipCreationIntent;
    }

    public final WidgetGuildTemplates3 copy(String title, String subtitle, List<? extends GuildTemplates> templates, boolean showInvitePrompt, boolean skipCreationIntent) {
        Intrinsics3.checkNotNullParameter(title, "title");
        Intrinsics3.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics3.checkNotNullParameter(templates, "templates");
        return new WidgetGuildTemplates3(title, subtitle, templates, showInvitePrompt, skipCreationIntent);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildTemplates3)) {
            return false;
        }
        WidgetGuildTemplates3 widgetGuildTemplates3 = (WidgetGuildTemplates3) other;
        return Intrinsics3.areEqual(this.title, widgetGuildTemplates3.title) && Intrinsics3.areEqual(this.subtitle, widgetGuildTemplates3.subtitle) && Intrinsics3.areEqual(this.templates, widgetGuildTemplates3.templates) && this.showInvitePrompt == widgetGuildTemplates3.showInvitePrompt && this.skipCreationIntent == widgetGuildTemplates3.skipCreationIntent;
    }

    public final boolean getShowInvitePrompt() {
        return this.showInvitePrompt;
    }

    public final boolean getSkipCreationIntent() {
        return this.skipCreationIntent;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final List<GuildTemplates> getTemplates() {
        return this.templates;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    public int hashCode() {
        String str = this.title;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.subtitle;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<GuildTemplates> list = this.templates;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.showInvitePrompt;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode3 + r1) * 31;
        boolean z3 = this.skipCreationIntent;
        return i + (z3 ? 1 : z3);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildTemplateArgs(title=");
        sbU.append(this.title);
        sbU.append(", subtitle=");
        sbU.append(this.subtitle);
        sbU.append(", templates=");
        sbU.append(this.templates);
        sbU.append(", showInvitePrompt=");
        sbU.append(this.showInvitePrompt);
        sbU.append(", skipCreationIntent=");
        return outline.O(sbU, this.skipCreationIntent, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        List<GuildTemplates> list = this.templates;
        parcel.writeInt(list.size());
        Iterator<GuildTemplates> it = list.iterator();
        while (it.hasNext()) {
            parcel.writeString(it.next().name());
        }
        parcel.writeInt(this.showInvitePrompt ? 1 : 0);
        parcel.writeInt(this.skipCreationIntent ? 1 : 0);
    }

    public /* synthetic */ WidgetGuildTemplates3(String str, String str2, List list, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? GuildTemplates2.INSTANCE.getNUX() : list, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? false : z3);
    }
}

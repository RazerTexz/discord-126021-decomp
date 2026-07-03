package com.discord.widgets.nux;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildTemplates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildTemplateArgs implements Parcelable {
    public static final Parcelable.Creator<GuildTemplateArgs> CREATOR = new Creator();
    private final boolean showInvitePrompt;
    private final boolean skipCreationIntent;
    private final String subtitle;
    private final List<GuildTemplate> templates;
    private final String title;

    public static class Creator implements Parcelable.Creator<GuildTemplateArgs> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GuildTemplateArgs createFromParcel(Parcel parcel) {
            C12238m.checkNotNullParameter(parcel, "in");
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            while (i != 0) {
                arrayList.add((GuildTemplate) Enum.valueOf(GuildTemplate.class, parcel.readString()));
                i--;
            }
            return new GuildTemplateArgs(string, string2, arrayList, parcel.readInt() != 0, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GuildTemplateArgs[] newArray(int i) {
            return new GuildTemplateArgs[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuildTemplateArgs(String str, String str2, List<? extends GuildTemplate> list, boolean z2, boolean z3) {
        C12238m.checkNotNullParameter(str, "title");
        C12238m.checkNotNullParameter(str2, "subtitle");
        C12238m.checkNotNullParameter(list, "templates");
        this.title = str;
        this.subtitle = str2;
        this.templates = list;
        this.showInvitePrompt = z2;
        this.skipCreationIntent = z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildTemplateArgs copy$default(GuildTemplateArgs guildTemplateArgs, String str, String str2, List list, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = guildTemplateArgs.title;
        }
        if ((i & 2) != 0) {
            str2 = guildTemplateArgs.subtitle;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            list = guildTemplateArgs.templates;
        }
        List list2 = list;
        if ((i & 8) != 0) {
            z2 = guildTemplateArgs.showInvitePrompt;
        }
        boolean z4 = z2;
        if ((i & 16) != 0) {
            z3 = guildTemplateArgs.skipCreationIntent;
        }
        return guildTemplateArgs.copy(str, str3, list2, z4, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    public final List<GuildTemplate> component3() {
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

    public final GuildTemplateArgs copy(String title, String subtitle, List<? extends GuildTemplate> templates, boolean showInvitePrompt, boolean skipCreationIntent) {
        C12238m.checkNotNullParameter(title, "title");
        C12238m.checkNotNullParameter(subtitle, "subtitle");
        C12238m.checkNotNullParameter(templates, "templates");
        return new GuildTemplateArgs(title, subtitle, templates, showInvitePrompt, skipCreationIntent);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildTemplateArgs)) {
            return false;
        }
        GuildTemplateArgs guildTemplateArgs = (GuildTemplateArgs) other;
        return C12238m.areEqual(this.title, guildTemplateArgs.title) && C12238m.areEqual(this.subtitle, guildTemplateArgs.subtitle) && C12238m.areEqual(this.templates, guildTemplateArgs.templates) && this.showInvitePrompt == guildTemplateArgs.showInvitePrompt && this.skipCreationIntent == guildTemplateArgs.skipCreationIntent;
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

    public final List<GuildTemplate> getTemplates() {
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
        List<GuildTemplate> list = this.templates;
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
        StringBuilder sbM833U = C1643a.m833U("GuildTemplateArgs(title=");
        sbM833U.append(this.title);
        sbM833U.append(", subtitle=");
        sbM833U.append(this.subtitle);
        sbM833U.append(", templates=");
        sbM833U.append(this.templates);
        sbM833U.append(", showInvitePrompt=");
        sbM833U.append(this.showInvitePrompt);
        sbM833U.append(", skipCreationIntent=");
        return C1643a.m827O(sbM833U, this.skipCreationIntent, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        C12238m.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        List<GuildTemplate> list = this.templates;
        parcel.writeInt(list.size());
        Iterator<GuildTemplate> it = list.iterator();
        while (it.hasNext()) {
            parcel.writeString(it.next().name());
        }
        parcel.writeInt(this.showInvitePrompt ? 1 : 0);
        parcel.writeInt(this.skipCreationIntent ? 1 : 0);
    }

    public /* synthetic */ GuildTemplateArgs(String str, String str2, List list, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? GuildTemplateTypes.INSTANCE.getNUX() : list, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? false : z3);
    }
}

package com.discord.widgets.nux;

import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.guilds.create.CreateGuildTrigger;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.widgets.nux.GuildCreateArgs, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildTemplates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildTemplates2 implements Parcelable {
    public static final Parcelable.Creator<WidgetGuildTemplates2> CREATOR = new Creator();
    private final boolean closeWithResult;
    private final WidgetGuildTemplates3 guildTemplate;
    private final boolean isNux;
    private final String location;
    private final CreateGuildTrigger trigger;

    /* JADX INFO: renamed from: com.discord.widgets.nux.GuildCreateArgs$Creator */
    public static class Creator implements Parcelable.Creator<WidgetGuildTemplates2> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetGuildTemplates2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetGuildTemplates2(parcel.readInt() != 0, parcel.readString(), (CreateGuildTrigger) Enum.valueOf(CreateGuildTrigger.class, parcel.readString()), WidgetGuildTemplates3.CREATOR.createFromParcel(parcel), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetGuildTemplates2[] newArray(int i) {
            return new WidgetGuildTemplates2[i];
        }
    }

    public WidgetGuildTemplates2(boolean z2, String str, CreateGuildTrigger createGuildTrigger, WidgetGuildTemplates3 widgetGuildTemplates3, boolean z3) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        Intrinsics3.checkNotNullParameter(createGuildTrigger, "trigger");
        Intrinsics3.checkNotNullParameter(widgetGuildTemplates3, "guildTemplate");
        this.isNux = z2;
        this.location = str;
        this.trigger = createGuildTrigger;
        this.guildTemplate = widgetGuildTemplates3;
        this.closeWithResult = z3;
    }

    public static /* synthetic */ WidgetGuildTemplates2 copy$default(WidgetGuildTemplates2 widgetGuildTemplates2, boolean z2, String str, CreateGuildTrigger createGuildTrigger, WidgetGuildTemplates3 widgetGuildTemplates3, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = widgetGuildTemplates2.isNux;
        }
        if ((i & 2) != 0) {
            str = widgetGuildTemplates2.location;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            createGuildTrigger = widgetGuildTemplates2.trigger;
        }
        CreateGuildTrigger createGuildTrigger2 = createGuildTrigger;
        if ((i & 8) != 0) {
            widgetGuildTemplates3 = widgetGuildTemplates2.guildTemplate;
        }
        WidgetGuildTemplates3 widgetGuildTemplates4 = widgetGuildTemplates3;
        if ((i & 16) != 0) {
            z3 = widgetGuildTemplates2.closeWithResult;
        }
        return widgetGuildTemplates2.copy(z2, str2, createGuildTrigger2, widgetGuildTemplates4, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsNux() {
        return this.isNux;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final CreateGuildTrigger getTrigger() {
        return this.trigger;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final WidgetGuildTemplates3 getGuildTemplate() {
        return this.guildTemplate;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getCloseWithResult() {
        return this.closeWithResult;
    }

    public final WidgetGuildTemplates2 copy(boolean isNux, String location, CreateGuildTrigger trigger, WidgetGuildTemplates3 guildTemplate, boolean closeWithResult) {
        Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        Intrinsics3.checkNotNullParameter(trigger, "trigger");
        Intrinsics3.checkNotNullParameter(guildTemplate, "guildTemplate");
        return new WidgetGuildTemplates2(isNux, location, trigger, guildTemplate, closeWithResult);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildTemplates2)) {
            return false;
        }
        WidgetGuildTemplates2 widgetGuildTemplates2 = (WidgetGuildTemplates2) other;
        return this.isNux == widgetGuildTemplates2.isNux && Intrinsics3.areEqual(this.location, widgetGuildTemplates2.location) && Intrinsics3.areEqual(this.trigger, widgetGuildTemplates2.trigger) && Intrinsics3.areEqual(this.guildTemplate, widgetGuildTemplates2.guildTemplate) && this.closeWithResult == widgetGuildTemplates2.closeWithResult;
    }

    public final boolean getCloseWithResult() {
        return this.closeWithResult;
    }

    public final WidgetGuildTemplates3 getGuildTemplate() {
        return this.guildTemplate;
    }

    public final String getLocation() {
        return this.location;
    }

    public final CreateGuildTrigger getTrigger() {
        return this.trigger;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean z2 = this.isNux;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        String str = this.location;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        CreateGuildTrigger createGuildTrigger = this.trigger;
        int iHashCode2 = (iHashCode + (createGuildTrigger != null ? createGuildTrigger.hashCode() : 0)) * 31;
        WidgetGuildTemplates3 widgetGuildTemplates3 = this.guildTemplate;
        int iHashCode3 = (iHashCode2 + (widgetGuildTemplates3 != null ? widgetGuildTemplates3.hashCode() : 0)) * 31;
        boolean z3 = this.closeWithResult;
        return iHashCode3 + (z3 ? 1 : z3);
    }

    public final boolean isNux() {
        return this.isNux;
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildCreateArgs(isNux=");
        sbU.append(this.isNux);
        sbU.append(", location=");
        sbU.append(this.location);
        sbU.append(", trigger=");
        sbU.append(this.trigger);
        sbU.append(", guildTemplate=");
        sbU.append(this.guildTemplate);
        sbU.append(", closeWithResult=");
        return outline.O(sbU, this.closeWithResult, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.isNux ? 1 : 0);
        parcel.writeString(this.location);
        parcel.writeString(this.trigger.name());
        this.guildTemplate.writeToParcel(parcel, 0);
        parcel.writeInt(this.closeWithResult ? 1 : 0);
    }

    public /* synthetic */ WidgetGuildTemplates2(boolean z2, String str, CreateGuildTrigger createGuildTrigger, WidgetGuildTemplates3 widgetGuildTemplates3, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, str, createGuildTrigger, widgetGuildTemplates3, (i & 16) != 0 ? false : z3);
    }
}

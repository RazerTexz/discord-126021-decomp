package com.discord.widgets.nux;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.guilds.create.CreateGuildTrigger;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildTemplates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildCreateArgs implements Parcelable {
    public static final Parcelable$Creator<GuildCreateArgs> CREATOR = new GuildCreateArgs$Creator();
    private final boolean closeWithResult;
    private final GuildTemplateArgs guildTemplate;
    private final boolean isNux;
    private final String location;
    private final CreateGuildTrigger trigger;

    public GuildCreateArgs(boolean z2, String str, CreateGuildTrigger createGuildTrigger, GuildTemplateArgs guildTemplateArgs, boolean z3) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        m.checkNotNullParameter(createGuildTrigger, "trigger");
        m.checkNotNullParameter(guildTemplateArgs, "guildTemplate");
        this.isNux = z2;
        this.location = str;
        this.trigger = createGuildTrigger;
        this.guildTemplate = guildTemplateArgs;
        this.closeWithResult = z3;
    }

    public static /* synthetic */ GuildCreateArgs copy$default(GuildCreateArgs guildCreateArgs, boolean z2, String str, CreateGuildTrigger createGuildTrigger, GuildTemplateArgs guildTemplateArgs, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = guildCreateArgs.isNux;
        }
        if ((i & 2) != 0) {
            str = guildCreateArgs.location;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            createGuildTrigger = guildCreateArgs.trigger;
        }
        CreateGuildTrigger createGuildTrigger2 = createGuildTrigger;
        if ((i & 8) != 0) {
            guildTemplateArgs = guildCreateArgs.guildTemplate;
        }
        GuildTemplateArgs guildTemplateArgs2 = guildTemplateArgs;
        if ((i & 16) != 0) {
            z3 = guildCreateArgs.closeWithResult;
        }
        return guildCreateArgs.copy(z2, str2, createGuildTrigger2, guildTemplateArgs2, z3);
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
    public final GuildTemplateArgs getGuildTemplate() {
        return this.guildTemplate;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getCloseWithResult() {
        return this.closeWithResult;
    }

    public final GuildCreateArgs copy(boolean isNux, String location, CreateGuildTrigger trigger, GuildTemplateArgs guildTemplate, boolean closeWithResult) {
        m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        m.checkNotNullParameter(trigger, "trigger");
        m.checkNotNullParameter(guildTemplate, "guildTemplate");
        return new GuildCreateArgs(isNux, location, trigger, guildTemplate, closeWithResult);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildCreateArgs)) {
            return false;
        }
        GuildCreateArgs guildCreateArgs = (GuildCreateArgs) other;
        return this.isNux == guildCreateArgs.isNux && m.areEqual(this.location, guildCreateArgs.location) && m.areEqual(this.trigger, guildCreateArgs.trigger) && m.areEqual(this.guildTemplate, guildCreateArgs.guildTemplate) && this.closeWithResult == guildCreateArgs.closeWithResult;
    }

    public final boolean getCloseWithResult() {
        return this.closeWithResult;
    }

    public final GuildTemplateArgs getGuildTemplate() {
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
        GuildTemplateArgs guildTemplateArgs = this.guildTemplate;
        int iHashCode3 = (iHashCode2 + (guildTemplateArgs != null ? guildTemplateArgs.hashCode() : 0)) * 31;
        boolean z3 = this.closeWithResult;
        return iHashCode3 + (z3 ? 1 : z3);
    }

    public final boolean isNux() {
        return this.isNux;
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildCreateArgs(isNux=");
        sbU.append(this.isNux);
        sbU.append(", location=");
        sbU.append(this.location);
        sbU.append(", trigger=");
        sbU.append(this.trigger);
        sbU.append(", guildTemplate=");
        sbU.append(this.guildTemplate);
        sbU.append(", closeWithResult=");
        return a.O(sbU, this.closeWithResult, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.isNux ? 1 : 0);
        parcel.writeString(this.location);
        parcel.writeString(this.trigger.name());
        this.guildTemplate.writeToParcel(parcel, 0);
        parcel.writeInt(this.closeWithResult ? 1 : 0);
    }

    public /* synthetic */ GuildCreateArgs(boolean z2, String str, CreateGuildTrigger createGuildTrigger, GuildTemplateArgs guildTemplateArgs, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, str, createGuildTrigger, guildTemplateArgs, (i & 16) != 0 ? false : z3);
    }
}

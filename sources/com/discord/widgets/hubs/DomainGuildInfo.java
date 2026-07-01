package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetHubDomains.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DomainGuildInfo implements Parcelable {
    private final String icon;
    private final long id;
    private final String name;
    public static final DomainGuildInfo$Companion Companion = new DomainGuildInfo$Companion(null);
    public static final Parcelable$Creator<DomainGuildInfo> CREATOR = new DomainGuildInfo$Creator();

    public DomainGuildInfo(String str, long j, String str2) {
        m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.icon = str;
        this.id = j;
        this.name = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.icon);
        parcel.writeLong(this.id);
        parcel.writeString(this.name);
    }
}

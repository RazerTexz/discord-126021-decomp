package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import com.discord.api.hubs.GuildInfo;
import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubDomains.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DomainGuildInfo implements Parcelable {
    private final String icon;
    private final long id;
    private final String name;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<DomainGuildInfo> CREATOR = new Creator();

    /* JADX INFO: compiled from: WidgetHubDomains.kt */
    public static final class Companion {
        private Companion() {
        }

        public final DomainGuildInfo from(GuildInfo guildInfo) {
            C12238m.checkNotNullParameter(guildInfo, "guildInfo");
            return new DomainGuildInfo(guildInfo.getIcon(), guildInfo.getId(), guildInfo.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static class Creator implements Parcelable.Creator<DomainGuildInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DomainGuildInfo createFromParcel(Parcel parcel) {
            C12238m.checkNotNullParameter(parcel, "in");
            return new DomainGuildInfo(parcel.readString(), parcel.readLong(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DomainGuildInfo[] newArray(int i) {
            return new DomainGuildInfo[i];
        }
    }

    public DomainGuildInfo(String str, long j, String str2) {
        C12238m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
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
        C12238m.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.icon);
        parcel.writeLong(this.id);
        parcel.writeString(this.name);
    }
}

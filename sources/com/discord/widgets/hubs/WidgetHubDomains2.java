package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import com.discord.api.hubs.EmailVerification3;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.widgets.hubs.DomainGuildInfo, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubDomains.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDomains2 implements Parcelable {
    private final String icon;
    private final long id;
    private final String name;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<WidgetHubDomains2> CREATOR = new Creator();

    /* JADX INFO: renamed from: com.discord.widgets.hubs.DomainGuildInfo$Companion, reason: from kotlin metadata */
    /* JADX INFO: compiled from: WidgetHubDomains.kt */
    public static final class Companion {
        private Companion() {
        }

        public final WidgetHubDomains2 from(EmailVerification3 guildInfo) {
            Intrinsics3.checkNotNullParameter(guildInfo, "guildInfo");
            return new WidgetHubDomains2(guildInfo.getIcon(), guildInfo.getId(), guildInfo.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.DomainGuildInfo$Creator */
    public static class Creator implements Parcelable.Creator<WidgetHubDomains2> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubDomains2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetHubDomains2(parcel.readString(), parcel.readLong(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubDomains2[] newArray(int i) {
            return new WidgetHubDomains2[i];
        }
    }

    public WidgetHubDomains2(String str, long j, String str2) {
        Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
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
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.icon);
        parcel.writeLong(this.id);
        parcel.writeString(this.name);
    }
}

package com.discord.widgets.directories;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.directories.DirectoriesSearchArgs, reason: use source file name */
/* JADX INFO: compiled from: WidgetDirectoriesSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetDirectoriesSearch2 implements Parcelable {
    public static final Parcelable.Creator<WidgetDirectoriesSearch2> CREATOR = new Creator();
    private final long channelId;

    /* JADX INFO: renamed from: com.discord.widgets.directories.DirectoriesSearchArgs$Creator */
    public static class Creator implements Parcelable.Creator<WidgetDirectoriesSearch2> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetDirectoriesSearch2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetDirectoriesSearch2(parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetDirectoriesSearch2[] newArray(int i) {
            return new WidgetDirectoriesSearch2[i];
        }
    }

    public WidgetDirectoriesSearch2(long j) {
        this.channelId = j;
    }

    public static /* synthetic */ WidgetDirectoriesSearch2 copy$default(WidgetDirectoriesSearch2 widgetDirectoriesSearch2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetDirectoriesSearch2.channelId;
        }
        return widgetDirectoriesSearch2.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    public final WidgetDirectoriesSearch2 copy(long channelId) {
        return new WidgetDirectoriesSearch2(channelId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetDirectoriesSearch2) && this.channelId == ((WidgetDirectoriesSearch2) other).channelId;
        }
        return true;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public int hashCode() {
        return b.a(this.channelId);
    }

    public String toString() {
        return outline.C(outline.U("DirectoriesSearchArgs(channelId="), this.channelId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.channelId);
    }
}

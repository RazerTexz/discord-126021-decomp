package com.discord.widgets.directories;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetDirectoriesSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class DirectoriesSearchArgs implements Parcelable {
    public static final Parcelable$Creator<DirectoriesSearchArgs> CREATOR = new DirectoriesSearchArgs$Creator();
    private final long channelId;

    public DirectoriesSearchArgs(long j) {
        this.channelId = j;
    }

    public static /* synthetic */ DirectoriesSearchArgs copy$default(DirectoriesSearchArgs directoriesSearchArgs, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = directoriesSearchArgs.channelId;
        }
        return directoriesSearchArgs.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    public final DirectoriesSearchArgs copy(long channelId) {
        return new DirectoriesSearchArgs(channelId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof DirectoriesSearchArgs) && this.channelId == ((DirectoriesSearchArgs) other).channelId;
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
        return a.C(a.U("DirectoriesSearchArgs(channelId="), this.channelId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.channelId);
    }
}

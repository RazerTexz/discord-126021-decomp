package com.discord.widgets.directories;

import android.os.Parcel;
import android.os.Parcelable;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetDirectoriesSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class DirectoriesSearchArgs implements Parcelable {
    public static final Parcelable.Creator<DirectoriesSearchArgs> CREATOR = new Creator();
    private final long channelId;

    public static class Creator implements Parcelable.Creator<DirectoriesSearchArgs> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DirectoriesSearchArgs createFromParcel(Parcel parcel) {
            C12238m.checkNotNullParameter(parcel, "in");
            return new DirectoriesSearchArgs(parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DirectoriesSearchArgs[] newArray(int i) {
            return new DirectoriesSearchArgs[i];
        }
    }

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
        return C0002b.m3a(this.channelId);
    }

    public String toString() {
        return C1643a.m815C(C1643a.m833U("DirectoriesSearchArgs(channelId="), this.channelId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        C12238m.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.channelId);
    }
}

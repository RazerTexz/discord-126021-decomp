package com.discord.widgets.directories;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import b.d.b.a.a;
import com.discord.models.hubs.DirectoryEntryCategory;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetDirectoryCategory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class DirectoryCategoryArgs implements Parcelable {
    public static final Parcelable$Creator<DirectoryCategoryArgs> CREATOR = new DirectoryCategoryArgs$Creator();
    private final DirectoryEntryCategory directoryCategory;

    public DirectoryCategoryArgs(DirectoryEntryCategory directoryEntryCategory) {
        m.checkNotNullParameter(directoryEntryCategory, "directoryCategory");
        this.directoryCategory = directoryEntryCategory;
    }

    public static /* synthetic */ DirectoryCategoryArgs copy$default(DirectoryCategoryArgs directoryCategoryArgs, DirectoryEntryCategory directoryEntryCategory, int i, Object obj) {
        if ((i & 1) != 0) {
            directoryEntryCategory = directoryCategoryArgs.directoryCategory;
        }
        return directoryCategoryArgs.copy(directoryEntryCategory);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final DirectoryEntryCategory getDirectoryCategory() {
        return this.directoryCategory;
    }

    public final DirectoryCategoryArgs copy(DirectoryEntryCategory directoryCategory) {
        m.checkNotNullParameter(directoryCategory, "directoryCategory");
        return new DirectoryCategoryArgs(directoryCategory);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof DirectoryCategoryArgs) && m.areEqual(this.directoryCategory, ((DirectoryCategoryArgs) other).directoryCategory);
        }
        return true;
    }

    public final DirectoryEntryCategory getDirectoryCategory() {
        return this.directoryCategory;
    }

    public int hashCode() {
        DirectoryEntryCategory directoryEntryCategory = this.directoryCategory;
        if (directoryEntryCategory != null) {
            return directoryEntryCategory.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("DirectoryCategoryArgs(directoryCategory=");
        sbU.append(this.directoryCategory);
        sbU.append(")");
        return sbU.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.directoryCategory.name());
    }
}

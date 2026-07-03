package com.discord.widgets.directories;

import android.os.Parcel;
import android.os.Parcelable;
import com.discord.models.hubs.DirectoryEntryCategory;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetDirectoryCategory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class DirectoryCategoryArgs implements Parcelable {
    public static final Parcelable.Creator<DirectoryCategoryArgs> CREATOR = new Creator();
    private final DirectoryEntryCategory directoryCategory;

    public static class Creator implements Parcelable.Creator<DirectoryCategoryArgs> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DirectoryCategoryArgs createFromParcel(Parcel parcel) {
            C12238m.checkNotNullParameter(parcel, "in");
            return new DirectoryCategoryArgs((DirectoryEntryCategory) Enum.valueOf(DirectoryEntryCategory.class, parcel.readString()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DirectoryCategoryArgs[] newArray(int i) {
            return new DirectoryCategoryArgs[i];
        }
    }

    public DirectoryCategoryArgs(DirectoryEntryCategory directoryEntryCategory) {
        C12238m.checkNotNullParameter(directoryEntryCategory, "directoryCategory");
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
        C12238m.checkNotNullParameter(directoryCategory, "directoryCategory");
        return new DirectoryCategoryArgs(directoryCategory);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof DirectoryCategoryArgs) && C12238m.areEqual(this.directoryCategory, ((DirectoryCategoryArgs) other).directoryCategory);
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
        StringBuilder sbM833U = C1643a.m833U("DirectoryCategoryArgs(directoryCategory=");
        sbM833U.append(this.directoryCategory);
        sbM833U.append(")");
        return sbM833U.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        C12238m.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.directoryCategory.name());
    }
}

package com.discord.widgets.directories;

import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import com.discord.models.hubs.DirectoryEntryCategory;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.directories.DirectoryCategoryArgs, reason: use source file name */
/* JADX INFO: compiled from: WidgetDirectoryCategory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetDirectoryCategory2 implements Parcelable {
    public static final Parcelable.Creator<WidgetDirectoryCategory2> CREATOR = new Creator();
    private final DirectoryEntryCategory directoryCategory;

    /* JADX INFO: renamed from: com.discord.widgets.directories.DirectoryCategoryArgs$Creator */
    public static class Creator implements Parcelable.Creator<WidgetDirectoryCategory2> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetDirectoryCategory2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetDirectoryCategory2((DirectoryEntryCategory) Enum.valueOf(DirectoryEntryCategory.class, parcel.readString()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetDirectoryCategory2[] newArray(int i) {
            return new WidgetDirectoryCategory2[i];
        }
    }

    public WidgetDirectoryCategory2(DirectoryEntryCategory directoryEntryCategory) {
        Intrinsics3.checkNotNullParameter(directoryEntryCategory, "directoryCategory");
        this.directoryCategory = directoryEntryCategory;
    }

    public static /* synthetic */ WidgetDirectoryCategory2 copy$default(WidgetDirectoryCategory2 widgetDirectoryCategory2, DirectoryEntryCategory directoryEntryCategory, int i, Object obj) {
        if ((i & 1) != 0) {
            directoryEntryCategory = widgetDirectoryCategory2.directoryCategory;
        }
        return widgetDirectoryCategory2.copy(directoryEntryCategory);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final DirectoryEntryCategory getDirectoryCategory() {
        return this.directoryCategory;
    }

    public final WidgetDirectoryCategory2 copy(DirectoryEntryCategory directoryCategory) {
        Intrinsics3.checkNotNullParameter(directoryCategory, "directoryCategory");
        return new WidgetDirectoryCategory2(directoryCategory);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetDirectoryCategory2) && Intrinsics3.areEqual(this.directoryCategory, ((WidgetDirectoryCategory2) other).directoryCategory);
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
        StringBuilder sbU = outline.U("DirectoryCategoryArgs(directoryCategory=");
        sbU.append(this.directoryCategory);
        sbU.append(")");
        return sbU.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.directoryCategory.name());
    }
}

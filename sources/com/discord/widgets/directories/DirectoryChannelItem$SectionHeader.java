package com.discord.widgets.directories;

import androidx.annotation.StringRes;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetDirectoryEntryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class DirectoryChannelItem$SectionHeader extends DirectoryChannelItem {
    private final int textRes;

    public DirectoryChannelItem$SectionHeader(@StringRes int i) {
        super(DirectoryChannelItem$ViewType.SectionHeader, null);
        this.textRes = i;
    }

    public static /* synthetic */ DirectoryChannelItem$SectionHeader copy$default(DirectoryChannelItem$SectionHeader directoryChannelItem$SectionHeader, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = directoryChannelItem$SectionHeader.textRes;
        }
        return directoryChannelItem$SectionHeader.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTextRes() {
        return this.textRes;
    }

    public final DirectoryChannelItem$SectionHeader copy(@StringRes int textRes) {
        return new DirectoryChannelItem$SectionHeader(textRes);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof DirectoryChannelItem$SectionHeader) && this.textRes == ((DirectoryChannelItem$SectionHeader) other).textRes;
        }
        return true;
    }

    public final int getTextRes() {
        return this.textRes;
    }

    public int hashCode() {
        return this.textRes;
    }

    public String toString() {
        return a.B(a.U("SectionHeader(textRes="), this.textRes, ")");
    }
}

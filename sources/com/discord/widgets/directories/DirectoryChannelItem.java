package com.discord.widgets.directories;

import androidx.annotation.StringRes;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetDirectoryEntryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class DirectoryChannelItem {
    private final ViewType viewType;

    /* JADX INFO: compiled from: WidgetDirectoryEntryViewHolder.kt */
    public static final class AddServer extends DirectoryChannelItem {
        public static final AddServer INSTANCE = new AddServer();

        private AddServer() {
            super(ViewType.AddServer, null);
        }
    }

    /* JADX INFO: compiled from: WidgetDirectoryEntryViewHolder.kt */
    public static final /* data */ class DirectoryItem extends DirectoryChannelItem {
        private final DirectoryEntryData directoryEntryData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DirectoryItem(DirectoryEntryData directoryEntryData) {
            super(ViewType.Item, null);
            Intrinsics3.checkNotNullParameter(directoryEntryData, "directoryEntryData");
            this.directoryEntryData = directoryEntryData;
        }

        public static /* synthetic */ DirectoryItem copy$default(DirectoryItem directoryItem, DirectoryEntryData directoryEntryData, int i, Object obj) {
            if ((i & 1) != 0) {
                directoryEntryData = directoryItem.directoryEntryData;
            }
            return directoryItem.copy(directoryEntryData);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DirectoryEntryData getDirectoryEntryData() {
            return this.directoryEntryData;
        }

        public final DirectoryItem copy(DirectoryEntryData directoryEntryData) {
            Intrinsics3.checkNotNullParameter(directoryEntryData, "directoryEntryData");
            return new DirectoryItem(directoryEntryData);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof DirectoryItem) && Intrinsics3.areEqual(this.directoryEntryData, ((DirectoryItem) other).directoryEntryData);
            }
            return true;
        }

        public final DirectoryEntryData getDirectoryEntryData() {
            return this.directoryEntryData;
        }

        public int hashCode() {
            DirectoryEntryData directoryEntryData = this.directoryEntryData;
            if (directoryEntryData != null) {
                return directoryEntryData.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("DirectoryItem(directoryEntryData=");
            sbU.append(this.directoryEntryData);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: WidgetDirectoryEntryViewHolder.kt */
    public static final /* data */ class SectionHeader extends DirectoryChannelItem {
        private final int textRes;

        public SectionHeader(@StringRes int i) {
            super(ViewType.SectionHeader, null);
            this.textRes = i;
        }

        public static /* synthetic */ SectionHeader copy$default(SectionHeader sectionHeader, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = sectionHeader.textRes;
            }
            return sectionHeader.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getTextRes() {
            return this.textRes;
        }

        public final SectionHeader copy(@StringRes int textRes) {
            return new SectionHeader(textRes);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof SectionHeader) && this.textRes == ((SectionHeader) other).textRes;
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
            return outline.B(outline.U("SectionHeader(textRes="), this.textRes, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetDirectoryEntryViewHolder.kt */
    public enum ViewType {
        Item,
        AddServer,
        SectionHeader;


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: compiled from: WidgetDirectoryEntryViewHolder.kt */
        public static final class Companion {
            private Companion() {
            }

            public final ViewType findType(int type) {
                return ViewType.values()[type];
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    private DirectoryChannelItem(ViewType viewType) {
        this.viewType = viewType;
    }

    public final ViewType getViewType() {
        return this.viewType;
    }

    public /* synthetic */ DirectoryChannelItem(ViewType viewType, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewType);
    }
}

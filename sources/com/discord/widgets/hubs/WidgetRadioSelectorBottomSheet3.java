package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.discord.widgets.hubs.RadioSelectorItems, reason: use source file name */
/* JADX INFO: compiled from: WidgetRadioSelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetRadioSelectorBottomSheet3 implements Parcelable {
    public static final Parcelable.Creator<WidgetRadioSelectorBottomSheet3> CREATOR = new Creator();
    private final List<WidgetRadioSelectorBottomSheet2> items;
    private final String title;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.RadioSelectorItems$Creator */
    public static class Creator implements Parcelable.Creator<WidgetRadioSelectorBottomSheet3> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetRadioSelectorBottomSheet3 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            String string = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            while (i != 0) {
                arrayList.add(WidgetRadioSelectorBottomSheet2.CREATOR.createFromParcel(parcel));
                i--;
            }
            return new WidgetRadioSelectorBottomSheet3(string, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetRadioSelectorBottomSheet3[] newArray(int i) {
            return new WidgetRadioSelectorBottomSheet3[i];
        }
    }

    public WidgetRadioSelectorBottomSheet3(String str, List<WidgetRadioSelectorBottomSheet2> list) {
        Intrinsics3.checkNotNullParameter(str, "title");
        Intrinsics3.checkNotNullParameter(list, "items");
        this.title = str;
        this.items = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetRadioSelectorBottomSheet3 copy$default(WidgetRadioSelectorBottomSheet3 widgetRadioSelectorBottomSheet3, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetRadioSelectorBottomSheet3.title;
        }
        if ((i & 2) != 0) {
            list = widgetRadioSelectorBottomSheet3.items;
        }
        return widgetRadioSelectorBottomSheet3.copy(str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final List<WidgetRadioSelectorBottomSheet2> component2() {
        return this.items;
    }

    public final WidgetRadioSelectorBottomSheet3 copy(String title, List<WidgetRadioSelectorBottomSheet2> items) {
        Intrinsics3.checkNotNullParameter(title, "title");
        Intrinsics3.checkNotNullParameter(items, "items");
        return new WidgetRadioSelectorBottomSheet3(title, items);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetRadioSelectorBottomSheet3)) {
            return false;
        }
        WidgetRadioSelectorBottomSheet3 widgetRadioSelectorBottomSheet3 = (WidgetRadioSelectorBottomSheet3) other;
        return Intrinsics3.areEqual(this.title, widgetRadioSelectorBottomSheet3.title) && Intrinsics3.areEqual(this.items, widgetRadioSelectorBottomSheet3.items);
    }

    public final List<WidgetRadioSelectorBottomSheet2> getItems() {
        return this.items;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<WidgetRadioSelectorBottomSheet2> list = this.items;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("RadioSelectorItems(title=");
        sbU.append(this.title);
        sbU.append(", items=");
        return outline.L(sbU, this.items, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        List<WidgetRadioSelectorBottomSheet2> list = this.items;
        parcel.writeInt(list.size());
        Iterator<WidgetRadioSelectorBottomSheet2> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, 0);
        }
    }
}

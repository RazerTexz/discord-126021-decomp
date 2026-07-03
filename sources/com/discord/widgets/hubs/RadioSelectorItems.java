package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetRadioSelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class RadioSelectorItems implements Parcelable {
    public static final Parcelable.Creator<RadioSelectorItems> CREATOR = new Creator();
    private final List<RadioSelectorItem> items;
    private final String title;

    public static class Creator implements Parcelable.Creator<RadioSelectorItems> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RadioSelectorItems createFromParcel(Parcel parcel) {
            C12238m.checkNotNullParameter(parcel, "in");
            String string = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            while (i != 0) {
                arrayList.add(RadioSelectorItem.CREATOR.createFromParcel(parcel));
                i--;
            }
            return new RadioSelectorItems(string, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RadioSelectorItems[] newArray(int i) {
            return new RadioSelectorItems[i];
        }
    }

    public RadioSelectorItems(String str, List<RadioSelectorItem> list) {
        C12238m.checkNotNullParameter(str, "title");
        C12238m.checkNotNullParameter(list, "items");
        this.title = str;
        this.items = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RadioSelectorItems copy$default(RadioSelectorItems radioSelectorItems, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = radioSelectorItems.title;
        }
        if ((i & 2) != 0) {
            list = radioSelectorItems.items;
        }
        return radioSelectorItems.copy(str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final List<RadioSelectorItem> component2() {
        return this.items;
    }

    public final RadioSelectorItems copy(String title, List<RadioSelectorItem> items) {
        C12238m.checkNotNullParameter(title, "title");
        C12238m.checkNotNullParameter(items, "items");
        return new RadioSelectorItems(title, items);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RadioSelectorItems)) {
            return false;
        }
        RadioSelectorItems radioSelectorItems = (RadioSelectorItems) other;
        return C12238m.areEqual(this.title, radioSelectorItems.title) && C12238m.areEqual(this.items, radioSelectorItems.items);
    }

    public final List<RadioSelectorItem> getItems() {
        return this.items;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<RadioSelectorItem> list = this.items;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("RadioSelectorItems(title=");
        sbM833U.append(this.title);
        sbM833U.append(", items=");
        return C1643a.m824L(sbM833U, this.items, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        C12238m.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        List<RadioSelectorItem> list = this.items;
        parcel.writeInt(list.size());
        Iterator<RadioSelectorItem> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, 0);
        }
    }
}

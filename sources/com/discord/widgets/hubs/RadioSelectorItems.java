package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import b.d.b.a.a;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: WidgetRadioSelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class RadioSelectorItems implements Parcelable {
    public static final Parcelable$Creator<RadioSelectorItems> CREATOR = new RadioSelectorItems$Creator();
    private final List<RadioSelectorItem> items;
    private final String title;

    public RadioSelectorItems(String str, List<RadioSelectorItem> list) {
        m.checkNotNullParameter(str, "title");
        m.checkNotNullParameter(list, "items");
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
        m.checkNotNullParameter(title, "title");
        m.checkNotNullParameter(items, "items");
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
        return m.areEqual(this.title, radioSelectorItems.title) && m.areEqual(this.items, radioSelectorItems.items);
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
        StringBuilder sbU = a.U("RadioSelectorItems(title=");
        sbU.append(this.title);
        sbU.append(", items=");
        return a.L(sbU, this.items, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        List<RadioSelectorItem> list = this.items;
        parcel.writeInt(list.size());
        Iterator<RadioSelectorItem> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, 0);
        }
    }
}

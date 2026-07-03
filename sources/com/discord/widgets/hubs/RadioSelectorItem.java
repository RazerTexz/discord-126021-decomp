package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetRadioSelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class RadioSelectorItem implements Parcelable {
    public static final Parcelable.Creator<RadioSelectorItem> CREATOR = new Creator();
    private final int id;
    private final boolean selected;
    private final String text;

    public static class Creator implements Parcelable.Creator<RadioSelectorItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RadioSelectorItem createFromParcel(Parcel parcel) {
            C12238m.checkNotNullParameter(parcel, "in");
            return new RadioSelectorItem(parcel.readInt(), parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RadioSelectorItem[] newArray(int i) {
            return new RadioSelectorItem[i];
        }
    }

    public RadioSelectorItem(int i, String str, boolean z2) {
        C12238m.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        this.id = i;
        this.text = str;
        this.selected = z2;
    }

    public static /* synthetic */ RadioSelectorItem copy$default(RadioSelectorItem radioSelectorItem, int i, String str, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = radioSelectorItem.id;
        }
        if ((i2 & 2) != 0) {
            str = radioSelectorItem.text;
        }
        if ((i2 & 4) != 0) {
            z2 = radioSelectorItem.selected;
        }
        return radioSelectorItem.copy(i, str, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    public final RadioSelectorItem copy(int id2, String text, boolean selected) {
        C12238m.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        return new RadioSelectorItem(id2, text, selected);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RadioSelectorItem)) {
            return false;
        }
        RadioSelectorItem radioSelectorItem = (RadioSelectorItem) other;
        return this.id == radioSelectorItem.id && C12238m.areEqual(this.text, radioSelectorItem.text) && this.selected == radioSelectorItem.selected;
    }

    public final int getId() {
        return this.id;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final String getText() {
        return this.text;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int i = this.id * 31;
        String str = this.text;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.selected;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("RadioSelectorItem(id=");
        sbM833U.append(this.id);
        sbM833U.append(", text=");
        sbM833U.append(this.text);
        sbM833U.append(", selected=");
        return C1643a.m827O(sbM833U, this.selected, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        C12238m.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.id);
        parcel.writeString(this.text);
        parcel.writeInt(this.selected ? 1 : 0);
    }
}

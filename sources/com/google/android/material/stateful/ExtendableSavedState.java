package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.customview.view.AbsSavedState;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes3.dex */
public class ExtendableSavedState extends AbsSavedState {
    public static final Parcelable.Creator<ExtendableSavedState> CREATOR = new C11004a();

    @NonNull
    public final SimpleArrayMap<String, Bundle> extendableStates;

    /* JADX INFO: renamed from: com.google.android.material.stateful.ExtendableSavedState$a */
    public static class C11004a implements Parcelable.ClassLoaderCreator<ExtendableSavedState> {
        @Override // android.os.Parcelable.ClassLoaderCreator
        @NonNull
        public ExtendableSavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
            return new ExtendableSavedState(parcel, classLoader, null);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public Object[] newArray(int i) {
            return new ExtendableSavedState[i];
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Parcelable.Creator
        @Nullable
        public Object createFromParcel(@NonNull Parcel parcel) {
            return new ExtendableSavedState(parcel, null, 0 == true ? 1 : 0);
        }
    }

    public /* synthetic */ ExtendableSavedState(Parcel parcel, ClassLoader classLoader, C11004a c11004a) {
        this(parcel, classLoader);
    }

    @NonNull
    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ExtendableSavedState{");
        sbM833U.append(Integer.toHexString(System.identityHashCode(this)));
        sbM833U.append(" states=");
        sbM833U.append(this.extendableStates);
        sbM833U.append("}");
        return sbM833U.toString();
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        int size = this.extendableStates.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = this.extendableStates.keyAt(i2);
            bundleArr[i2] = this.extendableStates.valueAt(i2);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public ExtendableSavedState(Parcelable parcelable) {
        super(parcelable);
        this.extendableStates = new SimpleArrayMap<>();
    }

    private ExtendableSavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int i = parcel.readInt();
        String[] strArr = new String[i];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[i];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.extendableStates = new SimpleArrayMap<>(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.extendableStates.put(strArr[i2], bundleArr[i2]);
        }
    }
}

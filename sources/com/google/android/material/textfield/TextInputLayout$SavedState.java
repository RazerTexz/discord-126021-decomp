package com.google.android.material.textfield;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.customview.view.AbsSavedState;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes3.dex */
public class TextInputLayout$SavedState extends AbsSavedState {
    public static final Parcelable$Creator<TextInputLayout$SavedState> CREATOR = new TextInputLayout$SavedState$a();

    @Nullable
    public CharSequence j;
    public boolean k;

    @Nullable
    public CharSequence l;

    @Nullable
    public CharSequence m;

    @Nullable
    public CharSequence n;

    public TextInputLayout$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    @NonNull
    public String toString() {
        StringBuilder sbU = a.U("TextInputLayout.SavedState{");
        sbU.append(Integer.toHexString(System.identityHashCode(this)));
        sbU.append(" error=");
        sbU.append((Object) this.j);
        sbU.append(" hint=");
        sbU.append((Object) this.l);
        sbU.append(" helperText=");
        sbU.append((Object) this.m);
        sbU.append(" placeholderText=");
        sbU.append((Object) this.n);
        sbU.append("}");
        return sbU.toString();
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        TextUtils.writeToParcel(this.j, parcel, i);
        parcel.writeInt(this.k ? 1 : 0);
        TextUtils.writeToParcel(this.l, parcel, i);
        TextUtils.writeToParcel(this.m, parcel, i);
        TextUtils.writeToParcel(this.n, parcel, i);
    }

    public TextInputLayout$SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.k = parcel.readInt() == 1;
        this.l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.m = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.n = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }
}

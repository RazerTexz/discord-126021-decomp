package com.discord.widgets.voice.feedback.call;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CallFeedbackSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallFeedbackSheetViewModel$Config$CREATOR implements Parcelable$Creator<CallFeedbackSheetViewModel$Config> {
    private CallFeedbackSheetViewModel$Config$CREATOR() {
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ CallFeedbackSheetViewModel$Config createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ CallFeedbackSheetViewModel$Config[] newArray(int i) {
        return newArray(i);
    }

    public /* synthetic */ CallFeedbackSheetViewModel$Config$CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public CallFeedbackSheetViewModel$Config createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "parcel");
        return new CallFeedbackSheetViewModel$Config(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public CallFeedbackSheetViewModel$Config[] newArray(int size) {
        return new CallFeedbackSheetViewModel$Config[size];
    }
}

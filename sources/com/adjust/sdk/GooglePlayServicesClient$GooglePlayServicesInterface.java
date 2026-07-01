package com.adjust.sdk;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class GooglePlayServicesClient$GooglePlayServicesInterface implements IInterface {
    private IBinder binder;

    public GooglePlayServicesClient$GooglePlayServicesInterface(IBinder iBinder) {
        this.binder = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.binder;
    }

    public String getGpsAdid() throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            this.binder.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    public Boolean getTrackingEnabled(boolean z2) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            parcelObtain.writeInt(z2 ? 1 : 0);
            this.binder.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            Boolean boolValueOf = Boolean.valueOf(parcelObtain2.readInt() != 0);
            parcelObtain2.recycle();
            parcelObtain.recycle();
            if (boolValueOf != null) {
                return Boolean.valueOf(!boolValueOf.booleanValue());
            }
            return null;
        } catch (Throwable th) {
            parcelObtain2.recycle();
            parcelObtain.recycle();
            throw th;
        }
    }
}

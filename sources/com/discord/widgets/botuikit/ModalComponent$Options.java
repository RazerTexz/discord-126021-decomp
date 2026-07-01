package com.discord.widgets.botuikit;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import b.d.b.a.a;
import com.discord.api.interaction.InteractionModalCreate;
import d0.z.d.m;

/* JADX INFO: compiled from: ModalComponent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ModalComponent$Options implements Parcelable {
    public static final Parcelable$Creator<ModalComponent$Options> CREATOR = new ModalComponent$Options$Creator();
    private final InteractionModalCreate modal;

    public ModalComponent$Options(InteractionModalCreate interactionModalCreate) {
        m.checkNotNullParameter(interactionModalCreate, "modal");
        this.modal = interactionModalCreate;
    }

    public static /* synthetic */ ModalComponent$Options copy$default(ModalComponent$Options modalComponent$Options, InteractionModalCreate interactionModalCreate, int i, Object obj) {
        if ((i & 1) != 0) {
            interactionModalCreate = modalComponent$Options.modal;
        }
        return modalComponent$Options.copy(interactionModalCreate);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final InteractionModalCreate getModal() {
        return this.modal;
    }

    public final ModalComponent$Options copy(InteractionModalCreate modal) {
        m.checkNotNullParameter(modal, "modal");
        return new ModalComponent$Options(modal);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ModalComponent$Options) && m.areEqual(this.modal, ((ModalComponent$Options) other).modal);
        }
        return true;
    }

    public final InteractionModalCreate getModal() {
        return this.modal;
    }

    public int hashCode() {
        InteractionModalCreate interactionModalCreate = this.modal;
        if (interactionModalCreate != null) {
            return interactionModalCreate.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Options(modal=");
        sbU.append(this.modal);
        sbU.append(")");
        return sbU.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeSerializable(this.modal);
    }
}

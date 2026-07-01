package com.discord.widgets.guilds.create;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetCreationIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class CreationIntentArgs implements Parcelable {
    public static final Parcelable$Creator<CreationIntentArgs> CREATOR = new CreationIntentArgs$Creator();
    private final WidgetGuildCreate$Options createGuildOptions;
    private final CreateGuildTrigger trigger;

    public CreationIntentArgs(CreateGuildTrigger createGuildTrigger, WidgetGuildCreate$Options widgetGuildCreate$Options) {
        m.checkNotNullParameter(createGuildTrigger, "trigger");
        m.checkNotNullParameter(widgetGuildCreate$Options, "createGuildOptions");
        this.trigger = createGuildTrigger;
        this.createGuildOptions = widgetGuildCreate$Options;
    }

    public static /* synthetic */ CreationIntentArgs copy$default(CreationIntentArgs creationIntentArgs, CreateGuildTrigger createGuildTrigger, WidgetGuildCreate$Options widgetGuildCreate$Options, int i, Object obj) {
        if ((i & 1) != 0) {
            createGuildTrigger = creationIntentArgs.trigger;
        }
        if ((i & 2) != 0) {
            widgetGuildCreate$Options = creationIntentArgs.createGuildOptions;
        }
        return creationIntentArgs.copy(createGuildTrigger, widgetGuildCreate$Options);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CreateGuildTrigger getTrigger() {
        return this.trigger;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final WidgetGuildCreate$Options getCreateGuildOptions() {
        return this.createGuildOptions;
    }

    public final CreationIntentArgs copy(CreateGuildTrigger trigger, WidgetGuildCreate$Options createGuildOptions) {
        m.checkNotNullParameter(trigger, "trigger");
        m.checkNotNullParameter(createGuildOptions, "createGuildOptions");
        return new CreationIntentArgs(trigger, createGuildOptions);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreationIntentArgs)) {
            return false;
        }
        CreationIntentArgs creationIntentArgs = (CreationIntentArgs) other;
        return m.areEqual(this.trigger, creationIntentArgs.trigger) && m.areEqual(this.createGuildOptions, creationIntentArgs.createGuildOptions);
    }

    public final WidgetGuildCreate$Options getCreateGuildOptions() {
        return this.createGuildOptions;
    }

    public final CreateGuildTrigger getTrigger() {
        return this.trigger;
    }

    public int hashCode() {
        CreateGuildTrigger createGuildTrigger = this.trigger;
        int iHashCode = (createGuildTrigger != null ? createGuildTrigger.hashCode() : 0) * 31;
        WidgetGuildCreate$Options widgetGuildCreate$Options = this.createGuildOptions;
        return iHashCode + (widgetGuildCreate$Options != null ? widgetGuildCreate$Options.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("CreationIntentArgs(trigger=");
        sbU.append(this.trigger);
        sbU.append(", createGuildOptions=");
        sbU.append(this.createGuildOptions);
        sbU.append(")");
        return sbU.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.trigger.name());
        this.createGuildOptions.writeToParcel(parcel, 0);
    }
}

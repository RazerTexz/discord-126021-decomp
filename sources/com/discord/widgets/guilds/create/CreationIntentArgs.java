package com.discord.widgets.guilds.create;

import android.os.Parcel;
import android.os.Parcelable;
import com.discord.widgets.guilds.create.WidgetGuildCreate;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetCreationIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class CreationIntentArgs implements Parcelable {
    public static final Parcelable.Creator<CreationIntentArgs> CREATOR = new Creator();
    private final WidgetGuildCreate.Options createGuildOptions;
    private final CreateGuildTrigger trigger;

    public static class Creator implements Parcelable.Creator<CreationIntentArgs> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CreationIntentArgs createFromParcel(Parcel parcel) {
            C12238m.checkNotNullParameter(parcel, "in");
            return new CreationIntentArgs((CreateGuildTrigger) Enum.valueOf(CreateGuildTrigger.class, parcel.readString()), WidgetGuildCreate.Options.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CreationIntentArgs[] newArray(int i) {
            return new CreationIntentArgs[i];
        }
    }

    public CreationIntentArgs(CreateGuildTrigger createGuildTrigger, WidgetGuildCreate.Options options) {
        C12238m.checkNotNullParameter(createGuildTrigger, "trigger");
        C12238m.checkNotNullParameter(options, "createGuildOptions");
        this.trigger = createGuildTrigger;
        this.createGuildOptions = options;
    }

    public static /* synthetic */ CreationIntentArgs copy$default(CreationIntentArgs creationIntentArgs, CreateGuildTrigger createGuildTrigger, WidgetGuildCreate.Options options, int i, Object obj) {
        if ((i & 1) != 0) {
            createGuildTrigger = creationIntentArgs.trigger;
        }
        if ((i & 2) != 0) {
            options = creationIntentArgs.createGuildOptions;
        }
        return creationIntentArgs.copy(createGuildTrigger, options);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CreateGuildTrigger getTrigger() {
        return this.trigger;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final WidgetGuildCreate.Options getCreateGuildOptions() {
        return this.createGuildOptions;
    }

    public final CreationIntentArgs copy(CreateGuildTrigger trigger, WidgetGuildCreate.Options createGuildOptions) {
        C12238m.checkNotNullParameter(trigger, "trigger");
        C12238m.checkNotNullParameter(createGuildOptions, "createGuildOptions");
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
        return C12238m.areEqual(this.trigger, creationIntentArgs.trigger) && C12238m.areEqual(this.createGuildOptions, creationIntentArgs.createGuildOptions);
    }

    public final WidgetGuildCreate.Options getCreateGuildOptions() {
        return this.createGuildOptions;
    }

    public final CreateGuildTrigger getTrigger() {
        return this.trigger;
    }

    public int hashCode() {
        CreateGuildTrigger createGuildTrigger = this.trigger;
        int iHashCode = (createGuildTrigger != null ? createGuildTrigger.hashCode() : 0) * 31;
        WidgetGuildCreate.Options options = this.createGuildOptions;
        return iHashCode + (options != null ? options.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("CreationIntentArgs(trigger=");
        sbM833U.append(this.trigger);
        sbM833U.append(", createGuildOptions=");
        sbM833U.append(this.createGuildOptions);
        sbM833U.append(")");
        return sbM833U.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        C12238m.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.trigger.name());
        this.createGuildOptions.writeToParcel(parcel, 0);
    }
}

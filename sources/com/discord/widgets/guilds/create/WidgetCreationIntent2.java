package com.discord.widgets.guilds.create;

import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import com.discord.widgets.guilds.create.WidgetGuildCreate;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.guilds.create.CreationIntentArgs, reason: use source file name */
/* JADX INFO: compiled from: WidgetCreationIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetCreationIntent2 implements Parcelable {
    public static final Parcelable.Creator<WidgetCreationIntent2> CREATOR = new Creator();
    private final WidgetGuildCreate.Options createGuildOptions;
    private final CreateGuildTrigger trigger;

    /* JADX INFO: renamed from: com.discord.widgets.guilds.create.CreationIntentArgs$Creator */
    public static class Creator implements Parcelable.Creator<WidgetCreationIntent2> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetCreationIntent2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetCreationIntent2((CreateGuildTrigger) Enum.valueOf(CreateGuildTrigger.class, parcel.readString()), WidgetGuildCreate.Options.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetCreationIntent2[] newArray(int i) {
            return new WidgetCreationIntent2[i];
        }
    }

    public WidgetCreationIntent2(CreateGuildTrigger createGuildTrigger, WidgetGuildCreate.Options options) {
        Intrinsics3.checkNotNullParameter(createGuildTrigger, "trigger");
        Intrinsics3.checkNotNullParameter(options, "createGuildOptions");
        this.trigger = createGuildTrigger;
        this.createGuildOptions = options;
    }

    public static /* synthetic */ WidgetCreationIntent2 copy$default(WidgetCreationIntent2 widgetCreationIntent2, CreateGuildTrigger createGuildTrigger, WidgetGuildCreate.Options options, int i, Object obj) {
        if ((i & 1) != 0) {
            createGuildTrigger = widgetCreationIntent2.trigger;
        }
        if ((i & 2) != 0) {
            options = widgetCreationIntent2.createGuildOptions;
        }
        return widgetCreationIntent2.copy(createGuildTrigger, options);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CreateGuildTrigger getTrigger() {
        return this.trigger;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final WidgetGuildCreate.Options getCreateGuildOptions() {
        return this.createGuildOptions;
    }

    public final WidgetCreationIntent2 copy(CreateGuildTrigger trigger, WidgetGuildCreate.Options createGuildOptions) {
        Intrinsics3.checkNotNullParameter(trigger, "trigger");
        Intrinsics3.checkNotNullParameter(createGuildOptions, "createGuildOptions");
        return new WidgetCreationIntent2(trigger, createGuildOptions);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetCreationIntent2)) {
            return false;
        }
        WidgetCreationIntent2 widgetCreationIntent2 = (WidgetCreationIntent2) other;
        return Intrinsics3.areEqual(this.trigger, widgetCreationIntent2.trigger) && Intrinsics3.areEqual(this.createGuildOptions, widgetCreationIntent2.createGuildOptions);
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
        StringBuilder sbU = outline.U("CreationIntentArgs(trigger=");
        sbU.append(this.trigger);
        sbU.append(", createGuildOptions=");
        sbU.append(this.createGuildOptions);
        sbU.append(")");
        return sbU.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.trigger.name());
        this.createGuildOptions.writeToParcel(parcel, 0);
    }
}

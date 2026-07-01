package com.discord.stores;

import b.d.b.a.a;
import com.discord.api.commands.ApplicationCommandData;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreApplicationInteractions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreApplicationInteractions$State$Loaded extends StoreApplicationInteractions$State {
    private final ApplicationCommandData commandOptions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationInteractions$State$Loaded(ApplicationCommandData applicationCommandData) {
        super(null);
        m.checkNotNullParameter(applicationCommandData, "commandOptions");
        this.commandOptions = applicationCommandData;
    }

    public static /* synthetic */ StoreApplicationInteractions$State$Loaded copy$default(StoreApplicationInteractions$State$Loaded storeApplicationInteractions$State$Loaded, ApplicationCommandData applicationCommandData, int i, Object obj) {
        if ((i & 1) != 0) {
            applicationCommandData = storeApplicationInteractions$State$Loaded.commandOptions;
        }
        return storeApplicationInteractions$State$Loaded.copy(applicationCommandData);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ApplicationCommandData getCommandOptions() {
        return this.commandOptions;
    }

    public final StoreApplicationInteractions$State$Loaded copy(ApplicationCommandData commandOptions) {
        m.checkNotNullParameter(commandOptions, "commandOptions");
        return new StoreApplicationInteractions$State$Loaded(commandOptions);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreApplicationInteractions$State$Loaded) && m.areEqual(this.commandOptions, ((StoreApplicationInteractions$State$Loaded) other).commandOptions);
        }
        return true;
    }

    public final ApplicationCommandData getCommandOptions() {
        return this.commandOptions;
    }

    public int hashCode() {
        ApplicationCommandData applicationCommandData = this.commandOptions;
        if (applicationCommandData != null) {
            return applicationCommandData.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(commandOptions=");
        sbU.append(this.commandOptions);
        sbU.append(")");
        return sbU.toString();
    }
}

package com.discord.widgets.chat.input.models;

import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ApplicationCommandData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ApplicationCommandData {
    private final Application application;
    private final ApplicationCommand applicationCommand;
    private final boolean validInputs;
    private final List<ApplicationCommandValue> values;

    public ApplicationCommandData(Application application, ApplicationCommand applicationCommand, List<ApplicationCommandValue> list, boolean z2) {
        C12238m.checkNotNullParameter(application, "application");
        C12238m.checkNotNullParameter(applicationCommand, "applicationCommand");
        C12238m.checkNotNullParameter(list, "values");
        this.application = application;
        this.applicationCommand = applicationCommand;
        this.values = list;
        this.validInputs = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApplicationCommandData copy$default(ApplicationCommandData applicationCommandData, Application application, ApplicationCommand applicationCommand, List list, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            application = applicationCommandData.application;
        }
        if ((i & 2) != 0) {
            applicationCommand = applicationCommandData.applicationCommand;
        }
        if ((i & 4) != 0) {
            list = applicationCommandData.values;
        }
        if ((i & 8) != 0) {
            z2 = applicationCommandData.validInputs;
        }
        return applicationCommandData.copy(application, applicationCommand, list, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ApplicationCommand getApplicationCommand() {
        return this.applicationCommand;
    }

    public final List<ApplicationCommandValue> component3() {
        return this.values;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getValidInputs() {
        return this.validInputs;
    }

    public final ApplicationCommandData copy(Application application, ApplicationCommand applicationCommand, List<ApplicationCommandValue> values, boolean validInputs) {
        C12238m.checkNotNullParameter(application, "application");
        C12238m.checkNotNullParameter(applicationCommand, "applicationCommand");
        C12238m.checkNotNullParameter(values, "values");
        return new ApplicationCommandData(application, applicationCommand, values, validInputs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommandData)) {
            return false;
        }
        ApplicationCommandData applicationCommandData = (ApplicationCommandData) other;
        return C12238m.areEqual(this.application, applicationCommandData.application) && C12238m.areEqual(this.applicationCommand, applicationCommandData.applicationCommand) && C12238m.areEqual(this.values, applicationCommandData.values) && this.validInputs == applicationCommandData.validInputs;
    }

    public final Application getApplication() {
        return this.application;
    }

    public final ApplicationCommand getApplicationCommand() {
        return this.applicationCommand;
    }

    public final boolean getValidInputs() {
        return this.validInputs;
    }

    public final List<ApplicationCommandValue> getValues() {
        return this.values;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        Application application = this.application;
        int iHashCode = (application != null ? application.hashCode() : 0) * 31;
        ApplicationCommand applicationCommand = this.applicationCommand;
        int iHashCode2 = (iHashCode + (applicationCommand != null ? applicationCommand.hashCode() : 0)) * 31;
        List<ApplicationCommandValue> list = this.values;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.validInputs;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode3 + r1;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ApplicationCommandData(application=");
        sbM833U.append(this.application);
        sbM833U.append(", applicationCommand=");
        sbM833U.append(this.applicationCommand);
        sbM833U.append(", values=");
        sbM833U.append(this.values);
        sbM833U.append(", validInputs=");
        return C1643a.m827O(sbM833U, this.validInputs, ")");
    }

    public /* synthetic */ ApplicationCommandData(Application application, ApplicationCommand applicationCommand, List list, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, applicationCommand, list, (i & 8) != 0 ? false : z2);
    }
}

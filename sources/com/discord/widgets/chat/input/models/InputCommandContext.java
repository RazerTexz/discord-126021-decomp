package com.discord.widgets.chat.input.models;

import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: InputCommandContext.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class InputCommandContext {
    private final boolean isCommand;
    private final Application selectedApplication;
    private final ApplicationCommand selectedCommand;

    /* JADX WARN: Multi-variable type inference failed */
    public InputCommandContext() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public InputCommandContext(Application application, ApplicationCommand applicationCommand) {
        this.selectedApplication = application;
        this.selectedCommand = applicationCommand;
        this.isCommand = applicationCommand != null;
    }

    public static /* synthetic */ InputCommandContext copy$default(InputCommandContext inputCommandContext, Application application, ApplicationCommand applicationCommand, int i, Object obj) {
        if ((i & 1) != 0) {
            application = inputCommandContext.selectedApplication;
        }
        if ((i & 2) != 0) {
            applicationCommand = inputCommandContext.selectedCommand;
        }
        return inputCommandContext.copy(application, applicationCommand);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Application getSelectedApplication() {
        return this.selectedApplication;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ApplicationCommand getSelectedCommand() {
        return this.selectedCommand;
    }

    public final InputCommandContext copy(Application selectedApplication, ApplicationCommand selectedCommand) {
        return new InputCommandContext(selectedApplication, selectedCommand);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InputCommandContext)) {
            return false;
        }
        InputCommandContext inputCommandContext = (InputCommandContext) other;
        return C12238m.areEqual(this.selectedApplication, inputCommandContext.selectedApplication) && C12238m.areEqual(this.selectedCommand, inputCommandContext.selectedCommand);
    }

    public final Application getSelectedApplication() {
        return this.selectedApplication;
    }

    public final ApplicationCommand getSelectedCommand() {
        return this.selectedCommand;
    }

    public int hashCode() {
        Application application = this.selectedApplication;
        int iHashCode = (application != null ? application.hashCode() : 0) * 31;
        ApplicationCommand applicationCommand = this.selectedCommand;
        return iHashCode + (applicationCommand != null ? applicationCommand.hashCode() : 0);
    }

    /* JADX INFO: renamed from: isCommand, reason: from getter */
    public final boolean getIsCommand() {
        return this.isCommand;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("InputCommandContext(selectedApplication=");
        sbM833U.append(this.selectedApplication);
        sbM833U.append(", selectedCommand=");
        sbM833U.append(this.selectedCommand);
        sbM833U.append(")");
        return sbM833U.toString();
    }

    public /* synthetic */ InputCommandContext(Application application, ApplicationCommand applicationCommand, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : application, (i & 2) != 0 ? null : applicationCommand);
    }
}

package com.discord.widgets.chat.input.autocomplete;

import com.discord.models.commands.Application;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Autocompletable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ApplicationPlaceholder extends Autocompletable {
    private final Application application;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationPlaceholder(Application application) {
        super(null);
        C12238m.checkNotNullParameter(application, "application");
        this.application = application;
    }

    public static /* synthetic */ ApplicationPlaceholder copy$default(ApplicationPlaceholder applicationPlaceholder, Application application, int i, Object obj) {
        if ((i & 1) != 0) {
            application = applicationPlaceholder.application;
        }
        return applicationPlaceholder.copy(application);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    public final ApplicationPlaceholder copy(Application application) {
        C12238m.checkNotNullParameter(application, "application");
        return new ApplicationPlaceholder(application);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ApplicationPlaceholder) && C12238m.areEqual(this.application, ((ApplicationPlaceholder) other).application);
        }
        return true;
    }

    public final Application getApplication() {
        return this.application;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public String getInputReplacement() {
        return "";
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public List<String> getInputTextMatchers() {
        return C12147n.emptyList();
    }

    public int hashCode() {
        Application application = this.application;
        if (application != null) {
            return application.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ApplicationPlaceholder(application=");
        sbM833U.append(this.application);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}

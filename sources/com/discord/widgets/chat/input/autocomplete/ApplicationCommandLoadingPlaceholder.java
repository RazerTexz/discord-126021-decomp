package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.a;
import com.discord.models.commands.Application;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Autocompletable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ApplicationCommandLoadingPlaceholder extends Autocompletable {
    private final Application application;

    public ApplicationCommandLoadingPlaceholder() {
        this(null, 1, null);
    }

    public /* synthetic */ ApplicationCommandLoadingPlaceholder(Application application, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : application);
    }

    public static /* synthetic */ ApplicationCommandLoadingPlaceholder copy$default(ApplicationCommandLoadingPlaceholder applicationCommandLoadingPlaceholder, Application application, int i, Object obj) {
        if ((i & 1) != 0) {
            application = applicationCommandLoadingPlaceholder.application;
        }
        return applicationCommandLoadingPlaceholder.copy(application);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    public final ApplicationCommandLoadingPlaceholder copy(Application application) {
        return new ApplicationCommandLoadingPlaceholder(application);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ApplicationCommandLoadingPlaceholder) && m.areEqual(this.application, ((ApplicationCommandLoadingPlaceholder) other).application);
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
        return n.emptyList();
    }

    public int hashCode() {
        Application application = this.application;
        if (application != null) {
            return application.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("ApplicationCommandLoadingPlaceholder(application=");
        sbU.append(this.application);
        sbU.append(")");
        return sbU.toString();
    }

    public ApplicationCommandLoadingPlaceholder(Application application) {
        super(null);
        this.application = application;
    }
}

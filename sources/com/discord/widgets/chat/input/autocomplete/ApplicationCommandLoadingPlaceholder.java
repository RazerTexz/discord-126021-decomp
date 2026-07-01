package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.outline;
import com.discord.models.commands.Application;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Autocompletable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ApplicationCommandLoadingPlaceholder extends Autocompletable {
    private final Application application;

    /* JADX WARN: Multi-variable type inference failed */
    public ApplicationCommandLoadingPlaceholder() {
        this(null, 1, 0 == true ? 1 : 0);
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
            return (other instanceof ApplicationCommandLoadingPlaceholder) && Intrinsics3.areEqual(this.application, ((ApplicationCommandLoadingPlaceholder) other).application);
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
        return Collections2.emptyList();
    }

    public int hashCode() {
        Application application = this.application;
        if (application != null) {
            return application.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ApplicationCommandLoadingPlaceholder(application=");
        sbU.append(this.application);
        sbU.append(")");
        return sbU.toString();
    }

    public ApplicationCommandLoadingPlaceholder(Application application) {
        super(null);
        this.application = application;
    }
}

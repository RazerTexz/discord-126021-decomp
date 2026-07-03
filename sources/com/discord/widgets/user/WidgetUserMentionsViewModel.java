package com.discord.widgets.user;

import com.discord.widgets.user.WidgetUserMentions;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;

/* JADX INFO: compiled from: WidgetUserMentionsViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentionsViewModel extends AbstractC0859d0<Unit> {
    private WidgetUserMentions.Model model;

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetUserMentionsViewModel() {
        DefaultConstructorMarker defaultConstructorMarker = null;
        super(defaultConstructorMarker, 1, defaultConstructorMarker);
    }

    /* JADX INFO: renamed from: getModel$app_productionGoogleRelease, reason: from getter */
    public final WidgetUserMentions.Model getModel() {
        return this.model;
    }

    public final void setModel$app_productionGoogleRelease(WidgetUserMentions.Model model) {
        this.model = model;
    }
}

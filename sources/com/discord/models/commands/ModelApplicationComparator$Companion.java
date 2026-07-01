package com.discord.models.commands;

import d0.z.d.m;
import java.util.Comparator;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModelApplicationComparator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelApplicationComparator$Companion implements Comparator<Application> {
    private ModelApplicationComparator$Companion() {
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Application application, Application application2) {
        return compare2(application, application2);
    }

    public /* synthetic */ ModelApplicationComparator$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(Application a, Application b2) {
        m.checkNotNullParameter(a, "a");
        m.checkNotNullParameter(b2, "b");
        int i = (a.getBuiltIn() ? 1 : 0) - (b2.getBuiltIn() ? 1 : 0);
        return i != 0 ? i : a.getName().compareTo(b2.getName());
    }
}
